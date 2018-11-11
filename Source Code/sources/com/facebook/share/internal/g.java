package com.facebook.share.internal;

import android.support.annotation.Nullable;
import com.facebook.share.a.f;
import com.facebook.share.a.h;
import com.facebook.share.a.j;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: OpenGraphJSONUtility */
public final class g {

    /* compiled from: OpenGraphJSONUtility */
    public interface a {
        JSONObject a(j jVar);
    }

    public static JSONObject a(f fVar, a aVar) {
        JSONObject jSONObject = new JSONObject();
        for (String str : fVar.keySet()) {
            jSONObject.put(str, a(fVar.get(str), aVar));
        }
        return jSONObject;
    }

    private static JSONObject a(h hVar, a aVar) {
        JSONObject jSONObject = new JSONObject();
        for (String str : hVar.keySet()) {
            jSONObject.put(str, a(hVar.get(str), aVar));
        }
        return jSONObject;
    }

    private static JSONArray a(List list, a aVar) {
        JSONArray jSONArray = new JSONArray();
        for (Object a : list) {
            jSONArray.put(a(a, aVar));
        }
        return jSONArray;
    }

    public static Object a(@Nullable Object obj, a aVar) {
        if (obj == null) {
            return JSONObject.NULL;
        }
        if ((obj instanceof String) || (obj instanceof Boolean) || (obj instanceof Double) || (obj instanceof Float) || (obj instanceof Integer) || (obj instanceof Long)) {
            return obj;
        }
        if (obj instanceof j) {
            return aVar != null ? aVar.a((j) obj) : null;
        } else {
            if (obj instanceof h) {
                return a((h) obj, aVar);
            }
            if (obj instanceof List) {
                return a((List) obj, aVar);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid object found for JSON serialization: ");
            stringBuilder.append(obj.toString());
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }
}
