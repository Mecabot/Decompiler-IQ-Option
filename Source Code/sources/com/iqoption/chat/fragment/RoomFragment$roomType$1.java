package com.iqoption.chat.fragment;

import com.iqoption.microservice.chat.ChatRoomType;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "Lcom/iqoption/microservice/chat/ChatRoomType;", "invoke"})
/* compiled from: RoomFragment.kt */
final class RoomFragment$roomType$1 extends Lambda implements a<ChatRoomType> {
    final /* synthetic */ x this$0;

    RoomFragment$roomType$1(x xVar) {
        this.this$0 = xVar;
        super(0);
    }

    /* renamed from: Qp */
    public final ChatRoomType invoke() {
        String string = com.iqoption.core.ext.a.o(this.this$0).getString("arg.chatRoomType");
        h.d(string, "args.getString(ARG_CHAT_ROOM_TYPE)");
        return ChatRoomType.valueOf(string);
    }
}
