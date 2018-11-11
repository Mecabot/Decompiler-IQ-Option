package com.iqoption.core.data.repository;

import android.support.annotation.UiThread;
import com.google.common.base.Optional;
import com.iqoption.core.microservices.usersettings.SettingsType;
import io.reactivex.c.f;
import io.reactivex.e;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0017J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\r\u001a\u00020\u0007H\u0002J0\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\u00100\u000f\"\u0004\b\u0000\u0010\u00112\u0006\u0010\r\u001a\u00020\u00072\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00110\u0013H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R \u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, aXE = {"Lcom/iqoption/core/data/repository/UserSettingsRepository;", "Lcom/iqoption/core/manager/LogoutClearList$Clearable;", "()V", "DISPOSE_DELAY_MILLIS", "", "settingStreams", "", "Lcom/iqoption/core/microservices/usersettings/SettingsType;", "Lcom/iqoption/core/rx/LiveStreamSupplier;", "Lcom/iqoption/core/microservices/usersettings/response/UserSettingsConfig;", "clearOnLogout", "", "createUserSettingStream", "settingsType", "observeUserSetting", "Lio/reactivex/Flowable;", "Lcom/google/common/base/Optional;", "T", "configClass", "Ljava/lang/Class;", "core_release"})
/* compiled from: UserSettingsRepository.kt */
public final class d implements com.iqoption.core.f.a.a {
    private static final Map<SettingsType, com.iqoption.core.h.d<com.iqoption.core.microservices.usersettings.b.a>> aOQ = new LinkedHashMap();
    public static final d aOR;
    private static final long aqO = 0;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "Lcom/iqoption/core/microservices/usersettings/response/UserSettingsConfig;", "settings", "", "apply"})
    /* compiled from: UserSettingsRepository.kt */
    static final class a<T, R> implements f<T, R> {
        final /* synthetic */ SettingsType aOS;

        a(SettingsType settingsType) {
            this.aOS = settingsType;
        }

        /* renamed from: ai */
        public final com.iqoption.core.microservices.usersettings.b.a apply(List<com.iqoption.core.microservices.usersettings.b.a> list) {
            h.e(list, "settings");
            for (Object next : list) {
                if (h.E(((com.iqoption.core.microservices.usersettings.b.a) next).getName(), this.aOS.getServerValue())) {
                    break;
                }
            }
            Object next2 = null;
            if (next2 == null) {
                h.aXZ();
            }
            return (com.iqoption.core.microservices.usersettings.b.a) next2;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u0001H\u0002H\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u0001H\u0002H\u0002\u0018\u00010\u00010\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "Lcom/google/common/base/Optional;", "T", "kotlin.jvm.PlatformType", "config", "Lcom/iqoption/core/microservices/usersettings/response/UserSettingsConfig;", "apply"})
    /* compiled from: UserSettingsRepository.kt */
    static final class b<T, R> implements f<T, R> {
        final /* synthetic */ Class aOT;

        b(Class cls) {
            this.aOT = cls;
        }

        /* renamed from: a */
        public final Optional<T> apply(com.iqoption.core.microservices.usersettings.b.a aVar) {
            h.e(aVar, "config");
            return Optional.F(aVar.y(this.aOT));
        }
    }

    static {
        d dVar = new d();
        aOR = dVar;
        com.iqoption.core.f.a.a(dVar);
    }

    private d() {
    }

    @UiThread
    public final <T> e<Optional<T>> a(SettingsType settingsType, Class<T> cls) {
        h.e(settingsType, "settingsType");
        h.e(cls, "configClass");
        if (((com.iqoption.core.h.d) aOQ.get(settingsType)) == null) {
            aOQ.put(settingsType, a(settingsType));
        }
        com.iqoption.core.h.d dVar = (com.iqoption.core.h.d) aOQ.get(settingsType);
        e Yg = dVar != null ? dVar.Yg() : null;
        if (Yg == null) {
            throw new TypeCastException("null cannot be cast to non-null type io.reactivex.Flowable<com.iqoption.core.microservices.usersettings.response.UserSettingsConfig>");
        }
        e<Optional<T>> d = Yg.d((f) new b(cls));
        h.d(d, "(settingStreams[settings….asConfig(configClass)) }");
        return d;
    }

    private final com.iqoption.core.h.d<com.iqoption.core.microservices.usersettings.b.a> a(SettingsType settingsType) {
        com.iqoption.core.microservices.usersettings.a.a c = com.iqoption.core.microservices.usersettings.a.aZv.c(settingsType);
        e d = com.iqoption.core.microservices.usersettings.a.aZv.a(c).aWk().d((f) new a(settingsType));
        e b = com.iqoption.core.microservices.usersettings.a.aZv.b(c);
        h.d(d, "init");
        return new com.iqoption.core.h.d(d, b, aqO, null, 8, null);
    }

    @UiThread
    public void Js() {
        for (com.iqoption.core.h.d a : aOQ.values()) {
            com.iqoption.core.h.d.a(a, null, 1, null);
        }
        aOQ.clear();
    }
}
