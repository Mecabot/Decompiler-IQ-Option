package com.iqoption.portfolio.component.viewholder;

import android.view.View;
import com.google.common.util.concurrent.o;
import com.iqoption.analytics.k;
import com.iqoption.core.microservices.tradingengine.response.active.a;
import com.iqoption.d.afh;
import com.iqoption.portfolio.a.r;
import com.iqoption.portfolio.component.b.l;
import com.iqoption.portfolio.component.b.m;
import com.iqoption.view.d.b;

/* compiled from: MktOnOpenSingleGroupItemViewHolder */
public class ae extends ao implements a {
    private l dbF;
    private final afh dbW;
    private m dbz;

    public void axs() {
    }

    public ae(final afh afh, r rVar) {
        super(afh.getRoot(), rVar);
        this.dbW = afh;
        afh.bLL.setOnClickListener(new b() {
            public void q(View view) {
                k.b(ae.this.dbz, ae.this.e(ae.this.dbz));
            }
        });
        afh.bPP.getRoot().setOnClickListener(new b() {
            public void q(View view) {
                ae.this.j(ae.this.dbF.axn());
            }
        });
        afh.bPP.bLs.setOnClickListener(new b() {
            public void q(View view) {
                if (!ae.this.h(ae.this.dbz)) {
                    afh.bPP.bLt.setVisibility(8);
                    afh.bPP.bLu.setVisibility(0);
                    o.a(ae.this.g(ae.this.dbz), new aj(ae.this));
                    k.b(ae.this.dbz);
                }
            }
        });
        afh.bPP.bLv.setOnClickListener(new af(this));
        afh.bPP.bLF.setVisibility(8);
    }

    final /* synthetic */ void bv(View view) {
        i(this.dbF.axn());
    }

    public void a(l lVar) {
        this.dbF = lVar;
        this.dbz = lVar.axn();
        awF();
        if (f(this.dbz)) {
            this.dbW.bLN.setVisibility(0);
            this.dbW.bPP.getRoot().setVisibility(0);
            axA().a(this.dbW.bPP, this.dbz);
        } else {
            this.dbW.bLN.setVisibility(8);
            this.dbW.bPP.getRoot().setVisibility(8);
        }
        a Jg = lVar.Jg();
        this.dbW.bnN.setText(axx().c(this.dbz));
        axC().a(this.dbW.afU, Jg.getImage());
        this.dbW.bnL.setText(com.iqoption.util.e.a.E(Jg));
        this.dbW.brA.setImageDrawable(this.dbz.isCall() ? axx().cZu : axx().cZv);
        this.dbW.bnl.setText(axx().i(this.dbz.getInvestment(), this.dbz.getMultiplier()));
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
        r1 = r3.dbW;
        r1 = r1.bPP;
        r2 = r3.dbz;
        r0.b(r1, r2);
    L_0x001e:
        return;
    L_0x001f:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.portfolio.component.viewholder.ae.awF():void");
    }

    public void axw() {
        if (this.dbz != null) {
            axx().a(this.dbz.Jg(), this.dbW.bMa);
        }
    }

    public void axt() {
        this.dbW.bPP.bLt.setVisibility(0);
        this.dbW.bPP.bLu.setVisibility(8);
    }
}
