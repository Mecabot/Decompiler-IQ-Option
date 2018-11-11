package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.support.v7.cardview.R;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;

public class CardView2 extends FrameLayout {
    private static final int[] COLOR_BACKGROUND_ATTR = new int[]{16842801};
    private static final CardViewImpl IMPL;
    private final CardViewDelegate mCardViewDelegate = new CardViewDelegate() {
        private Drawable mCardBackground;

        public void setCardBackground(Drawable drawable) {
            this.mCardBackground = drawable;
            CardView2.this.setBackgroundDrawable(drawable);
        }

        public boolean getUseCompatPadding() {
            return CardView2.this.getUseCompatPadding();
        }

        public boolean getPreventCornerOverlap() {
            return CardView2.this.getPreventCornerOverlap();
        }

        public void setShadowPadding(int i, int i2, int i3, int i4) {
            CardView2.this.mShadowBounds.set(i, i2, i3, i4);
            super.setPadding(i + CardView2.this.mContentPadding.left, i2 + CardView2.this.mContentPadding.top, i3 + CardView2.this.mContentPadding.right, i4 + CardView2.this.mContentPadding.bottom);
        }

        public void setMinWidthHeightInternal(int i, int i2) {
            if (i > CardView2.this.mUserSetMinWidth) {
                super.setMinimumWidth(i);
            }
            if (i2 > CardView2.this.mUserSetMinHeight) {
                super.setMinimumHeight(i2);
            }
        }

        public Drawable getCardBackground() {
            return this.mCardBackground;
        }

        public View getCardView() {
            return CardView2.this;
        }
    };
    private boolean mCompatPadding;
    private final Rect mContentPadding = new Rect();
    private boolean mPreventCornerOverlap;
    private final Rect mShadowBounds = new Rect();
    private int mUserSetMinHeight;
    private int mUserSetMinWidth;

    static class CardViewEclairMr1 implements CardViewImpl {
        final RectF sCornerRect = new RectF();

        public void onCompatPaddingChanged(CardViewDelegate cardViewDelegate) {
        }

        CardViewEclairMr1() {
        }

        public void initStatic() {
            RoundRectDrawableWithShadow.sRoundRectHelper = new RoundRectHelper() {
                public void drawRoundRect(Canvas canvas, RectF rectF, float f, Paint paint) {
                    Canvas canvas2 = canvas;
                    RectF rectF2 = rectF;
                    float f2 = 2.0f * f;
                    float width = (rectF.width() - f2) - 1.0f;
                    float height = (rectF.height() - f2) - 1.0f;
                    if (f >= 1.0f) {
                        float f3 = f + 0.5f;
                        float f4 = -f3;
                        CardViewEclairMr1.this.sCornerRect.set(f4, f4, f3, f3);
                        int save = canvas.save();
                        canvas2.translate(rectF2.left + f3, rectF2.top + f3);
                        canvas2.drawArc(CardViewEclairMr1.this.sCornerRect, 180.0f, 90.0f, true, paint);
                        canvas2.translate(width, 0.0f);
                        canvas2.rotate(90.0f);
                        Paint paint2 = paint;
                        canvas2.drawArc(CardViewEclairMr1.this.sCornerRect, 180.0f, 90.0f, true, paint2);
                        canvas2.translate(height, 0.0f);
                        canvas2.rotate(90.0f);
                        canvas2.drawArc(CardViewEclairMr1.this.sCornerRect, 180.0f, 90.0f, true, paint2);
                        canvas2.translate(width, 0.0f);
                        canvas2.rotate(90.0f);
                        canvas2.drawArc(CardViewEclairMr1.this.sCornerRect, 180.0f, 90.0f, true, paint2);
                        canvas2.restoreToCount(save);
                        canvas2.drawRect((rectF2.left + f3) - 1.0f, rectF2.top, (rectF2.right - f3) + 1.0f, rectF2.top + f3, paint);
                        canvas2.drawRect((rectF2.left + f3) - 1.0f, rectF2.bottom - f3, (rectF2.right - f3) + 1.0f, rectF2.bottom, paint);
                    }
                    canvas2.drawRect(rectF2.left, rectF2.top + f, rectF2.right, rectF2.bottom - f, paint);
                }
            };
        }

