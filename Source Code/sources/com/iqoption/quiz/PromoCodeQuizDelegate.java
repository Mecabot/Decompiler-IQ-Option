package com.iqoption.quiz;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.iqoption.core.ext.g;
import com.iqoption.core.k;
import com.iqoption.core.l;
import com.iqoption.d.rp;
import com.iqoption.quiz.model.TriviaSocketViewModel;
import com.iqoption.view.text.x;
import com.iqoption.x.R;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0011\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\rH\u0001J\u0011\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\rH\u0001J\u0011\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\rH\u0001J\u0011\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\rH\u0001J\u0011\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\rH\u0001J\u0011\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\rH\u0001J\u0011\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0013\u001a\u00020\rH\u0001J*\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0013\u001a\u00020\r2\u0012\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u00020!0 \"\u00020!H\u0001¢\u0006\u0002\u0010\"J\t\u0010#\u001a\u00020$H\u0001J\u0011\u0010%\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020\u001bH\u0001J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u001eH\u0002R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006*"}, aXE = {"Lcom/iqoption/quiz/PromoCodeQuizDelegate;", "Lcom/iqoption/quiz/QuizDelegate;", "Lcom/iqoption/core/Resourcer;", "f", "Lcom/iqoption/quiz/QuizFragment;", "root", "Landroid/view/ViewGroup;", "(Lcom/iqoption/quiz/QuizFragment;Landroid/view/ViewGroup;)V", "binding", "Lcom/iqoption/databinding/FragmentQuizPromocodeDelegateBinding;", "getBinding", "()Lcom/iqoption/databinding/FragmentQuizPromocodeDelegateBinding;", "maxInputLength", "", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "getColor", "resId", "getColors", "Landroid/content/res/ColorStateList;", "getDrawable", "Landroid/graphics/drawable/Drawable;", "getFont", "Landroid/graphics/Typeface;", "getPixels", "", "getPixelsInt", "getString", "", "args", "", "", "(I[Ljava/lang/Object;)Ljava/lang/CharSequence;", "getViewConfiguration", "Landroid/view/ViewConfiguration;", "toPixels", "dp", "validate", "", "s", "IqOption-5.5.1_optionXRelease"})
/* compiled from: PromoCodeQuizDelegate.kt */
public final class PromoCodeQuizDelegate extends QuizDelegate implements k {
    private final /* synthetic */ l det;
    private final rp dfL;
    private final int dfM;
    private final View view;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\f"}, aXE = {"com/iqoption/quiz/PromoCodeQuizDelegate$1", "Landroid/support/v4/view/ViewPager$OnPageChangeListener;", "onPageScrollStateChanged", "", "state", "", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: PromoCodeQuizDelegate.kt */
    /* renamed from: com.iqoption.quiz.PromoCodeQuizDelegate$1 */
    public static final class AnonymousClass1 implements OnPageChangeListener {
        final /* synthetic */ PromoCodeQuizDelegate dfN;

        public void onPageScrolled(int i, float f, int i2) {
        }

        public void onPageSelected(int i) {
        }

        AnonymousClass1(PromoCodeQuizDelegate promoCodeQuizDelegate) {
            this.dfN = promoCodeQuizDelegate;
        }

        public void onPageScrollStateChanged(int i) {
            TextView textView;
            if (i == 0) {
                textView = this.dfN.ayX().agA;
                h.d(textView, "binding.title");
                com.iqoption.core.ext.a.L(textView);
                return;
            }
            textView = this.dfN.ayX().agA;
            h.d(textView, "binding.title");
            com.iqoption.core.ext.a.hide(textView);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, aXE = {"com/iqoption/core/ext/AndroidExtensionsKt$setOnDelayedClickListener$1", "Lcom/iqoption/core/ext/OnDelayClickListener;", "onDelayClick", "", "v", "Landroid/view/View;", "core_release"})
    /* compiled from: AndroidExtensions.kt */
    public static final class a extends g {
        final /* synthetic */ PromoCodeQuizDelegate dfN;
        final /* synthetic */ TriviaSocketViewModel dfn;

