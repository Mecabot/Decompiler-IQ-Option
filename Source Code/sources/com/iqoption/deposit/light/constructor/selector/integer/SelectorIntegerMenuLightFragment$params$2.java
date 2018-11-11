package com.iqoption.deposit.light.constructor.selector.integer;

import android.os.Parcelable;
import com.iqoption.deposit.constructor.selector.integer.c;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "Lcom/iqoption/deposit/constructor/selector/integer/SelectorIntegerMenuParams;", "invoke"})
/* compiled from: SelectorIntegerMenuLightFragment.kt */
final class SelectorIntegerMenuLightFragment$params$2 extends Lambda implements a<c> {
    final /* synthetic */ c this$0;

    SelectorIntegerMenuLightFragment$params$2(c cVar) {
        this.this$0 = cVar;
        super(0);
    }

    /* renamed from: acS */
    public final c invoke() {
        Parcelable parcelable = com.iqoption.core.ext.a.o(this.this$0).getParcelable("ARG_PARAMS");
        if (parcelable != null) {
            return (c) parcelable;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.iqoption.deposit.constructor.selector.integer.SelectorIntegerMenuParams");
    }
}
