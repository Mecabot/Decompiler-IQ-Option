package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzr;

public final class zze extends zzab<zzv> {
    private final GoogleSignInOptions zzenp;

    public zze(Context context, Looper looper, zzr zzr, GoogleSignInOptions googleSignInOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 91, zzr, connectionCallbacks, onConnectionFailedListener);
        if (googleSignInOptions == null) {
            googleSignInOptions = new Builder().build();
        }
        if (!zzr.zzamg().isEmpty()) {
            Builder builder = new Builder(googleSignInOptions);
            for (Scope requestScopes : zzr.zzamg()) {
                builder.requestScopes(requestScopes, new Scope[0]);
            }
            googleSignInOptions = builder.build();
        }
        this.zzenp = googleSignInOptions;
    }

    public final Intent getSignInIntent() {
        return zzf.zza(getContext(), this.zzenp);
    }

    public final boolean zzacn() {
        return true;
    }

    public final GoogleSignInOptions zzaco() {
        return this.zzenp;
    }

    protected final /* synthetic */ IInterface zzd(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
        return queryLocalInterface instanceof zzv ? (zzv) queryLocalInterface : new zzw(iBinder);
    }

    protected final String zzhm() {
        return "com.google.android.gms.auth.api.signin.service.START";
    }

    protected final String zzhn() {
        return "com.google.android.gms.auth.api.signin.internal.ISignInService";
    }
}
