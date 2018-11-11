package com.iqoption.analytics;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.common.util.concurrent.n;
import com.google.common.util.concurrent.s;
import com.google.gson.JsonObject;
import com.iqoption.app.IQApp;
import com.iqoption.core.a.b;
import com.iqoption.core.a.d;
import com.iqoption.core.a.e;
import com.iqoption.core.i;
import com.iqoption.dto.Event;
import com.iqoption.dto.Event.ApiCallEventBusEvent;
import com.iqoption.dto.Event.Builder;
import com.iqoption.util.ag;
import com.jumio.nv.data.NVStrings;
import java.net.SocketTimeoutException;

/* compiled from: EventUtils */
public final class f implements e {
    private static final String TAG = "com.iqoption.analytics.f";
    private static f aje;

    public static f Br() {
        if (aje == null) {
            synchronized (f.class) {
                if (aje == null) {
                    aje = new f();
                }
            }
        }
        return aje;
    }

    private f() {
    }

    public void dV(String str) {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, str).build());
    }

    public void a(String str, JsonObject jsonObject) {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, str).setParameters(jsonObject).build());
    }

    public void b(String str, double d) {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, str).setValue(Double.valueOf(d)).build());
    }

    public void a(String str, double d, JsonObject jsonObject) {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, str).setValue(Double.valueOf(d)).setParameters(jsonObject).build());
    }

    public void b(@NonNull String str, double d, @Nullable JsonObject jsonObject) {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_FOCUS_ON, str).setParameters(jsonObject).build());
    }

    public void g(String str, boolean z) {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_SYSTEM, str).setTechnicalLogs(Boolean.valueOf(z)).build());
    }

    public void a(String str, double d, boolean z) {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_SYSTEM, str).setValue(Double.valueOf(d)).setTechnicalLogs(Boolean.valueOf(z)).build());
    }

    public void a(String str, double d, JsonObject jsonObject, boolean z) {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_SYSTEM, str).setValue(Double.valueOf(d)).setParameters(jsonObject).setTechnicalLogs(Boolean.valueOf(z)).build());
    }

    public void dW(String str) {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_SCROLL, str).build());
    }

    public void c(String str, double d, JsonObject jsonObject) {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_DROPDOWN_CHANGED, str).setParameters(jsonObject).build());
    }

    public void dX(String str) {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_TEXT_CHANGED, str).build());
    }

    public void b(String str, JsonObject jsonObject) {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_DRAG, str).setParameters(jsonObject).build());
    }

    public d dY(String str) {
        return c(str, 0.0d);
    }

    public d c(String str, double d) {
        return a(Event.CATEGORY_POPUP_SERVED, str, d, null, false);
    }

    public d dZ(String str) {
        return d(str, 0.0d);
    }

    public d d(String str, double d) {
        return d(str, d, null);
    }

    public d d(String str, double d, @Nullable JsonObject jsonObject) {
        return a(Event.CATEGORY_SCREEN_OPENED, str, d, jsonObject, false);
    }

    public b b(String str, double d, JsonObject jsonObject, boolean z) {
        return a(Event.CATEGORY_SYSTEM, str, d, jsonObject, z);
    }

    @NonNull
    private b a(String str, String str2, double d, final JsonObject jsonObject, boolean z) {
        final Builder technicalLogs = Event.Builder(str, str2).setValue(Double.valueOf(d)).setParameters(jsonObject).setTechnicalLogs(Boolean.valueOf(z));
        return new b() {
            JsonObject ajf = jsonObject;

            public void a(JsonObject jsonObject) {
                this.ajf = jsonObject;
            }

            public void Bs() {
                EventManager.Bm().a(technicalLogs.calcDuration().build());
            }

            public void a(Number number) {
                technicalLogs.setValue(Double.valueOf(number.doubleValue()));
            }
        };
    }

    public void a(s sVar, String str, long j, boolean z, String str2) {
        if (sVar != null && !TextUtils.isEmpty(str)) {
            Builder parameters = Event.ApiCallBuilder(str).setParameters(a(str, j, z, str2));
            IQApp.Dn().aE(new ApiCallEventBusEvent(str, parameters.build(), null));
            a(str, sVar, parameters);
        }
    }

    private JsonObject a(String str, long j, boolean z, String str2) {
        String str3 = z ? "true" : "false";
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("api_name", str);
        jsonObject.addProperty("api_timeout", Long.valueOf(j));
        jsonObject.addProperty("is_socket", str3);
        jsonObject.addProperty(NVStrings.FRONT, str2);
        return jsonObject;
    }

    private void a(final String str, s sVar, final Builder builder) {
        ag.a(sVar, new n() {
            public void onSuccess(Object obj) {
                Event build = builder.calcDuration().setValue(Double.valueOf(0.0d)).build();
                String access$000 = f.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("send api-call event ");
                stringBuilder.append(build);
                i.v(access$000, stringBuilder.toString());
                EventManager.Bm().a(build);
                IQApp.Dn().aE(new ApiCallEventBusEvent(str, build, null));
            }

            public void l(Throwable th) {
                Event build = builder.calcDuration().setValue(Double.valueOf(1.0d)).build();
                if (th instanceof SocketTimeoutException) {
                    String access$000 = f.TAG;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("send api-call event (timeout) ");
                    stringBuilder.append(build);
                    i.v(access$000, stringBuilder.toString());
                    EventManager.Bm().a(build);
                }
                build.value = Double.valueOf(2.0d);
                IQApp.Dn().aE(new ApiCallEventBusEvent(str, build, th));
            }
        });
    }

    public void a(String str, String str2, long j, int i) {
        String str3 = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("sendLaunchStat launch-stat front:");
        stringBuilder.append(str);
        stringBuilder.append(", duration:");
        stringBuilder.append(j);
        stringBuilder.append(", reconnectCount:");
        stringBuilder.append(i);
        stringBuilder.append(", log=");
        stringBuilder.append(str2);
        i.v(str3, stringBuilder.toString());
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_SYSTEM, Event.LAUNCH_STAT_EVENT).setParameters(V(str, str2)).setValue(Double.valueOf((double) i)).setDuration(j).build());
    }

    private JsonObject V(String str, String str2) {
        JsonObject jsonObject = new JsonObject();
        String str3 = NVStrings.FRONT;
        if (str == null) {
            str = "";
        }
        jsonObject.addProperty(str3, str);
        jsonObject.addProperty("log", str2);
        return jsonObject;
    }
}
