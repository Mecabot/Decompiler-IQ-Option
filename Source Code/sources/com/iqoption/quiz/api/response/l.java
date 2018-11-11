package com.iqoption.quiz.api.response;

import android.support.annotation.NonNull;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.math.BigDecimal;

/* compiled from: User */
public class l {
    public static l diK = new l();
    @SerializedName("avatar")
    @Expose
    private String aWO;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("can_answer")
    @Expose
    private Boolean diL;
    @SerializedName("last_answer")
    @Expose
    private Integer diM;
    @SerializedName("life_count")
    @Expose
    private Integer diN;
    @SerializedName("total_life_count")
    @Expose
    private Integer diO;
    @SerializedName("host")
    @Expose
    private Integer diP;
    @SerializedName("is_watcher")
    @Expose
    private Boolean diQ;
    @SerializedName("watch_count")
    @Expose
    private Integer diR;
    @SerializedName("referral_awarded")
    @Expose
    private Boolean diS;
    @SerializedName("nick_name")
    @Expose
    private String diT;
    @SerializedName("game_points")
    @Expose
    private BigDecimal diU;
    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("locale")
    @Expose
    private String locale;
    @SerializedName("name")
    @Expose
    private String name;

    public long getId() {
        return this.id == null ? 0 : this.id.longValue();
    }

    @NonNull
    public String aAB() {
        return this.diT == null ? "" : this.diT;
    }

    @NonNull
    public String getName() {
        return this.name == null ? "" : this.name;
    }

    public String Wj() {
        return this.aWO;
    }

    public BigDecimal aAC() {
        return this.diU;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        l lVar = (l) obj;
        if (!this.id == null ? this.id.equals(lVar.id) : lVar.id == null) {
            return false;
        }
        if (!this.diL == null ? this.diL.equals(lVar.diL) : lVar.diL == null) {
            return false;
        }
        if (!this.diM == null ? this.diM.equals(lVar.diM) : lVar.diM == null) {
            return false;
        }
        if (!this.code == null ? this.code.equals(lVar.code) : lVar.code == null) {
            return false;
        }
        if (!this.diN == null ? this.diN.equals(lVar.diN) : lVar.diN == null) {
            return false;
        }
        if (!this.diO == null ? this.diO.equals(lVar.diO) : lVar.diO == null) {
            return false;
        }
        if (!this.diP == null ? this.diP.equals(lVar.diP) : lVar.diP == null) {
            return false;
        }
        if (!this.diQ == null ? this.diQ.equals(lVar.diQ) : lVar.diQ == null) {
            return false;
        }
        if (!this.diR == null ? this.diR.equals(lVar.diR) : lVar.diR == null) {
            return false;
        }
        if (!this.diS == null ? this.diS.equals(lVar.diS) : lVar.diS == null) {
            return false;
        }
        if (!this.locale == null ? this.locale.equals(lVar.locale) : lVar.locale == null) {
            return false;
        }
        if (!this.diT == null ? this.diT.equals(lVar.diT) : lVar.diT == null) {
            return false;
        }
        if (!this.name == null ? this.name.equals(lVar.name) : lVar.name == null) {
            return false;
        }
        if (this.aWO != null) {
            z = this.aWO.equals(lVar.aWO);
        } else if (lVar.aWO != null) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (((((((((((((((((((((((((this.id != null ? this.id.hashCode() : 0) * 31) + (this.diL != null ? this.diL.hashCode() : 0)) * 31) + (this.diM != null ? this.diM.hashCode() : 0)) * 31) + (this.code != null ? this.code.hashCode() : 0)) * 31) + (this.diN != null ? this.diN.hashCode() : 0)) * 31) + (this.diO != null ? this.diO.hashCode() : 0)) * 31) + (this.diP != null ? this.diP.hashCode() : 0)) * 31) + (this.diQ != null ? this.diQ.hashCode() : 0)) * 31) + (this.diR != null ? this.diR.hashCode() : 0)) * 31) + (this.diS != null ? this.diS.hashCode() : 0)) * 31) + (this.locale != null ? this.locale.hashCode() : 0)) * 31) + (this.diT != null ? this.diT.hashCode() : 0)) * 31) + (this.name != null ? this.name.hashCode() : 0)) * 31;
        if (this.aWO != null) {
            i = this.aWO.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("User{id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", canAnswer=");
        stringBuilder.append(this.diL);
        stringBuilder.append(", lastAnswer=");
        stringBuilder.append(this.diM);
        stringBuilder.append(", code='");
        stringBuilder.append(this.code);
        stringBuilder.append('\'');
        stringBuilder.append(", lifeCount=");
        stringBuilder.append(this.diN);
        stringBuilder.append(", totalLifeCount=");
        stringBuilder.append(this.diO);
        stringBuilder.append(", host=");
        stringBuilder.append(this.diP);
        stringBuilder.append(", isWatcher=");
        stringBuilder.append(this.diQ);
        stringBuilder.append(", watchCount=");
        stringBuilder.append(this.diR);
        stringBuilder.append(", referralAwarded=");
        stringBuilder.append(this.diS);
        stringBuilder.append(", locale='");
        stringBuilder.append(this.locale);
        stringBuilder.append('\'');
        stringBuilder.append(", nickName='");
        stringBuilder.append(this.diT);
        stringBuilder.append('\'');
        stringBuilder.append(", name='");
        stringBuilder.append(this.name);
        stringBuilder.append('\'');
        stringBuilder.append(", avatar='");
        stringBuilder.append(this.aWO);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
