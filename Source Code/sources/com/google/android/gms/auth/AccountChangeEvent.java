package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbgl;
import com.google.android.gms.internal.zzbgo;
import java.util.Arrays;

public class AccountChangeEvent extends zzbgl {
    public static final Creator<AccountChangeEvent> CREATOR = new zza();
    private int mVersion;
    private long zzehj;
    private String zzehk;
    private int zzehl;
    private int zzehm;
    private String zzehn;

    AccountChangeEvent(int i, long j, String str, int i2, int i3, String str2) {
        this.mVersion = i;
        this.zzehj = j;
        this.zzehk = (String) zzbq.checkNotNull(str);
        this.zzehl = i2;
        this.zzehm = i3;
        this.zzehn = str2;
    }

    public AccountChangeEvent(long j, String str, int i, int i2, String str2) {
        this.mVersion = 1;
        this.zzehj = j;
        this.zzehk = (String) zzbq.checkNotNull(str);
        this.zzehl = i;
        this.zzehm = i2;
        this.zzehn = str2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AccountChangeEvent) {
            AccountChangeEvent accountChangeEvent = (AccountChangeEvent) obj;
            return this.mVersion == accountChangeEvent.mVersion && this.zzehj == accountChangeEvent.zzehj && zzbg.equal(this.zzehk, accountChangeEvent.zzehk) && this.zzehl == accountChangeEvent.zzehl && this.zzehm == accountChangeEvent.zzehm && zzbg.equal(this.zzehn, accountChangeEvent.zzehn);
        }
    }

    public String getAccountName() {
        return this.zzehk;
    }

    public String getChangeData() {
        return this.zzehn;
    }

    public int getChangeType() {
        return this.zzehl;
    }

    public int getEventIndex() {
        return this.zzehm;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.mVersion), Long.valueOf(this.zzehj), this.zzehk, Integer.valueOf(this.zzehl), Integer.valueOf(this.zzehm), this.zzehn});
    }

    public String toString() {
        String str = "UNKNOWN";
        switch (this.zzehl) {
            case 1:
                str = "ADDED";
                break;
            case 2:
                str = "REMOVED";
                break;
            case 3:
                str = "RENAMED_FROM";
                break;
            case 4:
                str = "RENAMED_TO";
                break;
        }
        String str2 = this.zzehk;
        String str3 = this.zzehn;
        int i = this.zzehm;
        StringBuilder stringBuilder = new StringBuilder(((String.valueOf(str2).length() + 91) + String.valueOf(str).length()) + String.valueOf(str3).length());
        stringBuilder.append("AccountChangeEvent {accountName = ");
        stringBuilder.append(str2);
        stringBuilder.append(", changeType = ");
        stringBuilder.append(str);
        stringBuilder.append(", changeData = ");
        stringBuilder.append(str3);
        stringBuilder.append(", eventIndex = ");
        stringBuilder.append(i);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        i = zzbgo.zze(parcel);
        zzbgo.zzc(parcel, 1, this.mVersion);
        zzbgo.zza(parcel, 2, this.zzehj);
        zzbgo.zza(parcel, 3, this.zzehk, false);
        zzbgo.zzc(parcel, 4, this.zzehl);
        zzbgo.zzc(parcel, 5, this.zzehm);
        zzbgo.zza(parcel, 6, this.zzehn, false);
        zzbgo.zzai(parcel, i);
    }
}
