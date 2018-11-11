package com.iqoption.core.microservices.billing;

import com.iqoption.core.ext.d;
import com.iqoption.core.microservices.billing.response.a;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "Lcom/iqoption/core/microservices/billing/response/CashboxResult;", "it", "", "invoke"})
/* compiled from: CashBoxRequests.kt */
final class CashBoxRequests$getCashBoxCounting$1 extends Lambda implements b<String, a> {
    public static final CashBoxRequests$getCashBoxCounting$1 aTb = new CashBoxRequests$getCashBoxCounting$1();

    CashBoxRequests$getCashBoxCounting$1() {
        super(1);
    }

    /* renamed from: gy */
    public final a invoke(String str) {
        h.e(str, "it");
        return (a) d.b(str, a.class, null, 2, null);
    }
}
