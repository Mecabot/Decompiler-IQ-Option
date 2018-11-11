package com.google.common.collect;

import com.google.common.base.e;
import com.google.common.collect.ImmutableSet.a;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Comparator;
import java.util.Map.Entry;

public class ImmutableSetMultimap<K, V> extends ImmutableMultimap<K, V> implements ac<K, V> {
    private static final long serialVersionUID = 0;
    private final transient ImmutableSet<V> Rh;
    private transient ImmutableSet<Entry<K, V>> Ri;

    private static final class EntrySet<K, V> extends ImmutableSet<Entry<K, V>> {
        private final transient ImmutableSetMultimap<K, V> Rj;

        boolean sK() {
            return false;
        }

        EntrySet(ImmutableSetMultimap<K, V> immutableSetMultimap) {
            this.Rj = immutableSetMultimap;
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            return this.Rj.m(entry.getKey(), entry.getValue());
        }

        public int size() {
            return this.Rj.size();
        }

        /* renamed from: sI */
        public aj<Entry<K, V>> iterator() {
            return this.Rj.rD();
        }
    }

    /* renamed from: ap */
    public ImmutableSet<V> aj(K k) {
        return (ImmutableSet) e.h((ImmutableSet) this.map.get(k), this.Rh);
    }

    @Deprecated
    /* renamed from: aq */
    public ImmutableSet<V> ak(Object obj) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: tu */
    public ImmutableSet<Entry<K, V>> th() {
        ImmutableSet<Entry<K, V>> immutableSet = this.Ri;
        if (immutableSet != null) {
            return immutableSet;
        }
        immutableSet = new EntrySet(this);
        this.Ri = immutableSet;
        return immutableSet;
    }

    private static <V> ImmutableSet<V> b(Comparator<? super V> comparator) {
        if (comparator == null) {
            return ImmutableSet.tq();
        }
        return ImmutableSortedSet.e(comparator);
    }

    private static <V> a<V> c(Comparator<? super V> comparator) {
        return comparator == null ? new a() : new ImmutableSortedSet.a(comparator);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(tv());
        ab.a((v) this, objectOutputStream);
    }

    Comparator<? super V> tv() {
        return this.Rh instanceof ImmutableSortedSet ? ((ImmutableSortedSet) this.Rh).comparator() : null;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        Comparator comparator = (Comparator) objectInputStream.readObject();
        int readInt = objectInputStream.readInt();
        StringBuilder stringBuilder;
        if (readInt < 0) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid key count ");
            stringBuilder.append(readInt);
            throw new InvalidObjectException(stringBuilder.toString());
        }
        ImmutableMap.a sU = ImmutableMap.sU();
        int i = 0;
        for (int i2 = 0; i2 < readInt; i2++) {
            Object readObject = objectInputStream.readObject();
            int readInt2 = objectInputStream.readInt();
            if (readInt2 <= 0) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Invalid value count ");
                stringBuilder.append(readInt2);
                throw new InvalidObjectException(stringBuilder.toString());
            }
            a c = c(comparator);
            for (int i3 = 0; i3 < readInt2; i3++) {
                c.ae(objectInputStream.readObject());
            }
            ImmutableSet tt = c.tt();
            if (tt.size() != readInt2) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Duplicate key-value pairs exist for key ");
                stringBuilder.append(readObject);
                throw new InvalidObjectException(stringBuilder.toString());
            }
            sU.r(readObject, tt);
            i += readInt2;
        }
        try {
            b.QX.set((Object) this, sU.tc());
            b.QY.set((Object) this, i);
            b.QZ.set((Object) this, b(comparator));
        } catch (Throwable e) {
            throw ((InvalidObjectException) new InvalidObjectException(e.getMessage()).initCause(e));
        }
    }
}
