package com.iqoption.vip;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.arch.lifecycle.Observer;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.plus.PlusShare;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import com.iqoption.analytics.r;
import com.iqoption.d.tz;
import com.iqoption.fragment.dialog.popup.PopupViewModel;
import com.iqoption.microservice.vip.VipManagerDeserializer;
import com.iqoption.util.Status;
import com.iqoption.util.ba;
import com.iqoption.util.m;
import com.iqoption.x.R;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;

@kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0001'B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0014\u001a\u00020\u0007H\u0016J&\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0016J\b\u0010 \u001a\u00020\u001eH\u0016J\u001a\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\f2\b\u0010#\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010$\u001a\u00020\u001e2\b\u0010%\u001a\u0004\u0018\u00010&H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\nX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000¨\u0006("}, aXE = {"Lcom/iqoption/vip/RequestCallFragment;", "Lcom/iqoption/fragment/base/IQAnimationFragment;", "Lcom/iqoption/vip/ChooseTimeFragment$OnWorkingPeriodSelected;", "()V", "binding", "Lcom/iqoption/databinding/FragmentVipRequestCallBinding;", "isRequestCallDialog", "", "()Z", "popUp", "Lkotlin/Lazy;", "selectedDate", "", "selectedPeriod", "Lcom/iqoption/vip/WorkingPeriod;", "sessionId", "showEvent", "Lcom/iqoption/core/analytics/AnalyticsSendEvent;", "viewModel", "Lcom/iqoption/vip/VipManagerViewModel;", "onClose", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "", "onHideAnimation", "onShowAnimation", "onWorkingPeriodSelected", "date", "period", "requestCall", "time", "", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: RequestCallFragment.kt */
public final class e extends com.iqoption.fragment.base.b implements com.iqoption.vip.c.b {
    private static final String TAG = "javaClass";
    public static final a dLc = new a();
    private HashMap atz;
    private VipManagerViewModel dKL;
    private long dKV;
    private final kotlin.d<Long> dKY = g.f(new RequestCallFragment$sessionId$1(this));
    private final kotlin.d<Boolean> dKZ = g.f(new RequestCallFragment$popUp$1(this));
    private tz dLa;
    private j dLb;
    private com.iqoption.core.a.d dez;

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\u00020\u00048\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\t\u0010\u0002¨\u0006\u0012"}, aXE = {"Lcom/iqoption/vip/RequestCallFragment$Companion;", "", "()V", "EXTRA_POP_UP", "", "EXTRA_SESSION_ID", "NO_SESSION", "", "TAG", "TAG$annotations", "show", "", "activity", "Landroid/support/v4/app/FragmentActivity;", "sessionId", "popUp", "", "showPopup", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: RequestCallFragment.kt */
    public static final class a {

        @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
        /* compiled from: RequestCallFragment.kt */
        static final class a implements Runnable {
            final /* synthetic */ FragmentActivity dpx;

            a(FragmentActivity fragmentActivity) {
                this.dpx = fragmentActivity;
            }

            public final void run() {
                e.dLc.a(this.dpx, -1, true);
            }
        }

        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public static /* bridge */ /* synthetic */ void a(a aVar, FragmentActivity fragmentActivity, long j, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                j = -1;
            }
            if ((i & 4) != 0) {
                z = false;
            }
            aVar.a(fragmentActivity, j, z);
        }

        public final void a(FragmentActivity fragmentActivity, long j, boolean z) {
            kotlin.jvm.internal.h.e(fragmentActivity, "activity");
            FragmentTransaction beginTransaction = fragmentActivity.getSupportFragmentManager().beginTransaction();
            e eVar = new e();
            Bundle bundle = new Bundle();
            bundle.putLong("extra_session", j);
            bundle.putBoolean("extra_pop_up", z);
            eVar.setArguments(bundle);
            beginTransaction.add(R.id.fragment, eVar, e.TAG).addToBackStack(e.TAG).commitAllowingStateLoss();
        }

