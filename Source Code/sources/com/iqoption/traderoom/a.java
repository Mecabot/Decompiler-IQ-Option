package com.iqoption.traderoom;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.iqoption.charttools.constructor.b;
import com.iqoption.charttools.tools.e;
import com.iqoption.fragment.base.j;
import com.iqoption.fragment.cr;
import com.iqoption.traderoom.TradeRoomViewModel.a.c;
import com.iqoption.traderoom.TradeRoomViewModel.a.d;
import com.iqoption.x.R;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, aXE = {"Lcom/iqoption/traderoom/TradeRoomHelper;", "", "fragment", "Lcom/iqoption/fragment/TradeFragment;", "(Lcom/iqoption/fragment/TradeFragment;)V", "getFragment", "()Lcom/iqoption/fragment/TradeFragment;", "onShowAction", "", "action", "Lcom/iqoption/traderoom/TradeRoomViewModel$Action;", "IqOption-5.5.1_optionXRelease"})
/* compiled from: TradeRoomHelper.kt */
public final class a {
    private final cr dsn;

    public a(cr crVar) {
        h.e(crVar, "fragment");
        this.dsn = crVar;
    }

    public final void a(com.iqoption.traderoom.TradeRoomViewModel.a aVar) {
        FragmentManager p;
        FragmentTransaction beginTransaction;
        if (aVar instanceof c) {
            b a = b.aty.a(((c) aVar).aEI());
            p = com.iqoption.core.ext.a.p(this.dsn);
            beginTransaction = p.beginTransaction();
            h.d(beginTransaction, "ft");
            beginTransaction.add(R.id.layout, a, b.TAG);
            beginTransaction.addToBackStack(null);
            beginTransaction.commitAllowingStateLoss();
            p.executePendingTransactions();
        } else if (aVar instanceof d) {
            e bZ = e.aAK.bZ(((d) aVar).aEJ());
            p = com.iqoption.core.ext.a.p(this.dsn);
            beginTransaction = p.beginTransaction();
            h.d(beginTransaction, "ft");
            beginTransaction.add(R.id.fragment, bZ, e.aAK.Ll());
            beginTransaction.addToBackStack(null);
            beginTransaction.commitAllowingStateLoss();
            p.executePendingTransactions();
        } else if (aVar instanceof com.iqoption.traderoom.TradeRoomViewModel.a.a) {
            com.iqoption.traderoom.TradeRoomViewModel.a.a aVar2 = (com.iqoption.traderoom.TradeRoomViewModel.a.a) aVar;
            com.iqoption.core.microservices.tradingengine.response.active.a a2 = com.iqoption.app.helpers.a.FI().a(Integer.valueOf(aVar2.getActiveId()), aVar2.getInstrumentType());
            if (a2 != null) {
                com.iqoption.app.managers.tab.a.Il().d(a2.getActiveId(), a2.getInstrumentType());
            }
        } else if (aVar instanceof com.iqoption.traderoom.TradeRoomViewModel.a.b) {
            com.iqoption.traderoom.TradeRoomViewModel.a.b bVar = (com.iqoption.traderoom.TradeRoomViewModel.a.b) aVar;
            Fragment a3 = j.a(bVar.Mk(), bVar.aEH(), true);
            p = com.iqoption.core.ext.a.p(this.dsn);
            beginTransaction = p.beginTransaction();
            h.d(beginTransaction, "ft");
            beginTransaction.add(R.id.other_fragment, a3, j.TAG);
            beginTransaction.addToBackStack(null);
            beginTransaction.commitAllowingStateLoss();
            p.executePendingTransactions();
        }
    }
}
