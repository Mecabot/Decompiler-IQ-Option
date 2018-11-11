package com.iqoption.quiz.chat;

import android.widget.ImageView;
import android.widget.LinearLayout;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"setShowInput", "", "show", "", "invoke"})
/* compiled from: ChatDelegate.kt */
final class ChatDelegate$3 extends Lambda implements b<Boolean, l> {
    final /* synthetic */ AtomicBoolean $isInputShown;
    final /* synthetic */ a this$0;

    ChatDelegate$3(a aVar, AtomicBoolean atomicBoolean) {
        this.this$0 = aVar;
        this.$isInputShown = atomicBoolean;
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        eo(((Boolean) obj).booleanValue());
        return l.etX;
    }

    public final void eo(boolean z) {
        if (this.$isInputShown.get() != z) {
            this.$isInputShown.set(z);
            ImageView imageView;
            LinearLayout linearLayout;
            if (z) {
                imageView = this.this$0.aAU().dkC;
                h.d(imageView, "b.btnWrite");
                imageView.setVisibility(8);
                linearLayout = this.this$0.aAU().dkF;
                h.d(linearLayout, "b.sendLayout");
                linearLayout.setVisibility(0);
            } else {
                imageView = this.this$0.aAU().dkC;
                h.d(imageView, "b.btnWrite");
                imageView.setVisibility(0);
                linearLayout = this.this$0.aAU().dkF;
                h.d(linearLayout, "b.sendLayout");
                linearLayout.setVisibility(8);
            }
        }
    }
}
