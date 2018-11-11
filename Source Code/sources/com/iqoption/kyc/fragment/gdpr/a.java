package com.iqoption.kyc.fragment.gdpr;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.iqoption.d.mz;
import com.iqoption.d.wp;
import com.iqoption.d.wr;
import com.iqoption.fragment.base.f;
import com.iqoption.util.af;
import com.iqoption.view.ConfirmButtonView;
import com.iqoption.view.text.l;
import com.iqoption.view.text.m;
import com.iqoption.view.text.o;
import com.iqoption.view.text.p;
import com.iqoption.x.R;
import java.util.HashMap;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000o\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f*\u0001\u000f\u0018\u0000 62\u00020\u00012\u00020\u0002:\u000267B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001e\u001a\u00020\rH\u0016J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0007H\u0002J\u0010\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020$H\u0016J&\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u0010-\u001a\u00020 H\u0016J\u0010\u0010.\u001a\u00020 2\u0006\u0010/\u001a\u00020,H\u0016J\u001a\u00100\u001a\u00020 2\u0006\u00101\u001a\u00020&2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u00102\u001a\u00020 H\u0002J\u0012\u00103\u001a\u00020 2\b\u0010+\u001a\u0004\u0018\u00010,H\u0002J\b\u00104\u001a\u00020 H\u0002J\u0012\u00105\u001a\u00020 2\b\u0010+\u001a\u0004\u0018\u00010,H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u000b\u001a\u0004\b\u0017\u0010\tR\u000e\u0010\u0019\u001a\u00020\u001aX.¢\u0006\u0002\n\u0000¨\u00068"}, aXE = {"Lcom/iqoption/kyc/fragment/gdpr/KycGdprFragment;", "Lcom/iqoption/fragment/base/IQFragment;", "Lcom/iqoption/kyc/analytics/KycAnalyticsFragmentInfo;", "()V", "binding", "Lcom/iqoption/databinding/FragmentKycGdprBinding;", "gdprLink", "Lcom/iqoption/view/text/Link;", "getGdprLink", "()Lcom/iqoption/view/text/Link;", "gdprLink$delegate", "Lkotlin/Lazy;", "isContinueClicked", "", "linkClickListener", "com/iqoption/kyc/fragment/gdpr/KycGdprFragment$linkClickListener$1", "Lcom/iqoption/kyc/fragment/gdpr/KycGdprFragment$linkClickListener$1;", "listener", "Lcom/iqoption/kyc/fragment/gdpr/KycGdprFragment$OnFragmentInteractionListener;", "nextButton", "Lcom/iqoption/view/ConfirmButtonView;", "shownLink", "termsLink", "getTermsLink", "termsLink$delegate", "viewModel", "Lcom/iqoption/kyc/fragment/gdpr/KycGdprViewModel;", "getScreenName", "", "getStageName", "isContinuePressed_Analytics", "loadLink", "", "link", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDetach", "onSaveInstanceState", "outState", "onViewCreated", "view", "prepareButton", "prepareCheckBox", "prepareToolbar", "prepareWebView", "Companion", "OnFragmentInteractionListener", "IqOption-5.5.1_optionXRelease"})
/* compiled from: KycGdprFragment.kt */
public final class a extends f implements com.iqoption.kyc.a.b {
    public static final String TAG = "com.iqoption.kyc.fragment.gdpr.a";
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(a.class), "termsLink", "getTermsLink()Lcom/iqoption/view/text/Link;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(a.class), "gdprLink", "getGdprLink()Lcom/iqoption/view/text/Link;"))};
    public static final a cKY = new a();
    private HashMap atz;
    private ConfirmButtonView bxH;
    private mz cKQ;
    private boolean cKR;
    private l cKS;
    private final kotlin.d cKT = g.f(new KycGdprFragment$termsLink$2(this));
    private final kotlin.d cKU = g.f(new KycGdprFragment$gdprLink$2(this));
    private KycGdprViewModel cKV;
    private b cKW;
    private final c cKX = new c(this);

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, aXE = {"Lcom/iqoption/kyc/fragment/gdpr/KycGdprFragment$Companion;", "", "()V", "STATE_SHOWN_URL", "", "TAG", "newInstance", "Lcom/iqoption/kyc/fragment/gdpr/KycGdprFragment;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: KycGdprFragment.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final a aqd() {
            return new a();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, aXE = {"Lcom/iqoption/kyc/fragment/gdpr/KycGdprFragment$OnFragmentInteractionListener;", "", "onGdprAccepted", "", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: KycGdprFragment.kt */
    public interface b {
        void aps();
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, aXE = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "checked", "", "onCheckedChanged"})
    /* compiled from: KycGdprFragment.kt */
    static final class e implements OnCheckedChangeListener {
        final /* synthetic */ a this$0;

        e(a aVar) {
            this.this$0 = aVar;
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            a.a(this.this$0).setEnabled(z);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, aXE = {"com/iqoption/kyc/fragment/gdpr/KycGdprFragment$linkClickListener$1", "Lcom/iqoption/view/text/LinkClickListener;", "onLinkClicked", "", "link", "Lcom/iqoption/view/text/Link;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: KycGdprFragment.kt */
    public static final class c implements m {
        final /* synthetic */ a this$0;

        c(a aVar) {
            this.this$0 = aVar;
        }

        public void b(l lVar) {
            h.e(lVar, "link");
            if ((h.E(this.this$0.cKS, lVar) ^ 1) != 0) {
                this.this$0.a(lVar);
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, aXE = {"com/iqoption/kyc/fragment/gdpr/KycGdprFragment$prepareButton$1", "Lcom/iqoption/view/viewinterface/OnClickDelayView;", "onDelayClick", "", "view", "Landroid/view/View;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: KycGdprFragment.kt */
    public static final class d extends com.iqoption.view.d.b {
        final /* synthetic */ a this$0;

        d(a aVar) {
            this.this$0 = aVar;
        }

        public void q(View view) {
            h.e(view, Promotion.ACTION_VIEW);
            a.a(this.this$0).f(true, true);
            this.this$0.cKR = true;
            af.a(a.b(this.this$0).b(new com.iqoption.core.microservices.busapi.response.b(Boolean.valueOf(true), null, null, null, null, 30, null)), new KycGdprFragment$prepareButton$1$onDelayClick$1(this), new KycGdprFragment$prepareButton$1$onDelayClick$2(this), null, 4, null);
        }
    }

    private final l apZ() {
        kotlin.d dVar = this.cKT;
        j jVar = apP[0];
        return (l) dVar.getValue();
    }

    private final l aqa() {
        kotlin.d dVar = this.cKU;
        j jVar = apP[1];
        return (l) dVar.getValue();
    }

    public static final a aqd() {
        return cKY.aqd();
    }

    public void KH() {
        if (this.atz != null) {
            this.atz.clear();
        }
    }

    public String apR() {
        return "GdprAcceptance";
    }

    public String apS() {
        return "GdprAcceptance";
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        KH();
    }

    public static final /* synthetic */ KycGdprViewModel b(a aVar) {
        KycGdprViewModel kycGdprViewModel = aVar.cKV;
        if (kycGdprViewModel == null) {
            h.lS("viewModel");
        }
        return kycGdprViewModel;
    }

    static {
        if (a.class.getName() == null) {
            h.aXZ();
        }
    }

    public void onAttach(Context context) {
        h.e(context, "context");
        super.onAttach(context);
        this.cKW = (b) context;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        h.e(layoutInflater, "inflater");
        this.cKQ = (mz) com.iqoption.core.ext.a.a((Fragment) this, (int) R.layout.fragment_kyc_gdpr, viewGroup, false, 4, null);
        mz mzVar = this.cKQ;
        if (mzVar == null) {
            h.lS("binding");
        }
        wp wpVar = mzVar.bxE;
        if (wpVar == null) {
            h.aXZ();
        }
        ConfirmButtonView confirmButtonView = wpVar.bxH;
        h.d(confirmButtonView, "binding.nextButton!!.nextButton");
        this.bxH = confirmButtonView;
        mzVar = this.cKQ;
        if (mzVar == null) {
            h.lS("binding");
        }
        return mzVar.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        h.e(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        KycGdprViewModel p = KycGdprViewModel.cKZ.p(com.iqoption.core.ext.a.n(this));
        h.d(p, "KycGdprViewModel.create(act)");
        this.cKV = p;
        aqb();
        ad(bundle);
        ae(bundle);
        aqc();
    }

    private final void aqb() {
        mz mzVar = this.cKQ;
        if (mzVar == null) {
            h.lS("binding");
        }
        wr wrVar = mzVar.bxz;
        if (wrVar == null) {
            h.aXZ();
        }
        Toolbar toolbar = wrVar.toolbar;
        FragmentActivity activity = zzakw();
        if (activity == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.support.v7.app.AppCompatActivity");
        }
        com.iqoption.kyc.i.a((AppCompatActivity) activity, toolbar);
    }

    public void onSaveInstanceState(Bundle bundle) {
        h.e(bundle, "outState");
        l lVar = this.cKS;
        if (lVar != null) {
            bundle.putParcelable("STATE_SHOWN_URL", lVar);
        }
        super.onSaveInstanceState(bundle);
    }

    public void onDetach() {
        this.cKW = (b) null;
        super.onDetach();
    }

    private final void ad(Bundle bundle) {
        mz mzVar = this.cKQ;
        if (mzVar == null) {
            h.lS("binding");
        }
        WebView webView = mzVar.byq;
        WebSettings settings = webView.getSettings();
        h.d(settings, "settings");
        settings.setJavaScriptEnabled(true);
        settings = webView.getSettings();
        h.d(settings, "settings");
        settings.setLoadWithOverviewMode(true);
        settings = webView.getSettings();
        h.d(settings, "settings");
        settings.setUseWideViewPort(true);
        webView.setBackgroundColor(0);
        webView.setWebChromeClient(new WebChromeClient());
        l lVar = bundle != null ? (l) bundle.getParcelable("STATE_SHOWN_URL") : null;
        if (lVar == null) {
            lVar = apZ();
        }
        a(lVar);
    }

    private final void ae(Bundle bundle) {
        Object[] objArr = new Object[]{apZ().getText(), aqa().getText()};
        String string = getString(R.string.i_hereby_accept, getString(R.string.n1_and_n2, objArr));
        mz mzVar = this.cKQ;
        if (mzVar == null) {
            h.lS("binding");
        }
        TextView textView = mzVar.byo;
        h.d(textView, "binding.kycGdprCheckBoxText");
        h.d(string, "text");
        l[] lVarArr = new l[]{apZ(), aqa()};
        o.a(new p(lVarArr, textView, string, 0, 0, this.cKX, 24, null));
        mz mzVar2 = this.cKQ;
        if (mzVar2 == null) {
            h.lS("binding");
        }
        CheckBox checkBox = mzVar2.byn;
        checkBox.setOnCheckedChangeListener(new e(this));
        if (bundle == null) {
            h.d(checkBox, "checkBox");
            checkBox.setChecked(false);
        }
        ConfirmButtonView confirmButtonView = this.bxH;
        if (confirmButtonView == null) {
            h.lS("nextButton");
        }
        h.d(checkBox, "checkBox");
        confirmButtonView.setEnabled(checkBox.isChecked());
    }

    private final void aqc() {
        ConfirmButtonView confirmButtonView = this.bxH;
        if (confirmButtonView == null) {
            h.lS("nextButton");
        }
        confirmButtonView.setOnClickListener(new d(this));
    }

    private final void a(l lVar) {
        mz mzVar = this.cKQ;
        if (mzVar == null) {
            h.lS("binding");
        }
        mzVar.byp.setText(lVar.getText());
        this.cKS = lVar;
        mzVar = this.cKQ;
        if (mzVar == null) {
            h.lS("binding");
        }
        mzVar.byq.loadUrl(lVar.getUrl());
    }

    public boolean apT() {
        return this.cKR;
    }
}
