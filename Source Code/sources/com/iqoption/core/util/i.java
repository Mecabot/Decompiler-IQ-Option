package com.iqoption.core.util;

import android.support.annotation.NonNull;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: JsonUtils */
public final class i {

    /* compiled from: JsonUtils */
    static class a {
        static Boolean l(JsonElement jsonElement) {
            if (jsonElement != null) {
                try {
                    if (jsonElement.isJsonPrimitive()) {
                        return Boolean.valueOf(jsonElement.getAsJsonPrimitive().getAsBoolean());
                    }
                } catch (NumberFormatException unused) {
                    return null;
                }
            }
        }

        static Double c(JsonElement jsonElement) {
            if (jsonElement != null) {
                try {
                    if (jsonElement.isJsonPrimitive()) {
                        return Double.valueOf(jsonElement.getAsJsonPrimitive().getAsDouble());
                    }
                } catch (NumberFormatException unused) {
                    return null;
                }
            }
        }

        static Integer m(JsonElement jsonElement) {
            if (jsonElement != null) {
                try {
                    if (jsonElement.isJsonPrimitive()) {
                        return Integer.valueOf((int) jsonElement.getAsJsonPrimitive().getAsDouble());
                    }
                } catch (NumberFormatException unused) {
                    return null;
                }
            }
        }

        static Long d(JsonElement jsonElement) {
            if (jsonElement != null) {
                try {
                    if (jsonElement.isJsonPrimitive()) {
                        return Long.valueOf((long) jsonElement.getAsJsonPrimitive().getAsDouble());
                    }
                } catch (NumberFormatException unused) {
                    return null;
                }
            }
        }

        static String n(JsonElement jsonElement) {
            if (jsonElement != null) {
                try {
                    if (jsonElement.isJsonPrimitive()) {
                        return jsonElement.getAsJsonPrimitive().getAsString();
                    }
                } catch (NumberFormatException unused) {
                    return null;
                }
            }
        }
    }

    /* compiled from: JsonUtils */
    public static class b {
        private final JsonObject bgR;

        public static b aaa() {
            return new b();
        }

        private b() {
            this(new JsonObject());
        }

        private b(JsonObject jsonObject) {
            this.bgR = jsonObject;
        }

        public <T> b l(String str, T t) {
            a(this.bgR, str, (Object) t);
            return this;
        }

        public <T> b c(String str, List<T> list) {
            a(this.bgR, str, (List) list);
            return this;
        }

        public JsonObject aab() {
            return this.bgR;
        }

        private static <T> void a(JsonObject jsonObject, String str, T t) {
            if (t != null) {
                b(jsonObject, str, t);
            }
        }

        private static <T> void b(JsonObject jsonObject, String str, T t) {
            if (t == null) {
                jsonObject.add(str, null);
            } else if (t instanceof Character) {
                jsonObject.addProperty(str, (Character) t);
            } else if (t instanceof Number) {
                jsonObject.addProperty(str, (Number) t);
            } else if (t instanceof Boolean) {
                jsonObject.addProperty(str, (Boolean) t);
            } else {
                jsonObject.addProperty(str, t.toString());
            }
        }

        private static <T> void a(JsonObject jsonObject, String str, List<T> list) {
            JsonElement jsonArray = new JsonArray();
            for (Object next : list) {
                if (next != null) {
                    if (next instanceof Character) {
                        jsonArray.add((Character) next);
                        return;
                    } else if (next instanceof Number) {
                        jsonArray.add((Number) next);
                    } else if (next instanceof Boolean) {
                        jsonArray.add((Boolean) next);
                    } else {
                        jsonArray.add(next.toString());
                    }
                }
            }
            jsonObject.add(str, jsonArray);
        }
    }

    public static b ZZ() {
        return b.aaa();
    }

    public static Double c(JsonElement jsonElement) {
        return a.c(jsonElement);
    }

    public static Long d(JsonElement jsonElement) {
        return a.d(jsonElement);
    }

    public static double e(JsonElement jsonElement) {
        return a(jsonElement, 0.0d);
    }

    public static double a(JsonElement jsonElement, double d) {
        Double c = a.c(jsonElement);
        return c != null ? c.doubleValue() : d;
    }

    public static long f(JsonElement jsonElement) {
        return a(jsonElement, 0);
    }

