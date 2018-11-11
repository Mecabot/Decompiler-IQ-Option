package com.appsflyer;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.support.annotation.Nullable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class u {
    private static char[] qv = new char[]{6730, 30045, 50303, 22289, 42532, 12602, 32991, 5037, 25247, 64918, 19639, 56390, 12155, 48763, 2324, 38957, 60370, 31389, 54735, 9350, 47015, 1718, 38475, 57707, 28676, 49949, 21026, 44526, 15594, 36861, 7834, 27044, 63822, 18497, '1', '0', 62100, 40332, 11428, 49116, 20128, 55768, 26672, 64360, 35401, 5457, 42050, 13485, 51077, 22200, 57808, 28918, 798, 37423, 59174, 34877, 14614, 43625, 23365, 52313, 32228, 61145, 40893, 248, 45441, 8575, 53765, 17182, 62509, 25887, 5872, 34746, 10432, 55785, 19088, 64473, 27488, 7260, 36192, 15909, 44805, 20650, 49622, 29388, 58277, 38045, 'a', 28534, 56916, 19770, 48143, 11025, 39668, 2438, 30895, 59307, 22238, 50762, 13633, 42060, 4900, 33293, 61938, 24801, 53245, 16041, 44430, 7321, 35959, 64333, 27186, 42498, 51477, 30775, 60249, 6764, 36210, 15511, 45029, 57035, 16858, 61665, 24591, 37684, 570, 46401, 9326, 22477, 50856, 27062, 39109, 3056, 47860, 10753, 'a', 28534, 56916, 19770, 48143, 11025, 39668, 2438, 30895, 59307, 22238, 50761, 13651, 42049, 4926, 33291, 61908, 24825, 53187, 16035, 'a', 28534, 56916, 19770, 48143, 11025, 39668, 2438, 30894, 59325, 22148, 50726, 13685, 42058, 4921, '.', '\\', 28470, 'j', 28537, 56902, 19753, 48206, 11025, 39679, 2438, 30900, 59317, 22144, 50796, 13641, 42058, '/', 28539, 56913, 19755, 48136, 11037, '.', 28466, 56863, 19732, 48147, 11090, 39608, 2438, 30954, 59377, 44459, 49816, 29629, 57539, 4579, 34531, 14093, 42029, 54637, 19016, 64379, 27525, 39096, 2468, 48849, 12271, 23558, 'F', 28537, 56921, 19748, 48133, 11036, 39600, 2524, 30895, 59384, 22167, 50797, 13652, 42008, 4915, 33289, 61923, 24816, 53205, 16104, 44432, 7321, 35940, 64320, 27232, 55599, 18457, 47100, 9928, 38296, 1205, 29584, 58211, 21117, 49472, 12348, 40713, 3607, 32254, 60562, 23520, 'g', 28541, 56900, 19713, 48142, 11019, 39652, 2505, 30892, 59316, 22165, 50796, 13665, 42056, 4896, 33284, 61929, 24827, 53201, 16060, 44425, 7319, 35966, 64347, 45389, 56958, 28507, 64549, 3333, 39429, 11243, 47307, 51612, 22195, 59288, 30570, 33867, 5461, 41514, 13091, 16630, 53749, 32475, 36790, 7322, 44447, 15729, 19016, 31460, 5595, 42235, 14214, 50855, 20926, 57362, 29539, 524, 40204, 11325, 48321, 20455, 57018, 27008, 63663, 35652, 6742, 46455, 17417, 55094, 26175, 63190, 33194, 4239, 41887, 12966, 52546, 23661, 61310, 32338, 2365, 39371, 10446, 48122, 19146, 58791, 29858, 1873, 38511, 8466, 45070, 17211, 54213, 25324, 64928, 36050};
    private static long qw = -3596787634459676904L;
    private static int qx = 0;
    private static int qy = 1;

    @Nullable
    static String a(Context context, long j) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder2.append((aD(a(34, 0, 6699).intern()) ? a(1, 34, 0) : a(1, 35, 0)).intern());
        StringBuilder stringBuilder4 = new StringBuilder();
        String packageName = context.getPackageName();
        String at = at(packageName);
        stringBuilder2.append(a(1, 34, 0).intern());
        stringBuilder4.append(at);
        if ((B(context) == null ? 13 : 15) != 15) {
            int i = qx + 27;
            qy = i % 128;
            i %= 2;
            stringBuilder2.append(a(1, 35, 0).intern());
            stringBuilder4.append(packageName);
        } else {
            stringBuilder2.append(a(1, 34, 0).intern());
            stringBuilder4.append(packageName);
        }
        at = C(context);
        if ((at == null ? null : 1) != 1) {
            stringBuilder2.append(a(1, 35, 0).intern());
            stringBuilder4.append(packageName);
        } else {
            stringBuilder2.append(a(1, 34, 0).intern());
            stringBuilder4.append(at);
        }
        Context context2 = context;
        stringBuilder4.append(h(context2, packageName));
        stringBuilder.append(stringBuilder4.toString());
        try {
            String a;
            long j2 = context2.getPackageManager().getPackageInfo(context2.getPackageName(), 0).firstInstallTime;
            DateFormat simpleDateFormat = new SimpleDateFormat(a(18, 36, 62189).intern(), Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            stringBuilder.append(simpleDateFormat.format(new Date(j2)));
            stringBuilder.append(j);
            stringBuilder3.append((aD(a(25, 86, 0).intern()) ? a(1, 34, 0) : a(1, 35, 0)).intern());
            stringBuilder3.append((aD(a(23, 111, 42595).intern()) ? a(1, 34, 0) : a(1, 35, 0)).intern());
            if (aD(a(20, 134, 0).intern())) {
                int i2 = qy + 37;
                qx = i2 % 128;
                i2 %= 2;
                a = a(1, 34, 0);
            } else {
                a = a(1, 35, 0);
            }
            stringBuilder3.append(a.intern());
            stringBuilder3.append(((aD(a(15, 154, 0).intern()) ? 27 : 21) != 21 ? a(1, 34, 0) : a(1, 35, 0)).intern());
            String aG = ae.aG(ae.aH(stringBuilder.toString()));
            String obj = stringBuilder2.toString();
            stringBuilder4 = new StringBuilder(aG);
            stringBuilder4.setCharAt(17, Integer.toString(Integer.parseInt(obj, 2), 16).charAt(0));
            aG = stringBuilder4.toString();
            obj = stringBuilder3.toString();
            stringBuilder3 = new StringBuilder(aG);
            stringBuilder3.setCharAt(27, Integer.toString(Integer.parseInt(obj, 2), 16).charAt(0));
            return a(stringBuilder3.toString(), Long.valueOf(j));
        } catch (NameNotFoundException unused) {
            return a(32, 54, 59204).intern();
        }
    }

    private static String a(String str, Long l) {
        if (str != null) {
            int i = qy + 73;
            qx = i % 128;
            i %= 2;
            if (l != null && str.length() == 32) {
                int i2;
                StringBuilder stringBuilder = new StringBuilder(str);
                str = l.toString();
                long j = 0;
                int i3 = 0;
                for (i2 = 0; i2 < str.length(); i2++) {
                    i3 += Character.getNumericValue(str.charAt(i2));
                }
                str = Integer.toHexString(i3);
                stringBuilder.replace(7, str.length() + 7, str);
                int i4 = 0;
                while (i4 < stringBuilder.length()) {
                    long numericValue;
                    i2 = qy + 101;
                    qx = i2 % 128;
                    if ((i2 % 2 != 0 ? 76 : 40) != 76) {
                        numericValue = j + ((long) Character.getNumericValue(stringBuilder.charAt(i4)));
                        i4++;
                    } else {
                        numericValue = j | ((long) Character.getNumericValue(stringBuilder.charAt(i4)));
                        i4 += 90;
                    }
                    j = numericValue;
                }
                while (true) {
                    if ((j > 100 ? null : 1) != null) {
                        break;
                    }
                    j %= 100;
                }
                stringBuilder.insert(23, (int) j);
                if ((j < 10 ? 82 : 74) != 74) {
                    i4 = qx + 103;
                    qy = i4 % 128;
                    i4 %= 2;
                    stringBuilder.insert(23, a(1, 35, 0).intern());
                }
                return stringBuilder.toString();
            }
        }
        return a(32, 54, 59204).intern();
    }

    private static boolean aD(String str) {
        boolean z;
        int i = qy + 29;
        qx = i % 128;
        Object obj = 1;
        if ((i % 2 != 0 ? 13 : 11) != 13) {
            try {
                Class.forName(str);
                z = true;
            } catch (ClassNotFoundException unused) {
                return false;
            }
        }
        Class.forName(str);
        z = false;
        i = qy + 31;
        qx = i % 128;
        if (i % 2 == 0) {
            obj = null;
        }
        if (obj != null) {
            Object[] objArr = null;
            i = objArr.length;
        }
        return z;
    }

    private static String at(String str) {
        int i = qx + 57;
        qy = i % 128;
        if (!(i % 2 == 0 ? 71 : 64) == 71 ? str.contains(a(1, 169, 0).intern()) : str.contains(a(0, 4947, 0).intern())) {
            return str;
        }
        String[] split = str.split(a(2, 170, 0).intern());
        i = split.length;
        StringBuilder stringBuilder = new StringBuilder();
        i--;
        stringBuilder.append(split[i]);
        stringBuilder.append(a(1, 169, 0).intern());
        for (int i2 = 1; i2 < i; i2++) {
            stringBuilder.append(split[i2]);
            stringBuilder.append(a(1, 169, 0).intern());
        }
        stringBuilder.append(split[0]);
        str = stringBuilder.toString();
        i = qy + 3;
        qx = i % 128;
        if ((i % 2 != 0 ? 87 : 46) != 87) {
            return str;
        }
        Object obj = null;
        super.hashCode();
        return str;
    }

    private static String B(Context context) {
        int i = qy + 49;
        qx = i % 128;
        i %= 2;
        String str = null;
        if ((System.getProperties().containsKey(a(14, 172, 0).intern()) ? null : 1) == null) {
            i = qy + 23;
            qx = i % 128;
            i %= 2;
            try {
                Matcher matcher = Pattern.compile(a(10, 192, 0).intern()).matcher(context.getCacheDir().getPath().replace(a(6, 186, 0).intern(), ""));
                if ((matcher.find() ? null : 1) == null) {
                    i = qy + 29;
                    qx = i % 128;
                    str = i % 2 != 0 ? matcher.group(0) : matcher.group(1);
                }
            } catch (Exception e) {
                ah ge = ah.ge();
                String intern = a(17, 202, 44520).intern();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(a(41, 219, 0).intern());
                stringBuilder.append(e);
                ge.h(intern, stringBuilder.toString());
                return null;
            }
        }
        return str;
    }

    private static String C(Context context) {
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
            int i = qy + 105;
            qx = i % 128;
            if (i % 2 != 0) {
            }
            i = qy + 49;
            qx = i % 128;
            if ((i % 2 != 0 ? 1 : 0) != 1) {
                return str;
            }
            i = 56 / 0;
            return str;
        } catch (NameNotFoundException unused) {
            return null;
        }
    }

    /* JADX WARNING: Missing block: B:14:0x005a, code:
            r12 = qy + 37;
            qx = r12 % 128;
     */
    /* JADX WARNING: Missing block: B:15:0x0064, code:
            if ((r12 % 2) == 0) goto L_0x0071;
     */
    /* JADX WARNING: Missing block: B:17:?, code:
            r12 = java.lang.Boolean.TRUE.toString();
            r13 = null;
            super.hashCode();
     */
    /* JADX WARNING: Missing block: B:18:0x0070, code:
            return r12;
     */
    /* JADX WARNING: Missing block: B:20:0x0077, code:
            return java.lang.Boolean.TRUE.toString();
     */
    private static java.lang.String h(android.content.Context r12, java.lang.String r13) {
        /*
        r12 = r12.getPackageManager();
        r0 = 31394; // 0x7aa2 float:4.3992E-41 double:1.55107E-319;
        r1 = 308; // 0x134 float:4.32E-43 double:1.52E-321;
        r2 = 47;
        r3 = 45326; // 0xb10e float:6.3515E-41 double:2.2394E-319;
        r4 = 284; // 0x11c float:3.98E-43 double:1.403E-321;
        r5 = 24;
        r6 = android.content.pm.PackageManager.class;
        r7 = 260; // 0x104 float:3.64E-43 double:1.285E-321;
        r8 = 0;
        r7 = a(r5, r7, r8);	 Catch:{ IllegalAccessException -> 0x00d3, NoSuchMethodException -> 0x00ab, InvocationTargetException -> 0x0083 }
        r7 = r7.intern();	 Catch:{ IllegalAccessException -> 0x00d3, NoSuchMethodException -> 0x00ab, InvocationTargetException -> 0x0083 }
        r9 = 1;
        r10 = new java.lang.Class[r9];	 Catch:{ IllegalAccessException -> 0x00d3, NoSuchMethodException -> 0x00ab, InvocationTargetException -> 0x0083 }
        r11 = java.lang.Integer.TYPE;	 Catch:{ IllegalAccessException -> 0x00d3, NoSuchMethodException -> 0x00ab, InvocationTargetException -> 0x0083 }
        r10[r8] = r11;	 Catch:{ IllegalAccessException -> 0x00d3, NoSuchMethodException -> 0x00ab, InvocationTargetException -> 0x0083 }
        r6 = r6.getDeclaredMethod(r7, r10);	 Catch:{ IllegalAccessException -> 0x00d3, NoSuchMethodException -> 0x00ab, InvocationTargetException -> 0x0083 }
        r7 = new java.lang.Object[r9];	 Catch:{ IllegalAccessException -> 0x00d3, NoSuchMethodException -> 0x00ab, InvocationTargetException -> 0x0083 }
        r10 = java.lang.Integer.valueOf(r8);	 Catch:{ IllegalAccessException -> 0x00d3, NoSuchMethodException -> 0x00ab, InvocationTargetException -> 0x0083 }
        r7[r8] = r10;	 Catch:{ IllegalAccessException -> 0x00d3, NoSuchMethodException -> 0x00ab, InvocationTargetException -> 0x0083 }
        r12 = r6.invoke(r12, r7);	 Catch:{ IllegalAccessException -> 0x00d3, NoSuchMethodException -> 0x00ab, InvocationTargetException -> 0x0083 }
        r12 = (java.util.List) r12;	 Catch:{ IllegalAccessException -> 0x00d3, NoSuchMethodException -> 0x00ab, InvocationTargetException -> 0x0083 }
        r12 = r12.iterator();	 Catch:{ IllegalAccessException -> 0x00d3, NoSuchMethodException -> 0x00ab, InvocationTargetException -> 0x0083 }
    L_0x003b:
        r6 = r12.hasNext();	 Catch:{ IllegalAccessException -> 0x00d3, NoSuchMethodException -> 0x00ab, InvocationTargetException -> 0x0083 }
        if (r6 == 0) goto L_0x0043;
    L_0x0041:
        r6 = 1;
        goto L_0x0044;
    L_0x0043:
        r6 = 0;
    L_0x0044:
        if (r6 == 0) goto L_0x0078;
    L_0x0046:
        r6 = r12.next();	 Catch:{ IllegalAccessException -> 0x00d3, NoSuchMethodException -> 0x00ab, InvocationTargetException -> 0x0083 }
        r6 = (android.content.pm.ApplicationInfo) r6;	 Catch:{ IllegalAccessException -> 0x00d3, NoSuchMethodException -> 0x00ab, InvocationTargetException -> 0x0083 }
        r6 = r6.packageName;	 Catch:{ IllegalAccessException -> 0x00d3, NoSuchMethodException -> 0x00ab, InvocationTargetException -> 0x0083 }
        r6 = r6.equals(r13);	 Catch:{ IllegalAccessException -> 0x00d3, NoSuchMethodException -> 0x00ab, InvocationTargetException -> 0x0083 }
        if (r6 == 0) goto L_0x0056;
    L_0x0054:
        r6 = 0;
        goto L_0x0057;
    L_0x0056:
        r6 = 1;
    L_0x0057:
        if (r6 == 0) goto L_0x005a;
    L_0x0059:
        goto L_0x003b;
    L_0x005a:
        r12 = qy;
        r12 = r12 + 37;
        r13 = r12 % 128;
        qx = r13;
        r12 = r12 % 2;
        if (r12 == 0) goto L_0x0071;
    L_0x0066:
        r12 = java.lang.Boolean.TRUE;	 Catch:{ IllegalAccessException -> 0x00d3, NoSuchMethodException -> 0x00ab, InvocationTargetException -> 0x0083 }
        r12 = r12.toString();	 Catch:{ IllegalAccessException -> 0x00d3, NoSuchMethodException -> 0x00ab, InvocationTargetException -> 0x0083 }
        r13 = 0;
        super.hashCode();	 Catch:{ IllegalAccessException -> 0x00d3, NoSuchMethodException -> 0x00ab, InvocationTargetException -> 0x0083 }
        return r12;
    L_0x0071:
        r12 = java.lang.Boolean.TRUE;	 Catch:{ IllegalAccessException -> 0x00d3, NoSuchMethodException -> 0x00ab, InvocationTargetException -> 0x0083 }
        r12 = r12.toString();	 Catch:{ IllegalAccessException -> 0x00d3, NoSuchMethodException -> 0x00ab, InvocationTargetException -> 0x0083 }
        return r12;
    L_0x0078:
        r12 = qy;
        r12 = r12 + 69;
        r13 = r12 % 128;
        qx = r13;
        r12 = r12 % 2;
        goto L_0x00fa;
    L_0x0083:
        r12 = move-exception;
        r13 = com.appsflyer.ah.ge();
        r3 = a(r5, r4, r3);
        r3 = r3.intern();
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r0 = a(r2, r1, r0);
        r0 = r0.intern();
        r4.append(r0);
        r4.append(r12);
        r12 = r4.toString();
        r13.h(r3, r12);
        goto L_0x00fa;
    L_0x00ab:
        r12 = move-exception;
        r13 = com.appsflyer.ah.ge();
        r3 = a(r5, r4, r3);
        r3 = r3.intern();
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r0 = a(r2, r1, r0);
        r0 = r0.intern();
        r4.append(r0);
        r4.append(r12);
        r12 = r4.toString();
        r13.h(r3, r12);
        goto L_0x00fa;
    L_0x00d3:
        r12 = move-exception;
        r13 = com.appsflyer.ah.ge();
        r3 = a(r5, r4, r3);
        r3 = r3.intern();
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r0 = a(r2, r1, r0);
        r0 = r0.intern();
        r4.append(r0);
        r4.append(r12);
        r12 = r4.toString();
        r13.h(r3, r12);
    L_0x00fa:
        r12 = java.lang.Boolean.FALSE;
        r12 = r12.toString();
        return r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.u.h(android.content.Context, java.lang.String):java.lang.String");
    }

    private static String a(int i, int i2, char c) {
        char[] cArr = new char[i];
        int i3 = 0;
        int i4 = qx + 13;
        qy = i4 % 128;
        i4 %= 2;
        while (true) {
            if ((i3 < i ? 21 : 36) != 21) {
                return new String(cArr);
            }
            i4 = qx + 43;
            qy = i4 % 128;
            i4 %= 2;
            cArr[i3] = (char) ((int) ((((long) qv[i2 + i3]) ^ (((long) i3) * qw)) ^ ((long) c)));
            i3++;
        }
    }
}