        public void initialize(CardViewDelegate cardViewDelegate, Context context, ColorStateList colorStateList, float f, float f2, float f3) {
            Drawable createBackground = createBackground(context, colorStateList, f, f2, f3);
            createBackground.setAddPaddingForCorners(cardViewDelegate.getPreventCornerOverlap());
            cardViewDelegate.setCardBackground(createBackground);
            updatePadding(cardViewDelegate);
        }

        private RoundRectDrawableWithShadow createBackground(Context context, ColorStateList colorStateList, float f, float f2, float f3) {
            return new RoundRectDrawableWithShadow(context.getResources(), colorStateList, f, f2, f3);
        }

        public void updatePadding(CardViewDelegate cardViewDelegate) {
            Rect rect = new Rect();
            getShadowBackground(cardViewDelegate).getMaxShadowAndCornerPadding(rect);
            cardViewDelegate.setMinWidthHeightInternal((int) Math.ceil((double) getMinWidth(cardViewDelegate)), (int) Math.ceil((double) getMinHeight(cardViewDelegate)));
            cardViewDelegate.setShadowPadding(rect.left, rect.top, rect.right, rect.bottom);
        }

        public void onPreventCornerOverlapChanged(CardViewDelegate cardViewDelegate) {
            getShadowBackground(cardViewDelegate).setAddPaddingForCorners(cardViewDelegate.getPreventCornerOverlap());
            updatePadding(cardViewDelegate);
        }

        public void setBackgroundColor(CardViewDelegate cardViewDelegate, @Nullable ColorStateList colorStateList) {
            getShadowBackground(cardViewDelegate).setColor(colorStateList);
        }

        public ColorStateList getBackgroundColor(CardViewDelegate cardViewDelegate) {
            return getShadowBackground(cardViewDelegate).getColor();
        }

        public void setRadius(CardViewDelegate cardViewDelegate, float f) {
            getShadowBackground(cardViewDelegate).setCornerRadius(f);
            updatePadding(cardViewDelegate);
        }

        public float getRadius(CardViewDelegate cardViewDelegate) {
            return getShadowBackground(cardViewDelegate).getCornerRadius();
        }

        public void setElevation(CardViewDelegate cardViewDelegate, float f) {
            getShadowBackground(cardViewDelegate).setShadowSize(f);
        }

        public float getElevation(CardViewDelegate cardViewDelegate) {
            return getShadowBackground(cardViewDelegate).getShadowSize();
        }

        public void setMaxElevation(CardViewDelegate cardViewDelegate, float f) {
            getShadowBackground(cardViewDelegate).setMaxShadowSize(f);
            updatePadding(cardViewDelegate);
        }

        public float getMaxElevation(CardViewDelegate cardViewDelegate) {
            return getShadowBackground(cardViewDelegate).getMaxShadowSize();
        }

        public float getMinWidth(CardViewDelegate cardViewDelegate) {
            return getShadowBackground(cardViewDelegate).getMinWidth();
        }

        public float getMinHeight(CardViewDelegate cardViewDelegate) {
            return getShadowBackground(cardViewDelegate).getMinHeight();
        }

        private RoundRectDrawableWithShadow getShadowBackground(CardViewDelegate cardViewDelegate) {
            return (RoundRectDrawableWithShadow) cardViewDelegate.getCardBackground();
        }
    }

    public void setPadding(int i, int i2, int i3, int i4) {
    }

    public void setPaddingRelative(int i, int i2, int i3, int i4) {
    }

    static {
        if (VERSION.SDK_INT >= 17) {
            IMPL = new CardViewApi17Impl();
        } else {
            IMPL = new CardViewEclairMr1();
        }
        IMPL.initStatic();
    }

    public CardView2(Context context) {
        super(context);
        initialize(context, null, 0);
    }

