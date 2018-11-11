package com.iqoption.core.microservices.pricemovements;

import com.iqoption.core.f;
import io.reactivex.e;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, aXE = {"<anonymous>", "Lio/reactivex/Flowable;", "Lcom/iqoption/core/microservices/pricemovements/response/Signal;", "invoke"})
/* compiled from: PriceMovementsRequests.kt */
final class PriceMovementsRequests$signalsStream$2 extends Lambda implements a<e<com.iqoption.core.microservices.pricemovements.a.a>> {
    public static final PriceMovementsRequests$signalsStream$2 aXh = new PriceMovementsRequests$signalsStream$2();

    PriceMovementsRequests$signalsStream$2() {
        super(0);
    }

    /* renamed from: Jr */
    public final e<com.iqoption.core.microservices.pricemovements.a.a> invoke() {
        return f.DT().c("signal-created", com.iqoption.core.microservices.pricemovements.a.a.class).eT("2.0").Hr();
    }
}
