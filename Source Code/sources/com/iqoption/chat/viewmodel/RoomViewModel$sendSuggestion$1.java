package com.iqoption.chat.viewmodel;

import com.iqoption.microservice.chat.g;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/microservice/chat/ChatDataResponse;", "Lcom/iqoption/microservice/chat/ChatMessage;", "invoke"})
/* compiled from: RoomViewModel.kt */
final class RoomViewModel$sendSuggestion$1 extends Lambda implements b<com.iqoption.microservice.chat.b<? extends g>, l> {
    public static final RoomViewModel$sendSuggestion$1 aLy = new RoomViewModel$sendSuggestion$1();

    RoomViewModel$sendSuggestion$1() {
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        d((com.iqoption.microservice.chat.b) obj);
        return l.etX;
    }

    public final void d(com.iqoption.microservice.chat.b<g> bVar) {
        com.iqoption.core.i.d(RoomViewModel.TAG, "Suggestion successfully was sent");
    }
}
