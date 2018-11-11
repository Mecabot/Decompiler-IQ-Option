package kotlin.reflect.jvm;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.i;
import kotlin.jvm.internal.h;
import kotlin.reflect.e;
import kotlin.reflect.f;
import kotlin.reflect.j;
import kotlin.reflect.jvm.internal.ae;
import kotlin.reflect.jvm.internal.s;

@i(aXC = {1, 1, 11}, aXD = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010%\u001a\u0004\u0018\u00010&*\u00020'H\u0002\"2\u0010\u0000\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00038FX\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u001b\u0010\b\u001a\u0004\u0018\u00010\t*\u0006\u0012\u0002\b\u00030\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\"\u001b\u0010\r\u001a\u0004\u0018\u00010\u000e*\u0006\u0012\u0002\b\u00030\n8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u000e*\u0006\u0012\u0002\b\u00030\u00038F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\"\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u000e*\u0006\u0012\u0002\b\u00030\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\"\u0015\u0010\u0018\u001a\u00020\u0019*\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\"-\u0010\u001d\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0003\"\b\b\u0000\u0010\u0002*\u00020\u001e*\b\u0012\u0004\u0012\u0002H\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 \"\u001b\u0010\u001d\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0003*\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010!\"\u001b\u0010\"\u001a\b\u0012\u0002\b\u0003\u0018\u00010\n*\u00020\t8F¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u0006("}, aXE = {"javaConstructor", "Ljava/lang/reflect/Constructor;", "T", "Lkotlin/reflect/KFunction;", "javaConstructor$annotations", "(Lkotlin/reflect/KFunction;)V", "getJavaConstructor", "(Lkotlin/reflect/KFunction;)Ljava/lang/reflect/Constructor;", "javaField", "Ljava/lang/reflect/Field;", "Lkotlin/reflect/KProperty;", "getJavaField", "(Lkotlin/reflect/KProperty;)Ljava/lang/reflect/Field;", "javaGetter", "Ljava/lang/reflect/Method;", "getJavaGetter", "(Lkotlin/reflect/KProperty;)Ljava/lang/reflect/Method;", "javaMethod", "getJavaMethod", "(Lkotlin/reflect/KFunction;)Ljava/lang/reflect/Method;", "javaSetter", "Lkotlin/reflect/KMutableProperty;", "getJavaSetter", "(Lkotlin/reflect/KMutableProperty;)Ljava/lang/reflect/Method;", "javaType", "Ljava/lang/reflect/Type;", "Lkotlin/reflect/KType;", "getJavaType", "(Lkotlin/reflect/KType;)Ljava/lang/reflect/Type;", "kotlinFunction", "", "getKotlinFunction", "(Ljava/lang/reflect/Constructor;)Lkotlin/reflect/KFunction;", "(Ljava/lang/reflect/Method;)Lkotlin/reflect/KFunction;", "kotlinProperty", "getKotlinProperty", "(Ljava/lang/reflect/Field;)Lkotlin/reflect/KProperty;", "getKPackage", "Lkotlin/reflect/KDeclarationContainer;", "Ljava/lang/reflect/Member;", "kotlin-reflect-api"})
/* compiled from: ReflectJvmMapping.kt */
public final class c {
    public static final Field a(j<?> jVar) {
        h.e(jVar, "$receiver");
        s cI = ae.cI(jVar);
        return cI != null ? cI.aZZ() : null;
    }

    public static final Method b(j<?> jVar) {
        h.e(jVar, "$receiver");
        return a((e) jVar.aYd());
    }

    public static final Method a(f<?> fVar) {
        h.e(fVar, "$receiver");
        return a((e) fVar.aYc());
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x001c  */
    public static final java.lang.reflect.Method a(kotlin.reflect.e<?> r2) {
        /*
        r0 = "$receiver";
        kotlin.jvm.internal.h.e(r2, r0);
        r2 = kotlin.reflect.jvm.internal.ae.cJ(r2);
        r0 = 0;
        if (r2 == 0) goto L_0x0017;
    L_0x000c:
        r2 = r2.aYN();
        if (r2 == 0) goto L_0x0017;
    L_0x0012:
        r2 = r2.aYw();
        goto L_0x0018;
    L_0x0017:
        r2 = r0;
    L_0x0018:
        r1 = r2 instanceof java.lang.reflect.Method;
        if (r1 != 0) goto L_0x001d;
    L_0x001c:
        r2 = r0;
    L_0x001d:
        r2 = (java.lang.reflect.Method) r2;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.c.a(kotlin.reflect.e):java.lang.reflect.Method");
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x001c  */
    public static final <T> java.lang.reflect.Constructor<T> b(kotlin.reflect.e<? extends T> r2) {
        /*
        r0 = "$receiver";
        kotlin.jvm.internal.h.e(r2, r0);
        r2 = kotlin.reflect.jvm.internal.ae.cJ(r2);
        r0 = 0;
        if (r2 == 0) goto L_0x0017;
    L_0x000c:
        r2 = r2.aYN();
        if (r2 == 0) goto L_0x0017;
    L_0x0012:
        r2 = r2.aYw();
        goto L_0x0018;
    L_0x0017:
        r2 = r0;
    L_0x0018:
        r1 = r2 instanceof java.lang.reflect.Constructor;
        if (r1 != 0) goto L_0x001d;
    L_0x001c:
        r2 = r0;
    L_0x001d:
        r2 = (java.lang.reflect.Constructor) r2;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.c.b(kotlin.reflect.e):java.lang.reflect.Constructor<T>");
    }
}
