package kotlin.reflect.jvm.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.an;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "T", "", "invoke"})
/* compiled from: KClassImpl.kt */
final class KClassImpl$Data$typeParameters$2 extends Lambda implements a<List<? extends w>> {
    final /* synthetic */ i.a this$0;

    KClassImpl$Data$typeParameters$2(i.a aVar) {
        this.this$0 = aVar;
        super(0);
    }

    /* renamed from: aYR */
    public final List<w> invoke() {
        List bbS = this.this$0.aYX().bbS();
        h.d(bbS, "descriptor.declaredTypeParameters");
        Iterable<an> iterable = bbS;
        Collection arrayList = new ArrayList(n.e(iterable, 10));
        for (an wVar : iterable) {
            arrayList.add(new w(wVar));
        }
        return (List) arrayList;
    }
}
