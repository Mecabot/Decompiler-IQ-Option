package org.slf4j;

import java.net.URL;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.slf4j.helpers.a;
import org.slf4j.helpers.d;
import org.slf4j.impl.b;

/* compiled from: LoggerFactory */
public final class c {
    static int fdl = 0;
    static org.slf4j.helpers.c fdm = new org.slf4j.helpers.c();
    static a fdn = new a();
    static boolean fdo = Boolean.getBoolean("slf4j.detectLoggerNameMismatch");
    private static final String[] fdp = new String[]{"1.6", "1.7"};
    private static String fdq = "org/slf4j/impl/StaticLoggerBinder.class";

    private c() {
    }

    private static final void bCa() {
        bind();
        if (fdl == 3) {
            bCc();
        }
    }

    private static boolean nK(String str) {
        if (str == null) {
            return false;
        }
        return (str.indexOf("org/slf4j/impl/StaticLoggerBinder") == -1 && str.indexOf("org.slf4j.impl.StaticLoggerBinder") == -1) ? false : true;
    }

    private static final void bind() {
        try {
            Set bCd = bCd();
            p(bCd);
            b.bCi();
            fdl = 3;
            q(bCd);
            bCb();
        } catch (Throwable e) {
            if (nK(e.getMessage())) {
                fdl = 4;
                d.nL("Failed to load class \"org.slf4j.impl.StaticLoggerBinder\".");
                d.nL("Defaulting to no-operation (NOP) logger implementation");
                d.nL("See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.");
                return;
            }
            ai(e);
            throw e;
        } catch (NoSuchMethodError e2) {
            String message = e2.getMessage();
            if (!(message == null || message.indexOf("org.slf4j.impl.StaticLoggerBinder.getSingleton()") == -1)) {
                fdl = 2;
                d.nL("slf4j-api 1.6.x (or later) is incompatible with this binding.");
                d.nL("Your binding is version 1.5.5 or earlier.");
                d.nL("Upgrade your binding to version 1.6.x.");
            }
            throw e2;
        } catch (Throwable e3) {
            ai(e3);
            throw new IllegalStateException("Unexpected initialization failure", e3);
        }
    }

    static void ai(Throwable th) {
        fdl = 2;
        d.f("Failed to instantiate SLF4J LoggerFactory", th);
    }

    private static final void bCb() {
        List<org.slf4j.helpers.b> bCg = fdm.bCg();
        if (!bCg.isEmpty()) {
            d.nL("The following set of substitute loggers may have been accessed");
            d.nL("during the initialization phase. Logging calls during this");
            d.nL("phase were not honored. However, subsequent logging calls to these");
            d.nL("loggers will work as normally expected.");
            d.nL("See also http://www.slf4j.org/codes.html#substituteLogger");
            for (org.slf4j.helpers.b bVar : bCg) {
                bVar.a(nJ(bVar.getName()));
                d.nL(bVar.getName());
            }
            fdm.clear();
        }
    }

    private static final void bCc() {
        try {
            String str = b.REQUESTED_API_VERSION;
            Object obj = null;
            for (String startsWith : fdp) {
                if (str.startsWith(startsWith)) {
                    obj = 1;
                }
            }
            if (obj == null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("The requested version ");
                stringBuilder.append(str);
                stringBuilder.append(" by your slf4j binding is not compatible with ");
                stringBuilder.append(Arrays.asList(fdp).toString());
                d.nL(stringBuilder.toString());
                d.nL("See http://www.slf4j.org/codes.html#version_mismatch for further details.");
            }
        } catch (NoSuchFieldError unused) {
        } catch (Throwable th) {
            d.f("Unexpected problem occured during version sanity check", th);
        }
    }

    private static Set<URL> bCd() {
        Set<URL> linkedHashSet = new LinkedHashSet();
        try {
            Enumeration systemResources;
            ClassLoader classLoader = c.class.getClassLoader();
            if (classLoader == null) {
                systemResources = ClassLoader.getSystemResources(fdq);
            } else {
                systemResources = classLoader.getResources(fdq);
            }
            while (systemResources.hasMoreElements()) {
                linkedHashSet.add((URL) systemResources.nextElement());
            }
        } catch (Throwable e) {
            d.f("Error getting resources from path", e);
        }
        return linkedHashSet;
    }

    private static boolean o(Set<URL> set) {
        return set.size() > 1;
    }

    private static void p(Set<URL> set) {
        if (o(set)) {
            d.nL("Class path contains multiple SLF4J bindings.");
            for (URL url : set) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Found binding in [");
                stringBuilder.append(url);
                stringBuilder.append("]");
                d.nL(stringBuilder.toString());
            }
            d.nL("See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.");
        }
    }

    private static void q(Set<URL> set) {
        if (o(set)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Actual binding is of type [");
            stringBuilder.append(b.bCi().bCk());
            stringBuilder.append("]");
            d.nL(stringBuilder.toString());
        }
    }

    public static b nJ(String str) {
        return bCe().nJ(str);
    }

    public static b aa(Class<?> cls) {
        b nJ = nJ(cls.getName());
        if (fdo) {
            if (a(cls, d.bCh())) {
                d.nL(String.format("Detected logger name mismatch. Given name: \"%s\"; computed name: \"%s\".", new Object[]{nJ.getName(), d.bCh().getName()}));
                d.nL("See http://www.slf4j.org/codes.html#loggerNameMismatch for an explanation");
            }
        }
        return nJ;
    }

    private static boolean a(Class<?> cls, Class<?> cls2) {
        return cls2.isAssignableFrom(cls) ^ 1;
    }

    public static a bCe() {
        if (fdl == 0) {
            fdl = 1;
            bCa();
        }
        switch (fdl) {
            case 1:
                return fdm;
            case 2:
                throw new IllegalStateException("org.slf4j.LoggerFactory could not be successfully initialized. See also http://www.slf4j.org/codes.html#unsuccessfulInit");
            case 3:
                return b.bCi().bCj();
            case 4:
                return fdn;
            default:
                throw new IllegalStateException("Unreachable code");
        }
    }
}
