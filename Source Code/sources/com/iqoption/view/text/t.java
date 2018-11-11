package com.iqoption.view.text;

import android.telephony.PhoneNumberUtils;
import android.text.TextWatcher;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.b;
import java.util.Locale;

/* compiled from: PhoneNumberFormattingTextWatcherCompat */
public class t implements TextWatcher {
    private b dJC;
    private boolean dJk;
    private boolean dJl;

    public t() {
        this(Locale.getDefault().getCountry());
    }

    public t(String str) {
        this.dJk = false;
        if (str == null) {
            throw new IllegalArgumentException();
        }
        this.dJC = PhoneNumberUtil.xo().dp(str);
    }

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
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.view.text.t.beforeTextChanged(java.lang.CharSequence, int, int, int):void");
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
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.view.text.t.onTextChanged(java.lang.CharSequence, int, int, int):void");
    }

    /* JADX WARNING: Missing block: B:23:0x0049, code:
            return;
     */
    public synchronized void afterTextChanged(android.text.Editable r11) {
        /*
        r10 = this;
        monitor-enter(r10);
        r0 = r10.dJl;	 Catch:{ all -> 0x004a }
        r1 = 0;
        r2 = 1;
        if (r0 == 0) goto L_0x0012;
    L_0x0007:
        r11 = r11.length();	 Catch:{ all -> 0x004a }
        if (r11 == 0) goto L_0x000e;
    L_0x000d:
        r1 = 1;
    L_0x000e:
        r10.dJl = r1;	 Catch:{ all -> 0x004a }
        monitor-exit(r10);
        return;
    L_0x0012:
        r0 = r10.dJk;	 Catch:{ all -> 0x004a }
        if (r0 == 0) goto L_0x0018;
    L_0x0016:
        monitor-exit(r10);
        return;
    L_0x0018:
        r0 = android.text.Selection.getSelectionEnd(r11);	 Catch:{ all -> 0x004a }
        r0 = r10.j(r11, r0);	 Catch:{ all -> 0x004a }
        if (r0 == 0) goto L_0x0048;
    L_0x0022:
        r3 = r10.dJC;	 Catch:{ all -> 0x004a }
        r9 = r3.xf();	 Catch:{ all -> 0x004a }
        r10.dJk = r2;	 Catch:{ all -> 0x004a }
        r4 = 0;
        r5 = r11.length();	 Catch:{ all -> 0x004a }
        r7 = 0;
        r8 = r0.length();	 Catch:{ all -> 0x004a }
        r3 = r11;
        r6 = r0;
        r3.replace(r4, r5, r6, r7, r8);	 Catch:{ all -> 0x004a }
        r2 = r11.toString();	 Catch:{ all -> 0x004a }
        r0 = r0.equals(r2);	 Catch:{ all -> 0x004a }
        if (r0 == 0) goto L_0x0046;
    L_0x0043:
        android.text.Selection.setSelection(r11, r9);	 Catch:{ all -> 0x004a }
    L_0x0046:
        r10.dJk = r1;	 Catch:{ all -> 0x004a }
    L_0x0048:
        monitor-exit(r10);
        return;
    L_0x004a:
        r11 = move-exception;
        monitor-exit(r10);
        throw r11;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.view.text.t.afterTextChanged(android.text.Editable):void");
    }

    private String j(CharSequence charSequence, int i) {
        i--;
        this.dJC.clear();
        int length = charSequence.length();
        String str = null;
        char c = 0;
        boolean z = false;
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = charSequence.charAt(i2);
            if (PhoneNumberUtils.isNonSeparator(charAt)) {
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
            return this.dJC.j(c);
        }
        return this.dJC.i(c);
    }

    private void aJK() {
        this.dJl = true;
        this.dJC.clear();
    }

    private boolean e(CharSequence charSequence, int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            if (!PhoneNumberUtils.isNonSeparator(charSequence.charAt(i3))) {
                return true;
            }
        }
        return false;
    }
}
