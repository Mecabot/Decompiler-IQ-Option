package com.iqoption.core.graphics.animation;

import android.animation.Animator;
import android.graphics.Matrix;
import android.os.Build.VERSION;
import android.widget.ImageView;
import com.google.android.gms.analytics.ecommerce.Promotion;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016R\u000e\u0010\u0003\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, aXE = {"Lcom/iqoption/core/graphics/animation/ImageAnimHelper;", "Lcom/iqoption/core/graphics/animation/ImageAnimHelperApi;", "()V", "impl", "animate", "", "view", "Landroid/widget/ImageView;", "matrix", "Landroid/graphics/Matrix;", "postAnimate", "animator", "Landroid/animation/Animator;", "preAnimate", "core_release"})
/* compiled from: ImageAnimHelperApi.kt */
public final class d implements g {
    private static final g aQN;
    public static final d aQO = new d();

    static {
        g fVar;
        if (VERSION.SDK_INT >= 21) {
            fVar = new f();
        } else {
            fVar = new e();
        }
        aQN = fVar;
    }

    private d() {
    }

    public void c(ImageView imageView) {
        h.e(imageView, Promotion.ACTION_VIEW);
        aQN.c(imageView);
    }

    public void a(ImageView imageView, Matrix matrix) {
        h.e(imageView, Promotion.ACTION_VIEW);
        h.e(matrix, "matrix");
        aQN.a(imageView, matrix);
    }

    public void a(ImageView imageView, Animator animator) {
        h.e(imageView, Promotion.ACTION_VIEW);
        h.e(animator, "animator");
        aQN.a(imageView, animator);
    }
}
