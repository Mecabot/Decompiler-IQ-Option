package kotlin;

import java.io.Serializable;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004B\u001f\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\bH\u0002R\u0014\u0010\n\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00028\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0013"}, aXE = {"Lkotlin/SynchronizedLazyImpl;", "T", "Lkotlin/Lazy;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "initializer", "Lkotlin/Function0;", "lock", "", "(Lkotlin/jvm/functions/Function0;Ljava/lang/Object;)V", "_value", "value", "getValue", "()Ljava/lang/Object;", "isInitialized", "", "toString", "", "writeReplace", "kotlin-stdlib"})
/* compiled from: LazyJVM.kt */
final class SynchronizedLazyImpl<T> implements Serializable, d<T> {
    private volatile Object _value;
    private a<? extends T> initializer;
    private final Object lock;

    public SynchronizedLazyImpl(a<? extends T> aVar, Object obj) {
        h.e(aVar, "initializer");
        this.initializer = aVar;
        this._value = k.etW;
        if (obj == null) {
            obj = this;
        }
        this.lock = obj;
    }

    public /* synthetic */ SynchronizedLazyImpl(a aVar, Object obj, int i, f fVar) {
        if ((i & 2) != 0) {
            obj = null;
        }
        this(aVar, obj);
    }

    public T getValue() {
        T t = this._value;
        if (t != k.etW) {
            return t;
        }
        T t2;
        synchronized (this.lock) {
            t2 = this._value;
            if (t2 == k.etW) {
                a aVar = this.initializer;
                if (aVar == null) {
                    h.aXZ();
                }
                t2 = aVar.invoke();
                this._value = t2;
                this.initializer = (a) null;
            }
        }
        return t2;
    }

    public boolean isInitialized() {
        return this._value != k.etW;
    }

    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }
}
