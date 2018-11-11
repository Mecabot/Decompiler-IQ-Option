package com.iqoption.charttools.model.indicator.constructor;

import com.iqoption.charttools.model.indicator.constructor.InputItem.Type;
import kotlin.i;

@i(aXC = {1, 1, 11})
public final /* synthetic */ class e {
    public static final /* synthetic */ int[] aoS = new int[Type.values().length];
    public static final /* synthetic */ int[] auV = new int[Type.values().length];
    public static final /* synthetic */ int[] auk = new int[Type.values().length];

    static {
        aoS[Type.INT.ordinal()] = 1;
        aoS[Type.DOUBLE.ordinal()] = 2;
        auk[Type.INT.ordinal()] = 1;
        auk[Type.DOUBLE.ordinal()] = 2;
        auV[Type.INT.ordinal()] = 1;
        auV[Type.DOUBLE.ordinal()] = 2;
    }
}
