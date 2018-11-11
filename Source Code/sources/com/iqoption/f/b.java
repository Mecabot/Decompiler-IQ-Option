package com.iqoption.f;

import com.iqoption.core.data.model.InstrumentType;
import kotlin.i;

@i(aXC = {1, 1, 11})
public final /* synthetic */ class b {
    public static final /* synthetic */ int[] aoS = new int[InstrumentType.values().length];
    public static final /* synthetic */ int[] auk = new int[InstrumentType.values().length];

    static {
        aoS[InstrumentType.TURBO_INSTRUMENT.ordinal()] = 1;
        aoS[InstrumentType.BINARY_INSTRUMENT.ordinal()] = 2;
        aoS[InstrumentType.DIGITAL_INSTRUMENT.ordinal()] = 3;
        aoS[InstrumentType.FX_INSTRUMENT.ordinal()] = 4;
        auk[InstrumentType.TURBO_INSTRUMENT.ordinal()] = 1;
        auk[InstrumentType.BINARY_INSTRUMENT.ordinal()] = 2;
        auk[InstrumentType.DIGITAL_INSTRUMENT.ordinal()] = 3;
        auk[InstrumentType.FX_INSTRUMENT.ordinal()] = 4;
    }
}
