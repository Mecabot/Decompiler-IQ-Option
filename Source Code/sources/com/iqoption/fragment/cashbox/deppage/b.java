package com.iqoption.fragment.cashbox.deppage;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.iqoption.analytics.EventManager;
import com.iqoption.d.go;
import com.iqoption.dto.Event;
import com.iqoption.dto.Event.Builder;
import com.iqoption.fragment.base.f;
import com.iqoption.util.bg;
import com.iqoption.x.R;
import java.util.HashMap;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 (2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001(B\u0005¢\u0006\u0002\u0010\u0005J\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J&\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010%\u001a\u00020\u001cH\u0016J\u001a\u0010&\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020 2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0016R\u0012\u0010\u0018\u001a\u00060\u0019R\u00020\u001aX.¢\u0006\u0002\n\u0000¨\u0006)"}, aXE = {"Lcom/iqoption/fragment/cashbox/deppage/DepositPageFragment;", "Lcom/iqoption/fragment/base/IQFragment;", "Lcom/iqoption/fragment/cashbox/deppage/DepositPageInteractorHolder;", "Lcom/iqoption/fragment/cashbox/deppage/DepositPageFundsFragment$HostCallback;", "Lcom/iqoption/fragment/cashbox/deppage/DepositPageCryptoFragment$HostCallback;", "()V", "binding", "Lcom/iqoption/databinding/DepositPageBinding;", "currency", "", "getCurrency", "()Ljava/lang/String;", "depositSum", "", "getDepositSum", "()D", "interactor", "Lcom/iqoption/fragment/cashbox/deppage/DepositPageInteractor;", "getInteractor", "()Lcom/iqoption/fragment/cashbox/deppage/DepositPageInteractor;", "is3dsOnly", "", "()Z", "isCryptoDeposit", "openEvent", "Lcom/iqoption/dto/Event$Builder;", "Lcom/iqoption/dto/Event;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onViewCreated", "view", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: DepositPageFragment.kt */
public final class b extends f implements com.iqoption.fragment.cashbox.deppage.a.b, com.iqoption.fragment.cashbox.deppage.d.b {
    public static final String TAG = "b";
    public static final a cyL = new a();
    private HashMap atz;
    private Builder cxf;
    private go cyK;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, aXE = {"Lcom/iqoption/fragment/cashbox/deppage/DepositPageFragment$Companion;", "", "()V", "ARG_CURRENCY", "", "ARG_DEPOSIT_SUM", "ARG_IS_3DS_ONLY", "ARG_IS_CRYPTO_DEPOSIT", "TAG", "get", "Lcom/iqoption/fragment/cashbox/deppage/DepositPageFragment;", "depositSum", "", "is3dsOnly", "", "currency", "isCryptoDeposit", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: DepositPageFragment.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final b a(double d, boolean z, String str, boolean z2) {
            h.e(str, com.google.firebase.analytics.FirebaseAnalytics.b.CURRENCY);
            b bVar = new b();
            Bundle bundle = new Bundle();
            bundle.putDouble("arg.depositSum", d);
            bundle.putBoolean("arg.is3dsOnly", z);
            bundle.putBoolean("arg.isCryptoDeposit", z2);
            bundle.putString("arg.currency", str);
            bVar.setArguments(bundle);
            return bVar;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/iqoption/fragment/cashbox/deppage/DepositPageFragment$onViewCreated$2$1"})
    /* compiled from: DepositPageFragment.kt */
    static final class b implements OnClickListener {
        final /* synthetic */ b cyM;
        final /* synthetic */ DepositSelectorViewModel cyN;

        b(b bVar, DepositSelectorViewModel depositSelectorViewModel) {
            this.cyM = bVar;
            this.cyN = depositSelectorViewModel;
        }

        public final void onClick(View view) {
            this.cyM.akL().aav();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0007"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/iqoption/fragment/cashbox/deppage/DepositPageFragment$onViewCreated$2$2$1", "com/iqoption/fragment/cashbox/deppage/DepositPageFragment$$special$$inlined$apply$lambda$1"})
    /* compiled from: DepositPageFragment.kt */
    static final class c implements OnClickListener {
        final /* synthetic */ b cyM;
        final /* synthetic */ DepositSelectorViewModel cyN;

        c(b bVar, DepositSelectorViewModel depositSelectorViewModel) {
            this.cyM = bVar;
            this.cyN = depositSelectorViewModel;
        }

        public final void onClick(View view) {
            this.cyN.b(DepositMethod.FUNDS);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0007"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/iqoption/fragment/cashbox/deppage/DepositPageFragment$onViewCreated$2$3$1", "com/iqoption/fragment/cashbox/deppage/DepositPageFragment$$special$$inlined$apply$lambda$2"})
    /* compiled from: DepositPageFragment.kt */
    static final class d implements OnClickListener {
        final /* synthetic */ b cyM;
        final /* synthetic */ DepositSelectorViewModel cyN;

        d(b bVar, DepositSelectorViewModel depositSelectorViewModel) {
            this.cyM = bVar;
            this.cyN = depositSelectorViewModel;
        }

        public final void onClick(View view) {
            this.cyN.b(DepositMethod.CRYPTO);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/fragment/cashbox/deppage/DepositMethod;", "onChanged"})
    /* compiled from: DepositPageFragment.kt */
    static final class e<T> implements Observer<DepositMethod> {
        final /* synthetic */ b cyM;

        e(b bVar) {
            this.cyM = bVar;
        }

        /* renamed from: a */
        public final void onChanged(DepositMethod depositMethod) {
            DepositPageFragment$onViewCreated$1$1 depositPageFragment$onViewCreated$1$1 = DepositPageFragment$onViewCreated$1$1.cyO;
            kotlin.jvm.a.a aVar = DepositPageFragment$onViewCreated$1$fundsSupplier$1.cyQ;
            kotlin.jvm.a.a aVar2 = DepositPageFragment$onViewCreated$1$cryptoSupplier$1.cyP;
            if (depositMethod != null) {
                TextView textView;
                FragmentManager childFragmentManager;
                switch (c.aoS[depositMethod.ordinal()]) {
                    case 1:
                        textView = b.a(this.cyM).bpt;
                        h.d(textView, "binding.depositFundsSelector");
                        textView.setSelected(true);
                        textView = b.a(this.cyM).bps;
                        h.d(textView, "binding.depositCryptoSelector");
                        textView.setSelected(false);
                        childFragmentManager = this.cyM.getChildFragmentManager();
                        h.d(childFragmentManager, "childFragmentManager");
                        String Ll = d.cyS.Ll();
                        h.d(Ll, "DepositPageFundsFragment.TAG");
                        depositPageFragment$onViewCreated$1$1.a(childFragmentManager, aVar, Ll);
                        return;
                    case 2:
                        textView = b.a(this.cyM).bpt;
                        h.d(textView, "binding.depositFundsSelector");
                        textView.setSelected(false);
                        textView = b.a(this.cyM).bps;
                        h.d(textView, "binding.depositCryptoSelector");
                        textView.setSelected(true);
                        childFragmentManager = this.cyM.getChildFragmentManager();
                        h.d(childFragmentManager, "childFragmentManager");
                        String str = a.TAG;
                        h.d(str, "DepositPageCryptoFragment.TAG");
                        depositPageFragment$onViewCreated$1$1.a(childFragmentManager, aVar2, str);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public void KH() {
        if (this.atz != null) {
            this.atz.clear();
        }
    }

    public static final /* synthetic */ go a(b bVar) {
        go goVar = bVar.cyK;
        if (goVar == null) {
            h.lS("binding");
        }
        return goVar;
    }

    static {
        h.d(b.class.getSimpleName(), "DepositPageFragment::class.java.simpleName");
    }

    public e akL() {
        Object host = getHost();
        if (host != null) {
            return (e) host;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.iqoption.fragment.cashbox.deppage.DepositPageInteractor");
    }

    public double akM() {
        return com.iqoption.core.ext.a.o(this).getDouble("arg.depositSum");
    }

    public boolean akN() {
        return com.iqoption.core.ext.a.o(this).getBoolean("arg.is3dsOnly");
    }

    public String getCurrency() {
        String string = com.iqoption.core.ext.a.o(this).getString("arg.currency");
        h.d(string, "args.getString(ARG_CURRENCY)");
        return string;
    }

    public final boolean akO() {
        return com.iqoption.core.ext.a.o(this).getBoolean("arg.isCryptoDeposit");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.iqoption.mobbtech.connect.response.a.a.ava().onStart();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        h.e(layoutInflater, "inflater");
        go k = go.k(layoutInflater, viewGroup, false);
        h.d(k, "it");
        this.cyK = k;
        h.d(k, "DepositPageBinding.infla…se).also { binding = it }");
        return k.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        h.e(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        Builder Builder = Event.Builder(Event.CATEGORY_SCREEN_OPENED, "deposit-page");
        h.d(Builder, "Event.Builder(Event.CATE…N_OPENED, \"deposit-page\")");
        this.cxf = Builder;
        boolean ff = com.iqoption.app.managers.feature.b.HT().ff("crypto-deposit");
        int i = 0;
        Object obj = (akO() && ff) ? 1 : null;
        go goVar = this.cyK;
        if (goVar == null) {
            h.lS("binding");
        }
        TextView textView = goVar.bps;
        h.d(textView, "binding.depositCryptoSelector");
        if (!ff) {
            i = 8;
        }
        textView.setVisibility(i);
        DepositSelectorViewModel depositSelectorViewModel = (DepositSelectorViewModel) ViewModelProviders.d((Fragment) this).h(DepositSelectorViewModel.class);
        depositSelectorViewModel.b(obj != null ? DepositMethod.CRYPTO : DepositMethod.FUNDS);
        depositSelectorViewModel.akU().observe(this, new e(this));
        go goVar2 = this.cyK;
        if (goVar2 == null) {
            h.lS("binding");
        }
        goVar2.boF.setOnClickListener(new b(this, depositSelectorViewModel));
        TextView textView2 = goVar2.bpt;
        textView2.setOnClickListener(new c(this, depositSelectorViewModel));
        View view2 = textView2;
        bg.setDrawableLeft(textView2, com.iqoption.core.ext.a.a(com.iqoption.core.ext.a.h(view2, R.drawable.ic_funds_28), com.iqoption.core.ext.a.d(view2, (int) R.color.deposit_funds_icon)));
        TextView textView3 = goVar2.bps;
        textView3.setOnClickListener(new d(this, depositSelectorViewModel));
        view = textView3;
        bg.setDrawableLeft(textView3, com.iqoption.core.ext.a.a(com.iqoption.core.ext.a.h(view, R.drawable.ic_btc_28), com.iqoption.core.ext.a.d(view, (int) R.color.deposit_crypto_icon)));
    }

    public void onDestroyView() {
        super.onDestroyView();
        EventManager Bm = EventManager.Bm();
        Builder builder = this.cxf;
        if (builder == null) {
            h.lS("openEvent");
        }
        Bm.a(builder.calcDuration().build());
        KH();
    }
}
