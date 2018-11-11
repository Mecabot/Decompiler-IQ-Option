package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collection;
import java.util.LinkedList;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.a;

/* compiled from: overridingUtils.kt */
public final class i {
    public static final <H> Collection<H> b(Collection<? extends H> collection, b<? super H, ? extends a> bVar) {
        h.e(collection, "$receiver");
        h.e(bVar, "descriptorByHandle");
        if (collection.size() <= 1) {
            return collection;
        }
        LinkedList linkedList = new LinkedList(collection);
        kotlin.reflect.jvm.internal.impl.utils.i bzH = kotlin.reflect.jvm.internal.impl.utils.i.eXR.bzH();
        while (true) {
            Collection collection2 = linkedList;
            if ((collection2.isEmpty() ^ 1) == 0) {
                return bzH;
            }
            Object bU = u.bU(linkedList);
            kotlin.reflect.jvm.internal.impl.utils.i bzH2 = kotlin.reflect.jvm.internal.impl.utils.i.eXR.bzH();
            collection2 = OverridingUtil.a(bU, collection2, (b) bVar, (b) new OverridingUtilsKt$selectMostSpecificInEachOverridableGroup$overridableGroup$1(bzH2));
            if (collection2.size() == 1 && bzH2.isEmpty()) {
                h.d(collection2, "overridableGroup");
                Object Q = u.Q(collection2);
                h.d(Q, "overridableGroup.single()");
                bzH.add(Q);
            } else {
                bU = OverridingUtil.a(collection2, (b) bVar);
                h.d(bU, "mostSpecific");
                a aVar = (a) bVar.invoke(bU);
                h.d(collection2, "overridableGroup");
                for (Object next : collection2) {
                    h.d(next, "it");
                    if (!OverridingUtil.f(aVar, (a) bVar.invoke(next))) {
                        bzH2.add(next);
                    }
                }
                Collection collection3 = bzH2;
                if ((collection3.isEmpty() ^ 1) != 0) {
                    bzH.addAll(collection3);
                }
                bzH.add(bU);
            }
        }
    }

    public static final <D extends a> void U(Collection<D> collection) {
        h.e(collection, "$receiver");
        Collection b = b(collection, OverridingUtilsKt$retainMostSpecificInEachOverridableGroup$newResult$1.eRf);
        if (collection.size() != b.size()) {
            collection.retainAll(b);
        }
    }
}
