package com.google.android.gms.plus.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.internal.zzbgl;
import com.google.android.gms.internal.zzbgo;
import com.google.android.gms.internal.zzbgq;
import java.util.Arrays;

@Hide
public final class zzn extends zzbgl {
    public static final Creator<zzn> CREATOR = new zzo();
    private final String zzehk;
    private final int zzehz;
    private final String zzflg;
    private final String[] zzkia;
    private final String[] zzkib;
    private final String[] zzkic;
    private final String zzkid;
    private final String zzkie;
    private final String zzkif;
    private final PlusCommonExtras zzkig;

    zzn(int i, String str, String[] strArr, String[] strArr2, String[] strArr3, String str2, String str3, String str4, String str5, PlusCommonExtras plusCommonExtras) {
        this.zzehz = i;
        this.zzehk = str;
        this.zzkia = strArr;
        this.zzkib = strArr2;
        this.zzkic = strArr3;
        this.zzkid = str2;
        this.zzkie = str3;
        this.zzflg = str4;
        this.zzkif = str5;
        this.zzkig = plusCommonExtras;
    }

    public zzn(String str, String[] strArr, String[] strArr2, String[] strArr3, String str2, String str3, String str4, PlusCommonExtras plusCommonExtras) {
        this.zzehz = 1;
        this.zzehk = str;
        this.zzkia = strArr;
        this.zzkib = strArr2;
        this.zzkic = strArr3;
        this.zzkid = str2;
        this.zzkie = str3;
        this.zzflg = null;
        this.zzkif = null;
        this.zzkig = plusCommonExtras;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzn)) {
            return false;
        }
        zzn zzn = (zzn) obj;
        return this.zzehz == zzn.zzehz && zzbg.equal(this.zzehk, zzn.zzehk) && Arrays.equals(this.zzkia, zzn.zzkia) && Arrays.equals(this.zzkib, zzn.zzkib) && Arrays.equals(this.zzkic, zzn.zzkic) && zzbg.equal(this.zzkid, zzn.zzkid) && zzbg.equal(this.zzkie, zzn.zzkie) && zzbg.equal(this.zzflg, zzn.zzflg) && zzbg.equal(this.zzkif, zzn.zzkif) && zzbg.equal(this.zzkig, zzn.zzkig);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zzehz), this.zzehk, this.zzkia, this.zzkib, this.zzkic, this.zzkid, this.zzkie, this.zzflg, this.zzkif, this.zzkig});
    }

    public final String toString() {
        return zzbg.zzx(this).zzg("versionCode", Integer.valueOf(this.zzehz)).zzg("accountName", this.zzehk).zzg("requestedScopes", this.zzkia).zzg("visibleActivities", this.zzkib).zzg("requiredFeatures", this.zzkic).zzg("packageNameForAuth", this.zzkid).zzg("callingPackageName", this.zzkie).zzg("applicationName", this.zzflg).zzg("extra", this.zzkig.toString()).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbgo.zze(parcel);
        zzbgo.zza(parcel, 1, this.zzehk, false);
        zzbgo.zza(parcel, 2, this.zzkia, false);
        zzbgo.zza(parcel, 3, this.zzkib, false);
        zzbgo.zza(parcel, 4, this.zzkic, false);
        zzbgo.zza(parcel, 5, this.zzkid, false);
        zzbgo.zza(parcel, 6, this.zzkie, false);
        zzbgo.zza(parcel, 7, this.zzflg, false);
        zzbgo.zzc(parcel, 1000, this.zzehz);
        zzbgo.zza(parcel, 8, this.zzkif, false);
        zzbgo.zza(parcel, 9, this.zzkig, i, false);
        zzbgo.zzai(parcel, zze);
    }

    public final String[] zzbeo() {
        return this.zzkib;
    }

    public final String zzbep() {
        return this.zzkid;
    }

    public final Bundle zzbeq() {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(PlusCommonExtras.class.getClassLoader());
        bundle.putByteArray("android.gms.plus.internal.PlusCommonExtras.extraPlusCommon", zzbgq.zza(this.zzkig));
        return bundle;
    }
}
