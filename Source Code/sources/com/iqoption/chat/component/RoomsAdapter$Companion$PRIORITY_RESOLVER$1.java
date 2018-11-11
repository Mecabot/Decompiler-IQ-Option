package com.iqoption.chat.component;

import com.iqoption.microservice.chat.n;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/microservice/chat/ChatRoom;", "invoke"})
/* compiled from: RoomsAdapter.kt */
final class RoomsAdapter$Companion$PRIORITY_RESOLVER$1 extends Lambda implements b<n, Integer> {
    public static final RoomsAdapter$Companion$PRIORITY_RESOLVER$1 aEV = new RoomsAdapter$Companion$PRIORITY_RESOLVER$1();

    RoomsAdapter$Companion$PRIORITY_RESOLVER$1() {
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        return Integer.valueOf(e((n) obj));
    }

    public final int e(n nVar) {
        h.e(nVar, "it");
        return aj.aEQ.indexOf(nVar.Qh());
    }
}
