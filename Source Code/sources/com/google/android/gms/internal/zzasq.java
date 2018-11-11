package com.google.android.gms.internal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobInfo.Builder;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.PersistableBundle;
import android.support.v4.app.NotificationCompat;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbq;

@Hide
public final class zzasq extends zzari {
    private boolean zzebh;
    private boolean zzebi;
    private final AlarmManager zzebj = ((AlarmManager) getContext().getSystemService(NotificationCompat.CATEGORY_ALARM));
    private Integer zzebk;

    protected zzasq(zzark zzark) {
        super(zzark);
    }

    private final int getJobId() {
        if (this.zzebk == null) {
            String str = "analytics";
            String valueOf = String.valueOf(getContext().getPackageName());
            this.zzebk = Integer.valueOf((valueOf.length() != 0 ? str.concat(valueOf) : new String(str)).hashCode());
        }
        return this.zzebk.intValue();
    }

    private final PendingIntent zzaak() {
        Intent intent = new Intent("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
        intent.setComponent(new ComponentName(getContext(), "com.google.android.gms.analytics.AnalyticsReceiver"));
        return PendingIntent.getBroadcast(getContext(), 0, intent, 0);
    }

    public final void cancel() {
        this.zzebi = false;
        this.zzebj.cancel(zzaak());
        if (VERSION.SDK_INT >= 24) {
            JobScheduler jobScheduler = (JobScheduler) getContext().getSystemService("jobscheduler");
            zza("Cancelling job. JobID", Integer.valueOf(getJobId()));
            jobScheduler.cancel(getJobId());
        }
    }

    public final void schedule() {
        zzyk();
        zzbq.zza(this.zzebh, (Object) "Receiver not registered");
        long zzzy = zzasl.zzzy();
        if (zzzy > 0) {
            cancel();
            long elapsedRealtime = zzxx().elapsedRealtime() + zzzy;
            this.zzebi = true;
            if (VERSION.SDK_INT >= 24) {
                zzea("Scheduling upload with JobScheduler");
                JobScheduler jobScheduler = (JobScheduler) getContext().getSystemService("jobscheduler");
                Builder builder = new Builder(getJobId(), new ComponentName(getContext(), "com.google.android.gms.analytics.AnalyticsJobService"));
                builder.setMinimumLatency(zzzy);
                builder.setOverrideDeadline(zzzy << 1);
                PersistableBundle persistableBundle = new PersistableBundle();
                persistableBundle.putString("action", "com.google.android.gms.analytics.ANALYTICS_DISPATCH");
                builder.setExtras(persistableBundle);
                JobInfo build = builder.build();
                zza("Scheduling job. JobID", Integer.valueOf(getJobId()));
                jobScheduler.schedule(build);
                return;
            }
            zzea("Scheduling upload with AlarmManager");
            this.zzebj.setInexactRepeating(2, elapsedRealtime, zzzy, zzaak());
        }
    }

    public final boolean zzaaj() {
        return this.zzebh;
    }

    public final boolean zzea() {
        return this.zzebi;
    }

    protected final void zzwk() {
        try {
            cancel();
            if (zzasl.zzzy() > 0) {
                ActivityInfo receiverInfo = getContext().getPackageManager().getReceiverInfo(new ComponentName(getContext(), "com.google.android.gms.analytics.AnalyticsReceiver"), 2);
                if (receiverInfo != null && receiverInfo.enabled) {
                    zzea("Receiver registered for local dispatch.");
                    this.zzebh = true;
                }
            }
        } catch (NameNotFoundException unused) {
        }
    }
}
