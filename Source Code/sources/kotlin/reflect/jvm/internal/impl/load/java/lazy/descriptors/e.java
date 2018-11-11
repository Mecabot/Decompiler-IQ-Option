package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.google.android.gms.measurement.AppMeasurement.Param;
import java.util.Map;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.j;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.c;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.q;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.a.a;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.h;
import kotlin.reflect.jvm.internal.impl.load.java.structure.m;
import kotlin.reflect.jvm.internal.impl.load.java.structure.o;
import kotlin.reflect.jvm.internal.impl.load.java.structure.v;
import kotlin.reflect.jvm.internal.impl.name.b;
import kotlin.reflect.jvm.internal.impl.resolve.constants.i;
import kotlin.reflect.jvm.internal.impl.storage.f;
import kotlin.reflect.jvm.internal.impl.storage.g;
import kotlin.reflect.jvm.internal.impl.types.ad;
import kotlin.reflect.jvm.internal.impl.types.ar;
import kotlin.reflect.jvm.internal.impl.types.au;
import kotlin.reflect.jvm.internal.impl.types.w;
import kotlin.reflect.jvm.internal.impl.types.x;

/* compiled from: LazyJavaAnnotationDescriptor.kt */
public final class e implements c {
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(e.class), "fqName", "getFqName()Lorg/jetbrains/kotlin/name/FqName;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(e.class), Param.TYPE, "getType()Lorg/jetbrains/kotlin/types/SimpleType;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(e.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};
    private final kotlin.reflect.jvm.internal.impl.storage.e eFQ = this.eGT.baI().i(new LazyJavaAnnotationDescriptor$type$2(this));
    private final h eGT;
    private final kotlin.reflect.jvm.internal.impl.storage.e eGh = this.eGT.baI().i(new LazyJavaAnnotationDescriptor$allValueArguments$2(this));
    private final f eHq = this.eGT.baI().j(new LazyJavaAnnotationDescriptor$fqName$2(this));
    private final a eHr = this.eGT.bgq().bgc().a(this.eHs);
    private final kotlin.reflect.jvm.internal.impl.load.java.structure.a eHs;

    public b bdD() {
        return (b) g.a(this.eHq, (Object) this, apP[0]);
    }

    public Map<kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.resolve.constants.f<?>> bee() {
        return (Map) g.a(this.eGh, (Object) this, apP[2]);
    }

    /* renamed from: bfN */
    public ad bai() {
        return (ad) g.a(this.eFQ, (Object) this, apP[1]);
    }

    public e(h hVar, kotlin.reflect.jvm.internal.impl.load.java.structure.a aVar) {
        kotlin.jvm.internal.h.e(hVar, "c");
        kotlin.jvm.internal.h.e(aVar, "javaAnnotation");
        this.eGT = hVar;
        this.eHs = aVar;
    }

    /* renamed from: bgz */
    public a bbR() {
        return this.eHr;
    }

    private final kotlin.reflect.jvm.internal.impl.resolve.constants.f<?> b(kotlin.reflect.jvm.internal.impl.load.java.structure.b bVar) {
        if (bVar instanceof o) {
            return kotlin.reflect.jvm.internal.impl.resolve.constants.g.eRn.db(((o) bVar).getValue());
        }
        if (bVar instanceof m) {
            m mVar = (m) bVar;
            return a(mVar.bhA(), mVar.bhB());
        } else if (bVar instanceof kotlin.reflect.jvm.internal.impl.load.java.structure.e) {
            kotlin.reflect.jvm.internal.impl.name.f bdc = bVar.bdc();
            if (bdc == null) {
                bdc = kotlin.reflect.jvm.internal.impl.load.java.m.eFm;
                kotlin.jvm.internal.h.d(bdc, "DEFAULT_ANNOTATION_MEMBER_NAME");
            }
            return a(bdc, ((kotlin.reflect.jvm.internal.impl.load.java.structure.e) bVar).bhn());
        } else if (bVar instanceof kotlin.reflect.jvm.internal.impl.load.java.structure.c) {
            return b(((kotlin.reflect.jvm.internal.impl.load.java.structure.c) bVar).bhl());
        } else {
            return bVar instanceof kotlin.reflect.jvm.internal.impl.load.java.structure.h ? a(((kotlin.reflect.jvm.internal.impl.load.java.structure.h) bVar).bhv()) : null;
        }
    }

    private final kotlin.reflect.jvm.internal.impl.resolve.constants.f<?> b(kotlin.reflect.jvm.internal.impl.load.java.structure.a aVar) {
        return new kotlin.reflect.jvm.internal.impl.resolve.constants.a(new e(this.eGT, aVar));
    }

