package com.iqoption.util;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentName;
import android.os.Bundle;
import com.iqoption.app.IQApp;
import com.iqoption.core.d.a;

/* compiled from: ConfigChangingTracker */
public final class j {
    private static boolean duU;

    public static void init() {
        IQApp.Dk().registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            private ComponentName duV;

            public void onActivityDestroyed(Activity activity) {
            }

            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            public void onActivityStopped(Activity activity) {
            }

            public void onActivityCreated(Activity activity, Bundle bundle) {
                this.duV = activity.getComponentName();
            }

            public void onActivityStarted(Activity activity) {
                if (this.duV == null) {
                    this.duV = activity.getComponentName();
                }
            }

            public void onActivityResumed(Activity activity) {
                if (j.duU) {
                    a.aSe.post(new Runnable() {
                        public void run() {
                            j.duU = false;
                        }
                    });
                }
            }

            public void onActivityPaused(Activity activity) {
                if (activity.isChangingConfigurations()) {
                    j.duU = true;
                } else {
                    this.duV = null;
                }
            }
        });
    }
}
