package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.types.ad;
import kotlin.reflect.jvm.internal.impl.types.ay;
import kotlin.reflect.jvm.internal.impl.types.n;
import kotlin.reflect.jvm.internal.impl.types.p;
import kotlin.reflect.jvm.internal.impl.types.q;
import kotlin.reflect.jvm.internal.impl.types.t;
import kotlin.reflect.jvm.internal.impl.types.x;
import kotlin.reflect.jvm.internal.impl.types.y;

/* compiled from: IntersectionType.kt */
public final class a {
    public static final ay co(List<? extends ay> list) {
        h.e(list, "types");
        switch (list.size()) {
            case 0:
                throw new IllegalStateException("Expected some types".toString());
            case 1:
                return (ay) u.bY(list);
            default:
                Iterable<ay> iterable = list;
                Collection arrayList = new ArrayList(n.e(iterable, 10));
                Object obj = null;
                Object obj2 = null;
                for (ay ayVar : iterable) {
                    Object obj3;
                    obj = (obj != null || y.aF(ayVar)) ? 1 : null;
                    if (ayVar instanceof ad) {
                        obj3 = (ad) ayVar;
                    } else if (!(ayVar instanceof q)) {
                        throw new NoWhenBranchMatchedException();
                    } else if (n.az(ayVar)) {
                        return ayVar;
                    } else {
                        obj3 = ((q) ayVar).byT();
                        obj2 = 1;
                    }
                    arrayList.add(obj3);
                }
                List list2 = (List) arrayList;
                if (obj != null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Intersection of error types: ");
                    stringBuilder.append(list);
                    ad mU = p.mU(stringBuilder.toString());
                    h.d(mU, "ErrorUtils.createErrorTy… of error types: $types\")");
                    return mU;
                } else if (obj2 == null) {
                    return TypeIntersector.eVO.cr(list2);
                } else {
                    Collection arrayList2 = new ArrayList(n.e(iterable, 10));
                    for (ay aE : iterable) {
                        arrayList2.add(t.aE(aE));
                    }
                    return x.a(TypeIntersector.eVO.cr(list2), TypeIntersector.eVO.cr((List) arrayList2));
                }
        }
    }
}
