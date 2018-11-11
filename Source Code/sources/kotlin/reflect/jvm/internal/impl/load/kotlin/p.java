package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.aj;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.g;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.f;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.n;

/* compiled from: KotlinJvmBinarySourceElement.kt */
public final class p implements f {
    private final n<g> eJO;
    private final boolean eJP;
    private final n eJV;

    public p(n nVar, n<g> nVar2, boolean z) {
        h.e(nVar, "binaryClass");
        this.eJV = nVar;
        this.eJO = nVar2;
        this.eJP = z;
    }

    public final n biC() {
        return this.eJV;
    }

    public aj ban() {
        aj ajVar = aj.eAY;
        h.d(ajVar, "SourceFile.NO_SOURCE_FILE");
        return ajVar;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getSimpleName());
        stringBuilder.append(": ");
        stringBuilder.append(this.eJV);
        return stringBuilder.toString();
    }
}
