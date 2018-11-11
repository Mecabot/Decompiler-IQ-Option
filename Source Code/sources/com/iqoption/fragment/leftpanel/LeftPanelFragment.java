package com.iqoption.fragment.leftpanel;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.iqoption.chat.fragment.q;
import com.iqoption.d.oh;
import com.iqoption.fragment.cn;
import com.iqoption.fragment.leftmenu.LeftMenuViewModel;
import com.iqoption.fragment.leftmenu.SupportUnreadIndicatorViewModel;
import com.iqoption.portfolio.a.z;
import com.iqoption.quiz.QuizFragment;
import com.iqoption.quiz.model.QuizInsightsViewModel;
import com.iqoption.quiz.model.TriviaSocketViewModel;
import com.iqoption.x.R;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref.ObjectRef;

@kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 12\u00020\u00012\u00020\u00022\u00020\u0003:\u0003012B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u000eH\u0002J\b\u0010\u0018\u001a\u00020\u0010H\u0002J\u0012\u0010\u0019\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J&\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010#\u001a\u00020\u0010H\u0016J\u001a\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u001b2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010&\u001a\u00020\u000eH\u0002J\u0018\u0010'\u001a\u00020\u000e2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0012H\u0002J\u0010\u0010+\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010,\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020\u0010H\u0002J\b\u0010.\u001a\u00020\u0010H\u0002J\u0010\u0010/\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000¨\u00063"}, aXE = {"Lcom/iqoption/fragment/leftpanel/LeftPanelFragment;", "Lcom/iqoption/core/ui/fragment/IQFragment;", "Landroid/view/View$OnClickListener;", "Lcom/iqoption/feed/SmartFeedFragment$OnSmartFeedCloseListener;", "()V", "binding", "Lcom/iqoption/databinding/FragmentLeftPanelBinding;", "insightsViewModel", "Lcom/iqoption/quiz/model/QuizInsightsViewModel;", "quizViewModel", "Lcom/iqoption/quiz/model/TriviaSocketViewModel;", "viewModel", "Lcom/iqoption/fragment/leftpanel/LeftPanelViewModel;", "animateQuizIcon", "", "isOnAir", "", "countDownTime", "", "getViewBySection", "Landroid/widget/ImageView;", "section", "Lcom/iqoption/fragment/leftpanel/LeftPanelSection;", "initQuiz", "onBackPressed", "onClick", "v", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onSmartFeedClose", "onViewCreated", "view", "removeFragment", "replace", "fragment", "Landroid/support/v4/app/Fragment;", "tag", "replaceFragment", "setFragmentContainerClickable", "clickable", "tryShowQuizWhatsNew", "updateOnAir", "ButtonsAnimationController", "Companion", "DotAnimationController", "IqOption-5.5.1_optionXRelease"})
/* compiled from: LeftPanelFragment.kt */
public final class LeftPanelFragment extends com.iqoption.core.ui.fragment.b implements OnClickListener, com.iqoption.feed.b.a {
    private static final String TAG = "LeftPanelFragment";
    public static final g cDs = new g();
    private HashMap atz;
    private oh cDo;
    private LeftPanelViewModel cDp;
    private TriviaSocketViewModel cDq;
    private QuizInsightsViewModel cDr;

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000 &2\u00020\u0001:\u0001&B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010!\u001a\u00020 H\u0002J\b\u0010\"\u001a\u00020 H\u0002J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020 H\u0016R#\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\r8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R#\u0010\u0010\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0011\u0010\tR\u0014\u0010\u0013\u001a\u00020\r8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000fR$\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0016@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u001c8BX\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, aXE = {"Lcom/iqoption/fragment/leftpanel/LeftPanelFragment$ButtonsAnimationController;", "Landroid/animation/AnimatorListenerAdapter;", "buttons", "Landroid/view/View;", "(Landroid/view/View;)V", "backwardAnimator", "Landroid/animation/ObjectAnimator;", "kotlin.jvm.PlatformType", "getBackwardAnimator", "()Landroid/animation/ObjectAnimator;", "backwardAnimator$delegate", "Lkotlin/Lazy;", "backwardDuration", "", "getBackwardDuration", "()J", "forwardAnimator", "getForwardAnimator", "forwardAnimator$delegate", "forwardDuration", "getForwardDuration", "value", "", "isShown", "()Z", "setShown", "(Z)V", "progress", "", "getProgress", "()F", "runningAnimator", "Landroid/animation/Animator;", "animateBackward", "animateForward", "onAnimationEnd", "", "animation", "Companion", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: LeftPanelFragment.kt */
    private static final class f extends AnimatorListenerAdapter {
        static final /* synthetic */ kotlin.reflect.j[] apP = new kotlin.reflect.j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(f.class), "forwardAnimator", "getForwardAnimator()Landroid/animation/ObjectAnimator;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(f.class), "backwardAnimator", "getBackwardAnimator()Landroid/animation/ObjectAnimator;"))};
        public static final a cDD = new a();
        private final kotlin.d cDA = g.f(new LeftPanelFragment$ButtonsAnimationController$forwardAnimator$2(this));
        private final kotlin.d cDB = g.f(new LeftPanelFragment$ButtonsAnimationController$backwardAnimator$2(this));
        private final View cDC;
        private boolean cDy = true;
        private Animator cDz;

