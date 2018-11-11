package com.iqoption.welcomeonboarding.registration.country;

import android.arch.lifecycle.Lifecycle;
import android.graphics.Point;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.iqoption.d.sd;
import com.iqoption.dto.ChartTimeInterval;
import com.iqoption.view.text.x;
import com.iqoption.x.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1Impl;

@kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ?2\u00020\u00012\u00020\u0002:\u0001?B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010(\u001a\u00020)H\u0002J\b\u0010*\u001a\u00020)H\u0002J\b\u0010+\u001a\u00020)H\u0002J\n\u0010,\u001a\u0004\u0018\u00010-H\u0002J\b\u0010.\u001a\u00020/H\u0002J\u0014\u00100\u001a\u00020)2\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0015H\u0002J\b\u00102\u001a\u00020!H\u0016J\u0012\u00103\u001a\u00020)2\b\u00104\u001a\u0004\u0018\u000105H\u0016J&\u00106\u001a\u0004\u0018\u00010-2\u0006\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010:2\b\u00104\u001a\u0004\u0018\u000105H\u0016J\u0010\u0010;\u001a\u00020)2\u0006\u0010<\u001a\u00020%H\u0016J\u001a\u0010=\u001a\u00020)2\u0006\u0010>\u001a\u00020-2\b\u00104\u001a\u0004\u0018\u000105H\u0016R+\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058B@BX\u0002¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR+\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\r8B@BX\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R#\u0010\u0014\u001a\n \u0016*\u0004\u0018\u00010\u00150\u00158BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010 \u001a\u00020!8BX\u0002¢\u0006\f\n\u0004\b#\u0010\u001a\u001a\u0004\b \u0010\"R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X.¢\u0006\u0002\n\u0000¨\u0006@"}, aXE = {"Lcom/iqoption/welcomeonboarding/registration/country/CountrySearchFragment;", "Lcom/iqoption/fragment/base/IQFragment;", "Lcom/iqoption/welcomeonboarding/registration/country/OnCountryClickListener;", "()V", "<set-?>", "Lcom/iqoption/welcomeonboarding/registration/country/CountryAdapter;", "adapter", "getAdapter", "()Lcom/iqoption/welcomeonboarding/registration/country/CountryAdapter;", "setAdapter", "(Lcom/iqoption/welcomeonboarding/registration/country/CountryAdapter;)V", "adapter$delegate", "Lkotlin/properties/ReadWriteProperty;", "Lcom/iqoption/databinding/FragmentSearchCountryBinding;", "binding", "getBinding", "()Lcom/iqoption/databinding/FragmentSearchCountryBinding;", "setBinding", "(Lcom/iqoption/databinding/FragmentSearchCountryBinding;)V", "binding$delegate", "countryName", "", "kotlin.jvm.PlatformType", "getCountryName", "()Ljava/lang/String;", "countryName$delegate", "Lkotlin/Lazy;", "inputPoint", "Landroid/graphics/Point;", "getInputPoint", "()Landroid/graphics/Point;", "inputPoint$delegate", "isTrial", "", "()Z", "isTrial$delegate", "selectedCountry", "Lcom/iqoption/core/microservices/configuration/response/Country;", "viewModel", "Lcom/iqoption/welcomeonboarding/registration/country/CountrySearchViewModel;", "animateShow", "", "closeKeyboardAndScreen", "closeWithAnimation", "getPreviewButton", "Landroid/view/View;", "inputTranslationY", "", "loadSuggest", "text", "onClose", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onCurrencyClicked", "country", "onViewCreated", "view", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: CountrySearchFragment.kt */
public final class d extends com.iqoption.fragment.base.f implements e {
    private static final String TAG = "com.iqoption.welcomeonboarding.registration.country.d";
    static final /* synthetic */ kotlin.reflect.j[] apP = new kotlin.reflect.j[]{kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(d.class), "binding", "getBinding()Lcom/iqoption/databinding/FragmentSearchCountryBinding;")), kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(d.class), "adapter", "getAdapter()Lcom/iqoption/welcomeonboarding/registration/country/CountryAdapter;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(d.class), "inputPoint", "getInputPoint()Landroid/graphics/Point;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(d.class), "countryName", "getCountryName()Ljava/lang/String;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(d.class), "isTrial", "isTrial()Z"))};
    public static final a dNj = new a();
    private HashMap atz;
    private final kotlin.e.d bXo = kotlin.e.a.euA.aYg();
    private final kotlin.e.d caV = kotlin.e.a.euA.aYg();
    private com.iqoption.core.microservices.configuration.a.c dMx;
    private CountrySearchViewModel dNf;
    private final kotlin.d dNg = g.f(new CountrySearchFragment$inputPoint$2(this));
    private final kotlin.d dNh = g.f(new CountrySearchFragment$countryName$2(this));
    private final kotlin.d dNi = g.f(new CountrySearchFragment$isTrial$2(this));

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, aXE = {"Lcom/iqoption/welcomeonboarding/registration/country/CountrySearchFragment$Companion;", "", "()V", "ARG_COUNTRY", "", "ARG_INPUT_POINT", "ARG_IS_TRIAL", "CONTENT_FADE_DURATION_MILLIS", "", "GENERAL_DURATION_MILLIS", "TAG", "createNavigationEntry", "Lcom/iqoption/core/ui/navigation/NavigatorEntry;", "inputPoint", "Landroid/graphics/Point;", "countryName", "isTrial", "", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: CountrySearchFragment.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final com.iqoption.core.ui.navigation.h a(Point point, String str, boolean z) {
            kotlin.jvm.internal.h.e(point, "inputPoint");
            kotlin.jvm.internal.h.e(str, "countryName");
            Bundle bundle = new Bundle();
            bundle.putParcelable("ARG_INPUT_POINT", point);
            bundle.putString("ARG_COUNTRY", str);
            bundle.putBoolean("ARG_IS_TRIAL", z);
            return new com.iqoption.core.ui.navigation.h(d.TAG, d.class, bundle, 0, 0, 0, 0, ChartTimeInterval.CANDLE_2m, null);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, aXE = {"com/iqoption/core/ext/AndroidExtensionsKt$doOnPreDrawSkip$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "core_release"})
    /* compiled from: AndroidExtensions.kt */
    public static final class b implements OnPreDrawListener {
        final /* synthetic */ View aGz;
        final /* synthetic */ FrameLayout dNk;
        final /* synthetic */ RecyclerView dNl;
        final /* synthetic */ d this$0;

        @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, aXE = {"<anonymous>", "", "run", "com/iqoption/welcomeonboarding/registration/country/CountrySearchFragment$animateShow$2$1"})
        /* compiled from: CountrySearchFragment.kt */
        static final class a implements Runnable {
            final /* synthetic */ b dNm;

            a(b bVar) {
                this.dNm = bVar;
            }

            public final void run() {
                if (this.dNm.this$0.isAdded()) {
                    this.dNm.dNl.animate().setDuration(100).alpha(1.0f);
                    com.iqoption.core.util.j.b(this.dNm.this$0.getContext(), this.dNm.this$0.aMq().bBV);
                }
            }
        }

        public b(View view, d dVar, FrameLayout frameLayout, RecyclerView recyclerView) {
            this.aGz = view;
            this.this$0 = dVar;
            this.dNk = frameLayout;
            this.dNl = recyclerView;
        }

        public boolean onPreDraw() {
            this.aGz.getViewTreeObserver().removeOnPreDrawListener(this);
            FrameLayout frameLayout = this.dNk;
            kotlin.jvm.internal.h.d(frameLayout, "inputContainer");
            frameLayout.setTranslationY(this.this$0.aMw());
            this.dNk.animate().setInterpolator(com.iqoption.core.graphics.animation.i.TI()).setDuration(400).translationY(0.0f).withEndAction(new a(this));
            return false;
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
    /* compiled from: CountrySearchFragment.kt */
    static final class c implements Runnable {
        final /* synthetic */ View dNn;

        c(View view) {
            this.dNn = view;
        }

        public final void run() {
            com.iqoption.core.ext.a.M(this.dNn);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, aXE = {"com/iqoption/core/ext/AndroidExtensionsKt$doOnLayout$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "core_release"})
    /* compiled from: AndroidExtensions.kt */
    public static final class d implements OnGlobalLayoutListener {
        final /* synthetic */ View aGz;
        final /* synthetic */ d this$0;

        public d(View view, d dVar) {
            this.aGz = view;
            this.this$0 = dVar;
        }

        public void onGlobalLayout() {
            this.aGz.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            this.this$0.aMv();
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
    /* compiled from: CountrySearchFragment.kt */
    static final class e implements Runnable {
        final /* synthetic */ d this$0;

        e(d dVar) {
            this.this$0 = dVar;
        }

        public final void run() {
            if (this.this$0.isAdded()) {
                this.this$0.onClose();
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, aXE = {"com/iqoption/core/ext/AndroidExtensionsKt$doOnPreDrawSkip$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "core_release"})
    /* compiled from: AndroidExtensions.kt */
    public static final class h implements OnPreDrawListener {
        final /* synthetic */ View aGz;
        final /* synthetic */ d this$0;

        public h(View view, d dVar) {
            this.aGz = view;
            this.this$0 = dVar;
        }

        public boolean onPreDraw() {
            this.aGz.getViewTreeObserver().removeOnPreDrawListener(this);
            this.this$0.aMq().bBV.requestFocus();
            this.this$0.aMq().bBV.jumpDrawablesToCurrentState();
            return false;
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "", "countries", "", "Lcom/iqoption/core/microservices/configuration/response/Country;", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: CountrySearchFragment.kt */
    static final class f<T> implements io.reactivex.c.e<List<? extends com.iqoption.core.microservices.configuration.a.c>> {
        final /* synthetic */ d this$0;

        f(d dVar) {
            this.this$0 = dVar;
        }

        /* renamed from: C */
        public final void accept(List<com.iqoption.core.microservices.configuration.a.c> list) {
            com.iqoption.core.ui.widget.recyclerview.adapter.a e = this.this$0.aMr();
            kotlin.jvm.internal.h.d(list, "countries");
            Iterable<com.iqoption.core.microservices.configuration.a.c> iterable = list;
            Collection arrayList = new ArrayList(n.e(iterable, 10));
            for (com.iqoption.core.microservices.configuration.a.c cVar : iterable) {
                arrayList.add(new c(cVar));
            }
            com.iqoption.core.ui.widget.recyclerview.adapter.a.a(e, (List) arrayList, null, 2, null);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "error", "", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: CountrySearchFragment.kt */
    static final class g<T> implements io.reactivex.c.e<Throwable> {
        public static final g dNo = new g();

        g() {
        }

        /* renamed from: o */
        public final void accept(Throwable th) {
            com.iqoption.core.i.e("Unable to fetch countries", th);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, aXE = {"com/iqoption/core/ext/AndroidExtensionsKt$setOnDelayedClickListener$1", "Lcom/iqoption/core/ext/OnDelayClickListener;", "onDelayClick", "", "v", "Landroid/view/View;", "core_release"})
    /* compiled from: AndroidExtensions.kt */
    public static final class i extends com.iqoption.core.ext.g {
        final /* synthetic */ d this$0;

        public i(d dVar) {
            this.this$0 = dVar;
            super(0, 1, null);
        }

        public void q(View view) {
            kotlin.jvm.internal.h.e(view, "v");
            this.this$0.aMu();
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, aXE = {"com/iqoption/core/ext/AndroidExtensionsKt$setOnDelayedClickListener$1", "Lcom/iqoption/core/ext/OnDelayClickListener;", "onDelayClick", "", "v", "Landroid/view/View;", "core_release"})
    /* compiled from: AndroidExtensions.kt */
    public static final class j extends com.iqoption.core.ext.g {
        final /* synthetic */ d this$0;

        @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/core/microservices/configuration/response/Country;", "kotlin.jvm.PlatformType", "accept", "com/iqoption/welcomeonboarding/registration/country/CountrySearchFragment$onViewCreated$2$1"})
        /* compiled from: CountrySearchFragment.kt */
        static final class a<T> implements io.reactivex.c.e<com.iqoption.core.microservices.configuration.a.c> {
            final /* synthetic */ j dNp;

            a(j jVar) {
                this.dNp = jVar;
            }

            /* renamed from: e */
            public final void accept(com.iqoption.core.microservices.configuration.a.c cVar) {
                d dVar = this.dNp.this$0;
                kotlin.jvm.internal.h.d(cVar, "it");
                dVar.c(cVar);
            }
        }

        public j(d dVar) {
            this.this$0 = dVar;
            super(0, 1, null);
        }

        public void q(View view) {
            kotlin.jvm.internal.h.e(view, "v");
            d.b(this.this$0).fv(this.this$0.CZ()).h(com.iqoption.core.h.i.Yo()).g(com.iqoption.core.h.i.Yp()).a((io.reactivex.c.e) new a(this), (io.reactivex.c.e) k.dNq);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "error", "", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: CountrySearchFragment.kt */
    static final class k<T> implements io.reactivex.c.e<Throwable> {
        public static final k dNq = new k();

        k() {
        }

        /* renamed from: o */
        public final void accept(Throwable th) {
            com.iqoption.core.i.e("Unable to get my country", th);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, aXE = {"com/iqoption/welcomeonboarding/registration/country/CountrySearchFragment$onViewCreated$4", "Lcom/iqoption/view/text/TextWatcherAdapter;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: CountrySearchFragment.kt */
    public static final class l extends x {
        final /* synthetic */ d this$0;

        l(d dVar) {
            this.this$0 = dVar;
        }

        public void afterTextChanged(Editable editable) {
            kotlin.jvm.internal.h.e(editable, "s");
            super.afterTextChanged(editable);
            this.this$0.kn(editable.toString());
        }
    }

    private final boolean CZ() {
        kotlin.d dVar = this.dNi;
        kotlin.reflect.j jVar = apP[4];
        return ((Boolean) dVar.getValue()).booleanValue();
    }

    private final void a(sd sdVar) {
        this.bXo.a(this, apP[0], sdVar);
    }

    private final void a(a aVar) {
        this.caV.a(this, apP[1], aVar);
    }

    private final sd aMq() {
        return (sd) this.bXo.b(this, apP[0]);
    }

    private final a aMr() {
        return (a) this.caV.b(this, apP[1]);
    }

    private final Point aMs() {
        kotlin.d dVar = this.dNg;
        kotlin.reflect.j jVar = apP[2];
        return (Point) dVar.getValue();
    }

    private final String getCountryName() {
        kotlin.d dVar = this.dNh;
        kotlin.reflect.j jVar = apP[3];
        return (String) dVar.getValue();
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

    public static final /* synthetic */ CountrySearchViewModel b(d dVar) {
        CountrySearchViewModel countrySearchViewModel = dVar.dNf;
        if (countrySearchViewModel == null) {
            kotlin.jvm.internal.h.lS("viewModel");
        }
        return countrySearchViewModel;
    }

    static {
        if (d.class.getName() == null) {
            kotlin.jvm.internal.h.aXZ();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dNf = CountrySearchViewModel.dNr.ad(this);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.h.e(layoutInflater, "inflater");
        a((sd) com.iqoption.core.ext.a.a((Fragment) this, (int) R.layout.fragment_search_country, viewGroup, false, 4, null));
        return aMq().getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.h.e(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        aMq().bBV.setTextSize(0, getResources().getDimension(CZ() ? R.dimen.sp14 : R.dimen.sp16));
        if (!CZ()) {
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.registration_horizontal_inset);
            LinearLayout linearLayout = aMq().byY;
            kotlin.jvm.internal.h.d(linearLayout, "binding.searchCountryToolbar");
            com.iqoption.core.ext.a.M(linearLayout);
            FrameLayout frameLayout = aMq().bBX;
            kotlin.jvm.internal.h.d(frameLayout, "binding.countryInputContainer");
            LayoutParams layoutParams = frameLayout.getLayoutParams();
            if (layoutParams == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            }
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) layoutParams;
            marginLayoutParams.setMarginStart(dimensionPixelOffset);
            marginLayoutParams.setMarginEnd(dimensionPixelOffset);
            FrameLayout frameLayout2 = aMq().bBX;
            kotlin.jvm.internal.h.d(frameLayout2, "binding.countryInputContainer");
            frameLayout2.setLayoutParams(marginLayoutParams);
            RecyclerView recyclerView = aMq().bBZ;
            kotlin.jvm.internal.h.d(recyclerView, "binding.countrySuggestList");
            layoutParams = recyclerView.getLayoutParams();
            if (layoutParams == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            }
            marginLayoutParams = (MarginLayoutParams) layoutParams;
            marginLayoutParams.setMarginStart(dimensionPixelOffset);
            marginLayoutParams.setMarginEnd(dimensionPixelOffset);
            RecyclerView recyclerView2 = aMq().bBZ;
            kotlin.jvm.internal.h.d(recyclerView2, "binding.countrySuggestList");
            recyclerView2.setLayoutParams(marginLayoutParams);
        }
        ImageView imageView = aMq().byW;
        kotlin.jvm.internal.h.d(imageView, "binding.searchCountryClose");
        imageView.setOnClickListener(new i(this));
        imageView = aMq().bBY;
        kotlin.jvm.internal.h.d(imageView, "binding.countryLocationButton");
        imageView.setOnClickListener(new j(this));
        String countryName = getCountryName();
        kotlin.jvm.internal.h.d(countryName, "countryName");
        if ((((CharSequence) countryName).length() > 0 ? 1 : null) != null) {
            TextInputLayout textInputLayout = aMq().bBW;
            kotlin.jvm.internal.h.d(textInputLayout, "binding.countryInput");
            textInputLayout.setHintAnimationEnabled(false);
            aMq().bBV.setText(getCountryName());
            aMq().bBV.setSelection(getCountryName().length());
            textInputLayout = aMq().bBW;
            kotlin.jvm.internal.h.d(textInputLayout, "binding.countryInput");
            textInputLayout.setHintAnimationEnabled(true);
        }
        view.getViewTreeObserver().addOnPreDrawListener(new h(view, this));
        RecyclerView recyclerView3 = aMq().bBZ;
        kotlin.jvm.internal.h.d(recyclerView3, "recyclerView");
        recyclerView3.setLayoutManager(new LinearLayoutManager(com.iqoption.core.ext.a.m(this)));
        a(new a(this));
        recyclerView3.setAdapter(aMr());
        aMq().bBV.addTextChangedListener(new l(this));
        if (bundle == null) {
            aMt();
        }
        a(this, null, 1, null);
        Lifecycle lifecycle = getLifecycle();
        FragmentActivity n = com.iqoption.core.ext.a.n(this);
        if (n == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.iqoption.core.ui.navigation.BackController");
        }
        lifecycle.a(new CountrySearchFragment$onViewCreated$5(this, (com.iqoption.core.ui.navigation.a) n));
    }

    static /* synthetic */ void a(d dVar, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = (String) null;
        }
        dVar.kn(str);
    }

    private final void kn(String str) {
        CountrySearchViewModel countrySearchViewModel = this.dNf;
        if (countrySearchViewModel == null) {
            kotlin.jvm.internal.h.lS("viewModel");
        }
        countrySearchViewModel.j(CZ(), str).h(com.iqoption.core.h.i.Yo()).g(com.iqoption.core.h.i.Yp()).a((io.reactivex.c.e) new f(this), (io.reactivex.c.e) g.dNo);
    }

    public void c(com.iqoption.core.microservices.configuration.a.c cVar) {
        kotlin.jvm.internal.h.e(cVar, "country");
        aMq().bBV.setText(cVar.getName());
        this.dMx = cVar;
        aMu();
    }

    private final void aMt() {
        if (CZ()) {
            TextView textView = aMq().byX;
            kotlin.jvm.internal.h.d(textView, "binding.searchCountryTitle");
            textView.setAlpha(0.0f);
            aMq().byX.animate().setDuration(400).alpha(1.0f);
        }
        View aLZ = aLZ();
        if (aLZ != null) {
            if (CZ()) {
                com.iqoption.core.ext.a.M(aLZ);
            } else {
                com.iqoption.core.ext.a.L(aLZ);
                aLZ.animate().setDuration(400).alpha(0.0f).withEndAction(new c(aLZ));
            }
        }
        FrameLayout frameLayout = aMq().bBX;
        RecyclerView recyclerView = aMq().bBZ;
        kotlin.jvm.internal.h.d(recyclerView, "suggestContainer");
        recyclerView.setAlpha(0.0f);
        kotlin.jvm.internal.h.d(frameLayout, "inputContainer");
        View view = frameLayout;
        view.getViewTreeObserver().addOnPreDrawListener(new b(view, this, frameLayout, recyclerView));
        aLZ = aMq().bBT;
        kotlin.jvm.internal.h.d(aLZ, "binding.countryBackground");
        aLZ.setAlpha(0.0f);
        aMq().bBT.animate().setDuration(400).alpha(1.0f);
    }

    private final void aMu() {
        FragmentActivity activity = zzakw();
        if (!(activity instanceof com.iqoption.activity.b)) {
            activity = null;
        }
        com.iqoption.activity.b bVar = (com.iqoption.activity.b) activity;
        if (bVar == null || !bVar.zN()) {
            aMv();
            return;
        }
        com.iqoption.core.util.j.n(com.iqoption.core.ext.a.n(this));
        View view = getView();
        if (view == null) {
            kotlin.jvm.internal.h.aXZ();
        }
        kotlin.jvm.internal.h.d(view, "view!!");
        view.getViewTreeObserver().addOnGlobalLayoutListener(new d(view, this));
    }

    private final void aMv() {
        aMq().bBV.clearFocus();
        if (CZ()) {
            aMq().byX.animate().setDuration(400).alpha(0.0f);
        }
        View aLZ = aLZ();
        if (!(CZ() || aLZ == null)) {
            aLZ.setAlpha(0.0f);
            com.iqoption.core.ext.a.L(aLZ);
            aLZ.animate().setDuration(400).alpha(1.0f);
        }
        aMq().bBZ.animate().setDuration(100).alpha(0.0f);
        aMq().bBX.animate().setInterpolator(com.iqoption.core.graphics.animation.i.TI()).setDuration(400).translationY(aMw()).withEndAction(new e(this));
        aMq().bBT.animate().setDuration(400).alpha(0.0f);
    }

    public boolean onClose() {
        Fragment parentFragment = getParentFragment();
        if (!(parentFragment instanceof f)) {
            parentFragment = null;
        }
        f fVar = (f) parentFragment;
        if (fVar != null) {
            fVar.g(this.dMx);
        }
        com.iqoption.core.ext.a.p(this).popBackStack();
        return true;
    }

    private final float aMw() {
        float f = (float) aMs().y;
        FrameLayout frameLayout = aMq().bBX;
        kotlin.jvm.internal.h.d(frameLayout, "binding.countryInputContainer");
        return f - ((float) com.iqoption.core.ext.a.K(frameLayout).y);
    }

    private final View aLZ() {
        Fragment parentFragment = getParentFragment();
        if (!(parentFragment instanceof g)) {
            parentFragment = null;
        }
        g gVar = (g) parentFragment;
        return gVar != null ? gVar.aLZ() : null;
    }
}
