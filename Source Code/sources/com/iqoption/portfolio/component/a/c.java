package com.iqoption.portfolio.component.a;

import android.text.style.ForegroundColorSpan;
import com.iqoption.d.aer;
import com.iqoption.d.zy;
import com.iqoption.portfolio.component.b.h;
import com.iqoption.portfolio.component.n;
import com.iqoption.portfolio.component.o;
import com.iqoption.util.bc;

/* compiled from: ExpInfoBinder */
public class c {
    private final n cYT;
    private final o cYW;

    public c(n nVar) {
        this.cYT = nVar;
        this.cYW = nVar.axx();
    }

    public void a(aer aer, h hVar) {
        aer.bLU.setText(this.cYW.aM(hVar.awU()));
        aer.brp.setText(this.cYW.B(hVar.avU().GN()));
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x013b  */
    public void b(com.iqoption.d.aer r13, com.iqoption.portfolio.component.b.h r14) {
        /*
        r12 = this;
        r0 = r14.avU();
        r1 = r0.avN();
        if (r1 == 0) goto L_0x0025;
    L_0x000a:
        r1 = r13.bLT;
        r2 = r12.cYW;
        r2 = r2.ahg;
        r1.setTextColor(r2);
        r1 = r13.bLT;
        r2 = r0.avM();
        r2 = java.lang.Double.valueOf(r2);
        r2 = com.iqoption.core.util.p.b(r2);
        r1.setText(r2);
        goto L_0x0050;
    L_0x0025:
        r1 = r0.avO();
        if (r1 == 0) goto L_0x004a;
    L_0x002b:
        r1 = r13.bLT;
        r2 = r12.cYW;
        r2 = r2.ahh;
        r1.setTextColor(r2);
        r1 = r13.bLT;
        r2 = r0.avM();
        r2 = java.lang.Math.abs(r2);
        r2 = java.lang.Double.valueOf(r2);
        r2 = com.iqoption.core.util.p.c(r2);
        r1.setText(r2);
        goto L_0x0050;
    L_0x004a:
        r1 = r13.bLT;
        r2 = 0;
        r1.setText(r2);
    L_0x0050:
        r1 = r14.axg();
        r2 = 8;
        r3 = 0;
        if (r1 == 0) goto L_0x008c;
    L_0x0059:
        r1 = r13.bEb;
        r4 = r12.cYW;
        r4 = r4.cZS;
        r5 = r14.axe();
        r4 = r4.format(r5);
        r1.setText(r4);
        r1 = r13.bDY;
        r4 = r12.cYW;
        r5 = r14.axf();
        r7 = r14.axh();
        r8 = r14.axj();
        r4 = r4.a(r5, r7, r8);
        r1.setText(r4);
        r1 = r13.bEc;
        r1.setVisibility(r3);
        r1 = r13.bDZ;
        r1.setVisibility(r3);
        goto L_0x0096;
    L_0x008c:
        r1 = r13.bEc;
        r1.setVisibility(r2);
        r1 = r13.bDZ;
        r1.setVisibility(r2);
    L_0x0096:
        r1 = r0.avK();
        r4 = 1;
        if (r1 == 0) goto L_0x00d1;
    L_0x009d:
        r1 = r13.bLW;
        r5 = r12.cYW;
        r6 = r0.getSellPnl();
        r5 = r5.B(r6);
        r5 = com.iqoption.core.util.p.gX(r5);
        r6 = r12.cYW;
        r6 = r6.daa;
        r7 = r12.cYW;
        r7 = r7.cZF;
        r8 = new java.lang.Object[r4];
        r9 = r0.avJ();
        r9 = java.lang.Double.valueOf(r9);
        r9 = com.iqoption.core.util.p.b(r9);
        r8[r3] = r9;
        r7 = java.lang.String.format(r7, r8);
        r5 = r12.b(r5, r6, r7);
        r1.setText(r5);
        goto L_0x0112;
    L_0x00d1:
        r1 = r0.avL();
        if (r1 == 0) goto L_0x0114;
    L_0x00d7:
        r1 = r13.bLW;
        r5 = r12.cYW;
        r6 = r0.getSellPnl();
        r6 = java.lang.Math.abs(r6);
        r5 = r5.B(r6);
        r5 = com.iqoption.core.util.p.gY(r5);
        r6 = r12.cYW;
        r6 = r6.dab;
        r7 = r12.cYW;
        r7 = r7.cZF;
        r8 = new java.lang.Object[r4];
        r9 = r0.avJ();
        r9 = java.lang.Math.abs(r9);
        r9 = java.lang.Double.valueOf(r9);
        r9 = com.iqoption.core.util.p.c(r9);
        r8[r3] = r9;
        r7 = java.lang.String.format(r7, r8);
        r5 = r12.b(r5, r6, r7);
        r1.setText(r5);
    L_0x0112:
        r1 = 1;
        goto L_0x011e;
    L_0x0114:
        r1 = r13.bLW;
        r5 = r12.cYW;
        r5 = r5.cZN;
        r1.setText(r5);
        r1 = 0;
    L_0x011e:
        r5 = r13.bLw;
        r6 = r12.cYW;
        r7 = r14.axj();
        r8 = r14.axi();
        r6 = r6.e(r7, r8);
        r5.setText(r6);
        r5 = r12.cYT;
        r14 = r5.e(r14);
        r5 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        if (r14 == 0) goto L_0x0151;
    L_0x013b:
        r14 = r13.bLP;
        r14.setEnabled(r3);
        r14 = r13.bLP;
        r14.setAlpha(r5);
        r14 = r13.bLQ;
        r14.setVisibility(r2);
        r13 = r13.bLR;
        r13.setVisibility(r3);
        goto L_0x01dd;
    L_0x0151:
        r14 = r13.bLQ;
        r14.setVisibility(r3);
        r14 = r13.bLR;
        r14.setVisibility(r2);
        r14 = r0.avH();
        if (r14 == 0) goto L_0x018f;
    L_0x0161:
        r14 = r13.bLQ;
        r1 = r12.cYW;
        r1 = r1.cZI;
        r2 = new java.lang.Object[r4];
        r6 = java.util.concurrent.TimeUnit.MILLISECONDS;
        r7 = r0.avI();
        r6 = r6.toSeconds(r7);
        r8 = 1;
        r10 = r6 + r8;
        r0 = java.lang.Long.valueOf(r10);
        r2[r3] = r0;
        r0 = java.lang.String.format(r1, r2);
        r14.setText(r0);
        r14 = r13.bLP;
        r14.setEnabled(r4);
        r13 = r13.bLP;
        r13.setAlpha(r5);
        goto L_0x01dd;
    L_0x018f:
        if (r1 == 0) goto L_0x01bc;
    L_0x0191:
        r14 = r12.cYW;
        r1 = r0.GN();
        r6 = r0.getSellPnl();
        r1 = r1 + r6;
        r14 = r14.B(r1);
        r0 = r13.bLQ;
        r1 = r12.cYW;
        r1 = r1.cZH;
        r2 = new java.lang.Object[r4];
        r2[r3] = r14;
        r14 = java.lang.String.format(r1, r2);
        r0.setText(r14);
        r14 = r13.bLP;
        r14.setEnabled(r4);
        r13 = r13.bLP;
        r13.setAlpha(r5);
        goto L_0x01dd;
    L_0x01bc:
        r14 = r13.bLQ;
        r0 = r12.cYW;
        r0 = r0.cZH;
        r1 = new java.lang.Object[r4];
        r2 = r12.cYW;
        r2 = r2.cZN;
        r1[r3] = r2;
        r0 = java.lang.String.format(r0, r1);
        r14.setText(r0);
        r14 = r13.bLP;
        r14.setEnabled(r3);
        r13 = r13.bLP;
        r14 = 1056964608; // 0x3f000000 float:0.5 double:5.222099017E-315;
        r13.setAlpha(r14);
    L_0x01dd:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.portfolio.component.a.c.b(com.iqoption.d.aer, com.iqoption.portfolio.component.b.h):void");
    }

    private CharSequence b(String str, ForegroundColorSpan foregroundColorSpan, String str2) {
        return new bc().bM(foregroundColorSpan).jO(str).aGw().jO(" ").jO(str2).aCT();
    }

    public void a(zy zyVar, h hVar) {
        zyVar.bLU.setText(this.cYW.aM(hVar.awU()));
        zyVar.brp.setText(this.cYW.B(hVar.avU().GN()));
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0109  */
    public void b(com.iqoption.d.zy r13, com.iqoption.portfolio.component.b.h r14) {
        /*
        r12 = this;
        r0 = r14.avU();
        r1 = r0.avN();
        if (r1 == 0) goto L_0x0025;
    L_0x000a:
        r1 = r13.bLT;
        r2 = r12.cYW;
        r2 = r2.ahg;
        r1.setTextColor(r2);
        r1 = r13.bLT;
        r2 = r0.avM();
        r2 = java.lang.Double.valueOf(r2);
        r2 = com.iqoption.core.util.p.b(r2);
        r1.setText(r2);
        goto L_0x0050;
    L_0x0025:
        r1 = r0.avO();
        if (r1 == 0) goto L_0x004a;
    L_0x002b:
        r1 = r13.bLT;
        r2 = r12.cYW;
        r2 = r2.ahh;
        r1.setTextColor(r2);
        r1 = r13.bLT;
        r2 = r0.avM();
        r2 = java.lang.Math.abs(r2);
        r2 = java.lang.Double.valueOf(r2);
        r2 = com.iqoption.core.util.p.c(r2);
        r1.setText(r2);
        goto L_0x0050;
    L_0x004a:
        r1 = r13.bLT;
        r2 = 0;
        r1.setText(r2);
    L_0x0050:
        r1 = r14.axg();
        r2 = 8;
        r3 = 0;
        if (r1 == 0) goto L_0x008c;
    L_0x0059:
        r1 = r13.bEb;
        r4 = r12.cYW;
        r4 = r4.cZS;
        r5 = r14.axe();
        r4 = r4.format(r5);
        r1.setText(r4);
        r1 = r13.bDY;
        r4 = r12.cYW;
        r5 = r14.axf();
        r7 = r14.axh();
        r8 = r14.axj();
        r4 = r4.a(r5, r7, r8);
        r1.setText(r4);
        r1 = r13.bEc;
        r1.setVisibility(r3);
        r1 = r13.bDZ;
        r1.setVisibility(r3);
        goto L_0x0096;
    L_0x008c:
        r1 = r13.bEc;
        r1.setVisibility(r2);
        r1 = r13.bDZ;
        r1.setVisibility(r2);
    L_0x0096:
        r1 = r0.avK();
        r4 = 1;
        if (r1 == 0) goto L_0x00ba;
    L_0x009d:
        r1 = r13.bLW;
        r5 = r12.cYW;
        r5 = r5.ahg;
        r1.setTextColor(r5);
        r1 = r13.bLW;
        r5 = r12.cYW;
        r6 = r0.getSellPnl();
        r5 = r5.B(r6);
        r5 = com.iqoption.core.util.p.gX(r5);
        r1.setText(r5);
        goto L_0x00e0;
    L_0x00ba:
        r1 = r0.avL();
        if (r1 == 0) goto L_0x00e2;
    L_0x00c0:
        r1 = r13.bLW;
        r5 = r12.cYW;
        r5 = r5.ahh;
        r1.setTextColor(r5);
        r1 = r13.bLW;
        r5 = r12.cYW;
        r6 = r0.getSellPnl();
        r6 = java.lang.Math.abs(r6);
        r5 = r5.B(r6);
        r5 = com.iqoption.core.util.p.gY(r5);
        r1.setText(r5);
    L_0x00e0:
        r1 = 1;
        goto L_0x00ec;
    L_0x00e2:
        r1 = r13.bLW;
        r5 = r12.cYW;
        r5 = r5.cZN;
        r1.setText(r5);
        r1 = 0;
    L_0x00ec:
        r5 = r13.bLw;
        r6 = r12.cYW;
        r7 = r14.axj();
        r8 = r14.axi();
        r6 = r6.e(r7, r8);
        r5.setText(r6);
        r5 = r12.cYT;
        r14 = r5.e(r14);
        r5 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        if (r14 == 0) goto L_0x011f;
    L_0x0109:
        r14 = r13.bLP;
        r14.setEnabled(r3);
        r14 = r13.bLP;
        r14.setAlpha(r5);
        r14 = r13.bLQ;
        r14.setVisibility(r2);
        r13 = r13.bLR;
        r13.setVisibility(r3);
        goto L_0x01ab;
    L_0x011f:
        r14 = r13.bLQ;
        r14.setVisibility(r3);
        r14 = r13.bLR;
        r14.setVisibility(r2);
        r14 = r0.avH();
        if (r14 == 0) goto L_0x015d;
    L_0x012f:
        r14 = r13.bLQ;
        r1 = r12.cYW;
        r1 = r1.cZI;
        r2 = new java.lang.Object[r4];
        r6 = java.util.concurrent.TimeUnit.MILLISECONDS;
        r7 = r0.avI();
        r6 = r6.toSeconds(r7);
        r8 = 1;
        r10 = r6 + r8;
        r0 = java.lang.Long.valueOf(r10);
        r2[r3] = r0;
        r0 = java.lang.String.format(r1, r2);
        r14.setText(r0);
        r14 = r13.bLP;
        r14.setEnabled(r4);
        r13 = r13.bLP;
        r13.setAlpha(r5);
        goto L_0x01ab;
    L_0x015d:
        if (r1 == 0) goto L_0x018a;
    L_0x015f:
        r14 = r12.cYW;
        r1 = r0.GN();
        r6 = r0.getSellPnl();
        r1 = r1 + r6;
        r14 = r14.B(r1);
        r0 = r13.bLQ;
        r1 = r12.cYW;
        r1 = r1.cZH;
        r2 = new java.lang.Object[r4];
        r2[r3] = r14;
        r14 = java.lang.String.format(r1, r2);
        r0.setText(r14);
        r14 = r13.bLP;
        r14.setEnabled(r4);
        r13 = r13.bLP;
        r13.setAlpha(r5);
        goto L_0x01ab;
    L_0x018a:
        r14 = r13.bLQ;
        r0 = r12.cYW;
        r0 = r0.cZH;
        r1 = new java.lang.Object[r4];
        r2 = r12.cYW;
        r2 = r2.cZN;
        r1[r3] = r2;
        r0 = java.lang.String.format(r0, r1);
        r14.setText(r0);
        r14 = r13.bLP;
        r14.setEnabled(r3);
        r13 = r13.bLP;
        r14 = 1056964608; // 0x3f000000 float:0.5 double:5.222099017E-315;
        r13.setAlpha(r14);
    L_0x01ab:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.portfolio.component.a.c.b(com.iqoption.d.zy, com.iqoption.portfolio.component.b.h):void");
    }
}
