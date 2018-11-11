package com.iqoption.deposit.old;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.iqoption.core.microservices.billing.response.deposit.PayMethod;
import com.iqoption.core.microservices.billing.response.deposit.e;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "Lcom/iqoption/deposit/old/PayMethodItem;", "method", "Lcom/iqoption/core/microservices/billing/response/deposit/PayMethod;", "kotlin.jvm.PlatformType", "invoke"})
/* compiled from: PayMethodSelector.kt */
final class PayMethodSelector$setData$items$1 extends Lambda implements b<PayMethod, e> {
    final /* synthetic */ PayMethodSelector this$0;

    PayMethodSelector$setData$items$1(PayMethodSelector payMethodSelector) {
        this.this$0 = payMethodSelector;
        super(1);
    }

    /* renamed from: n */
    public final e invoke(PayMethod payMethod) {
        h.d(payMethod, FirebaseAnalytics.b.METHOD);
        return new e(payMethod, h.E(this.this$0.caX, e.e(payMethod)));
    }
}
