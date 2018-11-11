package com.iqoption.portfolio.component.viewholder;

import android.view.View;
import com.iqoption.analytics.k;
import com.iqoption.core.microservices.tradingengine.response.active.a;
import com.iqoption.d.agb;
import com.iqoption.portfolio.a.r;
import com.iqoption.portfolio.component.b.l;
import com.iqoption.portfolio.component.b.m;
import com.iqoption.util.ag;
import com.iqoption.view.d.b;

/* compiled from: PendingSingleGroupItemViewHolder */
public final class ap extends ao implements a {
    private l dbF;
    private m dbz;
    private final agb dck;

    public void axs() {
    }

    public ap(final agb agb, r rVar) {
        super(agb.getRoot(), rVar);
        this.dck = agb;
        agb.bLL.setOnClickListener(new b() {
            public void q(View view) {
                k.b(ap.this.dbz, ap.this.e(ap.this.dbz));
            }
        });
        agb.bPP.getRoot().setOnClickListener(new b() {
            public void q(View view) {
                ap.this.j(ap.this.dbF.axn());
            }
        });
        agb.bPP.bLs.setOnClickListener(new b() {
            public void q(View view) {
                if (!ap.this.h(ap.this.dbz)) {
                    agb.bPP.bLt.setVisibility(8);
                    agb.bPP.bLu.setVisibility(0);
                    ag.b(ap.this.g(ap.this.dbz), new aj(ap.this));
                    k.b(ap.this.dbz);
                }
            }
        });
        agb.bPP.bLv.setOnClickListener(new b() {
            public void q(View view) {
                ap.this.i(ap.this.dbF.axn());
            }
        });
        agb.bPP.bLF.setVisibility(8);
    }

    public void a(l lVar) {
        this.dbF = lVar;
        this.dbz = lVar.axn();
        awF();
        if (f(this.dbz)) {
            this.dck.bLN.setVisibility(0);
            this.dck.bPP.getRoot().setVisibility(0);
            axA().a(this.dck.bPP, this.dbz);
        } else {
            this.dck.bLN.setVisibility(8);
            this.dck.bPP.getRoot().setVisibility(8);
        }
        a Jg = lVar.Jg();
        if (!this.dbz.awR()) {
            this.dck.bnN.setText(axx().c(this.dbz));
            this.dck.bLZ.setText(null);
        } else if (this.dbz.isCall()) {
            this.dck.bnN.setText(String.format(axx().cZC, new Object[]{com.iqoption.util.e.a.O(Jg.getInstrumentType())}));
            this.dck.bLZ.setText(String.format(axx().cZP, new Object[]{axx().d(this.dbz.axe(), this.dbz.Xg())}));
        } else {
            this.dck.bnN.setText(com.iqoption.util.e.a.O(Jg.getInstrumentType()));
            this.dck.bLZ.setText(null);
        }
        axC().a(this.dck.afU, Jg.getImage());
        this.dck.bnL.setText(com.iqoption.util.e.a.E(Jg));
        this.dck.brA.setImageDrawable(this.dbz.isCall() ? axx().cZu : axx().cZv);
        this.dck.bMi.setText(axx().e(Jg.getPrecision(), this.dbz.axp()));
        this.dck.bnl.setText(axx().i(this.dbz.getInvestment(), this.dbz.getMultiplier()));
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
        r1 = r3.dck;
        r1 = r1.bPP;
        r2 = r3.dbz;
        r0.b(r1, r2);
    L_0x001e:
        return;
    L_0x001f:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.portfolio.component.viewholder.ap.awF():void");
    }

    public void axt() {
        this.dck.bPP.bLt.setVisibility(0);
        this.dck.bPP.bLu.setVisibility(8);
    }
}
