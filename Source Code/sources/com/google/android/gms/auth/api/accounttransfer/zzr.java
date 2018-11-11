package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzaym;
import com.google.android.gms.internal.zzbgo;
import com.google.android.gms.internal.zzbhq;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Hide
public class zzr extends zzaym {
    public static final Creator<zzr> CREATOR = new zzs();
    private static final HashMap<String, zzbhq<?, ?>> zzejp;
    private String mPackageName;
    private String zzayo;
    private int zzehz;
    private Set<Integer> zzejq;
    private zzt zzeka;

    static {
        HashMap hashMap = new HashMap();
        zzejp = hashMap;
        hashMap.put("authenticatorInfo", zzbhq.zza("authenticatorInfo", 2, zzt.class));
        zzejp.put("signature", zzbhq.zzl("signature", 3));
        zzejp.put("package", zzbhq.zzl("package", 4));
    }

    @Hide
    public zzr() {
        this.zzejq = new HashSet(3);
        this.zzehz = 1;
    }

    zzr(Set<Integer> set, int i, zzt zzt, String str, String str2) {
        this.zzejq = set;
        this.zzehz = i;
        this.zzeka = zzt;
        this.zzayo = str;
        this.mPackageName = str2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int zze = zzbgo.zze(parcel);
        Set set = this.zzejq;
        if (set.contains(Integer.valueOf(1))) {
            zzbgo.zzc(parcel, 1, this.zzehz);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzbgo.zza(parcel, 2, this.zzeka, i, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzbgo.zza(parcel, 3, this.zzayo, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            zzbgo.zza(parcel, 4, this.mPackageName, true);
        }
        zzbgo.zzai(parcel, zze);
    }

    protected final boolean zza(zzbhq zzbhq) {
        return this.zzejq.contains(Integer.valueOf(zzbhq.zzane()));
    }

    public final /* synthetic */ Map zzabz() {
        return zzejp;
    }

    protected final Object zzb(zzbhq zzbhq) {
        switch (zzbhq.zzane()) {
            case 1:
                return Integer.valueOf(this.zzehz);
            case 2:
                return this.zzeka;
            case 3:
                return this.zzayo;
            case 4:
                return this.mPackageName;
            default:
                int zzane = zzbhq.zzane();
                StringBuilder stringBuilder = new StringBuilder(37);
                stringBuilder.append("Unknown SafeParcelable id=");
                stringBuilder.append(zzane);
                throw new IllegalStateException(stringBuilder.toString());
        }
    }
}
