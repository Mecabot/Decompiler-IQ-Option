package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: LazyStringArrayList */
public class k extends AbstractList<String> implements RandomAccess, l {
    public static final l eOo = new k().bvi();
    private final List<Object> ata;

    public k() {
        this.ata = new ArrayList();
    }

    public k(l lVar) {
        this.ata = new ArrayList(lVar.size());
        addAll(lVar);
    }

    public String get(int i) {
        Object obj = this.ata.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        String btV;
        if (obj instanceof d) {
            d dVar = (d) obj;
            btV = dVar.btV();
            if (dVar.btW()) {
                this.ata.set(i, btV);
            }
            return btV;
        }
        byte[] bArr = (byte[]) obj;
        btV = h.ai(bArr);
        if (h.ah(bArr)) {
            this.ata.set(i, btV);
        }
        return btV;
    }

    public int size() {
        return this.ata.size();
    }

    /* renamed from: o */
    public String set(int i, String str) {
        return cY(this.ata.set(i, str));
    }

    public void add(int i, String str) {
        this.ata.add(i, str);
        this.modCount++;
    }

    public boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    public boolean addAll(int i, Collection<? extends String> collection) {
        Collection collection2;
        if (collection2 instanceof l) {
            collection2 = ((l) collection2).bvh();
        }
        boolean addAll = this.ata.addAll(i, collection2);
        this.modCount++;
        return addAll;
    }

    /* renamed from: lI */
    public String remove(int i) {
        Object remove = this.ata.remove(i);
        this.modCount++;
        return cY(remove);
    }

    public void clear() {
        this.ata.clear();
        this.modCount++;
    }

    public void f(d dVar) {
        this.ata.add(dVar);
        this.modCount++;
    }

    public d lJ(int i) {
        d dVar = this.ata.get(i);
        d cZ = cZ(dVar);
        if (cZ != dVar) {
            this.ata.set(i, cZ);
        }
        return cZ;
    }

    private static String cY(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof d) {
            return ((d) obj).btV();
        }
        return h.ai((byte[]) obj);
    }

    private static d cZ(Object obj) {
        if (obj instanceof d) {
            return (d) obj;
        }
        if (obj instanceof String) {
            return d.mI((String) obj);
        }
        return d.ae((byte[]) obj);
    }

    public List<?> bvh() {
        return Collections.unmodifiableList(this.ata);
    }

    public l bvi() {
        return new t(this);
    }
}
