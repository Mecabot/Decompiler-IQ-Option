package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.builtins.g;
import kotlin.reflect.jvm.internal.impl.descriptors.ai;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.c;
import kotlin.reflect.jvm.internal.impl.descriptors.aq;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.descriptors.q;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.descriptors.w;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value.Type;
import kotlin.reflect.jvm.internal.impl.name.a;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.resolve.constants.o;
import kotlin.reflect.jvm.internal.impl.types.ad;
import kotlin.reflect.jvm.internal.impl.types.ar;
import kotlin.reflect.jvm.internal.impl.types.p;
import kotlin.reflect.jvm.internal.impl.types.x;

/* compiled from: AnnotationDeserializer.kt */
public final class b {
    private final u ezG;
    private final w ezw;

    public b(u uVar, w wVar) {
        h.e(uVar, "module");
        h.e(wVar, "notFoundClasses");
        this.ezG = uVar;
        this.ezw = wVar;
    }

    private final g bdy() {
        return this.ezG.bdy();
    }

    public final c c(Annotation annotation, kotlin.reflect.jvm.internal.impl.metadata.a.c cVar) {
        h.e(annotation, "proto");
        h.e(cVar, "nameResolver");
        d h = h(q.a(cVar, annotation.getId()));
        Map emptyMap = ad.emptyMap();
        if (annotation.biZ() != 0) {
            k kVar = h;
            if (!p.W(kVar) && kotlin.reflect.jvm.internal.impl.resolve.c.I(kVar)) {
                Collection bbE = h.bbE();
                h.d(bbE, "annotationClass.constructors");
                kotlin.reflect.jvm.internal.impl.descriptors.c cVar2 = (kotlin.reflect.jvm.internal.impl.descriptors.c) u.R(bbE);
                if (cVar2 != null) {
                    List bcS = cVar2.bcS();
                    h.d(bcS, "constructor.valueParameters");
                    Iterable iterable = bcS;
                    Map linkedHashMap = new LinkedHashMap(j.be(ad.jn(n.e(iterable, 10)), 16));
                    for (Object next : iterable) {
                        aq aqVar = (aq) next;
                        h.d(aqVar, "it");
                        linkedHashMap.put(aqVar.bdc(), next);
                    }
                    List<Argument> biY = annotation.biY();
                    h.d(biY, "proto.argumentList");
                    Collection arrayList = new ArrayList();
                    for (Argument argument : biY) {
                        h.d(argument, "it");
                        Pair a = a(argument, linkedHashMap, cVar);
                        if (a != null) {
                            arrayList.add(a);
                        }
                    }
                    emptyMap = ad.ae((List) arrayList);
                }
            }
        }
        return new kotlin.reflect.jvm.internal.impl.descriptors.annotations.d(h.bdb(), emptyMap, ai.eAX);
    }

    private final Pair<f, kotlin.reflect.jvm.internal.impl.resolve.constants.f<?>> a(Argument argument, Map<f, ? extends aq> map, kotlin.reflect.jvm.internal.impl.metadata.a.c cVar) {
        aq aqVar = (aq) map.get(q.b(cVar, argument.getNameId()));
        if (aqVar == null) {
            return null;
        }
        f b = q.b(cVar, argument.getNameId());
        kotlin.reflect.jvm.internal.impl.types.w bai = aqVar.bai();
        h.d(bai, "parameter.type");
        Value bjl = argument.bjl();
        h.d(bjl, "proto.value");
        return new Pair(b, a(bai, bjl, cVar));
    }

