package io.card.payment;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.drawable.shapes.RoundRectShape;
import android.support.v4.view.ViewCompat;
import java.util.Arrays;

/* compiled from: Torch */
class l {
    private static final String TAG = "l";
    private float dFk;
    private boolean elk = false;
    private float ell;

    public l(float f, float f2) {
        this.ell = f;
        this.dFk = f2;
    }

    public void draw(Canvas canvas) {
        canvas.save();
        canvas.translate((-this.ell) / 2.0f, (-this.dFk) / 2.0f);
        Paint paint = new Paint();
        paint.setColor(ViewCompat.MEASURED_STATE_MASK);
        paint.setStyle(Style.STROKE);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(1.5f);
        Paint paint2 = new Paint();
        paint2.setStyle(Style.FILL);
        paint2.setColor(-1);
        if (this.elk) {
            paint2.setAlpha(192);
        } else {
            paint2.setAlpha(96);
        }
        float[] fArr = new float[8];
        Arrays.fill(fArr, 5.0f);
        RoundRectShape roundRectShape = new RoundRectShape(fArr, null, null);
        roundRectShape.resize(this.ell, this.dFk);
        roundRectShape.draw(canvas, paint2);
        roundRectShape.draw(canvas, paint);
        paint = new Paint();
        paint.setStyle(Style.FILL_AND_STROKE);
        paint.setAntiAlias(true);
        if (this.elk) {
            paint.setColor(-1);
        } else {
            paint.setColor(ViewCompat.MEASURED_STATE_MASK);
        }
        Path aTU = aTU();
        Matrix matrix = new Matrix();
        float f = this.dFk * 0.8f;
        matrix.postScale(f, f);
        aTU.transform(matrix);
        canvas.translate(this.ell / 2.0f, this.dFk / 2.0f);
        canvas.drawPath(aTU, paint);
        canvas.restore();
    }

    public void gq(boolean z) {
        this.elk = z;
    }

    private static Path aTU() {
        Path path = new Path();
        path.moveTo(10.0f, 0.0f);
        path.lineTo(0.0f, 11.0f);
        path.lineTo(6.0f, 11.0f);
        path.lineTo(2.0f, 20.0f);
        path.lineTo(13.0f, 8.0f);
        path.lineTo(7.0f, 8.0f);
        path.lineTo(10.0f, 0.0f);
        path.setLastPoint(10.0f, 0.0f);
        Matrix matrix = new Matrix();
        matrix.postTranslate(-6.5f, -10.0f);
        matrix.postScale(0.05f, 0.05f);
        path.transform(matrix);
        return path;
    }
}
