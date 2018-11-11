package com.iqoption.quiz.api.response;

import android.support.annotation.NonNull;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.iqoption.quiz.aj;

/* compiled from: UserResponse */
public class o {
    public static o diV = new o();
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
    @SerializedName("nick_name")
    @Expose
    private String diW;
    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("name")
    @Expose
    private String name;

    public o a(o oVar) {
        if (oVar.id != null) {
            this.id = oVar.id;
        }
        if (oVar.code != null) {
            this.code = oVar.code;
        }
        if (oVar.diP != null) {
            this.diP = oVar.diP;
        }
        if (oVar.diN != null) {
            this.diN = oVar.diN;
        }
        if (oVar.diO != null) {
            this.diO = oVar.diO;
        }
        if (oVar.diM != null) {
            this.diM = oVar.diM;
        }
        if (oVar.diL != null) {
            this.diL = oVar.diL;
        }
        if (oVar.diQ != null) {
            this.diQ = oVar.diQ;
        }
        if (oVar.diR != null) {
            this.diR = oVar.diR;
        }
        if (oVar.name != null) {
            this.name = oVar.name;
        }
        if (oVar.diW != null) {
            this.diW = oVar.diW;
        }
        return this;
    }

    @NonNull
    public String getCode() {
        return aj.dhZ.jc(this.code);
    }

    public int aAE() {
        return this.diN == null ? 0 : this.diN.intValue();
    }

    public int aAF() {
        return this.diO == null ? 0 : this.diO.intValue();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UserResponse{id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", code='");
        stringBuilder.append(this.code);
        stringBuilder.append('\'');
        stringBuilder.append(", host=");
        stringBuilder.append(this.diP);
        stringBuilder.append(", lifeCount=");
        stringBuilder.append(this.diN);
        stringBuilder.append(", totalLifeCount=");
        stringBuilder.append(this.diO);
        stringBuilder.append(", lastAnswer=");
        stringBuilder.append(this.diM);
        stringBuilder.append(", canAnswer=");
        stringBuilder.append(this.diL);
        stringBuilder.append(", isWatcher=");
        stringBuilder.append(this.diQ);
        stringBuilder.append(", watchCount=");
        stringBuilder.append(this.diR);
        stringBuilder.append(", name='");
        stringBuilder.append(this.name);
        stringBuilder.append('\'');
        stringBuilder.append(", nick='");
        stringBuilder.append(this.diW);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
