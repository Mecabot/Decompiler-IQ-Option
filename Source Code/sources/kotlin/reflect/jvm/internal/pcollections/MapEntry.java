package kotlin.reflect.jvm.internal.pcollections;

import java.io.Serializable;

final class MapEntry<K, V> implements Serializable {
    public final K key;
    public final V value;

    public MapEntry(K k, V v) {
        this.key = k;
        this.value = v;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof MapEntry)) {
            return false;
        }
        MapEntry mapEntry = (MapEntry) obj;
        if (this.key != null ? !this.key.equals(mapEntry.key) : mapEntry.key != null) {
            if (this.value != null ? !this.value.equals(mapEntry.value) : mapEntry.value != null) {
                z = true;
            }
        }
        return z;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = this.key == null ? 0 : this.key.hashCode();
        if (this.value != null) {
            i = this.value.hashCode();
        }
        return hashCode ^ i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.key);
        stringBuilder.append("=");
        stringBuilder.append(this.value);
        return stringBuilder.toString();
    }
}
