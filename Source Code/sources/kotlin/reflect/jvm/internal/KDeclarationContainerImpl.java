package kotlin.reflect.jvm.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ad;
import kotlin.reflect.jvm.internal.impl.descriptors.au;
import kotlin.reflect.jvm.internal.impl.descriptors.av;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.l;
import kotlin.reflect.jvm.internal.impl.descriptors.r;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.text.Regex;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\b\u0005\b \u0018\u0000 ?2\u00020\u0001:\u0003?@AB\u0005¢\u0006\u0002\u0010\u0002J*\u0010\f\u001a\u00020\r2\u0010\u0010\u000e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0014\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u001c\u0010\u0018\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00192\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0013J\u001c\u0010\u001b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00192\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0013J(\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u0013J\u0016\u0010 \u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0011J \u0010#\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0013J\u0016\u0010$\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0011J\u0016\u0010%\u001a\b\u0012\u0004\u0012\u00020!0\u00042\u0006\u0010\u001e\u001a\u00020&H&J\u0012\u0010'\u001a\u0004\u0018\u00010\u00172\u0006\u0010(\u001a\u00020)H&J\"\u0010*\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030+0\u00042\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0004J\u0016\u00100\u001a\b\u0012\u0004\u0012\u00020\u00170\u00042\u0006\u0010\u001e\u001a\u00020&H&J\u001a\u00101\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t022\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0014\u00103\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J$\u00104\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u00105\u001a\u00020)2\u0006\u00106\u001a\u00020)H\u0002J@\u00107\u001a\u0004\u0018\u00010\u001d*\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u001e\u001a\u00020\u00112\u0010\u00108\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t022\n\u00109\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u001a\u001a\u00020\u0013H\u0002J0\u0010:\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0019*\u0006\u0012\u0002\b\u00030\t2\u0010\u00108\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t022\u0006\u0010;\u001a\u00020\u0013H\u0002JE\u0010<\u001a\u0004\u0018\u00010\u001d*\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u001e\u001a\u00020\u00112\u0010\u00108\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0=2\n\u00109\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010;\u001a\u00020\u0013H\u0002¢\u0006\u0002\u0010>R\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0006\u0012\u0002\b\u00030\t8TX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006B"}, aXE = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Lkotlin/jvm/internal/ClassBasedDeclarationContainer;", "()V", "constructorDescriptors", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "()Ljava/util/Collection;", "methodOwner", "Ljava/lang/Class;", "getMethodOwner", "()Ljava/lang/Class;", "addParametersAndMasks", "", "result", "", "desc", "", "isConstructor", "", "createProperty", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "findConstructorBySignature", "Ljava/lang/reflect/Constructor;", "isPublic", "findDefaultConstructor", "findDefaultMethod", "Ljava/lang/reflect/Method;", "name", "isMember", "findFunctionDescriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "signature", "findMethodBySignature", "findPropertyDescriptor", "getFunctions", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "getLocalProperty", "index", "", "getMembers", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "scope", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "belonginess", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$MemberBelonginess;", "getProperties", "loadParameterTypes", "", "loadReturnType", "parseType", "begin", "end", "lookupMethod", "parameterTypes", "returnType", "tryGetConstructor", "declared", "tryGetMethod", "", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;Ljava/lang/Class;Z)Ljava/lang/reflect/Method;", "Companion", "Data", "MemberBelonginess", "kotlin-reflect-api"})
/* compiled from: KDeclarationContainerImpl.kt */
public abstract class KDeclarationContainerImpl implements kotlin.jvm.internal.c {
    private static final Class<?> evN = Class.forName("kotlin.jvm.internal.f");
    private static final Regex evO = new Regex("<v#(\\d+)>");
    public static final a evP = new a();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, aXE = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$MemberBelonginess;", "", "(Ljava/lang/String;I)V", "accept", "", "member", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "DECLARED", "INHERITED", "kotlin-reflect-api"})
    /* compiled from: KDeclarationContainerImpl.kt */
    protected enum MemberBelonginess {
        DECLARED,
        INHERITED;

        public final boolean accept(CallableMemberDescriptor callableMemberDescriptor) {
            h.e(callableMemberDescriptor, "member");
            Kind bcW = callableMemberDescriptor.bcW();
            h.d(bcW, "member.kind");
            return bcW.isReal() == (((MemberBelonginess) this) == DECLARED);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0012\u0012\u0002\b\u0003 \u0005*\b\u0012\u0002\b\u0003\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, aXE = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Companion;", "", "()V", "DEFAULT_CONSTRUCTOR_MARKER", "Ljava/lang/Class;", "kotlin.jvm.PlatformType", "LOCAL_PROPERTY_SIGNATURE", "Lkotlin/text/Regex;", "getLOCAL_PROPERTY_SIGNATURE$kotlin_reflect_api", "()Lkotlin/text/Regex;", "kotlin-reflect-api"})
    /* compiled from: KDeclarationContainerImpl.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final Regex aZn() {
            return KDeclarationContainerImpl.evO;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b¦\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, aXE = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Data;", "", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;)V", "moduleData", "Lkotlin/reflect/jvm/internal/components/RuntimeModuleData;", "getModuleData", "()Lkotlin/reflect/jvm/internal/components/RuntimeModuleData;", "moduleData$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "kotlin-reflect-api"})
    /* compiled from: KDeclarationContainerImpl.kt */
    public abstract class b {
        static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(b.class), "moduleData", "getModuleData()Lkotlin/reflect/jvm/internal/components/RuntimeModuleData;"))};
        private final kotlin.reflect.jvm.internal.y.a evQ = y.h(new KDeclarationContainerImpl$Data$moduleData$2(this));

        public final kotlin.reflect.jvm.internal.components.j aZo() {
            return (kotlin.reflect.jvm.internal.components.j) this.evQ.G(this, apP[0]);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "", "first", "Lkotlin/reflect/jvm/internal/impl/descriptors/Visibility;", "kotlin.jvm.PlatformType", "second", "compare"})
    /* compiled from: KDeclarationContainerImpl.kt */
    static final class c<T> implements Comparator<av> {
        public static final c evU = new c();

        c() {
        }

        /* renamed from: a */
        public final int compare(av avVar, av avVar2) {
            Integer c = au.c(avVar, avVar2);
            return c != null ? c.intValue() : 0;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001J!\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003H\u0016¢\u0006\u0002\u0010\bJ!\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0003H\u0016¢\u0006\u0002\u0010\u000bJ!\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0003H\u0016¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, aXE = {"kotlin/reflect/jvm/internal/KDeclarationContainerImpl$getMembers$visitor$1", "Lkotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorVisitorEmptyBodies;", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "", "visitConstructorDescriptor", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "data", "(Lorg/jetbrains/kotlin/descriptors/ConstructorDescriptor;Lkotlin/Unit;)Lkotlin/reflect/jvm/internal/KCallableImpl;", "visitFunctionDescriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "(Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;Lkotlin/Unit;)Lkotlin/reflect/jvm/internal/KCallableImpl;", "visitPropertyDescriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "(Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;Lkotlin/Unit;)Lkotlin/reflect/jvm/internal/KCallableImpl;", "kotlin-reflect-api"})
    /* compiled from: KDeclarationContainerImpl.kt */
    public static final class d extends l<g<?>, kotlin.l> {
        final /* synthetic */ KDeclarationContainerImpl evR;

        d(KDeclarationContainerImpl kDeclarationContainerImpl) {
            this.evR = kDeclarationContainerImpl;
        }

        public g<?> a(ad adVar, kotlin.l lVar) {
            h.e(adVar, "descriptor");
            h.e(lVar, "data");
            return this.evR.a(adVar);
        }

        public g<?> a(r rVar, kotlin.l lVar) {
            h.e(rVar, "descriptor");
            h.e(lVar, "data");
            return new KFunctionImpl(this.evR, rVar);
        }

        public g<?> a(kotlin.reflect.jvm.internal.impl.descriptors.j jVar, kotlin.l lVar) {
            h.e(jVar, "descriptor");
            h.e(lVar, "data");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("No constructors should appear in this scope: ");
            stringBuilder.append(jVar);
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    public abstract Collection<ad> a(f fVar);

    public abstract Collection<kotlin.reflect.jvm.internal.impl.descriptors.j> aYt();

    public abstract Collection<r> b(f fVar);

    public abstract ad jo(int i);

    protected Class<?> aZl() {
        Class<?> R = kotlin.reflect.jvm.internal.structure.b.R(aXV());
        return R != null ? R : aXV();
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0022 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0058  */
    protected final java.util.Collection<kotlin.reflect.jvm.internal.g<?>> a(kotlin.reflect.jvm.internal.impl.resolve.scopes.h r8, kotlin.reflect.jvm.internal.KDeclarationContainerImpl.MemberBelonginess r9) {
        /*
        r7 = this;
        r0 = "scope";
        kotlin.jvm.internal.h.e(r8, r0);
        r0 = "belonginess";
        kotlin.jvm.internal.h.e(r9, r0);
        r0 = new kotlin.reflect.jvm.internal.KDeclarationContainerImpl$d;
        r0.<init>(r7);
        r1 = 0;
        r2 = 3;
        r8 = kotlin.reflect.jvm.internal.impl.resolve.scopes.j.a.a(r8, r1, r1, r2, r1);
        r8 = (java.lang.Iterable) r8;
        r2 = new java.util.ArrayList;
        r2.<init>();
        r2 = (java.util.Collection) r2;
        r8 = r8.iterator();
    L_0x0022:
        r3 = r8.hasNext();
        if (r3 == 0) goto L_0x005c;
    L_0x0028:
        r3 = r8.next();
        r3 = (kotlin.reflect.jvm.internal.impl.descriptors.k) r3;
        r4 = r3 instanceof kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
        if (r4 == 0) goto L_0x0055;
    L_0x0032:
        r4 = r3;
        r4 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) r4;
        r5 = r4.bbJ();
        r6 = kotlin.reflect.jvm.internal.impl.descriptors.au.eBj;
        r5 = kotlin.jvm.internal.h.E(r5, r6);
        r5 = r5 ^ 1;
        if (r5 == 0) goto L_0x0055;
    L_0x0043:
        r4 = r9.accept(r4);
        if (r4 == 0) goto L_0x0055;
    L_0x0049:
        r4 = r0;
        r4 = (kotlin.reflect.jvm.internal.impl.descriptors.m) r4;
        r5 = kotlin.l.etX;
        r3 = r3.a(r4, r5);
        r3 = (kotlin.reflect.jvm.internal.g) r3;
        goto L_0x0056;
    L_0x0055:
        r3 = r1;
    L_0x0056:
        if (r3 == 0) goto L_0x0022;
    L_0x0058:
        r2.add(r3);
        goto L_0x0022;
    L_0x005c:
        r2 = (java.util.List) r2;
        r2 = (java.lang.Iterable) r2;
        r8 = kotlin.collections.u.W(r2);
        r8 = (java.util.Collection) r8;
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.KDeclarationContainerImpl.a(kotlin.reflect.jvm.internal.impl.resolve.scopes.h, kotlin.reflect.jvm.internal.KDeclarationContainerImpl$MemberBelonginess):java.util.Collection<kotlin.reflect.jvm.internal.g<?>>");
    }

    private final s<?> a(ad adVar) {
        int i = 0;
        int i2 = adVar.bcP() != null ? 1 : 0;
        if (adVar.bcO() != null) {
            i = 1;
        }
        i2 += i;
        if (adVar.bdW()) {
            switch (i2) {
                case 0:
                    return new k(this, adVar);
                case 1:
                    return new l(this, adVar);
                case 2:
                    return new m(this, adVar);
            }
        }
        switch (i2) {
            case 0:
                return new p(this, adVar);
            case 1:
                return new q(this, adVar);
            case 2:
                return new r(this, adVar);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unsupported property: ");
        stringBuilder.append(adVar);
        throw new KotlinReflectionInternalError(stringBuilder.toString());
    }

    public final ad aY(String str, String str2) {
        h.e(str, "name");
        h.e(str2, "signature");
        kotlin.text.i L = evO.L(str2);
        int i = 1;
        if (L != null) {
            str = (String) L.bAk().bAl().bAj().get(1);
            ad jo = jo(Integer.parseInt(str));
            if (jo != null) {
                return jo;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Local property #");
            stringBuilder.append(str);
            stringBuilder.append(" not found in ");
            stringBuilder.append(aXV());
            throw new KotlinReflectionInternalError(stringBuilder.toString());
        }
        f mD = f.mD(str);
        h.d(mD, "Name.identifier(name)");
        Collection arrayList = new ArrayList();
        for (Object next : a(mD)) {
            if (h.E(ac.ewF.d((ad) next).asString(), str2)) {
                arrayList.add(next);
            }
        }
        List list = (List) arrayList;
        if (list.isEmpty()) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Property '");
            stringBuilder2.append(str);
            stringBuilder2.append("' (JVM signature: ");
            stringBuilder2.append(str2);
            stringBuilder2.append(") not resolved in ");
            stringBuilder2.append(this);
            throw new KotlinReflectionInternalError(stringBuilder2.toString());
        } else if (list.size() == 1) {
            return (ad) u.bY(list);
        } else {
            Map linkedHashMap = new LinkedHashMap();
            for (Object next2 : list) {
                av bbJ = ((ad) next2).bbJ();
                ArrayList arrayList2 = linkedHashMap.get(bbJ);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                    linkedHashMap.put(bbJ, arrayList2);
                }
                arrayList2.add(next2);
            }
            Collection values = ac.b(linkedHashMap, c.evU).values();
            h.d(values, "properties\n             …                }).values");
            List list2 = (List) u.O((Iterable) values);
            if (list2.size() == 1) {
                h.d(list2, "mostVisibleProperties");
                return (ad) u.bU(list2);
            }
            mD = f.mD(str);
            h.d(mD, "Name.identifier(name)");
            String a = u.a(a(mD), "\n", null, null, 0, null, KDeclarationContainerImpl$findPropertyDescriptor$allMembers$1.evT, 30, null);
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("Property '");
            stringBuilder3.append(str);
            stringBuilder3.append("' (JVM signature: ");
            stringBuilder3.append(str2);
            stringBuilder3.append(") not resolved in ");
            stringBuilder3.append(this);
            stringBuilder3.append(':');
            if (a.length() != 0) {
                i = 0;
            }
            if (i != 0) {
                str = " no members found";
            } else {
                StringBuilder stringBuilder4 = new StringBuilder();
                stringBuilder4.append(10);
                stringBuilder4.append(a);
                str = stringBuilder4.toString();
            }
            stringBuilder3.append(str);
            throw new KotlinReflectionInternalError(stringBuilder3.toString());
        }
    }

    public final r aZ(String str, String str2) {
        Collection W;
        h.e(str, "name");
        h.e(str2, "signature");
        if (h.E(str, "<init>")) {
            W = u.W(aYt());
        } else {
            f mD = f.mD(str);
            h.d(mD, "Name.identifier(name)");
            W = b(mD);
        }
        Iterable iterable = W;
        W = new ArrayList();
        for (Object next : iterable) {
            if (h.E(ac.ewF.d((r) next).asString(), str2)) {
                W.add(next);
            }
        }
        List list = (List) W;
        Object obj = 1;
        if (list.size() == 1) {
            return (r) u.bY(list);
        }
        String a = u.a(iterable, "\n", null, null, 0, null, KDeclarationContainerImpl$findFunctionDescriptor$allMembers$1.evS, 30, null);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Function '");
        stringBuilder.append(str);
        stringBuilder.append("' (JVM signature: ");
        stringBuilder.append(str2);
        stringBuilder.append(") not resolved in ");
        stringBuilder.append(this);
        stringBuilder.append(':');
        if (a.length() != 0) {
            obj = null;
        }
        if (obj != null) {
            str = " no members found";
        } else {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(10);
            stringBuilder2.append(a);
            str = stringBuilder2.toString();
        }
        stringBuilder.append(str);
        throw new KotlinReflectionInternalError(stringBuilder.toString());
    }

    private final Method a(Class<?> cls, String str, List<? extends Class<?>> list, Class<?> cls2, boolean z) {
        Collection collection = list;
        if (collection == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.util.Collection<T>");
        }
        Object[] toArray = collection.toArray(new Class[0]);
        if (toArray == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        Class[] clsArr = (Class[]) toArray;
        if (z) {
            Method a = a((Class) cls, str, clsArr, (Class) cls2, false);
            if (a != null) {
                return a;
            }
            if (cls.isInterface()) {
                a = a(Object.class, str, (List) list, (Class) cls2, z);
                if (a != null) {
                    return a;
                }
            }
        }
        for (Class cls3 = cls; cls3 != null; cls3 = cls3.getSuperclass()) {
            Method a2 = a(cls3, str, clsArr, (Class) cls2, true);
            if (a2 != null) {
                return a2;
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0071 A:{LOOP_END, LOOP:0: B:12:0x003e->B:26:0x0071} */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x006f A:{SYNTHETIC} */
    private final java.lang.reflect.Method a(java.lang.Class<?> r6, java.lang.String r7, java.lang.Class<?>[] r8, java.lang.Class<?> r9, boolean r10) {
        /*
        r5 = this;
        r0 = 0;
        if (r10 == 0) goto L_0x000f;
    L_0x0003:
        r1 = r8.length;	 Catch:{ NoSuchMethodException -> 0x0074 }
        r1 = java.util.Arrays.copyOf(r8, r1);	 Catch:{ NoSuchMethodException -> 0x0074 }
        r1 = (java.lang.Class[]) r1;	 Catch:{ NoSuchMethodException -> 0x0074 }
        r1 = r6.getDeclaredMethod(r7, r1);	 Catch:{ NoSuchMethodException -> 0x0074 }
        goto L_0x001a;
    L_0x000f:
        r1 = r8.length;	 Catch:{ NoSuchMethodException -> 0x0074 }
        r1 = java.util.Arrays.copyOf(r8, r1);	 Catch:{ NoSuchMethodException -> 0x0074 }
        r1 = (java.lang.Class[]) r1;	 Catch:{ NoSuchMethodException -> 0x0074 }
        r1 = r6.getMethod(r7, r1);	 Catch:{ NoSuchMethodException -> 0x0074 }
    L_0x001a:
        r2 = "result";
        kotlin.jvm.internal.h.d(r1, r2);	 Catch:{ NoSuchMethodException -> 0x0074 }
        r2 = r1.getReturnType();	 Catch:{ NoSuchMethodException -> 0x0074 }
        r2 = kotlin.jvm.internal.h.E(r2, r9);	 Catch:{ NoSuchMethodException -> 0x0074 }
        if (r2 == 0) goto L_0x002b;
    L_0x0029:
        r0 = r1;
        goto L_0x0074;
    L_0x002b:
        if (r10 == 0) goto L_0x0032;
    L_0x002d:
        r6 = r6.getDeclaredMethods();	 Catch:{ NoSuchMethodException -> 0x0074 }
        goto L_0x0036;
    L_0x0032:
        r6 = r6.getMethods();	 Catch:{ NoSuchMethodException -> 0x0074 }
    L_0x0036:
        r10 = "allMethods";
        kotlin.jvm.internal.h.d(r6, r10);	 Catch:{ NoSuchMethodException -> 0x0074 }
        r10 = r6.length;	 Catch:{ NoSuchMethodException -> 0x0074 }
        r1 = 0;
        r2 = 0;
    L_0x003e:
        if (r2 >= r10) goto L_0x0074;
    L_0x0040:
        r3 = r6[r2];	 Catch:{ NoSuchMethodException -> 0x0074 }
        r4 = "method";
        kotlin.jvm.internal.h.d(r3, r4);	 Catch:{ NoSuchMethodException -> 0x0074 }
        r4 = r3.getName();	 Catch:{ NoSuchMethodException -> 0x0074 }
        r4 = kotlin.jvm.internal.h.E(r4, r7);	 Catch:{ NoSuchMethodException -> 0x0074 }
        if (r4 == 0) goto L_0x006c;
    L_0x0051:
        r4 = r3.getReturnType();	 Catch:{ NoSuchMethodException -> 0x0074 }
        r4 = kotlin.jvm.internal.h.E(r4, r9);	 Catch:{ NoSuchMethodException -> 0x0074 }
        if (r4 == 0) goto L_0x006c;
    L_0x005b:
        r4 = r3.getParameterTypes();	 Catch:{ NoSuchMethodException -> 0x0074 }
        if (r4 != 0) goto L_0x0064;
    L_0x0061:
        kotlin.jvm.internal.h.aXZ();	 Catch:{ NoSuchMethodException -> 0x0074 }
    L_0x0064:
        r4 = java.util.Arrays.equals(r4, r8);	 Catch:{ NoSuchMethodException -> 0x0074 }
        if (r4 == 0) goto L_0x006c;
    L_0x006a:
        r4 = 1;
        goto L_0x006d;
    L_0x006c:
        r4 = 0;
    L_0x006d:
        if (r4 == 0) goto L_0x0071;
    L_0x006f:
        r0 = r3;
        goto L_0x0074;
    L_0x0071:
        r2 = r2 + 1;
        goto L_0x003e;
    L_0x0074:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.KDeclarationContainerImpl.a(java.lang.Class, java.lang.String, java.lang.Class[], java.lang.Class, boolean):java.lang.reflect.Method");
    }

    private final Constructor<?> a(Class<?> cls, List<? extends Class<?>> list, boolean z) {
        Collection collection;
        Object[] toArray;
        Class[] clsArr;
        if (z) {
            try {
                collection = list;
                if (collection == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.util.Collection<T>");
                }
                toArray = collection.toArray(new Class[0]);
                if (toArray == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                }
                clsArr = (Class[]) toArray;
                return cls.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr, clsArr.length));
            } catch (NoSuchMethodException unused) {
                return null;
            }
        }
        collection = list;
        if (collection == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.util.Collection<T>");
        }
        toArray = collection.toArray(new Class[0]);
        if (toArray == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        clsArr = (Class[]) toArray;
        return cls.getConstructor((Class[]) Arrays.copyOf(clsArr, clsArr.length));
    }

    public final Method l(String str, String str2, boolean z) {
        h.e(str, "name");
        h.e(str2, "desc");
        if (h.E(str, "<init>")) {
            return null;
        }
        return a(aZl(), str, lV(str2), lW(str2), z);
    }

    public final Method a(String str, String str2, boolean z, boolean z2) {
        h.e(str, "name");
        h.e(str2, "desc");
        if (h.E(str, "<init>")) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (z) {
            arrayList.add(aXV());
        }
        List list = arrayList;
        a(list, str2, false);
        Class aZl = aZl();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("$default");
        return a(aZl, stringBuilder.toString(), list, lW(str2), z2);
    }

    public final Constructor<?> w(String str, boolean z) {
        h.e(str, "desc");
        return a(aXV(), lV(str), z ^ 1);
    }

    public final Constructor<?> x(String str, boolean z) {
        h.e(str, "desc");
        List arrayList = new ArrayList();
        a(arrayList, str, true);
        return a(aXV(), arrayList, z ^ true);
    }

    private final void a(List<Class<?>> list, String str, boolean z) {
        List lV = lV(str);
        list.addAll(lV);
        int size = ((lV.size() + 32) - 1) / 32;
        for (int i = 0; i < size; i++) {
            Class cls = Integer.TYPE;
            h.d(cls, "Integer.TYPE");
            list.add(cls);
        }
        Object obj = z ? evN : Object.class;
        h.d(obj, "if (isConstructor) DEFAU…RKER else Any::class.java");
        list.add(obj);
    }

    private final List<Class<?>> lV(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 1;
        while (str.charAt(i) != ')') {
            int i2 = i;
            while (str.charAt(i2) == '[') {
                i2++;
            }
            char charAt = str.charAt(i2);
            if (v.c((CharSequence) "VZCBSIFJD", charAt, false, 2, null)) {
                i2++;
            } else if (charAt == 'L') {
                i2 = v.a((CharSequence) str, ';', i, false, 4, null) + 1;
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown type prefix in the method signature: ");
                stringBuilder.append(str);
                throw new KotlinReflectionInternalError(stringBuilder.toString());
            }
            arrayList.add(g(str, i, i2));
            i = i2;
        }
        return arrayList;
    }

    private final Class<?> g(String str, int i, int i2) {
        Class<?> loadClass;
        switch (str.charAt(i)) {
            case 'B':
                return Byte.TYPE;
            case 'C':
                return Character.TYPE;
            case 'D':
                return Double.TYPE;
            case 'F':
                return Float.TYPE;
            case 'I':
                return Integer.TYPE;
            case 'J':
                return Long.TYPE;
            case 'L':
                ClassLoader O = kotlin.reflect.jvm.internal.structure.b.O(aXV());
                i++;
                i2--;
                if (str == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                String substring = str.substring(i, i2);
                h.d(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                loadClass = O.loadClass(u.a(substring, '/', '.', false, 4, null));
                h.d(loadClass, "jClass.safeClassLoader.l…d - 1).replace('/', '.'))");
                return loadClass;
            case 'S':
                return Short.TYPE;
            case 'V':
                loadClass = Void.TYPE;
                h.d(loadClass, "Void.TYPE");
                return loadClass;
            case 'Z':
                return Boolean.TYPE;
            case '[':
                return kotlin.reflect.jvm.internal.structure.b.U(g(str, i + 1, i2));
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown type prefix in the method signature: ");
                stringBuilder.append(str);
                throw new KotlinReflectionInternalError(stringBuilder.toString());
        }
    }

    private final Class<?> lW(String str) {
        return g(str, v.a((CharSequence) str, ')', 0, false, 6, null) + 1, str.length());
    }
}
