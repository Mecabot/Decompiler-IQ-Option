package com.appsflyer;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import java.lang.ref.WeakReference;

@RequiresApi(api = 14)
final class ad implements ActivityLifecycleCallbacks {
    private static ad rg;
    private boolean qQ = true;
    private boolean qn = false;
    private b rh = null;

    class a extends AsyncTask<Void, Void, Void> {
        private WeakReference<Context> ri;

        public a(WeakReference<Context> weakReference) {
            this.ri = weakReference;
        }

        private Void gd() {
            try {
                Thread.sleep(500);
            } catch (Throwable e) {
                AFLogger.a("Sleeping attempt failed (essential for background state verification)\n", e);
            }
            if (ad.this.qn && ad.this.qQ) {
                ad.this.qn = false;
                try {
                    ad.this.rh.a(this.ri);
                } catch (Throwable e2) {
                    AFLogger.a("Listener threw exception! ", e2);
                    cancel(true);
                }
            }
            this.ri.clear();
            return null;
        }
    }

    interface b {
        void a(WeakReference<Context> weakReference);

        void f(Activity activity);
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public final void onActivityDestroyed(Activity activity) {
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }

    ad() {
    }

    static ad ga() {
        if (rg == null) {
            rg = new ad();
        }
        return rg;
    }

    public static ad gb() {
        if (rg != null) {
            return rg;
        }
        throw new IllegalStateException("Foreground is not initialised - invoke at least once with parameter init/get");
    }

    public final void a(Application application, b bVar) {
        this.rh = bVar;
        if (VERSION.SDK_INT >= 14) {
            application.registerActivityLifecycleCallbacks(rg);
        }
    }

    public final void onActivityResumed(Activity activity) {
        this.qQ = false;
        int i = this.qn ^ 1;
        this.qn = true;
        if (i != 0) {
            try {
                this.rh.f(activity);
            } catch (Throwable e) {
                AFLogger.a("Listener threw exception! ", e);
            }
        }
    }

    public final void onActivityPaused(Activity activity) {
        this.qQ = true;
        try {
            new a(new WeakReference(activity.getApplicationContext())).executeOnExecutor(a.fp().fq(), new Void[0]);
        } catch (Throwable e) {
            AFLogger.a("backgroundTask.executeOnExecutor failed with RejectedExecutionException Exception", e);
        } catch (Throwable e2) {
            AFLogger.a("backgroundTask.executeOnExecutor failed with Exception", e2);
        }
    }
}
