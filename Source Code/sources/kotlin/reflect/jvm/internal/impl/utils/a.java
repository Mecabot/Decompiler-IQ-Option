package kotlin.reflect.jvm.internal.impl.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.h;

/* compiled from: collections.kt */
public final class a {
    public static final <K> Map<K, Integer> ah(Iterable<? extends K> iterable) {
        h.e(iterable, "$receiver");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i = 0;
        for (Object put : iterable) {
            linkedHashMap.put(put, Integer.valueOf(i));
            i++;
        }
        return linkedHashMap;
    }

    public static final <T> void j(Collection<T> collection, T t) {
        h.e(collection, "$receiver");
        if (t != null) {
            collection.add(t);
        }
    }

    public static final <K, V> HashMap<K, V> bf(int i) {
        return new HashMap(bg(i));
    }

    public static final <E> HashSet<E> bu(int i) {
        return new HashSet(bg(i));
    }

    public static final <E> LinkedHashSet<E> mc(int i) {
        return new LinkedHashSet(bg(i));
    }

    private static final int bg(int i) {
        return i < 3 ? 3 : (i + (i / 3)) + 1;
    }

    public static final <T> List<T> j(ArrayList<T> arrayList) {
        h.e(arrayList, "$receiver");
        switch (arrayList.size()) {
            case 0:
                return m.emptyList();
            case 1:
                return l.cr(u.bU(arrayList));
            default:
                arrayList.trimToSize();
                return arrayList;
        }
    }
}
