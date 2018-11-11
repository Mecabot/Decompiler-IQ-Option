package com.iqoption.portfolio.component.viewholder;

import android.view.View;
import com.iqoption.d.aen;
import com.iqoption.portfolio.component.b.i;
import com.iqoption.portfolio.component.n;
import com.iqoption.view.d.b;

/* compiled from: ExpGroupViewHolder */
public final class g extends ai {
    private final aen daM;
    private i dau;

    public void awE() {
    }

    public g(final aen aen, final n nVar) {
        super(aen.getRoot(), nVar);
        this.daM = aen;
        aen.getRoot().setOnClickListener(new b() {
            public void q(View view) {
                aen.bLq.animate().setDuration(120).rotation(nVar.c(g.this.dau) ? 180.0f : 0.0f).start();
            }
        });
    }

    public void a(i iVar) {
        this.dau = iVar;
        awD();
        if (this.dcb.b(iVar)) {
            this.daM.bLq.setRotation(180.0f);
        } else {
            this.daM.bLq.setRotation(0.0f);
        }
        this.dcb.axC().a(this.daM.afU, iVar.awV());
        this.daM.bnL.setText(iVar.getActiveName());
        this.daM.bLr.setText(String.format(axx().cZF, new Object[]{String.valueOf(iVar.avT())}));
        this.daM.bnN.setText(String.format(axx().cZD, new Object[]{iVar.awX()}));
    }

    public void awD() {
        if (this.dau != null) {
            this.dcb.axB().a(this.daM.bns, this.daM.agQ, this.dau.avU());
        }
    }
}
