package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Collection;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.d;

/* compiled from: methodSignatureMapping.kt */
public final class w implements v<j> {
    public static final w eJZ = new w();

    public String E(d dVar) {
        h.e(dVar, "classDescriptor");
        return null;
    }

    /* renamed from: F */
    public Void D(d dVar) {
        h.e(dVar, "classDescriptor");
        return null;
    }

    public void a(kotlin.reflect.jvm.internal.impl.types.w wVar, d dVar) {
        h.e(wVar, "kotlinType");
        h.e(dVar, "descriptor");
    }

    public boolean biE() {
        return false;
    }

    private w() {
    }

    public kotlin.reflect.jvm.internal.impl.types.w R(Collection<? extends kotlin.reflect.jvm.internal.impl.types.w> collection) {
        h.e(collection, "types");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("There should be no intersection type in existing descriptors, but found: ");
        stringBuilder.append(u.a(collection, null, null, null, 0, null, null, 63, null));
        throw new AssertionError(stringBuilder.toString());
    }
}
