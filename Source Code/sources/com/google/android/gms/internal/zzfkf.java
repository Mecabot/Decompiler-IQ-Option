package com.google.android.gms.internal;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;

class zzfkf extends AbstractSet<Entry<K, V>> {
    private /* synthetic */ zzfjy zzpss;

    private zzfkf(zzfjy zzfjy) {
        this.zzpss = zzfjy;
    }

    /* synthetic */ zzfkf(zzfjy zzfjy, zzfjz zzfjz) {
        this(zzfjy);
    }

    public /* synthetic */ boolean add(Object obj) {
        Entry entry = (Entry) obj;
        if (contains(entry)) {
            return false;
        }
        this.zzpss.put((Comparable) entry.getKey(), entry.getValue());
        return true;
    }

    public void clear() {
        this.zzpss.clear();
    }

    public boolean contains(Object obj) {
        Entry entry = (Entry) obj;
        Object obj2 = this.zzpss.get(entry.getKey());
        obj = entry.getValue();
        return obj2 == obj || (obj2 != null && obj2.equals(obj));
    }

    public Iterator<Entry<K, V>> iterator() {
        return new zzfke(this.zzpss, null);
    }

    public boolean remove(Object obj) {
        Entry entry = (Entry) obj;
        if (!contains(entry)) {
            return false;
        }
        this.zzpss.remove(entry.getKey());
        return true;
    }

    public int size() {
        return this.zzpss.size();
    }
}
