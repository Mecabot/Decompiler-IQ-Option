package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import java.util.List;
import kotlin.jvm.internal.h;

/* compiled from: BinaryModuleData.kt */
public final class a {
    private final List<String> eBI;

    public a(List<String> list) {
        h.e(list, "annotations");
        this.eBI = list;
    }
}
