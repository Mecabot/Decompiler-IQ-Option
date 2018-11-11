package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.Iterator;
import java.util.Map.Entry;

/* compiled from: LazyField */
public class i extends j {
    private final n eOj;

    /* compiled from: LazyField */
    static class a<K> implements Entry<K, Object> {
        private Entry<K, i> PB;

        private a(Entry<K, i> entry) {
            this.PB = entry;
        }

        public K getKey() {
            return this.PB.getKey();
        }

        public Object getValue() {
            i iVar = (i) this.PB.getValue();
            if (iVar == null) {
                return null;
            }
            return iVar.bvg();
        }

        public Object setValue(Object obj) {
            if (obj instanceof n) {
                return ((i) this.PB.getValue()).i((n) obj);
            }
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }
    }

    /* compiled from: LazyField */
    static class b<K> implements Iterator<Entry<K, Object>> {
        private Iterator<Entry<K, Object>> RC;

        public b(Iterator<Entry<K, Object>> it) {
            this.RC = it;
        }

        public boolean hasNext() {
            return this.RC.hasNext();
        }

        public Entry<K, Object> next() {
            Entry<K, Object> entry = (Entry) this.RC.next();
            return entry.getValue() instanceof i ? new a(entry) : entry;
        }

        public void remove() {
            this.RC.remove();
        }
    }

    public n bvg() {
        return h(this.eOj);
    }

    public int hashCode() {
        return bvg().hashCode();
    }

    public boolean equals(Object obj) {
        return bvg().equals(obj);
    }

    public String toString() {
        return bvg().toString();
    }
}
