package com.airbnb.lottie.model;

import android.support.annotation.ColorInt;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;

@RestrictTo({Scope.LIBRARY})
/* compiled from: DocumentData */
public class b {
    @ColorInt
    public final int color;
    public final String md;
    public final double me;
    final int mf;
    public final int mg;
    final double mh;
    public final double mi;
    public final boolean mj;
    @ColorInt
    public final int strokeColor;
    public final int strokeWidth;
    public final String text;

    public b(String str, String str2, double d, int i, int i2, double d2, double d3, @ColorInt int i3, @ColorInt int i4, int i5, boolean z) {
        this.text = str;
        this.md = str2;
        this.me = d;
        this.mf = i;
        this.mg = i2;
        this.mh = d2;
        this.mi = d3;
        this.color = i3;
        this.strokeColor = i4;
        this.strokeWidth = i5;
        this.mj = z;
    }

    public int hashCode() {
        int hashCode = (((((int) (((double) (((this.text.hashCode() * 31) + this.md.hashCode()) * 31)) + this.me)) * 31) + this.mf) * 31) + this.mg;
        long doubleToLongBits = Double.doubleToLongBits(this.mh);
        return (((hashCode * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + this.color;
    }
}
