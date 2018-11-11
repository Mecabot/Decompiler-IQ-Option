package com.iqoption.core.e;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.e.d;
import kotlin.i;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0002\u0010\u0005J\"\u0010\t\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\u00032\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\fH\u0002¢\u0006\u0002\u0010\rJ*\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u00032\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\u0010\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0011R\u001c\u0010\u0006\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00018\u00008\u00000\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, aXE = {"Lcom/iqoption/core/kotlin/AtomicReferenceProperty;", "T", "Lkotlin/properties/ReadWriteProperty;", "", "initial", "(Ljava/lang/Object;)V", "ref", "Ljava/util/concurrent/atomic/AtomicReference;", "kotlin.jvm.PlatformType", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "", "value", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "core_release"})
/* compiled from: Delegates.kt */
final class a<T> implements d<Object, T> {
    private final AtomicReference<T> aSf;

    public a(T t) {
        this.aSf = new AtomicReference(t);
    }

    public T b(Object obj, j<?> jVar) {
        h.e(obj, "thisRef");
        h.e(jVar, "property");
        return this.aSf.get();
    }

    public void a(Object obj, j<?> jVar, T t) {
        h.e(obj, "thisRef");
        h.e(jVar, "property");
        this.aSf.set(t);
    }
}
