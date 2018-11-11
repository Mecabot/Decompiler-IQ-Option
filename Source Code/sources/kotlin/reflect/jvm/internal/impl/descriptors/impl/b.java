package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.descriptors.ai;
import kotlin.reflect.jvm.internal.impl.descriptors.al;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.storage.h;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* compiled from: AbstractLazyTypeParameterDescriptor */
public abstract class b extends e {
    public b(h hVar, k kVar, f fVar, Variance variance, boolean z, int i, ai aiVar, al alVar) {
        super(hVar, kVar, g.eBF.bel(), fVar, variance, z, i, aiVar, alVar);
    }

    public String toString() {
        String str;
        String str2 = "%s%s%s";
        Object[] objArr = new Object[3];
        objArr[0] = bde() ? "reified " : "";
        if (bdd() == Variance.INVARIANT) {
            str = "";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(bdd());
            stringBuilder.append(" ");
            str = stringBuilder.toString();
        }
        objArr[1] = str;
        objArr[2] = bdc();
        return String.format(str2, objArr);
    }
}
