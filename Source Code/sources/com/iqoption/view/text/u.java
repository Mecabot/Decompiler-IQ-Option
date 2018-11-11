package com.iqoption.view.text;

import android.content.Context;
import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat;
import java.util.Locale;

/* compiled from: PhoneNumberTransformation */
public class u implements TransformationMethod {
    private Locale locale;

    public void onFocusChanged(View view, CharSequence charSequence, boolean z, int i, Rect rect) {
    }

    public u(Context context) {
        this.locale = context.getResources().getConfiguration().locale;
    }

    public CharSequence getTransformation(CharSequence charSequence, View view) {
        if ((charSequence == null ? 0 : charSequence.length()) == 0) {
            return charSequence;
        }
        CharSequence charSequence2 = charSequence.toString();
        try {
            PhoneNumberUtil xo = PhoneNumberUtil.xo();
            return xo.a(xo.b(charSequence2, this.locale.getCountry()), PhoneNumberFormat.INTERNATIONAL);
        } catch (NumberParseException unused) {
            return charSequence;
        }
    }
}
