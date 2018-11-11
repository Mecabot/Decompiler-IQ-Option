package kotlin.reflect.jvm.internal.impl.name;

import kotlin.TypeCastException;
import kotlin.jvm.internal.h;

/* compiled from: FqNamesUtil.kt */
public final class d {
    public static final boolean a(b bVar, b bVar2) {
        h.e(bVar, "$receiver");
        h.e(bVar2, "packageName");
        if (h.E(bVar, bVar2) || bVar2.isRoot()) {
            return true;
        }
        String asString = bVar.asString();
        h.d(asString, "this.asString()");
        String asString2 = bVar2.asString();
        h.d(asString2, "packageName.asString()");
        return bi(asString, asString2);
    }

    private static final boolean bi(String str, String str2) {
        return u.a(str, str2, false, 2, null) && str.charAt(str2.length()) == '.';
    }

    public static final b b(b bVar, b bVar2) {
        h.e(bVar, "$receiver");
        h.e(bVar2, "prefix");
        if (!a(bVar, bVar2) || bVar2.isRoot()) {
            return bVar;
        }
        if (h.E(bVar, bVar2)) {
            bVar = b.eNc;
            h.d(bVar, "FqName.ROOT");
            return bVar;
        }
        String asString = bVar.asString();
        h.d(asString, "asString()");
        int length = bVar2.asString().length() + 1;
        if (asString == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        asString = asString.substring(length);
        h.d(asString, "(this as java.lang.String).substring(startIndex)");
        return new b(asString);
    }

    public static final boolean mC(String str) {
        boolean z = false;
        if (str == null) {
            return false;
        }
        State state = State.BEGINNING;
        int length = str.length();
        State state2 = state;
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            switch (e.aoS[state2.ordinal()]) {
                case 1:
                case 2:
                    if (Character.isJavaIdentifierPart(charAt)) {
                        state2 = State.MIDDLE;
                        break;
                    }
                    return false;
                case 3:
                    if (charAt != '.') {
                        if (Character.isJavaIdentifierPart(charAt)) {
                            break;
                        }
                        return false;
                    }
                    state2 = State.AFTER_DOT;
                    break;
                default:
                    break;
            }
        }
        if (state2 != State.AFTER_DOT) {
            z = true;
        }
        return z;
    }
}
