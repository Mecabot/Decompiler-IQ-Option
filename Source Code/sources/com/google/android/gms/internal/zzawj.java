package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbq;

@Hide
public final class zzawj extends zzbgl {
    public static final Creator<zzawj> CREATOR = new zzawk();
    private String accountType;
    @Hide
    private int zzehz;

    zzawj(int i, String str) {
        this.zzehz = 1;
        this.accountType = (String) zzbq.checkNotNull(str);
    }

    public zzawj(String str) {
        this(1, str);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = zzbgo.zze(parcel);
        zzbgo.zzc(parcel, 1, this.zzehz);
        zzbgo.zza(parcel, 2, this.accountType, false);
        zzbgo.zzai(parcel, i);
    }
}
