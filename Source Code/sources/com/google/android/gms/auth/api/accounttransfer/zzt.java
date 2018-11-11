package com.google.android.gms.auth.api.accounttransfer;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.NotificationCompat;
import android.support.v4.util.ArraySet;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzaym;
import com.google.android.gms.internal.zzbgo;
import com.google.android.gms.internal.zzbhq;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Hide
public class zzt extends zzaym {
    public static final Creator<zzt> CREATOR = new zzu();
    private static final HashMap<String, zzbhq<?, ?>> zzejp;
    private int zzcfl;
    @Hide
    private int zzehz;
    private Set<Integer> zzejq;
    private String zzekb;
    private byte[] zzekc;
    private PendingIntent zzekd;
    private DeviceMetaData zzeke;

    static {
        HashMap hashMap = new HashMap();
        zzejp = hashMap;
        hashMap.put("accountType", zzbhq.zzl("accountType", 2));
        zzejp.put(NotificationCompat.CATEGORY_STATUS, zzbhq.zzj(NotificationCompat.CATEGORY_STATUS, 3));
        zzejp.put("transferBytes", zzbhq.zzn("transferBytes", 4));
    }

    @Hide
    public zzt() {
        this.zzejq = new ArraySet(3);
        this.zzehz = 1;
    }

    zzt(Set<Integer> set, int i, String str, int i2, byte[] bArr, PendingIntent pendingIntent, DeviceMetaData deviceMetaData) {
        this.zzejq = set;
        this.zzehz = i;
        this.zzekb = str;
        this.zzcfl = i2;
        this.zzekc = bArr;
        this.zzekd = pendingIntent;
        this.zzeke = deviceMetaData;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int zze = zzbgo.zze(parcel);
        Set set = this.zzejq;
        if (set.contains(Integer.valueOf(1))) {
            zzbgo.zzc(parcel, 1, this.zzehz);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzbgo.zza(parcel, 2, this.zzekb, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzbgo.zzc(parcel, 3, this.zzcfl);
        }
        if (set.contains(Integer.valueOf(4))) {
            zzbgo.zza(parcel, 4, this.zzekc, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            zzbgo.zza(parcel, 5, this.zzekd, i, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            zzbgo.zza(parcel, 6, this.zzeke, i, true);
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
        int i;
        switch (zzbhq.zzane()) {
            case 1:
                i = this.zzehz;
                break;
            case 2:
                return this.zzekb;
            case 3:
                i = this.zzcfl;
                break;
            case 4:
                return this.zzekc;
            default:
                i = zzbhq.zzane();
                StringBuilder stringBuilder = new StringBuilder(37);
                stringBuilder.append("Unknown SafeParcelable id=");
                stringBuilder.append(i);
                throw new IllegalStateException(stringBuilder.toString());
        }
        return Integer.valueOf(i);
    }
}
