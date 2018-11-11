package com.crashlytics.android.answers;

import android.content.Context;
import android.os.Bundle;
import java.lang.reflect.Method;

/* compiled from: AppMeasurementEventLogger */
public class j implements o {
    private final Method si;
    private final Object sj;

    public static o L(Context context) {
        Class M = M(context);
        if (M == null) {
            return null;
        }
        Object b = b(context, M);
        if (b == null) {
            return null;
        }
        Method c = c(context, M);
        if (c == null) {
            return null;
        }
        return new j(b, c);
    }

    private static Class M(Context context) {
        try {
            return context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement");
        } catch (Exception unused) {
            return null;
        }
    }

    private static Object b(Context context, Class cls) {
        try {
            return cls.getDeclaredMethod("getInstance", new Class[]{Context.class}).invoke(cls, new Object[]{context});
        } catch (Exception unused) {
            return null;
        }
    }

    private static Method c(Context context, Class cls) {
        try {
            return cls.getDeclaredMethod("logEventInternal", new Class[]{String.class, String.class, Bundle.class});
        } catch (Exception unused) {
            return null;
        }
    }

    public j(Object obj, Method method) {
        this.sj = obj;
        this.si = method;
    }

    public void logEvent(String str, Bundle bundle) {
        a("fab", str, bundle);
    }

    public void a(String str, String str2, Bundle bundle) {
        try {
            this.si.invoke(this.sj, new Object[]{str, str2, bundle});
        } catch (Exception unused) {
        }
    }
}
