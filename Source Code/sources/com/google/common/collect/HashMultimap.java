package com.google.common.collect;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Set;

public final class HashMultimap<K, V> extends HashMultimapGwtSerializationDependencies<K, V> {
    private static final long serialVersionUID = 0;
    transient int expectedValuesPerKey = 2;

    public static <K, V> HashMultimap<K, V> sG() {
        return new HashMultimap();
    }

    public static <K, V> HashMultimap<K, V> b(v<? extends K, ? extends V> vVar) {
        return new HashMultimap(vVar);
    }

    private HashMultimap() {
        super(new HashMap());
    }

    private HashMultimap(v<? extends K, ? extends V> vVar) {
        super(Maps.bf(vVar.keySet().size()));
        a(vVar);
    }

    /* renamed from: sj */
    Set<V> ry() {
        return Sets.bu(this.expectedValuesPerKey);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        ab.a((v) this, objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.expectedValuesPerKey = 2;
        int c = ab.c(objectInputStream);
        m(Maps.us());
        ab.a((v) this, objectInputStream, c);
    }
}
