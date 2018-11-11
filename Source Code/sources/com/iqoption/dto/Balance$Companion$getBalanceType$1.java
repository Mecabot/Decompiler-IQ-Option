package com.iqoption.dto;

import com.google.common.base.d;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, aXE = {"<anonymous>", "", "input", "Lcom/iqoption/dto/Balance;", "apply", "(Lcom/iqoption/dto/Balance;)Ljava/lang/Integer;"})
/* compiled from: Balance.kt */
final class Balance$Companion$getBalanceType$1<F, T> implements d<Balance, Integer> {
    public static final Balance$Companion$getBalanceType$1 INSTANCE = new Balance$Companion$getBalanceType$1();

    Balance$Companion$getBalanceType$1() {
    }

    public final Integer apply(Balance balance) {
        return balance != null ? balance.type : null;
    }
}
