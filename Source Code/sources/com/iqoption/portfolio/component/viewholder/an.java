package com.iqoption.portfolio.component.viewholder;

import android.view.View;
import com.google.common.util.concurrent.o;
import com.iqoption.analytics.k;
import com.iqoption.d.afz;
import com.iqoption.portfolio.a.r;
import com.iqoption.portfolio.component.b.m;
import com.iqoption.view.d.b;

/* compiled from: PendingItemViewHolder */
public final class an extends ao implements a {
    private m dbz;
    private final afz dcg;

    public void axs() {
    }

    public an(final afz afz, r rVar) {
        super(afz.getRoot(), rVar);
        this.dcg = afz;
        afz.bLL.setOnClickListener(new b() {
            public void q(View view) {
                k.b(an.this.dbz, an.this.e(an.this.dbz));
            }
        });
        afz.bPP.bLs.setOnClickListener(new b() {
            public void q(View view) {
                if (!an.this.h(an.this.dbz)) {
                    afz.bPP.bLt.setVisibility(8);
                    afz.bPP.bLu.setVisibility(0);
                    o.a(an.this.g(an.this.dbz), new aj(an.this));
                    k.b(an.this.dbz);
                }
            }
        });
        afz.bPP.bLv.setOnClickListener(new b() {
            public void q(View view) {
                an.this.i(an.this.dbz);
            }
        });
        afz.bPP.bLy.setVisibility(8);
        afz.bPP.bLF.setVisibility(8);
    }

    public void d(m mVar) {
        this.dbz = mVar;
        awF();
        this.dcg.bLZ.setText(axx().d(mVar.axe(), mVar.Xg()));
        if (f(mVar)) {
            this.dcg.bLN.setVisibility(0);
            this.dcg.bPP.getRoot().setVisibility(0);
            axA().a(this.dcg.bPP, mVar);
        } else {
            this.dcg.bLN.setVisibility(8);
            this.dcg.bPP.getRoot().setVisibility(8);
        }
        this.dcg.brA.setImageDrawable(mVar.isCall() ? axx().cZu : axx().cZv);
        this.dcg.bMi.setText(axx().e(mVar.Jg().getPrecision(), mVar.axp()));
        this.dcg.bnl.setText(axx().i(mVar.getInvestment(), mVar.getMultiplier()));
    }

    public void awF() {
        if (this.dbz != null) {
            axA().b(this.dcg.bPP, this.dbz);
        }
    }

    public void axt() {
        this.dcg.bPP.bLt.setVisibility(0);
        this.dcg.bPP.bLu.setVisibility(8);
    }
}
