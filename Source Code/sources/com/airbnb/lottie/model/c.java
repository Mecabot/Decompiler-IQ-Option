package com.airbnb.lottie.model;

import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;

@RestrictTo({Scope.LIBRARY})
/* compiled from: Font */
public class c {
    private final float ascent;
    private final String mk;
    private final String ml;
    private final String name;

    public c(String str, String str2, String str3, float f) {
        this.mk = str;
        this.name = str2;
        this.ml = str3;
        this.ascent = f;
    }

    public String getFamily() {
        return this.mk;
    }

    public String getName() {
        return this.name;
    }

    public String dS() {
        return this.ml;
    }
}
