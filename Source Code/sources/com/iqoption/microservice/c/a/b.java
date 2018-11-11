package com.iqoption.microservice.c.a;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* compiled from: UserProfileClient */
public class b {
    @SerializedName("country_id")
    @Expose
    public Long cJs;
    @SerializedName("img_url")
    @Expose
    public String cSc;
    @SerializedName("is_vip")
    @Expose
    public Boolean cSd;
    @SerializedName("is_demo_account")
    @Expose
    public Boolean cSe;
    @SerializedName("selected_asset_id")
    @Expose
    public Integer cSf;
    @SerializedName("selected_option_type")
    @Expose
    public Integer cSg;
    @SerializedName("selected_balance_type")
    @Expose
    public Integer cSh;
    @SerializedName("registration_time")
    @Expose
    public Long cSi;
    @SerializedName("flag")
    @Expose
    public String flag;
    @SerializedName("isSuccessful")
    @Expose
    public Boolean isSuccessful;
    @SerializedName("user_id")
    @Expose
    public Long userId;
    @SerializedName("user_name")
    @Expose
    public String userName;

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (!this.isSuccessful == null ? this.isSuccessful.equals(bVar.isSuccessful) : bVar.isSuccessful == null) {
            return false;
        }
        if (!this.cJs == null ? this.cJs.equals(bVar.cJs) : bVar.cJs == null) {
            return false;
        }
        if (!this.flag == null ? this.flag.equals(bVar.flag) : bVar.flag == null) {
            return false;
        }
        if (!this.cSc == null ? this.cSc.equals(bVar.cSc) : bVar.cSc == null) {
            return false;
        }
        if (!this.cSd == null ? this.cSd.equals(bVar.cSd) : bVar.cSd == null) {
            return false;
        }
        if (!this.cSe == null ? this.cSe.equals(bVar.cSe) : bVar.cSe == null) {
            return false;
        }
        if (!this.cSf == null ? this.cSf.equals(bVar.cSf) : bVar.cSf == null) {
            return false;
        }
        if (!this.cSg == null ? this.cSg.equals(bVar.cSg) : bVar.cSg == null) {
            return false;
        }
        if (!this.cSh == null ? this.cSh.equals(bVar.cSh) : bVar.cSh == null) {
            return false;
        }
        if (!this.cSi == null ? this.cSi.equals(bVar.cSi) : bVar.cSi == null) {
            return false;
        }
        if (!this.userId == null ? this.userId.equals(bVar.userId) : bVar.userId == null) {
            return false;
        }
        if (this.userName != null) {
            z = this.userName.equals(bVar.userName);
        } else if (bVar.userName != null) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (((((((((((((((((((((this.isSuccessful != null ? this.isSuccessful.hashCode() : 0) * 31) + (this.cJs != null ? this.cJs.hashCode() : 0)) * 31) + (this.flag != null ? this.flag.hashCode() : 0)) * 31) + (this.cSc != null ? this.cSc.hashCode() : 0)) * 31) + (this.cSd != null ? this.cSd.hashCode() : 0)) * 31) + (this.cSe != null ? this.cSe.hashCode() : 0)) * 31) + (this.cSf != null ? this.cSf.hashCode() : 0)) * 31) + (this.cSg != null ? this.cSg.hashCode() : 0)) * 31) + (this.cSh != null ? this.cSh.hashCode() : 0)) * 31) + (this.cSi != null ? this.cSi.hashCode() : 0)) * 31) + (this.userId != null ? this.userId.hashCode() : 0)) * 31;
        if (this.userName != null) {
            i = this.userName.hashCode();
        }
        return hashCode + i;
    }
}
