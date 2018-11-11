package com.iqoption.microservice.chat;

import com.iqoption.microservice.chat.d.e;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/microservice/chat/ChatEventHandler$RoomListener;", "invoke"})
/* compiled from: ChatEventHandler.kt */
final class ChatEventHandler$onHandle$handled$3 extends Lambda implements b<e, l> {
    final /* synthetic */ e $event;

    ChatEventHandler$onHandle$handled$3(e eVar) {
        this.$event = eVar;
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        c((e) obj);
        return l.etX;
    }

    public final void c(e eVar) {
        h.e(eVar, "it");
        e eVar2 = this.$event;
        h.d(eVar2, "event");
        eVar.c(eVar2);
    }
}
