package com.iqoption.core.h;

import io.reactivex.c.f;
import io.reactivex.e;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002:\u0001\u0011BK\u0012\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ)\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0006\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0010R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, aXE = {"Lcom/iqoption/core/rx/LiveStreamItemMergerSupplier;", "Item", "Lcom/iqoption/core/rx/LiveStreamSupplier;", "", "init", "Lio/reactivex/Flowable;", "update", "itemIdentifier", "Lcom/iqoption/core/rx/LiveStreamItemMergerSupplier$ItemIdentifier;", "disposeDelay", "", "tag", "", "(Lio/reactivex/Flowable;Lio/reactivex/Flowable;Lcom/iqoption/core/rx/LiveStreamItemMergerSupplier$ItemIdentifier;JLjava/lang/String;)V", "applyEvent", "current", "(Ljava/util/List;Ljava/lang/Object;)Ljava/util/List;", "ItemIdentifier", "core_release"})
/* compiled from: LiveStreamItemMergerSupplier.kt */
public final class b<Item> extends d<List<? extends Item>> {
    private final a<Item> bag;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002J\u001d\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u00012\u0006\u0010\u0006\u001a\u00028\u0001H&¢\u0006\u0002\u0010\u0007¨\u0006\b"}, aXE = {"Lcom/iqoption/core/rx/LiveStreamItemMergerSupplier$ItemIdentifier;", "Item", "", "areItemsTheSame", "", "first", "second", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "core_release"})
    /* compiled from: LiveStreamItemMergerSupplier.kt */
    public interface a<Item> {
        boolean areItemsTheSame(Item item, Item item2);
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\n\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, aXE = {"<anonymous>", "", "Item", "it", "apply", "(Ljava/lang/Object;)Ljava/util/List;"})
    /* compiled from: LiveStreamItemMergerSupplier.kt */
    static final class b<T, R> implements f<T, R> {
        final /* synthetic */ b bah;

        b(b bVar) {
            this.bah = bVar;
        }

        /* renamed from: bj */
        public final List<Item> apply(Item item) {
            b bVar = this.bah;
            Object aVW = this.bah.Ye().aVW();
            h.d(aVW, "processor.blockingFirst()");
            return bVar.h((List) aVW, item);
        }
    }

    public /* synthetic */ b(e eVar, e eVar2, a aVar, long j, String str, int i, f fVar) {
        if ((i & 8) != 0) {
            j = TimeUnit.SECONDS.toMillis(0);
        }
        long j2 = j;
        if ((i & 16) != 0) {
            str = (String) null;
        }
        this(eVar, eVar2, aVar, j2, str);
    }

    public b(e<List<Item>> eVar, e<Item> eVar2, a<Item> aVar, long j, String str) {
        h.e(eVar, "init");
        h.e(eVar2, "update");
        h.e(aVar, "itemIdentifier");
        super(j, str);
        this.bag = aVar;
        e c = eVar.c((org.a.b) eVar2.d((f) new b(this)));
        h.d(c, "init.concatWith(updateFlowable)");
        a(c);
    }

    private final List<Item> h(List<? extends Item> list, Item item) {
        Iterable iterable = list;
        for (Object next : iterable) {
            if (this.bag.areItemsTheSame(next, item)) {
                break;
            }
        }
        Object next2 = null;
        if (next2 != null) {
            List<? extends Item> d = u.d(iterable, next2);
            if (d != null) {
                list = d;
            }
        }
        return u.i((Collection) list, (Object) item);
    }
}
