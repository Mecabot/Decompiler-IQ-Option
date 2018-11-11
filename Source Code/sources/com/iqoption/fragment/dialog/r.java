package com.iqoption.fragment.dialog;

import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import java.math.BigDecimal;

/* compiled from: OtnEmissionStatisticsDelegate */
abstract class r {
    private final s cAH;

    abstract CharSequence ald();

    abstract Double ale();

    abstract Double alf();

    abstract BigDecimal alg();

    abstract BigDecimal alh();

    abstract String gF();

    abstract CharSequence getTitle();

    r(@NonNull s sVar) {
        this.cAH = sVar;
    }

    protected final CharSequence dA(@StringRes int i) {
        return this.cAH.getString(i);
    }
}
