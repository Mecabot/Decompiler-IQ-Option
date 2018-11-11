package io.fabric.sdk.android.services.common;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Debug;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import io.fabric.sdk.android.c;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.Flushable;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CommonUtils {
    private static Boolean emP = null;
    private static final char[] emQ = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static long emR = -1;
    public static final Comparator<File> emS = new Comparator<File>() {
        public int compare(File file, File file2) {
            return (int) (file.lastModified() - file2.lastModified());
        }
    };

    enum Architecture {
        X86_32,
        X86_64,
        ARM_UNKNOWN,
        PPC,
        PPC64,
        ARMV6,
        ARMV7,
        UNKNOWN,
        ARMV7S,
        ARM64;
        
        private static final Map<String, Architecture> matcher = null;

        static {
            matcher = new HashMap(4);
            matcher.put("armeabi-v7a", ARMV7);
            matcher.put("armeabi", ARMV6);
            matcher.put("arm64-v8a", ARM64);
            matcher.put("x86", X86_32);
        }

        static Architecture getValue() {
            Object obj = Build.CPU_ABI;
            if (TextUtils.isEmpty(obj)) {
                c.aUg().d("Fabric", "Architecture#getValue()::Build.CPU_ABI returned null or empty");
                return UNKNOWN;
            }
            Architecture architecture = (Architecture) matcher.get(obj.toLowerCase(Locale.US));
            if (architecture == null) {
                architecture = UNKNOWN;
            }
            return architecture;
        }
    }

    public static String iT(int i) {
        switch (i) {
            case 2:
                return "V";
            case 3:
                return "D";
            case 4:
                return "I";
            case 5:
                return "W";
            case 6:
                return "E";
            case 7:
                return "A";
            default:
                return "?";
        }
    }

    public static SharedPreferences cF(Context context) {
        return context.getSharedPreferences("com.crashlytics.prefs", 0);
    }

    public static String e(File file, String str) {
        Throwable e;
        StringBuilder stringBuilder;
        Throwable th;
        String str2 = null;
        if (file.exists()) {
            Closeable bufferedReader;
            try {
                bufferedReader = new BufferedReader(new FileReader(file), 1024);
                while (true) {
                    try {
                        CharSequence readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        String[] split = Pattern.compile("\\s*:\\s*").split(readLine, 2);
                        if (split.length > 1 && split[0].equals(str)) {
                            str2 = split[1];
                            break;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            stringBuilder = new StringBuilder();
                            stringBuilder.append("Error parsing ");
                            stringBuilder.append(file);
                            c.aUg().e("Fabric", stringBuilder.toString(), e);
                            a(bufferedReader, "Failed to close system file reader.");
                            return str2;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                }
            } catch (Exception e3) {
                e = e3;
                bufferedReader = null;
                stringBuilder = new StringBuilder();
                stringBuilder.append("Error parsing ");
                stringBuilder.append(file);
                c.aUg().e("Fabric", stringBuilder.toString(), e);
                a(bufferedReader, "Failed to close system file reader.");
                return str2;
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
                a(bufferedReader, "Failed to close system file reader.");
                throw th;
            }
            a(bufferedReader, "Failed to close system file reader.");
        }
        return str2;
    }

    public static int aUB() {
        return Architecture.getValue().ordinal();
    }

    public static synchronized long aUC() {
        long j;
        synchronized (CommonUtils.class) {
            if (emR == -1) {
                j = 0;
                Object e = e(new File("/proc/meminfo"), "MemTotal");
                if (!TextUtils.isEmpty(e)) {
                    String toUpperCase = e.toUpperCase(Locale.US);
                    try {
                        long b;
                        if (toUpperCase.endsWith("KB")) {
                            b = b(toUpperCase, "KB", 1024);
                        } else if (toUpperCase.endsWith("MB")) {
                            b = b(toUpperCase, "MB", 1048576);
                        } else if (toUpperCase.endsWith("GB")) {
                            b = b(toUpperCase, "GB", 1073741824);
                        } else {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Unexpected meminfo format while computing RAM: ");
                            stringBuilder.append(toUpperCase);
                            c.aUg().d("Fabric", stringBuilder.toString());
                        }
                        j = b;
                    } catch (Throwable e2) {
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("Unexpected meminfo format while computing RAM: ");
                        stringBuilder2.append(toUpperCase);
                        c.aUg().e("Fabric", stringBuilder2.toString(), e2);
                    }
                }
                emR = j;
            }
            j = emR;
        }
        return j;
    }

    static long b(String str, String str2, int i) {
        return Long.parseLong(str.split(str2)[0].trim()) * ((long) i);
    }

    public static RunningAppProcessInfo h(String str, Context context) {
        List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.processName.equals(str)) {
                    return runningAppProcessInfo;
                }
            }
        }
        return null;
    }

    public static String h(InputStream inputStream) {
        Scanner useDelimiter = new Scanner(inputStream).useDelimiter("\\A");
        return useDelimiter.hasNext() ? useDelimiter.next() : "";
    }

    public static String lx(String str) {
        return aR(str, "SHA-1");
    }

    public static String ly(String str) {
        return aR(str, "SHA-256");
    }

    public static String i(InputStream inputStream) {
        return b(inputStream, "SHA-1");
    }

    private static String aR(String str, String str2) {
        return b(str.getBytes(), str2);
    }

    private static String b(InputStream inputStream, String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    return Z(instance.digest());
                }
                instance.update(bArr, 0, read);
            }
        } catch (Throwable e) {
            c.aUg().e("Fabric", "Could not calculate hash for app icon.", e);
            return "";
        }
    }

    private static String b(byte[] bArr, String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            instance.update(bArr);
            return Z(instance.digest());
        } catch (Throwable e) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Could not create hashing algorithm: ");
            stringBuilder.append(str);
            stringBuilder.append(", returning empty string.");
            c.aUg().e("Fabric", stringBuilder.toString(), e);
            return "";
        }
    }

    public static String g(String... strArr) {
        String str = null;
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        List<String> arrayList = new ArrayList();
        for (String str2 : strArr) {
            if (str2 != null) {
                arrayList.add(str2.replace("-", "").toLowerCase(Locale.US));
            }
        }
        Collections.sort(arrayList);
        StringBuilder stringBuilder = new StringBuilder();
        for (String append : arrayList) {
            stringBuilder.append(append);
        }
        String stringBuilder2 = stringBuilder.toString();
        if (stringBuilder2.length() > 0) {
            str = lx(stringBuilder2);
        }
        return str;
    }

    public static long cG(Context context) {
        MemoryInfo memoryInfo = new MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    public static long lz(String str) {
        StatFs statFs = new StatFs(str);
        long blockSize = (long) statFs.getBlockSize();
        return (((long) statFs.getBlockCount()) * blockSize) - (blockSize * ((long) statFs.getAvailableBlocks()));
    }

    public static Float cH(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return null;
        }
        return Float.valueOf(((float) registerReceiver.getIntExtra(b.LEVEL, -1)) / ((float) registerReceiver.getIntExtra("scale", -1)));
    }

    public static boolean cI(Context context) {
        boolean z = false;
        if (cK(context)) {
            return false;
        }
        if (((SensorManager) context.getSystemService("sensor")).getDefaultSensor(8) != null) {
            z = true;
        }
        return z;
    }

    public static void H(Context context, String str) {
        if (cJ(context)) {
            c.aUg().d("Fabric", str);
        }
    }

    public static void a(Context context, String str, Throwable th) {
        if (cJ(context)) {
            c.aUg().e("Fabric", str);
        }
    }

    public static void a(Context context, int i, String str, String str2) {
        if (cJ(context)) {
            c.aUg().e(i, "Fabric", str2);
        }
    }

    public static boolean cJ(Context context) {
        if (emP == null) {
            emP = Boolean.valueOf(b(context, "com.crashlytics.Trace", false));
        }
        return emP.booleanValue();
    }

    public static boolean b(Context context, String str, boolean z) {
        if (context != null) {
            Resources resources = context.getResources();
            if (resources != null) {
                int h = h(context, str, "bool");
                if (h > 0) {
                    return resources.getBoolean(h);
                }
                int h2 = h(context, str, "string");
                if (h2 > 0) {
                    return Boolean.parseBoolean(context.getString(h2));
                }
            }
        }
        return z;
    }

    public static int h(Context context, String str, String str2) {
        return context.getResources().getIdentifier(str, str2, cN(context));
    }

    public static boolean cK(Context context) {
        return "sdk".equals(Build.PRODUCT) || "google_sdk".equals(Build.PRODUCT) || Secure.getString(context.getContentResolver(), "android_id") == null;
    }

    public static boolean isRooted(Context context) {
        boolean cK = cK(context);
        String str = Build.TAGS;
        if ((!cK && str != null && str.contains("test-keys")) || new File("/system/app/Superuser.apk").exists()) {
            return true;
        }
        File file = new File("/system/xbin/su");
        if (cK || !file.exists()) {
            return false;
        }
        return true;
    }

    public static boolean aUD() {
        return Debug.isDebuggerConnected() || Debug.waitingForDebugger();
    }

    public static int cL(Context context) {
        int i = cK(context) ? 1 : 0;
        if (isRooted(context)) {
            i |= 2;
        }
        return aUD() ? i | 4 : i;
    }

    public static int f(Context context, boolean z) {
        Float cH = cH(context);
        if (!z || cH == null) {
            return 1;
        }
        if (((double) cH.floatValue()) >= 99.0d) {
            return 3;
        }
        return ((double) cH.floatValue()) < 99.0d ? 2 : 0;
    }

    public static String Z(byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            int i3 = i * 2;
            cArr[i3] = emQ[i2 >>> 4];
            cArr[i3 + 1] = emQ[i2 & 15];
        }
        return new String(cArr);
    }

    public static boolean cM(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    public static String I(Context context, String str) {
        int h = h(context, str, "string");
        return h > 0 ? context.getString(h) : "";
    }

    public static void a(Closeable closeable, String str) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable e) {
                c.aUg().e("Fabric", str, e);
            }
        }
    }

    public static void a(Flushable flushable, String str) {
        if (flushable != null) {
            try {
                flushable.flush();
            } catch (Throwable e) {
                c.aUg().e("Fabric", str, e);
            }
        }
    }

    public static boolean bc(String str) {
        return str == null || str.length() == 0;
    }

    public static String iS(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("value must be zero or greater");
        }
        return String.format(Locale.US, "%1$10s", new Object[]{Integer.valueOf(i)}).replace(' ', '0');
    }

    public static String cN(Context context) {
        int i = context.getApplicationContext().getApplicationInfo().icon;
        if (i > 0) {
            return context.getResources().getResourcePackageName(i);
        }
        return context.getPackageName();
    }

    public static void a(InputStream inputStream, OutputStream outputStream, byte[] bArr) {
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    public static String cO(Context context) {
        Throwable e;
        Throwable th;
        String str = null;
        Closeable openRawResource;
        try {
            openRawResource = context.getResources().openRawResource(cP(context));
            try {
                String i = i(openRawResource);
                if (!bc(i)) {
                    str = i;
                }
                a(openRawResource, "Failed to close icon input stream.");
                return str;
            } catch (Exception e2) {
                e = e2;
                try {
                    c.aUg().e("Fabric", "Could not calculate hash for app icon.", e);
                    a(openRawResource, "Failed to close icon input stream.");
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    a(openRawResource, "Failed to close icon input stream.");
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            openRawResource = null;
            c.aUg().e("Fabric", "Could not calculate hash for app icon.", e);
            a(openRawResource, "Failed to close icon input stream.");
            return null;
        } catch (Throwable th3) {
            th = th3;
            openRawResource = null;
            a(openRawResource, "Failed to close icon input stream.");
            throw th;
        }
    }

    public static int cP(Context context) {
        return context.getApplicationContext().getApplicationInfo().icon;
    }

    public static String cQ(Context context) {
        int h = h(context, "io.fabric.android.build_id", "string");
        if (h == 0) {
            h = h(context, "com.crashlytics.android.build_id", "string");
        }
        if (h == 0) {
            return null;
        }
        String string = context.getResources().getString(h);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Build ID is: ");
        stringBuilder.append(string);
        c.aUg().d("Fabric", stringBuilder.toString());
        return string;
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    public static boolean J(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    @SuppressLint({"MissingPermission"})
    public static boolean cR(Context context) {
        boolean z = true;
        if (!J(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return true;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) {
            z = false;
        }
        return z;
    }
}
