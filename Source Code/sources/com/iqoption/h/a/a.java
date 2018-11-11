package com.iqoption.h.a;

import com.iqoption.util.q;
import java.text.DecimalFormat;

/* compiled from: StrikeFormatter */
public final class a {
    private DecimalFormat duM;
    private int duN;

    public a() {
        gD(6);
    }

    public a(int i) {
        gD(i);
    }

    public String format(double d) {
        return this.duM.format(d);
    }

    public void gC(int i) {
        if (this.duN != i) {
            gD(i);
        }
    }

    private void gD(int i) {
        this.duN = i;
        this.duM = q.I("0", i);
    }
}
