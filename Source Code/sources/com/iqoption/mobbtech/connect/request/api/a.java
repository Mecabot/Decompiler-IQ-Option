package com.iqoption.mobbtech.connect.request.api;

import android.content.Context;
import android.support.v4.app.NotificationCompat;
import com.google.common.base.Optional;
import com.google.common.util.concurrent.g;
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.s;
import com.iqoption.app.IQApp;
import com.iqoption.core.i;
import com.iqoption.mobbtech.connect.RequestManager;
import com.iqoption.mobbtech.connect.request.a.a.k;
import com.iqoption.mobbtech.connect.response.m;
import java.util.HashMap;

/* compiled from: AccountSecurityRequests */
public class a {
    private static final String TAG = "com.iqoption.mobbtech.connect.request.api.a";

    /* compiled from: AccountSecurityRequests */
    private static class a extends m {
        public boolean isSuccessful() {
            return true;
        }

        private a() {
        }
    }

    private a() {
    }

    public static s<m> C(Context context, String str) {
        String str2 = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Change current email: ");
        stringBuilder.append(str);
        i.d(str2, stringBuilder.toString());
        HashMap hashMap = new HashMap();
        hashMap.put("email", str);
        str = IQApp.Dl().getClusterApi();
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("api/profile/save-email");
        return new k(m.class, RequestManager.b(stringBuilder.toString(), hashMap, context), "api/profile/save-email").auG();
    }

    public static s<m> e(final Context context, String str, final String str2) {
        String str3 = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Change not activated email. oldEmail: ");
        stringBuilder.append(str);
        stringBuilder.append(", newEmail: ");
        stringBuilder.append(str2);
        i.d(str3, stringBuilder.toString());
        HashMap hashMap = new HashMap();
        hashMap.put("old_email", str);
        hashMap.put("new_email", str2);
        return o.a(RequestManager.a(IQApp.Dl().getClusterApi(), "api/change-email", hashMap, context, m.class), new g<m, m>() {
            /* renamed from: a */
            public s<m> aP(m mVar) {
                return a.c(context, str2, com.iqoption.app.a.aL(context).getUserId());
            }
        });
    }

    public static s<m> c(Context context, String str, long j) {
        String str2 = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("reactivate email: ");
        stringBuilder.append(str);
        stringBuilder.append(", accountId: ");
        stringBuilder.append(j);
        i.d(str2, stringBuilder.toString());
        HashMap hashMap = new HashMap();
        hashMap.put("email", str);
        hashMap.put("id", Long.valueOf(j));
        return RequestManager.a(IQApp.Dl().getClusterApi(), "api/register/reactivate", hashMap, context, m.class);
    }

    public static s<m> b(Context context, long j, long j2) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Change phone countryCode=");
        stringBuilder.append(j);
        stringBuilder.append(", phone=");
        stringBuilder.append(j2);
        i.d(str, stringBuilder.toString());
        HashMap hashMap = new HashMap();
        hashMap.put("phone_code", Long.valueOf(j));
        hashMap.put("phone", Long.valueOf(j2));
        String clusterApi = IQApp.Dl().getClusterApi();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(clusterApi);
        stringBuilder2.append("api/profile/save-phone");
        stringBuilder2.toString();
        return RequestManager.a(clusterApi, "api/profile/save-phone", hashMap, context, m.class);
    }

    public static s<com.iqoption.mobbtech.connect.response.o> bE(Context context) {
        i.d(TAG, "Request phone confirmation");
        return RequestManager.a(IQApp.Dl().getClusterApi(), "api/sendphoneconfirmation", context, com.iqoption.mobbtech.connect.response.o.class);
    }

    public static s<com.iqoption.mobbtech.connect.response.o> D(Context context, String str) {
        String str2 = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Confirm phone, code=");
        stringBuilder.append(str);
        i.d(str2, stringBuilder.toString());
        return RequestManager.a(IQApp.Dl().getClusterApi(), "api/phoneconfirm/$hashcode".replace("$hashcode", str), null, context, com.iqoption.mobbtech.connect.response.o.class, "api/phoneconfirm/$hashcode");
    }

    public static s<? extends m> a(Context context, boolean z, Optional<String> optional) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("EnableTwoFactorAuth() enable=");
        stringBuilder.append(z);
        stringBuilder.append(", authCode=");
        stringBuilder.append(optional);
        i.d(str, stringBuilder.toString());
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_STATUS, Integer.valueOf(z));
        String clusterApi = IQApp.Dl().getClusterApi();
        stringBuilder = new StringBuilder();
        stringBuilder.append(clusterApi);
        stringBuilder.append("api/profile/auth_two_factor");
        clusterApi = stringBuilder.toString();
        if (!optional.isPresent()) {
            return new k(a.class, RequestManager.b(clusterApi, hashMap, context), "api/profile/auth_two_factor").auG();
        }
        hashMap.put("auth_code", optional.get());
        return new k(m.class, RequestManager.b(clusterApi, hashMap, context), "api/profile/auth_two_factor").auG();
    }
}
