package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.metadata.a.c;
import kotlin.reflect.jvm.internal.impl.name.a;
import kotlin.reflect.jvm.internal.impl.name.f;

/* compiled from: NameResolverUtil.kt */
public final class q {
    public static final a a(c cVar, int i) {
        h.e(cVar, "$receiver");
        a y = a.y(cVar.le(i), cVar.lf(i));
        h.d(y, "ClassId.fromString(getQu… isLocalClassName(index))");
        return y;
    }

    public static final f b(c cVar, int i) {
        h.e(cVar, "$receiver");
        f mG = f.mG(cVar.getString(i));
        h.d(mG, "Name.guessByFirstCharacter(getString(index))");
        return mG;
    }
}
