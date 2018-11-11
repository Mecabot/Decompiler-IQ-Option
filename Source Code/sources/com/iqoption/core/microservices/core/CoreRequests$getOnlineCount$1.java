package com.iqoption.core.microservices.core;

import com.iqoption.core.f;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "Lcom/iqoption/core/microservices/core/response/OnlineCountResponses;", "it", "", "invoke"})
/* compiled from: CoreRequests.kt */
final class CoreRequests$getOnlineCount$1 extends Lambda implements b<String, com.iqoption.core.microservices.core.a.b> {
    public static final CoreRequests$getOnlineCount$1 aVy = new CoreRequests$getOnlineCount$1();

    CoreRequests$getOnlineCount$1() {
        super(1);
    }

    /* renamed from: gD */
    public final com.iqoption.core.microservices.core.a.b invoke(String str) {
        h.e(str, "it");
        return (com.iqoption.core.microservices.core.a.b) f.RQ().Dq().fromJson(str, com.iqoption.core.microservices.core.a.b.class);
    }
}
