package com.iqoption.deposit;

import kotlin.i;

@i(aXC = {1, 1, 11})
public final /* synthetic */ class j {
    public static final /* synthetic */ int[] aoS = new int[DepositScreenType.values().length];
    public static final /* synthetic */ int[] auV = new int[DepositScreenType.values().length];
    public static final /* synthetic */ int[] auk = new int[DepositScreenType.values().length];

    static {
        aoS[DepositScreenType.DARK_PORTRAIT.ordinal()] = 1;
        aoS[DepositScreenType.LIGHT.ordinal()] = 2;
        auk[DepositScreenType.DARK_PORTRAIT.ordinal()] = 1;
        auk[DepositScreenType.LIGHT.ordinal()] = 2;
        auV[DepositScreenType.DARK_PORTRAIT.ordinal()] = 1;
        auV[DepositScreenType.LIGHT.ordinal()] = 2;
    }
}
