package com.iqoption.mobbtech.connect.request.api;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.common.util.concurrent.n;
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.s;
import com.iqoption.app.IQApp;
import com.iqoption.dto.entity.iqbus.NetverifyConfig;
import com.iqoption.dto.entity.iqbus.NetverifyToken;
import com.iqoption.dto.entity.iqbus.VerifyInitResult;
import com.iqoption.dto.entity.result.NetverifyUploadStatus;
import com.iqoption.mobbtech.connect.request.a.a.b;
import com.iqoption.mobbtech.connect.response.MobbErrorException;
import com.iqoption.util.k;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: IQBusJumioRequests */
public final class e {
    public static int cUL = 1;
    public static int cUM = 2;

    /* compiled from: IQBusJumioRequests */
    private static class a implements n<Object> {
        private final String abQ;

        public void onSuccess(Object obj) {
        }

        private a(String str) {
            this.abQ = str;
        }

        public void l(Throwable th) {
            com.crashlytics.android.a.log(this.abQ);
            k.c(th);
            if (th instanceof MobbErrorException) {
                MobbErrorException mobbErrorException = (MobbErrorException) th;
                if (mobbErrorException.auU() != null) {
                    JSONObject auS = mobbErrorException.auU().auS();
                    if (auS != null) {
                        com.iqoption.kyc.a.a.z(IQApp.Dk().getApplicationContext(), auS.toString());
                    }
                }
            }
        }
    }

    public static s<NetverifyConfig> auv() {
        s b = new b(NetverifyConfig.class, null, "get-netverify-config").b("get-netverify-config", null);
        o.a(b, new a("get-netverify-config error"));
        return b;
    }

    public static s<NetverifyToken> b(int i, long j, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("accountVerifyMethodId", Integer.valueOf(i));
        hashMap.put("customerId", Long.valueOf(j));
        hashMap.put("locale", str);
        s b = new b(NetverifyToken.class, null, "create-netverify-token").b("create-netverify-token", hashMap);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create-netverify-token error. accountVerifyMethodId=");
        stringBuilder.append(i);
        stringBuilder.append(", locale=");
        stringBuilder.append(str);
        o.a(b, new a(stringBuilder.toString()));
        return b;
    }

    public static s<NetverifyUploadStatus> c(String str, @Nullable String str2, boolean z, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("merchantScanReference", str);
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("jumioScanReference", str2);
        }
        hashMap.put("isUploadCanceled", Boolean.valueOf(z));
        if (i != 0) {
            hashMap.put("errorCode", Integer.valueOf(i));
        }
        s b = new b(NetverifyUploadStatus.class, null, "notify-netverify-upload-status").b("notify-netverify-upload-status", hashMap);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("notify-netverify-upload-status error. merchantScanReference=");
        stringBuilder.append(str);
        stringBuilder.append(", jumioScanReference=");
        stringBuilder.append(str2);
        stringBuilder.append(", isUploadCanceled=");
        stringBuilder.append(z);
        stringBuilder.append(", errorCode=");
        stringBuilder.append(i);
        o.a(b, new a(stringBuilder.toString()));
        return b;
    }

    public static s<VerifyInitResult> q(long j, long j2) {
        HashMap hashMap = new HashMap();
        hashMap.put("user_id", Long.valueOf(j));
        hashMap.put("card_id", Long.valueOf(j2));
        s b = new b(VerifyInitResult.class, null, "verify-init").b("verify-init", hashMap);
        o.a(b, new a("verify-init error"));
        return b;
    }
}
