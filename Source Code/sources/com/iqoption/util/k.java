package com.iqoption.util;

import android.text.TextUtils;
import com.crashlytics.android.a;
import com.iqoption.core.i;
import com.iqoption.mobbtech.connect.response.MobbErrorException;
import com.iqoption.mobbtech.connect.response.g;
import org.json.JSONObject;

/* compiled from: CrashlyticsUtils */
public final class k {
    private static final String TAG = "com.iqoption.util.k";

    private k() {
    }

    public static void c(Throwable th) {
        Object errorMessage;
        String str;
        StringBuilder stringBuilder;
        if (th instanceof MobbErrorException) {
            MobbErrorException mobbErrorException = (MobbErrorException) th;
            if (mobbErrorException.auU() != null) {
                Object obj;
                g auU = mobbErrorException.auU();
                JSONObject auS = auU.auS();
                if (auS == null) {
                    obj = null;
                } else {
                    obj = auS.toString();
                }
                if (!TextUtils.isEmpty(obj)) {
                    a.log(obj);
                }
                errorMessage = auU.getErrorMessage();
                if (!TextUtils.isEmpty(errorMessage)) {
                    a.log(errorMessage);
                }
                str = TAG;
                stringBuilder = new StringBuilder();
                stringBuilder.append("Crashlytics track exception: ");
                stringBuilder.append(th);
                i.v(str, stringBuilder.toString());
                a.c(th);
            }
        }
        errorMessage = th.getMessage();
        if (!TextUtils.isEmpty(errorMessage)) {
            a.log(errorMessage);
        }
        str = TAG;
        stringBuilder = new StringBuilder();
        stringBuilder.append("Crashlytics track exception: ");
        stringBuilder.append(th);
        i.v(str, stringBuilder.toString());
        a.c(th);
    }

    public static void log(String str) {
        if (!TextUtils.isEmpty(str)) {
            String str2 = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Crashlytics track log: ");
            stringBuilder.append(str);
            i.v(str2, stringBuilder.toString());
            a.log(str);
        }
    }
}
