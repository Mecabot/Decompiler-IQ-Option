package com.iqoption.portfolio.component.viewholder;

import android.graphics.Rect;
import android.view.View;
import com.iqoption.analytics.k;
import com.iqoption.d.zo;
import com.iqoption.portfolio.component.b.g;
import com.iqoption.portfolio.component.b.i;
import com.iqoption.portfolio.component.b.j;
import com.iqoption.portfolio.component.n;
import com.iqoption.util.ag;
import com.iqoption.util.bg;
import com.iqoption.view.d.b;

/* compiled from: MicroCfdSingleGroupViewHolder */
public final class o extends ai {
    private i dau;
    private final zo dbh;

    public o(final zo zoVar, final n nVar) {
        super(zoVar.getRoot(), nVar);
        this.dbh = zoVar;
        zoVar.bLL.setOnClickListener(new b() {
            public void q(View view) {
                j axb = o.this.dau.axb();
                boolean h = nVar.h(axb);
                k.a(axb, h);
                if (h && o.this.dau.axb() != null) {
                    nVar.d(o.this.dau.axb());
                }
            }
        });
        zoVar.bLM.getRoot().setOnClickListener(new b() {
            public void q(View view) {
                nVar.d(o.this.dau.axb());
            }
        });
        zoVar.bLM.bLs.setOnClickListener(new b() {
            public void q(View view) {
                j jVar = (g) o.this.dau.axb();
                if (!nVar.e(jVar)) {
                    zoVar.bLM.bLt.setVisibility(8);
                    zoVar.bLM.bLu.setVisibility(0);
                    ag.a(nVar.f(jVar), new com.google.common.util.concurrent.n<Object>() {
                        public void onSuccess(Object obj) {
                        }

                        public void l(Throwable th) {
                            zoVar.bLM.bLt.setVisibility(0);
                            zoVar.bLM.bLu.setVisibility(8);
                        }
                    });
                    k.b(jVar);
                }
            }
        });
        zoVar.bLM.bLv.setOnClickListener(new b() {
            public void q(View view) {
                nVar.d((g) o.this.dau.axb());
            }
        });
        zoVar.bLM.bnf.setOnClickListener(new b() {
            public void q(View view) {
                nVar.c((g) o.this.dau.axb());
            }
        });
        zoVar.bLM.bEe.setOnClickListener(new b() {
            public void q(View view) {
                nVar.b((g) o.this.dau.axb());
            }
        });
        zoVar.bLM.bLx.setOnClickListener(new b() {
            public void q(final View view) {
                Rect J = bg.J(view);
                view.setSelected(true);
                ag.a(nVar.g(J), new com.google.common.util.concurrent.n<Object>() {
                    public void onSuccess(Object obj) {
                        view.setSelected(false);
                    }

                    public void l(Throwable th) {
                        view.setSelected(false);
                    }
                });
            }
        });
        zoVar.bLM.bEe.setBackground(axx().awK());
    }

    public void a(i iVar) {
        this.dau = iVar;
        awD();
        g gVar = (g) iVar.axb();
        if (this.dcb.g(gVar)) {
            this.dbh.bLN.setVisibility(0);
            this.dbh.bLM.getRoot().setVisibility(0);
            this.dcb.axy().a(this.dbh.bLM, gVar);
        } else {
            this.dbh.bLN.setVisibility(8);
            this.dbh.bLM.getRoot().setVisibility(8);
        }
        if (iVar.awR()) {
            this.dbh.bLM.bLF.setVisibility(0);
        } else {
            this.dbh.bLM.bLF.setVisibility(8);
        }
        this.dcb.axC().a(this.dbh.afU, iVar.awV());
        this.dbh.bnL.setText(iVar.awW());
        this.dbh.brA.setImageDrawable(iVar.isCall() ? axx().cZu : axx().cZv);
        this.dbh.bnN.setText(iVar.awX());
        awE();
    }

    public void awD() {
        if (this.dau != null) {
            this.dcb.axB().a(this.dbh.bns, this.dbh.agQ, this.dau.avU());
            g gVar = (g) this.dau.axb();
            if (this.dcb.g(gVar)) {
                gVar.awb();
                this.dcb.axy().b(this.dbh.bLM, gVar);
            }
        }
    }

    public void awE() {
        g gVar = this.dau == null ? null : (g) this.dau.axb();
        boolean z = gVar != null && gVar.awT();
        eg(z);
    }

    private void eg(boolean z) {
        if (z) {
            this.dbh.bLM.bnf.setVisibility(4);
            this.dbh.bLM.bng.setVisibility(0);
            return;
        }
        this.dbh.bLM.bng.setVisibility(8);
        this.dbh.bLM.bnf.setVisibility(0);
    }
}
