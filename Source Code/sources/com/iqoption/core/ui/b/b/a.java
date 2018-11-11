package com.iqoption.core.ui.b.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.transition.Transition;
import android.support.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, aXE = {"Lcom/iqoption/core/ui/animation/transitions/AlphaScaleTransitionProvider;", "Lcom/iqoption/core/ui/animation/transitions/EnterReturnTransitionProvider;", "fragment", "Lcom/iqoption/core/ui/fragment/IQFragment;", "animatorFactory", "Lcom/iqoption/core/ui/animation/contentanimators/EnterExitContentAnimatorFactory;", "(Lcom/iqoption/core/ui/fragment/IQFragment;Lcom/iqoption/core/ui/animation/contentanimators/EnterExitContentAnimatorFactory;)V", "getEnterTransition", "Landroid/support/transition/Transition;", "getReturnTransition", "Companion", "core_release"})
/* compiled from: AlphaScaleTransitionProvider.kt */
public final class a extends c {
    private static final com.iqoption.core.ui.b.a.a bbh = new com.iqoption.core.ui.b.a.a();
    @Deprecated
    public static final a bbi = new a();
    private final com.iqoption.core.ui.fragment.b bbf;
    private final com.iqoption.core.ui.b.a.b bbg;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, aXE = {"Lcom/iqoption/core/ui/animation/transitions/AlphaScaleTransitionProvider$Companion;", "", "()V", "DEFAULT_ANIMATOR_FACTORY", "Lcom/iqoption/core/ui/animation/contentanimators/AlphaScaleAnimatorFactory;", "getDEFAULT_ANIMATOR_FACTORY", "()Lcom/iqoption/core/ui/animation/contentanimators/AlphaScaleAnimatorFactory;", "core_release"})
    /* compiled from: AlphaScaleTransitionProvider.kt */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\t¸\u0006\u0000"}, aXE = {"com/iqoption/core/ui/animation/transitions/TransitionsDSLKt$animatorTransition$2", "Lcom/iqoption/core/ui/animation/transitions/AnimatorTransition;", "createAnimator", "Landroid/animation/Animator;", "sceneRoot", "Landroid/view/ViewGroup;", "startValues", "Landroid/support/transition/TransitionValues;", "endValues", "core_release"})
    /* compiled from: TransitionsDSL.kt */
    public static final class b extends b {
        final /* synthetic */ String bbj;
        final /* synthetic */ a bbk;

        public b(String str, String str2, a aVar) {
            this.bbj = str;
            this.bbk = aVar;
            super(str2);
        }

        public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
            h.e(viewGroup, "sceneRoot");
            if (transitionValues2 != null) {
                View view = transitionValues2.view;
                if (view != null) {
                    return this.bbk.bbg.P(view);
                }
            }
            return null;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\t¸\u0006\u0000"}, aXE = {"com/iqoption/core/ui/animation/transitions/TransitionsDSLKt$animatorTransition$2", "Lcom/iqoption/core/ui/animation/transitions/AnimatorTransition;", "createAnimator", "Landroid/animation/Animator;", "sceneRoot", "Landroid/view/ViewGroup;", "startValues", "Landroid/support/transition/TransitionValues;", "endValues", "core_release"})
    /* compiled from: TransitionsDSL.kt */
    public static final class c extends b {
        final /* synthetic */ String bbj;
        final /* synthetic */ a bbk;

        @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006¸\u0006\b"}, aXE = {"com/iqoption/core/ui/animation/transitions/AlphaScaleTransitionProvider$getReturnTransition$1$1$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "core_release", "com/iqoption/core/ui/animation/transitions/AlphaScaleTransitionProvider$$special$$inlined$also$lambda$1", "com/iqoption/core/ui/animation/transitions/AlphaScaleTransitionProvider$$special$$inlined$let$lambda$1"})
        /* compiled from: AlphaScaleTransitionProvider.kt */
        public static final class a extends AnimatorListenerAdapter {
            final /* synthetic */ ViewGroup aCt;
            final /* synthetic */ View bbl;
            final /* synthetic */ c bbm;

            a(View view, ViewGroup viewGroup, c cVar) {
                this.bbl = view;
                this.aCt = viewGroup;
                this.bbm = cVar;
            }

            public void onAnimationEnd(Animator animator) {
                this.aCt.getOverlay().remove(this.bbl);
            }
        }

        public c(String str, String str2, a aVar) {
            this.bbj = str;
            this.bbk = aVar;
            super(str2);
        }

        public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
            h.e(viewGroup, "sceneRoot");
            if (transitionValues != null) {
                View view = transitionValues.view;
                if (view != null) {
                    Animator Q = this.bbk.bbg.Q(view);
                    viewGroup.getOverlay().add(view);
                    Q.addListener(new a(view, viewGroup, this));
                    return Q;
                }
            }
            return null;
        }
    }

    public /* synthetic */ a(com.iqoption.core.ui.fragment.b bVar, com.iqoption.core.ui.b.a.b bVar2, int i, f fVar) {
        if ((i & 2) != 0) {
            bVar2 = bbh;
        }
        this(bVar, bVar2);
    }

    public a(com.iqoption.core.ui.fragment.b bVar, com.iqoption.core.ui.b.a.b bVar2) {
        h.e(bVar, "fragment");
        h.e(bVar2, "animatorFactory");
        this.bbf = bVar;
        this.bbg = bVar2;
    }

    public Transition Yy() {
        String YG = this.bbf.YG();
        return new b(YG, YG, this);
    }

    public Transition Yz() {
        String YG = this.bbf.YG();
        return new c(YG, YG, this);
    }
}
