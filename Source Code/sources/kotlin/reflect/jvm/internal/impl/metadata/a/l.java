package kotlin.reflect.jvm.internal.impl.metadata.a;

import kotlin.jvm.internal.h;

/* compiled from: versionSpecificBehavior.kt */
public final class l {
    public static final boolean a(a aVar) {
        h.e(aVar, "version");
        return b(aVar);
    }

    private static final boolean b(a aVar) {
        return aVar.getMajor() == 1 && aVar.getMinor() >= 4;
    }
}
