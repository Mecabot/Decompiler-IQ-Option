package com.iqoption.util.e;

import com.iqoption.core.data.model.ActiveType;
import com.iqoption.core.data.model.InstrumentType;
import kotlin.i;

@i(aXC = {1, 1, 11})
public final /* synthetic */ class b {
    public static final /* synthetic */ int[] aoS = new int[InstrumentType.values().length];
    public static final /* synthetic */ int[] auk = new int[ActiveType.values().length];

    static {
        aoS[InstrumentType.TURBO_INSTRUMENT.ordinal()] = 1;
        aoS[InstrumentType.BINARY_INSTRUMENT.ordinal()] = 2;
        aoS[InstrumentType.DIGITAL_INSTRUMENT.ordinal()] = 3;
        aoS[InstrumentType.FOREX_INSTRUMENT.ordinal()] = 4;
        aoS[InstrumentType.CRYPTO_INSTRUMENT.ordinal()] = 5;
        aoS[InstrumentType.FX_INSTRUMENT.ordinal()] = 6;
        aoS[InstrumentType.CFD_INSTRUMENT.ordinal()] = 7;
        auk[ActiveType.TURBO_ACTIVE.ordinal()] = 1;
        auk[ActiveType.BINARY_ACTIVE.ordinal()] = 2;
        auk[ActiveType.DIGITAL_ACTIVE.ordinal()] = 3;
        auk[ActiveType.FOREX_ACTIVE.ordinal()] = 4;
        auk[ActiveType.CRYPTO_ACTIVE.ordinal()] = 5;
        auk[ActiveType.FX_ACTIVE.ordinal()] = 6;
        auk[ActiveType.COMMODITY_ACTIVE.ordinal()] = 7;
        auk[ActiveType.STOCK_ACTIVE.ordinal()] = 8;
        auk[ActiveType.ETF_ACTIVE.ordinal()] = 9;
        auk[ActiveType.INDEX_ACTIVE.ordinal()] = 10;
        auk[ActiveType.BOND_ACTIVE.ordinal()] = 11;
    }
}
