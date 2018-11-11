package com.iqoption.core.connect;

import com.google.common.util.concurrent.s;
import io.reactivex.o;
import java.util.HashMap;
import kotlin.i;
import org.json.JSONObject;

@i(aXC = {1, 1, 11}, aXD = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H&J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H&J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u000bH&J \u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\r\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u0002H&J$\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\r\u001a\u00020\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH&J\"\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00020\u0012H&J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\b\u001a\u00020\u000bH&J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0015\u001a\u00020\u000bH&J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\b\u001a\u00020\u0017H&J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\b\u001a\u00020\u0019H&J\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\b\u001a\u00020\u0017H&J\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\b\u001a\u00020\u0010H&J\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\b\u001a\u00020\u000bH&¨\u0006\u001d"}, aXE = {"Lcom/iqoption/core/connect/RequestBuilder;", "T", "", "exec", "Lio/reactivex/Single;", "execViaSocket", "Lcom/google/common/util/concurrent/ListenableFuture;", "jsonParams", "value", "Lorg/json/JSONObject;", "microService", "", "param", "name", "values", "", "", "params", "Ljava/util/HashMap;", "path", "requestId", "id", "retryCount", "", "retryFuture", "", "taskType", "timeout", "version", "core_release"})
/* compiled from: RequestBuilder.kt */
public interface k<T> {
    s<T> Sa();

    o<T> Sb();

    k<T> b(HashMap<String, Object> hashMap);

    k<T> c(String str, Iterable<Long> iterable);

    k<T> cd(boolean z);

    k<T> dF(int i);

    k<T> ga(String str);

    k<T> gb(String str);

    k<T> gc(String str);

    k<T> gd(String str);

    k<T> j(String str, Object obj);

    k<T> m(JSONObject jSONObject);
}
