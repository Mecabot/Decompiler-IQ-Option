package com.iqoption.view;

import android.content.Context;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class BottomCropImage extends ImageView {
    public BottomCropImage(Context context) {
        super(context);
        setup();
    }

    public BottomCropImage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setup();
    }

    public BottomCropImage(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setup();
    }

    private void setup() {
        setScaleType(ScaleType.MATRIX);
    }

    protected boolean setFrame(int i, int i2, int i3, int i4) {
        float f = (float) (i3 - i);
        float f2 = (float) (i4 - i2);
        float intrinsicWidth = (float) getDrawable().getIntrinsicWidth();
        float intrinsicHeight = (float) getDrawable().getIntrinsicHeight();
        float max = (f > intrinsicWidth || f2 > intrinsicHeight) ? Math.max(f / intrinsicWidth, f2 / intrinsicHeight) : 1.0f;
        intrinsicWidth *= max;
        intrinsicHeight *= max;
        Matrix imageMatrix = getImageMatrix();
        imageMatrix.setScale(max, max, 0.0f, 0.0f);
        imageMatrix.postTranslate((f - intrinsicWidth) / 2.0f, f2 - intrinsicHeight);
        setImageMatrix(imageMatrix);
        return super.setFrame(i, i2, i3, i4);
    }
}
