package com.iqoption.verify;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import com.google.common.util.concurrent.s;
import com.iqoption.dto.entity.iqbus.VerifyInitResult;
import com.iqoption.mobbtech.connect.request.api.e;
import com.iqoption.mobbtech.connect.request.p;
import com.iqoption.mobbtech.connect.response.q;
import com.iqoption.util.af;
import io.reactivex.c.f;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import kotlin.d;
import kotlin.i;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;
import org.a.b;

@i(aXC = {1, 1, 11}, aXD = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u000e2\u0006\u0010\u000f\u001a\u00020\u0005J\u001a\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00112\u0006\u0010\u000f\u001a\u00020\u0005J\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005R3\u0010\u0003\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00060\u00048BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, aXE = {"Lcom/iqoption/verify/VerifyCardsRepository;", "", "()V", "cardsStreams", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/iqoption/core/rx/LiveStreamSupplier;", "", "Lcom/iqoption/mobbtech/connect/response/VerifyCard;", "getCardsStreams", "()Ljava/util/concurrent/ConcurrentHashMap;", "cardsStreams$delegate", "Lkotlin/Lazy;", "getVerifyCards", "Landroid/arch/lifecycle/LiveData;", "userId", "observeCardChanges", "Lio/reactivex/Flowable;", "verifyInit", "Lcom/google/common/util/concurrent/ListenableFuture;", "Lcom/iqoption/dto/entity/iqbus/VerifyInitResult;", "cardId", "IqOption-5.5.1_optionXRelease"})
/* compiled from: VerifyCardsRepository.kt */
public final class a {
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(a.class), "cardsStreams", "getCardsStreams()Ljava/util/concurrent/ConcurrentHashMap;"))};
    private static final d dxp = g.f(VerifyCardsRepository$cardsStreams$2.dxr);
    public static final a dxq = new a();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00040\u00012\u0006\u0010\u0005\u001a\u00020\u0002H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "", "Lcom/iqoption/mobbtech/connect/response/VerifyCard;", "kotlin.jvm.PlatformType", "", "it", "apply"})
    /* compiled from: VerifyCardsRepository.kt */
    static final class a<T, R> implements f<T, R> {
        public static final a dxs = new a();

        a() {
        }

        /* renamed from: c */
        public final List<q> apply(q qVar) {
            h.e(qVar, "it");
            return Collections.singletonList(qVar);
        }
    }

    private final ConcurrentHashMap<Long, com.iqoption.core.h.d<List<q>>> aGL() {
        d dVar = dxp;
        j jVar = apP[0];
        return (ConcurrentHashMap) dVar.getValue();
    }

    private a() {
    }

    public final LiveData<List<q>> cm(long j) {
        MutableLiveData mutableLiveData = new MutableLiveData();
        af.a(p.cUB.bE(j), new VerifyCardsRepository$getVerifyCards$1(mutableLiveData), new VerifyCardsRepository$getVerifyCards$2(mutableLiveData), null, 4, null);
        return mutableLiveData;
    }

    public final s<VerifyInitResult> q(long j, long j2) {
        s<VerifyInitResult> q = e.q(j, j2);
        h.d(q, "IQBusJumioRequests.verifyInit(userId, cardId)");
        return q;
    }

    public final io.reactivex.e<List<q>> cn(long j) {
        com.iqoption.core.h.d dVar = (com.iqoption.core.h.d) aGL().get(Long.valueOf(j));
        if (dVar != null) {
            return dVar.Yg();
        }
        io.reactivex.e c = io.reactivex.e.e((Future) p.cUB.bE(j)).c((b) p.cUB.aur().d((f) a.dxs));
        h.d(c, "initial.concatWith(updates)");
        return new com.iqoption.core.h.d(c, 0, null, 6, null).Yg();
    }
}
