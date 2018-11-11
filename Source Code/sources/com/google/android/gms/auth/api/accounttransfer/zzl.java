package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.NotificationCompat;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzaym;
import com.google.android.gms.internal.zzbgo;
import com.google.android.gms.internal.zzbhq;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Hide
public final class zzl extends zzaym {
    public static final Creator<zzl> CREATOR = new zzm();
    private static final HashMap<String, zzbhq<?, ?>> zzejp;
    @Hide
    private int zzehz;
    private Set<Integer> zzejq;
    private ArrayList<zzr> zzejr;
    private int zzejs;
    private zzo zzejt;

    static {
        HashMap hashMap = new HashMap();
        zzejp = hashMap;
        hashMap.put("authenticatorData", zzbhq.zzb("authenticatorData", 2, zzr.class));
        zzejp.put(NotificationCompat.CATEGORY_PROGRESS, zzbhq.zza(NotificationCompat.CATEGORY_PROGRESS, 4, zzo.class));
    }

    @Hide
    public zzl() {
        this.zzejq = new HashSet(1);
        this.zzehz = 1;
    }

    zzl(Set<Integer> set, int i, ArrayList<zzr> arrayList, int i2, zzo zzo) {
        this.zzejq = set;
        this.zzehz = i;
        this.zzejr = arrayList;
        this.zzejs = i2;
        this.zzejt = zzo;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbgo.zze(parcel);
        Set set = this.zzejq;
        if (set.contains(Integer.valueOf(1))) {
            zzbgo.zzc(parcel, 1, this.zzehz);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzbgo.zzc(parcel, 2, this.zzejr, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzbgo.zzc(parcel, 3, this.zzejs);
        }
        if (set.contains(Integer.valueOf(4))) {
            zzbgo.zza(parcel, 4, this.zzejt, i, true);
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
        int zzane = zzbhq.zzane();
        if (zzane == 4) {
            return this.zzejt;
        }
        switch (zzane) {
            case 1:
                return Integer.valueOf(this.zzehz);
            case 2:
                return this.zzejr;
            default:
                int zzane2 = zzbhq.zzane();
                StringBuilder stringBuilder = new StringBuilder(37);
                stringBuilder.append("Unknown SafeParcelable id=");
                stringBuilder.append(zzane2);
                throw new IllegalStateException(stringBuilder.toString());
        }
    }
}
