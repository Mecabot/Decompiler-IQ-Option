package com.iqoption.portfolio.component.viewholder;

import android.graphics.Rect;
import android.view.View;
import com.iqoption.analytics.k;
import com.iqoption.d.aec;
import com.iqoption.portfolio.component.b.g;
import com.iqoption.portfolio.component.n;
import com.iqoption.util.ag;
import com.iqoption.util.bg;
import com.iqoption.view.d.b;

/* compiled from: CfdItemViewHolder */
public final class c extends ai {
    private g daA;
    private final aec daz;

    public c(final aec aec, final n nVar) {
        super(aec.getRoot(), nVar);
        this.daz = aec;
        aec.bLL.setOnClickListener(new b() {
            public void q(View view) {
                k.b(c.this.daA, nVar.h(c.this.daA));
            }
        });
        aec.bPx.getRoot().setOnClickListener(new b() {
            public void q(View view) {
                nVar.d(c.this.daA);
            }
        });
        aec.bPx.bLs.setOnClickListener(new b() {
            public void q(View view) {
                if (!nVar.e(c.this.daA)) {
                    aec.bPx.bLt.setVisibility(8);
                    aec.bPx.bLu.setVisibility(0);
                    ag.a(nVar.f(c.this.daA), new com.google.common.util.concurrent.n<Object>() {
                        public void onSuccess(Object obj) {
                        }

                        public void l(Throwable th) {
                            aec.bPx.bLt.setVisibility(0);
                            aec.bPx.bLu.setVisibility(8);
                        }
                    });
                    k.c(c.this.daA);
                }
            }
        });
        aec.bPx.bLv.setOnClickListener(new b() {
            public void q(View view) {
                nVar.d(c.this.daA);
            }
        });
        aec.bPx.bOW.setOnClickListener(new b() {
            public void q(View view) {
                nVar.c(c.this.daA);
            }
        });
        aec.bPx.bEe.setOnClickListener(new b() {
            public void q(View view) {
                nVar.b(c.this.daA);
            }
        });
        aec.bPx.bLx.setOnClickListener(new b() {
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
        aec.bPx.bEe.setBackground(axx().awK());
        aec.bPx.bLF.setVisibility(8);
    }

    public void a(g gVar) {
        this.daA = gVar;
        awD();
        if (this.dcb.g(gVar)) {
            this.daz.bLN.setVisibility(0);
            this.daz.bPx.getRoot().setVisibility(0);
            this.dcb.axy().a(this.daz.bPx, gVar);
        } else {
            this.daz.bLN.setVisibility(8);
            this.daz.bPx.getRoot().setVisibility(8);
        }
        if (gVar.awR()) {
            this.daz.agA.setText(axx().d(gVar.axe(), gVar.Xg()));
            this.daz.bPx.bDW.setVisibility(0);
        } else {
            this.daz.agA.setText(axx().e(gVar.axj(), gVar.axc()));
            this.daz.bPx.bDW.setVisibility(8);
        }
        this.daz.brA.setImageDrawable(gVar.isCall() ? axx().cZs : axx().cZt);
        this.daz.bnA.setText(String.format(axx().cZE, new Object[]{axx().B(gVar.avU().GN())}));
        awE();
    }

    public void awD() {
        if (this.daA != null) {
            this.daA.awb();
            this.dcb.axB().a(this.daz.bns, this.daz.agQ, this.daA.avU());
            if (this.dcb.g(this.daA)) {
                this.dcb.axy().b(this.daz.bPx, this.daA);
            }
        }
    }

    public void awE() {
        boolean z = this.daA != null && this.daA.awT();
        eg(z);
    }

    private void eg(boolean z) {
        if (z) {
            this.daz.bPx.bOW.setVisibility(4);
            this.daz.bPx.bng.setVisibility(0);
            return;
        }
        this.daz.bPx.bng.setVisibility(8);
        this.daz.bPx.bOW.setVisibility(0);
    }
}
