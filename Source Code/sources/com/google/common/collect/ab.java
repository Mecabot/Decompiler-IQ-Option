package com.google.common.collect;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map.Entry;

/* compiled from: Serialization */
final class ab {

    /* compiled from: Serialization */
    static final class a<T> {
        private final Field field;

        private a(Field field) {
            this.field = field;
            field.setAccessible(true);
        }

        void set(T t, Object obj) {
            try {
                this.field.set(t, obj);
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            }
        }

        void set(T t, int i) {
            try {
                this.field.set(t, Integer.valueOf(i));
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            }
        }
    }

    static int c(ObjectInputStream objectInputStream) {
        return objectInputStream.readInt();
    }

    static <E> void a(w<E> wVar, ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeInt(wVar.entrySet().size());
        for (com.google.common.collect.w.a aVar : wVar.entrySet()) {
            objectOutputStream.writeObject(aVar.getElement());
            objectOutputStream.writeInt(aVar.getCount());
        }
    }

    static <E> void a(w<E> wVar, ObjectInputStream objectInputStream, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            wVar.d(objectInputStream.readObject(), objectInputStream.readInt());
        }
    }

    static <K, V> void a(v<K, V> vVar, ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeInt(vVar.asMap().size());
        for (Entry entry : vVar.asMap().entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeInt(((Collection) entry.getValue()).size());
            for (Object writeObject : (Collection) entry.getValue()) {
                objectOutputStream.writeObject(writeObject);
            }
        }
    }

    static <K, V> void a(v<K, V> vVar, ObjectInputStream objectInputStream) {
        a((v) vVar, objectInputStream, objectInputStream.readInt());
    }

    static <K, V> void a(v<K, V> vVar, ObjectInputStream objectInputStream, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            Collection R = vVar.R(objectInputStream.readObject());
            int readInt = objectInputStream.readInt();
            for (int i3 = 0; i3 < readInt; i3++) {
                R.add(objectInputStream.readObject());
            }
        }
    }

    static <T> a<T> c(Class<T> cls, String str) {
        try {
            return new a(cls.getDeclaredField(str));
        } catch (NoSuchFieldException e) {
            throw new AssertionError(e);
        }
    }
}
