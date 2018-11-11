package com.iqoption.mobbtech.connect.response;

import android.support.annotation.Nullable;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.common.base.e;
import com.google.gson.annotations.SerializedName;
import com.iqoption.core.data.model.ActiveType;
import com.iqoption.dto.entity.position.Position;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

/* compiled from: BetInfoResponse */
public class a extends m {
    @SerializedName("result")
    public b cVv;

    /* compiled from: BetInfoResponse */
    public static class a {
        private static final String TAG = "com.iqoption.mobbtech.connect.response.a$a";
        @SerializedName("option_type")
        public ActiveType activeType;
        @SerializedName("balance_id")
        public Long balanceId;
        @SerializedName("buyback_state")
        public String buybackState;
        @SerializedName("deposit")
        public Double cVw;
        @SerializedName("profit")
        public Double cVx;
        @SerializedName("refund")
        public Double cVy;
        @SerializedName("client_platform_id")
        public Integer clientPlatformId;
        @SerializedName("created")
        public Long created;
        @SerializedName("direction")
        public String direction;
        @SerializedName("profit_income")
        public Long profitIncome;
        @SerializedName("value")
        public Double value;
        @SerializedName("win")
        public String win;

        public String toString() {
            return e.B(this).d("deposit", this.cVw).d(com.google.firebase.analytics.FirebaseAnalytics.b.VALUE, this.value).d("profit", this.cVx).d("direction", this.direction).d("created", this.created).d("created", this.created).d(ProductAction.ACTION_REFUND, this.cVy).d("profitIncome", this.profitIncome).d(Param.TYPE, this.activeType).d("balanceId", this.balanceId).d("win", this.win).d("buybackState", this.buybackState).d("clientPlatformId", this.clientPlatformId).toString();
        }
    }

    /* compiled from: BetInfoResponse */
    public static class b {
        @SerializedName("data")
        public HashMap<Long, a> aXJ;
        @SerializedName("active")
        public String active;
        @SerializedName("active_id")
        public Integer activeId;
        @SerializedName("exp_value")
        public Double expValue;
        @SerializedName("expired")
        public Long expired;

        public String toString() {
            return e.B(this).d("expValue", this.expValue).d(Position.CLOSE_REASON_EXPIRED, this.expired).d("active", this.active).d("data", this.aXJ).toString();
        }

        @Nullable
        public a bG(long j) {
            return (this.aXJ == null || !this.aXJ.containsKey(Long.valueOf(j))) ? null : (a) this.aXJ.get(Long.valueOf(j));
        }

        public Collection<Long> auP() {
            return this.aXJ == null ? Collections.emptySet() : this.aXJ.keySet();
        }
    }

    public String toString() {
        return e.B(this).d("super", super.toString()).d("result", this.cVv).toString();
    }
}
