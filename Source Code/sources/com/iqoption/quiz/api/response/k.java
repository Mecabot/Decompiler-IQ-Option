package com.iqoption.quiz.api.response;

import android.support.annotation.NonNull;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.iqoption.quiz.m;

/* compiled from: StatusResponse */
public class k {
    public static k diB = new k() {
        {
            gq(-1);
            eF(false);
            bQ(0);
            eG(false);
            eH(false);
            eJ(false);
            eK(false);
            jb("");
            eI(false);
        }
    };
    @SerializedName("current")
    @Expose
    private Integer diC;
    @SerializedName("show_answers")
    @Expose
    private Boolean diD;
    @SerializedName("on_air")
    @Expose
    private Boolean diE;
    @SerializedName("maintenance")
    @Expose
    private Boolean diF;
    @SerializedName("chat")
    @Expose
    private Boolean diG;
    @SerializedName("winners")
    @Expose
    private Boolean diH;
    @SerializedName("stream")
    @Expose
    private String diI;
    @SerializedName("rules")
    @Expose
    private Boolean diJ;
    @SerializedName("timestamp")
    @Expose
    private Long div;

    public int aAu() {
        return this.diC == null ? -1 : this.diC.intValue();
    }

    public k gq(int i) {
        this.diC = Integer.valueOf(i);
        return this;
    }

    public k eF(boolean z) {
        this.diD = Boolean.valueOf(z);
        return this;
    }

    public k bQ(long j) {
        this.div = Long.valueOf(j);
        return this;
    }

    public boolean aAv() {
        return m.ayY().azn().DG() || (this.diE != null && this.diE.booleanValue());
    }

    public k eG(boolean z) {
        this.diE = Boolean.valueOf(z);
        return this;
    }

    public boolean aAw() {
        return this.diF == null ? false : this.diF.booleanValue();
    }

    public k eH(boolean z) {
        this.diF = Boolean.valueOf(z);
        return this;
    }

    public boolean aAx() {
        return this.diJ == null ? false : this.diJ.booleanValue();
    }

    public k eI(boolean z) {
        this.diJ = Boolean.valueOf(z);
        return this;
    }

    public boolean aAy() {
        return this.diG == null ? false : this.diG.booleanValue();
    }

    public void eJ(boolean z) {
        this.diG = Boolean.valueOf(z);
    }

    public boolean aAz() {
        return this.diH == null ? false : this.diH.booleanValue();
    }

    public void eK(boolean z) {
        this.diH = Boolean.valueOf(z);
    }

    @NonNull
    public String aAA() {
        return this.diI == null ? "" : this.diI;
    }

    public void jb(@NonNull String str) {
        this.diI = str;
    }
}
