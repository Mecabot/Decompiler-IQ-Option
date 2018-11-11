package kotlin.reflect.jvm.internal.pcollections;

/* compiled from: IntTreePMap */
final class d<V> {
    private static final d<Object> eYd = new d(c.eXZ);
    private final c<V> eYe;

    public static <V> d<V> bzL() {
        return eYd;
    }

    private d(c<V> cVar) {
        this.eYe = cVar;
    }

    private d<V> a(c<V> cVar) {
        if (cVar == this.eYe) {
            return this;
        }
        return new d(cVar);
    }

    public V get(int i) {
        return this.eYe.get((long) i);
    }

    public d<V> e(int i, V v) {
        return a(this.eYe.a((long) i, (Object) v));
    }
}
