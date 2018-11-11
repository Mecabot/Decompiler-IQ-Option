package com.iqoption.view.text;

import android.text.Editable;
import com.iqoption.core.util.p;

/* compiled from: CreditCardTextWatcher */
public class f extends x {
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
        CharSequence obj = editable.toString();
        CharSequence E = E(p.v(obj));
        if (!E.equals(obj)) {
            editable.replace(0, editable.length(), E);
        }
    }

    private static String E(CharSequence charSequence) {
        StringBuilder stringBuilder = new StringBuilder();
        int length = charSequence.length();
        int i = 0;
        if (length > 19) {
            charSequence = charSequence.subSequence(0, 19);
            length = 19;
        }
        while (i < length) {
            if (i > 18) {
                return stringBuilder.toString();
            }
            int i2 = i + 4;
            if (i2 < length) {
                stringBuilder.append(charSequence.subSequence(i, i2));
                stringBuilder.append(' ');
            } else {
                stringBuilder.append(charSequence.subSequence(i, length));
            }
            i = i2;
        }
        return stringBuilder.toString();
    }
}
