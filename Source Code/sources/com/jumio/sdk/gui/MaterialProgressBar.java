package com.jumio.sdk.gui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RadialGradient;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

public class MaterialProgressBar extends ImageView {
    private static final int DEFAULT_CIRCLE_BG_LIGHT = -328966;
    private static final int DEFAULT_CIRCLE_DIAMETER = 56;
    public static final int DEFAULT_TEXT_SIZE = 9;
    private static final int FILL_SHADOW_COLOR = 1023410176;
    private static final int KEY_SHADOW_COLOR = 503316480;
    private static final int SHADOW_ELEVATION = 4;
    private static final float SHADOW_RADIUS = 3.5f;
    private static final int STROKE_WIDTH_LARGE = 3;
    private static final float X_OFFSET = 0.0f;
    private static final float Y_OFFSET = 1.75f;
    private int mArrowHeight;
    private int mArrowWidth;
    private int mBackGroundColor;
    private ShapeDrawable mBgCircle;
    private boolean mCircleBackgroundEnabled;
    private int[] mColors = new int[]{ViewCompat.MEASURED_STATE_MASK};
    private int mDiameter;
    private boolean mIfDrawText;
    private int mInnerRadius;
    private AnimationListener mListener;
    private int mMax;
    private int mProgress;
    private int mProgressColor;
    private MaterialProgressDrawable mProgressDrawable;
    private int mProgressStokeWidth;
    private int mShadowRadius;
    private boolean mShowArrow;
    private int mTextColor;
    private Paint mTextPaint;
    private int mTextSize;

    private class OvalShadow extends OvalShape {
        private int mCircleDiameter;
        private RadialGradient mRadialGradient;
        private Paint mShadowPaint = new Paint();
        private int mShadowRadius;

        public OvalShadow(int i, int i2) {
            this.mShadowRadius = i;
            this.mCircleDiameter = i2;
            this.mRadialGradient = new RadialGradient(((float) this.mCircleDiameter) / 2.0f, ((float) this.mCircleDiameter) / 2.0f, (float) this.mShadowRadius, new int[]{MaterialProgressBar.FILL_SHADOW_COLOR, 0}, null, TileMode.CLAMP);
            this.mShadowPaint.setShader(this.mRadialGradient);
        }

        public void draw(Canvas canvas, Paint paint) {
            float width = ((float) MaterialProgressBar.this.getWidth()) / 2.0f;
            float height = ((float) MaterialProgressBar.this.getHeight()) / 2.0f;
            canvas.drawCircle(width, height, (((float) this.mCircleDiameter) / 2.0f) + ((float) this.mShadowRadius), this.mShadowPaint);
            canvas.drawCircle(width, height, ((float) this.mCircleDiameter) / 2.0f, paint);
        }
    }

    public final void setImageDrawable(Drawable drawable) {
    }

    public final void setImageResource(int i) {
    }

    public MaterialProgressBar(Context context) {
        super(context);
        init();
    }

