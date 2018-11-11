package com.airbnb.lottie.model.a;

import com.airbnb.lottie.e.a;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: BaseAnimatableValue */
abstract class n<V, O> implements m<V, O> {
    final List<a<V>> lt;

    n(V v) {
        this(Collections.singletonList(new a(v)));
    }

    n(List<a<V>> list) {
        this.lt = list;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (!this.lt.isEmpty()) {
            stringBuilder.append("values=");
            stringBuilder.append(Arrays.toString(this.lt.toArray()));
        }
        return stringBuilder.toString();
    }
}
