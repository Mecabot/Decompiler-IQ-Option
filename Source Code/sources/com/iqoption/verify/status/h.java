package com.iqoption.verify.status;

import kotlin.i;

@i(aXC = {1, 1, 11})
public final /* synthetic */ class h {
    public static final /* synthetic */ int[] aoS = new int[CardSide.values().length];
    public static final /* synthetic */ int[] auk = new int[CardSide.values().length];

    static {
        aoS[CardSide.FRONT.ordinal()] = 1;
        aoS[CardSide.BACK.ordinal()] = 2;
        auk[CardSide.FRONT.ordinal()] = 1;
        auk[CardSide.BACK.ordinal()] = 2;
        auk[CardSide.NONE.ordinal()] = 3;
    }
}
