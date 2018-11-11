package com.google.common.cache;

import com.google.common.base.i;
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.s;

public abstract class CacheLoader<K, V> {

    public static final class InvalidCacheLoadException extends RuntimeException {
        public InvalidCacheLoadException(String str) {
            super(str);
        }
    }

    public abstract V K(K k);

    protected CacheLoader() {
    }

    public s<V> i(K k, V v) {
        i.checkNotNull(k);
        i.checkNotNull(v);
        return o.aR(K(k));
    }
}
