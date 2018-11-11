package com.iqoption.verify.status;

import com.iqoption.mobbtech.connect.response.DeclineReason;
import kotlin.i;

@i(aXC = {1, 1, 11})
public final /* synthetic */ class d {
    public static final /* synthetic */ int[] aoS = new int[DeclineReason.values().length];

    static {
        aoS[DeclineReason.CARD_IS_NOT_SIGNED.ordinal()] = 1;
        aoS[DeclineReason.THERE_IS_NO_BACKSIDE.ordinal()] = 2;
        aoS[DeclineReason.NO_FRONT_SIDE.ordinal()] = 3;
        aoS[DeclineReason.BLACK_AND_WHITE_COPY.ordinal()] = 4;
        aoS[DeclineReason.WRONG_CARD.ordinal()] = 5;
        aoS[DeclineReason.COPY_IS_BLURRY.ordinal()] = 6;
        aoS[DeclineReason.INFO_IS_HIDDEN.ordinal()] = 7;
    }
}
