package com.iqoption.withdrawal.crypto.fragment;

import com.google.common.util.concurrent.g;
import com.google.common.util.concurrent.s;
import com.iqoption.core.microservices.billing.response.b.a;

final /* synthetic */ class c implements g {
    private final double apk;
    private final String arb;
    private final WithdrawalCryptoPagerFragment dTj;
    private final int jH;

    c(WithdrawalCryptoPagerFragment withdrawalCryptoPagerFragment, int i, double d, String str) {
        this.dTj = withdrawalCryptoPagerFragment;
        this.jH = i;
        this.apk = d;
        this.arb = str;
    }

    public s aP(Object obj) {
        return this.dTj.a(this.jH, this.apk, this.arb, (a) obj);
    }
}
