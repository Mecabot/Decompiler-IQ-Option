package com.appsflyer;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class k extends FirebaseInstanceIdService {
    public void fM() {
        String token;
        super.fM();
        long currentTimeMillis = System.currentTimeMillis();
        try {
            token = FirebaseInstanceId.wj().getToken();
        } catch (Throwable th) {
            AFLogger.a("Error registering for uninstall tracking", th);
            token = null;
        }
        if (token != null) {
            AFLogger.an("Firebase Refreshed Token = ".concat(String.valueOf(token)));
            s aB = s.aB(i.fF().getString("afUninstallToken"));
            s sVar = new s(currentTimeMillis, token);
            if (aB.a(sVar)) {
                ag.a(getApplicationContext(), sVar);
            }
        }
    }
}
