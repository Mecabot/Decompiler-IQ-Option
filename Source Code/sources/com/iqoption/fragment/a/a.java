package com.iqoption.fragment.a;

import android.content.Context;
import android.text.TextUtils;
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.s;
import com.iqoption.app.IQApp;
import com.iqoption.app.af;
import com.iqoption.mobbtech.connect.RequestManager;

/* compiled from: DebugConsole */
public class a {
    public static String aMk = "";
    public static String aMm = "";
    public static String aMn = "";
    public static String aMo = "";
    public static String aMp = "";
    public static boolean czo = false;
    public static boolean czp = false;
    public static boolean czq = false;
    public static boolean czr = false;

    public static boolean isAvailable() {
        return "com.iqoption.x".matches("com\\.iqoption\\.dev(\\.x)?");
    }

    public static s<?> w(Context context, String str) {
        if (!isAvailable() || TextUtils.isEmpty(str)) {
            return o.aR(null);
        }
        RequestManager.atO().atV();
        s<?> x = x(context, str);
        af.aR(context).setHost(str);
        RequestManager.atO().atV();
        return x;
    }

    public static s<?> x(Context context, String str) {
        if (!isAvailable() || TextUtils.isEmpty(str)) {
            return o.aR(null);
        }
        return IQApp.Dl().B(context, str);
    }
}
