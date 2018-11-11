package com.iqoption.chat.fragment;

import android.support.v7.widget.RecyclerView;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, aXE = {"<anonymous>", "", "invoke", "com/iqoption/chat/fragment/RoomListFragment$onCreateView$1$5"})
/* compiled from: RoomListFragment.kt */
final class RoomListFragment$onCreateView$$inlined$apply$lambda$7 extends Lambda implements a<l> {
    final /* synthetic */ RoomListFragment this$0;

    RoomListFragment$onCreateView$$inlined$apply$lambda$7(RoomListFragment roomListFragment) {
        this.this$0 = roomListFragment;
        super(0);
    }

    public final void invoke() {
        RecyclerView recyclerView = RoomListFragment.d(this.this$0).bzb;
        h.d(recyclerView, "binding.chatList");
        recyclerView.setAdapter(RoomListFragment.c(this.this$0));
        RoomListFragment.d(this.this$0).bzb.scheduleLayoutAnimation();
    }
}
