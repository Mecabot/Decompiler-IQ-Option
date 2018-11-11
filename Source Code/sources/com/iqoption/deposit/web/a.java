package com.iqoption.deposit.web;

import android.arch.lifecycle.Lifecycle;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.plus.PlusShare;
import com.iqoption.billing.repository.e;
import com.iqoption.core.f;
import com.iqoption.deposit.p;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;
import okhttp3.HttpUrl;

@i(aXC = {1, 1, 11}, aXD = {"\u0000[\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001 \b&\u0018\u0000 22\u00020\u0001:\u000223B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020#H\u0002J\b\u0010%\u001a\u00020#H\u0002J\b\u0010&\u001a\u00020#H\u0016J\b\u0010'\u001a\u00020#H\u0016J\u001a\u0010(\u001a\u00020#2\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u0010-\u001a\u00020*H$J\u0012\u0010.\u001a\u00020\n2\b\u0010/\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u00100\u001a\u000201H$R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000f8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R'\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140\u00138BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\b\u001a\u0004\b\u0015\u0010\u0016R#\u0010\u0018\u001a\n \u0019*\u0004\u0018\u00010\u00140\u00148BX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\b\u001a\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u00020 X\u0004¢\u0006\u0004\n\u0002\u0010!¨\u00064"}, aXE = {"Lcom/iqoption/deposit/web/BaseRedirectWebPaymentFragment;", "Lcom/iqoption/core/ui/fragment/IQFragment;", "()V", "depositParams", "Lcom/iqoption/deposit/DepositParams;", "getDepositParams", "()Lcom/iqoption/deposit/DepositParams;", "depositParams$delegate", "Lkotlin/Lazy;", "isFiltered", "", "isPost", "()Z", "isPost$delegate", "listener", "Lcom/iqoption/deposit/web/BaseRedirectWebPaymentFragment$OnFragmentInteractionListener;", "getListener", "()Lcom/iqoption/deposit/web/BaseRedirectWebPaymentFragment$OnFragmentInteractionListener;", "redirectParams", "Ljava/util/HashMap;", "", "getRedirectParams", "()Ljava/util/HashMap;", "redirectParams$delegate", "redirectUrl", "kotlin.jvm.PlatformType", "getRedirectUrl", "()Ljava/lang/String;", "redirectUrl$delegate", "screenEvent", "Lcom/iqoption/core/analytics/AnalyticsSendEvent;", "webViewClient", "com/iqoption/deposit/web/BaseRedirectWebPaymentFragment$webViewClient$1", "Lcom/iqoption/deposit/web/BaseRedirectWebPaymentFragment$webViewClient$1;", "addCookies", "", "loadRedirectPageGet", "loadRedirectPagePost", "onDestroyView", "onResume", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "toolbarClose", "tryHandleUrlManually", "urlRaw", "webView", "Landroid/webkit/WebView;", "Companion", "OnFragmentInteractionListener", "deposit_release"})
/* compiled from: BaseRedirectWebPaymentFragment.kt */
public abstract class a extends com.iqoption.core.ui.fragment.b {
    private static final String TAG = "com.iqoption.deposit.web.a";
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(a.class), "redirectUrl", "getRedirectUrl()Ljava/lang/String;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(a.class), "redirectParams", "getRedirectParams()Ljava/util/HashMap;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(a.class), "isPost", "isPost()Z")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(a.class), "depositParams", "getDepositParams()Lcom/iqoption/deposit/DepositParams;"))};
    public static final a ceJ = new a();
    private HashMap atz;
    private com.iqoption.core.a.d bXA;
    private final kotlin.d ceD = g.f(new BaseRedirectWebPaymentFragment$redirectUrl$2(this));
    private final kotlin.d ceE = g.f(new BaseRedirectWebPaymentFragment$redirectParams$2(this));
    private final kotlin.d ceF = g.f(new BaseRedirectWebPaymentFragment$isPost$2(this));
    private final kotlin.d ceG = g.f(new BaseRedirectWebPaymentFragment$depositParams$2(this));
    private boolean ceH;
    private final d ceI = new d(this);

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, aXE = {"Lcom/iqoption/deposit/web/BaseRedirectWebPaymentFragment$Companion;", "", "()V", "ARG_DEPOSIT_PARAMS", "", "ARG_REDIRECT_METHOD_IS_POST", "ARG_REDIRECT_PARAMS", "ARG_REDIRECT_URL", "BITCOIN_SCHEME", "FAILED_URL", "REDIRECT_FAILED", "REDIRECT_SUCCESSED", "START_AGAIN_URL", "SUCCESS_URL", "TAG", "getTAG", "()Ljava/lang/String;", "deposit_release"})
    /* compiled from: BaseRedirectWebPaymentFragment.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final String Ll() {
            return a.TAG;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H&¨\u0006\t"}, aXE = {"Lcom/iqoption/deposit/web/BaseRedirectWebPaymentFragment$OnFragmentInteractionListener;", "", "onDepositPageWebPaymentResult", "", "isSuccess", "", "depositParams", "Lcom/iqoption/deposit/DepositParams;", "onDepositPageWebPaymentStartAgain", "deposit_release"})
    /* compiled from: BaseRedirectWebPaymentFragment.kt */
    public interface b {
        void a(boolean z, p pVar);

        void adN();
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: BaseRedirectWebPaymentFragment.kt */
    static final class c implements OnClickListener {
        final /* synthetic */ a this$0;

        c(a aVar) {
            this.this$0 = aVar;
        }

        public final void onClick(View view) {
            e.ary.JI();
            com.iqoption.deposit.navigator.b.cbG.G(this.this$0).pop();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u00007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\"\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001c\u0010\u000f\u001a\u00020\u00102\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\u0011"}, aXE = {"com/iqoption/deposit/web/BaseRedirectWebPaymentFragment$webViewClient$1", "Landroid/webkit/WebViewClient;", "onPageStarted", "", "view", "Landroid/webkit/WebView;", "url", "", "favicon", "Landroid/graphics/Bitmap;", "onReceivedError", "request", "Landroid/webkit/WebResourceRequest;", "error", "Landroid/webkit/WebResourceError;", "shouldOverrideUrlLoading", "", "deposit_release"})
    /* compiled from: BaseRedirectWebPaymentFragment.kt */
    public static final class d extends WebViewClient {
        final /* synthetic */ a this$0;

        d(a aVar) {
            this.this$0 = aVar;
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            h.e(webView, Promotion.ACTION_VIEW);
            h.e(str, PlusShare.KEY_CALL_TO_ACTION_URL);
            String Ll = a.ceJ.Ll();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onPageStarted, url=");
            stringBuilder.append(str);
            com.iqoption.core.i.v(Ll, stringBuilder.toString());
            b a = this.this$0.aek();
            if (!(a == null || this.this$0.ceH)) {
                CharSequence charSequence = str;
                if (v.b(charSequence, (CharSequence) "page/payment/success", false, 2, null) || v.b(charSequence, (CharSequence) "redirect/success", false, 2, null)) {
                    this.this$0.ceH = true;
                    a.a(true, this.this$0.adL());
                } else if (v.b(charSequence, (CharSequence) "page/payment/failed", false, 2, null) || v.b(charSequence, (CharSequence) "redirect/failed", false, 2, null)) {
                    this.this$0.ceH = true;
                    a.a(false, this.this$0.adL());
                } else if (v.b(charSequence, (CharSequence) "page/payment/new", false, 2, null)) {
                    this.this$0.ceH = true;
                    a.adN();
                }
            }
            super.onPageStarted(webView, str, bitmap);
        }

        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            h.e(webView, Promotion.ACTION_VIEW);
            h.e(webResourceError, "error");
            if (!(VERSION.SDK_INT < 21 || webResourceRequest == null || webResourceRequest.getUrl() == null)) {
                String Ll = a.ceJ.Ll();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onReceivedError, url=");
                stringBuilder.append(webResourceRequest.getUrl());
                com.iqoption.core.i.e(Ll, stringBuilder.toString());
            }
            super.onReceivedError(webView, webResourceRequest, webResourceError);
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (this.this$0.hl(str)) {
                return true;
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }
    }

    private final p adL() {
        kotlin.d dVar = this.ceG;
        j jVar = apP[3];
        return (p) dVar.getValue();
    }

    private final HashMap<String, String> aei() {
        kotlin.d dVar = this.ceE;
        j jVar = apP[1];
        return (HashMap) dVar.getValue();
    }

    private final boolean aej() {
        kotlin.d dVar = this.ceF;
        j jVar = apP[2];
        return ((Boolean) dVar.getValue()).booleanValue();
    }

    private final String iM() {
        kotlin.d dVar = this.ceD;
        j jVar = apP[0];
        return (String) dVar.getValue();
    }

    public void KH() {
        if (this.atz != null) {
            this.atz.clear();
        }
    }

    protected abstract View add();

    protected abstract WebView ade();

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

    static {
        if (a.class.getName() == null) {
            h.aXZ();
        }
    }

    private final b aek() {
        if (getContext() instanceof b) {
            return (b) getContext();
        }
        if (getTargetFragment() instanceof b) {
            return (b) getTargetFragment();
        }
        return getParentFragment() instanceof b ? (b) getParentFragment() : null;
    }

    public void onViewCreated(View view, Bundle bundle) {
        h.e(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        WebView ade = ade();
        ade.setWebViewClient(this.ceI);
        WebSettings settings = ade.getSettings();
        h.d(settings, "settings");
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        aen();
        if (aej()) {
            ael();
        } else {
            aem();
        }
        add().setOnClickListener(new c(this));
        Lifecycle lifecycle = getLifecycle();
        FragmentActivity n = com.iqoption.core.ext.a.n(this);
        if (n == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.iqoption.core.ui.navigation.BackController");
        }
        lifecycle.a(new BaseRedirectWebPaymentFragment$onViewCreated$2(this, ade, (com.iqoption.core.ui.navigation.a) n));
        this.bXA = f.RQ().Ds().d("deposit-gate", 0.0d, com.iqoption.deposit.c.c.ceC.aeh());
    }

    public void onResume() {
        super.onResume();
        com.iqoption.core.util.j.n(zzakw());
    }

    public void onDestroyView() {
        com.iqoption.core.a.d dVar = this.bXA;
        if (dVar != null) {
            dVar.Bs();
        }
        super.onDestroyView();
        KH();
    }

    private final void ael() {
        Builder buildUpon = Uri.parse(iM()).buildUpon();
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = aei().entrySet().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            stringBuilder.append((String) entry.getKey());
            stringBuilder.append('=');
            stringBuilder.append((String) entry.getValue());
            if (it.hasNext()) {
                stringBuilder.append('&');
            }
        }
        byte[] decode = Base64.decode(stringBuilder.toString(), 0);
        String uri = buildUpon.build().toString();
        String str = TAG;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("post url: ");
        stringBuilder2.append(uri);
        com.iqoption.core.i.d(str, stringBuilder2.toString());
        ade().postUrl(uri, decode);
    }

    private final void aem() {
        Builder buildUpon = Uri.parse(iM()).buildUpon();
        for (Entry entry : aei().entrySet()) {
            buildUpon.appendQueryParameter((String) entry.getKey(), (String) entry.getValue());
        }
        String uri = buildUpon.build().toString();
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("url: ");
        stringBuilder.append(uri);
        com.iqoption.core.i.d(str, stringBuilder.toString());
        ade().loadUrl(uri);
    }

    private final void aen() {
        com.iqoption.core.i.d(TAG, "addCookies");
        CookieSyncManager.createInstance(zzakw());
        CookieManager instance = CookieManager.getInstance();
        instance.removeAllCookie();
        instance.setAcceptCookie(true);
        if (!TextUtils.isEmpty(iM())) {
            HttpUrl parse = HttpUrl.parse(iM());
            if (parse == null) {
                h.aXZ();
            }
            String host = parse.host();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("lang=");
            stringBuilder.append(f.getLocale());
            instance.setCookie(host, stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append("platform=");
            stringBuilder.append(f.Dp().DM());
            instance.setCookie(host, stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append("ssid=");
            stringBuilder.append(com.iqoption.core.connect.http.b.aNM.Sq());
            instance.setCookie(host, stringBuilder.toString());
        }
        CookieSyncManager.getInstance().sync();
    }

    private final boolean hl(String str) {
        boolean z = false;
        if (str == null) {
            return false;
        }
        try {
            Uri parse = Uri.parse(str);
            if (parse != null && (h.E(parse.getScheme(), "bitcoin") ^ 1) == 0) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.addFlags(268435456);
                intent.setData(parse);
                startActivity(intent);
                z = true;
            }
        } catch (Exception unused) {
            return z;
        }
    }
}
