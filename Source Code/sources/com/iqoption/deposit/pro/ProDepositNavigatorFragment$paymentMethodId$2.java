package com.iqoption.deposit.pro;

import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, aXE = {"<anonymous>", "", "invoke", "()Ljava/lang/Long;"})
/* compiled from: ProDepositNavigatorFragment.kt */
final class ProDepositNavigatorFragment$paymentMethodId$2 extends Lambda implements a<Long> {
    final /* synthetic */ c this$0;

    ProDepositNavigatorFragment$paymentMethodId$2(c cVar) {
        this.this$0 = cVar;
        super(0);
    }

    /* renamed from: aea */
    public final Long invoke() {
        return com.iqoption.core.ext.a.o(this.this$0).containsKey("ARG_PAYMENT_METHOD_ID") ? Long.valueOf(com.iqoption.core.ext.a.o(this.this$0).getLong("ARG_PAYMENT_METHOD_ID", -1)) : null;
    }
}
