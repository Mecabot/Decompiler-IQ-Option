package com.google.common.collect;

import com.google.common.base.i;
import com.google.common.base.n;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class Multimaps {

    static abstract class a<K, V> extends AbstractCollection<Entry<K, V>> {
        abstract v<K, V> sd();

        a() {
        }

        public int size() {
            return sd().size();
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            return sd().m(entry.getKey(), entry.getValue());
        }

        public boolean remove(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            return sd().remove(entry.getKey(), entry.getValue());
        }

        public void clear() {
            sd().clear();
        }
    }

    static class b<K, V> extends d<K> {
        final v<K, V> Sm;

        class a extends c<K> {
            a() {
            }

            w<K> sf() {
                return b.this;
            }

            public Iterator<com.google.common.collect.w.a<K>> iterator() {
                return b.this.rD();
            }

            public int size() {
                return b.this.rY();
            }

            public boolean isEmpty() {
                return b.this.Sm.isEmpty();
            }

            public boolean contains(Object obj) {
                boolean z = false;
                if (!(obj instanceof com.google.common.collect.w.a)) {
                    return false;
                }
                com.google.common.collect.w.a aVar = (com.google.common.collect.w.a) obj;
                Collection collection = (Collection) b.this.Sm.asMap().get(aVar.getElement());
                if (collection != null && collection.size() == aVar.getCount()) {
                    z = true;
                }
                return z;
            }

            public boolean remove(Object obj) {
                if (obj instanceof com.google.common.collect.w.a) {
                    com.google.common.collect.w.a aVar = (com.google.common.collect.w.a) obj;
                    Collection collection = (Collection) b.this.Sm.asMap().get(aVar.getElement());
                    if (collection != null && collection.size() == aVar.getCount()) {
                        collection.clear();
                        return true;
                    }
                }
                return false;
            }
        }

        b(v<K, V> vVar) {
            this.Sm = vVar;
        }

        Iterator<com.google.common.collect.w.a<K>> rD() {
            return new ah<Entry<K, Collection<V>>, com.google.common.collect.w.a<K>>(this.Sm.asMap().entrySet().iterator()) {
                /* renamed from: f */
                com.google.common.collect.w.a<K> ax(final Entry<K, Collection<V>> entry) {
                    return new a<K>() {
                        public K getElement() {
                            return entry.getKey();
                        }

                        public int getCount() {
                            return ((Collection) entry.getValue()).size();
                        }
                    };
                }
            };
        }

        int rY() {
            return this.Sm.asMap().size();
        }

        Set<com.google.common.collect.w.a<K>> rF() {
            return new a();
        }

        public boolean contains(Object obj) {
            return this.Sm.containsKey(obj);
        }

        public Iterator<K> iterator() {
            return Maps.s(this.Sm.rC().iterator());
        }

        public int count(Object obj) {
            Collection collection = (Collection) Maps.a(this.Sm.asMap(), obj);
            if (collection == null) {
                return 0;
            }
            return collection.size();
        }

        public int e(Object obj, int i) {
            g.b(i, "occurrences");
            if (i == 0) {
                return count(obj);
            }
            Collection collection = (Collection) Maps.a(this.Sm.asMap(), obj);
            int i2 = 0;
            if (collection == null) {
                return 0;
            }
            int size = collection.size();
            if (i >= size) {
                collection.clear();
            } else {
                Iterator it = collection.iterator();
                while (i2 < i) {
                    it.next();
                    it.remove();
                    i2++;
                }
            }
            return size;
        }

        public void clear() {
            this.Sm.clear();
        }

        public Set<K> se() {
            return this.Sm.keySet();
        }
    }

    private static class CustomListMultimap<K, V> extends AbstractListMultimap<K, V> {
        private static final long serialVersionUID = 0;
        transient n<? extends List<V>> Sl;

        CustomListMultimap(Map<K, Collection<V>> map, n<? extends List<V>> nVar) {
            super(map);
            this.Sl = (n) i.checkNotNull(nVar);
        }

        /* renamed from: rw */
        protected List<V> ry() {
            return (List) this.Sl.get();
        }

        private void writeObject(ObjectOutputStream objectOutputStream) {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.Sl);
            objectOutputStream.writeObject(rA());
        }

        private void readObject(ObjectInputStream objectInputStream) {
            objectInputStream.defaultReadObject();
            this.Sl = (n) objectInputStream.readObject();
            m((Map) objectInputStream.readObject());
        }
    }

    private static class CustomSetMultimap<K, V> extends AbstractSetMultimap<K, V> {
        private static final long serialVersionUID = 0;
        transient n<? extends Set<V>> Sl;

        CustomSetMultimap(Map<K, Collection<V>> map, n<? extends Set<V>> nVar) {
            super(map);
            this.Sl = (n) i.checkNotNull(nVar);
        }

        /* renamed from: sj */
        protected Set<V> ry() {
            return (Set) this.Sl.get();
        }

        private void writeObject(ObjectOutputStream objectOutputStream) {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.Sl);
            objectOutputStream.writeObject(rA());
        }

        private void readObject(ObjectInputStream objectInputStream) {
            objectInputStream.defaultReadObject();
            this.Sl = (n) objectInputStream.readObject();
            m((Map) objectInputStream.readObject());
        }
    }

    public static <K, V> t<K, V> a(Map<K, Collection<V>> map, n<? extends List<V>> nVar) {
        return new CustomListMultimap(map, nVar);
    }

    public static <K, V> ac<K, V> b(Map<K, Collection<V>> map, n<? extends Set<V>> nVar) {
        return new CustomSetMultimap(map, nVar);
    }

    public static <K, V> ac<K, V> a(ac<K, V> acVar) {
        return Synchronized.a((ac) acVar, null);
    }

    static boolean a(v<?, ?> vVar, Object obj) {
        if (obj == vVar) {
            return true;
        }
        if (!(obj instanceof v)) {
            return false;
        }
        return vVar.asMap().equals(((v) obj).asMap());
    }
}
