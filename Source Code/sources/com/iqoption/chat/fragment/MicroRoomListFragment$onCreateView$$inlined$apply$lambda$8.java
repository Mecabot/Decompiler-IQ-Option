package com.iqoption.chat.fragment;

import android.support.v4.app.FragmentActivity;
import com.iqoption.analytics.b;
import com.iqoption.chat.ChatActivity;
import com.iqoption.core.ext.a;
import com.iqoption.microservice.chat.n;
import kotlin.i;
import kotlin.jvm.a.m;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, aXE = {"<anonymous>", "", "chatRoom", "Lcom/iqoption/microservice/chat/ChatRoom;", "<anonymous parameter 1>", "", "invoke", "com/iqoption/chat/fragment/MicroRoomListFragment$onCreateView$1$6"})
/* compiled from: MicroRoomListFragment.kt */
final class MicroRoomListFragment$onCreateView$$inlined$apply$lambda$8 extends Lambda implements m<n, Integer, l> {
    final /* synthetic */ FragmentActivity $activity$inlined;
    final /* synthetic */ q this$0;

    MicroRoomListFragment$onCreateView$$inlined$apply$lambda$8(q qVar, FragmentActivity fragmentActivity) {
        this.this$0 = qVar;
        this.$activity$inlined = fragmentActivity;
        super(2);
    }

    public /* synthetic */ Object B(Object obj, Object obj2) {
        a((n) obj, ((Number) obj2).intValue());
        return l.etX;
    }

    public final void a(n nVar, int i) {
        h.e(nVar, "chatRoom");
        b.aiV.a(nVar);
        ChatActivity.aCF.a(a.m(this.this$0), nVar.getId(), nVar.Qh());
    }
}
