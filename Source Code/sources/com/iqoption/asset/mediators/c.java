package com.iqoption.asset.mediators;

import com.iqoption.core.data.model.InstrumentType;
import kotlin.i;

@i(aXC = {1, 1, 11})
public final /* synthetic */ class c {
    public static final /* synthetic */ int[] aoS = new int[InstrumentType.values().length];

    static {
        aoS[InstrumentType.FX_INSTRUMENT.ordinal()] = 1;
        aoS[InstrumentType.DIGITAL_INSTRUMENT.ordinal()] = 2;
        aoS[InstrumentType.BINARY_INSTRUMENT.ordinal()] = 3;
        aoS[InstrumentType.TURBO_INSTRUMENT.ordinal()] = 4;
    }
}
