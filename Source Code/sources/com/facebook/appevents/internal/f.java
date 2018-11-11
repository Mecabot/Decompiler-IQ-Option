package com.facebook.appevents.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import com.facebook.h;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

/* compiled from: InAppPurchaseEventManager */
class f {
    private static final HashMap<String, Method> Bg = new HashMap();
    private static final HashMap<String, Class<?>> Bh = new HashMap();
    private static final SharedPreferences Bi = h.getApplicationContext().getSharedPreferences("com.facebook.internal.SKU_DETAILS", 0);
    private static final SharedPreferences Bj = h.getApplicationContext().getSharedPreferences("com.facebook.internal.PURCHASE", 0);
    private static final SharedPreferences Bk = h.getApplicationContext().getSharedPreferences("com.facebook.internal.PURCHASE_SUBS", 0);
    private static final String PACKAGE_NAME = h.getApplicationContext().getPackageName();
    private static final String TAG = f.class.getCanonicalName();

    f() {
    }

    @Nullable
    public static Object a(Context context, IBinder iBinder) {
        return a(context, "com.android.vending.billing.IInAppBillingService$Stub", "asInterface", null, new Object[]{iBinder});
    }

    public static Map<String, String> a(Context context, ArrayList<String> arrayList, Object obj, boolean z) {
        Map<String, String> c = c(arrayList);
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!c.containsKey(str)) {
                arrayList2.add(str);
            }
        }
        c.putAll(b(context, arrayList2, obj, z));
        return c;
    }

    private static Map<String, String> b(Context context, ArrayList<String> arrayList, Object obj, boolean z) {
        Map<String, String> hashMap = new HashMap();
        if (obj == null || arrayList.isEmpty()) {
            return hashMap;
        }
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("ITEM_ID_LIST", arrayList);
        Object[] objArr = new Object[4];
        int i = 0;
        objArr[0] = Integer.valueOf(3);
        objArr[1] = PACKAGE_NAME;
        objArr[2] = z ? "subs" : "inapp";
        objArr[3] = bundle;
        Object a = a(context, "com.android.vending.billing.IInAppBillingService", "getSkuDetails", obj, objArr);
        if (a != null) {
            Bundle bundle2 = (Bundle) a;
            if (bundle2.getInt("RESPONSE_CODE") == 0) {
                ArrayList stringArrayList = bundle2.getStringArrayList("DETAILS_LIST");
                if (stringArrayList != null && arrayList.size() == stringArrayList.size()) {
                    while (i < arrayList.size()) {
                        hashMap.put(arrayList.get(i), stringArrayList.get(i));
                        i++;
                    }
                }
                l(hashMap);
            }
        }
        return hashMap;
    }

    private static Map<String, String> c(ArrayList<String> arrayList) {
        Map<String, String> hashMap = new HashMap();
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            String string = Bi.getString(str, null);
            if (string != null) {
                String[] split = string.split(";", 2);
                if (currentTimeMillis - Long.parseLong(split[0]) < 43200) {
                    hashMap.put(str, split[1]);
                }
            }
        }
        return hashMap;
    }

    private static void l(Map<String, String> map) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        Editor edit = Bi.edit();
        for (Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(currentTimeMillis);
            stringBuilder.append(";");
            stringBuilder.append((String) entry.getValue());
            edit.putString(str, stringBuilder.toString());
        }
        edit.apply();
    }

    private static Boolean a(Context context, Object obj, String str) {
        boolean z = false;
        if (obj == null) {
            return Boolean.valueOf(false);
        }
        Object a = a(context, "com.android.vending.billing.IInAppBillingService", "isBillingSupported", obj, new Object[]{Integer.valueOf(3), PACKAGE_NAME, str});
        if (a != null && ((Integer) a).intValue() == 0) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    public static ArrayList<String> a(Context context, Object obj) {
        return d(b(context, obj, "inapp"));
    }

    public static ArrayList<String> b(Context context, Object obj) {
        ArrayList<String> arrayList = new ArrayList();
        Map all = Bk.getAll();
        if (all.isEmpty()) {
            return arrayList;
        }
        String str;
        ArrayList b = b(context, obj, "subs");
        Set hashSet = new HashSet();
        Iterator it = b.iterator();
        while (it.hasNext()) {
            try {
                hashSet.add(new JSONObject((String) it.next()).getString("productId"));
            } catch (Throwable e) {
                Log.e(TAG, "Error parsing purchase json", e);
            }
        }
        Set<String> hashSet2 = new HashSet();
        for (Entry key : all.entrySet()) {
            str = (String) key.getKey();
            if (!hashSet.contains(str)) {
                hashSet2.add(str);
            }
        }
        Editor edit = Bk.edit();
        for (String str2 : hashSet2) {
            str = Bk.getString(str2, "");
            edit.remove(str2);
            if (!str.isEmpty()) {
                arrayList.add(Bk.getString(str2, ""));
            }
        }
        edit.apply();
        return arrayList;
    }

    public static Map<String, SubscriptionType> c(Context context, Object obj) {
        Map<String, SubscriptionType> hashMap = new HashMap();
        Iterator it = b(context, obj, "subs").iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            SubscriptionType bw = bw(str);
            if (!(bw == SubscriptionType.DUPLICATED || bw == SubscriptionType.UNKNOWN)) {
                hashMap.put(str, bw);
            }
        }
        return hashMap;
    }

    private static SubscriptionType bw(String str) {
        SubscriptionType subscriptionType = null;
        try {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            JSONObject jSONObject = new JSONObject(str);
            str = jSONObject.getString("productId");
            String string = Bk.getString(str, "");
            JSONObject jSONObject2 = string.isEmpty() ? new JSONObject() : new JSONObject(string);
            if (!jSONObject2.optString("purchaseToken").equals(jSONObject.get("purchaseToken"))) {
                subscriptionType = currentTimeMillis - (jSONObject.getLong("purchaseTime") / 1000) < 43200 ? SubscriptionType.NEW : SubscriptionType.HEARTBEAT;
            }
            if (subscriptionType == null && !string.isEmpty()) {
                boolean z = jSONObject2.getBoolean("autoRenewing");
                boolean z2 = jSONObject.getBoolean("autoRenewing");
                if (!z2 && z) {
                    subscriptionType = SubscriptionType.CANCEL;
                } else if (!z && z2) {
                    subscriptionType = SubscriptionType.RESTORE;
                }
            }
            if (subscriptionType == null && !string.isEmpty()) {
                if (currentTimeMillis - jSONObject2.getLong("LAST_LOGGED_TIME_SEC") > 86400) {
                    subscriptionType = SubscriptionType.HEARTBEAT;
                } else {
                    subscriptionType = SubscriptionType.DUPLICATED;
                }
            }
            if (subscriptionType != SubscriptionType.DUPLICATED) {
                jSONObject.put("LAST_LOGGED_TIME_SEC", currentTimeMillis);
                Bk.edit().putString(str, jSONObject.toString()).apply();
            }
            return subscriptionType;
        } catch (Throwable e) {
            Log.e(TAG, "parsing purchase failure: ", e);
            return SubscriptionType.UNKNOWN;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x005c A:{SYNTHETIC, EDGE_INSN: B:19:0x005c->B:17:0x005c ?: BREAK  } */
    private static java.util.ArrayList<java.lang.String> b(android.content.Context r9, java.lang.Object r10, java.lang.String r11) {
        /*
        r0 = new java.util.ArrayList;
        r0.<init>();
        if (r10 != 0) goto L_0x0008;
    L_0x0007:
        return r0;
    L_0x0008:
        r1 = a(r9, r10, r11);
        r1 = r1.booleanValue();
        if (r1 == 0) goto L_0x005c;
    L_0x0012:
        r1 = 0;
        r2 = 0;
        r3 = r2;
        r4 = 0;
    L_0x0016:
        r5 = 4;
        r5 = new java.lang.Object[r5];
        r6 = 3;
        r7 = java.lang.Integer.valueOf(r6);
        r5[r1] = r7;
        r7 = 1;
        r8 = PACKAGE_NAME;
        r5[r7] = r8;
        r7 = 2;
        r5[r7] = r11;
        r5[r6] = r3;
        r3 = "com.android.vending.billing.IInAppBillingService";
        r6 = "getPurchases";
        r3 = a(r9, r3, r6, r10, r5);
        if (r3 == 0) goto L_0x0055;
    L_0x0034:
        r3 = (android.os.Bundle) r3;
        r5 = "RESPONSE_CODE";
        r5 = r3.getInt(r5);
        if (r5 != 0) goto L_0x0055;
    L_0x003e:
        r5 = "INAPP_PURCHASE_DATA_LIST";
        r5 = r3.getStringArrayList(r5);
        if (r5 == 0) goto L_0x005c;
    L_0x0046:
        r6 = r5.size();
        r4 = r4 + r6;
        r0.addAll(r5);
        r5 = "INAPP_CONTINUATION_TOKEN";
        r3 = r3.getString(r5);
        goto L_0x0056;
    L_0x0055:
        r3 = r2;
    L_0x0056:
        r5 = 30;
        if (r4 >= r5) goto L_0x005c;
    L_0x005a:
        if (r3 != 0) goto L_0x0016;
    L_0x005c:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.internal.f.b(android.content.Context, java.lang.Object, java.lang.String):java.util.ArrayList<java.lang.String>");
    }

    public static ArrayList<String> d(Context context, Object obj) {
        ArrayList<String> arrayList = new ArrayList();
        if (obj == null) {
            return arrayList;
        }
        Class p = p(context, "com.android.vending.billing.IInAppBillingService");
        if (p == null || b(p, "getPurchaseHistory") == null) {
            return arrayList;
        }
        return d(c(context, obj, "inapp"));
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00b3 A:{LOOP_END, LOOP:0: B:3:0x0017->B:33:0x00b3} */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b6 A:{SYNTHETIC, EDGE_INSN: B:37:0x00b6->B:34:0x00b6 ?: BREAK  } */
    private static java.util.ArrayList<java.lang.String> c(android.content.Context r21, java.lang.Object r22, java.lang.String r23) {
        /*
        r1 = new java.util.ArrayList;
        r1.<init>();
        r2 = a(r21, r22, r23);
        r2 = r2.booleanValue();
        if (r2 == 0) goto L_0x00b6;
    L_0x000f:
        r2 = 0;
        r3 = java.lang.Boolean.valueOf(r2);
        r5 = r3;
        r3 = 0;
        r6 = 0;
    L_0x0017:
        r7 = 5;
        r7 = new java.lang.Object[r7];
        r8 = 6;
        r8 = java.lang.Integer.valueOf(r8);
        r7[r2] = r8;
        r8 = PACKAGE_NAME;
        r9 = 1;
        r7[r9] = r8;
        r8 = 2;
        r7[r8] = r23;
        r8 = 3;
        r7[r8] = r3;
        r3 = 4;
        r8 = new android.os.Bundle;
        r8.<init>();
        r7[r3] = r8;
        r3 = "com.android.vending.billing.IInAppBillingService";
        r8 = "getPurchaseHistory";
        r10 = r21;
        r11 = r22;
        r3 = a(r10, r3, r8, r11, r7);
        if (r3 == 0) goto L_0x00a5;
    L_0x0042:
        r7 = java.lang.System.currentTimeMillis();
        r12 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r7 = r7 / r12;
        r3 = (android.os.Bundle) r3;
        r14 = "RESPONSE_CODE";
        r14 = r3.getInt(r14);
        if (r14 != 0) goto L_0x00a5;
    L_0x0053:
        r14 = "INAPP_PURCHASE_DATA_LIST";
        r14 = r3.getStringArrayList(r14);
        r14 = r14.iterator();
    L_0x005d:
        r15 = r14.hasNext();
        if (r15 == 0) goto L_0x009c;
    L_0x0063:
        r15 = r14.next();
        r2 = r15;
        r2 = (java.lang.String) r2;
        r4 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x008f }
        r4.<init>(r2);	 Catch:{ JSONException -> 0x008f }
        r9 = "purchaseTime";
        r16 = r4.getLong(r9);	 Catch:{ JSONException -> 0x008f }
        r16 = r16 / r12;
        r4 = 0;
        r18 = r7 - r16;
        r16 = 1200; // 0x4b0 float:1.682E-42 double:5.93E-321;
        r4 = (r18 > r16 ? 1 : (r18 == r16 ? 0 : -1));
        if (r4 <= 0) goto L_0x0088;
    L_0x0080:
        r4 = 1;
        r2 = java.lang.Boolean.valueOf(r4);	 Catch:{ JSONException -> 0x0086 }
        goto L_0x009d;
    L_0x0086:
        r0 = move-exception;
        goto L_0x0091;
    L_0x0088:
        r4 = 1;
        r1.add(r2);	 Catch:{ JSONException -> 0x0086 }
        r6 = r6 + 1;
        goto L_0x0099;
    L_0x008f:
        r0 = move-exception;
        r4 = 1;
    L_0x0091:
        r2 = r0;
        r9 = TAG;
        r4 = "parsing purchase failure: ";
        android.util.Log.e(r9, r4, r2);
    L_0x0099:
        r2 = 0;
        r9 = 1;
        goto L_0x005d;
    L_0x009c:
        r2 = r5;
    L_0x009d:
        r4 = "INAPP_CONTINUATION_TOKEN";
        r3 = r3.getString(r4);
        r5 = r2;
        goto L_0x00a6;
    L_0x00a5:
        r3 = 0;
    L_0x00a6:
        r2 = 30;
        if (r6 >= r2) goto L_0x00b6;
    L_0x00aa:
        if (r3 == 0) goto L_0x00b6;
    L_0x00ac:
        r2 = r5.booleanValue();
        if (r2 == 0) goto L_0x00b3;
    L_0x00b2:
        goto L_0x00b6;
    L_0x00b3:
        r2 = 0;
        goto L_0x0017;
    L_0x00b6:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.internal.f.c(android.content.Context, java.lang.Object, java.lang.String):java.util.ArrayList<java.lang.String>");
    }

    private static ArrayList<String> d(ArrayList<String> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList();
        Editor edit = Bj.edit();
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            try {
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString("productId");
                long j = jSONObject.getLong("purchaseTime");
                String string2 = jSONObject.getString("purchaseToken");
                if (currentTimeMillis - (j / 1000) <= 43200) {
                    if (!Bj.getString(string, "").equals(string2)) {
                        edit.putString(string, string2);
                        arrayList2.add(str);
                    }
                }
            } catch (Throwable e) {
                Log.e(TAG, "parsing purchase failure: ", e);
            }
        }
        edit.apply();
        return arrayList2;
    }

    @Nullable
    private static Method b(Class<?> cls, String str) {
        Throwable e;
        String str2;
        StringBuilder stringBuilder;
        Method method = (Method) Bg.get(str);
        if (method != null) {
            return method;
        }
        Class[] clsArr = null;
        Object obj = -1;
        try {
            switch (str.hashCode()) {
                case -1801122596:
                    if (str.equals("getPurchases")) {
                        obj = 3;
                        break;
                    }
                    break;
                case -1450694211:
                    if (str.equals("isBillingSupported")) {
                        obj = 2;
                        break;
                    }
                    break;
                case -1123215065:
                    if (str.equals("asInterface")) {
                        obj = null;
                        break;
                    }
                    break;
                case -594356707:
                    if (str.equals("getPurchaseHistory")) {
                        obj = 4;
                        break;
                    }
                    break;
                case -573310373:
                    if (str.equals("getSkuDetails")) {
                        obj = 1;
                        break;
                    }
                    break;
            }
            switch (obj) {
                case null:
                    clsArr = new Class[]{IBinder.class};
                    break;
                case 1:
                    clsArr = new Class[]{Integer.TYPE, String.class, String.class, Bundle.class};
                    break;
                case 2:
                    clsArr = new Class[]{Integer.TYPE, String.class, String.class};
                    break;
                case 3:
                    clsArr = new Class[]{Integer.TYPE, String.class, String.class, String.class};
                    break;
                case 4:
                    clsArr = new Class[]{Integer.TYPE, String.class, String.class, String.class, Bundle.class};
                    break;
            }
            Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
            try {
                Bg.put(str, declaredMethod);
                method = declaredMethod;
            } catch (Throwable e2) {
                Method method2 = declaredMethod;
                e = e2;
                method = method2;
                str2 = TAG;
                stringBuilder = new StringBuilder();
                stringBuilder.append(cls.getName());
                stringBuilder.append(".");
                stringBuilder.append(str);
                stringBuilder.append(" method not found");
                Log.e(str2, stringBuilder.toString(), e);
                return method;
            }
        } catch (NoSuchMethodException e3) {
            e = e3;
            str2 = TAG;
            stringBuilder = new StringBuilder();
            stringBuilder.append(cls.getName());
            stringBuilder.append(".");
            stringBuilder.append(str);
            stringBuilder.append(" method not found");
            Log.e(str2, stringBuilder.toString(), e);
            return method;
        }
        return method;
    }

    @Nullable
    private static Class<?> p(Context context, String str) {
        Throwable e;
        Class<?> cls = (Class) Bh.get(str);
        if (cls != null) {
            return cls;
        }
        Class<?> loadClass;
        try {
            loadClass = context.getClassLoader().loadClass(str);
            try {
                Bh.put(str, loadClass);
            } catch (Throwable e2) {
                Throwable th = e2;
                cls = loadClass;
                e = th;
            }
        } catch (ClassNotFoundException e3) {
            e = e3;
            String str2 = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(" is not available, please add ");
            stringBuilder.append(str);
            stringBuilder.append(" to the project.");
            Log.e(str2, stringBuilder.toString(), e);
            loadClass = cls;
            return loadClass;
        }
        return loadClass;
    }

    @Nullable
    private static Object a(Context context, String str, String str2, Object obj, Object[] objArr) {
        String str3;
        StringBuilder stringBuilder;
        Class p = p(context, str);
        if (p == null) {
            return null;
        }
        Method b = b(p, str2);
        if (b == null) {
            return null;
        }
        if (obj != null) {
            obj = p.cast(obj);
        }
        try {
            return b.invoke(obj, objArr);
        } catch (Throwable e) {
            str3 = TAG;
            stringBuilder = new StringBuilder();
            stringBuilder.append("Illegal access to method ");
            stringBuilder.append(p.getName());
            stringBuilder.append(".");
            stringBuilder.append(b.getName());
            Log.e(str3, stringBuilder.toString(), e);
            return null;
        } catch (Throwable e2) {
            str3 = TAG;
            stringBuilder = new StringBuilder();
            stringBuilder.append("Invocation target exception in ");
            stringBuilder.append(p.getName());
            stringBuilder.append(".");
            stringBuilder.append(b.getName());
            Log.e(str3, stringBuilder.toString(), e2);
            return null;
        }
    }

    public static void lf() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        long j = Bi.getLong("LAST_CLEARED_TIME", 0);
        if (j == 0) {
            Bi.edit().putLong("LAST_CLEARED_TIME", currentTimeMillis).apply();
        } else if (currentTimeMillis - j > 604800) {
            Bi.edit().clear().putLong("LAST_CLEARED_TIME", currentTimeMillis).apply();
        }
    }
}
