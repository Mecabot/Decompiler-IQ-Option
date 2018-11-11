package com.iqoption.chat.fragment;

import android.widget.TextView;
import com.iqoption.d.ee;
import com.iqoption.microservice.chat.n;
import com.iqoption.x.R;
import kotlin.i;
import kotlin.jvm.a.m;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, aXE = {"setTypingTitle", "", "typingUser", "", "typingUsers", "", "invoke", "com/iqoption/chat/fragment/PublicRoomTopBarDelegate$onRoomLoaded$1$2"})
/* compiled from: RoomTopBarDelegates.kt */
final class PublicRoomTopBarDelegate$onRoomLoaded$$inlined$apply$lambda$2 extends Lambda implements m<String, Integer, l> {
    final /* synthetic */ n $room$inlined;
    final /* synthetic */ ee receiver$0;
    final /* synthetic */ s this$0;

    PublicRoomTopBarDelegate$onRoomLoaded$$inlined$apply$lambda$2(ee eeVar, s sVar, n nVar) {
        this.receiver$0 = eeVar;
        this.this$0 = sVar;
        this.$room$inlined = nVar;
        super(2);
    }

    public final void B(String str, int i) {
        h.e(str, "typingUser");
        TextView textView = this.receiver$0.bmE;
        h.d(textView, "subtitle");
        s sVar = this.this$0;
        Object[] objArr = new Object[1];
        if (i > 1) {
            str = String.valueOf(i);
        }
        objArr[0] = str;
        textView.setText(sVar.a(R.plurals.typing, i, objArr));
    }
}
