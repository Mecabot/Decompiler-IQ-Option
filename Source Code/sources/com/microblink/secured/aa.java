package com.microblink.secured;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.microblink.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: line */
public class aa {
    private static int dXU = 1;
    private static int dXV = -1;
    private static boolean dXW;
    public Map<String, u> dXT;
    public Context mContext;

    public aa(Context context, boolean z) {
        this.mContext = context;
        if (z) {
            try {
                JSONObject jSONObject = new JSONObject(aPF());
                JSONArray names = jSONObject.names();
                this.dXT = new HashMap(names.length());
                for (int i = 0; i < names.length(); i++) {
                    String string = names.getString(i);
                    this.dXT.put(string, new u(jSONObject.getJSONObject(string), string));
                }
            } catch (Throwable e) {
                e.printStackTrace();
                throw new RuntimeException("Failed to parse /res/raw/device_list.json. Please make sure JSON syntax is correct!", e);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x004c A:{SYNTHETIC, Splitter: B:22:0x004c} */
    private java.lang.String aPF() {
        /*
        r6 = this;
        r0 = r6.mContext;
        r0 = r0.getAssets();
        r1 = 0;
        r2 = "microblink/device_list.json";
        r0 = r0.open(r2);	 Catch:{ IOException -> 0x003d, all -> 0x0038 }
        r1 = new java.io.StringWriter;	 Catch:{ IOException -> 0x0036 }
        r1.<init>();	 Catch:{ IOException -> 0x0036 }
        r2 = new java.io.BufferedReader;	 Catch:{ IOException -> 0x0036 }
        r3 = new java.io.InputStreamReader;	 Catch:{ IOException -> 0x0036 }
        r4 = "UTF-8";
        r3.<init>(r0, r4);	 Catch:{ IOException -> 0x0036 }
        r2.<init>(r3);	 Catch:{ IOException -> 0x0036 }
        r3 = r2.readLine();	 Catch:{ IOException -> 0x0036 }
    L_0x0022:
        if (r3 == 0) goto L_0x002c;
    L_0x0024:
        r1.write(r3);	 Catch:{ IOException -> 0x0036 }
        r3 = r2.readLine();	 Catch:{ IOException -> 0x0036 }
        goto L_0x0022;
    L_0x002c:
        r1 = r1.toString();	 Catch:{ IOException -> 0x0036 }
        if (r0 == 0) goto L_0x0035;
    L_0x0032:
        r0.close();	 Catch:{ IOException -> 0x0035 }
    L_0x0035:
        return r1;
    L_0x0036:
        r1 = move-exception;
        goto L_0x0041;
    L_0x0038:
        r0 = move-exception;
        r5 = r1;
        r1 = r0;
        r0 = r5;
        goto L_0x004a;
    L_0x003d:
        r0 = move-exception;
        r5 = r1;
        r1 = r0;
        r0 = r5;
    L_0x0041:
        r2 = new java.lang.RuntimeException;	 Catch:{ all -> 0x0049 }
        r3 = "Cannot load asset microblink/device_list.json. Please make sure that this asset exists!";
        r2.<init>(r3, r1);	 Catch:{ all -> 0x0049 }
        throw r2;	 Catch:{ all -> 0x0049 }
    L_0x0049:
        r1 = move-exception;
    L_0x004a:
        if (r0 == 0) goto L_0x004f;
    L_0x004c:
        r0.close();	 Catch:{ IOException -> 0x004f }
    L_0x004f:
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microblink.secured.aa.aPF():java.lang.String");
    }

    public final u aPG() {
        u aPI = aPI();
        Map map = this.dXT;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(aPI.dXa);
        stringBuilder.append("::");
        stringBuilder.append(aPI.dXb);
        return (u) map.get(stringBuilder.toString());
    }

    public final boolean aPH() {
        u aPG = aPG();
        if (aPG == null) {
            return false;
        }
        return a(aPG.dXo);
    }

    public final float T(float f) {
        u aPG = aPG();
        if (aPG != null) {
            float f2 = (float) aPG.dXh;
            Log.f(this, "Adjusting zoom level from {} to {}", Float.valueOf(f), Float.valueOf(f2 + ((((float) aPG.dXi) - f2) * f)));
            return f2 + ((((float) aPG.dXi) - f2) * f);
        }
        Log.f(this, "Keeping zoom level at {}", Float.valueOf(f));
        return f;
    }

    public static u aPI() {
        return new u(Build.DEVICE, Build.MODEL);
    }

    public static String getModel() {
        return Build.MODEL;
    }

    public static String aPJ() {
        return Build.DEVICE;
    }

    public static String getManufacturer() {
        return Build.MANUFACTURER;
    }

    public static String aPK() {
        return VERSION.RELEASE;
    }

    public static int aPL() {
        return dXU;
    }

    public static int aPM() {
        return dXV;
    }

    public static boolean aPN() {
        return dXW;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0046 A:{SYNTHETIC, Splitter: B:29:0x0046} */
    /* JADX WARNING: Missing block: B:12:?, code:
            com.microblink.util.Log.b(com.microblink.secured.aa.class, "Failed to parse CPU frequency: '{}'", r3);
     */
    /* JADX WARNING: Missing block: B:14:?, code:
            r4.close();
     */
    /* JADX WARNING: Missing block: B:15:0x0027, code:
            return -1;
     */
    private static int kF(java.lang.String r8) {
        /*
        r0 = -1;
        r1 = 0;
        r2 = 1;
        r3 = 0;
        r4 = new java.io.RandomAccessFile;	 Catch:{ IOException -> 0x0033 }
        r5 = "r";
        r4.<init>(r8, r5);	 Catch:{ IOException -> 0x0033 }
        r3 = r4.readLine();	 Catch:{ IOException -> 0x002f, all -> 0x002c }
        if (r3 == 0) goto L_0x0028;
    L_0x0011:
        r5 = java.lang.Integer.parseInt(r3);	 Catch:{ NumberFormatException -> 0x0019 }
        r4.close();	 Catch:{ IOException -> 0x0018 }
    L_0x0018:
        return r5;
    L_0x0019:
        r5 = com.microblink.secured.aa.class;
        r6 = "Failed to parse CPU frequency: '{}'";
        r7 = new java.lang.Object[r2];	 Catch:{ IOException -> 0x002f, all -> 0x002c }
        r7[r1] = r3;	 Catch:{ IOException -> 0x002f, all -> 0x002c }
        com.microblink.util.Log.b(r5, r6, r7);	 Catch:{ IOException -> 0x002f, all -> 0x002c }
        r4.close();	 Catch:{ IOException -> 0x0027 }
    L_0x0027:
        return r0;
    L_0x0028:
        r4.close();	 Catch:{ IOException -> 0x0043 }
        goto L_0x0043;
    L_0x002c:
        r8 = move-exception;
        r3 = r4;
        goto L_0x0044;
    L_0x002f:
        r3 = r4;
        goto L_0x0033;
    L_0x0031:
        r8 = move-exception;
        goto L_0x0044;
    L_0x0033:
        r4 = com.microblink.secured.aa.class;
        r5 = "Failed to open {} for reading";
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x0031 }
        r2[r1] = r8;	 Catch:{ all -> 0x0031 }
        com.microblink.util.Log.f(r4, r5, r2);	 Catch:{ all -> 0x0031 }
        if (r3 == 0) goto L_0x0043;
    L_0x0040:
        r3.close();	 Catch:{ IOException -> 0x0043 }
    L_0x0043:
        return r0;
    L_0x0044:
        if (r3 == 0) goto L_0x0049;
    L_0x0046:
        r3.close();	 Catch:{ IOException -> 0x0049 }
    L_0x0049:
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microblink.secured.aa.kF(java.lang.String):int");
    }

    private static boolean aPO() {
        if (new File("/proc/cpuinfo").exists()) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("/proc/cpuinfo")));
                String readLine;
                do {
                    readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        bufferedReader.close();
                        return false;
                    }
                } while (!readLine.contains("neon"));
                bufferedReader.close();
                return true;
            } catch (Throwable e) {
                Log.a(aa.class, e, "Cannot read /proc/cpuinfo to obtain whether NEON is supported. Will assume it is (and risk crash).", new Object[0]);
                return true;
            }
        }
        Log.b(aa.class, "File /proc/cpuinfo seems to be missing. Cannot determine whether NEON is supported. Will assume it is (and risk crash).", new Object[0]);
        return true;
    }

    public final boolean a(h hVar) {
        if (hVar == null) {
            return false;
        }
        try {
            ae aeVar = new ae(VERSION.RELEASE);
            if (hVar.dWa) {
                return true;
            }
            Object obj = (hVar.dVY == null || (hVar.dWb ? !aeVar.b(hVar.dVY) : !aeVar.a(hVar.dVY))) ? 1 : null;
            if (obj == null) {
                return false;
            }
            if (hVar.dVZ == null || (hVar.dWc ? !hVar.dVZ.b(aeVar) : !hVar.dVZ.a(aeVar))) {
                return true;
            }
            return false;
        } catch (Throwable e) {
            Log.b((Object) this, e, "Failed to extract android version number!", new Object[0]);
            return false;
        }
    }

    static {
        boolean aPO;
        if (Build.CPU_ABI.equals("armeabi-v7a")) {
            aPO = aPO();
        } else {
            aPO = true;
        }
        dXW = aPO;
        try {
            File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new FileFilter() {
                public final boolean accept(File file) {
                    return Pattern.matches("cpu[0-9]", file.getName());
                }
            });
            dXU = listFiles.length;
            dXV = -1;
            for (File absolutePath : listFiles) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(absolutePath.getAbsolutePath());
                stringBuilder.append("/cpufreq/cpuinfo_max_freq");
                Log.a(aa.class, "Examining file {}", stringBuilder.toString());
                int kF = kF(r5);
                if (kF > dXV) {
                    dXV = kF;
                }
            }
            if (dXV != -1) {
                dXV = Math.round(((float) dXV) / 1000.0f);
            }
            Log.f(aa.class, "Calculated max CPU frequency: {} MHz", Integer.valueOf(dXV));
        } catch (Exception unused) {
            dXU = Runtime.getRuntime().availableProcessors();
            dXV = -1;
        }
    }
}
