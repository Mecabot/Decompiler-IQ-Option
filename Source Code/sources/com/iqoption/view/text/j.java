package com.iqoption.view.text;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.text.method.TransformationMethod;
import android.view.View;
import android.widget.TextView;
import java.util.Locale;

/* compiled from: FirstLetterTransformation */
public class j implements TransformationMethod {
    private Locale locale;

    public void onFocusChanged(View view, CharSequence charSequence, boolean z, int i, Rect rect) {
    }

    public j(Context context) {
        this.locale = context.getResources().getConfiguration().locale;
    }

    public CharSequence getTransformation(CharSequence charSequence, View view) {
        int i;
        Locale textLocale = (!(view instanceof TextView) || VERSION.SDK_INT < 17) ? null : ((TextView) view).getTextLocale();
        if (textLocale == null) {
            textLocale = this.locale;
        }
        if (charSequence == null) {
            i = 0;
        } else {
            i = charSequence.length();
        }
        if (i == 0) {
            return charSequence;
        }
        String charSequence2 = charSequence.toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(charSequence2.substring(0, 1).toUpperCase(textLocale));
        stringBuilder.append(i > 1 ? charSequence2.substring(1).toLowerCase() : "");
        return stringBuilder.toString();
    }
}
