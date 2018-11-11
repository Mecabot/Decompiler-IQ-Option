package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.airbnb.lottie.h;

/* compiled from: NullLayer */
public class e extends a {
    void b(Canvas canvas, Matrix matrix, int i) {
    }

    e(h hVar, Layer layer) {
        super(hVar, layer);
    }

    public void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
    }
}
