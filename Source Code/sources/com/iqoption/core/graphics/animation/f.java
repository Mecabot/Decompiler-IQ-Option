package com.iqoption.core.graphics.animation;

import android.animation.Animator;
import android.graphics.Matrix;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.widget.ImageView;
import com.google.android.gms.analytics.ecommerce.Promotion;
import java.lang.reflect.Method;
import kotlin.d;
import kotlin.i;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;

@RequiresApi(21)
@i(aXC = {1, 1, 11}, aXD = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u000e"}, aXE = {"Lcom/iqoption/core/graphics/animation/ImageAnimHelper21;", "Lcom/iqoption/core/graphics/animation/ImageAnimHelperApi;", "()V", "animate", "", "view", "Landroid/widget/ImageView;", "matrix", "Landroid/graphics/Matrix;", "postAnimate", "animator", "Landroid/animation/Animator;", "preAnimate", "Companion", "core_release"})
/* compiled from: ImageAnimHelperApi.kt */
final class f implements g {
    private static final String TAG = "f";
    private static final d aQQ = g.f(ImageAnimHelper21$Companion$METHOD$2.aQS);
    public static final a aQR = new a();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001d\u0010\u0003\u001a\u0004\u0018\u00010\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, aXE = {"Lcom/iqoption/core/graphics/animation/ImageAnimHelper21$Companion;", "", "()V", "METHOD", "Ljava/lang/reflect/Method;", "getMETHOD", "()Ljava/lang/reflect/Method;", "METHOD$delegate", "Lkotlin/Lazy;", "TAG", "", "kotlin.jvm.PlatformType", "core_release"})
    /* compiled from: ImageAnimHelperApi.kt */
    public static final class a {
        static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(a.class), "METHOD", "getMETHOD()Ljava/lang/reflect/Method;"))};

        private final Method TF() {
            d TE = f.aQQ;
            j jVar = apP[0];
            return (Method) TE.getValue();
        }

        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public void a(ImageView imageView, Animator animator) {
        h.e(imageView, Promotion.ACTION_VIEW);
        h.e(animator, "animator");
    }

    public void c(ImageView imageView) {
        h.e(imageView, Promotion.ACTION_VIEW);
    }

    public void a(ImageView imageView, Matrix matrix) {
        h.e(imageView, Promotion.ACTION_VIEW);
        h.e(matrix, "matrix");
        try {
            Method a = aQR.TF();
            if (a != null) {
                a.invoke(imageView, new Object[]{matrix});
            }
        } catch (Exception e) {
            Log.w(TAG, e.getMessage(), e);
        }
    }
}
