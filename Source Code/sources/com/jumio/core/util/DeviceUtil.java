package com.jumio.core.util;

import android.content.Context;
import com.jumio.core.environment.CpuInfo;
import com.jumio.core.environment.Environment;

public class DeviceUtil {
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0090 A:{Catch:{ Exception -> 0x00b0 }} */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00b4  */
    public static java.lang.String getDeviceId(android.content.Context r5) {
        /*
        r0 = 0;
        if (r5 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = "UniqueID";
        r2 = 0;
        r1 = r5.getSharedPreferences(r1, r2);
        if (r1 == 0) goto L_0x0014;
    L_0x000d:
        r3 = "deviceId";
        r3 = r1.getString(r3, r0);
        goto L_0x0015;
    L_0x0014:
        r3 = r0;
    L_0x0015:
        if (r3 == 0) goto L_0x0022;
    L_0x0017:
        r4 = "";
        r4 = r3.equals(r4);
        if (r4 == 0) goto L_0x0020;
    L_0x001f:
        goto L_0x0022;
    L_0x0020:
        r5 = r3;
        goto L_0x0044;
    L_0x0022:
        r5 = r5.getContentResolver();	 Catch:{ Exception -> 0x0043 }
        r4 = "android_id";
        r5 = android.provider.Settings.Secure.getString(r5, r4);	 Catch:{ Exception -> 0x0043 }
        if (r5 == 0) goto L_0x0020;
    L_0x002e:
        r4 = r5.length();	 Catch:{ Exception -> 0x0043 }
        if (r4 <= 0) goto L_0x0020;
    L_0x0034:
        r4 = "9774d56d682e549c";
        r4 = r5.equals(r4);	 Catch:{ Exception -> 0x0043 }
        if (r4 != 0) goto L_0x0020;
    L_0x003c:
        r3 = java.util.Locale.GERMAN;	 Catch:{ Exception -> 0x0043 }
        r5 = r5.toUpperCase(r3);	 Catch:{ Exception -> 0x0043 }
        goto L_0x0044;
    L_0x0043:
        r5 = r0;
    L_0x0044:
        if (r5 == 0) goto L_0x004e;
    L_0x0046:
        r3 = "";
        r3 = r5.equals(r3);
        if (r3 == 0) goto L_0x0058;
    L_0x004e:
        r5 = android.os.Build.SERIAL;	 Catch:{ Exception -> 0x0057 }
        r3 = java.util.Locale.GERMAN;	 Catch:{ Exception -> 0x0057 }
        r5 = r5.toUpperCase(r3);	 Catch:{ Exception -> 0x0057 }
        goto L_0x0058;
    L_0x0057:
        r5 = r0;
    L_0x0058:
        if (r5 == 0) goto L_0x0062;
    L_0x005a:
        r0 = "";
        r0 = r5.equals(r0);
        if (r0 == 0) goto L_0x0072;
    L_0x0062:
        r5 = java.util.UUID.randomUUID();
        r5 = r5.toString();
        r0 = 45;
        r3 = 48;
        r5 = r5.replace(r0, r3);
    L_0x0072:
        r0 = new java.lang.StringBuffer;	 Catch:{ Exception -> 0x00b0 }
        r0.<init>();	 Catch:{ Exception -> 0x00b0 }
        r3 = "SHA-1";
        r3 = java.security.MessageDigest.getInstance(r3);	 Catch:{ Exception -> 0x00b0 }
        r3.reset();	 Catch:{ Exception -> 0x00b0 }
        r4 = "UTF-8";
        r5 = r5.getBytes(r4);	 Catch:{ Exception -> 0x00b0 }
        r3.update(r5);	 Catch:{ Exception -> 0x00b0 }
        r5 = r3.digest();	 Catch:{ Exception -> 0x00b0 }
    L_0x008d:
        r3 = r5.length;	 Catch:{ Exception -> 0x00b0 }
        if (r2 >= r3) goto L_0x00ab;
    L_0x0090:
        r3 = r5[r2];	 Catch:{ Exception -> 0x00b0 }
        r3 = r3 & 255;
        r4 = 16;
        if (r3 >= r4) goto L_0x009d;
    L_0x0098:
        r3 = "0";
        r0.append(r3);	 Catch:{ Exception -> 0x00b0 }
    L_0x009d:
        r3 = r5[r2];	 Catch:{ Exception -> 0x00b0 }
        r3 = r3 & 255;
        r3 = java.lang.Integer.toHexString(r3);	 Catch:{ Exception -> 0x00b0 }
        r0.append(r3);	 Catch:{ Exception -> 0x00b0 }
        r2 = r2 + 1;
        goto L_0x008d;
    L_0x00ab:
        r5 = r0.toString();	 Catch:{ Exception -> 0x00b0 }
        goto L_0x00b2;
    L_0x00b0:
        r5 = "0000000000000000";
    L_0x00b2:
        if (r1 == 0) goto L_0x00c0;
    L_0x00b4:
        r0 = r1.edit();
        r1 = "deviceId";
        r0.putString(r1, r5);
        r0.commit();
    L_0x00c0:
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.util.DeviceUtil.getDeviceId(android.content.Context):java.lang.String");
    }

    public static boolean isSupportedPlatform(boolean z) {
        Environment.loadCpuInfoLib();
        String cpuFeatures = getCpuFeatures();
        String cpuFamily = getCpuFamily();
        Object obj = (cpuFamily.equals("ARM") && cpuFeatures.contains("ARMv7") && cpuFeatures.contains("NEON")) ? 1 : null;
        boolean equals = cpuFamily.equals("ARM64");
        Object obj2 = (cpuFamily.equals("X86") && z) ? 1 : null;
        Object obj3 = (cpuFamily.equals("X86_64") && z) ? 1 : null;
        if (obj == null && !equals && obj2 == null && obj3 == null) {
            return false;
        }
        return true;
    }

    public static String getCpuFamily() {
        int cpuFamily = CpuInfo.getCpuFamily();
        switch (cpuFamily) {
            case 1:
                return "ARM";
            case 2:
                return "X86";
            case 3:
                return "MIPS";
            case 4:
                return "ARM64";
            case 5:
                return "X86_64";
            case 6:
                return "MIPS64";
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("UNKNOWN (");
                stringBuilder.append(cpuFamily);
                stringBuilder.append(")");
                return stringBuilder.toString();
        }
    }

    public static String getCpuFeatures() {
        int cpuFamily = CpuInfo.getCpuFamily();
        int cpuFeatures = CpuInfo.getCpuFeatures();
        String str = "";
        StringBuilder stringBuilder;
        if (cpuFamily != 4) {
            switch (cpuFamily) {
                case 1:
                    if ((cpuFeatures & 1) == 1) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(str);
                        stringBuilder.append("ARMv7 ");
                        str = stringBuilder.toString();
                    }
                    if ((cpuFeatures & 2) == 2) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(str);
                        stringBuilder.append("VFPv3 ");
                        str = stringBuilder.toString();
                    }
                    if ((cpuFeatures & 4) == 4) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(str);
                        stringBuilder.append("NEON ");
                        str = stringBuilder.toString();
                    }
                    if ((cpuFeatures & 8) == 8) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(str);
                        stringBuilder.append("LDREX_STREX ");
                        str = stringBuilder.toString();
                    }
                    if ((cpuFeatures & 16) == 16) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(str);
                        stringBuilder.append("VFPv2 ");
                        str = stringBuilder.toString();
                    }
                    if ((cpuFeatures & 32) == 32) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(str);
                        stringBuilder.append("VFP_D32 ");
                        str = stringBuilder.toString();
                    }
                    if ((cpuFeatures & 64) == 64) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(str);
                        stringBuilder.append("VFP_FP16 ");
                        str = stringBuilder.toString();
                    }
                    if ((cpuFeatures & 128) == 128) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(str);
                        stringBuilder.append("VFP_FMA ");
                        str = stringBuilder.toString();
                    }
                    if ((cpuFeatures & 256) == 256) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(str);
                        stringBuilder.append("NEON_FMA ");
                        str = stringBuilder.toString();
                    }
                    if ((cpuFeatures & 512) == 512) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(str);
                        stringBuilder.append("IDIV_ARM ");
                        str = stringBuilder.toString();
                    }
                    if ((cpuFeatures & 1024) == 1024) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(str);
                        stringBuilder.append("IDIV_THUMB2 ");
                        str = stringBuilder.toString();
                    }
                    if ((cpuFeatures & 2048) == 2048) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(str);
                        stringBuilder.append("iWMMXt ");
                        str = stringBuilder.toString();
                    }
                    if ((cpuFeatures & 4096) == 4096) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(str);
                        stringBuilder.append("AES ");
                        str = stringBuilder.toString();
                    }
                    if ((cpuFeatures & 8192) == 8192) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(str);
                        stringBuilder.append("PMULL ");
                        str = stringBuilder.toString();
                    }
                    if ((cpuFeatures & 16384) == 16384) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(str);
                        stringBuilder.append("SHA1 ");
                        str = stringBuilder.toString();
                    }
                    if ((32768 & cpuFeatures) == 32768) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(str);
                        stringBuilder.append("SHA2 ");
                        str = stringBuilder.toString();
                    }
                    if ((65536 & cpuFeatures) == 65536) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(str);
                        stringBuilder.append("CRC32 ");
                        str = stringBuilder.toString();
                    }
                    return str;
                case 2:
                    if ((cpuFeatures & 1) == 1) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(str);
                        stringBuilder.append("SSSE3 ");
                        str = stringBuilder.toString();
                    }
                    if ((cpuFeatures & 2) == 2) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(str);
                        stringBuilder.append("POPCNT ");
                        str = stringBuilder.toString();
                    }
                    if ((cpuFeatures & 4) == 4) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(str);
                        stringBuilder.append("MOVBE ");
                        str = stringBuilder.toString();
                    }
                    return str;
                default:
                    return "";
            }
        }
        if ((cpuFeatures & 1) == 1) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("FP ");
            str = stringBuilder.toString();
        }
        if ((cpuFeatures & 2) == 2) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("ASIMD ");
            str = stringBuilder.toString();
        }
        if ((cpuFeatures & 4) == 4) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("AES ");
            str = stringBuilder.toString();
        }
        if ((cpuFeatures & 8) == 8) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("PMULL ");
            str = stringBuilder.toString();
        }
        if ((cpuFeatures & 16) == 16) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("SHA1 ");
            str = stringBuilder.toString();
        }
        if ((cpuFeatures & 32) == 32) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("SHA2 ");
            str = stringBuilder.toString();
        }
        if ((cpuFeatures & 64) == 64) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("CRC32 ");
            str = stringBuilder.toString();
        }
        return str;
    }

    public static String getCpuCount(Context context) {
        return Integer.toString(CpuInfo.getCpuCount());
    }
}
