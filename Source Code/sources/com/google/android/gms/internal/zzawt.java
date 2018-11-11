package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbq;

@Hide
public final class zzawt extends zzbgl {
    public static final Creator<zzawt> CREATOR = new zzawu();
    private String accountType;
    @Hide
    private int zzehz;
    private byte[] zzekc;

    zzawt(int i, String str, byte[] bArr) {
        this.zzehz = 1;
        this.accountType = (String) zzbq.checkNotNull(str);
        this.zzekc = (byte[]) zzbq.checkNotNull(bArr);
    }

    public zzawt(String str, byte[] bArr) {
        this(1, str, bArr);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = zzbgo.zze(parcel);
        zzbgo.zzc(parcel, 1, this.zzehz);
        zzbgo.zza(parcel, 2, this.accountType, false);
        zzbgo.zza(parcel, 3, this.zzekc, false);
        zzbgo.zzai(parcel, i);
    }
}
