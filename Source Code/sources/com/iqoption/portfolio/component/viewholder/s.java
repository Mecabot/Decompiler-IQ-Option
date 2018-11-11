package com.iqoption.portfolio.component.viewholder;

import android.view.View;
import com.google.common.util.concurrent.o;
import com.iqoption.analytics.k;
import com.iqoption.app.managers.af;
import com.iqoption.d.aac;
import com.iqoption.portfolio.component.b.h;
import com.iqoption.portfolio.component.b.i;
import com.iqoption.portfolio.component.b.j;
import com.iqoption.portfolio.component.n;
import com.iqoption.view.d.b;

/* compiled from: MicroExpSingleGroupViewHolder */
public final class s extends ai {
    private i dau;
    private final aac dbu;

    public void awE() {
    }

    public s(final aac aac, final n nVar) {
        super(aac.getRoot(), nVar);
        this.dbu = aac;
        aac.bLL.setOnClickListener(new b() {
            public void q(View view) {
                j axb = s.this.dau.axb();
                boolean h = nVar.h(axb);
                k.a(axb, h);
                if (h && s.this.dau.axb() != null) {
                    nVar.d(s.this.dau.axb());
                }
            }
        });
        aac.bLX.bLV.setOnClickListener(new b() {
            public void q(View view) {
                nVar.d(s.this.dau.axb());
            }
        });
        aac.bLX.bLP.setOnClickListener(new b() {
            public void q(View view) {
                j jVar = (h) s.this.dau.axb();
                if (!nVar.e(jVar)) {
                    aac.bLX.bLQ.setVisibility(8);
                    aac.bLX.bLR.setVisibility(0);
                    o.a(nVar.f(jVar), new com.google.common.util.concurrent.n<Object>() {
                        public void onSuccess(Object obj) {
                        }

                        public void l(Throwable th) {
                            aac.bLX.bLQ.setVisibility(0);
                            aac.bLX.bLR.setVisibility(8);
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
            this.dbu.bLN.setVisibility(0);
            this.dbu.bLX.getRoot().setVisibility(0);
            this.dcb.axz().a(this.dbu.bLX, hVar);
        } else {
            this.dbu.bLN.setVisibility(8);
            this.dbu.bLX.getRoot().setVisibility(8);
        }
        this.dbu.bnL.setText(iVar.awW());
        this.dbu.brA.setImageDrawable(iVar.isCall() ? axx().cZu : axx().cZv);
        this.dbu.bnN.setText(iVar.awX());
        axu();
    }

    private void axu() {
        if (this.dau != null) {
            h hVar = (h) this.dau.axb();
            long awU = hVar.awU();
            this.dbu.blb.i(Math.max(0, awU - af.Hu().Hw()), awU - hVar.axd());
        }
    }

    public void awD() {
        if (this.dau != null) {
            this.dcb.axB().a(this.dbu.bns, this.dbu.agQ, this.dau.avU());
            h hVar = (h) this.dau.axb();
            if (this.dcb.g(hVar)) {
                hVar.awb();
                this.dcb.axz().b(this.dbu.bLX, hVar);
            }
            axu();
        }
    }
}
