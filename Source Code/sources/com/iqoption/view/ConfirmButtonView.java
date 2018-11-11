package com.iqoption.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.StringRes;
import android.support.v4.app.NotificationCompat;
import android.support.v7.content.res.AppCompatResources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.iqoption.app.IQApp;
import com.iqoption.b.b;
import com.iqoption.core.i;
import com.iqoption.widget.d;
import com.iqoption.x.R;

public class ConfirmButtonView extends FrameLayout {
    private ImageView bik;
    private d cux;
    private View dAW;
    private TextView dAX;
    private ImageView dAY;
    private ImageView dAZ;
    private Runnable dBa;
    private int dBb;
    private int dBc;
    private boolean dBd;
    private int maxHeight;
    private int maxWidth;

    public ConfirmButtonView(Context context) {
        super(context);
        e(context, null);
    }

    public boolean callOnClick() {
        return super.callOnClick();
    }

    public ConfirmButtonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        e(context, attributeSet);
    }

    public ConfirmButtonView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        e(context, attributeSet);
    }

    @TargetApi(21)
    public ConfirmButtonView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        e(context, attributeSet);
    }

    private void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.ConfirmButtonView, 0, 0);
        try {
            int dimensionPixelOffset;
            this.dAX.setText(obtainStyledAttributes.getText(6));
            ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(8);
            if (colorStateList != null) {
                this.dAX.setTextColor(colorStateList);
            }
            this.dAX.setTextSize(0, (float) obtainStyledAttributes.getDimensionPixelSize(9, (int) this.dAX.getTextSize()));
            Drawable drawable = obtainStyledAttributes.getDrawable(0);
            if (VERSION.SDK_INT >= 16) {
                this.dAW.setBackground(drawable);
            } else {
                this.dAW.setBackgroundDrawable(drawable);
            }
            R(obtainStyledAttributes.getString(2), obtainStyledAttributes.getInt(10, -1));
            this.dBd = obtainStyledAttributes.getBoolean(16, false);
            if (VERSION.SDK_INT >= 21) {
                dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(11, 0);
                int dimensionPixelOffset2 = obtainStyledAttributes.getDimensionPixelOffset(1, 0);
                this.dAW.setTranslationZ((float) dimensionPixelOffset);
                this.dAW.setElevation((float) dimensionPixelOffset2);
            }
            if (obtainStyledAttributes.getBoolean(7, false)) {
                this.dAX.setAllCaps(true);
            }
            drawable = obtainStyledAttributes.getDrawable(3);
            if (drawable != null) {
                this.dAY.setImageDrawable(drawable);
                this.dAY.setVisibility(0);
            } else {
                dimensionPixelOffset = obtainStyledAttributes.getResourceId(4, -1);
                if (dimensionPixelOffset != -1) {
                    drawable = AppCompatResources.getDrawable(getContext(), dimensionPixelOffset);
                    if (drawable != null) {
                        this.dAY.setImageDrawable(drawable);
                        this.dAY.setVisibility(0);
                    } else {
                        this.dAY.setVisibility(8);
                    }
                } else {
                    this.dAY.setVisibility(8);
                }
            }
            Drawable drawable2 = obtainStyledAttributes.getDrawable(5);
            if (drawable2 != null) {
                this.dAZ.setImageDrawable(drawable2);
                this.dAZ.setVisibility(0);
            } else {
                dimensionPixelOffset = obtainStyledAttributes.getResourceId(5, -1);
                if (dimensionPixelOffset != -1) {
                    drawable = AppCompatResources.getDrawable(getContext(), dimensionPixelOffset);
                    if (drawable != null) {
                        this.dAZ.setImageDrawable(drawable);
                        this.dAZ.setVisibility(0);
                    } else {
                        this.dAZ.setVisibility(8);
                    }
                } else {
                    this.dAZ.setVisibility(8);
                }
            }
            this.maxWidth = obtainStyledAttributes.getDimensionPixelSize(14, this.maxWidth);
            this.maxHeight = obtainStyledAttributes.getDimensionPixelSize(12, this.maxHeight);
            this.dBb = obtainStyledAttributes.getDimensionPixelSize(15, this.dBb);
            this.dBc = obtainStyledAttributes.getDimensionPixelSize(13, this.dBc);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public void setButtonImageSrc(Drawable drawable) {
        this.dAY.setImageDrawable(drawable);
        this.dAY.setVisibility(drawable == null ? 8 : 0);
    }

    public void setButtonLeftImageSrc(Drawable drawable) {
        this.dAZ.setImageDrawable(drawable);
        this.dAZ.setVisibility(drawable == null ? 8 : 0);
    }

    public void setButtonText(@StringRes int i) {
        this.dAX.setText(i);
    }

    private void R(String str, int i) {
        if (str != null) {
            Typeface create = Typeface.create(str, i);
            if (create != null) {
                this.dAX.setTypeface(create);
            }
        }
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.dAW.setEnabled(z);
        this.dAX.setEnabled(z);
        this.dAY.setEnabled(z);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.dAW.setOnClickListener(onClickListener);
    }

    private void e(Context context, AttributeSet attributeSet) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.account_security_confirm_button_layout, this, true);
        this.dAW = inflate.findViewById(R.id.confirmTextLayout);
        this.dAX = (TextView) inflate.findViewById(R.id.confirmText);
        this.dAY = (ImageView) inflate.findViewById(R.id.confirmImage);
        this.dAZ = (ImageView) inflate.findViewById(R.id.confirmImageLeft);
        this.cux = new d(context, inflate);
        this.bik = (ImageView) inflate.findViewById(R.id.progressView);
        if (!isInEditMode()) {
            this.bik.setImageDrawable(this.cux);
        }
        if (attributeSet != null) {
            b(context, attributeSet);
        }
    }

    public boolean performClick() {
        return isClickable() && super.performClick();
    }

    public void f(final boolean z, final boolean z2) {
        this.dAW.setClickable(z ^ 1);
        if (this.dBa != null) {
            removeCallbacks(this.dBa);
        }
        this.dBa = new Runnable() {
            public void run() {
                ConfirmButtonView.this.i(z, z2);
            }
        };
        post(this.dBa);
    }

    protected void onMeasure(int i, int i2) {
        int size = MeasureSpec.getSize(i);
        if (getMaxWidth() > 0 && getMaxWidth() < size) {
            i = MeasureSpec.makeMeasureSpec(getMaxWidth(), MeasureSpec.getMode(i));
        }
        size = MeasureSpec.getSize(i2);
        if (getMaxHeight() > 0 && getMaxHeight() < size) {
            i2 = MeasureSpec.makeMeasureSpec(getMaxHeight(), MeasureSpec.getMode(i2));
        }
        super.onMeasure(i, i2);
    }

    private int getMaxHeight() {
        return IQApp.aQ(getContext()) ? this.maxHeight : this.dBc;
    }

    private int getMaxWidth() {
        return IQApp.aQ(getContext()) ? this.maxWidth : this.dBb;
    }

    public void i(boolean z, boolean z2) {
        String str = NotificationCompat.CATEGORY_PROGRESS;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("showProgress showAnimation=");
        stringBuilder.append(z);
        stringBuilder.append(", isAnimated=");
        stringBuilder.append(z2);
        i.e(str, stringBuilder.toString());
        int i = 8;
        if (this.dBd) {
            this.bik.setAlpha(1.0f);
            ImageView imageView = this.bik;
            if (z) {
                i = 0;
            }
            imageView.setVisibility(i);
            return;
        }
        if (z) {
            if (z2) {
                this.dAW.animate().alpha(0.0f);
                this.dAW.animate().setListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        ConfirmButtonView.this.dAW.setVisibility(8);
                    }
                });
                this.bik.setAlpha(0.0f);
                this.bik.setVisibility(0);
                this.bik.animate().alpha(1.0f);
            } else {
                this.dAW.setVisibility(8);
                this.bik.setAlpha(1.0f);
                this.bik.setVisibility(0);
            }
            this.cux.start();
        } else if (z2) {
            this.dAW.setAlpha(0.0f);
            this.dAW.setVisibility(0);
            this.dAW.animate().alpha(1.0f);
            this.bik.animate().alpha(0.0f).setListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    ConfirmButtonView.this.bik.setVisibility(8);
                    ConfirmButtonView.this.cux.stop();
                }
            });
        } else {
            this.bik.setAlpha(0.0f);
            this.bik.setVisibility(8);
            this.dAW.setAlpha(1.0f);
            this.dAW.setVisibility(0);
            this.cux.stop();
        }
    }
}
