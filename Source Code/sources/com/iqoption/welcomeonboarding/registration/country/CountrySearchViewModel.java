package com.iqoption.welcomeonboarding.registration.country;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.Fragment;
import com.iqoption.core.microservices.configuration.a.c;
import com.iqoption.welcomeonboarding.registration.CountryViewModel;
import io.reactivex.o;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\u000f"}, aXE = {"Lcom/iqoption/welcomeonboarding/registration/country/CountrySearchViewModel;", "Landroid/arch/lifecycle/ViewModel;", "()V", "countryViewModel", "Lcom/iqoption/welcomeonboarding/registration/CountryViewModel;", "getCountries", "Lio/reactivex/Single;", "", "Lcom/iqoption/core/microservices/configuration/response/Country;", "authorized", "", "filter", "", "getMyCountry", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: CountrySearchViewModel.kt */
public final class CountrySearchViewModel extends ViewModel {
    public static final a dNr = new a();
    private CountryViewModel dMY;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, aXE = {"Lcom/iqoption/welcomeonboarding/registration/country/CountrySearchViewModel$Companion;", "", "()V", "create", "Lcom/iqoption/welcomeonboarding/registration/country/CountrySearchViewModel;", "fragment", "Landroid/support/v4/app/Fragment;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: CountrySearchViewModel.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final CountrySearchViewModel ad(Fragment fragment) {
            h.e(fragment, "fragment");
            CountrySearchViewModel countrySearchViewModel = (CountrySearchViewModel) ViewModelProviders.d(fragment).h(CountrySearchViewModel.class);
            countrySearchViewModel.dMY = CountryViewModel.dMN.K(com.iqoption.core.ext.a.n(fragment));
            h.d(countrySearchViewModel, "viewModel");
            return countrySearchViewModel;
        }
    }

    public final o<List<c>> j(boolean z, String str) {
        CountryViewModel countryViewModel = this.dMY;
        if (countryViewModel == null) {
            h.lS("countryViewModel");
        }
        return countryViewModel.j(z, str);
    }

    public final o<c> fv(boolean z) {
        CountryViewModel countryViewModel = this.dMY;
        if (countryViewModel == null) {
            h.lS("countryViewModel");
        }
        return countryViewModel.fv(z);
    }
}
