package com.iqoption.deposit.complete;

import java.io.Serializable;
import java.math.BigDecimal;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "Ljava/math/BigDecimal;", "invoke"})
/* compiled from: BaseCompletePaymentFragment.kt */
final class BaseCompletePaymentFragment$payAmount$2 extends Lambda implements a<BigDecimal> {
    final /* synthetic */ a this$0;

    BaseCompletePaymentFragment$payAmount$2(a aVar) {
        this.this$0 = aVar;
        super(0);
    }

    /* renamed from: abO */
    public final BigDecimal invoke() {
        Serializable serializable = com.iqoption.core.ext.a.o(this.this$0).getSerializable("ARG_PAY_AMOUNT");
        if (serializable != null) {
            return (BigDecimal) serializable;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.math.BigDecimal");
    }
}
