package kotlin.b;

import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\u001a \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0001\u001a\"\u0010\b\u001a\u0002H\t\"\n\b\u0000\u0010\t\u0018\u0001*\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\b¢\u0006\u0002\u0010\f\u001a\b\u0010\r\u001a\u00020\u0005H\u0002\"\u0010\u0010\u0000\u001a\u00020\u00018\u0000X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, aXE = {"IMPLEMENTATIONS", "Lkotlin/internal/PlatformImplementations;", "apiVersionIsAtLeast", "", "major", "", "minor", "patch", "castToBaseType", "T", "", "instance", "(Ljava/lang/Object;)Ljava/lang/Object;", "getJavaVersion", "kotlin-stdlib"})
/* compiled from: PlatformImplementations.kt */
public final class b {
    public static final a euo;

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:25:0x00bc, code:
            if (r0 >= 65543) goto L_0x00be;
     */
    /* JADX WARNING: Missing block: B:27:?, code:
            r0 = java.lang.Class.forName("kotlin.b.a.a").newInstance();
            kotlin.jvm.internal.h.d(r0, "Class.forName(\"kotlin.in…entations\").newInstance()");
     */
    /* JADX WARNING: Missing block: B:28:0x00cd, code:
            if (r0 == null) goto L_0x00cf;
     */
    /* JADX WARNING: Missing block: B:31:0x00d6, code:
            throw new kotlin.TypeCastException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
     */
    /* JADX WARNING: Missing block: B:32:0x00d7, code:
            r1 = move-exception;
     */
    /* JADX WARNING: Missing block: B:33:0x00d9, code:
            r2 = (kotlin.b.a) r0;
     */
    /* JADX WARNING: Missing block: B:35:?, code:
            r0 = r0.getClass().getClassLoader();
            r2 = kotlin.b.a.class.getClassLoader();
            r4 = new java.lang.StringBuilder();
            r4.append("Instance classloader: ");
            r4.append(r0);
            r4.append(", base type classloader: ");
            r4.append(r2);
            r0 = new java.lang.ClassCastException(r4.toString()).initCause(r1);
            kotlin.jvm.internal.h.d(r0, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
     */
    /* JADX WARNING: Missing block: B:36:0x0115, code:
            throw r0;
     */
    /* JADX WARNING: Missing block: B:38:?, code:
            r0 = java.lang.Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();
            kotlin.jvm.internal.h.d(r0, "Class.forName(\"kotlin.in…entations\").newInstance()");
     */
    /* JADX WARNING: Missing block: B:39:0x0125, code:
            if (r0 == null) goto L_0x0127;
     */
    /* JADX WARNING: Missing block: B:42:0x012e, code:
            throw new kotlin.TypeCastException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
     */
    /* JADX WARNING: Missing block: B:43:0x012f, code:
            r1 = move-exception;
     */
    /* JADX WARNING: Missing block: B:44:0x0131, code:
            r2 = (kotlin.b.a) r0;
     */
    /* JADX WARNING: Missing block: B:46:?, code:
            r0 = r0.getClass().getClassLoader();
            r2 = kotlin.b.a.class.getClassLoader();
            r4 = new java.lang.StringBuilder();
            r4.append("Instance classloader: ");
            r4.append(r0);
            r4.append(", base type classloader: ");
            r4.append(r2);
            r0 = new java.lang.ClassCastException(r4.toString()).initCause(r1);
            kotlin.jvm.internal.h.d(r0, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
     */
    /* JADX WARNING: Missing block: B:47:0x016c, code:
            throw r0;
     */
    /* JADX WARNING: Missing block: B:48:0x016d, code:
            r2 = new kotlin.b.a();
     */
    static {
        /*
        r0 = aXO();
        r1 = 65544; // 0x10008 float:9.1847E-41 double:3.2383E-319;
        if (r0 < r1) goto L_0x00b9;
    L_0x0009:
        r1 = "kotlin.internal.jdk8.JDK8PlatformImplementations";
        r1 = java.lang.Class.forName(r1);	 Catch:{ ClassNotFoundException -> 0x0061 }
        r1 = r1.newInstance();	 Catch:{ ClassNotFoundException -> 0x0061 }
        r2 = "Class.forName(\"kotlin.in…entations\").newInstance()";
        kotlin.jvm.internal.h.d(r1, r2);	 Catch:{ ClassNotFoundException -> 0x0061 }
        if (r1 != 0) goto L_0x0024;
    L_0x001a:
        r2 = new kotlin.TypeCastException;	 Catch:{ ClassCastException -> 0x0022 }
        r3 = "null cannot be cast to non-null type kotlin.internal.PlatformImplementations";
        r2.<init>(r3);	 Catch:{ ClassCastException -> 0x0022 }
        throw r2;	 Catch:{ ClassCastException -> 0x0022 }
    L_0x0022:
        r2 = move-exception;
        goto L_0x0029;
    L_0x0024:
        r2 = r1;
        r2 = (kotlin.b.a) r2;	 Catch:{ ClassCastException -> 0x0022 }
        goto L_0x0172;
    L_0x0029:
        r1 = r1.getClass();	 Catch:{ ClassNotFoundException -> 0x0061 }
        r1 = r1.getClassLoader();	 Catch:{ ClassNotFoundException -> 0x0061 }
        r3 = kotlin.b.a.class;
        r3 = r3.getClassLoader();	 Catch:{ ClassNotFoundException -> 0x0061 }
        r4 = new java.lang.ClassCastException;	 Catch:{ ClassNotFoundException -> 0x0061 }
        r5 = new java.lang.StringBuilder;	 Catch:{ ClassNotFoundException -> 0x0061 }
        r5.<init>();	 Catch:{ ClassNotFoundException -> 0x0061 }
        r6 = "Instance classloader: ";
        r5.append(r6);	 Catch:{ ClassNotFoundException -> 0x0061 }
        r5.append(r1);	 Catch:{ ClassNotFoundException -> 0x0061 }
        r1 = ", base type classloader: ";
        r5.append(r1);	 Catch:{ ClassNotFoundException -> 0x0061 }
        r5.append(r3);	 Catch:{ ClassNotFoundException -> 0x0061 }
        r1 = r5.toString();	 Catch:{ ClassNotFoundException -> 0x0061 }
        r4.<init>(r1);	 Catch:{ ClassNotFoundException -> 0x0061 }
        r2 = (java.lang.Throwable) r2;	 Catch:{ ClassNotFoundException -> 0x0061 }
        r1 = r4.initCause(r2);	 Catch:{ ClassNotFoundException -> 0x0061 }
        r2 = "ClassCastException(\"Inst…baseTypeCL\").initCause(e)";
        kotlin.jvm.internal.h.d(r1, r2);	 Catch:{ ClassNotFoundException -> 0x0061 }
        throw r1;	 Catch:{ ClassNotFoundException -> 0x0061 }
    L_0x0061:
        r1 = "kotlin.internal.JRE8PlatformImplementations";
        r1 = java.lang.Class.forName(r1);	 Catch:{ ClassNotFoundException -> 0x00b9 }
        r1 = r1.newInstance();	 Catch:{ ClassNotFoundException -> 0x00b9 }
        r2 = "Class.forName(\"kotlin.in…entations\").newInstance()";
        kotlin.jvm.internal.h.d(r1, r2);	 Catch:{ ClassNotFoundException -> 0x00b9 }
        if (r1 != 0) goto L_0x007c;
    L_0x0072:
        r2 = new kotlin.TypeCastException;	 Catch:{ ClassCastException -> 0x007a }
        r3 = "null cannot be cast to non-null type kotlin.internal.PlatformImplementations";
        r2.<init>(r3);	 Catch:{ ClassCastException -> 0x007a }
        throw r2;	 Catch:{ ClassCastException -> 0x007a }
    L_0x007a:
        r2 = move-exception;
        goto L_0x0081;
    L_0x007c:
        r2 = r1;
        r2 = (kotlin.b.a) r2;	 Catch:{ ClassCastException -> 0x007a }
        goto L_0x0172;
    L_0x0081:
        r1 = r1.getClass();	 Catch:{ ClassNotFoundException -> 0x00b9 }
        r1 = r1.getClassLoader();	 Catch:{ ClassNotFoundException -> 0x00b9 }
        r3 = kotlin.b.a.class;
        r3 = r3.getClassLoader();	 Catch:{ ClassNotFoundException -> 0x00b9 }
        r4 = new java.lang.ClassCastException;	 Catch:{ ClassNotFoundException -> 0x00b9 }
        r5 = new java.lang.StringBuilder;	 Catch:{ ClassNotFoundException -> 0x00b9 }
        r5.<init>();	 Catch:{ ClassNotFoundException -> 0x00b9 }
        r6 = "Instance classloader: ";
        r5.append(r6);	 Catch:{ ClassNotFoundException -> 0x00b9 }
        r5.append(r1);	 Catch:{ ClassNotFoundException -> 0x00b9 }
        r1 = ", base type classloader: ";
        r5.append(r1);	 Catch:{ ClassNotFoundException -> 0x00b9 }
        r5.append(r3);	 Catch:{ ClassNotFoundException -> 0x00b9 }
        r1 = r5.toString();	 Catch:{ ClassNotFoundException -> 0x00b9 }
        r4.<init>(r1);	 Catch:{ ClassNotFoundException -> 0x00b9 }
        r2 = (java.lang.Throwable) r2;	 Catch:{ ClassNotFoundException -> 0x00b9 }
        r1 = r4.initCause(r2);	 Catch:{ ClassNotFoundException -> 0x00b9 }
        r2 = "ClassCastException(\"Inst…baseTypeCL\").initCause(e)";
        kotlin.jvm.internal.h.d(r1, r2);	 Catch:{ ClassNotFoundException -> 0x00b9 }
        throw r1;	 Catch:{ ClassNotFoundException -> 0x00b9 }
    L_0x00b9:
        r1 = 65543; // 0x10007 float:9.1845E-41 double:3.23825E-319;
        if (r0 < r1) goto L_0x016d;
    L_0x00be:
        r0 = "kotlin.b.a.a";
        r0 = java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x0116 }
        r0 = r0.newInstance();	 Catch:{ ClassNotFoundException -> 0x0116 }
        r1 = "Class.forName(\"kotlin.in…entations\").newInstance()";
        kotlin.jvm.internal.h.d(r0, r1);	 Catch:{ ClassNotFoundException -> 0x0116 }
        if (r0 != 0) goto L_0x00d9;
    L_0x00cf:
        r1 = new kotlin.TypeCastException;	 Catch:{ ClassCastException -> 0x00d7 }
        r2 = "null cannot be cast to non-null type kotlin.internal.PlatformImplementations";
        r1.<init>(r2);	 Catch:{ ClassCastException -> 0x00d7 }
        throw r1;	 Catch:{ ClassCastException -> 0x00d7 }
    L_0x00d7:
        r1 = move-exception;
        goto L_0x00de;
    L_0x00d9:
        r2 = r0;
        r2 = (kotlin.b.a) r2;	 Catch:{ ClassCastException -> 0x00d7 }
        goto L_0x0172;
    L_0x00de:
        r0 = r0.getClass();	 Catch:{ ClassNotFoundException -> 0x0116 }
        r0 = r0.getClassLoader();	 Catch:{ ClassNotFoundException -> 0x0116 }
        r2 = kotlin.b.a.class;
        r2 = r2.getClassLoader();	 Catch:{ ClassNotFoundException -> 0x0116 }
        r3 = new java.lang.ClassCastException;	 Catch:{ ClassNotFoundException -> 0x0116 }
        r4 = new java.lang.StringBuilder;	 Catch:{ ClassNotFoundException -> 0x0116 }
        r4.<init>();	 Catch:{ ClassNotFoundException -> 0x0116 }
        r5 = "Instance classloader: ";
        r4.append(r5);	 Catch:{ ClassNotFoundException -> 0x0116 }
        r4.append(r0);	 Catch:{ ClassNotFoundException -> 0x0116 }
        r0 = ", base type classloader: ";
        r4.append(r0);	 Catch:{ ClassNotFoundException -> 0x0116 }
        r4.append(r2);	 Catch:{ ClassNotFoundException -> 0x0116 }
        r0 = r4.toString();	 Catch:{ ClassNotFoundException -> 0x0116 }
        r3.<init>(r0);	 Catch:{ ClassNotFoundException -> 0x0116 }
        r1 = (java.lang.Throwable) r1;	 Catch:{ ClassNotFoundException -> 0x0116 }
        r0 = r3.initCause(r1);	 Catch:{ ClassNotFoundException -> 0x0116 }
        r1 = "ClassCastException(\"Inst…baseTypeCL\").initCause(e)";
        kotlin.jvm.internal.h.d(r0, r1);	 Catch:{ ClassNotFoundException -> 0x0116 }
        throw r0;	 Catch:{ ClassNotFoundException -> 0x0116 }
    L_0x0116:
        r0 = "kotlin.internal.JRE7PlatformImplementations";
        r0 = java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x016d }
        r0 = r0.newInstance();	 Catch:{ ClassNotFoundException -> 0x016d }
        r1 = "Class.forName(\"kotlin.in…entations\").newInstance()";
        kotlin.jvm.internal.h.d(r0, r1);	 Catch:{ ClassNotFoundException -> 0x016d }
        if (r0 != 0) goto L_0x0131;
    L_0x0127:
        r1 = new kotlin.TypeCastException;	 Catch:{ ClassCastException -> 0x012f }
        r2 = "null cannot be cast to non-null type kotlin.internal.PlatformImplementations";
        r1.<init>(r2);	 Catch:{ ClassCastException -> 0x012f }
        throw r1;	 Catch:{ ClassCastException -> 0x012f }
    L_0x012f:
        r1 = move-exception;
        goto L_0x0135;
    L_0x0131:
        r2 = r0;
        r2 = (kotlin.b.a) r2;	 Catch:{ ClassCastException -> 0x012f }
        goto L_0x0172;
    L_0x0135:
        r0 = r0.getClass();	 Catch:{ ClassNotFoundException -> 0x016d }
        r0 = r0.getClassLoader();	 Catch:{ ClassNotFoundException -> 0x016d }
        r2 = kotlin.b.a.class;
        r2 = r2.getClassLoader();	 Catch:{ ClassNotFoundException -> 0x016d }
        r3 = new java.lang.ClassCastException;	 Catch:{ ClassNotFoundException -> 0x016d }
        r4 = new java.lang.StringBuilder;	 Catch:{ ClassNotFoundException -> 0x016d }
        r4.<init>();	 Catch:{ ClassNotFoundException -> 0x016d }
        r5 = "Instance classloader: ";
        r4.append(r5);	 Catch:{ ClassNotFoundException -> 0x016d }
        r4.append(r0);	 Catch:{ ClassNotFoundException -> 0x016d }
        r0 = ", base type classloader: ";
        r4.append(r0);	 Catch:{ ClassNotFoundException -> 0x016d }
        r4.append(r2);	 Catch:{ ClassNotFoundException -> 0x016d }
        r0 = r4.toString();	 Catch:{ ClassNotFoundException -> 0x016d }
        r3.<init>(r0);	 Catch:{ ClassNotFoundException -> 0x016d }
        r1 = (java.lang.Throwable) r1;	 Catch:{ ClassNotFoundException -> 0x016d }
        r0 = r3.initCause(r1);	 Catch:{ ClassNotFoundException -> 0x016d }
        r1 = "ClassCastException(\"Inst…baseTypeCL\").initCause(e)";
        kotlin.jvm.internal.h.d(r0, r1);	 Catch:{ ClassNotFoundException -> 0x016d }
        throw r0;	 Catch:{ ClassNotFoundException -> 0x016d }
    L_0x016d:
        r2 = new kotlin.b.a;
        r2.<init>();
    L_0x0172:
        euo = r2;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.b.b.<clinit>():void");
    }

    private static final int aXO() {
        String property = System.getProperty("java.specification.version");
        int i = 65542;
        if (property == null) {
            return 65542;
        }
        CharSequence charSequence = property;
        int a = v.a(charSequence, '.', 0, false, 6, null);
        if (a < 0) {
            try {
                i = Integer.parseInt(property) * 65536;
            } catch (NumberFormatException unused) {
                return i;
            }
        }
        int i2 = a + 1;
        int a2 = v.a(charSequence, '.', i2, false, 4, null);
        if (a2 < 0) {
            a2 = property.length();
        }
        if (property == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String substring = property.substring(0, a);
        h.d(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        if (property == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        property = property.substring(i2, a2);
        h.d(property, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        try {
            i = (Integer.parseInt(substring) * 65536) + Integer.parseInt(property);
        } catch (NumberFormatException unused2) {
            return i;
        }
    }
}
