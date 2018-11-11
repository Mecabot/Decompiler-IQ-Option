package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.a.q;
import kotlin.jvm.internal.h;
import kotlin.l;
import kotlin.m;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.f;
import kotlin.reflect.jvm.internal.impl.builtins.g;
import kotlin.reflect.jvm.internal.impl.builtins.j;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import kotlin.reflect.jvm.internal.impl.name.b;
import kotlin.reflect.jvm.internal.impl.resolve.c;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.an;
import kotlin.reflect.jvm.internal.impl.types.ap;
import kotlin.reflect.jvm.internal.impl.types.au;
import kotlin.reflect.jvm.internal.impl.types.b.a;
import kotlin.reflect.jvm.internal.impl.types.p;
import kotlin.reflect.jvm.internal.impl.types.v;
import kotlin.reflect.jvm.internal.impl.types.w;
import kotlin.reflect.jvm.internal.impl.utils.d;

/* compiled from: typeSignatureMapping.kt */
public final class z {
    private static final <T> T a(k<T> kVar, T t, boolean z) {
        return z ? kVar.cT(t) : t;
    }

    public static /* synthetic */ Object a(w wVar, k kVar, x xVar, v vVar, h hVar, q qVar, boolean z, int i, Object obj) {
        if ((i & 32) != 0) {
            qVar = d.bzA();
        }
        return a(wVar, kVar, xVar, vVar, hVar, qVar, z);
    }

