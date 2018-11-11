package com.iqoption.portfolio.component.viewholder;

import android.view.View;
import com.iqoption.d.ady;
import com.iqoption.portfolio.component.b.i;
import com.iqoption.portfolio.component.n;

/* compiled from: CfdGroupViewHolder */
public final class b extends ai {
    private final ady dat;
    private i dau;

    public void awE() {
    }

    public b(final ady ady, final n nVar) {
        super(ady.getRoot(), nVar);
        this.dat = ady;
        ady.getRoot().setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                ady.bLq.animate().setDuration(120).rotation(nVar.c(b.this.dau) ? 180.0f : 0.0f).start();
            }
        });
    }

    public void a(i iVar) {
        this.dau = iVar;
        awD();
        if (this.dcb.b(iVar)) {
            this.dat.bLq.setRotation(180.0f);
        } else {
            this.dat.bLq.setRotation(0.0f);
        }
        this.dcb.axC().a(this.dat.afU, iVar.awV());
        this.dat.bnL.setText(iVar.getActiveName());
        this.dat.bLr.setText(String.format(axx().cZF, new Object[]{String.valueOf(iVar.avT())}));
        this.dat.bnN.setText(iVar.awX());
    }

    public void awD() {
        if (this.dau != null) {
            this.dcb.axB().a(this.dat.bns, this.dat.agQ, this.dau.avU());
        }
    }
}
