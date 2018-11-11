package android.arch.core.internal;

import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import java.util.HashMap;
import java.util.Map.Entry;

@RestrictTo({Scope.LIBRARY_GROUP})
public class FastSafeIterableMap<K, V> extends SafeIterableMap<K, V> {
    private HashMap<K, Entry<K, V>> al = new HashMap();

    protected Entry<K, V> b(K k) {
        return (Entry) this.al.get(k);
    }

    public V putIfAbsent(@NonNull K k, @NonNull V v) {
        Entry b = b(k);
        if (b != null) {
            return b.mValue;
        }
        this.al.put(k, a(k, v));
        return null;
    }

    public V remove(@NonNull K k) {
        V remove = super.remove(k);
        this.al.remove(k);
        return remove;
    }

    public boolean contains(K k) {
        return this.al.containsKey(k);
    }

    public Entry<K, V> c(K k) {
        return contains(k) ? ((Entry) this.al.get(k)).ar : null;
    }
}
