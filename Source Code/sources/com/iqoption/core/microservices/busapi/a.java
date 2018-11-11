package com.iqoption.core.microservices.busapi;

import com.google.common.util.concurrent.s;
import com.iqoption.core.connect.k;
import com.iqoption.core.f;
import com.iqoption.core.microservices.busapi.response.b;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, aXE = {"Lcom/iqoption/core/microservices/busapi/BusApiRequests;", "", "()V", "CANCEL_FORGET_USER", "", "FORGET_USER", "GET_FORGET_USER_STATUS", "SET_PERSONAL_DATA_POLICY", "USER_FORGOTTEN", "cancelForgetUser", "Lcom/google/common/util/concurrent/ListenableFuture;", "Ljava/lang/Void;", "forgetUser", "setPersonalDataPolicy", "policy", "Lcom/iqoption/core/microservices/busapi/response/PersonalDataPolicy;", "core_release"})
/* compiled from: BusApiRequests.kt */
public final class a {
    public static final a aUn = new a();

    private a() {
    }

    public final s<Void> b(b bVar) {
        h.e(bVar, "policy");
        k gb = f.DS().b("set-personal-data-policy", Void.class).cd(false).gb("1.0");
        Boolean Vu = bVar.Vu();
        if (Vu != null) {
            gb.j("is_agreement_accepted", Boolean.valueOf(Vu.booleanValue()));
        }
        Vu = bVar.Vv();
        if (Vu != null) {
            gb.j("is_email_accepted", Boolean.valueOf(Vu.booleanValue()));
        }
        Vu = bVar.Vw();
        if (Vu != null) {
            gb.j("is_push_accepted", Boolean.valueOf(Vu.booleanValue()));
        }
        Vu = bVar.Vx();
        if (Vu != null) {
            gb.j("is_call_accepted", Boolean.valueOf(Vu.booleanValue()));
        }
        Boolean Vy = bVar.Vy();
        if (Vy != null) {
            gb.j("is_thirdparty_accepted", Boolean.valueOf(Vy.booleanValue()));
        }
        return gb.Sa();
    }

    public final s<Void> Vp() {
        return f.DS().b("forget-user", Void.class).cd(false).gb("1.0").Sa();
    }

    public final s<Void> Vq() {
        return f.DS().b("cancel-forget-user", Void.class).cd(false).gb("1.0").Sa();
    }
}
