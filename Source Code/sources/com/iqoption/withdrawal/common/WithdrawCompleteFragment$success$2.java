package com.iqoption.withdrawal.common;

import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "invoke"})
/* compiled from: WithdrawCompleteFragment.kt */
final class WithdrawCompleteFragment$success$2 extends Lambda implements a<Boolean> {
    final /* synthetic */ d this$0;

    WithdrawCompleteFragment$success$2(d dVar) {
        this.this$0 = dVar;
        super(0);
    }

    public final boolean invoke() {
        return com.iqoption.core.ext.a.o(this.this$0).getBoolean("ARG_SUCCESS");
    }
}
