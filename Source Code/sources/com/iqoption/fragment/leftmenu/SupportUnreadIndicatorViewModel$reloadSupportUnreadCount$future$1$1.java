package com.iqoption.fragment.leftmenu;

import com.iqoption.app.a;
import com.iqoption.microservice.chat.g;
import com.iqoption.microservice.chat.n;
import java.util.List;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"count", "", "messages", "", "Lcom/iqoption/microservice/chat/ChatMessage;", "invoke"})
/* compiled from: SupportUnreadIndicatorViewModel.kt */
final class SupportUnreadIndicatorViewModel$reloadSupportUnreadCount$future$1$1 extends Lambda implements b<List<? extends g>, Integer> {
    final /* synthetic */ n $supportRoom;

    SupportUnreadIndicatorViewModel$reloadSupportUnreadCount$future$1$1(n nVar) {
        this.$supportRoom = nVar;
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        return Integer.valueOf(aH((List) obj));
    }

    public final int aH(List<g> list) {
        int i = 0;
        if (list == null || list.isEmpty()) {
            return 0;
        }
        long userId = a.Cw().getUserId();
        while (i != list.size()) {
            g gVar = (g) list.get(i);
            if (h.E(gVar.getId(), this.$supportRoom.arJ()) || gVar.aro() == userId) {
                return i;
            }
            i++;
        }
        return i;
    }
}
