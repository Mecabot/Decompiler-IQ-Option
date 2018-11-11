package com.jumio.commons.math;

import android.graphics.PointF;

public class MathUtils {
    public static double deg2rad(double d) {
        return (d * 3.141592653589793d) / 180.0d;
    }

    public static double rad2deg(double d) {
        return d * 57.29577951308232d;
    }

    public static PointF[] inflatePolygon(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4, int i) {
        return inflatePolygon(new PointF[]{pointF, pointF2, pointF3, pointF4}, i);
    }

    public static PointF[] inflatePolygon(PointF[] pointFArr, int i) {
        PointF[] pointFArr2 = pointFArr;
        int i2 = i;
        if (i2 == 0) {
            return pointFArr2;
        }
        if (pointFArr2.length != 4) {
            throw new IllegalArgumentException("Only quadrangular polygons are supported at the moment!");
        }
        float f = pointFArr2[0].x;
        float f2 = pointFArr2[0].y;
        float f3 = pointFArr2[1].x;
        float f4 = pointFArr2[1].y;
        float f5 = pointFArr2[2].x;
        float f6 = pointFArr2[2].y;
        float f7 = pointFArr2[3].x;
        float f8 = pointFArr2[3].y;
        PointF[] pointFArr3 = new PointF[4];
        Vector2D vector2D = new Vector2D(f, f2, f3, f4);
        float f9 = f7;
        double d = (double) i2;
        Vector2D add = vector2D.getNormalRight().unit().scale(d).add(f3, f4);
        float slope = vector2D.getSlope();
        PointF[] pointFArr4 = pointFArr3;
        float y = (float) (add.getY() - (((double) slope) * add.getX()));
        Vector2D vector2D2 = new Vector2D(f3, f4, f5, f6);
        Vector2D add2 = vector2D2.getNormalRight().unit().scale(d).add(f5, f6);
        float slope2 = vector2D2.getSlope();
        float f10 = f5;
        float y2 = (float) (add2.getY() - (((double) slope2) * add2.getX()));
        f3 = (y2 - y) / (slope - slope2);
        pointFArr4[1] = new PointF(f3, (slope2 * f3) + y2);
        f4 = f9;
        Vector2D vector2D3 = new Vector2D(f10, f6, f4, f8);
        Vector2D add3 = vector2D3.getNormalRight().unit().scale(d).add(f4, f8);
        float slope3 = vector2D3.getSlope();
        float f11 = slope;
        f3 = (float) (add3.getY() - (((double) slope3) * add3.getX()));
        y2 = (f3 - y2) / (slope2 - slope3);
        pointFArr4[2] = new PointF(y2, (slope3 * y2) + f3);
        vector2D2 = new Vector2D(f4, f8, f, f2);
        Vector2D add4 = vector2D2.getNormalRight().unit().scale(d).add(f, f2);
        slope2 = vector2D2.getSlope();
        f8 = (float) (add4.getY() - (((double) slope2) * add4.getX()));
        y2 = (f8 - f3) / (slope3 - slope2);
        pointFArr4[3] = new PointF(y2, (slope2 * y2) + f8);
        f8 = (y - f8) / (slope2 - f11);
        pointFArr4[0] = new PointF(f8, (f11 * f8) + y);
        return pointFArr4;
    }

    public static float min(float... fArr) {
        int i = 0;
        float f = fArr[0];
        int length = fArr.length;
        while (i < length) {
            f = Math.min(f, fArr[i]);
            i++;
        }
        return f;
    }

    public static float max(float... fArr) {
        int i = 0;
        float f = fArr[0];
        int length = fArr.length;
        while (i < length) {
            f = Math.max(f, fArr[i]);
            i++;
        }
        return f;
    }
}
