package kotlin.reflect.jvm.internal.impl.types;

import kotlin.LazyThreadSafetyMode;
import kotlin.d;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;
import kotlin.reflect.jvm.internal.impl.descriptors.an;

/* compiled from: StarProjectionImpl.kt */
public final class ah extends aq {
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(ah.class), "_type", "get_type()Lorg/jetbrains/kotlin/types/KotlinType;"))};
    private final d eUZ = g.a(LazyThreadSafetyMode.PUBLICATION, new StarProjectionImpl$_type$2(this));
    private final an eVa;

    private final w bzg() {
        d dVar = this.eUZ;
        j jVar = apP[0];
        return (w) dVar.getValue();
    }

    public boolean bze() {
        return true;
    }

    public ah(an anVar) {
        h.e(anVar, "typeParameter");
        this.eVa = anVar;
    }

    public Variance bzf() {
        return Variance.OUT_VARIANCE;
    }

    public w bai() {
        return bzg();
    }
}
