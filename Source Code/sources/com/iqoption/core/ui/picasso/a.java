package com.iqoption.core.ui.picasso;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;
import com.squareup.picasso.Transformation;

/* compiled from: CircleTransformation */
public class a implements Transformation {
    private int bbT;
    private int bbU;
    private int bbV;
    private int bbW;
    private a bbX;
    private a bbY;

    /* compiled from: CircleTransformation */
    public interface a {
        void g(Canvas canvas);
    }

    public String key() {
        return "circle";
    }

    public Bitmap transform(Bitmap bitmap) {
        int min = Math.min(bitmap.getWidth() - this.bbT, bitmap.getHeight() - this.bbU);
        int max = Math.max(((bitmap.getWidth() - min) / 2) + this.bbV, 0);
        int max2 = Math.max(((bitmap.getHeight() - min) / 2) + this.bbW, 0);
        if (max + min > bitmap.getWidth()) {
            max = Math.max(bitmap.getWidth() - min, 0);
        }
        if (max2 + min > bitmap.getHeight()) {
            max2 = Math.max(bitmap.getHeight() - min, 0);
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, max, max2, min, min);
        if (createBitmap != bitmap) {
            bitmap.recycle();
        }
        bitmap = Bitmap.createBitmap(min, min, bitmap.getConfig());
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setShader(new BitmapShader(createBitmap, TileMode.CLAMP, TileMode.CLAMP));
        paint.setAntiAlias(true);
        float f = ((float) min) / 2.0f;
        if (this.bbX != null) {
            this.bbX.g(canvas);
        }
        canvas.drawCircle(f, f, f, paint);
        if (this.bbY != null) {
            this.bbY.g(canvas);
        }
        createBitmap.recycle();
        return bitmap;
    }
}
