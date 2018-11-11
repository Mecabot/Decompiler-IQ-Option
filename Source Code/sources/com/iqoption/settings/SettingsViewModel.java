package com.iqoption.settings;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.Fragment;
import com.google.common.base.Optional;
import com.iqoption.core.data.repository.d;
import com.iqoption.core.microservices.usersettings.SettingsType;
import io.reactivex.e;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\f"}, aXE = {"Lcom/iqoption/settings/SettingsViewModel;", "Landroid/arch/lifecycle/ViewModel;", "()V", "observePrivacySettingsConfig", "Lio/reactivex/Flowable;", "Lcom/google/common/base/Optional;", "Lcom/iqoption/core/microservices/usersettings/response/config/PrivacySettingsConfig;", "setAllowShareDeals", "Lio/reactivex/Completable;", "allowShareDeals", "", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: SettingsViewModel.kt */
public final class SettingsViewModel extends ViewModel {
    public static final a dra = new a();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, aXE = {"Lcom/iqoption/settings/SettingsViewModel$Companion;", "", "()V", "create", "Lcom/iqoption/settings/SettingsViewModel;", "fragment", "Landroid/support/v4/app/Fragment;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: SettingsViewModel.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final SettingsViewModel X(Fragment fragment) {
            h.e(fragment, "fragment");
            ViewModel h = ViewModelProviders.d(fragment).h(SettingsViewModel.class);
            h.d(h, "ViewModelProviders.of(fr…ngsViewModel::class.java)");
            return (SettingsViewModel) h;
        }
    }

    public static final SettingsViewModel X(Fragment fragment) {
        return dra.X(fragment);
    }

    public final e<Optional<com.iqoption.core.microservices.usersettings.b.a.a>> aDY() {
        e<Optional<com.iqoption.core.microservices.usersettings.b.a.a>> c = d.aOR.a(SettingsType.PRIVACY_SETTINGS, com.iqoption.core.microservices.usersettings.b.a.a.class).d(com.iqoption.core.h.i.Yo()).c(com.iqoption.core.h.i.Yp());
        h.d(c, "UserSettingsRepository.o…           .observeOn(ui)");
        return c;
    }

    public final io.reactivex.a eX(boolean z) {
        io.reactivex.a a = com.iqoption.core.microservices.usersettings.a.aZv.a(SettingsType.PRIVACY_SETTINGS, new com.iqoption.core.microservices.usersettings.b.a.a(Boolean.valueOf(z))).b(com.iqoption.core.h.i.Yo()).a(com.iqoption.core.h.i.Yp());
        h.d(a, "UserSettingsRequests.upd…           .observeOn(ui)");
        return a;
    }
}