    public MaterialProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public MaterialProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        float f = getContext().getResources().getDisplayMetrics().density;
        this.mBackGroundColor = DEFAULT_CIRCLE_BG_LIGHT;
        this.mProgressColor = DEFAULT_CIRCLE_BG_LIGHT;
        this.mInnerRadius = -1;
        this.mProgressStokeWidth = (int) (3.0f * f);
        this.mArrowWidth = -1;
        this.mArrowHeight = -1;
        this.mTextSize = (int) (f * 9.0f);
        this.mTextColor = ViewCompat.MEASURED_STATE_MASK;
        this.mShowArrow = false;
        this.mCircleBackgroundEnabled = false;
        this.mProgress = 0;
        this.mMax = 100;
        this.mIfDrawText = false;
        this.mTextPaint = new Paint();
        this.mTextPaint.setStyle(Style.FILL);
        this.mTextPaint.setColor(this.mTextColor);
        this.mTextPaint.setTextSize((float) this.mTextSize);
        this.mTextPaint.setAntiAlias(true);
        this.mProgressDrawable = new MaterialProgressDrawable(getContext(), this);
        super.setImageDrawable(this.mProgressDrawable);
    }

    private boolean elevationSupported() {
        return VERSION.SDK_INT >= 21;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float f = getContext().getResources().getDisplayMetrics().density;
        this.mDiameter = Math.min(getMeasuredWidth(), getMeasuredHeight());
        if (this.mDiameter <= 0) {
            this.mDiameter = ((int) f) * 56;
        }
        if (z) {
            this.mProgressDrawable.setBackgroundColor(this.mBackGroundColor);
            this.mProgressDrawable.setColorSchemeColors(this.mColors);
            this.mProgressDrawable.setSizeParameters((double) this.mDiameter, (double) this.mDiameter, this.mInnerRadius <= 0 ? ((double) (this.mDiameter - (this.mProgressStokeWidth * 2))) / 2.0d : (double) this.mInnerRadius, (double) this.mProgressStokeWidth, (float) (this.mArrowWidth < 0 ? this.mProgressStokeWidth * 4 : this.mArrowWidth), (float) (this.mArrowHeight < 0 ? this.mProgressStokeWidth * 2 : this.mArrowHeight));
            if (isShowArrow()) {
                this.mProgressDrawable.setArrowScale(1.0f);
                this.mProgressDrawable.showArrow(true);
            }
            super.setImageDrawable(null);
            super.setImageDrawable(this.mProgressDrawable);
            this.mProgressDrawable.setAlpha(255);
            this.mProgressDrawable.start();
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mIfDrawText) {
            String format = String.format("%s%%", new Object[]{Integer.valueOf(this.mProgress)});
            canvas.drawText(format, (float) ((getWidth() / 2) - ((format.length() * this.mTextSize) / 4)), (float) ((getHeight() / 2) + (this.mTextSize / 4)), this.mTextPaint);
        }
    }

    public boolean isShowArrow() {
        return this.mShowArrow;
    }

    public void setShowArrow(boolean z) {
        this.mShowArrow = z;
    }

    public final void setImageURI(Uri uri) {
        super.setImageURI(uri);
    }

    public void setAnimationListener(AnimationListener animationListener) {
        this.mListener = animationListener;
    }

    public void onAnimationStart() {
        super.onAnimationStart();
        if (this.mListener != null) {
            this.mListener.onAnimationStart(getAnimation());
        }
    }

    public void onAnimationEnd() {
        super.onAnimationEnd();
        if (this.mListener != null) {
            this.mListener.onAnimationEnd(getAnimation());
        }
    }

    public void setColorSchemeResources(int... iArr) {
        Resources resources = getResources();
        int[] iArr2 = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr2[i] = resources.getColor(iArr[i]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setColorSchemeColors(int... iArr) {
        this.mColors = iArr;
        if (this.mProgressDrawable != null) {
            this.mProgressDrawable.setColorSchemeColors(iArr);
        }
    }

    public void setBackgroundColor(@ColorInt int i) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i);
        }
    }

    public boolean isShowProgressText() {
        return this.mIfDrawText;
    }

    public void setShowProgressText(boolean z) {
        this.mIfDrawText = z;
    }

    public int getMax() {
        return this.mMax;
    }

    public void setMax(int i) {
        this.mMax = i;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void setProgress(int i) {
        if (getMax() > 0) {
            this.mProgress = i;
        }
    }

    public boolean circleBackgroundEnabled() {
        return this.mCircleBackgroundEnabled;
    }

    public void setCircleBackgroundEnabled(boolean z) {
        this.mCircleBackgroundEnabled = z;
    }

    public void setProgressStokeWidth(int i) {
        this.mProgressStokeWidth = i;
    }

    public int getVisibility() {
        return super.getVisibility();
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        if (this.mProgressDrawable != null) {
            if (i == 0) {
                this.mProgressDrawable.start();
            } else {
                this.mProgressDrawable.stop();
            }
            this.mProgressDrawable.setVisible(i == 0, false);
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mProgressDrawable != null) {
            this.mProgressDrawable.stop();
            this.mProgressDrawable.setVisible(getVisibility() == 0, false);
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mProgressDrawable != null) {
            this.mProgressDrawable.stop();
            this.mProgressDrawable.setVisible(false, false);
        }
    }
}
