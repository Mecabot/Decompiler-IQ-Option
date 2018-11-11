package android.arch.core.internal;

import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import java.util.Iterator;
import java.util.WeakHashMap;

@RestrictTo({Scope.LIBRARY_GROUP})
public class SafeIterableMap<K, V> implements Iterable<java.util.Map.Entry<K, V>> {
    private Entry<K, V> am;
    private Entry<K, V> an;
    private WeakHashMap<SupportRemove<K, V>, Boolean> ao = new WeakHashMap();
    private int mSize = 0;

    static class Entry<K, V> implements java.util.Map.Entry<K, V> {
        @NonNull
        final K ap;
        Entry<K, V> aq;
        Entry<K, V> ar;
        @NonNull
        final V mValue;

        Entry(@NonNull K k, @NonNull V v) {
            this.ap = k;
            this.mValue = v;
        }

        @NonNull
        public K getKey() {
            return this.ap;
        }

        @NonNull
        public V getValue() {
            return this.mValue;
        }

        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.ap);
            stringBuilder.append("=");
            stringBuilder.append(this.mValue);
            return stringBuilder.toString();
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
            if (!(this.ap.equals(entry.ap) && this.mValue.equals(entry.mValue))) {
                z = false;
            }
            return z;
        }
    }

    interface SupportRemove<K, V> {
        void c(@NonNull Entry<K, V> entry);
    }

    private class IteratorWithAdditions implements SupportRemove<K, V>, Iterator<java.util.Map.Entry<K, V>> {
        private Entry<K, V> as;
        private boolean at;

        private IteratorWithAdditions() {
            this.at = true;
        }

        public void c(@NonNull Entry<K, V> entry) {
            if (entry == this.as) {
                this.as = this.as.ar;
                this.at = this.as == null;
            }
        }

        public boolean hasNext() {
            boolean z = false;
            if (this.at) {
                if (SafeIterableMap.this.am != null) {
                    z = true;
                }
                return z;
            }
            if (!(this.as == null || this.as.aq == null)) {
                z = true;
            }
            return z;
        }

        public java.util.Map.Entry<K, V> next() {
            if (this.at) {
                this.at = false;
                this.as = SafeIterableMap.this.am;
            } else {
                this.as = this.as != null ? this.as.aq : null;
            }
            return this.as;
        }
    }

    private static abstract class ListIterator<K, V> implements SupportRemove<K, V>, Iterator<java.util.Map.Entry<K, V>> {
        Entry<K, V> aq;
        Entry<K, V> av;

        abstract Entry<K, V> a(Entry<K, V> entry);

        abstract Entry<K, V> b(Entry<K, V> entry);

        ListIterator(Entry<K, V> entry, Entry<K, V> entry2) {
            this.av = entry2;
            this.aq = entry;
        }

        public boolean hasNext() {
            return this.aq != null;
        }

        public void c(@NonNull Entry<K, V> entry) {
            if (this.av == entry && entry == this.aq) {
                this.aq = null;
                this.av = null;
            }
            if (this.av == entry) {
                this.av = b(this.av);
            }
            if (this.aq == entry) {
                this.aq = G();
            }
        }

        private Entry<K, V> G() {
            return (this.aq == this.av || this.av == null) ? null : a(this.aq);
        }

        public java.util.Map.Entry<K, V> next() {
            java.util.Map.Entry entry = this.aq;
            this.aq = G();
            return entry;
        }
    }

    static class AscendingIterator<K, V> extends ListIterator<K, V> {
        AscendingIterator(Entry<K, V> entry, Entry<K, V> entry2) {
            super(entry, entry2);
        }

        Entry<K, V> a(Entry<K, V> entry) {
            return entry.aq;
        }

        Entry<K, V> b(Entry<K, V> entry) {
            return entry.ar;
        }
    }

    private static class DescendingIterator<K, V> extends ListIterator<K, V> {
        DescendingIterator(Entry<K, V> entry, Entry<K, V> entry2) {
            super(entry, entry2);
        }

        Entry<K, V> a(Entry<K, V> entry) {
            return entry.ar;
        }

        Entry<K, V> b(Entry<K, V> entry) {
            return entry.aq;
        }
    }

    protected Entry<K, V> b(K k) {
        Entry<K, V> entry = this.am;
        while (entry != null && !entry.ap.equals(k)) {
            entry = entry.aq;
        }
        return entry;
    }

    public V putIfAbsent(@NonNull K k, @NonNull V v) {
        Entry b = b(k);
        if (b != null) {
            return b.mValue;
        }
        a(k, v);
        return null;
    }

    protected Entry<K, V> a(@NonNull K k, @NonNull V v) {
        Entry<K, V> entry = new Entry(k, v);
        this.mSize++;
        if (this.an == null) {
            this.am = entry;
            this.an = this.am;
            return entry;
        }
        this.an.aq = entry;
        entry.ar = this.an;
        this.an = entry;
        return entry;
    }

    public V remove(@NonNull K k) {
        Entry b = b(k);
        if (b == null) {
            return null;
        }
        this.mSize--;
        if (!this.ao.isEmpty()) {
            for (SupportRemove c : this.ao.keySet()) {
                c.c(b);
            }
        }
        if (b.ar != null) {
            b.ar.aq = b.aq;
        } else {
            this.am = b.aq;
        }
        if (b.aq != null) {
            b.aq.ar = b.ar;
        } else {
            this.an = b.ar;
        }
        b.aq = null;
        b.ar = null;
        return b.mValue;
    }

    public int size() {
        return this.mSize;
    }

    @NonNull
    public Iterator<java.util.Map.Entry<K, V>> iterator() {
        Iterator ascendingIterator = new AscendingIterator(this.am, this.an);
        this.ao.put(ascendingIterator, Boolean.valueOf(false));
        return ascendingIterator;
    }

    public Iterator<java.util.Map.Entry<K, V>> descendingIterator() {
        Iterator descendingIterator = new DescendingIterator(this.an, this.am);
        this.ao.put(descendingIterator, Boolean.valueOf(false));
        return descendingIterator;
    }

    public IteratorWithAdditions D() {
        IteratorWithAdditions iteratorWithAdditions = new IteratorWithAdditions();
        this.ao.put(iteratorWithAdditions, Boolean.valueOf(false));
        return iteratorWithAdditions;
    }

    public java.util.Map.Entry<K, V> E() {
        return this.am;
    }

    public java.util.Map.Entry<K, V> F() {
        return this.an;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SafeIterableMap)) {
            return false;
        }
        SafeIterableMap safeIterableMap = (SafeIterableMap) obj;
        if (size() != safeIterableMap.size()) {
            return false;
        }
        Iterator it = iterator();
        Iterator it2 = safeIterableMap.iterator();
        while (it.hasNext() && it2.hasNext()) {
            java.util.Map.Entry entry = (java.util.Map.Entry) it.next();
            Object next = it2.next();
            if ((entry == null && next != null) || (entry != null && !entry.equals(next))) {
                return false;
            }
        }
        if (it.hasNext() || it2.hasNext()) {
            z = false;
        }
        return z;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        Iterator it = iterator();
        while (it.hasNext()) {
            stringBuilder.append(((java.util.Map.Entry) it.next()).toString());
            if (it.hasNext()) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
