package com.iqoption.core.microservices.usersettings;

import com.google.gson.reflect.TypeToken;
import io.reactivex.c.f;
import io.reactivex.e;
import io.reactivex.o;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import kotlin.i;
import kotlin.j;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tJ\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\tH\u0002J\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u00102\u0006\u0010\u0013\u001a\u00020\fJ\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\u00152\u0006\u0010\u0013\u001a\u00020\fJ!\u0010\u0016\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u00182\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u0013\u001a\u0002H\u0018¢\u0006\u0002\u0010\u0019R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, aXE = {"Lcom/iqoption/core/microservices/usersettings/UserSettingsRequests;", "", "()V", "CMD_GET_USER_SETTINGS", "", "CMD_UPDATE_USER_SETTINGS", "EVENT_USER_SETTINGS_CHANGED", "versionMap", "", "Lcom/iqoption/core/microservices/usersettings/SettingsType;", "", "createConfig", "Lcom/iqoption/core/microservices/usersettings/request/GetSetting;", "settingsType", "getSettingVersion", "getUserSettings", "Lio/reactivex/Single;", "", "Lcom/iqoption/core/microservices/usersettings/response/UserSettingsConfig;", "config", "getUserSettingsUpdates", "Lio/reactivex/Flowable;", "updateUserSettings", "Lio/reactivex/Completable;", "T", "(Lcom/iqoption/core/microservices/usersettings/SettingsType;Ljava/lang/Object;)Lio/reactivex/Completable;", "core_release"})
/* compiled from: UserSettingsRequests.kt */
public final class a {
    private static final Map<SettingsType, Integer> aZu = ac.h(j.D(SettingsType.PRIVACY_SETTINGS, Integer.valueOf(1)));
    public static final a aZv = new a();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0003"}, aXE = {"com/iqoption/core/ext/GsonExtensionsKt$typeOf$1", "Lcom/google/gson/reflect/TypeToken;", "core_release", "com/iqoption/core/microservices/usersettings/UserSettingsRequests$create$$inlined$typeOf$1"})
    /* compiled from: GsonExtensions.kt */
    public static final class a extends TypeToken<com.iqoption.core.microservices.usersettings.b.b> {
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "Lcom/iqoption/core/microservices/usersettings/response/UserSettingsConfig;", "it", "Lcom/iqoption/core/microservices/usersettings/response/UserSettingsResponse;", "apply"})
    /* compiled from: UserSettingsRequests.kt */
    static final class b<T, R> implements f<T, R> {
        public static final b aZw = new b();

        b() {
        }

        /* renamed from: a */
        public final List<com.iqoption.core.microservices.usersettings.b.a> apply(com.iqoption.core.microservices.usersettings.b.b bVar) {
            h.e(bVar, "it");
            return bVar.XM();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0003"}, aXE = {"com/iqoption/core/ext/GsonExtensionsKt$typeOf$1", "Lcom/google/gson/reflect/TypeToken;", "core_release", "com/iqoption/core/microservices/usersettings/UserSettingsRequests$create$$inlined$typeOf$2"})
    /* compiled from: GsonExtensions.kt */
    public static final class c extends TypeToken<Object> {
    }

    private a() {
    }

    private final int b(SettingsType settingsType) {
        Integer num = (Integer) aZu.get(settingsType);
        return num != null ? num.intValue() : 1;
    }

    public final com.iqoption.core.microservices.usersettings.a.a c(SettingsType settingsType) {
        h.e(settingsType, "settingsType");
        String serverValue = settingsType.getServerValue();
        if (serverValue == null) {
            h.aXZ();
        }
        return new com.iqoption.core.microservices.usersettings.a.a(serverValue, b(settingsType));
    }

    public final o<List<com.iqoption.core.microservices.usersettings.b.a>> a(com.iqoption.core.microservices.usersettings.a.a aVar) {
        h.e(aVar, "config");
        Type type = new a().getType();
        h.d(type, "object : TypeToken<T>() {}.type");
        o<List<com.iqoption.core.microservices.usersettings.b.a>> n = com.iqoption.core.f.DS().a("get-user-settings", type).j("configs", com.iqoption.core.f.RQ().Dq().toJsonTree(l.cr(aVar))).gb("2.0").Sb().n(b.aZw);
        h.d(n, "requestBuilderFactory\n  …      .map { it.configs }");
        return n;
    }

    public final e<com.iqoption.core.microservices.usersettings.b.a> b(com.iqoption.core.microservices.usersettings.a.a aVar) {
        h.e(aVar, "config");
        return com.iqoption.core.f.DT().c("user-settings-changed", com.iqoption.core.microservices.usersettings.b.a.class).h("user_id", Long.valueOf(com.iqoption.core.f.Dr().getUserId())).h("name", aVar.getName()).eT("2.0").Hr();
    }

    public final <T> io.reactivex.a a(SettingsType settingsType, T t) {
        h.e(settingsType, "settingsType");
        Type type = new c().getType();
        h.d(type, "object : TypeToken<T>() {}.type");
        io.reactivex.a aWj = com.iqoption.core.f.DS().a("update-user-settings", type).gb("1.0").j("name", settingsType.getServerValue()).j("user_id", Long.valueOf(com.iqoption.core.f.Dr().getUserId())).j("version", Integer.valueOf(b(settingsType))).j("config", com.iqoption.core.f.RQ().Dq().toJsonTree(t)).Sb().aWj();
        h.d(aWj, "requestBuilderFactory.cr…         .ignoreElement()");
        return aWj;
    }
}
