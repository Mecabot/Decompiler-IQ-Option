package com.iqoption.core.ui.fragment;

import com.iqoption.core.ui.viewmodel.welcome.TermsViewModel.TERMS;
import java.io.Serializable;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "Lcom/iqoption/core/ui/viewmodel/welcome/TermsViewModel$TERMS;", "invoke"})
/* compiled from: TermsFragment.kt */
final class TermsFragment$termsArg$2 extends Lambda implements a<TERMS> {
    final /* synthetic */ c this$0;

    TermsFragment$termsArg$2(c cVar) {
        this.this$0 = cVar;
        super(0);
    }

    /* renamed from: YM */
    public final TERMS invoke() {
        Serializable serializable = com.iqoption.core.ext.a.o(this.this$0).getSerializable("termsUrl");
        if (serializable != null) {
            return (TERMS) serializable;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.iqoption.core.ui.viewmodel.welcome.TermsViewModel.TERMS");
    }
}
