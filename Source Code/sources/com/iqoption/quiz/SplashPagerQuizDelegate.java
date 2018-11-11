package com.iqoption.quiz;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.iqoption.core.a.d;
import com.iqoption.core.ext.c;
import com.iqoption.core.k;
import com.iqoption.core.l;
import com.iqoption.d.rl;
import com.iqoption.d.rt;
import com.iqoption.quiz.model.QuizInsightsViewModel;
import com.iqoption.quiz.model.TriviaSocketViewModel;
import com.iqoption.x.R;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.collections.w;
import kotlin.i;
import kotlin.j;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0011\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0001J\u0011\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u0019H\u0001J\u0011\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001a\u001a\u00020\u0019H\u0001J\u0011\u0010\u001f\u001a\u00020 2\u0006\u0010\u001a\u001a\u00020\u0019H\u0001J\u0016\u0010!\u001a\u00020\u00192\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00010#H\u0002J\u0011\u0010$\u001a\u00020%2\u0006\u0010\u001a\u001a\u00020\u0019H\u0001J\u0011\u0010&\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0001J\u0016\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00010#2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0011\u0010(\u001a\u00020)2\u0006\u0010\u001a\u001a\u00020\u0019H\u0001J*\u0010(\u001a\u00020)2\u0006\u0010\u001a\u001a\u00020\u00192\u0012\u0010*\u001a\n\u0012\u0006\b\u0001\u0012\u00020,0+\"\u00020,H\u0001¢\u0006\u0002\u0010-J\t\u0010.\u001a\u00020/H\u0001J\u0016\u00100\u001a\u00020\u00172\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00010#H\u0002J\u0011\u00101\u001a\u00020%2\u0006\u00102\u001a\u00020%H\u0001R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u00063"}, aXE = {"Lcom/iqoption/quiz/SplashPagerQuizDelegate;", "Lcom/iqoption/quiz/QuizDelegate;", "Lcom/iqoption/core/Resourcer;", "f", "Lcom/iqoption/quiz/QuizFragment;", "root", "Landroid/view/ViewGroup;", "(Lcom/iqoption/quiz/QuizFragment;Landroid/view/ViewGroup;)V", "binding", "Lcom/iqoption/databinding/FragmentQuizSplashPagerDelegateBinding;", "getBinding", "()Lcom/iqoption/databinding/FragmentQuizSplashPagerDelegateBinding;", "insightsViewModel", "Lcom/iqoption/quiz/model/QuizInsightsViewModel;", "quizViewModel", "Lcom/iqoption/quiz/model/TriviaSocketViewModel;", "screenOpenEvent", "Lcom/iqoption/core/analytics/AnalyticsSendEvent;", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "destroy", "", "getColor", "", "resId", "getColors", "Landroid/content/res/ColorStateList;", "getDrawable", "Landroid/graphics/drawable/Drawable;", "getFont", "Landroid/graphics/Typeface;", "getInitPageIndex", "quizSplashDelegates", "", "getPixels", "", "getPixelsInt", "getSplashDelegates", "getString", "", "args", "", "", "(I[Ljava/lang/Object;)Ljava/lang/CharSequence;", "getViewConfiguration", "Landroid/view/ViewConfiguration;", "initPageAdapter", "toPixels", "dp", "IqOption-5.5.1_optionXRelease"})
/* compiled from: SplashPagerQuizDelegate.kt */
public final class SplashPagerQuizDelegate extends QuizDelegate implements k {
    private final TriviaSocketViewModel cDq;
    private final QuizInsightsViewModel cDr;
    private final /* synthetic */ l det;
    private final rt dhp;
    private d dhq;
    private final View view;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, aXE = {"com/iqoption/quiz/SplashPagerQuizDelegate$initPageAdapter$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: SplashPagerQuizDelegate.kt */
    public static final class a extends AnimatorListenerAdapter {
        final /* synthetic */ SplashPagerQuizDelegate dhr;

        a(SplashPagerQuizDelegate splashPagerQuizDelegate) {
            this.dhr = splashPagerQuizDelegate;
        }

        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            this.dhr.azv().bnn.hide();
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

    public SplashPagerQuizDelegate(QuizFragment quizFragment, ViewGroup viewGroup) {
        QuizFragment quizFragment2 = quizFragment;
        h.e(quizFragment2, "f");
        ViewGroup viewGroup2 = viewGroup;
        h.e(viewGroup2, "root");
        super(quizFragment);
        Context context = viewGroup.getContext();
        h.d(context, "root.context");
        this.det = new l(context);
        Fragment fragment = quizFragment2;
        this.dhp = (rt) com.iqoption.core.ext.a.a(fragment, (int) R.layout.fragment_quiz_splash_pager_delegate, viewGroup2, false, 4, null);
        View root = this.dhp.getRoot();
        h.d(root, "binding.root");
        this.view = root;
        this.cDr = QuizInsightsViewModel.dlH.w(com.iqoption.core.ext.a.n(fragment));
        this.cDq = TriviaSocketViewModel.dmB.x(com.iqoption.core.ext.a.n(fragment));
        final List<QuizDelegate> a = a(quizFragment);
        Iterable<w> Z = u.Z(a);
        final Map linkedHashMap = new LinkedHashMap(j.be(ad.jn(n.e(Z, 10)), 16));
        for (w wVar : Z) {
            Pair D = j.D(Integer.valueOf(wVar.getIndex()), wVar.getValue());
            linkedHashMap.put(D.getFirst(), D.aXF());
        }
        final com.iqoption.portfolio.component.h hVar = new com.iqoption.portfolio.component.h(a.size(), dz(R.dimen.dp7), dz(R.dimen.dp7), 0.2f);
        hVar.i(-1.0f, 0.0f);
        this.dhp.bBJ.setImageDrawable(hVar);
        final long currentTimeMillis = System.currentTimeMillis();
        int i = 0;
        for (QuizDelegate quizDelegate : a) {
            if (quizDelegate instanceof InsightsQuizDelegate) {
                break;
            }
            i++;
        }
        i = -1;
        final int max = Math.max(0, i);
        ImageView imageView = this.dhp.bBq.bBr;
        h.d(imageView, "binding.title.infoIcon");
        com.iqoption.core.ext.a.hide(imageView);
        final List list = a;
        this.cDr.aBs().observe(quizFragment2, new Observer<Boolean>(this, 400) {
            final /* synthetic */ SplashPagerQuizDelegate dhr;

            @i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
            /* compiled from: SplashPagerQuizDelegate.kt */
            /* renamed from: com.iqoption.quiz.SplashPagerQuizDelegate$1$1 */
            static final class AnonymousClass1 implements Runnable {
                final /* synthetic */ AnonymousClass1 dhw;

                AnonymousClass1(AnonymousClass1 anonymousClass1) {
                    this.dhw = anonymousClass1;
                }

                public final void run() {
                    this.dhw.dhr.aV(list);
                }
            }

            /* renamed from: k */
            public final void onChanged(Boolean bool) {
                ViewPager viewPager = this.dhr.azv().bmI;
                h.d(viewPager, "binding.pager");
                if (viewPager.getAdapter() == null) {
                    long abs = Math.abs(c.aT(currentTimeMillis));
                    if (abs < 400) {
                        h.d(com.iqoption.core.h.i.Yp().b(new AnonymousClass1(this), 400 - abs, TimeUnit.MILLISECONDS), "ui.scheduleDirect({\n    …f, TimeUnit.MILLISECONDS)");
                    } else {
                        this.dhr.aV(list);
                    }
                } else if (h.E(bool, Boolean.valueOf(true))) {
                    ViewPager viewPager2 = this.dhr.azv().bmI;
                    h.d(viewPager2, "binding.pager");
                    if (viewPager2.getCurrentItem() != max) {
                        this.dhr.azv().bmI.setCurrentItem(max, false);
                    }
                }
            }
        });
        com.iqoption.core.h.i.Yp().b(new Runnable(this) {
            final /* synthetic */ SplashPagerQuizDelegate dhr;

            public final void run() {
                this.dhr.aV(a);
            }
        }, ((long) 5) * 400, TimeUnit.MILLISECONDS);
        this.dhp.bmI.addOnPageChangeListener(new OnPageChangeListener(this) {
            final /* synthetic */ SplashPagerQuizDelegate dhr;

            public void onPageScrollStateChanged(int i) {
                rl rlVar = this.dhr.azv().bBq;
                h.d(rlVar, "binding.title");
                View root = rlVar.getRoot();
                h.d(root, "binding.title.root");
                root.setVisibility(i == 0 ? 8 : 0);
            }

            /* JADX WARNING: Missing block: B:13:0x0060, code:
            if (r2 < 0.15f) goto L_0x0073;
     */
            /* JADX WARNING: Missing block: B:18:0x006c, code:
            if (r2 < 0.15f) goto L_0x0073;
     */
            /* JADX WARNING: Missing block: B:23:0x0077, code:
            if ((r5 instanceof com.iqoption.quiz.PromoCodeQuizDelegate) != false) goto L_0x0073;
     */
            public void onPageScrolled(int r5, float r6, int r7) {
                /*
                r4 = this;
                r7 = r11;
                r0 = (float) r5;
                r7.i(r0, r6);
                r7 = r4.dhr;
                r7 = r7.azv();
                r7 = r7.bBJ;
                r0 = "binding.pageIndicator";
                kotlin.jvm.internal.h.d(r7, r0);
                r0 = r10;
                r1 = java.lang.Integer.valueOf(r5);
                r0 = r0.get(r1);
                r0 = (com.iqoption.quiz.QuizDelegate) r0;
                r1 = r0 instanceof com.iqoption.quiz.LeaderBoardQuizDelegate;
                r2 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
                if (r1 == 0) goto L_0x0027;
            L_0x0025:
                r0 = r6;
                goto L_0x0037;
            L_0x0027:
                r1 = r0 instanceof com.iqoption.quiz.OffAirQuizDelegate;
                if (r1 == 0) goto L_0x002e;
            L_0x002b:
                r0 = r2 - r6;
                goto L_0x0037;
            L_0x002e:
                r0 = r0 instanceof com.iqoption.quiz.UpdateQuizDelegate;
                if (r0 == 0) goto L_0x0035;
            L_0x0032:
                r0 = r2 - r6;
                goto L_0x0037;
            L_0x0035:
                r0 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
            L_0x0037:
                r7.setAlpha(r0);
                r7 = r4.dhr;
                r7 = r7.azv();
                r7 = r7.bBq;
                r7 = r7.bBr;
                r0 = "binding.title.infoIcon";
                kotlin.jvm.internal.h.d(r7, r0);
                r0 = r10;
                r5 = java.lang.Integer.valueOf(r5);
                r5 = r0.get(r5);
                r5 = (com.iqoption.quiz.QuizDelegate) r5;
                r0 = r5 instanceof com.iqoption.quiz.OffAirQuizDelegate;
                r1 = 1041865114; // 0x3e19999a float:0.15 double:5.147497604E-315;
                r3 = 0;
                if (r0 == 0) goto L_0x0065;
            L_0x005d:
                r2 = r2 - r6;
                r5 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1));
                if (r5 >= 0) goto L_0x0063;
            L_0x0062:
                goto L_0x0073;
            L_0x0063:
                r6 = r2;
                goto L_0x007a;
            L_0x0065:
                r0 = r5 instanceof com.iqoption.quiz.UpdateQuizDelegate;
                if (r0 == 0) goto L_0x006f;
            L_0x0069:
                r2 = r2 - r6;
                r5 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1));
                if (r5 >= 0) goto L_0x0063;
            L_0x006e:
                goto L_0x0073;
            L_0x006f:
                r0 = r5 instanceof com.iqoption.quiz.LeaderBoardQuizDelegate;
                if (r0 == 0) goto L_0x0075;
            L_0x0073:
                r6 = 0;
                goto L_0x007a;
            L_0x0075:
                r5 = r5 instanceof com.iqoption.quiz.PromoCodeQuizDelegate;
                if (r5 == 0) goto L_0x007a;
            L_0x0079:
                goto L_0x0073;
            L_0x007a:
                r7.setAlpha(r6);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.iqoption.quiz.SplashPagerQuizDelegate.3.onPageScrolled(int, float, int):void");
            }

            public void onPageSelected(int i) {
                d a = this.dhr.dhq;
                if (a != null) {
                    a.Bs();
                }
                SplashPagerQuizDelegate splashPagerQuizDelegate = this.dhr;
                QuizDelegate quizDelegate = (QuizDelegate) linkedHashMap.get(Integer.valueOf(i));
                d azN = quizDelegate instanceof LeaderBoardQuizDelegate ? com.iqoption.quiz.a.a.did.azN() : quizDelegate instanceof InsightsQuizDelegate ? com.iqoption.quiz.a.a.did.azK() : quizDelegate instanceof OffAirQuizDelegate ? com.iqoption.quiz.a.a.did.ey(false) : quizDelegate instanceof UpdateQuizDelegate ? com.iqoption.quiz.a.a.did.azO() : quizDelegate instanceof PromoCodeQuizDelegate ? com.iqoption.quiz.a.a.did.azP() : null;
                splashPagerQuizDelegate.dhq = azN;
            }
        });
    }

    public final rt azv() {
        return this.dhp;
    }

    public View getView() {
        return this.view;
    }

    private final List<QuizDelegate> a(QuizFragment quizFragment) {
        List<QuizDelegate> G;
        ViewPager viewPager;
        QuizDelegate[] quizDelegateArr;
        ViewPager viewPager2;
        ViewPager viewPager3;
        if (com.iqoption.app.managers.feature.a.HN()) {
            quizDelegateArr = new QuizDelegate[3];
            viewPager2 = this.dhp.bmI;
            h.d(viewPager2, "binding.pager");
            quizDelegateArr[0] = new InsightsQuizDelegate(quizFragment, viewPager2);
            viewPager2 = this.dhp.bmI;
            h.d(viewPager2, "binding.pager");
            quizDelegateArr[1] = new UpdateQuizDelegate(quizFragment, viewPager2);
            viewPager3 = this.dhp.bmI;
            h.d(viewPager3, "binding.pager");
            quizDelegateArr[2] = new LeaderBoardQuizDelegate(quizFragment, viewPager3);
            G = m.G(quizDelegateArr);
        } else if (com.iqoption.app.managers.feature.a.eX("iq-quiz-leaderboard")) {
            quizDelegateArr = new QuizDelegate[3];
            viewPager2 = this.dhp.bmI;
            h.d(viewPager2, "binding.pager");
            quizDelegateArr[0] = new InsightsQuizDelegate(quizFragment, viewPager2);
            viewPager2 = this.dhp.bmI;
            h.d(viewPager2, "binding.pager");
            quizDelegateArr[1] = new OffAirQuizDelegate(quizFragment, viewPager2);
            viewPager3 = this.dhp.bmI;
            h.d(viewPager3, "binding.pager");
            quizDelegateArr[2] = new LeaderBoardQuizDelegate(quizFragment, viewPager3);
            G = m.G(quizDelegateArr);
        } else {
            quizDelegateArr = new QuizDelegate[2];
            viewPager = this.dhp.bmI;
            h.d(viewPager, "binding.pager");
            quizDelegateArr[0] = new InsightsQuizDelegate(quizFragment, viewPager);
            viewPager = this.dhp.bmI;
            h.d(viewPager, "binding.pager");
            quizDelegateArr[1] = new OffAirQuizDelegate(quizFragment, viewPager);
            G = m.G(quizDelegateArr);
        }
        Boolean bool = (Boolean) this.cDq.aBX().getValue();
        if (bool == null) {
            bool = Boolean.valueOf(false);
        }
        if (!bool.booleanValue()) {
            viewPager = this.dhp.bmI;
            h.d(viewPager, "binding.pager");
            G.add(0, new PromoCodeQuizDelegate(quizFragment, viewPager));
        }
        return G;
    }

    private final void aV(List<? extends QuizDelegate> list) {
        ViewPager viewPager = this.dhp.bmI;
        h.d(viewPager, "binding.pager");
        if (viewPager.getAdapter() == null) {
            viewPager = this.dhp.bmI;
            h.d(viewPager, "binding.pager");
            viewPager.setAdapter(new ab(list));
            this.dhp.bmI.setCurrentItem(aW(list), false);
            ImageView imageView = this.dhp.bBJ;
            h.d(imageView, "binding.pageIndicator");
            com.iqoption.core.ext.a.L(imageView);
            imageView = this.dhp.bBq.bBr;
            h.d(imageView, "binding.title.infoIcon");
            com.iqoption.core.ext.a.L(imageView);
            this.dhp.bnn.animate().alpha(0.0f).setListener(new a(this));
        }
    }

    private final int aW(List<? extends QuizDelegate> list) {
        Boolean bool = (Boolean) this.cDr.aBs().getValue();
        if (bool == null) {
            bool = Boolean.valueOf(false);
        }
        h.d(bool, "showInsights");
        int i;
        if (bool.booleanValue()) {
            i = 0;
            for (QuizDelegate quizDelegate : list) {
                if (quizDelegate instanceof InsightsQuizDelegate) {
                    break;
                }
                i++;
            }
            i = -1;
            return Math.max(0, i);
        }
        i = 0;
        for (QuizDelegate quizDelegate2 : list) {
            Object obj = ((quizDelegate2 instanceof OffAirQuizDelegate) || (quizDelegate2 instanceof UpdateQuizDelegate)) ? 1 : null;
            if (obj != null) {
                break;
            }
            i++;
        }
        i = -1;
        return Math.max(0, i);
    }

    public void destroy() {
        super.destroy();
        d dVar = this.dhq;
        if (dVar != null) {
            dVar.Bs();
        }
        this.dhq = (d) null;
    }
}
