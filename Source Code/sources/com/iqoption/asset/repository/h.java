package com.iqoption.asset.repository;

import com.iqoption.core.h.d;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B'\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\b0\u0007¢\u0006\u0002\u0010\tR#\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, aXE = {"Lcom/iqoption/asset/repository/UserIdStreamMapCache;", "Key", "Value", "", "userId", "", "streamsMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/iqoption/core/rx/LiveStreamSupplier;", "(JLjava/util/concurrent/ConcurrentHashMap;)V", "getStreamsMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "getUserId", "()J", "asset_release"})
/* compiled from: UserIdStreamMapCache.kt */
public final class h<Key, Value> {
    private final ConcurrentHashMap<Key, d<Value>> aqL;
    private final long userId;

    public h(long j, ConcurrentHashMap<Key, d<Value>> concurrentHashMap) {
        kotlin.jvm.internal.h.e(concurrentHashMap, "streamsMap");
        this.userId = j;
        this.aqL = concurrentHashMap;
    }

    public final long getUserId() {
        return this.userId;
    }

    public final ConcurrentHashMap<Key, d<Value>> Ju() {
        return this.aqL;
    }
}
