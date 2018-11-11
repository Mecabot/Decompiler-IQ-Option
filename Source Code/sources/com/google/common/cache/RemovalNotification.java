package com.google.common.cache;

import com.google.common.base.i;
import java.util.AbstractMap.SimpleImmutableEntry;

public final class RemovalNotification<K, V> extends SimpleImmutableEntry<K, V> {
    private static final long serialVersionUID = 0;
    private final RemovalCause cause;

    public static <K, V> RemovalNotification<K, V> a(K k, V v, RemovalCause removalCause) {
        return new RemovalNotification(k, v, removalCause);
    }

    private RemovalNotification(K k, V v, RemovalCause removalCause) {
        super(k, v);
        this.cause = (RemovalCause) i.checkNotNull(removalCause);
    }
}
