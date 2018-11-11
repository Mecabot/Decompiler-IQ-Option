package com.iqoption.portfolio.component.viewholder;

import android.view.View;
import com.iqoption.d.zu;
import com.iqoption.portfolio.component.b.i;
import com.iqoption.portfolio.component.n;
import com.iqoption.view.d.b;

/* compiled from: MicroExpGroupViewHolder */
public final class p extends ai {
    private i dau;
    private final zu dbm;

    public void awE() {
    }

    public p(final zu zuVar, final n nVar) {
        super(zuVar.getRoot(), nVar);
        this.dbm = zuVar;
        zuVar.getRoot().setOnClickListener(new b() {
            public void q(View view) {
                zuVar.bLq.animate().setDuration(120).rotation(nVar.c(p.this.dau) ? 180.0f : 0.0f).start();
            }
        });
    }

    public void a(i iVar) {
        this.dau = iVar;
        awD();
        if (this.dcb.b(iVar)) {
            this.dbm.bLq.setRotation(180.0f);
        } else {
            this.dbm.bLq.setRotation(0.0f);
        }
        this.dcb.axC().a(this.dbm.afU, iVar.awV());
        this.dbm.bnL.setText(iVar.awW());
        this.dbm.bLr.setText(String.format(axx().cZF, new Object[]{String.valueOf(iVar.avT())}));
        this.dbm.bnN.setText(iVar.awX());
    }

    public void awD() {
        if (this.dau != null) {
            this.dcb.axB().a(this.dbm.bns, this.dbm.agQ, this.dau.avU());
        }
    }
}
