package com.iqoption.fragment.cashbox;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.iqoption.analytics.EventManager;
import com.iqoption.core.i;
import com.iqoption.d.hb;
import com.iqoption.dto.Event;
import com.iqoption.dto.Event.Builder;
import com.iqoption.fragment.base.f;
import com.iqoption.util.am;
import com.iqoption.util.av;
import com.iqoption.x.R;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import org.apache.http.util.EncodingUtils;

/* compiled from: DepositWebPaymentFragment */
public class l extends f {
    public static final String TAG = "com.iqoption.fragment.cashbox.l";
    private final a ctr = new a();
    private String cxT;
    private HashMap<String, String> cxU;
    private boolean cxV;
    private boolean cxW;
    private hb cxX;
    private WebViewClient cxY = new WebViewClient() {
        /* JADX WARNING: Removed duplicated region for block: B:18:0x00b2  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x00b2  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x00b2  */
        public void onPageStarted(android.webkit.WebView r6, java.lang.String r7, android.graphics.Bitmap r8) {
            /*
            r5 = this;
            r0 = com.iqoption.fragment.cashbox.l.TAG;
            r1 = new java.lang.StringBuilder;
            r1.<init>();
            r2 = "onPageStarted, url=";
            r1.append(r2);
            r1.append(r7);
            r1 = r1.toString();
            com.iqoption.core.i.v(r0, r1);
            r0 = com.iqoption.fragment.cashbox.l.this;
            r0 = r0.akD();
            r1 = com.iqoption.fragment.cashbox.l.this;
            r1 = r1.cxW;
            r2 = 0;
            r3 = 1;
            if (r1 != 0) goto L_0x00af;
        L_0x0026:
            if (r0 == 0) goto L_0x00af;
        L_0x0028:
            r1 = "page/payment/success";
            r1 = r7.contains(r1);
            if (r1 != 0) goto L_0x00a4;
        L_0x0030:
            r1 = "redirect/success";
            r1 = r7.contains(r1);
            if (r1 == 0) goto L_0x0039;
        L_0x0038:
            goto L_0x00a4;
        L_0x0039:
            r1 = "page/payment/failed";
            r1 = r7.contains(r1);
            if (r1 != 0) goto L_0x005b;
        L_0x0041:
            r1 = "redirect/failed";
            r1 = r7.contains(r1);
            if (r1 == 0) goto L_0x004a;
        L_0x0049:
            goto L_0x005b;
        L_0x004a:
            r1 = "page/payment/new";
            r1 = r7.contains(r1);
            if (r1 == 0) goto L_0x00af;
        L_0x0052:
            r1 = com.iqoption.fragment.cashbox.l.this;
            r1.cxW = r3;
            r0.aau();
            goto L_0x00b0;
        L_0x005b:
            r1 = com.iqoption.fragment.cashbox.l.this;
            r1.cxW = r3;
            r1 = new java.lang.StringBuilder;
            r1.<init>();
            r4 = "failed url:";
            r1.append(r4);
            r1.append(r7);
            r4 = "; src redirectUrl:";
            r1.append(r4);
            r4 = com.iqoption.fragment.cashbox.l.this;
            r4 = r4.cxT;
            r1.append(r4);
            r4 = "; src redirectParams:";
            r1.append(r4);
            r4 = com.iqoption.fragment.cashbox.l.this;
            r4 = r4.cxU;
            r1.append(r4);
            r4 = "; isPost:";
            r1.append(r4);
            r4 = com.iqoption.fragment.cashbox.l.this;
            r4 = r4.cxV;
            r1.append(r4);
            r4 = ";";
            r1.append(r4);
            r1 = r1.toString();
            r0.e(r2, r1);
            goto L_0x00b0;
        L_0x00a4:
            r1 = com.iqoption.fragment.cashbox.l.this;
            r1.cxW = r3;
            r1 = "";
            r0.e(r3, r1);
            goto L_0x00b0;
        L_0x00af:
            r3 = 0;
        L_0x00b0:
            if (r3 != 0) goto L_0x00bb;
        L_0x00b2:
            r0 = com.iqoption.fragment.cashbox.l.this;
            r0 = r0.ctr;
            r0.hI(r7);
        L_0x00bb:
            super.onPageStarted(r6, r7, r8);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iqoption.fragment.cashbox.l.1.onPageStarted(android.webkit.WebView, java.lang.String, android.graphics.Bitmap):void");
        }

        public void onPageFinished(WebView webView, String str) {
            l.this.ctr.c(str, l.this.getContext());
            super.onPageFinished(webView, str);
        }

        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            if (!(VERSION.SDK_INT < 21 || webResourceRequest == null || webResourceRequest.getUrl() == null)) {
                String str = l.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onReceivedError, url=");
                stringBuilder.append(webResourceRequest.getUrl());
                i.e(str, stringBuilder.toString());
                l.this.ctr.d(webResourceRequest.getUrl().toString(), l.this.getContext());
            }
            super.onReceivedError(webView, webResourceRequest, webResourceError);
        }

        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            if (VERSION.SDK_INT < 21) {
                String str = l.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onReceivedSslError ");
                stringBuilder.append(sslError);
                i.e(str, stringBuilder.toString());
                return;
            }
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
        }

        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }

        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        }

        public void onLoadResource(WebView webView, String str) {
            String str2 = l.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onLoadResource ");
            stringBuilder.append(str);
            i.v(str2, stringBuilder.toString());
            super.onLoadResource(webView, str);
        }
    };
    private Builder cxf;

    /* compiled from: DepositWebPaymentFragment */
    public interface a {
        void aau();

        void e(boolean z, String str);
    }

    public boolean onBackPressed() {
        super.aN();
        a akD = akD();
        if (akD == null) {
            return false;
        }
        akD.aau();
        return true;
    }

    public static l a(String str, HashMap<String, String> hashMap, boolean z) {
        l lVar = new l();
        Bundle bundle = new Bundle();
        bundle.putString("ARG_REDIRECT_URL", str);
        bundle.putSerializable("ARG_REDIRECT_PARAMS", hashMap);
        bundle.putBoolean("ARG_REDIRECT_METHOD_IS_POST", z);
        lVar.setArguments(bundle);
        return lVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bundle = getArguments();
        if (bundle != null) {
            this.cxT = bundle.getString("ARG_REDIRECT_URL", "");
            this.cxU = (HashMap) bundle.getSerializable("ARG_REDIRECT_PARAMS");
            this.cxV = bundle.getBoolean("ARG_REDIRECT_METHOD_IS_POST");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.cxX = (hb) DataBindingUtil.inflate(layoutInflater, R.layout.deposit_payment_authorization_page, viewGroup, false);
        WebView webView = this.cxX.bqN;
        webView.setWebViewClient(this.cxY);
        WebSettings settings = webView.getSettings();
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        this.cxX.bqL.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                a a = l.this.akD();
                if (a != null) {
                    a.aau();
                }
            }
        });
        aen();
        if (this.cxV) {
            ael();
        } else {
            aem();
        }
        return this.cxX.getRoot();
    }

