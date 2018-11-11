package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.List;
import kotlin.jvm.internal.h;
import kotlin.m;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize.a;

/* compiled from: propertiesConventionUtil.kt */
public final class p {
    public static final f o(f fVar) {
        h.e(fVar, "methodName");
        f a = a(fVar, "get", false, null, 12, null);
        if (a != null) {
            return a;
        }
        return a(fVar, "is", false, null, 8, null);
    }

    public static final f a(f fVar, boolean z) {
        h.e(fVar, "methodName");
        return a(fVar, "set", false, z ? "is" : null, 4, null);
    }

    public static final List<f> p(f fVar) {
        h.e(fVar, "methodName");
        return u.S(m.listOf(a(fVar, false), a(fVar, true)));
    }

    static /* bridge */ /* synthetic */ f a(f fVar, String str, boolean z, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            str2 = (String) null;
        }
        return a(fVar, str, z, str2);
    }

    private static final f a(f fVar, String str, boolean z, String str2) {
        if (fVar.btR()) {
            return null;
        }
        String identifier = fVar.getIdentifier();
        h.d(identifier, "identifier");
        if (!u.a(identifier, str, false, 2, null) || identifier.length() == str.length()) {
            return null;
        }
        char charAt = identifier.charAt(str.length());
        if ('a' <= charAt && 'z' >= charAt) {
            return null;
        }
        if (str2 != null) {
            if (!m.etY || z) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str2);
                stringBuilder.append(v.a(identifier, (CharSequence) str));
                return f.mD(stringBuilder.toString());
            }
            throw new AssertionError("Assertion failed");
        } else if (!z) {
            return fVar;
        } else {
            String A = a.A(v.a(identifier, (CharSequence) str), true);
            if (f.mE(A)) {
                return f.mD(A);
            }
            return null;
        }
    }

    public static final List<f> q(f fVar) {
        h.e(fVar, "name");
        String asString = fVar.asString();
        if (l.mk(asString)) {
            return m.cs(o(fVar));
        }
        if (l.ml(asString)) {
            return p(fVar);
        }
        return c.eEZ.n(fVar);
    }
}
