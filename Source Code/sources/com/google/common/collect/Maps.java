package com.google.common.collect;

import com.google.common.base.f;
import com.google.common.base.i;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class Maps {

    static class c<K, V> extends AbstractCollection<V> {
        final Map<K, V> map;

        c(Map<K, V> map) {
            this.map = (Map) i.checkNotNull(map);
        }

        final Map<K, V> rG() {
            return this.map;
        }

        public Iterator<V> iterator() {
            return Maps.t(rG().entrySet().iterator());
        }

        public boolean remove(Object obj) {
            try {
                return super.remove(obj);
            } catch (UnsupportedOperationException unused) {
                for (Entry entry : rG().entrySet()) {
                    if (f.equal(obj, entry.getValue())) {
                        rG().remove(entry.getKey());
                        return true;
                    }
                }
                return false;
            }
        }

        public boolean removeAll(Collection<?> collection) {
            try {
                return super.removeAll((Collection) i.checkNotNull(collection));
            } catch (UnsupportedOperationException unused) {
                Collection uI = Sets.uI();
                for (Entry entry : rG().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        uI.add(entry.getKey());
                    }
                }
                return rG().keySet().removeAll(uI);
            }
        }

        public boolean retainAll(Collection<?> collection) {
            try {
                return super.retainAll((Collection) i.checkNotNull(collection));
            } catch (UnsupportedOperationException unused) {
                Collection uI = Sets.uI();
                for (Entry entry : rG().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        uI.add(entry.getKey());
                    }
                }
                return rG().keySet().retainAll(uI);
            }
        }

        public int size() {
            return rG().size();
        }

        public boolean isEmpty() {
            return rG().isEmpty();
        }

        public boolean contains(Object obj) {
            return rG().containsValue(obj);
        }

        public void clear() {
            rG().clear();
        }
    }

    static abstract class d<K, V> extends AbstractMap<K, V> {
        private transient Set<K> Os;
        private transient Collection<V> Ot;
        private transient Set<Entry<K, V>> Ou;

        abstract Set<Entry<K, V>> rF();

        d() {
        }

        public Set<Entry<K, V>> entrySet() {
            Set<Entry<K, V>> set = this.Ou;
            if (set != null) {
                return set;
            }
            set = rF();
            this.Ou = set;
            return set;
        }

        public Set<K> keySet() {
            Set<K> set = this.Os;
            if (set != null) {
                return set;
            }
            set = rB();
            this.Os = set;
            return set;
        }

        Set<K> rB() {
            return new b(this);
        }

        public Collection<V> values() {
            Collection<V> collection = this.Ot;
            if (collection != null) {
                return collection;
            }
            collection = uu();
            this.Ot = collection;
            return collection;
        }

        Collection<V> uu() {
            return new c(this);
        }
    }

    /* renamed from: com.google.common.collect.Maps$1 */
    static class AnonymousClass1 extends ah<K, Entry<K, V>> {
        final /* synthetic */ com.google.common.base.d Rs;

        /* renamed from: ay */
        Entry<K, V> ax(K k) {
            return Maps.x(k, this.Rs.apply(k));
        }
    }

    private enum EntryFunction implements com.google.common.base.d<Entry<?, ?>, Object> {
        KEY {
            public Object apply(Entry<?, ?> entry) {
                return entry.getKey();
            }
        },
        VALUE {
            public Object apply(Entry<?, ?> entry) {
                return entry.getValue();
            }
        }
    }

    static abstract class a<K, V> extends a<Entry<K, V>> {
        abstract Map<K, V> rG();

        a() {
        }

        public int size() {
            return rG().size();
        }

        public void clear() {
            rG().clear();
        }

        public boolean contains(Object obj) {
            boolean z = false;
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            Object key = entry.getKey();
            Object a = Maps.a(rG(), key);
            if (f.equal(a, entry.getValue()) && (a != null || rG().containsKey(key))) {
                z = true;
            }
            return z;
        }

        public boolean isEmpty() {
            return rG().isEmpty();
        }

        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            return rG().keySet().remove(((Entry) obj).getKey());
        }

        public boolean removeAll(Collection<?> collection) {
            try {
                return super.removeAll((Collection) i.checkNotNull(collection));
            } catch (UnsupportedOperationException unused) {
                return Sets.a((Set) this, collection.iterator());
            }
        }

        public boolean retainAll(Collection<?> collection) {
            try {
                return super.retainAll((Collection) i.checkNotNull(collection));
            } catch (UnsupportedOperationException unused) {
                Collection bu = Sets.bu(collection.size());
                for (Object next : collection) {
                    if (contains(next)) {
                        bu.add(((Entry) next).getKey());
                    }
                }
                return rG().keySet().retainAll(bu);
            }
        }
    }

    static class b<K, V> extends a<K> {
        final Map<K, V> map;

        b(Map<K, V> map) {
            this.map = (Map) i.checkNotNull(map);
        }

        Map<K, V> rG() {
            return this.map;
        }

        public Iterator<K> iterator() {
            return Maps.s(rG().entrySet().iterator());
        }

        public int size() {
            return rG().size();
        }

        public boolean isEmpty() {
            return rG().isEmpty();
        }

        public boolean contains(Object obj) {
            return rG().containsKey(obj);
        }

        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            rG().remove(obj);
            return true;
        }

        public void clear() {
            rG().clear();
        }
    }

    static <K> com.google.common.base.d<Entry<K, ?>, K> uq() {
        return EntryFunction.KEY;
    }

    static <V> com.google.common.base.d<Entry<?, V>, V> ur() {
        return EntryFunction.VALUE;
    }

    static <K, V> Iterator<K> s(Iterator<Entry<K, V>> it) {
        return Iterators.a((Iterator) it, uq());
    }

    static <K, V> Iterator<V> t(Iterator<Entry<K, V>> it) {
        return Iterators.a((Iterator) it, ur());
    }

    public static <K, V> HashMap<K, V> us() {
        return new HashMap();
    }

    public static <K, V> HashMap<K, V> bf(int i) {
        return new HashMap(bg(i));
    }

    static int bg(int i) {
        if (i >= 3) {
            return i < 1073741824 ? (int) ((((float) i) / 0.75f) + 1.0f) : ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        } else {
            g.b(i, "expectedSize");
            return i + 1;
        }
    }

    public static <K, V> LinkedHashMap<K, V> bh(int i) {
        return new LinkedHashMap(bg(i));
    }

    public static <K, V> ConcurrentMap<K, V> ut() {
        return new ConcurrentHashMap();
    }

    public static <K, V> ImmutableMap<K, V> b(Iterable<V> iterable, com.google.common.base.d<? super V, K> dVar) {
        return b(iterable.iterator(), (com.google.common.base.d) dVar);
    }

    public static <K, V> ImmutableMap<K, V> b(Iterator<V> it, com.google.common.base.d<? super V, K> dVar) {
        i.checkNotNull(dVar);
        com.google.common.collect.ImmutableMap.a sU = ImmutableMap.sU();
        while (it.hasNext()) {
            Object next = it.next();
            sU.r(dVar.apply(next), next);
        }
        try {
            return sU.tc();
        } catch (IllegalArgumentException e) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(e.getMessage());
            stringBuilder.append(". To index multiple values under a key, use Multimaps.index.");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    public static <K, V> Entry<K, V> x(K k, V v) {
        return new ImmutableEntry(k, v);
    }

    static <K, V> Entry<K, V> d(final Entry<? extends K, ? extends V> entry) {
        i.checkNotNull(entry);
        return new b<K, V>() {
            public K getKey() {
                return entry.getKey();
            }

            public V getValue() {
                return entry.getValue();
            }
        };
    }

    /* JADX WARNING: Removed duplicated region for block: B:4:0x0008 A:{Splitter: B:1:0x0003, ExcHandler: java.lang.ClassCastException (unused java.lang.ClassCastException)} */
    /* JADX WARNING: Missing block: B:5:0x0009, code:
            return null;
     */
    static <V> V a(java.util.Map<?, V> r0, java.lang.Object r1) {
        /*
        com.google.common.base.i.checkNotNull(r0);
        r0 = r0.get(r1);	 Catch:{ ClassCastException -> 0x0008, ClassCastException -> 0x0008 }
        return r0;
    L_0x0008:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.Maps.a(java.util.Map, java.lang.Object):V");
    }

    /* JADX WARNING: Removed duplicated region for block: B:4:0x0008 A:{Splitter: B:1:0x0003, ExcHandler: java.lang.ClassCastException (unused java.lang.ClassCastException)} */
    /* JADX WARNING: Missing block: B:5:0x0009, code:
            return false;
     */
    static boolean b(java.util.Map<?, ?> r0, java.lang.Object r1) {
        /*
        com.google.common.base.i.checkNotNull(r0);
        r0 = r0.containsKey(r1);	 Catch:{ ClassCastException -> 0x0008, ClassCastException -> 0x0008 }
        return r0;
    L_0x0008:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.Maps.b(java.util.Map, java.lang.Object):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:4:0x0008 A:{Splitter: B:1:0x0003, ExcHandler: java.lang.ClassCastException (unused java.lang.ClassCastException)} */
    /* JADX WARNING: Missing block: B:5:0x0009, code:
            return null;
     */
    static <V> V c(java.util.Map<?, V> r0, java.lang.Object r1) {
        /*
        com.google.common.base.i.checkNotNull(r0);
        r0 = r0.remove(r1);	 Catch:{ ClassCastException -> 0x0008, ClassCastException -> 0x0008 }
        return r0;
    L_0x0008:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.Maps.c(java.util.Map, java.lang.Object):V");
    }

    static <K, V> boolean c(Collection<Entry<K, V>> collection, Object obj) {
        if (obj instanceof Entry) {
            return collection.contains(d((Entry) obj));
        }
        return false;
    }

    static <K, V> boolean d(Collection<Entry<K, V>> collection, Object obj) {
        if (obj instanceof Entry) {
            return collection.remove(d((Entry) obj));
        }
        return false;
    }

    static boolean d(Map<?, ?> map, Object obj) {
        if (map == obj) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        return map.entrySet().equals(((Map) obj).entrySet());
    }

    static String q(Map<?, ?> map) {
        StringBuilder aL = h.aL(map.size());
        aL.append('{');
        Object obj = 1;
        for (Entry entry : map.entrySet()) {
            if (obj == null) {
                aL.append(", ");
            }
            obj = null;
            aL.append(entry.getKey());
            aL.append('=');
            aL.append(entry.getValue());
        }
        aL.append('}');
        return aL.toString();
    }

    static <K> K e(Entry<K, ?> entry) {
        return entry == null ? null : entry.getKey();
    }

    static <E> ImmutableMap<E, Integer> p(Collection<E> collection) {
        com.google.common.collect.ImmutableMap.a aVar = new com.google.common.collect.ImmutableMap.a(collection.size());
        int i = 0;
        for (E r : collection) {
            int i2 = i + 1;
            aVar.r(r, Integer.valueOf(i));
            i = i2;
        }
        return aVar.tc();
    }
}
