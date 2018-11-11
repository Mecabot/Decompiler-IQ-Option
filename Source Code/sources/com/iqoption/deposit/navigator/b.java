package com.iqoption.deposit.navigator;

import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.iqoption.core.microservices.billing.response.deposit.PayMethod;
import com.iqoption.core.ui.navigation.e;
import com.iqoption.core.ui.navigation.j;
import com.iqoption.deposit.a.q;
import com.iqoption.deposit.p;
import com.iqoption.deposit.r.f;
import com.iqoption.deposit.r.g;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b&\u0018\u0000 A2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001AB\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u000eH\u0016J\u001c\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010j\n\u0012\u0004\u0012\u00020\u0011\u0018\u0001`\u0012H&J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\fH\u0016J\b\u0010\u0016\u001a\u00020\fH&J\b\u0010\u0017\u001a\u00020\fH&J\b\u0010\u0018\u001a\u00020\fH&J\b\u0010\u0019\u001a\u00020\nH\u0002J\u0012\u0010\u001a\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J&\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0018\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020\nH\u0016J\u0010\u0010(\u001a\u00020\f2\u0006\u0010)\u001a\u00020*H\u0016J\u001a\u0010+\u001a\u00020\n2\u0006\u0010,\u001a\u00020\u001e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010-\u001a\u00020\nH&J\u000f\u0010.\u001a\u0004\u0018\u00010/H&¢\u0006\u0002\u00100J0\u00101\u001a\u00020\n2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u00142\u0006\u00107\u001a\u00020\f2\u0006\u00108\u001a\u00020\u000eH\u0002J\b\u00109\u001a\u00020\fH&J\b\u0010:\u001a\u00020\fH&J\b\u0010;\u001a\u00020\fH&J\u0010\u0010<\u001a\u00020\n2\u0006\u0010=\u001a\u00020\fH&J\u0018\u0010>\u001a\u00020\n2\u0006\u0010?\u001a\u00020\f2\u0006\u0010@\u001a\u00020\fH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000¨\u0006B"}, aXE = {"Lcom/iqoption/deposit/navigator/DepositNavigatorFragment;", "Lcom/iqoption/core/ui/navigation/BaseStackNavigatorFragment;", "Lcom/iqoption/deposit/web/BaseRedirectWebPaymentFragment$OnFragmentInteractionListener;", "Lcom/iqoption/core/ui/fragment/FragmentNewIntent;", "()V", "binding", "Lcom/iqoption/deposit/databinding/FragmentDepositNavigatorBinding;", "viewModel", "Lcom/iqoption/deposit/navigator/DepositNavigatorViewModel;", "close", "", "isDepSucceed", "", "getContainerId", "", "getDepositPreset", "Ljava/util/ArrayList;", "Lcom/iqoption/core/features/limit/CurrencyValue;", "Lkotlin/collections/ArrayList;", "getInitialEntry", "Lcom/iqoption/core/ui/navigation/NavigatorEntry;", "handleBack", "hidePresetsByFeature", "isDarkDeposit", "isKycLimitEnabled", "observeSelectedMethodIfNeeded", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDepositPageWebPaymentResult", "isSuccess", "depositParams", "Lcom/iqoption/deposit/DepositParams;", "onDepositPageWebPaymentStartAgain", "onNewIntent", "intent", "Landroid/content/Intent;", "onViewCreated", "view", "openSupport", "paymentMethodId", "", "()Ljava/lang/Long;", "setupFragment", "fm", "Landroid/support/v4/app/FragmentManager;", "ft", "Landroid/support/v4/app/FragmentTransaction;", "navigationEntry", "show", "containerId", "shouldSelectFirstMethod", "shouldShowKycAfterDep", "shouldShowKycBeforeDep", "showKycBeforeDep", "particularMethodBlocked", "updateFragmentsVisibility", "showMethods", "showPerform", "Companion", "deposit_release"})
/* compiled from: DepositNavigatorFragment.kt */
public abstract class b extends e implements com.iqoption.core.ui.fragment.a, com.iqoption.deposit.web.a.b {
    private static final String TAG = "com.iqoption.deposit.navigator.b";
    public static final a cbG = new a();
    private HashMap atz;
    private q cbE;
    private DepositNavigatorViewModel cbF;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u0012\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bJ\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u0015J\u000e\u0010\u0016\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u0017\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u0018\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u0019\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\u001a\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\rR\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001c"}, aXE = {"Lcom/iqoption/deposit/navigator/DepositNavigatorFragment$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "closeDeposit", "", "child", "Landroid/support/v4/app/Fragment;", "isDepSucceed", "", "findInstance", "Lcom/iqoption/deposit/navigator/DepositNavigatorFragment;", "getNavigator", "Lcom/iqoption/core/ui/navigation/StackNavigator;", "hidePresetsByFeature", "initialMethodId", "", "(Landroid/support/v4/app/Fragment;)Ljava/lang/Long;", "isKycLimitEnabled", "openSupport", "shouldSelectFirstMethod", "shouldShowKycBeforeDep", "showKycBeforeDep", "particularMethodBlocked", "deposit_release"})
    /* compiled from: DepositNavigatorFragment.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final j G(Fragment fragment) {
            h.e(fragment, "child");
            return ((b) com.iqoption.core.ext.a.a(fragment, b.class)).b();
        }

        public final void a(Fragment fragment, boolean z) {
            h.e(fragment, "child");
            b N = N(fragment);
            FragmentActivity activity = N.zzakw();
            if (activity != null) {
                com.iqoption.core.util.j.n(activity);
            }
            N.close(z);
        }

        public final boolean H(Fragment fragment) {
            h.e(fragment, "child");
            return N(fragment).acp();
        }

        public final void b(Fragment fragment, boolean z) {
            h.e(fragment, "child");
            N(fragment).cw(z);
        }

        public final void I(Fragment fragment) {
            h.e(fragment, "child");
            N(fragment).abB();
        }

        public final boolean J(Fragment fragment) {
            h.e(fragment, "child");
            return N(fragment).abQ();
        }

        public final boolean K(Fragment fragment) {
            h.e(fragment, "child");
            return N(fragment).adp();
        }

        public final boolean L(Fragment fragment) {
            h.e(fragment, "child");
            return N(fragment).adO();
        }

        public final Long M(Fragment fragment) {
            h.e(fragment, "child");
            return N(fragment).adQ();
        }

        private final b N(Fragment fragment) {
            return (b) com.iqoption.core.ext.a.a(fragment, b.class);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "selectedMethod", "Lcom/iqoption/core/microservices/billing/response/deposit/PayMethod;", "onChanged"})
    /* compiled from: DepositNavigatorFragment.kt */
    static final class b<T> implements Observer<PayMethod> {
        final /* synthetic */ b cbH;

        b(b bVar) {
            this.cbH = bVar;
        }

        /* renamed from: h */
        public final void onChanged(PayMethod payMethod) {
            if (payMethod != null) {
                this.cbH.c(false, true);
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/core/ui/Resource;", "Lcom/iqoption/core/microservices/billing/response/deposit/CashboxCounting;", "onChanged"})
    /* compiled from: DepositNavigatorFragment.kt */
    static final class c<T> implements Observer<com.iqoption.core.ui.c<com.iqoption.core.microservices.billing.response.deposit.b>> {
        final /* synthetic */ b cbH;

        c(b bVar) {
            this.cbH = bVar;
        }

        /* JADX WARNING: Missing block: B:8:0x001e, code:
            if ((r0.isEmpty() ^ 1) == 1) goto L_0x0037;
     */
        /* JADX WARNING: Missing block: B:14:0x0035, code:
            if ((r0.isEmpty() ^ 1) == 1) goto L_0x0037;
     */
        /* JADX WARNING: Missing block: B:15:0x0037, code:
            com.iqoption.deposit.navigator.b.a(r2.cbH).a((com.iqoption.core.microservices.billing.response.deposit.b) r3.getData());
     */
        /* JADX WARNING: Missing block: B:22:?, code:
            return;
     */
        /* renamed from: a */
        public final void onChanged(com.iqoption.core.ui.c<com.iqoption.core.microservices.billing.response.deposit.b> r3) {
            /*
            r2 = this;
            if (r3 == 0) goto L_0x0047;
        L_0x0002:
            r0 = r3.isSuccess();
            r1 = 1;
            if (r0 != r1) goto L_0x0047;
        L_0x0009:
            r0 = r3.getData();
            r0 = (com.iqoption.core.microservices.billing.response.deposit.b) r0;
            if (r0 == 0) goto L_0x0020;
        L_0x0011:
            r0 = r0.UH();
            if (r0 == 0) goto L_0x0020;
        L_0x0017:
            r0 = (java.util.Collection) r0;
            r0 = r0.isEmpty();
            r0 = r0 ^ r1;
            if (r0 == r1) goto L_0x0037;
        L_0x0020:
            r0 = r3.getData();
            r0 = (com.iqoption.core.microservices.billing.response.deposit.b) r0;
            if (r0 == 0) goto L_0x0047;
        L_0x0028:
            r0 = r0.UG();
            if (r0 == 0) goto L_0x0047;
        L_0x002e:
            r0 = (java.util.Collection) r0;
            r0 = r0.isEmpty();
            r0 = r0 ^ r1;
            if (r0 != r1) goto L_0x0047;
        L_0x0037:
            r0 = r2.cbH;
            r0 = com.iqoption.deposit.navigator.b.a(r0);
            r3 = r3.getData();
            r3 = (com.iqoption.core.microservices.billing.response.deposit.b) r3;
            r0.a(r3);
            goto L_0x005e;
        L_0x0047:
            r0 = "Unable to load counting";
            r1 = 0;
            if (r3 == 0) goto L_0x0051;
        L_0x004c:
            r3 = r3.getThrowable();
            goto L_0x0052;
        L_0x0051:
            r3 = r1;
        L_0x0052:
            com.iqoption.core.i.e(r0, r3);
            r3 = r2.cbH;
            r3 = com.iqoption.deposit.navigator.b.a(r3);
            r3.a(r1);
        L_0x005e:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iqoption.deposit.navigator.b.c.a(com.iqoption.core.ui.c):void");
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "result", "Lcom/iqoption/deposit/navigator/WebPaymentResult;", "onChanged"})
    /* compiled from: DepositNavigatorFragment.kt */
    static final class d<T> implements Observer<d> {
        final /* synthetic */ b cbH;

        d(b bVar) {
            this.cbH = bVar;
        }

        /* renamed from: a */
        public final void onChanged(d dVar) {
            if (dVar instanceof a) {
                com.iqoption.core.ui.navigation.h a;
                a aVar = (a) dVar;
                String str = aVar.isSuccess() ? "deposit" : "error_deposit";
                if (this.cbH.aci()) {
                    a = com.iqoption.deposit.dark.b.a.a.a(com.iqoption.deposit.dark.b.a.bXP, str, aVar.adL().aaH(), aVar.adL().VZ(), null, 8, null);
                } else {
                    a = com.iqoption.deposit.light.b.a.a.a(com.iqoption.deposit.light.b.a.caF, str, aVar.adL().aaH(), aVar.adL().VZ(), null, 8, null);
                }
                this.cbH.b().pop();
                j.a(this.cbH.b(), a, false, 2, null);
            } else if (dVar instanceof c) {
                this.cbH.b().pop();
            }
        }
    }

    public void KH() {
        if (this.atz != null) {
            this.atz.clear();
        }
    }

    public abstract void abB();

    public abstract boolean abQ();

    public abstract boolean aci();

    public abstract boolean acp();

    public abstract boolean adO();

    public abstract ArrayList<com.iqoption.core.c.c.a> adP();

    public abstract Long adQ();

    public abstract boolean adp();

    public abstract void close(boolean z);

    public abstract void cw(boolean z);

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

    public static final /* synthetic */ DepositNavigatorViewModel a(b bVar) {
        DepositNavigatorViewModel depositNavigatorViewModel = bVar.cbF;
        if (depositNavigatorViewModel == null) {
            h.lS("viewModel");
        }
        return depositNavigatorViewModel;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cbF = DepositNavigatorViewModel.cbJ.O(this);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        h.e(layoutInflater, "inflater");
        this.cbE = (q) com.iqoption.core.ext.a.a((Fragment) this, g.fragment_deposit_navigator, viewGroup, false, 4, null);
        q qVar = this.cbE;
        if (qVar == null) {
            h.lS("binding");
        }
        return qVar.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        DepositNavigatorViewModel depositNavigatorViewModel;
        h.e(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        if (!aci()) {
            boolean a = com.iqoption.core.util.q.a(getResources());
            DepositNavigatorViewModel depositNavigatorViewModel2 = this.cbF;
            if (depositNavigatorViewModel2 == null) {
                h.lS("viewModel");
            }
            boolean adR = depositNavigatorViewModel2.adR();
            boolean z = true;
            boolean z2 = a || !adR;
            if (!(a || adR)) {
                z = false;
            }
            c(z2, z);
            adM();
            depositNavigatorViewModel = this.cbF;
            if (depositNavigatorViewModel == null) {
                h.lS("viewModel");
            }
            depositNavigatorViewModel.cx(abQ()).observe(this, new c(this));
        }
        depositNavigatorViewModel = this.cbF;
        if (depositNavigatorViewModel == null) {
            h.lS("viewModel");
        }
        depositNavigatorViewModel.adS().observe(this, new d(this));
    }

    private final void adM() {
        if (!com.iqoption.core.util.q.a(getResources())) {
            DepositNavigatorViewModel depositNavigatorViewModel = this.cbF;
            if (depositNavigatorViewModel == null) {
                h.lS("viewModel");
            }
            depositNavigatorViewModel.aaJ().observe(this, new b(this));
        }
    }

    private final void c(boolean z, boolean z2) {
        FragmentManager q = com.iqoption.core.ext.a.q(this);
        FragmentTransaction beginTransaction = q.beginTransaction();
        if (!z && z2) {
            beginTransaction.setCustomAnimations(com.iqoption.deposit.r.a.slide_in_right, com.iqoption.deposit.r.a.slide_out_left);
        } else if (z && !z2) {
            beginTransaction.setCustomAnimations(com.iqoption.deposit.r.a.slide_in_left, com.iqoption.deposit.r.a.slide_out_right);
        }
        com.iqoption.core.ui.navigation.h abt = com.iqoption.deposit.light.methods.e.caZ.abt();
        h.d(beginTransaction, "ft");
        FragmentManager fragmentManager = q;
        FragmentTransaction fragmentTransaction = beginTransaction;
        a(fragmentManager, fragmentTransaction, abt, z, f.depositMethodsPane);
        a(fragmentManager, fragmentTransaction, com.iqoption.deposit.light.perform.b.cbf.h(adP()), z2, f.depositContentPane);
        beginTransaction.commitAllowingStateLoss();
    }

    private final void a(FragmentManager fragmentManager, FragmentTransaction fragmentTransaction, com.iqoption.core.ui.navigation.h hVar, boolean z, int i) {
        Fragment findFragmentByTag = fragmentManager.findFragmentByTag(hVar.getName());
        if (z) {
            if (findFragmentByTag != null) {
                fragmentTransaction.show(findFragmentByTag);
            } else {
                fragmentTransaction.replace(i, hVar.bf(com.iqoption.core.ext.a.m(this)), hVar.getName());
            }
        } else if (findFragmentByTag != null) {
            fragmentTransaction.hide(findFragmentByTag);
        }
    }

    public boolean r(Intent intent) {
        h.e(intent, "intent");
        for (Fragment fragment : com.iqoption.core.ext.a.q(this).getFragments()) {
            if ((fragment instanceof com.iqoption.core.ui.fragment.a) && ((com.iqoption.core.ui.fragment.a) fragment).r(intent)) {
                return true;
            }
        }
        return false;
    }

    public int YO() {
        return f.depositNavigatorContainer;
    }

    public com.iqoption.core.ui.navigation.h YU() {
        return aci() ? com.iqoption.deposit.dark.b.bXC.h(adP()) : null;
    }

    public void a(boolean z, p pVar) {
        h.e(pVar, "depositParams");
        DepositNavigatorViewModel depositNavigatorViewModel = this.cbF;
        if (depositNavigatorViewModel == null) {
            h.lS("viewModel");
        }
        depositNavigatorViewModel.a(z, pVar);
    }

    public void adN() {
        DepositNavigatorViewModel depositNavigatorViewModel = this.cbF;
        if (depositNavigatorViewModel == null) {
            h.lS("viewModel");
        }
        depositNavigatorViewModel.adN();
    }

    public boolean handleBack() {
        if (!(aci() || com.iqoption.core.util.q.a(getResources()))) {
            Fragment findFragmentById = com.iqoption.core.ext.a.q(this).findFragmentById(f.depositContentPane);
            if (findFragmentById != null && findFragmentById.isVisible()) {
                DepositNavigatorViewModel depositNavigatorViewModel = this.cbF;
                if (depositNavigatorViewModel == null) {
                    h.lS("viewModel");
                }
                depositNavigatorViewModel.f(null);
                c(true, false);
                return true;
            }
        }
        return super.handleBack();
    }
}
