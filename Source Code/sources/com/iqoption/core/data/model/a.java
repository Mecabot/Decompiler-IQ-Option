package com.iqoption.core.data.model;

import kotlin.i;

@i(aXC = {1, 1, 11})
public final /* synthetic */ class a {
    public static final /* synthetic */ int[] aoS = new int[ActiveType.values().length];

    static {
        aoS[ActiveType.TURBO_ACTIVE.ordinal()] = 1;
        aoS[ActiveType.BINARY_ACTIVE.ordinal()] = 2;
        aoS[ActiveType.DIGITAL_ACTIVE.ordinal()] = 3;
        aoS[ActiveType.FX_ACTIVE.ordinal()] = 4;
        aoS[ActiveType.FOREX_ACTIVE.ordinal()] = 5;
        aoS[ActiveType.CRYPTO_ACTIVE.ordinal()] = 6;
        aoS[ActiveType.STOCK_ACTIVE.ordinal()] = 7;
        aoS[ActiveType.COMMODITY_ACTIVE.ordinal()] = 8;
        aoS[ActiveType.ETF_ACTIVE.ordinal()] = 9;
        aoS[ActiveType.BOND_ACTIVE.ordinal()] = 10;
        aoS[ActiveType.INDEX_ACTIVE.ordinal()] = 11;
    }
}
