package com.facebook.internal;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.AsyncTask;
import android.os.AsyncTask.Status;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.facebook.FacebookDialogException;
import com.facebook.FacebookException;
import com.facebook.FacebookGraphResponseException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookServiceException;
import com.facebook.common.a.f;
import com.facebook.common.a.g;
import com.facebook.h;
import com.facebook.l;
import com.facebook.share.internal.i;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: WebDialog */
public class y extends Dialog {
    private static final int EJ = g.com_facebook_activity_theme;
    private static volatile int EZ;
    private String EK;
    private c EL;
    private WebView EM;
    private ProgressDialog EN;
    private ImageView EO;
    private FrameLayout EP;
    private d EV;
    private boolean EW;
    private boolean EX;
    private boolean EY;
    private LayoutParams Fa;
    private String url;

    /* compiled from: WebDialog */
    public static class a {
        private c Fc;
        private String action;
        private String applicationId;
        private Context context;
        private int theme;
        private com.facebook.a xX;
        private Bundle ye;

        public a(Context context, String str, Bundle bundle) {
            this.xX = com.facebook.a.ik();
            if (!com.facebook.a.il()) {
                String ac = w.ac(context);
                if (ac != null) {
                    this.applicationId = ac;
                } else {
                    throw new FacebookException("Attempted to create a builder without a valid access token or a valid default Application ID.");
                }
            }
            a(context, str, bundle);
        }

        public a(Context context, String str, String str2, Bundle bundle) {
            if (str == null) {
                str = w.ac(context);
            }
            x.F(str, "applicationId");
            this.applicationId = str;
            a(context, str2, bundle);
        }

        public a b(c cVar) {
            this.Fc = cVar;
            return this;
        }

        public y mJ() {
            if (this.xX != null) {
                this.ye.putString("app_id", this.xX.it());
                this.ye.putString("access_token", this.xX.getToken());
            } else {
                this.ye.putString("app_id", this.applicationId);
            }
            return y.a(this.context, this.action, this.ye, this.theme, this.Fc);
        }

        public String it() {
            return this.applicationId;
        }

        public Context getContext() {
            return this.context;
        }

        public int getTheme() {
            return this.theme;
        }

        public Bundle jn() {
            return this.ye;
        }

        public c mK() {
            return this.Fc;
        }

        private void a(Context context, String str, Bundle bundle) {
            this.context = context;
            this.action = str;
            if (bundle != null) {
                this.ye = bundle;
            } else {
                this.ye = new Bundle();
            }
        }
    }

    /* compiled from: WebDialog */
    private class b extends WebViewClient {
        private b() {
        }

