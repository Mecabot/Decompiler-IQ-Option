package com.iqoption.core.graphics.animation;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;
import com.google.android.gms.analytics.ecommerce.Promotion;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, aXE = {"Lcom/iqoption/core/graphics/animation/ImageViews;", "", "()V", "ANIMATED_TRANSFORM_PROPERTY", "Landroid/util/Property;", "Landroid/widget/ImageView;", "Landroid/graphics/Matrix;", "getANIMATED_TRANSFORM_PROPERTY", "()Landroid/util/Property;", "core_release"})
/* compiled from: ViewProperties.kt */
public final class h {
    private static final Property<ImageView, Matrix> ANIMATED_TRANSFORM_PROPERTY = new a(Matrix.class, "animatedTransform");
    public static final h aQT = new h();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\u0019\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0003H\u0002¨\u0006\n"}, aXE = {"com/iqoption/core/graphics/animation/ImageViews$ANIMATED_TRANSFORM_PROPERTY$1", "Landroid/util/Property;", "Landroid/widget/ImageView;", "Landroid/graphics/Matrix;", "get", "object", "set", "", "view", "matrix", "core_release"})
    /* compiled from: ViewProperties.kt */
    public static final class a extends Property<ImageView, Matrix> {
        public Matrix get(ImageView imageView) {
            kotlin.jvm.internal.h.e(imageView, "object");
            return null;
        }

        a(Class cls, String str) {
            super(cls, str);
        }

        public void set(ImageView imageView, Matrix matrix) {
            kotlin.jvm.internal.h.e(imageView, Promotion.ACTION_VIEW);
            kotlin.jvm.internal.h.e(matrix, "matrix");
            d.aQO.a(imageView, matrix);
        }
    }

    private h() {
    }

    public final Property<ImageView, Matrix> TH() {
        return ANIMATED_TRANSFORM_PROPERTY;
    }
}
