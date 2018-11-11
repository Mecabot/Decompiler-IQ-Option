package com.iqoption.portfolio.component.viewholder;

import com.iqoption.d.aak;
import com.iqoption.portfolio.component.b.e;
import com.iqoption.portfolio.component.n;
import com.iqoption.portfolio.component.o;

/* compiled from: MicroOpenHeaderViewHolder */
public final class w extends ai {
    private o cYW;
    private aak dbC;
    private e dbD;

    public void awE() {
    }

    public w(aak aak, n nVar) {
        super(aak.getRoot(), nVar);
        this.dbC = aak;
        this.cYW = nVar.axx();
    }

    public void a(e eVar) {
        this.dbD = eVar;
        awD();
    }

    public void awD() {
        this.dbC.bMd.setText(String.format(this.cYW.cZz, new Object[]{this.cYW.B(this.dbD.getValue())}));
        this.dcb.axB().a(this.dbC.bMd, this.dbC.bMb, this.dbD.avU());
    }
}
