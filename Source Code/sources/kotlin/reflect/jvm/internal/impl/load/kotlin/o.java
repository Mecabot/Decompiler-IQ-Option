package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.reflect.jvm.internal.impl.descriptors.ai;
import kotlin.reflect.jvm.internal.impl.descriptors.aj;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.h;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.b;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.g;

/* compiled from: KotlinJvmBinaryPackageSourceElement.kt */
public final class o implements ai {
    private final h eHp;

    public o(h hVar) {
        kotlin.jvm.internal.h.e(hVar, "packageFragment");
        this.eHp = hVar;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.eHp);
        stringBuilder.append(": ");
        stringBuilder.append(this.eHp.bgL().keySet());
        return stringBuilder.toString();
    }

    public aj ban() {
        aj ajVar = aj.eAY;
        kotlin.jvm.internal.h.d(ajVar, "SourceFile.NO_SOURCE_FILE");
        return ajVar;
    }

    public final n b(g gVar) {
        kotlin.jvm.internal.h.e(gVar, "descriptor");
        b a = kotlin.reflect.jvm.internal.impl.load.java.descriptors.h.a(gVar);
        return a != null ? (n) this.eHp.bgL().get(a.getInternalName()) : null;
    }
}
