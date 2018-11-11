package com.google.common.collect;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class ArrayListMultimap<K, V> extends ArrayListMultimapGwtSerializationDependencies<K, V> {
    private static final long serialVersionUID = 0;
    transient int expectedValuesPerKey = 3;

    public static <K, V> ArrayListMultimap<K, V> sq() {
        return new ArrayListMultimap();
    }

    private ArrayListMultimap() {
        super(new HashMap());
    }

    /* renamed from: rw */
    List<V> ry() {
        return new ArrayList(this.expectedValuesPerKey);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        ab.a((v) this, objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.expectedValuesPerKey = 3;
        int c = ab.c(objectInputStream);
        m(Maps.us());
        ab.a((v) this, objectInputStream, c);
    }
}
