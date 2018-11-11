package kotlin.reflect.jvm.internal.impl.utils;

import com.google.firebase.analytics.FirebaseAnalytics.b;
import kotlin.jvm.internal.h;

/* compiled from: numbers.kt */
public final class g {
    public static final f nc(String str) {
        h.e(str, b.VALUE);
        if (u.a(str, "0x", false, 2, null) || u.a(str, "0X", false, 2, null)) {
            str = str.substring(2);
            h.d(str, "(this as java.lang.String).substring(startIndex)");
            return new f(str, 16);
        } else if (!u.a(str, "0b", false, 2, null) && !u.a(str, "0B", false, 2, null)) {
            return new f(str, 10);
        } else {
            str = str.substring(2);
            h.d(str, "(this as java.lang.String).substring(startIndex)");
            return new f(str, 2);
        }
    }
}
