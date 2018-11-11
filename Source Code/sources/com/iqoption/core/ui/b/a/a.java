package com.iqoption.core.ui.b.a;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, aXE = {"Lcom/iqoption/core/ui/animation/contentanimators/AlphaScaleAnimatorFactory;", "Lcom/iqoption/core/ui/animation/contentanimators/EnterExitContentAnimatorFactory;", "()V", "createEnterAnimator", "Landroid/animation/Animator;", "content", "Landroid/view/View;", "createExitAnimator", "core_release"})
/* compiled from: AlphaScaleAnimatorFactory.kt */
public final class a implements b {
    public Animator P(View view) {
        h.e(view, b.CONTENT);
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f, 1.0f}), PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{1.1f, 1.0f}), PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{1.1f, 1.0f})});
        Animator animator = ofPropertyValuesHolder;
        com.iqoption.core.ext.a.a(animator, 250);
        ofPropertyValuesHolder.setInterpolator(com.iqoption.core.graphics.animation.i.TI());
        h.d(ofPropertyValuesHolder, "ObjectAnimator.ofPropert…= standardCurve\n        }");
        return animator;
    }

    public Animator Q(View view) {
        h.e(view, b.CONTENT);
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{1.0f, 0.0f}), PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{1.0f, 1.1f}), PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{1.0f, 1.1f})});
        Animator animator = ofPropertyValuesHolder;
        com.iqoption.core.ext.a.a(animator, 250);
        ofPropertyValuesHolder.setInterpolator(com.iqoption.core.graphics.animation.i.TI());
        h.d(ofPropertyValuesHolder, "ObjectAnimator.ofPropert…= standardCurve\n        }");
        return animator;
    }
}
