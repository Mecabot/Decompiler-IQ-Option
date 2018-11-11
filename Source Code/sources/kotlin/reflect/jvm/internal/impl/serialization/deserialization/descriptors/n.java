package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.List;
import kotlin.jvm.a.a;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.c;
import kotlin.reflect.jvm.internal.impl.storage.h;

/* compiled from: DeserializedAnnotations.kt */
public final class n extends a {
    public boolean isEmpty() {
        return false;
    }

    public n(h hVar, a<? extends List<? extends c>> aVar) {
        kotlin.jvm.internal.h.e(hVar, "storageManager");
        kotlin.jvm.internal.h.e(aVar, "compute");
        super(hVar, aVar);
    }
}
