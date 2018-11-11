package com.google.common.collect;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Map.Entry;

public class ImmutableListMultimap<K, V> extends ImmutableMultimap<K, V> implements t<K, V> {
    private static final long serialVersionUID = 0;

    public static final class a<K, V> extends com.google.common.collect.ImmutableMultimap.a<K, V> {
        /* renamed from: p */
        public a<K, V> q(K k, V v) {
            super.q(k, v);
            return this;
        }

        /* renamed from: sR */
        public ImmutableListMultimap<K, V> sS() {
            return (ImmutableListMultimap) super.sS();
        }
    }

    public static <K, V> ImmutableListMultimap<K, V> sQ() {
        return EmptyImmutableListMultimap.QD;
    }

    public static <K, V> ImmutableListMultimap<K, V> c(v<? extends K, ? extends V> vVar) {
        if (vVar.isEmpty()) {
            return sQ();
        }
        if (vVar instanceof ImmutableListMultimap) {
            ImmutableListMultimap<K, V> immutableListMultimap = (ImmutableListMultimap) vVar;
            if (!immutableListMultimap.sK()) {
                return immutableListMultimap;
            }
        }
        com.google.common.collect.ImmutableMap.a aVar = new com.google.common.collect.ImmutableMap.a(vVar.asMap().size());
        int i = 0;
        for (Entry entry : vVar.asMap().entrySet()) {
            ImmutableList m = ImmutableList.m((Collection) entry.getValue());
            if (!m.isEmpty()) {
                aVar.r(entry.getKey(), m);
                i += m.size();
            }
        }
        return new ImmutableListMultimap(aVar.tc(), i);
    }

    ImmutableListMultimap(ImmutableMap<K, ImmutableList<V>> immutableMap, int i) {
        super(immutableMap, i);
    }

    /* renamed from: ah */
    public ImmutableList<V> aj(K k) {
        ImmutableList<V> immutableList = (ImmutableList) this.map.get(k);
        return immutableList == null ? ImmutableList.sL() : immutableList;
    }

    @Deprecated
    /* renamed from: ai */
    public ImmutableList<V> ak(Object obj) {
        throw new UnsupportedOperationException();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        ab.a((v) this, objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        if (readInt < 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid key count ");
            stringBuilder.append(readInt);
            throw new InvalidObjectException(stringBuilder.toString());
        }
        com.google.common.collect.ImmutableMap.a sU = ImmutableMap.sU();
        int i = 0;
        for (int i2 = 0; i2 < readInt; i2++) {
            Object readObject = objectInputStream.readObject();
            int readInt2 = objectInputStream.readInt();
            if (readInt2 <= 0) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Invalid value count ");
                stringBuilder2.append(readInt2);
                throw new InvalidObjectException(stringBuilder2.toString());
            }
            com.google.common.collect.ImmutableList.a sO = ImmutableList.sO();
            for (int i3 = 0; i3 < readInt2; i3++) {
                sO.ae(objectInputStream.readObject());
            }
            sU.r(readObject, sO.sP());
            i += readInt2;
        }
        try {
            b.QX.set((Object) this, sU.tc());
            b.QY.set((Object) this, i);
        } catch (Throwable e) {
            throw ((InvalidObjectException) new InvalidObjectException(e.getMessage()).initCause(e));
        }
    }
}
