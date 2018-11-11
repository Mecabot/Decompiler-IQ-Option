package com.iqoption.deposit.complete;

import android.os.Parcelable;
import com.iqoption.core.microservices.billing.response.deposit.c;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "Lcom/iqoption/core/microservices/billing/response/deposit/CurrencyBilling;", "invoke"})
/* compiled from: BaseCompletePaymentFragment.kt */
final class BaseCompletePaymentFragment$currency$2 extends Lambda implements a<c> {
    final /* synthetic */ a this$0;

    BaseCompletePaymentFragment$currency$2(a aVar) {
        this.this$0 = aVar;
        super(0);
    }

    /* renamed from: abN */
    public final c invoke() {
        Parcelable parcelable = com.iqoption.core.ext.a.o(this.this$0).getParcelable("ARG_CURRENCY");
        if (parcelable != null) {
            return (c) parcelable;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.iqoption.core.microservices.billing.response.deposit.CurrencyBilling");
    }
}
