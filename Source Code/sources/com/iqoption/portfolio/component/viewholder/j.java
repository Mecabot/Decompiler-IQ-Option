package com.iqoption.portfolio.component.viewholder;

import android.view.View;
import com.iqoption.analytics.k;
import com.iqoption.app.managers.af;
import com.iqoption.d.aev;
import com.iqoption.portfolio.component.b.h;
import com.iqoption.portfolio.component.b.i;
import com.iqoption.portfolio.component.n;
import com.iqoption.util.ag;
import com.iqoption.view.d.b;

/* compiled from: ExpSingleGroupViewHolder */
public final class j extends ai {
    private final aev daV;
    private i dau;

    public void awE() {
    }

    public j(final aev aev, final n nVar) {
        super(aev.getRoot(), nVar);
        this.daV = aev;
        aev.bLL.setOnClickListener(new b() {
            public void q(View view) {
                com.iqoption.portfolio.component.b.j axb = j.this.dau.axb();
                k.a(axb, nVar.h(axb));
            }
        });
        aev.bPO.getRoot().setOnClickListener(new b() {
            public void q(View view) {
                nVar.d(j.this.dau.axb());
            }
        });
        aev.bPO.bLP.setOnClickListener(new b() {
            public void q(View view) {
                com.iqoption.portfolio.component.b.j jVar = (h) j.this.dau.axb();
                if (!nVar.e(jVar)) {
                    aev.bPO.bLQ.setVisibility(8);
                    aev.bPO.bLR.setVisibility(0);
                    ag.b(nVar.f(jVar), new com.google.common.util.concurrent.n<Object>() {
                        public void onSuccess(Object obj) {
                        }

                        public void l(Throwable th) {
                            aev.bPO.bLQ.setVisibility(0);
                            aev.bPO.bLR.setVisibility(8);
                        }
                    });
                    k.b(jVar);
                }
            }
        });
    }

    public void a(i iVar) {
        this.dau = iVar;
        awD();
        h hVar = (h) iVar.axb();
        if (this.dcb.g(hVar)) {
            this.daV.bLN.setVisibility(0);
            this.daV.bPO.getRoot().setVisibility(0);
            this.dcb.axz().a(this.daV.bPO, hVar);
        } else {
            this.daV.bLN.setVisibility(8);
            this.daV.bPO.getRoot().setVisibility(8);
        }
        this.daV.agA.setText(iVar.getActiveName());
        this.daV.brA.setImageDrawable(iVar.isCall() ? axx().cZs : axx().cZt);
        this.daV.bnN.setText(String.format(axx().cZD, new Object[]{iVar.awX()}));
        this.daV.blb.setTextSize(axx().cZT);
        axu();
    }

    private void axu() {
        if (this.dau != null) {
            h hVar = (h) this.dau.axb();
            long awU = hVar.awU();
            this.daV.blb.i(Math.max(0, awU - af.Hu().Hw()), awU - hVar.axd());
        }
    }

    public void awD() {
        if (this.dau != null) {
            this.dcb.axB().a(this.daV.bns, this.daV.agQ, this.dau.avU());
            h hVar = (h) this.dau.axb();
            if (this.dcb.g(hVar)) {
                hVar.awb();
                this.dcb.axz().b(this.daV.bPO, hVar);
            }
            axu();
        }
    }
}
