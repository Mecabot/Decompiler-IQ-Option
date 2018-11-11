package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.widget.ImageView;
import com.squareup.picasso.Picasso.LoadedFrom;

final class PicassoDrawable extends BitmapDrawable {
    private static final Paint DEBUG_PAINT = new Paint();
    private static final float FADE_DURATION = 200.0f;
    int alpha = 255;
    boolean animating;
    private final boolean debugging;
    private final float density;
    private final LoadedFrom loadedFrom;
    Drawable placeholder;
    long startTimeMillis;

    static void setBitmap(ImageView imageView, Context context, Bitmap bitmap, LoadedFrom loadedFrom, boolean z, boolean z2) {
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            ((AnimationDrawable) drawable).stop();
        }
        imageView.setImageDrawable(new PicassoDrawable(context, bitmap, drawable, loadedFrom, z, z2));
    }

    static void setPlaceholder(ImageView imageView, Drawable drawable) {
        imageView.setImageDrawable(drawable);
        if (imageView.getDrawable() instanceof AnimationDrawable) {
            ((AnimationDrawable) imageView.getDrawable()).start();
        }
    }

    PicassoDrawable(Context context, Bitmap bitmap, Drawable drawable, LoadedFrom loadedFrom, boolean z, boolean z2) {
        super(context.getResources(), bitmap);
        this.debugging = z2;
        this.density = context.getResources().getDisplayMetrics().density;
        this.loadedFrom = loadedFrom;
        Object obj = (loadedFrom == LoadedFrom.MEMORY || z) ? null : 1;
        if (obj != null) {
            this.placeholder = drawable;
            this.animating = true;
            this.startTimeMillis = SystemClock.uptimeMillis();
        }
    }

    public void draw(Canvas canvas) {
        if (this.animating) {
            float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.startTimeMillis)) / FADE_DURATION;
            if (uptimeMillis >= 1.0f) {
                this.animating = false;
                this.placeholder = null;
                super.draw(canvas);
            } else {
                if (this.placeholder != null) {
                    this.placeholder.draw(canvas);
                }
                super.setAlpha((int) (((float) this.alpha) * uptimeMillis));
                super.draw(canvas);
                super.setAlpha(this.alpha);
                if (VERSION.SDK_INT <= 10) {
                    invalidateSelf();
                }
            }
        } else {
            super.draw(canvas);
        }
        if (this.debugging) {
            drawDebugIndicator(canvas);
        }
    }

    public void setAlpha(int i) {
        this.alpha = i;
        if (this.placeholder != null) {
            this.placeholder.setAlpha(i);
        }
        super.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.placeholder != null) {
            this.placeholder.setColorFilter(colorFilter);
        }
        super.setColorFilter(colorFilter);
    }

    protected void onBoundsChange(Rect rect) {
        if (this.placeholder != null) {
            this.placeholder.setBounds(rect);
        }
        super.onBoundsChange(rect);
    }

    private void drawDebugIndicator(Canvas canvas) {
        DEBUG_PAINT.setColor(-1);
        canvas.drawPath(getTrianglePath(0, 0, (int) (this.density * 16.0f)), DEBUG_PAINT);
        DEBUG_PAINT.setColor(this.loadedFrom.debugColor);
        canvas.drawPath(getTrianglePath(0, 0, (int) (this.density * 15.0f)), DEBUG_PAINT);
    }

    private static Path getTrianglePath(int i, int i2, int i3) {
        Path path = new Path();
        float f = (float) i;
        float f2 = (float) i2;
        path.moveTo(f, f2);
        path.lineTo((float) (i + i3), f2);
        path.lineTo(f, (float) (i2 + i3));
        return path;
    }
}
