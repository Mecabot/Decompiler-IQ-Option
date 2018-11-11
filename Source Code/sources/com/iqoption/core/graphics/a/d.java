package com.iqoption.core.graphics.a;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.TintAwareDrawable;
import com.iqoption.core.ext.a;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0014J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u0012H\u0016J\u0012\u0010\u001b\u001a\u00020\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, aXE = {"Lcom/iqoption/core/graphics/drawable/InputBackgroundDrawable;", "Landroid/graphics/drawable/Drawable;", "Landroid/support/v4/graphics/drawable/TintAwareDrawable;", "colors", "Landroid/content/res/ColorStateList;", "res", "Landroid/content/res/Resources;", "(Landroid/content/res/ColorStateList;Landroid/content/res/Resources;)V", "lineWidth", "", "(Landroid/content/res/ColorStateList;F)V", "paint", "Landroid/graphics/Paint;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "getAlpha", "", "getOpacity", "isStateful", "", "onStateChange", "state", "", "setAlpha", "alpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "core_release"})
/* compiled from: InputBackgroundDrawable.kt */
public final class d extends Drawable implements TintAwareDrawable {
    private final ColorStateList aRK;
    private final float aRL;
    private final Paint kx = new Paint(1);

    public boolean isStateful() {
        return true;
    }

    public d(ColorStateList colorStateList, float f) {
        h.e(colorStateList, "colors");
        this.aRK = colorStateList;
        this.aRL = f;
    }

    public int getOpacity() {
        if (this.kx.getXfermode() == null && this.kx.getAlpha() != 0) {
        }
        return -3;
    }

    public void draw(Canvas canvas) {
        h.e(canvas, "canvas");
        Paint paint = this.kx;
        Object obj = (paint.getAlpha() == 0 && paint.getXfermode() == null) ? null : 1;
        if (obj != null) {
            Rect bounds = getBounds();
            float d = (float) a.d(bounds);
            canvas.drawRect((float) a.b(bounds), d - this.aRL, (float) a.c(bounds), d, this.kx);
        }
    }

    public void setAlpha(int i) {
        if (this.kx.getAlpha() != i) {
            this.kx.setAlpha(i);
            invalidateSelf();
        }
    }

    public int getAlpha() {
        return this.kx.getAlpha();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if ((h.E(this.kx.getColorFilter(), colorFilter) ^ 1) != 0) {
            this.kx.setColorFilter(colorFilter);
            invalidateSelf();
        }
    }

    protected boolean onStateChange(int[] iArr) {
        h.e(iArr, "state");
        int color = this.kx.getColor();
        int colorForState = this.aRK.getColorForState(iArr, this.aRK.getDefaultColor());
        if (colorForState == color) {
            return false;
        }
        this.kx.setColor(colorForState);
        return true;
    }
}
