package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.internal.Hide;

@Hide
public final class zzaxq implements Creator<zzaxp> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        Credential credential = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            if ((SupportMenu.USER_MASK & readInt) != 1) {
                zzbgm.zzb(parcel, readInt);
            } else {
                credential = (Credential) zzbgm.zza(parcel, readInt, Credential.CREATOR);
            }
        }
        zzbgm.zzaf(parcel, zzd);
        return new zzaxp(credential);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzaxp[i];
    }
}
