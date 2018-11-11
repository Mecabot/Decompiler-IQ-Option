package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbq;

@Hide
public final class zzawv extends zzbgl {
    public static final Creator<zzawv> CREATOR = new zzaww();
    private String accountType;
    @Hide
    private int zzehz;
    private PendingIntent zzekk;

    zzawv(int i, String str, PendingIntent pendingIntent) {
        this.zzehz = 1;
        this.accountType = (String) zzbq.checkNotNull(str);
        this.zzekk = (PendingIntent) zzbq.checkNotNull(pendingIntent);
    }

    public zzawv(String str, PendingIntent pendingIntent) {
        this(1, str, pendingIntent);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbgo.zze(parcel);
        zzbgo.zzc(parcel, 1, this.zzehz);
        zzbgo.zza(parcel, 2, this.accountType, false);
        zzbgo.zza(parcel, 3, this.zzekk, i, false);
        zzbgo.zzai(parcel, zze);
    }
}
