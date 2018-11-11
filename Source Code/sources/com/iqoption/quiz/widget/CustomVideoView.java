package com.iqoption.quiz.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;

public class CustomVideoView extends VideoView {
    private int doK = 0;
    private int doL = 0;

    public CustomVideoView(Context context) {
        super(context);
    }

    public CustomVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustomVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setDimensions(int i, int i2) {
        this.doK = i2;
        this.doL = i;
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(this.doL, this.doK);
    }
}
