package com.iqoption.util;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;

/* compiled from: BitmapUtils */
public class f {
    public static int dG(int i) {
        return (i >>> 24) | (i << 8);
    }

    public static int dH(int i) {
        return (i << 24) | (i >>> 8);
    }

    public static Bitmap a(Bitmap bitmap, int i, int i2) {
        float f = (float) i2;
        float width = (float) bitmap.getWidth();
        float f2 = (float) i;
        float height = (float) bitmap.getHeight();
        float max = Math.max(f / width, f2 / height);
        width *= max;
        max *= height;
        f = (f - width) / 2.0f;
        f2 = (f2 - max) / 2.0f;
        RectF rectF = new RectF(f, f2, width + f, max + f2);
        Bitmap createBitmap = Bitmap.createBitmap(i2, i, bitmap.getConfig());
        new Canvas(createBitmap).drawBitmap(bitmap, null, rectF, null);
        return createBitmap;
    }

    public static Bitmap a(Resources resources, int i, int i2, int i3) {
        Bitmap decodeResource = BitmapFactory.decodeResource(resources, i);
        int width = decodeResource.getWidth();
        int height = decodeResource.getHeight();
        float f = ((float) i2) / ((float) width);
        float f2 = ((float) i3) / ((float) height);
        Matrix matrix = new Matrix();
        matrix.postScale(f, f2);
        return Bitmap.createBitmap(decodeResource, 0, 0, width, height, matrix, true);
    }
}
