package com.iqoption.quiz.chat;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.View;
import com.google.android.gms.analytics.ecommerce.Promotion;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\t8BX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\t8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000bR$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, aXE = {"Lcom/iqoption/quiz/chat/RecentButtonController;", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "backwardAnimator", "Landroid/animation/ObjectAnimator;", "kotlin.jvm.PlatformType", "backwardDuration", "", "getBackwardDuration", "()J", "forwardAnimator", "forwardDuration", "getForwardDuration", "value", "", "isShown", "()Z", "setShown", "(Z)V", "runningAnimator", "Landroid/animation/Animator;", "Companion", "quiz_release"})
/* compiled from: RecentButtonController.kt */
public final class h extends OnScrollListener {
    public static final a djO = new a();
    private final ObjectAnimator cDE;
    private final ObjectAnimator cDF;
    private boolean cDy;
    private Animator cDz;
    private final View view;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, aXE = {"Lcom/iqoption/quiz/chat/RecentButtonController$Companion;", "", "()V", "TOTAL_DURATION", "", "quiz_release"})
    /* compiled from: RecentButtonController.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0004\"\u0004\b\u0005\u0010\u0006¨\u0006\f¸\u0006\u0000"}, aXE = {"com/iqoption/quiz/chat/RecentButtonController$isShown$2$1", "Landroid/animation/AnimatorListenerAdapter;", "isCancelled", "", "()Z", "setCancelled", "(Z)V", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "quiz_release"})
    /* compiled from: RecentButtonController.kt */
    public static final class b extends AnimatorListenerAdapter {
        private boolean JF;
        final /* synthetic */ h djP;

        b(h hVar) {
            this.djP = hVar;
        }

        public void onAnimationCancel(Animator animator) {
            this.JF = true;
        }

        public void onAnimationEnd(Animator animator) {
            if (animator != null) {
                animator.removeAllListeners();
            }
            if (!this.JF) {
                com.iqoption.core.ext.a.M(this.djP.view);
            }
        }
    }

    public h(View view) {
        kotlin.jvm.internal.h.e(view, Promotion.ACTION_VIEW);
        this.view = view;
        view = this.view;
        PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[2];
        propertyValuesHolderArr[0] = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{1.0f});
        propertyValuesHolderArr[1] = PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{0.0f});
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, propertyValuesHolderArr);
        ofPropertyValuesHolder.setInterpolator(com.iqoption.core.graphics.animation.i.TI());
        this.cDE = ofPropertyValuesHolder;
        view = this.view;
        PropertyValuesHolder[] propertyValuesHolderArr2 = new PropertyValuesHolder[2];
        propertyValuesHolderArr2[0] = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f});
        propertyValuesHolderArr2[1] = PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{com.iqoption.core.ext.a.e(this.view, com.iqoption.quiz.ae.a.dp20)});
        ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, propertyValuesHolderArr2);
        ofPropertyValuesHolder.setInterpolator(com.iqoption.core.graphics.animation.i.TI());
        this.cDF = ofPropertyValuesHolder;
        this.view.setAlpha(0.0f);
        this.view.setTranslationY(com.iqoption.core.ext.a.e(this.view, com.iqoption.quiz.ae.a.dp20));
    }

    private final long ame() {
        return c.af((1.0f - this.view.getAlpha()) * ((float) 150));
    }

    private final long amf() {
        return c.af(this.view.getAlpha() * ((float) 150));
    }

    public final void ar(boolean z) {
        if (this.cDy != z) {
            ObjectAnimator objectAnimator;
            this.cDy = z;
            Animator animator = this.cDz;
            if (animator != null) {
                animator.cancel();
            }
            if (z) {
                objectAnimator = this.cDE;
                com.iqoption.core.ext.a.L(this.view);
                objectAnimator.setDuration(ame());
            } else {
                objectAnimator = this.cDF;
                objectAnimator.setDuration(amf());
                objectAnimator.addListener(new b(this));
            }
            objectAnimator.start();
            this.cDz = objectAnimator;
        }
    }
}
