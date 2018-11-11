package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;

/* compiled from: RawType.kt */
final class RawTypeImpl$render$newArgs$1 extends Lambda implements b<String, String> {
    public static final RawTypeImpl$render$newArgs$1 eIu = new RawTypeImpl$render$newArgs$1();

    RawTypeImpl$render$newArgs$1() {
        super(1);
    }

    /* renamed from: gH */
    public final String invoke(String str) {
        h.e(str, "it");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(raw) ");
        stringBuilder.append(str);
        return stringBuilder.toString();
    }
}
