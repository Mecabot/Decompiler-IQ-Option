package org.apache.commons.lang3;

import java.io.PrintStream;

/* compiled from: SystemUtils */
public class d {
    public static final String eZD = getSystemProperty("line.separator");
    public static final String faA = getSystemProperty("java.specification.name");
    public static final String faB = getSystemProperty("java.specification.vendor");
    public static final String faC = getSystemProperty("java.specification.version");
    private static final JavaVersion faD = JavaVersion.get(faC);
    public static final String faE = getSystemProperty("java.util.prefs.PreferencesFactory");
    public static final String faF = getSystemProperty("java.vendor");
    public static final String faG = getSystemProperty("java.vendor.url");
    public static final String faH = getSystemProperty("java.version");
    public static final String faI = getSystemProperty("java.vm.info");
    public static final String faJ = getSystemProperty("java.vm.name");
    public static final String faK = getSystemProperty("java.vm.specification.name");
    public static final String faL = getSystemProperty("java.vm.specification.vendor");
    public static final String faM = getSystemProperty("java.vm.specification.version");
    public static final String faN = getSystemProperty("java.vm.vendor");
    public static final String faO = getSystemProperty("java.vm.version");
    public static final String faP = getSystemProperty("os.arch");
    public static final String faQ = getSystemProperty("os.name");
    public static final String faR = getSystemProperty("os.version");
    public static final String faS = getSystemProperty("path.separator");
    public static final String faT = getSystemProperty(getSystemProperty("user.country") == null ? "user.region" : "user.country");
    public static final String faU = getSystemProperty("user.dir");
    public static final String faV = getSystemProperty("user.home");
    public static final String faW = getSystemProperty("user.language");
    public static final String faX = getSystemProperty("user.name");
    public static final String faY = getSystemProperty("user.timezone");
    public static final boolean faZ = nj("1.1");
    public static final String fai = getSystemProperty("awt.toolkit");
    public static final String faj = getSystemProperty("file.encoding");
    public static final String fak = getSystemProperty("file.separator");
    public static final String fal = getSystemProperty("java.awt.fonts");
    public static final String fam = getSystemProperty("java.awt.graphicsenv");
    public static final String fan = getSystemProperty("java.awt.headless");
    public static final String fao = getSystemProperty("java.awt.printerjob");
    public static final String fap = getSystemProperty("java.class.path");
    public static final String far = getSystemProperty("java.class.version");
    public static final String fas = getSystemProperty("java.compiler");
    public static final String fat = getSystemProperty("java.endorsed.dirs");
    public static final String fau = getSystemProperty("java.ext.dirs");
    public static final String fav = getSystemProperty("java.home");
    public static final String faw = getSystemProperty("java.io.tmpdir");
    public static final String fax = getSystemProperty("java.library.path");
    public static final String fay = getSystemProperty("java.runtime.name");
    public static final String faz = getSystemProperty("java.runtime.version");
    public static final boolean fba = nj("1.2");
    public static final boolean fbb = nj("1.3");
    public static final boolean fbc = nj("1.4");
    public static final boolean fbd = nj("1.5");
    public static final boolean fbe = nj("1.6");
    public static final boolean fbf = nj("1.7");
    public static final boolean fbg = nk("AIX");
    public static final boolean fbh = nk("HP-UX");
    public static final boolean fbi = nk("Irix");
    public static final boolean fbj;
    public static final boolean fbk = nk("Mac");
    public static final boolean fbl = nk("Mac OS X");
    public static final boolean fbm = nk("OS/2");
    public static final boolean fbn = nk("Solaris");
    public static final boolean fbo = nk("SunOS");
    public static final boolean fbp;
    public static final boolean fbq = nk("Windows");
    public static final boolean fbr = bl("Windows", "5.0");
    public static final boolean fbs = bl("Windows 9", "4.0");
    public static final boolean fbt = bl("Windows 9", "4.1");
    public static final boolean fbu = bl("Windows", "4.9");
    public static final boolean fbv = nk("Windows NT");
    public static final boolean fbw = bl("Windows", "5.1");
    public static final boolean fbx = bl("Windows", "6.0");
    public static final boolean fby = bl("Windows", "6.1");

    static {
        boolean z = true;
        boolean z2 = nk("Linux") || nk("LINUX");
        fbj = z2;
        if (!(fbg || fbh || fbi || fbj || fbl || fbn || fbo)) {
            z = false;
        }
        fbp = z;
    }

    private static boolean nj(String str) {
        return bm(faC, str);
    }

    private static boolean bl(String str, String str2) {
        return f(faQ, faR, str, str2);
    }

    private static boolean nk(String str) {
        return bn(faQ, str);
    }

    private static String getSystemProperty(String str) {
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            PrintStream printStream = System.err;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Caught a SecurityException reading the system property '");
            stringBuilder.append(str);
            stringBuilder.append("'; the SystemUtils property value will default to null.");
            printStream.println(stringBuilder.toString());
            return null;
        }
    }

    static boolean bm(String str, String str2) {
        return str == null ? false : str.startsWith(str2);
    }

    static boolean f(String str, String str2, String str3, String str4) {
        boolean z = false;
        if (str == null || str2 == null) {
            return false;
        }
        if (str.startsWith(str3) && str2.startsWith(str4)) {
            z = true;
        }
        return z;
    }

    static boolean bn(String str, String str2) {
        return str == null ? false : str.startsWith(str2);
    }
}
