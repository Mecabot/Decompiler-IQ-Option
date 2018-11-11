package com.iqoption.core.e;

import java.lang.ref.WeakReference;
import kotlin.i;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u0010\u0012\u0004\u0012\u0002H\u0001\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00028\u0001¢\u0006\u0002\u0010\u0005J$\u0010\t\u001a\u0004\u0018\u00018\u00012\u0006\u0010\n\u001a\u00028\u00002\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\fH\u0002¢\u0006\u0002\u0010\rJ,\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00028\u00002\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\f2\b\u0010\u0004\u001a\u0004\u0018\u00018\u0001H\u0002¢\u0006\u0002\u0010\u0010R\u001c\u0010\u0006\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00018\u00018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, aXE = {"Lcom/iqoption/core/kotlin/WeakProperty;", "T", "R", "Lkotlin/properties/ReadWriteProperty;", "value", "(Ljava/lang/Object;)V", "ref", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "core_release"})
/* compiled from: Delegates.kt */
final class d<T, R> implements kotlin.e.d<T, R> {
    private WeakReference<R> aSh;

    public d(R r) {
        this.aSh = new WeakReference(r);
    }

    public R b(T t, j<?> jVar) {
        h.e(jVar, "property");
        return this.aSh.get();
    }

    public void a(T t, j<?> jVar, R r) {
        h.e(jVar, "property");
        this.aSh = new WeakReference(r);
    }
}
