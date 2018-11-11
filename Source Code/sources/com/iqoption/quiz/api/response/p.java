package com.iqoption.quiz.api.response;

import android.support.annotation.NonNull;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.iqoption.dto.Currencies;
import com.iqoption.quiz.aj;
import java.math.BigDecimal;

/* compiled from: Winner */
public class p {
    @SerializedName("user")
    @Expose
    private l diA;
    @SerializedName("money")
    @Expose
    private BigDecimal diX;
    private transient String diY = null;
    private transient String diZ = null;
    private transient String dja = null;

    @NonNull
    public l aAt() {
        return this.diA == null ? l.diK : this.diA;
    }

    public BigDecimal aAG() {
        return this.diX == null ? BigDecimal.ZERO : this.diX;
    }

    public BigDecimal aAH() {
        return this.diA == null ? null : this.diA.aAC();
    }

    public void jp(String str) {
        this.diY = aj.dhZ.a(aAG(), 2, str);
    }

    public void aAI() {
        this.diZ = aj.dhZ.a(aAG(), 0, Currencies.REPLACE_CURRENCY_MASK);
    }

    @NonNull
    public String jq(String str) {
        if (this.diY == null) {
            this.diY = aj.dhZ.a(aAG(), 2, str);
        }
        return this.diY;
    }

    @NonNull
    public String aAJ() {
        if (this.diZ == null) {
            this.diZ = aj.dhZ.a(aAG(), 0, Currencies.REPLACE_CURRENCY_MASK);
        }
        return this.diZ;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        p pVar = (p) obj;
        if (!this.diA == null ? this.diA.equals(pVar.diA) : pVar.diA == null) {
            return false;
        }
        if (!this.diX == null ? this.diX.equals(pVar.diX) : pVar.diX == null) {
            return false;
        }
        if (this.diY != null) {
            z = this.diY.equals(pVar.diY);
        } else if (pVar.diY != null) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (((this.diA != null ? this.diA.hashCode() : 0) * 31) + (this.diX != null ? this.diX.hashCode() : 0)) * 31;
        if (this.diY != null) {
            i = this.diY.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Winner{user=");
        stringBuilder.append(this.diA);
        stringBuilder.append(", money=");
        stringBuilder.append(this.diX);
        stringBuilder.append(", formattedAmount='");
        stringBuilder.append(this.diY);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
