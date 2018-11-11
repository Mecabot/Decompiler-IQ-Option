package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.a.m;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.PropertyReference;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.components.e;
import kotlin.reflect.jvm.internal.components.l.a;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.c;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ai;
import kotlin.reflect.jvm.internal.impl.descriptors.au;
import kotlin.reflect.jvm.internal.impl.descriptors.av;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.load.kotlin.n;
import kotlin.reflect.jvm.internal.impl.load.kotlin.p;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property;
import kotlin.reflect.jvm.internal.impl.name.b;
import kotlin.reflect.jvm.internal.structure.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001an\u0010\r\u001a\u0004\u0018\u0001H\u000e\"\b\b\u0000\u0010\u000f*\u00020\u0010\"\b\b\u0001\u0010\u000e*\u00020\u00112\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u00132\u0006\u0010\u0014\u001a\u0002H\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u001d\u0010\u001b\u001a\u0019\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u000e0\u001c¢\u0006\u0002\b\u001eH\u0000¢\u0006\u0002\u0010\u001f\u001a&\u0010 \u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00132\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020\tH\u0000\u001a\"\u0010%\u001a\u0002H&\"\u0004\b\u0000\u0010&2\f\u0010'\u001a\b\u0012\u0004\u0012\u0002H&0(H\b¢\u0006\u0002\u0010)\u001a\u0014\u0010*\u001a\b\u0012\u0002\b\u0003\u0018\u00010+*\u0004\u0018\u00010,H\u0000\u001a\u0010\u0010-\u001a\u0004\u0018\u00010.*\u0004\u0018\u00010,H\u0000\u001a\u0014\u0010/\u001a\b\u0012\u0002\b\u0003\u0018\u000100*\u0004\u0018\u00010,H\u0000\u001a\u0012\u00101\u001a\b\u0012\u0004\u0012\u00020302*\u000204H\u0000\u001a\u0012\u00105\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0013*\u000206H\u0000\u001a\u000e\u00107\u001a\u0004\u0018\u000108*\u000209H\u0000\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0018\u0010\u0004\u001a\u00020\u0005*\u00020\u00068@X\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0007\"\u001a\u0010\b\u001a\u0004\u0018\u00010\t*\u00020\n8@X\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006:"}, aXE = {"JVM_STATIC", "Lkotlin/reflect/jvm/internal/impl/name/FqName;", "getJVM_STATIC", "()Lorg/jetbrains/kotlin/name/FqName;", "isPublicInBytecode", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "(Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;)Z", "packageModuleName", "", "Lkotlin/reflect/jvm/internal/components/ReflectKotlinClass;", "getPackageModuleName", "(Lkotlin/reflect/jvm/internal/components/ReflectKotlinClass;)Ljava/lang/String;", "deserializeToDescriptor", "D", "M", "Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableDescriptor;", "moduleAnchor", "Ljava/lang/Class;", "proto", "nameResolver", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/NameResolver;", "typeTable", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/TypeTable;", "metadataVersion", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/BinaryVersion;", "createDescriptor", "Lkotlin/Function2;", "Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/MemberDeserializer;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Class;Lorg/jetbrains/kotlin/protobuf/MessageLite;Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;Lorg/jetbrains/kotlin/metadata/deserialization/TypeTable;Lorg/jetbrains/kotlin/metadata/deserialization/BinaryVersion;Lkotlin/jvm/functions/Function2;)Lorg/jetbrains/kotlin/descriptors/CallableDescriptor;", "loadClass", "classLoader", "Ljava/lang/ClassLoader;", "packageName", "className", "reflectionCall", "R", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "asKCallableImpl", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "", "asKFunctionImpl", "Lkotlin/reflect/jvm/internal/KFunctionImpl;", "asKPropertyImpl", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "computeAnnotations", "", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/Annotated;", "toJavaClass", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "toKVisibility", "Lkotlin/reflect/KVisibility;", "Lkotlin/reflect/jvm/internal/impl/descriptors/Visibility;", "kotlin-reflect-api"})
/* compiled from: util.kt */
public final class ae {
    private static final b ewH = new b("kotlin.jvm.JvmStatic");

