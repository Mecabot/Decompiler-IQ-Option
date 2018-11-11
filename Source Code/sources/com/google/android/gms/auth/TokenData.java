package com.google.android.gms.auth;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbgl;
import com.google.android.gms.internal.zzbgo;
import java.util.Arrays;
import java.util.List;

@Hide
public class TokenData extends zzbgl implements ReflectedParcelable {
    public static final Creator<TokenData> CREATOR = new zzk();
    private int zzehz;
    private final String zzeia;
    private final Long zzeib;
    private final boolean zzeic;
    private final boolean zzeid;
    private final List<String> zzeie;

    TokenData(int i, String str, Long l, boolean z, boolean z2, List<String> list) {
        this.zzehz = i;
        this.zzeia = zzbq.zzgv(str);
        this.zzeib = l;
        this.zzeic = z;
        this.zzeid = z2;
        this.zzeie = list;
    }

    @Nullable
    public static TokenData zzc(Bundle bundle, String str) {
        bundle.setClassLoader(TokenData.class.getClassLoader());
        bundle = bundle.getBundle(str);
        if (bundle == null) {
            return null;
        }
        bundle.setClassLoader(TokenData.class.getClassLoader());
        return (TokenData) bundle.getParcelable("TokenData");
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TokenData)) {
            return false;
        }
        TokenData tokenData = (TokenData) obj;
        return TextUtils.equals(this.zzeia, tokenData.zzeia) && zzbg.equal(this.zzeib, tokenData.zzeib) && this.zzeic == tokenData.zzeic && this.zzeid == tokenData.zzeid && zzbg.equal(this.zzeie, tokenData.zzeie);
    }

    public final String getToken() {
        return this.zzeia;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.zzeia, this.zzeib, Boolean.valueOf(this.zzeic), Boolean.valueOf(this.zzeid), this.zzeie});
    }

    public void writeToParcel(Parcel parcel, int i) {
        i = zzbgo.zze(parcel);
        zzbgo.zzc(parcel, 1, this.zzehz);
        zzbgo.zza(parcel, 2, this.zzeia, false);
        zzbgo.zza(parcel, 3, this.zzeib, false);
        zzbgo.zza(parcel, 4, this.zzeic);
        zzbgo.zza(parcel, 5, this.zzeid);
        zzbgo.zzb(parcel, 6, this.zzeie, false);
        zzbgo.zzai(parcel, i);
    }
}
