package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzbgm;
import com.google.android.gms.vision.barcode.Barcode.CalendarDateTime;
import com.google.android.gms.vision.barcode.Barcode.CalendarEvent;

@Hide
public final class zze implements Creator<CalendarEvent> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        String str = null;
        String str2 = str;
        String str3 = str2;
        String str4 = str3;
        String str5 = str4;
        CalendarDateTime calendarDateTime = str5;
        CalendarDateTime calendarDateTime2 = calendarDateTime;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 2:
                    str = zzbgm.zzq(parcel, readInt);
                    break;
                case 3:
                    str2 = zzbgm.zzq(parcel, readInt);
                    break;
                case 4:
                    str3 = zzbgm.zzq(parcel, readInt);
                    break;
                case 5:
                    str4 = zzbgm.zzq(parcel, readInt);
                    break;
                case 6:
                    str5 = zzbgm.zzq(parcel, readInt);
                    break;
                case 7:
                    calendarDateTime = (CalendarDateTime) zzbgm.zza(parcel, readInt, CalendarDateTime.CREATOR);
                    break;
                case 8:
                    calendarDateTime2 = (CalendarDateTime) zzbgm.zza(parcel, readInt, CalendarDateTime.CREATOR);
                    break;
                default:
                    zzbgm.zzb(parcel, readInt);
                    break;
            }
        }
        zzbgm.zzaf(parcel, zzd);
        return new CalendarEvent(str, str2, str3, str4, str5, calendarDateTime, calendarDateTime2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new CalendarEvent[i];
    }
}
