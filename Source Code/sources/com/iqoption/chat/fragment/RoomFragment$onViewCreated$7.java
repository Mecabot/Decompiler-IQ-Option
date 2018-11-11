package com.iqoption.chat.fragment;

import com.iqoption.chat.component.af;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/chat/component/RateSupportEvent;", "invoke"})
/* compiled from: RoomFragment.kt */
final class RoomFragment$onViewCreated$7 extends Lambda implements b<af, Boolean> {
    final /* synthetic */ x this$0;

    RoomFragment$onViewCreated$7(x xVar) {
        this.this$0 = xVar;
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(a((af) obj));
    }

    public final boolean a(af afVar) {
        h.e(afVar, "it");
        return afVar.getTime() > this.this$0.aIn;
    }
}
