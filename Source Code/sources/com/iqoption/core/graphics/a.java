package com.iqoption.core.graphics;

import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.RectF;
import com.iqoption.fragment.cashbox.deppage.b;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0017\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nH\u0016J(\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\nH\u0016J(\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J\u0018\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\nH\u0016J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u0017\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J\u0018\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nH\u0016J(\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J\u0018\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\nH\u0016J(\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J\u0018\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\nH\u0016J\b\u0010\u001b\u001a\u00020\u0004H\u0016J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0001H\u0016J\u0018\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\u0001H\u0016J0\u0010!\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020$H\u0016J \u0010(\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020)2\u0006\u0010%\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u0010,\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010,\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J\u0018\u0010-\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nH\u0016J(\u0010-\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J\u0018\u0010.\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\n2\u0006\u00100\u001a\u00020\nH\u0016J(\u0010.\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\n2\u0006\u00100\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J\u0018\u00101\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\nH\u0016J(\u00101\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J\u0018\u00102\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\nH\u0016J\u0010\u00103\u001a\u00020\u00042\u0006\u00104\u001a\u00020\"H\u0016¨\u00065"}, aXE = {"Lcom/iqoption/core/graphics/IdentityMatrix;", "Landroid/graphics/Matrix;", "()V", "oops", "", "postConcat", "", "other", "postRotate", "degrees", "", "px", "py", "postScale", "sx", "sy", "postSkew", "kx", "ky", "postTranslate", "dx", "dy", "preConcat", "preRotate", "preScale", "preSkew", "preTranslate", "reset", "set", "src", "setConcat", "a", "b", "setPolyToPoly", "", "srcIndex", "", "dst", "dstIndex", "pointCount", "setRectToRect", "Landroid/graphics/RectF;", "stf", "Landroid/graphics/Matrix$ScaleToFit;", "setRotate", "setScale", "setSinCos", "sinValue", "cosValue", "setSkew", "setTranslate", "setValues", "values", "core_release"})
/* compiled from: IdentityMatrix.kt */
public final class a extends Matrix {
    public static final a aQD = new a();

    private a() {
    }

    private final void oops() {
        throw new IllegalStateException("Matrix can not be modified");
    }

    public void set(Matrix matrix) {
        h.e(matrix, "src");
        oops();
    }

    public void reset() {
        oops();
    }

    public void setTranslate(float f, float f2) {
        oops();
    }

    public void setScale(float f, float f2, float f3, float f4) {
        oops();
    }

    public void setScale(float f, float f2) {
        oops();
    }

    public void setRotate(float f, float f2, float f3) {
        oops();
    }

    public void setRotate(float f) {
        oops();
    }

    public void setSinCos(float f, float f2, float f3, float f4) {
        oops();
    }

    public void setSinCos(float f, float f2) {
        oops();
    }

    public void setSkew(float f, float f2, float f3, float f4) {
        oops();
    }

    public void setSkew(float f, float f2) {
        oops();
    }

    public boolean setConcat(Matrix matrix, Matrix matrix2) {
        h.e(matrix, com.iqoption.fragment.cashbox.deppage.a.TAG);
        h.e(matrix2, b.TAG);
        oops();
        return false;
    }

    public boolean preTranslate(float f, float f2) {
        oops();
        return false;
    }

    public boolean preScale(float f, float f2, float f3, float f4) {
        oops();
        return false;
    }

    public boolean preScale(float f, float f2) {
        oops();
        return false;
    }

    public boolean preRotate(float f, float f2, float f3) {
        oops();
        return false;
    }

    public boolean preRotate(float f) {
        oops();
        return false;
    }

    public boolean preSkew(float f, float f2, float f3, float f4) {
        oops();
        return false;
    }

    public boolean preSkew(float f, float f2) {
        oops();
        return false;
    }

    public boolean preConcat(Matrix matrix) {
        h.e(matrix, "other");
        oops();
        return false;
    }

    public boolean postTranslate(float f, float f2) {
        oops();
        return false;
    }

    public boolean postScale(float f, float f2, float f3, float f4) {
        oops();
        return false;
    }

    public boolean postScale(float f, float f2) {
        oops();
        return false;
    }

    public boolean postRotate(float f, float f2, float f3) {
        oops();
        return false;
    }

    public boolean postRotate(float f) {
        oops();
        return false;
    }

    public boolean postSkew(float f, float f2, float f3, float f4) {
        oops();
        return false;
    }

    public boolean postSkew(float f, float f2) {
        oops();
        return false;
    }

    public boolean postConcat(Matrix matrix) {
        h.e(matrix, "other");
        oops();
        return false;
    }

    public boolean setRectToRect(RectF rectF, RectF rectF2, ScaleToFit scaleToFit) {
        h.e(rectF, "src");
        h.e(rectF2, "dst");
        h.e(scaleToFit, "stf");
        oops();
        return false;
    }

    public boolean setPolyToPoly(float[] fArr, int i, float[] fArr2, int i2, int i3) {
        h.e(fArr, "src");
        h.e(fArr2, "dst");
        oops();
        return false;
    }

    public void setValues(float[] fArr) {
        h.e(fArr, "values");
        oops();
    }
}
