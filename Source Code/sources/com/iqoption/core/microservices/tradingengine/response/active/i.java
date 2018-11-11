package com.iqoption.core.microservices.tradingengine.response.active;

import com.iqoption.core.data.model.InstrumentType;

@kotlin.i(aXC = {1, 1, 11})
public final /* synthetic */ class i {
    public static final /* synthetic */ int[] aoS = new int[InstrumentType.values().length];

    static {
        aoS[InstrumentType.DIGITAL_INSTRUMENT.ordinal()] = 1;
        aoS[InstrumentType.FX_INSTRUMENT.ordinal()] = 2;
    }
}
