package com.google.common.collect;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;

final class LexicographicalOrdering<T> extends Ordering<Iterable<T>> implements Serializable {
    private static final long serialVersionUID = 0;
    final Comparator<? super T> elementOrder;

    LexicographicalOrdering(Comparator<? super T> comparator) {
        this.elementOrder = comparator;
    }

    /* renamed from: c */
    public int compare(Iterable<T> iterable, Iterable<T> iterable2) {
        Iterator it = iterable2.iterator();
        for (T compare : iterable) {
            if (!it.hasNext()) {
                return 1;
            }
            int compare2 = this.elementOrder.compare(compare, it.next());
            if (compare2 != 0) {
                return compare2;
            }
        }
        return it.hasNext() ? -1 : 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LexicographicalOrdering)) {
            return false;
        }
        return this.elementOrder.equals(((LexicographicalOrdering) obj).elementOrder);
    }

    public int hashCode() {
        return this.elementOrder.hashCode() ^ 2075626741;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.elementOrder);
        stringBuilder.append(".lexicographical()");
        return stringBuilder.toString();
    }
}
