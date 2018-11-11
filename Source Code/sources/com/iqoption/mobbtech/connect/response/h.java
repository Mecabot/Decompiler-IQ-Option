package com.iqoption.mobbtech.connect.response;

import android.util.Pair;
import com.iqoption.dto.AbstractEntity;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: MobbResponse */
public class h {
    private JSONObject cVP;
    private Object tag;

    public h(JSONObject jSONObject) {
        this.cVP = jSONObject;
    }

    public static List<AbstractEntity> a(Class cls, JSONArray jSONArray) {
        List<AbstractEntity> arrayList = new ArrayList();
        for (Entry key : b(cls, jSONArray).entrySet()) {
            arrayList.add(key.getKey());
        }
        return arrayList;
    }

    public static Map<AbstractEntity, List<String>> b(Class cls, JSONArray jSONArray) {
        List arrayList = new ArrayList();
        a(arrayList, cls);
        Map<AbstractEntity, List<String>> linkedHashMap = new LinkedHashMap();
        try {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                Pair a = a(cls, jSONArray.getJSONObject(i), arrayList);
                linkedHashMap.put((AbstractEntity) a.first, a.second);
            }
        } catch (JSONException unused) {
            return linkedHashMap;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x0122 A:{Splitter: B:1:0x000f, ExcHandler: java.lang.InstantiationException (unused java.lang.InstantiationException)} */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0122 A:{Splitter: B:1:0x000f, ExcHandler: java.lang.InstantiationException (unused java.lang.InstantiationException)} */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0122 A:{Splitter: B:1:0x000f, ExcHandler: java.lang.InstantiationException (unused java.lang.InstantiationException)} */
    /* JADX WARNING: Missing block: B:50:?, code:
            return new android.util.Pair(new java.lang.Object(), new java.util.ArrayList());
     */
    private static android.util.Pair<java.lang.Object, java.util.List<java.lang.String>> a(java.lang.Class r7, org.json.JSONObject r8, java.util.List<java.lang.reflect.Field> r9) {
        /*
        r0 = new android.util.Pair;
        r1 = new java.lang.Object;
        r1.<init>();
        r2 = new java.util.ArrayList;
        r2.<init>();
        r0.<init>(r1, r2);
        r7 = r7.newInstance();	 Catch:{ InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122 }
        r1 = new java.util.ArrayList;	 Catch:{ InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122 }
        r1.<init>();	 Catch:{ InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122 }
        r9 = r9.iterator();	 Catch:{ InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122 }
    L_0x001c:
        r2 = r9.hasNext();	 Catch:{ InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122 }
        if (r2 == 0) goto L_0x011c;
    L_0x0022:
        r2 = r9.next();	 Catch:{ InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122 }
        r2 = (java.lang.reflect.Field) r2;	 Catch:{ InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122 }
        r3 = r2.getModifiers();	 Catch:{ InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122 }
        r3 = java.lang.reflect.Modifier.isStatic(r3);	 Catch:{ InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122 }
        if (r3 == 0) goto L_0x0033;
    L_0x0032:
        goto L_0x001c;
    L_0x0033:
        r3 = r2.getName();	 Catch:{ InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122 }
        r3 = r8.has(r3);	 Catch:{ InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122 }
        if (r3 == 0) goto L_0x001c;
    L_0x003d:
        r3 = r2.getName();	 Catch:{ InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122 }
        r3 = r8.isNull(r3);	 Catch:{ InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122 }
        if (r3 != 0) goto L_0x001c;
    L_0x0047:
        r3 = 1;
        r2.setAccessible(r3);	 Catch:{ InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122 }
        r3 = r2.getType();	 Catch:{ InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122 }
        r4 = java.lang.Integer.class;
        r4 = r3.equals(r4);	 Catch:{ InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122 }
        if (r4 != 0) goto L_0x0104;
    L_0x0057:
        r4 = java.lang.Integer.TYPE;	 Catch:{ InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122 }
        r4 = r3.equals(r4);	 Catch:{ InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122 }
        if (r4 == 0) goto L_0x0061;
    L_0x005f:
        goto L_0x0104;
    L_0x0061:
        r4 = java.lang.Long.class;
        r4 = r3.equals(r4);	 Catch:{ InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122 }
        if (r4 != 0) goto L_0x00f4;
    L_0x0069:
        r4 = java.lang.Long.TYPE;	 Catch:{ InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122 }
        r4 = r3.equals(r4);	 Catch:{ InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122 }
        if (r4 == 0) goto L_0x0073;
    L_0x0071:
        goto L_0x00f4;
    L_0x0073:
        r4 = java.lang.Double.class;
        r4 = r3.equals(r4);	 Catch:{ InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122 }
        if (r4 != 0) goto L_0x00e4;
    L_0x007b:
        r4 = java.lang.Double.TYPE;	 Catch:{ InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122 }
        r4 = r3.equals(r4);	 Catch:{ InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122 }
        if (r4 == 0) goto L_0x0084;
    L_0x0083:
        goto L_0x00e4;
    L_0x0084:
        r4 = java.lang.String.class;
        r3 = r3.equals(r4);	 Catch:{ InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122 }
        if (r3 == 0) goto L_0x009d;
    L_0x008c:
        r3 = r2.getName();	 Catch:{ InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122 }
        r3 = r8.get(r3);	 Catch:{ InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122 }
        r3 = r3.toString();	 Catch:{ InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122 }
        r2.set(r7, r3);	 Catch:{ InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122 }
        goto L_0x0113;
    L_0x009d:
        r3 = r2.getType();	 Catch:{ InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122 }
        r4 = java.util.Collection.class;
        r3 = r3.equals(r4);	 Catch:{ InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122 }
        if (r3 == 0) goto L_0x00aa;
    L_0x00a9:
        goto L_0x0113;
    L_0x00aa:
        r3 = r2.getType();	 Catch:{ InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122 }
        r4 = java.util.List.class;
        r3 = r3.equals(r4);	 Catch:{ InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122 }
        if (r3 == 0) goto L_0x00d8;
    L_0x00b6:
        r3 = r2.getName();	 Catch:{ InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122 }
        r3 = r8.getJSONArray(r3);	 Catch:{ InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122 }
        r4 = new java.util.ArrayList;	 Catch:{ InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122 }
        r4.<init>();	 Catch:{ InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122 }
        r5 = 0;
    L_0x00c4:
        r6 = r3.length();	 Catch:{ InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122 }
        if (r5 >= r6) goto L_0x00d4;
    L_0x00ca:
        r6 = r3.get(r5);	 Catch:{ InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122 }
        r4.add(r6);	 Catch:{ InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122 }
        r5 = r5 + 1;
        goto L_0x00c4;
    L_0x00d4:
        r2.set(r7, r4);	 Catch:{ InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122 }
        goto L_0x0113;
    L_0x00d8:
        r3 = r2.getName();	 Catch:{ InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122 }
        r3 = r8.get(r3);	 Catch:{ InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122 }
        r2.set(r7, r3);	 Catch:{ InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122 }
        goto L_0x0113;
    L_0x00e4:
        r3 = r2.getName();	 Catch:{ InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122 }
        r3 = r8.getDouble(r3);	 Catch:{ InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122 }
        r3 = java.lang.Double.valueOf(r3);	 Catch:{ InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122 }
        r2.set(r7, r3);	 Catch:{ InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122 }
        goto L_0x0113;
    L_0x00f4:
        r3 = r2.getName();	 Catch:{ InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122 }
        r3 = r8.getLong(r3);	 Catch:{ InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122 }
        r3 = java.lang.Long.valueOf(r3);	 Catch:{ InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122 }
        r2.set(r7, r3);	 Catch:{ InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122 }
        goto L_0x0113;
    L_0x0104:
        r3 = r2.getName();	 Catch:{ InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122 }
        r3 = r8.getInt(r3);	 Catch:{ InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122 }
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122 }
        r2.set(r7, r3);	 Catch:{ InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122 }
    L_0x0113:
        r2 = r2.getName();	 Catch:{ InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122 }
        r1.add(r2);	 Catch:{ InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122 }
        goto L_0x001c;
    L_0x011c:
        r8 = new android.util.Pair;	 Catch:{ InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122 }
        r8.<init>(r7, r1);	 Catch:{ InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122, InstantiationException -> 0x0122 }
        goto L_0x0123;
    L_0x0122:
        r8 = r0;
    L_0x0123:
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.mobbtech.connect.response.h.a(java.lang.Class, org.json.JSONObject, java.util.List):android.util.Pair<java.lang.Object, java.util.List<java.lang.String>>");
    }

    public JSONObject auV() {
        return this.cVP;
    }

    private static List<Field> a(List<Field> list, Class<?> cls) {
        for (Object add : cls.getDeclaredFields()) {
            list.add(add);
        }
        return cls.getSuperclass() != null ? a((List) list, cls.getSuperclass()) : list;
    }

    public void setTag(Object obj) {
        this.tag = obj;
    }
}
