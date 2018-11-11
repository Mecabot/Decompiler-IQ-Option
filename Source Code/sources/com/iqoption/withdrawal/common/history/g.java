package com.iqoption.withdrawal.common.history;

import com.iqoption.microservice.withdraw.response.Status;
import kotlin.i;

@i(aXC = {1, 1, 11})
public final /* synthetic */ class g {
    public static final /* synthetic */ int[] aoS = new int[Status.values().length];

    static {
        aoS[Status.STATUS_NEW.ordinal()] = 1;
        aoS[Status.OP_CREATING.ordinal()] = 2;
        aoS[Status.PROCESSING_READY.ordinal()] = 3;
        aoS[Status.CALLBACK_WAIT.ordinal()] = 4;
        aoS[Status.ANSWER_RECEIVED.ordinal()] = 5;
        aoS[Status.KYC_CHECKING.ordinal()] = 6;
        aoS[Status.APPROVE_REQUIRED.ordinal()] = 7;
        aoS[Status.APPROVE_PROCESSING.ordinal()] = 8;
        aoS[Status.PENDING.ordinal()] = 9;
        aoS[Status.PROCESSING_STARTED.ordinal()] = 10;
        aoS[Status.FAILED.ordinal()] = 11;
        aoS[Status.PROCESSING_FAILED.ordinal()] = 12;
        aoS[Status.SUCCESS.ordinal()] = 13;
        aoS[Status.SUCCESS_PROCESSING.ordinal()] = 14;
        aoS[Status.DECLINED.ordinal()] = 15;
        aoS[Status.CANCELED.ordinal()] = 16;
        aoS[Status.CANCEL_PROCESSING.ordinal()] = 17;
    }
}
