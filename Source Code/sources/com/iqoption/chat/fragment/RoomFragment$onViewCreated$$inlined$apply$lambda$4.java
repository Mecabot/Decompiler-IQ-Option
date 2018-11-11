package com.iqoption.chat.fragment;

import com.iqoption.chat.component.ac;
import com.iqoption.chat.fragment.x.e;
import com.iqoption.microservice.chat.g;
import com.iqoption.x.R;
import java.util.List;
import kotlin.i;
import kotlin.j;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/microservice/chat/ChatMessage;", "invoke", "com/iqoption/chat/fragment/RoomFragment$onViewCreated$9$2"})
/* compiled from: RoomFragment.kt */
final class RoomFragment$onViewCreated$$inlined$apply$lambda$4 extends Lambda implements b<g, l> {
    final /* synthetic */ e $messageInteractor;
    final /* synthetic */ RoomFragment$onViewCreated$$inlined$apply$lambda$3 $openMessageOptions$1;
    final /* synthetic */ ac receiver$0;
    final /* synthetic */ x this$0;

    RoomFragment$onViewCreated$$inlined$apply$lambda$4(ac acVar, RoomFragment$onViewCreated$$inlined$apply$lambda$3 roomFragment$onViewCreated$$inlined$apply$lambda$3, e eVar, x xVar) {
        this.receiver$0 = acVar;
        this.$openMessageOptions$1 = roomFragment$onViewCreated$$inlined$apply$lambda$3;
        this.$messageInteractor = eVar;
        this.this$0 = xVar;
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        e((g) obj);
        return l.etX;
    }

    public final void e(g gVar) {
        h.e(gVar, "it");
        u g = this.this$0.aIk;
        if (g != null && g.Qf()) {
            List cr;
            RoomFragment$onViewCreated$$inlined$apply$lambda$3 roomFragment$onViewCreated$$inlined$apply$lambda$3 = this.$openMessageOptions$1;
            if (gVar.arg()) {
                cr = l.cr(j.D("option.copy", this.receiver$0.getString(R.string.copy, new Object[0])));
            } else {
                cr = m.listOf(j.D("option.replyWithText", this.receiver$0.getString(R.string.reply_with_text, new Object[0])), j.D("option.reply", this.receiver$0.getString(R.string.reply, new Object[0])), j.D("option.copy", this.receiver$0.getString(R.string.copy, new Object[0])));
            }
            roomFragment$onViewCreated$$inlined$apply$lambda$3.b(gVar, cr, this.$messageInteractor);
        }
    }
}
