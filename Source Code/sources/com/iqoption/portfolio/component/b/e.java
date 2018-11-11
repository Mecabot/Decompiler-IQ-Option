package com.iqoption.portfolio.component.b;

import android.support.annotation.NonNull;
import com.iqoption.portfolio.a;

/* compiled from: HeaderItem */
public final class e implements f, k {
    private final a cYf;

    @NonNull
    public String Ml() {
        return "header";
    }

    public int getViewType() {
        return -2;
    }

    public e(a aVar) {
        this.cYf = aVar;
    }

    public double GN() {
        return this.cYf.GN();
    }

    public double getValue() {
        return this.cYf.getValue();
    }

    @NonNull
    public a avU() {
        return this.cYf;
    }
}
