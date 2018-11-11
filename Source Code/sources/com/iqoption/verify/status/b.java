package com.iqoption.verify.status;

import com.iqoption.mobbtech.connect.response.CardStatus;
import kotlin.i;

@i(aXC = {1, 1, 11})
public final /* synthetic */ class b {
    public static final /* synthetic */ int[] aoS = new int[CardStatus.values().length];

    static {
        aoS[CardStatus.VERIFIED.ordinal()] = 1;
        aoS[CardStatus.DECLINED.ordinal()] = 2;
    }
}
