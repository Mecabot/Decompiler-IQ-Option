package com.iqoption.quiz.chat;

import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "", "invoke"})
/* compiled from: ChatDelegate.kt */
final class ChatDelegate$6 extends Lambda implements b<Boolean, l> {
    final /* synthetic */ ChatDelegate$3 $setShowInput$3;

    ChatDelegate$6(ChatDelegate$3 chatDelegate$3) {
        this.$setShowInput$3 = chatDelegate$3;
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        eo(((Boolean) obj).booleanValue());
        return l.etX;
    }

    public final void eo(boolean z) {
        if (z) {
            this.$setShowInput$3.eo(true);
        } else {
            this.$setShowInput$3.eo(false);
        }
    }
}
