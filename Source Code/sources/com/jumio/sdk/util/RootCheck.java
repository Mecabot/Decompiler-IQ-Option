package com.jumio.sdk.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public final class RootCheck {
    private static final String[] dangerousAppPackages = new String[]{"com.koushikdutta.rommanager", "com.dimonvideo.luckypatcher", "com.chelpus.lackypatch", "com.ramdroid.appquarantine"};
    private static final String[] rootAppPackages = new String[]{"com.noshufou.android.su", "com.noshufou.android.su.elite", "eu.chainfire.supersu", "com.koushikdutta.superuser", "com.thirdparty.superuser", "com.yellowes.su"};

    public static boolean isRooted(Context context) {
        Map hashMap = new HashMap();
        hashMap.put("ro.debuggable", "1");
        hashMap.put("ro.secure", "0");
        int i = 0;
        int checkPackages = checkPackages(context, dangerousAppPackages) | (checkPackages(context, rootAppPackages) | 0);
        int i2 = (checkBinaryExists("su") || checkWhichBinary("su")) ? 1 : 0;
        checkPackages |= i2;
        i2 = (checkBinaryExists("busybox") || checkWhichBinary("busybox")) ? 1 : 0;
        checkPackages = (checkPackages | i2) | checkProps(hashMap);
        if (Build.TAGS != null && Build.TAGS.contains("test-keys")) {
            i = 1;
        }
        return checkPackages | i;
    }

    private static boolean checkBinaryExists(String str) {
        boolean z = false;
        for (String str2 : System.getenv("PATH").split(":")) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str2);
            stringBuilder.append(File.separator);
            stringBuilder.append(str);
            z |= new File(stringBuilder.toString()).exists();
        }
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x004f A:{SYNTHETIC, Splitter: B:28:0x004f} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0054 A:{Catch:{ Exception -> 0x0057 }} */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x004f A:{SYNTHETIC, Splitter: B:28:0x004f} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0054 A:{Catch:{ Exception -> 0x0057 }} */
    private static boolean checkWhichBinary(java.lang.String r7) {
        /*
        r0 = 0;
        r1 = 0;
        r2 = java.lang.Runtime.getRuntime();	 Catch:{ Throwable -> 0x0058, all -> 0x004b }
        r3 = 2;
        r3 = new java.lang.String[r3];	 Catch:{ Throwable -> 0x0058, all -> 0x004b }
        r4 = "which";
        r3[r1] = r4;	 Catch:{ Throwable -> 0x0058, all -> 0x004b }
        r4 = 1;
        r3[r4] = r7;	 Catch:{ Throwable -> 0x0058, all -> 0x004b }
        r7 = r2.exec(r3);	 Catch:{ Throwable -> 0x0058, all -> 0x004b }
        r2 = new java.io.BufferedReader;	 Catch:{ Throwable -> 0x0059, all -> 0x0046 }
        r3 = new java.io.InputStreamReader;	 Catch:{ Throwable -> 0x0059, all -> 0x0046 }
        r5 = r7.getInputStream();	 Catch:{ Throwable -> 0x0059, all -> 0x0046 }
        r3.<init>(r5);	 Catch:{ Throwable -> 0x0059, all -> 0x0046 }
        r2.<init>(r3);	 Catch:{ Throwable -> 0x0059, all -> 0x0046 }
        r0 = r2.readLine();	 Catch:{ Throwable -> 0x0044, all -> 0x003f }
        if (r0 == 0) goto L_0x0034;
    L_0x0029:
        if (r7 == 0) goto L_0x002e;
    L_0x002b:
        r7.destroy();	 Catch:{ Exception -> 0x0033 }
    L_0x002e:
        if (r2 == 0) goto L_0x0033;
    L_0x0030:
        r2.close();	 Catch:{ Exception -> 0x0033 }
    L_0x0033:
        return r4;
    L_0x0034:
        if (r7 == 0) goto L_0x0039;
    L_0x0036:
        r7.destroy();	 Catch:{ Exception -> 0x003e }
    L_0x0039:
        if (r2 == 0) goto L_0x003e;
    L_0x003b:
        r2.close();	 Catch:{ Exception -> 0x003e }
    L_0x003e:
        return r1;
    L_0x003f:
        r0 = move-exception;
        r6 = r0;
        r0 = r7;
        r7 = r6;
        goto L_0x004d;
    L_0x0044:
        r0 = r2;
        goto L_0x0059;
    L_0x0046:
        r1 = move-exception;
        r2 = r0;
        r0 = r7;
        r7 = r1;
        goto L_0x004d;
    L_0x004b:
        r7 = move-exception;
        r2 = r0;
    L_0x004d:
        if (r0 == 0) goto L_0x0052;
    L_0x004f:
        r0.destroy();	 Catch:{ Exception -> 0x0057 }
    L_0x0052:
        if (r2 == 0) goto L_0x0057;
    L_0x0054:
        r2.close();	 Catch:{ Exception -> 0x0057 }
    L_0x0057:
        throw r7;
    L_0x0058:
        r7 = r0;
    L_0x0059:
        if (r7 == 0) goto L_0x005e;
    L_0x005b:
        r7.destroy();	 Catch:{ Exception -> 0x0063 }
    L_0x005e:
        if (r0 == 0) goto L_0x0063;
    L_0x0060:
        r0.close();	 Catch:{ Exception -> 0x0063 }
    L_0x0063:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.sdk.util.RootCheck.checkWhichBinary(java.lang.String):boolean");
    }

    private static boolean checkPackages(Context context, String[] strArr) {
        PackageManager packageManager = context.getPackageManager();
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            try {
                packageManager.getPackageInfo(strArr[i], 0);
                return true;
            } catch (NameNotFoundException unused) {
                i++;
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0094 A:{SYNTHETIC, Splitter: B:29:0x0094} */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0099 A:{Catch:{ Exception -> 0x009c }} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0094 A:{SYNTHETIC, Splitter: B:29:0x0094} */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0099 A:{Catch:{ Exception -> 0x009c }} */
    private static boolean checkProps(java.util.Map<java.lang.String, java.lang.String> r8) {
        /*
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "\\[(";
        r0.append(r1);
        r1 = r8.keySet();
        r1 = r1.iterator();
    L_0x0012:
        r2 = r1.hasNext();
        if (r2 == 0) goto L_0x0028;
    L_0x0018:
        r2 = r1.next();
        r2 = (java.lang.String) r2;
        r0.append(r2);
        r2 = "|";
        r0.append(r2);
        goto L_0x0012;
    L_0x0028:
        r1 = r0.length();
        r2 = 1;
        r1 = r1 - r2;
        r0.deleteCharAt(r1);
        r1 = ")\\]: \\[(.*)\\]";
        r0.append(r1);
        r0 = r0.toString();
        r0 = java.util.regex.Pattern.compile(r0);
        r1 = 0;
        r3 = 0;
        r4 = java.lang.Runtime.getRuntime();	 Catch:{ Exception -> 0x009d, all -> 0x0090 }
        r5 = "getprop";
        r4 = r4.exec(r5);	 Catch:{ Exception -> 0x009d, all -> 0x0090 }
        r5 = new java.io.BufferedReader;	 Catch:{ Exception -> 0x009e, all -> 0x008e }
        r6 = new java.io.InputStreamReader;	 Catch:{ Exception -> 0x009e, all -> 0x008e }
        r7 = r4.getInputStream();	 Catch:{ Exception -> 0x009e, all -> 0x008e }
        r6.<init>(r7);	 Catch:{ Exception -> 0x009e, all -> 0x008e }
        r5.<init>(r6);	 Catch:{ Exception -> 0x009e, all -> 0x008e }
    L_0x0058:
        r3 = r5.readLine();	 Catch:{ Exception -> 0x008c, all -> 0x0089 }
        if (r3 == 0) goto L_0x007e;
    L_0x005e:
        r3 = r0.matcher(r3);	 Catch:{ Exception -> 0x008c, all -> 0x0089 }
        r6 = r3.find();	 Catch:{ Exception -> 0x008c, all -> 0x0089 }
        if (r6 == 0) goto L_0x0058;
    L_0x0068:
        r6 = r3.group(r2);	 Catch:{ Exception -> 0x008c, all -> 0x0089 }
        r6 = r8.get(r6);	 Catch:{ Exception -> 0x008c, all -> 0x0089 }
        r6 = (java.lang.String) r6;	 Catch:{ Exception -> 0x008c, all -> 0x0089 }
        r7 = 2;
        r3 = r3.group(r7);	 Catch:{ Exception -> 0x008c, all -> 0x0089 }
        r3 = r6.equals(r3);	 Catch:{ Exception -> 0x008c, all -> 0x0089 }
        if (r3 == 0) goto L_0x0058;
    L_0x007d:
        r1 = 1;
    L_0x007e:
        if (r4 == 0) goto L_0x0083;
    L_0x0080:
        r4.destroy();	 Catch:{ Exception -> 0x00a8 }
    L_0x0083:
        if (r5 == 0) goto L_0x00a8;
    L_0x0085:
        r5.close();	 Catch:{ Exception -> 0x00a8 }
        goto L_0x00a8;
    L_0x0089:
        r8 = move-exception;
        r3 = r5;
        goto L_0x0092;
    L_0x008c:
        r3 = r5;
        goto L_0x009e;
    L_0x008e:
        r8 = move-exception;
        goto L_0x0092;
    L_0x0090:
        r8 = move-exception;
        r4 = r3;
    L_0x0092:
        if (r4 == 0) goto L_0x0097;
    L_0x0094:
        r4.destroy();	 Catch:{ Exception -> 0x009c }
    L_0x0097:
        if (r3 == 0) goto L_0x009c;
    L_0x0099:
        r3.close();	 Catch:{ Exception -> 0x009c }
    L_0x009c:
        throw r8;
    L_0x009d:
        r4 = r3;
    L_0x009e:
        if (r4 == 0) goto L_0x00a3;
    L_0x00a0:
        r4.destroy();	 Catch:{ Exception -> 0x00a8 }
    L_0x00a3:
        if (r3 == 0) goto L_0x00a8;
    L_0x00a5:
        r3.close();	 Catch:{ Exception -> 0x00a8 }
    L_0x00a8:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.sdk.util.RootCheck.checkProps(java.util.Map):boolean");
    }
}
