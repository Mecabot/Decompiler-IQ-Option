package com.facebook.internal;

import com.facebook.FacebookRequestError.Category;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: FacebookRequestErrorClassification */
public final class h {
    private static h Ct;
    private final Map<Integer, Set<Integer>> Cn;
    private final Map<Integer, Set<Integer>> Co;
    private final Map<Integer, Set<Integer>> Cp;
    private final String Cq;
    private final String Cr;
    private final String Cs;

    h(Map<Integer, Set<Integer>> map, Map<Integer, Set<Integer>> map2, Map<Integer, Set<Integer>> map3, String str, String str2, String str3) {
        this.Cn = map;
        this.Co = map2;
        this.Cp = map3;
        this.Cq = str;
        this.Cr = str2;
        this.Cs = str3;
    }

    public String a(Category category) {
        switch (category) {
            case OTHER:
                return this.Cq;
            case LOGIN_RECOVERABLE:
                return this.Cs;
            case TRANSIENT:
                return this.Cr;
            default:
                return null;
        }
    }

    public Category a(int i, int i2, boolean z) {
        if (z) {
            return Category.TRANSIENT;
        }
        Set set;
        if (this.Cn != null && this.Cn.containsKey(Integer.valueOf(i))) {
            set = (Set) this.Cn.get(Integer.valueOf(i));
            if (set == null || set.contains(Integer.valueOf(i2))) {
                return Category.OTHER;
            }
        }
        if (this.Cp != null && this.Cp.containsKey(Integer.valueOf(i))) {
            set = (Set) this.Cp.get(Integer.valueOf(i));
            if (set == null || set.contains(Integer.valueOf(i2))) {
                return Category.LOGIN_RECOVERABLE;
            }
        }
        if (this.Co != null && this.Co.containsKey(Integer.valueOf(i))) {
            Set set2 = (Set) this.Co.get(Integer.valueOf(i));
            if (set2 == null || set2.contains(Integer.valueOf(i2))) {
                return Category.TRANSIENT;
            }
        }
        return Category.OTHER;
    }

    public static synchronized h lB() {
        h hVar;
        synchronized (h.class) {
            if (Ct == null) {
                Ct = lC();
            }
            hVar = Ct;
        }
        return hVar;
    }

    private static h lC() {
        return new h(null, new FacebookRequestErrorClassification$1(), new FacebookRequestErrorClassification$2(), null, null, null);
    }

    private static Map<Integer, Set<Integer>> h(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("items");
        if (optJSONArray.length() == 0) {
            return null;
        }
        Map<Integer, Set<Integer>> hashMap = new HashMap();
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                int optInt = optJSONObject.optInt("code");
                if (optInt != 0) {
                    Object obj;
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray("subcodes");
                    if (optJSONArray2 == null || optJSONArray2.length() <= 0) {
                        obj = null;
                    } else {
                        obj = new HashSet();
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            int optInt2 = optJSONArray2.optInt(i2);
                            if (optInt2 != 0) {
                                obj.add(Integer.valueOf(optInt2));
                            }
                        }
                    }
                    hashMap.put(Integer.valueOf(optInt), obj);
                }
            }
        }
        return hashMap;
    }

    public static h d(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        Map map = null;
        Map map2 = map;
        Map map3 = map2;
        String str = map3;
        String str2 = str;
        String str3 = str2;
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("name");
                if (optString != null) {
                    if (optString.equalsIgnoreCase("other")) {
                        str = optJSONObject.optString("recovery_message", null);
                        map = h(optJSONObject);
                    } else if (optString.equalsIgnoreCase("transient")) {
                        str2 = optJSONObject.optString("recovery_message", null);
                        map2 = h(optJSONObject);
                    } else if (optString.equalsIgnoreCase("login_recoverable")) {
                        str3 = optJSONObject.optString("recovery_message", null);
                        map3 = h(optJSONObject);
                    }
                }
            }
        }
        return new h(map, map2, map3, str, str2, str3);
    }
}
