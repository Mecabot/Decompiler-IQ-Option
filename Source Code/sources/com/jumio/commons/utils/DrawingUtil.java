package com.jumio.commons.utils;

import android.graphics.Path;
import android.graphics.Rect;

public class DrawingUtil {
    public static Path createRectWithRoundedCornersAsPath(Rect rect, int i, int i2, int i3, int i4) {
        float f;
        float f2;
        int i5 = rect.left;
        int i6 = rect.right;
        int i7 = rect.top;
        int i8 = rect.bottom;
        Path path = new Path();
        if (i == 0) {
            path.moveTo((float) i5, (float) i7);
        } else {
            path.moveTo((float) (i5 + i), (float) i7);
        }
        if (i2 == 0) {
            path.lineTo((float) i6, (float) i7);
        } else {
            float f3 = (float) i7;
            path.lineTo((float) (i6 - i), f3);
            f = (float) i6;
            path.quadTo(f, f3, f, (float) (i2 + i7));
        }
        if (i3 == 0) {
            path.lineTo((float) i6, (float) i8);
        } else {
            f2 = (float) i6;
            path.lineTo(f2, (float) (i8 - i3));
            f = (float) i8;
            path.quadTo(f2, f, (float) (i6 - i3), f);
        }
        if (i4 == 0) {
            path.lineTo((float) i5, (float) i8);
        } else {
            float f4 = (float) i8;
            path.lineTo((float) (i5 + i4), f4);
            f2 = (float) i5;
            path.quadTo(f2, f4, f2, (float) (i8 - i4));
        }
        if (i == 0) {
            path.lineTo((float) i5, (float) i7);
        } else {
            float f5 = (float) i5;
            path.lineTo(f5, (float) (i7 + i));
            f2 = (float) i7;
            path.quadTo(f5, f2, (float) (i5 + i), f2);
        }
        path.close();
        return path;
    }
}
