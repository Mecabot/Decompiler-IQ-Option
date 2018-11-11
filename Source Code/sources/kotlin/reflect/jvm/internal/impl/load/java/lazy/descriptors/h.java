package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.j;
import kotlin.reflect.jvm.internal.impl.descriptors.ai;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.w;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.a;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.f;
import kotlin.reflect.jvm.internal.impl.load.java.structure.t;
import kotlin.reflect.jvm.internal.impl.load.kotlin.n;
import kotlin.reflect.jvm.internal.impl.load.kotlin.o;
import kotlin.reflect.jvm.internal.impl.name.b;
import kotlin.reflect.jvm.internal.impl.storage.e;

/* compiled from: LazyJavaPackageFragment.kt */
public final class h extends w {
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(h.class), "binaryClasses", "getBinaryClasses$descriptors_jvm()Ljava/util/Map;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(h.class), "partToFacade", "getPartToFacade()Ljava/util/HashMap;"))};
    private final g eBt;
    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.h eGT;
    private final e eHI = this.eGT.baI().i(new LazyJavaPackageFragment$binaryClasses$2(this));
    private final d eHJ = new d(this.eGT, this.eHM, this);
    private final e<List<b>> eHK = this.eGT.baI().a(new LazyJavaPackageFragment$subPackages$1(this), m.emptyList());
    private final e eHL;
    private final t eHM;

    public final Map<String, n> bgL() {
        return (Map) kotlin.reflect.jvm.internal.impl.storage.g.a(this.eHI, (Object) this, apP[0]);
    }

    public h(kotlin.reflect.jvm.internal.impl.load.java.lazy.h hVar, t tVar) {
        g bel;
        kotlin.jvm.internal.h.e(hVar, "outerContext");
        kotlin.jvm.internal.h.e(tVar, "jPackage");
        super(hVar.bar(), tVar.bdD());
        this.eHM = tVar;
        this.eGT = a.a(hVar, (kotlin.reflect.jvm.internal.impl.descriptors.e) this, null, 0, 6, null);
        if (this.eGT.bgq().bgh().getDisabled()) {
            bel = g.eBF.bel();
        } else {
            bel = f.a(this.eGT, this.eHM);
        }
        this.eBt = bel;
        this.eHL = this.eGT.baI().i(new LazyJavaPackageFragment$partToFacade$2(this));
    }

    public g bbQ() {
        return this.eBt;
    }

    public final List<b> bgM() {
        return (List) this.eHK.invoke();
    }

    public final d c(kotlin.reflect.jvm.internal.impl.load.java.structure.g gVar) {
        kotlin.jvm.internal.h.e(gVar, "jClass");
        return this.eHJ.bgx().c(gVar);
    }

    /* renamed from: bgN */
    public d bbk() {
        return this.eHJ;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Lazy Java package fragment: ");
        stringBuilder.append(bdD());
        return stringBuilder.toString();
    }

    public ai bbR() {
        return new o(this);
    }
}
