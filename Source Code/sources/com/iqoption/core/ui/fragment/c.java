package com.iqoption.core.ui.fragment;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.plus.PlusShare;
import com.iqoption.core.ext.g;
import com.iqoption.core.j.f;
import com.iqoption.core.ui.navigation.h;
import com.iqoption.core.ui.viewmodel.welcome.TermsViewModel;
import com.iqoption.core.ui.viewmodel.welcome.TermsViewModel.TERMS;
import com.iqoption.dto.ChartTimeInterval;
import java.util.HashMap;
import kotlin.i;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH\u0002J&\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u000eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000¨\u0006\u001b"}, aXE = {"Lcom/iqoption/core/ui/fragment/TermsFragment;", "Lcom/iqoption/core/ui/fragment/IQFragment;", "()V", "binding", "Lcom/iqoption/core/databinding/TermsFragmentBinding;", "termsArg", "Lcom/iqoption/core/ui/viewmodel/welcome/TermsViewModel$TERMS;", "getTermsArg", "()Lcom/iqoption/core/ui/viewmodel/welcome/TermsViewModel$TERMS;", "termsArg$delegate", "Lkotlin/Lazy;", "termsViewModel", "Lcom/iqoption/core/ui/viewmodel/welcome/TermsViewModel;", "dismissProgressDialog", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "showProgressDialog", "Companion", "core_release"})
/* compiled from: TermsFragment.kt */
public final class c extends b {
    private static final String TAG = "com.iqoption.core.ui.fragment.c";
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(c.class), "termsArg", "getTermsArg()Lcom/iqoption/core/ui/viewmodel/welcome/TermsViewModel$TERMS;"))};
    public static final a bbF = new a();
    private HashMap atz;
    private final kotlin.d bbC = g.f(new TermsFragment$termsArg$2(this));
    private com.iqoption.core.b.c bbD;
    private TermsViewModel bbE;

    @i(aXC = {1, 1, 11}, aXD = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0002J \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\tH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, aXE = {"Lcom/iqoption/core/ui/fragment/TermsFragment$Companion;", "", "()V", "ARG", "", "TAG", "createNavigatorEntry", "Lcom/iqoption/core/ui/navigation/NavigatorEntry;", "terms", "Lcom/iqoption/core/ui/viewmodel/welcome/TermsViewModel$TERMS;", "newInstance", "Lcom/iqoption/core/ui/fragment/TermsFragment;", "show", "", "fm", "Landroid/support/v4/app/FragmentManager;", "containerId", "", "core_release"})
    /* compiled from: TermsFragment.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final h a(TERMS terms) {
            kotlin.jvm.internal.h.e(terms, "terms");
            Bundle bundle = new Bundle();
            bundle.putSerializable("termsUrl", terms);
            return new h(c.TAG, c.class, bundle, 0, 0, 0, 0, ChartTimeInterval.CANDLE_2m, null);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\"\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J(\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007H\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u0012¸\u0006\u0000"}, aXE = {"com/iqoption/core/ui/fragment/TermsFragment$onCreateView$1$2", "Landroid/webkit/WebViewClient;", "onPageFinished", "", "view", "Landroid/webkit/WebView;", "url", "", "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "onReceivedError", "errorCode", "", "description", "failingUrl", "shouldOverrideUrlLoading", "", "core_release"})
    /* compiled from: TermsFragment.kt */
    public static final class c extends WebViewClient {
        final /* synthetic */ c this$0;

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            kotlin.jvm.internal.h.e(webView, Promotion.ACTION_VIEW);
            kotlin.jvm.internal.h.e(str, PlusShare.KEY_CALL_TO_ACTION_URL);
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            kotlin.jvm.internal.h.e(webView, Promotion.ACTION_VIEW);
            kotlin.jvm.internal.h.e(str, PlusShare.KEY_CALL_TO_ACTION_URL);
            return false;
        }

        c(c cVar) {
            this.this$0 = cVar;
        }

        public void onPageFinished(WebView webView, String str) {
            kotlin.jvm.internal.h.e(webView, Promotion.ACTION_VIEW);
            kotlin.jvm.internal.h.e(str, PlusShare.KEY_CALL_TO_ACTION_URL);
            this.this$0.YL();
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            kotlin.jvm.internal.h.e(webView, Promotion.ACTION_VIEW);
            kotlin.jvm.internal.h.e(str, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION);
            kotlin.jvm.internal.h.e(str2, "failingUrl");
            this.this$0.YL();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0007"}, aXE = {"com/iqoption/core/ext/AndroidExtensionsKt$setOnDelayedClickListener$1", "Lcom/iqoption/core/ext/OnDelayClickListener;", "onDelayClick", "", "v", "Landroid/view/View;", "core_release", "com/iqoption/core/ui/fragment/TermsFragment$$special$$inlined$setOnDelayedClickListener$1"})
    /* compiled from: AndroidExtensions.kt */
    public static final class b extends g {
        final /* synthetic */ c this$0;

        public b(c cVar) {
            this.this$0 = cVar;
            super(0, 1, null);
        }

        public void q(View view) {
            kotlin.jvm.internal.h.e(view, "v");
            this.this$0.back();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "", "onChanged"})
    /* compiled from: TermsFragment.kt */
    static final class d<T> implements Observer<String> {
        final /* synthetic */ c this$0;

        d(c cVar) {
            this.this$0 = cVar;
        }

        /* renamed from: fz */
        public final void onChanged(String str) {
            TextView textView = c.b(this.this$0).aOZ.agA;
            kotlin.jvm.internal.h.d(textView, "binding.toolbar.title");
            textView.setText(str);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "", "onChanged"})
    /* compiled from: TermsFragment.kt */
    static final class e<T> implements Observer<String> {
        final /* synthetic */ c this$0;

        e(c cVar) {
            this.this$0 = cVar;
        }

        /* renamed from: fz */
        public final void onChanged(String str) {
            c.b(this.this$0).aOY.loadData(str, "text/html; charset=utf-8", null);
        }
    }

    private final TERMS YK() {
        kotlin.d dVar = this.bbC;
        j jVar = apP[0];
        return (TERMS) dVar.getValue();
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

    public static final /* synthetic */ com.iqoption.core.b.c b(c cVar) {
        com.iqoption.core.b.c cVar2 = cVar.bbD;
        if (cVar2 == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        return cVar2;
    }

    static {
        if (c.class.getName() == null) {
            kotlin.jvm.internal.h.aXZ();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.h.e(layoutInflater, "inflater");
        com.iqoption.core.b.c cVar = (com.iqoption.core.b.c) com.iqoption.core.ext.a.a((Fragment) this, f.terms_fragment, viewGroup, false);
        this.bbD = cVar;
        com.iqoption.core.b.c cVar2 = this.bbD;
        if (cVar2 == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        ImageView imageView = cVar2.aOZ.aOU;
        kotlin.jvm.internal.h.d(imageView, "binding.toolbar.backButton");
        imageView.setOnClickListener(new b(this));
        cVar2 = this.bbD;
        if (cVar2 == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        WebView webView = cVar2.aOY;
        kotlin.jvm.internal.h.d(webView, "binding.termsView");
        webView.setWebViewClient(new c(this));
        return cVar.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.h.e(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        TermsViewModel t = TermsViewModel.bcZ.t(this);
        kotlin.jvm.internal.h.d(t, "TermsViewModel.get(this)");
        this.bbE = t;
        t = this.bbE;
        if (t == null) {
            kotlin.jvm.internal.h.lS("termsViewModel");
        }
        LifecycleOwner lifecycleOwner = this;
        t.Zg().observe(lifecycleOwner, new d(this));
        t = this.bbE;
        if (t == null) {
            kotlin.jvm.internal.h.lS("termsViewModel");
        }
        t.Zh().observe(lifecycleOwner, new e(this));
        t = this.bbE;
        if (t == null) {
            kotlin.jvm.internal.h.lS("termsViewModel");
        }
        t.b(YK());
        zH();
    }

    private final void zH() {
        com.iqoption.core.b.c cVar = this.bbD;
        if (cVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        ContentLoadingProgressBar contentLoadingProgressBar = cVar.aOZ.aOW;
        kotlin.jvm.internal.h.d(contentLoadingProgressBar, "binding.toolbar.toolbarProgress");
        contentLoadingProgressBar.setVisibility(0);
    }

    private final void YL() {
        com.iqoption.core.b.c cVar = this.bbD;
        if (cVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        ContentLoadingProgressBar contentLoadingProgressBar = cVar.aOZ.aOW;
        kotlin.jvm.internal.h.d(contentLoadingProgressBar, "binding.toolbar.toolbarProgress");
        contentLoadingProgressBar.setVisibility(8);
    }
}
