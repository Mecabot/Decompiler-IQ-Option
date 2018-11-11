package com.jumio.core.util;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MultiHashMap<K, V> extends HashMap<K, List<V>> {
    public void putOne(K k, V v) {
        if (k != null && v != null) {
            if (containsKey(k)) {
                ((List) get(k)).add(v);
            } else {
                List defaultList = defaultList();
                defaultList.add(v);
                put((Object) k, defaultList);
            }
        }
    }

    public int count(K k) {
        return containsKey(k) ? ((List) get(k)).size() : 0;
    }

    private List<V> defaultList() {
        return new LinkedList();
    }

    public List<V> put(K k, List<V> list) {
        return list != null ? (List) super.put(k, list) : null;
    }

    public void putAll(Map<? extends K, ? extends List<V>> map) {
        super.putAll(map);
    }

    public List<V> remove(Object obj) {
        return (List) super.remove(obj);
    }
}
