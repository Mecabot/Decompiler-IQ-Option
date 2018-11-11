package com.iqoption.mobbtech.connect.request;

import com.google.common.util.concurrent.s;
import com.iqoption.core.f;
import com.iqoption.mobbtech.connect.request.a.a.b.a;
import com.iqoption.mobbtech.connect.response.q;
import io.reactivex.e;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\b0\u00072\u0006\u0010\t\u001a\u00020\nJ\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\u0006\u0010\r\u001a\u00020\u000e¨\u0006\u000f"}, aXE = {"Lcom/iqoption/mobbtech/connect/request/VerifyCardsRequests;", "", "()V", "getVerifyCardStatusUpdates", "Lio/reactivex/Flowable;", "Lcom/iqoption/mobbtech/connect/response/VerifyCard;", "requestVerifyCardStatus", "Lcom/google/common/util/concurrent/ListenableFuture;", "", "userId", "", "setVerifyCardUploaded", "", "uuid", "", "IqOption-5.5.1_optionXRelease"})
/* compiled from: VerifyCardRequests.kt */
public final class p {
    public static final p cUB = new p();

    private p() {
    }

    public final s<List<q>> bE(long j) {
        return new a(o.cTm).ga("get-verify-card-status").j("user_id", Long.valueOf(j)).Sa();
    }

    public final e<q> aur() {
        return f.DT().c("verify-card-status-changed", q.class).Hr();
    }

    public final s<l> iu(String str) {
        h.e(str, "uuid");
        return new a(l.class).ga("set-verify-card-uploaded").j("uuid", str).Sa();
    }
}
