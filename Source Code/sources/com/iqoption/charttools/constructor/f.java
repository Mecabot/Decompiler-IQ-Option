package com.iqoption.charttools.constructor;

import com.iqoption.charttools.model.indicator.constructor.InputItem.Type;
import kotlin.i;

@i(aXC = {1, 1, 11})
public final /* synthetic */ class f {
    public static final /* synthetic */ int[] aoS = new int[Type.values().length];
    public static final /* synthetic */ int[] auk = new int[Type.values().length];

    static {
        aoS[Type.BOOL.ordinal()] = 1;
        aoS[Type.PLOT_VISIBILITY.ordinal()] = 2;
        aoS[Type.INT.ordinal()] = 3;
        aoS[Type.DOUBLE.ordinal()] = 4;
        aoS[Type.STRING.ordinal()] = 5;
        aoS[Type.INT_SELECTION.ordinal()] = 6;
        aoS[Type.DOUBLE_SELECTION.ordinal()] = 7;
        aoS[Type.STRING_SELECTION.ordinal()] = 8;
        aoS[Type.COLOR.ordinal()] = 9;
        aoS[Type.LINE_WIDTH.ordinal()] = 10;
        aoS[Type.HOST.ordinal()] = 11;
        auk[Type.INT.ordinal()] = 1;
        auk[Type.INT_SELECTION.ordinal()] = 2;
        auk[Type.DOUBLE_SELECTION.ordinal()] = 3;
        auk[Type.STRING_SELECTION.ordinal()] = 4;
        auk[Type.LINE_WIDTH.ordinal()] = 5;
        auk[Type.HOST.ordinal()] = 6;
        auk[Type.COLOR.ordinal()] = 7;
        auk[Type.DOUBLE.ordinal()] = 8;
        auk[Type.BOOL.ordinal()] = 9;
        auk[Type.PLOT_VISIBILITY.ordinal()] = 10;
        auk[Type.ACTIVE.ordinal()] = 11;
    }
}
