package com.iqoption.microservice.authorization;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Base64;
import com.google.common.base.Joiner;
import com.google.common.util.concurrent.g;
import com.google.common.util.concurrent.n;
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.s;
import com.iqoption.app.IQApp;
import com.iqoption.core.i;
import com.iqoption.microservice.authorization.a.b;
import com.iqoption.microservice.authorization.a.c;
import com.iqoption.microservice.authorization.a.d;
import com.iqoption.microservice.authorization.a.e;
import com.iqoption.mobbtech.connect.RequestManager;
import com.iqoption.mobbtech.connect.request.a.a.j;
import com.iqoption.util.ag;
import java.nio.charset.Charset;
import java.util.HashMap;

/* compiled from: AuthorizationRequests */
public final class a {
    private static final String TAG = "com.iqoption.microservice.authorization.a";

    private a() {
    }

    public static s<b> d(Context context, String str, String str2, @Nullable String str3, boolean z) {
        String str4 = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("login=");
        stringBuilder.append(str);
        i.d(str4, stringBuilder.toString());
        HashMap hashMap = new HashMap();
        hashMap.put("email", str);
        hashMap.put("password", str2);
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("auth_code", str3);
        }
        if (z) {
            hashMap.put("auth_code_resend", "true");
        }
        str = IQApp.Dl().getAuthApi();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(str);
        stringBuilder2.append("api/v1.0/login");
        s auF = new j(b.class, RequestManager.b(stringBuilder2.toString(), hashMap, context), "api/v1.0/login").auF();
        ag.a(auF, new n<b>() {
            /* renamed from: a */
            public void onSuccess(b bVar) {
                String access$000;
                StringBuilder stringBuilder;
                if (bVar.getErrorCode() != 0) {
                    access$000 = a.TAG;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("login error, result: ");
                    stringBuilder.append(bVar);
                    i.e(access$000, stringBuilder.toString());
                    return;
                }
                access$000 = a.TAG;
                stringBuilder = new StringBuilder();
                stringBuilder.append("login success, result: ");
                stringBuilder.append(bVar);
                i.d(access$000, stringBuilder.toString());
            }

            public void l(Throwable th) {
                String access$000 = a.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("login error ");
                stringBuilder.append(th.getMessage());
                i.e(access$000, stringBuilder.toString());
            }
        });
        ag.a(auF, TAG, "api/v1.0/login");
        return auF;
    }

    public static s<c> aX(Context context) {
        i.d(TAG, "logout");
        String authApi = IQApp.Dl().getAuthApi();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(authApi);
        stringBuilder.append("api/v1.0/logout");
        s auF = new j(c.class, RequestManager.b(stringBuilder.toString(), null, context), "api/v1.0/logout").auF();
        ag.a(auF, TAG, "api/v1.0/logout");
        return auF;
    }

    public static s<e> by(Context context) {
        i.d(TAG, "token");
        String authApi = IQApp.Dl().getAuthApi();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(authApi);
        stringBuilder.append("api/v1.0/token");
        s auF = new j(e.class, RequestManager.b(stringBuilder.toString(), null, context), "api/v1.0/token").auF();
        ag.a(auF, TAG, "api/v1.0/token");
        return auF;
    }

    public static s<d> g(long j, String str) {
        String authApi = IQApp.Dl().getAuthApi();
        String join = Joiner.e('|').join(Long.valueOf(j), str, "http://iqoption.com/android");
        i.d(TAG, join);
        join = Base64.encodeToString(join.getBytes(Charset.forName("UTF-8")), 0);
        HashMap hashMap = new HashMap();
        hashMap.put("q", join);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(authApi);
        stringBuilder.append("api/v1.0/login/token");
        s a = o.a(new b(RequestManager.a(stringBuilder.toString(), hashMap, IQApp.Dk()), "api/v1.0/login/token").auF(), new g<d, d>() {
            /* renamed from: b */
            public s<d> aP(d dVar) {
                if (dVar.cPx == 0 && dVar.body != null && dVar.body.contains("http://iqoption.com/android")) {
                    return o.aR(dVar);
                }
                return o.m(new AuthException(dVar.cPx));
            }
        });
        ag.a(a, TAG, "api/v1.0/login/token");
        return a;
    }
}
