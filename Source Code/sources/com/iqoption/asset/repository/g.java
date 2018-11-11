package com.iqoption.asset.repository;

import com.iqoption.core.h.d;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, aXE = {"Lcom/iqoption/asset/repository/UserIdStreamCache;", "Value", "", "userId", "", "stream", "Lcom/iqoption/core/rx/LiveStreamSupplier;", "(JLcom/iqoption/core/rx/LiveStreamSupplier;)V", "getStream", "()Lcom/iqoption/core/rx/LiveStreamSupplier;", "getUserId", "()J", "asset_release"})
/* compiled from: UserIdStreamCache.kt */
public final class g<Value> {
    private final d<Value> aqU;
    private final long userId;

    public g(long j, d<Value> dVar) {
        h.e(dVar, "stream");
        this.userId = j;
        this.aqU = dVar;
    }

    public final long getUserId() {
        return this.userId;
    }

    public final d<Value> Jv() {
        return this.aqU;
    }
}
