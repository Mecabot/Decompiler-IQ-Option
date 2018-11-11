package com.facebook.appevents.codeless.internal;

import com.google.firebase.analytics.FirebaseAnalytics.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EventBinding {
    private final MappingMethod Ab;
    private final ActionType Ac;
    private final String Ad;
    private final List<PathComponent> Ae;
    private final String Af;
    private final String Ag;
    private final List<a> parameters;
    private final String sD;
    private final String zS;

    public enum ActionType {
        CLICK,
        SELECTED,
        TEXT_CHANGED
    }

    public enum MappingMethod {
        MANUAL,
        INFERENCE
    }

    public EventBinding(String str, MappingMethod mappingMethod, ActionType actionType, String str2, List<PathComponent> list, List<a> list2, String str3, String str4, String str5) {
        this.sD = str;
        this.Ab = mappingMethod;
        this.Ac = actionType;
        this.Ad = str2;
        this.Ae = list;
        this.parameters = list2;
        this.Af = str3;
        this.Ag = str4;
        this.zS = str5;
    }

    public static List<EventBinding> c(JSONArray jSONArray) {
        int length;
        List<EventBinding> arrayList = new ArrayList();
        int i = 0;
        if (jSONArray != null) {
            try {
                length = jSONArray.length();
            } catch (JSONException unused) {
                return arrayList;
            }
        }
        length = 0;
        while (i < length) {
            arrayList.add(f(jSONArray.getJSONObject(i)));
            i++;
        }
    }

    public static EventBinding f(JSONObject jSONObject) {
        String string = jSONObject.getString("event_name");
        MappingMethod valueOf = MappingMethod.valueOf(jSONObject.getString(b.METHOD).toUpperCase());
        ActionType valueOf2 = ActionType.valueOf(jSONObject.getString("event_type").toUpperCase());
        String string2 = jSONObject.getString("app_version");
        JSONArray jSONArray = jSONObject.getJSONArray("path");
        List arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(new PathComponent(jSONArray.getJSONObject(i)));
        }
        String optString = jSONObject.optString("path_type", "absolute");
        jSONArray = jSONObject.optJSONArray("parameters");
        List arrayList2 = new ArrayList();
        if (jSONArray != null) {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                arrayList2.add(new a(jSONArray.getJSONObject(i2)));
            }
        }
        return new EventBinding(string, valueOf, valueOf2, string2, arrayList, arrayList2, jSONObject.optString("component_id"), optString, jSONObject.optString("activity_name"));
    }

    public List<PathComponent> kC() {
        return Collections.unmodifiableList(this.Ae);
    }

    public List<a> kD() {
        return Collections.unmodifiableList(this.parameters);
    }

    public String gF() {
        return this.sD;
    }

    public ActionType kE() {
        return this.Ac;
    }

    public String kF() {
        return this.zS;
    }
}
