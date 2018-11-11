package com.iqoption.portfolio.component.a;

import android.text.style.ForegroundColorSpan;
import com.iqoption.core.util.p;
import com.iqoption.d.aaw;
import com.iqoption.d.afx;
import com.iqoption.portfolio.a.r;
import com.iqoption.portfolio.component.b.m;
import com.iqoption.portfolio.component.o;
import com.iqoption.util.bc;

/* compiled from: PendingInfoBinder */
public class e {
    private final o cYW;
    private final r daf;

    public e(r rVar) {
        this.daf = rVar;
        this.cYW = rVar.axx();
    }

    public void a(afx afx, m mVar) {
        afx.bMh.setText(this.cYW.aM(mVar.getCreateTime()));
        afx.bLE.setText(String.format(this.cYW.cZP, new Object[]{this.cYW.cZS.format(mVar.axe())}));
        afx.brp.setText(this.cYW.B(mVar.getInvestment()));
        int multiplier = mVar.getMultiplier();
        if (multiplier > 1) {
            afx.bLD.setVisibility(0);
            afx.bLC.setText(p.ea(multiplier));
        } else {
            afx.bLD.setVisibility(8);
        }
        if (mVar.awN() != null) {
            afx.bLG.setVisibility(0);
            afx.bNE.setText(a(p.o((double) mVar.awP()), this.cYW.dab, this.cYW.e(mVar.Jg().getPrecision(), mVar.awN().doubleValue())));
        } else {
            afx.bLG.setVisibility(8);
        }
        Double awO = mVar.awO();
        if (awO != null) {
            afx.bLI.setVisibility(0);
            afx.bNF.setText(a(p.o((double) mVar.awQ()), this.cYW.daa, this.cYW.e(mVar.Jg().getPrecision(), awO.doubleValue())));
        } else {
            afx.bLI.setVisibility(8);
        }
        if (this.daf.h(mVar)) {
            afx.bLt.setVisibility(8);
            afx.bLu.setVisibility(0);
            return;
        }
        afx.bLt.setVisibility(0);
        afx.bLu.setVisibility(8);
    }

    public void b(afx afx, m mVar) {
        Double axq = mVar.axq();
        if (axq != null) {
            afx.bLw.setText(this.cYW.e(mVar.Jg().getPrecision(), axq.doubleValue()));
        } else {
            afx.bLw.setText(null);
        }
    }

    public void a(aaw aaw, m mVar) {
        aaw.bMh.setText(this.cYW.aM(mVar.getCreateTime()));
        aaw.bLE.setText(String.format(this.cYW.cZP, new Object[]{this.cYW.cZS.format(mVar.axe())}));
        aaw.brp.setText(this.cYW.B(mVar.getInvestment()));
        int multiplier = mVar.getMultiplier();
        if (multiplier > 1) {
            aaw.bLD.setVisibility(0);
            aaw.bLC.setText(p.ea(multiplier));
        } else {
            aaw.bLD.setVisibility(8);
        }
        if (mVar.awN() != null) {
            aaw.bLG.setVisibility(0);
            aaw.bLH.setText(p.o((double) mVar.awP()));
        } else {
            aaw.bLG.setVisibility(8);
        }
        if (mVar.awO() != null) {
            aaw.bLI.setVisibility(0);
            aaw.bLJ.setText(p.o((double) mVar.awQ()));
        } else {
            aaw.bLI.setVisibility(8);
        }
        if (this.daf.h(mVar)) {
            aaw.bLt.setVisibility(8);
            aaw.bLu.setVisibility(0);
            return;
        }
        aaw.bLt.setVisibility(0);
        aaw.bLu.setVisibility(8);
    }

    public void b(aaw aaw, m mVar) {
        Double axq = mVar.axq();
        if (axq != null) {
            aaw.bLw.setText(this.cYW.e(mVar.Jg().getPrecision(), axq.doubleValue()));
        } else {
            aaw.bLw.setText(null);
        }
    }

    private static CharSequence a(String str, ForegroundColorSpan foregroundColorSpan, String str2) {
        return new bc().bM(foregroundColorSpan).jO(str).aGw().jO(" ").jO(str2).aCT();
    }
}
