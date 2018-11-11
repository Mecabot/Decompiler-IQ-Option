package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzbgl;
import com.google.android.gms.internal.zzbgo;

public class DeviceMetaData extends zzbgl {
    @Hide
    public static final Creator<DeviceMetaData> CREATOR = new zzv();
    @Hide
    private int zzehz;
    @Hide
    private boolean zzekf;
    @Hide
    private long zzekg;
    @Hide
    private final boolean zzekh;

    @Hide
    DeviceMetaData(int i, boolean z, long j, boolean z2) {
        this.zzehz = i;
        this.zzekf = z;
        this.zzekg = j;
        this.zzekh = z2;
    }

    public long getMinAgeOfLockScreen() {
        return this.zzekg;
    }

    public boolean isChallengeAllowed() {
        return this.zzekh;
    }

    public boolean isLockScreenSolved() {
        return this.zzekf;
    }

    @Hide
    public void writeToParcel(Parcel parcel, int i) {
        i = zzbgo.zze(parcel);
        zzbgo.zzc(parcel, 1, this.zzehz);
        zzbgo.zza(parcel, 2, isLockScreenSolved());
        zzbgo.zza(parcel, 3, getMinAgeOfLockScreen());
        zzbgo.zza(parcel, 4, isChallengeAllowed());
        zzbgo.zzai(parcel, i);
    }
}
