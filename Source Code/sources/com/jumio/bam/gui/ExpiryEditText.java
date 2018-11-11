package com.jumio.bam.gui;

import android.content.Context;
import android.util.AttributeSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import jumio.bam.r;

public class ExpiryEditText extends r {
    private String a;
    private String b;

    public ExpiryEditText(Context context) {
        super(context);
        a();
    }

    public ExpiryEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public ExpiryEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        this.a = new SimpleDateFormat("MM", Locale.getDefault()).format(new Date());
        this.b = new SimpleDateFormat("yy", Locale.getDefault()).format(new Date());
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:55:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Missing block: B:14:0x004b, code:
            if (r8.equals("0") != false) goto L_0x00e0;
     */
    /* JADX WARNING: Missing block: B:22:0x006b, code:
            if (r8.equals("2") == false) goto L_0x00e0;
     */
    /* JADX WARNING: Missing block: B:28:0x0082, code:
            if (r8.charAt(0) >= r6.b.charAt(0)) goto L_0x00df;
     */
    /* JADX WARNING: Missing block: B:47:0x00d6, code:
            if (r3 != null) goto L_0x00e0;
     */
    /* JADX WARNING: Missing block: B:50:0x00dc, code:
            if (r2 != 0) goto L_0x00e0;
     */
    protected java.lang.String a(int r7, java.lang.String r8, java.lang.String r9) {
        /*
        r6 = this;
        r0 = 0;
        r1 = r8.charAt(r0);
        r1 = java.lang.Character.isDigit(r1);
        if (r7 != 0) goto L_0x0036;
    L_0x000b:
        r2 = "";
        r2 = r8.equals(r2);
        if (r2 != 0) goto L_0x0036;
    L_0x0013:
        r2 = "0";
        r2 = r8.equals(r2);
        if (r2 != 0) goto L_0x0036;
    L_0x001b:
        r2 = "1";
        r2 = r8.equals(r2);
        if (r2 != 0) goto L_0x0036;
    L_0x0023:
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r9 = "0";
        r7.append(r9);
        r7.append(r8);
        r8 = r7.toString();
        goto L_0x00df;
    L_0x0036:
        r2 = 1;
        if (r7 != r2) goto L_0x006f;
    L_0x0039:
        r7 = r9.substring(r0, r2);
        r9 = "0";
        r9 = r7.equals(r9);
        if (r9 == 0) goto L_0x004d;
    L_0x0045:
        r9 = "0";
        r9 = r8.equals(r9);
        if (r9 != 0) goto L_0x00e0;
    L_0x004d:
        r9 = "1";
        r7 = r7.equals(r9);
        if (r7 == 0) goto L_0x00df;
    L_0x0055:
        r7 = "0";
        r7 = r8.equals(r7);
        if (r7 != 0) goto L_0x00df;
    L_0x005d:
        r7 = "1";
        r7 = r8.equals(r7);
        if (r7 != 0) goto L_0x00df;
    L_0x0065:
        r7 = "2";
        r7 = r8.equals(r7);
        if (r7 != 0) goto L_0x00df;
    L_0x006d:
        goto L_0x00e0;
    L_0x006f:
        r3 = 3;
        if (r7 != r3) goto L_0x0085;
    L_0x0072:
        r7 = r8.length();
        if (r7 == 0) goto L_0x00e0;
    L_0x0078:
        r7 = r8.charAt(r0);
        r9 = r6.b;
        r9 = r9.charAt(r0);
        if (r7 >= r9) goto L_0x00df;
    L_0x0084:
        goto L_0x00e0;
    L_0x0085:
        r4 = 4;
        if (r7 != r4) goto L_0x00df;
    L_0x0088:
        r7 = r9.substring(r3, r4);
        r3 = r6.b;
        r3 = r3.substring(r0, r2);
        r7 = r7.equals(r3);
        r3 = r8.length();
        if (r3 == 0) goto L_0x00ab;
    L_0x009c:
        r3 = r8.charAt(r0);
        r4 = r6.b;
        r4 = r4.charAt(r2);
        if (r3 >= r4) goto L_0x00a9;
    L_0x00a8:
        goto L_0x00ab;
    L_0x00a9:
        r3 = 0;
        goto L_0x00ac;
    L_0x00ab:
        r3 = 1;
    L_0x00ac:
        r4 = r8.length();
        if (r4 == 0) goto L_0x00c0;
    L_0x00b2:
        r4 = r8.charAt(r0);
        r5 = r6.b;
        r5 = r5.charAt(r2);
        if (r4 != r5) goto L_0x00c0;
    L_0x00be:
        r4 = 1;
        goto L_0x00c1;
    L_0x00c0:
        r4 = 0;
    L_0x00c1:
        r5 = 2;
        r9 = r9.substring(r0, r5);
        r9 = java.lang.Integer.parseInt(r9);
        r5 = r6.a;
        r5 = java.lang.Integer.parseInt(r5);
        if (r9 >= r5) goto L_0x00d3;
    L_0x00d2:
        goto L_0x00d4;
    L_0x00d3:
        r2 = 0;
    L_0x00d4:
        if (r7 == 0) goto L_0x00d8;
    L_0x00d6:
        if (r3 != 0) goto L_0x00e0;
    L_0x00d8:
        if (r7 == 0) goto L_0x00df;
    L_0x00da:
        if (r4 == 0) goto L_0x00df;
    L_0x00dc:
        if (r2 == 0) goto L_0x00df;
    L_0x00de:
        goto L_0x00e0;
    L_0x00df:
        r0 = r1;
    L_0x00e0:
        if (r0 == 0) goto L_0x00e3;
    L_0x00e2:
        goto L_0x00e4;
    L_0x00e3:
        r8 = 0;
    L_0x00e4:
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.bam.gui.ExpiryEditText.a(int, java.lang.String, java.lang.String):java.lang.String");
    }
}
