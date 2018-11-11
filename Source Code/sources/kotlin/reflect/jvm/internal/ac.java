package kotlin.reflect.jvm.internal;

import java.lang.reflect.Method;
import kotlin.i;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.e.d;
import kotlin.reflect.jvm.internal.e.e;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.g;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ad;
import kotlin.reflect.jvm.internal.impl.descriptors.ae;
import kotlin.reflect.jvm.internal.impl.descriptors.af;
import kotlin.reflect.jvm.internal.impl.descriptors.ai;
import kotlin.reflect.jvm.internal.impl.descriptors.r;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.q;
import kotlin.reflect.jvm.internal.impl.load.java.structure.l;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmPropertySignature;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.f;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.j;
import kotlin.reflect.jvm.internal.impl.name.a;
import kotlin.reflect.jvm.internal.impl.name.b;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableMessage;
import kotlin.reflect.jvm.internal.impl.protobuf.n;
import kotlin.reflect.jvm.internal.impl.resolve.c;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.reflect.jvm.internal.structure.m;
import kotlin.reflect.jvm.internal.structure.p;
import kotlin.reflect.jvm.internal.structure.s;

@i(aXC = {1, 1, 11}, aXD = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\n\u001a\u00020\u00042\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u0012H\u0002J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u0006\u0012\u0002\b\u00030\u00078BX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u001a"}, aXE = {"Lkotlin/reflect/jvm/internal/RuntimeTypeMapper;", "", "()V", "JAVA_LANG_VOID", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "primitiveType", "Lkotlin/reflect/jvm/internal/impl/builtins/PrimitiveType;", "Ljava/lang/Class;", "getPrimitiveType", "(Ljava/lang/Class;)Lorg/jetbrains/kotlin/builtins/PrimitiveType;", "mapJvmClassToKotlinClassId", "klass", "mapJvmFunctionSignature", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "mapName", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "mapPropertySignature", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "possiblyOverriddenProperty", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "mapSignature", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "possiblySubstitutedFunction", "kotlin-reflect-api"})
/* compiled from: RuntimeTypeMapper.kt */
public final class ac {
    private static final a ewE = a.t(new b("java.lang.Void"));
    public static final ac ewF = new ac();

    private ac() {
    }

    public final e d(r rVar) {
        h.e(rVar, "possiblySubstitutedFunction");
        CallableMemberDescriptor A = c.A((CallableMemberDescriptor) rVar);
        h.d(A, "DescriptorUtils.unwrapFa…siblySubstitutedFunction)");
        rVar = ((r) A).bdk();
        if (rVar instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.c) {
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.c cVar = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.c) rVar;
            n bxV = cVar.bxV();
            if (bxV instanceof Function) {
                f.b a = j.eMR.a((Function) bxV, cVar.aYI(), cVar.aYJ());
                if (a != null) {
                    return new e(a);
                }
            }
            if (bxV instanceof Constructor) {
                f.b a2 = j.eMR.a((Constructor) bxV, cVar.aYI(), cVar.aYJ());
                if (a2 != null) {
                    return new d(a2);
                }
            }
            h.d(rVar, "function");
            return e(rVar);
        }
        Object obj = null;
        ai bbR;
        kotlin.reflect.jvm.internal.impl.load.java.a.a aVar;
        StringBuilder stringBuilder;
        if (rVar instanceof JavaMethodDescriptor) {
            h.d(rVar, "function");
            bbR = ((JavaMethodDescriptor) rVar).bbR();
            if (!(bbR instanceof kotlin.reflect.jvm.internal.impl.load.java.a.a)) {
                bbR = null;
            }
            aVar = (kotlin.reflect.jvm.internal.impl.load.java.a.a) bbR;
            l baw = aVar != null ? aVar.baw() : null;
            if (!(baw instanceof s)) {
                baw = null;
            }
            s sVar = (s) baw;
            if (sVar != null) {
                Method bAb = sVar.bzW();
                if (bAb != null) {
                    return new e.c(bAb);
                }
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("Incorrect resolution sequence for Java method ");
            stringBuilder.append(rVar);
            throw new KotlinReflectionInternalError(stringBuilder.toString());
        } else if (rVar instanceof kotlin.reflect.jvm.internal.impl.load.java.descriptors.c) {
            e bVar;
            h.d(rVar, "function");
            bbR = ((kotlin.reflect.jvm.internal.impl.load.java.descriptors.c) rVar).bbR();
            if (!(bbR instanceof kotlin.reflect.jvm.internal.impl.load.java.a.a)) {
                bbR = null;
            }
            aVar = (kotlin.reflect.jvm.internal.impl.load.java.a.a) bbR;
            if (aVar != null) {
                obj = aVar.baw();
            }
            if (obj instanceof m) {
                bVar = new e.b(((m) obj).bzW());
            } else {
                if (obj instanceof kotlin.reflect.jvm.internal.structure.j) {
                    kotlin.reflect.jvm.internal.structure.j jVar = (kotlin.reflect.jvm.internal.structure.j) obj;
                    if (jVar.bhr()) {
                        bVar = new e.a(jVar.bzP());
                    }
                }
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Incorrect resolution sequence for Java constructor ");
                stringBuilder2.append(rVar);
                stringBuilder2.append(" (");
                stringBuilder2.append(obj);
                stringBuilder2.append(')');
                throw new KotlinReflectionInternalError(stringBuilder2.toString());
            }
            return bVar;
        } else if (kotlin.reflect.jvm.internal.impl.resolve.b.k(rVar) || kotlin.reflect.jvm.internal.impl.resolve.b.j(rVar)) {
            h.d(rVar, "function");
            return e(rVar);
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Unknown origin of ");
            stringBuilder.append(rVar);
            stringBuilder.append(" (");
            stringBuilder.append(rVar.getClass());
            stringBuilder.append(')');
            throw new KotlinReflectionInternalError(stringBuilder.toString());
        }
    }

    public final f d(ad adVar) {
        af bdJ;
        h.e(adVar, "possiblyOverriddenProperty");
        CallableMemberDescriptor A = c.A((CallableMemberDescriptor) adVar);
        h.d(A, "DescriptorUtils.unwrapFa…ssiblyOverriddenProperty)");
        ad bdL = ((ad) A).bdL();
        e eVar = null;
        if (bdL instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.j) {
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.j jVar = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.j) bdL;
            Property aYG = jVar.bxV();
            ExtendableMessage extendableMessage = aYG;
            GeneratedMessageLite.e eVar2 = JvmProtoBuf.eMl;
            h.d(eVar2, "JvmProtoBuf.propertySignature");
            JvmPropertySignature jvmPropertySignature = (JvmPropertySignature) kotlin.reflect.jvm.internal.impl.metadata.a.f.a(extendableMessage, eVar2);
            if (jvmPropertySignature != null) {
                h.d(bdL, "property");
                return new f.c(bdL, aYG, jvmPropertySignature, jVar.aYI(), jVar.aYJ());
            }
        } else if (bdL instanceof kotlin.reflect.jvm.internal.impl.load.java.descriptors.e) {
            f aVar;
            h.d(bdL, "property");
            ai bbR = ((kotlin.reflect.jvm.internal.impl.load.java.descriptors.e) bdL).bbR();
            if (!(bbR instanceof kotlin.reflect.jvm.internal.impl.load.java.a.a)) {
                bbR = null;
            }
            kotlin.reflect.jvm.internal.impl.load.java.a.a aVar2 = (kotlin.reflect.jvm.internal.impl.load.java.a.a) bbR;
            Object baw = aVar2 != null ? aVar2.baw() : null;
            if (baw instanceof p) {
                aVar = new f.a(((p) baw).bzW());
            } else if (baw instanceof s) {
                Method bAb;
                Method bAb2 = ((s) baw).bzW();
                bdJ = bdL.bdJ();
                ai bbR2 = bdJ != null ? bdJ.bbR() : null;
                if (!(bbR2 instanceof kotlin.reflect.jvm.internal.impl.load.java.a.a)) {
                    bbR2 = null;
                }
                kotlin.reflect.jvm.internal.impl.load.java.a.a aVar3 = (kotlin.reflect.jvm.internal.impl.load.java.a.a) bbR2;
                l baw2 = aVar3 != null ? aVar3.baw() : null;
                if (!(baw2 instanceof s)) {
                    baw2 = null;
                }
                s sVar = (s) baw2;
                if (sVar != null) {
                    bAb = sVar.bzW();
                }
                aVar = new f.b(bAb2, bAb);
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Incorrect resolution sequence for Java field ");
                stringBuilder.append(bdL);
                stringBuilder.append(" (source = ");
                stringBuilder.append(baw);
                stringBuilder.append(')');
                throw new KotlinReflectionInternalError(stringBuilder.toString());
            }
            return aVar;
        }
        ae bdI = bdL.bdI();
        if (bdI == null) {
            h.aXZ();
        }
        ac acVar = this;
        e e = acVar.e(bdI);
        bdJ = bdL.bdJ();
        if (bdJ != null) {
            eVar = acVar.e(bdJ);
        }
        return new f.d(e, eVar);
    }

    private final e e(r rVar) {
        return new e(new f.b(a(rVar), kotlin.reflect.jvm.internal.impl.load.kotlin.r.a(rVar, false, false, 1, null)));
    }

    private final String a(CallableMemberDescriptor callableMemberDescriptor) {
        String t = q.t(callableMemberDescriptor);
        if (t == null) {
            String mm;
            if (callableMemberDescriptor instanceof ae) {
                mm = kotlin.reflect.jvm.internal.impl.load.java.l.mm(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.H(callableMemberDescriptor).bdc().asString());
            } else if (callableMemberDescriptor instanceof af) {
                mm = kotlin.reflect.jvm.internal.impl.load.java.l.mn(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.H(callableMemberDescriptor).bdc().asString());
            } else {
                mm = callableMemberDescriptor.bdc().asString();
            }
            t = mm;
            h.d(t, "when (descriptor) {\n    …name.asString()\n        }");
        }
        return t;
    }

    public final a K(Class<?> cls) {
        h.e(cls, "klass");
        a t;
        if (cls.isArray()) {
            Class componentType = cls.getComponentType();
            h.d(componentType, "klass.componentType");
            PrimitiveType L = L(componentType);
            if (L != null) {
                return new a(g.exp, L.getArrayTypeName());
            }
            t = a.t(g.exC.exP.btP());
            h.d(t, "ClassId.topLevel(KotlinB….FQ_NAMES.array.toSafe())");
            return t;
        } else if (h.E(cls, Void.TYPE)) {
            t = ewE;
            h.d(t, "JAVA_LANG_VOID");
            return t;
        } else {
            PrimitiveType L2 = L(cls);
            if (L2 != null) {
                return new a(g.exp, L2.getTypeName());
            }
            t = kotlin.reflect.jvm.internal.structure.b.S(cls);
            if (!t.isLocal()) {
                kotlin.reflect.jvm.internal.impl.builtins.jvm.c cVar = kotlin.reflect.jvm.internal.impl.builtins.jvm.c.eAc;
                b btK = t.btK();
                h.d(btK, "classId.asSingleFqName()");
                a f = cVar.f(btK);
                if (f != null) {
                    return f;
                }
            }
            return t;
        }
    }

    private final PrimitiveType L(Class<?> cls) {
        if (!cls.isPrimitive()) {
            return null;
        }
        JvmPrimitiveType jvmPrimitiveType = JvmPrimitiveType.get(cls.getSimpleName());
        h.d(jvmPrimitiveType, "JvmPrimitiveType.get(simpleName)");
        return jvmPrimitiveType.getPrimitiveType();
    }
}
