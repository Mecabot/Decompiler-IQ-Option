package com.airbnb.lottie.d;

import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.a.r;
import com.airbnb.lottie.d;

/* compiled from: Utils */
public final class f {
    private static final PathMeasure lD = new PathMeasure();
    private static final Path lF = new Path();
    private static final Path oM = new Path();
    private static final float oN = ((float) Math.sqrt(2.0d));
    private static float oO = -1.0f;
    private static final float[] points = new float[4];

    public static int a(float f, float f2, float f3, float f4) {
        int i = f != 0.0f ? (int) (((float) 527) * f) : 17;
        if (f2 != 0.0f) {
            i = (int) (((float) (i * 31)) * f2);
        }
        if (f3 != 0.0f) {
            i = (int) (((float) (i * 31)) * f3);
        }
        return f4 != 0.0f ? (int) (((float) (i * 31)) * f4) : i;
    }

    public static boolean a(int i, int i2, int i3, int i4, int i5, int i6) {
        boolean z = false;
        if (i < i4) {
            return false;
        }
        if (i > i4) {
            return true;
        }
        if (i2 < i5) {
            return false;
        }
        if (i2 > i5) {
            return true;
        }
        if (i3 >= i6) {
            z = true;
        }
        return z;
    }

    public static Path b(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        Path path = new Path();
        path.moveTo(pointF.x, pointF.y);
        if (pointF3 == null || pointF4 == null || (pointF3.length() == 0.0f && pointF4.length() == 0.0f)) {
            path.lineTo(pointF2.x, pointF2.y);
        } else {
            Path path2 = path;
            path2.cubicTo(pointF3.x + pointF.x, pointF.y + pointF3.y, pointF2.x + pointF4.x, pointF2.y + pointF4.y, pointF2.x, pointF2.y);
        }
        return path;
    }

    public static float b(Matrix matrix) {
        points[0] = 0.0f;
        points[1] = 0.0f;
        points[2] = oN;
        points[3] = oN;
        matrix.mapPoints(points);
        return ((float) Math.hypot((double) (points[2] - points[0]), (double) (points[3] - points[1]))) / 2.0f;
    }

    public static void a(Path path, @Nullable r rVar) {
        if (rVar != null) {
            a(path, ((Float) rVar.dz().getValue()).floatValue() / 100.0f, ((Float) rVar.dA().getValue()).floatValue() / 100.0f, ((Float) rVar.dB().getValue()).floatValue() / 360.0f);
        }
    }

    public static void a(Path path, float f, float f2, float f3) {
        d.beginSection("applyTrimPathIfNeeded");
        lD.setPath(path, false);
        float length = lD.getLength();
        if (f == 1.0f && f2 == 0.0f) {
            d.X("applyTrimPathIfNeeded");
        } else if (length < 1.0f || ((double) Math.abs((f2 - f) - 1.0f)) < 0.01d) {
            d.X("applyTrimPathIfNeeded");
        } else {
            f *= length;
            f2 *= length;
            f3 *= length;
            float min = Math.min(f, f2) + f3;
            f = Math.max(f, f2) + f3;
            if (min >= length && f >= length) {
                min = (float) e.f(min, length);
                f = (float) e.f(f, length);
            }
            if (min < 0.0f) {
                min = (float) e.f(min, length);
            }
            if (f < 0.0f) {
                f = (float) e.f(f, length);
            }
            if (min == f) {
                path.reset();
                d.X("applyTrimPathIfNeeded");
                return;
            }
            if (min >= f) {
                min -= length;
            }
            lF.reset();
            lD.getSegment(min, f, lF, true);
            if (f > length) {
                oM.reset();
                lD.getSegment(0.0f, f % length, oM, true);
                lF.addPath(oM);
            } else if (min < 0.0f) {
                oM.reset();
                lD.getSegment(min + length, length, oM, true);
                lF.addPath(oM);
            }
            path.set(lF);
            d.X("applyTrimPathIfNeeded");
        }
    }

    public static float fo() {
        if (oO == -1.0f) {
            oO = Resources.getSystem().getDisplayMetrics().density;
        }
        return oO;
    }
}
