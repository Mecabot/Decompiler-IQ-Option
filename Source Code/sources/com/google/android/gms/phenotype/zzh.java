package com.google.android.gms.phenotype;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzbgm;

@Hide
public final class zzh implements Creator<ExperimentTokens> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        String str = null;
        byte[] bArr = str;
        byte[][] bArr2 = bArr;
        byte[][] bArr3 = bArr2;
        byte[][] bArr4 = bArr3;
        byte[][] bArr5 = bArr4;
        int[] iArr = bArr5;
        byte[][] bArr6 = iArr;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 2:
                    str = zzbgm.zzq(parcel, readInt);
                    break;
                case 3:
                    bArr = zzbgm.zzt(parcel, readInt);
                    break;
                case 4:
                    bArr2 = zzbgm.zzu(parcel, readInt);
                    break;
                case 5:
                    bArr3 = zzbgm.zzu(parcel, readInt);
                    break;
                case 6:
                    bArr4 = zzbgm.zzu(parcel, readInt);
                    break;
                case 7:
                    bArr5 = zzbgm.zzu(parcel, readInt);
                    break;
                case 8:
                    iArr = zzbgm.zzw(parcel, readInt);
                    break;
                case 9:
                    bArr6 = zzbgm.zzu(parcel, readInt);
                    break;
                default:
                    zzbgm.zzb(parcel, readInt);
                    break;
            }
        }
        zzbgm.zzaf(parcel, zzd);
        return new ExperimentTokens(str, bArr, bArr2, bArr3, bArr4, bArr5, iArr, bArr6);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new ExperimentTokens[i];
    }
}
