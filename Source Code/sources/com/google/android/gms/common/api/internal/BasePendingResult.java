package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzaq;
import com.google.android.gms.common.internal.zzbq;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

@KeepName
@Hide
public abstract class BasePendingResult<R extends Result> extends PendingResult<R> {
    static final ThreadLocal<Boolean> zzfvb = new zzs();
    @KeepName
    private zzb mResultGuardian;
    private Status mStatus;
    private boolean zzam;
    private final CountDownLatch zzapc;
    private R zzftm;
    private final Object zzfvc;
    @Hide
    private zza<R> zzfvd;
    private WeakReference<GoogleApiClient> zzfve;
    private final ArrayList<com.google.android.gms.common.api.PendingResult.zza> zzfvf;
    private ResultCallback<? super R> zzfvg;
    private final AtomicReference<zzdn> zzfvh;
    private volatile boolean zzfvi;
    private boolean zzfvj;
    private zzaq zzfvk;
    private volatile zzdh<R> zzfvl;
    private boolean zzfvm;

    @Hide
    public static class zza<R extends Result> extends Handler {
        public zza() {
            this(Looper.getMainLooper());
        }

        public zza(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    Pair pair = (Pair) message.obj;
                    ResultCallback resultCallback = (ResultCallback) pair.first;
                    Result result = (Result) pair.second;
                    try {
                        resultCallback.onResult(result);
                        return;
                    } catch (RuntimeException e) {
                        BasePendingResult.zzd(result);
                        throw e;
                    }
                case 2:
                    ((BasePendingResult) message.obj).zzv(Status.zzftt);
                    return;
                default:
                    int i = message.what;
                    StringBuilder stringBuilder = new StringBuilder(45);
                    stringBuilder.append("Don't know how to handle message: ");
                    stringBuilder.append(i);
                    Log.wtf("BasePendingResult", stringBuilder.toString(), new Exception());
                    return;
            }
        }

