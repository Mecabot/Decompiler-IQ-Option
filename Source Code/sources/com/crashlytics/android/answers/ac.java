package com.crashlytics.android.answers;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import com.google.android.gms.measurement.AppMeasurement.Param;
import io.fabric.sdk.android.services.b.a;
import java.io.IOException;
import org.json.JSONObject;

/* compiled from: SessionEventTransform */
class ac implements a<SessionEvent> {
    ac() {
    }

    /* renamed from: e */
    public byte[] n(SessionEvent sessionEvent) {
        return f(sessionEvent).toString().getBytes("UTF-8");
    }

    @TargetApi(9)
    public JSONObject f(SessionEvent sessionEvent) {
        try {
            JSONObject jSONObject = new JSONObject();
            ab abVar = sessionEvent.sT;
            jSONObject.put("appBundleId", abVar.tb);
            jSONObject.put("executionId", abVar.td);
            jSONObject.put("installationId", abVar.te);
            jSONObject.put("limitAdTrackingEnabled", abVar.tf);
            jSONObject.put("betaDeviceToken", abVar.tg);
            jSONObject.put("buildId", abVar.th);
            jSONObject.put("osVersion", abVar.osVersion);
            jSONObject.put("deviceModel", abVar.ti);
            jSONObject.put("appVersionCode", abVar.tj);
            jSONObject.put("appVersionName", abVar.tk);
            jSONObject.put(Param.TIMESTAMP, sessionEvent.timestamp);
            jSONObject.put(Param.TYPE, sessionEvent.sU.toString());
            if (sessionEvent.sV != null) {
                jSONObject.put("details", new JSONObject(sessionEvent.sV));
            }
            jSONObject.put("customType", sessionEvent.sW);
            if (sessionEvent.sX != null) {
                jSONObject.put("customAttributes", new JSONObject(sessionEvent.sX));
            }
            jSONObject.put("predefinedType", sessionEvent.sY);
            if (sessionEvent.sZ != null) {
                jSONObject.put("predefinedAttributes", new JSONObject(sessionEvent.sZ));
            }
            return jSONObject;
        } catch (Throwable e) {
            if (VERSION.SDK_INT >= 9) {
                throw new IOException(e.getMessage(), e);
            }
            throw new IOException(e.getMessage());
        }
    }
}
