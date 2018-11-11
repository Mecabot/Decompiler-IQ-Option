package com.iqoption.trading.history.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.iqoption.core.util.p;
import com.iqoption.d.sr;
import com.iqoption.trading.history.a.c;
import com.iqoption.trading.history.fragment.a.a;
import com.iqoption.util.au;
import com.iqoption.util.bc;
import com.iqoption.util.bg;
import com.iqoption.util.g;
import com.iqoption.x.R;

/* compiled from: TradingHistorySearchDetailFragment */
public class b extends a {
    private sr dsX;

    @NonNull
    private static b b(com.iqoption.trading.history.b.b bVar) {
        b bVar2 = new b();
        bVar2.setArguments(new g().b("arg.portfolio.item", (Parcelable) bVar).toBundle());
        return bVar2;
    }

    public static void a(@IdRes int i, FragmentManager fragmentManager, com.iqoption.trading.history.b.b bVar) {
        if (fragmentManager.findFragmentByTag("TradingHistorySearchDetailFragment") == null) {
            fragmentManager.beginTransaction().add(i, b(bVar), "TradingHistorySearchDetailFragment").addToBackStack("TradingHistorySearchDetailFragment").commit();
        }
    }

    protected View aeO() {
        return this.dsX.getRoot();
    }

    protected View aeP() {
        FragmentActivity activity = zzakw();
        return activity instanceof a ? ((a) activity).aeP() : null;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.dsX = (sr) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_trading_history_search_details, viewGroup, false);
        this.dsX.biw.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                b.this.aN();
            }
        });
        com.iqoption.trading.history.b.b bVar = (com.iqoption.trading.history.b.b) getArguments().getParcelable("arg.portfolio.item");
        if (bVar != null) {
            a(bVar, ((c.a) zzakw()).cc(bVar.dsQ));
        }
        return this.dsX.getRoot();
    }

    private void a(com.iqoption.trading.history.b.b bVar, c cVar) {
        int i;
        com.iqoption.core.microservices.tradingengine.response.active.a Jg = bVar.Jg();
        if (Jg == null) {
            i = 6;
        } else {
            i = Jg.getPrecision();
        }
        if (Jg != null) {
            this.dsX.bDO.setText(com.iqoption.util.e.a.s(Jg));
        }
        this.dsX.bDX.setText(cVar.ce(bVar.axd()));
        this.dsX.bDV.setText(cVar.e(i, bVar.dsS));
        bg.setDrawableRight(this.dsX.bDV, bVar.isCall() ? cVar.cZs : cVar.cZt);
        this.dsX.bDP.setText(cVar.ce(bVar.getCloseTime()));
        this.dsX.bDQ.setText(cVar.e(i, bVar.dsT));
        this.dsX.brp.setText(cVar.B(bVar.amZ));
        Integer aEM = bVar.aEM();
        if (aEM != null) {
            this.dsX.brq.setText(p.ea(aEM.intValue()));
        } else {
            this.dsX.bDU.setVisibility(8);
        }
        boolean axg = bVar.axg();
        Double aER = bVar.aER();
        if (aER == null || !axg) {
            this.dsX.bEc.setVisibility(8);
        } else {
            this.dsX.bEb.setText(cVar.cZS.format(aER));
        }
        aER = bVar.aEN();
        if (aER == null || !axg) {
            this.dsX.bDZ.setVisibility(8);
        } else {
            this.dsX.bDY.setText(cVar.a(aER.doubleValue(), bVar.instrumentType, i));
        }
        Double commission = bVar.getCommission();
        if (commission != null) {
            this.dsX.bDS.setText(new bc().jO(p.o(au.j(bVar.amZ, commission.doubleValue()))).bM(cVar.daa).C(' ').C('(').jO(cVar.B(commission.doubleValue())).C(')').aCT());
        } else {
            this.dsX.bDR.setVisibility(8);
        }
        commission = bVar.getSwap();
        if (commission != null) {
            this.dsX.bEe.setText(new bc().jO(p.e(au.j(bVar.amZ, commission.doubleValue()), 2)).bM(cVar.daa).C(' ').C('(').jO(cVar.B(commission.doubleValue())).C(')').aCT());
        } else {
            this.dsX.bEd.setVisibility(8);
        }
        this.dsX.bEa.setText(new bc().jO(cVar.B(bVar.aEO())).bM(cVar.E(bVar.aEP())).C(' ').C('(').jO(cVar.F(bVar.aEP())).jO(cVar.B(Math.abs(bVar.aEP()))).C(')').aCT());
    }
}