        public final void I(FragmentActivity fragmentActivity) {
            kotlin.jvm.internal.h.e(fragmentActivity, "activity");
            PopupViewModel.cBp.j(fragmentActivity).a((Runnable) new a(fragmentActivity), e.TAG);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: RequestCallFragment.kt */
    static final class b implements OnClickListener {
        final /* synthetic */ e this$0;

        b(e eVar) {
            this.this$0 = eVar;
        }

        public final void onClick(View view) {
            if (this.this$0.aKr()) {
                r.ajo.BU();
            } else {
                r.ajo.Cc();
            }
            this.this$0.onClose();
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: RequestCallFragment.kt */
    static final class c implements OnClickListener {
        final /* synthetic */ e this$0;

        c(e eVar) {
            this.this$0 = eVar;
        }

        public final void onClick(View view) {
            if (this.this$0.aKr()) {
                r.ajo.BV();
            } else {
                r.ajo.Cd();
            }
            this.this$0.onClose();
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: RequestCallFragment.kt */
    static final class d implements OnClickListener {
        final /* synthetic */ e this$0;

        d(e eVar) {
            this.this$0 = eVar;
        }

        public final void onClick(View view) {
            j b = this.this$0.dLb;
            if (b == null) {
                e eVar = this.this$0;
                VipManagerViewModel c = e.c(this.this$0);
                Calendar instance = Calendar.getInstance();
                kotlin.jvm.internal.h.d(instance, "Calendar.getInstance()");
                Date time = instance.getTime();
                kotlin.jvm.internal.h.d(time, "Calendar.getInstance().time");
                eVar.kh(c.h(time));
                return;
            }
            this.this$0.kh(e.c(this.this$0).e(this.this$0.dKV, b));
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: RequestCallFragment.kt */
    static final class e implements OnClickListener {
        final /* synthetic */ e this$0;

        e(e eVar) {
            this.this$0 = eVar;
        }

        public final void onClick(View view) {
            if (this.this$0.aKr()) {
                r.ajo.BW();
            } else {
                r.ajo.Ce();
            }
            com.iqoption.vip.c.a aVar = c.dKW;
            FragmentActivity activity = this.this$0.zzakw();
            if (activity == null) {
                kotlin.jvm.internal.h.aXZ();
            }
            kotlin.jvm.internal.h.d(activity, "activity!!");
            aVar.u(activity);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
    /* compiled from: RequestCallFragment.kt */
    static final class g implements AnimatorUpdateListener {
        final /* synthetic */ ArgbEvaluator dLd;
        final /* synthetic */ e this$0;

        g(e eVar, ArgbEvaluator argbEvaluator) {
            this.this$0 = eVar;
            this.dLd = argbEvaluator;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (((Boolean) this.this$0.dKZ.getValue()).booleanValue()) {
                FrameLayout frameLayout = e.e(this.this$0).bFR;
                ArgbEvaluator argbEvaluator = this.dLd;
                kotlin.jvm.internal.h.d(valueAnimator, "it");
                Object evaluate = argbEvaluator.evaluate(valueAnimator.getAnimatedFraction(), Integer.valueOf(-1476395008), Integer.valueOf(0));
                if (evaluate == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
                }
                frameLayout.setBackgroundColor(((Integer) evaluate).intValue());
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "valueAnimator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
    /* compiled from: RequestCallFragment.kt */
    static final class h implements AnimatorUpdateListener {
        final /* synthetic */ LayoutParams dKX;
        final /* synthetic */ e this$0;

        h(e eVar, LayoutParams layoutParams) {
            this.this$0 = eVar;
            this.dKX = layoutParams;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (this.this$0.isAdded()) {
                kotlin.jvm.internal.h.d(valueAnimator, "valueAnimator");
                Object animatedValue = valueAnimator.getAnimatedValue();
                if (animatedValue == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
                }
                this.dKX.width = ((Integer) animatedValue).intValue();
                LinearLayout linearLayout = e.e(this.this$0).bFT;
                kotlin.jvm.internal.h.d(linearLayout, "binding.main");
                linearLayout.setLayoutParams(this.dKX);
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0010\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/util/Resource;", "Lcom/iqoption/microservice/vip/VipManager;", "onChanged"})
    /* compiled from: RequestCallFragment.kt */
    static final class f<T> implements Observer<ba<com.iqoption.microservice.vip.d>> {
        final /* synthetic */ e this$0;

        f(e eVar) {
            this.this$0 = eVar;
        }

        /* renamed from: c */
        public final void onChanged(ba<com.iqoption.microservice.vip.d> baVar) {
            if ((baVar != null ? baVar.aGv() : null) == Status.SUCCESS) {
                com.iqoption.microservice.vip.d dVar = (com.iqoption.microservice.vip.d) baVar.getData();
                if (dVar != null) {
                    tz e = e.e(this.this$0);
                    TextView textView = e.bGf;
                    kotlin.jvm.internal.h.d(textView, "workingHours");
                    textView.setText(TextUtils.join("; ", dVar.atp()));
                    if (TextUtils.isEmpty(dVar.atj())) {
                        TextView textView2 = e.bGc;
                        kotlin.jvm.internal.h.d(textView2, "managerPhone");
                        textView2.setText("");
                        return;
                    }
                    PhoneNumberUtil xo = PhoneNumberUtil.xo();
                    PhoneNumber b = xo.b((CharSequence) dVar.atj(), "CY");
                    TextView textView3 = e.bGc;
                    kotlin.jvm.internal.h.d(textView3, "managerPhone");
                    textView3.setText(xo.a(b, PhoneNumberFormat.INTERNATIONAL));
                }
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/util/Resource;", "Ljava/lang/Void;", "onChanged"})
    /* compiled from: RequestCallFragment.kt */
    static final class i<T> implements Observer<ba<Void>> {
        final /* synthetic */ e this$0;

        i(e eVar) {
            this.this$0 = eVar;
        }

        /* renamed from: c */
        public final void onChanged(ba<Void> baVar) {
            if (baVar != null) {
                switch (f.aoS[baVar.aGv().ordinal()]) {
                    case 1:
                        if (this.this$0.aKr()) {
                            r.ajo.aB(true);
                        } else {
                            r.ajo.aC(true);
                        }
                        com.iqoption.app.a.b.cV(R.string.wait_for_a_call);
                        this.this$0.onClose();
                        return;
                    case 2:
                        if (this.this$0.aKr()) {
                            r.ajo.aB(false);
                        } else {
                            r.ajo.aC(false);
                        }
                        if (baVar.getMessage() == null) {
                            com.iqoption.app.a.b.FG();
                            return;
                        } else {
                            com.iqoption.app.a.b.eQ(baVar.getMessage());
                            return;
                        }
                    case 3:
                        return;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            }
        }
    }

    public void KH() {
        if (this.atz != null) {
            this.atz.clear();
        }
    }

    public static final /* synthetic */ VipManagerViewModel c(e eVar) {
        VipManagerViewModel vipManagerViewModel = eVar.dKL;
        if (vipManagerViewModel == null) {
            kotlin.jvm.internal.h.lS("viewModel");
        }
        return vipManagerViewModel;
    }

    public static final /* synthetic */ tz e(e eVar) {
        tz tzVar = eVar.dLa;
        if (tzVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        return tzVar;
    }

    private final boolean aKr() {
        return ((Number) this.dKY.getValue()).longValue() == -1;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String stringBuilder;
        kotlin.jvm.internal.h.e(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_vip_request_call, viewGroup, false);
        kotlin.jvm.internal.h.d(inflate, "DataBindingUtil.inflate(…t_call, container, false)");
        this.dLa = (tz) inflate;
        com.iqoption.vip.VipManagerViewModel.b bVar = VipManagerViewModel.dLy;
        FragmentActivity activity = zzakw();
        if (activity == null) {
            kotlin.jvm.internal.h.aXZ();
        }
        kotlin.jvm.internal.h.d(activity, "activity!!");
        this.dKL = bVar.J(activity);
        int aGd = m.aGd();
        tz tzVar = this.dLa;
        if (tzVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        TextView textView = tzVar.bGg;
        kotlin.jvm.internal.h.d(textView, "binding.workingHoursTitle");
        Object[] objArr = new Object[1];
        if (aGd >= 0) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append('+');
            stringBuilder2.append(aGd);
            stringBuilder = stringBuilder2.toString();
        } else {
            stringBuilder = String.valueOf(aGd);
        }
        objArr[0] = stringBuilder;
        textView.setText(getString(R.string.working_hours_n1, objArr));
        tz tzVar2 = this.dLa;
        if (tzVar2 == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        tzVar2.blw.setOnClickListener(new b(this));
        tzVar2 = this.dLa;
        if (tzVar2 == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        tzVar2.bFS.setOnClickListener(new c(this));
        tzVar2 = this.dLa;
        if (tzVar2 == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        tzVar2.bFQ.setOnClickListener(new d(this));
        tzVar2 = this.dLa;
        if (tzVar2 == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        tzVar2.bGd.setOnClickListener(new e(this));
        VipManagerViewModel vipManagerViewModel = this.dKL;
        if (vipManagerViewModel == null) {
            kotlin.jvm.internal.h.lS("viewModel");
        }
        vipManagerViewModel.aKv().observe(this, new f(this));
        TextView textView2;
        if (aKr()) {
            this.dez = r.ajo.BO();
            tzVar2 = this.dLa;
            if (tzVar2 == null) {
                kotlin.jvm.internal.h.lS("binding");
            }
            textView = tzVar2.agA;
            kotlin.jvm.internal.h.d(textView, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
            textView.setText(getString(R.string.request_a_call));
            textView2 = tzVar2.bFQ;
            kotlin.jvm.internal.h.d(textView2, "actionButton");
            textView2.setText(getString(R.string.request_a_call));
        } else {
            this.dez = r.ajo.BR();
            tzVar2 = this.dLa;
            if (tzVar2 == null) {
                kotlin.jvm.internal.h.lS("binding");
            }
            textView = tzVar2.agA;
            kotlin.jvm.internal.h.d(textView, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
            textView.setText(getString(R.string.arrange_your_training_session));
            textView2 = tzVar2.bFQ;
            kotlin.jvm.internal.h.d(textView2, "actionButton");
            textView2.setText(getString(R.string.schedule_session));
        }
        tzVar2 = this.dLa;
        if (tzVar2 == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        return tzVar2.getRoot();
    }

    public void onDestroyView() {
        com.iqoption.core.a.d dVar = this.dez;
        if (dVar != null) {
            dVar.Bs();
        }
        super.onDestroyView();
        KH();
    }

    public void a(long j, j jVar) {
        this.dKV = j;
        this.dLb = jVar;
        if (jVar == null) {
            tz tzVar = this.dLa;
            if (tzVar == null) {
                kotlin.jvm.internal.h.lS("binding");
            }
            tzVar.bGa.setText(R.string.as_soon_as_possible);
            return;
        }
        String format = VipManagerDeserializer.cgq.format(new Date(j));
        kotlin.jvm.internal.m mVar = kotlin.jvm.internal.m.euz;
        Locale locale = Locale.US;
        kotlin.jvm.internal.h.d(locale, "Locale.US");
        Object[] objArr = new Object[]{VipManagerDeserializer.cTi.format(jVar.getStartDate()), VipManagerDeserializer.cTi.format(jVar.getEndDate())};
        kotlin.jvm.internal.h.d(String.format(locale, "%s - %s", Arrays.copyOf(objArr, objArr.length)), "java.lang.String.format(locale, format, *args)");
        tz tzVar2 = this.dLa;
        if (tzVar2 == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        TextView textView = tzVar2.bGa;
        kotlin.jvm.internal.h.d(textView, "binding.callTime");
        kotlin.jvm.internal.m mVar2 = kotlin.jvm.internal.m.euz;
        Locale locale2 = Locale.US;
        kotlin.jvm.internal.h.d(locale2, "Locale.US");
        Object[] objArr2 = new Object[]{format, r7};
        format = String.format(locale2, "%s, %s", Arrays.copyOf(objArr2, objArr2.length));
        kotlin.jvm.internal.h.d(format, "java.lang.String.format(locale, format, *args)");
        textView.setText(format);
    }

    private final void kh(String str) {
        VipManagerViewModel vipManagerViewModel = this.dKL;
        if (vipManagerViewModel == null) {
            kotlin.jvm.internal.h.lS("viewModel");
        }
        vipManagerViewModel.a(getContext(), str, aKr() ? null : (Long) this.dKY.getValue()).observe(this, new i(this));
    }

    public void ND() {
        tz tzVar = this.dLa;
        if (tzVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        LinearLayout linearLayout = tzVar.bFT;
        kotlin.jvm.internal.h.d(linearLayout, "binding.main");
        linearLayout.setAlpha(0.0f);
        tzVar = this.dLa;
        if (tzVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(tzVar.bFT, "alpha", new float[]{1.0f});
        kotlin.jvm.internal.h.d(ofFloat, "contentAlphaAnimation");
        ofFloat.setInterpolator(com.iqoption.view.a.a.d.dEM);
        ofFloat.setDuration(300);
        tz tzVar2 = this.dLa;
        if (tzVar2 == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        View root = tzVar2.getRoot();
        kotlin.jvm.internal.h.d(root, "binding.root");
        int width = root.getWidth();
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.dp450);
        tz tzVar3 = this.dLa;
        if (tzVar3 == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        LinearLayout linearLayout2 = tzVar3.bFT;
        kotlin.jvm.internal.h.d(linearLayout2, "binding.main");
        LayoutParams layoutParams = linearLayout2.getLayoutParams();
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{width, dimensionPixelOffset});
        ofInt.addUpdateListener(new h(this, layoutParams));
        kotlin.jvm.internal.h.d(ofInt, "widthAnimateStep");
        ofInt.setDuration(400);
        ofInt.setInterpolator(com.iqoption.view.a.a.d.dEM);
        AnimatorSet animatorSet = new AnimatorSet();
        if (((Boolean) this.dKZ.getValue()).booleanValue()) {
            ValueAnimator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(0), Integer.valueOf(-1476395008)});
            tz tzVar4 = this.dLa;
            if (tzVar4 == null) {
                kotlin.jvm.internal.h.lS("binding");
            }
            ofObject.addUpdateListener(new com.iqoption.view.a.a.a(tzVar4.bFR));
            kotlin.jvm.internal.h.d(ofObject, "backgroundColorAnimator");
            ofObject.setInterpolator(com.iqoption.view.a.a.d.dEM);
            ofObject.setDuration(400);
            animatorSet.playTogether(new Animator[]{ofInt, ofFloat, ofObject});
        } else {
            animatorSet.playTogether(new Animator[]{ofInt, ofFloat});
        }
        animatorSet.start();
    }

    public void NE() {
        ArgbEvaluator argbEvaluator = new ArgbEvaluator();
        tz tzVar = this.dLa;
        if (tzVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        tzVar.bFT.animate().alpha(0.0f).scaleY(1.7f).scaleX(1.7f).setDuration(300).setInterpolator(com.iqoption.view.a.a.d.dEM).setUpdateListener(new g(this, argbEvaluator)).start();
    }

    public boolean onClose() {
        com.iqoption.core.ext.a.p(this).popBackStack();
        PopupViewModel.cBp.j(com.iqoption.core.ext.a.n(this)).hO(TAG);
        return true;
    }
}
