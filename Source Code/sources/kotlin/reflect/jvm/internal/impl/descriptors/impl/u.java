package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.d;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.j;
import kotlin.reflect.jvm.internal.impl.builtins.g;
import kotlin.reflect.jvm.internal.impl.descriptors.InvalidModuleException;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.u.a;
import kotlin.reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.jvm.internal.impl.descriptors.z;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.storage.b;
import kotlin.reflect.jvm.internal.impl.storage.h;

/* compiled from: ModuleDescriptorImpl.kt */
public final class u extends j implements kotlin.reflect.jvm.internal.impl.descriptors.u {
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(u.class), "packageFragmentProviderForWholeModuleWithDependencies", "getPackageFragmentProviderForWholeModuleWithDependencies()Lorg/jetbrains/kotlin/descriptors/impl/CompositePackageFragmentProvider;"))};
    private final g eBL;
    private final Map<a<? extends Object>, Object> eDG;
    private s eDH;
    private y eDI;
    private final b<kotlin.reflect.jvm.internal.impl.name.b, z> eDJ;
    private final d eDK;
    private final f eDL;
    private final h exB;
    private boolean isValid;

    public u(f fVar, h hVar, g gVar, kotlin.reflect.jvm.internal.impl.resolve.f fVar2) {
        this(fVar, hVar, gVar, fVar2, null, null, 48, null);
    }

    private final i beU() {
        d dVar = this.eDK;
        j jVar = apP[0];
        return (i) dVar.getValue();
    }

    public <R, D> R a(m<R, D> mVar, D d) {
        kotlin.jvm.internal.h.e(mVar, "visitor");
        return kotlin.reflect.jvm.internal.impl.descriptors.u.b.a(this, mVar, d);
    }

    public k bbv() {
        return kotlin.reflect.jvm.internal.impl.descriptors.u.b.e(this);
    }

    public g bdy() {
        return this.eBL;
    }

    public /* synthetic */ u(f fVar, h hVar, g gVar, kotlin.reflect.jvm.internal.impl.resolve.f fVar2, Map map, f fVar3, int i, f fVar4) {
        this(fVar, hVar, gVar, (i & 8) != 0 ? (kotlin.reflect.jvm.internal.impl.resolve.f) null : fVar2, (i & 16) != 0 ? ad.emptyMap() : map, (i & 32) != 0 ? (f) null : fVar3);
    }

    /* JADX WARNING: Missing block: B:6:0x004e, code:
            if (r2 != null) goto L_0x0055;
     */
    public u(kotlin.reflect.jvm.internal.impl.name.f r2, kotlin.reflect.jvm.internal.impl.storage.h r3, kotlin.reflect.jvm.internal.impl.builtins.g r4, kotlin.reflect.jvm.internal.impl.resolve.f r5, java.util.Map<kotlin.reflect.jvm.internal.impl.descriptors.u.a<?>, ? extends java.lang.Object> r6, kotlin.reflect.jvm.internal.impl.name.f r7) {
        /*
        r1 = this;
        r0 = "moduleName";
        kotlin.jvm.internal.h.e(r2, r0);
        r0 = "storageManager";
        kotlin.jvm.internal.h.e(r3, r0);
        r0 = "builtIns";
        kotlin.jvm.internal.h.e(r4, r0);
        r0 = "capabilities";
        kotlin.jvm.internal.h.e(r6, r0);
        r0 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.eBF;
        r0 = r0.bel();
        r1.<init>(r0, r2);
        r1.exB = r3;
        r1.eBL = r4;
        r1.eDL = r7;
        r3 = r2.btR();
        if (r3 != 0) goto L_0x0042;
    L_0x0029:
        r3 = new java.lang.IllegalArgumentException;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "Module name must be special: ";
        r4.append(r5);
        r4.append(r2);
        r2 = r4.toString();
        r3.<init>(r2);
        r3 = (java.lang.Throwable) r3;
        throw r3;
    L_0x0042:
        if (r5 == 0) goto L_0x0051;
    L_0x0044:
        r2 = kotlin.reflect.jvm.internal.impl.resolve.f.eQO;
        r2 = kotlin.j.D(r2, r5);
        r2 = kotlin.collections.ac.h(r2);
        if (r2 == 0) goto L_0x0051;
    L_0x0050:
        goto L_0x0055;
    L_0x0051:
        r2 = kotlin.collections.ad.emptyMap();
    L_0x0055:
        r2 = kotlin.collections.ad.c(r6, r2);
        r1.eDG = r2;
        r2 = 1;
        r1.isValid = r2;
        r2 = r1.exB;
        r3 = new kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl$packages$1;
        r3.<init>(r1);
        r3 = (kotlin.jvm.a.b) r3;
        r2 = r2.o(r3);
        r1.eDJ = r2;
        r2 = new kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl$packageFragmentProviderForWholeModuleWithDependencies$2;
        r2.<init>(r1);
        r2 = (kotlin.jvm.a.a) r2;
        r2 = kotlin.g.f(r2);
        r1.eDK = r2;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.impl.u.<init>(kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.storage.h, kotlin.reflect.jvm.internal.impl.builtins.g, kotlin.reflect.jvm.internal.impl.resolve.f, java.util.Map, kotlin.reflect.jvm.internal.impl.name.f):void");
    }

    public boolean isValid() {
        return this.isValid;
    }

    public void beS() {
        if (!isValid()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Accessing invalid module descriptor ");
            stringBuilder.append(this);
            throw new InvalidModuleException(stringBuilder.toString());
        }
    }

    public List<kotlin.reflect.jvm.internal.impl.descriptors.u> beT() {
        s sVar = this.eDH;
        if (sVar != null) {
            return sVar.beR();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Dependencies of module ");
        stringBuilder.append(getId());
        stringBuilder.append(" were not set");
        throw new AssertionError(stringBuilder.toString());
    }

    public z g(kotlin.reflect.jvm.internal.impl.name.b bVar) {
        kotlin.jvm.internal.h.e(bVar, "fqName");
        beS();
        return (z) this.eDJ.invoke(bVar);
    }

    public Collection<kotlin.reflect.jvm.internal.impl.name.b> a(kotlin.reflect.jvm.internal.impl.name.b bVar, kotlin.jvm.a.b<? super f, Boolean> bVar2) {
        kotlin.jvm.internal.h.e(bVar, "fqName");
        kotlin.jvm.internal.h.e(bVar2, "nameFilter");
        beS();
        return beV().a(bVar, bVar2);
    }

    private final boolean isInitialized() {
        return this.eDI != null;
    }

    public final void a(s sVar) {
        kotlin.jvm.internal.h.e(sVar, "dependencies");
        Object obj = this.eDH == null ? 1 : null;
        if (kotlin.m.etY && obj == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Dependencies of ");
            stringBuilder.append(getId());
            stringBuilder.append(" were already set");
            throw new AssertionError(stringBuilder.toString());
        }
        this.eDH = sVar;
    }

    public final void a(u... uVarArr) {
        kotlin.jvm.internal.h.e(uVarArr, "descriptors");
        ce(i.A(uVarArr));
    }

    public final void ce(List<u> list) {
        kotlin.jvm.internal.h.e(list, "descriptors");
        a((List) list, aj.emptySet());
    }

    public final void a(List<u> list, Set<u> set) {
        kotlin.jvm.internal.h.e(list, "descriptors");
        kotlin.jvm.internal.h.e(set, "friends");
        a((s) new t(list, set, m.emptyList()));
    }

    public boolean d(kotlin.reflect.jvm.internal.impl.descriptors.u uVar) {
        kotlin.jvm.internal.h.e(uVar, "targetModule");
        if (!kotlin.jvm.internal.h.E(this, uVar)) {
            s sVar = this.eDH;
            if (sVar == null) {
                kotlin.jvm.internal.h.aXZ();
            }
            if (!(u.b((Iterable) sVar.beQ(), (Object) uVar) || beT().contains(uVar))) {
                return false;
            }
        }
        return true;
    }

    private final String getId() {
        String fVar = bdc().toString();
        kotlin.jvm.internal.h.d(fVar, "name.toString()");
        return fVar;
    }

    public final void a(y yVar) {
        kotlin.jvm.internal.h.e(yVar, "providerForModuleContent");
        int isInitialized = isInitialized() ^ 1;
        if (kotlin.m.etY && isInitialized == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Attempt to initialize module ");
            stringBuilder.append(getId());
            stringBuilder.append(" twice");
            throw new AssertionError(stringBuilder.toString());
        }
        this.eDI = yVar;
    }

    public final y beV() {
        beS();
        return beU();
    }
}
