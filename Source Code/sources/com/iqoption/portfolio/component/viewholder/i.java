package com.iqoption.portfolio.component.viewholder;

import android.view.View;
import com.google.common.util.concurrent.o;
import com.iqoption.analytics.k;
import com.iqoption.app.managers.af;
import com.iqoption.d.aet;
import com.iqoption.portfolio.component.b.h;
import com.iqoption.portfolio.component.n;
import com.iqoption.view.d.b;

/* compiled from: ExpItemViewHolder */
public final class i extends ai {
    private final aet daQ;
    private h daR;

    public void awE() {
    }

    public i(final aet aet, final n nVar) {
        super(aet.getRoot(), nVar);
        this.daQ = aet;
        aet.bPO.bLS.setVisibility(8);
        aet.bLL.setOnClickListener(new b() {
            public void q(View view) {
                k.a(i.this.daR, nVar.h(i.this.daR));
            }
        });
        aet.bPO.getRoot().setOnClickListener(new b() {
            public void q(View view) {
                nVar.d(i.this.daR);
            }
        });
        aet.bPO.bLP.setOnClickListener(new b() {
            public void q(View view) {
                if (!nVar.e(i.this.daR)) {
                    aet.bPO.bLQ.setVisibility(8);
                    aet.bPO.bLR.setVisibility(0);
                    o.a(nVar.f(i.this.daR), new com.google.common.util.concurrent.n<Object>() {
                        public void onSuccess(Object obj) {
                        }

                        public void l(Throwable th) {
                            aet.bPO.bLQ.setVisibility(0);
                            aet.bPO.bLR.setVisibility(8);
                        }
                    });
                    k.b(i.this.daR);
                }
            }
        });
        aet.blb.setTextSize(axx().cZT);
    }

    public void a(h hVar) {
        this.daR = hVar;
        awD();
        if (this.dcb.g(hVar)) {
            this.daQ.bLN.setVisibility(0);
            this.daQ.bPO.getRoot().setVisibility(0);
            this.dcb.axz().a(this.daQ.bPO, hVar);
        } else {
            this.daQ.bLN.setVisibility(8);
            this.daQ.bPO.getRoot().setVisibility(8);
        }
        this.daQ.agA.setText(axx().e(hVar.axj(), hVar.axc()));
        this.daQ.brA.setImageDrawable(hVar.isCall() ? axx().cZs : axx().cZt);
        this.daQ.bnA.setText(String.format(axx().cZE, new Object[]{axx().B(hVar.avU().GN())}));
        axu();
    }

    private void axu() {
        if (this.daR != null) {
            long awU = this.daR.awU();
            this.daQ.blb.i(Math.max(0, awU - af.Hu().Hw()), awU - this.daR.axd());
        }
    }

    public void awD() {
        if (this.daR != null) {
            this.daR.awb();
            this.dcb.axB().a(this.daQ.bns, this.daQ.agQ, this.daR.avU());
            if (this.dcb.g(this.daR)) {
                this.dcb.axz().b(this.daQ.bPO, this.daR);
            }
            axu();
        }
    }
}
