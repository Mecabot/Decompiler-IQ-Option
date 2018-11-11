package com.jumio.commons.json;

import org.json.JSONException;

public class JSON {
    static StringBuilder toStringBuilder(Object obj) {
        return obj instanceof StringBuilder ? (StringBuilder) obj : null;
    }

    public static JSONException typeMismatch(Object obj, Object obj2, String str) {
        if (obj2 == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Value at ");
            stringBuilder.append(obj);
            stringBuilder.append(" is null.");
            throw new JSONException(stringBuilder.toString());
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Value ");
        stringBuilder2.append(obj2);
        stringBuilder2.append(" at ");
        stringBuilder2.append(obj);
        stringBuilder2.append(" of type ");
        stringBuilder2.append(obj2.getClass().getName());
        stringBuilder2.append(" cannot be converted to ");
        stringBuilder2.append(str);
        throw new JSONException(stringBuilder2.toString());
    }

    public static JSONException typeMismatch(Object obj, String str) {
        if (obj == null) {
            throw new JSONException("Value is null.");
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Value ");
        stringBuilder.append(obj);
        stringBuilder.append(" of type ");
        stringBuilder.append(obj.getClass().getName());
        stringBuilder.append(" cannot be converted to ");
        stringBuilder.append(str);
        throw new JSONException(stringBuilder.toString());
    }
}
