package com.iqoption.welcomeonboarding.registration.currency;

import android.os.Parcelable;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "Lcom/iqoption/welcomeonboarding/registration/currency/CurrencyMenuParams;", "invoke"})
/* compiled from: CurrencyMenuFragment.kt */
final class CurrencyMenuFragment$params$2 extends Lambda implements a<d> {
    final /* synthetic */ c this$0;

    CurrencyMenuFragment$params$2(c cVar) {
        this.this$0 = cVar;
        super(0);
    }

    /* renamed from: aMA */
    public final d invoke() {
        Parcelable parcelable = com.iqoption.core.ext.a.o(this.this$0).getParcelable("ARG_PARAMS");
        if (parcelable != null) {
            return (d) parcelable;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.iqoption.welcomeonboarding.registration.currency.CurrencyMenuParams");
    }
}
