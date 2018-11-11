package com.iqoption.dto;

import com.google.common.base.e;
import com.google.common.base.j;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "input", "Lcom/iqoption/dto/Balance;", "apply"})
/* compiled from: Balance.kt */
final class Balance$Companion$getOtnBalance$1<T> implements j<Balance> {
    public static final Balance$Companion$getOtnBalance$1 INSTANCE = new Balance$Companion$getOtnBalance$1();

    Balance$Companion$getOtnBalance$1() {
    }

    public final boolean apply(Balance balance) {
        Object obj = null;
        Integer num = (Integer) e.h(balance != null ? balance.type : null, Integer.valueOf(0));
        if (num == null || num.intValue() != 5) {
            return false;
        }
        if (balance != null) {
            obj = balance.currency;
        }
        return u.m((String) e.h(obj, ""), Currencies.OTN_CURRENCY, true);
    }
}