        @i(aXC = {1, 1, 11}, aXD = {"\u0000J\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u0001H\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, aXE = {"<anonymous>", "", "T", "it", "onChanged", "(Ljava/lang/Object;)V", "com/iqoption/util/LiveDatasKt$observe$1", "com/iqoption/quiz/PromoCodeQuizDelegate$$special$$inlined$observe$1"})
        /* compiled from: LiveDatas.kt */
        public static final class a<T> implements Observer<T> {
            final /* synthetic */ a dfO;
            final /* synthetic */ LiveData dfo;

            public a(LiveData liveData, a aVar) {
                this.dfo = liveData;
                this.dfO = aVar;
            }

            public final void onChanged(T t) {
                if (t != null) {
                    com.iqoption.core.ui.c cVar = (com.iqoption.core.ui.c) t;
                    if (cVar.isSuccess()) {
                        com.iqoption.app.a.b.cV(R.string.promo_code_applied);
                        this.dfO.dfn.aBY();
                    } else {
                        String message = cVar.getMessage();
                        if (message != null) {
                            if ((((CharSequence) message).length() > 0 ? 1 : 0) == 1) {
                                com.iqoption.app.a.b.eQ(cVar.getMessage());
                            }
                        }
                        com.iqoption.app.a.b.FG();
                    }
                    this.dfo.removeObservers(this.dfO.dfN);
                }
            }
        }

        public a(PromoCodeQuizDelegate promoCodeQuizDelegate, TriviaSocketViewModel triviaSocketViewModel) {
            this.dfN = promoCodeQuizDelegate;
            this.dfn = triviaSocketViewModel;
            super(0, 1, null);
        }

        public void q(View view) {
            h.e(view, "v");
            TextInputEditText textInputEditText = this.dfN.ayX().bBC;
            h.d(textInputEditText, "binding.promoCode");
            String obj = textInputEditText.getText().toString();
            if ((((CharSequence) obj).length() > 0 ? 1 : null) != null) {
                com.iqoption.quiz.a.a.did.s(obj, true);
                LiveData jv = this.dfn.jv(obj);
                jv.observe(this.dfN, new a(jv, this));
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, aXE = {"com/iqoption/core/ext/AndroidExtensionsKt$setOnDelayedClickListener$1", "Lcom/iqoption/core/ext/OnDelayClickListener;", "onDelayClick", "", "v", "Landroid/view/View;", "core_release"})
    /* compiled from: AndroidExtensions.kt */
    public static final class b extends g {
        final /* synthetic */ TriviaSocketViewModel dfn;

        public b(TriviaSocketViewModel triviaSocketViewModel) {
            this.dfn = triviaSocketViewModel;
            super(0, 1, null);
        }

        public void q(View view) {
            h.e(view, "v");
            this.dfn.aBY();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016¨\u0006\n"}, aXE = {"com/iqoption/quiz/PromoCodeQuizDelegate$textChangeListener$1", "Lcom/iqoption/view/text/TextWatcherAdapter;", "onTextChanged", "", "s", "", "start", "", "before", "count", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: PromoCodeQuizDelegate.kt */
    public static final class c extends x {
        final /* synthetic */ PromoCodeQuizDelegate dfN;

        c(PromoCodeQuizDelegate promoCodeQuizDelegate) {
            this.dfN = promoCodeQuizDelegate;
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            super.onTextChanged(charSequence, i, i2, i3);
            if (charSequence != null) {
                TextView textView = this.dfN.ayX().bBG;
                h.d(textView, "binding.redeem");
                textView.setEnabled(this.dfN.y(charSequence));
            }
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

    public PromoCodeQuizDelegate(QuizFragment quizFragment, ViewGroup viewGroup) {
        TextView textView;
        h.e(quizFragment, "f");
        h.e(viewGroup, "root");
        super(quizFragment);
        Context context = viewGroup.getContext();
        h.d(context, "root.context");
        this.det = new l(context);
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        h.d(from, "LayoutInflater.from(root.context)");
        this.dfL = (rp) com.iqoption.core.ext.a.a(from, (int) R.layout.fragment_quiz_promocode_delegate, viewGroup, false, 4, null);
        View root = this.dfL.getRoot();
        h.d(root, "binding.root");
        this.view = root;
        Fragment fragment = quizFragment;
        this.dfM = com.iqoption.core.ext.a.e(fragment, (int) R.integer.max_quiz_promo_input_length);
        TriviaSocketViewModel x = TriviaSocketViewModel.dmB.x(com.iqoption.core.ext.a.n(fragment));
        c cVar = new c(this);
        if (viewGroup instanceof ViewPager) {
            ((ViewPager) viewGroup).addOnPageChangeListener(new AnonymousClass1(this));
            textView = this.dfL.bBH;
            h.d(textView, "binding.skip");
            com.iqoption.core.ext.a.M(textView);
        }
        textView = this.dfL.bBG;
        h.d(textView, "binding.redeem");
        textView.setEnabled(false);
        textView = this.dfL.bBG;
        h.d(textView, "binding.redeem");
        textView.setOnClickListener(new a(this, x));
        textView = this.dfL.bBH;
        h.d(textView, "binding.skip");
        textView.setOnClickListener(new b(x));
        this.dfL.bBC.addTextChangedListener(cVar);
    }

    public final rp ayX() {
        return this.dfL;
    }

    public View getView() {
        return this.view;
    }

    private final boolean y(CharSequence charSequence) {
        return !TextUtils.isEmpty(charSequence) && charSequence.length() <= this.dfM;
    }
}
