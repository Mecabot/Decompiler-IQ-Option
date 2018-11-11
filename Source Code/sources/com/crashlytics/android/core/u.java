package com.crashlytics.android.core;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.measurement.AppMeasurement;
import io.fabric.sdk.android.c;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DefaultAppMeasurementEventListenerRegistrar */
class u implements b {
    private final k tR;

    static b b(k kVar) {
        return new u(kVar);
    }

    private u(k kVar) {
        this.tR = kVar;
    }

    public boolean gO() {
        Class cls = getClass("com.google.android.gms.measurement.AppMeasurement");
        if (cls == null) {
            c.aUg().w("CrashlyticsCore", "Firebase Analytics is not present; you will not see automatic logging of events before a crash occurs.");
            return false;
        }
        Object i = i(cls);
        if (i != null) {
            return a(cls, i, "registerOnMeasurementEventListener");
        }
        c.aUg().w("CrashlyticsCore", "Could not create an instance of Firebase Analytics.");
        return false;
    }

    private Class<?> getClass(String str) {
        try {
            return this.tR.getContext().getClassLoader().loadClass(str);
        } catch (Exception unused) {
            return null;
        }
    }

    private Object i(Class<?> cls) {
        try {
            return cls.getDeclaredMethod("getInstance", new Class[]{Context.class}).invoke(cls, new Object[]{this.tR.getContext()});
        } catch (Exception unused) {
            return null;
        }
    }

    private boolean a(Class<?> cls, Object obj, String str) {
        StringBuilder stringBuilder;
        Class cls2 = getClass("com.google.android.gms.measurement.AppMeasurement$OnEventListener");
        try {
            cls.getDeclaredMethod(str, new Class[]{cls2}).invoke(obj, new Object[]{j(cls2)});
            return true;
        } catch (Throwable e) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Expected method missing: ");
            stringBuilder.append(str);
            c.aUg().w("CrashlyticsCore", stringBuilder.toString(), e);
            return false;
        } catch (Throwable e2) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Cannot invoke method: ");
            stringBuilder.append(str);
            c.aUg().w("CrashlyticsCore", stringBuilder.toString(), e2);
            return false;
        } catch (Throwable e22) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Cannot access method: ");
            stringBuilder.append(str);
            c.aUg().w("CrashlyticsCore", stringBuilder.toString(), e22);
            return false;
        }
    }

    private Object j(Class cls) {
        return Proxy.newProxyInstance(this.tR.getContext().getClassLoader(), new Class[]{cls}, new InvocationHandler() {
            public Object invoke(Object obj, Method method, Object[] objArr) {
                if (objArr.length != 4) {
                    throw new RuntimeException("Unexpected AppMeasurement.OnEventListener signature");
                }
                String str = (String) objArr[0];
                String str2 = (String) objArr[1];
                Bundle bundle = (Bundle) objArr[2];
                if (!(str == null || str.equals(AppMeasurement.CRASH_ORIGIN))) {
                    u.a(u.this.tR, str2, bundle);
                }
                return null;
            }
        });
    }

    private static void a(k kVar, String str, Bundle bundle) {
        StringBuilder stringBuilder;
        try {
            stringBuilder = new StringBuilder();
            stringBuilder.append("$A$:");
            stringBuilder.append(a(str, bundle));
            kVar.log(stringBuilder.toString());
        } catch (JSONException unused) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to serialize Firebase Analytics event; ");
            stringBuilder.append(str);
            c.aUg().w("CrashlyticsCore", stringBuilder.toString());
        }
    }

    private static String a(String str, Bundle bundle) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        for (String str2 : bundle.keySet()) {
            jSONObject2.put(str2, bundle.get(str2));
        }
        jSONObject.put("name", str);
        jSONObject.put("parameters", jSONObject2);
        return jSONObject.toString();
    }
}
