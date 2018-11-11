package com.iqoption.protrader.web;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebChromeClient.FileChooserParams;
import android.webkit.WebSettings;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.android.gms.plus.PlusShare;
import com.iqoption.app.IQApp;
import com.iqoption.d.aki;
import com.iqoption.d.qh;
import com.iqoption.fragment.as;
import com.iqoption.fragment.base.f;
import com.iqoption.util.am;
import com.iqoption.util.av;
import com.iqoption.view.text.q;
import com.iqoption.x.R;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.i;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 :2\u00020\u00012\u00020\u0002:\u0001:B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0015\u001a\u00020\u0016H\u0002J#\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\f0\bH\u0002¢\u0006\u0002\u0010\u001bJ\u0006\u0010\u001c\u001a\u00020\u0016J\b\u0010\u001d\u001a\u00020\u0016H\u0002J\b\u0010\u001e\u001a\u00020\u0016H\u0002J\"\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\b\u0010#\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020\u0016H\u0016J&\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\b\u0010/\u001a\u00020\u0016H\u0016J\u0010\u00100\u001a\u00020\u00162\u0006\u00101\u001a\u00020.H\u0016J\u001a\u00102\u001a\u00020\u00162\u0006\u00103\u001a\u00020(2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u0010\u00104\u001a\u00020\u00162\u0006\u00105\u001a\u00020\fH\u0002J\u001b\u00106\u001a\u00020\u00162\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\f0\bH\u0002¢\u0006\u0002\u00107J\u0010\u00108\u001a\u00020%2\u0006\u00105\u001a\u00020\fH\u0002J\u0006\u00109\u001a\u00020\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012¨\u0006;"}, aXE = {"Lcom/iqoption/protrader/web/ProTraderWebFragment;", "Lcom/iqoption/fragment/base/IQFragment;", "Lcom/iqoption/fragment/DarkDialogFragment$OnDialogListener;", "()V", "binding", "Lcom/iqoption/databinding/FragmentProTraderWebBinding;", "fileCallback", "Landroid/webkit/ValueCallback;", "", "Landroid/net/Uri;", "fileCallbackOldApi", "startUrl", "", "toolbar", "Lcom/iqoption/databinding/ToolbarBlackLayoutBinding;", "type", "Lcom/iqoption/protrader/web/ProTraderWebType;", "getType", "()Lcom/iqoption/protrader/web/ProTraderWebType;", "type$delegate", "Lkotlin/Lazy;", "addCookies", "", "applyAcceptedTypes", "intent", "Landroid/content/Intent;", "mimeTypes", "(Landroid/content/Intent;[Ljava/lang/String;)V", "dismissProgressDialog", "initToolbar", "initWebView", "onActivityResult", "requestCode", "", "resultCode", "data", "onBackPressed", "", "onConfirm", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDialogClose", "onSaveInstanceState", "outState", "onViewCreated", "view", "openLinkInBrowser", "url", "pickFile", "([Ljava/lang/String;)V", "shouldOpenInBrowser", "showProgressDialog", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: ProTraderWebFragment.kt */
public final class a extends f implements com.iqoption.fragment.as.b {
    private static final String TAG = "com.iqoption.protrader.web.a";
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(a.class), Param.TYPE, "getType()Lcom/iqoption/protrader/web/ProTraderWebType;"))};
    private static final List<String> deq = m.listOf("terms-and-conditions/investor-compensation-fund", "/traderoom");
    public static final a der = new a();
    private HashMap atz;
    private String clt;
    private qh del;
    private aki dem;
    private final kotlin.d den = g.f(new ProTraderWebFragment$type$2(this));
    private ValueCallback<Uri[]> deo;
    private ValueCallback<Uri> dep;

    @i(aXC = {1, 1, 11}, aXD = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \f*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0017"}, aXE = {"Lcom/iqoption/protrader/web/ProTraderWebFragment$Companion;", "", "()V", "ARG_TYPE", "", "PATH_LIST_TO_OPEN_IN_BROWSER", "", "PATH_TERMS_AND_CONDITIONS", "PATH_TRADEROOM", "REQUEST_CODE_PICK_FILE", "", "TAG", "kotlin.jvm.PlatformType", "URL_PRO_TRADERS", "URL_PRO_TRADERS_STATUS", "URL_USER_VERIFICATION", "show", "", "fm", "Landroid/support/v4/app/FragmentManager;", "containerId", "type", "Lcom/iqoption/protrader/web/ProTraderWebType;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: ProTraderWebFragment.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final void a(FragmentManager fragmentManager, int i, ProTraderWebType proTraderWebType) {
            h.e(fragmentManager, "fm");
            h.e(proTraderWebType, Param.TYPE);
            a aVar = new a();
            Bundle bundle = new Bundle();
            bundle.putSerializable("ARG_TYPE", proTraderWebType);
            aVar.setArguments(bundle);
            fragmentManager.beginTransaction().add(i, aVar, a.TAG).addToBackStack(a.TAG).commit();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: ProTraderWebFragment.kt */
    static final class b implements OnClickListener {
        final /* synthetic */ a this$0;

        b(a aVar) {
            this.this$0 = aVar;
        }

        public final void onClick(View view) {
            com.iqoption.core.ext.a.n(this.this$0).onBackPressed();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0003H\u0016J\"\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0003H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, aXE = {"com/iqoption/protrader/web/ProTraderWebFragment$initWebView$1", "Landroid/webkit/WebViewClient;", "firstUrl", "", "firstUrlLoadingOnce", "", "onPageFinished", "", "view", "Landroid/webkit/WebView;", "url", "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "shouldOverrideUrlLoading", "webView", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: ProTraderWebFragment.kt */
    public static final class c extends WebViewClient {
        private String cly;
        private boolean clz;
        final /* synthetic */ a this$0;

        c(a aVar) {
            this.this$0 = aVar;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            h.e(webView, "webView");
            h.e(str, PlusShare.KEY_CALL_TO_ACTION_URL);
            if (this.cly == null) {
                this.cly = str;
            } else if (h.E(str, this.cly)) {
                if (this.clz) {
                    webView.stopLoading();
                    return false;
                }
                this.clz = true;
            }
            if (this.this$0.iY(str)) {
                this.this$0.iZ(str);
            } else {
                webView.loadUrl(str);
            }
            return true;
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            h.e(webView, Promotion.ACTION_VIEW);
            h.e(str, PlusShare.KEY_CALL_TO_ACTION_URL);
            this.this$0.zH();
        }

        public void onPageFinished(WebView webView, String str) {
            h.e(webView, Promotion.ACTION_VIEW);
            h.e(str, PlusShare.KEY_CALL_TO_ACTION_URL);
            this.this$0.YL();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000I\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0003H\u0016J,\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0017J$\u0010\u0015\u001a\u00020\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00120\u00102\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, aXE = {"com/iqoption/protrader/web/ProTraderWebFragment$initWebView$2", "Landroid/webkit/WebChromeClient;", "customCallback", "Landroid/webkit/WebChromeClient$CustomViewCallback;", "customView", "Landroid/view/View;", "onHideCustomView", "", "onShowCustomView", "view", "callback", "onShowFileChooser", "", "webView", "Landroid/webkit/WebView;", "filePathCallback", "Landroid/webkit/ValueCallback;", "", "Landroid/net/Uri;", "fileChooserParams", "Landroid/webkit/WebChromeClient$FileChooserParams;", "openFileChooser", "acceptType", "", "capture", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: ProTraderWebFragment.kt */
    public static final class d extends WebChromeClient {
        private CustomViewCallback clB;
        private View clC;
        final /* synthetic */ a this$0;

        d(a aVar) {
            this.this$0 = aVar;
        }

        public void onHideCustomView() {
            if (this.clC != null) {
                View view = this.clC;
                if (view == null) {
                    h.aXZ();
                }
                view.setVisibility(8);
                CustomViewCallback customViewCallback = this.clB;
                if (customViewCallback == null) {
                    h.aXZ();
                }
                customViewCallback.onCustomViewHidden();
                this.clB = (CustomViewCallback) null;
                this.clC = (View) null;
            }
        }

        public void onShowCustomView(View view, CustomViewCallback customViewCallback) {
            h.e(view, Promotion.ACTION_VIEW);
            h.e(customViewCallback, "callback");
            if (this.clC == null) {
                customViewCallback.onCustomViewHidden();
                return;
            }
            this.clC = view;
            this.clB = customViewCallback;
        }

        @TargetApi(21)
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, FileChooserParams fileChooserParams) {
            h.e(webView, "webView");
            h.e(valueCallback, "filePathCallback");
            h.e(fileChooserParams, "fileChooserParams");
            this.this$0.deo = valueCallback;
            a aVar = this.this$0;
            String[] acceptTypes = fileChooserParams.getAcceptTypes();
            h.d(acceptTypes, "fileChooserParams.acceptTypes");
            aVar.c(acceptTypes);
            return true;
        }
    }

    private final ProTraderWebType ayF() {
        kotlin.d dVar = this.den;
        j jVar = apP[0];
        return (ProTraderWebType) dVar.getValue();
    }

    public void KH() {
        if (this.atz != null) {
            this.atz.clear();
        }
    }

    public void ahp() {
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        KH();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        h.e(layoutInflater, "inflater");
        this.del = (qh) com.iqoption.core.ext.a.a((Fragment) this, (int) R.layout.fragment_pro_trader_web, viewGroup, false, 4, null);
        qh qhVar = this.del;
        if (qhVar == null) {
            h.lS("binding");
        }
        return qhVar.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        String str;
        h.e(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        apX();
        switch (ayF()) {
            case APPLY:
                str = "https://verify.iqoption.com/pro-traders?mobile=true";
                break;
            case MOR_INFO:
                str = q.o(com.iqoption.core.ext.a.m(this), R.string.pro_info_n1);
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        this.clt = str;
        afN();
        aen();
        zH();
        qh qhVar = this.del;
        if (qhVar == null) {
            h.lS("binding");
        }
        WebView webView = qhVar.bAI;
        if (bundle == null) {
            String str2 = this.clt;
            if (str2 == null) {
                h.lS("startUrl");
            }
            webView.loadUrl(str2);
        } else {
            webView.restoreState(bundle);
        }
        webView.setAlpha(0.0f);
        webView.animate().alpha(1.0f).setDuration(600).start();
    }

    private final void apX() {
        int i;
        switch (ayF()) {
            case APPLY:
                i = R.string.application_to_pro;
                break;
            case MOR_INFO:
                i = R.string.learn_more_about_pro;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        qh qhVar = this.del;
        if (qhVar == null) {
            h.lS("binding");
        }
        aki aki = qhVar.bAG;
        h.d(aki, "binding.proToolbar");
        this.dem = aki;
        aki = this.dem;
        if (aki == null) {
            h.lS("toolbar");
        }
        aki.agA.setText(i);
        aki aki2 = this.dem;
        if (aki2 == null) {
            h.lS("toolbar");
        }
        aki2.bNY.setOnClickListener(new b(this));
    }

    public void onSaveInstanceState(Bundle bundle) {
        h.e(bundle, "outState");
        qh qhVar = this.del;
        if (qhVar == null) {
            h.lS("binding");
        }
        qhVar.bAI.saveState(bundle);
        super.onSaveInstanceState(bundle);
    }

    public boolean onBackPressed() {
        qh qhVar = this.del;
        if (qhVar == null) {
            h.lS("binding");
        }
        WebView webView = qhVar.bAI;
        h.d(webView, "webView");
        String url = webView.getUrl();
        com.iqoption.activity.b ajV = ajV();
        h.d(ajV, "iqActivity");
        boolean z = false;
        if (ajV.zN()) {
            am.a(zzakw(), webView);
            z = true;
        } else if ((url == null || !u.a(url, "https://verify.iqoption.com/pro-traders/status/", false, 2, null)) && ayF() == ProTraderWebType.APPLY) {
            com.iqoption.fragment.as.a aVar = as.coZ;
            FragmentManager q = com.iqoption.core.ext.a.q(this);
            CharSequence string = getString(R.string.confirm_back);
            String string2 = getString(R.string.you_have_not_finished_your_application);
            h.d(string2, "getString(R.string.you_h…inished_your_application)");
            aVar.a(q, R.id.proWebOther, string, string2, getString(R.string.cancel), getString(R.string.confirm));
            return true;
        }
        return z;
    }

    public void ahq() {
        com.iqoption.core.ext.a.n(this).finish();
    }

    private final void afN() {
        qh qhVar = this.del;
        if (qhVar == null) {
            h.lS("binding");
        }
        WebView webView = qhVar.bAI;
        h.d(webView, "binding.proWebView");
        webView.setWebViewClient(new c(this));
        qhVar = this.del;
        if (qhVar == null) {
            h.lS("binding");
        }
        webView = qhVar.bAI;
        h.d(webView, "binding.proWebView");
        webView.setWebChromeClient(new d(this));
        qhVar = this.del;
        if (qhVar == null) {
            h.lS("binding");
        }
        webView = qhVar.bAI;
        h.d(webView, "binding.proWebView");
        WebSettings settings = webView.getSettings();
        settings.setDomStorageEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setJavaScriptEnabled(true);
        settings.setRenderPriority(RenderPriority.HIGH);
        settings.setCacheMode(2);
    }

    public final void zH() {
        aki aki = this.dem;
        if (aki == null) {
            h.lS("toolbar");
        }
        ContentLoadingProgressBar contentLoadingProgressBar = aki.aOW;
        h.d(contentLoadingProgressBar, "toolbar.toolbarProgress");
        contentLoadingProgressBar.setVisibility(0);
    }

    public final void YL() {
        aki aki = this.dem;
        if (aki == null) {
            h.lS("toolbar");
        }
        ContentLoadingProgressBar contentLoadingProgressBar = aki.aOW;
        h.d(contentLoadingProgressBar, "toolbar.toolbarProgress");
        contentLoadingProgressBar.setVisibility(8);
    }

    private final void aen() {
        CookieSyncManager.createInstance(zzakw());
        CookieManager instance = CookieManager.getInstance();
        instance.removeAllCookie();
        instance.setAcceptCookie(true);
        av.a(instance, IQApp.Dl().getClusterApi());
        String str = this.clt;
        if (str == null) {
            h.lS("startUrl");
        }
        av.a(instance, str);
        av.a(instance, "https://user-verification.iqoption.com/");
        CookieSyncManager.getInstance().sync();
    }

    private final void c(String[] strArr) {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        a(intent, strArr);
        startActivityForResult(Intent.createChooser(intent, getString(R.string.select_image)), 100);
    }

    private final void a(Intent intent, String[] strArr) {
        if (strArr.length == 1) {
            intent.setType(strArr[0]);
            return;
        }
        intent.setType("*/*");
        intent.putExtra("android.intent.extra.MIME_TYPES", strArr);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 100 && i2 == -1 && intent != null && intent.getData() != null) {
            ValueCallback valueCallback;
            Uri data = intent.getData();
            if (this.deo != null) {
                valueCallback = this.deo;
                if (valueCallback == null) {
                    h.aXZ();
                }
                Object obj = new Uri[1];
                h.d(data, "uri");
                obj[0] = data;
                valueCallback.onReceiveValue(obj);
                this.deo = (ValueCallback) null;
            }
            if (this.dep != null) {
                valueCallback = this.dep;
                if (valueCallback == null) {
                    h.aXZ();
                }
                valueCallback.onReceiveValue(data);
                this.dep = (ValueCallback) null;
            }
        }
    }

    private final boolean iY(String str) {
        Iterable<String> iterable = deq;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return false;
        }
        for (String b : iterable) {
            if (v.b((CharSequence) str, (CharSequence) b, false, 2, null)) {
                return true;
            }
        }
        return false;
    }

    private final void iZ(String str) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.addFlags(268435456);
        startActivity(intent);
    }
}
