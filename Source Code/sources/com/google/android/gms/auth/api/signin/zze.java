package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.auth.api.signin.internal.zzo;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzbgm;
import java.util.ArrayList;

@Hide
public final class zze implements Creator<GoogleSignInOptions> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        ArrayList arrayList = null;
        Account account = arrayList;
        String str = account;
        String str2 = str;
        ArrayList arrayList2 = str2;
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 1:
                    i = zzbgm.zzg(parcel, readInt);
                    break;
                case 2:
                    arrayList = zzbgm.zzc(parcel, readInt, Scope.CREATOR);
                    break;
                case 3:
                    account = (Account) zzbgm.zza(parcel, readInt, Account.CREATOR);
                    break;
                case 4:
                    z = zzbgm.zzc(parcel, readInt);
                    break;
                case 5:
                    z2 = zzbgm.zzc(parcel, readInt);
                    break;
                case 6:
                    z3 = zzbgm.zzc(parcel, readInt);
                    break;
                case 7:
                    str = zzbgm.zzq(parcel, readInt);
                    break;
                case 8:
                    str2 = zzbgm.zzq(parcel, readInt);
                    break;
                case 9:
                    arrayList2 = zzbgm.zzc(parcel, readInt, zzo.CREATOR);
                    break;
                default:
                    zzbgm.zzb(parcel, readInt);
                    break;
            }
        }
        zzbgm.zzaf(parcel, zzd);
        return new GoogleSignInOptions(i, arrayList, account, z, z2, z3, str, str2, arrayList2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new GoogleSignInOptions[i];
    }
}
