package com.iqoption.core.e;

import kotlin.e.d;
import kotlin.i;
import kotlin.jvm.internal.h;
import kotlin.l;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\"\u0010\n\u001a\u00028\u00012\u0006\u0010\u000b\u001a\u00028\u00002\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\rH\u0002¢\u0006\u0002\u0010\u000eJ*\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00028\u00002\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\r2\u0006\u0010\b\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010\u0010R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00018\u0001X\u000e¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u0011"}, aXE = {"Lcom/iqoption/core/kotlin/BindableProperty;", "T", "R", "Lkotlin/properties/ReadWriteProperty;", "onBind", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "value", "Ljava/lang/Object;", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "core_release"})
/* compiled from: Delegates.kt */
final class b<T, R> implements d<T, R> {
    private final kotlin.jvm.a.b<R, l> aSg;
    private R value;

    public b(kotlin.jvm.a.b<? super R, l> bVar) {
        h.e(bVar, "onBind");
        this.aSg = bVar;
    }

    public R b(T t, j<?> jVar) {
        h.e(jVar, "property");
        R r = this.value;
        if (r != null) {
            return r;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Property ");
        stringBuilder.append(jVar.getName());
        stringBuilder.append(" should be initialized before get.");
        throw new IllegalStateException(stringBuilder.toString());
    }

    public void a(T t, j<?> jVar, R r) {
        h.e(jVar, "property");
        this.value = r;
        this.aSg.invoke(r);
    }
}
