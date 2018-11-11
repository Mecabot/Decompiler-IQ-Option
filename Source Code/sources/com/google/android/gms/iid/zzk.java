package com.google.android.gms.iid;

import android.os.IBinder;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.internal.zzex;

public final class zzk extends zzev implements zzi {
    zzk(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.iid.IMessengerCompat");
    }

    public final void send(Message message) {
        Parcel zzbc = zzbc();
        zzex.zza(zzbc, (Parcelable) message);
        zzc(1, zzbc);
    }
}
