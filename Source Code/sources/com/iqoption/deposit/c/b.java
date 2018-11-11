package com.iqoption.deposit.c;

import io.card.payment.CardType;
import kotlin.i;

@i(aXC = {1, 1, 11})
public final /* synthetic */ class b {
    public static final /* synthetic */ int[] aoS = new int[CardType.values().length];

    static {
        aoS[CardType.VISA.ordinal()] = 1;
        aoS[CardType.MASTERCARD.ordinal()] = 2;
        aoS[CardType.AMEX.ordinal()] = 3;
        aoS[CardType.DISCOVER.ordinal()] = 4;
        aoS[CardType.JCB.ordinal()] = 5;
    }
}
