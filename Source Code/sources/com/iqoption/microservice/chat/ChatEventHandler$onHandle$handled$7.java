package com.iqoption.microservice.chat;

import com.iqoption.microservice.chat.d.d;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/microservice/chat/ChatEventHandler$PublicTypingListener;", "invoke"})
/* compiled from: ChatEventHandler.kt */
final class ChatEventHandler$onHandle$handled$7 extends Lambda implements b<d, l> {
    final /* synthetic */ c $event;

    ChatEventHandler$onHandle$handled$7(c cVar) {
        this.$event = cVar;
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        a((d) obj);
        return l.etX;
    }

    public final void a(d dVar) {
        h.e(dVar, "it");
        c cVar = this.$event;
        h.d(cVar, "event");
        dVar.e(cVar);
    }
}
