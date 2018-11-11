package com.jumio.core.environment;

import android.content.Context;
import android.os.Build.VERSION;
import java.io.File;

public class Environment {
    private static boolean ALE_LIB_IS_LOADED = false;
    public static final String ALE_VERSION = "1.3.0";
    public static final String BUILD_VERSION = "JMSDK 2.10.0 (0-63)";
    private static boolean CPU_INFO_LIB_IS_LOADED = false;
    protected static String DATA_DIRECTORY = "/jumio/";
    private static boolean JNI_IMAGE_QUALITY_LIB_IS_LOADED = false;
    private static boolean JNI_INTERFACE_LIB_IS_LOADED = false;
    public static final String OCR_VERSION = "1.102.0";
    public static final String PHOTOPAY_VERSION = "6.4.0";

    public static File getDataDirectory(Context context) {
        File file = new File(context.getFilesDir(), DATA_DIRECTORY);
        if (!file.isDirectory()) {
            file.mkdirs();
        }
        return file;
    }

    protected static void deleteDirectory(File file) {
        if (file != null && file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        deleteDirectory(file2);
                        file2.delete();
                    } else {
                        file2.delete();
                    }
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x003d A:{Catch:{ Exception -> 0x0041 }} */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0045 A:{Catch:{ Exception -> 0x0041 }} */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x003d A:{Catch:{ Exception -> 0x0041 }} */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0045 A:{Catch:{ Exception -> 0x0041 }} */
    protected static java.lang.String readFile(java.io.File r5) {
        /*
        r0 = new java.lang.StringBuffer;
        r1 = "";
        r0.<init>(r1);
        if (r5 == 0) goto L_0x0055;
    L_0x0009:
        r1 = r5.isFile();
        if (r1 != 0) goto L_0x0010;
    L_0x000f:
        goto L_0x0055;
    L_0x0010:
        r1 = 0;
        r2 = new java.io.FileInputStream;	 Catch:{ all -> 0x0039 }
        r2.<init>(r5);	 Catch:{ all -> 0x0039 }
        r5 = new java.io.BufferedReader;	 Catch:{ all -> 0x0037 }
        r3 = new java.io.InputStreamReader;	 Catch:{ all -> 0x0037 }
        r3.<init>(r2);	 Catch:{ all -> 0x0037 }
        r5.<init>(r3);	 Catch:{ all -> 0x0037 }
        r1 = r5.readLine();	 Catch:{ all -> 0x0032 }
        r0.append(r1);	 Catch:{ all -> 0x0032 }
        if (r2 == 0) goto L_0x002c;
    L_0x0029:
        r2.close();	 Catch:{ Exception -> 0x0041 }
    L_0x002c:
        if (r5 == 0) goto L_0x004c;
    L_0x002e:
        r5.close();	 Catch:{ Exception -> 0x0041 }
        goto L_0x004c;
    L_0x0032:
        r1 = move-exception;
        r4 = r1;
        r1 = r5;
        r5 = r4;
        goto L_0x003b;
    L_0x0037:
        r5 = move-exception;
        goto L_0x003b;
    L_0x0039:
        r5 = move-exception;
        r2 = r1;
    L_0x003b:
        if (r2 == 0) goto L_0x0043;
    L_0x003d:
        r2.close();	 Catch:{ Exception -> 0x0041 }
        goto L_0x0043;
    L_0x0041:
        r5 = move-exception;
        goto L_0x0049;
    L_0x0043:
        if (r1 == 0) goto L_0x0048;
    L_0x0045:
        r1.close();	 Catch:{ Exception -> 0x0041 }
    L_0x0048:
        throw r5;	 Catch:{ Exception -> 0x0041 }
    L_0x0049:
        com.jumio.commons.log.Log.printStackTrace(r5);
    L_0x004c:
        r5 = r0.toString();
        r5 = r5.trim();
        return r5;
    L_0x0055:
        r5 = "";
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.environment.Environment.readFile(java.io.File):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x001d A:{Catch:{ Exception -> 0x0024 }} */
    protected static void writeFile(java.lang.String r2, java.io.File r3) {
        /*
        r0 = 0;
        r1 = new java.io.FileOutputStream;	 Catch:{ all -> 0x001a }
        r1.<init>(r3);	 Catch:{ all -> 0x001a }
        r3 = new java.io.OutputStreamWriter;	 Catch:{ all -> 0x001a }
        r3.<init>(r1);	 Catch:{ all -> 0x001a }
        r3.write(r2);	 Catch:{ all -> 0x0017 }
        if (r3 == 0) goto L_0x002a;
    L_0x0010:
        r3.flush();	 Catch:{ Exception -> 0x0024 }
        r3.close();	 Catch:{ Exception -> 0x0024 }
        goto L_0x002a;
    L_0x0017:
        r2 = move-exception;
        r0 = r3;
        goto L_0x001b;
    L_0x001a:
        r2 = move-exception;
    L_0x001b:
        if (r0 == 0) goto L_0x0026;
    L_0x001d:
        r0.flush();	 Catch:{ Exception -> 0x0024 }
        r0.close();	 Catch:{ Exception -> 0x0024 }
        goto L_0x0026;
    L_0x0024:
        r2 = move-exception;
        goto L_0x0027;
    L_0x0026:
        throw r2;	 Catch:{ Exception -> 0x0024 }
    L_0x0027:
        com.jumio.commons.log.Log.printStackTrace(r2);
    L_0x002a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.environment.Environment.writeFile(java.lang.String, java.io.File):void");
    }

    public static void checkOcrVersion(Context context) {
        File dataDirectory = getDataDirectory(context);
        File file = new File(dataDirectory, "cv");
        if (!"1.102.0".equals(readFile(file))) {
            deleteDirectory(dataDirectory);
            writeFile("1.102.0", file);
        }
    }

    @Deprecated
    public static String extractFile(Context context, String str, String str2, String str3) {
        return extractFile(context, Environment.class, str, str2, str3);
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x0095 A:{SYNTHETIC, Splitter: B:42:0x0095} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00a1 A:{SYNTHETIC, Splitter: B:49:0x00a1} */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0095 A:{SYNTHETIC, Splitter: B:42:0x0095} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00a1 A:{SYNTHETIC, Splitter: B:49:0x00a1} */
    public static java.lang.String extractFile(android.content.Context r2, java.lang.Class<?> r3, java.lang.String r4, java.lang.String r5, java.lang.String r6) {
        /*
        r0 = new java.io.File;
        r2 = getDataDirectory(r2);
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1.append(r4);
        r1.append(r6);
        r6 = r1.toString();
        r0.<init>(r2, r6);
        r2 = r0.getName();
        r6 = "_";
        r2 = r2.startsWith(r6);
        if (r2 == 0) goto L_0x0037;
    L_0x0024:
        r2 = r0.getName();
        r6 = 1;
        r2 = r2.substring(r6);
        r6 = new java.io.File;
        r0 = r0.getParentFile();
        r6.<init>(r0, r2);
        goto L_0x0038;
    L_0x0037:
        r6 = r0;
    L_0x0038:
        r2 = calculateHash(r6);
        r0 = r6.isFile();
        if (r0 == 0) goto L_0x0048;
    L_0x0042:
        r2 = r5.equals(r2);
        if (r2 != 0) goto L_0x0086;
    L_0x0048:
        r2 = 2048; // 0x800 float:2.87E-42 double:1.0118E-320;
        r2 = new byte[r2];
        r5 = r6.isFile();
        if (r5 == 0) goto L_0x0056;
    L_0x0052:
        r6.delete();
        goto L_0x005d;
    L_0x0056:
        r5 = r6.getParentFile();
        r5.mkdirs();
    L_0x005d:
        r5 = 0;
        r3 = r3.getResourceAsStream(r4);	 Catch:{ all -> 0x0090 }
        r4 = new java.io.FileOutputStream;	 Catch:{ all -> 0x008d }
        r4.<init>(r6);	 Catch:{ all -> 0x008d }
    L_0x0067:
        r0 = r3.read(r2);	 Catch:{ all -> 0x008b }
        if (r0 <= 0) goto L_0x0072;
    L_0x006d:
        r1 = 0;
        r4.write(r2, r1, r0);	 Catch:{ all -> 0x008b }
        goto L_0x0067;
    L_0x0072:
        if (r3 == 0) goto L_0x007c;
    L_0x0074:
        r3.close();	 Catch:{ IOException -> 0x0078 }
        goto L_0x007c;
    L_0x0078:
        r2 = move-exception;
        com.jumio.commons.log.Log.printStackTrace(r2);	 Catch:{ Exception -> 0x0099 }
    L_0x007c:
        if (r4 == 0) goto L_0x0086;
    L_0x007e:
        r4.close();	 Catch:{ IOException -> 0x0082 }
        goto L_0x0086;
    L_0x0082:
        r2 = move-exception;
        com.jumio.commons.log.Log.printStackTrace(r2);	 Catch:{ Exception -> 0x0099 }
    L_0x0086:
        r2 = r6.getAbsolutePath();
        return r2;
    L_0x008b:
        r2 = move-exception;
        goto L_0x0093;
    L_0x008d:
        r2 = move-exception;
        r4 = r5;
        goto L_0x0093;
    L_0x0090:
        r2 = move-exception;
        r3 = r5;
        r4 = r3;
    L_0x0093:
        if (r3 == 0) goto L_0x009f;
    L_0x0095:
        r3.close();	 Catch:{ IOException -> 0x009b }
        goto L_0x009f;
    L_0x0099:
        r2 = move-exception;
        goto L_0x00aa;
    L_0x009b:
        r3 = move-exception;
        com.jumio.commons.log.Log.printStackTrace(r3);	 Catch:{ Exception -> 0x0099 }
    L_0x009f:
        if (r4 == 0) goto L_0x00a9;
    L_0x00a1:
        r4.close();	 Catch:{ IOException -> 0x00a5 }
        goto L_0x00a9;
    L_0x00a5:
        r3 = move-exception;
        com.jumio.commons.log.Log.printStackTrace(r3);	 Catch:{ Exception -> 0x0099 }
    L_0x00a9:
        throw r2;	 Catch:{ Exception -> 0x0099 }
    L_0x00aa:
        com.jumio.commons.log.Log.printStackTrace(r2);
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.environment.Environment.extractFile(android.content.Context, java.lang.Class, java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    public static synchronized boolean loadCpuInfoLib() {
        synchronized (Environment.class) {
            if (!CPU_INFO_LIB_IS_LOADED) {
                System.loadLibrary("cpuinfo");
                CPU_INFO_LIB_IS_LOADED = true;
            }
        }
        return true;
    }

    public static synchronized boolean loadAleLib() {
        synchronized (Environment.class) {
            if (!ALE_LIB_IS_LOADED) {
                System.loadLibrary("aleJwtInterface");
                ALE_LIB_IS_LOADED = true;
            }
        }
        return true;
    }

    public static synchronized boolean loadJniInterfaceLib() {
        synchronized (Environment.class) {
            if (!JNI_INTERFACE_LIB_IS_LOADED) {
                System.loadLibrary("jniInterface");
                JNI_INTERFACE_LIB_IS_LOADED = true;
            }
        }
        return true;
    }

    public static synchronized boolean loadJniImageQualityLib() {
        synchronized (Environment.class) {
            if (!JNI_IMAGE_QUALITY_LIB_IS_LOADED) {
                System.loadLibrary("jniImageQualityAcquisition");
                JNI_IMAGE_QUALITY_LIB_IS_LOADED = true;
            }
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0063 A:{SYNTHETIC, Splitter: B:28:0x0063} */
    protected static java.lang.String calculateHash(java.io.File r6) {
        /*
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = r6.isFile();
        r2 = 0;
        if (r1 != 0) goto L_0x000d;
    L_0x000c:
        return r2;
    L_0x000d:
        r1 = "SHA-256";
        r1 = java.security.MessageDigest.getInstance(r1);	 Catch:{ Exception -> 0x006c }
        r3 = new java.io.BufferedInputStream;	 Catch:{ all -> 0x0060 }
        r4 = new java.io.FileInputStream;	 Catch:{ all -> 0x0060 }
        r6 = r6.getPath();	 Catch:{ all -> 0x0060 }
        r4.<init>(r6);	 Catch:{ all -> 0x0060 }
        r3.<init>(r4);	 Catch:{ all -> 0x0060 }
        r6 = 2048; // 0x800 float:2.87E-42 double:1.0118E-320;
        r6 = new byte[r6];	 Catch:{ all -> 0x005d }
    L_0x0025:
        r2 = r3.read(r6);	 Catch:{ all -> 0x005d }
        r4 = -1;
        r5 = 0;
        if (r2 == r4) goto L_0x0031;
    L_0x002d:
        r1.update(r6, r5, r2);	 Catch:{ all -> 0x005d }
        goto L_0x0025;
    L_0x0031:
        if (r3 == 0) goto L_0x003b;
    L_0x0033:
        r3.close();	 Catch:{ IOException -> 0x0037 }
        goto L_0x003b;
    L_0x0037:
        r6 = move-exception;
        r6.printStackTrace();	 Catch:{ Exception -> 0x006c }
    L_0x003b:
        r6 = r1.digest();	 Catch:{ Exception -> 0x006c }
        r1 = r6.length;	 Catch:{ Exception -> 0x006c }
    L_0x0040:
        if (r5 >= r1) goto L_0x006c;
    L_0x0042:
        r2 = r6[r5];	 Catch:{ Exception -> 0x006c }
        r3 = r2 & 240;
        r3 = r3 >> 4;
        r4 = 16;
        r3 = java.lang.Character.forDigit(r3, r4);	 Catch:{ Exception -> 0x006c }
        r0.append(r3);	 Catch:{ Exception -> 0x006c }
        r2 = r2 & 15;
        r2 = java.lang.Character.forDigit(r2, r4);	 Catch:{ Exception -> 0x006c }
        r0.append(r2);	 Catch:{ Exception -> 0x006c }
        r5 = r5 + 1;
        goto L_0x0040;
    L_0x005d:
        r6 = move-exception;
        r2 = r3;
        goto L_0x0061;
    L_0x0060:
        r6 = move-exception;
    L_0x0061:
        if (r2 == 0) goto L_0x006b;
    L_0x0063:
        r2.close();	 Catch:{ IOException -> 0x0067 }
        goto L_0x006b;
    L_0x0067:
        r1 = move-exception;
        r1.printStackTrace();	 Catch:{ Exception -> 0x006c }
    L_0x006b:
        throw r6;	 Catch:{ Exception -> 0x006c }
    L_0x006c:
        r6 = r0.toString();
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.environment.Environment.calculateHash(java.io.File):java.lang.String");
    }

    public static boolean isLollipop() {
        return VERSION.SDK_INT == 21;
    }
}
