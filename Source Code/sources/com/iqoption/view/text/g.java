package com.iqoption.view.text;

import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;

/* compiled from: CreditCardTransformation */
public class g implements TransformationMethod {
    private static boolean B(char c) {
        return c >= '0' && c <= '9';
    }

    public void onFocusChanged(View view, CharSequence charSequence, boolean z, int i, Rect rect) {
    }

    public CharSequence getTransformation(CharSequence charSequence, View view) {
        if ((charSequence == null ? 0 : charSequence.length()) == 0) {
            return charSequence;
        }
        return E(v(charSequence.toString()));
    }

    private static String E(CharSequence charSequence) {
        StringBuilder stringBuilder = new StringBuilder();
        int length = charSequence.length();
        for (int i = 0; i < length; i += 4) {
            if (i < 16) {
                int i2 = i + 4;
                if (i2 < length) {
                    stringBuilder.append(charSequence.subSequence(i, i2));
                    stringBuilder.append(' ');
                }
            }
            stringBuilder.append(charSequence.subSequence(i, length));
        }
        return stringBuilder.toString();
    }

    private static String v(CharSequence charSequence) {
        StringBuilder stringBuilder = new StringBuilder(16);
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            char charAt = charSequence.charAt(i);
            if (B(charAt)) {
                stringBuilder.append(charAt);
            }
        }
        return stringBuilder.toString();
    }
}
