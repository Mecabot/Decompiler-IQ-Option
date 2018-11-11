package com.iqoption.core.microservices.e;

import com.iqoption.core.f;
import io.reactivex.o;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, aXE = {"Lcom/iqoption/core/microservices/socialuserprofile/SocialUserProfileRequests;", "", "()V", "CMD_GET_USER_PROFILE_CLIENT", "", "getUserProfile", "Lio/reactivex/Single;", "Lcom/iqoption/core/microservices/socialuserprofile/response/UserProfileClient;", "id", "", "core_release"})
/* compiled from: SocialUserProfileRequests.kt */
public final class a {
    public static final a aXK = new a();

    private a() {
    }

    public final o<com.iqoption.core.microservices.e.a.a> aZ(long j) {
        return f.DS().b("get-user-profile-client", com.iqoption.core.microservices.e.a.a.class).j("user_id", Long.valueOf(j)).Sb();
    }
}
