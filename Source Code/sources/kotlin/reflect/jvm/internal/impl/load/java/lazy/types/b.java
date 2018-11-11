package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.c;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.h;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.m;
import kotlin.reflect.jvm.internal.impl.load.java.structure.f;
import kotlin.reflect.jvm.internal.impl.load.java.structure.j;
import kotlin.reflect.jvm.internal.impl.load.java.structure.u;
import kotlin.reflect.jvm.internal.impl.load.java.structure.v;
import kotlin.reflect.jvm.internal.impl.load.java.structure.z;
import kotlin.reflect.jvm.internal.impl.name.a;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.ad;
import kotlin.reflect.jvm.internal.impl.types.an;
import kotlin.reflect.jvm.internal.impl.types.ap;
import kotlin.reflect.jvm.internal.impl.types.ar;
import kotlin.reflect.jvm.internal.impl.types.p;
import kotlin.reflect.jvm.internal.impl.types.w;
import kotlin.reflect.jvm.internal.impl.types.x;

/* compiled from: JavaTypeResolver.kt */
public final class b {
    private final h eGT;
    private final m eGZ;

    public b(h hVar, m mVar) {
        kotlin.jvm.internal.h.e(hVar, "c");
        kotlin.jvm.internal.h.e(mVar, "typeParameterResolver");
        this.eGT = hVar;
        this.eGZ = mVar;
    }

    public final w a(v vVar, a aVar) {
        kotlin.jvm.internal.h.e(vVar, "javaType");
        kotlin.jvm.internal.h.e(aVar, "attr");
        if (vVar instanceof u) {
            Object b;
            PrimitiveType bhJ = ((u) vVar).bhJ();
            if (bhJ != null) {
                b = this.eGT.bar().bdy().b(bhJ);
            } else {
                b = this.eGT.bar().bdy().bbf();
            }
            kotlin.jvm.internal.h.d(b, "if (primitiveType != nul….module.builtIns.unitType");
            return (w) b;
        } else if (vVar instanceof j) {
            return a((j) vVar, aVar);
        } else {
            if (vVar instanceof f) {
                return a(this, (f) vVar, aVar, false, 4, null);
            } else if (vVar instanceof z) {
                vVar = ((z) vVar).bhM();
                if (vVar != null) {
                    w a = a(vVar, aVar);
                    if (a != null) {
                        return a;
                    }
                }
                ad baW = this.eGT.bar().bdy().baW();
                kotlin.jvm.internal.h.d(baW, "c.module.builtIns.defaultBound");
                return baW;
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unsupported type: ");
                stringBuilder.append(vVar);
                throw new UnsupportedOperationException(stringBuilder.toString());
            }
        }
    }

    public static /* bridge */ /* synthetic */ w a(b bVar, f fVar, a aVar, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return bVar.a(fVar, aVar, z);
    }

    public final w a(f fVar, a aVar, boolean z) {
        kotlin.jvm.internal.h.e(fVar, "arrayType");
        kotlin.jvm.internal.h.e(aVar, "attr");
        v bho = fVar.bho();
        u uVar = (u) (!(bho instanceof u) ? null : bho);
        PrimitiveType bhJ = uVar != null ? uVar.bhJ() : null;
        ad c;
        w wVar;
        if (bhJ != null) {
            c = this.eGT.bar().bdy().c(bhJ);
            if (aVar.bhe()) {
                kotlin.jvm.internal.h.d(c, "jetType");
                wVar = c;
            } else {
                kotlin.jvm.internal.h.d(c, "jetType");
                wVar = x.a(c, c.gQ(true));
            }
            return wVar;
        }
        wVar = a(bho, c.a(TypeUsage.COMMON, aVar.bhe(), null, 2, null));
        if (aVar.bhe()) {
            c = this.eGT.bar().bdy().a(z ? Variance.OUT_VARIANCE : Variance.INVARIANT, wVar);
            kotlin.jvm.internal.h.d(c, "c.module.builtIns.getArr…ctionKind, componentType)");
            return c;
        }
        ad a = this.eGT.bar().bdy().a(Variance.INVARIANT, wVar);
        kotlin.jvm.internal.h.d(a, "c.module.builtIns.getArr…INVARIANT, componentType)");
        return x.a(a, this.eGT.bar().bdy().a(Variance.OUT_VARIANCE, wVar).gQ(true));
    }

