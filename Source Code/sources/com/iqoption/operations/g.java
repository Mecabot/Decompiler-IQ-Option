package com.iqoption.operations;

import com.iqoption.util.Status;
import kotlin.i;

@i(aXC = {1, 1, 11})
public final /* synthetic */ class g {
    public static final /* synthetic */ int[] aoS = new int[Status.values().length];

    static {
        aoS[Status.SUCCESS.ordinal()] = 1;
        aoS[Status.ERROR.ordinal()] = 2;
        aoS[Status.LOADING.ordinal()] = 3;
    }
}
