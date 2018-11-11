package com.iqoption.protrader;

import com.iqoption.microservice.regulators.response.StatusType;
import kotlin.i;

@i(aXC = {1, 1, 11})
public final /* synthetic */ class d {
    public static final /* synthetic */ int[] aoS = new int[StatusType.values().length];
    public static final /* synthetic */ int[] auV = new int[StatusType.values().length];
    public static final /* synthetic */ int[] auk = new int[StatusType.values().length];

    static {
        aoS[StatusType.APPROVED.ordinal()] = 1;
        aoS[StatusType.DECLINED.ordinal()] = 2;
        auk[StatusType.APPROVED.ordinal()] = 1;
        auk[StatusType.DECLINED.ordinal()] = 2;
        auV[StatusType.APPROVED.ordinal()] = 1;
        auV[StatusType.DECLINED.ordinal()] = 2;
    }
}
