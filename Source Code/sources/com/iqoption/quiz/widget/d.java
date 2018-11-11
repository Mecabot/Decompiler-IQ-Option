package com.iqoption.quiz.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.Op;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.DimenRes;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0005H\u0016J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017H\u0014J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0005H\u0016J\u0012\u0010\u001a\u001a\u00020\u00112\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, aXE = {"Lcom/iqoption/quiz/widget/TopRoundCornerDrawable;", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "radiusDimenRes", "", "(Landroid/content/Context;I)V", "boundsF", "Landroid/graphics/RectF;", "paint", "Landroid/graphics/Paint;", "pathToDraw", "Landroid/graphics/Path;", "pathToOp", "radii", "", "draw", "", "canvas", "Landroid/graphics/Canvas;", "getOpacity", "onBoundsChange", "bounds", "Landroid/graphics/Rect;", "setAlpha", "alpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "quiz_release"})
/* compiled from: TopRoundCornerDrawable.kt */
public final class d extends Drawable {
    private final Path dpb = new Path();
    private final Path dpc = new Path();
    private final RectF dpd = new RectF();
    private final float[] dpe;
    private final Paint kx = new Paint(1);

    public int getOpacity() {
        return -3;
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public d(Context context, @DimenRes int i) {
        h.e(context, "context");
        float dimension = context.getResources().getDimension(i);
        this.dpe = new float[]{dimension, dimension, dimension, dimension, 0.0f, 0.0f, 0.0f, 0.0f};
    }

    public void draw(Canvas canvas) {
        h.e(canvas, "canvas");
        canvas.drawPath(this.dpc, this.kx);
    }

    protected void onBoundsChange(Rect rect) {
        h.e(rect, "bounds");
        super.onBoundsChange(rect);
        this.dpb.reset();
        this.dpc.reset();
        this.dpd.setEmpty();
        if (!rect.isEmpty()) {
            this.dpd.set(rect);
            this.dpb.addRoundRect(this.dpd, this.dpe, Direction.CCW);
            this.dpc.addRect(this.dpd, Direction.CCW);
            this.dpc.op(this.dpb, Op.DIFFERENCE);
        }
    }
}
