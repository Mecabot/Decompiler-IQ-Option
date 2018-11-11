package com.iqoption.core.data.repository;

import com.iqoption.core.h.d;
import io.reactivex.e;
import io.reactivex.o;
import java.util.List;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "Lcom/iqoption/core/rx/LiveStreamSupplier;", "", "Lcom/iqoption/core/microservices/configuration/response/Currency;", "invoke"})
/* compiled from: GeneralRepository.kt */
final class GeneralRepository$currenciesStream$2 extends Lambda implements a<d<List<? extends com.iqoption.core.microservices.configuration.a.d>>> {
    public static final GeneralRepository$currenciesStream$2 aOO = new GeneralRepository$currenciesStream$2();

    GeneralRepository$currenciesStream$2() {
        super(0);
    }

    /* renamed from: JJ */
    public final d<List<com.iqoption.core.microservices.configuration.a.d>> invoke() {
        c cVar = c.aOM;
        o VA = com.iqoption.core.microservices.configuration.a.aUz.VA();
        e VB = com.iqoption.core.microservices.configuration.a.aUz.VB();
        h.d(VB, "ConfigurationRequests.currencyUpdatesStream");
        return cVar.a(VA, VB);
    }
}
