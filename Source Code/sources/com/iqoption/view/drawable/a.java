package com.iqoption.view.drawable;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import com.iqoption.x.R;

/* compiled from: DashedTextViewDrawable */
public class a extends Drawable {
    private final Path ciE = new Path();
    private float dFk;
    private Paint mPaint;

    public a(@NonNull Paint paint) {
        this.mPaint = paint;
        this.dFk = paint.getStrokeWidth();
    }

    public a(@NonNull Context context, @ColorRes int i) {
        this.dFk = context.getResources().getDimension(R.dimen.dp1);
        this.mPaint = new Paint(1);
        this.mPaint.setStyle(Style.STROKE);
        this.mPaint.setStrokeCap(Cap.ROUND);
        this.mPaint.setStrokeJoin(Join.ROUND);
        this.mPaint.setStrokeWidth(this.dFk);
        this.mPaint.setPathEffect(new DashPathEffect(new float[]{this.dFk, this.dFk * 1.5f}, 0.0f));
        this.mPaint.setColor(ContextCompat.getColor(context, i));
    }

    public void draw(@NonNull Canvas canvas) {
        if (this.mPaint != null) {
            this.ciE.reset();
            this.ciE.moveTo(0.0f, ((float) canvas.getHeight()) - this.dFk);
            this.ciE.lineTo((float) canvas.getWidth(), ((float) canvas.getHeight()) - this.dFk);
            canvas.drawPath(this.ciE, this.mPaint);
        }
    }

    public void setAlpha(@IntRange(from = 0, to = 255) int i) {
        this.mPaint.setAlpha(i);
        invalidateSelf();
    }

    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public int getOpacity() {
        if (this.mPaint != null && this.mPaint.getXfermode() == null) {
            int alpha = this.mPaint.getAlpha();
            if (alpha == 0) {
                return -2;
            }
            if (alpha == 255) {
                return -1;
            }
        }
        return -3;
    }
}
