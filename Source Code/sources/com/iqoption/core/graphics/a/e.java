package com.iqoption.core.graphics.a;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.graphics.drawable.TintAwareDrawable;
import android.view.Gravity;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0002\u0010\u0004J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020\u0006H\u0017J\b\u0010)\u001a\u00020\u0006H\u0016J\b\u0010*\u001a\u00020\u0006H\u0016J\b\u0010+\u001a\u00020\u0006H\u0016J\u0012\u0010,\u001a\u00020%2\b\u0010-\u001a\u0004\u0018\u00010.H\u0017J\u0010\u0010/\u001a\u00020%2\u0006\u00100\u001a\u00020\u000fH\u0014J\u0010\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u0006H\u0017J\u0010\u00104\u001a\u0002022\u0006\u00105\u001a\u00020\u0006H\u0014J\u0012\u00106\u001a\u0002022\b\u00107\u001a\u0004\u0018\u000108H\u0014J\u0010\u00109\u001a\u00020%2\u0006\u0010:\u001a\u00020\u0006H\u0016J\u0012\u0010;\u001a\u00020%2\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J\u0010\u0010>\u001a\u00020%2\u0006\u0010?\u001a\u00020\u0006H\u0016J\u0012\u0010@\u001a\u00020%2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\u0010\u0010C\u001a\u00020%2\u0006\u0010D\u001a\u00020EH\u0016R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\n \r*\u0004\u0018\u00010\u00010\u0001X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u0014@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u0014@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u000e\u0010\u001d\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R$\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\t\"\u0004\b \u0010\u000bR$\u0010!\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\t\"\u0004\b#\u0010\u000b¨\u0006F"}, aXE = {"Lcom/iqoption/core/graphics/drawable/PropertyDrawable;", "Landroid/graphics/drawable/Drawable;", "Landroid/support/v4/graphics/drawable/TintAwareDrawable;", "d", "(Landroid/graphics/drawable/Drawable;)V", "value", "", "alphaCompat", "getAlphaCompat", "()I", "setAlphaCompat", "(I)V", "delegate", "kotlin.jvm.PlatformType", "insets", "Landroid/graphics/Rect;", "getInsets", "()Landroid/graphics/Rect;", "setInsets", "(Landroid/graphics/Rect;)V", "", "scaleX", "getScaleX", "()F", "setScaleX", "(F)V", "scaleY", "getScaleY", "setScaleY", "tempRect", "translationX", "getTranslationX", "setTranslationX", "translationY", "getTranslationY", "setTranslationY", "draw", "", "canvas", "Landroid/graphics/Canvas;", "getAlpha", "getIntrinsicHeight", "getIntrinsicWidth", "getOpacity", "getOutline", "outline", "Landroid/graphics/Outline;", "onBoundsChange", "bounds", "onLayoutDirectionChanged", "", "layoutDirection", "onLevelChange", "level", "onStateChange", "state", "", "setAlpha", "alpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "setTint", "tintColor", "setTintList", "tint", "Landroid/content/res/ColorStateList;", "setTintMode", "tintMode", "Landroid/graphics/PorterDuff$Mode;", "core_release"})
/* compiled from: PropertyDrawable.kt */
public final class e extends Drawable implements TintAwareDrawable {
    private final Drawable aRM;
    private int aRN = 255;
    private Rect aRO = new Rect();
    private final Rect aRj = new Rect();
    private float scaleX = 1.0f;
    private float scaleY = 1.0f;
    private int translationX;
    private int translationY;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J$\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u001c\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\f¸\u0006\u0000"}, aXE = {"com/iqoption/core/graphics/drawable/PropertyDrawable$delegate$1$1", "Landroid/graphics/drawable/Drawable$Callback;", "invalidateDrawable", "", "who", "Landroid/graphics/drawable/Drawable;", "scheduleDrawable", "what", "Ljava/lang/Runnable;", "when", "", "unscheduleDrawable", "core_release"})
    /* compiled from: PropertyDrawable.kt */
    public static final class a implements Callback {
        final /* synthetic */ e aRP;

        a(e eVar) {
            this.aRP = eVar;
        }

        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            this.aRP.unscheduleSelf(runnable);
        }

        public void invalidateDrawable(Drawable drawable) {
            this.aRP.invalidateSelf();
        }

        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            this.aRP.scheduleSelf(runnable, j);
        }
    }

    public e(Drawable drawable) {
        h.e(drawable, "d");
        drawable = DrawableCompat.wrap(drawable.mutate());
        h.d(drawable, "it");
        drawable.setCallback(new a(this));
        this.aRM = drawable;
    }

    public final void dK(int i) {
        if (this.aRN != i) {
            this.aRN = i;
            Drawable drawable = this.aRM;
            h.d(drawable, "delegate");
            drawable.setAlpha(i);
            invalidateSelf();
        }
    }

    public final float getScaleX() {
        return this.scaleX;
    }

    public final void setScaleX(float f) {
        if (this.scaleX != f) {
            this.scaleX = f;
            Rect bounds = getBounds();
            h.d(bounds, "bounds");
            onBoundsChange(bounds);
            invalidateSelf();
        }
    }

    public final float getScaleY() {
        return this.scaleY;
    }

    public final void setScaleY(float f) {
        if (this.scaleY != f) {
            this.scaleY = f;
            Rect bounds = getBounds();
            h.d(bounds, "bounds");
            onBoundsChange(bounds);
            invalidateSelf();
        }
    }

    public final int Ud() {
        return this.translationX;
    }

    public final void dL(int i) {
        if (this.translationX != i) {
            this.translationX = i;
            Rect bounds = getBounds();
            h.d(bounds, "bounds");
            onBoundsChange(bounds);
            invalidateSelf();
        }
    }

    public final int Ue() {
        return this.translationY;
    }

    public final void dM(int i) {
        if (this.translationY != i) {
            this.translationY = i;
            Rect bounds = getBounds();
            h.d(bounds, "bounds");
            onBoundsChange(bounds);
            invalidateSelf();
        }
    }

    public void draw(Canvas canvas) {
        h.e(canvas, "canvas");
        this.aRM.draw(canvas);
    }

    public void setAlpha(int i) {
        dK(i);
    }

    public int getOpacity() {
        Drawable drawable = this.aRM;
        h.d(drawable, "delegate");
        return drawable.getOpacity();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.aRM;
        h.d(drawable, "delegate");
        drawable.setColorFilter(colorFilter);
    }

    @TargetApi(19)
    public int getAlpha() {
        Drawable drawable = this.aRM;
        h.d(drawable, "delegate");
        return drawable.getAlpha();
    }

    protected void onBoundsChange(Rect rect) {
        h.e(rect, "bounds");
        super.onBoundsChange(rect);
        Rect rect2 = this.aRj;
        int width = (int) (((float) rect.width()) * this.scaleX);
        int height = (int) (((float) rect.height()) * this.scaleY);
        Gravity.apply(17, width, height, rect, rect2);
        rect2.left += this.aRO.left;
        rect2.top += this.aRO.top;
        rect2.right -= this.aRO.right;
        rect2.bottom -= this.aRO.bottom;
        rect2.offset(this.translationX, this.translationY);
        if (width > 0 && height > 0) {
            Drawable drawable = this.aRM;
            h.d(drawable, "delegate");
            drawable.setBounds(rect2);
        }
    }

    protected boolean onStateChange(int[] iArr) {
        return this.aRM.setState(iArr);
    }

    protected boolean onLevelChange(int i) {
        return this.aRM.setLevel(i);
    }

    @TargetApi(23)
    public boolean onLayoutDirectionChanged(int i) {
        return this.aRM.setLayoutDirection(i);
    }

    public void setTint(int i) {
        DrawableCompat.setTint(this.aRM, i);
    }

    public void setTintList(ColorStateList colorStateList) {
        DrawableCompat.setTintList(this.aRM, colorStateList);
    }

    public void setTintMode(Mode mode) {
        h.e(mode, "tintMode");
        DrawableCompat.setTintMode(this.aRM, mode);
    }

    @TargetApi(21)
    public void getOutline(Outline outline) {
        this.aRM.getOutline(outline);
    }

    public int getIntrinsicWidth() {
        Drawable drawable = this.aRM;
        h.d(drawable, "delegate");
        return drawable.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        Drawable drawable = this.aRM;
        h.d(drawable, "delegate");
        return drawable.getIntrinsicHeight();
    }
}
