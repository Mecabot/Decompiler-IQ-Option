package com.iqoption.feed;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.net.Uri;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.GestureDetectorCompat;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebSettings;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.plus.PlusShare;
import com.iqoption.analytics.EventManager;
import com.iqoption.app.managers.y;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.d.kx;
import com.iqoption.dto.Event;
import com.iqoption.service.WebSocketHandler;
import com.iqoption.util.am;
import com.iqoption.util.l;
import com.iqoption.x.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.util.Arrays;
import java.util.Locale;
import kotlin.i;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.m;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000  2\u00020\u0001:\u0001 B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0012H\u0002J\b\u0010\u0016\u001a\u00020\u0012H\u0003J\b\u0010\u0017\u001a\u00020\u0012H\u0016J\b\u0010\u0018\u001a\u00020\u0012H\u0002J\u0012\u0010\u0019\u001a\u00020\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\b\u0010\u001c\u001a\u00020\u0012H\u0014J\u0018\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, aXE = {"Lcom/iqoption/feed/FeedWebViewActivity;", "Lcom/iqoption/activity/IQActivity;", "()V", "active", "Lcom/iqoption/core/microservices/tradingengine/response/active/Active;", "binding", "Lcom/iqoption/databinding/FeedWebBinding;", "item", "Lcom/iqoption/core/microservices/feed/response/CommonFeedItem;", "getItem", "()Lcom/iqoption/core/microservices/feed/response/CommonFeedItem;", "item$delegate", "Lkotlin/Lazy;", "startUrl", "", "timerListener", "Lcom/iqoption/view/animation/GlobalTimer$TimerUpdateListener;", "clearWebView", "", "getClient", "Landroid/webkit/WebViewClient;", "initSuggest", "initWebView", "onBackPressed", "onCloseSuggestBySwipe", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "updateSubtitle", "instrumentType", "Lcom/iqoption/core/data/model/InstrumentType;", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: FeedWebViewActivity.kt */
public final class FeedWebViewActivity extends com.iqoption.activity.b {
    private static final String TAG = "com.iqoption.feed.FeedWebViewActivity";
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(FeedWebViewActivity.class), "item", "getItem()Lcom/iqoption/core/microservices/feed/response/CommonFeedItem;"))};
    public static final a clx = new a();
    private com.iqoption.core.microservices.tradingengine.response.active.a aiJ;
    private String clt;
    private kx clu;
    private final kotlin.d clv = g.f(new FeedWebViewActivity$item$2(this));
    private final com.iqoption.view.a.b.a clw = new h(this);

    @i(aXC = {1, 1, 11}, aXD = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fXT¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u0010*\u0004\u0018\u00010\u00070\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, aXE = {"Lcom/iqoption/feed/FeedWebViewActivity$Companion;", "", "()V", "ANIMATION_DELAY", "", "ANIMATION_DURATION", "EXTRA_URL", "", "EXTRA_WEB_BUTTON_ITEM", "EXTRA_WEB_CLICKED_BUTTON_ITEM", "FORCE_REQUEST_ORIENTATION", "RESULT_REQUEST_CODE", "", "SWIPE_THRESHOLD", "SWIPE_VELOCITY_THRESHOLD", "TAG", "kotlin.jvm.PlatformType", "start", "", "context", "Landroid/support/v4/app/FragmentActivity;", "fragment", "Lcom/iqoption/feed/SmartFeedFragment;", "url", "forceRequestOrientation", "", "item", "Lcom/iqoption/core/microservices/feed/response/CommonFeedItem;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: FeedWebViewActivity.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final void a(FragmentActivity fragmentActivity, b bVar, String str, boolean z, com.iqoption.core.microservices.feed.response.a aVar) {
            kotlin.jvm.internal.h.e(fragmentActivity, "context");
            kotlin.jvm.internal.h.e(bVar, "fragment");
            kotlin.jvm.internal.h.e(str, PlusShare.KEY_CALL_TO_ACTION_URL);
            kotlin.jvm.internal.h.e(aVar, "item");
            Intent intent = new Intent(fragmentActivity, FeedWebViewActivity.class);
            intent.putExtra("URL", str);
            intent.putExtra("EXTRA_WEB_BUTTON_ITEM", aVar);
            intent.putExtra("REQUEST_ORIENTATION", z);
            bVar.startActivityForResult(intent, 512);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0003H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, aXE = {"com/iqoption/feed/FeedWebViewActivity$getClient$1", "Landroid/webkit/WebViewClient;", "firstUrl", "", "firstUrlLoadingOnce", "", "shouldOverrideUrlLoading", "webView", "Landroid/webkit/WebView;", "url", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: FeedWebViewActivity.kt */
    public static final class b extends WebViewClient {
        private String cly;
        private boolean clz;
        final /* synthetic */ FeedWebViewActivity this$0;

        b(FeedWebViewActivity feedWebViewActivity) {
            this.this$0 = feedWebViewActivity;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            kotlin.jvm.internal.h.e(webView, "webView");
            kotlin.jvm.internal.h.e(str, PlusShare.KEY_CALL_TO_ACTION_URL);
            if (this.cly == null) {
                this.cly = str;
            } else if (kotlin.jvm.internal.h.E(str, this.cly)) {
                if (this.clz) {
                    webView.stopLoading();
                    this.this$0.finish();
                    return false;
                }
                this.clz = true;
            }
            webView.loadUrl(str);
            return true;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: FeedWebViewActivity.kt */
    static final class c implements OnClickListener {
        final /* synthetic */ FeedWebViewActivity this$0;

        c(FeedWebViewActivity feedWebViewActivity) {
            this.this$0 = feedWebViewActivity;
        }

        public final void onClick(View view) {
            FeedWebViewActivity feedWebViewActivity = this.this$0;
            Intent intent = new Intent();
            intent.putExtra("EXTRA_WEB_CLICKED_BUTTON_ITEM", this.this$0.afM());
            feedWebViewActivity.setResult(-1, intent);
            this.this$0.finish();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, aXE = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
    /* compiled from: FeedWebViewActivity.kt */
    static final class d implements OnTouchListener {
        final /* synthetic */ GestureDetectorCompat clA;

        d(GestureDetectorCompat gestureDetectorCompat) {
            this.clA = gestureDetectorCompat;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            return this.clA.onTouchEvent(motionEvent);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J,\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\f"}, aXE = {"com/iqoption/feed/FeedWebViewActivity$initSuggest$gestureDetector$1", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "onDown", "", "e", "Landroid/view/MotionEvent;", "onFling", "e1", "e2", "velocityX", "", "velocityY", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: FeedWebViewActivity.kt */
    public static final class e extends SimpleOnGestureListener {
        final /* synthetic */ FeedWebViewActivity this$0;

        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        e(FeedWebViewActivity feedWebViewActivity) {
            this.this$0 = feedWebViewActivity;
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            float y;
            f = 0.0f;
            if (motionEvent != null) {
                try {
                    y = motionEvent.getY();
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            }
            y = 0.0f;
            if (motionEvent2 != null) {
                f = motionEvent2.getY();
            }
            f -= y;
            if (Math.abs(f) <= ((float) 50) || Math.abs(f2) <= ((float) 100) || f <= ((float) null)) {
                return false;
            }
            this.this$0.afR();
            return true;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0003H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, aXE = {"com/iqoption/feed/FeedWebViewActivity$initWebView$1", "Landroid/webkit/WebChromeClient;", "customCallback", "Landroid/webkit/WebChromeClient$CustomViewCallback;", "customView", "Landroid/view/View;", "onHideCustomView", "", "onShowCustomView", "view", "callback", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: FeedWebViewActivity.kt */
    public static final class f extends WebChromeClient {
        private CustomViewCallback clB;
        private View clC;
        final /* synthetic */ FeedWebViewActivity this$0;

        f(FeedWebViewActivity feedWebViewActivity) {
            this.this$0 = feedWebViewActivity;
        }

        public void onHideCustomView() {
            if (this.clC != null) {
                FeedWebViewActivity.a(this.this$0).bvS.removeView(this.clC);
                View view = this.clC;
                if (view == null) {
                    kotlin.jvm.internal.h.aXZ();
                }
                view.setVisibility(8);
                CustomViewCallback customViewCallback = this.clB;
                if (customViewCallback == null) {
                    kotlin.jvm.internal.h.aXZ();
                }
                customViewCallback.onCustomViewHidden();
                this.clB = (CustomViewCallback) null;
                this.clC = (View) null;
            }
        }

        public void onShowCustomView(View view, CustomViewCallback customViewCallback) {
            kotlin.jvm.internal.h.e(view, Promotion.ACTION_VIEW);
            kotlin.jvm.internal.h.e(customViewCallback, "callback");
            if (this.clC == null) {
                customViewCallback.onCustomViewHidden();
                return;
            }
            this.clC = view;
            FeedWebViewActivity.a(this.this$0).bvS.addView(view);
            this.clB = customViewCallback;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0006\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\b\u001a\u00020\tH\n¢\u0006\u0002\b\n"}, aXE = {"<anonymous>", "", "url", "", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "<anonymous parameter 2>", "<anonymous parameter 3>", "<anonymous parameter 4>", "", "onDownloadStart"})
    /* compiled from: FeedWebViewActivity.kt */
    static final class g implements DownloadListener {
        final /* synthetic */ FeedWebViewActivity this$0;

        g(FeedWebViewActivity feedWebViewActivity) {
            this.this$0 = feedWebViewActivity;
        }

        public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            this.this$0.startActivity(intent);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "", "onTick"})
    /* compiled from: FeedWebViewActivity.kt */
    static final class h implements com.iqoption.view.a.b.a {
        final /* synthetic */ FeedWebViewActivity this$0;

        h(FeedWebViewActivity feedWebViewActivity) {
            this.this$0 = feedWebViewActivity;
        }

        public final void onTick(long j) {
            com.iqoption.core.microservices.tradingengine.response.active.a d = this.this$0.aiJ;
            if (d != null) {
                FeedWebViewActivity feedWebViewActivity = this.this$0;
                com.iqoption.core.microservices.feed.response.c VT = this.this$0.afM().VT();
                if (VT == null) {
                    kotlin.jvm.internal.h.aXZ();
                }
                feedWebViewActivity.a(VT.getInstrumentType(), d);
            }
        }
    }

    private final com.iqoption.core.microservices.feed.response.a afM() {
        kotlin.d dVar = this.clv;
        j jVar = apP[0];
        return (com.iqoption.core.microservices.feed.response.a) dVar.getValue();
    }

    public static final /* synthetic */ kx a(FeedWebViewActivity feedWebViewActivity) {
        kx kxVar = feedWebViewActivity.clu;
        if (kxVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        return kxVar;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        WebSocketHandler.aDm().bE(TAG);
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.feed_web, null, false);
        kotlin.jvm.internal.h.d(inflate, "DataBindingUtil.inflate(…ut.feed_web, null, false)");
        this.clu = (kx) inflate;
        kx kxVar = this.clu;
        if (kxVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        setContentView(kxVar.getRoot());
        String stringExtra = getIntent().getStringExtra("URL");
        kotlin.jvm.internal.h.d(stringExtra, "intent.getStringExtra(EXTRA_URL)");
        this.clt = stringExtra;
        afP();
        afN();
        afQ();
        kxVar = this.clu;
        if (kxVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        WebView webView = kxVar.EM;
        String str = this.clt;
        if (str == null) {
            kotlin.jvm.internal.h.lS("startUrl");
        }
        webView.loadUrl(str);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void afN() {
        kx kxVar = this.clu;
        if (kxVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        WebView webView = kxVar.EM;
        kotlin.jvm.internal.h.d(webView, "binding.webView");
        webView.setWebViewClient(afO());
        kxVar = this.clu;
        if (kxVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        webView = kxVar.EM;
        kotlin.jvm.internal.h.d(webView, "binding.webView");
        webView.setWebChromeClient(new f(this));
        kxVar = this.clu;
        if (kxVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        kxVar.EM.setDownloadListener(new g(this));
        kxVar = this.clu;
        if (kxVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        webView = kxVar.EM;
        kotlin.jvm.internal.h.d(webView, "binding.webView");
        WebSettings settings = webView.getSettings();
        kotlin.jvm.internal.h.d(settings, "settings");
        settings.setDomStorageEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setJavaScriptEnabled(true);
        settings.setRenderPriority(RenderPriority.HIGH);
        settings.setCacheMode(2);
    }

    private final WebViewClient afO() {
        return new b(this);
    }

    private final void afP() {
        kx kxVar = this.clu;
        if (kxVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        WebView webView = kxVar.EM;
        webView.clearCache(true);
        webView.clearFormData();
        webView.clearHistory();
        webView.clearMatches();
        webView.clearSslPreferences();
    }

    private final void afQ() {
        com.iqoption.core.microservices.feed.response.c VT = afM().VT();
        if (VT != null) {
            InstrumentType instrumentType = VT.getInstrumentType();
            com.iqoption.core.microservices.tradingengine.response.active.a a = com.iqoption.app.helpers.a.FI().a(Integer.valueOf(VT.VU()), instrumentType);
            if (a != null) {
                int i;
                this.aiJ = a;
                com.iqoption.app.helpers.a.FI().k(instrumentType);
                y.a(true, instrumentType);
                a = this.aiJ;
                if (a == null) {
                    kotlin.jvm.internal.h.aXZ();
                }
                a(instrumentType, a);
                com.iqoption.view.a.b.aIK().a(this.clw);
                kx kxVar = this.clu;
                if (kxVar == null) {
                    kotlin.jvm.internal.h.lS("binding");
                }
                TextView textView = kxVar.bvW;
                kotlin.jvm.internal.h.d(textView, "binding.suggestTitle");
                a = this.aiJ;
                if (a == null) {
                    kotlin.jvm.internal.h.aXZ();
                }
                textView.setText(com.iqoption.util.e.a.s(a));
                Context context = this;
                Picasso with = Picasso.with(context);
                com.iqoption.core.microservices.tradingengine.response.active.a aVar = this.aiJ;
                if (aVar == null) {
                    kotlin.jvm.internal.h.aXZ();
                }
                RequestCreator load = with.load(aVar.getImage());
                kx kxVar2 = this.clu;
                if (kxVar2 == null) {
                    kotlin.jvm.internal.h.lS("binding");
                }
                load.into(kxVar2.bvU);
                switch (VT.getAction()) {
                    case 1:
                        i = R.string.buy;
                        break;
                    case 2:
                        i = R.string.sell;
                        break;
                    default:
                        i = R.string.trade;
                        break;
                }
                kx kxVar3 = this.clu;
                if (kxVar3 == null) {
                    kotlin.jvm.internal.h.lS("binding");
                }
                TextView textView2 = kxVar3.bvX;
                textView2.setText(i);
                textView2.setOnClickListener(new c(this));
                GestureDetectorCompat gestureDetectorCompat = new GestureDetectorCompat(context, new e(this));
                kxVar = this.clu;
                if (kxVar == null) {
                    kotlin.jvm.internal.h.lS("binding");
                }
                kxVar.bvT.setOnTouchListener(new d(gestureDetectorCompat));
                kx kxVar4 = this.clu;
                if (kxVar4 == null) {
                    kotlin.jvm.internal.h.lS("binding");
                }
                ConstraintLayout constraintLayout = kxVar4.bvT;
                kotlin.jvm.internal.h.d(constraintLayout, "binding.suggestContainer");
                constraintLayout.setVisibility(0);
                kxVar4 = this.clu;
                if (kxVar4 == null) {
                    kotlin.jvm.internal.h.lS("binding");
                }
                kxVar4.bvT.animate().setStartDelay(2000).translationY(0.0f).setDuration(300).setInterpolator(new OvershootInterpolator()).start();
            }
        }
    }

    private final void afR() {
        kx kxVar = this.clu;
        if (kxVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        kxVar.bvT.animate().setStartDelay(0).translationY((float) getResources().getDimensionPixelOffset(R.dimen.dp64)).setDuration(300).setInterpolator(new AccelerateInterpolator()).start();
    }

    private final void a(InstrumentType instrumentType, com.iqoption.core.microservices.tradingengine.response.active.a aVar) {
        com.iqoption.core.microservices.f.a.a.a a = com.iqoption.app.helpers.a.FI().a(aVar.getActiveId(), instrumentType);
        if (a != null) {
            com.iqoption.core.microservices.f.a.a.a.c WZ = a.WZ();
            if (WZ != null && WZ.isValid()) {
                WZ = a.WW();
                if (WZ != null && WZ.isValid()) {
                    WZ = a.WZ();
                    Double d = null;
                    Double value = WZ != null ? WZ.getValue() : null;
                    if (value == null) {
                        kotlin.jvm.internal.h.aXZ();
                    }
                    double doubleValue = value.doubleValue();
                    com.iqoption.core.microservices.f.a.a.a.c WW = a.WW();
                    if (WW != null) {
                        d = WW.getValue();
                    }
                    if (d == null) {
                        kotlin.jvm.internal.h.aXZ();
                    }
                    String G = l.G(doubleValue + (d.doubleValue() / ((double) 2)));
                    kx kxVar = this.clu;
                    if (kxVar == null) {
                        kotlin.jvm.internal.h.lS("binding");
                    }
                    TextView textView = kxVar.bvV;
                    kotlin.jvm.internal.h.d(textView, "binding.suggestSubtitle");
                    m mVar = m.euz;
                    Locale locale = Locale.US;
                    kotlin.jvm.internal.h.d(locale, "Locale.US");
                    Object[] objArr = new Object[]{com.iqoption.util.e.a.E(aVar), G};
                    String format = String.format(locale, "1%s = %s", Arrays.copyOf(objArr, objArr.length));
                    kotlin.jvm.internal.h.d(format, "java.lang.String.format(locale, format, *args)");
                    textView.setText(format);
                    return;
                }
            }
        }
        kx kxVar2 = this.clu;
        if (kxVar2 == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        TextView textView2 = kxVar2.bvV;
        kotlin.jvm.internal.h.d(textView2, "binding.suggestSubtitle");
        textView2.setText(com.iqoption.util.e.a.E(aVar));
    }

    protected void onDestroy() {
        WebSocketHandler.aDm().m(TAG, 0);
        com.iqoption.view.a.b.aIK().b(this.clw);
        com.iqoption.core.microservices.feed.response.c VT = afM().VT();
        if (VT != null) {
            InstrumentType instrumentType = VT.getInstrumentType();
            if (instrumentType != null) {
                y.a(false, instrumentType);
            }
        }
        Intent intent = getIntent();
        kotlin.jvm.internal.h.d(intent, "intent");
        Bundle extras = intent.getExtras();
        if (extras != null && extras.getBoolean("REQUEST_ORIENTATION", false)) {
            setRequestedOrientation(6);
        }
        super.onDestroy();
    }

    public void onBackPressed() {
        if (zN()) {
            Context context = this;
            kx kxVar = this.clu;
            if (kxVar == null) {
                kotlin.jvm.internal.h.lS("binding");
            }
            am.a(context, kxVar.EM);
            return;
        }
        kx kxVar2 = this.clu;
        if (kxVar2 == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        if (kxVar2.EM.canGoBack()) {
            kxVar2 = this.clu;
            if (kxVar2 == null) {
                kotlin.jvm.internal.h.lS("binding");
            }
            WebView webView = kxVar2.EM;
            kotlin.jvm.internal.h.d(webView, "binding.webView");
            String url = webView.getUrl();
            kotlin.jvm.internal.h.d(url, "binding.webView.url");
            String str = this.clt;
            if (str == null) {
                kotlin.jvm.internal.h.lS("startUrl");
            }
            if (!u.a(url, str, false, 2, null)) {
                kxVar2 = this.clu;
                if (kxVar2 == null) {
                    kotlin.jvm.internal.h.lS("binding");
                }
                webView = kxVar2.EM;
                str = this.clt;
                if (str == null) {
                    kotlin.jvm.internal.h.lS("startUrl");
                }
                webView.loadUrl(str);
            }
        }
        super.onBackPressed();
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "smart-feed_news-back").build());
    }
}
