package com.iqoption.portfolio.component.viewholder;

import android.view.View;
import com.iqoption.analytics.k;
import com.iqoption.d.aae;
import com.iqoption.portfolio.a.r;
import com.iqoption.portfolio.component.b.m;
import com.iqoption.util.ag;
import com.iqoption.view.d.b;

/* compiled from: MicroMktOnOpenItemViewHolder */
public class u extends ao implements a {
    private final aae dby;
    private m dbz;

    public void axs() {
    }

    public u(final aae aae, r rVar) {
        super(aae.getRoot(), rVar);
        this.dby = aae;
        aae.bLL.setOnClickListener(new b() {
            public void q(View view) {
                k.a(u.this.dbz, u.this.e(u.this.dbz));
            }
        });
        aae.bLY.bLs.setOnClickListener(new b() {
            public void q(View view) {
                if (!u.this.h(u.this.dbz)) {
                    aae.bLY.bLt.setVisibility(8);
                    aae.bLY.bLu.setVisibility(0);
                    ag.b(u.this.g(u.this.dbz), new aj(u.this));
                    k.a(u.this.dbz);
                }
            }
        });
        aae.bLY.bLv.setOnClickListener(new b() {
            public void q(View view) {
                u.this.i(u.this.dbz);
            }
        });
        aae.bLY.bLy.setVisibility(8);
        aae.bLY.bLF.setVisibility(8);
    }

    public void d(m mVar) {
        this.dbz = mVar;
        awF();
        this.dby.bLZ.setText(axx().d(mVar.axe(), mVar.Xg()));
        if (f(mVar)) {
            this.dby.bLN.setVisibility(0);
            this.dby.bLY.getRoot().setVisibility(0);
            axA().a(this.dby.bLY, mVar);
        } else {
            this.dby.bLN.setVisibility(8);
            this.dby.bLY.getRoot().setVisibility(8);
        }
        this.dby.brA.setImageDrawable(mVar.isCall() ? axx().cZu : axx().cZv);
        this.dby.bnl.setText(axx().i(mVar.getInvestment(), mVar.getMultiplier()));
    }

    public void axw() {
        if (this.dbz != null) {
            axx().a(this.dbz.Jg(), this.dby.bMa);
        }
    }

    public void awF() {
        if (this.dbz != null) {
            axA().b(this.dby.bLY, this.dbz);
        }
    }

    public void axt() {
        this.dby.bLY.bLt.setVisibility(0);
        this.dby.bLY.bLu.setVisibility(8);
    }
}
