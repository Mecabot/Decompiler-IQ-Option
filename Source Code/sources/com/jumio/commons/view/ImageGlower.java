package com.jumio.commons.view;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BlurMaskFilter;
import android.graphics.BlurMaskFilter.Blur;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

public class ImageGlower {
    private static int MAX_COUNT = 10;
    private AlphaAnimation lAnimation1;
    private AlphaAnimation lAnimation2;
    private int mGlowCount = 0;
    private int mGlowRadius = 24;
    private ImageView mGlowView;
    private int mHalfMargin = (this.mMargin / 2);
    private ImageView mImageView;
    private int mMargin = 0;
    private Paint mPaint;
    private Bitmap mSource;

    public ImageGlower(Bitmap bitmap, ImageView imageView, ImageView imageView2, float f) {
        this.mSource = bitmap;
        this.mImageView = imageView;
        this.mGlowView = imageView2;
        this.mPaint = new Paint();
        this.mPaint.setMaskFilter(new BlurMaskFilter((((float) this.mGlowRadius) * f) + 0.5f, Blur.SOLID));
        bitmap = Bitmap.createBitmap(this.mSource.getWidth() + this.mMargin, this.mSource.getHeight() + this.mMargin, Config.ARGB_8888);
        new Canvas(bitmap).drawBitmap(this.mSource, (float) this.mHalfMargin, (float) this.mHalfMargin, null);
        this.mImageView.setImageBitmap(bitmap);
        this.lAnimation1 = new AlphaAnimation(0.0f, 1.0f);
        this.lAnimation2 = new AlphaAnimation(1.0f, 0.0f);
        this.lAnimation1.setDuration(350);
        this.lAnimation2.setDuration(350);
        this.lAnimation1.setAnimationListener(new AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                ImageGlower.this.mGlowCount = ImageGlower.this.mGlowCount + 1;
                if (ImageGlower.this.mGlowCount < ImageGlower.MAX_COUNT) {
                    ImageGlower.this.mGlowView.startAnimation(ImageGlower.this.lAnimation2);
                }
            }
        });
        this.lAnimation2.setAnimationListener(new AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                ImageGlower.this.mGlowCount = ImageGlower.this.mGlowCount + 1;
                if (ImageGlower.this.mGlowCount < ImageGlower.MAX_COUNT) {
                    ImageGlower.this.mGlowView.startAnimation(ImageGlower.this.lAnimation1);
                }
            }
        });
    }

    public void cancel() {
        this.mGlowCount = MAX_COUNT;
    }

    public void glow(boolean z) {
        this.mGlowView.setLayoutParams(this.mImageView.getLayoutParams());
        this.mGlowView.setVisibility(z ? 0 : 4);
    }

    public void setColor(int i) {
        this.mPaint.setColor(i);
        Bitmap createBitmap = Bitmap.createBitmap(this.mSource.getWidth() + this.mMargin, this.mSource.getHeight() + this.mMargin, Config.ARGB_8888);
        createBitmap.eraseColor(0);
        new Canvas(createBitmap).drawBitmap(this.mSource.extractAlpha(), (float) this.mHalfMargin, (float) this.mHalfMargin, this.mPaint);
        this.mGlowView.setImageBitmap(createBitmap);
        this.mGlowView.setVisibility(4);
    }

    public void pulsate() {
        this.mGlowCount = 0;
        this.mGlowView.startAnimation(this.lAnimation1);
    }
}