    public static long a(JsonElement jsonElement, long j) {
        Long d = a.d(jsonElement);
        return d != null ? d.longValue() : j;
    }

    public static int g(JsonElement jsonElement) {
        return a(jsonElement, 0);
    }

    public static int a(JsonElement jsonElement, int i) {
        Integer m = a.m(jsonElement);
        return m != null ? m.intValue() : i;
    }

    public static boolean h(JsonElement jsonElement) {
        return a(jsonElement, false);
    }

    public static boolean a(JsonElement jsonElement, boolean z) {
        Boolean l = a.l(jsonElement);
        return l != null ? l.booleanValue() : z;
    }

    public static String i(JsonElement jsonElement) {
        return a(jsonElement, "");
    }

    public static String a(JsonElement jsonElement, String str) {
        String n = a.n(jsonElement);
        return n != null ? n : str;
    }

    private static JsonObject j(JsonElement jsonElement) {
        return (jsonElement == null || !jsonElement.isJsonObject()) ? null : jsonElement.getAsJsonObject();
    }

    public static JsonElement b(JsonElement jsonElement, String str) {
        JsonObject j = j(jsonElement);
        return j != null ? j.get(str) : null;
    }

    /* JADX WARNING: Missing block: B:50:0x0074, code:
            return r1;
     */
    public static java.lang.Object wrap(java.lang.Object r1) {
        /*
        if (r1 != 0) goto L_0x0005;
    L_0x0002:
        r1 = org.json.JSONObject.NULL;
        return r1;
    L_0x0005:
        r0 = r1 instanceof org.json.JSONArray;
        if (r0 != 0) goto L_0x0074;
    L_0x0009:
        r0 = r1 instanceof org.json.JSONObject;
        if (r0 == 0) goto L_0x000e;
    L_0x000d:
        goto L_0x0074;
    L_0x000e:
        r0 = org.json.JSONObject.NULL;
        r0 = r1.equals(r0);
        if (r0 == 0) goto L_0x0017;
    L_0x0016:
        return r1;
    L_0x0017:
        r0 = r1 instanceof com.google.gson.JsonElement;
        if (r0 == 0) goto L_0x0022;
    L_0x001b:
        r1 = (com.google.gson.JsonElement) r1;
        r1 = k(r1);
        return r1;
    L_0x0022:
        r0 = r1 instanceof java.util.Collection;	 Catch:{ Exception -> 0x0072 }
        if (r0 == 0) goto L_0x002d;
    L_0x0026:
        r1 = (java.util.Collection) r1;	 Catch:{ Exception -> 0x0072 }
        r1 = D(r1);	 Catch:{ Exception -> 0x0072 }
        return r1;
    L_0x002d:
        r0 = r1.getClass();	 Catch:{ Exception -> 0x0072 }
        r0 = r0.isArray();	 Catch:{ Exception -> 0x0072 }
        if (r0 == 0) goto L_0x003c;
    L_0x0037:
        r1 = bp(r1);	 Catch:{ Exception -> 0x0072 }
        return r1;
    L_0x003c:
        r0 = r1 instanceof java.util.Map;	 Catch:{ Exception -> 0x0072 }
        if (r0 == 0) goto L_0x0047;
    L_0x0040:
        r1 = (java.util.Map) r1;	 Catch:{ Exception -> 0x0072 }
        r1 = w(r1);	 Catch:{ Exception -> 0x0072 }
        return r1;
    L_0x0047:
        r0 = r1 instanceof java.lang.Boolean;	 Catch:{ Exception -> 0x0072 }
        if (r0 != 0) goto L_0x0071;
    L_0x004b:
        r0 = r1 instanceof java.lang.Byte;	 Catch:{ Exception -> 0x0072 }
        if (r0 != 0) goto L_0x0071;
    L_0x004f:
        r0 = r1 instanceof java.lang.Character;	 Catch:{ Exception -> 0x0072 }
        if (r0 != 0) goto L_0x0071;
    L_0x0053:
        r0 = r1 instanceof java.lang.Double;	 Catch:{ Exception -> 0x0072 }
        if (r0 != 0) goto L_0x0071;
    L_0x0057:
        r0 = r1 instanceof java.lang.Float;	 Catch:{ Exception -> 0x0072 }
        if (r0 != 0) goto L_0x0071;
    L_0x005b:
        r0 = r1 instanceof java.lang.Integer;	 Catch:{ Exception -> 0x0072 }
        if (r0 != 0) goto L_0x0071;
    L_0x005f:
        r0 = r1 instanceof java.lang.Long;	 Catch:{ Exception -> 0x0072 }
        if (r0 != 0) goto L_0x0071;
    L_0x0063:
        r0 = r1 instanceof java.lang.Short;	 Catch:{ Exception -> 0x0072 }
        if (r0 != 0) goto L_0x0071;
    L_0x0067:
        r0 = r1 instanceof java.lang.String;	 Catch:{ Exception -> 0x0072 }
        if (r0 == 0) goto L_0x006c;
    L_0x006b:
        goto L_0x0071;
    L_0x006c:
        r1 = r1.toString();	 Catch:{ Exception -> 0x0072 }
        return r1;
    L_0x0071:
        return r1;
    L_0x0072:
        r1 = 0;
        return r1;
    L_0x0074:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.core.util.i.wrap(java.lang.Object):java.lang.Object");
    }

    private static Object k(@NonNull JsonElement jsonElement) {
        if (jsonElement.isJsonObject()) {
            try {
                return new JSONObject(jsonElement.toString());
            } catch (Exception unused) {
                return JSONObject.NULL;
            }
        } else if (jsonElement.isJsonArray()) {
            return new JSONArray(jsonElement.toString());
        } else {
            if (jsonElement.isJsonPrimitive()) {
                JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
                if (asJsonPrimitive.isBoolean()) {
                    return Boolean.valueOf(asJsonPrimitive.getAsBoolean());
                }
                if (asJsonPrimitive.isNumber()) {
                    return asJsonPrimitive.getAsNumber();
                }
                return asJsonPrimitive.getAsString();
            }
        }
    }

    private static JSONArray D(@NonNull Collection collection) {
        JSONArray jSONArray = new JSONArray();
        for (Object wrap : collection) {
            jSONArray.put(wrap(wrap));
        }
        return jSONArray;
    }

    private static JSONArray bp(@NonNull Object obj) {
        JSONArray jSONArray = new JSONArray();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            jSONArray.put(wrap(Array.get(obj, i)));
        }
        return jSONArray;
    }

    /* JADX WARNING: Can't wrap try/catch for R(4:7|8|9|15) */
    /* JADX WARNING: Missing block: B:2:0x0011, code:
            if (r3.hasNext() != false) goto L_0x0013;
     */
    /* JADX WARNING: Missing block: B:3:0x0013, code:
            r1 = (java.util.Map.Entry) r3.next();
            r2 = java.lang.String.valueOf(r1.getKey());
     */
    /* JADX WARNING: Missing block: B:4:0x0021, code:
            if (r2 == null) goto L_0x0023;
     */
    /* JADX WARNING: Missing block: B:6:0x002a, code:
            throw new java.lang.NullPointerException("key == null");
     */
    /* JADX WARNING: Missing block: B:8:?, code:
            r0.put(r2, wrap(r1.getValue()));
     */
    /* JADX WARNING: Missing block: B:10:0x0037, code:
            return r0;
     */
    private static org.json.JSONObject w(@android.support.annotation.NonNull java.util.Map r3) {
        /*
        r0 = new org.json.JSONObject;
        r0.<init>();
        r3 = r3.entrySet();
        r3 = r3.iterator();
    L_0x000d:
        r1 = r3.hasNext();
        if (r1 == 0) goto L_0x0037;
    L_0x0013:
        r1 = r3.next();
        r1 = (java.util.Map.Entry) r1;
        r2 = r1.getKey();
        r2 = java.lang.String.valueOf(r2);
        if (r2 != 0) goto L_0x002b;
    L_0x0023:
        r3 = new java.lang.NullPointerException;
        r0 = "key == null";
        r3.<init>(r0);
        throw r3;
    L_0x002b:
        r1 = r1.getValue();	 Catch:{ Exception -> 0x000d }
        r1 = wrap(r1);	 Catch:{ Exception -> 0x000d }
        r0.put(r2, r1);	 Catch:{ Exception -> 0x000d }
        goto L_0x000d;
    L_0x0037:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.core.util.i.w(java.util.Map):org.json.JSONObject");
    }
}
