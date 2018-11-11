package com.iqoption.deposit.light.b;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.text.SpannableStringBuilder;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.iqoption.core.ext.g;
import com.iqoption.core.f;
import com.iqoption.core.microservices.billing.response.deposit.c;
import com.iqoption.core.ui.navigation.h;
import com.iqoption.deposit.a.w;
import com.iqoption.deposit.r;
import com.iqoption.dto.ChartTimeInterval;
import java.math.BigDecimal;
import java.util.HashMap;
import kotlin.e.d;
import kotlin.i;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\u0018\u0000 22\u00020\u0001:\u00012B\u0005¢\u0006\u0002\u0010\u0002J\r\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0017\u001a\u00020\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0015H\u0016J&\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020$H\u0016J\b\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020\u0015H\u0016J\u001c\u0010)\u001a\u00020$2\b\b\u0001\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0010\u0010.\u001a\u00020$2\u0006\u0010/\u001a\u000200H\u0017J\b\u00101\u001a\u00020\u0019H\u0016R+\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048B@BX\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\rXD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000e¨\u00063"}, aXE = {"Lcom/iqoption/deposit/light/complete/CompletePaymentLightFragment;", "Lcom/iqoption/deposit/complete/BaseCompletePaymentFragment;", "()V", "<set-?>", "Lcom/iqoption/deposit/databinding/FragmentPaymentCompletedLightBinding;", "binding", "getBinding", "()Lcom/iqoption/deposit/databinding/FragmentPaymentCompletedLightBinding;", "setBinding", "(Lcom/iqoption/deposit/databinding/FragmentPaymentCompletedLightBinding;)V", "binding$delegate", "Lkotlin/properties/ReadWriteProperty;", "isCustomAnimationsEnabled", "", "()Z", "animationStartDelayMillis", "", "()Ljava/lang/Long;", "backButton", "Landroid/widget/ImageView;", "buyingTextView", "Landroid/widget/TextView;", "copyErrorButton", "doneButton", "errorAnimation", "Lcom/iqoption/deposit/CurrencyAnimation;", "line1TextView", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onEnterAnimation", "", "onExitAnimation", "progressLogoView", "Lcom/airbnb/lottie/LottieAnimationView;", "retryButton", "showErrorUI", "contactSupportTextId", "", "message", "", "showSuccessUI", "mainText", "", "successAnimation", "Companion", "deposit_release"})
/* compiled from: CompletePaymentLightFragment.kt */
public final class a extends com.iqoption.deposit.complete.a {
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(a.class), "binding", "getBinding()Lcom/iqoption/deposit/databinding/FragmentPaymentCompletedLightBinding;"))};
    public static final a caF = new a();
    private HashMap atz;
    private final d bXo = kotlin.e.a.euA.aYg();
    private final boolean bbw = true;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006¨\u0006\f"}, aXE = {"Lcom/iqoption/deposit/light/complete/CompletePaymentLightFragment$Companion;", "", "()V", "createNavigatorEntry", "Lcom/iqoption/core/ui/navigation/NavigatorEntry;", "showTag", "", "currency", "Lcom/iqoption/core/microservices/billing/response/deposit/CurrencyBilling;", "payAmount", "Ljava/math/BigDecimal;", "errorMessage", "deposit_release"})
    /* compiled from: CompletePaymentLightFragment.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public static /* bridge */ /* synthetic */ h a(a aVar, String str, c cVar, BigDecimal bigDecimal, String str2, int i, Object obj) {
            if ((i & 8) != 0) {
                str2 = (String) null;
            }
            return aVar.a(str, cVar, bigDecimal, str2);
        }

        public final h a(String str, c cVar, BigDecimal bigDecimal, String str2) {
            kotlin.jvm.internal.h.e(str, "showTag");
            kotlin.jvm.internal.h.e(cVar, com.google.firebase.analytics.FirebaseAnalytics.b.CURRENCY);
            kotlin.jvm.internal.h.e(bigDecimal, "payAmount");
            Bundle bundle = new Bundle();
            bundle.putString("ARG_TAG", str);
            bundle.putParcelable("ARG_CURRENCY", cVar);
            bundle.putSerializable("ARG_PAY_AMOUNT", bigDecimal);
            if (str2 != null) {
                bundle.putString("ARG_PAYMENT_ERROR_MESSAGE", str2);
            }
            return new h(com.iqoption.deposit.complete.a.bWF.Ll(), a.class, bundle, 0, 0, 0, 0, ChartTimeInterval.CANDLE_2m, null);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, aXE = {"com/iqoption/core/ext/AndroidExtensionsKt$setOnDelayedClickListener$1", "Lcom/iqoption/core/ext/OnDelayClickListener;", "onDelayClick", "", "v", "Landroid/view/View;", "core_release"})
    /* compiled from: AndroidExtensions.kt */
    public static final class b extends g {
        final /* synthetic */ a caG;

        public b(a aVar) {
            this.caG = aVar;
            super(0, 1, null);
        }

        public void q(View view) {
            kotlin.jvm.internal.h.e(view, "v");
            com.iqoption.deposit.navigator.b.cbG.I(this.caG);
            f.RQ().Ds().dV("deposit-page_failed-support");
        }
    }

    private final void a(w wVar) {
        this.bXo.a(this, apP[0], wVar);
    }

    private final w adh() {
        return (w) this.bXo.b(this, apP[0]);
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

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.h.e(layoutInflater, "inflater");
        a((w) com.iqoption.core.ext.a.a((Fragment) this, r.g.fragment_payment_completed_light, viewGroup, false, 4, null));
        return adh().getRoot();
    }

    @SuppressLint({"SetTextI18n"})
    public void w(CharSequence charSequence) {
        kotlin.jvm.internal.h.e(charSequence, "mainText");
        adh().agA.setText(r.h.payment_processed);
        ImageView acK = abD();
        kotlin.jvm.internal.h.d(acK, "backButton()");
        com.iqoption.core.ext.a.L(acK);
        TextView adj = abE();
        kotlin.jvm.internal.h.d(adj, "retryButton()");
        com.iqoption.core.ext.a.M(adj);
        adj = abH();
        kotlin.jvm.internal.h.d(adj, "doneButton()");
        com.iqoption.core.ext.a.L(adj);
        adj = adh().bZu;
        kotlin.jvm.internal.h.d(adj, "binding.resultText");
        com.iqoption.core.ext.a.L(adj);
        String string = getString(r.h.success2);
        kotlin.jvm.internal.h.d(string, "getString(R.string.success2)");
        string = u.capitalize(string);
        TextView textView = adh().bZu;
        kotlin.jvm.internal.h.d(textView, "binding.resultText");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(": ");
        stringBuilder.append(charSequence);
        textView.setText(stringBuilder.toString());
        TextView textView2 = adh().bZo;
        kotlin.jvm.internal.h.d(textView2, "binding.contactSupportButton");
        com.iqoption.core.ext.a.M(textView2);
        textView2 = adh().bZv;
        kotlin.jvm.internal.h.d(textView2, "binding.resultTextTitle");
        com.iqoption.core.ext.a.M(textView2);
    }

    public void g(@StringRes int i, String str) {
        TextView abG;
        TextView textView = adh().agA;
        kotlin.jvm.internal.h.d(textView, "binding.title");
        com.iqoption.core.ext.a.L(textView);
        adh().agA.setText(r.h.payment_error);
        textView = abF();
        kotlin.jvm.internal.h.d(textView, "buyingTextView()");
        com.iqoption.core.ext.a.M(textView);
        adh().bZu.setText(r.h.failed);
        textView = adh().bZu;
        kotlin.jvm.internal.h.d(textView, "binding.resultText");
        com.iqoption.core.ext.a.L(textView);
        textView = abG();
        kotlin.jvm.internal.h.d(textView, "line1TextView()");
        com.iqoption.core.ext.a.L(textView);
        textView = abH();
        kotlin.jvm.internal.h.d(textView, "doneButton()");
        com.iqoption.core.ext.a.M(textView);
        ImageView acK = abD();
        kotlin.jvm.internal.h.d(acK, "backButton()");
        com.iqoption.core.ext.a.L(acK);
        textView = abE();
        kotlin.jvm.internal.h.d(textView, "retryButton()");
        com.iqoption.core.ext.a.L(textView);
        if (str != null) {
            CharSequence charSequence = str;
            if ((charSequence.length() == 0 ? 1 : null) == null) {
                abG = abG();
                kotlin.jvm.internal.h.d(abG, "line1TextView()");
                abG.setMovementMethod(new ScrollingMovementMethod());
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getString(r.h.the_operation_was_unsuccessful_n1, str));
                spannableStringBuilder.setSpan(new ForegroundColorSpan(com.iqoption.core.ext.a.i(com.iqoption.core.ext.a.m(this), r.c.black)), (spannableStringBuilder.length() - str.length()) - 1, spannableStringBuilder.length() - 1, 33);
                abG = abG();
                kotlin.jvm.internal.h.d(abG, "line1TextView()");
                abG.setText(charSequence);
                abG = abG();
                kotlin.jvm.internal.h.d(abG, "line1TextView()");
                abG.setVisibility(0);
                abG = adh().bZo;
                kotlin.jvm.internal.h.d(abG, "binding.contactSupportButton");
                abG.setOnClickListener(new b(this));
            }
        }
        abG().setText(i);
        abG = adh().bZo;
        kotlin.jvm.internal.h.d(abG, "binding.contactSupportButton");
        abG.setOnClickListener(new b(this));
    }

    /* renamed from: acK */
    public ImageView abD() {
        return adh().bZm;
    }

    /* renamed from: adi */
    public TextView abK() {
        return adh().bZw;
    }

    public TextView abF() {
        return adh().bZn;
    }

    public TextView abG() {
        return adh().bZs;
    }

    public TextView abH() {
        return adh().bqV;
    }

    /* renamed from: adj */
    public TextView abE() {
        return adh().bqY;
    }

    public LottieAnimationView abI() {
        return adh().bZt;
    }

    public Long abJ() {
        return Long.valueOf(150);
    }

    public boolean KE() {
        return this.bbw;
    }

    public com.iqoption.deposit.b abL() {
        return com.iqoption.deposit.c.bVi.aaq();
    }

    public com.iqoption.deposit.b abM() {
        return com.iqoption.deposit.c.bVi.aao();
    }

    public void KF() {
        Resources resources = com.iqoption.core.ext.a.m(this).getResources();
        kotlin.jvm.internal.h.d(resources, "ctx.resources");
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        View root = adh().getRoot();
        PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[1];
        propertyValuesHolderArr[0] = PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{(float) displayMetrics.heightPixels, 0.0f});
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(root, propertyValuesHolderArr);
        kotlin.jvm.internal.h.d(ofPropertyValuesHolder, "translation");
        ofPropertyValuesHolder.setInterpolator(com.iqoption.core.graphics.animation.i.TI());
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(adh().getRoot(), View.ALPHA, new float[]{0.0f, 1.0f});
        kotlin.jvm.internal.h.d(ofFloat, "alpha");
        ofFloat.setInterpolator(com.iqoption.core.graphics.animation.i.TI());
        AnimatorSet animatorSet = new AnimatorSet();
        com.iqoption.core.ext.a.a((Animator) animatorSet, Yw());
        animatorSet.playTogether(new Animator[]{ofPropertyValuesHolder, ofFloat});
        animatorSet.start();
    }

    public void KG() {
        Resources resources = com.iqoption.core.ext.a.m(this).getResources();
        kotlin.jvm.internal.h.d(resources, "ctx.resources");
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        View root = adh().getRoot();
        PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[1];
        propertyValuesHolderArr[0] = PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{0.0f, (float) displayMetrics.heightPixels});
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(root, propertyValuesHolderArr);
        kotlin.jvm.internal.h.d(ofPropertyValuesHolder, "translation");
        ofPropertyValuesHolder.setInterpolator(com.iqoption.core.graphics.animation.i.TI());
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(adh().getRoot(), View.ALPHA, new float[]{1.0f, 0.0f});
        kotlin.jvm.internal.h.d(ofFloat, "alpha");
        ofFloat.setInterpolator(com.iqoption.core.graphics.animation.i.TI());
        AnimatorSet animatorSet = new AnimatorSet();
        com.iqoption.core.ext.a.a((Animator) animatorSet, Yw());
        animatorSet.playTogether(new Animator[]{ofPropertyValuesHolder, ofFloat});
        animatorSet.start();
    }
}
