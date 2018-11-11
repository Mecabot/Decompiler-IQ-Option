package com.facebook.appevents;

import android.content.Context;
import android.os.Bundle;
import com.facebook.appevents.internal.AppEventsLoggerUtility;
import com.facebook.appevents.internal.AppEventsLoggerUtility.GraphAPIActivityType;
import com.facebook.i;
import com.facebook.internal.b;
import com.facebook.internal.w;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SessionEventsState */
class f {
    private String zn;
    private List<AppEvent> zt = new ArrayList();
    private List<AppEvent> zu = new ArrayList();
    private int zv;
    private b zw;
    private final int zx = 1000;

    public f(b bVar, String str) {
        this.zw = bVar;
        this.zn = str;
    }

    public synchronized void a(AppEvent appEvent) {
        if (this.zt.size() + this.zu.size() >= 1000) {
            this.zv++;
        } else {
            this.zt.add(appEvent);
        }
    }

    public synchronized int kq() {
        return this.zt.size();
    }

    public synchronized void J(boolean z) {
        if (z) {
            this.zt.addAll(this.zu);
        }
        this.zu.clear();
        this.zv = 0;
    }

    public int a(i iVar, Context context, boolean z, boolean z2) {
        synchronized (this) {
            int i = this.zv;
            this.zu.addAll(this.zt);
            this.zt.clear();
            JSONArray jSONArray = new JSONArray();
            for (AppEvent appEvent : this.zu) {
                if (!appEvent.ka()) {
                    w.E("Event with invalid checksum: %s", appEvent.toString());
                } else if (z || !appEvent.jZ()) {
                    jSONArray.put(appEvent.jK());
                }
            }
            if (jSONArray.length() == 0) {
                return 0;
            }
            a(iVar, context, i, jSONArray, z2);
            return jSONArray.length();
        }
    }

    public synchronized List<AppEvent> kr() {
        List<AppEvent> list;
        list = this.zt;
        this.zt = new ArrayList();
        return list;
    }

    private void a(i iVar, Context context, int i, JSONArray jSONArray, boolean z) {
        JSONObject a;
        try {
            a = AppEventsLoggerUtility.a(GraphAPIActivityType.CUSTOM_APP_EVENTS, this.zw, this.zn, z, context);
            if (this.zv > 0) {
                a.put("num_skipped_events", i);
            }
        } catch (JSONException unused) {
            a = new JSONObject();
        }
        iVar.d(a);
        Bundle jn = iVar.jn();
        if (jn == null) {
            jn = new Bundle();
        }
        String jSONArray2 = jSONArray.toString();
        if (jSONArray2 != null) {
            jn.putString("custom_events", jSONArray2);
            iVar.setTag(jSONArray2);
        }
        iVar.setParameters(jn);
    }
}
