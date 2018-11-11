package com.google.android.gms.analytics;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.RequiresPermission;
import android.util.Log;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzari;
import com.google.android.gms.internal.zzark;
import com.google.android.gms.internal.zzast;
import com.google.android.gms.internal.zzatc;
import com.google.android.gms.internal.zzatq;
import com.google.android.gms.internal.zzats;
import com.google.android.gms.internal.zzatu;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class GoogleAnalytics extends zza {
    private static List<Runnable> zzduj = new ArrayList();
    private boolean zzarf;
    private Set<zza> zzduk = new HashSet();
    private boolean zzdul;
    private boolean zzdum;
    private volatile boolean zzdun;
    private boolean zzduo;

    interface zza {
        void zzm(Activity activity);

        void zzn(Activity activity);
    }

    @TargetApi(14)
    class zzb implements ActivityLifecycleCallbacks {
        zzb() {
        }

        public final void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public final void onActivityDestroyed(Activity activity) {
        }

        public final void onActivityPaused(Activity activity) {
        }

        public final void onActivityResumed(Activity activity) {
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public final void onActivityStarted(Activity activity) {
            GoogleAnalytics.this.zzk(activity);
        }

        public final void onActivityStopped(Activity activity) {
            GoogleAnalytics.this.zzl(activity);
        }
    }

    @Hide
    public GoogleAnalytics(zzark zzark) {
        super(zzark);
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public static GoogleAnalytics getInstance(Context context) {
        return zzark.zzbl(context).zzyn();
    }

    @Hide
    public static void zzvw() {
        synchronized (GoogleAnalytics.class) {
            if (zzduj != null) {
                for (Runnable run : zzduj) {
                    run.run();
                }
                zzduj = null;
            }
        }
    }

    public final void dispatchLocalHits() {
        zzvr().zzyc().zzxs();
    }

    @TargetApi(14)
    public final void enableAutoActivityReports(Application application) {
        if (!this.zzdul) {
            application.registerActivityLifecycleCallbacks(new zzb());
            this.zzdul = true;
        }
    }

    public final boolean getAppOptOut() {
        return this.zzdun;
    }

    @Deprecated
    public final Logger getLogger() {
        return zzatc.getLogger();
    }

    @Hide
    public final void initialize() {
        zzatu zzye = zzvr().zzye();
        zzye.zzabm();
        if (zzye.zzabn()) {
            setDryRun(zzye.zzabo());
        }
        zzye.zzabm();
        this.zzarf = true;
    }

    public final boolean isDryRunEnabled() {
        return this.zzdum;
    }

    @Hide
    public final boolean isInitialized() {
        return this.zzarf;
    }

    public final Tracker newTracker(int i) {
        zzari tracker;
        synchronized (this) {
            tracker = new Tracker(zzvr(), null, null);
            if (i > 0) {
                zzats zzats = (zzats) new zzatq(zzvr()).zzav(i);
                if (zzats != null) {
                    tracker.zza(zzats);
                }
            }
            tracker.initialize();
        }
        return tracker;
    }

    public final Tracker newTracker(String str) {
        zzari tracker;
        synchronized (this) {
            tracker = new Tracker(zzvr(), str, null);
            tracker.initialize();
        }
        return tracker;
    }

    public final void reportActivityStart(Activity activity) {
        if (!this.zzdul) {
            zzk(activity);
        }
    }

    public final void reportActivityStop(Activity activity) {
        if (!this.zzdul) {
            zzl(activity);
        }
    }

    public final void setAppOptOut(boolean z) {
        this.zzdun = z;
        if (this.zzdun) {
            zzvr().zzyc().zzxr();
        }
    }

    public final void setDryRun(boolean z) {
        this.zzdum = z;
    }

    public final void setLocalDispatchPeriod(int i) {
        zzvr().zzyc().setLocalDispatchPeriod(i);
    }

    @Deprecated
    public final void setLogger(Logger logger) {
        zzatc.setLogger(logger);
        if (!this.zzduo) {
            String str = (String) zzast.zzebn.get();
            String str2 = (String) zzast.zzebn.get();
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(str2).length() + 112);
            stringBuilder.append("GoogleAnalytics.setLogger() is deprecated. To enable debug logging, please run:\nadb shell setprop log.tag.");
            stringBuilder.append(str2);
            stringBuilder.append(" DEBUG");
            Log.i(str, stringBuilder.toString());
            this.zzduo = true;
        }
    }

    final void zza(zza zza) {
        this.zzduk.add(zza);
        Context context = zzvr().getContext();
        if (context instanceof Application) {
            enableAutoActivityReports((Application) context);
        }
    }

    final void zzb(zza zza) {
        this.zzduk.remove(zza);
    }

    final void zzk(Activity activity) {
        for (zza zzm : this.zzduk) {
            zzm.zzm(activity);
        }
    }

    final void zzl(Activity activity) {
        for (zza zzn : this.zzduk) {
            zzn.zzn(activity);
        }
    }
}
