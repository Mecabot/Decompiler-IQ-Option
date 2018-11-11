package com.iqoption.portfolio.component.viewholder;

import android.view.View;
import com.iqoption.analytics.k;
import com.iqoption.app.managers.af;
import com.iqoption.d.aaa;
import com.iqoption.portfolio.component.b.h;
import com.iqoption.portfolio.component.n;
import com.iqoption.portfolio.component.o;
import com.iqoption.util.ag;
import com.iqoption.view.d.b;

/* compiled from: MicroExpItemViewHolder */
public final class r extends ai {
    private o cYW;
    private h daR;
    private final aaa dbq;

    public void awE() {
    }

    public r(final aaa aaa, final n nVar) {
        super(aaa.getRoot(), nVar);
        this.dbq = aaa;
        this.cYW = nVar.axx();
        aaa.bLL.setOnClickListener(new b() {
            public void q(View view) {
                boolean h = nVar.h(r.this.daR);
                k.a(r.this.daR, h);
                if (h) {
                    nVar.d(r.this.daR);
                }
            }
        });
        aaa.bLX.bLV.setOnClickListener(new b() {
            public void q(View view) {
                nVar.d(r.this.daR);
            }
        });
        aaa.bLX.bLP.setOnClickListener(new b() {
            public void q(View view) {
                if (!nVar.e(r.this.daR)) {
                    aaa.bLX.bLQ.setVisibility(8);
                    aaa.bLX.bLR.setVisibility(0);
                    ag.a(nVar.f(r.this.daR), new com.google.common.util.concurrent.n<Object>() {
                        public void onSuccess(Object obj) {
                        }

                        public void l(Throwable th) {
                            aaa.bLX.bLQ.setVisibility(0);
                            aaa.bLX.bLR.setVisibility(8);
                        }
                    });
                    k.b(r.this.daR);
                }
            }
        });
        aaa.bLX.bLS.setVisibility(8);
        aaa.bLX.bLy.setVisibility(8);
    }

    public void a(h hVar) {
        this.daR = hVar;
        awD();
        if (this.dcb.g(hVar)) {
            this.dbq.bLN.setVisibility(0);
            this.dbq.bLX.getRoot().setVisibility(0);
            this.dcb.axz().a(this.dbq.bLX, hVar);
        } else {
            this.dbq.bLN.setVisibility(8);
            this.dbq.bLX.getRoot().setVisibility(8);
        }
        this.dbq.agA.setText(axx().e(hVar.axj(), hVar.axc()));
        this.dbq.brA.setImageDrawable(hVar.isCall() ? axx().cZu : axx().cZv);
        axu();
    }

    private void axu() {
        if (this.daR != null) {
            long awU = this.daR.awU();
            this.dbq.blb.i(Math.max(0, awU - af.Hu().Hw()), awU - this.daR.axd());
        }
    }

    public void awD() {
        if (this.daR != null) {
            this.daR.awb();
            this.dcb.axB().a(this.dbq.bns, this.dbq.agQ, this.daR.avU());
            if (this.dcb.g(this.daR)) {
                this.dcb.axz().b(this.dbq.bLX, this.daR);
            }
            axu();
        }
    }
}
