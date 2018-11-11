package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Package;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter;
import kotlin.reflect.jvm.internal.impl.metadata.a.c;
import kotlin.reflect.jvm.internal.impl.metadata.a.g;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmFieldSignature;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmPropertySignature;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.f.a;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.f.b;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableMessage;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.e;
import kotlin.reflect.jvm.internal.impl.protobuf.f;

/* compiled from: JvmProtoBufUtil.kt */
public final class j {
    private static final f eMQ;
    public static final j eMR = new j();

    static {
        f buD = f.buD();
        JvmProtoBuf.a(buD);
        h.d(buD, "ExtensionRegistryLite.ne…f::registerAllExtensions)");
        eMQ = buD;
    }

    private j() {
    }

    public final f btD() {
        return eMQ;
    }

    public static final Pair<h, Class> a(String[] strArr, String[] strArr2) {
        h.e(strArr, "data");
        h.e(strArr2, "strings");
        byte[] k = b.k(strArr);
        h.d(k, "BitEncoding.decodeBytes(data)");
        return a(k, strArr2);
    }

    public static final Pair<h, Class> a(byte[] bArr, String[] strArr) {
        h.e(bArr, "bytes");
        h.e(strArr, "strings");
        InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        return new Pair(eMR.a(byteArrayInputStream, strArr), Class.a(byteArrayInputStream, eMQ));
    }

    public static final Pair<h, Package> b(String[] strArr, String[] strArr2) {
        h.e(strArr, "data");
        h.e(strArr2, "strings");
        byte[] k = b.k(strArr);
        h.d(k, "BitEncoding.decodeBytes(data)");
        return b(k, strArr2);
    }

    public static final Pair<h, Package> b(byte[] bArr, String[] strArr) {
        h.e(bArr, "bytes");
        h.e(strArr, "strings");
        InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        return new Pair(eMR.a(byteArrayInputStream, strArr), Package.c(byteArrayInputStream, eMQ));
    }

    public static final Pair<h, Function> c(String[] strArr, String[] strArr2) {
        h.e(strArr, "data");
        h.e(strArr2, "strings");
        InputStream byteArrayInputStream = new ByteArrayInputStream(b.k(strArr));
        return new Pair(eMR.a(byteArrayInputStream, strArr2), Function.b(byteArrayInputStream, eMQ));
    }

    private final h a(InputStream inputStream, String[] strArr) {
        StringTableTypes e = StringTableTypes.e(inputStream, eMQ);
        h.d(e, "JvmProtoBuf.StringTableT…this, EXTENSION_REGISTRY)");
        return new h(e, strArr);
    }

