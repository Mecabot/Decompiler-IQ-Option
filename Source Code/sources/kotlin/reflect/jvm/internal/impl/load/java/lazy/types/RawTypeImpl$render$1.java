package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import kotlin.jvm.a.m;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;

/* compiled from: RawType.kt */
final class RawTypeImpl$render$1 extends Lambda implements m<String, String, Boolean> {
    public static final RawTypeImpl$render$1 eIs = new RawTypeImpl$render$1();

    RawTypeImpl$render$1() {
        super(2);
    }

    public /* synthetic */ Object B(Object obj, Object obj2) {
        return Boolean.valueOf(ba((String) obj, (String) obj2));
    }

    public final boolean ba(String str, String str2) {
        h.e(str, "first");
        h.e(str2, "second");
        return h.E(str, v.a(str2, (CharSequence) "out ")) || h.E(str2, "*");
    }
}
