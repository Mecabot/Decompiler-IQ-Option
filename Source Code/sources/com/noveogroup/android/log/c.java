package com.noveogroup.android.log;

import com.noveogroup.android.log.Logger.Level;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.WeakHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: LoggerManager */
public final class c {
    private static final Logger ebA = new f("ROOT", ebz);
    private static final Pattern ebB = Pattern.compile("(.*?):(.*?)(:(.*))?");
    private static final Map<String, b> ebC = Collections.unmodifiableMap(aRF());
    private static final Map<String, Logger> ebD = new WeakHashMap();
    private static final b ebz = new e(Level.VERBOSE, "%logger", "%date %caller%n");

    private c() {
        throw new UnsupportedOperationException();
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x002f  */
    private static void a(java.util.Properties r3) {
        /*
        r0 = 0;
        r1 = com.noveogroup.android.log.c.class;
        r1 = r1.getClassLoader();	 Catch:{ all -> 0x002c }
        r2 = "android-logger.properties";
        r1 = r1.getResourceAsStream(r2);	 Catch:{ all -> 0x002c }
        if (r1 == 0) goto L_0x0017;
    L_0x000f:
        r3.load(r1);	 Catch:{ all -> 0x0014 }
        r0 = r1;
        goto L_0x0026;
    L_0x0014:
        r3 = move-exception;
        r0 = r1;
        goto L_0x002d;
    L_0x0017:
        r0 = java.lang.ClassLoader.getSystemClassLoader();	 Catch:{ all -> 0x0014 }
        r2 = "android-logger.properties";
        r0 = r0.getResourceAsStream(r2);	 Catch:{ all -> 0x0014 }
        if (r0 == 0) goto L_0x0026;
    L_0x0023:
        r3.load(r0);	 Catch:{ all -> 0x002c }
    L_0x0026:
        if (r0 == 0) goto L_0x002b;
    L_0x0028:
        r0.close();
    L_0x002b:
        return;
    L_0x002c:
        r3 = move-exception;
    L_0x002d:
        if (r0 == 0) goto L_0x0032;
    L_0x002f:
        r0.close();
    L_0x0032:
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.noveogroup.android.log.c.a(java.util.Properties):void");
    }

    private static b kZ(String str) {
        Matcher matcher = ebB.matcher(str);
        if (matcher.matches()) {
            str = matcher.group(1);
            String group = matcher.group(2);
            String group2 = matcher.group(4);
            if (group.length() > 23) {
                ebA.f("Android doesn't support tags %d characters longer. Tag '%s' will be trimmed to '%s'", Integer.valueOf(23), group, group.substring(0, 23));
                group = r6;
            }
            try {
                return new e(Level.valueOf(str), group, group2);
            } catch (IllegalArgumentException unused) {
                ebA.f("Cannot parse '%s' as logging level. Only %s are allowed", str, Arrays.toString(Level.values()));
                return null;
            }
        }
        ebA.f("Wrong format of logger configuration: '%s'", str);
        return null;
    }

    private static Map<String, b> aRF() {
        Map<String, b> hashMap = new HashMap();
        Properties properties = new Properties();
        try {
            a(properties);
            if (properties.propertyNames().hasMoreElements()) {
                Enumeration propertyNames = properties.propertyNames();
                while (propertyNames.hasMoreElements()) {
                    String str = (String) propertyNames.nextElement();
                    b kZ = kZ(properties.getProperty(str));
                    if (kZ != null) {
                        if (str.equals("root")) {
                            hashMap.put(null, kZ);
                        } else if (str.startsWith("logger.")) {
                            Object substring = str.substring("logger.".length());
                            if (substring.equalsIgnoreCase("ROOT")) {
                                substring = null;
                            }
                            hashMap.put(substring, kZ);
                        } else {
                            ebA.g("unknown key '%s' in '%s' file", str, "android-logger.properties");
                        }
                    }
                }
                if (!hashMap.containsKey(null)) {
                    hashMap.put(null, ebz);
                }
                return hashMap;
            }
            ebA.g("Logger configuration file is empty. Default configuration will be used", new Object[0]);
            hashMap.put(null, ebz);
            return hashMap;
        } catch (Throwable e) {
            ebA.a(e, "Cannot configure logger from '%s'. Default configuration will be used", "android-logger.properties");
            hashMap.put(null, ebz);
            return hashMap;
        }
    }

    private static b la(String str) {
        Object obj = null;
        if (str != null) {
            for (String str2 : ebC.keySet()) {
                if (str2 != null && str.startsWith(str2)) {
                    if ((str2.length() >= str.length() || str.charAt(str2.length()) == '.' || str.charAt(str2.length()) == '$') && (r0 == null || r0.length() < str2.length())) {
                        String str3 = str2;
                    }
                }
            }
        }
        b bVar = (b) ebC.get(obj);
        return bVar != null ? bVar : ebz;
    }

    public static Logger lb(String str) {
        Logger logger;
        synchronized (ebD) {
            logger = (Logger) ebD.get(str);
        }
        if (logger == null) {
            logger = new f(str, la(str));
            synchronized (ebD) {
                ebD.put(logger.getName(), logger);
            }
        }
        return logger;
    }
}
