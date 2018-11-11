package com.iqoption.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import com.iqoption.b.b;

public class SelectionButton extends AppCompatButton {
    int dDD;
    ColorStateList dDE;

    public SelectionButton(Context context) {
        this(context, null);
    }

    public SelectionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SelectionButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dDD = -1;
        d(attributeSet);
    }

    private void d(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, b.SelectionButton);
            this.dDD = obtainStyledAttributes.getColor(1, -1);
            this.dDE = obtainStyledAttributes.getColorStateList(2);
            setSelected(obtainStyledAttributes.getBoolean(0, false));
            obtainStyledAttributes.recycle();
        }
    }

    public void setSelected(boolean z) {
        super.setSelected(z);
        if (z) {
            setTextColor(this.dDD);
        } else {
            setTextColor(this.dDE);
        }
    }
}
