package com.iqoption.verify.status;

import android.support.v4.app.NotificationCompat;
import com.iqoption.mobbtech.connect.response.CardStatus;
import com.iqoption.mobbtech.connect.response.r;
import kotlin.jvm.internal.h;

@kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, aXE = {"Lcom/iqoption/verify/status/VerifyDetailsFragmentFactory;", "", "()V", "newInstance", "Lcom/iqoption/verify/status/BaseVerifyStatusFragment;", "status", "Lcom/iqoption/mobbtech/connect/response/CardStatus;", "IqOption-5.5.1_optionXRelease"})
/* compiled from: VerifyDetailsFragmentFactory.kt */
public final class i {
    public static final i dys = new i();

    private i() {
    }

    public final a f(CardStatus cardStatus) {
        h.e(cardStatus, NotificationCompat.CATEGORY_STATUS);
        if (cardStatus == CardStatus.VERIFIED || cardStatus == CardStatus.DECLINED || r.auZ().contains(cardStatus)) {
            return new m();
        }
        return new g();
    }
}
