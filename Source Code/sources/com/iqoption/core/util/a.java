package com.iqoption.core.util;

import io.card.payment.CardType;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, aXE = {"Lcom/iqoption/core/util/CardTypeUtils;", "", "()V", "fromCardNumberSafe", "Lio/card/payment/CardType;", "number", "", "core_release"})
/* compiled from: CardTypeUtils.kt */
public final class a {
    public static final a bgB = new a();

    private a() {
    }

    public static final CardType gV(String str) {
        h.e(str, "number");
        try {
            return CardType.fromCardNumber(str);
        } catch (Exception unused) {
            CardType cardType = ((((CharSequence) str).length() > 0 ? 1 : null) == null || str.charAt(0) != '4') ? null : CardType.VISA;
            return cardType;
        }
    }
}
