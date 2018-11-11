package com.facebook.appevents.codeless.internal;

import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.View;
import android.widget.TextView;

/* compiled from: SensitiveUserDataUtils */
public class b {
    public static boolean e(View view) {
        boolean z = false;
        if (!(view instanceof TextView)) {
            return false;
        }
        TextView textView = (TextView) view;
        if (a(textView) || f(textView) || c(textView) || d(textView) || e(textView) || b(textView)) {
            z = true;
        }
        return z;
    }

    private static boolean a(TextView textView) {
        if (textView.getInputType() == 128) {
            return true;
        }
        return textView.getTransformationMethod() instanceof PasswordTransformationMethod;
    }

    private static boolean b(TextView textView) {
        if (textView.getInputType() == 32) {
            return true;
        }
        CharSequence l = d.l(textView);
        return (l == null || l.length() == 0) ? false : Patterns.EMAIL_ADDRESS.matcher(l).matches();
    }

    private static boolean c(TextView textView) {
        return textView.getInputType() == 96;
    }

    private static boolean d(TextView textView) {
        return textView.getInputType() == 112;
    }

    private static boolean e(TextView textView) {
        return textView.getInputType() == 3;
    }

    private static boolean f(TextView textView) {
        String replaceAll = d.l(textView).replaceAll("\\s", "");
        int length = replaceAll.length();
        boolean z = false;
        if (length < 12 || length > 19) {
            return false;
        }
        int i = 0;
        int i2 = 0;
        for (length--; length >= 0; length--) {
            char charAt = replaceAll.charAt(length);
            if (charAt < '0' || charAt > '9') {
                return false;
            }
            int i3 = charAt - 48;
            if (i2 != 0) {
                i3 *= 2;
                if (i3 > 9) {
                    i3 = (i3 % 10) + 1;
                }
            }
            i += i3;
            i2 ^= 1;
        }
        if (i % 10 == 0) {
            z = true;
        }
        return z;
    }
}
