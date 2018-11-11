package com.iqoption.core.util;

import com.google.common.base.f;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: MapUtils */
public class l {

    /* compiled from: MapUtils */
    public interface a<A, B, C> {
        C apply(A a, B b);
    }

    public static <K, V> Map<K, V> a(Map<K, V> map, Map<K, V> map2, a<? super V, ? super V, ? extends V> aVar) {
        for (Entry entry : map2.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            Object obj = map.get(key);
            if (obj != null) {
                value = aVar.apply(obj, value);
            }
            if (value == null) {
                map.remove(key);
            } else {
                map.put(key, value);
            }
        }
        return map;
    }

    public static <K, V> Map<K, V> b(Map<K, V> map, Map<K, V> map2) {
        Map hashMap = new HashMap();
        for (Entry entry : map2.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (!f.equal(map.get(key), value)) {
                hashMap.put(key, value);
            }
        }
        return hashMap;
    }

    public static boolean x(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }
}
