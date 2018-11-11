package com.iqoption.chat.fragment;

import android.widget.ImageView;
import com.iqoption.d.eh;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "", "invoke"})
/* compiled from: RoomBottomBarDelegates.kt */
final class SendDelegate$2$updateSendButton$1 extends Lambda implements b<CharSequence, l> {
    final /* synthetic */ eh receiver$0;

    SendDelegate$2$updateSendButton$1(eh ehVar) {
        this.receiver$0 = ehVar;
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        q((CharSequence) obj);
        return l.etX;
    }

    public final void q(CharSequence charSequence) {
        h.e(charSequence, "it");
        ImageView imageView;
        if (u.M(charSequence)) {
            imageView = this.receiver$0.bmG;
            h.d(imageView, "btnSend");
            imageView.setVisibility(8);
            imageView = this.receiver$0.bmG;
            h.d(imageView, "btnSend");
            imageView.setEnabled(false);
            return;
        }
        imageView = this.receiver$0.bmG;
        h.d(imageView, "btnSend");
        imageView.setVisibility(0);
        imageView = this.receiver$0.bmG;
        h.d(imageView, "btnSend");
        imageView.setEnabled(true);
    }
}
