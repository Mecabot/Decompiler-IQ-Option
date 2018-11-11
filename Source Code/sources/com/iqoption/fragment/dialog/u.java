package com.iqoption.fragment.dialog;

import android.os.Bundle;
import android.support.annotation.NonNull;
import com.iqoption.app.managers.r;
import com.iqoption.x.R;
import java.math.BigDecimal;

/* compiled from: OtnEmissionStatisticsReceivedDelegate */
final class u extends r {
    private final Double cAN;
    private final Double cAO;
    private final BigDecimal cAV;

    String gF() {
        return "otn_receive-tokens-info-calculated";
    }

    u(@NonNull s sVar, @NonNull Bundle bundle) {
        BigDecimal bigDecimal;
        super(sVar);
        this.cAN = Double.valueOf(bundle.getDouble("arg.totalCommission"));
        this.cAO = Double.valueOf(bundle.getDouble("arg.yourCommission"));
        try {
            bigDecimal = new BigDecimal(bundle.getDouble("arg.otnAmount"));
        } catch (NumberFormatException unused) {
            bigDecimal = BigDecimal.ZERO;
        }
        this.cAV = bigDecimal;
    }

    CharSequence getTitle() {
        return dA(R.string.received_otn_amount);
    }

    CharSequence ald() {
        return dA(R.string.tokens_distributed);
    }

    Double ale() {
        return this.cAN;
    }

    Double alf() {
        return this.cAO;
    }

    BigDecimal alg() {
        return r.GT().Hj();
    }

    BigDecimal alh() {
        return this.cAV;
    }
}
