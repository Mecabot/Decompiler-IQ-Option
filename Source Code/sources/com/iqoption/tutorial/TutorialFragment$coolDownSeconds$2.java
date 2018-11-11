package com.iqoption.tutorial;

import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "invoke"})
/* compiled from: TutorialFragment.kt */
final class TutorialFragment$coolDownSeconds$2 extends Lambda implements a<Long> {
    final /* synthetic */ c this$0;

    TutorialFragment$coolDownSeconds$2(c cVar) {
        this.this$0 = cVar;
        super(0);
    }

    public /* synthetic */ Object invoke() {
        return Long.valueOf(aFq());
    }

    public final long aFq() {
        return com.iqoption.core.ext.a.o(this.this$0).getLong("ARG_COOL_DOWN_SECONDS");
    }
}
