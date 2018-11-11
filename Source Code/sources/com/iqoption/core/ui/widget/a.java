package com.iqoption.core.ui.widget;

import android.text.InputFilter;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J:\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H\u0016J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, aXE = {"Lcom/iqoption/core/ui/widget/ExtendedBigDecimalPrecisionFilter;", "Landroid/text/InputFilter;", "precision", "", "(I)V", "filter", "", "source", "start", "end", "dest", "Landroid/text/Spanned;", "dstart", "dend", "setPrecision", "", "core_release"})
/* compiled from: ExtendedBigDecimalPrecisionFilter.kt */
public final class a implements InputFilter {
    private int precision;

    public a(int i) {
        this.precision = i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0068 A:{Splitter: B:1:0x003a, ExcHandler: java.lang.NumberFormatException (unused java.lang.NumberFormatException)} */
    /* JADX WARNING: Missing block: B:16:0x006c, code:
            return "";
     */
    public java.lang.CharSequence filter(java.lang.CharSequence r2, int r3, int r4, android.text.Spanned r5, int r6, int r7) {
        /*
        r1 = this;
        r0 = "source";
        kotlin.jvm.internal.h.e(r2, r0);
        r0 = "dest";
        kotlin.jvm.internal.h.e(r5, r0);
        r2 = r2.subSequence(r3, r4);
        r2 = r2.toString();
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = 0;
        r4 = r5.subSequence(r4, r6);
        r4 = r4.toString();
        r3.append(r4);
        r3.append(r2);
        r2 = r5.length();
        r2 = r5.subSequence(r7, r2);
        r2 = r2.toString();
        r3.append(r2);
        r2 = r3.toString();
        r3 = "00";
        r3 = kotlin.jvm.internal.h.E(r2, r3);	 Catch:{ NumberFormatException -> 0x0068, NumberFormatException -> 0x0068 }
        if (r3 == 0) goto L_0x0047;
    L_0x0042:
        r2 = ".0";
        r2 = (java.lang.CharSequence) r2;	 Catch:{ NumberFormatException -> 0x0068, NumberFormatException -> 0x0068 }
        return r2;
    L_0x0047:
        r3 = ".";
        r3 = kotlin.jvm.internal.h.E(r2, r3);	 Catch:{ NumberFormatException -> 0x0068, NumberFormatException -> 0x0068 }
        if (r3 == 0) goto L_0x0054;
    L_0x004f:
        r2 = "0.";
        r2 = (java.lang.CharSequence) r2;	 Catch:{ NumberFormatException -> 0x0068, NumberFormatException -> 0x0068 }
        return r2;
    L_0x0054:
        r3 = new java.math.BigDecimal;	 Catch:{ NumberFormatException -> 0x0068, NumberFormatException -> 0x0068 }
        r3.<init>(r2);	 Catch:{ NumberFormatException -> 0x0068, NumberFormatException -> 0x0068 }
        r2 = r3.scale();	 Catch:{ NumberFormatException -> 0x0068, NumberFormatException -> 0x0068 }
        r3 = r1.precision;	 Catch:{ NumberFormatException -> 0x0068, NumberFormatException -> 0x0068 }
        if (r2 > r3) goto L_0x0063;
    L_0x0061:
        r2 = 0;
        goto L_0x0067;
    L_0x0063:
        r2 = "";
        r2 = (java.lang.CharSequence) r2;	 Catch:{ NumberFormatException -> 0x0068, NumberFormatException -> 0x0068 }
    L_0x0067:
        return r2;
    L_0x0068:
        r2 = "";
        r2 = (java.lang.CharSequence) r2;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.core.ui.widget.a.filter(java.lang.CharSequence, int, int, android.text.Spanned, int, int):java.lang.CharSequence");
    }
}
