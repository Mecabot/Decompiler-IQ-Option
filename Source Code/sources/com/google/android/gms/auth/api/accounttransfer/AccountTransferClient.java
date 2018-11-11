package com.google.android.gms.auth.api.accounttransfer;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.support.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzf;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzde;
import com.google.android.gms.common.api.internal.zzg;
import com.google.android.gms.common.api.zzd;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzawg;
import com.google.android.gms.internal.zzawi;
import com.google.android.gms.internal.zzawj;
import com.google.android.gms.internal.zzawm;
import com.google.android.gms.internal.zzawn;
import com.google.android.gms.internal.zzawp;
import com.google.android.gms.internal.zzawr;
import com.google.android.gms.internal.zzawt;
import com.google.android.gms.internal.zzawv;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

public class AccountTransferClient extends GoogleApi<zzn> {
    private static final zzf<zzawi> zzeiz = new zzf();
    private static final com.google.android.gms.common.api.Api.zza<zzawi, zzn> zzeja = new zzc();
    private static final Api<zzn> zzejb = new Api("AccountTransfer.ACCOUNT_TRANSFER_API", zzeja, zzeiz);

    @Hide
    static abstract class zzb<T> extends zzde<zzawi, T> {
        private TaskCompletionSource<T> zzejm;

        private zzb() {
        }

        /* synthetic */ zzb(zzc zzc) {
            this();
        }

        protected final void setResult(T t) {
            this.zzejm.setResult(t);
        }

        protected final /* synthetic */ void zza(com.google.android.gms.common.api.Api.zzb zzb, TaskCompletionSource taskCompletionSource) {
            zzawi zzawi = (zzawi) zzb;
            this.zzejm = taskCompletionSource;
            zza((zzawn) zzawi.zzalw());
        }

        protected abstract void zza(zzawn zzawn);

        protected final void zzd(Status status) {
            AccountTransferClient.zza(this.zzejm, status);
        }
    }

    @Hide
    static abstract class zzc extends zzb<Void> {
        zzawm zzejn;

        private zzc() {
            super();
            this.zzejn = new zzk(this);
        }

        /* synthetic */ zzc(zzc zzc) {
            this();
        }
    }

    @Hide
    static class zza<T> extends zzawg {
        private zzb<T> zzejl;

        public zza(zzb<T> zzb) {
            this.zzejl = zzb;
        }

        public final void onFailure(Status status) {
            this.zzejl.zzd(status);
        }
    }

    @Hide
    AccountTransferClient(@NonNull Activity activity) {
        super(activity, zzejb, null, new zzd().zza(new zzg()).zzahy());
    }

    @Hide
    AccountTransferClient(@NonNull Context context) {
        super(context, zzejb, null, new zzd().zza(new zzg()).zzahy());
    }

    private static void zza(TaskCompletionSource taskCompletionSource, Status status) {
        taskCompletionSource.setException(new AccountTransferException(status));
    }

    public Task<DeviceMetaData> getDeviceMetaData(String str) {
        zzbq.checkNotNull(str);
        return zza(new zzg(this, new zzawj(str)));
    }

    public Task<Void> notifyCompletion(String str, int i) {
        zzbq.checkNotNull(str);
        return zzb(new zzj(this, new zzawp(str, i)));
    }

    public Task<byte[]> retrieveData(String str) {
        zzbq.checkNotNull(str);
        return zza(new zze(this, new zzawr(str)));
    }

    public Task<Void> sendData(String str, byte[] bArr) {
        zzbq.checkNotNull(str);
        zzbq.checkNotNull(bArr);
        return zzb(new zzd(this, new zzawt(str, bArr)));
    }

    public Task<Void> showUserChallenge(String str, PendingIntent pendingIntent) {
        zzbq.checkNotNull(str);
        zzbq.checkNotNull(pendingIntent);
        return zzb(new zzi(this, new zzawv(str, pendingIntent)));
    }
}
