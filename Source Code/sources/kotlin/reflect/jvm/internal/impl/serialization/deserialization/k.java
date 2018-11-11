package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.w;
import kotlin.reflect.jvm.internal.impl.name.f;

/* compiled from: DeserializedPackageFragment.kt */
public abstract class k extends w {
    public boolean N(f fVar) {
        h.e(fVar, "name");
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h bbk = bbk();
        return (bbk instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.h) && ((kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.h) bbk).byv().contains(fVar);
    }
}
