package com.iqoption.view.materialcalendar.a;

/* compiled from: ArrayWeekDayFormatter */
public class a implements h {
    private final CharSequence[] dIb;

    public a(CharSequence[] charSequenceArr) {
        if (charSequenceArr == null) {
            throw new IllegalArgumentException("Cannot be null");
        } else if (charSequenceArr.length != 7) {
            throw new IllegalArgumentException("Array must contain exactly 7 elements");
        } else {
            this.dIb = charSequenceArr;
        }
    }

    public CharSequence ho(int i) {
        return this.dIb[i - 1];
    }
}
