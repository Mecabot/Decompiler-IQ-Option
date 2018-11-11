package com.iqoption.portfolio.component.viewholder;

import android.view.View;
import com.google.common.util.concurrent.o;
import com.iqoption.analytics.k;
import com.iqoption.d.aay;
import com.iqoption.portfolio.a.r;
import com.iqoption.portfolio.component.b.m;
import com.iqoption.view.d.b;

/* compiled from: MicroPendingItemViewHolder */
public final class z extends ao implements a {
    private final aay dbI;
    private m dbz;

    public void axs() {
    }

    public z(final aay aay, r rVar) {
        super(aay.getRoot(), rVar);
        this.dbI = aay;
        aay.bLL.setOnClickListener(new b() {
            public void q(View view) {
                k.a(z.this.dbz, z.this.e(z.this.dbz));
            }
        });
        aay.bLY.bLs.setOnClickListener(new b() {
            public void q(View view) {
                if (!z.this.h(z.this.dbz)) {
                    aay.bLY.bLt.setVisibility(8);
                    aay.bLY.bLu.setVisibility(0);
                    o.a(z.this.g(z.this.dbz), new aj(z.this));
                    k.a(z.this.dbz);
                }
            }
        });
        aay.bLY.bLv.setOnClickListener(new b() {
            public void q(View view) {
                z.this.i(z.this.dbz);
            }
        });
        aay.bLY.bLy.setVisibility(8);
        aay.bLY.bLF.setVisibility(8);
    }

    public void d(m mVar) {
        this.dbz = mVar;
        awF();
        this.dbI.bLZ.setText(axx().d(mVar.axe(), mVar.Xg()));
        if (f(mVar)) {
            this.dbI.bLN.setVisibility(0);
            this.dbI.bLY.getRoot().setVisibility(0);
            axA().a(this.dbI.bLY, mVar);
        } else {
            this.dbI.bLN.setVisibility(8);
            this.dbI.bLY.getRoot().setVisibility(8);
        }
        this.dbI.brA.setImageDrawable(mVar.isCall() ? axx().cZu : axx().cZv);
        this.dbI.bMi.setText(axx().e(mVar.Jg().getPrecision(), mVar.axp()));
        this.dbI.bnl.setText(axx().i(mVar.getInvestment(), mVar.getMultiplier()));
    }

    public void awF() {
        if (this.dbz != null) {
            axA().b(this.dbI.bLY, this.dbz);
        }
    }

    public void axt() {
        this.dbI.bLY.bLt.setVisibility(0);
        this.dbI.bLY.bLu.setVisibility(8);
    }
}
