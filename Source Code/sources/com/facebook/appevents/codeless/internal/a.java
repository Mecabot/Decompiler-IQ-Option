package com.facebook.appevents.codeless.internal;

import com.google.firebase.analytics.FirebaseAnalytics.b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ParameterComponent */
public final class a {
    public final List<PathComponent> Ae;
    public final String Ag;
    public final String name;
    public final String value;

    public a(JSONObject jSONObject) {
        this.name = jSONObject.getString("name");
        this.value = jSONObject.optString(b.VALUE);
        List arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("path");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                arrayList.add(new PathComponent(optJSONArray.getJSONObject(i)));
            }
        }
        this.Ae = arrayList;
        this.Ag = jSONObject.optString("path_type", "absolute");
    }
}
