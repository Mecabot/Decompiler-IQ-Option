package com.iqoption.deposit.light.methods;

import com.iqoption.deposit.time.MethodTimeUnit;
import kotlin.i;

@i(aXC = {1, 1, 11})
public final /* synthetic */ class f {
    public static final /* synthetic */ int[] aoS = new int[MethodTimeUnit.values().length];

    static {
        aoS[MethodTimeUnit.MINUTES.ordinal()] = 1;
        aoS[MethodTimeUnit.HOURS.ordinal()] = 2;
        aoS[MethodTimeUnit.DAYS.ordinal()] = 3;
    }
}
