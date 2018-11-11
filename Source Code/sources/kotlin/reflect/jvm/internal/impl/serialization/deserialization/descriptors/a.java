package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.j;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.c;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.f;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import kotlin.reflect.jvm.internal.impl.name.b;
import kotlin.reflect.jvm.internal.impl.storage.e;
import kotlin.reflect.jvm.internal.impl.storage.h;

/* compiled from: DeserializedAnnotations.kt */
public class a implements g {
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(a.class), "annotations", "getAnnotations()Ljava/util/List;"))};
    private final e eTx;

    private final List<c> bxS() {
        return (List) kotlin.reflect.jvm.internal.impl.storage.g.a(this.eTx, (Object) this, apP[0]);
    }

    public a(h hVar, kotlin.jvm.a.a<? extends List<? extends c>> aVar) {
        kotlin.jvm.internal.h.e(hVar, "storageManager");
        kotlin.jvm.internal.h.e(aVar, "compute");
        this.eTx = hVar.i(aVar);
    }

    public c j(b bVar) {
        kotlin.jvm.internal.h.e(bVar, "fqName");
        return g.b.a(this, bVar);
    }

    public boolean k(b bVar) {
        kotlin.jvm.internal.h.e(bVar, "fqName");
        return g.b.b(this, bVar);
    }

    public boolean isEmpty() {
        return bxS().isEmpty();
    }

    public List<f> bej() {
        return m.emptyList();
    }

    public List<f> bek() {
        Iterable<c> bxS = bxS();
        Collection arrayList = new ArrayList(n.e(bxS, 10));
        for (c fVar : bxS) {
            arrayList.add(new f(fVar, null));
        }
        return (List) arrayList;
    }

    public Iterator<c> iterator() {
        return bxS().iterator();
    }
}
