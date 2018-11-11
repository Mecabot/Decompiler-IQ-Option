package com.iqoption.dto;

import com.google.common.base.d;
import com.google.common.base.e;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, aXE = {"<anonymous>", "", "kotlin.jvm.PlatformType", "input", "Lcom/iqoption/dto/Balance;", "apply", "(Lcom/iqoption/dto/Balance;)Ljava/lang/Double;"})
/* compiled from: Balance.kt */
final class Balance$Companion$getBalanceValue$1<F, T> implements d<Balance, Double> {
    public static final Balance$Companion$getBalanceValue$1 INSTANCE = new Balance$Companion$getBalanceValue$1();

    Balance$Companion$getBalanceValue$1() {
    }

    public final Double apply(Balance balance) {
        return (Double) e.h(balance != null ? balance.amount : null, Double.valueOf(0.0d));
    }
}
