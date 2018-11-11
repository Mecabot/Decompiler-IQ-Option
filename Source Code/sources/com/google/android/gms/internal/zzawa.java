package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.auth.account.zzc;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzr;
import com.iqoption.dto.ChartTimeInterval;

public final class zzawa extends zzab<zzc> {
    public zzawa(Context context, Looper looper, zzr zzr, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, ChartTimeInterval.CANDLE_2m, zzr, connectionCallbacks, onConnectionFailedListener);
    }

    protected final String zzhm() {
        return "com.google.android.gms.auth.account.workaccount.START";
    }

    protected final String zzhn() {
        return "com.google.android.gms.auth.account.IWorkAccountService";
    }
}
