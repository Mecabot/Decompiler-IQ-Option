package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.d;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.j;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.b;

/* compiled from: context.kt */
public final class h {
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(h.class), "defaultTypeQualifiers", "getDefaultTypeQualifiers()Lorg/jetbrains/kotlin/load/java/lazy/JavaTypeQualifiersByElementType;"))};
    private final d eGW = this.eHa;
    private final b eGX = new b(this, this.eGZ);
    private final b eGY;
    private final m eGZ;
    private final d<d> eHa;

    public final d bgo() {
        d dVar = this.eGW;
        j jVar = apP[0];
        return (d) dVar.getValue();
    }

    public h(b bVar, m mVar, d<d> dVar) {
        kotlin.jvm.internal.h.e(bVar, "components");
        kotlin.jvm.internal.h.e(mVar, "typeParameterResolver");
        kotlin.jvm.internal.h.e(dVar, "delegateForDefaultTypeQualifiers");
        this.eGY = bVar;
        this.eGZ = mVar;
        this.eHa = dVar;
    }

    public final b bgq() {
        return this.eGY;
    }

    public final m bgr() {
        return this.eGZ;
    }

    public final d<d> bgs() {
        return this.eHa;
    }

    public final b bgp() {
        return this.eGX;
    }

    public final kotlin.reflect.jvm.internal.impl.storage.h baI() {
        return this.eGY.baI();
    }

    public final u bar() {
        return this.eGY.bar();
    }
}
