package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.support.annotation.Nullable;
import com.google.android.gms.auth.api.Auth.AuthCredentialsOptions;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzr;

public final class zzaxi extends zzab<zzaxn> {
    @Nullable
    private final AuthCredentialsOptions zzelw;

    public zzaxi(Context context, Looper looper, zzr zzr, AuthCredentialsOptions authCredentialsOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 68, zzr, connectionCallbacks, onConnectionFailedListener);
        this.zzelw = authCredentialsOptions;
    }

    protected final Bundle zzabt() {
        return this.zzelw == null ? new Bundle() : this.zzelw.toBundle();
    }

    final AuthCredentialsOptions zzacb() {
        return this.zzelw;
    }

    protected final /* synthetic */ IInterface zzd(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
        return queryLocalInterface instanceof zzaxn ? (zzaxn) queryLocalInterface : new zzaxo(iBinder);
    }

    protected final String zzhm() {
        return "com.google.android.gms.auth.api.credentials.service.START";
    }

    protected final String zzhn() {
        return "com.google.android.gms.auth.api.credentials.internal.ICredentialsService";
    }
}
