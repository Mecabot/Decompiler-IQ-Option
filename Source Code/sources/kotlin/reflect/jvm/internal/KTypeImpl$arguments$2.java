package kotlin.reflect.jvm.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.LazyThreadSafetyMode;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;
import kotlin.reflect.jvm.internal.impl.types.ap;
import kotlin.reflect.jvm.internal.impl.types.w;
import kotlin.reflect.p;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, aXE = {"<anonymous>", "", "Lkotlin/reflect/KTypeProjection;", "invoke"})
/* compiled from: KTypeImpl.kt */
final class KTypeImpl$arguments$2 extends Lambda implements a<List<? extends p>> {
    final /* synthetic */ u this$0;

    KTypeImpl$arguments$2(u uVar) {
        this.this$0 = uVar;
        super(0);
    }

    /* renamed from: aYR */
    public final List<p> invoke() {
        List bdF = this.this$0.bai().bdF();
        if (bdF.isEmpty()) {
            return m.emptyList();
        }
        d a = g.a(LazyThreadSafetyMode.PUBLICATION, new KTypeImpl$arguments$2$parameterizedTypeArguments$2(this));
        j jVar = u.apP[3];
        Iterable<ap> iterable = bdF;
        Collection arrayList = new ArrayList(n.e(iterable, 10));
        int i = 0;
        for (ap apVar : iterable) {
            Object aYs;
            int i2 = i + 1;
            if (apVar.bze()) {
                aYs = p.euN.aYs();
            } else {
                w bai = apVar.bai();
                h.d(bai, "typeProjection.type");
                u uVar = new u(bai, new KTypeImpl$arguments$2$$special$$inlined$mapIndexed$lambda$1(i, this, a, jVar));
                switch (apVar.bzf()) {
                    case INVARIANT:
                        aYs = p.euN.a(uVar);
                        break;
                    case IN_VARIANCE:
                        aYs = p.euN.b(uVar);
                        break;
                    case OUT_VARIANCE:
                        aYs = p.euN.c(uVar);
                        break;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            }
            arrayList.add(aYs);
            i = i2;
        }
        return (List) arrayList;
    }
}
