package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.auth.api.zzd;
import com.google.android.gms.auth.api.zzf;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzr;

public final class zzaxs extends zzab<zzaxv> {
    private final Bundle zzeki;

    public zzaxs(Context context, Looper looper, zzr zzr, zzf zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 16, zzr, connectionCallbacks, onConnectionFailedListener);
        if (zzf == null) {
            this.zzeki = new Bundle();
            return;
        }
        throw new NoSuchMethodError();
    }

    protected final Bundle zzabt() {
        return this.zzeki;
    }

    public final boolean zzacc() {
        zzr zzamr = zzamr();
        return (TextUtils.isEmpty(zzamr.getAccountName()) || zzamr.zzc(zzd.API).isEmpty()) ? false : true;
    }

    protected final /* synthetic */ IInterface zzd(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.internal.IAuthService");
        return queryLocalInterface instanceof zzaxv ? (zzaxv) queryLocalInterface : new zzaxw(iBinder);
    }

    protected final String zzhm() {
        return "com.google.android.gms.auth.service.START";
    }

    protected final String zzhn() {
        return "com.google.android.gms.auth.api.internal.IAuthService";
    }
}
