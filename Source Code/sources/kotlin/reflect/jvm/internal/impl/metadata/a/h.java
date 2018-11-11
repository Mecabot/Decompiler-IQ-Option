package kotlin.reflect.jvm.internal.impl.metadata.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeTable;

/* compiled from: TypeTable.kt */
public final class h {
    private final List<Type> eLV;

    public h(TypeTable typeTable) {
        kotlin.jvm.internal.h.e(typeTable, "typeTable");
        h hVar = this;
        List bpW = typeTable.bpW();
        if (typeTable.bpY()) {
            int bpZ = typeTable.bpZ();
            List bpW2 = typeTable.bpW();
            kotlin.jvm.internal.h.d(bpW2, "typeTable.typeList");
            Iterable<Object> iterable = bpW2;
            Collection arrayList = new ArrayList(n.e(iterable, 10));
            int i = 0;
            for (Object obj : iterable) {
                Object obj2;
                int i2 = i + 1;
                if (i >= bpZ) {
                    obj2 = obj2.bjf().gS(true).bjx();
                }
                arrayList.add(obj2);
                i = i2;
            }
            bpW = (List) arrayList;
        } else {
            kotlin.jvm.internal.h.d(bpW, "originalTypes");
        }
        this.eLV = bpW;
    }

    public final Type lh(int i) {
        return (Type) this.eLV.get(i);
    }
}
