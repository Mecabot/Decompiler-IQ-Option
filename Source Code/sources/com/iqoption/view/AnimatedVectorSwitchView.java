package com.iqoption.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import com.iqoption.b.b;

public class AnimatedVectorSwitchView extends AppCompatImageView {
    private boolean dAm = false;
    private AnimatedVectorDrawableCompat dAn;
    private AnimatedVectorDrawableCompat dAo;

    public AnimatedVectorSwitchView(Context context) {
        super(context);
    }

    public AnimatedVectorSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context, attributeSet);
    }

    public AnimatedVectorSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b(context, attributeSet);
    }

    private void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.AnimatedVectorSwitchView, 0, 0);
        try {
            this.dAm = obtainStyledAttributes.getBoolean(0, false);
            this.dAn = AnimatedVectorDrawableCompat.create(context, obtainStyledAttributes.getResourceId(2, 0));
            this.dAo = AnimatedVectorDrawableCompat.create(context, obtainStyledAttributes.getResourceId(1, 0));
            setSwitched(this.dAm);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public boolean aHX() {
        return this.dAm;
    }

    public void setSwitched(boolean z) {
        this.dAm = z;
        Drawable drawable = this.dAm ? this.dAo : this.dAn;
        setImageDrawable(drawable);
        drawable.invalidateSelf();
        ViewCompat.postInvalidateOnAnimation(this);
    }

    public void setAnimatedSwitched(boolean z) {
        if (this.dAm != z) {
            this.dAm = z;
            aHY();
            return;
        }
        setSwitched(z);
    }

    private void aHY() {
        Drawable drawable = this.dAm ? this.dAn : this.dAo;
        setImageDrawable(drawable);
        drawable.invalidateSelf();
        drawable.start();
    }
}
