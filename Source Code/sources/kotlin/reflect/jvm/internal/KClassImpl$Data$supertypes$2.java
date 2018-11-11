package kotlin.reflect.jvm.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.builtins.g;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.resolve.c;
import kotlin.reflect.jvm.internal.impl.types.ad;
import kotlin.reflect.jvm.internal.impl.types.an;
import kotlin.reflect.jvm.internal.impl.types.w;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "T", "", "invoke"})
/* compiled from: KClassImpl.kt */
final class KClassImpl$Data$supertypes$2 extends Lambda implements a<List<? extends u>> {
    final /* synthetic */ i.a this$0;

    KClassImpl$Data$supertypes$2(i.a aVar) {
        this.this$0 = aVar;
        super(0);
    }

    /* renamed from: aYR */
    public final List<u> invoke() {
        an bby = this.this$0.aYX().bby();
        h.d(bby, "descriptor.typeConstructor");
        Collection<w> beu = bby.beu();
        ArrayList arrayList = new ArrayList(beu.size());
        h.d(beu, "kotlinTypes");
        for (w wVar : beu) {
            Collection collection = arrayList;
            h.d(wVar, "kotlinType");
            collection.add(new u(wVar, new KClassImpl$Data$supertypes$2$$special$$inlined$mapTo$lambda$1(wVar, this)));
        }
        Collection collection2 = arrayList;
        if (!g.e(this.this$0.aYX())) {
            Iterable<u> iterable = arrayList;
            Object obj = 1;
            if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                for (u bai : iterable) {
                    Object obj2;
                    d ao = c.ao(bai.bai());
                    h.d(ao, "DescriptorUtils.getClassDescriptorForType(it.type)");
                    ClassKind bbF = ao.bbF();
                    if (bbF == ClassKind.INTERFACE || bbF == ClassKind.ANNOTATION_CLASS) {
                        obj2 = 1;
                        continue;
                    } else {
                        obj2 = null;
                        continue;
                    }
                    if (obj2 == null) {
                        obj = null;
                        break;
                    }
                }
            }
            if (obj != null) {
                ad baU = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.Q(this.this$0.aYX()).baU();
                h.d(baU, "descriptor.builtIns.anyType");
                collection2.add(new u(baU, AnonymousClass3.evL));
            }
        }
        return kotlin.reflect.jvm.internal.impl.utils.a.j(arrayList);
    }
}
