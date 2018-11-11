package com.iqoption.portfolio.component.viewholder;

import com.iqoption.d.aep;
import com.iqoption.portfolio.component.b.c;
import com.iqoption.portfolio.component.n;

/* compiled from: ExpHeaderViewHolder */
public final class h extends ai {
    private final aep daP;

    public void awD() {
    }

    public void awE() {
    }

    public h(aep aep, n nVar) {
        super(aep.getRoot(), nVar);
        this.daP = aep;
    }

    public void a(c cVar) {
        this.daP.bLO.setText(String.format(axx().cZG, new Object[]{axx().aM(cVar.getExpiration())}));
    }
}
