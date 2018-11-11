package com.appsflyer;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONObject;

final class ac extends p {
    private String pr;
    private a rf;

    interface a {
        void aj(String str);

        void h(Map<String, String> map);
    }

    ac(Uri uri, h hVar) {
        super(hVar);
        if (!TextUtils.isEmpty(uri.getHost()) && !TextUtils.isEmpty(uri.getPath())) {
            String[] split = uri.getPath().split("/");
            if (uri.getHost().contains("onelink.me") && split.length == 3) {
                this.po = split[1];
                this.pr = split[2];
            }
        }
    }

    final void a(@NonNull a aVar) {
        this.rf = aVar;
    }

    final boolean fZ() {
        return (TextUtils.isEmpty(this.po) || TextUtils.isEmpty(this.pr)) ? false : true;
    }

    final void a(HttpsURLConnection httpsURLConnection) {
        httpsURLConnection.setRequestMethod("GET");
    }

    final String fN() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(q.aA("https://onelink.%s/shortlink-sdk/v1"));
        stringBuilder.append("/");
        stringBuilder.append(this.po);
        stringBuilder.append("?id=");
        stringBuilder.append(this.pr);
        return stringBuilder.toString();
    }

    final void al(String str) {
        try {
            Map hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject(str);
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                hashMap.put(str2, jSONObject.optString(str2));
            }
            this.rf.h(hashMap);
        } catch (Throwable e) {
            this.rf.aj("Can't parse one link data");
            AFLogger.a("Error while parsing to json ".concat(String.valueOf(str)), e);
        }
    }

    final void fO() {
        this.rf.aj("Can't get one link data");
    }
}
