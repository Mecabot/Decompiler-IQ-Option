package com.google.android.gms.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzaa;
import com.google.android.gms.common.util.zzw;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

@Hide
public final class zzcyz {
    private static boolean DEBUG = false;
    private static String TAG = "WakeLock";
    private static ScheduledExecutorService zzimq = null;
    private static String zzkma = "*gcore*:";
    private final Context mContext;
    private final String zzgjx;
    private final String zzgjz;
    private final WakeLock zzkmb;
    private WorkSource zzkmc;
    private final int zzkmd;
    private final String zzkme;
    private boolean zzkmf;
    private final Map<String, Integer[]> zzkmg;
    private int zzkmh;
    private AtomicInteger zzkmi;

    public zzcyz(Context context, int i, String str) {
        this(context, 1, str, null, context == null ? null : context.getPackageName());
    }

    @Hide
    @SuppressLint({"UnwrappedWakeLock"})
    private zzcyz(Context context, int i, String str, String str2, String str3) {
        this(context, 1, str, null, str3, null);
    }

    @Hide
    @SuppressLint({"UnwrappedWakeLock"})
    private zzcyz(Context context, int i, String str, String str2, String str3, String str4) {
        this.zzkmf = true;
        this.zzkmg = new HashMap();
        this.zzkmi = new AtomicInteger(0);
        zzbq.zzh(str, "Wake lock name can NOT be empty");
        this.zzkmd = i;
        this.zzkme = null;
        this.zzgjz = null;
        this.mContext = context.getApplicationContext();
        if ("com.google.android.gms".equals(context.getPackageName())) {
            this.zzgjx = str;
        } else {
            str2 = String.valueOf(zzkma);
            str4 = String.valueOf(str);
            this.zzgjx = str4.length() != 0 ? str2.concat(str4) : new String(str2);
        }
        this.zzkmb = ((PowerManager) context.getSystemService("power")).newWakeLock(i, str);
        if (zzaa.zzda(this.mContext)) {
            if (zzw.zzhb(str3)) {
                str3 = context.getPackageName();
            }
            this.zzkmc = zzaa.zzw(context, str3);
            WorkSource workSource = this.zzkmc;
            if (workSource != null && zzaa.zzda(this.mContext)) {
                if (this.zzkmc != null) {
                    this.zzkmc.add(workSource);
                } else {
                    this.zzkmc = workSource;
                }
                try {
                    this.zzkmb.setWorkSource(this.zzkmc);
                } catch (IllegalArgumentException e) {
                    Log.wtf(TAG, e.toString());
                }
            }
        }
        if (zzimq == null) {
            zzimq = zzbhg.zzanc().newSingleThreadScheduledExecutor();
        }
    }

    private final void zzew(int i) {
        if (this.zzkmb.isHeld()) {
            try {
                this.zzkmb.release();
            } catch (RuntimeException e) {
                if (e.getClass().equals(RuntimeException.class)) {
                    Log.e(TAG, String.valueOf(this.zzgjx).concat("was already released!"), new IllegalStateException());
                    return;
                }
                throw e;
            }
        }
    }

    private final String zzlf(String str) {
        return this.zzkmf ? !TextUtils.isEmpty(str) ? str : this.zzkme : this.zzkme;
    }

