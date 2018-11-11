package com.iqoption.view.text;

import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;

/* compiled from: SplitLineTransformation */
public class v implements TransformationMethod {
    private int lines;

    public void onFocusChanged(View view, CharSequence charSequence, boolean z, int i, Rect rect) {
    }

    public v(int i) {
        if (i < 1) {
            throw new IllegalArgumentException("lines value should be greater than zero");
        }
        this.lines = i;
    }

    public void setLines(int i) {
        this.lines = i;
    }

    public CharSequence getTransformation(CharSequence charSequence, View view) {
        int length = charSequence == null ? 0 : charSequence.length();
        if (length == 0) {
            return charSequence;
        }
        String charSequence2 = charSequence.toString();
        String[] split = charSequence2.split(" ");
        if (split.length < 1) {
            return charSequence;
        }
        if (split.length <= this.lines) {
            return charSequence2.replaceAll(" ", "\n");
        }
        StringBuilder stringBuilder = new StringBuilder();
        length = Math.max(1, length / this.lines);
        int i = 0;
        int i2 = 1;
        for (String str : split) {
            if (i != 0 && i2 < this.lines && str.length() + i > length) {
                stringBuilder.append(10);
                i2++;
                i = 0;
            } else if (i > 0) {
                stringBuilder.append(' ');
                i++;
            }
            stringBuilder.append(str);
            i += str.length();
        }
        return stringBuilder.toString();
    }
}
