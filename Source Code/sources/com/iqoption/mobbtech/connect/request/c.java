package com.iqoption.mobbtech.connect.request;

import android.content.Context;
import android.text.TextUtils;
import com.iqoption.app.IQApp;
import com.iqoption.app.a.b;
import com.iqoption.mobbtech.connect.RequestManager;
import com.iqoption.mobbtech.connect.request.a.a.a;
import com.iqoption.mobbtech.connect.response.g;
import com.iqoption.mobbtech.connect.response.h;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ChangePassRequest */
public class c {
    public void b(final Context context, String str, final String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("current_password", str);
        hashMap.put("password", str2);
        hashMap.put("password2", str3);
        str = IQApp.Dl().getClusterApi();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("api/profile/password");
        a.a(RequestManager.b(stringBuilder.toString(), hashMap, context), new com.iqoption.mobbtech.connect.a.a() {
            /* renamed from: a */
            public void onSuccess(h hVar) {
                try {
                    b.b(hVar.auV().getJSONArray("message").getString(0), context);
                    com.iqoption.app.a.aL(context).setPassword(str2);
                    com.iqoption.app.a.aL(context).aN(context);
                } catch (JSONException unused) {
                }
            }

            public void a(g gVar) {
                String str = "";
                if (!(gVar.auS() == null || (gVar.auS().optJSONArray("message") == null && gVar.auS().optJSONObject("message") == null))) {
                    try {
                        JSONObject jSONObject = gVar.auS().getJSONObject("message");
                        if (TextUtils.isEmpty(str) && jSONObject.optJSONArray("password") != null) {
                            str = jSONObject.optJSONArray("password").getString(0);
                        }
                        if (TextUtils.isEmpty(str) && jSONObject.optJSONArray("current_password") != null) {
                            str = jSONObject.optJSONArray("current_password").getString(0);
                        }
                    } catch (JSONException unused) {
                        str = gVar.getErrorMessage();
                    }
                }
                if (str.isEmpty()) {
                    b.aT(context);
                } else {
                    b.b(str, context);
                }
            }
        }, "api/profile/password");
    }
}
