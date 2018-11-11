package com.iqoption.dialog.a.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.PointF;
import android.graphics.Shader.TileMode;
import android.support.annotation.ColorInt;
import android.support.v4.content.ContextCompat;
import com.iqoption.dialog.a.a.d.b;
import com.iqoption.x.R;

/* compiled from: DefaultGraphDrawer */
public class a implements b {
    private final Paint chA = new Paint(1);
    private final Paint chB = new Paint(1);
    private final float chC;
    private final Path chD = new Path();
    private final Path chE = new Path();
    private final PathEffect chv;
    @ColorInt
    private final int chw;
    @ColorInt
    private final int chx;
    private Paint chy;
    private float chz;

    public a(Context context) {
        Resources resources = context.getResources();
        this.chv = new CornerPathEffect((float) resources.getDimensionPixelSize(R.dimen.dp4));
        this.chw = ContextCompat.getColor(context, R.color.grey_blur_50);
        this.chx = ContextCompat.getColor(context, R.color.grey_blur_00);
        this.chA.setColor(ContextCompat.getColor(context, R.color.grey_blur));
        this.chA.setStyle(Style.STROKE);
        this.chA.setStrokeWidth((float) resources.getDimensionPixelSize(R.dimen.dp1));
        this.chA.setPathEffect(this.chv);
        this.chB.setColor(ContextCompat.getColor(context, R.color.white));
        this.chC = (float) resources.getDimensionPixelSize(R.dimen.dp2);
    }

    public void a(c cVar, Canvas canvas) {
        int pointsToDrawCount = cVar.getPointsToDrawCount();
        if (pointsToDrawCount != 0) {
            this.chD.reset();
            this.chE.reset();
            float graphHeight = cVar.getGraphHeight();
            float viewportHeight = cVar.getViewportHeight();
            int i = 0;
            PointF eg = cVar.eg(0);
            this.chD.moveTo(cVar.C(eg.x), cVar.D(eg.y));
            this.chE.moveTo(0.0f, viewportHeight);
            this.chE.lineTo(cVar.C(eg.x), cVar.D(eg.y));
            while (i < pointsToDrawCount) {
                float eh = cVar.eh(i);
                float ei = cVar.ei(i);
                this.chD.lineTo(eh, ei);
                this.chE.lineTo(eh, ei);
                i++;
            }
            int i2 = pointsToDrawCount - 1;
            this.chE.lineTo(cVar.eh(i2), viewportHeight);
            if (this.chy == null) {
                this.chy = new Paint(1);
                this.chz = graphHeight + ((float) cVar.getPaddingBottom());
                this.chy.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, this.chz, this.chw, this.chx, TileMode.CLAMP));
                this.chy.setPathEffect(this.chv);
            } else {
                viewportHeight = graphHeight / this.chz;
                if (viewportHeight > 1.0f) {
                    viewportHeight -= 1.0f;
                }
                if (viewportHeight > 0.1f) {
                    this.chz = graphHeight + ((float) cVar.getPaddingBottom());
                    this.chy.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, this.chz, this.chw, this.chx, TileMode.CLAMP));
                }
            }
            canvas.drawPath(this.chD, this.chA);
            canvas.drawPath(this.chE, this.chy);
            if (pointsToDrawCount == cVar.getPointsCount()) {
                canvas.drawCircle(cVar.eh(i2), cVar.ei(i2), this.chC, this.chB);
            }
        }
    }
}
