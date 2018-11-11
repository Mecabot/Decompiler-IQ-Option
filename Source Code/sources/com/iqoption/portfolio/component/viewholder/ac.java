package com.iqoption.portfolio.component.viewholder;

import android.view.View;
import com.iqoption.analytics.k;
import com.iqoption.core.microservices.tradingengine.response.active.a;
import com.iqoption.d.aba;
import com.iqoption.portfolio.a.r;
import com.iqoption.portfolio.component.b.l;
import com.iqoption.portfolio.component.b.m;
import com.iqoption.util.ag;
import com.iqoption.view.d.b;

/* compiled from: MicroPendingSingleGroupItemViewHolder */
public final class ac extends ao implements a {
    private l dbF;
    private final aba dbQ;
    private m dbz;

    public void axs() {
    }

    public ac(final aba aba, final r rVar) {
        super(aba.getRoot(), rVar);
        this.dbQ = aba;
        aba.bLL.setOnClickListener(new b() {
            public void q(View view) {
                boolean e = ac.this.e(ac.this.dbz);
                if (e) {
                    rVar.j(ac.this.dbz);
                }
                k.a(ac.this.dbz, e);
            }
        });
        aba.bLY.getRoot().setOnClickListener(new b() {
            public void q(View view) {
                ac.this.j(ac.this.dbF.axn());
            }
        });
        aba.bLY.bLs.setOnClickListener(new b() {
            public void q(View view) {
                if (!ac.this.h(ac.this.dbz)) {
                    aba.bLY.bLt.setVisibility(8);
                    aba.bLY.bLu.setVisibility(0);
                    ag.b(ac.this.g(ac.this.dbz), new aj(ac.this));
                    k.a(ac.this.dbz);
                }
            }
        });
        aba.bLY.bLv.setOnClickListener(new b() {
            public void q(View view) {
                ac.this.i(ac.this.dbF.axn());
            }
        });
    }

    public void a(l lVar) {
        this.dbF = lVar;
        this.dbz = lVar.axn();
        awF();
        if (f(this.dbz)) {
            this.dbQ.bLN.setVisibility(0);
            this.dbQ.bLY.getRoot().setVisibility(0);
            axA().a(this.dbQ.bLY, this.dbz);
        } else {
            this.dbQ.bLN.setVisibility(8);
            this.dbQ.bLY.getRoot().setVisibility(8);
        }
        if (lVar.awR()) {
            this.dbQ.bLY.bLF.setVisibility(0);
        } else {
            this.dbQ.bLY.bLF.setVisibility(8);
        }
        a Jg = lVar.Jg();
        axC().a(this.dbQ.afU, Jg.getImage());
        this.dbQ.bnL.setText(com.iqoption.util.e.a.E(Jg));
        this.dbQ.brA.setImageDrawable(this.dbz.isCall() ? axx().cZu : axx().cZv);
        this.dbQ.bMi.setText(axx().e(Jg.getPrecision(), this.dbz.axp()));
        this.dbQ.bnN.setText(axx().c(lVar.axn()));
        this.dbQ.bnl.setText(axx().i(this.dbz.getInvestment(), this.dbz.getMultiplier()));
    }

    /* JADX WARNING: Missing block: B:8:0x001f, code:
            return;
     */
    public void awF() {
        /*
        r3 = this;
        r0 = r3.dbF;
        if (r0 == 0) goto L_0x001f;
    L_0x0004:
        r0 = r3.dbz;
        if (r0 != 0) goto L_0x0009;
    L_0x0008:
        goto L_0x001f;
    L_0x0009:
        r0 = r3.dbz;
        r0 = r3.f(r0);
        if (r0 == 0) goto L_0x001e;
    L_0x0011:
        r0 = r3.axA();
        r1 = r3.dbQ;
        r1 = r1.bLY;
        r2 = r3.dbz;
        r0.b(r1, r2);
    L_0x001e:
        return;
    L_0x001f:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.portfolio.component.viewholder.ac.awF():void");
    }

    public void axt() {
        this.dbQ.bLY.bLt.setVisibility(0);
        this.dbQ.bLY.bLu.setVisibility(8);
    }
}
