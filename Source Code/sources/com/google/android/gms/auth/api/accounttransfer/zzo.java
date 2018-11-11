package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzaym;
import com.google.android.gms.internal.zzbgo;
import com.google.android.gms.internal.zzbhq;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import java.util.List;
import java.util.Map;

@Hide
public class zzo extends zzaym {
    public static final Creator<zzo> CREATOR = new zzp();
    private static final ArrayMap<String, zzbhq<?, ?>> zzeju;
    @Hide
    private int zzehz;
    private List<String> zzejv;
    private List<String> zzejw;
    private List<String> zzejx;
    private List<String> zzejy;
    private List<String> zzejz;

    static {
        ArrayMap arrayMap = new ArrayMap();
        zzeju = arrayMap;
        arrayMap.put("registered", zzbhq.zzm("registered", 2));
        zzeju.put("in_progress", zzbhq.zzm("in_progress", 3));
        zzeju.put(b.SUCCESS, zzbhq.zzm(b.SUCCESS, 4));
        zzeju.put("failed", zzbhq.zzm("failed", 5));
        zzeju.put("escrowed", zzbhq.zzm("escrowed", 6));
    }

    @Hide
    public zzo() {
        this.zzehz = 1;
    }

    zzo(int i, @Nullable List<String> list, @Nullable List<String> list2, @Nullable List<String> list3, @Nullable List<String> list4, @Nullable List<String> list5) {
        this.zzehz = i;
        this.zzejv = list;
        this.zzejw = list2;
        this.zzejx = list3;
        this.zzejy = list4;
        this.zzejz = list5;
    }

    public void writeToParcel(Parcel parcel, int i) {
        i = zzbgo.zze(parcel);
        zzbgo.zzc(parcel, 1, this.zzehz);
        zzbgo.zzb(parcel, 2, this.zzejv, false);
        zzbgo.zzb(parcel, 3, this.zzejw, false);
        zzbgo.zzb(parcel, 4, this.zzejx, false);
        zzbgo.zzb(parcel, 5, this.zzejy, false);
        zzbgo.zzb(parcel, 6, this.zzejz, false);
        zzbgo.zzai(parcel, i);
    }

    protected final boolean zza(zzbhq zzbhq) {
        return true;
    }

    public final Map<String, zzbhq<?, ?>> zzabz() {
        return zzeju;
    }

    protected final Object zzb(zzbhq zzbhq) {
        switch (zzbhq.zzane()) {
            case 1:
                return Integer.valueOf(this.zzehz);
            case 2:
                return this.zzejv;
            case 3:
                return this.zzejw;
            case 4:
                return this.zzejx;
            case 5:
                return this.zzejy;
            case 6:
                return this.zzejz;
            default:
                int zzane = zzbhq.zzane();
                StringBuilder stringBuilder = new StringBuilder(37);
                stringBuilder.append("Unknown SafeParcelable id=");
                stringBuilder.append(zzane);
                throw new IllegalStateException(stringBuilder.toString());
        }
    }
}
