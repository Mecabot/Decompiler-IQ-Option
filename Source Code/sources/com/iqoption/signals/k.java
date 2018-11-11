package com.iqoption.signals;

import kotlin.i;

@i(aXC = {1, 1, 11})
public final /* synthetic */ class k {
    public static final /* synthetic */ int[] aoS = new int[SignalFilter.values().length];

    static {
        aoS[SignalFilter.ALL.ordinal()] = 1;
        aoS[SignalFilter.GAP.ordinal()] = 2;
        aoS[SignalFilter.SHARP_JUMP.ordinal()] = 3;
    }
}
