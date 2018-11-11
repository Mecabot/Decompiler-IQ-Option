package com.facebook.internal;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import org.json.JSONObject;

/* compiled from: FacebookWebFallbackDialog */
public class j extends y {
    private static final String TAG = "com.facebook.internal.j";
    private boolean Cw;

    public static j c(Context context, String str, String str2) {
        y.al(context);
        return new j(context, str, str2);
    }

    private j(Context context, String str, String str2) {
        super(context, str);
        bR(str2);
    }

    protected Bundle bC(String str) {
        Bundle bO = w.bO(Uri.parse(str).getQuery());
        String string = bO.getString("bridge_args");
        bO.remove("bridge_args");
        if (!w.bc(string)) {
            try {
                bO.putBundle("com.facebook.platform.protocol.BRIDGE_ARGS", d.g(new JSONObject(string)));
            } catch (Throwable e) {
                w.a(TAG, "Unable to parse bridge_args JSON", e);
            }
        }
        string = bO.getString("method_results");
        bO.remove("method_results");
        if (!w.bc(string)) {
            if (w.bc(string)) {
                string = "{}";
            }
            try {
                bO.putBundle("com.facebook.platform.protocol.RESULT_ARGS", d.g(new JSONObject(string)));
            } catch (Throwable e2) {
                w.a(TAG, "Unable to parse bridge_args JSON", e2);
            }
        }
        bO.remove("version");
        bO.putInt("com.facebook.platform.protocol.PROTOCOL_VERSION", s.mj());
        return bO;
    }

    public void cancel() {
        WebView webView = getWebView();
        if (!mH() || mG() || webView == null || !webView.isShown()) {
            super.a();
        } else if (!this.Cw) {
            this.Cw = true;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("javascript:");
            stringBuilder.append("(function() {  var event = document.createEvent('Event');  event.initEvent('fbPlatformDialogMustClose',true,true);  document.dispatchEvent(event);})();");
            webView.loadUrl(stringBuilder.toString());
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                public void run() {
                    super.a();
                }
            }, 1500);
        }
    }
}
