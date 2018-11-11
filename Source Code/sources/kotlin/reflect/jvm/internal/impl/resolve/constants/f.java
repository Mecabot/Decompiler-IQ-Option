package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: constantValues.kt */
public abstract class f<T> {
    private final T value;

    public abstract w h(u uVar);

    public f(T t) {
        this.value = t;
    }

    public T getValue() {
        return this.value;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            Object value = getValue();
            Object obj2 = null;
            if (!(obj instanceof f)) {
                obj = null;
            }
            f fVar = (f) obj;
            if (fVar != null) {
                obj2 = fVar.getValue();
            }
            if (!h.E(value, obj2)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        Object value = getValue();
        return value != null ? value.hashCode() : 0;
    }

    public String toString() {
        return String.valueOf(getValue());
    }
}