    public static final <T> T a(w wVar, k<T> kVar, x xVar, v<? extends T> vVar, h<T> hVar, q<? super w, ? super T, ? super x, l> qVar, boolean z) {
        h.e(wVar, "kotlinType");
        h.e(kVar, "factory");
        h.e(xVar, "mode");
        h.e(vVar, "typeMappingConfiguration");
        h.e(qVar, "writeGenericType");
        if (f.d(wVar)) {
            return a(j.a(wVar, vVar.biE()), kVar, xVar, vVar, hVar, qVar, z);
        }
        Object a = a(wVar, (k) kVar, xVar);
        T a2;
        if (a != null) {
            a2 = a((k) kVar, a, xVar.biG());
            qVar.c(wVar, a2, xVar);
            return a2;
        }
        an bwA = wVar.bwA();
        if (bwA instanceof v) {
            Collection beu = ((v) bwA).beu();
            h.d(beu, "constructor.supertypes");
            return a(a.bl(vVar.R(beu)), kVar, xVar, vVar, hVar, qVar, z);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.f bbW = bwA.bbW();
        StringBuilder stringBuilder;
        if (bbW == null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("no descriptor for type constructor of ");
            stringBuilder.append(wVar);
            throw new UnsupportedOperationException(stringBuilder.toString());
        } else if (p.W(bbW)) {
            a2 = kVar.mr("error/NonExistentClass");
            if (bbW == null) {
                throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            }
            vVar.a(wVar, (kotlin.reflect.jvm.internal.impl.descriptors.d) bbW);
            if (hVar != null) {
                hVar.cR(a2);
            }
            return a2;
        } else {
            boolean z2 = bbW instanceof kotlin.reflect.jvm.internal.impl.descriptors.d;
            if (z2 && g.n(wVar)) {
                if (wVar.bdF().size() != 1) {
                    throw new UnsupportedOperationException("arrays must have one type argument");
                }
                Object mr;
                ap apVar = (ap) wVar.bdF().get(0);
                w bai = apVar.bai();
                if (apVar.bzf() == Variance.IN_VARIANCE) {
                    mr = kVar.mr("java/lang/Object");
                    if (hVar != null) {
                        hVar.bis();
                        hVar.cR(mr);
                        hVar.bit();
                    }
                } else {
                    if (hVar != null) {
                        hVar.bis();
                    }
                    h.d(bai, "memberType");
                    Variance bzf = apVar.bzf();
                    h.d(bzf, "memberProjection.projectionKind");
                    mr = a(bai, kVar, xVar.a(bzf), vVar, hVar, qVar, z);
                    if (hVar != null) {
                        hVar.bit();
                    }
                }
                stringBuilder = new StringBuilder();
                stringBuilder.append("[");
                stringBuilder.append(kVar.toString(mr));
                return kVar.mq(stringBuilder.toString());
            } else if (z2) {
                kotlin.reflect.jvm.internal.impl.descriptors.d dVar = (kotlin.reflect.jvm.internal.impl.descriptors.d) bbW;
                if (dVar.bbN() && !xVar.biH()) {
                    w ah = ah(wVar);
                    if (ah != null) {
                        if (!kotlin.reflect.jvm.internal.impl.resolve.d.ar(ah)) {
                            xVar = xVar.biF();
                        }
                        return a(ah, kVar, xVar, vVar, hVar, qVar, z);
                    }
                }
                if (xVar.bhe() && g.g(dVar)) {
                    a2 = kVar.biA();
                } else {
                    kotlin.reflect.jvm.internal.impl.descriptors.d bdi = dVar.bdi();
                    h.d(bdi, "descriptor.original");
                    T D = vVar.D(bdi);
                    if (D != null) {
                        a2 = D;
                    } else {
                        if (dVar.bbF() == ClassKind.ENUM_ENTRY) {
                            k bbv = dVar.bbv();
                            if (bbv == null) {
                                throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                            }
                            dVar = (kotlin.reflect.jvm.internal.impl.descriptors.d) bbv;
                        }
                        bdi = dVar.bdi();
                        h.d(bdi, "enumClassIfEnumEntry.original");
                        a2 = kVar.mr(a(bdi, (v) vVar, z));
                    }
                }
                qVar.c(wVar, a2, xVar);
                return a2;
            } else if (bbW instanceof kotlin.reflect.jvm.internal.impl.descriptors.an) {
                T a3 = a(c((kotlin.reflect.jvm.internal.impl.descriptors.an) bbW), kVar, xVar, vVar, null, d.bzA(), z);
                if (hVar != null) {
                    kotlin.reflect.jvm.internal.impl.name.f bdc = bbW.bdc();
                    h.d(bdc, "descriptor.getName()");
                    hVar.c(bdc, a3);
                }
                return a3;
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown type ");
                stringBuilder.append(wVar);
                throw new UnsupportedOperationException(stringBuilder.toString());
            }
        }
    }

    /* JADX WARNING: Missing block: B:14:0x002b, code:
            if ((r2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ae) == false) goto L_0x002f;
     */
    public static final boolean d(kotlin.reflect.jvm.internal.impl.descriptors.a r2) {
        /*
        r0 = "descriptor";
        kotlin.jvm.internal.h.e(r2, r0);
        r0 = r2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.j;
        r1 = 1;
        if (r0 == 0) goto L_0x000b;
    L_0x000a:
        return r1;
    L_0x000b:
        r0 = r2.bcQ();
        if (r0 != 0) goto L_0x0014;
    L_0x0011:
        kotlin.jvm.internal.h.aXZ();
    L_0x0014:
        r0 = kotlin.reflect.jvm.internal.impl.builtins.g.G(r0);
        if (r0 == 0) goto L_0x002e;
    L_0x001a:
        r0 = r2.bcQ();
        if (r0 != 0) goto L_0x0023;
    L_0x0020:
        kotlin.jvm.internal.h.aXZ();
    L_0x0023:
        r0 = kotlin.reflect.jvm.internal.impl.types.au.aW(r0);
        if (r0 != 0) goto L_0x002e;
    L_0x0029:
        r2 = r2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ae;
        if (r2 != 0) goto L_0x002e;
    L_0x002d:
        goto L_0x002f;
    L_0x002e:
        r1 = 0;
    L_0x002f:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.kotlin.z.d(kotlin.reflect.jvm.internal.impl.descriptors.a):boolean");
    }

    private static final String gR(boolean z) {
        b bVar;
        if (z) {
            bVar = c.eQJ;
        } else {
            bVar = c.eQI;
        }
        kotlin.reflect.jvm.internal.impl.resolve.jvm.b j = kotlin.reflect.jvm.internal.impl.resolve.jvm.b.j(kotlin.reflect.jvm.internal.impl.name.a.t(bVar));
        h.d(j, "JvmClassName.byClassId(ClassId.topLevel(fqName))");
        String internalName = j.getInternalName();
        h.d(internalName, "JvmClassName.byClassId(C…vel(fqName)).internalName");
        return internalName;
    }

    private static final <T> T a(w wVar, k<T> kVar, x xVar) {
        kotlin.reflect.jvm.internal.impl.descriptors.f bbW = wVar.bwA().bbW();
        if (!(bbW instanceof kotlin.reflect.jvm.internal.impl.descriptors.d)) {
            bbW = null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.d dVar = (kotlin.reflect.jvm.internal.impl.descriptors.d) bbW;
        if (dVar == null) {
            return null;
        }
        boolean z = false;
        if (dVar == j.bbp()) {
            return kVar.mr(gR(false));
        }
        if (h.E(dVar, j.bbq())) {
            return kVar.mr(gR(true));
        }
        k kVar2 = dVar;
        PrimitiveType d = g.d(kVar2);
        if (d != null) {
            JvmPrimitiveType jvmPrimitiveType = JvmPrimitiveType.get(d);
            h.d(jvmPrimitiveType, "JvmPrimitiveType.get(primitiveType)");
            String desc = jvmPrimitiveType.getDesc();
            h.d(desc, "JvmPrimitiveType.get(primitiveType).desc");
            Object mq = kVar.mq(desc);
            if (au.aW(wVar) || kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.p.af(wVar)) {
                z = true;
            }
            return a((k) kVar, mq, z);
        }
        PrimitiveType e = g.e(kVar2);
        if (e != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            JvmPrimitiveType jvmPrimitiveType2 = JvmPrimitiveType.get(e);
            h.d(jvmPrimitiveType2, "JvmPrimitiveType.get(arrayElementType)");
            stringBuilder.append(jvmPrimitiveType2.getDesc());
            return kVar.mq(stringBuilder.toString());
        }
        if (g.c(kVar2)) {
            kotlin.reflect.jvm.internal.impl.name.a c = kotlin.reflect.jvm.internal.impl.builtins.jvm.c.eAc.c(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.z(kVar2));
            if (c != null) {
                if (!xVar.biI()) {
                    Iterable<kotlin.reflect.jvm.internal.impl.builtins.jvm.c.a> bch = kotlin.reflect.jvm.internal.impl.builtins.jvm.c.eAc.bch();
                    if (!(bch instanceof Collection) || !((Collection) bch).isEmpty()) {
                        for (kotlin.reflect.jvm.internal.impl.builtins.jvm.c.a bci : bch) {
                            if (h.E(bci.bci(), c)) {
                                z = true;
                                break;
                            }
                        }
                    }
                    if (z) {
                        return null;
                    }
                }
                kotlin.reflect.jvm.internal.impl.resolve.jvm.b j = kotlin.reflect.jvm.internal.impl.resolve.jvm.b.j(c);
                h.d(j, "JvmClassName.byClassId(classId)");
                String internalName = j.getInternalName();
                h.d(internalName, "JvmClassName.byClassId(classId).internalName");
                return kVar.mr(internalName);
            }
        }
        return null;
    }

    public static final w ah(w wVar) {
        h.e(wVar, "inlineClassType");
        if (!ai(wVar)) {
            return null;
        }
        w aq = kotlin.reflect.jvm.internal.impl.resolve.d.aq(wVar);
        if (aq != null) {
            an bwA = aq.bwA();
            if (bwA != null) {
                kotlin.reflect.jvm.internal.impl.descriptors.f bbW = bwA.bbW();
                if (bbW != null) {
                    if (bbW instanceof kotlin.reflect.jvm.internal.impl.descriptors.an) {
                        wVar = c((kotlin.reflect.jvm.internal.impl.descriptors.an) bbW);
                    } else {
                        wVar = kotlin.reflect.jvm.internal.impl.resolve.d.as(wVar);
                    }
                    return wVar;
                }
            }
        }
        return null;
    }

    public static final boolean ai(w wVar) {
        h.e(wVar, "inlineClassType");
        w aq = kotlin.reflect.jvm.internal.impl.resolve.d.aq(wVar);
        boolean z = false;
        if (aq == null) {
            return false;
        }
        if (!(wVar.aYp() && (au.aW(aq) || g.p(aq)))) {
            z = true;
        }
        return z;
    }

    public static /* bridge */ /* synthetic */ String a(kotlin.reflect.jvm.internal.impl.descriptors.d dVar, v vVar, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            vVar = w.eJZ;
        }
        return a(dVar, vVar, z);
    }

    public static final String a(kotlin.reflect.jvm.internal.impl.descriptors.d dVar, v<?> vVar, boolean z) {
        h.e(dVar, "klass");
        h.e(vVar, "typeMappingConfiguration");
        Object q = z ? q(dVar.bbv()) : dVar.bbv();
        kotlin.reflect.jvm.internal.impl.name.f I = kotlin.reflect.jvm.internal.impl.name.h.I(dVar.bdc());
        h.d(I, "SpecialNames.safeIdentifier(klass.name)");
        String identifier = I.getIdentifier();
        StringBuilder stringBuilder;
        if (q instanceof x) {
            b bdD = ((x) q).bdD();
            if (bdD.isRoot()) {
                h.d(identifier, "name");
            } else {
                stringBuilder = new StringBuilder();
                String asString = bdD.asString();
                h.d(asString, "fqName.asString()");
                stringBuilder.append(u.a(asString, '.', '/', false, 4, null));
                stringBuilder.append('/');
                stringBuilder.append(identifier);
                identifier = stringBuilder.toString();
            }
            return identifier;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.d dVar2 = (kotlin.reflect.jvm.internal.impl.descriptors.d) (!(q instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) ? null : q);
        if (dVar2 != null) {
            String E = vVar.E(dVar2);
            if (E == null) {
                E = a(dVar2, (v) vVar, z);
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(E);
            stringBuilder.append("$");
            stringBuilder.append(identifier);
            return stringBuilder.toString();
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Unexpected container: ");
        stringBuilder2.append(q);
        stringBuilder2.append(" for ");
        stringBuilder2.append(dVar);
        throw new IllegalArgumentException(stringBuilder2.toString());
    }

    private static final k q(k kVar) {
        kotlin.reflect.jvm.internal.impl.descriptors.d dVar = (kotlin.reflect.jvm.internal.impl.descriptors.d) (!(kVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) ? null : kVar);
        if (dVar == null) {
            x dVar2 = (x) (!(kVar instanceof x) ? null : kVar);
        }
        k kVar2 = dVar2;
        if (kVar2 != null) {
            return kVar2;
        }
        if (kVar != null) {
            return q(kVar.bbv());
        }
        return null;
    }

    private static final w c(kotlin.reflect.jvm.internal.impl.descriptors.an anVar) {
        List aYq = anVar.aYq();
        int isEmpty = aYq.isEmpty() ^ 1;
        if (m.etY && isEmpty == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Upper bounds should not be empty: ");
            stringBuilder.append(anVar);
            throw new AssertionError(stringBuilder.toString());
        }
        Object obj;
        h.d(aYq, "upperBounds");
        Iterator it = aYq.iterator();
        Object obj2;
        do {
            kotlin.reflect.jvm.internal.impl.descriptors.f fVar = null;
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            kotlin.reflect.jvm.internal.impl.descriptors.f bbW = ((w) obj).bwA().bbW();
            if (bbW instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) {
                fVar = bbW;
            }
            kotlin.reflect.jvm.internal.impl.descriptors.d dVar = (kotlin.reflect.jvm.internal.impl.descriptors.d) fVar;
            obj2 = null;
            if (!(dVar == null || dVar.bbF() == ClassKind.INTERFACE || dVar.bbF() == ClassKind.ANNOTATION_CLASS)) {
                obj2 = 1;
                continue;
            }
        } while (obj2 == null);
        w wVar = (w) obj;
        if (wVar != null) {
            return wVar;
        }
        Object bU = u.bU(aYq);
        h.d(bU, "upperBounds.first()");
        return (w) bU;
    }
}
