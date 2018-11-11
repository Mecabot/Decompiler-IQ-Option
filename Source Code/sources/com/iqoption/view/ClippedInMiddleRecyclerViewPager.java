package com.iqoption.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Region.Op;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.iqoption.view.drumview.recyclerviewpager.RecyclerViewPager;

public class ClippedInMiddleRecyclerViewPager extends RecyclerViewPager {
    private int W = 0;
    private int dAH = 0;
    private boolean dAI = false;

    public ClippedInMiddleRecyclerViewPager(Context context) {
        super(context);
    }

    public ClippedInMiddleRecyclerViewPager(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ClippedInMiddleRecyclerViewPager(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void t(int i, boolean z) {
        this.W = i;
        this.dAI = z;
    }

    public void onDraw(Canvas canvas) {
        int i;
        if (this.W > 0) {
            i = this.W / 2;
            if (this.dAI) {
                canvas.clipRect(0.0f, 0.0f, (float) ((canvas.getWidth() / 2) - i), (float) canvas.getHeight(), Op.REPLACE);
                canvas.clipRect((float) ((canvas.getWidth() / 2) + i), 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight(), Op.UNION);
            } else {
                canvas.clipRect((float) ((canvas.getWidth() / 2) - i), 0.0f, (float) ((canvas.getWidth() / 2) + i), (float) canvas.getHeight(), Op.REPLACE);
            }
        }
        if (this.dAH > 0) {
            i = this.dAH / 2;
            if (this.dAI) {
                canvas.clipRect(0.0f, 0.0f, (float) canvas.getWidth(), (float) ((canvas.getHeight() / 2) - i), Op.REPLACE);
                canvas.clipRect(0.0f, (float) ((canvas.getHeight() / 2) + i), (float) canvas.getWidth(), (float) canvas.getHeight(), Op.UNION);
            } else {
                canvas.clipRect(0.0f, (float) ((canvas.getHeight() / 2) - i), (float) canvas.getWidth(), (float) ((canvas.getHeight() / 2) + i), Op.REPLACE);
            }
        }
        super.onDraw(canvas);
    }
}
