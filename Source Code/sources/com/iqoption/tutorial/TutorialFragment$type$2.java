package com.iqoption.tutorial;

import com.iqoption.tutorial.dictionary.TutorialAction;
import java.io.Serializable;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "Lcom/iqoption/tutorial/dictionary/TutorialAction;", "invoke"})
/* compiled from: TutorialFragment.kt */
final class TutorialFragment$type$2 extends Lambda implements a<TutorialAction> {
    final /* synthetic */ c this$0;

    TutorialFragment$type$2(c cVar) {
        this.this$0 = cVar;
        super(0);
    }

    /* renamed from: aFr */
    public final TutorialAction invoke() {
        Serializable serializable = com.iqoption.core.ext.a.o(this.this$0).getSerializable("ARG_TYPE");
        if (serializable != null) {
            return (TutorialAction) serializable;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.iqoption.tutorial.dictionary.TutorialAction");
    }
}
