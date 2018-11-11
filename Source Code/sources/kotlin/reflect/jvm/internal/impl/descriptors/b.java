package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.ad;
import kotlin.reflect.jvm.internal.impl.types.an;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: typeParameterUtils.kt */
final class b implements an {
    private final an eAI;
    private final k eAJ;
    private final int eAK;

    public <R, D> R a(m<R, D> mVar, D d) {
        return this.eAI.a(mVar, d);
    }

    public List<w> aYq() {
        return this.eAI.aYq();
    }

    public g bbQ() {
        return this.eAI.bbQ();
    }

    public ai bbR() {
        return this.eAI.bbR();
    }

    public an bby() {
        return this.eAI.bby();
    }

    public boolean bcX() {
        return true;
    }

    public ad bdb() {
        return this.eAI.bdb();
    }

    public f bdc() {
        return this.eAI.bdc();
    }

    public Variance bdd() {
        return this.eAI.bdd();
    }

    public boolean bde() {
        return this.eAI.bde();
    }

    public b(an anVar, k kVar, int i) {
        h.e(anVar, "originalDescriptor");
        h.e(kVar, "declarationDescriptor");
        this.eAI = anVar;
        this.eAJ = kVar;
        this.eAK = i;
    }

    /* renamed from: bcY */
    public an bda() {
        return this.eAI.bcY();
    }

    public k bbv() {
        return this.eAJ;
    }

    public int getIndex() {
        return this.eAK + this.eAI.getIndex();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.eAI.toString());
        stringBuilder.append("[inner-copy]");
        return stringBuilder.toString();
    }
}
