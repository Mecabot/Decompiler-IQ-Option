package android.support.v7.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.widget.AutoSizeableTextView;
import android.support.v7.appcompat.R;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import java.lang.ref.WeakReference;

@RequiresApi(9)
class AppCompatTextHelper {
    private static final int MONOSPACE = 3;
    private static final int SANS = 1;
    private static final int SERIF = 2;
    private boolean mAsyncFontPending;
    @NonNull
    private final AppCompatTextViewAutoSizeHelper mAutoSizeTextHelper;
    private TintInfo mDrawableBottomTint;
    private TintInfo mDrawableLeftTint;
    private TintInfo mDrawableRightTint;
    private TintInfo mDrawableTopTint;
    private Typeface mFontTypeface;
    private int mStyle = 0;
    final TextView mView;

    static AppCompatTextHelper create(TextView textView) {
        if (VERSION.SDK_INT >= 17) {
            return new AppCompatTextHelperV17(textView);
        }
        return new AppCompatTextHelper(textView);
    }

    AppCompatTextHelper(TextView textView) {
        this.mView = textView;
        this.mAutoSizeTextHelper = new AppCompatTextViewAutoSizeHelper(this.mView);
    }

    @SuppressLint({"NewApi"})
    void loadFromAttributes(AttributeSet attributeSet, int i) {
        TintTypedArray obtainStyledAttributes;
        Object obj;
        boolean z;
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Context context = this.mView.getContext();
        AppCompatDrawableManager appCompatDrawableManager = AppCompatDrawableManager.get();
        TintTypedArray obtainStyledAttributes2 = TintTypedArray.obtainStyledAttributes(context, attributeSet, R.styleable.AppCompatTextHelper, i, 0);
        int resourceId = obtainStyledAttributes2.getResourceId(R.styleable.AppCompatTextHelper_android_textAppearance, -1);
        if (obtainStyledAttributes2.hasValue(R.styleable.AppCompatTextHelper_android_drawableLeft)) {
            this.mDrawableLeftTint = createTintInfo(context, appCompatDrawableManager, obtainStyledAttributes2.getResourceId(R.styleable.AppCompatTextHelper_android_drawableLeft, 0));
        }
        if (obtainStyledAttributes2.hasValue(R.styleable.AppCompatTextHelper_android_drawableTop)) {
            this.mDrawableTopTint = createTintInfo(context, appCompatDrawableManager, obtainStyledAttributes2.getResourceId(R.styleable.AppCompatTextHelper_android_drawableTop, 0));
        }
        if (obtainStyledAttributes2.hasValue(R.styleable.AppCompatTextHelper_android_drawableRight)) {
            this.mDrawableRightTint = createTintInfo(context, appCompatDrawableManager, obtainStyledAttributes2.getResourceId(R.styleable.AppCompatTextHelper_android_drawableRight, 0));
        }
        if (obtainStyledAttributes2.hasValue(R.styleable.AppCompatTextHelper_android_drawableBottom)) {
            this.mDrawableBottomTint = createTintInfo(context, appCompatDrawableManager, obtainStyledAttributes2.getResourceId(R.styleable.AppCompatTextHelper_android_drawableBottom, 0));
        }
        obtainStyledAttributes2.recycle();
        boolean z2 = this.mView.getTransformationMethod() instanceof PasswordTransformationMethod;
        ColorStateList colorStateList3 = null;
        if (resourceId != -1) {
            obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, resourceId, R.styleable.TextAppearance);
            if (z2 || !obtainStyledAttributes.hasValue(R.styleable.TextAppearance_textAllCaps)) {
                obj = null;
                z = false;
            } else {
                z = obtainStyledAttributes.getBoolean(R.styleable.TextAppearance_textAllCaps, false);
                obj = 1;
            }
            updateTypefaceAndStyle(context, obtainStyledAttributes);
            if (VERSION.SDK_INT < 23) {
                colorStateList = obtainStyledAttributes.hasValue(R.styleable.TextAppearance_android_textColor) ? obtainStyledAttributes.getColorStateList(R.styleable.TextAppearance_android_textColor) : null;
                colorStateList2 = obtainStyledAttributes.hasValue(R.styleable.TextAppearance_android_textColorHint) ? obtainStyledAttributes.getColorStateList(R.styleable.TextAppearance_android_textColorHint) : null;
                if (obtainStyledAttributes.hasValue(R.styleable.TextAppearance_android_textColorLink)) {
                    colorStateList3 = obtainStyledAttributes.getColorStateList(R.styleable.TextAppearance_android_textColorLink);
                }
                ColorStateList colorStateList4 = colorStateList;
                colorStateList = colorStateList3;
                colorStateList3 = colorStateList4;
            } else {
                colorStateList = null;
                colorStateList2 = colorStateList;
            }
            obtainStyledAttributes.recycle();
        } else {
            colorStateList = null;
            colorStateList2 = colorStateList;
            obj = null;
            z = false;
        }
        obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, R.styleable.TextAppearance, i, 0);
        if (!z2 && obtainStyledAttributes.hasValue(R.styleable.TextAppearance_textAllCaps)) {
            z = obtainStyledAttributes.getBoolean(R.styleable.TextAppearance_textAllCaps, false);
            obj = 1;
        }
        if (VERSION.SDK_INT < 23) {
            if (obtainStyledAttributes.hasValue(R.styleable.TextAppearance_android_textColor)) {
                colorStateList3 = obtainStyledAttributes.getColorStateList(R.styleable.TextAppearance_android_textColor);
            }
            if (obtainStyledAttributes.hasValue(R.styleable.TextAppearance_android_textColorHint)) {
                colorStateList2 = obtainStyledAttributes.getColorStateList(R.styleable.TextAppearance_android_textColorHint);
            }
            if (obtainStyledAttributes.hasValue(R.styleable.TextAppearance_android_textColorLink)) {
                colorStateList = obtainStyledAttributes.getColorStateList(R.styleable.TextAppearance_android_textColorLink);
            }
        }
        updateTypefaceAndStyle(context, obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        if (colorStateList3 != null) {
            this.mView.setTextColor(colorStateList3);
        }
        if (colorStateList2 != null) {
            this.mView.setHintTextColor(colorStateList2);
        }
        if (colorStateList != null) {
            this.mView.setLinkTextColor(colorStateList);
        }
        if (!(z2 || r5 == null)) {
            setAllCaps(z);
        }
        if (this.mFontTypeface != null) {
            this.mView.setTypeface(this.mFontTypeface, this.mStyle);
        }
        this.mAutoSizeTextHelper.loadFromAttributes(attributeSet, i);
        if (AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE && this.mAutoSizeTextHelper.getAutoSizeTextType() != 0) {
            int[] autoSizeTextAvailableSizes = this.mAutoSizeTextHelper.getAutoSizeTextAvailableSizes();
            if (autoSizeTextAvailableSizes.length <= 0) {
                return;
            }
            if (((float) this.mView.getAutoSizeStepGranularity()) != -1.0f) {
                this.mView.setAutoSizeTextTypeUniformWithConfiguration(this.mAutoSizeTextHelper.getAutoSizeMinTextSize(), this.mAutoSizeTextHelper.getAutoSizeMaxTextSize(), this.mAutoSizeTextHelper.getAutoSizeStepGranularity(), 0);
            } else {
                this.mView.setAutoSizeTextTypeUniformWithPresetSizes(autoSizeTextAvailableSizes, 0);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0072 A:{Splitter: B:19:0x0062, ExcHandler: java.lang.UnsupportedOperationException (unused java.lang.UnsupportedOperationException)} */
    /* JADX WARNING: Missing block: B:25:0x0074, code:
            if (r4.mFontTypeface == null) goto L_0x0076;
     */
    /* JADX WARNING: Missing block: B:26:0x0076, code:
            r5 = r6.getString(r0);
     */
    /* JADX WARNING: Missing block: B:27:0x007a, code:
            if (r5 != null) goto L_0x007c;
     */
    /* JADX WARNING: Missing block: B:28:0x007c, code:
            r4.mFontTypeface = android.graphics.Typeface.create(r5, r4.mStyle);
     */
    /* JADX WARNING: Missing block: B:29:0x0084, code:
            return;
     */
    private void updateTypefaceAndStyle(android.content.Context r5, android.support.v7.widget.TintTypedArray r6) {
        /*
        r4 = this;
        r0 = android.support.v7.appcompat.R.styleable.TextAppearance_android_textStyle;
        r1 = r4.mStyle;
        r0 = r6.getInt(r0, r1);
        r4.mStyle = r0;
        r0 = android.support.v7.appcompat.R.styleable.TextAppearance_android_fontFamily;
        r0 = r6.hasValue(r0);
        r1 = 1;
        r2 = 0;
        if (r0 != 0) goto L_0x0040;
    L_0x0014:
        r0 = android.support.v7.appcompat.R.styleable.TextAppearance_fontFamily;
        r0 = r6.hasValue(r0);
        if (r0 == 0) goto L_0x001d;
    L_0x001c:
        goto L_0x0040;
    L_0x001d:
        r5 = android.support.v7.appcompat.R.styleable.TextAppearance_android_typeface;
        r5 = r6.hasValue(r5);
        if (r5 == 0) goto L_0x003f;
    L_0x0025:
        r4.mAsyncFontPending = r2;
        r5 = android.support.v7.appcompat.R.styleable.TextAppearance_android_typeface;
        r5 = r6.getInt(r5, r1);
        switch(r5) {
            case 1: goto L_0x003b;
            case 2: goto L_0x0036;
            case 3: goto L_0x0031;
            default: goto L_0x0030;
        };
    L_0x0030:
        goto L_0x003f;
    L_0x0031:
        r5 = android.graphics.Typeface.MONOSPACE;
        r4.mFontTypeface = r5;
        goto L_0x003f;
    L_0x0036:
        r5 = android.graphics.Typeface.SERIF;
        r4.mFontTypeface = r5;
        goto L_0x003f;
    L_0x003b:
        r5 = android.graphics.Typeface.SANS_SERIF;
        r4.mFontTypeface = r5;
    L_0x003f:
        return;
    L_0x0040:
        r0 = 0;
        r4.mFontTypeface = r0;
        r0 = android.support.v7.appcompat.R.styleable.TextAppearance_fontFamily;
        r0 = r6.hasValue(r0);
        if (r0 == 0) goto L_0x004e;
    L_0x004b:
        r0 = android.support.v7.appcompat.R.styleable.TextAppearance_fontFamily;
        goto L_0x0050;
    L_0x004e:
        r0 = android.support.v7.appcompat.R.styleable.TextAppearance_android_fontFamily;
    L_0x0050:
        r5 = r5.isRestricted();
        if (r5 != 0) goto L_0x0072;
    L_0x0056:
        r5 = new java.lang.ref.WeakReference;
        r3 = r4.mView;
        r5.<init>(r3);
        r3 = new android.support.v7.widget.AppCompatTextHelper$1;
        r3.<init>(r5);
        r5 = r4.mStyle;	 Catch:{ UnsupportedOperationException -> 0x0072, UnsupportedOperationException -> 0x0072 }
        r5 = r6.getFont(r0, r5, r3);	 Catch:{ UnsupportedOperationException -> 0x0072, UnsupportedOperationException -> 0x0072 }
        r4.mFontTypeface = r5;	 Catch:{ UnsupportedOperationException -> 0x0072, UnsupportedOperationException -> 0x0072 }
        r5 = r4.mFontTypeface;	 Catch:{ UnsupportedOperationException -> 0x0072, UnsupportedOperationException -> 0x0072 }
        if (r5 != 0) goto L_0x006f;
    L_0x006e:
        goto L_0x0070;
    L_0x006f:
        r1 = 0;
    L_0x0070:
        r4.mAsyncFontPending = r1;	 Catch:{ UnsupportedOperationException -> 0x0072, UnsupportedOperationException -> 0x0072 }
    L_0x0072:
        r5 = r4.mFontTypeface;
        if (r5 != 0) goto L_0x0084;
    L_0x0076:
        r5 = r6.getString(r0);
        if (r5 == 0) goto L_0x0084;
    L_0x007c:
        r6 = r4.mStyle;
        r5 = android.graphics.Typeface.create(r5, r6);
        r4.mFontTypeface = r5;
    L_0x0084:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.AppCompatTextHelper.updateTypefaceAndStyle(android.content.Context, android.support.v7.widget.TintTypedArray):void");
    }

    private void onAsyncTypefaceReceived(WeakReference<TextView> weakReference, Typeface typeface) {
        if (this.mAsyncFontPending) {
            this.mFontTypeface = typeface;
            TextView textView = (TextView) weakReference.get();
            if (textView != null) {
                textView.setTypeface(typeface, this.mStyle);
            }
        }
    }

    void onSetTextAppearance(Context context, int i) {
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, i, R.styleable.TextAppearance);
        if (obtainStyledAttributes.hasValue(R.styleable.TextAppearance_textAllCaps)) {
            setAllCaps(obtainStyledAttributes.getBoolean(R.styleable.TextAppearance_textAllCaps, false));
        }
        if (VERSION.SDK_INT < 23 && obtainStyledAttributes.hasValue(R.styleable.TextAppearance_android_textColor)) {
            ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(R.styleable.TextAppearance_android_textColor);
            if (colorStateList != null) {
                this.mView.setTextColor(colorStateList);
            }
        }
        updateTypefaceAndStyle(context, obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        if (this.mFontTypeface != null) {
            this.mView.setTypeface(this.mFontTypeface, this.mStyle);
        }
    }

    void setAllCaps(boolean z) {
        this.mView.setAllCaps(z);
    }

    void applyCompoundDrawablesTints() {
        if (this.mDrawableLeftTint != null || this.mDrawableTopTint != null || this.mDrawableRightTint != null || this.mDrawableBottomTint != null) {
            Drawable[] compoundDrawables = this.mView.getCompoundDrawables();
            applyCompoundDrawableTint(compoundDrawables[0], this.mDrawableLeftTint);
            applyCompoundDrawableTint(compoundDrawables[1], this.mDrawableTopTint);
            applyCompoundDrawableTint(compoundDrawables[2], this.mDrawableRightTint);
            applyCompoundDrawableTint(compoundDrawables[3], this.mDrawableBottomTint);
        }
    }

    final void applyCompoundDrawableTint(Drawable drawable, TintInfo tintInfo) {
        if (drawable != null && tintInfo != null) {
            AppCompatDrawableManager.tintDrawable(drawable, tintInfo, this.mView.getDrawableState());
        }
    }

    protected static TintInfo createTintInfo(Context context, AppCompatDrawableManager appCompatDrawableManager, int i) {
        ColorStateList tintList = appCompatDrawableManager.getTintList(context, i);
        if (tintList == null) {
            return null;
        }
        TintInfo tintInfo = new TintInfo();
        tintInfo.mHasTintList = true;
        tintInfo.mTintList = tintList;
        return tintInfo;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (!AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE) {
            autoSizeText();
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    void setTextSize(int i, float f) {
        if (!AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE && !isAutoSizeEnabled()) {
            setTextSizeInternal(i, f);
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    void autoSizeText() {
        this.mAutoSizeTextHelper.autoSizeText();
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    boolean isAutoSizeEnabled() {
        return this.mAutoSizeTextHelper.isAutoSizeEnabled();
    }

    private void setTextSizeInternal(int i, float f) {
        this.mAutoSizeTextHelper.setTextSizeInternal(i, f);
    }

    void setAutoSizeTextTypeWithDefaults(int i) {
        this.mAutoSizeTextHelper.setAutoSizeTextTypeWithDefaults(i);
    }

    void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) {
        this.mAutoSizeTextHelper.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
    }

    void setAutoSizeTextTypeUniformWithPresetSizes(@NonNull int[] iArr, int i) {
        this.mAutoSizeTextHelper.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
    }

    int getAutoSizeTextType() {
        return this.mAutoSizeTextHelper.getAutoSizeTextType();
    }

    int getAutoSizeStepGranularity() {
        return this.mAutoSizeTextHelper.getAutoSizeStepGranularity();
    }

    int getAutoSizeMinTextSize() {
        return this.mAutoSizeTextHelper.getAutoSizeMinTextSize();
    }

    int getAutoSizeMaxTextSize() {
        return this.mAutoSizeTextHelper.getAutoSizeMaxTextSize();
    }

    int[] getAutoSizeTextAvailableSizes() {
        return this.mAutoSizeTextHelper.getAutoSizeTextAvailableSizes();
    }
}
