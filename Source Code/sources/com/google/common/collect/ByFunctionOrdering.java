package com.google.common.collect;

import com.google.common.base.d;
import com.google.common.base.f;
import com.google.common.base.i;
import java.io.Serializable;

final class ByFunctionOrdering<F, T> extends Ordering<F> implements Serializable {
    private static final long serialVersionUID = 0;
    final d<F, ? extends T> function;
    final Ordering<T> ordering;

    ByFunctionOrdering(d<F, ? extends T> dVar, Ordering<T> ordering) {
        this.function = (d) i.checkNotNull(dVar);
        this.ordering = (Ordering) i.checkNotNull(ordering);
    }

    public int compare(F f, F f2) {
        return this.ordering.compare(this.function.apply(f), this.function.apply(f2));
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByFunctionOrdering)) {
            return false;
        }
        ByFunctionOrdering byFunctionOrdering = (ByFunctionOrdering) obj;
        if (!(this.function.equals(byFunctionOrdering.function) && this.ordering.equals(byFunctionOrdering.ordering))) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return f.hashCode(this.function, this.ordering);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.ordering);
        stringBuilder.append(".onResultOf(");
        stringBuilder.append(this.function);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
