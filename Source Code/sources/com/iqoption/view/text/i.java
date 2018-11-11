package com.iqoption.view.text;

import android.text.InputFilter;

/* compiled from: DoublePrecisionFilter */
public class i implements InputFilter {
    private int precision;

    public i(int i) {
        this.precision = i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x004b A:{Splitter: B:1:0x002f, ExcHandler: java.lang.NumberFormatException (unused java.lang.NumberFormatException)} */
    /* JADX WARNING: Missing block: B:11:0x004d, code:
            return "";
     */
    public java.lang.CharSequence filter(java.lang.CharSequence r1, int r2, int r3, android.text.Spanned r4, int r5, int r6) {
        /*
        r0 = this;
        r1 = r1.subSequence(r2, r3);
        r1 = r1.toString();
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = 0;
        r3 = r4.subSequence(r3, r5);
        r3 = r3.toString();
        r2.append(r3);
        r2.append(r1);
        r1 = r4.length();
        r1 = r4.subSequence(r6, r1);
        r1 = r1.toString();
        r2.append(r1);
        r1 = r2.toString();
        java.lang.Double.parseDouble(r1);	 Catch:{ NumberFormatException -> 0x004b, NumberFormatException -> 0x004b }
        r2 = 46;
        r2 = r1.indexOf(r2);	 Catch:{ NumberFormatException -> 0x004b, NumberFormatException -> 0x004b }
        r3 = 0;
        if (r2 <= 0) goto L_0x004a;
    L_0x003b:
        r1 = r1.length();	 Catch:{ NumberFormatException -> 0x004b, NumberFormatException -> 0x004b }
        r1 = r1 - r2;
        r1 = r1 + -1;
        r2 = r0.precision;	 Catch:{ NumberFormatException -> 0x004b, NumberFormatException -> 0x004b }
        if (r1 > r2) goto L_0x0047;
    L_0x0046:
        return r3;
    L_0x0047:
        r1 = "";
        return r1;
    L_0x004a:
        return r3;
    L_0x004b:
        r1 = "";
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.view.text.i.filter(java.lang.CharSequence, int, int, android.text.Spanned, int, int):java.lang.CharSequence");
    }
}
