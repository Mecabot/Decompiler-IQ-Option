package org.slf4j.helpers;

import java.io.PrintStream;

/* compiled from: Util */
public final class d {
    private static final a fdu = new a();

    /* compiled from: Util */
    private static final class a extends SecurityManager {
        private a() {
        }

        protected Class<?>[] getClassContext() {
            return super.getClassContext();
        }
    }

    private d() {
    }

    public static Class<?> bCh() {
        Class[] classContext = fdu.getClassContext();
        String name = d.class.getName();
        int i = 0;
        while (i < classContext.length && !name.equals(classContext[i].getName())) {
            i++;
        }
        if (i < classContext.length) {
            i += 2;
            if (i < classContext.length) {
                return classContext[i];
            }
        }
        throw new IllegalStateException("Failed to find org.slf4j.helpers.Util or its caller in the stack; this should not happen");
    }

    public static final void f(String str, Throwable th) {
        System.err.println(str);
        System.err.println("Reported exception:");
        th.printStackTrace();
    }

    public static final void nL(String str) {
        PrintStream printStream = System.err;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SLF4J: ");
        stringBuilder.append(str);
        printStream.println(stringBuilder.toString());
    }
}
