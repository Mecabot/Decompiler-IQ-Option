package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.d;

/* compiled from: methodSignatureBuilding.kt */
public final class u {
    public static final u eJX = new u();

    private u() {
    }

    public final String mu(String str) {
        h.e(str, "name");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("java/lang/");
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    public final String mv(String str) {
        h.e(str, "name");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("java/util/");
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    public final String mw(String str) {
        h.e(str, "name");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("java/util/function/");
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    public final LinkedHashSet<String> c(String str, String... strArr) {
        h.e(str, "name");
        h.e(strArr, "signatures");
        return e(mu(str), (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public final LinkedHashSet<String> d(String str, String... strArr) {
        h.e(str, "name");
        h.e(strArr, "signatures");
        return e(mv(str), (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public final LinkedHashSet<String> e(String str, String... strArr) {
        h.e(str, "internalName");
        h.e(strArr, "signatures");
        Collection linkedHashSet = new LinkedHashSet();
        for (String str2 : strArr) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(".");
            stringBuilder.append(str2);
            linkedHashSet.add(stringBuilder.toString());
        }
        return (LinkedHashSet) linkedHashSet;
    }

    public final String a(d dVar, String str) {
        h.e(dVar, "classDescriptor");
        h.e(str, "jvmDescriptor");
        return be(r.C(dVar), str);
    }

    public final String be(String str, String str2) {
        h.e(str, "internalName");
        h.e(str2, "jvmDescriptor");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(".");
        stringBuilder.append(str2);
        return stringBuilder.toString();
    }

    public final String a(String str, List<String> list, String str2) {
        h.e(str, "name");
        h.e(list, "parameters");
        h.e(str2, "ret");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append('(');
        stringBuilder.append(u.a(list, "", null, null, 0, null, SignatureBuildingComponents$jvmDescriptor$1.eJY, 30, null));
        stringBuilder.append(')');
        stringBuilder.append(mx(str2));
        return stringBuilder.toString();
    }

    private final String mx(String str) {
        if (str.length() <= 1) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('L');
        stringBuilder.append(str);
        stringBuilder.append(';');
        return stringBuilder.toString();
    }

    public final String[] i(String... strArr) {
        h.e(strArr, "signatures");
        Collection arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<init>(");
            stringBuilder.append(str);
            stringBuilder.append(")V");
            arrayList.add(stringBuilder.toString());
        }
        Object[] toArray = ((List) arrayList).toArray(new String[0]);
        if (toArray != null) {
            return (String[]) toArray;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }
}
