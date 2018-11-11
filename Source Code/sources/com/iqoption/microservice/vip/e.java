package com.iqoption.microservice.vip;

import com.google.common.util.concurrent.s;
import com.iqoption.app.IQApp;
import com.iqoption.mobbtech.connect.request.a.a.b;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J%\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\f¨\u0006\r"}, aXE = {"Lcom/iqoption/microservice/vip/VipManagerRequests;", "", "()V", "getVipManagerInfo", "Lcom/google/common/util/concurrent/ListenableFuture;", "Lcom/iqoption/microservice/vip/VipManagerResponse;", "requestCallBack", "Lcom/iqoption/microservice/vip/BasicResponse;", "time", "", "trainingSessionId", "", "(Ljava/lang/String;Ljava/lang/Long;)Lcom/google/common/util/concurrent/ListenableFuture;", "IqOption-5.5.1_optionXRelease"})
/* compiled from: VipManagerRequests.kt */
public final class e {
    public static final e cTk = new e();

    private e() {
    }

    public final s<f> atr() {
        s<f> auF = b.B(f.class).iF(IQApp.Dl().getClusterApi()).iG("api/getcontactinfo").auF();
        h.d(auF, "RequestTask.httpOf(VipMa…)\n                .exec()");
        return auF;
    }

    public final s<a> c(String str, Long l) {
        b.b iG = b.B(a.class).iF(IQApp.Dl().getClusterApi()).ft(2).iG("api/callbackme");
        if (str != null) {
            iG.n("time", str);
        }
        if (l != null) {
            l.longValue();
            iG.n("trainingSessionId", l);
        }
        s<a> auF = iG.auF();
        h.d(auF, "builder.exec()");
        return auF;
    }
}
