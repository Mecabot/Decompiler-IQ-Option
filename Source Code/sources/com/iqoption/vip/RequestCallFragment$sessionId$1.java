package com.iqoption.vip;

import android.os.Bundle;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "invoke"})
/* compiled from: RequestCallFragment.kt */
final class RequestCallFragment$sessionId$1 extends Lambda implements a<Long> {
    final /* synthetic */ e this$0;

    RequestCallFragment$sessionId$1(e eVar) {
        this.this$0 = eVar;
        super(0);
    }

    public /* synthetic */ Object invoke() {
        return Long.valueOf(aFq());
    }

    public final long aFq() {
        Bundle arguments = this.this$0.getArguments();
        if (arguments == null) {
            h.aXZ();
        }
        return arguments.getLong("extra_session");
    }
}
