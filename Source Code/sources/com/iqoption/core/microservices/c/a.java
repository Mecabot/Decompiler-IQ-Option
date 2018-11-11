package com.iqoption.core.microservices.c;

import com.google.gson.reflect.TypeToken;
import io.reactivex.c.f;
import io.reactivex.o;
import java.lang.reflect.Type;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, aXE = {"Lcom/iqoption/core/microservices/leaderboard/LeaderBoardRequests;", "", "()V", "CMD_REQUEST_LEADERBOARD_USERINFO_DEALS_CLIENT", "", "getLeaderBoardUserInfo", "Lio/reactivex/Single;", "Lcom/iqoption/core/microservices/leaderboard/response/LeaderBoardUserInfo;", "requestedUserId", "", "core_release"})
/* compiled from: LeaderBoardRequests.kt */
public final class a {
    public static final a aWv = new a();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0003"}, aXE = {"com/iqoption/core/ext/GsonExtensionsKt$typeOf$1", "Lcom/google/gson/reflect/TypeToken;", "core_release", "com/iqoption/core/microservices/leaderboard/LeaderBoardRequests$create$$inlined$typeOf$1"})
    /* compiled from: GsonExtensions.kt */
    public static final class a extends TypeToken<com.iqoption.core.microservices.c.a.b> {
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "Lcom/iqoption/core/microservices/leaderboard/response/LeaderBoardUserInfo;", "response", "Lcom/iqoption/core/microservices/leaderboard/response/LeaderBoardUserInfoResponse;", "apply"})
    /* compiled from: LeaderBoardRequests.kt */
    static final class b<T, R> implements f<T, R> {
        public static final b aWw = new b();

        b() {
        }

        /* renamed from: a */
        public final com.iqoption.core.microservices.c.a.a apply(com.iqoption.core.microservices.c.a.b bVar) {
            h.e(bVar, "response");
            return (com.iqoption.core.microservices.c.a.a) bVar.Wc().Wd().get("0");
        }
    }

    private a() {
    }

    public final o<com.iqoption.core.microservices.c.a.a> aX(long j) {
        Type type = new a().getType();
        h.d(type, "object : TypeToken<T>() {}.type");
        o<com.iqoption.core.microservices.c.a.a> n = com.iqoption.core.f.DS().a("request-leaderboard-userinfo-deals-client", type).gb("1.0").j("user_id", Long.valueOf(com.iqoption.core.f.Dr().getUserId())).j("requested_user_id", Long.valueOf(j)).j("country_ids", new String[0]).Sb().n(b.aWw);
        h.d(n, "requestBuilderFactory\n  ….entitiesByCountry[\"0\"] }");
        return n;
    }
}
