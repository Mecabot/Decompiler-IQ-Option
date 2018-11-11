package kotlin.reflect.jvm.internal.impl.name;

import kotlin.jvm.internal.h;
import kotlin.text.Regex;

/* compiled from: NameUtils.kt */
public final class g {
    private static final Regex eNm = new Regex("[^\\p{L}\\p{Digit}]");
    public static final g eNn = new g();

    private g() {
    }

    public static final String mH(String str) {
        h.e(str, "name");
        return eNm.c(str, "_");
    }
}
