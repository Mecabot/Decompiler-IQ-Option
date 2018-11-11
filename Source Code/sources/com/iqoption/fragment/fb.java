package com.iqoption.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.android.gms.analytics.HitBuilders.EventBuilder;
import com.google.android.gms.analytics.HitBuilders.ScreenViewBuilder;
import com.google.android.gms.analytics.Tracker;
import com.iqoption.analytics.EventManager;
import com.iqoption.app.IQApp;
import com.iqoption.app.a.b;
import com.iqoption.app.managers.ae;
import com.iqoption.core.i;
import com.iqoption.dto.Event;
import com.iqoption.dto.Event.Builder;
import com.iqoption.fragment.base.f;
import com.iqoption.fragment.cashbox.a;
import com.iqoption.mobbtech.connect.response.a.l;
import com.iqoption.util.am;
import com.iqoption.util.av;
import com.iqoption.x.R;

/* compiled from: WebFragment */
public class fb extends f {
    protected WebView EM;
    private ProgressBar bly;
    protected String clt;
    private boolean ctd;
    private boolean cte;
    private boolean ctf;
    private boolean ctg;
    private boolean cth;
    private ViewGroup cti;
    protected View ctj;
    protected View ctk;
    protected View ctl;
    private boolean ctm;
    private boolean ctn;
    private Builder cto;
    private Builder ctp;
    private Builder ctq;
    private final a ctr = new a();

    public static fb ab(Bundle bundle) {
        fb fbVar = new fb();
        fbVar.setArguments(bundle);
        return fbVar;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        i.d("WebFragment", "onCreateView");
        return layoutInflater.inflate(R.layout.web_fragment, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        i.d("WebFragment", "onViewCreated");
        super.onViewCreated(view, bundle);
        this.clt = getArguments().getString("EXTRA_URL", "");
        this.ctd = getArguments().getBoolean("EXTRA_IS_NEW_BILLING", false);
        this.cte = getArguments().getBoolean("EXTRA_IS_DEPOSIT", false);
        this.ctg = getArguments().getBoolean("EXTRA_IS_WITHDRAWAL", false);
        boolean z = getArguments().getBoolean("EXTRA_IS_POST", false);
        Y(view);
        zH();
        String clusterApi = IQApp.Dl().getClusterApi();
        if (this.ctd) {
            aiJ();
        } else if (this.ctg) {
            aiK();
        } else {
            String str = this.clt;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(clusterApi);
            stringBuilder.append("mobile/education/");
            if (str.startsWith(stringBuilder.toString())) {
                aiL();
            } else if (this.clt.equalsIgnoreCase("https://otn.org/?aff=6&afftrack=android_app")) {
                this.cto = Event.Builder(Event.CATEGORY_SCREEN_OPENED, "otn_otn-info-web-page");
                this.ctp = Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "otn_otn-info-web-page-return");
            }
        }
        if (z) {
            this.EM.postUrl(this.clt, getArguments().getByteArray("EXTRA_POST_BYTE_ARRAY"));
        } else {
            this.EM.loadUrl(this.clt);
        }
        this.EM.setAlpha(0.0f);
        this.EM.animate().alpha(1.0f).setDuration(600).start();
    }

    public void onDestroy() {
        i.d("WebFragment", "onDestroy");
        if (this.cte) {
            this.ctr.bo(getContext());
        }
        aiN();
        super.onDestroy();
    }

