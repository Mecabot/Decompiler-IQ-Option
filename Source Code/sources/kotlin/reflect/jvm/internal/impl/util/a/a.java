package kotlin.reflect.jvm.internal.impl.util.a;

import java.util.Collection;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.h;

/* compiled from: scopeUtils.kt */
public final class a {
    public static final <T> Collection<T> d(Collection<? extends T> collection, Collection<? extends T> collection2) {
        h.e(collection2, "collection");
        if (collection2.isEmpty()) {
            return collection;
        }
        if (collection == null) {
            return collection2;
        }
        if (collection instanceof LinkedHashSet) {
            ((LinkedHashSet) collection).addAll(collection2);
            return collection;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(collection);
        linkedHashSet.addAll(collection2);
        return linkedHashSet;
    }
}
