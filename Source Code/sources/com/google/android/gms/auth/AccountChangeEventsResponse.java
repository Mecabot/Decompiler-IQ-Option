package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbgl;
import com.google.android.gms.internal.zzbgo;
import java.util.List;

public class AccountChangeEventsResponse extends zzbgl {
    public static final Creator<AccountChangeEventsResponse> CREATOR = new zzc();
    private int mVersion;
    private List<AccountChangeEvent> zzaoz;

    AccountChangeEventsResponse(int i, List<AccountChangeEvent> list) {
        this.mVersion = i;
        this.zzaoz = (List) zzbq.checkNotNull(list);
    }

    public AccountChangeEventsResponse(List<AccountChangeEvent> list) {
        this.mVersion = 1;
        this.zzaoz = (List) zzbq.checkNotNull(list);
    }

    public List<AccountChangeEvent> getEvents() {
        return this.zzaoz;
    }

    public void writeToParcel(Parcel parcel, int i) {
        i = zzbgo.zze(parcel);
        zzbgo.zzc(parcel, 1, this.mVersion);
        zzbgo.zzc(parcel, 2, this.zzaoz, false);
        zzbgo.zzai(parcel, i);
    }
}