        /* synthetic */ b(y yVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Redirect URL: ");
            stringBuilder.append(str);
            w.E("FacebookSDK.WebDialog", stringBuilder.toString());
            if (str.startsWith(y.this.EK)) {
                Bundle bC = y.this.bC(str);
                str = bC.getString("error");
                if (str == null) {
                    str = bC.getString("error_type");
                }
                String string = bC.getString("error_msg");
                if (string == null) {
                    string = bC.getString("error_message");
                }
                if (string == null) {
                    string = bC.getString("error_description");
                }
                String string2 = bC.getString("error_code");
                if (!w.bc(string2)) {
                    int parseInt;
                    try {
                        parseInt = Integer.parseInt(string2);
                    } catch (NumberFormatException unused) {
                        parseInt = -1;
                    }
                    if (w.bc(str) && w.bc(string) && parseInt == -1) {
                        y.this.m(bC);
                    } else if (str != null && (str.equals("access_denied") || str.equals("OAuthAccessDeniedException"))) {
                        y.this.cancel();
                    } else if (parseInt == 4201) {
                        y.this.cancel();
                    } else {
                        y.this.d(new FacebookServiceException(new FacebookRequestError(parseInt, str, string), string));
                    }
                    return true;
                }
            } else if (str.startsWith("fbconnect://cancel")) {
                y.this.cancel();
                return true;
            } else if (str.contains("touch")) {
                return false;
            } else {
                try {
                    y.this.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                    return true;
                } catch (ActivityNotFoundException unused2) {
                    return false;
                }
            }
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            y.this.d(new FacebookDialogException(str, i, str2));
        }

        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            sslErrorHandler.cancel();
            y.this.d(new FacebookDialogException(null, -11, null));
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Webview loading URL: ");
            stringBuilder.append(str);
            w.E("FacebookSDK.WebDialog", stringBuilder.toString());
            super.onPageStarted(webView, str, bitmap);
            if (!y.this.EX) {
                y.this.EN.show();
            }
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (!y.this.EX) {
                y.this.EN.dismiss();
            }
            y.this.EP.setBackgroundColor(0);
            y.this.EM.setVisibility(0);
            y.this.EO.setVisibility(0);
            y.this.EY = true;
        }
    }

    /* compiled from: WebDialog */
    public interface c {
        void b(Bundle bundle, FacebookException facebookException);
    }

    /* compiled from: WebDialog */
    private class d extends AsyncTask<Void, Void, String[]> {
        private Exception[] Fd;
        private String action;
        private Bundle ye;

        d(String str, Bundle bundle) {
            this.action = str;
            this.ye = bundle;
        }

        /* renamed from: b */
        protected String[] doInBackground(Void... voidArr) {
            String[] stringArray = this.ye.getStringArray("media");
            final String[] strArr = new String[stringArray.length];
            this.Fd = new Exception[stringArray.length];
            final CountDownLatch countDownLatch = new CountDownLatch(stringArray.length);
            ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
            com.facebook.a ik = com.facebook.a.ik();
            int i = 0;
            while (i < stringArray.length) {
                Iterator it;
                try {
                    if (isCancelled()) {
                        it = concurrentLinkedQueue.iterator();
                        while (it.hasNext()) {
                            ((AsyncTask) it.next()).cancel(true);
                        }
                        return null;
                    }
                    Uri parse = Uri.parse(stringArray[i]);
                    if (w.c(parse)) {
                        strArr[i] = parse.toString();
                        countDownLatch.countDown();
                    } else {
                        concurrentLinkedQueue.add(i.a(ik, parse, new com.facebook.i.b() {
                            public void a(l lVar) {
                                try {
                                    FacebookRequestError jJ = lVar.jJ();
                                    if (jJ != null) {
                                        String errorMessage = jJ.getErrorMessage();
                                        if (errorMessage == null) {
                                            errorMessage = "Error staging photo.";
                                        }
                                        throw new FacebookGraphResponseException(lVar, errorMessage);
                                    }
                                    JSONObject jK = lVar.jK();
                                    if (jK == null) {
                                        throw new FacebookException("Error staging photo.");
                                    }
                                    String optString = jK.optString("uri");
                                    if (optString == null) {
                                        throw new FacebookException("Error staging photo.");
                                    }
                                    strArr[i] = optString;
                                    countDownLatch.countDown();
                                } catch (Exception e) {
                                    d.this.Fd[i] = e;
                                }
                            }
                        }).jr());
                    }
                    i++;
                } catch (Exception unused) {
                    it = concurrentLinkedQueue.iterator();
                    while (it.hasNext()) {
                        ((AsyncTask) it.next()).cancel(true);
                    }
                    return null;
                }
            }
            countDownLatch.await();
            return strArr;
        }

        /* renamed from: b */
        protected void onPostExecute(String[] strArr) {
            y.this.EN.dismiss();
            for (Throwable th : this.Fd) {
                if (th != null) {
                    y.this.d(th);
                    return;
                }
            }
            if (strArr == null) {
                y.this.d(new FacebookException("Failed to stage photos for web dialog"));
                return;
            }
            Collection asList = Arrays.asList(strArr);
            if (asList.contains(null)) {
                y.this.d(new FacebookException("Failed to stage photos for web dialog"));
                return;
            }
            w.b(this.ye, "media", new JSONArray(asList));
            String mq = v.mq();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(h.iZ());
            stringBuilder.append("/");
            stringBuilder.append("dialog/");
            stringBuilder.append(this.action);
            y.this.url = w.b(mq, stringBuilder.toString(), this.ye).toString();
            y.this.S((y.this.EO.getDrawable().getIntrinsicWidth() / 2) + 1);
        }
    }

    private int a(int i, float f, int i2, int i3) {
        int i4 = (int) (((float) i) / f);
        double d = 0.5d;
        if (i4 <= i2) {
            d = 1.0d;
        } else if (i4 < i3) {
            d = 0.5d + ((((double) (i3 - i4)) / ((double) (i3 - i2))) * 0.5d);
        }
        return (int) (((double) i) * d);
    }

    /* JADX WARNING: Missing block: B:11:0x0028, code:
            return;
     */
    protected static void al(android.content.Context r2) {
        /*
        if (r2 != 0) goto L_0x0003;
    L_0x0002:
        return;
    L_0x0003:
        r0 = r2.getPackageManager();	 Catch:{ NameNotFoundException -> 0x0029 }
        r2 = r2.getPackageName();	 Catch:{ NameNotFoundException -> 0x0029 }
        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
        r2 = r0.getApplicationInfo(r2, r1);	 Catch:{ NameNotFoundException -> 0x0029 }
        if (r2 == 0) goto L_0x0028;
    L_0x0013:
        r0 = r2.metaData;
        if (r0 != 0) goto L_0x0018;
    L_0x0017:
        goto L_0x0028;
    L_0x0018:
        r0 = EZ;
        if (r0 != 0) goto L_0x0027;
    L_0x001c:
        r2 = r2.metaData;
        r0 = "com.facebook.sdk.WebDialogTheme";
        r2 = r2.getInt(r0);
        R(r2);
    L_0x0027:
        return;
    L_0x0028:
        return;
    L_0x0029:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.y.al(android.content.Context):void");
    }

    public static y a(Context context, String str, Bundle bundle, int i, c cVar) {
        al(context);
        return new y(context, str, bundle, i, cVar);
    }

    public static int mF() {
        x.mC();
        return EZ;
    }

    public static void R(int i) {
        if (i == 0) {
            i = EJ;
        }
        EZ = i;
    }

    protected y(Context context, String str) {
        this(context, str, mF());
    }

    private y(Context context, String str, int i) {
        if (i == 0) {
            i = mF();
        }
        super(context, i);
        this.EK = "fbconnect://success";
        this.EW = false;
        this.EX = false;
        this.EY = false;
        this.url = str;
    }

    private y(Context context, String str, Bundle bundle, int i, c cVar) {
        if (i == 0) {
            i = mF();
        }
        super(context, i);
        this.EK = "fbconnect://success";
        this.EW = false;
        this.EX = false;
        this.EY = false;
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.EK = w.aj(context) ? "fbconnect://chrome_os_success" : "fbconnect://success";
        bundle.putString("redirect_uri", this.EK);
        bundle.putString("display", "touch");
        bundle.putString("client_id", h.it());
        bundle.putString("sdk", String.format(Locale.ROOT, "android-%s", new Object[]{h.ja()}));
        this.EL = cVar;
        if (str.equals(com.google.firebase.analytics.FirebaseAnalytics.a.SHARE) && bundle.containsKey("media")) {
            this.EV = new d(str, bundle);
            return;
        }
        String mq = v.mq();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(h.iZ());
        stringBuilder.append("/");
        stringBuilder.append("dialog/");
        stringBuilder.append(str);
        this.url = w.b(mq, stringBuilder.toString(), bundle).toString();
    }

    public void a(c cVar) {
        this.EL = cVar;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            cancel();
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void dismiss() {
        if (this.EM != null) {
            this.EM.stopLoading();
        }
        if (!(this.EX || this.EN == null || !this.EN.isShowing())) {
            this.EN.dismiss();
        }
        super.dismiss();
    }

    protected void onStart() {
        super.onStart();
        if (this.EV == null || this.EV.getStatus() != Status.PENDING) {
            resize();
            return;
        }
        this.EV.execute(new Void[0]);
        this.EN.show();
    }

    protected void onStop() {
        if (this.EV != null) {
            this.EV.cancel(true);
            this.EN.dismiss();
        }
        super.onStop();
    }

    public void onDetachedFromWindow() {
        this.EX = true;
        super.onDetachedFromWindow();
    }

    public void onAttachedToWindow() {
        this.EX = false;
        if (w.ah(getContext()) && this.Fa != null && this.Fa.token == null) {
            this.Fa.token = getOwnerActivity().getWindow().getAttributes().token;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Set token on onAttachedToWindow(): ");
            stringBuilder.append(this.Fa.token);
            w.E("FacebookSDK.WebDialog", stringBuilder.toString());
        }
        super.onAttachedToWindow();
    }

    public void onWindowAttributesChanged(LayoutParams layoutParams) {
        if (layoutParams.token == null) {
            this.Fa = layoutParams;
        }
        super.onWindowAttributesChanged(layoutParams);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.EN = new ProgressDialog(getContext());
        this.EN.requestWindowFeature(1);
        this.EN.setMessage(getContext().getString(f.com_facebook_loading));
        this.EN.setCanceledOnTouchOutside(false);
        this.EN.setOnCancelListener(new OnCancelListener() {
            public void onCancel(DialogInterface dialogInterface) {
                y.this.cancel();
            }
        });
        requestWindowFeature(1);
        this.EP = new FrameLayout(getContext());
        resize();
        getWindow().setGravity(17);
        getWindow().setSoftInputMode(16);
        mI();
        if (this.url != null) {
            S((this.EO.getDrawable().getIntrinsicWidth() / 2) + 1);
        }
        this.EP.addView(this.EO, new ViewGroup.LayoutParams(-2, -2));
        setContentView(this.EP);
    }

    protected void bR(String str) {
        this.EK = str;
    }

    protected Bundle bC(String str) {
        Uri parse = Uri.parse(str);
        Bundle bO = w.bO(parse.getQuery());
        bO.putAll(w.bO(parse.getFragment()));
        return bO;
    }

    protected boolean mG() {
        return this.EW;
    }

    protected boolean mH() {
        return this.EY;
    }

    protected WebView getWebView() {
        return this.EM;
    }

    public void resize() {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        getWindow().setLayout(Math.min(a(displayMetrics.widthPixels < displayMetrics.heightPixels ? displayMetrics.widthPixels : displayMetrics.heightPixels, displayMetrics.density, 480, 800), displayMetrics.widthPixels), Math.min(a(displayMetrics.widthPixels < displayMetrics.heightPixels ? displayMetrics.heightPixels : displayMetrics.widthPixels, displayMetrics.density, 800, 1280), displayMetrics.heightPixels));
    }

    protected void m(Bundle bundle) {
        if (this.EL != null && !this.EW) {
            this.EW = true;
            this.EL.b(bundle, null);
            dismiss();
        }
    }

    protected void d(Throwable th) {
        if (this.EL != null && !this.EW) {
            FacebookException facebookException;
            this.EW = true;
            if (th instanceof FacebookException) {
                facebookException = (FacebookException) th;
            } else {
                facebookException = new FacebookException(th);
            }
            this.EL.b(null, facebookException);
            dismiss();
        }
    }

    public void cancel() {
        if (this.EL != null && !this.EW) {
            d(new FacebookOperationCanceledException());
        }
    }

    private void mI() {
        this.EO = new ImageView(getContext());
        this.EO.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                y.this.cancel();
            }
        });
        this.EO.setImageDrawable(getContext().getResources().getDrawable(com.facebook.common.a.c.com_facebook_close));
        this.EO.setVisibility(4);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void S(int i) {
        View linearLayout = new LinearLayout(getContext());
        this.EM = new WebView(getContext()) {
            public void onWindowFocusChanged(boolean z) {
                try {
                    super.onWindowFocusChanged(z);
                } catch (NullPointerException unused) {
                }
            }
        };
        this.EM.setVerticalScrollBarEnabled(false);
        this.EM.setHorizontalScrollBarEnabled(false);
        this.EM.setWebViewClient(new b(this, null));
        this.EM.getSettings().setJavaScriptEnabled(true);
        this.EM.loadUrl(this.url);
        this.EM.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.EM.setVisibility(4);
        this.EM.getSettings().setSavePassword(false);
        this.EM.getSettings().setSaveFormData(false);
        this.EM.setFocusable(true);
        this.EM.setFocusableInTouchMode(true);
        this.EM.setOnTouchListener(new OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (!view.hasFocus()) {
                    view.requestFocus();
                }
                return false;
            }
        });
        linearLayout.setPadding(i, i, i, i);
        linearLayout.addView(this.EM);
        linearLayout.setBackgroundColor(-872415232);
        this.EP.addView(linearLayout);
    }
}
