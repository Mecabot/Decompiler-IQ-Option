package com.iqoption.operations;

import com.iqoption.operations.OperationViewModel.FilterType;
import kotlin.i;

@i(aXC = {1, 1, 11})
public final /* synthetic */ class k {
    public static final /* synthetic */ int[] aoS = new int[FilterType.values().length];

    static {
        aoS[FilterType.DATE.ordinal()] = 1;
        aoS[FilterType.OPERATION.ordinal()] = 2;
        aoS[FilterType.STATUS.ordinal()] = 3;
    }
}
