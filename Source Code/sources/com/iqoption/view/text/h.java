package com.iqoption.view.text;

import android.support.annotation.Nullable;
import android.text.TextWatcher;

/* compiled from: DateFormattingTextWatcher */
public class h implements TextWatcher, w {
    @Nullable
    private z dJh;
    private boolean dJk = false;
    private boolean dJl;
    private c dJm = new c();

    /* JADX WARNING: Missing block: B:9:0x0015, code:
            return;
     */
    public void beforeTextChanged(java.lang.CharSequence r1, int r2, int r3, int r4) {
        /*
        r0 = this;
        r4 = r0.dJk;
        if (r4 != 0) goto L_0x0015;
    L_0x0004:
        r4 = r0.dJl;
        if (r4 == 0) goto L_0x0009;
    L_0x0008:
        goto L_0x0015;
    L_0x0009:
        if (r3 <= 0) goto L_0x0014;
    L_0x000b:
        r1 = r0.e(r1, r2, r3);
        if (r1 == 0) goto L_0x0014;
    L_0x0011:
        r0.aJK();
    L_0x0014:
        return;
    L_0x0015:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.view.text.h.beforeTextChanged(java.lang.CharSequence, int, int, int):void");
    }

    /* JADX WARNING: Missing block: B:9:0x0015, code:
            return;
     */
    public void onTextChanged(java.lang.CharSequence r1, int r2, int r3, int r4) {
        /*
        r0 = this;
        r3 = r0.dJk;
        if (r3 != 0) goto L_0x0015;
    L_0x0004:
        r3 = r0.dJl;
        if (r3 == 0) goto L_0x0009;
    L_0x0008:
        goto L_0x0015;
    L_0x0009:
        if (r4 <= 0) goto L_0x0014;
    L_0x000b:
        r1 = r0.e(r1, r2, r4);
        if (r1 == 0) goto L_0x0014;
    L_0x0011:
        r0.aJK();
    L_0x0014:
        return;
    L_0x0015:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.view.text.h.onTextChanged(java.lang.CharSequence, int, int, int):void");
    }

    /* JADX WARNING: Missing block: B:43:0x00b4, code:
            return;
     */
    public synchronized void afterTextChanged(android.text.Editable r10) {
        /*
        r9 = this;
        monitor-enter(r9);
        r0 = r9.dJl;	 Catch:{ all -> 0x00b5 }
        r1 = 0;
        r2 = 1;
        if (r0 == 0) goto L_0x0012;
    L_0x0007:
        r10 = r10.length();	 Catch:{ all -> 0x00b5 }
        if (r10 == 0) goto L_0x000e;
    L_0x000d:
        r1 = 1;
    L_0x000e:
        r9.dJl = r1;	 Catch:{ all -> 0x00b5 }
        monitor-exit(r9);
        return;
    L_0x0012:
        r0 = r9.dJk;	 Catch:{ all -> 0x00b5 }
        if (r0 == 0) goto L_0x0018;
    L_0x0016:
        monitor-exit(r9);
        return;
    L_0x0018:
        r0 = android.text.Selection.getSelectionEnd(r10);	 Catch:{ all -> 0x00b5 }
        r0 = r9.j(r10, r0);	 Catch:{ all -> 0x00b5 }
        if (r0 == 0) goto L_0x00b3;
    L_0x0022:
        r9.dJk = r2;	 Catch:{ all -> 0x00b5 }
        r2 = r9.dJm;	 Catch:{ all -> 0x00b5 }
        r2 = r2.xf();	 Catch:{ all -> 0x00b5 }
        r4 = 0;
        r5 = r10.length();	 Catch:{ all -> 0x00b5 }
        r7 = 0;
        r8 = r0.length();	 Catch:{ all -> 0x00b5 }
        r3 = r10;
        r6 = r0;
        r3.replace(r4, r5, r6, r7, r8);	 Catch:{ all -> 0x00b5 }
        r3 = r10.toString();	 Catch:{ all -> 0x00b5 }
        r0 = r0.equals(r3);	 Catch:{ all -> 0x00b5 }
        if (r0 == 0) goto L_0x0046;
    L_0x0043:
        android.text.Selection.setSelection(r10, r2);	 Catch:{ all -> 0x00b5 }
    L_0x0046:
        r9.dJk = r1;	 Catch:{ all -> 0x00b5 }
        r10 = r9.dJh;	 Catch:{ all -> 0x00b5 }
        if (r10 == 0) goto L_0x00b3;
    L_0x004c:
        r10 = r9.dJm;	 Catch:{ all -> 0x00b5 }
        r10 = r10.aJH();	 Catch:{ all -> 0x00b5 }
        if (r10 == 0) goto L_0x0062;
    L_0x0054:
        r10 = r9.dJm;	 Catch:{ all -> 0x00b5 }
        r10 = r10.aJE();	 Catch:{ all -> 0x00b5 }
        if (r10 != 0) goto L_0x0062;
    L_0x005c:
        r10 = r9.dJh;	 Catch:{ all -> 0x00b5 }
        r10.aqs();	 Catch:{ all -> 0x00b5 }
        goto L_0x00b3;
    L_0x0062:
        r10 = r9.dJm;	 Catch:{ all -> 0x00b5 }
        r10 = r10.aJI();	 Catch:{ all -> 0x00b5 }
        if (r10 == 0) goto L_0x0078;
    L_0x006a:
        r10 = r9.dJm;	 Catch:{ all -> 0x00b5 }
        r10 = r10.aJF();	 Catch:{ all -> 0x00b5 }
        if (r10 != 0) goto L_0x0078;
    L_0x0072:
        r10 = r9.dJh;	 Catch:{ all -> 0x00b5 }
        r10.aqs();	 Catch:{ all -> 0x00b5 }
        goto L_0x00b3;
    L_0x0078:
        r10 = r9.dJm;	 Catch:{ all -> 0x00b5 }
        r10 = r10.aJJ();	 Catch:{ all -> 0x00b5 }
        if (r10 == 0) goto L_0x008e;
    L_0x0080:
        r10 = r9.dJm;	 Catch:{ all -> 0x00b5 }
        r10 = r10.aJG();	 Catch:{ all -> 0x00b5 }
        if (r10 != 0) goto L_0x008e;
    L_0x0088:
        r10 = r9.dJh;	 Catch:{ all -> 0x00b5 }
        r10.aqs();	 Catch:{ all -> 0x00b5 }
        goto L_0x00b3;
    L_0x008e:
        r10 = r9.dJm;	 Catch:{ all -> 0x00b5 }
        r10 = r10.isCompleted();	 Catch:{ all -> 0x00b5 }
        if (r10 == 0) goto L_0x00ae;
    L_0x0096:
        r10 = r9.dJh;	 Catch:{ all -> 0x00b5 }
        r0 = r9.dJm;	 Catch:{ all -> 0x00b5 }
        r0 = r0.getDay();	 Catch:{ all -> 0x00b5 }
        r1 = r9.dJm;	 Catch:{ all -> 0x00b5 }
        r1 = r1.getMonth();	 Catch:{ all -> 0x00b5 }
        r2 = r9.dJm;	 Catch:{ all -> 0x00b5 }
        r2 = r2.getYear();	 Catch:{ all -> 0x00b5 }
        r10.p(r0, r1, r2);	 Catch:{ all -> 0x00b5 }
        goto L_0x00b3;
    L_0x00ae:
        r10 = r9.dJh;	 Catch:{ all -> 0x00b5 }
        r10.aqt();	 Catch:{ all -> 0x00b5 }
    L_0x00b3:
        monitor-exit(r9);
        return;
    L_0x00b5:
        r10 = move-exception;
        monitor-exit(r9);
        throw r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.view.text.h.afterTextChanged(android.text.Editable):void");
    }

    public boolean isValid() {
        return this.dJm.isValid();
    }

    public boolean aJE() {
        return this.dJm.aJE();
    }

    public boolean aJF() {
        return this.dJm.aJF();
    }

    public boolean aJG() {
        return this.dJm.aJG();
    }

    public boolean aJH() {
        return this.dJm.aJH();
    }

    public boolean aJI() {
        return this.dJm.aJI();
    }

    public boolean aJJ() {
        return this.dJm.aJJ();
    }

    public int getDay() {
        return this.dJm.getDay();
    }

    public int getMonth() {
        return this.dJm.getMonth();
    }

    public int getYear() {
        return this.dJm.getYear();
    }

    public void setValidationListener(z zVar) {
        this.dJh = zVar;
    }

    private String j(CharSequence charSequence, int i) {
        i--;
        this.dJm.clear();
        int length = charSequence.length();
        String str = null;
        char c = 0;
        boolean z = false;
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = charSequence.charAt(i2);
            if (Character.isDigit(charAt)) {
                if (c != 0) {
                    str = d(c, z);
                    z = false;
                }
                c = charAt;
            }
            if (i2 == i) {
                z = true;
            }
        }
        return c != 0 ? d(c, z) : str;
    }

    private String d(char c, boolean z) {
        if (z) {
            return this.dJm.j(c);
        }
        return this.dJm.i(c);
    }

    private void aJK() {
        this.dJl = true;
        this.dJm.clear();
    }

    private boolean e(CharSequence charSequence, int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            if (!Character.isDigit(charSequence.charAt(i3))) {
                return true;
            }
        }
        return false;
    }
}
