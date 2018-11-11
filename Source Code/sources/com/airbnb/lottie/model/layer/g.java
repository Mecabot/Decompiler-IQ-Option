package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.a.b.p;
import com.airbnb.lottie.e.c;
import com.airbnb.lottie.h;
import com.airbnb.lottie.q;

/* compiled from: SolidLayer */
public class g extends a {
    @Nullable
    private a<ColorFilter, ColorFilter> kC;
    private final Path kr = new Path();
    private final RectF kt = new RectF();
    private final Paint kx = new Paint();
    private final Layer nB;
    private final float[] points = new float[8];

    g(h hVar, Layer layer) {
        super(hVar, layer);
        this.nB = layer;
        this.kx.setAlpha(0);
        this.kx.setStyle(Style.FILL);
        this.kx.setColor(layer.getSolidColor());
    }

    public void b(Canvas canvas, Matrix matrix, int i) {
        int alpha = Color.alpha(this.nB.getSolidColor());
        if (alpha != 0) {
            i = (int) (((((float) i) / 255.0f) * (((((float) alpha) / 255.0f) * ((float) ((Integer) this.lk.dM().getValue()).intValue())) / 100.0f)) * 255.0f);
            this.kx.setAlpha(i);
            if (this.kC != null) {
                this.kx.setColorFilter((ColorFilter) this.kC.getValue());
            }
            if (i > 0) {
                this.points[0] = 0.0f;
                this.points[1] = 0.0f;
                this.points[2] = (float) this.nB.eZ();
                this.points[3] = 0.0f;
                this.points[4] = (float) this.nB.eZ();
                this.points[5] = (float) this.nB.eY();
                this.points[6] = 0.0f;
                this.points[7] = (float) this.nB.eY();
                matrix.mapPoints(this.points);
                this.kr.reset();
                this.kr.moveTo(this.points[0], this.points[1]);
                this.kr.lineTo(this.points[2], this.points[3]);
                this.kr.lineTo(this.points[4], this.points[5]);
                this.kr.lineTo(this.points[6], this.points[7]);
                this.kr.lineTo(this.points[0], this.points[1]);
                this.kr.close();
                canvas.drawPath(this.kr, this.kx);
            }
        }
    }

    public void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        this.kt.set(0.0f, 0.0f, (float) this.nB.eZ(), (float) this.nB.eY());
        this.nA.mapRect(this.kt);
        rectF.set(this.kt);
    }

    public <T> void a(T t, @Nullable c<T> cVar) {
        super.a((Object) t, (c) cVar);
        if (t != q.kk) {
            return;
        }
        if (cVar == null) {
            this.kC = null;
        } else {
            this.kC = new p(cVar);
        }
    }
}
