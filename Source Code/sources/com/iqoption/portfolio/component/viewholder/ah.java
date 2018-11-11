package com.iqoption.portfolio.component.viewholder;

import com.iqoption.d.afl;
import com.iqoption.portfolio.component.b.e;
import com.iqoption.portfolio.component.n;
import com.iqoption.portfolio.component.o;

/* compiled from: OpenHeaderViewHolder */
public final class ah extends ai {
    private o cYW;
    private e dbD;
    private final afl dca;

    public void awE() {
    }

    public ah(afl afl, n nVar) {
        super(afl.getRoot(), nVar);
        this.dca = afl;
        this.cYW = nVar.axx();
    }

    public void a(e eVar) {
        this.dbD = eVar;
        awD();
    }

    public void awD() {
        this.dca.bPQ.setText(String.format(this.cYW.cZA, new Object[]{this.cYW.B(this.dbD.GN())}));
    }
}
