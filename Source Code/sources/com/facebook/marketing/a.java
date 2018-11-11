package com.facebook.marketing;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

/* compiled from: CodelessActivityLifecycleTracker */
public class a {
    private static Boolean Av = Boolean.valueOf(false);
    private static final com.facebook.marketing.internal.a Hg = new com.facebook.marketing.internal.a();
    private static final String TAG = a.class.getCanonicalName();

    public static void c(Application application) {
        application.registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            public void onActivityCreated(Activity activity, Bundle bundle) {
            }

            public void onActivityDestroyed(Activity activity) {
            }

            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            public void onActivityStarted(Activity activity) {
            }

            public void onActivityStopped(Activity activity) {
            }

            public void onActivityResumed(Activity activity) {
                a.Hg.add(activity);
            }

            public void onActivityPaused(Activity activity) {
                a.Hg.g(activity);
            }
        });
    }
}
