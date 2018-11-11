package com.iqoption.chat.fragment;

import com.iqoption.chat.fragment.u.b;
import com.iqoption.microservice.chat.ChatRoomType;
import com.iqoption.microservice.chat.o;
import com.iqoption.x.R;
import kotlin.jvm.internal.h;

@kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, aXE = {"Lcom/iqoption/chat/fragment/DummyDelegate;", "Lcom/iqoption/chat/fragment/RoomBottomBarDelegate;", "params", "Lcom/iqoption/chat/fragment/RoomBottomBarDelegate$Params;", "(Lcom/iqoption/chat/fragment/RoomBottomBarDelegate$Params;)V", "onStateChanged", "state", "Lcom/iqoption/microservice/chat/ChatState;", "IqOption-5.5.1_optionXRelease"})
/* compiled from: RoomBottomBarDelegates.kt */
final class i extends u {
    public i(b bVar) {
        h.e(bVar, "params");
        super(bVar);
        Qd().PB().removeAllViews();
    }

    public u a(o oVar) {
        if (Qg().Qh() == ChatRoomType.NOTIFICATION) {
            return this;
        }
        if (oVar == null) {
            return this;
        }
        u bVar;
        if (oVar.arO()) {
            bVar = new b(Qg(), getString(R.string.you_have_been_banned, new Object[0]));
        } else if (oVar.arP() < oVar.arQ()) {
            bVar = new b(Qg(), w.a(this, oVar));
        } else {
            bVar = new ac(Qg());
        }
        return bVar;
    }
}
