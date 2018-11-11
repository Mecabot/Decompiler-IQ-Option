package com.iqoption.deposit.light.menu.currency;

import android.os.Parcelable;
import com.iqoption.deposit.menu.currency.b;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "Lcom/iqoption/deposit/menu/currency/CurrencyMenuParams;", "invoke"})
/* compiled from: CurrencyMenuLightFragment.kt */
final class CurrencyMenuLightFragment$params$2 extends Lambda implements a<b> {
    final /* synthetic */ c this$0;

    CurrencyMenuLightFragment$params$2(c cVar) {
        this.this$0 = cVar;
        super(0);
    }

    /* renamed from: acY */
    public final b invoke() {
        Parcelable parcelable = com.iqoption.core.ext.a.o(this.this$0).getParcelable("ARG_PARAMS");
        if (parcelable != null) {
            return (b) parcelable;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.iqoption.deposit.menu.currency.CurrencyMenuParams");
    }
}
