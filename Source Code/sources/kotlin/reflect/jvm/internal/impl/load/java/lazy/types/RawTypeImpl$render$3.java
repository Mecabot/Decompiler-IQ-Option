package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import kotlin.jvm.a.m;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;

/* compiled from: RawType.kt */
final class RawTypeImpl$render$3 extends Lambda implements m<String, String, String> {
    public static final RawTypeImpl$render$3 eIt = new RawTypeImpl$render$3();

    RawTypeImpl$render$3() {
        super(2);
    }

    /* renamed from: bb */
    public final String B(String str, String str2) {
        h.e(str, "$receiver");
        h.e(str2, "newArgs");
        if (!v.c((CharSequence) str, '<', false, 2, null)) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(v.a(str, '<', null, 2, null));
        stringBuilder.append('<');
        stringBuilder.append(str2);
        stringBuilder.append('>');
        stringBuilder.append(v.c(str, '>', null, 2, null));
        return stringBuilder.toString();
    }
}