    public final b a(Function function, c cVar, kotlin.reflect.jvm.internal.impl.metadata.a.h hVar) {
        String b;
        h.e(function, "proto");
        h.e(cVar, "nameResolver");
        h.e(hVar, "typeTable");
        ExtendableMessage extendableMessage = function;
        e eVar = JvmProtoBuf.eMj;
        h.d(eVar, "JvmProtoBuf.methodSignature");
        JvmMethodSignature jvmMethodSignature = (JvmMethodSignature) kotlin.reflect.jvm.internal.impl.metadata.a.f.a(extendableMessage, eVar);
        int blW = (jvmMethodSignature == null || !jvmMethodSignature.hasName()) ? function.blW() : jvmMethodSignature.blW();
        if (jvmMethodSignature == null || !jvmMethodSignature.bse()) {
            Collection cs = m.cs(g.b(function, hVar));
            List blf = function.blf();
            h.d(blf, "proto.valueParameterList");
            Iterable<ValueParameter> iterable = blf;
            Collection arrayList = new ArrayList(n.e(iterable, 10));
            for (ValueParameter valueParameter : iterable) {
                h.d(valueParameter, "it");
                arrayList.add(g.a(valueParameter, hVar));
            }
            Iterable<Type> b2 = u.b(cs, (Iterable) (List) arrayList);
            Collection arrayList2 = new ArrayList(n.e(b2, 10));
            for (Type b3 : b2) {
                String b4 = eMR.b(b3, cVar);
                if (b4 == null) {
                    return null;
                }
                arrayList2.add(b4);
            }
            blf = (List) arrayList2;
            b = b(g.a(function, hVar), cVar);
            if (b == null) {
                return null;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(u.a(blf, "", "(", ")", 0, null, null, 56, null));
            stringBuilder.append(b);
            b = stringBuilder.toString();
        } else {
            b = cVar.getString(jvmMethodSignature.bsf());
        }
        return new b(cVar.getString(blW), b);
    }

    public final b a(Constructor constructor, c cVar, kotlin.reflect.jvm.internal.impl.metadata.a.h hVar) {
        String a;
        h.e(constructor, "proto");
        h.e(cVar, "nameResolver");
        h.e(hVar, "typeTable");
        ExtendableMessage extendableMessage = constructor;
        e eVar = JvmProtoBuf.eMi;
        h.d(eVar, "JvmProtoBuf.constructorSignature");
        JvmMethodSignature jvmMethodSignature = (JvmMethodSignature) kotlin.reflect.jvm.internal.impl.metadata.a.f.a(extendableMessage, eVar);
        if (jvmMethodSignature == null || !jvmMethodSignature.bse()) {
            List blf = constructor.blf();
            h.d(blf, "proto.valueParameterList");
            Iterable<ValueParameter> iterable = blf;
            Collection arrayList = new ArrayList(n.e(iterable, 10));
            for (ValueParameter valueParameter : iterable) {
                j jVar = eMR;
                h.d(valueParameter, "it");
                String b = jVar.b(g.a(valueParameter, hVar), cVar);
                if (b == null) {
                    return null;
                }
                arrayList.add(b);
            }
            a = u.a((List) arrayList, "", "(", ")V", 0, null, null, 56, null);
        } else {
            a = cVar.getString(jvmMethodSignature.bsf());
        }
        return new b("<init>", a);
    }

    public final a a(Property property, c cVar, kotlin.reflect.jvm.internal.impl.metadata.a.h hVar) {
        h.e(property, "proto");
        h.e(cVar, "nameResolver");
        h.e(hVar, "typeTable");
        ExtendableMessage extendableMessage = property;
        e eVar = JvmProtoBuf.eMl;
        h.d(eVar, "JvmProtoBuf.propertySignature");
        JvmPropertySignature jvmPropertySignature = (JvmPropertySignature) kotlin.reflect.jvm.internal.impl.metadata.a.f.a(extendableMessage, eVar);
        if (jvmPropertySignature == null) {
            return null;
        }
        String b;
        JvmFieldSignature bsB = jvmPropertySignature.bsA() ? jvmPropertySignature.bsB() : null;
        int blW = (bsB == null || !bsB.hasName()) ? property.blW() : bsB.blW();
        if (bsB == null || !bsB.bse()) {
            b = b(g.a(property, hVar), cVar);
            if (b == null) {
                return null;
            }
        }
        b = cVar.getString(bsB.bsf());
        return new a(cVar.getString(blW), b);
    }

    private final String b(Type type, c cVar) {
        return type.bou() ? c.my(cVar.le(type.bov())) : null;
    }

    public static final boolean g(Property property) {
        h.e(property, "proto");
        kotlin.reflect.jvm.internal.impl.metadata.a.b.a btB = e.eMG.btB();
        Object e = property.e(JvmProtoBuf.eMm);
        h.d(e, "proto.getExtension(JvmProtoBuf.flags)");
        Boolean lc = btB.get(((Number) e).intValue());
        h.d(lc, "JvmFlags.IS_MOVED_FROM_I…nsion(JvmProtoBuf.flags))");
        return lc.booleanValue();
    }
}
