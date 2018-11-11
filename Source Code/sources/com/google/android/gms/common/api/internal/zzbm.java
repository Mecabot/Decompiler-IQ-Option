package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import android.support.v4.util.ArraySet;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzcyj;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Hide
public final class zzbm implements Callback {
    private static final Object sLock = new Object();
    public static final Status zzfzg = new Status(4, "Sign-out occurred while this API call was in progress.");
    private static final Status zzfzh = new Status(4, "The user must be signed in to make this API call.");
    private static zzbm zzfzj;
    private final Context mContext;
    private final Handler mHandler;
    private final GoogleApiAvailability zzftg;
    private final Map<zzh<?>, zzbo<?>> zzfwg = new ConcurrentHashMap(5, 0.75f, 1);
    private long zzfyf = 120000;
    private long zzfyg = 5000;
    private long zzfzi = 10000;
    private int zzfzk = -1;
    private final AtomicInteger zzfzl = new AtomicInteger(1);
    private final AtomicInteger zzfzm = new AtomicInteger(0);
    private zzah zzfzn = null;
    private final Set<zzh<?>> zzfzo = new ArraySet();
    private final Set<zzh<?>> zzfzp = new ArraySet();

    private zzbm(Context context, Looper looper, GoogleApiAvailability googleApiAvailability) {
        this.mContext = context;
        this.mHandler = new Handler(looper, this);
        this.zzftg = googleApiAvailability;
        this.mHandler.sendMessage(this.mHandler.obtainMessage(6));
    }

    public static zzbm zzajy() {
        zzbm zzbm;
        synchronized (sLock) {
            zzbq.checkNotNull(zzfzj, "Must guarantee manager is non-null before using getInstance");
            zzbm = zzfzj;
        }
        return zzbm;
    }

    public static void zzajz() {
        synchronized (sLock) {
            if (zzfzj != null) {
                zzbm zzbm = zzfzj;
                zzbm.zzfzm.incrementAndGet();
                zzbm.mHandler.sendMessageAtFrontOfQueue(zzbm.mHandler.obtainMessage(10));
            }
        }
    }

    @WorkerThread
    private final void zzakb() {
        for (zzh remove : this.zzfzp) {
            ((zzbo) this.zzfwg.remove(remove)).signOut();
        }
        this.zzfzp.clear();
    }

    @WorkerThread
    private final void zzb(GoogleApi<?> googleApi) {
        zzh zzahv = googleApi.zzahv();
        zzbo zzbo = (zzbo) this.zzfwg.get(zzahv);
        if (zzbo == null) {
            zzbo = new zzbo(this, googleApi);
            this.zzfwg.put(zzahv, zzbo);
        }
        if (zzbo.zzacc()) {
            this.zzfzp.add(zzahv);
        }
        zzbo.connect();
    }

