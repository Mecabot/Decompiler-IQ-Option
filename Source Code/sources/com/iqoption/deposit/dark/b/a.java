package com.iqoption.deposit.dark.b;

import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.text.SpannableStringBuilder;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.iqoption.core.ext.g;
import com.iqoption.core.microservices.billing.response.deposit.c;
import com.iqoption.core.ui.navigation.h;
import com.iqoption.deposit.a.u;
import com.iqoption.deposit.r;
import com.iqoption.dto.ChartTimeInterval;
import java.math.BigDecimal;
import java.util.HashMap;
import kotlin.e.d;
import kotlin.i;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\u0018\u0000 /2\u00020\u0001:\u0001/B\u0005¢\u0006\u0002\u0010\u0002J\u000f\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0012H\u0016J&\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\"H\u0016J\n\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u001c\u0010%\u001a\u00020&2\b\b\u0001\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u0010\u0010+\u001a\u00020&2\u0006\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020\u0017H\u0016R+\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048B@BX\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u00060"}, aXE = {"Lcom/iqoption/deposit/dark/complete/CompletePaymentDarkFragment;", "Lcom/iqoption/deposit/complete/BaseCompletePaymentFragment;", "()V", "<set-?>", "Lcom/iqoption/deposit/databinding/FragmentPaymentCompletedBinding;", "binding", "getBinding", "()Lcom/iqoption/deposit/databinding/FragmentPaymentCompletedBinding;", "setBinding", "(Lcom/iqoption/deposit/databinding/FragmentPaymentCompletedBinding;)V", "binding$delegate", "Lkotlin/properties/ReadWriteProperty;", "animationStartDelayMillis", "", "()Ljava/lang/Long;", "backButton", "Landroid/widget/ImageView;", "buyingTextView", "Landroid/widget/TextView;", "copyErrorButton", "Landroid/widget/LinearLayout;", "doneButton", "errorAnimation", "Lcom/iqoption/deposit/CurrencyAnimation;", "line1TextView", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "progressLogoView", "Lcom/airbnb/lottie/LottieAnimationView;", "retryButton", "", "showErrorUI", "", "contactSupportTextId", "", "message", "", "showSuccessUI", "mainText", "", "successAnimation", "Companion", "deposit_release"})
/* compiled from: CompletePaymentDarkFragment.kt */
public final class a extends com.iqoption.deposit.complete.a {
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(a.class), "binding", "getBinding()Lcom/iqoption/deposit/databinding/FragmentPaymentCompletedBinding;"))};
    public static final a bXP = new a();
    private HashMap atz;
    private final d bXo = kotlin.e.a.euA.aYg();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006¨\u0006\f"}, aXE = {"Lcom/iqoption/deposit/dark/complete/CompletePaymentDarkFragment$Companion;", "", "()V", "createNavigatorEntry", "Lcom/iqoption/core/ui/navigation/NavigatorEntry;", "showTag", "", "currency", "Lcom/iqoption/core/microservices/billing/response/deposit/CurrencyBilling;", "payAmount", "Ljava/math/BigDecimal;", "errorMessage", "deposit_release"})
    /* compiled from: CompletePaymentDarkFragment.kt */
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
        final /* synthetic */ a bXQ;

        public b(a aVar) {
            this.bXQ = aVar;
            super(0, 1, null);
        }

        public void q(View view) {
            kotlin.jvm.internal.h.e(view, "v");
            com.iqoption.deposit.navigator.b.cbG.I(this.bXQ);
        }
    }

    private final void a(u uVar) {
        this.bXo.a(this, apP[0], uVar);
    }

    private final u acJ() {
        return (u) this.bXo.b(this, apP[0]);
    }

    public void KH() {
        if (this.atz != null) {
            this.atz.clear();
        }
    }

    public Long abJ() {
        return null;
    }

    public Void acL() {
        return null;
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

    public /* synthetic */ View abE() {
        return (View) acL();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.h.e(layoutInflater, "inflater");
        a((u) com.iqoption.core.ext.a.a((Fragment) this, r.g.fragment_payment_completed, viewGroup, false, 4, null));
        return acJ().getRoot();
    }

    public void w(CharSequence charSequence) {
        kotlin.jvm.internal.h.e(charSequence, "mainText");
        acJ().agA.setText(r.h.success1);
        ImageView acK = abD();
        kotlin.jvm.internal.h.d(acK, "backButton()");
        com.iqoption.core.ext.a.M(acK);
        Void acL = acL();
        if (acL != null) {
            com.iqoption.core.ext.a.M((View) acL);
        }
        TextView abH = abH();
        kotlin.jvm.internal.h.d(abH, "doneButton()");
        com.iqoption.core.ext.a.L(abH);
        abH = acJ().bZu;
        kotlin.jvm.internal.h.d(abH, "binding.resultText");
        com.iqoption.core.ext.a.L(abH);
        abH = acJ().bZu;
        kotlin.jvm.internal.h.d(abH, "binding.resultText");
        abH.setText(charSequence);
        TextView textView = acJ().bZo;
        kotlin.jvm.internal.h.d(textView, "binding.contactSupportButton");
        com.iqoption.core.ext.a.M(textView);
        textView = acJ().bZv;
        kotlin.jvm.internal.h.d(textView, "binding.resultTextTitle");
        com.iqoption.core.ext.a.L(textView);
        acJ().bZv.setText(r.h.you_have_deposited);
    }

    public void g(@StringRes int i, String str) {
        TextView abG;
        TextView textView = acJ().agA;
        kotlin.jvm.internal.h.d(textView, "binding.title");
        com.iqoption.core.ext.a.M(textView);
        textView = abF();
        kotlin.jvm.internal.h.d(textView, "buyingTextView()");
        com.iqoption.core.ext.a.M(textView);
        acJ().bZu.setText(r.h.failed);
        textView = acJ().bZu;
        kotlin.jvm.internal.h.d(textView, "binding.resultText");
        com.iqoption.core.ext.a.L(textView);
        textView = abG();
        kotlin.jvm.internal.h.d(textView, "line1TextView()");
        com.iqoption.core.ext.a.L(textView);
        ImageView acK = abD();
        kotlin.jvm.internal.h.d(acK, "backButton()");
        com.iqoption.core.ext.a.L(acK);
        Void acL = acL();
        if (acL != null) {
            com.iqoption.core.ext.a.L((View) acL);
        }
        if (str != null) {
            CharSequence charSequence = str;
            if ((charSequence.length() == 0 ? 1 : null) == null) {
                abG = abG();
                kotlin.jvm.internal.h.d(abG, "line1TextView()");
                abG.setMovementMethod(new ScrollingMovementMethod());
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getString(r.h.the_operation_was_unsuccessful_n1, str));
                spannableStringBuilder.setSpan(new ForegroundColorSpan(com.iqoption.core.ext.a.i(com.iqoption.core.ext.a.m(this), r.c.white)), (spannableStringBuilder.length() - str.length()) - 1, spannableStringBuilder.length() - 1, 33);
                abG = abG();
                kotlin.jvm.internal.h.d(abG, "line1TextView()");
                abG.setText(charSequence);
                abG = abG();
                kotlin.jvm.internal.h.d(abG, "line1TextView()");
                abG.setVisibility(0);
                abG = acJ().bZo;
                kotlin.jvm.internal.h.d(abG, "binding.contactSupportButton");
                abG.setOnClickListener(new b(this));
            }
        }
        abG().setText(i);
        abG = acJ().bZo;
        kotlin.jvm.internal.h.d(abG, "binding.contactSupportButton");
        abG.setOnClickListener(new b(this));
    }

    /* renamed from: acK */
    public ImageView abD() {
        return acJ().bZm;
    }

    public TextView abF() {
        return acJ().bZn;
    }

    public TextView abG() {
        return acJ().bZs;
    }

    public TextView abH() {
        return acJ().bZq;
    }

    /* renamed from: acM */
    public LinearLayout abK() {
        return acJ().bZp;
    }

    public LottieAnimationView abI() {
        return acJ().bZt;
    }

    public com.iqoption.deposit.b abL() {
        return com.iqoption.deposit.c.bVi.aap();
    }

    public com.iqoption.deposit.b abM() {
        return com.iqoption.deposit.c.bVi.aan();
    }
}
