package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.builtins.j;
import kotlin.reflect.jvm.internal.impl.descriptors.an;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.f;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.descriptors.q;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.Argument;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.Argument.Projection;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.m;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.ad;
import kotlin.reflect.jvm.internal.impl.types.ag;
import kotlin.reflect.jvm.internal.impl.types.ah;
import kotlin.reflect.jvm.internal.impl.types.al;
import kotlin.reflect.jvm.internal.impl.types.ap;
import kotlin.reflect.jvm.internal.impl.types.ar;
import kotlin.reflect.jvm.internal.impl.types.p;
import kotlin.reflect.jvm.internal.impl.types.w;
import kotlin.reflect.jvm.internal.impl.types.x;

/* compiled from: TypeDeserializer.kt */
public final class v {
    private final String debugName;
    private final j eTh;
    private final b<Integer, d> eTq;
    private final b<Integer, f> eTr;
    private final Map<Integer, an> eTs;
    private final v eTt;
    private boolean eTu;

    public v(j jVar, v vVar, List<TypeParameter> list, String str, boolean z) {
        Map emptyMap;
        h.e(jVar, "c");
        h.e(list, "typeParameterProtos");
        h.e(str, "debugName");
        this.eTh = jVar;
        this.eTt = vVar;
        this.debugName = str;
        this.eTu = z;
        this.eTq = this.eTh.baI().p(new TypeDeserializer$classDescriptors$1(this));
        this.eTr = this.eTh.baI().p(new TypeDeserializer$typeAliasDescriptors$1(this));
        if (list.isEmpty()) {
            emptyMap = ad.emptyMap();
        } else {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int i = 0;
            for (TypeParameter typeParameter : list) {
                linkedHashMap.put(Integer.valueOf(typeParameter.getId()), new m(this.eTh, typeParameter, i));
                i++;
            }
            emptyMap = linkedHashMap;
        }
        this.eTs = emptyMap;
    }

    public /* synthetic */ v(j jVar, v vVar, List list, String str, boolean z, int i, f fVar) {
        this(jVar, vVar, list, str, (i & 16) != 0 ? false : z);
    }

    public final boolean bxR() {
        return this.eTu;
    }

    public final List<an> bxQ() {
        return u.W(this.eTs.values());
    }

    public static /* synthetic */ w a(v vVar, Type type, g gVar, int i, Object obj) {
        if ((i & 2) != 0) {
            gVar = g.eBF.bel();
        }
        return vVar.a(type, gVar);
    }

    public final w a(Type type, g gVar) {
        h.e(type, "proto");
        h.e(gVar, "additionalAnnotations");
        if (!type.boo()) {
            return b(type, gVar);
        }
        String string = this.eTh.aYI().getString(type.bop());
        ad b = b(type, gVar);
        Type a = kotlin.reflect.jvm.internal.impl.metadata.a.g.a(type, this.eTh.aYJ());
        if (a == null) {
            h.aXZ();
        }
        return this.eTh.biq().bxz().a(type, string, b, b(a, gVar));
    }

    public static /* synthetic */ ad b(v vVar, Type type, g gVar, int i, Object obj) {
        if ((i & 2) != 0) {
            gVar = g.eBF.bel();
        }
        return vVar.b(type, gVar);
    }

    public final ad b(Type type, g gVar) {
        h.e(type, "proto");
        h.e(gVar, "additionalAnnotations");
        ad lX = type.bou() ? lX(type.bov()) : type.boA() ? lX(type.boB()) : null;
        if (lX != null) {
            return lX;
        }
        kotlin.reflect.jvm.internal.impl.types.an r = r(type);
        if (p.W(r.bbW())) {
            ad a = p.a(r.toString(), r);
            h.d(a, "ErrorUtils.createErrorTy….toString(), constructor)");
            return a;
        }
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.b bVar = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.b(this.eTh.baI(), new TypeDeserializer$simpleType$annotations$1(this, type, gVar));
        Iterable<Argument> s = new TypeDeserializer$simpleType$1(this).invoke(type);
        Collection arrayList = new ArrayList(n.e(s, 10));
        int i = 0;
        for (Argument argument : s) {
            int i2 = i + 1;
            List parameters = r.getParameters();
            h.d(parameters, "constructor.parameters");
            arrayList.add(a((an) u.h(parameters, i), argument));
            i = i2;
        }
        List W = u.W((List) arrayList);
        Boolean lc = kotlin.reflect.jvm.internal.impl.metadata.a.b.eLg.get(type.getFlags());
        h.d(lc, "Flags.SUSPEND_TYPE.get(proto.flags)");
        if (lc.booleanValue()) {
            lX = a(bVar, r, W, type.bon());
        } else {
            lX = x.c(bVar, r, W, type.bon());
        }
        type = kotlin.reflect.jvm.internal.impl.metadata.a.g.c(type, this.eTh.aYJ());
        return type != null ? ag.b(lX, b(type, gVar)) : lX;
    }

