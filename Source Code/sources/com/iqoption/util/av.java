package com.iqoption.util;

import android.text.TextUtils;
import android.webkit.CookieManager;
import com.iqoption.core.f;
import com.iqoption.mobbtech.connect.RequestManager;
import okhttp3.HttpUrl;

/* compiled from: NetworkUtil */
public class av {
    public static void a(CookieManager cookieManager, String str) {
        if (!TextUtils.isEmpty(str)) {
            str = HttpUrl.parse(str).host();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("lang=");
            stringBuilder.append(f.getLocale());
            cookieManager.setCookie(str, stringBuilder.toString());
            cookieManager.setCookie(str, "platform=17");
            stringBuilder = new StringBuilder();
            stringBuilder.append("ssid=");
            stringBuilder.append(RequestManager.atO().atS());
            cookieManager.setCookie(str, stringBuilder.toString());
            if (!TextUtils.isEmpty("")) {
                cookieManager.setCookie(str, "ws_route=");
            }
        }
    }

    public static String aB(String str, String str2) {
        StringBuilder stringBuilder;
        if (str.endsWith("/")) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append('/');
        }
        stringBuilder.append(str2);
        return stringBuilder.toString();
    }
}
