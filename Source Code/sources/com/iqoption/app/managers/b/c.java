package com.iqoption.app.managers.b;

import com.iqoption.core.data.model.InstrumentType;
import kotlin.i;

@i(aXC = {1, 1, 11})
public final /* synthetic */ class c {
    public static final /* synthetic */ int[] aoS = new int[InstrumentType.values().length];

    static {
        aoS[InstrumentType.FOREX_INSTRUMENT.ordinal()] = 1;
        aoS[InstrumentType.CFD_INSTRUMENT.ordinal()] = 2;
        aoS[InstrumentType.CRYPTO_INSTRUMENT.ordinal()] = 3;
    }
}