    private void aiJ() {
        i.d("WebFragment", "initBillingPage");
        this.ctq = Event.Builder(Event.CATEGORY_SYSTEM, "billing_page-loaded");
        this.cto = Event.Builder(Event.CATEGORY_SCREEN_OPENED, "deposit");
        this.ctp = Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "deposit_back");
        ae.d(getContext(), 512);
        this.ctk.setVisibility(8);
        Tracker aP = IQApp.aP(getContext());
        aP.setScreenName("Personal data");
        aP.send(((ScreenViewBuilder) new ScreenViewBuilder().setCustomDimension(2, aP.get("&cid"))).build());
        aP.send(((EventBuilder) ((EventBuilder) new EventBuilder().setCustomMetric(1, (float) com.iqoption.app.a.aL(getContext()).getUserId())).setCategory("Android").setAction("Billing_Metrics").setLabel("BilingPage_Loading").setCustomDimension(2, aP.get("&cid"))).build());
    }

    private void aiK() {
        i.d("WebFragment", "initWithdrawalPage");
        this.cto = Event.Builder(Event.CATEGORY_SCREEN_OPENED, "withdrawal");
        this.ctp = Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "withdrawal_back");
        ae.d(getContext(), 1024);
        Tracker aP = IQApp.aP(getContext());
        aP.setScreenName("Withdrawal page");
        aP.send(((ScreenViewBuilder) new ScreenViewBuilder().setCustomDimension(2, aP.get("&cid"))).build());
    }

    private void aiL() {
        i.d("WebFragment", "initEducationPage");
        this.cto = Event.Builder(Event.CATEGORY_SCREEN_OPENED, "education");
        this.ctp = Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "education_back");
        ae.d(getContext(), 2048);
        Tracker aP = IQApp.aP(getContext());
        aP.setScreenName("Education");
        aP.send(((ScreenViewBuilder) new ScreenViewBuilder().setCustomDimension(2, aP.get("&cid"))).build());
    }

    private void Y(View view) {
        i.d("WebFragment", "initControls");
        ((TextView) view.findViewById(R.id.title)).setText(getArguments().getString("EXTRA_TITLE"));
        this.EM = (WebView) view.findViewById(R.id.fragmentWeb);
        this.bly = (ProgressBar) view.findViewById(R.id.toolbarProgress);
        this.cti = (ViewGroup) view.findViewById(R.id.mainContent);
        this.ctl = view.findViewById(R.id.titleContainer);
        afP();
        afN();
        aen();
        aT(view);
    }

    private void aT(View view) {
        i.d("WebFragment", "initBackButton");
        view.findViewById(R.id.backButton).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (fb.this.getArguments().getBoolean("EXTRA_ACTIVITY_BACK_PRESSED", false)) {
                    fb.this.zzakw().onBackPressed();
                } else if (fb.this.getFragmentManager().getBackStackEntryCount() > 0) {
                    fb.this.onBackPressed();
                } else {
                    fb.this.aiM();
                }
            }
        });
        this.ctj = view.findViewById(R.id.backButton2);
        this.ctj.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (fb.this.ajV().zN()) {
                    am.a(fb.this.zzakw(), fb.this.EM);
                } else {
                    fb.this.EM.loadUrl(fb.this.clt);
                }
            }
        });
        this.ctk = view.findViewById(R.id.closeButton);
        this.ctk.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (fb.this.ajV().zN()) {
                    am.a(fb.this.zzakw(), fb.this.EM);
                } else {
                    fb.this.aiM();
                }
            }
        });
    }

    private void aiM() {
        i.d("WebFragment", "forceClose");
        if (!super.aN()) {
            if (ajV().zN()) {
                am.a(zzakw(), this.EM);
            }
            FragmentManager fragmentManager = getFragmentManager();
            if (fragmentManager == null) {
                fragmentManager = zzakw().getSupportFragmentManager();
            }
            if (fragmentManager.findFragmentByTag("WebFragment") != null) {
                fragmentManager.popBackStack();
            }
            if (getTradeRoomActivity() != null) {
                getTradeRoomActivity().Ag();
            }
            if (this.ctd) {
                Tracker aP = IQApp.aP(zzakw());
                if (this.ctm) {
                    aP.send(((EventBuilder) ((EventBuilder) new EventBuilder().setCustomMetric(1, (float) com.iqoption.app.a.aL(getContext()).getUserId())).setCategory("Android").setAction("Billing_Metrics").setLabel("BilingPageIsLoaded").setCustomDimension(2, aP.get("&cid"))).build());
                }
                if (this.ctn) {
                    aP.send(((EventBuilder) ((EventBuilder) new EventBuilder().setCustomMetric(1, (float) com.iqoption.app.a.aL(getContext()).getUserId())).setCategory("Android").setAction("Billing_Metrics").setLabel("GatePage_Loaded").setCustomDimension(2, aP.get("&cid"))).build());
                }
            }
            if (this.cto != null) {
                EventManager.Bm().a(this.cto.calcDuration().build());
            }
            aiN();
        }
    }

    private void aiN() {
        if (!this.cth && this.ctg && this.clt.contains("frontend/mobile/withdrawal/?sess_id=")) {
            IQApp.Dn().aE(new l());
            this.cth = true;
        }
    }

    public boolean onBackPressed() {
        i.d("WebFragment", "onBackPressed");
        if (!isAdded()) {
            return false;
        }
        if (ajV().zN()) {
            am.a(zzakw(), this.EM);
            return true;
        } else if (this.clt == null || this.EM == null || this.EM.getUrl() == null) {
            return false;
        } else {
            if (!this.EM.canGoBack() || this.EM.getUrl().startsWith(this.clt)) {
                aiM();
            } else {
                this.EM.loadUrl(this.clt);
                if (this.ctp != null) {
                    EventManager.Bm().a(this.ctp.build());
                }
            }
            return true;
        }
    }

    protected void afN() {
        i.d("WebFragment", "initWebView");
        this.EM.setWebViewClient(afO());
        this.EM.setWebChromeClient(new WebChromeClient() {
            private CustomViewCallback clB;
            private View clC;

            public void onHideCustomView() {
                if (this.clC != null) {
                    fb.this.cti.removeView(this.clC);
                    this.clC.setVisibility(8);
                    this.clB.onCustomViewHidden();
                    this.clB = null;
                    this.clC = null;
                }
            }

            public void onShowCustomView(View view, CustomViewCallback customViewCallback) {
                if (this.clC == null) {
                    customViewCallback.onCustomViewHidden();
                    return;
                }
                this.clC = view;
                fb.this.cti.addView(view);
                this.clB = customViewCallback;
            }
        });
        this.EM.setDownloadListener(new DownloadListener() {
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                if (fb.this.isAdded()) {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse(str));
                    fb.this.startActivity(intent);
                }
            }
        });
        WebSettings settings = this.EM.getSettings();
        settings.setDomStorageEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setJavaScriptEnabled(true);
        settings.setRenderPriority(RenderPriority.HIGH);
        settings.setCacheMode(2);
    }

    private WebViewClient afO() {
        return new WebViewClient() {
            private String cly = null;
            private boolean clz = false;

            public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("shouldInterceptRequest url=");
                stringBuilder.append(str);
                i.d("WebFragment", stringBuilder.toString());
                return super.shouldInterceptRequest(webView, str);
            }

            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("shouldOverrideUrlLoading:");
                stringBuilder.append(str);
                i.d("WebFragment", stringBuilder.toString());
                if (str.contains("/traderoom")) {
                    fb.this.aiM();
                    webView.stopLoading();
                    return true;
                }
                if (this.cly == null) {
                    this.cly = str;
                } else if (str.equals(this.cly)) {
                    if (this.clz) {
                        fb.this.aiM();
                        webView.stopLoading();
                        return false;
                    }
                    this.clz = true;
                }
                webView.loadUrl(str);
                return true;
            }

            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onPageStarted:");
                stringBuilder.append(str);
                i.d("WebFragment", stringBuilder.toString());
                if (fb.this.cte) {
                    fb.this.ctr.hI(str);
                }
                if (fb.this.ctf) {
                    if (str.contains("external/counting/mobile") || str.contains("page/cashbox/mobile") || str.contains("page/payment/success") || str.contains("page/payment/failed")) {
                        fb.this.ctj.setVisibility(8);
                    } else {
                        fb.this.ctj.setVisibility(0);
                    }
                }
                if (str.contains("cabinet/counting/success")) {
                    b.b(fb.this.getString(R.string.payment_successfull), fb.this.zzakw());
                    fb.this.EM.stopLoading();
                    fb.this.onBackPressed();
                } else if (str.contains("cabinet/counting/failed")) {
                    b.b(fb.this.getString(R.string.payment_unsuccessfull), fb.this.zzakw());
                    fb.this.onBackPressed();
                    fb.this.EM.stopLoading();
                } else if (str.contains("/traderoom")) {
                    fb.this.EM.stopLoading();
                    fb.this.aiM();
                } else {
                    fb.this.zH();
                }
            }

            public void onPageFinished(WebView webView, String str) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onPageFinished:");
                stringBuilder.append(str);
                i.d("WebFragment", stringBuilder.toString());
                if (str.equals(fb.this.clt)) {
                    fb.this.ctm = true;
                } else {
                    fb.this.ctn = true;
                }
                fb.this.YL();
                if (fb.this.cte) {
                    fb.this.ctr.c(str, fb.this.getContext());
                }
                if (fb.this.ctq != null) {
                    EventManager.Bm().a(fb.this.ctq.calcDuration().setTechnicalLogs(Boolean.valueOf(true)).build());
                }
            }

            public void onReceivedError(WebView webView, int i, String str, String str2) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onReceivedError:");
                stringBuilder.append(str2);
                i.d("WebFragment", stringBuilder.toString());
                fb.this.YL();
            }

            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                i.d("WebFragment", "onReceivedError");
                if (fb.this.cte && VERSION.SDK_INT >= 21 && webResourceRequest != null && webResourceRequest.getUrl() != null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("onReceivedError, url=");
                    stringBuilder.append(webResourceRequest.getUrl());
                    i.e("WebFragment", stringBuilder.toString());
                    fb.this.ctr.d(webResourceRequest.getUrl().toString(), fb.this.getContext());
                }
                super.onReceivedError(webView, webResourceRequest, webResourceError);
            }
        };
    }

    public void onResume() {
        i.d("WebFragment", "onResume");
        super.onResume();
        ajV().zL();
    }

    public void onPause() {
        i.d("WebFragment", "onPause");
        super.onPause();
        ajV().zM();
    }

    public void zH() {
        i.d("WebFragment", "showProgressDialog");
        this.bly.setVisibility(0);
    }

    public void YL() {
        i.d("WebFragment", "dismissProgressDialog");
        this.bly.setVisibility(8);
    }

    private void aen() {
        i.d("WebFragment", "addCookies");
        CookieSyncManager.createInstance(zzakw());
        CookieManager instance = CookieManager.getInstance();
        instance.removeAllCookie();
        instance.setAcceptCookie(true);
        av.a(instance, IQApp.Dl().getClusterApi());
        av.a(instance, this.clt);
        CookieSyncManager.getInstance().sync();
    }

    protected void afP() {
        i.d("WebFragment", "clearWebView");
        this.EM.clearCache(true);
        this.EM.clearFormData();
        this.EM.clearHistory();
        this.EM.clearMatches();
        this.EM.clearSslPreferences();
    }
}
