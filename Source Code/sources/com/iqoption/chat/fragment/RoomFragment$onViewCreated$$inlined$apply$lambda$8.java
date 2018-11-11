package com.iqoption.chat.fragment;

import com.iqoption.chat.component.ac;
import com.iqoption.microservice.chat.a;
import com.iqoption.microservice.chat.g;
import com.iqoption.x.R;
import java.util.List;
import kotlin.Pair;
import kotlin.i;
import kotlin.j;
import kotlin.jvm.a.m;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, aXE = {"<anonymous>", "", "message", "Lcom/iqoption/microservice/chat/ChatMessage;", "attachment", "Lcom/iqoption/microservice/chat/ChatAttachment;", "invoke", "com/iqoption/chat/fragment/RoomFragment$onViewCreated$9$7"})
/* compiled from: RoomFragment.kt */
final class RoomFragment$onViewCreated$$inlined$apply$lambda$8 extends Lambda implements m<g, a, l> {
    final /* synthetic */ x.i $attachmentInteractor;
    final /* synthetic */ RoomFragment$onViewCreated$9$6 $formatSubTitle$6;
    final /* synthetic */ RoomFragment$onViewCreated$$inlined$apply$lambda$7 $openImage$5;
    final /* synthetic */ RoomFragment$onViewCreated$$inlined$apply$lambda$3 $openMessageOptions$1;
    final /* synthetic */ ac receiver$0;
    final /* synthetic */ x this$0;

    RoomFragment$onViewCreated$$inlined$apply$lambda$8(ac acVar, RoomFragment$onViewCreated$$inlined$apply$lambda$7 roomFragment$onViewCreated$$inlined$apply$lambda$7, RoomFragment$onViewCreated$9$6 roomFragment$onViewCreated$9$6, RoomFragment$onViewCreated$$inlined$apply$lambda$3 roomFragment$onViewCreated$$inlined$apply$lambda$3, x.i iVar, x xVar) {
        this.receiver$0 = acVar;
        this.$openImage$5 = roomFragment$onViewCreated$$inlined$apply$lambda$7;
        this.$formatSubTitle$6 = roomFragment$onViewCreated$9$6;
        this.$openMessageOptions$1 = roomFragment$onViewCreated$$inlined$apply$lambda$3;
        this.$attachmentInteractor = iVar;
        this.this$0 = xVar;
        super(2);
    }

    public /* synthetic */ Object B(Object obj, Object obj2) {
        a((g) obj, (a) obj2);
        return l.etX;
    }

    public final void a(g gVar, a aVar) {
        h.e(gVar, "message");
        h.e(aVar, "attachment");
        if (!aVar.arf()) {
            List listOf;
            RoomFragment$onViewCreated$$inlined$apply$lambda$3 roomFragment$onViewCreated$$inlined$apply$lambda$3 = this.$openMessageOptions$1;
            Pair pair = new Pair(gVar, aVar);
            if (!gVar.arg()) {
                u g = this.this$0.aIk;
                if (g != null && g.Qf()) {
                    listOf = m.listOf(j.D("option.reply", this.receiver$0.getString(R.string.reply, new Object[0])), j.D("option.download", this.receiver$0.getString(R.string.download, new Object[0])));
                    roomFragment$onViewCreated$$inlined$apply$lambda$3.b(pair, listOf, this.$attachmentInteractor);
                }
            }
            listOf = l.cr(j.D("option.download", this.receiver$0.getString(R.string.download, new Object[0])));
            roomFragment$onViewCreated$$inlined$apply$lambda$3.b(pair, listOf, this.$attachmentInteractor);
        } else if (aVar.getUrl() != null) {
            this.$openImage$5.Z(aVar.getUrl(), this.$formatSubTitle$6.g(gVar.arn(), gVar.getDate()));
        }
    }
}