        public final void zza(ResultCallback<? super R> resultCallback, R r) {
            sendMessage(obtainMessage(1, new Pair(resultCallback, r)));
        }
    }

    final class zzb {
        private zzb() {
        }

        /* synthetic */ zzb(BasePendingResult basePendingResult, zzs zzs) {
            this();
        }

        protected final void finalize() {
            BasePendingResult.zzd(BasePendingResult.this.zzftm);
            super.finalize();
        }
    }

    @Deprecated
    BasePendingResult() {
        this.zzfvc = new Object();
        this.zzapc = new CountDownLatch(1);
        this.zzfvf = new ArrayList();
        this.zzfvh = new AtomicReference();
        this.zzfvm = false;
        this.zzfvd = new zza(Looper.getMainLooper());
        this.zzfve = new WeakReference(null);
    }

    @Deprecated
    protected BasePendingResult(Looper looper) {
        this.zzfvc = new Object();
        this.zzapc = new CountDownLatch(1);
        this.zzfvf = new ArrayList();
        this.zzfvh = new AtomicReference();
        this.zzfvm = false;
        this.zzfvd = new zza(looper);
        this.zzfve = new WeakReference(null);
    }

    protected BasePendingResult(GoogleApiClient googleApiClient) {
        this.zzfvc = new Object();
        this.zzapc = new CountDownLatch(1);
        this.zzfvf = new ArrayList();
        this.zzfvh = new AtomicReference();
        this.zzfvm = false;
        this.zzfvd = new zza(googleApiClient != null ? googleApiClient.getLooper() : Looper.getMainLooper());
        this.zzfve = new WeakReference(googleApiClient);
    }

    private final R get() {
        R r;
        synchronized (this.zzfvc) {
            zzbq.zza(this.zzfvi ^ true, (Object) "Result has already been consumed.");
            zzbq.zza(isReady(), (Object) "Result is not ready.");
            r = this.zzftm;
            this.zzftm = null;
            this.zzfvg = null;
            this.zzfvi = true;
        }
        zzdn zzdn = (zzdn) this.zzfvh.getAndSet(null);
        if (zzdn != null) {
            zzdn.zzc(this);
        }
        return r;
    }

    private final void zzc(R r) {
        this.zzftm = r;
        this.zzfvk = null;
        this.zzapc.countDown();
        this.mStatus = this.zzftm.getStatus();
        if (this.zzam) {
            this.zzfvg = null;
        } else if (this.zzfvg != null) {
            this.zzfvd.removeMessages(2);
            this.zzfvd.zza(this.zzfvg, get());
        } else if (this.zzftm instanceof Releasable) {
            this.mResultGuardian = new zzb(this, null);
        }
        ArrayList arrayList = this.zzfvf;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((com.google.android.gms.common.api.PendingResult.zza) obj).zzr(this.mStatus);
        }
        this.zzfvf.clear();
    }

    @Hide
    public static void zzd(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (Throwable e) {
                String valueOf = String.valueOf(result);
                StringBuilder stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 18);
                stringBuilder.append("Unable to release ");
                stringBuilder.append(valueOf);
                Log.w("BasePendingResult", stringBuilder.toString(), e);
            }
        }
    }

    public final R await() {
        zzbq.zzgw("await must not be called on the UI thread");
        boolean z = true;
        zzbq.zza(this.zzfvi ^ true, (Object) "Result has already been consumed");
        if (this.zzfvl != null) {
            z = false;
        }
        zzbq.zza(z, (Object) "Cannot await if then() has been called.");
        try {
            this.zzapc.await();
        } catch (InterruptedException unused) {
            zzv(Status.zzftr);
        }
        zzbq.zza(isReady(), (Object) "Result is not ready.");
        return get();
    }

    public final R await(long j, TimeUnit timeUnit) {
        if (j > 0) {
            zzbq.zzgw("await must not be called on the UI thread when time is greater than zero.");
        }
        boolean z = true;
        zzbq.zza(this.zzfvi ^ true, (Object) "Result has already been consumed.");
        if (this.zzfvl != null) {
            z = false;
        }
        zzbq.zza(z, (Object) "Cannot await if then() has been called.");
        try {
            if (!this.zzapc.await(j, timeUnit)) {
                zzv(Status.zzftt);
            }
        } catch (InterruptedException unused) {
            zzv(Status.zzftr);
        }
        zzbq.zza(isReady(), (Object) "Result is not ready.");
        return get();
    }

    public void cancel() {
        synchronized (this.zzfvc) {
            if (this.zzam || this.zzfvi) {
            } else {
                if (this.zzfvk != null) {
                    this.zzfvk.cancel();
                }
                try {
                } catch (RemoteException unused) {
                    zzd(this.zzftm);
                    this.zzam = true;
                    zzc(zzb(Status.zzftu));
                }
            }
        }
    }

    public boolean isCanceled() {
        boolean z;
        synchronized (this.zzfvc) {
            z = this.zzam;
        }
        return z;
    }

    @Hide
    public final boolean isReady() {
        return this.zzapc.getCount() == 0;
    }

    @Hide
    public final void setResult(R r) {
        synchronized (this.zzfvc) {
            if (this.zzfvj || this.zzam) {
                zzd(r);
                return;
            }
            isReady();
            zzbq.zza(isReady() ^ 1, (Object) "Results have already been set");
            zzbq.zza(this.zzfvi ^ 1, (Object) "Result has already been consumed");
            zzc(r);
        }
    }

    /* JADX WARNING: Missing block: B:21:0x003b, code:
            return;
     */
    public final void setResultCallback(com.google.android.gms.common.api.ResultCallback<? super R> r5) {
        /*
        r4 = this;
        r0 = r4.zzfvc;
        monitor-enter(r0);
        if (r5 != 0) goto L_0x000c;
    L_0x0005:
        r5 = 0;
        r4.zzfvg = r5;	 Catch:{ all -> 0x000a }
        monitor-exit(r0);	 Catch:{ all -> 0x000a }
        return;
    L_0x000a:
        r5 = move-exception;
        goto L_0x003c;
    L_0x000c:
        r1 = r4.zzfvi;	 Catch:{ all -> 0x000a }
        r2 = 1;
        r1 = r1 ^ r2;
        r3 = "Result has already been consumed.";
        com.google.android.gms.common.internal.zzbq.zza(r1, r3);	 Catch:{ all -> 0x000a }
        r1 = r4.zzfvl;	 Catch:{ all -> 0x000a }
        if (r1 != 0) goto L_0x001a;
    L_0x0019:
        goto L_0x001b;
    L_0x001a:
        r2 = 0;
    L_0x001b:
        r1 = "Cannot set callbacks if then() has been called.";
        com.google.android.gms.common.internal.zzbq.zza(r2, r1);	 Catch:{ all -> 0x000a }
        r1 = r4.isCanceled();	 Catch:{ all -> 0x000a }
        if (r1 == 0) goto L_0x0028;
    L_0x0026:
        monitor-exit(r0);	 Catch:{ all -> 0x000a }
        return;
    L_0x0028:
        r1 = r4.isReady();	 Catch:{ all -> 0x000a }
        if (r1 == 0) goto L_0x0038;
    L_0x002e:
        r1 = r4.zzfvd;	 Catch:{ all -> 0x000a }
        r2 = r4.get();	 Catch:{ all -> 0x000a }
        r1.zza(r5, r2);	 Catch:{ all -> 0x000a }
        goto L_0x003a;
    L_0x0038:
        r4.zzfvg = r5;	 Catch:{ all -> 0x000a }
    L_0x003a:
        monitor-exit(r0);	 Catch:{ all -> 0x000a }
        return;
    L_0x003c:
        monitor-exit(r0);	 Catch:{ all -> 0x000a }
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.BasePendingResult.setResultCallback(com.google.android.gms.common.api.ResultCallback):void");
    }

    /* JADX WARNING: Missing block: B:21:0x0049, code:
            return;
     */
    public final void setResultCallback(com.google.android.gms.common.api.ResultCallback<? super R> r5, long r6, java.util.concurrent.TimeUnit r8) {
        /*
        r4 = this;
        r0 = r4.zzfvc;
        monitor-enter(r0);
        if (r5 != 0) goto L_0x000c;
    L_0x0005:
        r5 = 0;
        r4.zzfvg = r5;	 Catch:{ all -> 0x000a }
        monitor-exit(r0);	 Catch:{ all -> 0x000a }
        return;
    L_0x000a:
        r5 = move-exception;
        goto L_0x004a;
    L_0x000c:
        r1 = r4.zzfvi;	 Catch:{ all -> 0x000a }
        r2 = 1;
        r1 = r1 ^ r2;
        r3 = "Result has already been consumed.";
        com.google.android.gms.common.internal.zzbq.zza(r1, r3);	 Catch:{ all -> 0x000a }
        r1 = r4.zzfvl;	 Catch:{ all -> 0x000a }
        if (r1 != 0) goto L_0x001a;
    L_0x0019:
        goto L_0x001b;
    L_0x001a:
        r2 = 0;
    L_0x001b:
        r1 = "Cannot set callbacks if then() has been called.";
        com.google.android.gms.common.internal.zzbq.zza(r2, r1);	 Catch:{ all -> 0x000a }
        r1 = r4.isCanceled();	 Catch:{ all -> 0x000a }
        if (r1 == 0) goto L_0x0028;
    L_0x0026:
        monitor-exit(r0);	 Catch:{ all -> 0x000a }
        return;
    L_0x0028:
        r1 = r4.isReady();	 Catch:{ all -> 0x000a }
        if (r1 == 0) goto L_0x0038;
    L_0x002e:
        r6 = r4.zzfvd;	 Catch:{ all -> 0x000a }
        r7 = r4.get();	 Catch:{ all -> 0x000a }
        r6.zza(r5, r7);	 Catch:{ all -> 0x000a }
        goto L_0x0048;
    L_0x0038:
        r4.zzfvg = r5;	 Catch:{ all -> 0x000a }
        r5 = r4.zzfvd;	 Catch:{ all -> 0x000a }
        r6 = r8.toMillis(r6);	 Catch:{ all -> 0x000a }
        r8 = 2;
        r8 = r5.obtainMessage(r8, r4);	 Catch:{ all -> 0x000a }
        r5.sendMessageDelayed(r8, r6);	 Catch:{ all -> 0x000a }
    L_0x0048:
        monitor-exit(r0);	 Catch:{ all -> 0x000a }
        return;
    L_0x004a:
        monitor-exit(r0);	 Catch:{ all -> 0x000a }
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.BasePendingResult.setResultCallback(com.google.android.gms.common.api.ResultCallback, long, java.util.concurrent.TimeUnit):void");
    }

    @Hide
    public <S extends Result> TransformedResult<S> then(ResultTransform<? super R, ? extends S> resultTransform) {
        TransformedResult<S> then;
        zzbq.zza(this.zzfvi ^ true, (Object) "Result has already been consumed.");
        synchronized (this.zzfvc) {
            boolean z = false;
            zzbq.zza(this.zzfvl == null, (Object) "Cannot call then() twice.");
            if (this.zzfvg == null) {
                z = true;
            }
            zzbq.zza(z, (Object) "Cannot call then() if callbacks are set.");
            zzbq.zza(this.zzam ^ true, (Object) "Cannot call then() if result was canceled.");
            this.zzfvm = true;
            this.zzfvl = new zzdh(this.zzfve);
            then = this.zzfvl.then(resultTransform);
            if (isReady()) {
                this.zzfvd.zza(this.zzfvl, get());
            } else {
                this.zzfvg = this.zzfvl;
            }
        }
        return then;
    }

    @Hide
    public final void zza(com.google.android.gms.common.api.PendingResult.zza zza) {
        zzbq.checkArgument(zza != null, "Callback cannot be null.");
        synchronized (this.zzfvc) {
            if (isReady()) {
                zza.zzr(this.mStatus);
            } else {
                this.zzfvf.add(zza);
            }
        }
    }

    @Hide
    public final void zza(zzdn zzdn) {
        this.zzfvh.set(zzdn);
    }

    @Hide
    protected final void zza(zzaq zzaq) {
        synchronized (this.zzfvc) {
            this.zzfvk = zzaq;
        }
    }

    @Hide
    public final Integer zzaid() {
        return null;
    }

    @Hide
    public final boolean zzaip() {
        boolean isCanceled;
        synchronized (this.zzfvc) {
            if (((GoogleApiClient) this.zzfve.get()) == null || !this.zzfvm) {
                cancel();
            }
            isCanceled = isCanceled();
        }
        return isCanceled;
    }

    @Hide
    public final void zzaiq() {
        boolean z = this.zzfvm || ((Boolean) zzfvb.get()).booleanValue();
        this.zzfvm = z;
    }

    @Hide
    @NonNull
    protected abstract R zzb(Status status);

    @Hide
    public final void zzv(Status status) {
        synchronized (this.zzfvc) {
            if (!isReady()) {
                setResult(zzb(status));
                this.zzfvj = true;
            }
        }
    }
}
