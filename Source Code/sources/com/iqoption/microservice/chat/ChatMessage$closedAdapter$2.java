package com.iqoption.microservice.chat;

import com.google.gson.JsonElement;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "Lcom/iqoption/microservice/chat/ChatMessageClosedAdapter;", "invoke"})
/* compiled from: Responses.kt */
final class ChatMessage$closedAdapter$2 extends Lambda implements a<h> {
    final /* synthetic */ g this$0;

    ChatMessage$closedAdapter$2(g gVar) {
        this.this$0 = gVar;
        super(0);
    }

    /* renamed from: ary */
    public final h invoke() {
        JsonElement arm = this.this$0.arm();
        return new h(arm != null ? arm.getAsJsonObject() : null);
    }
}
