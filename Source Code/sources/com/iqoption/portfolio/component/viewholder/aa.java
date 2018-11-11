package com.iqoption.portfolio.component.viewholder;

import android.view.View;
import com.iqoption.analytics.k;
import com.iqoption.core.microservices.tradingengine.response.active.a;
import com.iqoption.d.aag;
import com.iqoption.portfolio.a.r;
import com.iqoption.portfolio.component.b.l;
import com.iqoption.portfolio.component.b.m;
import com.iqoption.util.ag;
import com.iqoption.view.d.b;

/* compiled from: MicroPendingMktOnOpenGroupItemViewHolder */
public class aa extends ao implements a {
    private l dbF;
    private final aag dbL;
    private m dbz;

    public void axs() {
    }

    public aa(final aag aag, final r rVar) {
        super(aag.getRoot(), rVar);
        this.dbL = aag;
        aag.bLL.setOnClickListener(new b() {
            public void q(View view) {
                boolean e = aa.this.e(aa.this.dbz);
                if (e) {
                    rVar.j(aa.this.dbz);
                }
                k.a(aa.this.dbz, e);
            }
        });
        aag.bLY.getRoot().setOnClickListener(new b() {
            public void q(View view) {
                aa.this.j(aa.this.dbF.axn());
            }
        });
        aag.bLY.bLs.setOnClickListener(new b() {
            public void q(View view) {
                if (!aa.this.h(aa.this.dbz)) {
                    aag.bLY.bLt.setVisibility(8);
                    aag.bLY.bLu.setVisibility(0);
                    ag.b(aa.this.g(aa.this.dbz), new aj(aa.this));
                    k.a(aa.this.dbz);
                }
            }
        });
        aag.bLY.bLv.setOnClickListener(new ab(this));
    }

    final /* synthetic */ void bu(View view) {
        i(this.dbF.axn());
    }

    public void a(l lVar) {
        this.dbF = lVar;
        this.dbz = lVar.axn();
        awF();
        if (f(this.dbz)) {
            this.dbL.bLN.setVisibility(0);
            this.dbL.bLY.getRoot().setVisibility(0);
            axA().a(this.dbL.bLY, this.dbz);
        } else {
            this.dbL.bLN.setVisibility(8);
            this.dbL.bLY.getRoot().setVisibility(8);
        }
        if (lVar.awR()) {
            this.dbL.bLY.bLF.setVisibility(0);
        } else {
            this.dbL.bLY.bLF.setVisibility(8);
        }
        a Jg = lVar.Jg();
        axC().a(this.dbL.afU, Jg.getImage());
        this.dbL.bnL.setText(com.iqoption.util.e.a.E(Jg));
        this.dbL.brA.setImageDrawable(this.dbz.isCall() ? axx().cZu : axx().cZv);
        this.dbL.bnN.setText(axx().c(lVar.axn()));
        this.dbL.bnl.setText(axx().i(this.dbz.getInvestment(), this.dbz.getMultiplier()));
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
        r1 = r3.dbL;
        r1 = r1.bLY;
        r2 = r3.dbz;
        r0.b(r1, r2);
    L_0x001e:
        return;
    L_0x001f:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.portfolio.component.viewholder.aa.awF():void");
    }

    public void axw() {
        if (this.dbz != null) {
            axx().a(this.dbz.Jg(), this.dbL.bMa);
        }
    }

    public void axt() {
        this.dbL.bLY.bLt.setVisibility(0);
        this.dbL.bLY.bLu.setVisibility(8);
    }
}
