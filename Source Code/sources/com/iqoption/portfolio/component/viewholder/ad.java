package com.iqoption.portfolio.component.viewholder;

import android.view.View;
import com.iqoption.analytics.k;
import com.iqoption.d.aff;
import com.iqoption.portfolio.a.r;
import com.iqoption.portfolio.component.b.m;
import com.iqoption.util.ag;
import com.iqoption.view.d.b;

/* compiled from: MktOnOpenItemViewHolder */
public class ad extends ao implements a {
    private final aff dbT;
    private m dbz;

    public void axs() {
    }

    public ad(final aff aff, r rVar) {
        super(aff.getRoot(), rVar);
        this.dbT = aff;
        aff.bLL.setOnClickListener(new b() {
            public void q(View view) {
                k.b(ad.this.dbz, ad.this.e(ad.this.dbz));
            }
        });
        aff.bPP.bLs.setOnClickListener(new b() {
            public void q(View view) {
                if (!ad.this.h(ad.this.dbz)) {
                    aff.bPP.bLt.setVisibility(8);
                    aff.bPP.bLu.setVisibility(0);
                    ag.b(ad.this.g(ad.this.dbz), new aj(ad.this));
                    k.b(ad.this.dbz);
                }
            }
        });
        aff.bPP.bLv.setOnClickListener(new b() {
            public void q(View view) {
                ad.this.i(ad.this.dbz);
            }
        });
        aff.bPP.bLy.setVisibility(8);
        aff.bPP.bLF.setVisibility(8);
    }

    public void d(m mVar) {
        this.dbz = mVar;
        awF();
        this.dbT.bLZ.setText(axx().d(mVar.axe(), mVar.Xg()));
        if (f(mVar)) {
            this.dbT.bLN.setVisibility(0);
            this.dbT.bPP.getRoot().setVisibility(0);
            axA().a(this.dbT.bPP, mVar);
        } else {
            this.dbT.bLN.setVisibility(8);
            this.dbT.bPP.getRoot().setVisibility(8);
        }
        this.dbT.brA.setImageDrawable(mVar.isCall() ? axx().cZu : axx().cZv);
        this.dbT.bnl.setText(axx().i(mVar.getInvestment(), mVar.getMultiplier()));
    }

    public void awF() {
        if (this.dbz != null) {
            axA().b(this.dbT.bPP, this.dbz);
        }
    }

    public void axw() {
        if (this.dbz != null) {
            axx().a(this.dbz.Jg(), this.dbT.bMa);
        }
    }

    public void axt() {
        this.dbT.bPP.bLt.setVisibility(0);
        this.dbT.bPP.bLu.setVisibility(8);
    }
}