    private final w a(j jVar, a aVar) {
        JavaTypeResolver$transformJavaClassifierType$1 javaTypeResolver$transformJavaClassifierType$1 = new JavaTypeResolver$transformJavaClassifierType$1(jVar);
        Object obj = (aVar.bhe() || aVar.bhc() == TypeUsage.SUPERTYPE) ? null : 1;
        boolean bhx = jVar.bhx();
        ad a;
        if (bhx || obj != null) {
            ad a2 = a(jVar, aVar.a(JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND), null);
            if (a2 != null) {
                a = a(jVar, aVar.a(JavaTypeFlexibility.FLEXIBLE_UPPER_BOUND), a2);
                if (a != null) {
                    w fVar;
                    if (bhx) {
                        fVar = new f(a2, a);
                    } else {
                        fVar = x.a(a2, a);
                    }
                    return fVar;
                }
                a = javaTypeResolver$transformJavaClassifierType$1.invoke();
                kotlin.jvm.internal.h.d(a, "errorType()");
                return a;
            }
            a = javaTypeResolver$transformJavaClassifierType$1.invoke();
            kotlin.jvm.internal.h.d(a, "errorType()");
            return a;
        }
        a = a(jVar, aVar, null);
        if (a == null) {
            a = javaTypeResolver$transformJavaClassifierType$1.invoke();
            kotlin.jvm.internal.h.d(a, "errorType()");
        }
        return a;
    }

