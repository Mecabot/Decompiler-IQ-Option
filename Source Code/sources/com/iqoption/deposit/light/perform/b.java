package com.iqoption.deposit.light.perform;

import android.annotation.SuppressLint;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.text.Editable;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.iqoption.core.microservices.billing.response.deposit.PayMethod;
import com.iqoption.core.ui.viewmodel.welcome.TermsViewModel.TERMS;
import com.iqoption.core.util.q;
import com.iqoption.core.util.r;
import com.iqoption.deposit.a.bg;
import com.iqoption.deposit.a.bk;
import com.iqoption.deposit.a.s;
import com.iqoption.deposit.p;
import com.iqoption.dto.ChartTimeInterval;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1Impl;

@kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 f2\u00020\u00012\u00020\u0002:\u0001fB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010-\u001a\u00020.H\u0016J\u000f\u0010/\u001a\u0004\u0018\u000100H\u0002¢\u0006\u0002\u00101J\b\u00102\u001a\u000203H\u0002J\b\u00104\u001a\u000203H\u0002J\b\u00105\u001a\u000203H\u0002J\b\u00106\u001a\u000207H\u0002J\u0012\u00108\u001a\u0002032\b\u00109\u001a\u0004\u0018\u00010:H\u0016J&\u0010;\u001a\u0004\u0018\u00010<2\u0006\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010@2\b\u00109\u001a\u0004\u0018\u00010:H\u0016J\u001a\u0010A\u001a\u0002032\b\u0010B\u001a\u0004\u0018\u00010C2\u0006\u0010D\u001a\u00020EH\u0002J\u0012\u0010F\u001a\u0002032\b\u0010 \u001a\u0004\u0018\u00010!H\u0003J\u0010\u0010G\u001a\u0002032\u0006\u0010H\u001a\u00020IH\u0016J\u0010\u0010J\u001a\u0002032\u0006\u0010K\u001a\u00020:H\u0016J\b\u0010L\u001a\u000203H\u0016J\u001a\u0010M\u001a\u0002032\u0006\u0010N\u001a\u00020<2\b\u00109\u001a\u0004\u0018\u00010:H\u0016J\b\u0010O\u001a\u000203H\u0002J\u001c\u0010P\u001a\u0002032\b\u0010Q\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010R\u001a\u000207H\u0002J\u0010\u0010S\u001a\u0002032\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0012\u0010T\u001a\u0002032\b\u0010U\u001a\u0004\u0018\u00010*H\u0002J\b\u0010V\u001a\u000207H\u0002J$\u0010W\u001a\u0002032\u0006\u0010X\u001a\u0002072\u0006\u0010D\u001a\u00020E2\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010\u001fH\u0002J\u0010\u0010Z\u001a\u0002032\u0006\u0010Q\u001a\u00020\u001fH\u0002J\b\u0010[\u001a\u000203H\u0002J\b\u0010\\\u001a\u000203H\u0003J\b\u0010]\u001a\u000203H\u0002J\b\u0010^\u001a\u000203H\u0002J\b\u0010_\u001a\u000203H\u0002J\u0010\u0010`\u001a\u0002032\u0006\u0010a\u001a\u000207H\u0002J\u001b\u0010b\u001a\u0004\u0018\u00010c2\n\b\u0002\u0010d\u001a\u0004\u0018\u000100H\u0002¢\u0006\u0002\u0010eR+\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058B@BX\u0002¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR+\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\r8B@BX\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R/\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017j\n\u0012\u0004\u0012\u00020\u0018\u0018\u0001`\u00198BX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R+\u0010#\u001a\u00020\"2\u0006\u0010\u0004\u001a\u00020\"8B@BX\u0002¢\u0006\u0012\n\u0004\b(\u0010\f\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X.¢\u0006\u0002\n\u0000¨\u0006g"}, aXE = {"Lcom/iqoption/deposit/light/perform/DepositPerformLightFragment;", "Lcom/iqoption/core/ui/navigation/BaseSlotNavigatorFragment;", "Lcom/iqoption/deposit/light/presets/OnPresetLightClickListener;", "()V", "<set-?>", "Lcom/iqoption/deposit/databinding/FragmentDepositPerformLightBinding;", "binding", "getBinding", "()Lcom/iqoption/deposit/databinding/FragmentDepositPerformLightBinding;", "setBinding", "(Lcom/iqoption/deposit/databinding/FragmentDepositPerformLightBinding;)V", "binding$delegate", "Lkotlin/properties/ReadWriteProperty;", "Lcom/iqoption/deposit/databinding/LayoutDepositButtonLightBinding;", "buttonBinding", "getButtonBinding", "()Lcom/iqoption/deposit/databinding/LayoutDepositButtonLightBinding;", "setButtonBinding", "(Lcom/iqoption/deposit/databinding/LayoutDepositButtonLightBinding;)V", "buttonBinding$delegate", "cashboxCounting", "Lcom/iqoption/core/microservices/billing/response/deposit/CashboxCounting;", "defaultPreset", "Ljava/util/ArrayList;", "Lcom/iqoption/core/features/limit/CurrencyValue;", "Lkotlin/collections/ArrayList;", "getDefaultPreset", "()Ljava/util/ArrayList;", "defaultPreset$delegate", "Lkotlin/Lazy;", "lastDefaultPresetAmount", "", "payMethod", "Lcom/iqoption/core/microservices/billing/response/deposit/PayMethod;", "Lcom/iqoption/deposit/light/presets/PresetsLightAdapter;", "presetsAdapter", "getPresetsAdapter", "()Lcom/iqoption/deposit/light/presets/PresetsLightAdapter;", "setPresetsAdapter", "(Lcom/iqoption/deposit/light/presets/PresetsLightAdapter;)V", "presetsAdapter$delegate", "selectedCurrency", "Lcom/iqoption/core/microservices/billing/response/deposit/CurrencyBilling;", "viewModel", "Lcom/iqoption/deposit/light/perform/DepositPerformLightViewModel;", "getContainerId", "", "getDepositAmount", "", "()Ljava/lang/Double;", "hidePayProgress", "", "initPresets", "initViews", "isKycLimitEnabled", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDepositPaymentResult", "payResponse", "Lcom/iqoption/core/microservices/billing/response/PayResponse;", "depositParams", "Lcom/iqoption/deposit/DepositParams;", "onMethodSelected", "onPresetClick", "item", "Lcom/iqoption/deposit/presets/PresetItem;", "onSaveInstanceState", "outState", "onStart", "onViewCreated", "view", "performPay", "setAmountError", "message", "shouldLinkifyKyc", "setData", "setDefaultPreset", "currency", "shouldShowKycBeforeDep", "showCompletePaymentFragment", "isSuccess", "errorMessage", "showKycAmountError", "showPayProgress", "subscribeOnChanges", "updateDepositButtonAvailability", "updateNoDataUIVisibility", "updatePresets", "updatePresetsVisibility", "focused", "validateAmount", "Lcom/iqoption/deposit/light/perform/AmountError;", "amount", "(Ljava/lang/Double;)Lcom/iqoption/deposit/light/perform/AmountError;", "Companion", "deposit_release"})
/* compiled from: DepositPerformLightFragment.kt */
public final class b extends com.iqoption.core.ui.navigation.c implements com.iqoption.deposit.light.c.a {
    private static final String TAG = "com.iqoption.deposit.light.perform.b";
    static final /* synthetic */ kotlin.reflect.j[] apP = new kotlin.reflect.j[]{kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(b.class), "binding", "getBinding()Lcom/iqoption/deposit/databinding/FragmentDepositPerformLightBinding;")), kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(b.class), "buttonBinding", "getButtonBinding()Lcom/iqoption/deposit/databinding/LayoutDepositButtonLightBinding;")), kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(b.class), "presetsAdapter", "getPresetsAdapter()Lcom/iqoption/deposit/light/presets/PresetsLightAdapter;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(b.class), "defaultPreset", "getDefaultPreset()Ljava/util/ArrayList;"))};
    public static final a cbf = new a();
    private com.iqoption.core.microservices.billing.response.deposit.b aTd;
    private HashMap atz;
    private PayMethod bVQ;
    private final kotlin.e.d bXo = kotlin.e.a.euA.aYg();
    private final kotlin.e.d bXs = kotlin.e.a.euA.aYg();
    private final kotlin.e.d bXt = kotlin.e.a.euA.aYg();
    private com.iqoption.core.microservices.billing.response.deposit.c bXv;
    private final kotlin.d bXy = g.f(new DepositPerformLightFragment$defaultPreset$2(this));
    private String bXz;
    private DepositPerformLightViewModel cbe;

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\t\u001a\u00020\n2\u001a\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000eR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000f"}, aXE = {"Lcom/iqoption/deposit/light/perform/DepositPerformLightFragment$Companion;", "", "()V", "ARG_DEFAULT_PRESET", "", "STATE_CURRENCY", "TAG", "getTAG", "()Ljava/lang/String;", "createNavigatorEntry", "Lcom/iqoption/core/ui/navigation/NavigatorEntry;", "depositPreset", "Ljava/util/ArrayList;", "Lcom/iqoption/core/features/limit/CurrencyValue;", "Lkotlin/collections/ArrayList;", "deposit_release"})
    /* compiled from: DepositPerformLightFragment.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final String Ll() {
            return b.TAG;
        }

        public final com.iqoption.core.ui.navigation.h h(ArrayList<com.iqoption.core.c.c.a> arrayList) {
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("ARG_DEFAULT_PRESET", arrayList);
            return new com.iqoption.core.ui.navigation.h(Ll(), b.class, bundle, 0, 0, 0, 0, ChartTimeInterval.CANDLE_2m, null);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: DepositPerformLightFragment.kt */
    static final class e implements OnClickListener {
        final /* synthetic */ b this$0;

        e(b bVar) {
            this.this$0 = bVar;
        }

        public final void onClick(View view) {
            com.iqoption.core.f.RQ().Ds().a("deposit-page_deposit", 0.0d, com.iqoption.deposit.c.c.ceC.aeh());
            this.this$0.acs();
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: DepositPerformLightFragment.kt */
    static final class f implements OnClickListener {
        final /* synthetic */ b this$0;

        f(b bVar) {
            this.this$0 = bVar;
        }

        public final void onClick(View view) {
            com.iqoption.core.microservices.billing.response.deposit.b b = this.this$0.aTd;
            ArrayList Td = b != null ? b.Td() : null;
            if (Td == null) {
                kotlin.jvm.internal.h.aXZ();
            }
            com.iqoption.deposit.light.menu.currency.c.a aVar = com.iqoption.deposit.light.menu.currency.c.caP;
            List list = Td;
            com.iqoption.core.microservices.billing.response.deposit.c c = this.this$0.bXv;
            com.iqoption.core.ui.navigation.j.b(com.iqoption.deposit.navigator.b.cbG.G(this.this$0), aVar.a(new com.iqoption.deposit.menu.currency.b(list, c != null ? Long.valueOf(c.getId()) : null)), false, 2, null);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, aXE = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "focused", "", "onFocusChange"})
    /* compiled from: DepositPerformLightFragment.kt */
    static final class o implements OnFocusChangeListener {
        final /* synthetic */ b this$0;

        @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, aXE = {"com/iqoption/core/ext/AndroidExtensionsKt$doOnLayout$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "core_release"})
        /* compiled from: AndroidExtensions.kt */
        public static final class a implements OnGlobalLayoutListener {
            final /* synthetic */ View aGz;
            final /* synthetic */ boolean bXE;
            final /* synthetic */ o cbh;

            public a(View view, o oVar, boolean z) {
                this.aGz = view;
                this.cbh = oVar;
                this.bXE = z;
            }

            public void onGlobalLayout() {
                this.aGz.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                this.cbh.this$0.ct(this.bXE);
            }
        }

        o(b bVar) {
            this.this$0 = bVar;
        }

        public final void onFocusChange(View view, boolean z) {
            if (this.this$0.Yu()) {
                this.this$0.ct(z);
            } else {
                view = this.this$0.adv().getRoot();
                kotlin.jvm.internal.h.d(view, "binding.root");
                view.getViewTreeObserver().addOnGlobalLayoutListener(new a(view, this, z));
            }
            if (z) {
                Double h = this.this$0.acB();
                com.iqoption.core.f.RQ().Ds().b("deposit-page_amount", h != null ? h.doubleValue() : 0.0d, com.iqoption.deposit.c.c.ceC.aeh());
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, aXE = {"com/iqoption/core/ext/AndroidExtensionsKt$setOnDelayedClickListener$1", "Lcom/iqoption/core/ext/OnDelayClickListener;", "onDelayClick", "", "v", "Landroid/view/View;", "core_release"})
    /* compiled from: AndroidExtensions.kt */
    public static final class b extends com.iqoption.core.ext.g {
        final /* synthetic */ b this$0;

        public b(b bVar) {
            this.this$0 = bVar;
            super(0, 1, null);
        }

        public void q(View view) {
            kotlin.jvm.internal.h.e(view, "v");
            this.this$0.adv().bZg.fullScroll(130);
            com.iqoption.core.util.j.n(this.this$0.zzakw());
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, aXE = {"com/iqoption/core/ext/AndroidExtensionsKt$setOnDelayedClickListener$1", "Lcom/iqoption/core/ext/OnDelayClickListener;", "onDelayClick", "", "v", "Landroid/view/View;", "core_release"})
    /* compiled from: AndroidExtensions.kt */
    public static final class c extends com.iqoption.core.ext.g {
        final /* synthetic */ b this$0;

        public c(b bVar) {
            this.this$0 = bVar;
            super(0, 1, null);
        }

        public void q(View view) {
            kotlin.jvm.internal.h.e(view, "v");
            this.this$0.back();
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, aXE = {"com/iqoption/deposit/light/perform/DepositPerformLightFragment$initViews$3", "Lcom/iqoption/core/util/TextWatcherAdapter;", "prevText", "Landroid/text/Editable;", "afterTextChanged", "", "text", "deposit_release"})
    /* compiled from: DepositPerformLightFragment.kt */
    public static final class d extends r {
        private Editable bXF;
        final /* synthetic */ b this$0;

        d(b bVar) {
            this.this$0 = bVar;
        }

        public void afterTextChanged(Editable editable) {
            kotlin.jvm.internal.h.e(editable, "text");
            super.afterTextChanged(editable);
            if (!kotlin.jvm.internal.h.E(this.bXF, editable)) {
                if (this.this$0.aTd == null || this.this$0.bXv == null || b.a(this.this$0, null, 1, null) != null) {
                    b.d(this.this$0).a(null);
                } else {
                    b.d(this.this$0).a(new BigDecimal(editable.toString()));
                    b.a(this.this$0, null, false, 2, null);
                }
                this.bXF = editable;
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/core/microservices/billing/response/PayResponse;", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: DepositPerformLightFragment.kt */
    static final class g<T> implements io.reactivex.c.e<com.iqoption.core.microservices.billing.response.c> {
        final /* synthetic */ p bXG;
        final /* synthetic */ WeakReference cbg;

        g(WeakReference weakReference, p pVar) {
            this.cbg = weakReference;
            this.bXG = pVar;
        }

        /* renamed from: a */
        public final void accept(com.iqoption.core.microservices.billing.response.c cVar) {
            b bVar = (b) this.cbg.get();
            if (bVar != null) {
                kotlin.jvm.internal.h.d(bVar, "it");
                if (!bVar.isAdded()) {
                    bVar = null;
                }
                if (bVar != null) {
                    bVar.acz();
                    bVar.a(cVar, this.bXG);
                }
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "error", "", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: DepositPerformLightFragment.kt */
    static final class h<T> implements io.reactivex.c.e<Throwable> {
        final /* synthetic */ p bXG;
        final /* synthetic */ WeakReference cbg;

        h(WeakReference weakReference, p pVar) {
            this.cbg = weakReference;
            this.bXG = pVar;
        }

        /* renamed from: o */
        public final void accept(Throwable th) {
            com.iqoption.core.i.e("Unable to pay", th);
            b bVar = (b) this.cbg.get();
            if (bVar != null) {
                kotlin.jvm.internal.h.d(bVar, "it");
                if (!bVar.isAdded()) {
                    bVar = null;
                }
                b bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.acz();
                    b.a(bVar2, false, this.bXG, null, 4, null);
                }
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, aXE = {"com/iqoption/deposit/light/perform/DepositPerformLightFragment$setData$1", "Lcom/iqoption/core/util/link/LinkClickListener;", "onLinkClicked", "", "link", "Lcom/iqoption/core/util/link/Link;", "deposit_release"})
    /* compiled from: DepositPerformLightFragment.kt */
    public static final class i implements com.iqoption.core.util.a.b {
        final /* synthetic */ b this$0;

        i(b bVar) {
            this.this$0 = bVar;
        }

        public void a(com.iqoption.core.util.a.a aVar) {
            kotlin.jvm.internal.h.e(aVar, "link");
            com.iqoption.core.ui.navigation.j.b(com.iqoption.deposit.navigator.b.cbG.G(this.this$0), com.iqoption.core.ui.fragment.c.bbF.a(TERMS.CONDITIONS), false, 2, null);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/core/microservices/billing/response/deposit/PayMethod;", "onChanged"})
    /* compiled from: DepositPerformLightFragment.kt */
    static final class j<T> implements Observer<PayMethod> {
        final /* synthetic */ b this$0;

        j(b bVar) {
            this.this$0 = bVar;
        }

        /* renamed from: h */
        public final void onChanged(PayMethod payMethod) {
            this.this$0.i(payMethod);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "currency", "Lcom/iqoption/core/microservices/billing/response/deposit/CurrencyBilling;", "onChanged"})
    /* compiled from: DepositPerformLightFragment.kt */
    static final class k<T> implements Observer<com.iqoption.core.microservices.billing.response.deposit.c> {
        final /* synthetic */ b this$0;

        k(b bVar) {
            this.this$0 = bVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:8:0x0073  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x00db  */
        /* renamed from: c */
        public final void onChanged(com.iqoption.core.microservices.billing.response.deposit.c r9) {
            /*
            r8 = this;
            if (r9 == 0) goto L_0x00e2;
        L_0x0002:
            r0 = r8.this$0;
            r0.bXv = r9;
            r0 = r8.this$0;
            r0 = r0.adv();
            r0 = r0.bZc;
            r1 = "binding.depositAmountTitle";
            kotlin.jvm.internal.h.d(r0, r1);
            r1 = new java.lang.StringBuilder;
            r1.<init>();
            r2 = r8.this$0;
            r3 = com.iqoption.deposit.r.h.amount;
            r2 = r2.getString(r3);
            r1.append(r2);
            r2 = " (";
            r1.append(r2);
            r2 = r9.getName();
            r1.append(r2);
            r2 = 41;
            r1.append(r2);
            r1 = r1.toString();
            r1 = (java.lang.CharSequence) r1;
            r0.setText(r1);
            r0 = r8.this$0;
            r0 = r0.adv();
            r0 = r0.bYY;
            r0 = r0.bZU;
            r1 = "binding.currencySelector.selectCurrencyName";
            kotlin.jvm.internal.h.d(r0, r1);
            r1 = r9.getName();
            r1 = (java.lang.CharSequence) r1;
            r0.setText(r1);
            r0 = r8.this$0;
            r0 = r0.aTd;
            r1 = 0;
            if (r0 == 0) goto L_0x0070;
        L_0x005f:
            r0 = r0.UJ();
            if (r0 == 0) goto L_0x0070;
        L_0x0065:
            r2 = r9.getName();
            r0 = r0.get(r2);
            r0 = (java.util.ArrayList) r0;
            goto L_0x0071;
        L_0x0070:
            r0 = r1;
        L_0x0071:
            if (r0 == 0) goto L_0x00d2;
        L_0x0073:
            r0 = (java.lang.Iterable) r0;
            r1 = new java.util.ArrayList;
            r1.<init>();
            r1 = (java.util.Collection) r1;
            r0 = r0.iterator();
        L_0x0080:
            r2 = r0.hasNext();
            r3 = 0;
            if (r2 == 0) goto L_0x00a5;
        L_0x0087:
            r2 = r0.next();
            r4 = r2;
            r4 = (com.iqoption.core.microservices.billing.response.deposit.d) r4;
            r5 = r8.this$0;
            r6 = r4.UO();
            r4 = java.lang.Double.valueOf(r6);
            r4 = r5.d(r4);
            if (r4 != 0) goto L_0x009f;
        L_0x009e:
            r3 = 1;
        L_0x009f:
            if (r3 == 0) goto L_0x0080;
        L_0x00a1:
            r1.add(r2);
            goto L_0x0080;
        L_0x00a5:
            r1 = (java.util.List) r1;
            r1 = (java.lang.Iterable) r1;
            r0 = new java.util.ArrayList;
            r2 = 10;
            r2 = kotlin.collections.n.e(r1, r2);
            r0.<init>(r2);
            r0 = (java.util.Collection) r0;
            r1 = r1.iterator();
        L_0x00ba:
            r2 = r1.hasNext();
            if (r2 == 0) goto L_0x00cf;
        L_0x00c0:
            r2 = r1.next();
            r2 = (com.iqoption.core.microservices.billing.response.deposit.d) r2;
            r4 = new com.iqoption.deposit.b.c;
            r4.<init>(r2, r9, r3);
            r0.add(r4);
            goto L_0x00ba;
        L_0x00cf:
            r1 = r0;
            r1 = (java.util.List) r1;
        L_0x00d2:
            r0 = r8.this$0;
            r0 = r0.adx();
            if (r1 == 0) goto L_0x00db;
        L_0x00da:
            goto L_0x00df;
        L_0x00db:
            r1 = kotlin.collections.m.emptyList();
        L_0x00df:
            r0.ap(r1);
        L_0x00e2:
            r0 = r8.this$0;
            r0.b(r9);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iqoption.deposit.light.perform.b.k.c(com.iqoption.core.microservices.billing.response.deposit.c):void");
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "deposit", "Lcom/iqoption/core/microservices/billing/response/deposit/Deposit;", "onChanged"})
    /* compiled from: DepositPerformLightFragment.kt */
    static final class l<T> implements Observer<com.iqoption.core.microservices.billing.response.deposit.d> {
        final /* synthetic */ b this$0;

        l(b bVar) {
            this.this$0 = bVar;
        }

        /* renamed from: c */
        public final void onChanged(com.iqoption.core.microservices.billing.response.deposit.d dVar) {
            if (dVar != null) {
                String a = com.iqoption.deposit.h.a(dVar);
                this.this$0.adv().bZa.setText(a);
                this.this$0.adv().bZa.setSelection(a.length());
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "amount", "Ljava/math/BigDecimal;", "onChanged"})
    /* compiled from: DepositPerformLightFragment.kt */
    static final class m<T> implements Observer<BigDecimal> {
        final /* synthetic */ b this$0;

        m(b bVar) {
            this.this$0 = bVar;
        }

        /* renamed from: b */
        public final void onChanged(BigDecimal bigDecimal) {
            String string = this.this$0.getString(com.iqoption.deposit.r.h.deposit1);
            String str = null;
            TextView textView;
            if (bigDecimal == null || this.this$0.bXv == null) {
                textView = this.this$0.adw().bZX;
                kotlin.jvm.internal.h.d(textView, "buttonBinding.depositBottomButtonText");
                textView.setText(string);
            } else {
                textView = this.this$0.adw().bZX;
                kotlin.jvm.internal.h.d(textView, "buttonBinding.depositBottomButtonText");
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string);
                stringBuilder.append(' ');
                com.iqoption.core.microservices.billing.response.deposit.c c = this.this$0.bXv;
                if (c == null) {
                    kotlin.jvm.internal.h.aXZ();
                }
                stringBuilder.append(com.iqoption.core.util.c.a(bigDecimal, c, false, 2, null));
                textView.setText(stringBuilder.toString());
            }
            com.iqoption.deposit.light.c.c f = this.this$0.adx();
            if (bigDecimal != null) {
                str = com.iqoption.core.util.c.a(bigDecimal, 0, null, true, false, null, 27, null);
            }
            f.setSelection(str);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "counting", "Lcom/iqoption/core/microservices/billing/response/deposit/CashboxCounting;", "onChanged"})
    /* compiled from: DepositPerformLightFragment.kt */
    static final class n<T> implements Observer<com.iqoption.core.microservices.billing.response.deposit.b> {
        final /* synthetic */ b this$0;

        n(b bVar) {
            this.this$0 = bVar;
        }

        /* renamed from: e */
        public final void onChanged(com.iqoption.core.microservices.billing.response.deposit.b bVar) {
            if (bVar != null) {
                b bVar2 = this.this$0;
                kotlin.jvm.internal.h.d(bVar, "it");
                bVar2.b(bVar);
            }
        }
    }

    private final void a(bk bkVar) {
        this.bXs.a(this, apP[1], bkVar);
    }

    private final void a(s sVar) {
        this.bXo.a(this, apP[0], sVar);
    }

    private final void a(com.iqoption.deposit.light.c.c cVar) {
        this.bXt.a(this, apP[2], cVar);
    }

    private final ArrayList<com.iqoption.core.c.c.a> aaD() {
        kotlin.d dVar = this.bXy;
        kotlin.reflect.j jVar = apP[3];
        return (ArrayList) dVar.getValue();
    }

    private final s adv() {
        return (s) this.bXo.b(this, apP[0]);
    }

    private final bk adw() {
        return (bk) this.bXs.b(this, apP[1]);
    }

    private final com.iqoption.deposit.light.c.c adx() {
        return (com.iqoption.deposit.light.c.c) this.bXt.b(this, apP[2]);
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

    static {
        if (b.class.getName() == null) {
            kotlin.jvm.internal.h.aXZ();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cbe = DepositPerformLightViewModel.cbi.D(this);
        if (bundle != null) {
            this.bXv = (com.iqoption.core.microservices.billing.response.deposit.c) bundle.getParcelable("STATE_CURRENCY");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.h.e(layoutInflater, "inflater");
        a((s) com.iqoption.core.ext.a.a((Fragment) this, com.iqoption.deposit.r.g.fragment_deposit_perform_light, viewGroup, false, 4, null));
        bk bkVar = adv().bZd;
        kotlin.jvm.internal.h.d(bkVar, "binding.depositButtonBinding");
        a(bkVar);
        return adv().getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.h.e(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        abr();
        ady();
        adA();
        acq();
    }

    private final void abr() {
        acz();
        LinearLayout linearLayout = adv().bZj.bqH;
        kotlin.jvm.internal.h.d(linearLayout, "toolbarLayout.depositToolbarSecure");
        linearLayout.setOnClickListener(new b(this));
        ImageView imageView;
        if (q.a(getResources())) {
            imageView = adv().bTH;
            kotlin.jvm.internal.h.d(imageView, "binding.toolbarBack");
            com.iqoption.core.ext.a.M(imageView);
        } else {
            imageView = adv().bTH;
            kotlin.jvm.internal.h.d(imageView, "binding.toolbarBack");
            com.iqoption.core.ext.a.L(imageView);
            imageView = adv().bTH;
            kotlin.jvm.internal.h.d(imageView, "binding.toolbarBack");
            imageView.setOnClickListener(new c(this));
        }
        EditText editText = adv().bZa;
        kotlin.jvm.internal.h.d(editText, "binding.depositAmountEdit");
        com.iqoption.core.ext.a.a(editText, (InputFilter) new com.iqoption.core.ui.widget.a(2));
        adv().bZa.addTextChangedListener(new d(this));
        adw().bZV.setOnClickListener(new e(this));
        bg bgVar = adv().bYY;
        kotlin.jvm.internal.h.d(bgVar, "binding.currencySelector");
        bgVar.getRoot().setOnClickListener(new f(this));
        acr();
    }

    public void onStart() {
        super.onStart();
        ady();
    }

    private final void ady() {
        LinearLayout linearLayout;
        TextView textView;
        FrameLayout frameLayout;
        if (this.aTd == null || this.bVQ == null) {
            linearLayout = adv().bZj.bqH;
            kotlin.jvm.internal.h.d(linearLayout, "binding.toolbarTitleLayout.depositToolbarSecure");
            com.iqoption.core.ext.a.M(linearLayout);
            textView = adv().bZf;
            kotlin.jvm.internal.h.d(textView, "binding.depositNoData");
            textView.setText(getString(com.iqoption.deposit.r.h.choose_method));
            linearLayout = adv().bYZ;
            kotlin.jvm.internal.h.d(linearLayout, "binding.depositAmountContainer");
            com.iqoption.core.ext.a.M(linearLayout);
            textView = adv().bZf;
            kotlin.jvm.internal.h.d(textView, "binding.depositNoData");
            com.iqoption.core.ext.a.L(textView);
            frameLayout = adv().bZe;
            kotlin.jvm.internal.h.d(frameLayout, "binding.depositFields");
            com.iqoption.core.ext.a.M(frameLayout);
        } else if (acp()) {
            linearLayout = adv().bZj.bqH;
            kotlin.jvm.internal.h.d(linearLayout, "binding.toolbarTitleLayout.depositToolbarSecure");
            com.iqoption.core.ext.a.L(linearLayout);
            textView = adv().bZf;
            kotlin.jvm.internal.h.d(textView, "binding.depositNoData");
            textView.setText((CharSequence) null);
            linearLayout = adv().bYZ;
            kotlin.jvm.internal.h.d(linearLayout, "binding.depositAmountContainer");
            com.iqoption.core.ext.a.L(linearLayout);
            textView = adv().bZf;
            kotlin.jvm.internal.h.d(textView, "binding.depositNoData");
            com.iqoption.core.ext.a.L(textView);
            frameLayout = adv().bZe;
            kotlin.jvm.internal.h.d(frameLayout, "binding.depositFields");
            com.iqoption.core.ext.a.M(frameLayout);
        } else {
            linearLayout = adv().bZj.bqH;
            kotlin.jvm.internal.h.d(linearLayout, "binding.toolbarTitleLayout.depositToolbarSecure");
            com.iqoption.core.ext.a.L(linearLayout);
            linearLayout = adv().bYZ;
            kotlin.jvm.internal.h.d(linearLayout, "binding.depositAmountContainer");
            com.iqoption.core.ext.a.L(linearLayout);
            textView = adv().bZf;
            kotlin.jvm.internal.h.d(textView, "binding.depositNoData");
            com.iqoption.core.ext.a.M(textView);
            frameLayout = adv().bZe;
            kotlin.jvm.internal.h.d(frameLayout, "binding.depositFields");
            com.iqoption.core.ext.a.L(frameLayout);
        }
    }

    private final boolean acp() {
        return com.iqoption.deposit.navigator.b.cbG.H(this);
    }

    @SuppressLint({"SetTextI18n"})
    private final void acq() {
        DepositPerformLightViewModel depositPerformLightViewModel = this.cbe;
        if (depositPerformLightViewModel == null) {
            kotlin.jvm.internal.h.lS("viewModel");
        }
        LifecycleOwner lifecycleOwner = this;
        depositPerformLightViewModel.aaJ().observe(lifecycleOwner, new j(this));
        depositPerformLightViewModel = this.cbe;
        if (depositPerformLightViewModel == null) {
            kotlin.jvm.internal.h.lS("viewModel");
        }
        depositPerformLightViewModel.aaK().observe(lifecycleOwner, new k(this));
        depositPerformLightViewModel = this.cbe;
        if (depositPerformLightViewModel == null) {
            kotlin.jvm.internal.h.lS("viewModel");
        }
        depositPerformLightViewModel.aaL().observe(lifecycleOwner, new l(this));
        depositPerformLightViewModel = this.cbe;
        if (depositPerformLightViewModel == null) {
            kotlin.jvm.internal.h.lS("viewModel");
        }
        depositPerformLightViewModel.aaM().observe(lifecycleOwner, new m(this));
        depositPerformLightViewModel = this.cbe;
        if (depositPerformLightViewModel == null) {
            kotlin.jvm.internal.h.lS("viewModel");
        }
        depositPerformLightViewModel.aaI().observe(lifecycleOwner, new n(this));
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x009f  */
    /* JADX WARNING: Missing block: B:5:0x0021, code:
            if ((kotlin.jvm.internal.h.E(r0.getText().toString(), r12.bXz) ^ 1) != 0) goto L_0x00a9;
     */
    private final void b(com.iqoption.core.microservices.billing.response.deposit.c r13) {
        /*
        r12 = this;
        r0 = r12.adv();
        r0 = r0.bZa;
        if (r13 == 0) goto L_0x00a9;
    L_0x0008:
        r1 = r12.bXz;
        if (r1 == 0) goto L_0x0025;
    L_0x000c:
        r1 = "amountField";
        kotlin.jvm.internal.h.d(r0, r1);
        r1 = r0.getText();
        r1 = r1.toString();
        r2 = r12.bXz;
        r1 = kotlin.jvm.internal.h.E(r1, r2);
        r1 = r1 ^ 1;
        if (r1 == 0) goto L_0x0025;
    L_0x0023:
        goto L_0x00a9;
    L_0x0025:
        r1 = r12.aaD();
        r2 = 0;
        if (r1 == 0) goto L_0x0066;
    L_0x002c:
        r1 = (java.lang.Iterable) r1;
        r1 = r1.iterator();
    L_0x0032:
        r3 = r1.hasNext();
        if (r3 == 0) goto L_0x004e;
    L_0x0038:
        r3 = r1.next();
        r4 = r3;
        r4 = (com.iqoption.core.c.c.a) r4;
        r4 = r4.getName();
        r5 = r13.getName();
        r4 = kotlin.jvm.internal.h.E(r4, r5);
        if (r4 == 0) goto L_0x0032;
    L_0x004d:
        goto L_0x004f;
    L_0x004e:
        r3 = r2;
    L_0x004f:
        r3 = (com.iqoption.core.c.c.a) r3;
        if (r3 == 0) goto L_0x0066;
    L_0x0053:
        r4 = r3.Tb();
        if (r4 == 0) goto L_0x0066;
    L_0x0059:
        r5 = 0;
        r6 = 0;
        r7 = 1;
        r8 = 0;
        r9 = 0;
        r10 = 19;
        r11 = 0;
        r1 = com.iqoption.core.util.c.a(r4, r5, r6, r7, r8, r9, r10, r11);
        goto L_0x0067;
    L_0x0066:
        r1 = r2;
    L_0x0067:
        r3 = r12.aTd;
        if (r3 == 0) goto L_0x007c;
    L_0x006b:
        r3 = r3.UJ();
        if (r3 == 0) goto L_0x007c;
    L_0x0071:
        r13 = r13.getName();
        r13 = r3.get(r13);
        r13 = (java.util.ArrayList) r13;
        goto L_0x007d;
    L_0x007c:
        r13 = r2;
    L_0x007d:
        if (r1 != 0) goto L_0x009c;
    L_0x007f:
        if (r13 == 0) goto L_0x009c;
    L_0x0081:
        r13 = r12.adx();
        r13 = r13.getItems();
        r13 = kotlin.collections.u.bV(r13);
        r13 = (com.iqoption.deposit.b.c) r13;
        if (r13 == 0) goto L_0x009b;
    L_0x0091:
        r13 = r13.adX();
        if (r13 == 0) goto L_0x009b;
    L_0x0097:
        r2 = com.iqoption.deposit.h.a(r13);
    L_0x009b:
        r1 = r2;
    L_0x009c:
        if (r1 == 0) goto L_0x009f;
    L_0x009e:
        goto L_0x00a1;
    L_0x009f:
        r1 = "";
    L_0x00a1:
        r12.bXz = r1;
        r1 = (java.lang.CharSequence) r1;
        r0.setText(r1);
        return;
    L_0x00a9:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.deposit.light.perform.b.b(com.iqoption.core.microservices.billing.response.deposit.c):void");
    }

    public void onSaveInstanceState(Bundle bundle) {
        kotlin.jvm.internal.h.e(bundle, "outState");
        com.iqoption.core.microservices.billing.response.deposit.c cVar = this.bXv;
        if (cVar != null) {
            bundle.putParcelable("STATE_CURRENCY", cVar);
        }
        super.onSaveInstanceState(bundle);
    }

    private final void acr() {
        RecyclerView recyclerView = adv().bZh;
        kotlin.jvm.internal.h.d(recyclerView, "presetsList");
        recyclerView.setItemAnimator((ItemAnimator) null);
        recyclerView.setLayoutManager(new LinearLayoutManager(com.iqoption.core.ext.a.m(this), 0, false));
        com.iqoption.core.ui.a.a(recyclerView, getResources().getDimension(com.iqoption.deposit.r.d.dp8), false);
        a(new com.iqoption.deposit.light.c.c(this));
        recyclerView.setAdapter(adx());
        adz();
    }

    /* JADX WARNING: Missing block: B:8:0x0023, code:
            if (r2 != 0) goto L_0x0026;
     */
    private final void adz() {
        /*
        r5 = this;
        r0 = r5.bVQ;
        r1 = r5.adv();
        r1 = r1.bZa;
        r2 = r0 instanceof com.iqoption.core.microservices.billing.response.deposit.g;
        r3 = 0;
        r4 = 1;
        if (r2 == 0) goto L_0x0026;
    L_0x000e:
        r2 = r0;
        r2 = (com.iqoption.core.microservices.billing.response.deposit.g) r2;
        r2 = r2.Va();
        if (r2 == 0) goto L_0x0022;
    L_0x0017:
        r2 = r2.Vo();
        if (r2 == 0) goto L_0x0022;
    L_0x001d:
        r2 = r2.size();
        goto L_0x0023;
    L_0x0022:
        r2 = 0;
    L_0x0023:
        if (r2 != 0) goto L_0x0026;
    L_0x0025:
        goto L_0x003b;
    L_0x0026:
        if (r0 == 0) goto L_0x002d;
    L_0x0028:
        r0 = r0.UT();
        goto L_0x002e;
    L_0x002d:
        r0 = 0;
    L_0x002e:
        r2 = com.iqoption.core.microservices.billing.response.deposit.PayMethod.PayMethodType.UserCard;
        if (r0 != r2) goto L_0x0033;
    L_0x0032:
        goto L_0x003b;
    L_0x0033:
        r0 = r5.acp();
        if (r0 == 0) goto L_0x003a;
    L_0x0039:
        goto L_0x003b;
    L_0x003a:
        r4 = 0;
    L_0x003b:
        if (r4 == 0) goto L_0x004e;
    L_0x003d:
        r0 = r5.adv();
        r0 = r0.bZh;
        r1 = "binding.depositPresetsList";
        kotlin.jvm.internal.h.d(r0, r1);
        r0 = (android.view.View) r0;
        com.iqoption.core.ext.a.L(r0);
        goto L_0x0068;
    L_0x004e:
        r0 = r5.adv();
        r0 = r0.bZh;
        r2 = "binding.depositPresetsList";
        kotlin.jvm.internal.h.d(r0, r2);
        r0 = (android.view.View) r0;
        com.iqoption.core.ext.a.M(r0);
        r0 = new com.iqoption.deposit.light.perform.b$o;
        r0.<init>(r5);
        r0 = (android.view.View.OnFocusChangeListener) r0;
        r1.setOnFocusChangeListener(r0);
    L_0x0068:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.deposit.light.perform.b.adz():void");
    }

    private final void ct(boolean z) {
        RecyclerView recyclerView = adv().bZh;
        if (z) {
            kotlin.jvm.internal.h.d(recyclerView, "presetsList");
            com.iqoption.core.ext.a.L(recyclerView);
            return;
        }
        kotlin.jvm.internal.h.d(recyclerView, "presetsList");
        com.iqoption.core.ext.a.M(recyclerView);
    }

    public void a(com.iqoption.deposit.b.c cVar) {
        kotlin.jvm.internal.h.e(cVar, "item");
        DepositPerformLightViewModel depositPerformLightViewModel = this.cbe;
        if (depositPerformLightViewModel == null) {
            kotlin.jvm.internal.h.lS("viewModel");
        }
        depositPerformLightViewModel.b(cVar.adX());
        JsonObject aeh = com.iqoption.deposit.c.c.ceC.aeh();
        aeh.add("is_vip", new JsonPrimitive(Boolean.valueOf(kotlin.jvm.internal.h.E(cVar.adX().UP(), "vip"))));
        com.iqoption.core.f.RQ().Ds().a("deposit-page_preset-picked", cVar.adX().UO(), aeh);
    }

    private final void acs() {
        boolean z = false;
        if (acp()) {
            com.iqoption.deposit.navigator.b.cbG.b(this, false);
            return;
        }
        Fragment findFragmentById = com.iqoption.core.ext.a.q(this).findFragmentById(com.iqoption.deposit.r.f.depositFields);
        if (!(findFragmentById instanceof com.iqoption.deposit.q)) {
            findFragmentById = null;
        }
        com.iqoption.deposit.q qVar = (com.iqoption.deposit.q) findFragmentById;
        a a = a(this, null, 1, null);
        if (a == null) {
            z = true;
        }
        if (qVar != null && qVar.validate() && z) {
            acy();
            Double acB = acB();
            if (acB == null) {
                kotlin.jvm.internal.h.aXZ();
            }
            BigDecimal bigDecimal = new BigDecimal(acB.doubleValue());
            com.iqoption.core.microservices.billing.response.deposit.c cVar = this.bXv;
            if (cVar == null) {
                kotlin.jvm.internal.h.aXZ();
            }
            p pVar = new p(bigDecimal, cVar);
            WeakReference bf = com.iqoption.core.ext.c.bf(this);
            DepositPerformLightViewModel depositPerformLightViewModel = this.cbe;
            if (depositPerformLightViewModel == null) {
                kotlin.jvm.internal.h.lS("viewModel");
            }
            depositPerformLightViewModel.a(qVar.aaS(), pVar.aaH().getName(), pVar.VZ(), qVar.aaR()).h(com.iqoption.core.h.i.Yo()).g(com.iqoption.core.h.i.Yp()).a((io.reactivex.c.e) new g(bf, pVar), (io.reactivex.c.e) new h(bf, pVar));
        } else if (!z) {
            if (a == null) {
                kotlin.jvm.internal.h.aXZ();
            }
            p(a.getErrorMessage(), a.ach());
        }
    }

    static /* synthetic */ a a(b bVar, Double d, int i, Object obj) {
        if ((i & 1) != 0) {
            d = bVar.acB();
        }
        return bVar.d(d);
    }

    private final a d(Double d) {
        com.iqoption.core.microservices.billing.response.deposit.c cVar = this.bXv;
        a aVar = null;
        if (cVar == null) {
            return null;
        }
        com.iqoption.core.microservices.billing.response.deposit.b bVar = this.aTd;
        if (bVar == null) {
            return null;
        }
        String string;
        BigDecimal bigDecimal;
        if (d == null) {
            string = getString(com.iqoption.deposit.r.h.incorrect_value);
            kotlin.jvm.internal.h.d(string, "getString(R.string.incorrect_value)");
            aVar = new a(string, false);
        } else if (d.doubleValue() < cVar.UM()) {
            bigDecimal = new BigDecimal(cVar.UM());
            string = getString(com.iqoption.deposit.r.h.deposit_limit_n1, com.iqoption.core.util.c.a(bigDecimal, cVar, true));
            kotlin.jvm.internal.h.d(string, "message");
            aVar = new a(string, false);
        } else {
            if (abQ() && bVar.UK() > ((double) -1) && bVar.Td() != null) {
                ArrayList Td = bVar.Td();
                if (Td == null) {
                    kotlin.jvm.internal.h.aXZ();
                }
                if (Td.size() == 1 && bVar.UL() + d.doubleValue() > bVar.UK()) {
                    bigDecimal = new BigDecimal(bVar.UK());
                    string = getString(com.iqoption.deposit.r.h.max_deposit_total_amount_for_the_non_verified, com.iqoption.core.util.c.a(bigDecimal, cVar, true));
                    kotlin.jvm.internal.h.d(string, "message");
                    aVar = new a(string, true);
                }
            }
            if (d.doubleValue() > cVar.UN()) {
                bigDecimal = new BigDecimal(cVar.UN());
                string = getString(com.iqoption.deposit.r.h.up_to_n1, com.iqoption.core.util.c.a(bigDecimal, cVar, true));
                kotlin.jvm.internal.h.d(string, "message");
                aVar = new a(string, false);
            }
        }
        return aVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x002a  */
    private final void a(com.iqoption.core.microservices.billing.response.c r8, com.iqoption.deposit.p r9) {
        /*
        r7 = this;
        r0 = 0;
        r1 = 0;
        if (r8 == 0) goto L_0x0099;
    L_0x0004:
        r2 = r8.UA();
        r3 = 1;
        r4 = java.lang.Boolean.valueOf(r3);
        r2 = kotlin.jvm.internal.h.E(r2, r4);
        r2 = r2 ^ r3;
        if (r2 == 0) goto L_0x0016;
    L_0x0014:
        goto L_0x0099;
    L_0x0016:
        r2 = r8.UB();
        if (r2 == 0) goto L_0x0027;
    L_0x001c:
        r2 = r2.UC();
        if (r2 == 0) goto L_0x0027;
    L_0x0022:
        r2 = r2.getUrl();
        goto L_0x0028;
    L_0x0027:
        r2 = r1;
    L_0x0028:
        if (r2 != 0) goto L_0x002f;
    L_0x002a:
        r7.a(r3, r9, r1);
        goto L_0x00a2;
    L_0x002f:
        r4 = r2;
        r4 = (java.lang.CharSequence) r4;
        r5 = "redirect/success";
        r5 = (java.lang.CharSequence) r5;
        r6 = 2;
        r5 = kotlin.text.v.b(r4, r5, r0, r6, r1);
        if (r5 == 0) goto L_0x0041;
    L_0x003d:
        r7.a(r3, r9, r1);
        goto L_0x00a2;
    L_0x0041:
        r3 = "redirect/failed";
        r3 = (java.lang.CharSequence) r3;
        r3 = kotlin.text.v.b(r4, r3, r0, r6, r1);
        if (r3 == 0) goto L_0x0053;
    L_0x004b:
        r8 = r8.Uz();
        r7.a(r0, r9, r8);
        goto L_0x00a2;
    L_0x0053:
        r3 = r8.UB();
        if (r3 != 0) goto L_0x005c;
    L_0x0059:
        kotlin.jvm.internal.h.aXZ();
    L_0x005c:
        r3 = r3.UC();
        if (r3 != 0) goto L_0x0065;
    L_0x0062:
        kotlin.jvm.internal.h.aXZ();
    L_0x0065:
        r3 = r3.UE();
        if (r3 != 0) goto L_0x006e;
    L_0x006b:
        kotlin.jvm.internal.h.aXZ();
    L_0x006e:
        r4 = "POST";
        r8 = r8.UB();
        if (r8 == 0) goto L_0x0081;
    L_0x0076:
        r8 = r8.UC();
        if (r8 == 0) goto L_0x0081;
    L_0x007c:
        r8 = r8.getMethod();
        goto L_0x0082;
    L_0x0081:
        r8 = r1;
    L_0x0082:
        r8 = kotlin.jvm.internal.h.E(r4, r8);
        r4 = com.iqoption.deposit.light.d.a.cbo;
        r8 = r4.a(r2, r3, r8, r9);
        r9 = com.iqoption.deposit.navigator.b.cbG;
        r2 = r7;
        r2 = (android.support.v4.app.Fragment) r2;
        r9 = r9.G(r2);
        com.iqoption.core.ui.navigation.j.b(r9, r8, r0, r6, r1);
        goto L_0x00a2;
    L_0x0099:
        if (r8 == 0) goto L_0x009f;
    L_0x009b:
        r1 = r8.Uz();
    L_0x009f:
        r7.a(r0, r9, r1);
    L_0x00a2:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.deposit.light.perform.b.a(com.iqoption.core.microservices.billing.response.c, com.iqoption.deposit.p):void");
    }

    static /* bridge */ /* synthetic */ void a(b bVar, boolean z, p pVar, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            str = (String) null;
        }
        bVar.a(z, pVar, str);
    }

    private final void a(boolean z, p pVar, String str) {
        com.iqoption.core.util.j.n(com.iqoption.core.ext.a.n(this));
        com.iqoption.core.ui.navigation.j.a(com.iqoption.deposit.navigator.b.cbG.G(this), com.iqoption.deposit.light.b.a.caF.a(z ? "deposit" : "error_deposit", pVar.aaH(), pVar.VZ(), str), false, 2, null);
    }

    private final void b(com.iqoption.core.microservices.billing.response.deposit.b bVar) {
        this.aTd = bVar;
        ady();
        adA();
        ArrayList Td = bVar.Td();
        com.iqoption.core.microservices.billing.response.deposit.c UI = bVar.UI();
        Object obj = null;
        if (UI == null) {
            UI = Td != null ? (com.iqoption.core.microservices.billing.response.deposit.c) u.bV(Td) : null;
        }
        HashMap UJ = bVar.UJ();
        if (UJ != null) {
            Map map = UJ;
            if (UI != null) {
                obj = UI.getName();
            }
            obj = (ArrayList) map.get(obj);
        }
        if (!(obj == null || UI == null)) {
            DepositPerformLightViewModel depositPerformLightViewModel = this.cbe;
            if (depositPerformLightViewModel == null) {
                kotlin.jvm.internal.h.lS("viewModel");
            }
            depositPerformLightViewModel.a(UI);
        }
        this.bXv = UI;
        Object obj2 = (Td != null ? Td.size() : 0) > 1 ? 1 : null;
        bg bgVar;
        View root;
        if (obj2 != null) {
            bgVar = adv().bYY;
            kotlin.jvm.internal.h.d(bgVar, "binding.currencySelector");
            root = bgVar.getRoot();
            kotlin.jvm.internal.h.d(root, "binding.currencySelector.root");
            com.iqoption.core.ext.a.L(root);
        } else {
            bgVar = adv().bYY;
            kotlin.jvm.internal.h.d(bgVar, "binding.currencySelector");
            root = bgVar.getRoot();
            kotlin.jvm.internal.h.d(root, "binding.currencySelector.root");
            com.iqoption.core.ext.a.M(root);
        }
        if (obj2 == null || !com.iqoption.core.f.Dr().Dh()) {
            TextView textView = adv().bZi;
            kotlin.jvm.internal.h.d(textView, "binding.depositTerms");
            com.iqoption.core.ext.a.M(textView);
            return;
        }
        TextView textView2 = adv().bZi;
        kotlin.jvm.internal.h.d(textView2, "textView");
        com.iqoption.core.ext.a.L(textView2);
        String string = getString(com.iqoption.deposit.r.h.terms_and_conditions);
        kotlin.jvm.internal.h.d(string, "getString(R.string.terms_and_conditions)");
        com.iqoption.core.util.a.a aVar = new com.iqoption.core.util.a.a(string, "");
        string = getString(com.iqoption.deposit.r.h.by_clicking_deposit_you_confirm_n1, aVar.getText());
        kotlin.jvm.internal.h.d(string, "text");
        com.iqoption.core.util.a.d.a(new com.iqoption.core.util.a.e(new com.iqoption.core.util.a.a[]{aVar}, textView2, string, com.iqoption.deposit.r.c.green, com.iqoption.deposit.r.c.green_60, false, new i(this), 32, null));
    }

    private final void acy() {
        TextView textView = adw().bZX;
        kotlin.jvm.internal.h.d(textView, "buttonBinding.depositBottomButtonText");
        com.iqoption.core.ext.a.hide(textView);
        ContentLoadingProgressBar contentLoadingProgressBar = adw().bZW;
        kotlin.jvm.internal.h.d(contentLoadingProgressBar, "buttonBinding.depositBottomButtonProgress");
        contentLoadingProgressBar.setVisibility(0);
    }

    private final void acz() {
        TextView textView = adw().bZX;
        kotlin.jvm.internal.h.d(textView, "buttonBinding.depositBottomButtonText");
        com.iqoption.core.ext.a.L(textView);
        ContentLoadingProgressBar contentLoadingProgressBar = adw().bZW;
        kotlin.jvm.internal.h.d(contentLoadingProgressBar, "buttonBinding.depositBottomButtonProgress");
        contentLoadingProgressBar.setVisibility(4);
    }

    @SuppressLint({"SetTextI18n"})
    private final void i(PayMethod payMethod) {
        CharSequence a;
        this.bVQ = payMethod;
        ady();
        if (payMethod != null) {
            a = com.iqoption.deposit.menu.method.c.a(payMethod, com.iqoption.core.ext.a.m(this), true, false, 4, null);
        } else {
            String string = getString(com.iqoption.deposit.r.h.deposit1);
            kotlin.jvm.internal.h.d(string, "getString(R.string.deposit1)");
            a = string;
        }
        TextView textView = adv().bZj.cav;
        kotlin.jvm.internal.h.d(textView, "binding.toolbarTitleLayo….depositPerformLightTitle");
        textView.setText(a);
        if (payMethod != null) {
            com.iqoption.core.ui.navigation.h abt;
            if ((payMethod instanceof com.iqoption.core.microservices.billing.response.deposit.h) || com.iqoption.core.microservices.billing.response.deposit.e.b(payMethod)) {
                abt = com.iqoption.deposit.light.a.a.caB.abt();
            } else {
                abt = com.iqoption.deposit.light.constructor.a.caH.abt();
            }
            YN().a(abt);
            adv().bZk.requestFocus();
        }
        adA();
        adz();
    }

    /* JADX WARNING: Missing block: B:14:0x0032, code:
            if (r1.UU() == true) goto L_0x0034;
     */
    private final void adA() {
        /*
        r4 = this;
        r0 = r4.adw();
        r0 = r0.bZV;
        r1 = "buttonBinding.depositBottomButton";
        kotlin.jvm.internal.h.d(r0, r1);
        r1 = r4.aTd;
        r2 = 0;
        r3 = 1;
        if (r1 == 0) goto L_0x0034;
    L_0x0011:
        r1 = r4.bVQ;
        if (r1 != 0) goto L_0x0016;
    L_0x0015:
        goto L_0x0034;
    L_0x0016:
        r1 = r4.acp();
        if (r1 == 0) goto L_0x001e;
    L_0x001c:
        r2 = 1;
        goto L_0x0034;
    L_0x001e:
        r1 = r4.abQ();
        if (r1 == 0) goto L_0x001c;
    L_0x0024:
        r1 = r4.bVQ;
        r1 = r1 instanceof com.iqoption.core.microservices.billing.response.deposit.g;
        if (r1 == 0) goto L_0x001c;
    L_0x002a:
        r1 = r4.bVQ;
        if (r1 == 0) goto L_0x001c;
    L_0x002e:
        r1 = r1.UU();
        if (r1 != r3) goto L_0x001c;
    L_0x0034:
        r0.setEnabled(r2);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.deposit.light.perform.b.adA():void");
    }

    private final Double acB() {
        EditText editText = adv().bZa;
        kotlin.jvm.internal.h.d(editText, "binding.depositAmountEdit");
        Editable text = editText.getText();
        kotlin.jvm.internal.h.d(text, "text");
        Double d = null;
        if ((((CharSequence) text).length() == 0 ? 1 : null) != null) {
            return null;
        }
        try {
            Double valueOf;
            BigDecimal bigDecimal = new BigDecimal(text.toString());
            if (bigDecimal.compareTo(BigDecimal.valueOf(kotlin.jvm.internal.g.euu.aXX())) == -1) {
                valueOf = Double.valueOf(bigDecimal.doubleValue());
            } else {
                valueOf = Double.valueOf(kotlin.jvm.internal.g.euu.aXX());
            }
            d = valueOf;
        } catch (NumberFormatException e) {
            com.iqoption.core.i.e(TAG, "error when getting deposit amount", e);
        }
        return d;
    }

    static /* synthetic */ void a(b bVar, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        bVar.p(str, z);
    }

    private final void p(String str, boolean z) {
        if (str == null || !z) {
            TextView textView = adv().bZb;
            kotlin.jvm.internal.h.d(textView, "binding.depositAmountKycError");
            com.iqoption.core.ext.a.M(textView);
            EditText editText = adv().bZa;
            kotlin.jvm.internal.h.d(editText, "binding.depositAmountEdit");
            com.iqoption.deposit.light.a.b(editText, str);
        } else {
            hk(str);
        }
        adv().bZc.setTextColor(com.iqoption.core.ext.a.i(com.iqoption.core.ext.a.m(this), str != null ? com.iqoption.deposit.r.c.red : com.iqoption.deposit.r.c.deposit_dark_grey));
    }

    private final void hk(String str) {
        EditText editText = adv().bZa;
        kotlin.jvm.internal.h.d(editText, "binding.depositAmountEdit");
        com.iqoption.deposit.light.a.b(editText, null);
        TextView textView = adv().bZb;
        kotlin.jvm.internal.h.d(textView, "binding.depositAmountKycError");
        com.iqoption.core.ext.a.L(textView);
        com.iqoption.deposit.k kVar = com.iqoption.deposit.k.bVt;
        Fragment fragment = this;
        TextView textView2 = adv().bZb;
        kotlin.jvm.internal.h.d(textView2, "binding.depositAmountKycError");
        kVar.a(fragment, textView2, str, false);
        adv().bZa.setTextColor(com.iqoption.core.ext.a.i(com.iqoption.core.ext.a.m(this), com.iqoption.deposit.r.c.red));
        adv().bZa.requestFocus();
    }

    public int YO() {
        return com.iqoption.deposit.r.f.depositFields;
    }

    private final boolean abQ() {
        return com.iqoption.deposit.navigator.b.cbG.J(this);
    }
}
