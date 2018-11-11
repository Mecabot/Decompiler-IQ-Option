package com.iqoption.deposit.web;

import java.io.Serializable;
import java.util.HashMap;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, aXE = {"<anonymous>", "Ljava/util/HashMap;", "", "invoke"})
/* compiled from: BaseRedirectWebPaymentFragment.kt */
final class BaseRedirectWebPaymentFragment$redirectParams$2 extends Lambda implements a<HashMap<String, String>> {
    final /* synthetic */ a this$0;

    BaseRedirectWebPaymentFragment$redirectParams$2(a aVar) {
        this.this$0 = aVar;
        super(0);
    }

    /* renamed from: Xx */
    public final HashMap<String, String> invoke() {
        Serializable serializable = com.iqoption.core.ext.a.o(this.this$0).getSerializable("ARG_REDIRECT_PARAMS");
        if (serializable != null) {
            return (HashMap) serializable;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.String>");
    }
}
