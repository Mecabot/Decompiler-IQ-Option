package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;

/* compiled from: SpecialTypes.kt */
public final class a extends i {
    private final ad eIE;
    private final ad eUr;

    public a(ad adVar, ad adVar2) {
        h.e(adVar, "delegate");
        h.e(adVar2, "abbreviation");
        this.eIE = adVar;
        this.eUr = adVar2;
    }

    protected ad bhi() {
        return this.eIE;
    }

    public final ad byI() {
        return this.eUr;
    }

    public final ad bdO() {
        return bhi();
    }

    /* renamed from: k */
    public a h(g gVar) {
        h.e(gVar, "newAnnotations");
        return new a(bhi().h(gVar), this.eUr);
    }

    /* renamed from: hf */
    public a gQ(boolean z) {
        return new a(bhi().gQ(z), this.eUr.gQ(z));
    }
}
