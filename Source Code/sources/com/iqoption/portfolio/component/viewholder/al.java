package com.iqoption.portfolio.component.viewholder;

import android.view.View;
import com.iqoption.core.microservices.tradingengine.response.active.a;
import com.iqoption.d.aft;
import com.iqoption.portfolio.a.r;
import com.iqoption.portfolio.component.b.l;
import com.iqoption.view.d.b;

/* compiled from: PendingGroupItemViewHolder */
public final class al extends ao {
    private l dbF;
    private final aft dcc;

    public void awF() {
    }

    public al(final aft aft, r rVar) {
        super(aft.getRoot(), rVar);
        this.dcc = aft;
        aft.getRoot().setOnClickListener(new b() {
            public void q(View view) {
                aft.bLq.animate().setDuration(120).rotation(al.this.b(al.this.dbF) ? 180.0f : 0.0f).start();
            }
        });
    }

    public void a(l lVar) {
        this.dbF = lVar;
        if (c(lVar)) {
            this.dcc.bLq.setRotation(180.0f);
        } else {
            this.dcc.bLq.setRotation(0.0f);
        }
        a Jg = lVar.Jg();
        axC().a(this.dcc.afU, Jg.getImage());
        this.dcc.bnL.setText(com.iqoption.util.e.a.E(Jg));
        this.dcc.bLr.setText(String.format(axx().cZF, new Object[]{String.valueOf(lVar.axm())}));
        if (lVar.axo()) {
            this.dcc.bnN.setText(String.format(axx().cZC, new Object[]{com.iqoption.util.e.a.O(Jg.getInstrumentType())}));
            this.dcc.bLZ.setText(axx().d(lVar.axe(), lVar.Xg()));
        } else {
            this.dcc.bnN.setText(axx().c(lVar.axn()));
            this.dcc.bLZ.setText(null);
        }
        this.dcc.bnl.setText(axx().B(lVar.getInvestment()));
    }
}
