package com.iqoption.quiz;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.iqoption.core.k;
import com.iqoption.d.qz;
import com.iqoption.d.rb;
import com.iqoption.d.rd;
import com.iqoption.d.rf;
import com.iqoption.quiz.model.LeaderBoardFilter;
import com.iqoption.quiz.model.LeaderBoardViewModel;
import com.iqoption.quiz.model.j;
import com.iqoption.quiz.model.l;
import com.iqoption.x.R;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1Impl;

@i(aXC = {1, 1, 11}, aXD = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002:\u0003<=>B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0011\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0001J\u0011\u0010 \u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\u001eH\u0001J\u0011\u0010\"\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020\u001eH\u0001J\u0011\u0010$\u001a\u00020%2\u0006\u0010\u001f\u001a\u00020\u001eH\u0001J\u0011\u0010&\u001a\u00020'2\u0006\u0010\u001f\u001a\u00020\u001eH\u0001J\u0011\u0010(\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0001J\u0011\u0010)\u001a\u00020*2\u0006\u0010\u001f\u001a\u00020\u001eH\u0001J*\u0010)\u001a\u00020*2\u0006\u0010\u001f\u001a\u00020\u001e2\u0012\u0010+\u001a\n\u0012\u0006\b\u0001\u0012\u00020-0,\"\u00020-H\u0001¢\u0006\u0002\u0010.J\t\u0010/\u001a\u000200H\u0001J(\u00101\u001a\u00020\u00162\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u001e2\u0006\u00107\u001a\u000205H\u0002J\u0010\u00108\u001a\u00020\u00162\u0006\u00109\u001a\u00020\u0018H\u0002J\u0011\u0010:\u001a\u00020'2\u0006\u0010;\u001a\u00020'H\u0001R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000¨\u0006?"}, aXE = {"Lcom/iqoption/quiz/LeaderBoardQuizDelegate;", "Lcom/iqoption/quiz/QuizDelegate;", "Lcom/iqoption/core/Resourcer;", "f", "Lcom/iqoption/quiz/QuizFragment;", "root", "Landroid/view/ViewGroup;", "(Lcom/iqoption/quiz/QuizFragment;Landroid/view/ViewGroup;)V", "adapter", "Lcom/iqoption/quiz/QuizLeaderBoardAdapter;", "binding", "Lcom/iqoption/databinding/FragmentQuizLeaderboardDelegateBinding;", "getBinding", "()Lcom/iqoption/databinding/FragmentQuizLeaderboardDelegateBinding;", "filterAdapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/iqoption/quiz/LeaderBoardQuizDelegate$QuizLeaderBoardFilterViewHolder;", "filterWindow", "Lcom/iqoption/widget/window/OptionsWindow;", "onItemClick", "Lkotlin/Function1;", "Lcom/iqoption/quiz/model/QuizLeaderBoardItem;", "", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "viewModel", "Lcom/iqoption/quiz/model/LeaderBoardViewModel;", "getColor", "", "resId", "getColors", "Landroid/content/res/ColorStateList;", "getDrawable", "Landroid/graphics/drawable/Drawable;", "getFont", "Landroid/graphics/Typeface;", "getPixels", "", "getPixelsInt", "getString", "", "args", "", "", "(I[Ljava/lang/Object;)Ljava/lang/CharSequence;", "getViewConfiguration", "Landroid/view/ViewConfiguration;", "openUserProfileDialog", "userId", "", "userName", "", "position", "value", "showFilterChooser", "anchorView", "toPixels", "dp", "FilterAdapter", "QuizLeaderBoardFilterViewHolder", "YouItemController", "IqOption-5.5.1_optionXRelease"})
/* compiled from: LeaderBoardQuizDelegate.kt */
public final class LeaderBoardQuizDelegate extends QuizDelegate implements k {
    private com.iqoption.widget.a.a ddn;
    private final qz deN;
    private final LeaderBoardViewModel deO;
    private final kotlin.jvm.a.b<l, kotlin.l> deP = new LeaderBoardQuizDelegate$onItemClick$1(this);
    private final w deQ = new w(this.deP);
    private Adapter<g> deR;
    private final /* synthetic */ com.iqoption.core.l det;
    private final View view;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, aXE = {"<anonymous>", "", "run", "com/iqoption/quiz/LeaderBoardQuizDelegate$2$3"})
    /* compiled from: LeaderBoardQuizDelegate.kt */
    static final class c implements Runnable {
        final /* synthetic */ QuizFragment deH;
        final /* synthetic */ h deS;
        final /* synthetic */ LeaderBoardQuizDelegate this$0;

        @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "", "Lcom/iqoption/quiz/model/QuizLeaderBoardAdapterItem;", "onChanged", "com/iqoption/quiz/LeaderBoardQuizDelegate$2$3$1"})
        /* compiled from: LeaderBoardQuizDelegate.kt */
        /* renamed from: com.iqoption.quiz.LeaderBoardQuizDelegate$c$1 */
        static final class AnonymousClass1<T> implements Observer<List<? extends j>> {
            final /* synthetic */ c deT;

            AnonymousClass1(c cVar) {
                this.deT = cVar;
            }

            /* renamed from: L */
            public final void onChanged(List<? extends j> list) {
                if (list != null) {
                    this.deT.this$0.deQ.setItems(list);
                }
            }
        }

        c(LeaderBoardQuizDelegate leaderBoardQuizDelegate, QuizFragment quizFragment, h hVar) {
            this.this$0 = leaderBoardQuizDelegate;
            this.deH = quizFragment;
            this.deS = hVar;
        }

        public final void run() {
            this.this$0.deO.aBm().observe(this.deH, new AnonymousClass1(this));
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 '2\u00020\u0001:\u0001'B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010$\u001a\u00020%2\u0006\u0010\u001c\u001a\u00020\u0015H\u0002J\u0010\u0010&\u001a\u00020%2\u0006\u0010\u001c\u001a\u00020\u0015H\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\f8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00118BX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R$\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0015@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0015@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019R$\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0015@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010 \u001a\n \r*\u0004\u0018\u00010\f0\f8BX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u000fR\u0014\u0010\"\u001a\u00020\u00118BX\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006("}, aXE = {"Lcom/iqoption/quiz/LeaderBoardQuizDelegate$YouItemController;", "", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "endTranslationY", "", "getEndTranslationY", "()F", "endTranslationY$delegate", "Lkotlin/Lazy;", "hideAnimator", "Landroid/animation/ObjectAnimator;", "kotlin.jvm.PlatformType", "getHideAnimator", "()Landroid/animation/ObjectAnimator;", "hideDuration", "", "getHideDuration", "()J", "value", "", "isHiddenByHorizontalScroll", "()Z", "setHiddenByHorizontalScroll", "(Z)V", "isHiddenByVerticalScroll", "setHiddenByVerticalScroll", "isShown", "setShown", "runningAnimator", "Landroid/animation/Animator;", "showAnimator", "getShowAnimator", "showDuration", "getShowDuration", "animate", "", "change", "Companion", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: LeaderBoardQuizDelegate.kt */
    public static final class h {
        static final /* synthetic */ kotlin.reflect.j[] apP = new kotlin.reflect.j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(h.class), "endTranslationY", "getEndTranslationY()F"))};
        public static final a dfi = new a();
        private boolean cDy;
        private Animator cDz;
        private final kotlin.d dff = g.f(new LeaderBoardQuizDelegate$YouItemController$endTranslationY$2(this));
        private boolean dfg;
        private boolean dfh;
        private final View view;

        @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, aXE = {"Lcom/iqoption/quiz/LeaderBoardQuizDelegate$YouItemController$Companion;", "", "()V", "DURATION", "", "IqOption-5.5.1_optionXRelease"})
        /* compiled from: LeaderBoardQuizDelegate.kt */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(f fVar) {
                this();
            }
        }

        @i(aXC = {1, 1, 11}, aXD = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\t¸\u0006\u0000"}, aXE = {"com/iqoption/quiz/LeaderBoardQuizDelegate$YouItemController$animate$2$1", "Landroid/animation/AnimatorListenerAdapter;", "isCancelled", "", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "IqOption-5.5.1_optionXRelease"})
        /* compiled from: LeaderBoardQuizDelegate.kt */
        public static final class b extends AnimatorListenerAdapter {
            private boolean JF;
            final /* synthetic */ h this$0;

            b(h hVar) {
                this.this$0 = hVar;
            }

            public void onAnimationCancel(Animator animator) {
                this.JF = true;
            }

            public void onAnimationEnd(Animator animator) {
                if (!this.JF) {
                    com.iqoption.core.ext.a.M(this.this$0.view);
                }
            }
        }

        private final float ayN() {
            kotlin.d dVar = this.dff;
            kotlin.reflect.j jVar = apP[0];
            return ((Number) dVar.getValue()).floatValue();
        }

        public h(View view) {
            kotlin.jvm.internal.h.e(view, Promotion.ACTION_VIEW);
            this.view = view;
            this.view.setClickable(true);
            this.view.setFocusable(true);
        }

        private final ObjectAnimator ayO() {
            View view = this.view;
            PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[2];
            propertyValuesHolderArr[0] = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{1.0f});
            propertyValuesHolderArr[1] = PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{0.0f});
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, propertyValuesHolderArr);
            ofPropertyValuesHolder.setInterpolator(com.iqoption.core.graphics.animation.i.TI());
            return ofPropertyValuesHolder;
        }

        private final long AD() {
            return c.af((1.0f - this.view.getAlpha()) * ((float) 200));
        }

        private final ObjectAnimator ayP() {
            View view = this.view;
            PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[2];
            propertyValuesHolderArr[0] = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f});
            propertyValuesHolderArr[1] = PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{ayN()});
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, propertyValuesHolderArr);
            ofPropertyValuesHolder.setInterpolator(com.iqoption.core.graphics.animation.i.TI());
            return ofPropertyValuesHolder;
        }

        private final long AE() {
            return c.af(this.view.getAlpha() * ((float) 200));
        }

        public final void ek(boolean z) {
            if (this.dfg != z) {
                this.dfg = z;
                z = !z && this.cDy;
                en(z);
            }
        }

        public final void el(boolean z) {
            if (this.dfh != z) {
                this.dfh = z;
                if (z || !this.cDy) {
                    en(false);
                } else {
                    em(z);
                }
            }
        }

        public final void ar(boolean z) {
            if (this.cDy != z) {
                this.cDy = z;
                if (!this.dfg && !this.dfh) {
                    em(z);
                }
            }
        }

        private final void em(boolean z) {
            ObjectAnimator ayO;
            Animator animator = this.cDz;
            if (animator != null) {
                animator.cancel();
            }
            if (z) {
                com.iqoption.core.ext.a.L(this.view);
                ayO = ayO();
                ayO.setDuration(AD());
            } else {
                ayO = ayP();
                ayO.setDuration(AE());
                ayO.addListener(new b(this));
            }
            ayO.start();
            this.cDz = ayO;
        }

        private final void en(boolean z) {
            if (z) {
                com.iqoption.core.ext.a.L(this.view);
                this.view.setAlpha(1.0f);
                this.view.setTranslationY(0.0f);
                return;
            }
            com.iqoption.core.ext.a.M(this.view);
            this.view.setAlpha(0.0f);
            this.view.setTranslationY(ayN());
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0007"}, aXE = {"com/iqoption/core/ext/AndroidExtensionsKt$setOnDelayedClickListener$1", "Lcom/iqoption/core/ext/OnDelayClickListener;", "onDelayClick", "", "v", "Landroid/view/View;", "core_release", "com/iqoption/quiz/LeaderBoardQuizDelegate$$special$$inlined$setOnDelayedClickListener$1"})
    /* compiled from: AndroidExtensions.kt */
    public static final class a extends com.iqoption.core.ext.g {
        final /* synthetic */ QuizFragment deH;
        final /* synthetic */ h deS;
        final /* synthetic */ LeaderBoardQuizDelegate this$0;

        public a(LeaderBoardQuizDelegate leaderBoardQuizDelegate, QuizFragment quizFragment, h hVar) {
            this.this$0 = leaderBoardQuizDelegate;
            this.deH = quizFragment;
            this.deS = hVar;
            super(0, 1, null);
        }

        public void q(View view) {
            kotlin.jvm.internal.h.e(view, "v");
            LeaderBoardQuizDelegate leaderBoardQuizDelegate = this.this$0;
            TextView textView = this.this$0.ayK().agA;
            kotlin.jvm.internal.h.d(textView, "binding.title");
            leaderBoardQuizDelegate.bH(textView);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/quiz/model/LeaderBoardFilter;", "onChanged", "com/iqoption/quiz/LeaderBoardQuizDelegate$2$2"})
    /* compiled from: LeaderBoardQuizDelegate.kt */
    static final class b<T> implements Observer<LeaderBoardFilter> {
        final /* synthetic */ QuizFragment deH;
        final /* synthetic */ h deS;
        final /* synthetic */ LeaderBoardQuizDelegate this$0;

        b(LeaderBoardQuizDelegate leaderBoardQuizDelegate, QuizFragment quizFragment, h hVar) {
            this.this$0 = leaderBoardQuizDelegate;
            this.deH = quizFragment;
            this.deS = hVar;
        }

        /* renamed from: a */
        public final void onChanged(LeaderBoardFilter leaderBoardFilter) {
            if (leaderBoardFilter != null) {
                this.this$0.ayK().bAZ.setText(leaderBoardFilter.getLabel());
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u00009\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0014\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f¸\u0006\u0000"}, aXE = {"com/iqoption/quiz/LeaderBoardQuizDelegate$2$4", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "layoutManager", "Landroid/support/v7/widget/LinearLayoutManager;", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "isHighEnough", "", "Landroid/view/View;", "list", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: LeaderBoardQuizDelegate.kt */
    public static final class d extends OnScrollListener {
        private final LinearLayoutManager aIi;
        final /* synthetic */ QuizFragment deH;
        final /* synthetic */ h deS;
        final /* synthetic */ qz deU;
        final /* synthetic */ OnScrollListener deV;
        final /* synthetic */ LeaderBoardQuizDelegate this$0;

        d(qz qzVar, OnScrollListener onScrollListener, LeaderBoardQuizDelegate leaderBoardQuizDelegate, QuizFragment quizFragment, h hVar) {
            this.deU = qzVar;
            this.deV = onScrollListener;
            this.this$0 = leaderBoardQuizDelegate;
            this.deH = quizFragment;
            this.deS = hVar;
            RecyclerView recyclerView = this.deU.axw;
            kotlin.jvm.internal.h.d(recyclerView, "list");
            LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
            }
            this.aIi = (LinearLayoutManager) layoutManager;
        }

        private final boolean b(View view, RecyclerView recyclerView) {
            return recyclerView.getHeight() - view.getHeight() >= view.getTop();
        }

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            this.deV.onScrolled(recyclerView, i, i2);
            l lVar = (l) this.this$0.deO.aBn().getValue();
            if (lVar != null) {
                ViewHolder findViewHolderForItemId = this.deU.axw.findViewHolderForItemId(this.this$0.deQ.a((j) lVar));
                if (findViewHolderForItemId != null) {
                    h hVar = this.deS;
                    View view = findViewHolderForItemId.itemView;
                    kotlin.jvm.internal.h.d(view, "youH.itemView");
                    RecyclerView recyclerView2 = this.deU.axw;
                    kotlin.jvm.internal.h.d(recyclerView2, "list");
                    hVar.ek(b(view, recyclerView2));
                } else {
                    findViewHolderForItemId = this.deU.axw.findViewHolderForAdapterPosition(this.aIi.findFirstVisibleItemPosition());
                    if (findViewHolderForItemId != null) {
                        h hVar2 = this.deS;
                        boolean z = true;
                        if (findViewHolderForItemId.getAdapterPosition() + 1 <= lVar.getPosition()) {
                            z = false;
                        }
                        hVar2.ek(z);
                    }
                }
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/quiz/model/QuizLeaderBoardItem;", "onChanged", "com/iqoption/quiz/LeaderBoardQuizDelegate$2$5"})
    /* compiled from: LeaderBoardQuizDelegate.kt */
    static final class e<T> implements Observer<l> {
        final /* synthetic */ QuizFragment deH;
        final /* synthetic */ h deS;
        final /* synthetic */ LeaderBoardQuizDelegate this$0;

        e(LeaderBoardQuizDelegate leaderBoardQuizDelegate, QuizFragment quizFragment, h hVar) {
            this.this$0 = leaderBoardQuizDelegate;
            this.deH = quizFragment;
            this.deS = hVar;
        }

        /* renamed from: a */
        public final void onChanged(final l lVar) {
            if (lVar != null) {
                this.deS.ar(true);
                com.iqoption.quiz.x.b bVar = x.dgN;
                rf rfVar = this.this$0.ayK().bBb;
                kotlin.jvm.internal.h.d(rfVar, "binding.youItem");
                bVar.a(rfVar, lVar);
                rf rfVar2 = this.this$0.ayK().bBb;
                kotlin.jvm.internal.h.d(rfVar2, "binding.youItem");
                View root = rfVar2.getRoot();
                kotlin.jvm.internal.h.d(root, "binding.youItem.root");
                root.setOnClickListener(new com.iqoption.core.ext.g(this) {
                    final /* synthetic */ e deW;

                    public void q(View view) {
                        kotlin.jvm.internal.h.e(view, "v");
                        this.deW.this$0.deP.invoke(lVar);
                    }
                });
                return;
            }
            this.deS.ar(false);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\rH\u0016J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\rH\u0016R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, aXE = {"Lcom/iqoption/quiz/LeaderBoardQuizDelegate$FilterAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/iqoption/quiz/LeaderBoardQuizDelegate$QuizLeaderBoardFilterViewHolder;", "window", "Lcom/iqoption/widget/window/OptionsWindow;", "viewModel", "Lcom/iqoption/quiz/model/LeaderBoardViewModel;", "(Lcom/iqoption/widget/window/OptionsWindow;Lcom/iqoption/quiz/model/LeaderBoardViewModel;)V", "filters", "", "Lcom/iqoption/quiz/model/LeaderBoardFilter;", "[Lcom/iqoption/quiz/model/LeaderBoardFilter;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: LeaderBoardQuizDelegate.kt */
    private static final class f extends Adapter<g> {
        private final LeaderBoardViewModel deO;
        private final LeaderBoardFilter[] dfc = LeaderBoardFilter.values();
        private final com.iqoption.widget.a.a dfd;

        public f(com.iqoption.widget.a.a aVar, LeaderBoardViewModel leaderBoardViewModel) {
            kotlin.jvm.internal.h.e(aVar, "window");
            kotlin.jvm.internal.h.e(leaderBoardViewModel, "viewModel");
            this.dfd = aVar;
            this.deO = leaderBoardViewModel;
        }

        public int getItemCount() {
            return this.dfc.length;
        }

        /* renamed from: T */
        public g onCreateViewHolder(ViewGroup viewGroup, int i) {
            kotlin.jvm.internal.h.e(viewGroup, "parent");
            return new g((rd) com.iqoption.core.ext.a.a(viewGroup, (int) R.layout.fragment_quiz_leaderboard_filter_item, null, false, 6, null), this.deO.aBl(), new LeaderBoardQuizDelegate$FilterAdapter$onCreateViewHolder$1(this));
        }

        /* renamed from: a */
        public void onBindViewHolder(g gVar, int i) {
            kotlin.jvm.internal.h.e(gVar, "holder");
            gVar.c(this.dfc[i]);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nR+\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00068F@FX\u0002¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, aXE = {"Lcom/iqoption/quiz/LeaderBoardQuizDelegate$QuizLeaderBoardFilterViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iqoption/databinding/FragmentQuizLeaderboardFilterItemBinding;", "current", "Landroid/arch/lifecycle/LiveData;", "Lcom/iqoption/quiz/model/LeaderBoardFilter;", "onSelect", "Lkotlin/Function1;", "", "(Lcom/iqoption/databinding/FragmentQuizLeaderboardFilterItemBinding;Landroid/arch/lifecycle/LiveData;Lkotlin/jvm/functions/Function1;)V", "<set-?>", "bound", "getBound", "()Lcom/iqoption/quiz/model/LeaderBoardFilter;", "setBound", "(Lcom/iqoption/quiz/model/LeaderBoardFilter;)V", "bound$delegate", "Lkotlin/properties/ReadWriteProperty;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: LeaderBoardQuizDelegate.kt */
    public static final class g extends ViewHolder {
        static final /* synthetic */ kotlin.reflect.j[] apP = new kotlin.reflect.j[]{kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(g.class), "bound", "getBound()Lcom/iqoption/quiz/model/LeaderBoardFilter;"))};
        private final kotlin.jvm.a.b<LeaderBoardFilter, kotlin.l> aDe;
        private final kotlin.e.d bXV;
        private final LiveData<LeaderBoardFilter> dfe;

        @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        /* compiled from: LeaderBoardQuizDelegate.kt */
        /* renamed from: com.iqoption.quiz.LeaderBoardQuizDelegate$g$1 */
        static final class AnonymousClass1 implements OnClickListener {
            final /* synthetic */ g this$0;

            AnonymousClass1(g gVar) {
                this.this$0 = gVar;
            }

            public final void onClick(View view) {
                this.this$0.aDe.invoke(this.this$0.ayM());
            }
        }

        public final LeaderBoardFilter ayM() {
            return (LeaderBoardFilter) this.bXV.b(this, apP[0]);
        }

        public final void c(LeaderBoardFilter leaderBoardFilter) {
            kotlin.jvm.internal.h.e(leaderBoardFilter, "<set-?>");
            this.bXV.a(this, apP[0], leaderBoardFilter);
        }

        public g(rd rdVar, LiveData<LeaderBoardFilter> liveData, kotlin.jvm.a.b<? super LeaderBoardFilter, kotlin.l> bVar) {
            kotlin.jvm.internal.h.e(rdVar, "binding");
            kotlin.jvm.internal.h.e(liveData, "current");
            kotlin.jvm.internal.h.e(bVar, "onSelect");
            super(rdVar.getRoot());
            this.dfe = liveData;
            this.aDe = bVar;
            this.bXV = com.iqoption.core.e.c.h(new LeaderBoardQuizDelegate$QuizLeaderBoardFilterViewHolder$$special$$inlined$bindable$1(rdVar, this));
            rdVar.aip.setOnClickListener(new AnonymousClass1(this));
        }
    }

    public CharSequence dA(int i) {
        return this.det.dA(i);
    }

    public ColorStateList dx(int i) {
        return this.det.dx(i);
    }

    public float dy(int i) {
        return this.det.dy(i);
    }

    public int dz(int i) {
        return this.det.dz(i);
    }

    public int getColor(int i) {
        return this.det.getColor(i);
    }

    public Drawable getDrawable(int i) {
        return this.det.getDrawable(i);
    }

    public Typeface getFont(int i) {
        return this.det.getFont(i);
    }

    public LeaderBoardQuizDelegate(QuizFragment quizFragment, final ViewGroup viewGroup) {
        kotlin.jvm.internal.h.e(quizFragment, "f");
        kotlin.jvm.internal.h.e(viewGroup, "root");
        super(quizFragment);
        Context context = viewGroup.getContext();
        kotlin.jvm.internal.h.d(context, "root.context");
        this.det = new com.iqoption.core.l(context);
        Fragment fragment = quizFragment;
        this.deN = (qz) com.iqoption.core.ext.a.a(fragment, (int) R.layout.fragment_quiz_leaderboard_delegate, viewGroup, false, 4, null);
        View root = this.deN.getRoot();
        kotlin.jvm.internal.h.d(root, "binding.root");
        this.view = root;
        this.deO = LeaderBoardViewModel.dlq.W(fragment);
        rf rfVar = this.deN.bBb;
        kotlin.jvm.internal.h.d(rfVar, "binding.youItem");
        root = rfVar.getRoot();
        kotlin.jvm.internal.h.d(root, "binding.youItem.root");
        final h hVar = new h(root);
        if (viewGroup instanceof ViewPager) {
            ((ViewPager) viewGroup).addOnPageChangeListener(new OnPageChangeListener(this) {
                static final /* synthetic */ kotlin.reflect.j[] apP = new kotlin.reflect.j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(AnonymousClass1.class), "pagerPosition", "getPagerPosition()Ljava/lang/Integer;"))};
                private final kotlin.d deY = g.f(new LeaderBoardQuizDelegate$1$pagerPosition$2(this));
                private int deZ;
                final /* synthetic */ LeaderBoardQuizDelegate this$0;

                private final Integer ayL() {
                    kotlin.d dVar = this.deY;
                    kotlin.reflect.j jVar = apP[0];
                    return (Integer) dVar.getValue();
                }

                public void onPageScrolled(int i, float f, int i2) {
                }

                public void onPageScrollStateChanged(int i) {
                    TextView textView;
                    if (i == 0) {
                        textView = this.this$0.ayK().agA;
                        kotlin.jvm.internal.h.d(textView, "binding.title");
                        com.iqoption.core.ext.a.L(textView);
                        h hVar = hVar;
                        int i2 = this.deZ;
                        Integer ayL = ayL();
                        boolean z = ayL == null || i2 != ayL.intValue();
                        hVar.el(z);
                        return;
                    }
                    textView = this.this$0.ayK().agA;
                    kotlin.jvm.internal.h.d(textView, "binding.title");
                    com.iqoption.core.ext.a.hide(textView);
                }

                public void onPageSelected(int i) {
                    this.deZ = i;
                }
            });
        }
        qz qzVar = this.deN;
        TextView textView = qzVar.bAZ;
        kotlin.jvm.internal.h.d(textView, "filter");
        textView.setOnClickListener(new a(this, quizFragment, hVar));
        qzVar.axw.setHasFixedSize(true);
        RecyclerView recyclerView = qzVar.axw;
        kotlin.jvm.internal.h.d(recyclerView, "list");
        recyclerView.setAdapter(this.deQ);
        LifecycleOwner lifecycleOwner = quizFragment;
        this.deO.aBl().observe(lifecycleOwner, new b(this, quizFragment, hVar));
        com.iqoption.core.h.i.Yp().b(new c(this, quizFragment, hVar), 1000, TimeUnit.MILLISECONDS);
        qzVar.axw.addOnScrollListener(new d(qzVar, com.iqoption.quiz.a.a.did.azL(), this, quizFragment, hVar));
        this.deO.aBn().observe(lifecycleOwner, new e(this, quizFragment, hVar));
    }

    public final qz ayK() {
        return this.deN;
    }

    public View getView() {
        return this.view;
    }

    private final void bH(View view) {
        com.iqoption.widget.a.a aVar;
        if (this.ddn == null) {
            aVar = new com.iqoption.widget.a.a();
            rb rbVar = (rb) com.iqoption.core.ext.a.a((Fragment) azc(), (int) R.layout.fragment_quiz_leaderboard_filter, null, false, 4, null);
            TextView textView = rbVar.agA;
            kotlin.jvm.internal.h.d(textView, "b.title");
            textView.setText(azc().getString(R.string.iq_quiz));
            this.deR = new f(aVar, this.deO);
            RecyclerView recyclerView = rbVar.axw;
            kotlin.jvm.internal.h.d(recyclerView, "b.list");
            recyclerView.setAdapter(this.deR);
            View root = rbVar.getRoot();
            kotlin.jvm.internal.h.d(root, "root");
            com.iqoption.core.ext.a.N(root);
            aVar.g(root, root.getMeasuredWidth(), root.getMeasuredHeight());
            this.ddn = aVar;
        }
        aVar = this.ddn;
        if (aVar == null || !aVar.isShowing()) {
            Adapter adapter = this.deR;
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
            aVar = this.ddn;
            if (aVar != null) {
                aVar.L(view);
            }
        }
    }

    private final void a(long j, String str, int i, String str2) {
        com.iqoption.quiz.a.a.did.h(j, str2);
        FragmentActivity activity = azc().zzakw();
        if (activity != null) {
            FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
            if (supportFragmentManager != null) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                kotlin.jvm.internal.h.d(beginTransaction, "ft");
                beginTransaction.add(R.id.other_fragment, ac.dgV.a(j, str, i), ac.dgV.Ll());
                beginTransaction.addToBackStack(ac.dgV.Ll());
                beginTransaction.commitAllowingStateLoss();
                supportFragmentManager.executePendingTransactions();
            }
        }
    }
}
