package com.google.android.gms.analytics;

import android.content.Context;
import android.net.Uri;
import android.os.Process;
import android.util.DisplayMetrics;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzaql;
import com.google.android.gms.internal.zzaqq;
import com.google.android.gms.internal.zzatt;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Hide
public final class zzk {
    private static volatile zzk zzdvk;
    private final Context mContext;
    private final List<zzn> zzdvl = new CopyOnWriteArrayList();
    private final zze zzdvm = new zze();
    private final zza zzdvn = new zza();
    private volatile zzaql zzdvo;
    private UncaughtExceptionHandler zzdvp;

    class zza extends ThreadPoolExecutor {
        public zza() {
            super(1, 1, 1, TimeUnit.MINUTES, new LinkedBlockingQueue());
            setThreadFactory(new zzb());
            allowCoreThreadTimeOut(true);
        }

        protected final <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
            return new zzm(this, runnable, t);
        }
    }

    static class zzb implements ThreadFactory {
        private static final AtomicInteger zzdvt = new AtomicInteger();

        private zzb() {
        }

        /* synthetic */ zzb(zzl zzl) {
            this();
        }

        public final Thread newThread(Runnable runnable) {
            int incrementAndGet = zzdvt.incrementAndGet();
            StringBuilder stringBuilder = new StringBuilder(23);
            stringBuilder.append("measurement-");
            stringBuilder.append(incrementAndGet);
            return new zzc(runnable, stringBuilder.toString());
        }
    }

    static class zzc extends Thread {
        zzc(Runnable runnable, String str) {
            super(runnable, str);
        }

        public final void run() {
            Process.setThreadPriority(10);
            super.run();
        }
    }

    private zzk(Context context) {
        context = context.getApplicationContext();
        zzbq.checkNotNull(context);
        this.mContext = context;
    }

    private static void zzb(zzg zzg) {
        zzbq.zzgw("deliver should be called from worker thread");
        zzbq.checkArgument(zzg.zzwb(), "Measurement must be submitted");
        List<zzo> transports = zzg.getTransports();
        if (!transports.isEmpty()) {
            Set hashSet = new HashSet();
            for (zzo zzo : transports) {
                Uri zzvu = zzo.zzvu();
                if (!hashSet.contains(zzvu)) {
                    hashSet.add(zzvu);
                    zzo.zzb(zzg);
                }
            }
        }
    }

    public static zzk zzbk(Context context) {
        zzbq.checkNotNull(context);
        if (zzdvk == null) {
            synchronized (zzk.class) {
                if (zzdvk == null) {
                    zzdvk = new zzk(context);
                }
            }
        }
        return zzdvk;
    }

    @Hide
    public static void zzwj() {
        if (!(Thread.currentThread() instanceof zzc)) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    @Hide
    public final Context getContext() {
        return this.mContext;
    }

    @Hide
    public final <V> Future<V> zza(Callable<V> callable) {
        zzbq.checkNotNull(callable);
        if (!(Thread.currentThread() instanceof zzc)) {
            return this.zzdvn.submit(callable);
        }
        Future futureTask = new FutureTask(callable);
        futureTask.run();
        return futureTask;
    }

    public final void zza(UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.zzdvp = uncaughtExceptionHandler;
    }

    @Hide
    public final void zzd(Runnable runnable) {
        zzbq.checkNotNull(runnable);
        this.zzdvn.submit(runnable);
    }

    final void zze(zzg zzg) {
        if (zzg.zzwe()) {
            throw new IllegalStateException("Measurement prototype can't be submitted");
        } else if (zzg.zzwb()) {
            throw new IllegalStateException("Measurement can only be submitted once");
        } else {
            zzg = zzg.zzvx();
            zzg.zzwc();
            this.zzdvn.execute(new zzl(this, zzg));
        }
    }

    /* JADX WARNING: Missing block: B:17:?, code:
            r1 = "GAv4";
            r4 = "Error retrieving package info: appName set to ";
            r5 = java.lang.String.valueOf(r2);
     */
    /* JADX WARNING: Missing block: B:18:0x0053, code:
            if (r5.length() != 0) goto L_0x0055;
     */
    /* JADX WARNING: Missing block: B:19:0x0055, code:
            r4 = r4.concat(r5);
     */
    /* JADX WARNING: Missing block: B:20:0x005a, code:
            r4 = new java.lang.String(r4);
     */
    /* JADX WARNING: Missing block: B:21:0x0060, code:
            android.util.Log.e(r1, r4);
     */
    public final com.google.android.gms.internal.zzaql zzwh() {
        /*
        r7 = this;
        r0 = r7.zzdvo;
        if (r0 != 0) goto L_0x0070;
    L_0x0004:
        monitor-enter(r7);
        r0 = r7.zzdvo;	 Catch:{ all -> 0x006d }
        if (r0 != 0) goto L_0x006b;
    L_0x0009:
        r0 = new com.google.android.gms.internal.zzaql;	 Catch:{ all -> 0x006d }
        r0.<init>();	 Catch:{ all -> 0x006d }
        r1 = r7.mContext;	 Catch:{ all -> 0x006d }
        r1 = r1.getPackageManager();	 Catch:{ all -> 0x006d }
        r2 = r7.mContext;	 Catch:{ all -> 0x006d }
        r2 = r2.getPackageName();	 Catch:{ all -> 0x006d }
        r0.setAppId(r2);	 Catch:{ all -> 0x006d }
        r3 = r1.getInstallerPackageName(r2);	 Catch:{ all -> 0x006d }
        r0.setAppInstallerId(r3);	 Catch:{ all -> 0x006d }
        r3 = 0;
        r4 = r7.mContext;	 Catch:{ NameNotFoundException -> 0x0047 }
        r4 = r4.getPackageName();	 Catch:{ NameNotFoundException -> 0x0047 }
        r5 = 0;
        r4 = r1.getPackageInfo(r4, r5);	 Catch:{ NameNotFoundException -> 0x0047 }
        if (r4 == 0) goto L_0x0063;
    L_0x0032:
        r5 = r4.applicationInfo;	 Catch:{ NameNotFoundException -> 0x0047 }
        r1 = r1.getApplicationLabel(r5);	 Catch:{ NameNotFoundException -> 0x0047 }
        r5 = android.text.TextUtils.isEmpty(r1);	 Catch:{ NameNotFoundException -> 0x0047 }
        if (r5 != 0) goto L_0x0043;
    L_0x003e:
        r1 = r1.toString();	 Catch:{ NameNotFoundException -> 0x0047 }
        r2 = r1;
    L_0x0043:
        r1 = r4.versionName;	 Catch:{ NameNotFoundException -> 0x0047 }
        r3 = r1;
        goto L_0x0063;
    L_0x0047:
        r1 = "GAv4";
        r4 = "Error retrieving package info: appName set to ";
        r5 = java.lang.String.valueOf(r2);	 Catch:{ all -> 0x006d }
        r6 = r5.length();	 Catch:{ all -> 0x006d }
        if (r6 == 0) goto L_0x005a;
    L_0x0055:
        r4 = r4.concat(r5);	 Catch:{ all -> 0x006d }
        goto L_0x0060;
    L_0x005a:
        r5 = new java.lang.String;	 Catch:{ all -> 0x006d }
        r5.<init>(r4);	 Catch:{ all -> 0x006d }
        r4 = r5;
    L_0x0060:
        android.util.Log.e(r1, r4);	 Catch:{ all -> 0x006d }
    L_0x0063:
        r0.setAppName(r2);	 Catch:{ all -> 0x006d }
        r0.setAppVersion(r3);	 Catch:{ all -> 0x006d }
        r7.zzdvo = r0;	 Catch:{ all -> 0x006d }
    L_0x006b:
        monitor-exit(r7);	 Catch:{ all -> 0x006d }
        goto L_0x0070;
    L_0x006d:
        r0 = move-exception;
        monitor-exit(r7);	 Catch:{ all -> 0x006d }
        throw r0;
    L_0x0070:
        r0 = r7.zzdvo;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.zzk.zzwh():com.google.android.gms.internal.zzaql");
    }

    public final zzaqq zzwi() {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        zzaqq zzaqq = new zzaqq();
        zzaqq.setLanguage(zzatt.zza(Locale.getDefault()));
        zzaqq.zzcly = displayMetrics.widthPixels;
        zzaqq.zzclz = displayMetrics.heightPixels;
        return zzaqq;
    }
}