    public CardView2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initialize(context, attributeSet, 0);
    }

    public CardView2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initialize(context, attributeSet, i);
    }

    public boolean getUseCompatPadding() {
        return this.mCompatPadding;
    }

    public void setUseCompatPadding(boolean z) {
        if (this.mCompatPadding != z) {
            this.mCompatPadding = z;
            IMPL.onCompatPaddingChanged(this.mCardViewDelegate);
        }
    }

    public void setContentPadding(int i, int i2, int i3, int i4) {
        this.mContentPadding.set(i, i2, i3, i4);
        IMPL.updatePadding(this.mCardViewDelegate);
    }

    protected void onMeasure(int i, int i2) {
        if (IMPL instanceof CardViewApi21Impl) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = MeasureSpec.getMode(i);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            i = MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) IMPL.getMinWidth(this.mCardViewDelegate)), MeasureSpec.getSize(i)), mode);
        }
        mode = MeasureSpec.getMode(i2);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            i2 = MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) IMPL.getMinHeight(this.mCardViewDelegate)), MeasureSpec.getSize(i2)), mode);
        }
        super.onMeasure(i, i2);
    }

    private void initialize(Context context, AttributeSet attributeSet, int i) {
        ColorStateList colorStateList;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CardView, i, com.iqoption.x.R.style.CardView);
        if (obtainStyledAttributes.hasValue(2)) {
            colorStateList = obtainStyledAttributes.getColorStateList(2);
        } else {
            TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(COLOR_BACKGROUND_ATTR);
            int color = obtainStyledAttributes2.getColor(0, 0);
            obtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color, fArr);
            if (fArr[2] > 0.5f) {
                i = getResources().getColor(com.iqoption.x.R.color.cardview_light_background);
            } else {
                i = getResources().getColor(com.iqoption.x.R.color.cardview_dark_background);
            }
            colorStateList = ColorStateList.valueOf(i);
        }
        ColorStateList colorStateList2 = colorStateList;
        float dimension = obtainStyledAttributes.getDimension(3, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(4, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(5, 0.0f);
        this.mCompatPadding = obtainStyledAttributes.getBoolean(7, false);
        this.mPreventCornerOverlap = obtainStyledAttributes.getBoolean(6, true);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(8, 0);
        this.mContentPadding.left = obtainStyledAttributes.getDimensionPixelSize(10, dimensionPixelSize);
        this.mContentPadding.top = obtainStyledAttributes.getDimensionPixelSize(12, dimensionPixelSize);
        this.mContentPadding.right = obtainStyledAttributes.getDimensionPixelSize(11, dimensionPixelSize);
        this.mContentPadding.bottom = obtainStyledAttributes.getDimensionPixelSize(9, dimensionPixelSize);
        float f = dimension2 > dimension3 ? dimension2 : dimension3;
        this.mUserSetMinWidth = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.mUserSetMinHeight = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        obtainStyledAttributes.recycle();
        IMPL.initialize(this.mCardViewDelegate, context, colorStateList2, dimension, dimension2, f);
    }

    public void setMinimumWidth(int i) {
        this.mUserSetMinWidth = i;
        super.setMinimumWidth(i);
    }

    public void setMinimumHeight(int i) {
        this.mUserSetMinHeight = i;
        super.setMinimumHeight(i);
    }

    public void setCardBackgroundColor(@ColorInt int i) {
        IMPL.setBackgroundColor(this.mCardViewDelegate, ColorStateList.valueOf(i));
    }

    public void setCardBackgroundColor(@Nullable ColorStateList colorStateList) {
        IMPL.setBackgroundColor(this.mCardViewDelegate, colorStateList);
    }

    public ColorStateList getCardBackgroundColor() {
        return IMPL.getBackgroundColor(this.mCardViewDelegate);
    }

    public int getContentPaddingLeft() {
        return this.mContentPadding.left;
    }

    public int getContentPaddingRight() {
        return this.mContentPadding.right;
    }

    public int getContentPaddingTop() {
        return this.mContentPadding.top;
    }

    public int getContentPaddingBottom() {
        return this.mContentPadding.bottom;
    }

    public void setRadius(float f) {
        IMPL.setRadius(this.mCardViewDelegate, f);
    }

    public float getRadius() {
        return IMPL.getRadius(this.mCardViewDelegate);
    }

    public void setCardElevation(float f) {
        IMPL.setElevation(this.mCardViewDelegate, f);
    }

    public float getCardElevation() {
        return IMPL.getElevation(this.mCardViewDelegate);
    }

    public void setMaxCardElevation(float f) {
        IMPL.setMaxElevation(this.mCardViewDelegate, f);
    }

    public float getMaxCardElevation() {
        return IMPL.getMaxElevation(this.mCardViewDelegate);
    }

    public boolean getPreventCornerOverlap() {
        return this.mPreventCornerOverlap;
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.mPreventCornerOverlap) {
            this.mPreventCornerOverlap = z;
            IMPL.onPreventCornerOverlapChanged(this.mCardViewDelegate);
        }
    }
}
