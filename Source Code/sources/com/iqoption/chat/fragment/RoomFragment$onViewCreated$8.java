package com.iqoption.chat.fragment;

import com.iqoption.chat.component.af;
import com.iqoption.x.R;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/chat/component/RateSupportEvent;", "invoke"})
/* compiled from: RoomFragment.kt */
final class RoomFragment$onViewCreated$8 extends Lambda implements b<af, l> {
    final /* synthetic */ x this$0;

    RoomFragment$onViewCreated$8(x xVar) {
        this.this$0 = xVar;
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        b((af) obj);
        return l.etX;
    }

    public final void b(af afVar) {
        h.e(afVar, "it");
        if (afVar.Pg()) {
            com.iqoption.app.a.b.eP(this.this$0.getString(R.string.thank_you_your_feedback_is_highly_appreciated));
        } else {
            com.iqoption.app.a.b.eP(this.this$0.getString(R.string.you_can_not_rate_this_conversation));
            x.j(this.this$0).fJ(afVar.getMessageId());
        }
        this.this$0.aIn = afVar.getTime();
    }
}
