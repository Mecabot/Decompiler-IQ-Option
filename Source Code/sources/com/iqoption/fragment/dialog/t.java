package com.iqoption.fragment.dialog;

import android.support.annotation.NonNull;
import com.iqoption.app.managers.r;
import com.iqoption.x.R;
import java.math.BigDecimal;

/* compiled from: OtnEmissionStatisticsExpectedDelegate */
final class t extends r {
    String gF() {
        return "otn_expected-otn-amount";
    }

    t(@NonNull s sVar) {
        super(sVar);
    }

    CharSequence getTitle() {
        return dA(R.string.expected_otn_amount);
    }

    CharSequence ald() {
        return dA(R.string.tokens_to_be_distributed);
    }

    Double ale() {
        return r.GT().Hf();
    }

    Double alf() {
        return r.GT().He();
    }

    BigDecimal alg() {
        return r.GT().Hi();
    }

    BigDecimal alh() {
        return r.GT().Hd();
    }
}
