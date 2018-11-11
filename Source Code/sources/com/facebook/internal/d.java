package com.facebook.internal;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: BundleJSONConverter */
public class d {
    private static final Map<Class<?>, a> Cf = new HashMap();

    /* compiled from: BundleJSONConverter */
    public interface a {
        void a(Bundle bundle, String str, Object obj);

        void a(JSONObject jSONObject, String str, Object obj);
    }

    static {
        Cf.put(Boolean.class, new a() {
            public void a(Bundle bundle, String str, Object obj) {
                bundle.putBoolean(str, ((Boolean) obj).booleanValue());
            }

            public void a(JSONObject jSONObject, String str, Object obj) {
                jSONObject.put(str, obj);
            }
        });
        Cf.put(Integer.class, new a() {
            public void a(Bundle bundle, String str, Object obj) {
                bundle.putInt(str, ((Integer) obj).intValue());
            }

            public void a(JSONObject jSONObject, String str, Object obj) {
                jSONObject.put(str, obj);
            }
        });
        Cf.put(Long.class, new a() {
            public void a(Bundle bundle, String str, Object obj) {
                bundle.putLong(str, ((Long) obj).longValue());
            }

            public void a(JSONObject jSONObject, String str, Object obj) {
                jSONObject.put(str, obj);
            }
        });
        Cf.put(Double.class, new a() {
            public void a(Bundle bundle, String str, Object obj) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            }

            public void a(JSONObject jSONObject, String str, Object obj) {
                jSONObject.put(str, obj);
            }
        });
        Cf.put(String.class, new a() {
            public void a(Bundle bundle, String str, Object obj) {
                bundle.putString(str, (String) obj);
            }

            public void a(JSONObject jSONObject, String str, Object obj) {
                jSONObject.put(str, obj);
            }
        });
        Cf.put(String[].class, new a() {
            public void a(Bundle bundle, String str, Object obj) {
                throw new IllegalArgumentException("Unexpected type from JSON");
            }

            public void a(JSONObject jSONObject, String str, Object obj) {
                JSONArray jSONArray = new JSONArray();
                for (Object put : (String[]) obj) {
                    jSONArray.put(put);
                }
                jSONObject.put(str, jSONArray);
            }
        });
        Cf.put(JSONArray.class, new a() {
            public void a(Bundle bundle, String str, Object obj) {
                JSONArray jSONArray = (JSONArray) obj;
                ArrayList arrayList = new ArrayList();
                if (jSONArray.length() == 0) {
                    bundle.putStringArrayList(str, arrayList);
                    return;
                }
                int i = 0;
                while (i < jSONArray.length()) {
                    Object obj2 = jSONArray.get(i);
                    if (obj2 instanceof String) {
                        arrayList.add((String) obj2);
                        i++;
                    } else {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Unexpected type in an array: ");
                        stringBuilder.append(obj2.getClass());
                        throw new IllegalArgumentException(stringBuilder.toString());
                    }
                }
                bundle.putStringArrayList(str, arrayList);
            }

            public void a(JSONObject jSONObject, String str, Object obj) {
                throw new IllegalArgumentException("JSONArray's are not supported in bundles.");
            }
        });
    }

    public static JSONObject g(Bundle bundle) {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj != null) {
                if (obj instanceof List) {
                    JSONArray jSONArray = new JSONArray();
                    for (String put : (List) obj) {
                        jSONArray.put(put);
                    }
                    jSONObject.put(str, jSONArray);
                } else if (obj instanceof Bundle) {
                    jSONObject.put(str, g((Bundle) obj));
                } else {
                    a aVar = (a) Cf.get(obj.getClass());
                    if (aVar == null) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Unsupported type: ");
                        stringBuilder.append(obj.getClass());
                        throw new IllegalArgumentException(stringBuilder.toString());
                    }
                    aVar.a(jSONObject, str, obj);
                }
            }
        }
        return jSONObject;
    }

    public static Bundle g(JSONObject jSONObject) {
        Bundle bundle = new Bundle();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            Object obj = jSONObject.get(str);
            if (obj != null) {
                if (obj != JSONObject.NULL) {
                    if (obj instanceof JSONObject) {
                        bundle.putBundle(str, g((JSONObject) obj));
                    } else {
                        a aVar = (a) Cf.get(obj.getClass());
                        if (aVar == null) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Unsupported type: ");
                            stringBuilder.append(obj.getClass());
                            throw new IllegalArgumentException(stringBuilder.toString());
                        }
                        aVar.a(bundle, str, obj);
                    }
                }
            }
        }
        return bundle;
    }
}
