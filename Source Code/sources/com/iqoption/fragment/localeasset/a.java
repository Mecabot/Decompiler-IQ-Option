package com.iqoption.fragment.localeasset;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.iqoption.core.ext.g;
import com.iqoption.core.ui.navigation.h;
import com.iqoption.d.oj;
import com.iqoption.welcomeonboarding.registration.country.e;
import com.iqoption.x.R;
import java.util.HashMap;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 +2\u00020\u00012\u00020\u0002:\u0001+B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J&\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020\u001bH\u0016J\b\u0010(\u001a\u00020\u001bH\u0016J\u001a\u0010)\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020\u001f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016R+\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058B@BX\u0002¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR+\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\r8B@BX\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0014\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000¨\u0006,"}, aXE = {"Lcom/iqoption/fragment/localeasset/LocalAssetCountrySearchFragment;", "Lcom/iqoption/fragment/base/IQAnimationFragment;", "Lcom/iqoption/welcomeonboarding/registration/country/OnCountryClickListener;", "()V", "<set-?>", "Lcom/iqoption/fragment/localeasset/LocaleAssetCountryAdapter;", "adapter", "getAdapter", "()Lcom/iqoption/fragment/localeasset/LocaleAssetCountryAdapter;", "setAdapter", "(Lcom/iqoption/fragment/localeasset/LocaleAssetCountryAdapter;)V", "adapter$delegate", "Lkotlin/properties/ReadWriteProperty;", "Lcom/iqoption/databinding/FragmentLocaleAssetSearchCountryBinding;", "binding", "getBinding", "()Lcom/iqoption/databinding/FragmentLocaleAssetSearchCountryBinding;", "setBinding", "(Lcom/iqoption/databinding/FragmentLocaleAssetSearchCountryBinding;)V", "binding$delegate", "viewModel", "Lcom/iqoption/fragment/localeasset/LocaleAssetViewModel;", "getAnimationDuration", "", "onClose", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onCurrencyClicked", "country", "Lcom/iqoption/core/microservices/configuration/response/Country;", "onHideAnimation", "onShowAnimation", "onViewCreated", "view", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: LocalAssetCountrySearchFragment.kt */
public final class a extends com.iqoption.fragment.base.b implements e {
    private static final String TAG = "com.iqoption.fragment.localeasset.a";
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(a.class), "binding", "getBinding()Lcom/iqoption/databinding/FragmentLocaleAssetSearchCountryBinding;")), kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(a.class), "adapter", "getAdapter()Lcom/iqoption/fragment/localeasset/LocaleAssetCountryAdapter;"))};
    public static final a cEh = new a();
    private HashMap atz;
    private final kotlin.e.d bXo = kotlin.e.a.euA.aYg();
    private LocaleAssetViewModel cEg;
    private final kotlin.e.d caV = kotlin.e.a.euA.aYg();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0007R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, aXE = {"Lcom/iqoption/fragment/localeasset/LocalAssetCountrySearchFragment$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "createNavigationEntry", "Lcom/iqoption/core/ui/navigation/NavigatorEntry;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: LocalAssetCountrySearchFragment.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final h ams() {
            String Ki = a.TAG;
            kotlin.jvm.internal.h.d(Ki, "TAG");
            return new h(Ki, a.class, null, 0, 0, 0, 0, 124, null);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, aXE = {"com/iqoption/core/ext/AndroidExtensionsKt$setOnDelayedClickListener$1", "Lcom/iqoption/core/ext/OnDelayClickListener;", "onDelayClick", "", "v", "Landroid/view/View;", "core_release"})
    /* compiled from: AndroidExtensions.kt */
    public static final class b extends g {
        final /* synthetic */ a cEi;

        public b(a aVar) {
            this.cEi = aVar;
            super(0, 1, null);
        }

        public void q(View view) {
            kotlin.jvm.internal.h.e(view, "v");
            this.cEi.aN();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, aXE = {"com/iqoption/core/ext/AndroidExtensionsKt$setOnDelayedClickListener$1", "Lcom/iqoption/core/ext/OnDelayClickListener;", "onDelayClick", "", "v", "Landroid/view/View;", "core_release"})
    /* compiled from: AndroidExtensions.kt */
    public static final class c extends g {
        final /* synthetic */ a cEi;

        public c(a aVar) {
            this.cEi = aVar;
            super(0, 1, null);
        }

        public void q(View view) {
            kotlin.jvm.internal.h.e(view, "v");
            this.cEi.aN();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "list", "", "Lcom/iqoption/fragment/localeasset/LocaleAssetContryItem;", "onChanged"})
    /* compiled from: LocalAssetCountrySearchFragment.kt */
    static final class d<T> implements Observer<List<? extends b>> {
        final /* synthetic */ a cEi;

        d(a aVar) {
            this.cEi = aVar;
        }

        /* renamed from: L */
        public final void onChanged(List<b> list) {
            if (list != null) {
                com.iqoption.core.ui.widget.recyclerview.adapter.a a = this.cEi.amr();
                kotlin.jvm.internal.h.d(list, "it");
                com.iqoption.core.ui.widget.recyclerview.adapter.a.a(a, list, null, 2, null);
                ProgressBar progressBar = this.cEi.amq().bly;
                kotlin.jvm.internal.h.d(progressBar, "binding.progress");
                com.iqoption.core.ext.a.M(progressBar);
                return;
            }
            this.cEi.aN();
        }
    }

    private final void a(oj ojVar) {
        this.bXo.a(this, apP[0], ojVar);
    }

    private final void a(c cVar) {
        this.caV.a(this, apP[1], cVar);
    }

    private final oj amq() {
        return (oj) this.bXo.b(this, apP[0]);
    }

    private final c amr() {
        return (c) this.caV.b(this, apP[1]);
    }

    public static final h ams() {
        return cEh.ams();
    }

    public void KH() {
        if (this.atz != null) {
            this.atz.clear();
        }
    }

    public long getAnimationDuration() {
        return 300;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        KH();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cEg = LocaleAssetViewModel.cEt.S(this);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.h.e(layoutInflater, "inflater");
        a((oj) com.iqoption.core.ext.a.a((Fragment) this, (int) R.layout.fragment_locale_asset_search_country, viewGroup, false, 4, null));
        return amq().getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.h.e(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        ImageView imageView = amq().byW;
        kotlin.jvm.internal.h.d(imageView, "binding.searchCountryClose");
        imageView.setOnClickListener(new b(this));
        view = amq().blp;
        kotlin.jvm.internal.h.d(view, "binding.outside");
        view.setOnClickListener(new c(this));
        a(new c(this));
        RecyclerView recyclerView = amq().axw;
        kotlin.jvm.internal.h.d(recyclerView, "binding.list");
        recyclerView.setLayoutManager(new LinearLayoutManager(com.iqoption.core.ext.a.m(this)));
        recyclerView = amq().axw;
        kotlin.jvm.internal.h.d(recyclerView, "binding.list");
        recyclerView.setAdapter(amr());
        LocaleAssetViewModel localeAssetViewModel = this.cEg;
        if (localeAssetViewModel == null) {
            kotlin.jvm.internal.h.lS("viewModel");
        }
        localeAssetViewModel.amA().observe(this, new d(this));
    }

    public void c(com.iqoption.core.microservices.configuration.a.c cVar) {
        kotlin.jvm.internal.h.e(cVar, "country");
        LocaleAssetViewModel localeAssetViewModel = this.cEg;
        if (localeAssetViewModel == null) {
            kotlin.jvm.internal.h.lS("viewModel");
        }
        localeAssetViewModel.d(cVar);
        aN();
    }

    public void ND() {
        LinearLayout linearLayout = amq().blz;
        View view = amq().blp;
        kotlin.jvm.internal.h.d(linearLayout, "sheetView");
        linearLayout.setTranslationY((float) linearLayout.getHeight());
        kotlin.jvm.internal.h.d(view, "outsideView");
        view.setAlpha(0.0f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(linearLayout, View.TRANSLATION_Y, new float[]{0.0f});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, View.ALPHA, new float[]{1.0f});
        AnimatorSet animatorSet = new AnimatorSet();
        com.iqoption.util.b.a(animatorSet, getAnimationDuration());
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        animatorSet.setInterpolator(com.iqoption.view.a.a.d.aQV);
        animatorSet.start();
    }

    public void NE() {
        LinearLayout linearLayout = amq().blz;
        View view = amq().blp;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(linearLayout, View.TRANSLATION_Y, new float[]{(float) linearLayout.getHeight()});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, View.ALPHA, new float[]{0.0f});
        AnimatorSet animatorSet = new AnimatorSet();
        com.iqoption.util.b.a(animatorSet, getAnimationDuration());
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        animatorSet.setInterpolator(com.iqoption.view.a.a.d.aQW);
        animatorSet.start();
    }

    public boolean onClose() {
        com.iqoption.core.ext.a.p(this).popBackStack();
        return true;
    }
}
