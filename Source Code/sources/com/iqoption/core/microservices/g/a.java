package com.iqoption.core.microservices.g;

import com.google.gson.reflect.TypeToken;
import com.iqoption.core.f;
import io.reactivex.o;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0016\n\u0002\u0010\t\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\n\u0010\t\u001a\u00020\n\"\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, aXE = {"Lcom/iqoption/core/microservices/useronline/UserOnlineRequests;", "", "()V", "CMD_GET_USERS_AVAILABILITY", "", "getUsersAvailability", "Lio/reactivex/Single;", "", "Lcom/iqoption/core/microservices/useronline/response/UserAvailability;", "ids", "", "", "core_release"})
/* compiled from: UserOnlineRequests.kt */
public final class a {
    public static final a aZo = new a();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0003"}, aXE = {"com/iqoption/core/ext/GsonExtensionsKt$typeOf$1", "Lcom/google/gson/reflect/TypeToken;", "core_release", "com/iqoption/core/microservices/useronline/UserOnlineRequests$create$$inlined$typeOf$1"})
    /* compiled from: GsonExtensions.kt */
    public static final class a extends TypeToken<List<? extends com.iqoption.core.microservices.g.a.a>> {
    }

    private a() {
    }

    public final o<List<com.iqoption.core.microservices.g.a.a>> c(long... jArr) {
        h.e(jArr, "ids");
        if ((jArr.length == 0 ? 1 : null) != null) {
            throw new IllegalArgumentException("User ids must not be empty");
        }
        Type type = new a().getType();
        h.d(type, "object : TypeToken<T>() {}.type");
        return f.DS().a("get-users-availability", type).j("user_ids", jArr).Sb();
    }
}
