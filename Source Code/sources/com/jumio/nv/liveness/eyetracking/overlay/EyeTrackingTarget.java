package com.jumio.nv.liveness.eyetracking.overlay;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.support.annotation.Keep;
import android.util.TypedValue;
import android.view.View;
import com.jumio.commons.utils.ScreenUtil;
import com.jumio.nv.R;

public class EyeTrackingTarget extends View {
    private Paint a;
    private Paint b;
    private Paint c;
    private Path d;
    private Path e;
    private RectF f;
    private Matrix g;
    private int h;
    private int i;
    private int j;
    private int k;
    private float l = 0.0f;
    private float m = 1.0f;

    public EyeTrackingTarget(Context context) {
        super(context);
        setWillNotDraw(false);
        TypedValue typedValue = new TypedValue();
        Theme theme = context.getTheme();
        theme.resolveAttribute(R.attr.colorPrimary, typedValue, true);
        this.a = new Paint();
        this.a.setColor(typedValue.data);
        this.a.setStyle(Style.FILL);
        this.a.setDither(true);
        this.a.setStrokeJoin(Join.ROUND);
        this.a.setStrokeCap(Cap.ROUND);
        this.a.setAntiAlias(true);
        this.c = new Paint();
        this.c.setColor(typedValue.data);
        this.c.setStyle(Style.STROKE);
        this.c.setDither(true);
        this.c.setStrokeJoin(Join.ROUND);
        this.c.setStrokeCap(Cap.ROUND);
        this.c.setAntiAlias(true);
        this.c.setStrokeWidth((float) ScreenUtil.dpToPx(context, 6));
        theme.resolveAttribute(R.attr.netverify_scanOverlay, typedValue, true);
        this.b = new Paint();
        this.b.setColor(typedValue.data);
        this.b.setStyle(Style.STROKE);
        this.b.setDither(true);
        this.b.setStrokeJoin(Join.ROUND);
        this.b.setStrokeCap(Cap.ROUND);
        this.b.setAntiAlias(true);
        this.b.setStrokeWidth((float) ScreenUtil.dpToPx(context, 6));
        this.j = ScreenUtil.dpToPx(context, 27);
        this.k = 0;
        this.l = 0.0f;
        this.d = new Path();
        this.e = new Path();
        this.f = new RectF();
        this.g = new Matrix();
    }

    @Keep
    public void setPercent(float f) {
        if (f >= 0.0f && f <= 1.0f) {
            this.l = f;
        }
        invalidate();
    }

    @Keep
    public float getPercent() {
        return this.l;
    }

    @Keep
    public void setTargetScale(float f) {
        if (f >= 0.0f && f <= 1.0f) {
            this.k = ScreenUtil.dpToPx(getContext(), f * 23.0f);
        }
        invalidate();
    }

    @Keep
    public float getTargetScale() {
        return (float) this.k;
    }

    @Keep
    public void setBorderScale(float f) {
        this.m = f;
        invalidate();
    }

    @Keep
    public float getBorderScale() {
        return this.m;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.h = getMeasuredWidth();
        this.i = getMeasuredHeight();
        this.f.set((float) ((this.h / 2) - this.j), (float) ((this.i / 2) - this.j), (float) ((this.h / 2) + this.j), (float) ((this.i / 2) + this.j));
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.g.setScale(this.m, this.m, (float) (this.h / 2), (float) (this.i / 2));
        this.d.reset();
        this.d.addCircle((float) (this.h / 2), (float) (this.i / 2), (float) this.j, Direction.CW);
        this.d.transform(this.g);
        this.e.reset();
        this.e.addArc(this.f, 270.0f, this.l * 360.0f);
        this.e.transform(this.g);
        canvas.drawPath(this.d, this.b);
        canvas.drawPath(this.e, this.c);
        canvas.drawCircle((float) (this.h / 2), (float) (this.i / 2), (float) this.k, this.a);
    }
}
