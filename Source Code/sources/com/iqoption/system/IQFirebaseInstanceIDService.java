package com.iqoption.system;

import android.content.Context;
import android.text.TextUtils;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.google.firebase.messaging.a;
import com.iqoption.app.IQApp;
import com.iqoption.app.af;
import com.iqoption.core.i;
import com.iqoption.mobbtech.connect.request.api.f;

public class IQFirebaseInstanceIDService extends FirebaseInstanceIdService {
    private static final String TAG = "com.iqoption.system.IQFirebaseInstanceIDService";

    public void fM() {
        try {
            af.aR(getApplicationContext()).eD(FirebaseInstanceId.wj().getToken());
        } catch (Exception unused) {
        }
    }

    public static void aEo() {
        try {
            Context Dk = IQApp.Dk();
            if (Dk != null) {
                String token = FirebaseInstanceId.wj().getToken();
                String str = TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("token: ");
                stringBuilder.append(token);
                i.d(str, stringBuilder.toString());
                if (!TextUtils.isEmpty(token)) {
                    f.iv(token);
                    af.aR(Dk.getApplicationContext()).eC(token);
                    aEp();
                }
            } else {
                i.d(TAG, "FCM registration token is not sent");
            }
        } catch (Exception unused) {
        }
    }

    private static void aEp() {
        a.wR().cZ("global");
    }

    public static void bM(Context context) {
        if (context != null) {
            try {
                Object token = FirebaseInstanceId.wj().getToken();
                String str = TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("unregisterTokenOnServer token: ");
                stringBuilder.append(token);
                i.d(str, stringBuilder.toString());
                if (!TextUtils.isEmpty(token)) {
                    f.iw(token);
                    af.aR(context.getApplicationContext()).eC("");
                }
            } catch (Exception unused) {
                return;
            }
        }
        i.d(TAG, "FCM unregister token is not called");
    }
}
