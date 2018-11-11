package com.iqoption.microservice.chat;

import com.iqoption.microservice.chat.d.c;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/microservice/chat/ChatEventHandler$PublicMessagesListener;", "invoke"})
/* compiled from: ChatEventHandler.kt */
final class ChatEventHandler$onHandle$handled$6 extends Lambda implements b<c, l> {
    final /* synthetic */ e $event;

    ChatEventHandler$onHandle$handled$6(e eVar) {
        this.$event = eVar;
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        a((c) obj);
        return l.etX;
    }

    public final void a(c cVar) {
        h.e(cVar, "it");
        e eVar = this.$event;
        h.d(eVar, "event");
        cVar.a(eVar);
    }
}
