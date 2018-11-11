package com.iqoption.mobbtech.connect.request;

import android.content.Context;
import com.iqoption.app.IQApp;
import com.iqoption.mobbtech.connect.RequestManager;
import com.iqoption.mobbtech.connect.response.h;
import java.util.HashMap;

/* compiled from: PushSettingRequest */
public class g {

    /* compiled from: PushSettingRequest */
    public interface a {
        void a(com.iqoption.mobbtech.connect.response.g gVar);

        void onFinish();
    }

    public static void a(long j, boolean z, final a aVar, Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("id", Long.valueOf(j));
        hashMap.put("enabled", Boolean.valueOf(z));
        String clusterApi = IQApp.Dl().getClusterApi();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(clusterApi);
        stringBuilder.append("api/profile/settings/push");
        com.iqoption.mobbtech.connect.request.a.a.a.a(RequestManager.b(stringBuilder.toString(), hashMap, context), new com.iqoption.mobbtech.connect.a.a() {
            /* renamed from: a */
            public void onSuccess(h hVar) {
                aVar.onFinish();
            }

            public void a(com.iqoption.mobbtech.connect.response.g gVar) {
                aVar.a(gVar);
            }
        }, "api/profile/settings/push");
    }
}