    public void onResume() {
        super.onResume();
        am.n(zzakw());
        this.cxf = Event.Builder(Event.CATEGORY_SCREEN_OPENED, "deposit-gate");
    }

    public void onPause() {
        super.onPause();
        EventManager.Bm().a(this.cxf.calcDuration().build());
    }

    public void onDestroy() {
        this.ctr.bo(getContext());
        super.onDestroy();
    }

    private void ael() {
        Uri.Builder buildUpon = Uri.parse(this.cxT).buildUpon();
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = this.cxU.entrySet().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            stringBuilder.append((String) entry.getKey());
            stringBuilder.append('=');
            stringBuilder.append((String) entry.getValue());
            if (it.hasNext()) {
                stringBuilder.append('&');
            }
        }
        byte[] bytes = EncodingUtils.getBytes(stringBuilder.toString(), "BASE64");
        String uri = buildUpon.build().toString();
        String str = TAG;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("post url: ");
        stringBuilder2.append(uri);
        i.d(str, stringBuilder2.toString());
        this.cxX.bqN.postUrl(uri, bytes);
    }

    private void aem() {
        Uri.Builder buildUpon = Uri.parse(this.cxT).buildUpon();
        for (Entry entry : this.cxU.entrySet()) {
            buildUpon.appendQueryParameter((String) entry.getKey(), (String) entry.getValue());
        }
        String uri = buildUpon.build().toString();
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("url: ");
        stringBuilder.append(uri);
        i.d(str, stringBuilder.toString());
        this.cxX.bqN.loadUrl(uri);
    }

    private a akD() {
        if (getContext() instanceof a) {
            return (a) getContext();
        }
        return getTargetFragment() instanceof a ? (a) getTargetFragment() : null;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public void onDetach() {
        super.onDetach();
    }

    private void aen() {
        i.d(TAG, "addCookies");
        CookieSyncManager.createInstance(zzakw());
        CookieManager instance = CookieManager.getInstance();
        instance.removeAllCookie();
        instance.setAcceptCookie(true);
        av.a(instance, this.cxT);
        CookieSyncManager.getInstance().sync();
    }
}
