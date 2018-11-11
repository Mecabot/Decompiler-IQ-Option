package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbgl;
import com.google.android.gms.internal.zzbgo;

public final class IdToken extends zzbgl implements ReflectedParcelable {
    public static final Creator<IdToken> CREATOR = new zzi();
    @NonNull
    private final String zzekb;
    @NonNull
    private final String zzelh;

    public IdToken(@NonNull String str, @NonNull String str2) {
        zzbq.checkArgument(TextUtils.isEmpty(str) ^ 1, "account type string cannot be null or empty");
        zzbq.checkArgument(TextUtils.isEmpty(str2) ^ 1, "id token string cannot be null or empty");
        this.zzekb = str;
        this.zzelh = str2;
    }

    @NonNull
    public final String getAccountType() {
        return this.zzekb;
    }

    @NonNull
    public final String getIdToken() {
        return this.zzelh;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = zzbgo.zze(parcel);
        zzbgo.zza(parcel, 1, getAccountType(), false);
        zzbgo.zza(parcel, 2, getIdToken(), false);
        zzbgo.zzai(parcel, i);
    }
}
