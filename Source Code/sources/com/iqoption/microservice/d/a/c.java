package com.iqoption.microservice.d.a;

import com.google.gson.annotations.SerializedName;
import java.math.BigDecimal;

/* compiled from: OtnEmissionSummary */
public final class c {
    @SerializedName("total_coins")
    private BigDecimal cSs;
    @SerializedName("total_emitted")
    private BigDecimal cSt;
    @SerializedName("last_emission")
    private BigDecimal cSu;
    @SerializedName("next_emission")
    private BigDecimal cSv;

    public BigDecimal asS() {
        return this.cSs == null ? BigDecimal.ZERO : this.cSs.scaleByPowerOfTen(-18);
    }

    public BigDecimal Hh() {
        return this.cSt == null ? BigDecimal.ZERO : this.cSt.scaleByPowerOfTen(-18);
    }

    public BigDecimal Hj() {
        return this.cSu == null ? BigDecimal.ZERO : this.cSu.scaleByPowerOfTen(-18);
    }

    public BigDecimal Hi() {
        return this.cSv == null ? BigDecimal.ZERO : this.cSv.scaleByPowerOfTen(-18);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("OtnEmissionSummary{totalEmitted=");
        stringBuilder.append(this.cSt);
        stringBuilder.append(", lastEmission=");
        stringBuilder.append(this.cSu);
        stringBuilder.append(", nextEmission=");
        stringBuilder.append(this.cSv);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
