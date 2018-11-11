package com.iqoption.chat.fragment;

import android.widget.TextView;
import com.iqoption.core.util.LocalizationUtil;
import com.iqoption.d.ec;
import com.iqoption.microservice.chat.n;
import com.iqoption.x.R;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, aXE = {"Lcom/iqoption/chat/fragment/PrivateRoomTopBarDelegate;", "Lcom/iqoption/chat/fragment/RoomTopBarDelegate;", "delegateContext", "Lcom/iqoption/chat/fragment/DelegateContext;", "(Lcom/iqoption/chat/fragment/DelegateContext;)V", "binding", "Lcom/iqoption/databinding/ChatRoomPrivateToolbarBinding;", "getBinding", "()Lcom/iqoption/databinding/ChatRoomPrivateToolbarBinding;", "onRoomLoaded", "", "room", "Lcom/iqoption/microservice/chat/ChatRoom;", "IqOption-5.5.1_optionXRelease"})
/* compiled from: RoomTopBarDelegates.kt */
public final class r extends y {
    private final ec aHI;

    public r(g gVar) {
        h.e(gVar, "delegateContext");
        super(gVar);
        this.aHI = (ec) aa.e(gVar, R.layout.chat_room_private_toolbar);
    }

    public void g(n nVar) {
        if (nVar != null) {
            TextView textView = this.aHI.agA;
            h.d(textView, "binding.title");
            textView.setText(LocalizationUtil.translate(nVar.getName()));
        }
    }
}
