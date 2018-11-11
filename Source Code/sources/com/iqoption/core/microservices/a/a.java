package com.iqoption.core.microservices.a;

import com.iqoption.core.f;
import com.iqoption.core.microservices.a.a.d;
import io.reactivex.o;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0012J\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0012J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0004J9\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00122\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00042\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\u0002\u0010 J\u0006\u0010!\u001a\u00020\u0016J\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040\u00122\u0006\u0010\u001b\u001a\u00020\u0004J\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00140\u00122\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040%R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006&"}, aXE = {"Lcom/iqoption/core/microservices/auth/AuthRequests;", "", "()V", "API_LOGIN", "", "API_LOGIN_TOKEN", "API_LOGOUT", "API_RETRIEVING", "API_TOKEN", "CMD_GET_SESSIONS", "CMD_TERMINATE_SESSIONS", "SOCIAL_ID_FB", "SOCIAL_ID_GP", "SOCIAL_ID_MAIL", "SOCIAL_ID_OK", "SOCIAL_ID_TW", "SOCIAL_ID_VK", "generateAutoLoginToken", "Lio/reactivex/Single;", "getSessions", "Lcom/iqoption/core/microservices/auth/response/SessionsResponse;", "login", "Lio/reactivex/Completable;", "userId", "", "token", "Lcom/iqoption/core/microservices/auth/response/LoginResponse;", "email", "password", "authCode", "authCodeResend", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lio/reactivex/Single;", "logout", "passwordRecoveryRequest", "terminateSessions", "terminateIds", "", "core_release"})
/* compiled from: AuthRequests.kt */
public final class a {
    public static final a aSK = new a();

    private a() {
    }

    public final o<d> Um() {
        return f.DS().b("get-sessions", d.class).Sb();
    }

    public final o<d> al(List<String> list) {
        h.e(list, "terminateIds");
        return f.DS().b("terminate-sessions", d.class).j("match", list).Sb();
    }
}