    /* JADX WARNING: Missing block: B:59:0x0201, code:
            if (kotlin.reflect.jvm.internal.impl.types.b.a.c(r8.h(r6.ezG), r7) == false) goto L_0x0204;
     */
    /* JADX WARNING: Missing block: B:64:?, code:
            return kotlin.reflect.jvm.internal.impl.resolve.constants.j.eRq.mQ("Unexpected argument value");
     */
    /* JADX WARNING: Missing block: B:65:?, code:
            return r8;
     */
    public final kotlin.reflect.jvm.internal.impl.resolve.constants.f<?> a(kotlin.reflect.jvm.internal.impl.types.w r7, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value r8, kotlin.reflect.jvm.internal.impl.metadata.a.c r9) {
        /*
        r6 = this;
        r0 = "expectedType";
        kotlin.jvm.internal.h.e(r7, r0);
        r0 = "value";
        kotlin.jvm.internal.h.e(r8, r0);
        r0 = "nameResolver";
        kotlin.jvm.internal.h.e(r9, r0);
        r0 = kotlin.reflect.jvm.internal.impl.metadata.a.b.eLQ;
        r1 = r8.getFlags();
        r0 = r0.get(r1);
        r1 = r8.bjB();
        if (r1 != 0) goto L_0x0021;
    L_0x001f:
        goto L_0x0210;
    L_0x0021:
        r2 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.c.aoS;
        r1 = r1.ordinal();
        r1 = r2[r1];
        r2 = 0;
        r3 = 1;
        switch(r1) {
            case 1: goto L_0x01d8;
            case 2: goto L_0x01c9;
            case 3: goto L_0x01a9;
            case 4: goto L_0x018a;
            case 5: goto L_0x016c;
            case 6: goto L_0x015e;
            case 7: goto L_0x0150;
            case 8: goto L_0x013b;
            case 9: goto L_0x0129;
            case 10: goto L_0x011b;
            case 11: goto L_0x0101;
            case 12: goto L_0x00ea;
            case 13: goto L_0x0030;
            default: goto L_0x002e;
        };
    L_0x002e:
        goto L_0x0210;
    L_0x0030:
        r0 = kotlin.reflect.jvm.internal.impl.builtins.g.n(r7);
        if (r0 != 0) goto L_0x003c;
    L_0x0036:
        r0 = kotlin.reflect.jvm.internal.impl.builtins.g.o(r7);
        if (r0 == 0) goto L_0x003d;
    L_0x003c:
        r2 = 1;
    L_0x003d:
        r8 = r8.bjP();
        r0 = "arrayElements";
        kotlin.jvm.internal.h.d(r8, r0);
        r0 = r8;
        r0 = (java.util.Collection) r0;
        r0 = r0.isEmpty();
        r0 = r0 ^ r3;
        if (r0 == 0) goto L_0x0081;
    L_0x0050:
        r0 = kotlin.collections.u.bU(r8);
        r1 = "arrayElements.first()";
        kotlin.jvm.internal.h.d(r0, r1);
        r0 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value) r0;
        r0 = r6.a(r0, r9);
        r1 = r6.bdy();
        r0 = (kotlin.reflect.jvm.internal.impl.types.w) r0;
        r1 = r1.m(r0);
        if (r1 == 0) goto L_0x006f;
    L_0x006b:
        r0 = r1;
        r0 = (kotlin.reflect.jvm.internal.impl.types.w) r0;
        goto L_0x00a0;
    L_0x006f:
        r1 = r6.bdy();
        r3 = kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT;
        r0 = r1.a(r3, r0);
        r1 = "builtIns.getArrayType(Va…RIANT, actualElementType)";
        kotlin.jvm.internal.h.d(r0, r1);
        r0 = (kotlin.reflect.jvm.internal.impl.types.w) r0;
        goto L_0x00a0;
    L_0x0081:
        if (r2 == 0) goto L_0x0085;
    L_0x0083:
        r0 = r7;
        goto L_0x00a0;
    L_0x0085:
        r0 = r6.bdy();
        r1 = kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT;
        r3 = r6.bdy();
        r3 = r3.baU();
        r3 = (kotlin.reflect.jvm.internal.impl.types.w) r3;
        r0 = r0.a(r1, r3);
        r1 = "builtIns.getArrayType(Va…ARIANT, builtIns.anyType)";
        kotlin.jvm.internal.h.d(r0, r1);
        r0 = (kotlin.reflect.jvm.internal.impl.types.w) r0;
    L_0x00a0:
        r1 = r6.bdy();
        if (r2 == 0) goto L_0x00a8;
    L_0x00a6:
        r2 = r7;
        goto L_0x00a9;
    L_0x00a8:
        r2 = r0;
    L_0x00a9:
        r1 = r1.l(r2);
        r2 = kotlin.reflect.jvm.internal.impl.resolve.constants.g.eRn;
        r8 = (java.lang.Iterable) r8;
        r3 = new java.util.ArrayList;
        r4 = 10;
        r4 = kotlin.collections.n.e(r8, r4);
        r3.<init>(r4);
        r3 = (java.util.Collection) r3;
        r8 = r8.iterator();
    L_0x00c2:
        r4 = r8.hasNext();
        if (r4 == 0) goto L_0x00e0;
    L_0x00c8:
        r4 = r8.next();
        r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value) r4;
        r5 = "expectedElementType";
        kotlin.jvm.internal.h.d(r1, r5);
        r5 = "it";
        kotlin.jvm.internal.h.d(r4, r5);
        r4 = r6.a(r1, r4, r9);
        r3.add(r4);
        goto L_0x00c2;
    L_0x00e0:
        r3 = (java.util.List) r3;
        r8 = r2.a(r3, r0);
        r8 = (kotlin.reflect.jvm.internal.impl.resolve.constants.f) r8;
        goto L_0x01f7;
    L_0x00ea:
        r0 = new kotlin.reflect.jvm.internal.impl.resolve.constants.a;
        r8 = r8.bjO();
        r1 = "value.annotation";
        kotlin.jvm.internal.h.d(r8, r1);
        r8 = r6.c(r8, r9);
        r0.<init>(r8);
        r8 = r0;
        r8 = (kotlin.reflect.jvm.internal.impl.resolve.constants.f) r8;
        goto L_0x01f7;
    L_0x0101:
        r0 = new kotlin.reflect.jvm.internal.impl.resolve.constants.i;
        r1 = r8.bjK();
        r1 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.q.a(r9, r1);
        r8 = r8.bjM();
        r8 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.q.b(r9, r8);
        r0.<init>(r1, r8);
        r8 = r0;
        r8 = (kotlin.reflect.jvm.internal.impl.resolve.constants.f) r8;
        goto L_0x01f7;
    L_0x011b:
        r8 = r8.bjK();
        r8 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.q.a(r9, r8);
        r8 = r6.k(r8);
        goto L_0x01f7;
    L_0x0129:
        r0 = new kotlin.reflect.jvm.internal.impl.resolve.constants.s;
        r8 = r8.bjI();
        r8 = r9.getString(r8);
        r0.<init>(r8);
        r8 = r0;
        r8 = (kotlin.reflect.jvm.internal.impl.resolve.constants.f) r8;
        goto L_0x01f7;
    L_0x013b:
        r9 = new kotlin.reflect.jvm.internal.impl.resolve.constants.c;
        r0 = r8.bjD();
        r4 = 0;
        r8 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r8 == 0) goto L_0x0148;
    L_0x0147:
        r2 = 1;
    L_0x0148:
        r9.<init>(r2);
        r8 = r9;
        r8 = (kotlin.reflect.jvm.internal.impl.resolve.constants.f) r8;
        goto L_0x01f7;
    L_0x0150:
        r9 = new kotlin.reflect.jvm.internal.impl.resolve.constants.h;
        r0 = r8.Mu();
        r9.<init>(r0);
        r8 = r9;
        r8 = (kotlin.reflect.jvm.internal.impl.resolve.constants.f) r8;
        goto L_0x01f7;
    L_0x015e:
        r9 = new kotlin.reflect.jvm.internal.impl.resolve.constants.k;
        r8 = r8.bjF();
        r9.<init>(r8);
        r8 = r9;
        r8 = (kotlin.reflect.jvm.internal.impl.resolve.constants.f) r8;
        goto L_0x01f7;
    L_0x016c:
        r8 = r8.bjD();
        r1 = "isUnsigned";
        kotlin.jvm.internal.h.d(r0, r1);
        r0 = r0.booleanValue();
        if (r0 == 0) goto L_0x0181;
    L_0x017b:
        r0 = new kotlin.reflect.jvm.internal.impl.resolve.constants.v;
        r0.<init>(r8);
        goto L_0x0186;
    L_0x0181:
        r0 = new kotlin.reflect.jvm.internal.impl.resolve.constants.p;
        r0.<init>(r8);
    L_0x0186:
        r8 = r0;
        r8 = (kotlin.reflect.jvm.internal.impl.resolve.constants.f) r8;
        goto L_0x01f7;
    L_0x018a:
        r8 = r8.bjD();
        r8 = (int) r8;
        r9 = "isUnsigned";
        kotlin.jvm.internal.h.d(r0, r9);
        r9 = r0.booleanValue();
        if (r9 == 0) goto L_0x01a0;
    L_0x019a:
        r9 = new kotlin.reflect.jvm.internal.impl.resolve.constants.u;
        r9.<init>(r8);
        goto L_0x01a5;
    L_0x01a0:
        r9 = new kotlin.reflect.jvm.internal.impl.resolve.constants.l;
        r9.<init>(r8);
    L_0x01a5:
        r8 = r9;
        r8 = (kotlin.reflect.jvm.internal.impl.resolve.constants.f) r8;
        goto L_0x01f7;
    L_0x01a9:
        r8 = r8.bjD();
        r8 = (int) r8;
        r8 = (short) r8;
        r9 = "isUnsigned";
        kotlin.jvm.internal.h.d(r0, r9);
        r9 = r0.booleanValue();
        if (r9 == 0) goto L_0x01c0;
    L_0x01ba:
        r9 = new kotlin.reflect.jvm.internal.impl.resolve.constants.w;
        r9.<init>(r8);
        goto L_0x01c5;
    L_0x01c0:
        r9 = new kotlin.reflect.jvm.internal.impl.resolve.constants.r;
        r9.<init>(r8);
    L_0x01c5:
        r8 = r9;
        r8 = (kotlin.reflect.jvm.internal.impl.resolve.constants.f) r8;
        goto L_0x01f7;
    L_0x01c9:
        r9 = new kotlin.reflect.jvm.internal.impl.resolve.constants.e;
        r0 = r8.bjD();
        r8 = (int) r0;
        r8 = (char) r8;
        r9.<init>(r8);
        r8 = r9;
        r8 = (kotlin.reflect.jvm.internal.impl.resolve.constants.f) r8;
        goto L_0x01f7;
    L_0x01d8:
        r8 = r8.bjD();
        r8 = (int) r8;
        r8 = (byte) r8;
        r9 = "isUnsigned";
        kotlin.jvm.internal.h.d(r0, r9);
        r9 = r0.booleanValue();
        if (r9 == 0) goto L_0x01ef;
    L_0x01e9:
        r9 = new kotlin.reflect.jvm.internal.impl.resolve.constants.t;
        r9.<init>(r8);
        goto L_0x01f4;
    L_0x01ef:
        r9 = new kotlin.reflect.jvm.internal.impl.resolve.constants.d;
        r9.<init>(r8);
    L_0x01f4:
        r8 = r9;
        r8 = (kotlin.reflect.jvm.internal.impl.resolve.constants.f) r8;
    L_0x01f7:
        r9 = r6.ezG;
        r9 = r8.h(r9);
        r7 = kotlin.reflect.jvm.internal.impl.types.b.a.c(r9, r7);
        if (r7 == 0) goto L_0x0204;
    L_0x0203:
        goto L_0x020f;
    L_0x0204:
        r7 = kotlin.reflect.jvm.internal.impl.resolve.constants.j.eRq;
        r8 = "Unexpected argument value";
        r7 = r7.mQ(r8);
        r8 = r7;
        r8 = (kotlin.reflect.jvm.internal.impl.resolve.constants.f) r8;
    L_0x020f:
        return r8;
    L_0x0210:
        r9 = new java.lang.StringBuilder;
        r9.<init>();
        r0 = "Unsupported annotation argument type: ";
        r9.append(r0);
        r8 = r8.bjB();
        r9.append(r8);
        r8 = " (expected ";
        r9.append(r8);
        r9.append(r7);
        r7 = 41;
        r9.append(r7);
        r7 = r9.toString();
        r8 = new java.lang.IllegalStateException;
        r7 = r7.toString();
        r8.<init>(r7);
        r8 = (java.lang.Throwable) r8;
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.b.a(kotlin.reflect.jvm.internal.impl.types.w, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation$Argument$Value, kotlin.reflect.jvm.internal.impl.metadata.a.c):kotlin.reflect.jvm.internal.impl.resolve.constants.f<?>");
    }

    private final kotlin.reflect.jvm.internal.impl.resolve.constants.f<?> k(a aVar) {
        ad bdb = h(aVar).bdb();
        h.d(bdb, "resolveClass(classId).defaultType");
        kotlin.reflect.jvm.internal.impl.types.w bl = kotlin.reflect.jvm.internal.impl.types.b.a.bl(bdb);
        a t = a.t(g.exC.eyK.btP());
        h.d(t, "ClassId.topLevel(KotlinB…FQ_NAMES.kClass.toSafe())");
        return new o(x.a(kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.eBF.bel(), h(t), l.cr(new ar(bl))));
    }

    private final ad a(Value value, kotlin.reflect.jvm.internal.impl.metadata.a.c cVar) {
        g bdy = bdy();
        Type bjB = value.bjB();
        if (bjB != null) {
            ad baX;
            switch (c.auk[bjB.ordinal()]) {
                case 1:
                    baX = bdy.baX();
                    h.d(baX, "byteType");
                    return baX;
                case 2:
                    baX = bdy.bbd();
                    h.d(baX, "charType");
                    return baX;
                case 3:
                    baX = bdy.baY();
                    h.d(baX, "shortType");
                    return baX;
                case 4:
                    baX = bdy.baZ();
                    h.d(baX, "intType");
                    return baX;
                case 5:
                    baX = bdy.bba();
                    h.d(baX, "longType");
                    return baX;
                case 6:
                    baX = bdy.bbb();
                    h.d(baX, "floatType");
                    return baX;
                case 7:
                    baX = bdy.bbc();
                    h.d(baX, "doubleType");
                    return baX;
                case 8:
                    baX = bdy.bbe();
                    h.d(baX, "booleanType");
                    return baX;
                case 9:
                    baX = bdy.bbg();
                    h.d(baX, "stringType");
                    return baX;
                case 10:
                    throw new IllegalStateException("Arrays of class literals are not supported yet".toString());
                case 11:
                    baX = h(q.a(cVar, value.bjK())).bdb();
                    h.d(baX, "resolveClass(nameResolve…lue.classId)).defaultType");
                    return baX;
                case 12:
                    Annotation bjO = value.bjO();
                    h.d(bjO, "value.annotation");
                    baX = h(q.a(cVar, bjO.getId())).bdb();
                    h.d(baX, "resolveClass(nameResolve…notation.id)).defaultType");
                    return baX;
                case 13:
                    throw new IllegalStateException("Array of arrays is impossible".toString());
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown type: ");
        stringBuilder.append(value.bjB());
        throw new IllegalStateException(stringBuilder.toString().toString());
    }

    private final d h(a aVar) {
        return q.a(this.ezG, aVar, this.ezw);
    }
}
