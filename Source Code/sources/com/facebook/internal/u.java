package com.facebook.internal;

import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* compiled from: ProfileInformationCache */
class u {
    private static final ConcurrentHashMap<String, JSONObject> Er = new ConcurrentHashMap();

    public static JSONObject bM(String str) {
        return (JSONObject) Er.get(str);
    }

    public static void e(String str, JSONObject jSONObject) {
        Er.put(str, jSONObject);
    }
}
