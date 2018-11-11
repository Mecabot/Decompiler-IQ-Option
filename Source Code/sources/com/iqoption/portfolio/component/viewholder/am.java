package com.iqoption.portfolio.component.viewholder;

import com.iqoption.d.afv;
import com.iqoption.portfolio.a.r;
import com.iqoption.portfolio.component.b.e;

/* compiled from: PendingHeaderViewHolder */
public final class am extends ao {
    private final afv dcf;

    public void awF() {
    }

    public am(afv afv, r rVar) {
        super(afv.getRoot(), rVar);
        this.dcf = afv;
    }

    public void a(e eVar) {
        this.dcf.bru.setText(String.format(axx().cZB, new Object[]{axx().B(eVar.GN())}));
    }
}
