package com.google.firebase.messaging;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzflr;
import com.google.android.gms.internal.zzfmv;
import com.google.android.gms.measurement.AppMeasurement;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@Hide
public final class e {
    private static Bundle R(@NonNull String str, @NonNull String str2) {
        Bundle bundle = new Bundle();
        bundle.putString(str, str2);
        return bundle;
    }

    @Nullable
    private static Object a(@NonNull zzfmv zzfmv, @NonNull String str, @NonNull d dVar) {
        Throwable e;
        Object obj = null;
        Object newInstance;
        try {
            Class cls = Class.forName("com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty");
            Bundle R = R(zzfmv.zzpzs, zzfmv.zzpzt);
            newInstance = cls.getConstructor(new Class[0]).newInstance(new Object[0]);
            try {
                cls.getField("mOrigin").set(newInstance, str);
                cls.getField("mCreationTimestamp").set(newInstance, Long.valueOf(zzfmv.zzpzu));
                cls.getField("mName").set(newInstance, zzfmv.zzpzs);
                cls.getField("mValue").set(newInstance, zzfmv.zzpzt);
                if (!TextUtils.isEmpty(zzfmv.zzpzv)) {
                    obj = zzfmv.zzpzv;
                }
                cls.getField("mTriggerEventName").set(newInstance, obj);
                cls.getField("mTimedOutEventName").set(newInstance, !TextUtils.isEmpty(zzfmv.zzqaa) ? zzfmv.zzqaa : dVar.wX());
                cls.getField("mTimedOutEventParams").set(newInstance, R);
                cls.getField("mTriggerTimeout").set(newInstance, Long.valueOf(zzfmv.zzpzw));
                cls.getField("mTriggeredEventName").set(newInstance, !TextUtils.isEmpty(zzfmv.zzpzy) ? zzfmv.zzpzy : dVar.wW());
                cls.getField("mTriggeredEventParams").set(newInstance, R);
                cls.getField("mTimeToLive").set(newInstance, Long.valueOf(zzfmv.zzgoc));
                cls.getField("mExpiredEventName").set(newInstance, !TextUtils.isEmpty(zzfmv.zzqab) ? zzfmv.zzqab : dVar.wY());
                cls.getField("mExpiredEventParams").set(newInstance, R);
                return newInstance;
            } catch (Exception e2) {
                e = e2;
                Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e);
                return newInstance;
            }
        } catch (Exception e3) {
            e = e3;
            newInstance = null;
            Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e);
            return newInstance;
        }
    }

    private static String a(@Nullable zzfmv zzfmv, @NonNull d dVar) {
        return (zzfmv == null || TextUtils.isEmpty(zzfmv.zzpzz)) ? dVar.wZ() : zzfmv.zzpzz;
    }

    private static List<Object> a(@NonNull AppMeasurement appMeasurement, @NonNull String str) {
        List<Object> list;
        ArrayList arrayList = new ArrayList();
        try {
            Method declaredMethod = AppMeasurement.class.getDeclaredMethod("getConditionalUserProperties", new Class[]{String.class, String.class});
            declaredMethod.setAccessible(true);
            list = (List) declaredMethod.invoke(appMeasurement, new Object[]{str, ""});
        } catch (Throwable e) {
            Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e);
            list = arrayList;
        }
        if (Log.isLoggable("FirebaseAbtUtil", 2)) {
            int size = list.size();
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 55);
            stringBuilder.append("Number of currently set _Es for origin: ");
            stringBuilder.append(str);
            stringBuilder.append(" is ");
            stringBuilder.append(size);
            Log.v("FirebaseAbtUtil", stringBuilder.toString());
        }
        return list;
    }

    private static void a(@NonNull Context context, @NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4) {
        if (Log.isLoggable("FirebaseAbtUtil", 2)) {
            String str5 = "FirebaseAbtUtil";
            String str6 = "_CE(experimentId) called by ";
            str = String.valueOf(str);
            Log.v(str5, str.length() != 0 ? str6.concat(str) : new String(str6));
        }
        if (aF(context)) {
            AppMeasurement aE = aE(context);
            try {
                Method declaredMethod = AppMeasurement.class.getDeclaredMethod("clearConditionalUserProperty", new Class[]{String.class, String.class, Bundle.class});
                declaredMethod.setAccessible(true);
                if (Log.isLoggable("FirebaseAbtUtil", 2)) {
                    StringBuilder stringBuilder = new StringBuilder((String.valueOf(str2).length() + 17) + String.valueOf(str3).length());
                    stringBuilder.append("Clearing _E: [");
                    stringBuilder.append(str2);
                    stringBuilder.append(", ");
                    stringBuilder.append(str3);
                    stringBuilder.append("]");
                    Log.v("FirebaseAbtUtil", stringBuilder.toString());
                }
                declaredMethod.invoke(aE, new Object[]{str2, str4, R(str2, str3)});
            } catch (Throwable e) {
                Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x01ba A:{Catch:{ Exception -> 0x0211 }} */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0125 A:{Catch:{ Exception -> 0x0211 }} */
    public static void a(@android.support.annotation.NonNull android.content.Context r17, @android.support.annotation.NonNull java.lang.String r18, @android.support.annotation.NonNull byte[] r19, @android.support.annotation.NonNull com.google.firebase.messaging.d r20, int r21) {
        /*
        r3 = r18;
        r1 = "FirebaseAbtUtil";
        r2 = 2;
        r1 = android.util.Log.isLoggable(r1, r2);
        if (r1 == 0) goto L_0x0027;
    L_0x000b:
        r1 = "FirebaseAbtUtil";
        r4 = "_SE called by ";
        r5 = java.lang.String.valueOf(r18);
        r6 = r5.length();
        if (r6 == 0) goto L_0x001e;
    L_0x0019:
        r4 = r4.concat(r5);
        goto L_0x0024;
    L_0x001e:
        r5 = new java.lang.String;
        r5.<init>(r4);
        r4 = r5;
    L_0x0024:
        android.util.Log.v(r1, r4);
    L_0x0027:
        r1 = aF(r17);
        if (r1 != 0) goto L_0x002e;
    L_0x002d:
        return;
    L_0x002e:
        r1 = aE(r17);
        r4 = n(r19);
        if (r4 != 0) goto L_0x0048;
    L_0x0038:
        r1 = "FirebaseAbtUtil";
        r1 = android.util.Log.isLoggable(r1, r2);
        if (r1 == 0) goto L_0x0047;
    L_0x0040:
        r1 = "FirebaseAbtUtil";
        r2 = "_SE failed; either _P was not set, or we couldn't deserialize the _P.";
        android.util.Log.v(r1, r2);
    L_0x0047:
        return;
    L_0x0048:
        r5 = "com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty";
        java.lang.Class.forName(r5);	 Catch:{ Exception -> 0x0211 }
        r5 = a(r1, r3);	 Catch:{ Exception -> 0x0211 }
        r5 = r5.iterator();	 Catch:{ Exception -> 0x0211 }
        r7 = 0;
        r8 = 0;
    L_0x0057:
        r9 = r5.hasNext();	 Catch:{ Exception -> 0x0211 }
        if (r9 == 0) goto L_0x01c0;
    L_0x005d:
        r9 = r5.next();	 Catch:{ Exception -> 0x0211 }
        r10 = aS(r9);	 Catch:{ Exception -> 0x0211 }
        r11 = aT(r9);	 Catch:{ Exception -> 0x0211 }
        r12 = "com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty";
        r12 = java.lang.Class.forName(r12);	 Catch:{ Exception -> 0x0211 }
        r13 = "mCreationTimestamp";
        r12 = r12.getField(r13);	 Catch:{ Exception -> 0x0211 }
        r9 = r12.get(r9);	 Catch:{ Exception -> 0x0211 }
        r9 = (java.lang.Long) r9;	 Catch:{ Exception -> 0x0211 }
        r12 = r9.longValue();	 Catch:{ Exception -> 0x0211 }
        r9 = r4.zzpzs;	 Catch:{ Exception -> 0x0211 }
        r9 = r9.equals(r10);	 Catch:{ Exception -> 0x0211 }
        if (r9 == 0) goto L_0x00cf;
    L_0x0087:
        r9 = r4.zzpzt;	 Catch:{ Exception -> 0x0211 }
        r9 = r9.equals(r11);	 Catch:{ Exception -> 0x0211 }
        if (r9 == 0) goto L_0x00cf;
    L_0x008f:
        r8 = "FirebaseAbtUtil";
        r8 = android.util.Log.isLoggable(r8, r2);	 Catch:{ Exception -> 0x0211 }
        if (r8 == 0) goto L_0x00cd;
    L_0x0097:
        r8 = "FirebaseAbtUtil";
        r9 = java.lang.String.valueOf(r10);	 Catch:{ Exception -> 0x0211 }
        r9 = r9.length();	 Catch:{ Exception -> 0x0211 }
        r9 = r9 + 23;
        r12 = java.lang.String.valueOf(r11);	 Catch:{ Exception -> 0x0211 }
        r12 = r12.length();	 Catch:{ Exception -> 0x0211 }
        r9 = r9 + r12;
        r12 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0211 }
        r12.<init>(r9);	 Catch:{ Exception -> 0x0211 }
        r9 = "_E is already set. [";
        r12.append(r9);	 Catch:{ Exception -> 0x0211 }
        r12.append(r10);	 Catch:{ Exception -> 0x0211 }
        r9 = ", ";
        r12.append(r9);	 Catch:{ Exception -> 0x0211 }
        r12.append(r11);	 Catch:{ Exception -> 0x0211 }
        r9 = "]";
        r12.append(r9);	 Catch:{ Exception -> 0x0211 }
        r9 = r12.toString();	 Catch:{ Exception -> 0x0211 }
        android.util.Log.v(r8, r9);	 Catch:{ Exception -> 0x0211 }
    L_0x00cd:
        r8 = 1;
        goto L_0x0057;
    L_0x00cf:
        r9 = r4.zzqad;	 Catch:{ Exception -> 0x0211 }
        r14 = r9.length;	 Catch:{ Exception -> 0x0211 }
        r15 = 0;
    L_0x00d3:
        if (r15 >= r14) goto L_0x0122;
    L_0x00d5:
        r6 = r9[r15];	 Catch:{ Exception -> 0x0211 }
        r6 = r6.zzpzs;	 Catch:{ Exception -> 0x0211 }
        r6 = r6.equals(r10);	 Catch:{ Exception -> 0x0211 }
        if (r6 == 0) goto L_0x011f;
    L_0x00df:
        r6 = "FirebaseAbtUtil";
        r6 = android.util.Log.isLoggable(r6, r2);	 Catch:{ Exception -> 0x0211 }
        if (r6 == 0) goto L_0x011d;
    L_0x00e7:
        r6 = "FirebaseAbtUtil";
        r9 = java.lang.String.valueOf(r10);	 Catch:{ Exception -> 0x0211 }
        r9 = r9.length();	 Catch:{ Exception -> 0x0211 }
        r9 = r9 + 33;
        r14 = java.lang.String.valueOf(r11);	 Catch:{ Exception -> 0x0211 }
        r14 = r14.length();	 Catch:{ Exception -> 0x0211 }
        r9 = r9 + r14;
        r14 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0211 }
        r14.<init>(r9);	 Catch:{ Exception -> 0x0211 }
        r9 = "_E is found in the _OE list. [";
        r14.append(r9);	 Catch:{ Exception -> 0x0211 }
        r14.append(r10);	 Catch:{ Exception -> 0x0211 }
        r9 = ", ";
        r14.append(r9);	 Catch:{ Exception -> 0x0211 }
        r14.append(r11);	 Catch:{ Exception -> 0x0211 }
        r9 = "]";
        r14.append(r9);	 Catch:{ Exception -> 0x0211 }
        r9 = r14.toString();	 Catch:{ Exception -> 0x0211 }
        android.util.Log.v(r6, r9);	 Catch:{ Exception -> 0x0211 }
    L_0x011d:
        r6 = 1;
        goto L_0x0123;
    L_0x011f:
        r15 = r15 + 1;
        goto L_0x00d3;
    L_0x0122:
        r6 = 0;
    L_0x0123:
        if (r6 != 0) goto L_0x01ba;
    L_0x0125:
        r14 = r4.zzpzu;	 Catch:{ Exception -> 0x0211 }
        r6 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1));
        if (r6 <= 0) goto L_0x0176;
    L_0x012b:
        r6 = "FirebaseAbtUtil";
        r6 = android.util.Log.isLoggable(r6, r2);	 Catch:{ Exception -> 0x0211 }
        if (r6 == 0) goto L_0x0169;
    L_0x0133:
        r6 = "FirebaseAbtUtil";
        r9 = java.lang.String.valueOf(r10);	 Catch:{ Exception -> 0x0211 }
        r9 = r9.length();	 Catch:{ Exception -> 0x0211 }
        r9 = r9 + 115;
        r12 = java.lang.String.valueOf(r11);	 Catch:{ Exception -> 0x0211 }
        r12 = r12.length();	 Catch:{ Exception -> 0x0211 }
        r9 = r9 + r12;
        r12 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0211 }
        r12.<init>(r9);	 Catch:{ Exception -> 0x0211 }
        r9 = "Clearing _E as it was not in the _OE list, andits start time is older than the start time of the _E to be set. [";
        r12.append(r9);	 Catch:{ Exception -> 0x0211 }
        r12.append(r10);	 Catch:{ Exception -> 0x0211 }
        r9 = ", ";
        r12.append(r9);	 Catch:{ Exception -> 0x0211 }
        r12.append(r11);	 Catch:{ Exception -> 0x0211 }
        r9 = "]";
        r12.append(r9);	 Catch:{ Exception -> 0x0211 }
        r9 = r12.toString();	 Catch:{ Exception -> 0x0211 }
        android.util.Log.v(r6, r9);	 Catch:{ Exception -> 0x0211 }
    L_0x0169:
        r6 = r20;
        r9 = a(r4, r6);	 Catch:{ Exception -> 0x0211 }
        r12 = r17;
        a(r12, r3, r10, r11, r9);	 Catch:{ Exception -> 0x0211 }
        goto L_0x0057;
    L_0x0176:
        r12 = r17;
        r6 = r20;
        r9 = "FirebaseAbtUtil";
        r9 = android.util.Log.isLoggable(r9, r2);	 Catch:{ Exception -> 0x0211 }
        if (r9 == 0) goto L_0x0057;
    L_0x0182:
        r9 = "FirebaseAbtUtil";
        r13 = java.lang.String.valueOf(r10);	 Catch:{ Exception -> 0x0211 }
        r13 = r13.length();	 Catch:{ Exception -> 0x0211 }
        r13 = r13 + 109;
        r14 = java.lang.String.valueOf(r11);	 Catch:{ Exception -> 0x0211 }
        r14 = r14.length();	 Catch:{ Exception -> 0x0211 }
        r13 = r13 + r14;
        r14 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0211 }
        r14.<init>(r13);	 Catch:{ Exception -> 0x0211 }
        r13 = "_E was not found in the _OE list, but not clearing it as it has a new start time than the _E to be set.  [";
        r14.append(r13);	 Catch:{ Exception -> 0x0211 }
        r14.append(r10);	 Catch:{ Exception -> 0x0211 }
        r10 = ", ";
        r14.append(r10);	 Catch:{ Exception -> 0x0211 }
        r14.append(r11);	 Catch:{ Exception -> 0x0211 }
        r10 = "]";
        r14.append(r10);	 Catch:{ Exception -> 0x0211 }
        r10 = r14.toString();	 Catch:{ Exception -> 0x0211 }
        android.util.Log.v(r9, r10);	 Catch:{ Exception -> 0x0211 }
        goto L_0x0057;
    L_0x01ba:
        r12 = r17;
        r6 = r20;
        goto L_0x0057;
    L_0x01c0:
        r12 = r17;
        r6 = r20;
        if (r8 == 0) goto L_0x0209;
    L_0x01c6:
        r1 = "FirebaseAbtUtil";
        r1 = android.util.Log.isLoggable(r1, r2);	 Catch:{ Exception -> 0x0211 }
        if (r1 == 0) goto L_0x0208;
    L_0x01ce:
        r1 = "FirebaseAbtUtil";
        r2 = r4.zzpzs;	 Catch:{ Exception -> 0x0211 }
        r3 = r4.zzpzt;	 Catch:{ Exception -> 0x0211 }
        r4 = java.lang.String.valueOf(r2);	 Catch:{ Exception -> 0x0211 }
        r4 = r4.length();	 Catch:{ Exception -> 0x0211 }
        r4 = r4 + 44;
        r5 = java.lang.String.valueOf(r3);	 Catch:{ Exception -> 0x0211 }
        r5 = r5.length();	 Catch:{ Exception -> 0x0211 }
        r4 = r4 + r5;
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0211 }
        r5.<init>(r4);	 Catch:{ Exception -> 0x0211 }
        r4 = "_E is already set. Not setting it again [";
        r5.append(r4);	 Catch:{ Exception -> 0x0211 }
        r5.append(r2);	 Catch:{ Exception -> 0x0211 }
        r2 = ", ";
        r5.append(r2);	 Catch:{ Exception -> 0x0211 }
        r5.append(r3);	 Catch:{ Exception -> 0x0211 }
        r2 = "]";
        r5.append(r2);	 Catch:{ Exception -> 0x0211 }
        r2 = r5.toString();	 Catch:{ Exception -> 0x0211 }
        android.util.Log.v(r1, r2);	 Catch:{ Exception -> 0x0211 }
    L_0x0208:
        return;
    L_0x0209:
        r7 = 1;
        r2 = r12;
        r5 = r6;
        r6 = r7;
        a(r1, r2, r3, r4, r5, r6);	 Catch:{ Exception -> 0x0211 }
        return;
    L_0x0211:
        r0 = move-exception;
        r1 = r0;
        r2 = "FirebaseAbtUtil";
        r3 = "Could not complete the operation due to an internal error.";
        android.util.Log.e(r2, r3, r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.e.a(android.content.Context, java.lang.String, byte[], com.google.firebase.messaging.d, int):void");
    }

    private static void a(@NonNull AppMeasurement appMeasurement, @NonNull Context context, @NonNull String str, @NonNull zzfmv zzfmv, @NonNull d dVar, int i) {
        String str2;
        String str3;
        if (Log.isLoggable("FirebaseAbtUtil", 2)) {
            str2 = zzfmv.zzpzs;
            str3 = zzfmv.zzpzt;
            StringBuilder stringBuilder = new StringBuilder((String.valueOf(str2).length() + 7) + String.valueOf(str3).length());
            stringBuilder.append("_SEI: ");
            stringBuilder.append(str2);
            stringBuilder.append(" ");
            stringBuilder.append(str3);
            Log.v("FirebaseAbtUtil", stringBuilder.toString());
        }
        try {
            Object obj;
            StringBuilder stringBuilder2;
            String str4;
            StringBuilder stringBuilder3;
            Class.forName("com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty");
            List a = a(appMeasurement, str);
            if (a(appMeasurement, str).size() >= b(appMeasurement, str)) {
                if ((zzfmv.zzqac != 0 ? zzfmv.zzqac : 1) == 1) {
                    obj = a.get(0);
                    str3 = aS(obj);
                    str2 = aT(obj);
                    if (Log.isLoggable("FirebaseAbtUtil", 2)) {
                        stringBuilder2 = new StringBuilder(String.valueOf(str3).length() + 38);
                        stringBuilder2.append("Clearing _E due to overflow policy: [");
                        stringBuilder2.append(str3);
                        stringBuilder2.append("]");
                        Log.v("FirebaseAbtUtil", stringBuilder2.toString());
                    }
                    a(context, str, str3, str2, a(zzfmv, dVar));
                } else {
                    if (Log.isLoggable("FirebaseAbtUtil", 2)) {
                        str4 = zzfmv.zzpzs;
                        str = zzfmv.zzpzt;
                        stringBuilder3 = new StringBuilder((String.valueOf(str4).length() + 44) + String.valueOf(str).length());
                        stringBuilder3.append("_E won't be set due to overflow policy. [");
                        stringBuilder3.append(str4);
                        stringBuilder3.append(", ");
                        stringBuilder3.append(str);
                        stringBuilder3.append("]");
                        Log.v("FirebaseAbtUtil", stringBuilder3.toString());
                    }
                    return;
                }
            }
            for (Object obj2 : a) {
                str3 = aS(obj2);
                str2 = aT(obj2);
                if (str3.equals(zzfmv.zzpzs) && !str2.equals(zzfmv.zzpzt) && Log.isLoggable("FirebaseAbtUtil", 2)) {
                    stringBuilder2 = new StringBuilder((String.valueOf(str3).length() + 77) + String.valueOf(str2).length());
                    stringBuilder2.append("Clearing _E, as only one _V of the same _E can be set atany given time: [");
                    stringBuilder2.append(str3);
                    stringBuilder2.append(", ");
                    stringBuilder2.append(str2);
                    stringBuilder2.append("].");
                    Log.v("FirebaseAbtUtil", stringBuilder2.toString());
                    a(context, str, str3, str2, a(zzfmv, dVar));
                }
            }
            if (a(zzfmv, str, dVar) == null) {
                if (Log.isLoggable("FirebaseAbtUtil", 2)) {
                    str4 = zzfmv.zzpzs;
                    str = zzfmv.zzpzt;
                    stringBuilder3 = new StringBuilder((String.valueOf(str4).length() + 42) + String.valueOf(str).length());
                    stringBuilder3.append("Could not create _CUP for: [");
                    stringBuilder3.append(str4);
                    stringBuilder3.append(", ");
                    stringBuilder3.append(str);
                    stringBuilder3.append("]. Skipping.");
                    Log.v("FirebaseAbtUtil", stringBuilder3.toString());
                }
                return;
            }
            try {
                Method declaredMethod = AppMeasurement.class.getDeclaredMethod("setConditionalUserProperty", new Class[]{Class.forName("com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty")});
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(appMeasurement, new Object[]{r9});
            } catch (Throwable e) {
                Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e);
            }
        } catch (Throwable e2) {
            Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e2);
        }
    }

    @Nullable
    private static AppMeasurement aE(Context context) {
        try {
            return AppMeasurement.getInstance(context);
        } catch (NoClassDefFoundError unused) {
            return null;
        }
    }

    private static boolean aF(Context context) {
        if (aE(context) == null) {
            if (Log.isLoggable("FirebaseAbtUtil", 2)) {
                Log.v("FirebaseAbtUtil", "Firebase Analytics not available");
            }
            return false;
        }
        try {
            Class.forName("com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty");
            return true;
        } catch (ClassNotFoundException unused) {
            if (Log.isLoggable("FirebaseAbtUtil", 2)) {
                Log.v("FirebaseAbtUtil", "Firebase Analytics library is missing support for abt. Please update to a more recent version.");
            }
            return false;
        }
    }

    private static String aS(@NonNull Object obj) {
        return (String) Class.forName("com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty").getField("mName").get(obj);
    }

    private static String aT(@NonNull Object obj) {
        return (String) Class.forName("com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty").getField("mValue").get(obj);
    }

    private static int b(@NonNull AppMeasurement appMeasurement, @NonNull String str) {
        try {
            Method declaredMethod = AppMeasurement.class.getDeclaredMethod("getMaxUserProperties", new Class[]{String.class});
            declaredMethod.setAccessible(true);
            return ((Integer) declaredMethod.invoke(appMeasurement, new Object[]{str})).intValue();
        } catch (Throwable e) {
            Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e);
            return 20;
        }
    }

    @Nullable
    private static zzfmv n(@NonNull byte[] bArr) {
        try {
            return zzfmv.zzbi(bArr);
        } catch (zzflr unused) {
            return null;
        }
    }
}
