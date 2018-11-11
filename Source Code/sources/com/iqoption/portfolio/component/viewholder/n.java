package com.iqoption.portfolio.component.viewholder;

import android.graphics.Rect;
import android.view.View;
import com.iqoption.analytics.k;
import com.iqoption.d.zm;
import com.iqoption.portfolio.component.b.g;
import com.iqoption.util.ag;
import com.iqoption.util.bg;
import com.iqoption.view.d.b;

/* compiled from: MicroCfdItemViewHolder */
public final class n extends ai {
    private g daA;
    private final zm dbc;

    public n(final zm zmVar, final com.iqoption.portfolio.component.n nVar) {
        super(zmVar.getRoot(), nVar);
        this.dbc = zmVar;
        zmVar.bLL.setOnClickListener(new b() {
            public void q(View view) {
                boolean h = nVar.h(n.this.daA);
                k.a(n.this.daA, h);
                if (h) {
                    nVar.d(n.this.daA);
                }
            }
        });
        zmVar.bLM.getRoot().setOnClickListener(new b() {
            public void q(View view) {
                nVar.d(n.this.daA);
            }
        });
        zmVar.bLM.bLs.setOnClickListener(new b() {
            public void q(View view) {
                if (!nVar.e(n.this.daA)) {
                    zmVar.bLM.bLt.setVisibility(8);
                    zmVar.bLM.bLu.setVisibility(0);
                    ag.a(nVar.f(n.this.daA), new com.google.common.util.concurrent.n<Object>() {
                        public void onSuccess(Object obj) {
                        }

                        public void l(Throwable th) {
                            zmVar.bLM.bLt.setVisibility(0);
                            zmVar.bLM.bLu.setVisibility(8);
                        }
                    });
                    k.b(n.this.daA);
                }
            }
        });
        zmVar.bLM.bLv.setOnClickListener(new b() {
            public void q(View view) {
                nVar.d(n.this.daA);
            }
        });
        zmVar.bLM.bnf.setOnClickListener(new b() {
            public void q(View view) {
                nVar.c(n.this.daA);
            }
        });
        zmVar.bLM.bEe.setOnClickListener(new b() {
            public void q(View view) {
                nVar.b(n.this.daA);
            }
        });
        zmVar.bLM.bLx.setOnClickListener(new b() {
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
        zmVar.bLM.bEe.setBackground(axx().awK());
        zmVar.bLM.bLF.setVisibility(8);
    }

    public void a(g gVar) {
        this.daA = gVar;
        awD();
        if (this.dcb.g(gVar)) {
            this.dbc.bLN.setVisibility(0);
            this.dbc.bLM.getRoot().setVisibility(0);
            this.dcb.axy().a(this.dbc.bLM, gVar);
        } else {
            this.dbc.bLN.setVisibility(8);
            this.dbc.bLM.getRoot().setVisibility(8);
        }
        if (gVar.awR()) {
            this.dbc.agA.setText(axx().d(gVar.axe(), gVar.Xg()));
            this.dbc.bLM.bDW.setVisibility(0);
        } else {
            this.dbc.agA.setText(axx().e(gVar.axj(), gVar.axc()));
            this.dbc.bLM.bDW.setVisibility(8);
        }
        this.dbc.brA.setImageDrawable(gVar.isCall() ? axx().cZu : axx().cZv);
        this.dbc.bnA.setText(axx().B(gVar.avU().GN()));
        awE();
    }

    public void awD() {
        if (this.daA != null) {
            this.daA.awb();
            this.dcb.axB().a(this.dbc.bns, this.dbc.agQ, this.daA.avU());
            if (this.dcb.g(this.daA)) {
                this.dcb.axy().b(this.dbc.bLM, this.daA);
            }
        }
    }

    public void awE() {
        boolean z = this.daA != null && this.daA.awT();
        eg(z);
    }

    private void eg(boolean z) {
        if (z) {
            this.dbc.bLM.bnf.setVisibility(4);
            this.dbc.bLM.bng.setVisibility(0);
            return;
        }
        this.dbc.bLM.bng.setVisibility(8);
        this.dbc.bLM.bnf.setVisibility(0);
    }
}
