package com.iqoption.portfolio.component.viewholder;

import android.view.View;
import com.iqoption.core.microservices.tradingengine.response.active.a;
import com.iqoption.d.aau;
import com.iqoption.portfolio.a.r;
import com.iqoption.portfolio.component.b.l;
import com.iqoption.view.d.b;

/* compiled from: MicroPendingGroupItemViewHolder */
public final class y extends ao {
    private final aau dbE;
    private l dbF;

    public void awF() {
    }

    public y(final aau aau, r rVar) {
        super(aau.getRoot(), rVar);
        this.dbE = aau;
        aau.getRoot().setOnClickListener(new b() {
            public void q(View view) {
                aau.bLq.animate().setDuration(120).rotation(y.this.b(y.this.dbF) ? 180.0f : 0.0f).start();
            }
        });
    }

    public void a(l lVar) {
        this.dbF = lVar;
        if (c(lVar)) {
            this.dbE.bLq.setRotation(180.0f);
        } else {
            this.dbE.bLq.setRotation(0.0f);
        }
        a Jg = lVar.Jg();
        axC().a(this.dbE.afU, Jg.getImage());
        this.dbE.bnL.setText(com.iqoption.util.e.a.E(Jg));
        this.dbE.bLr.setText(String.format(axx().cZF, new Object[]{String.valueOf(lVar.axm())}));
        this.dbE.bnN.setText(axx().c(lVar.axn()));
        this.dbE.bnl.setText(axx().B(lVar.getInvestment()));
    }
}
