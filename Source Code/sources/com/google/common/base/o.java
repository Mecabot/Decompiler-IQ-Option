package com.google.common.base;

import java.lang.reflect.Method;

/* compiled from: Throwables */
public final class o {
    private static final Object Nw = qa();
    private static final Method Nx = (Nw == null ? null : qb());
    private static final Method Ny;

    public static <X extends Throwable> void a(Throwable th, Class<X> cls) {
        i.checkNotNull(th);
        if (cls.isInstance(th)) {
            throw ((Throwable) cls.cast(th));
        }
    }

    @Deprecated
    public static <X extends Throwable> void b(Throwable th, Class<X> cls) {
        if (th != null) {
            a(th, (Class) cls);
        }
    }

    public static void e(Throwable th) {
        i.checkNotNull(th);
        if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        } else if (th instanceof Error) {
            throw ((Error) th);
        }
    }

    @Deprecated
    public static void f(Throwable th) {
        if (th != null) {
            e(th);
        }
    }

    public static <X extends Throwable> void c(Throwable th, Class<X> cls) {
        b(th, cls);
        f(th);
    }

    @Deprecated
    public static RuntimeException g(Throwable th) {
        e(th);
        throw new RuntimeException(th);
    }

    static {
        Method method = null;
        if (Nw != null) {
            method = qc();
        }
        Ny = method;
    }

    private static Object qa() {
        try {
            return Class.forName("sun.misc.SharedSecrets", false, null).getMethod("getJavaLangAccess", new Class[0]).invoke(null, new Object[0]);
        } catch (ThreadDeath e) {
            throw e;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method qb() {
        return a("getStackTraceElement", Throwable.class, Integer.TYPE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0023 A:{RETURN, Splitter: B:1:0x0001, ExcHandler: java.lang.UnsupportedOperationException (unused java.lang.UnsupportedOperationException)} */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0023 A:{RETURN, Splitter: B:1:0x0001, ExcHandler: java.lang.UnsupportedOperationException (unused java.lang.UnsupportedOperationException)} */
    /* JADX WARNING: Missing block: B:7:0x0023, code:
            return null;
     */
    private static java.lang.reflect.Method qc() {
        /*
        r0 = 0;
        r1 = "getStackTraceDepth";
        r2 = 1;
        r3 = new java.lang.Class[r2];	 Catch:{ UnsupportedOperationException -> 0x0023, UnsupportedOperationException -> 0x0023, UnsupportedOperationException -> 0x0023 }
        r4 = java.lang.Throwable.class;
        r5 = 0;
        r3[r5] = r4;	 Catch:{ UnsupportedOperationException -> 0x0023, UnsupportedOperationException -> 0x0023, UnsupportedOperationException -> 0x0023 }
        r1 = a(r1, r3);	 Catch:{ UnsupportedOperationException -> 0x0023, UnsupportedOperationException -> 0x0023, UnsupportedOperationException -> 0x0023 }
        if (r1 != 0) goto L_0x0012;
    L_0x0011:
        return r0;
    L_0x0012:
        r3 = qa();	 Catch:{ UnsupportedOperationException -> 0x0023, UnsupportedOperationException -> 0x0023, UnsupportedOperationException -> 0x0023 }
        r2 = new java.lang.Object[r2];	 Catch:{ UnsupportedOperationException -> 0x0023, UnsupportedOperationException -> 0x0023, UnsupportedOperationException -> 0x0023 }
        r4 = new java.lang.Throwable;	 Catch:{ UnsupportedOperationException -> 0x0023, UnsupportedOperationException -> 0x0023, UnsupportedOperationException -> 0x0023 }
        r4.<init>();	 Catch:{ UnsupportedOperationException -> 0x0023, UnsupportedOperationException -> 0x0023, UnsupportedOperationException -> 0x0023 }
        r2[r5] = r4;	 Catch:{ UnsupportedOperationException -> 0x0023, UnsupportedOperationException -> 0x0023, UnsupportedOperationException -> 0x0023 }
        r1.invoke(r3, r2);	 Catch:{ UnsupportedOperationException -> 0x0023, UnsupportedOperationException -> 0x0023, UnsupportedOperationException -> 0x0023 }
        return r1;
    L_0x0023:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.base.o.qc():java.lang.reflect.Method");
    }

    private static Method a(String str, Class<?>... clsArr) {
        try {
            return Class.forName("sun.misc.JavaLangAccess", false, null).getMethod(str, clsArr);
        } catch (ThreadDeath e) {
            throw e;
        } catch (Throwable unused) {
            return null;
        }
    }
}
