package com.iqoption.fragment.leftmenu;

import com.iqoption.microservice.regulators.response.StatusType;
import kotlin.i;

@i(aXC = {1, 1, 11})
public final /* synthetic */ class j {
    public static final /* synthetic */ int[] aoS = new int[StatusType.values().length];
    public static final /* synthetic */ int[] auV = new int[StatusType.values().length];
    public static final /* synthetic */ int[] auW = new int[StatusType.values().length];
    public static final /* synthetic */ int[] auk = new int[StatusType.values().length];
    public static final /* synthetic */ int[] cCT = new int[StatusType.values().length];

    static {
        aoS[StatusType.DECLINED.ordinal()] = 1;
        aoS[StatusType.PENDING.ordinal()] = 2;
        aoS[StatusType.APPROVED.ordinal()] = 3;
        auk[StatusType.DECLINED.ordinal()] = 1;
        auk[StatusType.PENDING.ordinal()] = 2;
        auk[StatusType.APPROVED.ordinal()] = 3;
        auV[StatusType.PENDING.ordinal()] = 1;
        auV[StatusType.DECLINED.ordinal()] = 2;
        auW[StatusType.DECLINED.ordinal()] = 1;
        cCT[StatusType.PENDING.ordinal()] = 1;
        cCT[StatusType.DECLINED.ordinal()] = 2;
    }
}
