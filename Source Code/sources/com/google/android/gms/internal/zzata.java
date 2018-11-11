package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import java.util.List;
import java.util.Map;

public final class zzata extends zzev implements zzasz {
    zzata(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.analytics.internal.IAnalyticsService");
    }

    public final void zza(Map map, long j, String str, List<zzasf> list) {
        Parcel zzbc = zzbc();
        zzbc.writeMap(map);
        zzbc.writeLong(j);
        zzbc.writeString(str);
        zzbc.writeTypedList(list);
        zzb(1, zzbc);
    }

    public final void zzxr() {
        zzb(2, zzbc());
    }
}
