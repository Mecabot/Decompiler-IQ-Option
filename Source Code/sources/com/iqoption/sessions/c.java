package com.iqoption.sessions;

import com.iqoption.core.ui.Status;
import kotlin.i;

@i(aXC = {1, 1, 11})
public final /* synthetic */ class c {
    public static final /* synthetic */ int[] aoS = new int[Status.values().length];
    public static final /* synthetic */ int[] auk = new int[Status.values().length];

    static {
        aoS[Status.SUCCESS.ordinal()] = 1;
        aoS[Status.ERROR.ordinal()] = 2;
        aoS[Status.LOADING.ordinal()] = 3;
        auk[Status.SUCCESS.ordinal()] = 1;
        auk[Status.ERROR.ordinal()] = 2;
        auk[Status.LOADING.ordinal()] = 3;
    }
}
