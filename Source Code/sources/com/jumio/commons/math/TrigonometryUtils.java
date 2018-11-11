package com.jumio.commons.math;

import android.graphics.Point;

public class TrigonometryUtils {
    public static double getAreaFromTrianlge(Point point, Point point2, Point point3) {
        double d = ((double) (((point.x * (point2.y - point3.y)) + (point2.x * (point3.y - point.y))) + (point3.x * (point.y - point2.y)))) / 2.0d;
        return d < 0.0d ? d * -1.0d : d;
    }

    public static double getAreaFromQuadrangle(Point point, Point point2, Point point3, Point point4) {
        return getAreaFromTrianlge(point, point2, point4) + getAreaFromTrianlge(point2, point3, point4);
    }

    public static double getDistanceBetweenTwoPoints(Point point, Point point2) {
        int i = point.x - point2.x;
        int i2 = point.y - point2.y;
        return Math.sqrt((double) ((i * i) + (i2 * i2)));
    }
}
