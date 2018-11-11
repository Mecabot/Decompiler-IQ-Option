package com.iqoption.tutorial;

import kotlin.i;

@i(aXC = {1, 1, 11})
public final /* synthetic */ class j {
    public static final /* synthetic */ int[] aoS = new int[ToastType.values().length];
    public static final /* synthetic */ int[] auk = new int[ToastType.values().length];

    static {
        aoS[ToastType.FIRST_DONE.ordinal()] = 1;
        aoS[ToastType.LAST_CLOSED.ordinal()] = 2;
        auk[ToastType.FIRST_DONE.ordinal()] = 1;
        auk[ToastType.LAST_CLOSED.ordinal()] = 2;
    }
}