        @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, aXE = {"Lcom/iqoption/fragment/leftpanel/LeftPanelFragment$ButtonsAnimationController$Companion;", "", "()V", "DURATION", "", "IqOption-5.5.1_optionXRelease"})
        /* compiled from: LeftPanelFragment.kt */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(f fVar) {
                this();
            }
        }

        private final ObjectAnimator amc() {
            kotlin.d dVar = this.cDA;
            kotlin.reflect.j jVar = apP[0];
            return (ObjectAnimator) dVar.getValue();
        }

        private final ObjectAnimator amd() {
            kotlin.d dVar = this.cDB;
            kotlin.reflect.j jVar = apP[1];
            return (ObjectAnimator) dVar.getValue();
        }

        public f(View view) {
            kotlin.jvm.internal.h.e(view, "buttons");
            this.cDC = view;
        }

        public final void ar(boolean z) {
            if (this.cDy != z) {
                Animator amg;
                Animator animator = this.cDz;
                if (animator != null) {
                    animator.cancel();
                }
                this.cDy = z;
                if (z) {
                    amg = amg();
                } else {
                    amg = amh();
                }
                this.cDz = amg;
            }
        }

        private final float getProgress() {
            return com.iqoption.core.ext.c.c(this.cDC.getTranslationX(), (float) this.cDC.getWidth(), 0.0f);
        }

        private final long ame() {
            return c.af(((float) 250) * (1.0f - getProgress()));
        }

        private final long amf() {
            return c.af(((float) 250) * getProgress());
        }

        private final Animator amg() {
            ObjectAnimator amc = amc();
            amc.setDuration(ame());
            amc.addListener(this);
            amc.start();
            kotlin.jvm.internal.h.d(amc, "forwardAnimator.apply {\n…    start()\n            }");
            return amc;
        }

        private final Animator amh() {
            ObjectAnimator amd = amd();
            amd.setDuration(amf());
            amd.addListener(this);
            amd.start();
            kotlin.jvm.internal.h.d(amd, "backwardAnimator.apply {…    start()\n            }");
            return amd;
        }

        public void onAnimationEnd(Animator animator) {
            kotlin.jvm.internal.h.e(animator, "animation");
            animator.removeAllListeners();
            this.cDz = (Animator) null;
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, aXE = {"Lcom/iqoption/fragment/leftpanel/LeftPanelFragment$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "newInstance", "Lcom/iqoption/fragment/leftpanel/LeftPanelFragment;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: LeftPanelFragment.kt */
    public static final class g {
        private g() {
        }

        public /* synthetic */ g(f fVar) {
            this();
        }

        public final String Ll() {
            return LeftPanelFragment.TAG;
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u0018\u001a\u00020\u0016H\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0016H\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\t8BX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\t8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000bR$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, aXE = {"Lcom/iqoption/fragment/leftpanel/LeftPanelFragment$DotAnimationController;", "Landroid/animation/AnimatorListenerAdapter;", "d", "Lcom/iqoption/core/graphics/drawable/DecoratedPathDrawable;", "(Lcom/iqoption/core/graphics/drawable/DecoratedPathDrawable;)V", "backwardAnimator", "Landroid/animation/ObjectAnimator;", "kotlin.jvm.PlatformType", "backwardDuration", "", "getBackwardDuration", "()J", "forwardAnimator", "forwardDuration", "getForwardDuration", "value", "", "isShown", "()Z", "setShown", "(Z)V", "runningAnimator", "Landroid/animation/Animator;", "animateBackward", "animateForward", "onAnimationEnd", "", "animation", "Companion", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: LeftPanelFragment.kt */
    private static final class h extends AnimatorListenerAdapter {
        public static final a cDH = new a();
        private final ObjectAnimator cDE;
        private final ObjectAnimator cDF;
        private final com.iqoption.core.graphics.a.a cDG;
        private boolean cDy;
        private Animator cDz;

        @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, aXE = {"Lcom/iqoption/fragment/leftpanel/LeftPanelFragment$DotAnimationController$Companion;", "", "()V", "DURATION", "", "IqOption-5.5.1_optionXRelease"})
        /* compiled from: LeftPanelFragment.kt */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(f fVar) {
                this();
            }
        }

        public h(com.iqoption.core.graphics.a.a aVar) {
            kotlin.jvm.internal.h.e(aVar, "d");
            this.cDG = aVar;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.cDG, com.iqoption.core.graphics.a.a.aRI.Ub(), new float[]{1.0f});
            ofFloat.setInterpolator(com.iqoption.core.graphics.animation.i.TI());
            this.cDE = ofFloat;
            ofFloat = ObjectAnimator.ofFloat(this.cDG, com.iqoption.core.graphics.a.a.aRI.Ub(), new float[]{0.0f});
            ofFloat.setInterpolator(com.iqoption.core.graphics.animation.i.TI());
            this.cDF = ofFloat;
        }

        public final void ar(boolean z) {
            if (this.cDy != z) {
                Animator amg;
                Animator animator = this.cDz;
                if (animator != null) {
                    animator.cancel();
                }
                this.cDy = z;
                if (z) {
                    amg = amg();
                } else {
                    amg = amh();
                }
                this.cDz = amg;
            }
        }

        private final long ame() {
            return c.af(((float) 150) * (1.0f - this.cDG.getProgress()));
        }

        private final long amf() {
            return c.af(((float) 150) * this.cDG.getProgress());
        }

        private final Animator amg() {
            ObjectAnimator objectAnimator = this.cDE;
            objectAnimator.setDuration(ame());
            objectAnimator.addListener(this);
            objectAnimator.start();
            kotlin.jvm.internal.h.d(objectAnimator, "forwardAnimator.apply {\n…    start()\n            }");
            return objectAnimator;
        }

        private final Animator amh() {
            ObjectAnimator objectAnimator = this.cDF;
            objectAnimator.setDuration(amf());
            objectAnimator.addListener(this);
            objectAnimator.start();
            kotlin.jvm.internal.h.d(objectAnimator, "backwardAnimator.apply {…    start()\n            }");
            return objectAnimator;
        }

        public void onAnimationEnd(Animator animator) {
            kotlin.jvm.internal.h.e(animator, "animation");
            animator.removeAllListeners();
            this.cDz = (Animator) null;
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
    /* compiled from: LeftPanelFragment.kt */
    static final class o implements Runnable {
        final /* synthetic */ LeftPanelFragment this$0;

        o(LeftPanelFragment leftPanelFragment) {
            this.this$0 = leftPanelFragment;
        }

        public final void run() {
            com.iqoption.fragment.dialog.whatsnew.a.b(com.iqoption.core.ext.a.n(this.this$0), com.iqoption.core.ext.a.n(this.this$0).getSupportFragmentManager(), "WHATS_NEW_DIALOG_TYPE_QUIZ");
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u0001H\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "T", "it", "onChanged", "(Ljava/lang/Object;)V", "com/iqoption/util/LiveDatasKt$observe$1"})
    /* compiled from: LiveDatas.kt */
    public static final class a<T> implements Observer<T> {
        final /* synthetic */ f cDt;

        public a(f fVar) {
            this.cDt = fVar;
        }

        public final void onChanged(T t) {
            if (t != null) {
                this.cDt.ar(((Boolean) t).booleanValue());
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u0001H\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "T", "it", "onChanged", "(Ljava/lang/Object;)V", "com/iqoption/util/LiveDatasKt$observe$1"})
    /* compiled from: LiveDatas.kt */
    public static final class b<T> implements Observer<T> {
        final /* synthetic */ h cDu;

        public b(h hVar) {
            this.cDu = hVar;
        }

        public final void onChanged(T t) {
            if (t != null) {
                this.cDu.ar(((Boolean) t).booleanValue());
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u0001H\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "T", "it", "onChanged", "(Ljava/lang/Object;)V", "com/iqoption/util/LiveDatasKt$observe$1"})
    /* compiled from: LiveDatas.kt */
    public static final class c<T> implements Observer<T> {
        final /* synthetic */ h cDv;

        public c(h hVar) {
            this.cDv = hVar;
        }

        public final void onChanged(T t) {
            if (t != null) {
                this.cDv.ar(((Boolean) t).booleanValue());
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u0001H\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "T", "it", "onChanged", "(Ljava/lang/Object;)V", "com/iqoption/util/LiveDatasKt$observe$1"})
    /* compiled from: LiveDatas.kt */
    public static final class d<T> implements Observer<T> {
        final /* synthetic */ h cDw;

        public d(h hVar) {
            this.cDw = hVar;
        }

        public final void onChanged(T t) {
            if (t != null) {
                this.cDw.ar(((Number) t).intValue() != 0);
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u0001H\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "T", "it", "onChanged", "(Ljava/lang/Object;)V", "com/iqoption/util/LiveDatasKt$observe$1"})
    /* compiled from: LiveDatas.kt */
    public static final class e<T> implements Observer<T> {
        final /* synthetic */ h cDx;

        public e(h hVar) {
            this.cDx = hVar;
        }

        public final void onChanged(T t) {
            if (t != null) {
                this.cDx.ar(((Boolean) t).booleanValue());
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u0001H\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "T", "it", "onChanged", "(Ljava/lang/Object;)V", "com/iqoption/util/LiveDatasKt$observe$1"})
    /* compiled from: LiveDatas.kt */
    public static final class i<T> implements Observer<T> {
        final /* synthetic */ LeftPanelFragment this$0;

        public i(LeftPanelFragment leftPanelFragment) {
            this.this$0 = leftPanelFragment;
        }

        public final void onChanged(T t) {
            if (t != null) {
                String str = (String) t;
                TextView textView = (TextView) this.this$0.dj(com.iqoption.b.a.quizCountDown);
                kotlin.jvm.internal.h.d(textView, "quizCountDown");
                textView.setText(str);
                textView = (TextView) this.this$0.dj(com.iqoption.b.a.quizCountDown);
                kotlin.jvm.internal.h.d(textView, "quizCountDown");
                textView.setVisibility(kotlin.jvm.internal.h.E(str, "") ? 8 : 0);
                boolean aBJ = LeftPanelFragment.c(this.this$0).aBJ();
                this.this$0.dm(aBJ);
                this.this$0.g(aBJ, str);
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u0001H\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "T", "it", "onChanged", "(Ljava/lang/Object;)V", "com/iqoption/util/LiveDatasKt$observe$1"})
    /* compiled from: LiveDatas.kt */
    public static final class j<T> implements Observer<T> {
        final /* synthetic */ LeftPanelFragment this$0;

        public j(LeftPanelFragment leftPanelFragment) {
            this.this$0 = leftPanelFragment;
        }

        public final void onChanged(T t) {
            if (t != null) {
                boolean booleanValue = ((Boolean) ((com.iqoption.core.ui.c) t).bl(Boolean.valueOf(false))).booleanValue();
                this.this$0.dm(booleanValue);
                LeftPanelFragment leftPanelFragment = this.this$0;
                String str = (String) LeftPanelFragment.c(this.this$0).aBF().getValue();
                if (str == null) {
                    str = "";
                }
                leftPanelFragment.g(booleanValue, str);
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u0001H\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "T", "it", "onChanged", "(Ljava/lang/Object;)V", "com/iqoption/util/LiveDatasKt$observe$1"})
    /* compiled from: LiveDatas.kt */
    public static final class k<T> implements Observer<T> {
        final /* synthetic */ LiveData cDI;
        final /* synthetic */ LeftPanelFragment this$0;

        @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, aXE = {"<anonymous>", "", "run", "com/iqoption/fragment/leftpanel/LeftPanelFragment$initQuiz$4$1"})
        /* compiled from: LeftPanelFragment.kt */
        static final class a implements Runnable {
            final /* synthetic */ com.iqoption.core.ui.c cDJ;
            final /* synthetic */ k cDK;

            a(com.iqoption.core.ui.c cVar, k kVar) {
                this.cDJ = cVar;
                this.cDK = kVar;
            }

            public final void run() {
                if (this.cDJ.isSuccess()) {
                    com.iqoption.app.a.b.cV(R.string.quiz_referral_code_applied);
                    return;
                }
                String message = this.cDJ.getMessage();
                if (message != null) {
                    if ((((CharSequence) message).length() > 0 ? 1 : null) == 1) {
                        message = this.cDJ.getMessage();
                        String Ll = LeftPanelFragment.cDs.Ll();
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Quiz referral code error: ");
                        stringBuilder.append(message);
                        com.iqoption.core.i.e(Ll, stringBuilder.toString());
                        kotlin.jvm.internal.m mVar = kotlin.jvm.internal.m.euz;
                        Locale locale = Locale.US;
                        kotlin.jvm.internal.h.d(locale, "Locale.US");
                        Object[] objArr = new Object[]{this.cDK.this$0.getString(R.string.quiz), message};
                        message = String.format(locale, "%s: %s", Arrays.copyOf(objArr, objArr.length));
                        kotlin.jvm.internal.h.d(message, "java.lang.String.format(locale, format, *args)");
                        com.iqoption.app.a.b.eQ(message);
                    }
                }
            }
        }

        public k(LeftPanelFragment leftPanelFragment, LiveData liveData) {
            this.this$0 = leftPanelFragment;
            this.cDI = liveData;
        }

        public final void onChanged(T t) {
            if (t != null) {
                com.iqoption.core.d.a.aSe.postDelayed(new a((com.iqoption.core.ui.c) t, this), 5000);
                this.cDI.removeObservers(this.this$0);
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/fragment/leftpanel/LeftPanelSection;", "onChanged"})
    /* compiled from: LeftPanelFragment.kt */
    static final class l<T> implements Observer<b> {
        final /* synthetic */ LeftPanelFragment this$0;

        l(LeftPanelFragment leftPanelFragment) {
            this.this$0 = leftPanelFragment;
        }

        /* renamed from: c */
        public final void onChanged(b bVar) {
            LeftPanelFragment leftPanelFragment = this.this$0;
            boolean aBJ = LeftPanelFragment.c(this.this$0).aBJ();
            String str = (String) LeftPanelFragment.c(this.this$0).aBF().getValue();
            if (str == null) {
                str = "";
            }
            leftPanelFragment.g(aBJ, str);
            this.this$0.ama();
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000J\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u0001H\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, aXE = {"<anonymous>", "", "T", "it", "onChanged", "(Ljava/lang/Object;)V", "com/iqoption/util/LiveDatasKt$observeNullable$1", "com/iqoption/fragment/leftpanel/LeftPanelFragment$$special$$inlined$observeNullable$1"})
    /* compiled from: LiveDatas.kt */
    public static final class m<T> implements Observer<T> {
        final /* synthetic */ ObjectRef cDL;
        final /* synthetic */ LeftPanelFragment this$0;

        public m(ObjectRef objectRef, LeftPanelFragment leftPanelFragment) {
            this.cDL = objectRef;
            this.this$0 = leftPanelFragment;
        }

        public final void onChanged(T t) {
            b bVar = (b) t;
            if (bVar == null) {
                View view = (View) this.cDL.element;
                if (view != null) {
                    view.setSelected(false);
                }
                this.cDL.element = (View) null;
                this.this$0.amb();
                return;
            }
            this.this$0.b(bVar);
            ImageView b = this.this$0.a(bVar);
            b.setSelected(true);
            View view2 = (View) this.cDL.element;
            if (view2 != null) {
                view2.setSelected(false);
            }
            this.cDL.element = b;
            kotlin.jvm.internal.h.d(b, "getViewBySection(section… it\n                    }");
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000J\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u0001H\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, aXE = {"<anonymous>", "", "T", "it", "onChanged", "(Ljava/lang/Object;)V", "com/iqoption/util/LiveDatasKt$observe$1", "com/iqoption/fragment/leftpanel/LeftPanelFragment$$special$$inlined$observe$6"})
    /* compiled from: LiveDatas.kt */
    public static final class n<T> implements Observer<T> {
        final /* synthetic */ List cDM;
        final /* synthetic */ LeftPanelFragment this$0;

        public n(List list, LeftPanelFragment leftPanelFragment) {
            this.cDM = list;
            this.this$0 = leftPanelFragment;
        }

        public final void onChanged(T t) {
            if (t != null) {
                List<b> list = (List) t;
                List<ImageView> O = u.O((Collection) this.cDM);
                for (b b : list) {
                    ImageView b2 = this.this$0.a(b);
                    O.remove(b2);
                    kotlin.jvm.internal.h.d(b2, "getViewBySection(it).als…ctionsToGone.remove(it) }");
                    com.iqoption.core.ext.a.L(b2);
                }
                for (ImageView imageView : O) {
                    kotlin.jvm.internal.h.d(imageView, "it");
                    com.iqoption.core.ext.a.M(imageView);
                }
            }
        }
    }

    public void KH() {
        if (this.atz != null) {
            this.atz.clear();
        }
    }

    public View dj(int i) {
        if (this.atz == null) {
            this.atz = new HashMap();
        }
        View view = (View) this.atz.get(Integer.valueOf(i));
        if (view == null) {
            view = getView();
            if (view == null) {
                return null;
            }
            view = view.findViewById(i);
            this.atz.put(Integer.valueOf(i), view);
        }
        return view;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        KH();
    }

    public static final /* synthetic */ TriviaSocketViewModel c(LeftPanelFragment leftPanelFragment) {
        TriviaSocketViewModel triviaSocketViewModel = leftPanelFragment.cDq;
        if (triviaSocketViewModel == null) {
            kotlin.jvm.internal.h.lS("quizViewModel");
        }
        return triviaSocketViewModel;
    }

    static {
        kotlin.jvm.internal.h.d(LeftPanelFragment.class.getSimpleName(), "LeftPanelFragment::class.java.simpleName");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.h.e(layoutInflater, "inflater");
        this.cDo = (oh) com.iqoption.core.ext.a.a((Fragment) this, (int) R.layout.fragment_left_panel, viewGroup, false, 4, null);
        LeftPanelViewModel l = LeftPanelViewModel.cEc.l(com.iqoption.core.ext.a.n(this));
        kotlin.jvm.internal.h.d(l, "LeftPanelViewModel.get(act)");
        this.cDp = l;
        this.cDq = TriviaSocketViewModel.dmB.x(com.iqoption.core.ext.a.n(this));
        this.cDr = QuizInsightsViewModel.dlH.w(com.iqoption.core.ext.a.n(this));
        oh ohVar = this.cDo;
        if (ohVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        com.iqoption.core.l lVar = new com.iqoption.core.l(com.iqoption.core.ext.a.n(this));
        LinearLayout linearLayout = ohVar.bmP;
        kotlin.jvm.internal.h.d(linearLayout, "buttonsLayout");
        f fVar = new f(linearLayout);
        LeftPanelViewModel leftPanelViewModel = this.cDp;
        if (leftPanelViewModel == null) {
            kotlin.jvm.internal.h.lS("viewModel");
        }
        LifecycleOwner lifecycleOwner = this;
        leftPanelViewModel.amj().observe(lifecycleOwner, new a(fVar));
        com.iqoption.core.k kVar = lVar;
        com.iqoption.core.graphics.a.a a = a.a(kVar);
        ohVar.byP.setImageDrawable(a);
        h hVar = new h(a);
        LeftPanelViewModel leftPanelViewModel2 = this.cDp;
        if (leftPanelViewModel2 == null) {
            kotlin.jvm.internal.h.lS("viewModel");
        }
        leftPanelViewModel2.amk().observe(lifecycleOwner, new b(hVar));
        a = a.b(kVar);
        ohVar.byV.setImageDrawable(a);
        hVar = new h(a);
        leftPanelViewModel2 = this.cDp;
        if (leftPanelViewModel2 == null) {
            kotlin.jvm.internal.h.lS("viewModel");
        }
        leftPanelViewModel2.aml().observe(lifecycleOwner, new c(hVar));
        a = a.c(kVar);
        ohVar.byL.setImageDrawable(a);
        new SupportUnreadIndicatorViewModel().alS().observe(lifecycleOwner, new d(new h(a)));
        leftPanelViewModel2 = this.cDp;
        if (leftPanelViewModel2 == null) {
            kotlin.jvm.internal.h.lS("viewModel");
        }
        com.iqoption.core.graphics.a.a d;
        if (leftPanelViewModel2.amp()) {
            d = a.d(kVar);
            ohVar.byQ.setImageDrawable(d);
            new h(d).ar(true);
        } else {
            leftPanelViewModel2 = this.cDp;
            if (leftPanelViewModel2 == null) {
                kotlin.jvm.internal.h.lS("viewModel");
            }
            if (leftPanelViewModel2.amo()) {
                d = a.e(kVar);
                ohVar.byQ.setImageDrawable(d);
                h hVar2 = new h(d);
                QuizInsightsViewModel quizInsightsViewModel = this.cDr;
                if (quizInsightsViewModel == null) {
                    kotlin.jvm.internal.h.lS("insightsViewModel");
                }
                quizInsightsViewModel.aBs().observe(lifecycleOwner, new e(hVar2));
            }
        }
        ObjectRef objectRef = new ObjectRef();
        objectRef.element = (View) null;
        leftPanelViewModel2 = this.cDp;
        if (leftPanelViewModel2 == null) {
            kotlin.jvm.internal.h.lS("viewModel");
        }
        leftPanelViewModel2.amn().observe(lifecycleOwner, new m(objectRef, this));
        r8 = new ImageView[7];
        int i = 0;
        r8[0] = ohVar.byP;
        r8[1] = ohVar.byU;
        r8[2] = ohVar.byQ;
        r8[3] = ohVar.byT;
        r8[4] = ohVar.byV;
        r8[5] = ohVar.byL;
        r8[6] = ohVar.byO;
        List listOf = m.listOf(r8);
        leftPanelViewModel2 = this.cDp;
        if (leftPanelViewModel2 == null) {
            kotlin.jvm.internal.h.lS("viewModel");
        }
        leftPanelViewModel2.amm().observe(lifecycleOwner, new n(listOf, this));
        OnClickListener onClickListener = this;
        ohVar.byN.setOnClickListener(onClickListener);
        LinearLayout linearLayout2 = ohVar.bmP;
        kotlin.jvm.internal.h.d(linearLayout2, "buttonsLayout");
        ViewGroup viewGroup2 = linearLayout2;
        int childCount = viewGroup2.getChildCount();
        while (i < childCount) {
            View childAt = viewGroup2.getChildAt(i);
            kotlin.jvm.internal.h.d(childAt, "getChildAt(index)");
            childAt.setOnClickListener(onClickListener);
            i++;
        }
        alZ();
        Lifecycle lifecycle = getLifecycle();
        FragmentActivity activity = zzakw();
        if (activity == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.iqoption.view.BackController");
        }
        lifecycle.a(new BackListenerObserver((com.iqoption.view.e) activity, new LeftPanelFragment$onCreateView$2(this)));
        ohVar = this.cDo;
        if (ohVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        return ohVar.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.h.e(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        g(false, "");
    }

    private final void alZ() {
        LeftPanelViewModel leftPanelViewModel = this.cDp;
        if (leftPanelViewModel == null) {
            kotlin.jvm.internal.h.lS("viewModel");
        }
        if (leftPanelViewModel.amo()) {
            TriviaSocketViewModel triviaSocketViewModel = this.cDq;
            if (triviaSocketViewModel == null) {
                kotlin.jvm.internal.h.lS("quizViewModel");
            }
            LifecycleOwner lifecycleOwner = this;
            triviaSocketViewModel.aBF().observe(lifecycleOwner, new i(this));
            triviaSocketViewModel = this.cDq;
            if (triviaSocketViewModel == null) {
                kotlin.jvm.internal.h.lS("quizViewModel");
            }
            triviaSocketViewModel.aBI().observe(lifecycleOwner, new j(this));
            leftPanelViewModel = this.cDp;
            if (leftPanelViewModel == null) {
                kotlin.jvm.internal.h.lS("viewModel");
            }
            leftPanelViewModel.amn().observe(lifecycleOwner, new l(this));
            triviaSocketViewModel = this.cDq;
            if (triviaSocketViewModel == null) {
                kotlin.jvm.internal.h.lS("quizViewModel");
            }
            LiveData aCa = triviaSocketViewModel.aCa();
            aCa.observe(lifecycleOwner, new k(this, aCa));
        }
    }

    private final void dm(boolean z) {
        TextView textView;
        if (z) {
            textView = (TextView) dj(com.iqoption.b.a.quizCountDown);
            kotlin.jvm.internal.h.d(textView, "quizCountDown");
            textView.setVisibility(8);
            textView = (TextView) dj(com.iqoption.b.a.quizOnAir);
            kotlin.jvm.internal.h.d(textView, "quizOnAir");
            textView.setVisibility(0);
            return;
        }
        textView = (TextView) dj(com.iqoption.b.a.quizOnAir);
        kotlin.jvm.internal.h.d(textView, "quizOnAir");
        textView.setVisibility(8);
    }

    private final void g(boolean z, String str) {
        if (VERSION.SDK_INT >= 21) {
            oh ohVar = this.cDo;
            if (ohVar == null) {
                kotlin.jvm.internal.h.lS("binding");
            }
            ImageView imageView = ohVar.byQ;
            kotlin.jvm.internal.h.d(imageView, "binding.quiz");
            Drawable drawable = imageView.getDrawable();
            if (!(drawable instanceof AnimatedVectorDrawable)) {
                drawable = null;
            }
            AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) drawable;
            if (animatedVectorDrawable != null) {
                if (z || (kotlin.jvm.internal.h.E(str, "") ^ 1) != 0) {
                    LeftPanelViewModel leftPanelViewModel = this.cDp;
                    if (leftPanelViewModel == null) {
                        kotlin.jvm.internal.h.lS("viewModel");
                    }
                    if (((b) leftPanelViewModel.amn().getValue()) != com.iqoption.fragment.leftpanel.b.d.cDQ) {
                        if (!animatedVectorDrawable.isRunning()) {
                            animatedVectorDrawable.start();
                            return;
                        }
                        return;
                    }
                }
                if (animatedVectorDrawable.isRunning()) {
                    animatedVectorDrawable.stop();
                }
            }
        }
    }

    private final boolean ama() {
        LeftPanelViewModel leftPanelViewModel = this.cDp;
        if (leftPanelViewModel == null) {
            kotlin.jvm.internal.h.lS("viewModel");
        }
        if (((b) leftPanelViewModel.amn().getValue()) != com.iqoption.fragment.leftpanel.b.d.cDQ || !com.iqoption.app.managers.feature.a.eW("iq-quiz") || !com.iqoption.fragment.dialog.whatsnew.a.y(getContext(), "WHATS_NEW_DIALOG_TYPE_QUIZ")) {
            return false;
        }
        com.iqoption.core.d.a.aSe.postDelayed(new o(this), 400);
        return true;
    }

    private final boolean onBackPressed() {
        boolean z = false;
        if (com.iqoption.core.ext.a.p(this).getBackStackEntryCount() != 0) {
            return false;
        }
        LeftPanelViewModel leftPanelViewModel = this.cDp;
        if (leftPanelViewModel == null) {
            kotlin.jvm.internal.h.lS("viewModel");
        }
        b bVar = (b) leftPanelViewModel.amn().getValue();
        if (bVar != null) {
            LeftPanelViewModel leftPanelViewModel2 = this.cDp;
            if (leftPanelViewModel2 == null) {
                kotlin.jvm.internal.h.lS("viewModel");
            }
            leftPanelViewModel2.d(bVar);
            z = true;
        }
        return z;
    }

    private final ImageView a(b bVar) {
        oh ohVar;
        if (kotlin.jvm.internal.h.E(bVar, com.iqoption.fragment.leftpanel.b.c.cDP)) {
            ohVar = this.cDo;
            if (ohVar == null) {
                kotlin.jvm.internal.h.lS("binding");
            }
            return ohVar.byP;
        } else if (kotlin.jvm.internal.h.E(bVar, com.iqoption.fragment.leftpanel.b.f.cDS)) {
            ohVar = this.cDo;
            if (ohVar == null) {
                kotlin.jvm.internal.h.lS("binding");
            }
            return ohVar.byU;
        } else if (kotlin.jvm.internal.h.E(bVar, com.iqoption.fragment.leftpanel.b.d.cDQ)) {
            ohVar = this.cDo;
            if (ohVar == null) {
                kotlin.jvm.internal.h.lS("binding");
            }
            return ohVar.byQ;
        } else if (kotlin.jvm.internal.h.E(bVar, com.iqoption.fragment.leftpanel.b.e.cDR)) {
            ohVar = this.cDo;
            if (ohVar == null) {
                kotlin.jvm.internal.h.lS("binding");
            }
            return ohVar.byT;
        } else if (kotlin.jvm.internal.h.E(bVar, com.iqoption.fragment.leftpanel.b.g.cDT)) {
            ohVar = this.cDo;
            if (ohVar == null) {
                kotlin.jvm.internal.h.lS("binding");
            }
            return ohVar.byV;
        } else if (kotlin.jvm.internal.h.E(bVar, com.iqoption.fragment.leftpanel.b.a.cDN)) {
            ohVar = this.cDo;
            if (ohVar == null) {
                kotlin.jvm.internal.h.lS("binding");
            }
            return ohVar.byL;
        } else if (kotlin.jvm.internal.h.E(bVar, com.iqoption.fragment.leftpanel.b.b.cDO)) {
            ohVar = this.cDo;
            if (ohVar == null) {
                kotlin.jvm.internal.h.lS("binding");
            }
            return ohVar.byO;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    private final void b(b bVar) {
        Fragment fragment;
        String str;
        if (kotlin.jvm.internal.h.E(bVar, com.iqoption.fragment.leftpanel.b.c.cDP)) {
            z ge = z.ge(1);
            kotlin.jvm.internal.h.d(ge, "PortfolioFragment.newIns…(PortfolioFragment.MICRO)");
            a((Fragment) ge, "PortfolioFragment");
        } else if (kotlin.jvm.internal.h.E(bVar, com.iqoption.fragment.leftpanel.b.f.cDS)) {
            com.iqoption.feed.b afT = com.iqoption.feed.b.afT();
            kotlin.jvm.internal.h.d(afT, "SmartFeedFragment.newInstance()");
            fragment = afT;
            str = com.iqoption.feed.b.TAG;
            kotlin.jvm.internal.h.d(str, "SmartFeedFragment.TAG");
            a(fragment, str);
        } else if (kotlin.jvm.internal.h.E(bVar, com.iqoption.fragment.leftpanel.b.d.cDQ)) {
            fragment = QuizFragment.dgy.azd();
            str = QuizFragment.dgy.Ll();
            kotlin.jvm.internal.h.d(str, "QuizFragment.TAG");
            a(fragment, str);
        } else if (kotlin.jvm.internal.h.E(bVar, com.iqoption.fragment.leftpanel.b.e.cDR)) {
            fragment = com.iqoption.signals.i.drr.aEd();
            str = com.iqoption.signals.i.drr.Ll();
            kotlin.jvm.internal.h.d(str, "SignalsFragment.TAG");
            a(fragment, str);
        } else if (kotlin.jvm.internal.h.E(bVar, com.iqoption.fragment.leftpanel.b.g.cDT)) {
            com.iqoption.videoeducation.fragment.a aHQ = com.iqoption.videoeducation.fragment.a.aHQ();
            kotlin.jvm.internal.h.d(aHQ, "VideoCatalogsFragment.newInstance()");
            fragment = aHQ;
            str = com.iqoption.videoeducation.fragment.a.TAG;
            kotlin.jvm.internal.h.d(str, "VideoCatalogsFragment.TAG");
            a(fragment, str);
        } else if (kotlin.jvm.internal.h.E(bVar, com.iqoption.fragment.leftpanel.b.a.cDN)) {
            fragment = q.aHC.Qa();
            str = q.aHC.Ll();
            kotlin.jvm.internal.h.d(str, "MicroRoomListFragment.TAG");
            a(fragment, str);
        } else if (kotlin.jvm.internal.h.E(bVar, com.iqoption.fragment.leftpanel.b.b.cDO)) {
            cn ahP = cn.ahP();
            kotlin.jvm.internal.h.d(ahP, "TokenBalanceFragment.newInstance()");
            a((Fragment) ahP, "TokenBalanceFragment");
        }
    }

    private final void dn(boolean z) {
        oh ohVar = this.cDo;
        if (ohVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        FrameLayout frameLayout = ohVar.byM;
        frameLayout.setClickable(z);
        frameLayout.setFocusable(z);
    }

    private final void a(Fragment fragment, String str) {
        FragmentManager q = com.iqoption.core.ext.a.q(this);
        FragmentTransaction beginTransaction = q.beginTransaction();
        kotlin.jvm.internal.h.d(beginTransaction, "ft");
        beginTransaction.setCustomAnimations(R.anim.appear_from_left_to_rigth_with_alpha, R.anim.disappear_from_right_to_left_with_alpha);
        beginTransaction.replace(R.id.fragmentContainer, fragment, str);
        dn(true);
        beginTransaction.commitAllowingStateLoss();
        q.executePendingTransactions();
    }

    private final void amb() {
        Fragment findFragmentById = com.iqoption.core.ext.a.q(this).findFragmentById(R.id.fragmentContainer);
        if (findFragmentById != null) {
            FragmentManager q = com.iqoption.core.ext.a.q(this);
            FragmentTransaction beginTransaction = q.beginTransaction();
            kotlin.jvm.internal.h.d(beginTransaction, "ft");
            beginTransaction.setCustomAnimations(0, R.anim.disappear_from_right_to_left_with_alpha);
            beginTransaction.remove(findFragmentById);
            dn(false);
            beginTransaction.commitAllowingStateLoss();
            q.executePendingTransactions();
        }
    }

    public void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        LeftPanelViewModel leftPanelViewModel;
        if (valueOf != null && valueOf.intValue() == R.id.menu) {
            LeftMenuViewModel.cCO.k(com.iqoption.core.ext.a.n(this)).toggle();
        } else if (valueOf != null && valueOf.intValue() == R.id.portfolio) {
            leftPanelViewModel = this.cDp;
            if (leftPanelViewModel == null) {
                kotlin.jvm.internal.h.lS("viewModel");
            }
            leftPanelViewModel.f(com.iqoption.fragment.leftpanel.b.c.cDP);
        } else if (valueOf != null && valueOf.intValue() == R.id.smartFeed) {
            leftPanelViewModel = this.cDp;
            if (leftPanelViewModel == null) {
                kotlin.jvm.internal.h.lS("viewModel");
            }
            leftPanelViewModel.f(com.iqoption.fragment.leftpanel.b.f.cDS);
        } else if (valueOf != null && valueOf.intValue() == R.id.quiz) {
            leftPanelViewModel = this.cDp;
            if (leftPanelViewModel == null) {
                kotlin.jvm.internal.h.lS("viewModel");
            }
            leftPanelViewModel.f(com.iqoption.fragment.leftpanel.b.d.cDQ);
        } else if (valueOf != null && valueOf.intValue() == R.id.signals) {
            leftPanelViewModel = this.cDp;
            if (leftPanelViewModel == null) {
                kotlin.jvm.internal.h.lS("viewModel");
            }
            leftPanelViewModel.f(com.iqoption.fragment.leftpanel.b.e.cDR);
        } else if (valueOf != null && valueOf.intValue() == R.id.videoEducation) {
            leftPanelViewModel = this.cDp;
            if (leftPanelViewModel == null) {
                kotlin.jvm.internal.h.lS("viewModel");
            }
            leftPanelViewModel.f(com.iqoption.fragment.leftpanel.b.g.cDT);
        } else if (valueOf != null && valueOf.intValue() == R.id.chats) {
            leftPanelViewModel = this.cDp;
            if (leftPanelViewModel == null) {
                kotlin.jvm.internal.h.lS("viewModel");
            }
            leftPanelViewModel.f(com.iqoption.fragment.leftpanel.b.a.cDN);
        } else if (valueOf != null && valueOf.intValue() == R.id.otn) {
            leftPanelViewModel = this.cDp;
            if (leftPanelViewModel == null) {
                kotlin.jvm.internal.h.lS("viewModel");
            }
            leftPanelViewModel.f(com.iqoption.fragment.leftpanel.b.b.cDO);
        }
    }

    public boolean agh() {
        return onBackPressed();
    }
}
