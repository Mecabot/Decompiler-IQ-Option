package com.iqoption.core.ui.b.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.transition.Transition;
import android.support.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;
import kotlin.i;
import kotlin.jvm.a.m;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00126\u0010\u0004\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0005¢\u0006\u0002\u0010\rJ\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016RA\u0010\u0004\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, aXE = {"Lcom/iqoption/core/ui/animation/transitions/SimpleFragmentTransitionProvider;", "Lcom/iqoption/core/ui/animation/transitions/EnterReturnTransitionProvider;", "fragment", "Lcom/iqoption/core/ui/fragment/IQFragment;", "animatorFactory", "Lkotlin/Function2;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "content", "", "isEnter", "Landroid/animation/Animator;", "(Lcom/iqoption/core/ui/fragment/IQFragment;Lkotlin/jvm/functions/Function2;)V", "getAnimatorFactory", "()Lkotlin/jvm/functions/Function2;", "getFragment", "()Lcom/iqoption/core/ui/fragment/IQFragment;", "getEnterTransition", "Landroid/support/transition/Transition;", "getReturnTransition", "core_release"})
/* compiled from: SimpleFragmentTransitionProvider.kt */
public final class d extends c {
    private final com.iqoption.core.ui.fragment.b bbf;
    private final m<View, Boolean, Animator> bbn;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\t¸\u0006\u0000"}, aXE = {"com/iqoption/core/ui/animation/transitions/TransitionsDSLKt$animatorTransition$2", "Lcom/iqoption/core/ui/animation/transitions/AnimatorTransition;", "createAnimator", "Landroid/animation/Animator;", "sceneRoot", "Landroid/view/ViewGroup;", "startValues", "Landroid/support/transition/TransitionValues;", "endValues", "core_release"})
    /* compiled from: TransitionsDSL.kt */
    public static final class a extends b {
        final /* synthetic */ String bbj;
        final /* synthetic */ d bbo;

        public a(String str, String str2, d dVar) {
            this.bbj = str;
            this.bbo = dVar;
            super(str2);
        }

        public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
            h.e(viewGroup, "sceneRoot");
            if (transitionValues2 != null) {
                View view = transitionValues2.view;
                if (view != null) {
                    return (Animator) this.bbo.YC().B(view, Boolean.valueOf(true));
                }
            }
            return null;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\t¸\u0006\u0000"}, aXE = {"com/iqoption/core/ui/animation/transitions/TransitionsDSLKt$animatorTransition$2", "Lcom/iqoption/core/ui/animation/transitions/AnimatorTransition;", "createAnimator", "Landroid/animation/Animator;", "sceneRoot", "Landroid/view/ViewGroup;", "startValues", "Landroid/support/transition/TransitionValues;", "endValues", "core_release"})
    /* compiled from: TransitionsDSL.kt */
    public static final class b extends b {
        final /* synthetic */ String bbj;
        final /* synthetic */ d bbo;

        @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006¸\u0006\b"}, aXE = {"com/iqoption/core/ui/animation/transitions/SimpleFragmentTransitionProvider$getReturnTransition$1$1$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "core_release", "com/iqoption/core/ui/animation/transitions/SimpleFragmentTransitionProvider$$special$$inlined$also$lambda$1", "com/iqoption/core/ui/animation/transitions/SimpleFragmentTransitionProvider$$special$$inlined$let$lambda$1"})
        /* compiled from: SimpleFragmentTransitionProvider.kt */
        public static final class a extends AnimatorListenerAdapter {
            final /* synthetic */ ViewGroup aCt;
            final /* synthetic */ View bbl;
            final /* synthetic */ b bbp;

            a(View view, ViewGroup viewGroup, b bVar) {
                this.bbl = view;
                this.aCt = viewGroup;
                this.bbp = bVar;
            }

            public void onAnimationEnd(Animator animator) {
                this.aCt.getOverlay().remove(this.bbl);
            }
        }

        public b(String str, String str2, d dVar) {
            this.bbj = str;
            this.bbo = dVar;
            super(str2);
        }

        public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
            h.e(viewGroup, "sceneRoot");
            if (transitionValues != null) {
                View view = transitionValues.view;
                if (view != null) {
                    Animator animator = (Animator) this.bbo.YC().B(view, Boolean.valueOf(false));
                    viewGroup.getOverlay().add(view);
                    animator.addListener(new a(view, viewGroup, this));
                    return animator;
                }
            }
            return null;
        }
    }

    public final m<View, Boolean, Animator> YC() {
        return this.bbn;
    }

    public d(com.iqoption.core.ui.fragment.b bVar, m<? super View, ? super Boolean, ? extends Animator> mVar) {
        h.e(bVar, "fragment");
        h.e(mVar, "animatorFactory");
        this.bbf = bVar;
        this.bbn = mVar;
    }

    public Transition Yy() {
        String YG = this.bbf.YG();
        return new a(YG, YG, this);
    }

    public Transition Yz() {
        String YG = this.bbf.YG();
        return new b(YG, YG, this);
    }
}
