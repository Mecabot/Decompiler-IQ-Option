package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.h;
import kotlin.m;
import kotlin.reflect.jvm.internal.impl.name.a;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.d;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.e;

/* compiled from: JavaClassDataFinder.kt */
public final class f implements e {
    private final m eGy;
    private final e eGz;

    public f(m mVar, e eVar) {
        h.e(mVar, "kotlinClassFinder");
        h.e(eVar, "deserializedDescriptorResolver");
        this.eGy = mVar;
        this.eGz = eVar;
    }

    public d i(a aVar) {
        h.e(aVar, "classId");
        n b = this.eGy.b(aVar);
        if (b == null) {
            return null;
        }
        boolean E = h.E(b.getClassId(), aVar);
        if (!m.etY || E) {
            return this.eGz.f(b);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Class with incorrect id found: expected ");
        stringBuilder.append(aVar);
        stringBuilder.append(", actual ");
        stringBuilder.append(b.getClassId());
        throw new AssertionError(stringBuilder.toString());
    }
}