    public static final b bam() {
        return ewH;
    }

    public static final Class<?> a(d dVar) {
        Class<?> bao;
        h.e(dVar, "$receiver");
        ai bbR = dVar.bbR();
        if (bbR instanceof p) {
            n biC = ((p) bbR).biC();
            if (biC == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.reflect.jvm.internal.components.ReflectKotlinClass");
            }
            bao = ((e) biC).bao();
        } else if (bbR instanceof a) {
            kotlin.reflect.jvm.internal.structure.n bav = ((a) bbR).baw();
            if (bav == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.reflect.jvm.internal.structure.ReflectJavaClass");
            }
            bao = ((j) bav).bzP();
        } else {
            c cVar = c.eAc;
            kotlin.reflect.jvm.internal.impl.name.c w = kotlin.reflect.jvm.internal.impl.resolve.c.w(dVar);
            h.d(w, "DescriptorUtils.getFqName(this)");
            kotlin.reflect.jvm.internal.impl.name.a c = cVar.c(w);
            if (c == null) {
                c = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.c(dVar);
            }
            if (c == null) {
                return null;
            }
            String asString = c.getPackageFqName().asString();
            String asString2 = c.btG().asString();
            ClassLoader O = kotlin.reflect.jvm.internal.structure.b.O(dVar.getClass());
            h.d(asString, "packageName");
            h.d(asString2, "className");
            bao = a(O, asString, asString2);
        }
        return bao;
    }

