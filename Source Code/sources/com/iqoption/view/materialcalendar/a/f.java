package com.iqoption.view.materialcalendar.a;

import android.text.SpannableStringBuilder;
import com.iqoption.view.materialcalendar.b;

/* compiled from: MonthArrayTitleFormatter */
public class f implements g {
    private final CharSequence[] dId;

    public f(CharSequence[] charSequenceArr) {
        if (charSequenceArr == null) {
            throw new IllegalArgumentException("Label array cannot be null");
        } else if (charSequenceArr.length < 12) {
            throw new IllegalArgumentException("Label array is too short");
        } else {
            this.dId = charSequenceArr;
        }
    }

    public CharSequence o(b bVar) {
        return new SpannableStringBuilder().append(this.dId[bVar.getMonth()]).append(" ").append(String.valueOf(bVar.getYear()));
    }
}
