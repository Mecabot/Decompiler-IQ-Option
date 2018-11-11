package com.iqoption.deposit.dark;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.design.widget.IQTextInputLayout;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.iqoption.core.microservices.billing.response.deposit.PayMethod;
import com.iqoption.core.ui.viewmodel.welcome.TermsViewModel.TERMS;
import com.iqoption.deposit.a.be;
import com.iqoption.deposit.a.bi;
import com.iqoption.deposit.a.bm;
import com.iqoption.deposit.a.bs;
import com.iqoption.deposit.a.bx;
import com.iqoption.dto.ChartTimeInterval;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1Impl;

@kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000Þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00012\u00020\u00012\u00020\u0002:\u0002\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010K\u001a\u00020LH\u0016J\u000f\u0010M\u001a\u0004\u0018\u00010NH\u0002¢\u0006\u0002\u0010OJ\b\u0010P\u001a\u0004\u0018\u00010QJ\b\u0010R\u001a\u00020*H\u0002J\b\u0010S\u001a\u00020*H\u0002J\b\u0010T\u001a\u00020*H\u0002J\b\u0010U\u001a\u00020VH\u0002J\b\u0010W\u001a\u00020VH\u0002J\u0012\u0010X\u001a\u00020*2\b\u0010Y\u001a\u0004\u0018\u00010ZH\u0016J&\u0010[\u001a\u0004\u0018\u00010)2\u0006\u0010\\\u001a\u00020]2\b\u0010^\u001a\u0004\u0018\u00010_2\b\u0010Y\u001a\u0004\u0018\u00010ZH\u0016J\u001a\u0010`\u001a\u00020*2\b\u0010a\u001a\u0004\u0018\u00010b2\u0006\u0010c\u001a\u00020dH\u0002J\b\u0010e\u001a\u00020*H\u0016J\u0012\u0010f\u001a\u00020*2\b\u0010g\u001a\u0004\u0018\u00010hH\u0002J\u0010\u0010i\u001a\u00020*2\u0006\u0010j\u001a\u00020kH\u0016J\u0010\u0010l\u001a\u00020*2\u0006\u0010m\u001a\u00020ZH\u0016J\b\u0010n\u001a\u00020*H\u0016J\u001a\u0010o\u001a\u00020*2\u0006\u0010p\u001a\u00020)2\b\u0010Y\u001a\u0004\u0018\u00010ZH\u0016J\b\u0010q\u001a\u00020*H\u0002J\u0010\u0010r\u001a\u00020*2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0012\u0010s\u001a\u00020*2\b\u0010t\u001a\u0004\u0018\u00010@H\u0002J\b\u0010u\u001a\u00020VH\u0002J$\u0010v\u001a\u00020*2\u0006\u0010w\u001a\u00020V2\u0006\u0010c\u001a\u00020d2\n\b\u0002\u0010x\u001a\u0004\u0018\u00010&H\u0002J\b\u0010y\u001a\u00020*H\u0002J\b\u0010z\u001a\u00020*H\u0002J\b\u0010{\u001a\u00020*H\u0002J\b\u0010|\u001a\u00020*H\u0002J\b\u0010}\u001a\u00020*H\u0002J\u0010\u0010~\u001a\u00020*2\u0006\u0010\u001a\u00020VH\u0002J\t\u0010\u0001\u001a\u00020*H\u0002J\f\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0002R+\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058B@BX\u0002¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR+\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\r8B@BX\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R+\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u00168B@BX\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR/\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001ej\n\u0012\u0004\u0012\u00020\u001f\u0018\u0001` 8BX\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b!\u0010\"R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010'\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020*0(X\u0004¢\u0006\u0002\n\u0000R+\u0010,\u001a\u00020+2\u0006\u0010\u0004\u001a\u00020+8B@BX\u0002¢\u0006\u0012\n\u0004\b1\u0010\f\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R+\u00103\u001a\u0002022\u0006\u0010\u0004\u001a\u0002028B@BX\u0002¢\u0006\u0012\n\u0004\b8\u0010\f\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u0010\u00109\u001a\u0004\u0018\u00010:X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020>X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010@X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u0002\n\u0000R+\u0010C\u001a\u00020B2\u0006\u0010\u0004\u001a\u00020B8B@BX\u0002¢\u0006\u0012\n\u0004\bH\u0010\f\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u000e\u0010I\u001a\u00020JX.¢\u0006\u0002\n\u0000¨\u0006\u0001"}, aXE = {"Lcom/iqoption/deposit/dark/DepositFragment;", "Lcom/iqoption/core/ui/navigation/BaseSlotNavigatorFragment;", "Lcom/iqoption/deposit/presets/OnPresetClickListener;", "()V", "<set-?>", "Lcom/iqoption/deposit/databinding/FragmentDepositBinding;", "binding", "getBinding", "()Lcom/iqoption/deposit/databinding/FragmentDepositBinding;", "setBinding", "(Lcom/iqoption/deposit/databinding/FragmentDepositBinding;)V", "binding$delegate", "Lkotlin/properties/ReadWriteProperty;", "Lcom/iqoption/deposit/databinding/LayoutDepositButtonBinding;", "buttonBinding", "getButtonBinding", "()Lcom/iqoption/deposit/databinding/LayoutDepositButtonBinding;", "setButtonBinding", "(Lcom/iqoption/deposit/databinding/LayoutDepositButtonBinding;)V", "buttonBinding$delegate", "cashboxCounting", "Lcom/iqoption/core/microservices/billing/response/deposit/CashboxCounting;", "Lcom/iqoption/deposit/databinding/LayoutDepositContentBinding;", "contentBinding", "getContentBinding", "()Lcom/iqoption/deposit/databinding/LayoutDepositContentBinding;", "setContentBinding", "(Lcom/iqoption/deposit/databinding/LayoutDepositContentBinding;)V", "contentBinding$delegate", "defaultPreset", "Ljava/util/ArrayList;", "Lcom/iqoption/core/features/limit/CurrencyValue;", "Lkotlin/collections/ArrayList;", "getDefaultPreset", "()Ljava/util/ArrayList;", "defaultPreset$delegate", "Lkotlin/Lazy;", "lastDefaultPresetAmount", "", "payMethodClickListener", "Lkotlin/Function1;", "Landroid/view/View;", "", "Lcom/iqoption/deposit/databinding/LayoutPayMethodSelectorBinding;", "payMethodSelector", "getPayMethodSelector", "()Lcom/iqoption/deposit/databinding/LayoutPayMethodSelectorBinding;", "setPayMethodSelector", "(Lcom/iqoption/deposit/databinding/LayoutPayMethodSelectorBinding;)V", "payMethodSelector$delegate", "Lcom/iqoption/deposit/presets/PresetsAdapter;", "presetsAdapter", "getPresetsAdapter", "()Lcom/iqoption/deposit/presets/PresetsAdapter;", "setPresetsAdapter", "(Lcom/iqoption/deposit/presets/PresetsAdapter;)V", "presetsAdapter$delegate", "screenEvent", "Lcom/iqoption/core/analytics/AnalyticsSendEvent;", "scrollBounds", "Landroid/graphics/Rect;", "scrollListener", "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "selectedCurrency", "Lcom/iqoption/core/microservices/billing/response/deposit/CurrencyBilling;", "selectedMethodId", "Lcom/iqoption/deposit/databinding/LayoutDepositToolbarBinding;", "toolbarBinding", "getToolbarBinding", "()Lcom/iqoption/deposit/databinding/LayoutDepositToolbarBinding;", "setToolbarBinding", "(Lcom/iqoption/deposit/databinding/LayoutDepositToolbarBinding;)V", "toolbarBinding$delegate", "viewModel", "Lcom/iqoption/deposit/dark/DepositViewModel;", "getContainerId", "", "getDepositAmount", "", "()Ljava/lang/Double;", "getInitialEntry", "Lcom/iqoption/core/ui/navigation/NavigatorEntry;", "hidePayProgress", "initPresets", "initViews", "isContentUiVisible", "", "isKycLimitEnabled", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDepositPaymentResult", "payResponse", "Lcom/iqoption/core/microservices/billing/response/PayResponse;", "depositParams", "Lcom/iqoption/deposit/DepositParams;", "onDestroyView", "onMethodSelected", "payMethod", "Lcom/iqoption/core/microservices/billing/response/deposit/PayMethod;", "onPresetClick", "item", "Lcom/iqoption/deposit/presets/PresetItem;", "onSaveInstanceState", "outState", "onStart", "onViewCreated", "view", "performPay", "setData", "setDefaultPreset", "currency", "shouldShowKycBeforeDep", "showCompletePaymentFragment", "isSuccess", "errorMessage", "showContentUI", "showErrorUI", "showPayProgress", "showProgressUI", "subscribeOnChanges", "updatePresetsVisibility", "focused", "updateToolbarInfo", "validateAmount", "Lcom/iqoption/deposit/dark/AmountError;", "Companion", "deposit_release"})
/* compiled from: DepositFragment.kt */
public final class b extends com.iqoption.core.ui.navigation.c implements com.iqoption.deposit.b.b {
    private static final String TAG = "com.iqoption.deposit.dark.b";
    static final /* synthetic */ kotlin.reflect.j[] apP = new kotlin.reflect.j[]{kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(b.class), "binding", "getBinding()Lcom/iqoption/deposit/databinding/FragmentDepositBinding;")), kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(b.class), "toolbarBinding", "getToolbarBinding()Lcom/iqoption/deposit/databinding/LayoutDepositToolbarBinding;")), kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(b.class), "contentBinding", "getContentBinding()Lcom/iqoption/deposit/databinding/LayoutDepositContentBinding;")), kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(b.class), "payMethodSelector", "getPayMethodSelector()Lcom/iqoption/deposit/databinding/LayoutPayMethodSelectorBinding;")), kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(b.class), "buttonBinding", "getButtonBinding()Lcom/iqoption/deposit/databinding/LayoutDepositButtonBinding;")), kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(b.class), "presetsAdapter", "getPresetsAdapter()Lcom/iqoption/deposit/presets/PresetsAdapter;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(b.class), "defaultPreset", "getDefaultPreset()Ljava/util/ArrayList;"))};
    public static final a bXC = new a();
    private com.iqoption.core.microservices.billing.response.deposit.b aTd;
    private HashMap atz;
    private com.iqoption.core.a.d bXA;
    private final kotlin.jvm.a.b<View, kotlin.l> bXB = new DepositFragment$payMethodClickListener$1(this);
    private DepositViewModel bXn;
    private final kotlin.e.d bXo = kotlin.e.a.euA.aYg();
    private final kotlin.e.d bXp = kotlin.e.a.euA.aYg();
    private final kotlin.e.d bXq = kotlin.e.a.euA.aYg();
    private final kotlin.e.d bXr = kotlin.e.a.euA.aYg();
    private final kotlin.e.d bXs = kotlin.e.a.euA.aYg();
    private final kotlin.e.d bXt = kotlin.e.a.euA.aYg();
    private String bXu;
    private com.iqoption.core.microservices.billing.response.deposit.c bXv;
    private final OnScrollChangedListener bXw = new n(this);
    private final Rect bXx = new Rect();
    private final kotlin.d bXy = g.f(new DepositFragment$defaultPreset$2(this));
    private String bXz;

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\f\u001a\u00020\r2\u001a\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fj\n\u0012\u0004\u0012\u00020\u0010\u0018\u0001`\u0011R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, aXE = {"Lcom/iqoption/deposit/dark/DepositFragment$Companion;", "", "()V", "ARG_DEFAULT_PRESET", "", "STATE_CURRENCY", "STATE_SELECTED_ID", "TAG", "getTAG", "()Ljava/lang/String;", "TOOLBAR_ANIMATION_MILLIS", "", "createNavigatorEntry", "Lcom/iqoption/core/ui/navigation/NavigatorEntry;", "depositPreset", "Ljava/util/ArrayList;", "Lcom/iqoption/core/features/limit/CurrencyValue;", "Lkotlin/collections/ArrayList;", "deposit_release"})
    /* compiled from: DepositFragment.kt */
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

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, aXE = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "focused", "", "onFocusChange"})
    /* compiled from: DepositFragment.kt */
    static final class b implements OnFocusChangeListener {
        final /* synthetic */ b this$0;

        @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, aXE = {"com/iqoption/core/ext/AndroidExtensionsKt$doOnLayout$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "core_release"})
        /* compiled from: AndroidExtensions.kt */
        public static final class a implements OnGlobalLayoutListener {
            final /* synthetic */ View aGz;
            final /* synthetic */ b bXD;
            final /* synthetic */ boolean bXE;

            public a(View view, b bVar, boolean z) {
                this.aGz = view;
                this.bXD = bVar;
                this.bXE = z;
            }

            public void onGlobalLayout() {
                this.aGz.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                this.bXD.this$0.ct(this.bXE);
            }
        }

        b(b bVar) {
            this.this$0 = bVar;
        }

        public final void onFocusChange(View view, boolean z) {
            if (this.this$0.Yu()) {
                this.this$0.ct(z);
            } else {
                view = this.this$0.acj().getRoot();
                kotlin.jvm.internal.h.d(view, "binding.root");
                view.getViewTreeObserver().addOnGlobalLayoutListener(new a(view, this, z));
            }
            if (z) {
                Double n = this.this$0.acB();
                com.iqoption.core.f.RQ().Ds().b("deposit-page_amount", n != null ? n.doubleValue() : 0.0d, com.iqoption.deposit.c.c.ceC.aeh());
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: DepositFragment.kt */
    static final class e implements OnClickListener {
        final /* synthetic */ b this$0;

        e(b bVar) {
            this.this$0 = bVar;
        }

        public final void onClick(View view) {
            com.iqoption.deposit.navigator.b.cbG.a(this.this$0, false);
            com.iqoption.core.f.RQ().Ds().a("deposit-page_back", com.iqoption.deposit.c.c.ceC.aeh());
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: DepositFragment.kt */
    static final class f implements OnClickListener {
        final /* synthetic */ b this$0;

        f(b bVar) {
            this.this$0 = bVar;
        }

        public final void onClick(View view) {
            this.this$0.acs();
            com.iqoption.core.f.RQ().Ds().a("deposit-page_deposit", 1.0d, com.iqoption.deposit.c.c.ceC.aeh());
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: DepositFragment.kt */
    static final class g implements OnClickListener {
        final /* synthetic */ b this$0;

        g(b bVar) {
            this.this$0 = bVar;
        }

        public final void onClick(View view) {
            com.iqoption.core.f.RQ().Ds().a("deposit-page_deposit", 0.0d, com.iqoption.deposit.c.c.ceC.aeh());
            this.this$0.acs();
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: DepositFragment.kt */
    static final class h implements OnClickListener {
        final /* synthetic */ b this$0;

        h(b bVar) {
            this.this$0 = bVar;
        }

        public final void onClick(View view) {
            com.iqoption.core.microservices.billing.response.deposit.b c = this.this$0.aTd;
            ArrayList Td = c != null ? c.Td() : null;
            if (Td == null) {
                kotlin.jvm.internal.h.aXZ();
            }
            com.iqoption.deposit.dark.menu.currency.c.a aVar = com.iqoption.deposit.dark.menu.currency.c.bYk;
            List list = Td;
            com.iqoption.core.microservices.billing.response.deposit.c d = this.this$0.bXv;
            com.iqoption.core.ui.navigation.j.b(com.iqoption.deposit.navigator.b.cbG.G(this.this$0), aVar.a(new com.iqoption.deposit.menu.currency.b(list, d != null ? Long.valueOf(d.getId()) : null)), false, 2, null);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "onGlobalLayout"})
    /* compiled from: DepositFragment.kt */
    static final class i implements OnGlobalLayoutListener {
        final /* synthetic */ b this$0;

        i(b bVar) {
            this.this$0 = bVar;
        }

        public final void onGlobalLayout() {
            if (this.this$0.isAdded()) {
                this.this$0.acA();
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "onScrollChanged"})
    /* compiled from: DepositFragment.kt */
    static final class n implements OnScrollChangedListener {
        final /* synthetic */ b this$0;

        n(b bVar) {
            this.this$0 = bVar;
        }

        public final void onScrollChanged() {
            this.this$0.acA();
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
    /* compiled from: DepositFragment.kt */
    static final class t implements Runnable {
        final /* synthetic */ FrameLayout bXH;

        t(FrameLayout frameLayout) {
            this.bXH = frameLayout;
        }

        public final void run() {
            FrameLayout frameLayout = this.bXH;
            kotlin.jvm.internal.h.d(frameLayout, "toolbarView");
            com.iqoption.core.ext.a.M(frameLayout);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, aXE = {"com/iqoption/core/ext/AndroidExtensionsKt$setOnDelayedClickListener$1", "Lcom/iqoption/core/ext/OnDelayClickListener;", "onDelayClick", "", "v", "Landroid/view/View;", "core_release"})
    /* compiled from: AndroidExtensions.kt */
    public static final class c extends com.iqoption.core.ext.g {
        final /* synthetic */ kotlin.jvm.a.b aPd;

        public c(kotlin.jvm.a.b bVar) {
            this.aPd = bVar;
            super(0, 1, null);
        }

        public void q(View view) {
            kotlin.jvm.internal.h.e(view, "v");
            this.aPd.invoke(view);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, aXE = {"com/iqoption/deposit/dark/DepositFragment$initViews$1", "Lcom/iqoption/core/util/TextWatcherAdapter;", "prevText", "Landroid/text/Editable;", "afterTextChanged", "", "text", "deposit_release"})
    /* compiled from: DepositFragment.kt */
    public static final class d extends com.iqoption.core.util.r {
        private Editable bXF;
        final /* synthetic */ b this$0;

        d(b bVar) {
            this.this$0 = bVar;
        }

        public void afterTextChanged(Editable editable) {
            kotlin.jvm.internal.h.e(editable, "text");
            super.afterTextChanged(editable);
            if (!kotlin.jvm.internal.h.E(this.bXF, editable)) {
                if (this.this$0.aTd == null || this.this$0.bXv == null || this.this$0.act() != null) {
                    b.f(this.this$0).a(null);
                } else {
                    b.f(this.this$0).a(new BigDecimal(editable.toString()));
                    IQTextInputLayout iQTextInputLayout = this.this$0.acl().cab;
                    kotlin.jvm.internal.h.d(iQTextInputLayout, "contentBinding.depositAmountInput");
                    iQTextInputLayout.setError((CharSequence) null);
                }
                this.bXF = editable;
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "cashboxCounting", "Lcom/iqoption/core/microservices/billing/response/deposit/CashboxCounting;", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: DepositFragment.kt */
    static final class j<T> implements io.reactivex.c.e<com.iqoption.core.microservices.billing.response.deposit.b> {
        final /* synthetic */ b this$0;

        j(b bVar) {
            this.this$0 = bVar;
        }

        /* renamed from: c */
        public final void accept(com.iqoption.core.microservices.billing.response.deposit.b bVar) {
            if (bVar != null) {
                this.this$0.acw();
                this.this$0.b(bVar);
                return;
            }
            this.this$0.acv();
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "error", "", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: DepositFragment.kt */
    static final class k<T> implements io.reactivex.c.e<Throwable> {
        final /* synthetic */ b this$0;

        k(b bVar) {
            this.this$0 = bVar;
        }

        /* renamed from: o */
        public final void accept(Throwable th) {
            com.iqoption.core.i.e("Unable to load counting", th);
            this.this$0.acv();
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/core/microservices/billing/response/PayResponse;", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: DepositFragment.kt */
    static final class l<T> implements io.reactivex.c.e<com.iqoption.core.microservices.billing.response.c> {
        final /* synthetic */ com.iqoption.deposit.p bXG;
        final /* synthetic */ b this$0;

        l(b bVar, com.iqoption.deposit.p pVar) {
            this.this$0 = bVar;
            this.bXG = pVar;
        }

        /* renamed from: a */
        public final void accept(com.iqoption.core.microservices.billing.response.c cVar) {
            this.this$0.acz();
            this.this$0.a(cVar, this.bXG);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "error", "", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: DepositFragment.kt */
    static final class m<T> implements io.reactivex.c.e<Throwable> {
        final /* synthetic */ com.iqoption.deposit.p bXG;
        final /* synthetic */ b this$0;

        m(b bVar, com.iqoption.deposit.p pVar) {
            this.this$0 = bVar;
            this.bXG = pVar;
        }

        /* renamed from: o */
        public final void accept(Throwable th) {
            com.iqoption.core.i.e("Unable to pay", th);
            this.this$0.acz();
            b.a(this.this$0, false, this.bXG, null, 4, null);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, aXE = {"com/iqoption/deposit/dark/DepositFragment$setData$5", "Lcom/iqoption/core/util/link/LinkClickListener;", "onLinkClicked", "", "link", "Lcom/iqoption/core/util/link/Link;", "deposit_release"})
    /* compiled from: DepositFragment.kt */
    public static final class o implements com.iqoption.core.util.a.b {
        final /* synthetic */ b this$0;

        o(b bVar) {
            this.this$0 = bVar;
        }

        public void a(com.iqoption.core.util.a.a aVar) {
            kotlin.jvm.internal.h.e(aVar, "link");
            com.iqoption.core.ui.navigation.j.b(com.iqoption.deposit.navigator.b.cbG.G(this.this$0), com.iqoption.core.ui.fragment.c.bbF.a(TERMS.CONDITIONS), false, 2, null);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/core/microservices/billing/response/deposit/PayMethod;", "onChanged"})
    /* compiled from: DepositFragment.kt */
    static final class p<T> implements Observer<PayMethod> {
        final /* synthetic */ b this$0;

        p(b bVar) {
            this.this$0 = bVar;
        }

        /* renamed from: h */
        public final void onChanged(PayMethod payMethod) {
            this.this$0.i(payMethod);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "currency", "Lcom/iqoption/core/microservices/billing/response/deposit/CurrencyBilling;", "onChanged"})
    /* compiled from: DepositFragment.kt */
    static final class q<T> implements Observer<com.iqoption.core.microservices.billing.response.deposit.c> {
        final /* synthetic */ b this$0;

        q(b bVar) {
            this.this$0 = bVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:8:0x0073  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x00a7  */
        /* renamed from: c */
        public final void onChanged(com.iqoption.core.microservices.billing.response.deposit.c r6) {
            /*
            r5 = this;
            if (r6 == 0) goto L_0x00ae;
        L_0x0002:
            r0 = r5.this$0;
            r0.bXv = r6;
            r0 = r5.this$0;
            r0 = r0.acl();
            r0 = r0.cab;
            r1 = "contentBinding.depositAmountInput";
            kotlin.jvm.internal.h.d(r0, r1);
            r1 = new java.lang.StringBuilder;
            r1.<init>();
            r2 = r5.this$0;
            r3 = com.iqoption.deposit.r.h.amount;
            r2 = r2.getString(r3);
            r1.append(r2);
            r2 = " (";
            r1.append(r2);
            r2 = r6.getName();
            r1.append(r2);
            r2 = 41;
            r1.append(r2);
            r1 = r1.toString();
            r1 = (java.lang.CharSequence) r1;
            r0.setHint(r1);
            r0 = r5.this$0;
            r0 = r0.acl();
            r0 = r0.bZZ;
            r0 = r0.bZU;
            r1 = "contentBinding.currencySelector.selectCurrencyName";
            kotlin.jvm.internal.h.d(r0, r1);
            r1 = r6.getName();
            r1 = (java.lang.CharSequence) r1;
            r0.setText(r1);
            r0 = r5.this$0;
            r0 = r0.aTd;
            r1 = 0;
            if (r0 == 0) goto L_0x0070;
        L_0x005f:
            r0 = r0.UJ();
            if (r0 == 0) goto L_0x0070;
        L_0x0065:
            r2 = r6.getName();
            r0 = r0.get(r2);
            r0 = (java.util.ArrayList) r0;
            goto L_0x0071;
        L_0x0070:
            r0 = r1;
        L_0x0071:
            if (r0 == 0) goto L_0x009e;
        L_0x0073:
            r0 = (java.lang.Iterable) r0;
            r1 = new java.util.ArrayList;
            r2 = 10;
            r2 = kotlin.collections.n.e(r0, r2);
            r1.<init>(r2);
            r1 = (java.util.Collection) r1;
            r0 = r0.iterator();
        L_0x0086:
            r2 = r0.hasNext();
            if (r2 == 0) goto L_0x009c;
        L_0x008c:
            r2 = r0.next();
            r2 = (com.iqoption.core.microservices.billing.response.deposit.d) r2;
            r3 = new com.iqoption.deposit.b.c;
            r4 = 0;
            r3.<init>(r2, r6, r4);
            r1.add(r3);
            goto L_0x0086;
        L_0x009c:
            r1 = (java.util.List) r1;
        L_0x009e:
            r0 = r5.this$0;
            r0 = r0.aco();
            if (r1 == 0) goto L_0x00a7;
        L_0x00a6:
            goto L_0x00ab;
        L_0x00a7:
            r1 = kotlin.collections.m.emptyList();
        L_0x00ab:
            r0.ap(r1);
        L_0x00ae:
            r0 = r5.this$0;
            r0.b(r6);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iqoption.deposit.dark.b.q.c(com.iqoption.core.microservices.billing.response.deposit.c):void");
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "deposit", "Lcom/iqoption/core/microservices/billing/response/deposit/Deposit;", "onChanged"})
    /* compiled from: DepositFragment.kt */
    static final class r<T> implements Observer<com.iqoption.core.microservices.billing.response.deposit.d> {
        final /* synthetic */ b this$0;

        r(b bVar) {
            this.this$0 = bVar;
        }

        /* renamed from: c */
        public final void onChanged(com.iqoption.core.microservices.billing.response.deposit.d dVar) {
            if (dVar != null) {
                String a = com.iqoption.deposit.h.a(dVar);
                this.this$0.acl().caa.setText(a);
                this.this$0.acl().caa.setSelection(a.length());
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "amount", "Ljava/math/BigDecimal;", "onChanged"})
    /* compiled from: DepositFragment.kt */
    static final class s<T> implements Observer<BigDecimal> {
        final /* synthetic */ b this$0;

        s(b bVar) {
            this.this$0 = bVar;
        }

        /* renamed from: b */
        public final void onChanged(BigDecimal bigDecimal) {
            String string = this.this$0.getString(com.iqoption.deposit.r.h.deposit1);
            String str = null;
            TextView textView;
            if (bigDecimal == null || this.this$0.bXv == null) {
                textView = this.this$0.acn().bZX;
                kotlin.jvm.internal.h.d(textView, "buttonBinding.depositBottomButtonText");
                CharSequence charSequence = string;
                textView.setText(charSequence);
                textView = this.this$0.ack().cal;
                kotlin.jvm.internal.h.d(textView, "toolbarBinding.toolbarDeposit");
                textView.setText(charSequence);
            } else {
                textView = this.this$0.acn().bZX;
                kotlin.jvm.internal.h.d(textView, "buttonBinding.depositBottomButtonText");
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string);
                stringBuilder.append(' ');
                com.iqoption.core.microservices.billing.response.deposit.c d = this.this$0.bXv;
                if (d == null) {
                    kotlin.jvm.internal.h.aXZ();
                }
                stringBuilder.append(com.iqoption.core.util.c.a(bigDecimal, d, false, 2, null));
                textView.setText(stringBuilder.toString());
                textView = this.this$0.ack().cal;
                kotlin.jvm.internal.h.d(textView, "toolbarBinding.toolbarDeposit");
                stringBuilder = new StringBuilder();
                stringBuilder.append(string);
                stringBuilder.append(' ');
                com.iqoption.core.microservices.billing.response.deposit.c d2 = this.this$0.bXv;
                if (d2 == null) {
                    kotlin.jvm.internal.h.aXZ();
                }
                stringBuilder.append(com.iqoption.core.util.c.a(bigDecimal, d2, true));
                textView.setText(stringBuilder.toString());
            }
            com.iqoption.deposit.b.f j = this.this$0.aco();
            if (bigDecimal != null) {
                str = com.iqoption.core.util.c.a(bigDecimal, 0, null, true, false, null, 27, null);
            }
            j.setSelection(str);
        }
    }

    private final void a(bi biVar) {
        this.bXs.a(this, apP[4], biVar);
    }

    private final void a(bm bmVar) {
        this.bXq.a(this, apP[2], bmVar);
    }

    private final void a(bs bsVar) {
        this.bXp.a(this, apP[1], bsVar);
    }

    private final void a(bx bxVar) {
        this.bXr.a(this, apP[3], bxVar);
    }

    private final void a(com.iqoption.deposit.a.m mVar) {
        this.bXo.a(this, apP[0], mVar);
    }

    private final void a(com.iqoption.deposit.b.f fVar) {
        this.bXt.a(this, apP[5], fVar);
    }

    private final ArrayList<com.iqoption.core.c.c.a> aaD() {
        kotlin.d dVar = this.bXy;
        kotlin.reflect.j jVar = apP[6];
        return (ArrayList) dVar.getValue();
    }

    private final com.iqoption.deposit.a.m acj() {
        return (com.iqoption.deposit.a.m) this.bXo.b(this, apP[0]);
    }

    private final bs ack() {
        return (bs) this.bXp.b(this, apP[1]);
    }

    private final bm acl() {
        return (bm) this.bXq.b(this, apP[2]);
    }

    private final bx acm() {
        return (bx) this.bXr.b(this, apP[3]);
    }

    private final bi acn() {
        return (bi) this.bXs.b(this, apP[4]);
    }

    private final com.iqoption.deposit.b.f aco() {
        return (com.iqoption.deposit.b.f) this.bXt.b(this, apP[5]);
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

    public static final /* synthetic */ DepositViewModel f(b bVar) {
        DepositViewModel depositViewModel = bVar.bXn;
        if (depositViewModel == null) {
            kotlin.jvm.internal.h.lS("viewModel");
        }
        return depositViewModel;
    }

    static {
        if (b.class.getName() == null) {
            kotlin.jvm.internal.h.aXZ();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bXn = DepositViewModel.bXI.B(this);
        if (bundle != null) {
            this.bXv = (com.iqoption.core.microservices.billing.response.deposit.c) bundle.getParcelable("STATE_CURRENCY");
            this.bXu = bundle.getString("STATE_SELECTED_ID");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.h.e(layoutInflater, "inflater");
        a((com.iqoption.deposit.a.m) com.iqoption.core.ext.a.a((Fragment) this, com.iqoption.deposit.r.g.fragment_deposit, viewGroup, false, 4, null));
        bs bsVar = acj().bYS;
        kotlin.jvm.internal.h.d(bsVar, "binding.depositToolbar");
        a(bsVar);
        bm bmVar = acj().bYP;
        kotlin.jvm.internal.h.d(bmVar, "binding.depositContent");
        a(bmVar);
        bx bxVar = acl().cae;
        kotlin.jvm.internal.h.d(bxVar, "contentBinding.payMethodSelector");
        a(bxVar);
        bi biVar = acl().cac;
        kotlin.jvm.internal.h.d(biVar, "contentBinding.depositBottomButtonBinding");
        a(biVar);
        return acj().getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.h.e(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        abr();
        DepositViewModel depositViewModel = this.bXn;
        if (depositViewModel == null) {
            kotlin.jvm.internal.h.lS("viewModel");
        }
        io.reactivex.disposables.b a = depositViewModel.bE(abQ()).d(com.iqoption.core.h.i.Yo()).c(com.iqoption.core.h.i.Yp()).a((io.reactivex.c.e) new j(this), (io.reactivex.c.e) new k(this));
        kotlin.jvm.internal.h.d(a, "viewModel.getCounting(is…      }\n                )");
        a(a);
        acq();
        this.bXA = com.iqoption.core.f.RQ().Ds().d("deposit-page_show", 0.0d, com.iqoption.deposit.c.c.ceC.aeh());
    }

    private final void abr() {
        acz();
        TextInputEditText textInputEditText = acl().caa;
        kotlin.jvm.internal.h.d(textInputEditText, "contentBinding.depositAmountEdit");
        com.iqoption.core.ext.a.a((EditText) textInputEditText, (InputFilter) new com.iqoption.core.ui.widget.a(2));
        acl().caa.addTextChangedListener(new d(this));
        ack().bTH.setOnClickListener(new e(this));
        ack().cal.setOnClickListener(new f(this));
        acn().bZV.setOnClickListener(new g(this));
        ScrollView scrollView = acl().cad;
        kotlin.jvm.internal.h.d(scrollView, "contentBinding.depositScroll");
        scrollView.getViewTreeObserver().addOnScrollChangedListener(this.bXw);
        be beVar = acl().bZZ;
        kotlin.jvm.internal.h.d(beVar, "contentBinding.currencySelector");
        beVar.getRoot().setOnClickListener(new h(this));
        acr();
        LinearLayout linearLayout = acm().car;
        kotlin.jvm.internal.h.d(linearLayout, "payMethodSelector.payMethodSelectorContainer");
        linearLayout.setOnClickListener(new c(this.bXB));
        acu();
        scrollView = acl().cad;
        kotlin.jvm.internal.h.d(scrollView, "contentBinding.depositScroll");
        scrollView.getViewTreeObserver().addOnGlobalLayoutListener(new i(this));
    }

    public void onStart() {
        super.onStart();
        bx bxVar;
        View root;
        FrameLayout frameLayout;
        if (acp()) {
            bxVar = acl().cae;
            kotlin.jvm.internal.h.d(bxVar, "contentBinding.payMethodSelector");
            root = bxVar.getRoot();
            kotlin.jvm.internal.h.d(root, "contentBinding.payMethodSelector.root");
            com.iqoption.core.ext.a.M(root);
            frameLayout = acl().bZe;
            kotlin.jvm.internal.h.d(frameLayout, "contentBinding.depositFields");
            com.iqoption.core.ext.a.M(frameLayout);
            return;
        }
        bxVar = acl().cae;
        kotlin.jvm.internal.h.d(bxVar, "contentBinding.payMethodSelector");
        root = bxVar.getRoot();
        kotlin.jvm.internal.h.d(root, "contentBinding.payMethodSelector.root");
        com.iqoption.core.ext.a.L(root);
        frameLayout = acl().bZe;
        kotlin.jvm.internal.h.d(frameLayout, "contentBinding.depositFields");
        com.iqoption.core.ext.a.L(frameLayout);
    }

    private final boolean acp() {
        return com.iqoption.deposit.navigator.b.cbG.H(this);
    }

    private final void acq() {
        DepositViewModel depositViewModel = this.bXn;
        if (depositViewModel == null) {
            kotlin.jvm.internal.h.lS("viewModel");
        }
        LifecycleOwner lifecycleOwner = this;
        depositViewModel.aaJ().observe(lifecycleOwner, new p(this));
        depositViewModel = this.bXn;
        if (depositViewModel == null) {
            kotlin.jvm.internal.h.lS("viewModel");
        }
        depositViewModel.aaK().observe(lifecycleOwner, new q(this));
        depositViewModel = this.bXn;
        if (depositViewModel == null) {
            kotlin.jvm.internal.h.lS("viewModel");
        }
        depositViewModel.aaL().observe(lifecycleOwner, new r(this));
        depositViewModel = this.bXn;
        if (depositViewModel == null) {
            kotlin.jvm.internal.h.lS("viewModel");
        }
        depositViewModel.aaM().observe(lifecycleOwner, new s(this));
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
        r0 = r12.acl();
        r0 = r0.caa;
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
        r13 = r12.aco();
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
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.deposit.dark.b.b(com.iqoption.core.microservices.billing.response.deposit.c):void");
    }

    public void onSaveInstanceState(Bundle bundle) {
        kotlin.jvm.internal.h.e(bundle, "outState");
        String str = this.bXu;
        if (str != null) {
            bundle.putString("STATE_SELECTED_ID", str);
        }
        com.iqoption.core.microservices.billing.response.deposit.c cVar = this.bXv;
        if (cVar != null) {
            bundle.putParcelable("STATE_CURRENCY", cVar);
        }
        super.onSaveInstanceState(bundle);
    }

    public void onDestroyView() {
        com.iqoption.core.a.d dVar = this.bXA;
        if (dVar != null) {
            dVar.Bs();
        }
        ScrollView scrollView = acl().cad;
        kotlin.jvm.internal.h.d(scrollView, "contentBinding.depositScroll");
        scrollView.getViewTreeObserver().removeOnScrollChangedListener(this.bXw);
        super.onDestroyView();
        KH();
    }

    private final void acr() {
        RecyclerView recyclerView = acl().bZh;
        kotlin.jvm.internal.h.d(recyclerView, "presetsList");
        recyclerView.setLayoutManager(new LinearLayoutManager(com.iqoption.core.ext.a.m(this), 0, false));
        com.iqoption.core.ui.a.a(recyclerView, getResources().getDimension(com.iqoption.deposit.r.d.dp8), false);
        a(new com.iqoption.deposit.b.f(this));
        recyclerView.setAdapter(aco());
        TextInputEditText textInputEditText = acl().caa;
        if (com.iqoption.deposit.navigator.b.cbG.L(this)) {
            com.iqoption.core.ext.a.M(recyclerView);
            textInputEditText.setOnFocusChangeListener(new b(this));
        }
    }

    private final void ct(boolean z) {
        RecyclerView recyclerView = acl().bZh;
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
        DepositViewModel depositViewModel = this.bXn;
        if (depositViewModel == null) {
            kotlin.jvm.internal.h.lS("viewModel");
        }
        depositViewModel.b(cVar.adX());
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
        a act = act();
        if (act == null) {
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
            com.iqoption.deposit.p pVar = new com.iqoption.deposit.p(bigDecimal, cVar);
            DepositViewModel depositViewModel = this.bXn;
            if (depositViewModel == null) {
                kotlin.jvm.internal.h.lS("viewModel");
            }
            depositViewModel.a(qVar.aaS(), pVar.aaH().getName(), pVar.VZ(), qVar.aaR()).h(com.iqoption.core.h.i.Yo()).g(com.iqoption.core.h.i.Yp()).a((io.reactivex.c.e) new l(this, pVar), (io.reactivex.c.e) new m(this, pVar));
        } else if (!z) {
            IQTextInputLayout iQTextInputLayout = acl().cab;
            kotlin.jvm.internal.h.d(iQTextInputLayout, "contentBinding.depositAmountInput");
            if (act == null) {
                kotlin.jvm.internal.h.aXZ();
            }
            iQTextInputLayout.setError(act.getErrorMessage());
            if (act.ach()) {
                iQTextInputLayout = acl().cab;
                kotlin.jvm.internal.h.d(iQTextInputLayout, "contentBinding.depositAmountInput");
                TextView errorView = iQTextInputLayout.getErrorView();
                com.iqoption.deposit.k kVar = com.iqoption.deposit.k.bVt;
                Fragment fragment = this;
                kotlin.jvm.internal.h.d(errorView, "errorView");
                kVar.a(fragment, errorView, act.getErrorMessage(), true);
            }
        }
    }

    private final a act() {
        Double acB = acB();
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
        if (acB == null) {
            string = getString(com.iqoption.deposit.r.h.incorrect_value);
            kotlin.jvm.internal.h.d(string, "getString(R.string.incorrect_value)");
            aVar = new a(string, false);
        } else if (acB.doubleValue() < cVar.UM()) {
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
                if (Td.size() == 1 && bVar.UL() + acB.doubleValue() > bVar.UK()) {
                    bigDecimal = new BigDecimal(bVar.UK());
                    string = getString(com.iqoption.deposit.r.h.max_deposit_total_amount_for_the_non_verified, com.iqoption.core.util.c.a(bigDecimal, cVar, true));
                    kotlin.jvm.internal.h.d(string, "message");
                    aVar = new a(string, true);
                }
            }
            if (acB.doubleValue() > cVar.UN()) {
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
        r4 = com.iqoption.deposit.dark.c.a.bYs;
        r8 = r4.a(r2, r3, r8, r9);
        r9 = com.iqoption.deposit.navigator.b.cbG;
        r2 = r7;
        r2 = (android.support.v4.app.Fragment) r2;
        r9 = r9.G(r2);
        com.iqoption.core.ui.navigation.j.a(r9, r8, r0, r6, r1);
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
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.deposit.dark.b.a(com.iqoption.core.microservices.billing.response.c, com.iqoption.deposit.p):void");
    }

    static /* bridge */ /* synthetic */ void a(b bVar, boolean z, com.iqoption.deposit.p pVar, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            str = (String) null;
        }
        bVar.a(z, pVar, str);
    }

    private final void a(boolean z, com.iqoption.deposit.p pVar, String str) {
        com.iqoption.core.util.j.n(com.iqoption.core.ext.a.n(this));
        com.iqoption.core.ui.navigation.j.a(com.iqoption.deposit.navigator.b.cbG.G(this), com.iqoption.deposit.dark.b.a.bXP.a(z ? "deposit" : "error_deposit", pVar.aaH(), pVar.VZ(), str), false, 2, null);
    }

    private final void b(com.iqoption.core.microservices.billing.response.deposit.b bVar) {
        Object obj;
        this.aTd = bVar;
        ArrayList Td = bVar.Td();
        Object obj2 = null;
        PayMethod payMethod = (PayMethod) null;
        if (this.bXu != null) {
            for (Object obj3 : bVar.UH()) {
                if (kotlin.jvm.internal.h.E(com.iqoption.core.microservices.billing.response.deposit.e.e((com.iqoption.core.microservices.billing.response.deposit.g) obj3), this.bXu)) {
                    break;
                }
            }
            obj3 = null;
            payMethod = (PayMethod) obj3;
        }
        Long M = com.iqoption.deposit.navigator.b.cbG.M(this);
        if (payMethod == null && M != null) {
            for (Object next : bVar.UH()) {
                Object obj4;
                long id = ((com.iqoption.core.microservices.billing.response.deposit.g) next).getId();
                if (M != null && id == M.longValue()) {
                    obj4 = 1;
                    continue;
                } else {
                    obj4 = null;
                    continue;
                }
                if (obj4 != null) {
                    break;
                }
            }
            Object next2 = null;
            payMethod = (PayMethod) next2;
        }
        if (payMethod == null) {
            ArrayList UG = bVar.UG();
            payMethod = UG != null ? (com.iqoption.core.microservices.billing.response.deposit.h) u.bV(UG) : null;
        }
        if (payMethod == null) {
            for (Object obj32 : bVar.UH()) {
                if (com.iqoption.core.microservices.billing.response.deposit.e.a((com.iqoption.core.microservices.billing.response.deposit.g) obj32)) {
                    break;
                }
            }
            obj32 = null;
            payMethod = (PayMethod) obj32;
        }
        if (payMethod != null) {
            DepositViewModel depositViewModel = this.bXn;
            if (depositViewModel == null) {
                kotlin.jvm.internal.h.lS("viewModel");
            }
            depositViewModel.f(payMethod);
        }
        com.iqoption.core.microservices.billing.response.deposit.c UI = bVar.UI();
        if (UI == null) {
            UI = Td != null ? (com.iqoption.core.microservices.billing.response.deposit.c) u.bV(Td) : null;
        }
        HashMap UJ = bVar.UJ();
        if (UJ != null) {
            Map map = UJ;
            if (UI != null) {
                obj2 = UI.getName();
            }
            obj2 = (ArrayList) map.get(obj2);
        }
        if (!(obj2 == null || UI == null)) {
            DepositViewModel depositViewModel2 = this.bXn;
            if (depositViewModel2 == null) {
                kotlin.jvm.internal.h.lS("viewModel");
            }
            depositViewModel2.a(UI);
        }
        this.bXv = UI;
        Object obj5 = (Td != null ? Td.size() : 0) > 1 ? 1 : null;
        be beVar;
        View root;
        if (obj5 != null) {
            beVar = acl().bZZ;
            kotlin.jvm.internal.h.d(beVar, "contentBinding.currencySelector");
            root = beVar.getRoot();
            kotlin.jvm.internal.h.d(root, "contentBinding.currencySelector.root");
            com.iqoption.core.ext.a.L(root);
        } else {
            beVar = acl().bZZ;
            kotlin.jvm.internal.h.d(beVar, "contentBinding.currencySelector");
            root = beVar.getRoot();
            kotlin.jvm.internal.h.d(root, "contentBinding.currencySelector.root");
            com.iqoption.core.ext.a.M(root);
        }
        if (obj5 == null || !com.iqoption.core.f.Dr().Dh()) {
            TextView textView = acl().bZi;
            kotlin.jvm.internal.h.d(textView, "contentBinding.depositTerms");
            com.iqoption.core.ext.a.M(textView);
            return;
        }
        TextView textView2 = acl().bZi;
        kotlin.jvm.internal.h.d(textView2, "textView");
        com.iqoption.core.ext.a.L(textView2);
        String string = getString(com.iqoption.deposit.r.h.terms_and_conditions);
        kotlin.jvm.internal.h.d(string, "getString(R.string.terms_and_conditions)");
        com.iqoption.core.util.a.a aVar = new com.iqoption.core.util.a.a(string, "");
        string = getString(com.iqoption.deposit.r.h.by_clicking_deposit_you_confirm_n1, aVar.getText());
        kotlin.jvm.internal.h.d(string, "text");
        com.iqoption.core.util.a.d.a(new com.iqoption.core.util.a.e(new com.iqoption.core.util.a.a[]{aVar}, textView2, string, 0, 0, false, new o(this), 56, null));
    }

    private final void acu() {
        FrameLayout frameLayout = acj().bYR;
        kotlin.jvm.internal.h.d(frameLayout, "binding.depositProgress");
        com.iqoption.core.ext.a.L(frameLayout);
        TextView textView = acj().bYQ;
        kotlin.jvm.internal.h.d(textView, "binding.depositError");
        com.iqoption.core.ext.a.M(textView);
        View root = acl().getRoot();
        kotlin.jvm.internal.h.d(root, "contentBinding.root");
        com.iqoption.core.ext.a.M(root);
        frameLayout = ack().cam;
        kotlin.jvm.internal.h.d(frameLayout, "toolbarBinding.toolbarDepositContainer");
        com.iqoption.core.ext.a.M(frameLayout);
    }

    private final void acv() {
        FrameLayout frameLayout = acj().bYR;
        kotlin.jvm.internal.h.d(frameLayout, "binding.depositProgress");
        com.iqoption.core.ext.a.M(frameLayout);
        TextView textView = acj().bYQ;
        kotlin.jvm.internal.h.d(textView, "binding.depositError");
        com.iqoption.core.ext.a.L(textView);
        View root = acl().getRoot();
        kotlin.jvm.internal.h.d(root, "contentBinding.root");
        com.iqoption.core.ext.a.M(root);
        frameLayout = ack().cam;
        kotlin.jvm.internal.h.d(frameLayout, "toolbarBinding.toolbarDepositContainer");
        com.iqoption.core.ext.a.M(frameLayout);
    }

    private final void acw() {
        FrameLayout frameLayout = acj().bYR;
        kotlin.jvm.internal.h.d(frameLayout, "binding.depositProgress");
        com.iqoption.core.ext.a.M(frameLayout);
        TextView textView = acj().bYQ;
        kotlin.jvm.internal.h.d(textView, "binding.depositError");
        com.iqoption.core.ext.a.M(textView);
        View root = acl().getRoot();
        kotlin.jvm.internal.h.d(root, "contentBinding.root");
        com.iqoption.core.ext.a.L(root);
    }

    private final boolean acx() {
        View root = acl().getRoot();
        kotlin.jvm.internal.h.d(root, "contentBinding.root");
        return com.iqoption.core.ext.a.I(root);
    }

    private final void acy() {
        ContentLoadingProgressBar contentLoadingProgressBar = ack().aOW;
        kotlin.jvm.internal.h.d(contentLoadingProgressBar, "toolbarBinding.toolbarProgress");
        contentLoadingProgressBar.setVisibility(0);
        TextView textView = ack().cal;
        kotlin.jvm.internal.h.d(textView, "toolbarBinding.toolbarDeposit");
        com.iqoption.core.ext.a.hide(textView);
        textView = acn().bZX;
        kotlin.jvm.internal.h.d(textView, "buttonBinding.depositBottomButtonText");
        com.iqoption.core.ext.a.hide(textView);
        contentLoadingProgressBar = acn().bZW;
        kotlin.jvm.internal.h.d(contentLoadingProgressBar, "buttonBinding.depositBottomButtonProgress");
        contentLoadingProgressBar.setVisibility(0);
    }

    private final void acz() {
        ContentLoadingProgressBar contentLoadingProgressBar = ack().aOW;
        kotlin.jvm.internal.h.d(contentLoadingProgressBar, "toolbarBinding.toolbarProgress");
        contentLoadingProgressBar.setVisibility(8);
        TextView textView = ack().cal;
        kotlin.jvm.internal.h.d(textView, "toolbarBinding.toolbarDeposit");
        com.iqoption.core.ext.a.L(textView);
        textView = acn().bZX;
        kotlin.jvm.internal.h.d(textView, "buttonBinding.depositBottomButtonText");
        com.iqoption.core.ext.a.L(textView);
        contentLoadingProgressBar = acn().bZW;
        kotlin.jvm.internal.h.d(contentLoadingProgressBar, "buttonBinding.depositBottomButtonProgress");
        contentLoadingProgressBar.setVisibility(4);
    }

    private final void acA() {
        acl().cad.getHitRect(this.bXx);
        FrameLayout frameLayout = ack().cam;
        TextView textView = acn().bZX;
        frameLayout.animate().cancel();
        if (!acx() || textView.getLocalVisibleRect(this.bXx)) {
            frameLayout.animate().setDuration(200).alpha(0.0f).withEndAction(new t(frameLayout));
            return;
        }
        kotlin.jvm.internal.h.d(frameLayout, "toolbarView");
        com.iqoption.core.ext.a.L(frameLayout);
        frameLayout.animate().setDuration(200).alpha(1.0f);
    }

    private final void i(PayMethod payMethod) {
        CharSequence charSequence = null;
        this.bXu = payMethod != null ? com.iqoption.core.microservices.billing.response.deposit.e.e(payMethod) : null;
        TextView textView = acm().caq;
        kotlin.jvm.internal.h.d(textView, "payMethodSelector.payMethodSelector");
        if (payMethod != null) {
            charSequence = com.iqoption.deposit.menu.method.c.a(payMethod, com.iqoption.core.ext.a.m(this), true, false, 4, null);
        }
        textView.setText(charSequence);
        if (payMethod != null) {
            com.iqoption.core.ui.navigation.h abt;
            if ((payMethod instanceof com.iqoption.core.microservices.billing.response.deposit.h) || com.iqoption.core.microservices.billing.response.deposit.e.b(payMethod)) {
                abt = com.iqoption.deposit.dark.a.a.bXN.abt();
            } else {
                abt = com.iqoption.deposit.dark.constructor.a.bXR.abt();
            }
            YN().a(abt);
            acl().bZY.requestFocus();
            FrameLayout frameLayout = acn().bZV;
            kotlin.jvm.internal.h.d(frameLayout, "buttonBinding.depositBottomButton");
            boolean z = (abQ() && (payMethod instanceof com.iqoption.core.microservices.billing.response.deposit.g) && payMethod.UU()) ? false : true;
            frameLayout.setEnabled(z);
        }
    }

    public int YO() {
        return com.iqoption.deposit.r.f.depositFields;
    }

    private final Double acB() {
        TextInputEditText textInputEditText = acl().caa;
        kotlin.jvm.internal.h.d(textInputEditText, "contentBinding.depositAmountEdit");
        Editable text = textInputEditText.getText();
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

    private final boolean abQ() {
        return com.iqoption.deposit.navigator.b.cbG.J(this);
    }
}
