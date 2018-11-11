package com.iqoption.withdrawal.common.history;

import com.iqoption.microservice.withdraw.response.Status;
import java.util.Collection;
import java.util.List;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, aXE = {"CANCELABLE_STATUSES", "", "Lcom/iqoption/microservice/withdraw/response/Status;", "ERROR_COLOR_STATUSES", "ERROR_ICON_STATUSES", "SUCCESS_STATUSES", "IqOption-5.5.1_optionXRelease"})
/* compiled from: WithdrawHistoryHolders.kt */
public final class m {
    private static final List<Status> dRs = m.listOf(Status.SUCCESS, Status.SUCCESS_PROCESSING);
    private static final List<Status> dRt = m.listOf(Status.FAILED, Status.PROCESSING_FAILED, Status.DECLINED, Status.CANCELED, Status.UNKNOWN);
    private static final List<Status> dRu = u.i((Collection) dRt, (Object) Status.CANCEL_PROCESSING);
    private static final List<Status> dRv = m.listOf(Status.PENDING, Status.APPROVE_REQUIRED);
}
