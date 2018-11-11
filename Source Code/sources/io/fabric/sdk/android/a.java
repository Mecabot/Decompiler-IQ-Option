package io.fabric.sdk.android;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import java.util.HashSet;
import java.util.Set;

/* compiled from: ActivityLifecycleManager */
public class a {
    private final Application elV;
    private a elW;

    /* compiled from: ActivityLifecycleManager */
    private static class a {
        private final Application elV;
        private final Set<ActivityLifecycleCallbacks> elX = new HashSet();

        a(Application application) {
            this.elV = application;
        }

        @TargetApi(14)
        private void clearCallbacks() {
            for (ActivityLifecycleCallbacks unregisterActivityLifecycleCallbacks : this.elX) {
                this.elV.unregisterActivityLifecycleCallbacks(unregisterActivityLifecycleCallbacks);
            }
        }

        @TargetApi(14)
        private boolean b(final b bVar) {
            if (this.elV == null) {
                return false;
            }
            ActivityLifecycleCallbacks anonymousClass1 = new ActivityLifecycleCallbacks() {
                public void onActivityCreated(Activity activity, Bundle bundle) {
                    bVar.onActivityCreated(activity, bundle);
                }

                public void onActivityStarted(Activity activity) {
                    bVar.onActivityStarted(activity);
                }

                public void onActivityResumed(Activity activity) {
                    bVar.onActivityResumed(activity);
                }

                public void onActivityPaused(Activity activity) {
                    bVar.onActivityPaused(activity);
                }

                public void onActivityStopped(Activity activity) {
                    bVar.onActivityStopped(activity);
                }

                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                    bVar.onActivitySaveInstanceState(activity, bundle);
                }

                public void onActivityDestroyed(Activity activity) {
                    bVar.onActivityDestroyed(activity);
                }
            };
            this.elV.registerActivityLifecycleCallbacks(anonymousClass1);
            this.elX.add(anonymousClass1);
            return true;
        }
    }

    /* compiled from: ActivityLifecycleManager */
    public static abstract class b {
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    public a(Context context) {
        this.elV = (Application) context.getApplicationContext();
        if (VERSION.SDK_INT >= 14) {
            this.elW = new a(this.elV);
        }
    }

    public boolean a(b bVar) {
        return this.elW != null && this.elW.b(bVar);
    }

    public void aUd() {
        if (this.elW != null) {
            this.elW.clearCallbacks();
        }
    }
}
