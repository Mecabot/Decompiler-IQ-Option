package com.iqoption.portfolio.component.viewholder;

import com.iqoption.d.zw;
import com.iqoption.portfolio.component.b.c;
import com.iqoption.portfolio.component.n;

/* compiled from: MicroExpHeaderViewHolder */
public final class q extends ai {
    private final zw dbp;

    public void awD() {
    }

    public void awE() {
    }

    public q(zw zwVar, n nVar) {
        super(zwVar.getRoot(), nVar);
        this.dbp = zwVar;
    }

    public void a(c cVar) {
        this.dbp.bLO.setText(String.format(axx().cZG, new Object[]{axx().aM(cVar.getExpiration())}));
    }
}