    /* JADX WARNING: Missing block: B:16:0x0052, code:
            if (r13 == 0) goto L_0x0054;
     */
    /* JADX WARNING: Missing block: B:20:0x005a, code:
            if (r11.zzkmh == 0) goto L_0x005c;
     */
    /* JADX WARNING: Missing block: B:21:0x005c, code:
            com.google.android.gms.common.stats.zze.zzanp();
            com.google.android.gms.common.stats.zze.zza(r11.mContext, com.google.android.gms.common.stats.zzc.zza(r11.zzkmb, r4), 7, r11.zzgjx, r4, null, r11.zzkmd, com.google.android.gms.common.util.zzaa.zzb(r11.zzkmc), 1000);
            r11.zzkmh++;
     */
    public final void acquire(long r12) {
        /*
        r11 = this;
        r12 = r11.zzkmi;
        r12.incrementAndGet();
        r12 = 0;
        r4 = r11.zzlf(r12);
        monitor-enter(r11);
        r12 = r11.zzkmg;	 Catch:{ all -> 0x0092 }
        r12 = r12.isEmpty();	 Catch:{ all -> 0x0092 }
        r13 = 0;
        if (r12 == 0) goto L_0x0018;
    L_0x0014:
        r12 = r11.zzkmh;	 Catch:{ all -> 0x0092 }
        if (r12 <= 0) goto L_0x0027;
    L_0x0018:
        r12 = r11.zzkmb;	 Catch:{ all -> 0x0092 }
        r12 = r12.isHeld();	 Catch:{ all -> 0x0092 }
        if (r12 != 0) goto L_0x0027;
    L_0x0020:
        r12 = r11.zzkmg;	 Catch:{ all -> 0x0092 }
        r12.clear();	 Catch:{ all -> 0x0092 }
        r11.zzkmh = r13;	 Catch:{ all -> 0x0092 }
    L_0x0027:
        r12 = r11.zzkmf;	 Catch:{ all -> 0x0092 }
        r10 = 1;
        if (r12 == 0) goto L_0x0054;
    L_0x002c:
        r12 = r11.zzkmg;	 Catch:{ all -> 0x0092 }
        r12 = r12.get(r4);	 Catch:{ all -> 0x0092 }
        r12 = (java.lang.Integer[]) r12;	 Catch:{ all -> 0x0092 }
        if (r12 != 0) goto L_0x0045;
    L_0x0036:
        r12 = r11.zzkmg;	 Catch:{ all -> 0x0092 }
        r0 = new java.lang.Integer[r10];	 Catch:{ all -> 0x0092 }
        r1 = java.lang.Integer.valueOf(r10);	 Catch:{ all -> 0x0092 }
        r0[r13] = r1;	 Catch:{ all -> 0x0092 }
        r12.put(r4, r0);	 Catch:{ all -> 0x0092 }
        r13 = 1;
        goto L_0x0052;
    L_0x0045:
        r0 = r12[r13];	 Catch:{ all -> 0x0092 }
        r0 = r0.intValue();	 Catch:{ all -> 0x0092 }
        r0 = r0 + r10;
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ all -> 0x0092 }
        r12[r13] = r0;	 Catch:{ all -> 0x0092 }
    L_0x0052:
        if (r13 != 0) goto L_0x005c;
    L_0x0054:
        r12 = r11.zzkmf;	 Catch:{ all -> 0x0092 }
        if (r12 != 0) goto L_0x007d;
    L_0x0058:
        r12 = r11.zzkmh;	 Catch:{ all -> 0x0092 }
        if (r12 != 0) goto L_0x007d;
    L_0x005c:
        com.google.android.gms.common.stats.zze.zzanp();	 Catch:{ all -> 0x0092 }
        r0 = r11.mContext;	 Catch:{ all -> 0x0092 }
        r12 = r11.zzkmb;	 Catch:{ all -> 0x0092 }
        r1 = com.google.android.gms.common.stats.zzc.zza(r12, r4);	 Catch:{ all -> 0x0092 }
        r2 = 7;
        r3 = r11.zzgjx;	 Catch:{ all -> 0x0092 }
        r5 = 0;
        r6 = r11.zzkmd;	 Catch:{ all -> 0x0092 }
        r12 = r11.zzkmc;	 Catch:{ all -> 0x0092 }
        r7 = com.google.android.gms.common.util.zzaa.zzb(r12);	 Catch:{ all -> 0x0092 }
        r8 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        com.google.android.gms.common.stats.zze.zza(r0, r1, r2, r3, r4, r5, r6, r7, r8);	 Catch:{ all -> 0x0092 }
        r12 = r11.zzkmh;	 Catch:{ all -> 0x0092 }
        r12 = r12 + r10;
        r11.zzkmh = r12;	 Catch:{ all -> 0x0092 }
    L_0x007d:
        monitor-exit(r11);	 Catch:{ all -> 0x0092 }
        r12 = r11.zzkmb;
        r12.acquire();
        r12 = zzimq;
        r13 = new com.google.android.gms.internal.zzcza;
        r13.<init>(r11);
        r0 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r2 = java.util.concurrent.TimeUnit.MILLISECONDS;
        r12.schedule(r13, r0, r2);
        return;
    L_0x0092:
        r12 = move-exception;
        monitor-exit(r11);	 Catch:{ all -> 0x0092 }
        throw r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcyz.acquire(long):void");
    }

    public final boolean isHeld() {
        return this.zzkmb.isHeld();
    }

    /* JADX WARNING: Missing block: B:15:0x0044, code:
            if (r0 != null) goto L_0x004e;
     */
    /* JADX WARNING: Missing block: B:19:0x004c, code:
            if (r11.zzkmh == 1) goto L_0x004e;
     */
    /* JADX WARNING: Missing block: B:20:0x004e, code:
            com.google.android.gms.common.stats.zze.zzanp();
            com.google.android.gms.common.stats.zze.zza(r11.mContext, com.google.android.gms.common.stats.zzc.zza(r11.zzkmb, r5), 8, r11.zzgjx, r5, null, r11.zzkmd, com.google.android.gms.common.util.zzaa.zzb(r11.zzkmc));
            r11.zzkmh--;
     */
    public final void release() {
        /*
        r11 = this;
        r0 = r11.zzkmi;
        r0 = r0.decrementAndGet();
        if (r0 >= 0) goto L_0x000f;
    L_0x0008:
        r0 = TAG;
        r1 = "release without a matched acquire!";
        android.util.Log.e(r0, r1);
    L_0x000f:
        r0 = 0;
        r5 = r11.zzlf(r0);
        monitor-enter(r11);
        r0 = r11.zzkmf;	 Catch:{ all -> 0x0073 }
        r9 = 1;
        r10 = 0;
        if (r0 == 0) goto L_0x0046;
    L_0x001b:
        r0 = r11.zzkmg;	 Catch:{ all -> 0x0073 }
        r0 = r0.get(r5);	 Catch:{ all -> 0x0073 }
        r0 = (java.lang.Integer[]) r0;	 Catch:{ all -> 0x0073 }
        if (r0 != 0) goto L_0x0027;
    L_0x0025:
        r0 = 0;
        goto L_0x0044;
    L_0x0027:
        r1 = r0[r10];	 Catch:{ all -> 0x0073 }
        r1 = r1.intValue();	 Catch:{ all -> 0x0073 }
        if (r1 != r9) goto L_0x0036;
    L_0x002f:
        r0 = r11.zzkmg;	 Catch:{ all -> 0x0073 }
        r0.remove(r5);	 Catch:{ all -> 0x0073 }
        r0 = 1;
        goto L_0x0044;
    L_0x0036:
        r1 = r0[r10];	 Catch:{ all -> 0x0073 }
        r1 = r1.intValue();	 Catch:{ all -> 0x0073 }
        r1 = r1 - r9;
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ all -> 0x0073 }
        r0[r10] = r1;	 Catch:{ all -> 0x0073 }
        goto L_0x0025;
    L_0x0044:
        if (r0 != 0) goto L_0x004e;
    L_0x0046:
        r0 = r11.zzkmf;	 Catch:{ all -> 0x0073 }
        if (r0 != 0) goto L_0x006e;
    L_0x004a:
        r0 = r11.zzkmh;	 Catch:{ all -> 0x0073 }
        if (r0 != r9) goto L_0x006e;
    L_0x004e:
        com.google.android.gms.common.stats.zze.zzanp();	 Catch:{ all -> 0x0073 }
        r1 = r11.mContext;	 Catch:{ all -> 0x0073 }
        r0 = r11.zzkmb;	 Catch:{ all -> 0x0073 }
        r2 = com.google.android.gms.common.stats.zzc.zza(r0, r5);	 Catch:{ all -> 0x0073 }
        r3 = 8;
        r4 = r11.zzgjx;	 Catch:{ all -> 0x0073 }
        r6 = 0;
        r7 = r11.zzkmd;	 Catch:{ all -> 0x0073 }
        r0 = r11.zzkmc;	 Catch:{ all -> 0x0073 }
        r8 = com.google.android.gms.common.util.zzaa.zzb(r0);	 Catch:{ all -> 0x0073 }
        com.google.android.gms.common.stats.zze.zza(r1, r2, r3, r4, r5, r6, r7, r8);	 Catch:{ all -> 0x0073 }
        r0 = r11.zzkmh;	 Catch:{ all -> 0x0073 }
        r0 = r0 - r9;
        r11.zzkmh = r0;	 Catch:{ all -> 0x0073 }
    L_0x006e:
        monitor-exit(r11);	 Catch:{ all -> 0x0073 }
        r11.zzew(r10);
        return;
    L_0x0073:
        r0 = move-exception;
        monitor-exit(r11);	 Catch:{ all -> 0x0073 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcyz.release():void");
    }

    public final void setReferenceCounted(boolean z) {
        this.zzkmb.setReferenceCounted(false);
        this.zzkmf = false;
    }
}
