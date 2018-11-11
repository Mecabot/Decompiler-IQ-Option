package com.iqoption.util;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;

/* compiled from: DrawUtils */
public final class aa {
    public static void a(Canvas canvas, float f, float f2, float f3, float f4, float f5, float f6, int i, float f7) {
        Paint paint = new Paint();
        paint.setColor(i);
        paint.setStyle(Style.STROKE);
        paint.setStrokeCap(Cap.ROUND);
        paint.setStrokeWidth(f7);
        paint.setAntiAlias(true);
        Path path = new Path();
        f7 = Math.max((float) ((int) ((f3 - f6) * 0.5f)), f5);
        float f8 = f + f5;
        path.moveTo(f8, f2);
        f7 += f;
        path.lineTo(f7, f2);
        f7 += f6;
        f3 += f;
        if (f7 < f3) {
            path.moveTo(f7, f2);
            path.lineTo(f3 - f5, f2);
        } else {
            path.moveTo(f3 - f5, f2);
        }
        f6 = f2 + f5;
        path.quadTo(f3, f2, f3, f6);
        f4 += f2;
        f7 = f4 - f5;
        path.lineTo(f3, f7);
        path.quadTo(f3, f4, f3 - f5, f4);
        path.lineTo(f8, f4);
        path.quadTo(f, f4, f, f7);
        path.lineTo(f, f6);
        path.quadTo(f, f2, f8, f2);
        canvas.drawPath(path, paint);
    }
}
