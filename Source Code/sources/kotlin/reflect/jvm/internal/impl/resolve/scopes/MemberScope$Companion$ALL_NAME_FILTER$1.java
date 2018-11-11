package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.name.f;

/* compiled from: MemberScope.kt */
final class MemberScope$Companion$ALL_NAME_FILTER$1 extends Lambda implements b<f, Boolean> {
    public static final MemberScope$Companion$ALL_NAME_FILTER$1 eSl = new MemberScope$Companion$ALL_NAME_FILTER$1();

    MemberScope$Companion$ALL_NAME_FILTER$1() {
        super(1);
    }

    public final boolean M(f fVar) {
        h.e(fVar, "it");
        return true;
    }

    public /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(M((f) obj));
    }
}
