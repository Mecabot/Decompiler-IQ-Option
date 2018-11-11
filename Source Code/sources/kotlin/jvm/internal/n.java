package kotlin.jvm.internal;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.a.a;
import kotlin.jvm.internal.a.b;
import kotlin.jvm.internal.a.f;
import kotlin.jvm.internal.a.g;

/* compiled from: TypeIntrinsics */
public class n {
    private static <T extends Throwable> T ad(T t) {
        return h.b(t, n.class.getName());
    }

    public static void f(Object obj, String str) {
        String name = obj == null ? "null" : obj.getClass().getName();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name);
        stringBuilder.append(" cannot be cast to ");
        stringBuilder.append(str);
        lU(stringBuilder.toString());
    }

    public static void lU(String str) {
        throw a(new ClassCastException(str));
    }

    public static ClassCastException a(ClassCastException classCastException) {
        throw ((ClassCastException) ad(classCastException));
    }

    public static Collection cx(Object obj) {
        if ((obj instanceof a) && !(obj instanceof b)) {
            f(obj, "kotlin.collections.MutableCollection");
        }
        return cy(obj);
    }

    public static Collection cy(Object obj) {
        try {
            return (Collection) obj;
        } catch (ClassCastException e) {
            throw a(e);
        }
    }

    public static Set cz(Object obj) {
        if ((obj instanceof a) && !(obj instanceof g)) {
            f(obj, "kotlin.collections.MutableSet");
        }
        return cA(obj);
    }

    public static Set cA(Object obj) {
        try {
            return (Set) obj;
        } catch (ClassCastException e) {
            throw a(e);
        }
    }

    public static Map cB(Object obj) {
        if ((obj instanceof a) && !(obj instanceof f)) {
            f(obj, "kotlin.collections.MutableMap");
        }
        return cC(obj);
    }

    public static Map cC(Object obj) {
        try {
            return (Map) obj;
        } catch (ClassCastException e) {
            throw a(e);
        }
    }
}
