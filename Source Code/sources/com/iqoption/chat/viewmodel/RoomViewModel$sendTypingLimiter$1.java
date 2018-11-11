package com.iqoption.chat.viewmodel;

import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "Ljava/lang/Void;", "invoke"})
/* compiled from: RoomViewModel.kt */
final class RoomViewModel$sendTypingLimiter$1 extends Lambda implements b<Void, l> {
    final /* synthetic */ RoomViewModel this$0;

    RoomViewModel$sendTypingLimiter$1(RoomViewModel roomViewModel) {
        this.this$0 = roomViewModel;
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        b((Void) obj);
        return l.etX;
    }

    public final void b(Void voidR) {
        com.iqoption.core.i.d(RoomViewModel.TAG, "send chat typing");
        com.iqoption.microservice.chat.l.cQj.ik(this.this$0.Re());
    }
}
