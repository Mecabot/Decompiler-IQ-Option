package com.iqoption.withdrawal.common.methods;

import io.card.payment.CardType;
import kotlin.i;

@i(aXC = {1, 1, 11})
public final /* synthetic */ class d {
    public static final /* synthetic */ int[] aoS = new int[CardType.values().length];

    static {
        aoS[CardType.VISA.ordinal()] = 1;
        aoS[CardType.MASTERCARD.ordinal()] = 2;
    }
}
