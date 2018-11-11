package com.iqoption.quiz.api.response;

import android.support.annotation.NonNull;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

/* compiled from: WinnersResponse */
public class q {
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("money")
    @Expose
    private BigDecimal diX;
    @SerializedName("win_total")
    @Expose
    private Integer djb;
    @SerializedName("winners")
    @Expose
    private List<p> djc = null;

    @NonNull
    public String getCurrency() {
        return this.currency == null ? "" : this.currency;
    }

    @NonNull
    public List<p> aAK() {
        return this.djc == null ? Collections.emptyList() : this.djc;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        q qVar = (q) obj;
        if (!this.diX == null ? this.diX.equals(qVar.diX) : qVar.diX == null) {
            return false;
        }
        if (!this.currency == null ? this.currency.equals(qVar.currency) : qVar.currency == null) {
            return false;
        }
        if (!this.djb == null ? this.djb.equals(qVar.djb) : qVar.djb == null) {
            return false;
        }
        if (this.djc != null) {
            z = this.djc.equals(qVar.djc);
        } else if (qVar.djc != null) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (((((this.diX != null ? this.diX.hashCode() : 0) * 31) + (this.currency != null ? this.currency.hashCode() : 0)) * 31) + (this.djb != null ? this.djb.hashCode() : 0)) * 31;
        if (this.djc != null) {
            i = this.djc.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("WinnersResponse{money=");
        stringBuilder.append(this.diX);
        stringBuilder.append(", currency='");
        stringBuilder.append(this.currency);
        stringBuilder.append('\'');
        stringBuilder.append(", winTotal=");
        stringBuilder.append(this.djb);
        stringBuilder.append(", winners=");
        stringBuilder.append(this.djc);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
