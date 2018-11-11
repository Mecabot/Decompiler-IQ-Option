package com.iqoption.core;

import android.content.Context;
import com.google.gson.Gson;
import com.iqoption.core.f.b;
import com.iqoption.core.f.e;
import kotlin.e.d;
import kotlin.i;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 )2\u00020\u0001:\u0001)J\u001a\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00012\b\b\u0002\u0010%\u001a\u00020&H&J\u0010\u0010'\u001a\u00020(2\u0006\u0010$\u001a\u00020\u0001H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0016\u001a\u00020\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0012\u0010\u001a\u001a\u00020\u001bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u001f8VX\u0004¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006*"}, aXE = {"Lcom/iqoption/core/Core;", "", "account", "Lcom/iqoption/core/IQAccount;", "getAccount", "()Lcom/iqoption/core/IQAccount;", "analytics", "Lcom/iqoption/core/analytics/IQAnalytics;", "getAnalytics", "()Lcom/iqoption/core/analytics/IQAnalytics;", "apiConfig", "Lcom/iqoption/core/connect/ApiConfigData;", "getApiConfig", "()Lcom/iqoption/core/connect/ApiConfigData;", "config", "Lcom/iqoption/core/Config;", "getConfig", "()Lcom/iqoption/core/Config;", "connect", "Lcom/iqoption/core/IQConnect;", "getConnect", "()Lcom/iqoption/core/IQConnect;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "timeServer", "Lcom/iqoption/core/TimeServer;", "getTimeServer", "()Lcom/iqoption/core/TimeServer;", "closeConnection", "", "tag", "closeDelay", "", "openConnection", "Lio/reactivex/Completable;", "Companion", "core_release"})
/* compiled from: Core.kt */
public interface c {
    public static final a aMe = a.aMg;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R+\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8@@@X\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0013"}, aXE = {"Lcom/iqoption/core/Core$Companion;", "", "()V", "CLOSE_DELAY", "", "TAG", "", "<set-?>", "Lcom/iqoption/core/Core;", "instance", "getInstance$core_release", "()Lcom/iqoption/core/Core;", "setInstance$core_release", "(Lcom/iqoption/core/Core;)V", "instance$delegate", "Lkotlin/properties/ReadWriteProperty;", "init", "", "core", "core_release"})
    /* compiled from: Core.kt */
    public static final class a {
        private static final d aMf = kotlin.e.a.euA.aYg();
        static final /* synthetic */ a aMg = new a();
        static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(a.class), "instance", "getInstance$core_release()Lcom/iqoption/core/Core;"))};

        public final c RI() {
            return (c) aMf.b(this, apP[0]);
        }

        public final void a(c cVar) {
            h.e(cVar, "<set-?>");
            aMf.a(this, apP[0], cVar);
        }

        private a() {
        }

        public final void b(c cVar) {
            h.e(cVar, "core");
            a(cVar);
            e.aSt.init();
            b.aSl.init();
        }
    }

    b Dp();

    Gson Dq();

    g Dr();

    com.iqoption.core.a.e Ds();

    h Dt();

    com.iqoption.core.connect.a Du();

    io.reactivex.a aX(Object obj);

    Context getContext();

    boolean m(Object obj, int i);
}
