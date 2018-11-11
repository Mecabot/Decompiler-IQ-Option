package com.facebook.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcel;
import android.os.StatFs;
import android.support.v4.app.NotificationCompat;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.view.autofill.AutofillManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.facebook.FacebookException;
import com.facebook.HttpMethod;
import com.facebook.h;
import com.facebook.i;
import com.facebook.l;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

/* compiled from: Utility */
public final class w {
    private static String EA = "NoCarrier";
    private static int Eu = 0;
    private static long Ev = -1;
    private static long Ew = -1;
    private static long Ex = -1;
    private static String Ey = "";
    private static String Ez = "";

    /* compiled from: Utility */
    public interface a {
        void c(FacebookException facebookException);

        void e(JSONObject jSONObject);
    }

    /* compiled from: Utility */
    public static class b {
        List<String> EF;
        List<String> EI;

        public b(List<String> list, List<String> list2) {
            this.EF = list;
            this.EI = list2;
        }

        public List<String> mA() {
            return this.EF;
        }

        public List<String> mB() {
            return this.EI;
        }
    }

    public static <T> boolean c(Collection<T> collection) {
        return collection == null || collection.size() == 0;
    }

    public static boolean bc(String str) {
        return str == null || str.length() == 0;
    }

    public static String C(String str, String str2) {
        return bc(str) ? str2 : str;
    }

    public static <T> Collection<T> a(T... tArr) {
        return Collections.unmodifiableCollection(Arrays.asList(tArr));
    }

    public static String bN(String str) {
        return D("MD5", str);
    }

    public static String l(byte[] bArr) {
        return c("SHA-1", bArr);
    }

    private static String D(String str, String str2) {
        return c(str, str2.getBytes());
    }

