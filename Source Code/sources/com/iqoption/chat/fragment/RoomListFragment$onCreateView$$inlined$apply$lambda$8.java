package com.iqoption.chat.fragment;

import com.iqoption.analytics.b;
import com.iqoption.microservice.chat.n;
import kotlin.i;
import kotlin.jvm.a.m;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, aXE = {"<anonymous>", "", "chatRoom", "Lcom/iqoption/microservice/chat/ChatRoom;", "<anonymous parameter 1>", "", "invoke", "com/iqoption/chat/fragment/RoomListFragment$onCreateView$1$6"})
/* compiled from: RoomListFragment.kt */
final class RoomListFragment$onCreateView$$inlined$apply$lambda$8 extends Lambda implements m<n, Integer, l> {
    final /* synthetic */ RoomListFragment this$0;

    RoomListFragment$onCreateView$$inlined$apply$lambda$8(RoomListFragment roomListFragment) {
        this.this$0 = roomListFragment;
        super(2);
    }

    public /* synthetic */ Object B(Object obj, Object obj2) {
        a((n) obj, ((Number) obj2).intValue());
        return l.etX;
    }

    public final void a(n nVar, int i) {
        h.e(nVar, "chatRoom");
        b.aiV.a(nVar);
        RoomListFragment.b f = this.this$0.aIC;
        if (f != null) {
            f.c(nVar);
        }
    }
}
