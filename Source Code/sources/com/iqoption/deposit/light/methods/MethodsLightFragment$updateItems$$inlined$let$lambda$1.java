package com.iqoption.deposit.light.methods;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.iqoption.core.microservices.billing.response.deposit.PayMethod;
import com.iqoption.core.microservices.billing.response.deposit.e;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, aXE = {"<anonymous>", "Lcom/iqoption/deposit/menu/method/MethodAdapterItem;", "method", "Lcom/iqoption/core/microservices/billing/response/deposit/PayMethod;", "invoke", "com/iqoption/deposit/light/methods/MethodsLightFragment$updateItems$1$methodItems$1"})
/* compiled from: MethodsLightFragment.kt */
final class MethodsLightFragment$updateItems$$inlined$let$lambda$1 extends Lambda implements b<PayMethod, com.iqoption.deposit.menu.method.b> {
    final /* synthetic */ boolean $isKycLimitEnabled;
    final /* synthetic */ e this$0;

    MethodsLightFragment$updateItems$$inlined$let$lambda$1(boolean z, e eVar) {
        this.$isKycLimitEnabled = z;
        this.this$0 = eVar;
        super(1);
    }

    /* renamed from: l */
    public final com.iqoption.deposit.menu.method.b invoke(PayMethod payMethod) {
        h.e(payMethod, FirebaseAnalytics.b.METHOD);
        return new com.iqoption.deposit.menu.method.b(payMethod, this.$isKycLimitEnabled, h.E(this.this$0.caX, e.e(payMethod)), e.e(this.this$0).m(payMethod));
    }
}
