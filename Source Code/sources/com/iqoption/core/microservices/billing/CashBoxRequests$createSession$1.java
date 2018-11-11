package com.iqoption.core.microservices.billing;

import com.iqoption.core.ext.d;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "Lcom/iqoption/core/microservices/billing/response/CreateSessionResult;", "it", "", "invoke"})
/* compiled from: CashBoxRequests.kt */
final class CashBoxRequests$createSession$1 extends Lambda implements b<String, com.iqoption.core.microservices.billing.response.b> {
    public static final CashBoxRequests$createSession$1 aTa = new CashBoxRequests$createSession$1();

    CashBoxRequests$createSession$1() {
        super(1);
    }

    /* renamed from: gx */
    public final com.iqoption.core.microservices.billing.response.b invoke(String str) {
        h.e(str, "it");
        return (com.iqoption.core.microservices.billing.response.b) d.b(str, com.iqoption.core.microservices.billing.response.b.class, null, 2, null);
    }
}