    /* JADX WARNING: Missing block: B:10:0x0026, code:
            if (r3 != null) goto L_0x0047;
     */
    private final kotlin.reflect.jvm.internal.impl.resolve.constants.f<?> a(kotlin.reflect.jvm.internal.impl.name.f r3, java.util.List<? extends kotlin.reflect.jvm.internal.impl.load.java.structure.b> r4) {
        /*
        r2 = this;
        r0 = r2.bai();
        r1 = "type";
        kotlin.jvm.internal.h.d(r0, r1);
        r0 = (kotlin.reflect.jvm.internal.impl.types.w) r0;
        r0 = kotlin.reflect.jvm.internal.impl.types.y.aF(r0);
        if (r0 == 0) goto L_0x0013;
    L_0x0011:
        r3 = 0;
        return r3;
    L_0x0013:
        r0 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.l(r2);
        if (r0 != 0) goto L_0x001c;
    L_0x0019:
        kotlin.jvm.internal.h.aXZ();
    L_0x001c:
        r3 = kotlin.reflect.jvm.internal.impl.load.java.components.a.b(r3, r0);
        if (r3 == 0) goto L_0x0029;
    L_0x0022:
        r3 = r3.bai();
        if (r3 == 0) goto L_0x0029;
    L_0x0028:
        goto L_0x0047;
    L_0x0029:
        r3 = r2.eGT;
        r3 = r3.bgq();
        r3 = r3.bar();
        r3 = r3.bdy();
        r0 = kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT;
        r1 = "Unknown array element type";
        r1 = kotlin.reflect.jvm.internal.impl.types.p.mU(r1);
        r1 = (kotlin.reflect.jvm.internal.impl.types.w) r1;
        r3 = r3.a(r0, r1);
        r3 = (kotlin.reflect.jvm.internal.impl.types.w) r3;
    L_0x0047:
        r4 = (java.lang.Iterable) r4;
        r0 = new java.util.ArrayList;
        r1 = 10;
        r1 = kotlin.collections.n.e(r4, r1);
        r0.<init>(r1);
        r0 = (java.util.Collection) r0;
        r4 = r4.iterator();
    L_0x005a:
        r1 = r4.hasNext();
        if (r1 == 0) goto L_0x0078;
    L_0x0060:
        r1 = r4.next();
        r1 = (kotlin.reflect.jvm.internal.impl.load.java.structure.b) r1;
        r1 = r2.b(r1);
        if (r1 == 0) goto L_0x006d;
    L_0x006c:
        goto L_0x0074;
    L_0x006d:
        r1 = new kotlin.reflect.jvm.internal.impl.resolve.constants.q;
        r1.<init>();
        r1 = (kotlin.reflect.jvm.internal.impl.resolve.constants.f) r1;
    L_0x0074:
        r0.add(r1);
        goto L_0x005a;
    L_0x0078:
        r0 = (java.util.List) r0;
        r4 = kotlin.reflect.jvm.internal.impl.resolve.constants.g.eRn;
        r1 = "arrayType";
        kotlin.jvm.internal.h.d(r3, r1);
        r3 = r4.a(r0, r3);
        r3 = (kotlin.reflect.jvm.internal.impl.resolve.constants.f) r3;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.e.a(kotlin.reflect.jvm.internal.impl.name.f, java.util.List):kotlin.reflect.jvm.internal.impl.resolve.constants.f<?>");
    }

    private final kotlin.reflect.jvm.internal.impl.resolve.constants.f<?> a(kotlin.reflect.jvm.internal.impl.name.a aVar, kotlin.reflect.jvm.internal.impl.name.f fVar) {
        return (aVar == null || fVar == null) ? null : new i(aVar, fVar);
    }

    private final kotlin.reflect.jvm.internal.impl.resolve.constants.f<?> a(v vVar) {
        w aU = au.aU(this.eGT.bgp().a(vVar, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.c.a(TypeUsage.COMMON, false, null, 3, null)));
        d b = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.b(this.eGT.bar(), new b("java.lang.Class"), NoLookupLocation.FOR_NON_TRACKED_SCOPE);
        if (b == null) {
            return null;
        }
        return new kotlin.reflect.jvm.internal.impl.resolve.constants.o(x.a(kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.eBF.bel(), b, l.cr(new ar(aU))));
    }

    public String toString() {
        return kotlin.reflect.jvm.internal.impl.renderer.b.a(kotlin.reflect.jvm.internal.impl.renderer.b.ePd, this, null, 2, null);
    }

    private final d q(b bVar) {
        u bar = this.eGT.bar();
        kotlin.reflect.jvm.internal.impl.name.a t = kotlin.reflect.jvm.internal.impl.name.a.t(bVar);
        kotlin.jvm.internal.h.d(t, "ClassId.topLevel(fqName)");
        return q.a(bar, t, this.eGT.bgq().bfX().biq().bxB());
    }
}
