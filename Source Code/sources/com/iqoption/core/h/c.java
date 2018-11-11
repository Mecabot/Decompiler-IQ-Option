package com.iqoption.core.h;

import io.reactivex.c.f;
import io.reactivex.e;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000.\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00040\u0003:\u0001\u0011B]\u0012\u0018\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\u0006\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ<\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0002R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, aXE = {"Lcom/iqoption/core/rx/LiveStreamMapValueMergerSupplier;", "Key", "Value", "Lcom/iqoption/core/rx/LiveStreamSupplier;", "", "init", "Lio/reactivex/Flowable;", "update", "valueMerger", "Lcom/iqoption/core/rx/LiveStreamMapValueMergerSupplier$ValueMerger;", "disposeDelay", "", "tag", "", "(Lio/reactivex/Flowable;Lio/reactivex/Flowable;Lcom/iqoption/core/rx/LiveStreamMapValueMergerSupplier$ValueMerger;JLjava/lang/String;)V", "applyUpdates", "current", "ValueMerger", "core_release"})
/* compiled from: LiveStreamMapValueMergerSupplier.kt */
public final class c<Key, Value> extends d<Map<Key, ? extends Value>> {
    private final a<Value> bai;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\bf\u0018\u0000*\u0004\b\u0002\u0010\u00012\u00020\u0002J#\u0010\u0003\u001a\u0004\u0018\u00018\u00022\b\u0010\u0004\u001a\u0004\u0018\u00018\u00022\b\u0010\u0005\u001a\u0004\u0018\u00018\u0002H&¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, aXE = {"Lcom/iqoption/core/rx/LiveStreamMapValueMergerSupplier$ValueMerger;", "Value", "", "mergeValue", "old", "new", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "core_release"})
    /* compiled from: LiveStreamMapValueMergerSupplier.kt */
    public interface a<Value> {
        Value A(Value value, Value value2);
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\n\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "Key", "Value", "it", "apply"})
    /* compiled from: LiveStreamMapValueMergerSupplier.kt */
    static final class b<T, R> implements f<T, R> {
        final /* synthetic */ c baj;

        b(c cVar) {
            this.baj = cVar;
        }

        /* renamed from: v */
        public final Map<Key, Value> apply(Map<Key, ? extends Value> map) {
            h.e(map, "it");
            c cVar = this.baj;
            Object aVW = this.baj.Ye().aVW();
            h.d(aVW, "processor.blockingFirst()");
            return cVar.a((Map) aVW, map);
        }
    }

    public c(e<Map<Key, Value>> eVar, e<Map<Key, Value>> eVar2, a<Value> aVar, long j, String str) {
        h.e(eVar, "init");
        h.e(eVar2, "update");
        h.e(aVar, "valueMerger");
        super(j, str);
        this.bai = aVar;
        e c = eVar.c((org.a.b) eVar2.d((f) new b(this)));
        h.d(c, "init.concatWith(updateFlowable)");
        a(c);
    }

    private final Map<Key, Value> a(Map<Key, ? extends Value> map, Map<Key, ? extends Value> map2) {
        Map<Key, Value> linkedHashMap = new LinkedHashMap();
        for (Object next : u.Y(ak.a(map.keySet(), map2.keySet()))) {
            Object A = this.bai.A(map.get(next), map2.get(next));
            if (A != null) {
                linkedHashMap.put(next, A);
            }
        }
        return linkedHashMap;
    }
}
