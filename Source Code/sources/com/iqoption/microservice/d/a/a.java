package com.iqoption.microservice.d.a;

import com.google.gson.annotations.SerializedName;
import java.math.BigDecimal;

/* compiled from: OtnCoinBalance */
public final class a {
    @SerializedName("coins")
    private BigDecimal cSn;
    @SerializedName("potential_coins")
    private BigDecimal cSo;
    @SerializedName("commission_volume_enrolled")
    private Double cSp;
    @SerializedName("total_commission_volume_enrolled")
    private Double cSq;

    public BigDecimal asO() {
        return this.cSn == null ? BigDecimal.ZERO : this.cSn.scaleByPowerOfTen(-18);
    }

    public BigDecimal Hd() {
        return this.cSo == null ? BigDecimal.ZERO : this.cSo.scaleByPowerOfTen(-18);
    }

    public Double asP() {
        return this.cSp;
    }

    public Double asQ() {
        return this.cSq;
    }

    public void c(BigDecimal bigDecimal) {
        if (bigDecimal != null) {
            this.cSn = bigDecimal.scaleByPowerOfTen(18);
        } else {
            this.cSn = null;
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("OtnCoinBalance{coins=");
        stringBuilder.append(this.cSn);
        stringBuilder.append(", potentialCoins=");
        stringBuilder.append(this.cSo);
        stringBuilder.append(", commissionVolumeEnrolled=");
        stringBuilder.append(this.cSp);
        stringBuilder.append(", totalCommissionVolumeEnrolled=");
        stringBuilder.append(this.cSq);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public void k(Double d) {
        this.cSq = d;
    }

    public void l(Double d) {
        this.cSp = d;
    }
}
