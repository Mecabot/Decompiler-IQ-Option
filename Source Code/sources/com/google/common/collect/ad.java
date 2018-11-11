package com.google.common.collect;

import java.util.Comparator;

/* compiled from: SortedIterable */
interface ad<T> extends Iterable<T> {
    Comparator<? super T> comparator();
}
