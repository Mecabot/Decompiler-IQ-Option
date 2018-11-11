package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzr;

public final class zzayb extends zzab<zzaxx> {
    public zzayb(Context context, Looper looper, zzr zzr, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 126, zzr, connectionCallbacks, onConnectionFailedListener);
    }

    protected final /* synthetic */ IInterface zzd(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.phone.internal.ISmsRetrieverApiService");
        return queryLocalInterface instanceof zzaxx ? (zzaxx) queryLocalInterface : new zzaxy(iBinder);
    }

    protected final String zzhm() {
        return "com.google.android.gms.auth.api.phone.service.SmsRetrieverApiService.START";
    }

    protected final String zzhn() {
        return "com.google.android.gms.auth.api.phone.internal.ISmsRetrieverApiService";
    }
}
