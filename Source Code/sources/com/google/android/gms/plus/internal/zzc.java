package com.google.android.gms.plus.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.zzbia;
import com.google.android.gms.internal.zzcwn;
import com.google.android.gms.internal.zzew;
import com.google.android.gms.internal.zzex;

public abstract class zzc extends zzew implements zzb {
    public zzc() {
        attachInterface(this, "com.google.android.gms.plus.internal.IPlusCallbacks");
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                zza(parcel.readInt(), (Bundle) zzex.zza(parcel, Bundle.CREATOR), (Bundle) zzex.zza(parcel, Bundle.CREATOR));
                break;
            case 2:
                zza(parcel.readInt(), (Bundle) zzex.zza(parcel, Bundle.CREATOR), (ParcelFileDescriptor) zzex.zza(parcel, ParcelFileDescriptor.CREATOR));
                break;
            case 3:
                zzlb(parcel.readString());
                break;
            case 4:
                zza((DataHolder) zzex.zza(parcel, DataHolder.CREATOR), parcel.readString());
                break;
            case 5:
                zza(parcel.readInt(), (Bundle) zzex.zza(parcel, Bundle.CREATOR), (zzbia) zzex.zza(parcel, zzbia.CREATOR));
                break;
            case 6:
                zza((DataHolder) zzex.zza(parcel, DataHolder.CREATOR), parcel.readString(), parcel.readString());
                break;
            case 7:
                zzk(parcel.readInt(), (Bundle) zzex.zza(parcel, Bundle.CREATOR));
                break;
            case 8:
                zzlc(parcel.readString());
                break;
            case 9:
                zza(parcel.readInt(), (zzcwn) zzex.zza(parcel, zzcwn.CREATOR));
                break;
            case 10:
                zzaq((Status) zzex.zza(parcel, Status.CREATOR));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
