package com.iqoption.mobbtech.connect.request;

import android.content.Context;
import com.iqoption.app.IQApp;
import com.iqoption.mobbtech.connect.RequestManager;
import com.iqoption.mobbtech.connect.a.a;
import java.util.HashMap;

/* compiled from: PasswordRecoveryRequest */
public class e {
    public void a(Context context, String str, a aVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("email", str);
        str = IQApp.Dl().getClusterApi();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("api/auth/retrieving");
        com.iqoption.mobbtech.connect.request.a.a.a.a(RequestManager.b(stringBuilder.toString(), hashMap, context), aVar, "api/auth/retrieving");
    }
}
