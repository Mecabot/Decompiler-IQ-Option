package com.iqoption.gdpr.removal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.iqoption.app.IQApp;
import com.iqoption.core.microservices.busapi.response.ForgetUserStatus;
import com.iqoption.d.jd;
import com.iqoption.fragment.dialog.popup.PopupViewModel;
import com.iqoption.popup.PopupPriority;
import com.iqoption.util.bg;
import com.iqoption.x.R;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import kotlin.i;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0011\u0018\u0000 12\u00020\u00012\u00020\u0002:\u0003123B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J&\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020#H\u0016J\b\u0010%\u001a\u00020#H\u0016J\b\u0010&\u001a\u00020#H\u0016J\b\u0010'\u001a\u00020#H\u0016J\u001a\u0010(\u001a\u00020#2\u0006\u0010)\u001a\u00020\u001b2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010*\u001a\u00020#H\u0002J\b\u0010+\u001a\u00020#H\u0002J\u0010\u0010,\u001a\u00020#2\u0006\u0010-\u001a\u00020\u0018H\u0002J\b\u0010.\u001a\u00020#H\u0002J\b\u0010/\u001a\u00020#H\u0002J\b\u00100\u001a\u00020#H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R#\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\r8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X.¢\u0006\u0002\n\u0000¨\u00064"}, aXE = {"Lcom/iqoption/gdpr/removal/PendingRemovalDialog;", "Lcom/iqoption/fragment/base/IQAnimationFragment;", "Lcom/iqoption/view/BackController$OnBackListener;", "()V", "analytics", "Lcom/iqoption/core/analytics/IQAnalytics;", "binding", "Lcom/iqoption/databinding/DialogPendingRemovalBinding;", "dateFormat", "Ljava/text/SimpleDateFormat;", "eventHandler", "Lcom/iqoption/gdpr/removal/PendingRemovalDialog$EventHandler;", "forgetUserData", "Lcom/iqoption/core/microservices/busapi/response/ForgetUserData;", "kotlin.jvm.PlatformType", "getForgetUserData", "()Lcom/iqoption/core/microservices/busapi/response/ForgetUserData;", "forgetUserData$delegate", "Lkotlin/Lazy;", "popupServedEvent", "Lcom/iqoption/core/analytics/AnalyticsSendEvent;", "viewModel", "Lcom/iqoption/gdpr/removal/PendingRemovalViewModel;", "onBackPressed", "", "onClose", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "", "onHideAnimation", "onPause", "onResume", "onShowAnimation", "onViewCreated", "view", "performCancel", "setCancelButton", "setCancelButtonState", "progress", "setText", "setTextBottom", "showBouncing", "Companion", "EventHandler", "OnPendingRemovalCloseListener", "IqOption-5.5.1_optionXRelease"})
/* compiled from: PendingRemovalDialog.kt */
public final class a extends com.iqoption.fragment.base.b implements com.iqoption.view.e.a {
    private static final String TAG = "com.iqoption.gdpr.removal.a";
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(a.class), "forgetUserData", "getForgetUserData()Lcom/iqoption/core/microservices/busapi/response/ForgetUserData;"))};
    public static final a cIs = new a();
    private com.iqoption.core.a.e aMD;
    private HashMap atz;
    private jd cIn;
    private PendingRemovalViewModel cIo;
    private final b cIp = new b(this);
    private final kotlin.d cIq = g.f(new PendingRemovalDialog$forgetUserData$2(this));
    private com.iqoption.core.a.d cIr;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy", Locale.getDefault());

    @i(aXC = {1, 1, 11}, aXD = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, aXE = {"Lcom/iqoption/gdpr/removal/PendingRemovalDialog$Companion;", "", "()V", "ARG_FORGET_USER_DATA", "", "TAG", "show", "", "fm", "Landroid/support/v4/app/FragmentManager;", "forgetUserData", "Lcom/iqoption/core/microservices/busapi/response/ForgetUserData;", "tryShow", "", "activity", "Landroid/support/v4/app/FragmentActivity;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: PendingRemovalDialog.kt */
    public static final class a {

        @i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
        /* compiled from: PendingRemovalDialog.kt */
        static final class a implements Runnable {
            final /* synthetic */ FragmentManager cBh;
            final /* synthetic */ com.iqoption.core.microservices.busapi.response.a cIt;

            a(FragmentManager fragmentManager, com.iqoption.core.microservices.busapi.response.a aVar) {
                this.cBh = fragmentManager;
                this.cIt = aVar;
            }

            public final void run() {
                a aVar = a.cIs;
                FragmentManager fragmentManager = this.cBh;
                kotlin.jvm.internal.h.d(fragmentManager, "fm");
                aVar.a(fragmentManager, this.cIt);
            }
        }

        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final void b(FragmentActivity fragmentActivity, com.iqoption.core.microservices.busapi.response.a aVar) {
            kotlin.jvm.internal.h.e(fragmentActivity, "activity");
            kotlin.jvm.internal.h.e(aVar, "forgetUserData");
            FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            PopupViewModel j = PopupViewModel.cBp.j(fragmentActivity);
            if (!j.hP(a.TAG)) {
                j.a((Runnable) new a(supportFragmentManager, aVar), a.TAG, PopupPriority.VERY_HIGH);
            }
        }

        private final boolean a(FragmentManager fragmentManager, com.iqoption.core.microservices.busapi.response.a aVar) {
            a aVar2 = new a();
            Bundle bundle = new Bundle();
            bundle.putParcelable("ARG_FORGET_USER_DATA", aVar);
            aVar2.setArguments(bundle);
            fragmentManager.beginTransaction().replace(R.id.other_fragment, aVar2, a.TAG).addToBackStack(a.TAG).commitAllowingStateLoss();
            return true;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, aXE = {"Lcom/iqoption/gdpr/removal/PendingRemovalDialog$OnPendingRemovalCloseListener;", "", "onPendingRemovalClose", "", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: PendingRemovalDialog.kt */
    public interface c {
        void aoo();
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, aXE = {"com/iqoption/gdpr/removal/PendingRemovalDialog$onHideAnimation$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: PendingRemovalDialog.kt */
    public static final class d extends AnimatorListenerAdapter {
        final /* synthetic */ a this$0;

        d(a aVar) {
            this.this$0 = aVar;
        }

        public void onAnimationEnd(Animator animator) {
            FragmentActivity activity = this.this$0.zzakw();
            if (!(activity instanceof c)) {
                activity = null;
            }
            c cVar = (c) activity;
            if (cVar != null) {
                cVar.aoo();
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: PendingRemovalDialog.kt */
    static final class e implements OnClickListener {
        final /* synthetic */ a this$0;

        e(a aVar) {
            this.this$0 = aVar;
        }

        public final void onClick(View view) {
            this.this$0.aey();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: PendingRemovalDialog.kt */
    static final class h implements OnClickListener {
        final /* synthetic */ a this$0;

        h(a aVar) {
            this.this$0 = aVar;
        }

        public final void onClick(View view) {
            a.b(this.this$0).dV("account-is-blocked_cancel-block");
            this.this$0.dH(true);
            this.this$0.aos();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
    /* compiled from: PendingRemovalDialog.kt */
    static final class f implements io.reactivex.c.a {
        final /* synthetic */ a this$0;

        f(a aVar) {
            this.this$0 = aVar;
        }

        public final void run() {
            this.this$0.onClose();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "error", "", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: PendingRemovalDialog.kt */
    static final class g<T> implements io.reactivex.c.e<Throwable> {
        public static final g cIw = new g();

        g() {
        }

        /* renamed from: o */
        public final void accept(Throwable th) {
            com.iqoption.core.i.e("Unable to cancel removal", th);
            com.iqoption.app.a.b.FG();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, aXE = {"Lcom/iqoption/gdpr/removal/PendingRemovalDialog$EventHandler;", "Lcom/iqoption/system/event/EventHandlerBaseT;", "Lcom/iqoption/gdpr/removal/PendingRemovalDialog;", "ref", "(Lcom/iqoption/gdpr/removal/PendingRemovalDialog;)V", "onForgetUserDataChanged", "", "event", "Lcom/iqoption/app/events/IQAccountEvents$ForgetUserDataChanged;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: PendingRemovalDialog.kt */
    private static final class b extends com.iqoption.system.a.e<a> {

        @i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
        /* compiled from: PendingRemovalDialog.kt */
        static final class a implements Runnable {
            final /* synthetic */ b cIu;
            final /* synthetic */ com.iqoption.app.b.b.h cIv;

            a(b bVar, com.iqoption.app.b.b.h hVar) {
                this.cIu = bVar;
                this.cIv = hVar;
            }

            public final void run() {
                a aVar = (a) this.cIu.drU.get();
                if (aVar != null && !aVar.isAdded()) {
                    com.iqoption.core.microservices.busapi.response.a aVar2 = (com.iqoption.core.microservices.busapi.response.a) this.cIv.getValue();
                    if (aVar2 != null && aVar2.Vr() == ForgetUserStatus.WAITING) {
                        aVar.onClose();
                    }
                }
            }
        }

        public b(a aVar) {
            kotlin.jvm.internal.h.e(aVar, "ref");
            super(aVar);
        }

        @com.google.common.b.e
        public final void onForgetUserDataChanged(com.iqoption.app.b.b.h hVar) {
            kotlin.jvm.internal.h.e(hVar, "event");
            com.iqoption.core.d.a.aSe.execute(new a(this, hVar));
        }
    }

    private final com.iqoption.core.microservices.busapi.response.a CV() {
        kotlin.d dVar = this.cIq;
        j jVar = apP[0];
        return (com.iqoption.core.microservices.busapi.response.a) dVar.getValue();
    }

    public static final void b(FragmentActivity fragmentActivity, com.iqoption.core.microservices.busapi.response.a aVar) {
        cIs.b(fragmentActivity, aVar);
    }

    public void KH() {
        if (this.atz != null) {
            this.atz.clear();
        }
    }

    public static final /* synthetic */ com.iqoption.core.a.e b(a aVar) {
        com.iqoption.core.a.e eVar = aVar.aMD;
        if (eVar == null) {
            kotlin.jvm.internal.h.lS("analytics");
        }
        return eVar;
    }

    static {
        if (a.class.getName() == null) {
            kotlin.jvm.internal.h.aXZ();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.h.e(layoutInflater, "inflater");
        this.cIn = (jd) com.iqoption.core.ext.a.a((Fragment) this, (int) R.layout.dialog_pending_removal, viewGroup, false, 4, null);
        jd jdVar = this.cIn;
        if (jdVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        return jdVar.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.h.e(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        com.iqoption.core.a.e Ds = IQApp.Dk().Ds();
        kotlin.jvm.internal.h.d(Ds, "IQApp.instance().analytics");
        this.aMD = Ds;
        PendingRemovalViewModel o = PendingRemovalViewModel.cIx.o(com.iqoption.core.ext.a.n(this));
        kotlin.jvm.internal.h.d(o, "PendingRemovalViewModel.create(act)");
        this.cIo = o;
        jd jdVar = this.cIn;
        if (jdVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        jdVar.bjF.setOnClickListener(new e(this));
        aop();
        aoq();
        aor();
        Ds = this.aMD;
        if (Ds == null) {
            kotlin.jvm.internal.h.lS("analytics");
        }
        this.cIr = Ds.dY("account-is-blocked_show");
    }

    public void onResume() {
        super.onResume();
        this.cIp.register();
    }

    public void onPause() {
        this.cIp.unregister();
        super.onPause();
    }

    public void onDestroyView() {
        com.iqoption.core.a.d dVar = this.cIr;
        if (dVar != null) {
            dVar.Bs();
        }
        super.onDestroyView();
        KH();
    }

    private final void aop() {
        jd jdVar = this.cIn;
        if (jdVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        TextView textView = jdVar.btm;
        Date date = new Date(CV().Vs() * ((long) 1000));
        kotlin.jvm.internal.h.d(textView, "textView");
        textView.setText(getString(R.string.on_n1_you_requested_the_removal, this.dateFormat.format(date)));
    }

    private final void aoq() {
        jd jdVar = this.cIn;
        if (jdVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        TextView textView = jdVar.btn;
        Date date = new Date(CV().Vt() * ((long) 1000));
        kotlin.jvm.internal.h.d(textView, "textView");
        textView.setText(getString(R.string.your_account_will_be_blocked_n1, this.dateFormat.format(date)));
    }

    private final void aor() {
        jd jdVar = this.cIn;
        if (jdVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        jdVar.btj.setOnClickListener(new h(this));
    }

    private final void aos() {
        PendingRemovalViewModel pendingRemovalViewModel = this.cIo;
        if (pendingRemovalViewModel == null) {
            kotlin.jvm.internal.h.lS("viewModel");
        }
        a(pendingRemovalViewModel.aou().a(new f(this), g.cIw));
    }

    private final void dH(boolean z) {
        jd jdVar = this.cIn;
        if (jdVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        TextView textView = jdVar.btj;
        kotlin.jvm.internal.h.d(textView, "binding.pendingRemovalCancel");
        textView.setEnabled(z ^ 1);
        jd jdVar2;
        if (z) {
            jdVar2 = this.cIn;
            if (jdVar2 == null) {
                kotlin.jvm.internal.h.lS("binding");
            }
            jdVar2.btk.show();
            return;
        }
        jdVar2 = this.cIn;
        if (jdVar2 == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        jdVar2.btk.hide();
    }

    public boolean onBackPressed() {
        aey();
        return true;
    }

    public boolean onClose() {
        com.iqoption.core.ext.a.p(this).popBackStack();
        com.iqoption.core.ext.a.p(this).executePendingTransactions();
        PopupViewModel.cBp.j(com.iqoption.core.ext.a.n(this)).hO(TAG);
        return true;
    }

    private final void aey() {
        Context context = getContext();
        if (context == null) {
            kotlin.jvm.internal.h.aXZ();
        }
        int bQ = com.iqoption.util.b.bQ(context);
        jd jdVar = this.cIn;
        if (jdVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        com.iqoption.util.b.o(jdVar.btl, bQ);
    }

    public void ND() {
        jd jdVar = this.cIn;
        if (jdVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        Animator c = com.iqoption.view.a.a.a.c(jdVar.bjF, bg.getColor(R.color.transparent), bg.getColor(R.color.black_66));
        kotlin.jvm.internal.h.d(c, "background");
        c.setInterpolator(com.iqoption.view.a.a.d.dEM);
        jd jdVar2 = this.cIn;
        if (jdVar2 == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(jdVar2.btl, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{0.4f, 1.0f}), PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{0.4f, 1.0f})});
        kotlin.jvm.internal.h.d(ofPropertyValuesHolder, "popup");
        ofPropertyValuesHolder.setInterpolator(new OvershootInterpolator(2.5f));
        jd jdVar3 = this.cIn;
        if (jdVar3 == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(jdVar3.btl, View.ALPHA, new float[]{0.0f, 1.0f});
        kotlin.jvm.internal.h.d(ofFloat, "alphaPopup");
        ofFloat.setInterpolator(com.iqoption.view.a.a.d.dEM);
        AnimatorSet animatorSet = new AnimatorSet();
        com.iqoption.util.b.a(animatorSet, getAnimationDuration());
        animatorSet.playTogether(new Animator[]{c, ofPropertyValuesHolder, ofFloat});
        animatorSet.start();
    }

    public void NE() {
        jd jdVar = this.cIn;
        if (jdVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        Animator c = com.iqoption.view.a.a.a.c(jdVar.bjF, bg.getColor(R.color.black_66), bg.getColor(R.color.transparent));
        jd jdVar2 = this.cIn;
        if (jdVar2 == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        LinearLayout linearLayout = jdVar2.btl;
        r2 = new PropertyValuesHolder[3];
        r2[0] = PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{0.4f});
        r2[1] = PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{0.4f});
        r2[2] = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f});
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(linearLayout, r2);
        AnimatorSet animatorSet = new AnimatorSet();
        com.iqoption.util.b.a(animatorSet, getAnimationDuration());
        animatorSet.playTogether(new Animator[]{c, ofPropertyValuesHolder});
        animatorSet.setInterpolator(com.iqoption.view.a.a.d.dEM);
        animatorSet.addListener(new d(this));
        animatorSet.start();
    }
}
