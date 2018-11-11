package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* compiled from: SmallSortedMap */
class s<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private boolean eNQ;
    private final int eOI;
    private List<b> eOJ;
    private Map<K, V> eOK;
    private volatile d eOL;

    /* compiled from: SmallSortedMap */
    private static class a {
        private static final Iterator<Object> eOM = new Iterator<Object>() {
            public boolean hasNext() {
                return false;
            }

            public Object next() {
                throw new NoSuchElementException();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        private static final Iterable<Object> eON = new Iterable<Object>() {
            public Iterator<Object> iterator() {
                return a.eOM;
            }
        };

        static <T> Iterable<T> bvs() {
            return eON;
        }
    }

    /* compiled from: SmallSortedMap */
    private class b implements Comparable<b>, Entry<K, V> {
        private final K eOO;
        private V value;

        b(s sVar, Entry<K, V> entry) {
            this((Comparable) entry.getKey(), entry.getValue());
        }

        b(K k, V v) {
            this.eOO = k;
            this.value = v;
        }

        /* renamed from: bvu */
        public K getKey() {
            return this.eOO;
        }

        public V getValue() {
            return this.value;
        }

        /* renamed from: a */
        public int compareTo(b bVar) {
            return getKey().compareTo(bVar.getKey());
        }

        public V setValue(V v) {
            s.this.bvp();
            V v2 = this.value;
            this.value = v;
            return v2;
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            if (!(equals(this.eOO, entry.getKey()) && equals(this.value, entry.getValue()))) {
                z = false;
            }
            return z;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = this.eOO == null ? 0 : this.eOO.hashCode();
            if (this.value != null) {
                i = this.value.hashCode();
            }
            return hashCode ^ i;
        }

        public String toString() {
            String valueOf = String.valueOf(String.valueOf(this.eOO));
            String valueOf2 = String.valueOf(String.valueOf(this.value));
            StringBuilder stringBuilder = new StringBuilder((valueOf.length() + 1) + valueOf2.length());
            stringBuilder.append(valueOf);
            stringBuilder.append("=");
            stringBuilder.append(valueOf2);
            return stringBuilder.toString();
        }

        private boolean equals(Object obj, Object obj2) {
            if (obj == null) {
                return obj2 == null;
            } else {
                return obj.equals(obj2);
            }
        }
    }

    /* compiled from: SmallSortedMap */
    private class c implements Iterator<Entry<K, V>> {
        private boolean eOQ;
        private Iterator<Entry<K, V>> eOR;
        private int pos;

        private c() {
            this.pos = -1;
        }

        /* synthetic */ c(s sVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        public boolean hasNext() {
            return this.pos + 1 < s.this.eOJ.size() || bvv().hasNext();
        }

        public Entry<K, V> next() {
            this.eOQ = true;
            int i = this.pos + 1;
            this.pos = i;
            if (i < s.this.eOJ.size()) {
                return (Entry) s.this.eOJ.get(this.pos);
            }
            return (Entry) bvv().next();
        }

        public void remove() {
            if (this.eOQ) {
                this.eOQ = false;
                s.this.bvp();
                if (this.pos < s.this.eOJ.size()) {
                    s sVar = s.this;
                    int i = this.pos;
                    this.pos = i - 1;
                    sVar.lN(i);
                    return;
                }
                bvv().remove();
                return;
            }
            throw new IllegalStateException("remove() was called before next()");
        }

        private Iterator<Entry<K, V>> bvv() {
            if (this.eOR == null) {
                this.eOR = s.this.eOK.entrySet().iterator();
            }
            return this.eOR;
        }
    }

    /* compiled from: SmallSortedMap */
    private class d extends AbstractSet<Entry<K, V>> {
        private d() {
        }

        /* synthetic */ d(s sVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        public Iterator<Entry<K, V>> iterator() {
            return new c(s.this, null);
        }

        public int size() {
            return s.this.size();
        }

        public boolean contains(Object obj) {
            Entry entry = (Entry) obj;
            Object obj2 = s.this.get(entry.getKey());
            obj = entry.getValue();
            return obj2 == obj || (obj2 != null && obj2.equals(obj));
        }

        public boolean add(Entry<K, V> entry) {
            if (contains(entry)) {
                return false;
            }
            s.this.put((Comparable) entry.getKey(), entry.getValue());
            return true;
        }

        public boolean remove(Object obj) {
            Entry entry = (Entry) obj;
            if (!contains(entry)) {
                return false;
            }
            s.this.remove(entry.getKey());
            return true;
        }

        public void clear() {
            s.this.clear();
        }
    }

    /* synthetic */ s(int i, AnonymousClass1 anonymousClass1) {
        this(i);
    }

    static <FieldDescriptorType extends kotlin.reflect.jvm.internal.impl.protobuf.g.a<FieldDescriptorType>> s<FieldDescriptorType, Object> lL(int i) {
        return new s<FieldDescriptorType, Object>(i) {
            public void makeImmutable() {
                if (!isImmutable()) {
                    Entry lM;
                    for (int i = 0; i < bvn(); i++) {
                        lM = lM(i);
                        if (((kotlin.reflect.jvm.internal.impl.protobuf.g.a) lM.getKey()).buK()) {
                            lM.setValue(Collections.unmodifiableList((List) lM.getValue()));
                        }
                    }
                    for (Entry lM2 : bvo()) {
                        if (((kotlin.reflect.jvm.internal.impl.protobuf.g.a) lM2.getKey()).buK()) {
                            lM2.setValue(Collections.unmodifiableList((List) lM2.getValue()));
                        }
                    }
                }
                super.makeImmutable();
            }
        };
    }

    private s(int i) {
        this.eOI = i;
        this.eOJ = Collections.emptyList();
        this.eOK = Collections.emptyMap();
    }

    public void makeImmutable() {
        if (!this.eNQ) {
            this.eOK = this.eOK.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.eOK);
            this.eNQ = true;
        }
    }

    public boolean isImmutable() {
        return this.eNQ;
    }

    public int bvn() {
        return this.eOJ.size();
    }

    public Entry<K, V> lM(int i) {
        return (Entry) this.eOJ.get(i);
    }

    public Iterable<Entry<K, V>> bvo() {
        return this.eOK.isEmpty() ? a.bvs() : this.eOK.entrySet();
    }

    public int size() {
        return this.eOJ.size() + this.eOK.size();
    }

    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return a(comparable) >= 0 || this.eOK.containsKey(comparable);
    }

    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int a = a(comparable);
        if (a >= 0) {
            return ((b) this.eOJ.get(a)).getValue();
        }
        return this.eOK.get(comparable);
    }

    public V put(K k, V v) {
        bvp();
        int a = a((Comparable) k);
        if (a >= 0) {
            return ((b) this.eOJ.get(a)).setValue(v);
        }
        bvr();
        a = -(a + 1);
        if (a >= this.eOI) {
            return bvq().put(k, v);
        }
        if (this.eOJ.size() == this.eOI) {
            b bVar = (b) this.eOJ.remove(this.eOI - 1);
            bvq().put(bVar.getKey(), bVar.getValue());
        }
        this.eOJ.add(a, new b(k, v));
        return null;
    }

    public void clear() {
        bvp();
        if (!this.eOJ.isEmpty()) {
            this.eOJ.clear();
        }
        if (!this.eOK.isEmpty()) {
            this.eOK.clear();
        }
    }

    public V remove(Object obj) {
        bvp();
        Comparable comparable = (Comparable) obj;
        int a = a(comparable);
        if (a >= 0) {
            return lN(a);
        }
        if (this.eOK.isEmpty()) {
            return null;
        }
        return this.eOK.remove(comparable);
    }

    private V lN(int i) {
        bvp();
        V value = ((b) this.eOJ.remove(i)).getValue();
        if (!this.eOK.isEmpty()) {
            Iterator it = bvq().entrySet().iterator();
            this.eOJ.add(new b(this, (Entry) it.next()));
            it.remove();
        }
        return value;
    }

    private int a(K k) {
        int compareTo;
        int size = this.eOJ.size() - 1;
        if (size >= 0) {
            compareTo = k.compareTo(((b) this.eOJ.get(size)).getKey());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        compareTo = 0;
        while (compareTo <= size) {
            int i = (compareTo + size) / 2;
            int compareTo2 = k.compareTo(((b) this.eOJ.get(i)).getKey());
            if (compareTo2 < 0) {
                size = i - 1;
            } else if (compareTo2 <= 0) {
                return i;
            } else {
                compareTo = i + 1;
            }
        }
        return -(compareTo + 1);
    }

    public Set<Entry<K, V>> entrySet() {
        if (this.eOL == null) {
            this.eOL = new d(this, null);
        }
        return this.eOL;
    }

    private void bvp() {
        if (this.eNQ) {
            throw new UnsupportedOperationException();
        }
    }

    private SortedMap<K, V> bvq() {
        bvp();
        if (this.eOK.isEmpty() && !(this.eOK instanceof TreeMap)) {
            this.eOK = new TreeMap();
        }
        return (SortedMap) this.eOK;
    }

    private void bvr() {
        bvp();
        if (this.eOJ.isEmpty() && !(this.eOJ instanceof ArrayList)) {
            this.eOJ = new ArrayList(this.eOI);
        }
    }
}
