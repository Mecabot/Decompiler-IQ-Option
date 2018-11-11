package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.apps.common.proguard.UsedByNative;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzbgl;
import com.google.android.gms.internal.zzbgo;

@Hide
@UsedByNative("wrapper.cc")
public final class LandmarkParcel extends zzbgl {
    public static final Creator<LandmarkParcel> CREATOR = new zzi();
    public final int type;
    private int versionCode;
    public final float x;
    public final float y;

    public LandmarkParcel(int i, float f, float f2, int i2) {
        this.versionCode = i;
        this.x = f;
        this.y = f2;
        this.type = i2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = zzbgo.zze(parcel);
        zzbgo.zzc(parcel, 1, this.versionCode);
        zzbgo.zza(parcel, 2, this.x);
        zzbgo.zza(parcel, 3, this.y);
        zzbgo.zzc(parcel, 4, this.type);
        zzbgo.zzai(parcel, i);
    }
}
