package com.iqoption.dialog;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.iqoption.app.IQApp;
import com.iqoption.fragment.base.f;
import com.iqoption.mobbtech.connect.RequestManager;
import com.iqoption.mobbtech.connect.request.a.a.a;
import com.iqoption.mobbtech.connect.response.g;
import com.iqoption.x.R;
import java.util.HashMap;

/* compiled from: TermsDialog */
public class s extends f {
    private WebView aOY;
    private ProgressBar bly;
    private TextView cfD;
    private String cfE;

    public static s hm(String str) {
        s sVar = new s();
        Bundle bundle = new Bundle();
        bundle.putString("termsUrl", str);
        sVar.setArguments(bundle);
        return sVar;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.web_fragment, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.cfE = getArguments() == null ? "" : getArguments().getString("termsUrl", "");
        Y(view);
        zH();
        aew();
    }

    private void Y(View view) {
        this.aOY = (WebView) view.findViewById(R.id.fragmentWeb);
        this.aOY.setLayerType(1, null);
        this.aOY.setWebViewClient(new WebViewClient() {
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            }

            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return false;
            }

            public void onPageFinished(WebView webView, String str) {
                s.this.YL();
            }

            public void onReceivedError(WebView webView, int i, String str, String str2) {
                s.this.YL();
            }
        });
        this.cfD = (TextView) view.findViewById(R.id.title);
        this.bly = (ProgressBar) view.findViewById(R.id.toolbarProgress);
        view.findViewById(R.id.backButton).setOnClickListener(new t(this));
    }

    final /* synthetic */ void Z(View view) {
        getFragmentManager().popBackStack();
    }

    public void zH() {
        this.bly.setVisibility(0);
    }

    public void YL() {
        this.bly.setVisibility(8);
    }

    private void aew() {
        HashMap hashMap = new HashMap();
        hashMap.put("key", this.cfE);
        hashMap.put("lang", com.iqoption.core.f.getLocale());
        String clusterApi = IQApp.Dl().getClusterApi();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(clusterApi);
        stringBuilder.append("api/article/get");
        a.a(RequestManager.b(stringBuilder.toString(), hashMap, getContext()), new com.iqoption.mobbtech.connect.a.a() {
            public void a(g gVar) {
            }

            /* JADX WARNING: Removed duplicated region for block: B:2:0x003b A:{RETURN, Splitter: B:0:0x0000, ExcHandler: org.json.JSONException (unused org.json.JSONException)} */
            /* JADX WARNING: Missing block: B:2:0x003b, code:
            return;
     */
            /* renamed from: a */
            public void onSuccess(com.iqoption.mobbtech.connect.response.h r4) {
                /*
                r3 = this;
                r4 = r4.auV();	 Catch:{ JSONException -> 0x003b, JSONException -> 0x003b }
                r0 = "result";
                r4 = r4.getJSONObject(r0);	 Catch:{ JSONException -> 0x003b, JSONException -> 0x003b }
                r0 = "content";
                r4 = r4.getJSONObject(r0);	 Catch:{ JSONException -> 0x003b, JSONException -> 0x003b }
                r0 = com.iqoption.core.f.getLocale();	 Catch:{ JSONException -> 0x003b, JSONException -> 0x003b }
                r4 = r4.getJSONObject(r0);	 Catch:{ JSONException -> 0x003b, JSONException -> 0x003b }
                r0 = com.iqoption.dialog.s.this;	 Catch:{ JSONException -> 0x003b, JSONException -> 0x003b }
                r0 = r0.cfD;	 Catch:{ JSONException -> 0x003b, JSONException -> 0x003b }
                r1 = "header";
                r1 = r4.getString(r1);	 Catch:{ JSONException -> 0x003b, JSONException -> 0x003b }
                r0.setText(r1);	 Catch:{ JSONException -> 0x003b, JSONException -> 0x003b }
                r0 = com.iqoption.dialog.s.this;	 Catch:{ JSONException -> 0x003b, JSONException -> 0x003b }
                r0 = r0.aOY;	 Catch:{ JSONException -> 0x003b, JSONException -> 0x003b }
                r1 = "text";
                r4 = r4.getString(r1);	 Catch:{ JSONException -> 0x003b, JSONException -> 0x003b }
                r1 = "text/html; charset=utf-8";
                r2 = 0;
                r0.loadData(r4, r1, r2);	 Catch:{ JSONException -> 0x003b, JSONException -> 0x003b }
            L_0x003b:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.iqoption.dialog.s.2.a(com.iqoption.mobbtech.connect.response.h):void");
            }
        }, "api/article/get");
    }
}
