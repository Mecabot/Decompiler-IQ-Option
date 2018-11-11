package kotlin.reflect.jvm.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.types.w;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, aXE = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "invoke"})
/* compiled from: KTypeParameterImpl.kt */
final class KTypeParameterImpl$upperBounds$2 extends Lambda implements a<List<? extends u>> {
    final /* synthetic */ w this$0;

    KTypeParameterImpl$upperBounds$2(w wVar) {
        this.this$0 = wVar;
        super(0);
    }

    /* renamed from: aYR */
    public final List<u> invoke() {
        List aYq = this.this$0.bak().aYq();
        h.d(aYq, "descriptor.upperBounds");
        Iterable<w> iterable = aYq;
        Collection arrayList = new ArrayList(n.e(iterable, 10));
        for (w wVar : iterable) {
            h.d(wVar, "kotlinType");
            arrayList.add(new u(wVar, new KTypeParameterImpl$upperBounds$2$$special$$inlined$map$lambda$1(this)));
        }
        return (List) arrayList;
    }
}
