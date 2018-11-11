package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzbgm;
import com.google.android.gms.vision.barcode.Barcode.Address;
import com.google.android.gms.vision.barcode.Barcode.ContactInfo;
import com.google.android.gms.vision.barcode.Barcode.Email;
import com.google.android.gms.vision.barcode.Barcode.PersonName;
import com.google.android.gms.vision.barcode.Barcode.Phone;

@Hide
public final class zzf implements Creator<ContactInfo> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        PersonName personName = null;
        String str = personName;
        String str2 = str;
        Phone[] phoneArr = str2;
        Email[] emailArr = phoneArr;
        String[] strArr = emailArr;
        Address[] addressArr = strArr;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 2:
                    personName = (PersonName) zzbgm.zza(parcel, readInt, PersonName.CREATOR);
                    break;
                case 3:
                    str = zzbgm.zzq(parcel, readInt);
                    break;
                case 4:
                    str2 = zzbgm.zzq(parcel, readInt);
                    break;
                case 5:
                    phoneArr = (Phone[]) zzbgm.zzb(parcel, readInt, Phone.CREATOR);
                    break;
                case 6:
                    emailArr = (Email[]) zzbgm.zzb(parcel, readInt, Email.CREATOR);
                    break;
                case 7:
                    strArr = zzbgm.zzaa(parcel, readInt);
                    break;
                case 8:
                    addressArr = (Address[]) zzbgm.zzb(parcel, readInt, Address.CREATOR);
                    break;
                default:
                    zzbgm.zzb(parcel, readInt);
                    break;
            }
        }
        zzbgm.zzaf(parcel, zzd);
        return new ContactInfo(personName, str, str2, phoneArr, emailArr, strArr, addressArr);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new ContactInfo[i];
    }
}