    private static String c(String str, byte[] bArr) {
        try {
            return a(MessageDigest.getInstance(str), bArr);
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    private static String a(MessageDigest messageDigest, byte[] bArr) {
        messageDigest.update(bArr);
        byte[] digest = messageDigest.digest();
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : digest) {
            stringBuilder.append(Integer.toHexString((b >> 4) & 15));
            stringBuilder.append(Integer.toHexString((b >> 0) & 15));
        }
        return stringBuilder.toString();
    }

    public static Uri b(String str, String str2, Bundle bundle) {
        Builder builder = new Builder();
        builder.scheme("https");
        builder.authority(str);
        builder.path(str2);
        if (bundle != null) {
            for (String str22 : bundle.keySet()) {
                Object obj = bundle.get(str22);
                if (obj instanceof String) {
                    builder.appendQueryParameter(str22, (String) obj);
                }
            }
        }
        return builder.build();
    }

    public static Bundle bO(String str) {
        Bundle bundle = new Bundle();
        if (!bc(str)) {
            for (String split : str.split("&")) {
                String[] split2 = split.split("=");
                try {
                    if (split2.length == 2) {
                        bundle.putString(URLDecoder.decode(split2[0], "UTF-8"), URLDecoder.decode(split2[1], "UTF-8"));
                    } else if (split2.length == 1) {
                        bundle.putString(URLDecoder.decode(split2[0], "UTF-8"), "");
                    }
                } catch (Exception e) {
                    a("FacebookSDK", e);
                }
            }
        }
        return bundle;
    }

    public static void b(Bundle bundle, String str, String str2) {
        if (!bc(str2)) {
            bundle.putString(str, str2);
        }
    }

    public static void a(Bundle bundle, String str, Uri uri) {
        if (uri != null) {
            b(bundle, str, uri.toString());
        }
    }

    public static boolean b(Bundle bundle, String str, Object obj) {
        if (obj == null) {
            bundle.remove(str);
        } else if (obj instanceof Boolean) {
            bundle.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof boolean[]) {
            bundle.putBooleanArray(str, (boolean[]) obj);
        } else if (obj instanceof Double) {
            bundle.putDouble(str, ((Double) obj).doubleValue());
        } else if (obj instanceof double[]) {
            bundle.putDoubleArray(str, (double[]) obj);
        } else if (obj instanceof Integer) {
            bundle.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof int[]) {
            bundle.putIntArray(str, (int[]) obj);
        } else if (obj instanceof Long) {
            bundle.putLong(str, ((Long) obj).longValue());
        } else if (obj instanceof long[]) {
            bundle.putLongArray(str, (long[]) obj);
        } else if (obj instanceof String) {
            bundle.putString(str, (String) obj);
        } else if (obj instanceof JSONArray) {
            bundle.putString(str, obj.toString());
        } else if (!(obj instanceof JSONObject)) {
            return false;
        } else {
            bundle.putString(str, obj.toString());
        }
        return true;
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void a(URLConnection uRLConnection) {
        if (uRLConnection != null && (uRLConnection instanceof HttpURLConnection)) {
            ((HttpURLConnection) uRLConnection).disconnect();
        }
    }

    public static String ac(Context context) {
        x.a((Object) context, "context");
        h.Q(context);
        return h.it();
    }

    public static Object b(JSONObject jSONObject, String str, String str2) {
        Object opt = jSONObject.opt(str);
        if (opt != null && (opt instanceof String)) {
            opt = new JSONTokener((String) opt).nextValue();
        }
        if (opt == null || (opt instanceof JSONObject) || (opt instanceof JSONArray)) {
            return opt;
        }
        if (str2 != null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt(str2, opt);
            return jSONObject2;
        }
        throw new FacebookException("Got an unexpected non-JSON object.");
    }

    public static String c(InputStream inputStream) {
        Throwable th;
        Closeable bufferedInputStream;
        Closeable inputStreamReader;
        try {
            bufferedInputStream = new BufferedInputStream(inputStream);
            try {
                inputStreamReader = new InputStreamReader(bufferedInputStream);
                try {
                    StringBuilder stringBuilder = new StringBuilder();
                    char[] cArr = new char[2048];
                    while (true) {
                        int read = inputStreamReader.read(cArr);
                        if (read != -1) {
                            stringBuilder.append(cArr, 0, read);
                        } else {
                            String stringBuilder2 = stringBuilder.toString();
                            closeQuietly(bufferedInputStream);
                            closeQuietly(inputStreamReader);
                            return stringBuilder2;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    closeQuietly(bufferedInputStream);
                    closeQuietly(inputStreamReader);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                inputStreamReader = null;
                closeQuietly(bufferedInputStream);
                closeQuietly(inputStreamReader);
                throw th;
            }
        } catch (Throwable th32) {
            bufferedInputStream = null;
            th = th32;
            inputStreamReader = bufferedInputStream;
            closeQuietly(bufferedInputStream);
            closeQuietly(inputStreamReader);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x002e  */
    public static int a(java.io.InputStream r6, java.io.OutputStream r7) {
        /*
        r0 = 0;
        r1 = new java.io.BufferedInputStream;	 Catch:{ all -> 0x0025 }
        r1.<init>(r6);	 Catch:{ all -> 0x0025 }
        r0 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
        r0 = new byte[r0];	 Catch:{ all -> 0x0023 }
        r2 = 0;
        r3 = 0;
    L_0x000c:
        r4 = r1.read(r0);	 Catch:{ all -> 0x0023 }
        r5 = -1;
        if (r4 == r5) goto L_0x0018;
    L_0x0013:
        r7.write(r0, r2, r4);	 Catch:{ all -> 0x0023 }
        r3 = r3 + r4;
        goto L_0x000c;
    L_0x0018:
        if (r1 == 0) goto L_0x001d;
    L_0x001a:
        r1.close();
    L_0x001d:
        if (r6 == 0) goto L_0x0022;
    L_0x001f:
        r6.close();
    L_0x0022:
        return r3;
    L_0x0023:
        r7 = move-exception;
        goto L_0x0027;
    L_0x0025:
        r7 = move-exception;
        r1 = r0;
    L_0x0027:
        if (r1 == 0) goto L_0x002c;
    L_0x0029:
        r1.close();
    L_0x002c:
        if (r6 == 0) goto L_0x0031;
    L_0x002e:
        r6.close();
    L_0x0031:
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.w.a(java.io.InputStream, java.io.OutputStream):int");
    }

    private static void r(Context context, String str) {
        CookieSyncManager.createInstance(context).sync();
        CookieManager instance = CookieManager.getInstance();
        String cookie = instance.getCookie(str);
        if (cookie != null) {
            for (String split : cookie.split(";")) {
                String[] split2 = split.split("=");
                if (split2.length > 0) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(split2[0].trim());
                    stringBuilder.append("=;expires=Sat, 1 Jan 2000 00:00:01 UTC;");
                    instance.setCookie(str, stringBuilder.toString());
                }
            }
            instance.removeExpiredCookie();
        }
    }

    public static void ad(Context context) {
        r(context, "facebook.com");
        r(context, ".facebook.com");
        r(context, "https://facebook.com");
        r(context, "https://.facebook.com");
    }

    public static void a(String str, Exception exception) {
        if (h.isDebugEnabled() && str != null && exception != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(exception.getClass().getSimpleName());
            stringBuilder.append(": ");
            stringBuilder.append(exception.getMessage());
            Log.d(str, stringBuilder.toString());
        }
    }

    public static void E(String str, String str2) {
        if (h.isDebugEnabled() && str != null && str2 != null) {
            Log.d(str, str2);
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (h.isDebugEnabled() && !bc(str)) {
            Log.d(str, str2, th);
        }
    }

    public static <T> boolean d(T t, T t2) {
        if (t != null) {
            return t.equals(t2);
        }
        return t2 == null;
    }

    public static String b(JSONObject jSONObject, String str) {
        return jSONObject != null ? jSONObject.optString(str, "") : "";
    }

    public static JSONObject c(JSONObject jSONObject, String str) {
        return jSONObject != null ? jSONObject.optJSONObject(str) : null;
    }

    public static JSONArray d(JSONObject jSONObject, String str) {
        return jSONObject != null ? jSONObject.optJSONArray(str) : null;
    }

    public static void deleteDirectory(File file) {
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File deleteDirectory : listFiles) {
                        deleteDirectory(deleteDirectory);
                    }
                }
            }
            file.delete();
        }
    }

    public static <T> List<T> b(T... tArr) {
        List arrayList = new ArrayList();
        for (Object obj : tArr) {
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static List<String> f(JSONArray jSONArray) {
        List arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        return arrayList;
    }

    public static void a(JSONObject jSONObject, b bVar, String str, boolean z) {
        if (!(bVar == null || bVar.lw() == null)) {
            jSONObject.put("attribution", bVar.lw());
        }
        if (!(bVar == null || bVar.lx() == null)) {
            jSONObject.put("advertiser_id", bVar.lx());
            jSONObject.put("advertiser_tracking_enabled", bVar.lz() ^ 1);
        }
        if (!(bVar == null || bVar.ly() == null)) {
            jSONObject.put("installer_package", bVar.ly());
        }
        jSONObject.put("anon_id", str);
        jSONObject.put("application_tracking_enabled", z ^ 1);
    }

    public static void a(JSONObject jSONObject, Context context) {
        int i;
        int i2;
        int i3;
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("a2");
        af(context);
        String packageName = context.getPackageName();
        Object obj = "";
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            i = packageInfo.versionCode;
            try {
                obj = packageInfo.versionName;
            } catch (NameNotFoundException unused) {
                Locale locale;
                jSONArray.put(packageName);
                jSONArray.put(i);
                jSONArray.put(obj);
                jSONArray.put(VERSION.RELEASE);
                jSONArray.put(Build.MODEL);
                try {
                    locale = context.getResources().getConfiguration().locale;
                } catch (Exception unused2) {
                    locale = Locale.getDefault();
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(locale.getLanguage());
                stringBuilder.append("_");
                stringBuilder.append(locale.getCountry());
                jSONArray.put(stringBuilder.toString());
                jSONArray.put(Ey);
                jSONArray.put(EA);
                double d = 0.0d;
                try {
                    WindowManager windowManager = (WindowManager) context.getSystemService("window");
                    if (windowManager != null) {
                        Display defaultDisplay = windowManager.getDefaultDisplay();
                        DisplayMetrics displayMetrics = new DisplayMetrics();
                        defaultDisplay.getMetrics(displayMetrics);
                        i2 = displayMetrics.widthPixels;
                        try {
                            i3 = displayMetrics.heightPixels;
                            try {
                                d = (double) displayMetrics.density;
                            } catch (Exception unused3) {
                                jSONArray.put(i2);
                                jSONArray.put(i3);
                                jSONArray.put(String.format("%.2f", new Object[]{Double.valueOf(d)}));
                                jSONArray.put(mu());
                                jSONArray.put(Ew);
                                jSONArray.put(Ex);
                                jSONArray.put(Ez);
                                jSONObject.put("extinfo", jSONArray.toString());
                            }
                        } catch (Exception unused4) {
                            i3 = 0;
                        }
                    }
                } catch (Exception unused5) {
                    i2 = 0;
                }
            }
        } catch (NameNotFoundException unused6) {
            i = -1;
        }
    }

    public static Method a(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public static Method a(String str, String str2, Class<?>... clsArr) {
        try {
            return a(Class.forName(str), str2, (Class[]) clsArr);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static Object a(Object obj, Method method, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException unused) {
            return null;
        } catch (InvocationTargetException unused2) {
            return null;
        }
    }

    public static String ae(Context context) {
        if (context == null) {
            return "null";
        }
        if (context == context.getApplicationContext()) {
            return "unknown";
        }
        return context.getClass().getSimpleName();
    }

    public static boolean c(Uri uri) {
        return uri != null && ("http".equalsIgnoreCase(uri.getScheme()) || "https".equalsIgnoreCase(uri.getScheme()) || "fbstaging".equalsIgnoreCase(uri.getScheme()));
    }

    public static boolean d(Uri uri) {
        return uri != null && com.google.firebase.analytics.FirebaseAnalytics.b.CONTENT.equalsIgnoreCase(uri.getScheme());
    }

    public static boolean e(Uri uri) {
        return uri != null && "file".equalsIgnoreCase(uri.getScheme());
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002d  */
    public static long f(android.net.Uri r9) {
        /*
        r0 = 0;
        r1 = com.facebook.h.getApplicationContext();	 Catch:{ all -> 0x0027 }
        r2 = r1.getContentResolver();	 Catch:{ all -> 0x0027 }
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r3 = r9;
        r9 = r2.query(r3, r4, r5, r6, r7);	 Catch:{ all -> 0x0027 }
        r0 = "_size";
        r0 = r9.getColumnIndex(r0);	 Catch:{ all -> 0x0025 }
        r9.moveToFirst();	 Catch:{ all -> 0x0025 }
        r0 = r9.getLong(r0);	 Catch:{ all -> 0x0025 }
        if (r9 == 0) goto L_0x0024;
    L_0x0021:
        r9.close();
    L_0x0024:
        return r0;
    L_0x0025:
        r0 = move-exception;
        goto L_0x002b;
    L_0x0027:
        r9 = move-exception;
        r8 = r0;
        r0 = r9;
        r9 = r8;
    L_0x002b:
        if (r9 == 0) goto L_0x0030;
    L_0x002d:
        r9.close();
    L_0x0030:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.w.f(android.net.Uri):long");
    }

    public static Date a(Bundle bundle, String str, Date date) {
        if (bundle == null) {
            return null;
        }
        long longValue;
        Object obj = bundle.get(str);
        if (obj instanceof Long) {
            longValue = ((Long) obj).longValue();
        } else if (!(obj instanceof String)) {
            return null;
        } else {
            try {
                longValue = Long.parseLong((String) obj);
            } catch (NumberFormatException unused) {
                return null;
            }
        }
        if (longValue == 0) {
            return new Date(Long.MAX_VALUE);
        }
        return new Date(date.getTime() + (longValue * 1000));
    }

    public static void a(Parcel parcel, Map<String, String> map) {
        if (map == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(map.size());
        for (Entry entry : map.entrySet()) {
            parcel.writeString((String) entry.getKey());
            parcel.writeString((String) entry.getValue());
        }
    }

    public static Map<String, String> g(Parcel parcel) {
        int readInt = parcel.readInt();
        if (readInt < 0) {
            return null;
        }
        Map<String, String> hashMap = new HashMap();
        for (int i = 0; i < readInt; i++) {
            hashMap.put(parcel.readString(), parcel.readString());
        }
        return hashMap;
    }

    public static boolean e(com.facebook.a aVar) {
        return aVar != null && aVar.equals(com.facebook.a.ik());
    }

    public static void a(final String str, final a aVar) {
        JSONObject bM = u.bM(str);
        if (bM != null) {
            aVar.e(bM);
            return;
        }
        com.facebook.i.b anonymousClass1 = new com.facebook.i.b() {
            public void a(l lVar) {
                if (lVar.jJ() != null) {
                    aVar.c(lVar.jJ().iV());
                    return;
                }
                u.e(str, lVar.jK());
                aVar.e(lVar.jK());
            }
        };
        i bQ = bQ(str);
        bQ.a(anonymousClass1);
        bQ.jr();
    }

    public static JSONObject bP(String str) {
        JSONObject bM = u.bM(str);
        if (bM != null) {
            return bM;
        }
        l jq = bQ(str).jq();
        if (jq.jJ() != null) {
            return null;
        }
        return jq.jK();
    }

    private static i bQ(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("fields", "id,name,first_name,middle_name,last_name,link");
        bundle.putString("access_token", str);
        return new i(null, "me", bundle, HttpMethod.GET, null);
    }

    private static int mu() {
        if (Eu > 0) {
            return Eu;
        }
        try {
            File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new FilenameFilter() {
                public boolean accept(File file, String str) {
                    return Pattern.matches("cpu[0-9]+", str);
                }
            });
            if (listFiles != null) {
                Eu = listFiles.length;
            }
        } catch (Exception unused) {
            if (Eu <= 0) {
                Eu = Math.max(Runtime.getRuntime().availableProcessors(), 1);
            }
            return Eu;
        }
    }

    private static void af(Context context) {
        if (Ev == -1 || System.currentTimeMillis() - Ev >= 1800000) {
            Ev = System.currentTimeMillis();
            mv();
            ag(context);
            my();
            mx();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:2:0x001a A:{RETURN, Splitter: B:0:0x0000, ExcHandler: java.lang.AssertionError (unused java.lang.AssertionError)} */
    /* JADX WARNING: Missing block: B:2:0x001a, code:
            return;
     */
    private static void mv() {
        /*
        r0 = java.util.TimeZone.getDefault();	 Catch:{ AssertionError -> 0x001a, AssertionError -> 0x001a }
        r1 = new java.util.Date;	 Catch:{ AssertionError -> 0x001a, AssertionError -> 0x001a }
        r1.<init>();	 Catch:{ AssertionError -> 0x001a, AssertionError -> 0x001a }
        r1 = r0.inDaylightTime(r1);	 Catch:{ AssertionError -> 0x001a, AssertionError -> 0x001a }
        r2 = 0;
        r1 = r0.getDisplayName(r1, r2);	 Catch:{ AssertionError -> 0x001a, AssertionError -> 0x001a }
        Ey = r1;	 Catch:{ AssertionError -> 0x001a, AssertionError -> 0x001a }
        r0 = r0.getID();	 Catch:{ AssertionError -> 0x001a, AssertionError -> 0x001a }
        Ez = r0;	 Catch:{ AssertionError -> 0x001a, AssertionError -> 0x001a }
    L_0x001a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.w.mv():void");
    }

    private static void ag(Context context) {
        if (EA.equals("NoCarrier")) {
            try {
                EA = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperatorName();
            } catch (Exception unused) {
            }
        }
    }

    private static boolean mw() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    private static void mx() {
        try {
            if (mw()) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                Ex = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
            }
            Ex = b((double) Ex);
        } catch (Exception unused) {
        }
    }

    private static void my() {
        try {
            if (mw()) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                Ew = ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
            }
            Ew = b((double) Ew);
        } catch (Exception unused) {
        }
    }

    private static long b(double d) {
        return Math.round(d / 1.073741824E9d);
    }

    public static b k(JSONObject jSONObject) {
        JSONArray jSONArray = jSONObject.getJSONObject("permissions").getJSONArray("data");
        List arrayList = new ArrayList(jSONArray.length());
        List arrayList2 = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            String optString = optJSONObject.optString("permission");
            if (!(optString == null || optString.equals("installed"))) {
                String optString2 = optJSONObject.optString(NotificationCompat.CATEGORY_STATUS);
                if (optString2 != null) {
                    if (optString2.equals("granted")) {
                        arrayList.add(optString);
                    } else if (optString2.equals("declined")) {
                        arrayList2.add(optString);
                    }
                }
            }
        }
        return new b(arrayList, arrayList2);
    }

    public static String Q(int i) {
        return new BigInteger(i * 5, new Random()).toString(32);
    }

    public static boolean ah(Context context) {
        return ai(context);
    }

    public static boolean ai(Context context) {
        boolean z = false;
        if (VERSION.SDK_INT < 26) {
            return false;
        }
        AutofillManager autofillManager = (AutofillManager) context.getSystemService(AutofillManager.class);
        if (autofillManager != null && autofillManager.isAutofillSupported() && autofillManager.isEnabled()) {
            z = true;
        }
        return z;
    }

    public static boolean aj(Context context) {
        if (VERSION.SDK_INT >= 27) {
            return context.getPackageManager().hasSystemFeature("android.hardware.type.pc");
        }
        return Build.DEVICE != null && Build.DEVICE.matches(".+_cheets|cheets_.+");
    }

    public static Locale mz() {
        try {
            return h.getApplicationContext().getResources().getConfiguration().locale;
        } catch (Exception unused) {
            return Locale.getDefault();
        }
    }
}
