package com.iqoption.quiz;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.iqoption.d.qn;
import com.iqoption.quiz.api.response.k;
import com.iqoption.quiz.model.TriviaSocketViewModel;
import com.iqoption.x.R;
import java.util.HashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001b\u001cB\u0005¢\u0006\u0002\u0010\u0002J&\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J \u0010\u0014\u001a\u00020\u00152\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00172\u0006\u0010\u0019\u001a\u00020\u001aH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\"\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b@BX\u000e¢\u0006\b\n\u0000\"\u0004\b\n\u0010\u000b¨\u0006\u001d"}, aXE = {"Lcom/iqoption/quiz/QuizFragment;", "Lcom/iqoption/core/ui/fragment/IQFragment;", "()V", "binding", "Lcom/iqoption/databinding/FragmentQuizBinding;", "quizDelegate", "Lcom/iqoption/quiz/QuizDelegate;", "value", "Lcom/iqoption/quiz/QuizFragment$QuizState;", "quizState", "setQuizState", "(Lcom/iqoption/quiz/QuizFragment$QuizState;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "updateQuizState", "", "quizStatus", "Lcom/iqoption/core/ui/Resource;", "Lcom/iqoption/quiz/api/response/StatusResponse;", "isAppOpenFromQuizLanding", "", "Companion", "QuizState", "IqOption-5.5.1_optionXRelease"})
/* compiled from: QuizFragment.kt */
public final class QuizFragment extends com.iqoption.core.ui.fragment.b {
    private static final String TAG = "com.iqoption.quiz.QuizFragment";
    public static final a dgy = new a();
    private HashMap atz;
    private qn dgv;
    private QuizState dgw;
    private QuizDelegate dgx;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, aXE = {"Lcom/iqoption/quiz/QuizFragment$QuizState;", "", "(Ljava/lang/String;I)V", "QuizOnAir", "QuizOffAirSplashPager", "QuizError", "QuizPromoCode", "QuizUpdate", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: QuizFragment.kt */
    private enum QuizState {
        QuizOnAir,
        QuizOffAirSplashPager,
        QuizError,
        QuizPromoCode,
        QuizUpdate
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\tH\u0007R\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, aXE = {"Lcom/iqoption/quiz/QuizFragment$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "newInstance", "Lcom/iqoption/quiz/QuizFragment;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: QuizFragment.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final String Ll() {
            return QuizFragment.TAG;
        }

        public final QuizFragment azd() {
            return new QuizFragment();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/core/ui/Resource;", "Lcom/iqoption/quiz/api/response/StatusResponse;", "onChanged", "com/iqoption/quiz/QuizFragment$onCreateView$1$1"})
    /* compiled from: QuizFragment.kt */
    static final class b<T> implements Observer<com.iqoption.core.ui.c<k>> {
        final /* synthetic */ TriviaSocketViewModel dfD;
        final /* synthetic */ QuizFragment dgz;

        b(TriviaSocketViewModel triviaSocketViewModel, QuizFragment quizFragment) {
            this.dfD = triviaSocketViewModel;
            this.dgz = quizFragment;
        }

        /* renamed from: a */
        public final void onChanged(com.iqoption.core.ui.c<k> cVar) {
            QuizFragment quizFragment = this.dgz;
            Boolean bool = (Boolean) this.dfD.aBW().getValue();
            if (bool == null) {
                bool = Boolean.valueOf(false);
            }
            quizFragment.a(cVar, bool.booleanValue());
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "", "onChanged", "(Ljava/lang/Boolean;)V", "com/iqoption/quiz/QuizFragment$onCreateView$1$2"})
    /* compiled from: QuizFragment.kt */
    static final class c<T> implements Observer<Boolean> {
        final /* synthetic */ TriviaSocketViewModel dfD;
        final /* synthetic */ QuizFragment dgz;

        c(TriviaSocketViewModel triviaSocketViewModel, QuizFragment quizFragment) {
            this.dfD = triviaSocketViewModel;
            this.dgz = quizFragment;
        }

        /* renamed from: k */
        public final void onChanged(Boolean bool) {
            QuizFragment quizFragment = this.dgz;
            com.iqoption.core.ui.c cVar = (com.iqoption.core.ui.c) this.dfD.aBO().getValue();
            if (bool == null) {
                bool = Boolean.valueOf(false);
            }
            quizFragment.a(cVar, bool.booleanValue());
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

    private final void a(QuizState quizState) {
        qn qnVar = this.dgv;
        if (qnVar == null) {
            h.lS("binding");
        }
        FrameLayout frameLayout = qnVar.axh;
        h.d(frameLayout, "binding.content");
        if (frameLayout.getChildCount() == 0 || this.dgw != quizState) {
            qn qnVar2;
            QuizDelegate quizDelegate;
            this.dgw = quizState;
            QuizDelegate quizDelegate2 = this.dgx;
            if (quizDelegate2 != null) {
                quizDelegate2.destroy();
                qnVar2 = this.dgv;
                if (qnVar2 == null) {
                    h.lS("binding");
                }
                qnVar2.axh.removeView(quizDelegate2.getView());
            }
            if (quizState == null) {
                quizDelegate = null;
            } else {
                FrameLayout frameLayout2;
                switch (t.aoS[quizState.ordinal()]) {
                    case 1:
                        com.iqoption.quiz.a.a.did.eC(false);
                        qnVar2 = this.dgv;
                        if (qnVar2 == null) {
                            h.lS("binding");
                        }
                        frameLayout2 = qnVar2.axh;
                        h.d(frameLayout2, "binding.content");
                        quizDelegate = new OnAirQuizDelegate(this, frameLayout2);
                        break;
                    case 2:
                        com.iqoption.quiz.a.a.did.eB(false);
                        qnVar2 = this.dgv;
                        if (qnVar2 == null) {
                            h.lS("binding");
                        }
                        frameLayout2 = qnVar2.axh;
                        h.d(frameLayout2, "binding.content");
                        quizDelegate = new SplashPagerQuizDelegate(this, frameLayout2);
                        break;
                    case 3:
                        com.iqoption.quiz.a.a.did.eA(false);
                        qnVar2 = this.dgv;
                        if (qnVar2 == null) {
                            h.lS("binding");
                        }
                        frameLayout2 = qnVar2.axh;
                        h.d(frameLayout2, "binding.content");
                        quizDelegate = new ErrorQuizDelegate(this, frameLayout2);
                        break;
                    case 4:
                        com.iqoption.quiz.a.a.did.azP().Bs();
                        qnVar2 = this.dgv;
                        if (qnVar2 == null) {
                            h.lS("binding");
                        }
                        frameLayout2 = qnVar2.axh;
                        h.d(frameLayout2, "binding.content");
                        quizDelegate = new PromoCodeQuizDelegate(this, frameLayout2);
                        break;
                    case 5:
                        qnVar2 = this.dgv;
                        if (qnVar2 == null) {
                            h.lS("binding");
                        }
                        frameLayout2 = qnVar2.axh;
                        h.d(frameLayout2, "binding.content");
                        quizDelegate = new UpdateQuizDelegate(this, frameLayout2);
                        break;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            }
            this.dgx = quizDelegate;
            if (quizDelegate != null) {
                qnVar2 = this.dgv;
                if (qnVar2 == null) {
                    h.lS("binding");
                }
                qnVar2.axh.addView(quizDelegate.getView(), 0);
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        h.e(layoutInflater, "inflater");
        this.dgv = (qn) com.iqoption.core.ext.a.a((Fragment) this, (int) R.layout.fragment_quiz, viewGroup, false, 4, null);
        if (this.dgv == null) {
            h.lS("binding");
        }
        TriviaSocketViewModel x = TriviaSocketViewModel.dmB.x(com.iqoption.core.ext.a.n(this));
        LifecycleOwner lifecycleOwner = this;
        x.aBO().observe(lifecycleOwner, new b(x, this));
        x.aBW().observe(lifecycleOwner, new c(x, this));
        qn qnVar = this.dgv;
        if (qnVar == null) {
            h.lS("binding");
        }
        return qnVar.getRoot();
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x001f  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0048 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0052  */
    private final void a(com.iqoption.core.ui.c<com.iqoption.quiz.api.response.k> r5, boolean r6) {
        /*
        r4 = this;
        r0 = 0;
        r1 = 0;
        if (r5 == 0) goto L_0x001c;
    L_0x0004:
        r2 = r5.isSuccess();
        if (r2 == 0) goto L_0x000c;
    L_0x000a:
        r2 = r5;
        goto L_0x000d;
    L_0x000c:
        r2 = r0;
    L_0x000d:
        if (r2 == 0) goto L_0x001c;
    L_0x000f:
        r2 = r2.getData();
        r2 = (com.iqoption.quiz.api.response.k) r2;
        if (r2 == 0) goto L_0x001c;
    L_0x0017:
        r2 = r2.aAv();
        goto L_0x001d;
    L_0x001c:
        r2 = 0;
    L_0x001d:
        if (r5 == 0) goto L_0x0036;
    L_0x001f:
        r3 = r5.isSuccess();
        if (r3 == 0) goto L_0x0026;
    L_0x0025:
        goto L_0x0027;
    L_0x0026:
        r5 = r0;
    L_0x0027:
        if (r5 == 0) goto L_0x0036;
    L_0x0029:
        r5 = r5.getData();
        r5 = (com.iqoption.quiz.api.response.k) r5;
        if (r5 == 0) goto L_0x0036;
    L_0x0031:
        r5 = r5.aAw();
        goto L_0x0037;
    L_0x0036:
        r5 = 0;
    L_0x0037:
        r0 = "iq-quiz";
        r0 = com.iqoption.app.managers.feature.a.eX(r0);
        if (r0 != 0) goto L_0x0046;
    L_0x003f:
        r0 = com.iqoption.app.managers.feature.a.HN();
        if (r0 == 0) goto L_0x0046;
    L_0x0045:
        r1 = 1;
    L_0x0046:
        if (r1 == 0) goto L_0x004d;
    L_0x0048:
        if (r2 == 0) goto L_0x004d;
    L_0x004a:
        r5 = com.iqoption.quiz.QuizFragment.QuizState.QuizUpdate;
        goto L_0x0063;
    L_0x004d:
        if (r1 == 0) goto L_0x0052;
    L_0x004f:
        r5 = com.iqoption.quiz.QuizFragment.QuizState.QuizOffAirSplashPager;
        goto L_0x0063;
    L_0x0052:
        if (r6 == 0) goto L_0x0057;
    L_0x0054:
        r5 = com.iqoption.quiz.QuizFragment.QuizState.QuizPromoCode;
        goto L_0x0063;
    L_0x0057:
        if (r5 == 0) goto L_0x005c;
    L_0x0059:
        r5 = com.iqoption.quiz.QuizFragment.QuizState.QuizError;
        goto L_0x0063;
    L_0x005c:
        if (r2 == 0) goto L_0x0061;
    L_0x005e:
        r5 = com.iqoption.quiz.QuizFragment.QuizState.QuizOnAir;
        goto L_0x0063;
    L_0x0061:
        r5 = com.iqoption.quiz.QuizFragment.QuizState.QuizOffAirSplashPager;
    L_0x0063:
        r4.a(r5);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.quiz.QuizFragment.a(com.iqoption.core.ui.c, boolean):void");
    }
}
