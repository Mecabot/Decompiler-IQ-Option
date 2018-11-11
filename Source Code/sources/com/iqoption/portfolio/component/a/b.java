package com.iqoption.portfolio.component.a;

import android.text.style.ForegroundColorSpan;
import android.widget.FrameLayout;
import com.iqoption.core.util.p;
import com.iqoption.d.aea;
import com.iqoption.d.zk;
import com.iqoption.portfolio.component.b.g;
import com.iqoption.portfolio.component.n;
import com.iqoption.portfolio.component.o;
import com.iqoption.util.bc;

/* compiled from: CfdInfoBinder */
public class b {
    private final n cYT;
    private final o cYW;

    public b(n nVar) {
        this.cYT = nVar;
        this.cYW = nVar.axx();
    }

    public void a(aea aea, g gVar) {
        double GN = gVar.avU().GN();
        aea.bDV.setText(this.cYW.e(gVar.axj(), gVar.axc()));
        aea.bDX.setText(this.cYW.aM(gVar.axd()));
        aea.bLE.setText(this.cYW.cZS.format(gVar.axe()));
        aea.brp.setText(this.cYW.B(GN));
        Double awO = gVar.awO();
        int i = 8;
        if (awO != null) {
            int awQ = gVar.awQ();
            aea.bLI.setVisibility(0);
            aea.bNF.setText(a(p.o((double) awQ), this.cYW.daa, this.cYW.e(gVar.axj(), awO.doubleValue())));
        } else {
            aea.bLI.setVisibility(8);
        }
        if (gVar.awN() != null) {
            int awP = gVar.awP();
            aea.bLG.setVisibility(0);
            aea.bNE.setText(a(p.o((double) awP), this.cYW.dab, this.cYW.e(gVar.axj(), gVar.awN().doubleValue())));
        } else {
            aea.bLG.setVisibility(8);
        }
        aea.bPw.setText(a(p.o((double) gVar.C(GN)), this.cYW.dab, this.cYW.B(GN + gVar.getSelfMarginCall())));
        if (this.cYT.e(gVar)) {
            aea.bLt.setVisibility(8);
            aea.bLu.setVisibility(0);
        } else {
            aea.bLt.setVisibility(0);
            aea.bLu.setVisibility(8);
        }
        Double commission = gVar.getCommission();
        if (commission == null) {
            aea.bDR.setVisibility(8);
        } else {
            aea.bDR.setVisibility(0);
            aea.bDS.setText(this.cYW.B(commission.doubleValue()));
        }
        commission = gVar.getSwap();
        if (commission == null) {
            aea.bLx.setVisibility(8);
            aea.bEd.setVisibility(8);
        } else {
            aea.bLx.setVisibility(0);
            aea.bEd.setVisibility(0);
            aea.bEe.setText(this.cYW.B(commission.doubleValue()));
        }
        aea.bLs.setVisibility(gVar.awS() ? 0 : 8);
        FrameLayout frameLayout = aea.bne;
        if (gVar.isWithdrawalable()) {
            i = 0;
        }
        frameLayout.setVisibility(i);
    }

    private CharSequence a(String str, ForegroundColorSpan foregroundColorSpan, String str2) {
        return new bc().bM(foregroundColorSpan).jO(str).aGw().jO(" ").jO(str2).aCT();
    }

    public void b(aea aea, g gVar) {
        aea.bLw.setText(this.cYW.ga(gVar.axj()).format(gVar.axi()));
        aea.bLs.setVisibility(gVar.awS() ? 0 : 8);
    }

    public void a(zk zkVar, g gVar) {
        double GN = gVar.avU().GN();
        zkVar.bDV.setText(this.cYW.e(gVar.axj(), gVar.axc()));
        zkVar.bLE.setText(this.cYW.cZS.format(gVar.axe()));
        zkVar.brp.setText(this.cYW.B(GN));
        int multiplier = gVar.getMultiplier();
        int i = 8;
        if (multiplier > 1) {
            zkVar.bLD.setVisibility(0);
            zkVar.bLC.setText(p.ea(multiplier));
        } else {
            zkVar.bLD.setVisibility(8);
        }
        if (gVar.awO() != null) {
            multiplier = gVar.awQ();
            zkVar.bLI.setVisibility(0);
            zkVar.bLJ.setText(p.o((double) multiplier));
        } else {
            zkVar.bLI.setVisibility(8);
        }
        if (gVar.awN() != null) {
            multiplier = gVar.awP();
            zkVar.bLG.setVisibility(0);
            zkVar.bLH.setText(p.o((double) multiplier));
        } else {
            zkVar.bLG.setVisibility(8);
        }
        zkVar.bLA.setText(p.o((double) gVar.C(GN)));
        if (this.cYT.e(gVar)) {
            zkVar.bLt.setVisibility(8);
            zkVar.bLu.setVisibility(0);
        } else {
            zkVar.bLt.setVisibility(0);
            zkVar.bLu.setVisibility(8);
        }
        Double commission = gVar.getCommission();
        if (commission == null) {
            zkVar.bDR.setVisibility(8);
        } else {
            zkVar.bDR.setVisibility(0);
            zkVar.bDS.setText(this.cYW.B(commission.doubleValue()));
        }
        commission = gVar.getSwap();
        if (commission == null) {
            zkVar.bLx.setVisibility(8);
            zkVar.bEd.setVisibility(8);
        } else {
            zkVar.bLx.setVisibility(0);
            zkVar.bEd.setVisibility(0);
            zkVar.bEe.setText(this.cYW.B(commission.doubleValue()));
        }
        zkVar.bLs.setVisibility(gVar.awS() ? 0 : 8);
        FrameLayout frameLayout = zkVar.bne;
        if (gVar.isWithdrawalable()) {
            i = 0;
        }
        frameLayout.setVisibility(i);
    }

    public void b(zk zkVar, g gVar) {
        zkVar.bLw.setText(this.cYW.ga(gVar.axj()).format(gVar.axi()));
        zkVar.bLs.setVisibility(gVar.awS() ? 0 : 8);
    }
}
