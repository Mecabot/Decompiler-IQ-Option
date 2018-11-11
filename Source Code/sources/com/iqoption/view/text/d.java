package com.iqoption.view.text;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.text.method.TransformationMethod;
import android.view.View;
import android.widget.TextView;
import com.google.common.base.Joiner;
import com.google.common.base.k;
import com.google.common.collect.s;
import java.util.Locale;

/* compiled from: CamelSpaceTransformation */
public class d implements TransformationMethod {
    private Locale locale;

    public void onFocusChanged(View view, CharSequence charSequence, boolean z, int i, Rect rect) {
    }

    public d(Context context) {
        this.locale = context.getResources().getConfiguration().locale;
    }

    public CharSequence getTransformation(CharSequence charSequence, View view) {
        int i;
        final Locale cj = cj(view);
        if (charSequence == null) {
            i = 0;
        } else {
            i = charSequence.length();
        }
        if (i == 0) {
            return charSequence;
        }
        return Joiner.e(' ').join(s.a(k.f(' ').b(charSequence), new com.google.common.base.d<String, String>() {
            /* renamed from: cH */
            public String apply(String str) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str.substring(0, 1).toUpperCase(cj));
                stringBuilder.append(str.length() > 1 ? str.substring(1) : "");
                return stringBuilder.toString();
            }
        }));
    }

    private Locale cj(View view) {
        Locale textLocale = (!(view instanceof TextView) || VERSION.SDK_INT < 17) ? null : ((TextView) view).getTextLocale();
        return textLocale == null ? this.locale : textLocale;
    }
}
