package com.iqoption.fragment.cashbox.deppage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.AppCompatSpinner2;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.SpinnerAdapter;
import android.widget.Switch;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.common.util.concurrent.s;
import com.iqoption.analytics.EventManager;
import com.iqoption.core.microservices.billing.response.deposit.PayMethod;
import com.iqoption.d.gt;
import com.iqoption.d.hl;
import com.iqoption.dto.Event;
import com.iqoption.fragment.cashbox.m;
import com.iqoption.util.ag;
import com.iqoption.util.be;
import com.iqoption.view.ConfirmButtonView;
import com.iqoption.x.R;
import java.util.HashMap;
import java.util.concurrent.Executor;
import kotlin.TypeCastException;

@kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 /2\u00020\u0001:\u0003/01B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\u0016\u0010\u001c\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\u001fH\u0002J\u0016\u0010 \u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\u001fH\u0002J\u0016\u0010!\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\u001fH\u0002J&\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u001a\u0010*\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020#2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u0018\u0010,\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\u0012H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128BX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0013¨\u00062"}, aXE = {"Lcom/iqoption/fragment/cashbox/deppage/DepositPageFundsFragment;", "Lcom/iqoption/fragment/base/IQFragment;", "()V", "binding", "Lcom/iqoption/databinding/DepositPageContentNoBonusBinding;", "cashboxCounting", "Lcom/iqoption/core/microservices/billing/response/deposit/CashboxCounting;", "depositHelper", "Lcom/iqoption/fragment/cashbox/DepositHelper;", "depositSum", "", "getDepositSum", "()D", "hostCallback", "Lcom/iqoption/fragment/cashbox/deppage/DepositPageFundsFragment$HostCallback;", "getHostCallback", "()Lcom/iqoption/fragment/cashbox/deppage/DepositPageFundsFragment$HostCallback;", "is3dsOnly", "", "()Z", "getListener", "Lcom/iqoption/fragment/cashbox/deppage/DepositPageFundsFragment$Companion$OnFragmentInteractionListener;", "getPaymentMethodById", "Lcom/iqoption/core/microservices/billing/response/deposit/PaymentMethod;", "paymentMethodId", "", "getTermsText", "", "initCurrencies", "", "cashBox", "Lcom/google/common/util/concurrent/ListenableFuture;", "initDeposits", "initPaymentMethods", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "show3ds", "isShow", "isDefault3ds", "Companion", "HostCallback", "OnDepositClickListener", "IqOption-5.5.1_optionXRelease"})
/* compiled from: DepositPageFundsFragment.kt */
public final class d extends com.iqoption.fragment.base.f {
    private static final String TAG = "d";
    public static final a cyS = new a();
    private com.iqoption.core.microservices.billing.response.deposit.b aTd;
    private HashMap atz;
    private com.iqoption.fragment.cashbox.f cxy;
    private gt cyR;

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0015B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u001a\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0019\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0016"}, aXE = {"Lcom/iqoption/fragment/cashbox/deppage/DepositPageFundsFragment$Companion;", "", "()V", "MAX_VISIBLE_DROPDOWN_ITEMS", "", "TAG", "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "get", "Lcom/iqoption/fragment/cashbox/deppage/DepositPageFundsFragment;", "getFirstAvailablePaymentMethodPos", "", "adapter", "Lcom/iqoption/fragment/cashbox/PaymentMethodsAdapter;", "tryShow3dsSwitch", "", "payMethod", "Lcom/iqoption/core/microservices/billing/response/deposit/PayMethod;", "fragment", "OnFragmentInteractionListener", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: DepositPageFundsFragment.kt */
    public static final class a {

