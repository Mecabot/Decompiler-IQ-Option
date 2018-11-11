package com.google.common.collect;

import com.google.common.base.f;
import java.util.Map.Entry;

/* compiled from: AbstractMapEntry */
abstract class b<K, V> implements Entry<K, V> {
    public abstract K getKey();

    public abstract V getValue();

    b() {
    }

    public V setValue(V v) {
        throw new UnsupportedOperationException();
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        if (f.equal(getKey(), entry.getKey()) && f.equal(getValue(), entry.getValue())) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        int i;
        Object key = getKey();
        Object value = getValue();
        int i2 = 0;
        if (key == null) {
            i = 0;
        } else {
            i = key.hashCode();
        }
        if (value != null) {
            i2 = value.hashCode();
        }
        return i ^ i2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getKey());
        stringBuilder.append("=");
        stringBuilder.append(getValue());
        return stringBuilder.toString();
    }
}
