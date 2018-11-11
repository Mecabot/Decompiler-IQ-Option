package com.google.common.collect;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public final class HashMultiset<E> extends AbstractMapBasedMultiset<E> {
    private static final long serialVersionUID = 0;

    public static <E> HashMultiset<E> sH() {
        return new HashMultiset();
    }

    private HashMultiset() {
        super(new y());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        ab.a((w) this, objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        int c = ab.c(objectInputStream);
        a(new y());
        ab.a((w) this, objectInputStream, c);
    }
}