    public static zzbm zzck(Context context) {
        zzbm zzbm;
        synchronized (sLock) {
            if (zzfzj == null) {
                HandlerThread handlerThread = new HandlerThread("GoogleApiHandler", 9);
                handlerThread.start();
                zzfzj = new zzbm(context.getApplicationContext(), handlerThread.getLooper(), GoogleApiAvailability.getInstance());
            }
            zzbm = zzfzj;
        }
        return zzbm;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ce  */
    @android.support.annotation.WorkerThread
    public final boolean handleMessage(android.os.Message r8) {
        /*
        r7 = this;
        r0 = r8.what;
        r1 = 300000; // 0x493e0 float:4.2039E-40 double:1.482197E-318;
        r3 = 1;
        r4 = 0;
        switch(r0) {
            case 1: goto L_0x01ee;
            case 2: goto L_0x019b;
            case 3: goto L_0x017e;
            case 4: goto L_0x0136;
            case 5: goto L_0x00a8;
            case 6: goto L_0x007a;
            case 7: goto L_0x0072;
            case 8: goto L_0x0136;
            case 9: goto L_0x005a;
            case 10: goto L_0x0056;
            case 11: goto L_0x003e;
            case 12: goto L_0x0026;
            case 13: goto L_0x0136;
            default: goto L_0x000a;
        };
    L_0x000a:
        r0 = "GoogleApiManager";
        r8 = r8.what;
        r1 = 31;
        r2 = new java.lang.StringBuilder;
        r2.<init>(r1);
        r1 = "Unknown message id: ";
        r2.append(r1);
        r2.append(r8);
        r8 = r2.toString();
        android.util.Log.w(r0, r8);
        r8 = 0;
        return r8;
    L_0x0026:
        r0 = r7.zzfwg;
        r1 = r8.obj;
        r0 = r0.containsKey(r1);
        if (r0 == 0) goto L_0x0227;
    L_0x0030:
        r0 = r7.zzfwg;
        r8 = r8.obj;
        r8 = r0.get(r8);
        r8 = (com.google.android.gms.common.api.internal.zzbo) r8;
        r8.zzakm();
        return r3;
    L_0x003e:
        r0 = r7.zzfwg;
        r1 = r8.obj;
        r0 = r0.containsKey(r1);
        if (r0 == 0) goto L_0x0227;
    L_0x0048:
        r0 = r7.zzfwg;
        r8 = r8.obj;
        r8 = r0.get(r8);
        r8 = (com.google.android.gms.common.api.internal.zzbo) r8;
        r8.zzajr();
        return r3;
    L_0x0056:
        r7.zzakb();
        return r3;
    L_0x005a:
        r0 = r7.zzfwg;
        r1 = r8.obj;
        r0 = r0.containsKey(r1);
        if (r0 == 0) goto L_0x0227;
    L_0x0064:
        r0 = r7.zzfwg;
        r8 = r8.obj;
        r8 = r0.get(r8);
        r8 = (com.google.android.gms.common.api.internal.zzbo) r8;
        r8.resume();
        return r3;
    L_0x0072:
        r8 = r8.obj;
        r8 = (com.google.android.gms.common.api.GoogleApi) r8;
        r7.zzb(r8);
        return r3;
    L_0x007a:
        r8 = r7.mContext;
        r8 = r8.getApplicationContext();
        r8 = r8 instanceof android.app.Application;
        if (r8 == 0) goto L_0x0227;
    L_0x0084:
        r8 = r7.mContext;
        r8 = r8.getApplicationContext();
        r8 = (android.app.Application) r8;
        com.google.android.gms.common.api.internal.zzk.zza(r8);
        r8 = com.google.android.gms.common.api.internal.zzk.zzaij();
        r0 = new com.google.android.gms.common.api.internal.zzbn;
        r0.<init>(r7);
        r8.zza(r0);
        r8 = com.google.android.gms.common.api.internal.zzk.zzaij();
        r8 = r8.zzbi(r3);
        if (r8 != 0) goto L_0x0227;
    L_0x00a5:
        r7.zzfzi = r1;
        return r3;
    L_0x00a8:
        r0 = r8.arg1;
        r8 = r8.obj;
        r8 = (com.google.android.gms.common.ConnectionResult) r8;
        r1 = r7.zzfwg;
        r1 = r1.values();
        r1 = r1.iterator();
    L_0x00b8:
        r2 = r1.hasNext();
        if (r2 == 0) goto L_0x00cb;
    L_0x00be:
        r2 = r1.next();
        r2 = (com.google.android.gms.common.api.internal.zzbo) r2;
        r5 = r2.getInstanceId();
        if (r5 != r0) goto L_0x00b8;
    L_0x00ca:
        goto L_0x00cc;
    L_0x00cb:
        r2 = r4;
    L_0x00cc:
        if (r2 == 0) goto L_0x0113;
    L_0x00ce:
        r0 = new com.google.android.gms.common.api.Status;
        r1 = 17;
        r4 = r7.zzftg;
        r5 = r8.getErrorCode();
        r4 = r4.getErrorString(r5);
        r8 = r8.getErrorMessage();
        r5 = java.lang.String.valueOf(r4);
        r5 = r5.length();
        r5 = r5 + 69;
        r6 = java.lang.String.valueOf(r8);
        r6 = r6.length();
        r5 = r5 + r6;
        r6 = new java.lang.StringBuilder;
        r6.<init>(r5);
        r5 = "Error resolution was canceled by the user, original error message: ";
        r6.append(r5);
        r6.append(r4);
        r4 = ": ";
        r6.append(r4);
        r6.append(r8);
        r8 = r6.toString();
        r0.<init>(r1, r8);
        r2.zzw(r0);
        return r3;
    L_0x0113:
        r8 = "GoogleApiManager";
        r1 = 76;
        r2 = new java.lang.StringBuilder;
        r2.<init>(r1);
        r1 = "Could not find API instance ";
        r2.append(r1);
        r2.append(r0);
        r0 = " while trying to fail enqueued calls.";
        r2.append(r0);
        r0 = r2.toString();
        r1 = new java.lang.Exception;
        r1.<init>();
        android.util.Log.wtf(r8, r0, r1);
        return r3;
    L_0x0136:
        r8 = r8.obj;
        r8 = (com.google.android.gms.common.api.internal.zzcp) r8;
        r0 = r7.zzfwg;
        r1 = r8.zzgba;
        r1 = r1.zzahv();
        r0 = r0.get(r1);
        r0 = (com.google.android.gms.common.api.internal.zzbo) r0;
        if (r0 != 0) goto L_0x015d;
    L_0x014a:
        r0 = r8.zzgba;
        r7.zzb(r0);
        r0 = r7.zzfwg;
        r1 = r8.zzgba;
        r1 = r1.zzahv();
        r0 = r0.get(r1);
        r0 = (com.google.android.gms.common.api.internal.zzbo) r0;
    L_0x015d:
        r1 = r0.zzacc();
        if (r1 == 0) goto L_0x0178;
    L_0x0163:
        r1 = r7.zzfzm;
        r1 = r1.get();
        r2 = r8.zzgaz;
        if (r1 == r2) goto L_0x0178;
    L_0x016d:
        r8 = r8.zzgay;
        r1 = zzfzg;
        r8.zzs(r1);
        r0.signOut();
        return r3;
    L_0x0178:
        r8 = r8.zzgay;
        r0.zza(r8);
        return r3;
    L_0x017e:
        r8 = r7.zzfwg;
        r8 = r8.values();
        r8 = r8.iterator();
    L_0x0188:
        r0 = r8.hasNext();
        if (r0 == 0) goto L_0x0227;
    L_0x018e:
        r0 = r8.next();
        r0 = (com.google.android.gms.common.api.internal.zzbo) r0;
        r0.zzaki();
        r0.connect();
        goto L_0x0188;
    L_0x019b:
        r8 = r8.obj;
        r8 = (com.google.android.gms.common.api.internal.zzj) r8;
        r0 = r8.zzaii();
        r0 = r0.iterator();
    L_0x01a7:
        r1 = r0.hasNext();
        if (r1 == 0) goto L_0x0227;
    L_0x01ad:
        r1 = r0.next();
        r1 = (com.google.android.gms.common.api.internal.zzh) r1;
        r2 = r7.zzfwg;
        r2 = r2.get(r1);
        r2 = (com.google.android.gms.common.api.internal.zzbo) r2;
        if (r2 != 0) goto L_0x01c8;
    L_0x01bd:
        r0 = new com.google.android.gms.common.ConnectionResult;
        r2 = 13;
        r0.<init>(r2);
        r8.zza(r1, r0, r4);
        return r3;
    L_0x01c8:
        r5 = r2.isConnected();
        if (r5 == 0) goto L_0x01dc;
    L_0x01ce:
        r5 = com.google.android.gms.common.ConnectionResult.zzfqt;
        r2 = r2.zzaix();
        r2 = r2.zzahp();
        r8.zza(r1, r5, r2);
        goto L_0x01a7;
    L_0x01dc:
        r5 = r2.zzakj();
        if (r5 == 0) goto L_0x01ea;
    L_0x01e2:
        r2 = r2.zzakj();
        r8.zza(r1, r2, r4);
        goto L_0x01a7;
    L_0x01ea:
        r2.zza(r8);
        goto L_0x01a7;
    L_0x01ee:
        r8 = r8.obj;
        r8 = (java.lang.Boolean) r8;
        r8 = r8.booleanValue();
        if (r8 == 0) goto L_0x01fa;
    L_0x01f8:
        r1 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
    L_0x01fa:
        r7.zzfzi = r1;
        r8 = r7.mHandler;
        r0 = 12;
        r8.removeMessages(r0);
        r8 = r7.zzfwg;
        r8 = r8.keySet();
        r8 = r8.iterator();
    L_0x020d:
        r1 = r8.hasNext();
        if (r1 == 0) goto L_0x0227;
    L_0x0213:
        r1 = r8.next();
        r1 = (com.google.android.gms.common.api.internal.zzh) r1;
        r2 = r7.mHandler;
        r4 = r7.mHandler;
        r1 = r4.obtainMessage(r0, r1);
        r4 = r7.zzfzi;
        r2.sendMessageDelayed(r1, r4);
        goto L_0x020d;
    L_0x0227:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zzbm.handleMessage(android.os.Message):boolean");
    }

    final PendingIntent zza(zzh<?> zzh, int i) {
        zzbo zzbo = (zzbo) this.zzfwg.get(zzh);
        if (zzbo == null) {
            return null;
        }
        zzcyj zzakn = zzbo.zzakn();
        return zzakn == null ? null : PendingIntent.getActivity(this.mContext, i, zzakn.getSignInIntent(), 134217728);
    }

    public final <O extends ApiOptions> Task<Boolean> zza(@NonNull GoogleApi<O> googleApi, @NonNull zzck<?> zzck) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.mHandler.sendMessage(this.mHandler.obtainMessage(13, new zzcp(new zzf(zzck, taskCompletionSource), this.zzfzm.get(), googleApi)));
        return taskCompletionSource.getTask();
    }

    public final <O extends ApiOptions> Task<Void> zza(@NonNull GoogleApi<O> googleApi, @NonNull zzcq<zzb, ?> zzcq, @NonNull zzdo<zzb, ?> zzdo) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.mHandler.sendMessage(this.mHandler.obtainMessage(8, new zzcp(new zzd(new zzcr(zzcq, zzdo), taskCompletionSource), this.zzfzm.get(), googleApi)));
        return taskCompletionSource.getTask();
    }

    public final Task<Map<zzh<?>, String>> zza(Iterable<? extends GoogleApi<?>> iterable) {
        zzj zzj = new zzj(iterable);
        for (GoogleApi googleApi : iterable) {
            zzbo zzbo = (zzbo) this.zzfwg.get(googleApi.zzahv());
            if (zzbo == null || !zzbo.isConnected()) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(2, zzj));
                return zzj.getTask();
            }
            zzj.zza(googleApi.zzahv(), ConnectionResult.zzfqt, zzbo.zzaix().zzahp());
        }
        return zzj.getTask();
    }

    public final void zza(ConnectionResult connectionResult, int i) {
        if (!zzc(connectionResult, i)) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(5, i, 0, connectionResult));
        }
    }

    public final void zza(GoogleApi<?> googleApi) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(7, googleApi));
    }

    public final <O extends ApiOptions, TResult> void zza(GoogleApi<O> googleApi, int i, zzde<zzb, TResult> zzde, TaskCompletionSource<TResult> taskCompletionSource, zzda zzda) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4, new zzcp(new zze(i, zzde, taskCompletionSource, zzda), this.zzfzm.get(), googleApi)));
    }

    public final <O extends ApiOptions> void zza(GoogleApi<O> googleApi, int i, zzm<? extends Result, zzb> zzm) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4, new zzcp(new zzc(i, zzm), this.zzfzm.get(), googleApi)));
    }

    public final void zza(@NonNull zzah zzah) {
        synchronized (sLock) {
            if (this.zzfzn != zzah) {
                this.zzfzn = zzah;
                this.zzfzo.clear();
                this.zzfzo.addAll(zzah.zzajf());
            }
        }
    }

    final void zzaia() {
        this.zzfzm.incrementAndGet();
        this.mHandler.sendMessage(this.mHandler.obtainMessage(10));
    }

    public final void zzaih() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
    }

    public final int zzaka() {
        return this.zzfzl.getAndIncrement();
    }

    final void zzb(@NonNull zzah zzah) {
        synchronized (sLock) {
            if (this.zzfzn == zzah) {
                this.zzfzn = null;
                this.zzfzo.clear();
            }
        }
    }

    final boolean zzc(ConnectionResult connectionResult, int i) {
        return this.zzftg.zza(this.mContext, connectionResult, i);
    }
}
