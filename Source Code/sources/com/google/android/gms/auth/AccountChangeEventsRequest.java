package com.google.android.gms.auth;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.internal.zzbgl;
import com.google.android.gms.internal.zzbgo;

public class AccountChangeEventsRequest extends zzbgl {
    public static final Creator<AccountChangeEventsRequest> CREATOR = new zzb();
    private int mVersion;
    @Deprecated
    private String zzehk;
    private int zzehm;
    private Account zzeho;

    public AccountChangeEventsRequest() {
        this.mVersion = 1;
    }

    AccountChangeEventsRequest(int i, int i2, String str, Account account) {
        this.mVersion = i;
        this.zzehm = i2;
        this.zzehk = str;
        if (account != null || TextUtils.isEmpty(str)) {
            this.zzeho = account;
        } else {
            this.zzeho = new Account(str, "com.google");
        }
    }

    public Account getAccount() {
        return this.zzeho;
    }

    @Deprecated
    public String getAccountName() {
        return this.zzehk;
    }

    public int getEventIndex() {
        return this.zzehm;
    }

    public AccountChangeEventsRequest setAccount(Account account) {
        this.zzeho = account;
        return this;
    }

    @Deprecated
    public AccountChangeEventsRequest setAccountName(String str) {
        this.zzehk = str;
        return this;
    }

    public AccountChangeEventsRequest setEventIndex(int i) {
        this.zzehm = i;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int zze = zzbgo.zze(parcel);
        zzbgo.zzc(parcel, 1, this.mVersion);
        zzbgo.zzc(parcel, 2, this.zzehm);
        zzbgo.zza(parcel, 3, this.zzehk, false);
        zzbgo.zza(parcel, 4, this.zzeho, i, false);
        zzbgo.zzai(parcel, zze);
    }
}
