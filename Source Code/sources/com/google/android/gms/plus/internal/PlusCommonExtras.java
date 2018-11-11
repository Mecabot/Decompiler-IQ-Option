package com.google.android.gms.plus.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.internal.zzbgl;
import com.google.android.gms.internal.zzbgo;
import java.util.Arrays;

@KeepName
public class PlusCommonExtras extends zzbgl {
    public static final Creator<PlusCommonExtras> CREATOR = new zzl();
    private final int zzehz;
    private String zzkhx;
    private String zzkhy;

    public PlusCommonExtras() {
        this.zzehz = 1;
        this.zzkhx = "";
        this.zzkhy = "";
    }

    PlusCommonExtras(int i, String str, String str2) {
        this.zzehz = i;
        this.zzkhx = str;
        this.zzkhy = str2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlusCommonExtras)) {
            return false;
        }
        PlusCommonExtras plusCommonExtras = (PlusCommonExtras) obj;
        return this.zzehz == plusCommonExtras.zzehz && zzbg.equal(this.zzkhx, plusCommonExtras.zzkhx) && zzbg.equal(this.zzkhy, plusCommonExtras.zzkhy);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zzehz), this.zzkhx, this.zzkhy});
    }

    public String toString() {
        return zzbg.zzx(this).zzg("versionCode", Integer.valueOf(this.zzehz)).zzg("Gpsrc", this.zzkhx).zzg("ClientCallingPackage", this.zzkhy).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        i = zzbgo.zze(parcel);
        zzbgo.zza(parcel, 1, this.zzkhx, false);
        zzbgo.zza(parcel, 2, this.zzkhy, false);
        zzbgo.zzc(parcel, 1000, this.zzehz);
        zzbgo.zzai(parcel, i);
    }
}