    /* JADX WARNING: Missing block: B:2:0x0006, code:
            if (r0 != null) goto L_0x0015;
     */
    private final kotlin.reflect.jvm.internal.impl.types.ad a(kotlin.reflect.jvm.internal.impl.load.java.structure.j r5, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a r6, kotlin.reflect.jvm.internal.impl.types.ad r7) {
        /*
        r4 = this;
        if (r7 == 0) goto L_0x0009;
    L_0x0002:
        r0 = r7.bbQ();
        if (r0 == 0) goto L_0x0009;
    L_0x0008:
        goto L_0x0015;
    L_0x0009:
        r0 = new kotlin.reflect.jvm.internal.impl.load.java.lazy.e;
        r1 = r4.eGT;
        r2 = r5;
        r2 = (kotlin.reflect.jvm.internal.impl.load.java.structure.d) r2;
        r0.<init>(r1, r2);
        r0 = (kotlin.reflect.jvm.internal.impl.descriptors.annotations.g) r0;
    L_0x0015:
        r1 = r4.b(r5, r6);
        r2 = 0;
        if (r1 == 0) goto L_0x0043;
    L_0x001c:
        r3 = r4.a(r6);
        if (r7 == 0) goto L_0x0026;
    L_0x0022:
        r2 = r7.bwA();
    L_0x0026:
        r2 = kotlin.jvm.internal.h.E(r2, r1);
        if (r2 == 0) goto L_0x003a;
    L_0x002c:
        r2 = r5.bhx();
        if (r2 != 0) goto L_0x003a;
    L_0x0032:
        if (r3 == 0) goto L_0x003a;
    L_0x0034:
        r5 = 1;
        r5 = r7.gQ(r5);
        return r5;
    L_0x003a:
        r5 = r4.a(r5, r6, r1);
        r5 = kotlin.reflect.jvm.internal.impl.types.x.c(r0, r1, r5, r3);
        return r5;
    L_0x0043:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.types.b.a(kotlin.reflect.jvm.internal.impl.load.java.structure.j, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a, kotlin.reflect.jvm.internal.impl.types.ad):kotlin.reflect.jvm.internal.impl.types.ad");
    }

    /* JADX WARNING: Missing block: B:11:0x002e, code:
            if (r5 != null) goto L_0x0063;
     */
    private final kotlin.reflect.jvm.internal.impl.types.an b(kotlin.reflect.jvm.internal.impl.load.java.structure.j r4, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a r5) {
        /*
        r3 = this;
        r0 = r4.bhw();
        if (r0 == 0) goto L_0x007d;
    L_0x0006:
        r1 = r0 instanceof kotlin.reflect.jvm.internal.impl.load.java.structure.g;
        if (r1 == 0) goto L_0x004f;
    L_0x000a:
        r1 = r0;
        r1 = (kotlin.reflect.jvm.internal.impl.load.java.structure.g) r1;
        r2 = r1.bdD();
        if (r2 == 0) goto L_0x0036;
    L_0x0013:
        r5 = r3.a(r4, r5, r2);
        if (r5 == 0) goto L_0x001a;
    L_0x0019:
        goto L_0x0028;
    L_0x001a:
        r5 = r3.eGT;
        r5 = r5.bgq();
        r5 = r5.bgd();
        r5 = r5.b(r1);
    L_0x0028:
        if (r5 == 0) goto L_0x0031;
    L_0x002a:
        r5 = r5.bby();
        if (r5 == 0) goto L_0x0031;
    L_0x0030:
        goto L_0x0063;
    L_0x0031:
        r5 = r3.a(r4);
        goto L_0x0063;
    L_0x0036:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "Class type should have a FQ name: ";
        r4.append(r5);
        r4.append(r0);
        r4 = r4.toString();
        r5 = new java.lang.AssertionError;
        r5.<init>(r4);
        r5 = (java.lang.Throwable) r5;
        throw r5;
    L_0x004f:
        r4 = r0 instanceof kotlin.reflect.jvm.internal.impl.load.java.structure.w;
        if (r4 == 0) goto L_0x0064;
    L_0x0053:
        r4 = r3.eGZ;
        r0 = (kotlin.reflect.jvm.internal.impl.load.java.structure.w) r0;
        r4 = r4.a(r0);
        if (r4 == 0) goto L_0x0062;
    L_0x005d:
        r5 = r4.bby();
        goto L_0x0063;
    L_0x0062:
        r5 = 0;
    L_0x0063:
        return r5;
    L_0x0064:
        r4 = new java.lang.IllegalStateException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r1 = "Unknown classifier kind: ";
        r5.append(r1);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        r4 = (java.lang.Throwable) r4;
        throw r4;
    L_0x007d:
        r4 = r3.a(r4);
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.types.b.b(kotlin.reflect.jvm.internal.impl.load.java.structure.j, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a):kotlin.reflect.jvm.internal.impl.types.an");
    }

    private final an a(j jVar) {
        a t = a.t(new kotlin.reflect.jvm.internal.impl.name.b(jVar.bhy()));
        kotlin.reflect.jvm.internal.impl.descriptors.w bxB = this.eGT.bgq().bfX().biq().bxB();
        kotlin.jvm.internal.h.d(t, "classId");
        an bby = bxB.a(t, l.cr(Integer.valueOf(0))).bby();
        kotlin.jvm.internal.h.d(bby, "c.components.deserialize…istOf(0)).typeConstructor");
        return bby;
    }

    private final d a(j jVar, a aVar, kotlin.reflect.jvm.internal.impl.name.b bVar) {
        if (aVar.bhe() && kotlin.jvm.internal.h.E(bVar, c.eIo)) {
            return this.eGT.bgq().bgg().bbm();
        }
        c cVar = c.eAc;
        d a = c.a(cVar, bVar, this.eGT.bar().bdy(), null, 4, null);
        if (a != null) {
            return (cVar.i(a) && (aVar.bhd() == JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND || aVar.bhc() == TypeUsage.SUPERTYPE || a(jVar, a))) ? cVar.k(a) : a;
        } else {
            return null;
        }
    }

    private final boolean a(j jVar, d dVar) {
        boolean z = false;
        if (!JavaTypeResolver$argumentsMakeSenseOnlyForMutableContainer$1.eIn.b((v) u.bX(jVar.getTypeArguments()))) {
            return false;
        }
        an bby = c.eAc.k(dVar).bby();
        kotlin.jvm.internal.h.d(bby, "JavaToKotlinClassMap.con…         .typeConstructor");
        List parameters = bby.getParameters();
        kotlin.jvm.internal.h.d(parameters, "JavaToKotlinClassMap.con…ypeConstructor.parameters");
        kotlin.reflect.jvm.internal.impl.descriptors.an anVar = (kotlin.reflect.jvm.internal.impl.descriptors.an) u.bX(parameters);
        if (anVar != null) {
            Variance bdd = anVar.bdd();
            if (bdd != null) {
                if (bdd != Variance.OUT_VARIANCE) {
                    z = true;
                }
                return z;
            }
        }
        return false;
    }

    private final List<ap> a(j jVar, a aVar, an anVar) {
        boolean bhx = jVar.bhx();
        Object obj = (bhx || (jVar.getTypeArguments().isEmpty() && !anVar.getParameters().isEmpty())) ? 1 : null;
        List parameters = anVar.getParameters();
        Iterable<kotlin.reflect.jvm.internal.impl.descriptors.an> iterable;
        Collection arrayList;
        if (obj != null) {
            kotlin.jvm.internal.h.d(parameters, "typeParameters");
            iterable = parameters;
            arrayList = new ArrayList(n.e(iterable, 10));
            for (kotlin.reflect.jvm.internal.impl.descriptors.an anVar2 : iterable) {
                a aVar2;
                kotlin.reflect.jvm.internal.impl.types.z zVar = new kotlin.reflect.jvm.internal.impl.types.z(this.eGT.baI(), new JavaTypeResolver$computeArguments$$inlined$map$lambda$1(anVar2, this, aVar, anVar, bhx));
                d dVar = d.eIr;
                kotlin.jvm.internal.h.d(anVar2, "parameter");
                if (bhx) {
                    aVar2 = aVar;
                } else {
                    aVar2 = aVar.a(JavaTypeFlexibility.INFLEXIBLE);
                }
                arrayList.add(dVar.a(anVar2, aVar2, (w) zVar));
            }
            return u.W((List) arrayList);
        } else if (parameters.size() != jVar.getTypeArguments().size()) {
            kotlin.jvm.internal.h.d(parameters, "typeParameters");
            iterable = parameters;
            arrayList = new ArrayList(n.e(iterable, 10));
            for (kotlin.reflect.jvm.internal.impl.descriptors.an anVar3 : iterable) {
                kotlin.jvm.internal.h.d(anVar3, "p");
                arrayList.add(new ar(p.mU(anVar3.bdc().asString())));
            }
            return u.W((List) arrayList);
        } else {
            Iterable<kotlin.collections.w> Z = u.Z(jVar.getTypeArguments());
            Collection arrayList2 = new ArrayList(n.e(Z, 10));
            for (kotlin.collections.w wVar : Z) {
                int component1 = wVar.component1();
                v vVar = (v) wVar.aXH();
                Object obj2 = component1 < parameters.size() ? 1 : null;
                if (kotlin.m.etY && obj2 == null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Argument index should be less then type parameters count, but ");
                    stringBuilder.append(component1);
                    stringBuilder.append(" > ");
                    stringBuilder.append(parameters.size());
                    throw new AssertionError(stringBuilder.toString());
                }
                kotlin.reflect.jvm.internal.impl.descriptors.an anVar4 = (kotlin.reflect.jvm.internal.impl.descriptors.an) parameters.get(component1);
                a a = c.a(TypeUsage.COMMON, false, null, 3, null);
                kotlin.jvm.internal.h.d(anVar4, "parameter");
                arrayList2.add(a(vVar, a, anVar4));
            }
            return u.W((List) arrayList2);
        }
    }

    private final ap a(v vVar, a aVar, kotlin.reflect.jvm.internal.impl.descriptors.an anVar) {
        if (!(vVar instanceof z)) {
            return new ar(Variance.INVARIANT, a(vVar, aVar));
        }
        z zVar = (z) vVar;
        v bhM = zVar.bhM();
        Variance variance = zVar.bhN() ? Variance.OUT_VARIANCE : Variance.IN_VARIANCE;
        if (bhM == null || a(variance, anVar)) {
            return c.a(anVar, aVar);
        }
        return kotlin.reflect.jvm.internal.impl.types.b.a.a(a(bhM, c.a(TypeUsage.COMMON, false, null, 3, null)), variance, anVar);
    }

    private final boolean a(Variance variance, kotlin.reflect.jvm.internal.impl.descriptors.an anVar) {
        boolean z = false;
        if (anVar.bdd() == Variance.INVARIANT) {
            return false;
        }
        if (variance != anVar.bdd()) {
            z = true;
        }
        return z;
    }

    private final boolean a(a aVar) {
        boolean z = false;
        if (aVar.bhd() == JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND) {
            return false;
        }
        if (!(aVar.bhe() || aVar.bhc() == TypeUsage.SUPERTYPE)) {
            z = true;
        }
        return z;
    }
}
