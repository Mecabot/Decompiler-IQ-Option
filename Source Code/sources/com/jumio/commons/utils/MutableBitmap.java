package com.jumio.commons.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.support.v4.view.ViewCompat;

public class MutableBitmap {
    public static Bitmap copy(Bitmap bitmap) {
        return bitmap.copy(bitmap.getConfig(), true);
    }

    public static Bitmap createScaledBitmap(Bitmap bitmap, int i, int i2) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, bitmap.getConfig());
        Canvas canvas = new Canvas(createBitmap);
        Matrix matrix = new Matrix();
        matrix.setScale(((float) i) / ((float) bitmap.getWidth()), ((float) i2) / ((float) bitmap.getHeight()));
        canvas.drawBitmap(bitmap, matrix, null);
        return createBitmap;
    }

    public static void delete(Bitmap bitmap) {
        if (bitmap != null) {
            if (bitmap.isMutable()) {
                bitmap.eraseColor(ViewCompat.MEASURED_STATE_MASK);
            }
            bitmap.recycle();
        }
    }
}
