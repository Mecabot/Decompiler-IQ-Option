package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobInfo.Builder;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.PersistableBundle;
import android.support.v4.app.NotificationCompat;

public final class zzcnj extends zzcli {
    private Integer zzebk;
    private final AlarmManager zzjsf = ((AlarmManager) getContext().getSystemService(NotificationCompat.CATEGORY_ALARM));
    private final zzcip zzjsg;

    protected zzcnj(zzckj zzckj) {
        super(zzckj);
        this.zzjsg = new zzcnk(this, zzckj, zzckj);
    }

    private final int getJobId() {
        if (this.zzebk == null) {
            String str = "measurement";
            String valueOf = String.valueOf(getContext().getPackageName());
            this.zzebk = Integer.valueOf((valueOf.length() != 0 ? str.concat(valueOf) : new String(str)).hashCode());
        }
        return this.zzebk.intValue();
    }

    private final PendingIntent zzaak() {
        Intent className = new Intent().setClassName(getContext(), "com.google.android.gms.measurement.AppMeasurementReceiver");
        className.setAction("com.google.android.gms.measurement.UPLOAD");
        return PendingIntent.getBroadcast(getContext(), 0, className, 0);
    }

    @TargetApi(24)
    private final void zzbcp() {
        JobScheduler jobScheduler = (JobScheduler) getContext().getSystemService("jobscheduler");
        zzayp().zzbba().zzj("Cancelling job. JobID", Integer.valueOf(getJobId()));
        jobScheduler.cancel(getJobId());
    }

    public final void cancel() {
        zzyk();
        this.zzjsf.cancel(zzaak());
        this.zzjsg.cancel();
        if (VERSION.SDK_INT >= 24) {
            zzbcp();
        }
    }

    protected final boolean zzazq() {
        this.zzjsf.cancel(zzaak());
        if (VERSION.SDK_INT >= 24) {
            zzbcp();
        }
        return false;
    }

    public final void zzs(long j) {
        zzyk();
        if (!zzcka.zzbj(getContext())) {
            zzayp().zzbaz().log("Receiver not registered/enabled");
        }
        if (!zzcmy.zzg(getContext(), false)) {
            zzayp().zzbaz().log("Service not registered/enabled");
        }
        cancel();
        long elapsedRealtime = zzxx().elapsedRealtime() + j;
        if (j < Math.max(0, ((Long) zzciz.zzjjk.get()).longValue()) && !this.zzjsg.zzea()) {
            zzayp().zzbba().log("Scheduling upload with DelayedRunnable");
            this.zzjsg.zzs(j);
        }
        if (VERSION.SDK_INT >= 24) {
            zzayp().zzbba().log("Scheduling upload with JobScheduler");
            JobScheduler jobScheduler = (JobScheduler) getContext().getSystemService("jobscheduler");
            Builder builder = new Builder(getJobId(), new ComponentName(getContext(), "com.google.android.gms.measurement.AppMeasurementJobService"));
            builder.setMinimumLatency(j);
            builder.setOverrideDeadline(j << 1);
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putString("action", "com.google.android.gms.measurement.UPLOAD");
            builder.setExtras(persistableBundle);
            JobInfo build = builder.build();
            zzayp().zzbba().zzj("Scheduling job. JobID", Integer.valueOf(getJobId()));
            jobScheduler.schedule(build);
            return;
        }
        zzayp().zzbba().log("Scheduling upload with AlarmManager");
        this.zzjsf.setInexactRepeating(2, elapsedRealtime, Math.max(((Long) zzciz.zzjjf.get()).longValue(), j), zzaak());
    }
}
