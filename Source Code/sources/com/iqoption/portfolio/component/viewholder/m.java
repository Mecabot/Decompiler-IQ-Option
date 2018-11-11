package com.iqoption.portfolio.component.viewholder;

import android.view.View;
import com.iqoption.d.zi;
import com.iqoption.portfolio.component.b.i;
import com.iqoption.portfolio.component.n;
import com.iqoption.view.d.b;

/* compiled from: MicroCfdGroupViewHolder */
public final class m extends ai {
    private final zi daZ;
    private i dau;

    public void awE() {
    }

    public m(final zi ziVar, final n nVar) {
        super(ziVar.getRoot(), nVar);
        this.daZ = ziVar;
        ziVar.getRoot().setOnClickListener(new b() {
            public void q(View view) {
                ziVar.bLq.animate().setDuration(120).rotation(nVar.c(m.this.dau) ? 180.0f : 0.0f).start();
            }
        });
    }

    public void a(i iVar) {
        this.dau = iVar;
        awD();
        if (this.dcb.b(iVar)) {
            this.daZ.bLq.setRotation(180.0f);
        } else {
            this.daZ.bLq.setRotation(0.0f);
        }
        this.dcb.axC().a(this.daZ.afU, iVar.awV());
        this.daZ.bnL.setText(iVar.awW());
        this.daZ.bLr.setText(String.format(axx().cZF, new Object[]{String.valueOf(iVar.avT())}));
        this.daZ.bnN.setText(iVar.awX());
    }

    public void awD() {
        if (this.dau != null) {
            this.dcb.axB().a(this.daZ.bns, this.daZ.agQ, this.dau.avU());
        }
    }
}
