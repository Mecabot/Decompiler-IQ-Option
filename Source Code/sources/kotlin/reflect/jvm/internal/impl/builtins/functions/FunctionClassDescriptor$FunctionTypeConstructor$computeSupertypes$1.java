package kotlin.reflect.jvm.internal.impl.builtins.functions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.a.m;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.l;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.types.an;
import kotlin.reflect.jvm.internal.impl.types.ar;

/* compiled from: FunctionClassDescriptor.kt */
final class FunctionClassDescriptor$FunctionTypeConstructor$computeSupertypes$1 extends Lambda implements m<x, f, l> {
    final /* synthetic */ ArrayList $result;
    final /* synthetic */ a this$0;

    FunctionClassDescriptor$FunctionTypeConstructor$computeSupertypes$1(a aVar, ArrayList arrayList) {
        this.this$0 = aVar;
        this.$result = arrayList;
        super(2);
    }

    public /* synthetic */ Object B(Object obj, Object obj2) {
        a((x) obj, (f) obj2);
        return l.etX;
    }

    public final void a(x xVar, f fVar) {
        h.e(xVar, "packageFragment");
        h.e(fVar, "name");
        kotlin.reflect.jvm.internal.impl.descriptors.f c = xVar.bbk().c(fVar, NoLookupLocation.FROM_BUILTINS);
        if (!(c instanceof d)) {
            c = null;
        }
        d dVar = (d) c;
        if (dVar != null) {
            an bby = dVar.bby();
            List parameters = this.this$0.getParameters();
            h.d(bby, "typeConstructor");
            Iterable<kotlin.reflect.jvm.internal.impl.descriptors.an> j = u.j(parameters, bby.getParameters().size());
            Collection arrayList = new ArrayList(n.e(j, 10));
            for (kotlin.reflect.jvm.internal.impl.descriptors.an bdb : j) {
                arrayList.add(new ar(bdb.bdb()));
            }
            this.$result.add(kotlin.reflect.jvm.internal.impl.types.x.a(g.eBF.bel(), dVar, (List) arrayList));
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Class ");
        stringBuilder.append(fVar);
        stringBuilder.append(" not found in ");
        stringBuilder.append(xVar);
        throw new IllegalStateException(stringBuilder.toString().toString());
    }
}
