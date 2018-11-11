package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.List;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.j;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import kotlin.reflect.jvm.internal.impl.descriptors.z;
import kotlin.reflect.jvm.internal.impl.descriptors.z.a;
import kotlin.reflect.jvm.internal.impl.name.b;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.h;
import kotlin.reflect.jvm.internal.impl.storage.e;
import kotlin.reflect.jvm.internal.impl.storage.g;

/* compiled from: LazyPackageViewDescriptorImpl.kt */
public final class q extends j implements z {
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(q.class), "fragments", "getFragments()Ljava/util/List;"))};
    private final b eBM;
    private final e eDu;
    private final h eDv;
    private final u eDw;

    public List<x> getFragments() {
        return (List) g.a(this.eDu, (Object) this, apP[0]);
    }

    public boolean isEmpty() {
        return a.a(this);
    }

    /* renamed from: beN */
    public u bar() {
        return this.eDw;
    }

    public b bdD() {
        return this.eBM;
    }

    public q(u uVar, b bVar, kotlin.reflect.jvm.internal.impl.storage.h hVar) {
        kotlin.jvm.internal.h.e(uVar, "module");
        kotlin.jvm.internal.h.e(bVar, "fqName");
        kotlin.jvm.internal.h.e(hVar, "storageManager");
        super(kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.eBF.bel(), bVar.btO());
        this.eDw = uVar;
        this.eBM = bVar;
        this.eDu = hVar.i(new LazyPackageViewDescriptorImpl$fragments$2(this));
        this.eDv = new kotlin.reflect.jvm.internal.impl.resolve.scopes.g(hVar.i(new LazyPackageViewDescriptorImpl$memberScope$1(this)));
    }

    public h bbk() {
        return this.eDv;
    }

    /* renamed from: beM */
    public z bbv() {
        if (bdD().isRoot()) {
            return null;
        }
        u beN = bar();
        b btM = bdD().btM();
        kotlin.jvm.internal.h.d(btM, "fqName.parent()");
        return beN.g(btM);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof z)) {
            obj = null;
        }
        z zVar = (z) obj;
        boolean z = false;
        if (zVar == null) {
            return false;
        }
        if (kotlin.jvm.internal.h.E(bdD(), zVar.bdD()) && kotlin.jvm.internal.h.E(bar(), zVar.bar())) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return (bar().hashCode() * 31) + bdD().hashCode();
    }

    public <R, D> R a(m<R, D> mVar, D d) {
        kotlin.jvm.internal.h.e(mVar, "visitor");
        return mVar.a((z) this, (Object) d);
    }
}
