package kotlin.reflect.jvm;

import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\",\u0010\u0002\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u000e¢\u0006\f\u001a\u0004\b\u0002\u0010\u0004\"\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, aXE = {"value", "", "isAccessible", "Lkotlin/reflect/KCallable;", "(Lkotlin/reflect/KCallable;)Z", "setAccessible", "(Lkotlin/reflect/KCallable;Z)V", "kotlin-reflect-api"})
/* compiled from: KCallablesJvm.kt */
public final class a {
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:66:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00bb  */
    public static final void a(kotlin.reflect.a<?> r3, boolean r4) {
        /*
        r0 = "$receiver";
        kotlin.jvm.internal.h.e(r3, r0);
        r0 = r3 instanceof kotlin.reflect.f;
        if (r0 == 0) goto L_0x002b;
    L_0x0009:
        r0 = r3;
        r0 = (kotlin.reflect.j) r0;
        r1 = kotlin.reflect.jvm.c.a(r0);
        if (r1 == 0) goto L_0x0015;
    L_0x0012:
        r1.setAccessible(r4);
    L_0x0015:
        r0 = kotlin.reflect.jvm.c.b(r0);
        if (r0 == 0) goto L_0x001e;
    L_0x001b:
        r0.setAccessible(r4);
    L_0x001e:
        r3 = (kotlin.reflect.f) r3;
        r3 = kotlin.reflect.jvm.c.a(r3);
        if (r3 == 0) goto L_0x00be;
    L_0x0026:
        r3.setAccessible(r4);
        goto L_0x00be;
    L_0x002b:
        r0 = r3 instanceof kotlin.reflect.j;
        if (r0 == 0) goto L_0x0045;
    L_0x002f:
        r3 = (kotlin.reflect.j) r3;
        r0 = kotlin.reflect.jvm.c.a(r3);
        if (r0 == 0) goto L_0x003a;
    L_0x0037:
        r0.setAccessible(r4);
    L_0x003a:
        r3 = kotlin.reflect.jvm.c.b(r3);
        if (r3 == 0) goto L_0x00be;
    L_0x0040:
        r3.setAccessible(r4);
        goto L_0x00be;
    L_0x0045:
        r0 = r3 instanceof kotlin.reflect.j.b;
        if (r0 == 0) goto L_0x0065;
    L_0x0049:
        r0 = r3;
        r0 = (kotlin.reflect.j.b) r0;
        r0 = r0.aYn();
        r0 = kotlin.reflect.jvm.c.a(r0);
        if (r0 == 0) goto L_0x0059;
    L_0x0056:
        r0.setAccessible(r4);
    L_0x0059:
        r3 = (kotlin.reflect.e) r3;
        r3 = kotlin.reflect.jvm.c.a(r3);
        if (r3 == 0) goto L_0x00be;
    L_0x0061:
        r3.setAccessible(r4);
        goto L_0x00be;
    L_0x0065:
        r0 = r3 instanceof kotlin.reflect.f.a;
        if (r0 == 0) goto L_0x0085;
    L_0x0069:
        r0 = r3;
        r0 = (kotlin.reflect.f.a) r0;
        r0 = r0.aYn();
        r0 = kotlin.reflect.jvm.c.a(r0);
        if (r0 == 0) goto L_0x0079;
    L_0x0076:
        r0.setAccessible(r4);
    L_0x0079:
        r3 = (kotlin.reflect.e) r3;
        r3 = kotlin.reflect.jvm.c.a(r3);
        if (r3 == 0) goto L_0x00be;
    L_0x0081:
        r3.setAccessible(r4);
        goto L_0x00be;
    L_0x0085:
        r0 = r3 instanceof kotlin.reflect.e;
        if (r0 == 0) goto L_0x00bf;
    L_0x0089:
        r0 = r3;
        r0 = (kotlin.reflect.e) r0;
        r1 = kotlin.reflect.jvm.c.a(r0);
        if (r1 == 0) goto L_0x0095;
    L_0x0092:
        r1.setAccessible(r4);
    L_0x0095:
        r3 = kotlin.reflect.jvm.internal.ae.cJ(r3);
        r1 = 0;
        if (r3 == 0) goto L_0x00a7;
    L_0x009c:
        r3 = r3.aYO();
        if (r3 == 0) goto L_0x00a7;
    L_0x00a2:
        r3 = r3.aYw();
        goto L_0x00a8;
    L_0x00a7:
        r3 = r1;
    L_0x00a8:
        r2 = r3 instanceof java.lang.reflect.AccessibleObject;
        if (r2 != 0) goto L_0x00ad;
    L_0x00ac:
        r3 = r1;
    L_0x00ad:
        r3 = (java.lang.reflect.AccessibleObject) r3;
        if (r3 == 0) goto L_0x00b5;
    L_0x00b1:
        r1 = 1;
        r3.setAccessible(r1);
    L_0x00b5:
        r3 = kotlin.reflect.jvm.c.b(r0);
        if (r3 == 0) goto L_0x00be;
    L_0x00bb:
        r3.setAccessible(r4);
    L_0x00be:
        return;
    L_0x00bf:
        r4 = new java.lang.UnsupportedOperationException;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "Unknown callable: ";
        r0.append(r1);
        r0.append(r3);
        r1 = " (";
        r0.append(r1);
        r3 = r3.getClass();
        r0.append(r3);
        r3 = 41;
        r0.append(r3);
        r3 = r0.toString();
        r4.<init>(r3);
        r4 = (java.lang.Throwable) r4;
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.a.a(kotlin.reflect.a, boolean):void");
    }
}
