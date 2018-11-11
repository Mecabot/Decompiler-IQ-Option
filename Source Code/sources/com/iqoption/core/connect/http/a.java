package com.iqoption.core.connect.http;

import io.reactivex.c.k;
import kotlin.f.f;
import kotlin.i;
import kotlin.jvm.internal.h;
import okhttp3.Response;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, aXE = {"Lcom/iqoption/core/connect/http/CodeOkResponseValidator;", "Lio/reactivex/functions/Predicate;", "Lokhttp3/Response;", "()V", "STATUS_CODES_OK", "Lkotlin/ranges/IntRange;", "test", "", "t", "core_release"})
/* compiled from: ResponseValidators.kt */
public final class a implements k<Response> {
    private static final f aND = new f(200, 299);
    public static final a aNE = new a();

    private a() {
    }

    /* renamed from: a */
    public boolean test(Response response) {
        h.e(response, "t");
        return aND.contains(response.code());
    }
}
