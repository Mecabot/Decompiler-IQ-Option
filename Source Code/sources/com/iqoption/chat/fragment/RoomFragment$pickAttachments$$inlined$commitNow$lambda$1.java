package com.iqoption.chat.fragment;

import android.content.Context;
import android.net.Uri;
import com.iqoption.chat.service.SendFileMessageService;
import java.util.List;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "files", "", "Landroid/net/Uri;", "invoke", "com/iqoption/chat/fragment/RoomFragment$pickAttachments$1$f$1"})
/* compiled from: RoomFragment.kt */
final class RoomFragment$pickAttachments$$inlined$commitNow$lambda$1 extends Lambda implements b<List<? extends Uri>, l> {
    final /* synthetic */ x this$0;

    RoomFragment$pickAttachments$$inlined$commitNow$lambda$1(x xVar) {
        this.this$0 = xVar;
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        P((List) obj);
        return l.etX;
    }

    public final void P(List<? extends Uri> list) {
        h.e(list, "files");
        String Ll = x.aIp.Ll();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Should send: ");
        stringBuilder.append(list);
        com.iqoption.core.i.d(Ll, stringBuilder.toString());
        Context context = this.this$0.getContext();
        if (context != null) {
            SendFileMessageService.b bVar = SendFileMessageService.aJW;
            h.d(context, "it");
            Object value = this.this$0.aIb.getValue();
            h.d(value, "roomId.value");
            bVar.a(context, (String) value, list);
        }
    }
}
