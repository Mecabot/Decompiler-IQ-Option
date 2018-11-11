package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.support.annotation.NonNull;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultCallbacks;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.zzbq;
import java.lang.ref.WeakReference;

public final class zzdh<R extends Result> extends TransformedResult<R> implements ResultCallback<R> {
    private final Object zzfvc = new Object();
    private final WeakReference<GoogleApiClient> zzfve;
    private ResultTransform<? super R, ? extends Result> zzgbh = null;
    private zzdh<? extends Result> zzgbi = null;
    private volatile ResultCallbacks<? super R> zzgbj = null;
    private PendingResult<R> zzgbk = null;
    private Status zzgbl = null;
    private final zzdj zzgbm;
    private boolean zzgbn = false;

    public zzdh(WeakReference<GoogleApiClient> weakReference) {
        zzbq.checkNotNull(weakReference, "GoogleApiClient reference must not be null");
        this.zzfve = weakReference;
        GoogleApiClient googleApiClient = (GoogleApiClient) this.zzfve.get();
        this.zzgbm = new zzdj(this, googleApiClient != null ? googleApiClient.getLooper() : Looper.getMainLooper());
    }

    private final void zzala() {
        if (this.zzgbh != null || this.zzgbj != null) {
            GoogleApiClient googleApiClient = (GoogleApiClient) this.zzfve.get();
            if (!(this.zzgbn || this.zzgbh == null || googleApiClient == null)) {
                googleApiClient.zza(this);
                this.zzgbn = true;
            }
            if (this.zzgbl != null) {
                zzx(this.zzgbl);
                return;
            }
            if (this.zzgbk != null) {
                this.zzgbk.setResultCallback(this);
            }
        }
    }

    private final boolean zzalc() {
        return (this.zzgbj == null || ((GoogleApiClient) this.zzfve.get()) == null) ? false : true;
    }

    private static void zzd(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (Throwable e) {
                String valueOf = String.valueOf(result);
                StringBuilder stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 18);
                stringBuilder.append("Unable to release ");
                stringBuilder.append(valueOf);
                Log.w("TransformedResultImpl", stringBuilder.toString(), e);
            }
        }
    }

    private final void zzd(Status status) {
        synchronized (this.zzfvc) {
            this.zzgbl = status;
            zzx(this.zzgbl);
        }
    }

    private final void zzx(Status status) {
        synchronized (this.zzfvc) {
            if (this.zzgbh != null) {
                status = this.zzgbh.onFailure(status);
                zzbq.checkNotNull(status, "onFailure must not return null");
                this.zzgbi.zzd(status);
            } else if (zzalc()) {
                this.zzgbj.onFailure(status);
            }
        }
    }

    public final void andFinally(@NonNull ResultCallbacks<? super R> resultCallbacks) {
        synchronized (this.zzfvc) {
            boolean z = false;
            zzbq.zza(this.zzgbj == null, (Object) "Cannot call andFinally() twice.");
            if (this.zzgbh == null) {
                z = true;
            }
            zzbq.zza(z, (Object) "Cannot call then() and andFinally() on the same TransformedResult.");
            this.zzgbj = resultCallbacks;
            zzala();
        }
    }

    public final void onResult(R r) {
        synchronized (this.zzfvc) {
            if (!r.getStatus().isSuccess()) {
                zzd(r.getStatus());
                zzd((Result) r);
            } else if (this.zzgbh != null) {
                zzcs.zzajx().submit(new zzdi(this, r));
            } else if (zzalc()) {
                this.zzgbj.onSuccess(r);
            }
        }
    }

    @NonNull
    public final <S extends Result> TransformedResult<S> then(@NonNull ResultTransform<? super R, ? extends S> resultTransform) {
        TransformedResult zzdh;
        synchronized (this.zzfvc) {
            boolean z = false;
            zzbq.zza(this.zzgbh == null, (Object) "Cannot call then() twice.");
            if (this.zzgbj == null) {
                z = true;
            }
            zzbq.zza(z, (Object) "Cannot call then() and andFinally() on the same TransformedResult.");
            this.zzgbh = resultTransform;
            zzdh = new zzdh(this.zzfve);
            this.zzgbi = zzdh;
            zzala();
        }
        return zzdh;
    }

    public final void zza(PendingResult<?> pendingResult) {
        synchronized (this.zzfvc) {
            this.zzgbk = pendingResult;
            zzala();
        }
    }

    final void zzalb() {
        this.zzgbj = null;
    }
}
