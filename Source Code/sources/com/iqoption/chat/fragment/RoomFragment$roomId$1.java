package com.iqoption.chat.fragment;

import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, aXE = {"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"})
/* compiled from: RoomFragment.kt */
final class RoomFragment$roomId$1 extends Lambda implements a<String> {
    final /* synthetic */ x this$0;

    RoomFragment$roomId$1(x xVar) {
        this.this$0 = xVar;
        super(0);
    }

    /* renamed from: PM */
    public final String invoke() {
        return com.iqoption.core.ext.a.o(this.this$0).getString("arg.chatRoomId", "unknown");
    }
}
