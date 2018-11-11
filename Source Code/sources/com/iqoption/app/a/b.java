package com.iqoption.app.a;

import android.content.Context;
import android.support.annotation.StringRes;
import android.support.multidex.MultiDexApplication;
import android.text.TextUtils;
import android.widget.Toast;
import com.iqoption.app.IQApp;
import com.iqoption.app.af;
import com.iqoption.core.d.a;
import com.iqoption.util.be;
import com.iqoption.x.R;
import io.fabric.sdk.android.c;

/* compiled from: IQBaseApp */
public class b extends MultiDexApplication {
    public static boolean FF() {
        return af.DX().Ej();
    }

    public static void eO(String str) {
        a(str, IQApp.Dk(), 1);
    }

    public static void eP(String str) {
        a(str, IQApp.Dk(), 0);
    }

    public static void cV(@StringRes int i) {
        a(IQApp.Dk().getString(i), IQApp.Dk(), 0);
    }

    public static void eQ(String str) {
        if (TextUtils.isEmpty(str)) {
            FG();
        } else {
            a(str, IQApp.Dk(), 0);
        }
    }

    public static void b(String str, Context context) {
        a(str, context, 1);
    }

    public static void a(String str, Context context, int i) {
        if (!TextUtils.isEmpty(str)) {
            if (be.aGz()) {
                Toast.makeText(context, str, i).show();
            } else {
                a.aSe.execute(new c(context, str, i));
            }
        }
    }

    public static void FG() {
        Context Dk = IQApp.Dk();
        b(Dk.getString(R.string.unknown_error_occurred), Dk);
    }

    public static void aT(Context context) {
        b(context.getString(R.string.unknown_error_occurred), context);
    }

    public void onCreate() {
        super.onCreate();
        c.a((Context) this, new com.crashlytics.android.a(), new com.crashlytics.android.ndk.c());
    }
}
