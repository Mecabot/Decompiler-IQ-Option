package com.iqoption.charttools.c.a;

import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;

/* compiled from: DoubleIndicatorFilter */
public class a implements InputFilter {
    private double max;
    private double min;

    public a() {
        this.min = 0.1d;
        this.max = 10.0d;
    }

    public a(double d, double d2) {
        this.min = d;
        this.max = d2;
    }

    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        String charSequence2 = charSequence.subSequence(i, i2).toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(spanned.subSequence(0, i3).toString());
        stringBuilder.append(charSequence2);
        stringBuilder.append(spanned.subSequence(i4, spanned.length()).toString());
        try {
            double parseDouble = Double.parseDouble(stringBuilder.toString());
            return ((parseDouble >= this.min && parseDouble <= this.max) || TextUtils.isEmpty(spanned) || charSequence2.equals(".") || charSequence2.equals(",") || charSequence2.equals("0")) ? null : "";
        } catch (NumberFormatException unused) {
            return "";
        }
    }
}
