package com.iqoption.core.graphics.animation.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0002\u0010\u0005J\u001a\u00107\u001a\u00020\b2\u0010\u00108\u001a\f\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\tH\u0016J\u001a\u00109\u001a\u00020\b2\u0010\u00108\u001a\f\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\tH\u0016J\u001a\u0010:\u001a\u00020\b2\u0010\u00108\u001a\f\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\tH\u0016J\u001a\u0010;\u001a\u00020\b2\u0010\u00108\u001a\f\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\tH\u0016J\b\u0010<\u001a\u00020\bH\u0016J\b\u0010=\u001a\u00020\bH\u0016R(\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\u0004\u0018\u0001`\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR(\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\u0004\u0018\u0001`\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R(\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\u0004\u0018\u0001`\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000b\"\u0004\b\u0019\u0010\rR(\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\u0004\u0018\u0001`\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000b\"\u0004\b\u001c\u0010\rR\u0014\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R \u0010!\u001a\u0014\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\t\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R \u0010#\u001a\u0014\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\t\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\u00020\u001eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010 R \u0010&\u001a\u0014\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\t\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R \u0010'\u001a\u0014\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\t\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00028\u0000X\u0004¢\u0006\u0004\n\u0002\u0010(R\u001a\u0010)\u001a\u00020*X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010+\"\u0004\b,\u0010-R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u0002\n\u0000R4\u00100\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b\u0018\u000101j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`2X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106¨\u0006>"}, aXE = {"Lcom/iqoption/core/graphics/animation/transition/TemplateTransition;", "Info", "Lcom/iqoption/core/graphics/animation/transition/TransitionInfo;", "Lcom/iqoption/core/graphics/animation/transition/Transition;", "info", "(Lcom/iqoption/core/graphics/animation/transition/TransitionInfo;)V", "afterEnter", "Lkotlin/Function0;", "", "Lcom/iqoption/core/graphics/animation/transition/Callback;", "getAfterEnter", "()Lkotlin/jvm/functions/Function0;", "setAfterEnter", "(Lkotlin/jvm/functions/Function0;)V", "afterExit", "getAfterExit", "setAfterExit", "animatorFactory", "Lcom/iqoption/core/graphics/animation/transition/AnimatorFactory;", "getAnimatorFactory", "()Lcom/iqoption/core/graphics/animation/transition/AnimatorFactory;", "setAnimatorFactory", "(Lcom/iqoption/core/graphics/animation/transition/AnimatorFactory;)V", "beforeEnter", "getBeforeEnter", "setBeforeEnter", "beforeExit", "getBeforeExit", "setBeforeExit", "enterDuration", "", "getEnterDuration", "()J", "enterEndCallbacks", "", "enterStartCallbacks", "exitDuration", "getExitDuration", "exitEndCallbacks", "exitStartCallbacks", "Lcom/iqoption/core/graphics/animation/transition/TransitionInfo;", "isParallel", "", "()Z", "setParallel", "(Z)V", "playingAnimator", "Landroid/animation/Animator;", "reloader", "Lkotlin/Function1;", "Lcom/iqoption/core/graphics/animation/transition/Reloader;", "getReloader", "()Lkotlin/jvm/functions/Function1;", "setReloader", "(Lkotlin/jvm/functions/Function1;)V", "addEnterEndCallback", "callback", "addEnterStartCallback", "addExitEndCallback", "addExitStartCallback", "playEnter", "playExit", "core_release"})
/* compiled from: Transition.kt */
public class c<Info extends d> {
    private List<kotlin.jvm.a.a<l>> aRA;
    private List<kotlin.jvm.a.a<l>> aRB;
    private final Info aRC;
    private final long aRo = this.aRC.TX().TO();
    private final long aRp = this.aRC.TX().TP();
    private Animator aRq;
    private boolean aRr = true;
    private a<? super Info> aRs;
    private kotlin.jvm.a.b<? super Info, l> aRt;
    private kotlin.jvm.a.a<l> aRu;
    private kotlin.jvm.a.a<l> aRv;
    private kotlin.jvm.a.a<l> aRw;
    private kotlin.jvm.a.a<l> aRx;
    private List<kotlin.jvm.a.a<l>> aRy;
    private List<kotlin.jvm.a.a<l>> aRz;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, aXE = {"com/iqoption/core/graphics/animation/transition/TemplateTransition$playEnter$2$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "core_release"})
    /* compiled from: Transition.kt */
    public static final class a extends AnimatorListenerAdapter {
        final /* synthetic */ c aRD;

        a(c cVar) {
            this.aRD = cVar;
        }

        public void onAnimationEnd(Animator animator) {
            h.e(animator, "animation");
            kotlin.jvm.a.a TT = this.aRD.TT();
            if (TT != null) {
                l lVar = (l) TT.invoke();
            }
            List<kotlin.jvm.a.a> a = this.aRD.aRz;
            if (a != null) {
                for (kotlin.jvm.a.a invoke : a) {
                    invoke.invoke();
                }
            }
            this.aRD.aRz = (List) null;
            this.aRD.aRq = (Animator) null;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, aXE = {"com/iqoption/core/graphics/animation/transition/TemplateTransition$playExit$2$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "core_release"})
    /* compiled from: Transition.kt */
    public static final class b extends AnimatorListenerAdapter {
        final /* synthetic */ c aRD;

        b(c cVar) {
            this.aRD = cVar;
        }

        public void onAnimationEnd(Animator animator) {
            l lVar;
            h.e(animator, "animation");
            kotlin.jvm.a.a TU = this.aRD.TU();
            if (TU != null) {
                lVar = (l) TU.invoke();
            }
            List<kotlin.jvm.a.a> b = this.aRD.aRB;
            if (b != null) {
                for (kotlin.jvm.a.a invoke : b) {
                    invoke.invoke();
                }
            }
            this.aRD.aRB = (List) null;
            kotlin.jvm.a.b TS = this.aRD.TS();
            if (TS != null) {
                lVar = (l) TS.invoke(this.aRD.aRC);
            }
            this.aRD.aRq = (Animator) null;
        }
    }

    public c(Info info) {
        h.e(info, "info");
        this.aRC = info;
    }

    public long TQ() {
        return this.aRo;
    }

    public long TR() {
        return this.aRp;
    }

    public final void a(a<? super Info> aVar) {
        this.aRs = aVar;
    }

    public final kotlin.jvm.a.b<Info, l> TS() {
        return this.aRt;
    }

    public final void c(kotlin.jvm.a.a<l> aVar) {
        this.aRu = aVar;
    }

    public final kotlin.jvm.a.a<l> TT() {
        return this.aRv;
    }

    public final void d(kotlin.jvm.a.a<l> aVar) {
        this.aRw = aVar;
    }

    public final kotlin.jvm.a.a<l> TU() {
        return this.aRx;
    }

    public final void e(kotlin.jvm.a.a<l> aVar) {
        this.aRx = aVar;
    }

    public void TV() {
        Animator animator = this.aRq;
        if (animator != null) {
            animator.cancel();
        }
        kotlin.jvm.a.a aVar = this.aRu;
        if (aVar != null) {
            l lVar = (l) aVar.invoke();
        }
        List<kotlin.jvm.a.a> list = this.aRy;
        if (list != null) {
            for (kotlin.jvm.a.a invoke : list) {
                invoke.invoke();
            }
        }
        List list2 = null;
        this.aRy = null;
        AnimatorSet animatorSet = new AnimatorSet();
        Animator animator2 = animatorSet;
        this.aRq = animator2;
        a aVar2 = this.aRs;
        if (aVar2 != null) {
            list2 = aVar2.bc(this.aRC);
        }
        if (this.aRr) {
            animatorSet.playTogether(list2);
        } else {
            animatorSet.playSequentially(list2);
        }
        com.iqoption.core.ext.a.a(animator2, this.aRC.TX().TO());
        animatorSet.setInterpolator(com.iqoption.core.graphics.animation.i.TI());
        animatorSet.addListener(new a(this));
        animatorSet.start();
    }

    public void TW() {
        Animator animator = this.aRq;
        if (animator != null) {
            animator.cancel();
        }
        kotlin.jvm.a.a aVar = this.aRw;
        if (aVar != null) {
            l lVar = (l) aVar.invoke();
        }
        List<kotlin.jvm.a.a> list = this.aRA;
        if (list != null) {
            for (kotlin.jvm.a.a invoke : list) {
                invoke.invoke();
            }
        }
        List list2 = null;
        this.aRA = null;
        AnimatorSet animatorSet = new AnimatorSet();
        Animator animator2 = animatorSet;
        this.aRq = animator2;
        a aVar2 = this.aRs;
        if (aVar2 != null) {
            list2 = aVar2.bd(this.aRC);
        }
        if (this.aRr) {
            animatorSet.playTogether(list2);
        } else {
            animatorSet.playSequentially(list2);
        }
        com.iqoption.core.ext.a.a(animator2, this.aRC.TX().TP());
        animatorSet.setInterpolator(com.iqoption.core.graphics.animation.i.TI());
        animatorSet.addListener(new b(this));
        animatorSet.start();
    }
}
