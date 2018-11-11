package com.iqoption.chat.viewmodel;

import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "", "invoke"})
/* compiled from: RoomViewModel.kt */
final class RoomViewModel$sendTextTypingLimiter$1 extends Lambda implements b<String, l> {
    final /* synthetic */ RoomViewModel this$0;

    RoomViewModel$sendTextTypingLimiter$1(RoomViewModel roomViewModel) {
        this.this$0 = roomViewModel;
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        fB((String) obj);
        return l.etX;
    }

    public final void fB(String str) {
        h.e(str, "it");
        String Ki = RoomViewModel.TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("send chat text typing: ");
        stringBuilder.append(str);
        com.iqoption.core.i.d(Ki, stringBuilder.toString());
        com.iqoption.microservice.chat.l.cQj.al(this.this$0.Re(), str);
    }
}
