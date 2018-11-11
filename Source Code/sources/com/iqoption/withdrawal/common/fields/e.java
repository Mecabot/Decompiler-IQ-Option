package com.iqoption.withdrawal.common.fields;

import com.iqoption.microservice.withdraw.response.PayoutFieldType;
import com.iqoption.withdrawal.common.LimitDirection;
import com.iqoption.withdrawal.common.LimitType;
import kotlin.i;

@i(aXC = {1, 1, 11})
public final /* synthetic */ class e {
    public static final /* synthetic */ int[] aoS = new int[LimitType.values().length];
    public static final /* synthetic */ int[] auV = new int[LimitDirection.values().length];
    public static final /* synthetic */ int[] auW = new int[LimitDirection.values().length];
    public static final /* synthetic */ int[] auk = new int[PayoutFieldType.values().length];
    public static final /* synthetic */ int[] cCT = new int[LimitType.values().length];

    static {
        aoS[LimitType.WALLET_AMOUNT.ordinal()] = 1;
        aoS[LimitType.WITHDRAW_METHOD_LIMIT.ordinal()] = 2;
        aoS[LimitType.CARD_REFUND_LIMIT.ordinal()] = 3;
        auk[PayoutFieldType.TEXT.ordinal()] = 1;
        auk[PayoutFieldType.TEXT_AREA.ordinal()] = 2;
        auV[LimitDirection.UPPER.ordinal()] = 1;
        auV[LimitDirection.LOWER.ordinal()] = 2;
        auW[LimitDirection.UPPER.ordinal()] = 1;
        auW[LimitDirection.LOWER.ordinal()] = 2;
        cCT[LimitType.WALLET_AMOUNT.ordinal()] = 1;
        cCT[LimitType.WITHDRAW_METHOD_LIMIT.ordinal()] = 2;
        cCT[LimitType.CARD_REFUND_LIMIT.ordinal()] = 3;
    }
}