    public static final Class<?> a(ClassLoader classLoader, String str, String str2) {
        h.e(classLoader, "classLoader");
        h.e(str, "packageName");
        h.e(str2, "className");
        if (h.E(str, "kotlin")) {
            switch (str2.hashCode()) {
                case -901856463:
                    if (str2.equals("BooleanArray")) {
                        return boolean[].class;
                    }
                    break;
                case -763279523:
                    if (str2.equals("ShortArray")) {
                        return short[].class;
                    }
                    break;
                case -755911549:
                    if (str2.equals("CharArray")) {
                        return char[].class;
                    }
                    break;
                case -74930671:
                    if (str2.equals("ByteArray")) {
                        return byte[].class;
                    }
                    break;
                case 22374632:
                    if (str2.equals("DoubleArray")) {
                        return double[].class;
                    }
                    break;
                case 63537721:
                    if (str2.equals("Array")) {
                        return Object[].class;
                    }
                    break;
                case 601811914:
                    if (str2.equals("IntArray")) {
                        return int[].class;
                    }
                    break;
                case 948852093:
                    if (str2.equals("FloatArray")) {
                        return float[].class;
                    }
                    break;
                case 2104330525:
                    if (str2.equals("LongArray")) {
                        return long[].class;
                    }
                    break;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append('.');
        stringBuilder.append(u.a(str2, '.', '$', false, 4, null));
        return kotlin.reflect.jvm.internal.components.d.a(classLoader, stringBuilder.toString());
    }

    public static final List<Annotation> a(kotlin.reflect.jvm.internal.impl.descriptors.annotations.a aVar) {
        h.e(aVar, "$receiver");
        Collection arrayList = new ArrayList();
        for (kotlin.reflect.jvm.internal.impl.descriptors.annotations.c bbR : aVar.bbQ()) {
            ai bbR2 = bbR.bbR();
            Object obj = null;
            if (bbR2 instanceof kotlin.reflect.jvm.internal.components.a) {
                obj = ((kotlin.reflect.jvm.internal.components.a) bbR2).getAnnotation();
            } else if (bbR2 instanceof a) {
                kotlin.reflect.jvm.internal.structure.n bav = ((a) bbR2).baw();
                if (!(bav instanceof kotlin.reflect.jvm.internal.structure.c)) {
                    bav = null;
                }
                kotlin.reflect.jvm.internal.structure.c cVar = (kotlin.reflect.jvm.internal.structure.c) bav;
                if (cVar != null) {
                    obj = cVar.getAnnotation();
                }
            }
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return (List) arrayList;
    }

    public static final KFunctionImpl cH(Object obj) {
        KFunctionImpl kFunctionImpl = (KFunctionImpl) (!(obj instanceof KFunctionImpl) ? null : obj);
        if (kFunctionImpl != null) {
            return kFunctionImpl;
        }
        if (!(obj instanceof FunctionReference)) {
            obj = null;
        }
        FunctionReference functionReference = (FunctionReference) obj;
        kotlin.reflect.a aXR = functionReference != null ? functionReference.aXR() : null;
        if (!(aXR instanceof KFunctionImpl)) {
            aXR = null;
        }
        return (KFunctionImpl) aXR;
    }

    public static final s<?> cI(Object obj) {
        s<?> sVar = (s) (!(obj instanceof s) ? null : obj);
        if (sVar != null) {
            return sVar;
        }
        if (!(obj instanceof PropertyReference)) {
            obj = null;
        }
        PropertyReference propertyReference = (PropertyReference) obj;
        kotlin.reflect.a aXR = propertyReference != null ? propertyReference.aXR() : null;
        if (!(aXR instanceof s)) {
            aXR = null;
        }
        return (s) aXR;
    }

    public static final g<?> cJ(Object obj) {
        g<?> gVar = (g) (!(obj instanceof g) ? null : obj);
        if (gVar == null) {
            gVar = cH(obj);
        }
        return gVar != null ? gVar : cI(obj);
    }

    /* JADX WARNING: Missing block: B:20:0x009a, code:
            if (r2 != null) goto L_0x009f;
     */
    public static final java.lang.String a(kotlin.reflect.jvm.internal.components.e r9) {
        /*
        r0 = "$receiver";
        kotlin.jvm.internal.h.e(r9, r0);
        r0 = r9.bap();
        r1 = r0.biN();
        r1 = r1.btC();
        r2 = 0;
        if (r1 != 0) goto L_0x0015;
    L_0x0014:
        return r2;
    L_0x0015:
        r1 = r0.biM();
        r3 = kotlin.reflect.jvm.internal.af.aoS;
        r1 = r1.ordinal();
        r1 = r3[r1];
        switch(r1) {
            case 1: goto L_0x005d;
            case 2: goto L_0x005d;
            case 3: goto L_0x0026;
            default: goto L_0x0024;
        };
    L_0x0024:
        goto L_0x009f;
    L_0x0026:
        r0 = r0.biK();
        r0 = kotlin.collections.u.bV(r0);
        r3 = r0;
        r3 = (java.lang.String) r3;
        if (r3 == 0) goto L_0x005c;
    L_0x0033:
        r0 = kotlin.reflect.jvm.internal.components.e.ewO;
        r9 = r9.bao();
        r9 = r9.getClassLoader();
        r4 = 47;
        r5 = 46;
        r6 = 0;
        r7 = 4;
        r8 = 0;
        r1 = kotlin.text.u.a(r3, r4, r5, r6, r7, r8);
        r9 = r9.loadClass(r1);
        r1 = "klass.classLoader.loadCl…rtName.replace('/', '.'))";
        kotlin.jvm.internal.h.d(r9, r1);
        r9 = r0.M(r9);
        if (r9 == 0) goto L_0x009f;
    L_0x0057:
        r2 = a(r9);
        goto L_0x009f;
    L_0x005c:
        return r2;
    L_0x005d:
        r9 = r0.biO();
        if (r9 != 0) goto L_0x0066;
    L_0x0063:
        kotlin.jvm.internal.h.aXZ();
    L_0x0066:
        r0 = r0.biQ();
        if (r0 != 0) goto L_0x006f;
    L_0x006c:
        kotlin.jvm.internal.h.aXZ();
    L_0x006f:
        r9 = kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.j.b(r9, r0);
        r0 = r9.aXG();
        r0 = (kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.h) r0;
        r9 = r9.aXH();
        r9 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Package) r9;
        r9 = (kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableMessage) r9;
        r1 = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.eMt;
        r2 = "JvmProtoBuf.packageModuleName";
        kotlin.jvm.internal.h.d(r1, r2);
        r9 = kotlin.reflect.jvm.internal.impl.metadata.a.f.a(r9, r1);
        r9 = (java.lang.Integer) r9;
        if (r9 == 0) goto L_0x009d;
    L_0x0090:
        r9 = (java.lang.Number) r9;
        r9 = r9.intValue();
        r2 = r0.getString(r9);
        if (r2 == 0) goto L_0x009d;
    L_0x009c:
        goto L_0x009f;
    L_0x009d:
        r2 = "main";
    L_0x009f:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.ae.a(kotlin.reflect.jvm.internal.components.e):java.lang.String");
    }

    public static final boolean b(CallableMemberDescriptor callableMemberDescriptor) {
        h.e(callableMemberDescriptor, "$receiver");
        av bbJ = callableMemberDescriptor.bbJ();
        return (h.E(bbJ, au.eBg) || h.E(bbJ, au.eBf)) && !kotlin.reflect.jvm.internal.impl.descriptors.annotations.e.b(callableMemberDescriptor);
    }

    public static final <M extends kotlin.reflect.jvm.internal.impl.protobuf.n, D extends kotlin.reflect.jvm.internal.impl.descriptors.a> D a(Class<?> cls, M m, kotlin.reflect.jvm.internal.impl.metadata.a.c cVar, kotlin.reflect.jvm.internal.impl.metadata.a.h hVar, kotlin.reflect.jvm.internal.impl.metadata.a.a aVar, m<? super kotlin.reflect.jvm.internal.impl.serialization.deserialization.p, ? super M, ? extends D> mVar) {
        List bkn;
        M m2 = m;
        m<? super kotlin.reflect.jvm.internal.impl.serialization.deserialization.p, ? super M, ? extends D> mVar2 = mVar;
        Class<?> cls2 = cls;
        h.e(cls2, "moduleAnchor");
        h.e(m2, "proto");
        kotlin.reflect.jvm.internal.impl.metadata.a.c cVar2 = cVar;
        h.e(cVar2, "nameResolver");
        kotlin.reflect.jvm.internal.impl.metadata.a.h hVar2 = hVar;
        h.e(hVar2, "typeTable");
        kotlin.reflect.jvm.internal.impl.metadata.a.a aVar2 = aVar;
        h.e(aVar2, "metadataVersion");
        h.e(mVar2, "createDescriptor");
        kotlin.reflect.jvm.internal.components.j J = x.J(cls2);
        if (m2 instanceof Function) {
            bkn = ((Function) m2).bkn();
        } else if (m2 instanceof Property) {
            bkn = ((Property) m2).bkn();
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unsupported message: ");
            stringBuilder.append(m2);
            throw new IllegalStateException(stringBuilder.toString().toString());
        }
        List list = bkn;
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.h bas = J.bas();
        k bar = J.bar();
        kotlin.reflect.jvm.internal.impl.metadata.a.k bri = kotlin.reflect.jvm.internal.impl.metadata.a.k.eMf.bri();
        h.d(list, "typeParameters");
        return (kotlin.reflect.jvm.internal.impl.descriptors.a) mVar2.B(new kotlin.reflect.jvm.internal.impl.serialization.deserialization.p(new kotlin.reflect.jvm.internal.impl.serialization.deserialization.j(bas, cVar2, bar, hVar2, bri, aVar2, null, null, list)), m2);
    }
}
