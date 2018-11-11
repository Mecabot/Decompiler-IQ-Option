package com.crashlytics.android.answers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import io.fabric.sdk.android.c;
import io.fabric.sdk.android.h;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.i.a;
import io.fabric.sdk.android.services.common.m;
import io.fabric.sdk.android.services.settings.q;
import io.fabric.sdk.android.services.settings.s;
import java.io.File;

/* compiled from: Answers */
public class b extends h<Boolean> {
    boolean rO = false;
    z rP;

    public String getIdentifier() {
        return "com.crashlytics.sdk.android:answers";
    }

    public String getVersion() {
        return "1.4.2.25";
    }

    public void a(io.fabric.sdk.android.services.common.i.b bVar) {
        if (this.rP != null) {
            this.rP.onError(bVar.FC());
        }
    }

    public void a(a aVar) {
        if (this.rP != null) {
            this.rP.k(aVar.FC(), aVar.getExceptionName());
        }
    }

    @SuppressLint({"NewApi"})
    protected boolean go() {
        try {
            long j;
            Context context = getContext();
            PackageManager packageManager = context.getPackageManager();
            String packageName = context.getPackageName();
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
            String num = Integer.toString(packageInfo.versionCode);
            String str = packageInfo.versionName == null ? "0.0" : packageInfo.versionName;
            if (VERSION.SDK_INT >= 9) {
                j = packageInfo.firstInstallTime;
            } else {
                j = new File(packageManager.getApplicationInfo(packageName, 0).sourceDir).lastModified();
            }
            this.rP = z.a(this, context, aUn(), num, str, j);
            this.rP.enable();
            this.rO = new m().cS(context);
            return true;
        } catch (Throwable e) {
            c.aUg().e("Answers", "Error retrieving app properties", e);
            return false;
        }
    }

    /* renamed from: gp */
    protected Boolean doInBackground() {
        try {
            s aVN = q.aVM().aVN();
            if (aVN == null) {
                c.aUg().e("Answers", "Failed to retrieve settings");
                return Boolean.valueOf(false);
            } else if (aVN.epN.eps) {
                c.aUg().d("Answers", "Analytics collection enabled");
                this.rP.a(aVN.sN, gq());
                return Boolean.valueOf(true);
            } else {
                c.aUg().d("Answers", "Analytics collection disabled");
                this.rP.disable();
                return Boolean.valueOf(false);
            }
        } catch (Throwable e) {
            c.aUg().e("Answers", "Error dealing with settings", e);
            return Boolean.valueOf(false);
        }
    }

    String gq() {
        return CommonUtils.I(getContext(), "com.crashlytics.ApiEndpoint");
    }
}
