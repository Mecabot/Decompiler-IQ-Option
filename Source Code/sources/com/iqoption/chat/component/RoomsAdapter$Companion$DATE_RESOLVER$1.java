package com.iqoption.chat.component;

import com.iqoption.chat.viewmodel.LastMessagesViewModel;
import com.iqoption.microservice.chat.g;
import com.iqoption.microservice.chat.n;
import kotlin.i;
import kotlin.jvm.a.m;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "", "viewModel", "Lcom/iqoption/chat/viewmodel/LastMessagesViewModel;", "room", "Lcom/iqoption/microservice/chat/ChatRoom;", "invoke"})
/* compiled from: RoomsAdapter.kt */
final class RoomsAdapter$Companion$DATE_RESOLVER$1 extends Lambda implements m<LastMessagesViewModel, n, Long> {
    public static final RoomsAdapter$Companion$DATE_RESOLVER$1 aEU = new RoomsAdapter$Companion$DATE_RESOLVER$1();

    RoomsAdapter$Companion$DATE_RESOLVER$1() {
        super(2);
    }

    public /* synthetic */ Object B(Object obj, Object obj2) {
        return Long.valueOf(a((LastMessagesViewModel) obj, (n) obj2));
    }

    public final long a(LastMessagesViewModel lastMessagesViewModel, n nVar) {
        h.e(lastMessagesViewModel, "viewModel");
        h.e(nVar, "room");
        g fQ = lastMessagesViewModel.fQ(nVar.getId());
        return fQ != null ? fQ.getDate() : 0;
    }
}
