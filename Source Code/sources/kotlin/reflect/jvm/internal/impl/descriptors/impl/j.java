package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.descriptors.annotations.b;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.name.f;

/* compiled from: DeclarationDescriptorImpl */
public abstract class j extends b implements k {
    private final f eBW;

    public k bcZ() {
        return this;
    }

    public j(g gVar, f fVar) {
        super(gVar);
        this.eBW = fVar;
    }

    public f bdc() {
        return this.eBW;
    }

    public String toString() {
        return m(this);
    }

    public static String m(k kVar) {
        StringBuilder stringBuilder;
        try {
            stringBuilder = new StringBuilder();
            stringBuilder.append(kotlin.reflect.jvm.internal.impl.renderer.b.ePf.s(kVar));
            stringBuilder.append("[");
            stringBuilder.append(kVar.getClass().getSimpleName());
            stringBuilder.append("@");
            stringBuilder.append(Integer.toHexString(System.identityHashCode(kVar)));
            stringBuilder.append("]");
            return stringBuilder.toString();
        } catch (Throwable unused) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(kVar.getClass().getSimpleName());
            stringBuilder.append(" ");
            stringBuilder.append(kVar.bdc());
            return stringBuilder.toString();
        }
    }
}
