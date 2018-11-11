package com.iqoption.dto.event;

import com.google.gson.annotations.SerializedName;
import java.math.BigDecimal;

public final class OtnEmissionExecuted {
    public static final String COMMISSION_VOLUME_ENROLLED = "commission_volume_enrolled";
    public static final String COUNT = "count";
    private static final int SCALE = -18;
    public static final String TOTAL_COMMISSIONS_ENROLLED = "total_commissions_enrolled";
    @SerializedName("commission_volume_enrolled")
    private double commissionVolumeEnrolled;
    @SerializedName("count")
    private BigDecimal count;
    @SerializedName("date")
    private long time;
    @SerializedName("total_commissions_enrolled")
    private double totalCommissionEnrolled;

    public OtnEmissionExecuted(String str, double d) {
        try {
            this.count = new BigDecimal(str);
        } catch (Exception unused) {
            this.count = null;
        }
        this.commissionVolumeEnrolled = d;
    }

    public long getTime() {
        return this.time;
    }

    public BigDecimal getCount() {
        return this.count.scaleByPowerOfTen(SCALE);
    }

    public double getCommissionVolumeEnrolled() {
        return this.commissionVolumeEnrolled;
    }

    public double getTotalCommissionEnrolled() {
        return this.totalCommissionEnrolled;
    }

    public static double parseCount(String str) {
        return new BigDecimal(str).scaleByPowerOfTen(SCALE).doubleValue();
    }
}
