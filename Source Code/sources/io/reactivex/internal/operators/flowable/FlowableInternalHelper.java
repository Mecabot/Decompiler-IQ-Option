package io.reactivex.internal.operators.flowable;

import io.reactivex.c.e;
import org.a.d;

public final class FlowableInternalHelper {

    public enum RequestMax implements e<d> {
        INSTANCE;

        public void accept(d dVar) {
            dVar.request(Long.MAX_VALUE);
        }
    }
}