        @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J5\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u0004H&¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u000eH&¨\u0006\u000f"}, aXE = {"Lcom/iqoption/fragment/cashbox/deppage/DepositPageFundsFragment$Companion$OnFragmentInteractionListener;", "", "onDepositOnDepositPagePressed", "Lcom/google/common/util/concurrent/ListenableFuture;", "", "payMethod", "Lcom/iqoption/core/microservices/billing/response/deposit/PayMethod;", "currencyBilling", "Lcom/iqoption/core/microservices/billing/response/deposit/CurrencyBilling;", "depositAmount", "", "is3dsPayment", "(Lcom/iqoption/core/microservices/billing/response/deposit/PayMethod;Lcom/iqoption/core/microservices/billing/response/deposit/CurrencyBilling;Ljava/lang/Double;Z)Lcom/google/common/util/concurrent/ListenableFuture;", "onDepositPageStartTradingPressed", "", "IqOption-5.5.1_optionXRelease"})
        /* compiled from: DepositPageFundsFragment.kt */
        public interface a {
            s<Boolean> a(PayMethod payMethod, com.iqoption.core.microservices.billing.response.deposit.c cVar, Double d, boolean z);
        }

        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final String Ll() {
            return d.TAG;
        }

        private final int a(m mVar) {
            int count = mVar.getCount();
            for (int i = 0; i < count; i++) {
                if (!mVar.getItem(i).UU()) {
                    return i;
                }
            }
            return 0;
        }

        private final void a(PayMethod payMethod, d dVar) {
            boolean z = false;
            if (payMethod == null || payMethod.UW() == -1) {
                dVar.g(false, false);
            } else if (dVar.akN()) {
                dVar.g(true, true);
            } else {
                boolean aOa = com.iqoption.withdrawal.crypto.a.aOa();
                if (payMethod.UV() || dVar.akN()) {
                    z = true;
                }
                dVar.g(aOa, z);
            }
        }

        public final d akT() {
            return new d();
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\b¨\u0006\t"}, aXE = {"Lcom/iqoption/fragment/cashbox/deppage/DepositPageFundsFragment$HostCallback;", "", "depositSum", "", "getDepositSum", "()D", "is3dsOnly", "", "()Z", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: DepositPageFundsFragment.kt */
    public interface b {
        double akM();

        boolean akN();
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0007"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/iqoption/fragment/cashbox/deppage/DepositPageFundsFragment$onViewCreated$1$1$1", "com/iqoption/fragment/cashbox/deppage/DepositPageFundsFragment$$special$$inlined$apply$lambda$1"})
    /* compiled from: DepositPageFundsFragment.kt */
    static final class j implements OnClickListener {
        final /* synthetic */ d cyT;

        j(d dVar) {
            this.cyT = dVar;
        }

        public final void onClick(View view) {
            com.iqoption.core.ext.a.p(com.iqoption.core.ext.a.r(this.cyT)).beginTransaction().add(R.id.fragment, com.iqoption.dialog.s.hm("terms-regulated"), "TermsDialog").setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).addToBackStack("TermsDialog").commit();
            EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "deposit_terms").build());
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/iqoption/fragment/cashbox/deppage/DepositPageFundsFragment$onViewCreated$1$icon3dsQuestionClickListener$1"})
    /* compiled from: DepositPageFundsFragment.kt */
    static final class k implements OnClickListener {
        final /* synthetic */ d cyT;

        k(d dVar) {
            this.cyT = dVar;
        }

