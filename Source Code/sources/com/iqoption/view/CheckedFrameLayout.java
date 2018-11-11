package com.iqoption.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.FrameLayout;
import com.iqoption.x.R;

public class CheckedFrameLayout extends FrameLayout implements Checkable {
    private boolean cXf;

    public CheckedFrameLayout(Context context) {
        super(context);
    }

    public CheckedFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CheckedFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setChecked(boolean z) {
        if (this.cXf != z) {
            this.cXf = z;
            findViewById(R.id.checkmark).setVisibility(this.cXf ? 0 : 4);
        }
    }

    public boolean isChecked() {
        return this.cXf;
    }

    public void toggle() {
        setChecked(this.cXf ^ 1);
    }
}
