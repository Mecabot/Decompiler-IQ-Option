package com.iqoption.mobbtech.connect.request;

import android.content.Context;
import com.iqoption.app.IQApp;
import com.iqoption.core.f;
import com.iqoption.mobbtech.connect.RequestManager;
import com.iqoption.mobbtech.connect.a.c;
import com.iqoption.mobbtech.connect.request.a.a.a;
import com.iqoption.mobbtech.connect.response.g;
import com.iqoption.mobbtech.connect.response.h;
import java.util.HashMap;
import java.util.TimeZone;

/* compiled from: ChangeLangRequest */
public class b {
    private boolean Fs = false;

    public void a(Context context, final c cVar) {
        this.Fs = true;
        HashMap hashMap = new HashMap();
        hashMap.put("lang", f.getLocale());
        hashMap.put("tz", TimeZone.getDefault().getID());
        String clusterApi = IQApp.Dl().getClusterApi();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(clusterApi);
        stringBuilder.append("api/profile/settings");
        a.a(RequestManager.b(stringBuilder.toString(), hashMap, context), new com.iqoption.mobbtech.connect.a.a() {
            /* renamed from: a */
            public void onSuccess(h hVar) {
                b.this.Fs = false;
                cVar.r(new Object[0]);
            }

            public void a(g gVar) {
                b.this.Fs = false;
                cVar.r(new Object[0]);
            }
        }, "api/profile/settings");
    }
}
