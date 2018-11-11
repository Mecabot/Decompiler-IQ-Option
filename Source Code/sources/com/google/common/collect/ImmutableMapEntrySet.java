package com.google.common.collect;

import java.io.Serializable;
import java.util.Map.Entry;

abstract class ImmutableMapEntrySet<K, V> extends ImmutableSet<Entry<K, V>> {

    private static class EntrySetSerializedForm<K, V> implements Serializable {
        private static final long serialVersionUID = 0;
        final ImmutableMap<K, V> map;

        EntrySetSerializedForm(ImmutableMap<K, V> immutableMap) {
            this.map = immutableMap;
        }

        Object readResolve() {
            return this.map.entrySet();
        }
    }

    abstract ImmutableMap<K, V> te();

    ImmutableMapEntrySet() {
    }

    public int size() {
        return te().size();
    }

    public boolean contains(Object obj) {
        boolean z = false;
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        Object obj2 = te().get(entry.getKey());
        if (obj2 != null && obj2.equals(entry.getValue())) {
            z = true;
        }
        return z;
    }

    boolean sK() {
        return te().sK();
    }

    boolean tb() {
        return te().tb();
    }

    public int hashCode() {
        return te().hashCode();
    }

    Object writeReplace() {
        return new EntrySetSerializedForm(te());
    }
}