        public final void onClick(final View view) {
            ViewParent viewParent;
            final PopupWindow popupWindow = new PopupWindow(this.cyT.getContext());
            ViewGroup viewGroup = (ViewGroup) (!(view instanceof ViewGroup) ? null : view);
            if (viewGroup != null) {
                viewParent = viewGroup;
            } else {
                kotlin.jvm.internal.h.d(view, "v");
                viewParent = view.getParent();
            }
            if (viewParent == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
            }
            View inflate = this.cyT.getLayoutInflater().inflate(R.layout.deposit_card_3ds_description_popup, (ViewGroup) viewParent, false);
            int dimension = (int) this.cyT.getResources().getDimension(R.dimen.deposit_3d_description_popup_width);
            inflate.measure(MeasureSpec.makeMeasureSpec(dimension, 1073741824), 0);
            kotlin.jvm.internal.h.d(inflate, "contentView");
            inflate.setMinimumHeight(inflate.getMeasuredHeight());
            popupWindow.setContentView(inflate);
            popupWindow.setBackgroundDrawable(null);
            popupWindow.setHeight(-2);
            popupWindow.setWidth(dimension);
            popupWindow.getContentView().setOnClickListener(new OnClickListener() {

                @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0007"}, aXE = {"com/iqoption/fragment/cashbox/deppage/DepositPageFundsFragment$onViewCreated$1$icon3dsQuestionClickListener$1$popup$1$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "IqOption-5.5.1_optionXRelease", "com/iqoption/fragment/cashbox/deppage/DepositPageFundsFragment$onViewCreated$1$icon3dsQuestionClickListener$1$$special$$inlined$also$lambda$1$1"})
                /* compiled from: DepositPageFundsFragment.kt */
                /* renamed from: com.iqoption.fragment.cashbox.deppage.d$k$1$1 */
                public static final class AnonymousClass1 extends AnimatorListenerAdapter {
                    final /* synthetic */ AnonymousClass1 czl;

                    AnonymousClass1(AnonymousClass1 anonymousClass1) {
                        this.czl = anonymousClass1;
                    }

                    public void onAnimationEnd(Animator animator) {
                        kotlin.jvm.internal.h.e(animator, "animation");
                        super.onAnimationEnd(animator);
                        popupWindow.dismiss();
                        View view = d.b(this.cyT).bqo;
                        kotlin.jvm.internal.h.d(view, "binding.veil");
                        view.setVisibility(8);
                    }
                }

                public final void onClick(View view) {
                    view.animate().alpha(0.0f).setListener(new AnonymousClass1(this));
                }
            });
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            final View contentView = popupWindow.getContentView();
            kotlin.jvm.internal.h.d(contentView, "popupContentView");
            i -= contentView.getMeasuredWidth();
            double measuredHeight = ((double) contentView.getMeasuredHeight()) * 0.5d;
            kotlin.jvm.internal.h.d(view, "v");
            i2 -= (int) (measuredHeight - (((double) view.getHeight()) * 0.5d));
            contentView.setAlpha(0.0f);
            contentView.animate().alpha(1.0f);
            d.b(this.cyT).bqo.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    contentView.performClick();
                }
            });
            contentView = d.b(this.cyT).bqo;
            kotlin.jvm.internal.h.d(contentView, "binding.veil");
            contentView.setVisibility(0);
            popupWindow.showAtLocation(view, 0, i, i2);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, aXE = {"Lcom/iqoption/fragment/cashbox/deppage/DepositPageFundsFragment$OnDepositClickListener;", "Lcom/iqoption/view/viewinterface/OnClickDelayView;", "(Lcom/iqoption/fragment/cashbox/deppage/DepositPageFundsFragment;)V", "onDelayClick", "", "view", "Landroid/view/View;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: DepositPageFundsFragment.kt */
    private final class c extends com.iqoption.view.d.b {

        @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
        /* compiled from: DepositPageFundsFragment.kt */
        static final class a implements Runnable {
            final /* synthetic */ ConfirmButtonView cyU;

            a(ConfirmButtonView confirmButtonView) {
                this.cyU = confirmButtonView;
            }

            public final void run() {
                this.cyU.f(false, false);
            }
        }

        /* JADX WARNING: Missing block: B:21:0x0071, code:
            if (r6 != null) goto L_0x0088;
     */
        public void q(android.view.View r8) {
            /*
            r7 = this;
            r0 = "view";
            kotlin.jvm.internal.h.e(r8, r0);
            r8 = r8.getParent();
            if (r8 != 0) goto L_0x0014;
        L_0x000c:
            r8 = new kotlin.TypeCastException;
            r0 = "null cannot be cast to non-null type com.iqoption.view.ConfirmButtonView";
            r8.<init>(r0);
            throw r8;
        L_0x0014:
            r8 = (com.iqoption.view.ConfirmButtonView) r8;
            r0 = com.iqoption.fragment.cashbox.deppage.d.this;
            r0 = r0.cxy;
            if (r0 == 0) goto L_0x00c1;
        L_0x001e:
            r1 = com.iqoption.analytics.EventManager.Bm();
            r2 = "button_pressed";
            r3 = "deposit-page_deposit";
            r2 = com.iqoption.dto.Event.Builder(r2, r3);
            r2 = r2.build();
            r1.a(r2);
            r1 = com.iqoption.fragment.cashbox.deppage.d.this;
            r1 = com.iqoption.fragment.cashbox.deppage.d.b(r1);
            r1 = r1.bpX;
            r2 = "binding.paymentMethodSpinner";
            kotlin.jvm.internal.h.d(r1, r2);
            r1 = r1.getSelectedItem();
            r1 = (com.iqoption.core.microservices.billing.response.deposit.PayMethod) r1;
            r2 = com.iqoption.fragment.cashbox.deppage.d.this;
            r2 = r2.aTd;
            r3 = 0;
            r4 = 1;
            if (r2 == 0) goto L_0x0074;
        L_0x004e:
            r5 = r2.Td();
            if (r5 == 0) goto L_0x005c;
        L_0x0054:
            r5 = r5.size();
            if (r5 != r4) goto L_0x005c;
        L_0x005a:
            r5 = 1;
            goto L_0x005d;
        L_0x005c:
            r5 = 0;
        L_0x005d:
            r6 = 0;
            if (r5 == 0) goto L_0x0061;
        L_0x0060:
            goto L_0x0062;
        L_0x0061:
            r2 = r6;
        L_0x0062:
            if (r2 == 0) goto L_0x0074;
        L_0x0064:
            r2 = r2.Td();
            if (r2 == 0) goto L_0x0071;
        L_0x006a:
            r2 = r2.get(r3);
            r6 = r2;
            r6 = (com.iqoption.core.microservices.billing.response.deposit.c) r6;
        L_0x0071:
            if (r6 == 0) goto L_0x0074;
        L_0x0073:
            goto L_0x0088;
        L_0x0074:
            r2 = com.iqoption.fragment.cashbox.deppage.d.this;
            r2 = com.iqoption.fragment.cashbox.deppage.d.b(r2);
            r2 = r2.bpj;
            r5 = "binding.currencySpinner";
            kotlin.jvm.internal.h.d(r2, r5);
            r2 = r2.getSelectedItem();
            r6 = r2;
            r6 = (com.iqoption.core.microservices.billing.response.deposit.c) r6;
        L_0x0088:
            r0 = r0.akf();
            r2 = com.iqoption.fragment.cashbox.deppage.d.this;
            r2 = r2.akS();
            if (r2 == 0) goto L_0x00c0;
        L_0x0094:
            if (r1 == 0) goto L_0x00c0;
        L_0x0096:
            if (r6 == 0) goto L_0x00c0;
        L_0x0098:
            if (r0 == 0) goto L_0x00c0;
        L_0x009a:
            r8.f(r4, r3);
            r3 = com.iqoption.fragment.cashbox.deppage.d.this;
            r3 = com.iqoption.fragment.cashbox.deppage.d.b(r3);
            r3 = r3.bpb;
            r4 = "binding.enable3dsSwitch";
            kotlin.jvm.internal.h.d(r3, r4);
            r3 = r3.isChecked();
            r0 = r2.a(r1, r6, r0, r3);
            r1 = new com.iqoption.fragment.cashbox.deppage.d$c$a;
            r1.<init>(r8);
            r1 = (java.lang.Runnable) r1;
            r8 = com.iqoption.core.d.a.aSe;
            r8 = (java.util.concurrent.Executor) r8;
            com.iqoption.util.ag.a(r0, r1, r8);
        L_0x00c0:
            return;
        L_0x00c1:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iqoption.fragment.cashbox.deppage.d.c.q(android.view.View):void");
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "", "referent", "Lcom/iqoption/fragment/cashbox/deppage/DepositPageFundsFragment;", "result", "Lcom/iqoption/core/microservices/billing/response/deposit/CashboxCounting;", "call"})
    /* compiled from: DepositPageFundsFragment.kt */
    static final class d<T, V> implements com.iqoption.util.ag.f<d, com.iqoption.core.microservices.billing.response.deposit.b> {
        public static final d cza = new d();

        d() {
        }

        /* renamed from: c */
        public final void C(d dVar, com.iqoption.core.microservices.billing.response.deposit.b bVar) {
            kotlin.jvm.internal.h.e(dVar, "referent");
            kotlin.jvm.internal.h.e(bVar, "result");
            DepositPageFundsFragment$initCurrencies$2.cyW.b(dVar, bVar);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "", "<anonymous parameter 0>", "Lcom/iqoption/fragment/cashbox/deppage/DepositPageFundsFragment;", "throwable", "", "call"})
    /* compiled from: DepositPageFundsFragment.kt */
    static final class e<T> implements com.iqoption.util.ag.b<d> {
        public static final e czb = new e();

        e() {
        }

        /* renamed from: a */
        public final void d(d dVar, Throwable th) {
            kotlin.jvm.internal.h.e(dVar, "<anonymous parameter 0>");
            kotlin.jvm.internal.h.e(th, "throwable");
            com.iqoption.core.i.w(d.cyS.Ll(), th.getMessage(), th);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "", "referent", "Lcom/iqoption/fragment/cashbox/deppage/DepositPageFundsFragment;", "result", "Lcom/iqoption/core/microservices/billing/response/deposit/CashboxCounting;", "call"})
    /* compiled from: DepositPageFundsFragment.kt */
    static final class f<T, V> implements com.iqoption.util.ag.f<d, com.iqoption.core.microservices.billing.response.deposit.b> {
        public static final f czd = new f();

        f() {
        }

        /* renamed from: c */
        public final void C(d dVar, com.iqoption.core.microservices.billing.response.deposit.b bVar) {
            kotlin.jvm.internal.h.e(dVar, "referent");
            kotlin.jvm.internal.h.e(bVar, "result");
            DepositPageFundsFragment$initDeposits$1.czc.b(dVar, bVar);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "", "<anonymous parameter 0>", "Lcom/iqoption/fragment/cashbox/deppage/DepositPageFundsFragment;", "throwable", "", "call"})
    /* compiled from: DepositPageFundsFragment.kt */
    static final class g<T> implements com.iqoption.util.ag.b<d> {
        public static final g cze = new g();

        g() {
        }

        /* renamed from: a */
        public final void d(d dVar, Throwable th) {
            kotlin.jvm.internal.h.e(dVar, "<anonymous parameter 0>");
            kotlin.jvm.internal.h.e(th, "throwable");
            com.iqoption.core.i.w(d.cyS.Ll(), th.getMessage(), th);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "", "referent", "Lcom/iqoption/fragment/cashbox/deppage/DepositPageFundsFragment;", "result", "Lcom/iqoption/core/microservices/billing/response/deposit/CashboxCounting;", "call"})
    /* compiled from: DepositPageFundsFragment.kt */
    static final class h<T, V> implements com.iqoption.util.ag.f<d, com.iqoption.core.microservices.billing.response.deposit.b> {
        public static final h czf = new h();

        h() {
        }

        /* renamed from: c */
        public final void C(final d dVar, com.iqoption.core.microservices.billing.response.deposit.b bVar) {
            kotlin.jvm.internal.h.e(dVar, "referent");
            kotlin.jvm.internal.h.e(bVar, "result");
            if (dVar.isAdded()) {
                d.b(dVar).bpI.f(false, false);
                AppCompatSpinner2 appCompatSpinner2 = d.b(dVar).bpX;
                int dimension = (int) (com.iqoption.core.ext.a.m(dVar).getResources().getDimension(R.dimen.deposit_payment_method_item_height) * 5.5f);
                kotlin.jvm.internal.h.d(appCompatSpinner2, "spinner");
                appCompatSpinner2.setMaxHeight(dimension);
                final m mVar = new m(appCompatSpinner2.getContext(), bVar, dVar.akN());
                appCompatSpinner2.setAdapter((SpinnerAdapter) mVar);
                appCompatSpinner2.setOnItemSelectedListener(new OnItemSelectedListener() {
                    public void onNothingSelected(AdapterView<?> adapterView) {
                        kotlin.jvm.internal.h.e(adapterView, "adapterView");
                    }

                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                        kotlin.jvm.internal.h.e(adapterView, "adapterView");
                        kotlin.jvm.internal.h.e(view, Promotion.ACTION_VIEW);
                        PayMethod eR = mVar.getItem(i);
                        if (dVar.cxy != null) {
                            com.iqoption.core.microservices.billing.response.deposit.g a = dVar.bn(eR.UQ());
                            com.iqoption.fragment.cashbox.f a2 = dVar.cxy;
                            if (a2 == null) {
                                kotlin.jvm.internal.h.aXZ();
                            }
                            a2.a(a);
                        }
                        d.cyS.a(eR, dVar);
                        EventManager.Bm().a(Event.Builder(Event.CATEGORY_DROPDOWN_CHANGED, "deposit-page_payment-method-changed").setValue(Double.valueOf((double) eR.UQ())).build());
                    }
                });
                ImageView imageView;
                if (mVar.getCount() < 2) {
                    imageView = d.b(dVar).bpW;
                    kotlin.jvm.internal.h.d(imageView, "referent.binding.paymentMethodCheck");
                    imageView.setVisibility(8);
                    AppCompatSpinner2 appCompatSpinner22 = d.b(dVar).bpX;
                    kotlin.jvm.internal.h.d(appCompatSpinner22, "referent.binding.paymentMethodSpinner");
                    appCompatSpinner22.setEnabled(false);
                    return;
                }
                imageView = d.b(dVar).bpW;
                kotlin.jvm.internal.h.d(imageView, "referent.binding.paymentMethodCheck");
                imageView.setVisibility(0);
                AppCompatSpinner2 appCompatSpinner23 = d.b(dVar).bpX;
                kotlin.jvm.internal.h.d(appCompatSpinner23, "referent.binding.paymentMethodSpinner");
                appCompatSpinner23.setEnabled(true);
                if (com.iqoption.app.managers.feature.a.eW("kyc-deposit-limit")) {
                    int a = d.cyS.a(mVar);
                    if (a > 0) {
                        d.b(dVar).bpX.setSelection(a);
                    }
                }
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "", "referent", "Lcom/iqoption/fragment/cashbox/deppage/DepositPageFundsFragment;", "throwable", "", "call"})
    /* compiled from: DepositPageFundsFragment.kt */
    static final class i<T> implements com.iqoption.util.ag.b<d> {
        public static final i czi = new i();

        i() {
        }

        /* renamed from: a */
        public final void d(d dVar, Throwable th) {
            kotlin.jvm.internal.h.e(dVar, "referent");
            kotlin.jvm.internal.h.e(th, "throwable");
            com.iqoption.core.i.w(d.cyS.Ll(), th.getMessage(), th);
            if (dVar.isAdded()) {
                d.b(dVar).bpI.f(false, false);
                com.iqoption.app.a.b.aT(dVar.getContext());
            }
        }
    }

    public void KH() {
        if (this.atz != null) {
            this.atz.clear();
        }
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        KH();
    }

    public static final /* synthetic */ gt b(d dVar) {
        gt gtVar = dVar.cyR;
        if (gtVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        return gtVar;
    }

    private final b akR() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            return (b) parentFragment;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.iqoption.fragment.cashbox.deppage.DepositPageFundsFragment.HostCallback");
    }

    private final boolean akN() {
        return akR().akN();
    }

    private final double akM() {
        return akR().akM();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.h.e(layoutInflater, "inflater");
        gt l = gt.l(layoutInflater, viewGroup, false);
        kotlin.jvm.internal.h.d(l, "this");
        this.cyR = l;
        kotlin.jvm.internal.h.d(l, "DepositPageContentNoBonu….apply { binding = this }");
        return l.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.h.e(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        gt gtVar = this.cyR;
        if (gtVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        gtVar.bpI.f(true, false);
        s iL = com.iqoption.mobbtech.connect.response.a.a.ava().iL(TAG);
        kotlin.jvm.internal.h.d(iL, "cashBox");
        g(iL);
        h(iL);
        i(iL);
        OnClickListener cVar = new c();
        gtVar.bpI.setOnClickListener(cVar);
        gtVar.bpo.setOnClickListener(cVar);
        hl hlVar = gtVar.bqe;
        if (hlVar != null) {
            hlVar.brc.setOnClickListener(new j(this));
        }
        OnClickListener kVar = new k(this);
        gt gtVar2 = this.cyR;
        if (gtVar2 == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        gtVar2.bpd.setOnClickListener(kVar);
        gtVar2 = this.cyR;
        if (gtVar2 == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        gtVar2.bpe.setOnClickListener(kVar);
    }

    private final void g(s<com.iqoption.core.microservices.billing.response.deposit.b> sVar) {
        ag.a((s) sVar, (Object) this, (com.iqoption.util.ag.f) h.czf, (com.iqoption.util.ag.b) i.czi, (Executor) com.iqoption.core.d.a.aSe);
    }

    private final a akS() {
        if (getContext() instanceof a) {
            Context context = getContext();
            if (context != null) {
                return (a) context;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.iqoption.fragment.cashbox.deppage.DepositPageFundsFragment.Companion.OnFragmentInteractionListener");
        } else if (!(getTargetFragment() instanceof a)) {
            return null;
        } else {
            Fragment targetFragment = getTargetFragment();
            if (targetFragment != null) {
                return (a) targetFragment;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.iqoption.fragment.cashbox.deppage.DepositPageFundsFragment.Companion.OnFragmentInteractionListener");
        }
    }

    private final com.iqoption.core.microservices.billing.response.deposit.g bn(long j) {
        com.iqoption.core.microservices.billing.response.deposit.b bVar = this.aTd;
        com.iqoption.core.microservices.billing.response.deposit.g gVar = null;
        if (bVar == null) {
            return null;
        }
        for (com.iqoption.core.microservices.billing.response.deposit.g next : bVar.UH()) {
            Object obj;
            if (next.UQ() == j) {
                obj = 1;
                continue;
            } else {
                obj = null;
                continue;
            }
            if (obj != null) {
                gVar = next;
                break;
            }
        }
        return gVar;
    }

    private final CharSequence akA() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<u><font color=#6d6e70>");
        stringBuilder.append(getString(R.string.conditions_and_provisions));
        stringBuilder.append("</u>");
        String stringBuilder2 = stringBuilder.toString();
        Spanned fromHtml = Html.fromHtml(getString(com.iqoption.app.managers.feature.a.eW("hide-deposit-check") ? R.string.by_clicking_deposit_you_confirm_n1 : R.string.i_hereby_accept, stringBuilder2));
        kotlin.jvm.internal.h.d(fromHtml, "Html.fromHtml(getString(…Res, termsAndConditions))");
        return fromHtml;
    }

    private final void h(s<com.iqoption.core.microservices.billing.response.deposit.b> sVar) {
        DepositPageFundsFragment$initCurrencies$1 depositPageFundsFragment$initCurrencies$1 = DepositPageFundsFragment$initCurrencies$1.cyV;
        DepositPageFundsFragment$initCurrencies$2 depositPageFundsFragment$initCurrencies$2 = DepositPageFundsFragment$initCurrencies$2.cyW;
        ag.a((s) sVar, (Object) this, (com.iqoption.util.ag.f) d.cza, (com.iqoption.util.ag.b) e.czb, (Executor) com.iqoption.core.d.a.aSe);
    }

    private final void i(s<com.iqoption.core.microservices.billing.response.deposit.b> sVar) {
        DepositPageFundsFragment$initDeposits$1 depositPageFundsFragment$initDeposits$1 = DepositPageFundsFragment$initDeposits$1.czc;
        ag.a((s) sVar, (Object) this, (com.iqoption.util.ag.f) f.czd, (com.iqoption.util.ag.b) g.cze, (Executor) com.iqoption.core.d.a.aSe);
    }

    private final void g(boolean z, boolean z2) {
        gt gtVar;
        RelativeLayout relativeLayout;
        ImageView imageView;
        Switch switchR;
        if (z) {
            gtVar = this.cyR;
            if (gtVar == null) {
                kotlin.jvm.internal.h.lS("binding");
            }
            relativeLayout = gtVar.bpa;
            kotlin.jvm.internal.h.d(relativeLayout, "binding.enable3dsContainer");
            relativeLayout.setVisibility(0);
            String bi = be.bi(getContext());
            if (kotlin.jvm.internal.h.E("hdpi", bi) || kotlin.jvm.internal.h.E("mdpi", bi)) {
                gtVar = this.cyR;
                if (gtVar == null) {
                    kotlin.jvm.internal.h.lS("binding");
                }
                imageView = gtVar.bpd;
                kotlin.jvm.internal.h.d(imageView, "binding.icon3dsQuestion");
                imageView.setVisibility(4);
                gtVar = this.cyR;
                if (gtVar == null) {
                    kotlin.jvm.internal.h.lS("binding");
                }
                imageView = gtVar.bpe;
                kotlin.jvm.internal.h.d(imageView, "binding.icon3dsQuestionSmall");
                imageView.setVisibility(0);
            } else {
                gtVar = this.cyR;
                if (gtVar == null) {
                    kotlin.jvm.internal.h.lS("binding");
                }
                imageView = gtVar.bpe;
                kotlin.jvm.internal.h.d(imageView, "binding.icon3dsQuestionSmall");
                imageView.setVisibility(4);
                gtVar = this.cyR;
                if (gtVar == null) {
                    kotlin.jvm.internal.h.lS("binding");
                }
                imageView = gtVar.bpd;
                kotlin.jvm.internal.h.d(imageView, "binding.icon3dsQuestion");
                imageView.setVisibility(0);
            }
            gtVar = this.cyR;
            if (gtVar == null) {
                kotlin.jvm.internal.h.lS("binding");
            }
            switchR = gtVar.bpb;
            kotlin.jvm.internal.h.d(switchR, "binding.enable3dsSwitch");
            switchR.setChecked(z2);
            return;
        }
        gtVar = this.cyR;
        if (gtVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        relativeLayout = gtVar.bpa;
        kotlin.jvm.internal.h.d(relativeLayout, "binding.enable3dsContainer");
        relativeLayout.setVisibility(8);
        gtVar = this.cyR;
        if (gtVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        switchR = gtVar.bpb;
        kotlin.jvm.internal.h.d(switchR, "binding.enable3dsSwitch");
        switchR.setChecked(false);
        gtVar = this.cyR;
        if (gtVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        imageView = gtVar.bpe;
        kotlin.jvm.internal.h.d(imageView, "binding.icon3dsQuestionSmall");
        imageView.setVisibility(8);
        gtVar = this.cyR;
        if (gtVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        imageView = gtVar.bpd;
        kotlin.jvm.internal.h.d(imageView, "binding.icon3dsQuestion");
        imageView.setVisibility(8);
    }
}