    private final kotlin.reflect.jvm.internal.impl.types.an r(Type type) {
        TypeDeserializer$typeConstructor$1 typeDeserializer$typeConstructor$1 = new TypeDeserializer$typeConstructor$1(this, type);
        kotlin.reflect.jvm.internal.impl.types.an bby;
        if (type.bou()) {
            d dVar = (d) this.eTq.invoke(Integer.valueOf(type.bov()));
            if (dVar == null) {
                dVar = typeDeserializer$typeConstructor$1.lZ(type.bov());
            }
            bby = dVar.bby();
            h.d(bby, "(classDescriptors(proto.…assName)).typeConstructor");
            return bby;
        } else if (type.bow()) {
            kotlin.reflect.jvm.internal.impl.types.an lV = lV(type.box());
            if (lV != null) {
                return lV;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unknown type parameter ");
            stringBuilder.append(type.box());
            bby = p.mW(stringBuilder.toString());
            h.d(bby, "ErrorUtils.createErrorTy… ${proto.typeParameter}\")");
            return bby;
        } else if (type.boy()) {
            k bbv = this.eTh.bbv();
            String string = this.eTh.aYI().getString(type.boz());
            for (Object next : bxQ()) {
                if (h.E(((an) next).bdc().asString(), string)) {
                    break;
                }
            }
            Object next2 = null;
            an anVar = (an) next2;
            if (anVar != null) {
                kotlin.reflect.jvm.internal.impl.types.an bby2 = anVar.bby();
                if (bby2 != null) {
                    return bby2;
                }
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Deserialized type parameter ");
            stringBuilder2.append(string);
            stringBuilder2.append(" in ");
            stringBuilder2.append(bbv);
            bby = p.mW(stringBuilder2.toString());
            h.d(bby, "ErrorUtils.createErrorTy…ter $name in $container\")");
            return bby;
        } else if (type.boA()) {
            f fVar = (f) this.eTr.invoke(Integer.valueOf(type.boB()));
            if (fVar == null) {
                fVar = typeDeserializer$typeConstructor$1.lZ(type.boB());
            }
            bby = fVar.bby();
            h.d(bby, "(typeAliasDescriptors(pr…iasName)).typeConstructor");
            return bby;
        } else {
            bby = p.mW("Unknown type");
            h.d(bby, "ErrorUtils.createErrorTy…nstructor(\"Unknown type\")");
            return bby;
        }
    }

    private final ad a(g gVar, kotlin.reflect.jvm.internal.impl.types.an anVar, List<? extends ap> list, boolean z) {
        ad adVar = null;
        switch (anVar.getParameters().size() - list.size()) {
            case 0:
                adVar = b(gVar, anVar, list, z);
                break;
            case 1:
                int size = list.size() - 1;
                if (size >= 0) {
                    d js = anVar.bdy().js(size);
                    h.d(js, "functionTypeConstructor.…getSuspendFunction(arity)");
                    kotlin.reflect.jvm.internal.impl.types.an bby = js.bby();
                    h.d(bby, "functionTypeConstructor.…on(arity).typeConstructor");
                    adVar = x.c(gVar, bby, list, z);
                    break;
                }
                break;
        }
        if (adVar != null) {
            return adVar;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Bad suspend function in metadata with constructor: ");
        stringBuilder.append(anVar);
        adVar = p.f(stringBuilder.toString(), list);
        h.d(adVar, "ErrorUtils.createErrorTy…      arguments\n        )");
        return adVar;
    }

    private final ad b(g gVar, kotlin.reflect.jvm.internal.impl.types.an anVar, List<? extends ap> list, boolean z) {
        w c = x.c(gVar, anVar, list, z);
        if (kotlin.reflect.jvm.internal.impl.builtins.f.c(c)) {
            return av(c);
        }
        return null;
    }

    private final ad av(w wVar) {
        boolean bxH = this.eTh.biq().bxv().bxH();
        ap apVar = (ap) u.bX(kotlin.reflect.jvm.internal.impl.builtins.f.j(wVar));
        Object obj = null;
        if (apVar != null) {
            w bai = apVar.bai();
            if (bai != null) {
                f bbW = bai.bwA().bbW();
                kotlin.reflect.jvm.internal.impl.name.b x = bbW != null ? a.x(bbW) : null;
                boolean z = true;
                if (bai.bdF().size() != 1 || (!j.a(x, true) && !j.a(x, false))) {
                    return (ad) wVar;
                }
                bai = ((ap) u.bY(bai.bdF())).bai();
                k bbv = this.eTh.bbv();
                if (!(bbv instanceof kotlin.reflect.jvm.internal.impl.descriptors.a)) {
                    bbv = null;
                }
                kotlin.reflect.jvm.internal.impl.descriptors.a aVar = (kotlin.reflect.jvm.internal.impl.descriptors.a) bbv;
                if (aVar != null) {
                    obj = a.h(aVar);
                }
                if (h.E(obj, u.eTp)) {
                    h.d(bai, "suspendReturnType");
                    return a(wVar, bai);
                }
                if (!(this.eTu || (bxH && j.a(x, bxH ^ true)))) {
                    z = false;
                }
                this.eTu = z;
                h.d(bai, "suspendReturnType");
                return a(wVar, bai);
            }
        }
        return null;
    }

    private final ad a(w wVar, w wVar2) {
        kotlin.reflect.jvm.internal.impl.builtins.g bj = kotlin.reflect.jvm.internal.impl.types.b.a.bj(wVar);
        g bbQ = wVar.bbQ();
        w h = kotlin.reflect.jvm.internal.impl.builtins.f.h(wVar);
        Iterable<ap> i = u.i(kotlin.reflect.jvm.internal.impl.builtins.f.j(wVar), 1);
        Collection arrayList = new ArrayList(n.e(i, 10));
        for (ap bai : i) {
            arrayList.add(bai.bai());
        }
        return kotlin.reflect.jvm.internal.impl.builtins.f.a(bj, bbQ, h, (List) arrayList, null, wVar2, true).gQ(wVar.aYp());
    }

    private final kotlin.reflect.jvm.internal.impl.types.an lV(int i) {
        an anVar = (an) this.eTs.get(Integer.valueOf(i));
        if (anVar != null) {
            kotlin.reflect.jvm.internal.impl.types.an bby = anVar.bby();
            if (bby != null) {
                return bby;
            }
        }
        v vVar = this.eTt;
        return vVar != null ? vVar.lV(i) : null;
    }

    private final d lW(int i) {
        kotlin.reflect.jvm.internal.impl.name.a a = q.a(this.eTh.aYI(), i);
        if (a.isLocal()) {
            return this.eTh.biq().l(a);
        }
        return q.a(this.eTh.biq().bxu(), a);
    }

    private final ad lX(int i) {
        return q.a(this.eTh.aYI(), i).isLocal() ? this.eTh.biq().bxy().bxM() : null;
    }

    private final f lY(int i) {
        kotlin.reflect.jvm.internal.impl.name.a a = q.a(this.eTh.aYI(), i);
        if (a.isLocal()) {
            return null;
        }
        return q.b(this.eTh.biq().bxu(), a);
    }

    private final ap a(an anVar, Argument argument) {
        if (argument.boQ() == Projection.STAR) {
            ap alVar;
            if (anVar == null) {
                ad baV = this.eTh.biq().bxu().bdy().baV();
                h.d(baV, "c.components.moduleDescr….builtIns.nullableAnyType");
                alVar = new al(baV);
            } else {
                alVar = new ah(anVar);
            }
            return alVar;
        }
        s sVar = s.eTk;
        Projection boQ = argument.boQ();
        h.d(boQ, "typeArgumentProto.projection");
        Variance b = sVar.b(boQ);
        Type a = kotlin.reflect.jvm.internal.impl.metadata.a.g.a(argument, this.eTh.aYJ());
        if (a != null) {
            return new ar(b, a(this, a, null, 2, null));
        }
        return new ar(p.mU("No type recorded"));
    }

    public String toString() {
        String str;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.debugName);
        if (this.eTt == null) {
            str = "";
        } else {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(". Child of ");
            stringBuilder2.append(this.eTt.debugName);
            str = stringBuilder2.toString();
        }
        stringBuilder.append(str);
        return stringBuilder.toString();
    }
}
