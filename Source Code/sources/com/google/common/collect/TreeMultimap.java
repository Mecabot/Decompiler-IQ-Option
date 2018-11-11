package com.google.common.collect;

import com.google.common.base.i;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Comparator;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class TreeMultimap<K, V> extends AbstractSortedKeySortedSetMultimap<K, V> {
    private static final long serialVersionUID = 0;
    private transient Comparator<? super V> QS;
    private transient Comparator<? super K> QW;

    public static <K extends Comparable, V extends Comparable> TreeMultimap<K, V> uQ() {
        return new TreeMultimap(Ordering.natural(), Ordering.natural());
    }

    TreeMultimap(Comparator<? super K> comparator, Comparator<? super V> comparator2) {
        super(new TreeMap(comparator));
        this.QW = comparator;
        this.QS = comparator2;
    }

    /* renamed from: so */
    SortedSet<V> sj() {
        return new TreeSet(this.QS);
    }

    Collection<V> T(K k) {
        if (k == null) {
            uR().compare(k, k);
        }
        return super.T(k);
    }

    @Deprecated
    public Comparator<? super K> uR() {
        return this.QW;
    }

    public Comparator<? super V> tv() {
        return this.QS;
    }

    /* renamed from: aC */
    public NavigableSet<V> Z(K k) {
        return (NavigableSet) super.X(k);
    }

    /* renamed from: keySet */
    public NavigableSet<K> rK() {
        return (NavigableSet) super.keySet();
    }

    /* renamed from: uS */
    public NavigableMap<K, Collection<V>> sm() {
        return (NavigableMap) super.asMap();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(uR());
        objectOutputStream.writeObject(tv());
        ab.a((v) this, objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.QW = (Comparator) i.checkNotNull((Comparator) objectInputStream.readObject());
        this.QS = (Comparator) i.checkNotNull((Comparator) objectInputStream.readObject());
        m(new TreeMap(this.QW));
        ab.a((v) this, objectInputStream);
    }
}
