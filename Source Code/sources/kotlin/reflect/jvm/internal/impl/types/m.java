package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import kotlin.reflect.jvm.internal.impl.renderer.b;
import kotlin.reflect.jvm.internal.impl.renderer.f;
import kotlin.reflect.jvm.internal.impl.types.b.a;

/* compiled from: dynamicTypes.kt */
public final class m extends q {
    private final g eBt;

    public String a(b bVar, f fVar) {
        h.e(bVar, "renderer");
        h.e(fVar, "options");
        return "dynamic";
    }

    public boolean aYp() {
        return false;
    }

    /* renamed from: hi */
    public m gP(boolean z) {
        return this;
    }

    public m(kotlin.reflect.jvm.internal.impl.builtins.g gVar, g gVar2) {
        h.e(gVar, "builtIns");
        h.e(gVar2, "annotations");
        ad baS = gVar.baS();
        h.d(baS, "builtIns.nothingType");
        ad baV = gVar.baV();
        h.d(baV, "builtIns.nullableAnyType");
        super(baS, baV);
        this.eBt = gVar2;
    }

    public g bbQ() {
        return this.eBt;
    }

    public ad bhi() {
        return byU();
    }

    /* renamed from: o */
    public m f(g gVar) {
        h.e(gVar, "newAnnotations");
        return new m(a.bj(bhi()), gVar);
    }
}
