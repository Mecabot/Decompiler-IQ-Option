package com.iqoption.verify;

import com.iqoption.core.h.d;
import com.iqoption.mobbtech.connect.response.q;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00030\u0001H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/iqoption/core/rx/LiveStreamSupplier;", "", "Lcom/iqoption/mobbtech/connect/response/VerifyCard;", "invoke"})
/* compiled from: VerifyCardsRepository.kt */
final class VerifyCardsRepository$cardsStreams$2 extends Lambda implements a<ConcurrentHashMap<Long, d<List<? extends q>>>> {
    public static final VerifyCardsRepository$cardsStreams$2 dxr = new VerifyCardsRepository$cardsStreams$2();

    VerifyCardsRepository$cardsStreams$2() {
        super(0);
    }

    /* renamed from: ayA */
    public final ConcurrentHashMap<Long, d<List<q>>> invoke() {
        return new ConcurrentHashMap();
    }
}
