package kotlin.reflect.jvm.internal;

import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a \u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u0001*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¨\u0006\u0005"}, aXE = {"computeCallerForAccessor", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "isGetter", "", "kotlin-reflect-api"})
/* compiled from: KPropertyImpl.kt */
public final class t {
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00ce  */
    private static final kotlin.reflect.jvm.internal.c<?> a(kotlin.reflect.jvm.internal.s.a<?, ?> r9, boolean r10) {
        /*
        r0 = kotlin.reflect.jvm.internal.KDeclarationContainerImpl.evP;
        r0 = r0.aZn();
        r1 = r9.aZv();
        r1 = r1.getSignature();
        r1 = (java.lang.CharSequence) r1;
        r0 = r0.matches(r1);
        if (r0 == 0) goto L_0x001b;
    L_0x0016:
        r9 = kotlin.reflect.jvm.internal.c.aa.eve;
        r9 = (kotlin.reflect.jvm.internal.c) r9;
        return r9;
    L_0x001b:
        r2 = new kotlin.reflect.jvm.internal.KPropertyImplKt$computeCallerForAccessor$1;
        r2.<init>(r9);
        r0 = new kotlin.reflect.jvm.internal.KPropertyImplKt$computeCallerForAccessor$2;
        r0.<init>(r9);
        r3 = new kotlin.reflect.jvm.internal.KPropertyImplKt$computeCallerForAccessor$3;
        r3.<init>(r9, r0);
        r7 = new kotlin.reflect.jvm.internal.KPropertyImplKt$computeCallerForAccessor$4;
        r7.<init>(r9);
        r5 = new kotlin.reflect.jvm.internal.KPropertyImplKt$computeCallerForAccessor$5;
        r5.<init>(r9);
        r8 = new kotlin.reflect.jvm.internal.KPropertyImplKt$computeCallerForAccessor$6;
        r0 = r8;
        r1 = r9;
        r4 = r10;
        r6 = r7;
        r0.<init>(r1, r2, r3, r4, r5, r6);
        r0 = kotlin.reflect.jvm.internal.ac.ewF;
        r1 = r9.aZv();
        r1 = r1.aYM();
        r0 = r0.d(r1);
        r1 = r0 instanceof kotlin.reflect.jvm.internal.f.c;
        if (r1 == 0) goto L_0x013b;
    L_0x004f:
        r0 = (kotlin.reflect.jvm.internal.f.c) r0;
        r1 = r0.aYH();
        r2 = 0;
        if (r10 == 0) goto L_0x0065;
    L_0x0058:
        r10 = r1.bsE();
        if (r10 == 0) goto L_0x0063;
    L_0x005e:
        r10 = r1.bsF();
        goto L_0x006f;
    L_0x0063:
        r10 = r2;
        goto L_0x006f;
    L_0x0065:
        r10 = r1.bsG();
        if (r10 == 0) goto L_0x0063;
    L_0x006b:
        r10 = r1.bsH();
    L_0x006f:
        if (r10 == 0) goto L_0x009f;
    L_0x0071:
        r1 = r9.aZv();
        r1 = r1.aYP();
        r2 = r0.aYI();
        r3 = r10.blW();
        r2 = r2.getString(r3);
        r0 = r0.aYI();
        r10 = r10.bsf();
        r10 = r0.getString(r10);
        r0 = r9.bab();
        r0 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) r0;
        r0 = kotlin.reflect.jvm.internal.ae.b(r0);
        r2 = r1.l(r2, r10, r0);
    L_0x009f:
        if (r2 != 0) goto L_0x00ce;
    L_0x00a1:
        r10 = r9.aZv();
        r10 = r10.aZZ();
        if (r10 == 0) goto L_0x00b1;
    L_0x00ab:
        r9 = r8.invoke(r10);
        goto L_0x0180;
    L_0x00b1:
        r10 = new kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "No accessors or field is found for property ";
        r0.append(r1);
        r9 = r9.aZv();
        r0.append(r9);
        r9 = r0.toString();
        r10.<init>(r9);
        r10 = (java.lang.Throwable) r10;
        throw r10;
    L_0x00ce:
        r10 = r2.getModifiers();
        r10 = java.lang.reflect.Modifier.isStatic(r10);
        if (r10 != 0) goto L_0x00fb;
    L_0x00d8:
        r10 = r9.isBound();
        if (r10 == 0) goto L_0x00ee;
    L_0x00de:
        r10 = new kotlin.reflect.jvm.internal.c$f;
        r9 = r9.aZv();
        r9 = r9.aXQ();
        r10.<init>(r2, r9);
        r10 = (kotlin.reflect.jvm.internal.c.w) r10;
        goto L_0x00f6;
    L_0x00ee:
        r9 = new kotlin.reflect.jvm.internal.c$s;
        r9.<init>(r2);
        r10 = r9;
        r10 = (kotlin.reflect.jvm.internal.c.w) r10;
    L_0x00f6:
        r9 = r10;
        r9 = (kotlin.reflect.jvm.internal.c) r9;
        goto L_0x0180;
    L_0x00fb:
        r10 = r7.invoke();
        if (r10 == 0) goto L_0x0119;
    L_0x0101:
        r9 = r9.isBound();
        if (r9 == 0) goto L_0x010f;
    L_0x0107:
        r9 = new kotlin.reflect.jvm.internal.c$g;
        r9.<init>(r2);
        r9 = (kotlin.reflect.jvm.internal.c.w) r9;
        goto L_0x0116;
    L_0x010f:
        r9 = new kotlin.reflect.jvm.internal.c$t;
        r9.<init>(r2);
        r9 = (kotlin.reflect.jvm.internal.c.w) r9;
    L_0x0116:
        r9 = (kotlin.reflect.jvm.internal.c) r9;
        goto L_0x0180;
    L_0x0119:
        r10 = r9.isBound();
        if (r10 == 0) goto L_0x012f;
    L_0x011f:
        r10 = new kotlin.reflect.jvm.internal.c$j;
        r9 = r9.aZv();
        r9 = r9.aXQ();
        r10.<init>(r2, r9);
        r10 = (kotlin.reflect.jvm.internal.c.w) r10;
        goto L_0x0137;
    L_0x012f:
        r9 = new kotlin.reflect.jvm.internal.c$z;
        r9.<init>(r2);
        r10 = r9;
        r10 = (kotlin.reflect.jvm.internal.c.w) r10;
    L_0x0137:
        r9 = r10;
        r9 = (kotlin.reflect.jvm.internal.c) r9;
        goto L_0x0180;
    L_0x013b:
        r1 = r0 instanceof kotlin.reflect.jvm.internal.f.a;
        if (r1 == 0) goto L_0x014a;
    L_0x013f:
        r0 = (kotlin.reflect.jvm.internal.f.a) r0;
        r9 = r0.getField();
        r9 = r8.invoke(r9);
        goto L_0x0180;
    L_0x014a:
        r1 = r0 instanceof kotlin.reflect.jvm.internal.f.b;
        if (r1 == 0) goto L_0x019e;
    L_0x014e:
        if (r10 == 0) goto L_0x0157;
    L_0x0150:
        r0 = (kotlin.reflect.jvm.internal.f.b) r0;
        r10 = r0.aYC();
        goto L_0x015f;
    L_0x0157:
        r0 = (kotlin.reflect.jvm.internal.f.b) r0;
        r10 = r0.aYD();
        if (r10 == 0) goto L_0x0181;
    L_0x015f:
        r0 = r9.isBound();
        if (r0 == 0) goto L_0x0175;
    L_0x0165:
        r0 = new kotlin.reflect.jvm.internal.c$f;
        r9 = r9.aZv();
        r9 = r9.aXQ();
        r0.<init>(r10, r9);
        r0 = (kotlin.reflect.jvm.internal.c.w) r0;
        goto L_0x017d;
    L_0x0175:
        r9 = new kotlin.reflect.jvm.internal.c$s;
        r9.<init>(r10);
        r0 = r9;
        r0 = (kotlin.reflect.jvm.internal.c.w) r0;
    L_0x017d:
        r9 = r0;
        r9 = (kotlin.reflect.jvm.internal.c) r9;
    L_0x0180:
        return r9;
    L_0x0181:
        r9 = new kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
        r10 = new java.lang.StringBuilder;
        r10.<init>();
        r1 = "No source found for setter of Java method property: ";
        r10.append(r1);
        r0 = r0.aYC();
        r10.append(r0);
        r10 = r10.toString();
        r9.<init>(r10);
        r9 = (java.lang.Throwable) r9;
        throw r9;
    L_0x019e:
        r1 = r0 instanceof kotlin.reflect.jvm.internal.f.d;
        if (r1 == 0) goto L_0x0259;
    L_0x01a2:
        if (r10 == 0) goto L_0x01ab;
    L_0x01a4:
        r0 = (kotlin.reflect.jvm.internal.f.d) r0;
        r10 = r0.aYK();
        goto L_0x01b3;
    L_0x01ab:
        r0 = (kotlin.reflect.jvm.internal.f.d) r0;
        r10 = r0.aYL();
        if (r10 == 0) goto L_0x023c;
    L_0x01b3:
        r0 = r9.aZv();
        r0 = r0.aYP();
        r1 = r10.getMethodName();
        r10 = r10.aYB();
        r2 = r9.bab();
        r2 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) r2;
        r2 = kotlin.reflect.jvm.internal.ae.b(r2);
        r10 = r0.l(r1, r10, r2);
        if (r10 == 0) goto L_0x021f;
    L_0x01d3:
        r0 = r10.getModifiers();
        r0 = java.lang.reflect.Modifier.isStatic(r0);
        r0 = r0 ^ 1;
        r1 = kotlin.m.etY;
        if (r1 == 0) goto L_0x0200;
    L_0x01e1:
        if (r0 != 0) goto L_0x0200;
    L_0x01e3:
        r10 = new java.lang.StringBuilder;
        r10.<init>();
        r0 = "Mapped property cannot have a static accessor: ";
        r10.append(r0);
        r9 = r9.aZv();
        r10.append(r9);
        r9 = r10.toString();
        r10 = new java.lang.AssertionError;
        r10.<init>(r9);
        r10 = (java.lang.Throwable) r10;
        throw r10;
    L_0x0200:
        r0 = r9.isBound();
        if (r0 == 0) goto L_0x0216;
    L_0x0206:
        r0 = new kotlin.reflect.jvm.internal.c$f;
        r9 = r9.aZv();
        r9 = r9.aXQ();
        r0.<init>(r10, r9);
        r0 = (kotlin.reflect.jvm.internal.c) r0;
        goto L_0x021e;
    L_0x0216:
        r9 = new kotlin.reflect.jvm.internal.c$s;
        r9.<init>(r10);
        r0 = r9;
        r0 = (kotlin.reflect.jvm.internal.c) r0;
    L_0x021e:
        return r0;
    L_0x021f:
        r10 = new kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "No accessor found for property ";
        r0.append(r1);
        r9 = r9.aZv();
        r0.append(r9);
        r9 = r0.toString();
        r10.<init>(r9);
        r10 = (java.lang.Throwable) r10;
        throw r10;
    L_0x023c:
        r10 = new kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "No setter found for property ";
        r0.append(r1);
        r9 = r9.aZv();
        r0.append(r9);
        r9 = r0.toString();
        r10.<init>(r9);
        r10 = (java.lang.Throwable) r10;
        throw r10;
    L_0x0259:
        r9 = new kotlin.NoWhenBranchMatchedException;
        r9.<init>();
        throw r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.t.a(kotlin.reflect.jvm.internal.s$a, boolean):kotlin.reflect.jvm.internal.c<?>");
    }
}
