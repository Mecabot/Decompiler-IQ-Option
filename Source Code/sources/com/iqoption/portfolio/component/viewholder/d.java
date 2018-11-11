package com.iqoption.portfolio.component.viewholder;

import android.graphics.Rect;
import android.view.View;
import com.iqoption.analytics.k;
import com.iqoption.d.aee;
import com.iqoption.portfolio.component.b.g;
import com.iqoption.portfolio.component.b.i;
import com.iqoption.portfolio.component.b.j;
import com.iqoption.portfolio.component.n;
import com.iqoption.util.ag;
import com.iqoption.util.bg;
import com.iqoption.view.d.b;

/* compiled from: CfdSingleGroupViewHolder */
public final class d extends ai {
    private final aee daF;
    private i dau;

    public d(final aee aee, final n nVar) {
        super(aee.getRoot(), nVar);
        this.daF = aee;
        aee.bLL.setOnClickListener(new b() {
            public void q(View view) {
                j axb = d.this.dau.axb();
                k.b(axb, nVar.h(axb));
            }
        });
        aee.bPx.getRoot().setOnClickListener(new b() {
            public void q(View view) {
                nVar.d(d.this.dau.axb());
            }
        });
        aee.bPx.bLs.setOnClickListener(new b() {
            public void q(View view) {
                g gVar = (g) d.this.dau.axb();
                if (!nVar.e(gVar)) {
                    aee.bPx.bLt.setVisibility(8);
                    aee.bPx.bLu.setVisibility(0);
                    ag.a(nVar.f(gVar), new com.google.common.util.concurrent.n<Object>() {
                        public void onSuccess(Object obj) {
                        }

                        public void l(Throwable th) {
                            aee.bPx.bLt.setVisibility(0);
                            aee.bPx.bLu.setVisibility(8);
                        }
                    });
                    k.c(gVar);
                }
            }
        });
        aee.bPx.bLv.setOnClickListener(new b() {
            public void q(View view) {
                nVar.d((g) d.this.dau.axb());
            }
        });
        aee.bPx.bOW.setOnClickListener(new b() {
            public void q(View view) {
                nVar.c((g) d.this.dau.axb());
            }
        });
        aee.bPx.bEe.setOnClickListener(new b() {
            public void q(View view) {
                nVar.b((g) d.this.dau.axb());
            }
        });
        aee.bPx.bLx.setOnClickListener(new b() {
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
        aee.bPx.bEe.setBackground(axx().awK());
    }

    public void a(i iVar) {
        this.dau = iVar;
        awD();
        g gVar = (g) iVar.axb();
        if (this.dcb.g(gVar)) {
            this.daF.bLN.setVisibility(0);
            this.daF.bPx.getRoot().setVisibility(0);
            this.dcb.axy().a(this.daF.bPx, gVar);
        } else {
            this.daF.bLN.setVisibility(8);
            this.daF.bPx.getRoot().setVisibility(8);
        }
        if (iVar.awR()) {
            this.daF.bPx.bLF.setVisibility(0);
        } else {
            this.daF.bPx.bLF.setVisibility(8);
        }
        this.dcb.axC().a(this.daF.afU, iVar.awV());
        this.daF.agA.setText(iVar.getActiveName());
        this.daF.brA.setImageDrawable(iVar.isCall() ? axx().cZs : axx().cZt);
        this.daF.bnN.setText(iVar.awX());
        awE();
    }

    public void awD() {
        if (this.dau != null) {
            this.dcb.axB().a(this.daF.bns, this.daF.agQ, this.dau.avU());
            g gVar = (g) this.dau.axb();
            if (this.dcb.g(gVar)) {
                gVar.awb();
                this.dcb.axy().b(this.daF.bPx, gVar);
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
            this.daF.bPx.bOW.setVisibility(4);
            this.daF.bPx.bng.setVisibility(0);
            return;
        }
        this.daF.bPx.bng.setVisibility(8);
        this.daF.bPx.bOW.setVisibility(0);
    }
}
