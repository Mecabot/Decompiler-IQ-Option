package com.iqoption.chat.fragment;

import android.widget.TextView;
import com.iqoption.d.ee;
import com.iqoption.microservice.chat.n;
import com.iqoption.x.R;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, aXE = {"setStaticSubtitle", "", "invoke", "com/iqoption/chat/fragment/PublicRoomTopBarDelegate$onRoomLoaded$1$1"})
/* compiled from: RoomTopBarDelegates.kt */
final class PublicRoomTopBarDelegate$onRoomLoaded$$inlined$apply$lambda$1 extends Lambda implements a<l> {
    final /* synthetic */ n $room$inlined;
    final /* synthetic */ ee receiver$0;
    final /* synthetic */ s this$0;

    PublicRoomTopBarDelegate$onRoomLoaded$$inlined$apply$lambda$1(ee eeVar, s sVar, n nVar) {
        this.receiver$0 = eeVar;
        this.this$0 = sVar;
        this.$room$inlined = nVar;
        super(0);
    }

    public final void invoke() {
        TextView textView;
        if (this.$room$inlined.arL() > 0) {
            textView = this.receiver$0.bmE;
            h.d(textView, "subtitle");
            textView.setText(this.this$0.getString(R.string.n1_online, Integer.valueOf(this.$room$inlined.arL())));
            textView = this.receiver$0.bmE;
            h.d(textView, "subtitle");
            textView.setVisibility(0);
            return;
        }
        textView = this.receiver$0.bmE;
        h.d(textView, "subtitle");
        textView.setVisibility(8);
    }
}
