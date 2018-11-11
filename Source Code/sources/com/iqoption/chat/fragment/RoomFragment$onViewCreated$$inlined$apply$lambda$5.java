package com.iqoption.chat.fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.iqoption.core.ext.a;
import com.iqoption.microservice.chat.g;
import com.iqoption.x.R;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/microservice/chat/ChatMessage;", "invoke", "com/iqoption/chat/fragment/RoomFragment$onViewCreated$9$3"})
/* compiled from: RoomFragment.kt */
final class RoomFragment$onViewCreated$$inlined$apply$lambda$5 extends Lambda implements b<g, l> {
    final /* synthetic */ x this$0;

    RoomFragment$onViewCreated$$inlined$apply$lambda$5(x xVar) {
        this.this$0 = xVar;
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        e((g) obj);
        return l.etX;
    }

    public final void e(g gVar) {
        h.e(gVar, "it");
        if (!gVar.art() && !gVar.ars()) {
            long aro = gVar.aro();
            String arq = gVar.arq();
            long parseLong = arq != null ? Long.parseLong(arq) : -1;
            FragmentManager p = a.p(this.this$0);
            FragmentTransaction beginTransaction = p.beginTransaction();
            h.d(beginTransaction, "ft");
            af m = af.aJj.m(aro, parseLong);
            String Ll = af.aJj.Ll();
            beginTransaction.add(R.id.dialogLayer, m, Ll);
            beginTransaction.addToBackStack(Ll);
            beginTransaction.commitAllowingStateLoss();
            p.executePendingTransactions();
        }
    }
}
