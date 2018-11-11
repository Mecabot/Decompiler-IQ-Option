package com.iqoption.deposit.complete;

import android.arch.lifecycle.Lifecycle;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.annotation.StringRes;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.iqoption.core.util.q;
import io.reactivex.subjects.CompletableSubject;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.util.HashMap;
import kotlin.TypeCastException;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1Impl;

@kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\r\n\u0002\b\t\b&\u0018\u0000 R2\u00020\u0001:\u0004RSTUB\u0005¢\u0006\u0002\u0010\u0002J\u000f\u0010&\u001a\u0004\u0018\u00010'H&¢\u0006\u0002\u0010(J\b\u0010)\u001a\u00020*H&J\b\u0010+\u001a\u00020,H&J\b\u0010-\u001a\u00020.H\u0002J\b\u0010/\u001a\u00020*H&J\u0010\u00100\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0015H\u0002J\b\u00101\u001a\u00020,H&J\b\u00102\u001a\u000203H&J\b\u00104\u001a\u00020,H&J\u0010\u00105\u001a\u0002062\u0006\u00107\u001a\u000203H\u0002J\u0012\u00108\u001a\u00020.2\b\u00109\u001a\u0004\u0018\u00010:H\u0016J\b\u0010;\u001a\u00020.H\u0016J\u001c\u0010<\u001a\u00020.2\b\b\u0001\u0010=\u001a\u00020>2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\b\u0010?\u001a\u00020.H\u0016J\u001a\u0010@\u001a\u00020.2\u0006\u0010A\u001a\u00020*2\b\u00109\u001a\u0004\u0018\u00010:H\u0016J\b\u0010B\u001a\u00020.H\u0002J\b\u0010C\u001a\u00020DH&J\n\u0010E\u001a\u0004\u0018\u00010*H&J&\u0010F\u001a\u00020.2\u0006\u0010G\u001a\u0002032\b\b\u0001\u0010=\u001a\u00020>2\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\u0015H\u0002J\u001c\u0010I\u001a\u00020.2\b\b\u0001\u0010=\u001a\u00020>2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\u001e\u0010J\u001a\u00020.2\b\b\u0001\u0010=\u001a\u00020>2\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\u0015H&J\u0018\u0010K\u001a\u00020.2\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020\u001bH\u0002J\u0010\u0010O\u001a\u00020.2\u0006\u0010L\u001a\u00020MH&J\b\u0010P\u001a\u000203H&J\b\u0010Q\u001a\u00020.H\u0002R+\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048B@BX\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R#\u0010\u0014\u001a\n \u0016*\u0004\u0018\u00010\u00150\u00158BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0002¢\u0006\f\n\u0004\b \u0010\u0013\u001a\u0004\b\u001e\u0010\u001fR#\u0010!\u001a\n \u0016*\u0004\u0018\u00010\u00150\u00158BX\u0002¢\u0006\f\n\u0004\b#\u0010\u0013\u001a\u0004\b\"\u0010\u0018R\u000e\u0010$\u001a\u00020%X.¢\u0006\u0002\n\u0000¨\u0006V"}, aXE = {"Lcom/iqoption/deposit/complete/BaseCompletePaymentFragment;", "Lcom/iqoption/core/ui/fragment/IQFragment;", "()V", "<set-?>", "Lcom/iqoption/deposit/complete/BaseCompletePaymentFragment$CompletePaymentDelegate;", "completePaymentDelegate", "getCompletePaymentDelegate", "()Lcom/iqoption/deposit/complete/BaseCompletePaymentFragment$CompletePaymentDelegate;", "setCompletePaymentDelegate", "(Lcom/iqoption/deposit/complete/BaseCompletePaymentFragment$CompletePaymentDelegate;)V", "completePaymentDelegate$delegate", "Lkotlin/properties/ReadWriteProperty;", "compositionLoader", "Lcom/airbnb/lottie/Cancellable;", "currency", "Lcom/iqoption/core/microservices/billing/response/deposit/CurrencyBilling;", "getCurrency", "()Lcom/iqoption/core/microservices/billing/response/deposit/CurrencyBilling;", "currency$delegate", "Lkotlin/Lazy;", "errorMessage", "", "kotlin.jvm.PlatformType", "getErrorMessage", "()Ljava/lang/String;", "errorMessage$delegate", "operationCompleted", "", "payAmount", "Ljava/math/BigDecimal;", "getPayAmount", "()Ljava/math/BigDecimal;", "payAmount$delegate", "showTag", "getShowTag", "showTag$delegate", "viewModel", "Lcom/iqoption/deposit/complete/CompleteViewModel;", "animationStartDelayMillis", "", "()Ljava/lang/Long;", "backButton", "Landroid/view/View;", "buyingTextView", "Landroid/widget/TextView;", "close", "", "copyErrorButton", "delegateFromTag", "doneButton", "errorAnimation", "Lcom/iqoption/deposit/CurrencyAnimation;", "line1TextView", "loadAnim", "Lio/reactivex/Completable;", "animation", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onError", "contactSupportTextId", "", "onResume", "onViewCreated", "view", "openSupport", "progressLogoView", "Lcom/airbnb/lottie/LottieAnimationView;", "retryButton", "showError", "currencyAnimation", "message", "showErrorImmediate", "showErrorUI", "showSuccessImmediate", "mainText", "", "autoClose", "showSuccessUI", "successAnimation", "vibrate", "Companion", "CompleteDepositDelegate", "CompletePaymentDelegate", "ErrorDelegate", "deposit_release"})
/* compiled from: BaseCompletePaymentFragment.kt */
public abstract class a extends com.iqoption.core.ui.fragment.b {
    private static final String TAG = "com.iqoption.deposit.complete.a";
    static final /* synthetic */ kotlin.reflect.j[] apP = new kotlin.reflect.j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(a.class), "showTag", "getShowTag()Ljava/lang/String;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(a.class), "errorMessage", "getErrorMessage()Ljava/lang/String;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(a.class), com.google.firebase.analytics.FirebaseAnalytics.b.CURRENCY, "getCurrency()Lcom/iqoption/core/microservices/billing/response/deposit/CurrencyBilling;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(a.class), "payAmount", "getPayAmount()Ljava/math/BigDecimal;")), kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(a.class), "completePaymentDelegate", "getCompletePaymentDelegate()Lcom/iqoption/deposit/complete/BaseCompletePaymentFragment$CompletePaymentDelegate;"))};
    public static final a bWF = new a();
    private HashMap atz;
    private final kotlin.d bWA = g.f(new BaseCompletePaymentFragment$currency$2(this));
    private final kotlin.d bWB = g.f(new BaseCompletePaymentFragment$payAmount$2(this));
    private boolean bWC;
    private CompleteViewModel bWD;
    private final kotlin.e.d bWE = kotlin.e.a.euA.aYg();
    private final kotlin.d bWy = g.f(new BaseCompletePaymentFragment$showTag$2(this));
    private final kotlin.d bWz = g.f(new BaseCompletePaymentFragment$errorMessage$2(this));
    private com.airbnb.lottie.a iZ;

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, aXE = {"Lcom/iqoption/deposit/complete/BaseCompletePaymentFragment$Companion;", "", "()V", "ARG_CURRENCY", "", "ARG_PAYMENT_ERROR_MESSAGE", "ARG_PAY_AMOUNT", "ARG_SHOW_TAG", "DEPOSIT_TAG", "ERROR_DEPOSIT_TAG", "TAG", "getTAG", "()Ljava/lang/String;", "deposit_release"})
    /* compiled from: BaseCompletePaymentFragment.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final String Ll() {
            return a.TAG;
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\bb\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\"\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0010"}, aXE = {"Lcom/iqoption/deposit/complete/BaseCompletePaymentFragment$CompletePaymentDelegate;", "", "cleanup", "", "makePayment", "fragment", "Lcom/iqoption/deposit/complete/BaseCompletePaymentFragment;", "showError", "currencyAnimation", "Lcom/iqoption/deposit/CurrencyAnimation;", "contactSupportTextId", "", "showProgress", "showSuccess", "mainText", "", "deposit_release"})
    /* compiled from: BaseCompletePaymentFragment.kt */
    private interface c {

        @kotlin.i(aXC = {1, 1, 11})
        /* compiled from: BaseCompletePaymentFragment.kt */
        public static final class a {
            public static void b(c cVar) {
            }
        }

        void cleanup();

        void e(a aVar);
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: BaseCompletePaymentFragment.kt */
    static final class f implements OnClickListener {
        final /* synthetic */ a this$0;

        f(a aVar) {
            this.this$0 = aVar;
        }

        public final void onClick(View view) {
            this.this$0.abB();
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: BaseCompletePaymentFragment.kt */
    static final class g implements OnClickListener {
        final /* synthetic */ a this$0;

        g(a aVar) {
            this.this$0 = aVar;
        }

        public final void onClick(View view) {
            this.this$0.close();
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: BaseCompletePaymentFragment.kt */
    static final class h implements OnClickListener {
        final /* synthetic */ a this$0;

        h(a aVar) {
            this.this$0 = aVar;
        }

        public final void onClick(View view) {
            com.iqoption.core.f.RQ().Ds().dV("deposit-page_failed-try-again");
            this.this$0.close();
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: BaseCompletePaymentFragment.kt */
    static final class i implements OnClickListener {
        final /* synthetic */ a this$0;

        i(a aVar) {
            this.this$0 = aVar;
        }

        public final void onClick(View view) {
            com.iqoption.core.f.RQ().Ds().dV("deposit-page_success-trade");
            this.this$0.close();
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
    /* compiled from: BaseCompletePaymentFragment.kt */
    static final class j implements Runnable {
        final /* synthetic */ WeakReference bWN;

        j(WeakReference weakReference) {
            this.bWN = weakReference;
        }

        public final void run() {
            a aVar = (a) this.bWN.get();
            if (aVar != null) {
                aVar.close();
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, aXE = {"Lcom/iqoption/deposit/complete/BaseCompletePaymentFragment$CompleteDepositDelegate;", "Lcom/iqoption/deposit/complete/BaseCompletePaymentFragment$CompletePaymentDelegate;", "realBalance", "Lio/reactivex/Flowable;", "Lcom/iqoption/core/data/mediators/BalanceData;", "(Lio/reactivex/Flowable;)V", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "cleanup", "", "makePayment", "fragment", "Lcom/iqoption/deposit/complete/BaseCompletePaymentFragment;", "deposit_release"})
    /* compiled from: BaseCompletePaymentFragment.kt */
    private static final class b implements c {
        private final io.reactivex.disposables.a bWG = new io.reactivex.disposables.a();
        private final io.reactivex.e<com.iqoption.core.data.c.a> bWH;

        @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/core/data/mediators/BalanceData;", "kotlin.jvm.PlatformType", "accept"})
        /* compiled from: BaseCompletePaymentFragment.kt */
        static final class a<T> implements io.reactivex.c.e<com.iqoption.core.data.c.a> {
            final /* synthetic */ TextView bWI;
            final /* synthetic */ a bWJ;

            a(TextView textView, a aVar) {
                this.bWI = textView;
                this.bWJ = aVar;
            }

            /* renamed from: a */
            public final void accept(com.iqoption.core.data.c.a aVar) {
                this.bWI.setText(com.iqoption.core.ext.a.m(this.bWJ).getString(com.iqoption.deposit.r.h.balance_n1, new Object[]{aVar.Sz()}));
            }
        }

        @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "error", "", "kotlin.jvm.PlatformType", "accept"})
        /* compiled from: BaseCompletePaymentFragment.kt */
        static final class b<T> implements io.reactivex.c.e<Throwable> {
            final /* synthetic */ TextView bWI;

            b(TextView textView) {
                this.bWI = textView;
            }

            /* renamed from: o */
            public final void accept(Throwable th) {
                this.bWI.setText((CharSequence) null);
            }
        }

        public b(io.reactivex.e<com.iqoption.core.data.c.a> eVar) {
            kotlin.jvm.internal.h.e(eVar, "realBalance");
            this.bWH = eVar;
        }

        public void e(a aVar) {
            kotlin.jvm.internal.h.e(aVar, "fragment");
            BigDecimal a = aVar.abz();
            com.iqoption.core.microservices.billing.response.deposit.c b = aVar.aaH();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("+ ");
            stringBuilder.append(com.iqoption.core.util.c.a(a, b, true));
            aVar.b(stringBuilder.toString(), false);
            TextView abF = aVar.abF();
            this.bWG.e(this.bWH.d(com.iqoption.core.h.i.Yo()).c(com.iqoption.core.h.i.Yp()).a((io.reactivex.c.e) new a(abF, aVar), (io.reactivex.c.e) new b(abF)));
            com.iqoption.billing.repository.e.ary.JI();
            com.iqoption.core.f.RQ().Ds().dZ("deposit-page_success").Bs();
        }

        public void cleanup() {
            a.b(this);
            this.bWG.clear();
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, aXE = {"Lcom/iqoption/deposit/complete/BaseCompletePaymentFragment$ErrorDelegate;", "Lcom/iqoption/deposit/complete/BaseCompletePaymentFragment$CompletePaymentDelegate;", "contactSupportTextId", "", "errorMessage", "", "(ILjava/lang/String;)V", "getContactSupportTextId", "()I", "getErrorMessage", "()Ljava/lang/String;", "makePayment", "", "fragment", "Lcom/iqoption/deposit/complete/BaseCompletePaymentFragment;", "deposit_release"})
    /* compiled from: BaseCompletePaymentFragment.kt */
    private static final class d implements c {
        private final int bWK;
        private final String errorMessage;

        public d(@StringRes int i, String str) {
            this.bWK = i;
            this.errorMessage = str;
        }

        public void cleanup() {
            a.b(this);
        }

        public void e(a aVar) {
            kotlin.jvm.internal.h.e(aVar, "fragment");
            aVar.f(this.bWK, this.errorMessage);
            com.iqoption.core.f.RQ().Ds().dZ("deposit-page_failed").Bs();
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, aXE = {"com/iqoption/core/ext/AndroidExtensionsKt$setOnDelayedClickListener$1", "Lcom/iqoption/core/ext/OnDelayClickListener;", "onDelayClick", "", "v", "Landroid/view/View;", "core_release"})
    /* compiled from: AndroidExtensions.kt */
    public static final class e extends com.iqoption.core.ext.g {
        final /* synthetic */ String bWM;
        final /* synthetic */ a this$0;

        public e(a aVar, String str) {
            this.this$0 = aVar;
            this.bWM = str;
            super(0, 1, null);
        }

        public void q(View view) {
            kotlin.jvm.internal.h.e(view, "v");
            q.ag(this.this$0.getString(com.iqoption.deposit.r.h.deposit_error), this.bWM);
            Toast.makeText(com.iqoption.core.ext.a.m(this.this$0), com.iqoption.deposit.r.h.error_text_copied, 0).show();
        }
    }

    private final void a(c cVar) {
        this.bWE.a(this, apP[4], cVar);
    }

    private final com.iqoption.core.microservices.billing.response.deposit.c aaH() {
        kotlin.d dVar = this.bWA;
        kotlin.reflect.j jVar = apP[2];
        return (com.iqoption.core.microservices.billing.response.deposit.c) dVar.getValue();
    }

    private final c abA() {
        return (c) this.bWE.b(this, apP[4]);
    }

    private final void abB() {
    }

    private final String aby() {
        kotlin.d dVar = this.bWy;
        kotlin.reflect.j jVar = apP[0];
        return (String) dVar.getValue();
    }

    private final BigDecimal abz() {
        kotlin.d dVar = this.bWB;
        kotlin.reflect.j jVar = apP[3];
        return (BigDecimal) dVar.getValue();
    }

    private final String getErrorMessage() {
        kotlin.d dVar = this.bWz;
        kotlin.reflect.j jVar = apP[1];
        return (String) dVar.getValue();
    }

    public void KH() {
        if (this.atz != null) {
            this.atz.clear();
        }
    }

    public abstract View abD();

    public abstract View abE();

    public abstract TextView abF();

    public abstract TextView abG();

    public abstract TextView abH();

    public abstract LottieAnimationView abI();

    public abstract Long abJ();

    public abstract View abK();

    public abstract com.iqoption.deposit.b abL();

    public abstract com.iqoption.deposit.b abM();

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

    public abstract void g(@StringRes int i, String str);

    public abstract void w(CharSequence charSequence);

    static {
        kotlin.jvm.internal.h.d(a.class.getName(), "BaseCompletePaymentFragment::class.java.name");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bWD = CompleteViewModel.bWO.x(this);
    }

    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.h.e(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        abG().setOnClickListener(new f(this));
        abD().setOnClickListener(new g(this));
        view = abE();
        if (view != null) {
            view.setOnClickListener(new h(this));
        }
        abH().setOnClickListener(new i(this));
        String aby = aby();
        kotlin.jvm.internal.h.d(aby, "showTag");
        a(hd(aby));
        abA().e(this);
        Lifecycle lifecycle = getLifecycle();
        FragmentActivity n = com.iqoption.core.ext.a.n(this);
        if (n == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.iqoption.core.ui.navigation.BackController");
        }
        lifecycle.a(new BaseCompletePaymentFragment$onViewCreated$5(this, (com.iqoption.core.ui.navigation.a) n));
    }

    public void onDestroyView() {
        super.onDestroyView();
        abA().cleanup();
        com.airbnb.lottie.a aVar = this.iZ;
        if (aVar != null) {
            aVar.cancel();
        }
        this.iZ = (com.airbnb.lottie.a) null;
        KH();
    }

    private final void f(@StringRes int i, String str) {
        abI().cW();
        abI().w(false);
        a(abL());
        onError(i, str);
    }

    private final void onError(@StringRes int i, String str) {
        this.bWC = true;
        g(i, str);
        if (str == null || (u.M(str) ^ 1) != 1) {
            com.iqoption.core.ext.a.M(abK());
            return;
        }
        com.iqoption.core.ext.a.L(abK());
        abK().setOnClickListener(new e(this, str));
    }

    private final void b(CharSequence charSequence, boolean z) {
        abI().cW();
        abI().w(false);
        a(abM());
        com.iqoption.core.ext.a.M(abK());
        abC();
        w(charSequence);
        this.bWC = true;
        if (z) {
            com.iqoption.core.d.a.aSe.postDelayed(new j(com.iqoption.core.ext.c.bf(this)), 2500);
        }
    }

    private final io.reactivex.a a(com.iqoption.deposit.b bVar) {
        CompletableSubject aXz = CompletableSubject.aXz();
        this.iZ = bVar.a(com.iqoption.core.ext.a.m(this), new BaseCompletePaymentFragment$loadAnim$1(this, aXz));
        kotlin.jvm.internal.h.d(aXz, "callback");
        return aXz;
    }

    public void onResume() {
        super.onResume();
        com.iqoption.core.util.j.n(com.iqoption.core.ext.a.n(this));
    }

    private final c hd(String str) {
        int hashCode = str.hashCode();
        if (hashCode != -1339226265) {
            if (hashCode == 1554454174 && str.equals("deposit")) {
                CompleteViewModel completeViewModel = this.bWD;
                if (completeViewModel == null) {
                    kotlin.jvm.internal.h.lS("viewModel");
                }
                return new b(completeViewModel.he(aaH().getName()));
            }
        } else if (str.equals("error_deposit")) {
            return new d(com.iqoption.deposit.r.h.the_payment_was_unsuccessful, getErrorMessage());
        }
        return new d(com.iqoption.deposit.r.h.unknown_error_occurred, getErrorMessage());
    }

    private final void close() {
        String aby = aby();
        if (aby != null && aby.hashCode() == 1554454174 && aby.equals("deposit")) {
            com.iqoption.deposit.navigator.b.cbG.a(this, true);
            return;
        }
        com.iqoption.billing.repository.e.ary.JI();
        com.iqoption.deposit.navigator.b.cbG.G(this).pop();
    }

    private final void abC() {
        Object systemService = com.iqoption.core.ext.a.m(this).getSystemService("vibrator");
        if (systemService == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.os.Vibrator");
        }
        Vibrator vibrator = (Vibrator) systemService;
        if (VERSION.SDK_INT >= 26) {
            vibrator.vibrate(VibrationEffect.createOneShot(100, -1));
        } else {
            vibrator.vibrate(50);
        }
    }
}
