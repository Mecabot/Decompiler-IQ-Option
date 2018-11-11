package androidx.work.impl.background.systemjob;

import android.app.Application;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.text.TextUtils;
import androidx.work.e;
import androidx.work.impl.a;
import androidx.work.impl.g;
import java.util.HashMap;
import java.util.Map;

@RequiresApi(23)
@RestrictTo({Scope.LIBRARY_GROUP})
public class SystemJobService extends JobService implements a {
    private g eo;
    private final Map<String, JobParameters> fj = new HashMap();

    public void onCreate() {
        super.onCreate();
        this.eo = g.bz();
        if (this.eo != null) {
            this.eo.bD().a(this);
        } else if (Application.class.equals(getApplication().getClass())) {
            e.d("SystemJobService", "Could not find WorkManager instance; this may be because an auto-backup is in progress. Ignoring JobScheduler commands for now. Please make sure that you are initializing WorkManager if you have manually disabled WorkManagerInitializer.", new Throwable[0]);
        } else {
            throw new IllegalStateException("WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().");
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.eo != null) {
            this.eo.bD().b(this);
        }
    }

    /* JADX WARNING: Missing block: B:18:0x0062, code:
            r2 = null;
     */
    /* JADX WARNING: Missing block: B:19:0x0067, code:
            if (android.os.Build.VERSION.SDK_INT < 24) goto L_0x0092;
     */
    /* JADX WARNING: Missing block: B:20:0x0069, code:
            r2 = new androidx.work.impl.Extras.a();
     */
    /* JADX WARNING: Missing block: B:21:0x0072, code:
            if (r8.getTriggeredContentUris() != null) goto L_0x007a;
     */
    /* JADX WARNING: Missing block: B:23:0x0078, code:
            if (r8.getTriggeredContentAuthorities() == null) goto L_0x0086;
     */
    /* JADX WARNING: Missing block: B:24:0x007a, code:
            r2.eg = r8.getTriggeredContentUris();
            r2.ef = r8.getTriggeredContentAuthorities();
     */
    /* JADX WARNING: Missing block: B:26:0x008a, code:
            if (android.os.Build.VERSION.SDK_INT < 28) goto L_0x0092;
     */
    /* JADX WARNING: Missing block: B:27:0x008c, code:
            r2.eh = r8.getNetwork();
     */
    /* JADX WARNING: Missing block: B:28:0x0092, code:
            r7.eo.b(r0, r2);
     */
    /* JADX WARNING: Missing block: B:29:0x0097, code:
            return true;
     */
    public boolean onStartJob(android.app.job.JobParameters r8) {
        /*
        r7 = this;
        r0 = r7.eo;
        r1 = 1;
        r2 = 0;
        if (r0 != 0) goto L_0x0013;
    L_0x0006:
        r0 = "SystemJobService";
        r3 = "WorkManager is not initialized; requesting retry.";
        r4 = new java.lang.Throwable[r2];
        androidx.work.e.b(r0, r3, r4);
        r7.jobFinished(r8, r1);
        return r2;
    L_0x0013:
        r0 = r8.getExtras();
        r3 = "EXTRA_WORK_SPEC_ID";
        r0 = r0.getString(r3);
        r3 = android.text.TextUtils.isEmpty(r0);
        if (r3 == 0) goto L_0x002d;
    L_0x0023:
        r8 = "SystemJobService";
        r0 = "WorkSpec id not found!";
        r1 = new java.lang.Throwable[r2];
        androidx.work.e.e(r8, r0, r1);
        return r2;
    L_0x002d:
        r3 = r7.fj;
        monitor-enter(r3);
        r4 = r7.fj;	 Catch:{ all -> 0x0098 }
        r4 = r4.containsKey(r0);	 Catch:{ all -> 0x0098 }
        if (r4 == 0) goto L_0x004b;
    L_0x0038:
        r8 = "SystemJobService";
        r4 = "Job is already being executed by SystemJobService: %s";
        r1 = new java.lang.Object[r1];	 Catch:{ all -> 0x0098 }
        r1[r2] = r0;	 Catch:{ all -> 0x0098 }
        r0 = java.lang.String.format(r4, r1);	 Catch:{ all -> 0x0098 }
        r1 = new java.lang.Throwable[r2];	 Catch:{ all -> 0x0098 }
        androidx.work.e.b(r8, r0, r1);	 Catch:{ all -> 0x0098 }
        monitor-exit(r3);	 Catch:{ all -> 0x0098 }
        return r2;
    L_0x004b:
        r4 = "SystemJobService";
        r5 = "onStartJob for %s";
        r6 = new java.lang.Object[r1];	 Catch:{ all -> 0x0098 }
        r6[r2] = r0;	 Catch:{ all -> 0x0098 }
        r5 = java.lang.String.format(r5, r6);	 Catch:{ all -> 0x0098 }
        r2 = new java.lang.Throwable[r2];	 Catch:{ all -> 0x0098 }
        androidx.work.e.b(r4, r5, r2);	 Catch:{ all -> 0x0098 }
        r2 = r7.fj;	 Catch:{ all -> 0x0098 }
        r2.put(r0, r8);	 Catch:{ all -> 0x0098 }
        monitor-exit(r3);	 Catch:{ all -> 0x0098 }
        r2 = 0;
        r3 = android.os.Build.VERSION.SDK_INT;
        r4 = 24;
        if (r3 < r4) goto L_0x0092;
    L_0x0069:
        r2 = new androidx.work.impl.Extras$a;
        r2.<init>();
        r3 = r8.getTriggeredContentUris();
        if (r3 != 0) goto L_0x007a;
    L_0x0074:
        r3 = r8.getTriggeredContentAuthorities();
        if (r3 == 0) goto L_0x0086;
    L_0x007a:
        r3 = r8.getTriggeredContentUris();
        r2.eg = r3;
        r3 = r8.getTriggeredContentAuthorities();
        r2.ef = r3;
    L_0x0086:
        r3 = android.os.Build.VERSION.SDK_INT;
        r4 = 28;
        if (r3 < r4) goto L_0x0092;
    L_0x008c:
        r8 = r8.getNetwork();
        r2.eh = r8;
    L_0x0092:
        r8 = r7.eo;
        r8.b(r0, r2);
        return r1;
    L_0x0098:
        r8 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0098 }
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.background.systemjob.SystemJobService.onStartJob(android.app.job.JobParameters):boolean");
    }

    public boolean onStopJob(JobParameters jobParameters) {
        if (this.eo == null) {
            e.b("SystemJobService", "WorkManager is not initialized; requesting retry.", new Throwable[0]);
            return true;
        }
        String string = jobParameters.getExtras().getString("EXTRA_WORK_SPEC_ID");
        if (TextUtils.isEmpty(string)) {
            e.e("SystemJobService", "WorkSpec id not found!", new Throwable[0]);
            return false;
        }
        e.b("SystemJobService", String.format("onStopJob for %s", new Object[]{string}), new Throwable[0]);
        synchronized (this.fj) {
            this.fj.remove(string);
        }
        this.eo.z(string);
        return this.eo.bD().t(string) ^ true;
    }

    public void a(@NonNull String str, boolean z, boolean z2) {
        JobParameters jobParameters;
        e.b("SystemJobService", String.format("%s executed on JobScheduler", new Object[]{str}), new Throwable[0]);
        synchronized (this.fj) {
            jobParameters = (JobParameters) this.fj.get(str);
        }
        if (jobParameters != null) {
            jobFinished(jobParameters, z2);
        }
    }
}
