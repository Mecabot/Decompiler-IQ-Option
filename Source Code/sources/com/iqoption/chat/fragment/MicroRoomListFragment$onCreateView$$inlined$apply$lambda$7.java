package com.iqoption.chat.fragment;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, aXE = {"<anonymous>", "", "invoke", "com/iqoption/chat/fragment/MicroRoomListFragment$onCreateView$1$5"})
/* compiled from: MicroRoomListFragment.kt */
final class MicroRoomListFragment$onCreateView$$inlined$apply$lambda$7 extends Lambda implements a<l> {
    final /* synthetic */ FragmentActivity $activity$inlined;
    final /* synthetic */ q this$0;

    MicroRoomListFragment$onCreateView$$inlined$apply$lambda$7(q qVar, FragmentActivity fragmentActivity) {
        this.this$0 = qVar;
        this.$activity$inlined = fragmentActivity;
        super(0);
    }

    public final void invoke() {
        RecyclerView recyclerView = q.d(this.this$0).bzb;
        h.d(recyclerView, "binding.chatList");
        recyclerView.setAdapter(q.c(this.this$0));
        q.d(this.this$0).bzb.scheduleLayoutAnimation();
    }
}
