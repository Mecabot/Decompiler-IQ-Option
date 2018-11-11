package kotlin.reflect.jvm.internal.pcollections;

/* compiled from: HashPMap */
public final class b<K, V> {
    private static final b<Object, Object> eXX = new b(d.bzL(), 0);
    private final d<a<MapEntry<K, V>>> eXY;
    private final int size;

    public static <K, V> b<K, V> bzK() {
        return eXX;
    }

    private b(d<a<MapEntry<K, V>>> dVar, int i) {
        this.eXY = dVar;
        this.size = i;
    }

    public V get(Object obj) {
        a mg = mg(obj.hashCode());
        while (mg != null && mg.size() > 0) {
            MapEntry mapEntry = (MapEntry) mg.first;
            if (mapEntry.key.equals(obj)) {
                return mapEntry.value;
            }
            mg = mg.eXV;
        }
        return null;
    }

    public b<K, V> I(K k, V v) {
        a mg = mg(k.hashCode());
        int size = mg.size();
        int a = a(mg, k);
        if (a != -1) {
            mg = mg.me(a);
        }
        a dn = mg.dn(new MapEntry(k, v));
        return new b(this.eXY.e(k.hashCode(), dn), (this.size - size) + dn.size());
    }

    private a<MapEntry<K, V>> mg(int i) {
        a<MapEntry<K, V>> aVar = (a) this.eXY.get(i);
        return aVar == null ? a.bzJ() : aVar;
    }

    private static <K, V> int a(a<MapEntry<K, V>> aVar, Object obj) {
        int i = 0;
        a aVar2;
        while (aVar2 != null && aVar2.size() > 0) {
            if (((MapEntry) aVar2.first).key.equals(obj)) {
                return i;
            }
            aVar2 = aVar2.eXV;
            i++;
        }
        return -1;
    }
}
