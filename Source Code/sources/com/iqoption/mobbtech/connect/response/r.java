package com.iqoption.mobbtech.connect.response;

import java.util.List;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, aXE = {"PROGRESS_STATUSES", "", "Lcom/iqoption/mobbtech/connect/response/CardStatus;", "getPROGRESS_STATUSES", "()Ljava/util/List;", "IqOption-5.5.1_optionXRelease"})
/* compiled from: VerifyCard.kt */
public final class r {
    private static final List<CardStatus> cWc = m.listOf(CardStatus.CALLBACK_WAIT, CardStatus.VERIFY_PENDING);

    public static final List<CardStatus> auZ() {
        return cWc;
    }
}
