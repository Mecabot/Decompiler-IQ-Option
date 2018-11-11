package com.iqoption.core.util;

import com.crashlytics.android.a;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, aXE = {"Lcom/iqoption/core/util/CrashlyticsUtils;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "log", "", "message", "logException", "t", "", "core_release"})
/* compiled from: CrashlyticsUtils.kt */
public final class b {
    private static final String TAG = "b";
    public static final b bgC = new b();

    private b() {
    }

    public static final void c(Throwable th) {
        h.e(th, "t");
        log(th.getMessage());
        a.c(th);
        com.iqoption.core.i.v(TAG, "track exception", th);
    }

    public static final void log(String str) {
        if (str != null) {
            if ((((CharSequence) str).length() > 0 ? 1 : null) != null) {
                a.log(str);
                String str2 = TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Crashlytics track log: ");
                stringBuilder.append(str);
                com.iqoption.core.i.v(str2, stringBuilder.toString());
            }
        }
    }
}
