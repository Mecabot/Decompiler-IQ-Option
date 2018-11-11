package com.iqoption.mobbtech.connect.request;

import com.iqoption.app.IQApp;
import com.iqoption.mobbtech.connect.RequestManager;
import java.util.HashMap;
import java.util.TimeZone;

/* compiled from: AnonymRegisterRequest */
public class a {
    public static void a(final com.iqoption.mobbtech.connect.a.a aVar) {
        com.iqoption.core.d.a.aSc.execute(new Runnable() {
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put("tz", TimeZone.getDefault().getID());
                String in = IQApp.Dl().in("api/anonymregister-trial-users");
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(in);
                stringBuilder.append("api/anonymregister-trial-users");
                com.iqoption.mobbtech.connect.request.a.a.a.a(RequestManager.b(stringBuilder.toString(), hashMap, IQApp.Dk()), aVar, "api/anonymregister-trial-users");
            }
        });
    }
}
