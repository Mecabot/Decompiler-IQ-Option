package com.iqoption.welcomeonboarding.registration;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.Fragment;
import com.iqoption.core.microservices.configuration.a.c;
import io.reactivex.o;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\r"}, aXE = {"Lcom/iqoption/welcomeonboarding/registration/RegistrationViewModel;", "Landroid/arch/lifecycle/ViewModel;", "()V", "countryViewModel", "Lcom/iqoption/welcomeonboarding/registration/CountryViewModel;", "getMyCountry", "Lio/reactivex/Single;", "Lcom/iqoption/core/microservices/configuration/response/Country;", "useSocket", "", "loadCountries", "Lio/reactivex/Completable;", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: RegistrationViewModel.kt */
public final class RegistrationViewModel extends ViewModel {
    public static final a dMZ = new a();
    private CountryViewModel dMY;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, aXE = {"Lcom/iqoption/welcomeonboarding/registration/RegistrationViewModel$Companion;", "", "()V", "create", "Lcom/iqoption/welcomeonboarding/registration/RegistrationViewModel;", "fragment", "Landroid/support/v4/app/Fragment;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: RegistrationViewModel.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final RegistrationViewModel ac(Fragment fragment) {
            h.e(fragment, "fragment");
            RegistrationViewModel registrationViewModel = (RegistrationViewModel) ViewModelProviders.d(fragment).h(RegistrationViewModel.class);
            registrationViewModel.dMY = CountryViewModel.dMN.K(com.iqoption.core.ext.a.n(fragment));
            h.d(registrationViewModel, "viewModel");
            return registrationViewModel;
        }
    }

    public final o<c> fv(boolean z) {
        CountryViewModel countryViewModel = this.dMY;
        if (countryViewModel == null) {
            h.lS("countryViewModel");
        }
        return countryViewModel.fv(z);
    }
}
