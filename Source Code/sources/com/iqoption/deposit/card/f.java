package com.iqoption.deposit.card;

import com.iqoption.core.ui.Status;
import kotlin.i;

@i(aXC = {1, 1, 11})
public final /* synthetic */ class f {
    public static final /* synthetic */ int[] aoS = new int[Status.values().length];

    static {
        aoS[Status.LOADING.ordinal()] = 1;
        aoS[Status.ERROR.ordinal()] = 2;
        aoS[Status.SUCCESS.ordinal()] = 3;
    }
}
