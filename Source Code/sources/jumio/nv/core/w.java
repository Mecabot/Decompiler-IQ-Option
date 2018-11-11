package jumio.nv.core;

import com.jumio.core.mvp.presenter.Presenter;
import com.jumio.nv.data.country.Country;
import com.jumio.nv.models.CountryDocumentModel;
import com.jumio.nv.models.MerchantSettingsModel;
import com.jumio.nv.models.SelectionModel;
import com.jumio.nv.models.ServerSettingsModel;
import com.jumio.nv.view.interactors.CountryListView;
import com.jumio.persistence.DataAccess;
import java.util.Collections;
import java.util.List;

/* compiled from: CountryListPresenter */
public class w extends Presenter<CountryListView> {
    private ServerSettingsModel a;
    private SelectionModel b;
    private MerchantSettingsModel c;

    protected void onStart() {
    }

    protected void onStop() {
    }

    protected void onCreate() {
        super.onCreate();
        this.a = (ServerSettingsModel) DataAccess.load(((CountryListView) getView()).getContext(), ServerSettingsModel.class);
        this.c = (MerchantSettingsModel) DataAccess.load(((CountryListView) getView()).getContext(), MerchantSettingsModel.class);
        this.b = (SelectionModel) DataAccess.load(((CountryListView) getView()).getContext(), SelectionModel.class);
    }

    public List<Country> a() {
        CountryDocumentModel countryModel = this.a.getCountryModel();
        boolean isVerificationRequired = this.b.isVerificationRequired();
        boolean z = !this.b.isVerificationRequired() && this.c.isDataExtractionOnMobileOnly();
        List<Country> countriesFor = countryModel.getCountriesFor(isVerificationRequired, z, this.c.getSupportedDocumentTypes(), this.c.getDocumentVariant());
        Collections.sort(countriesFor);
        return countriesFor;
    }

    public void a(Country country) {
        this.b.setSelectedCountry(country);
        if (getView() != null && ((CountryListView) getView()).getContext() != null) {
            DataAccess.update(((CountryListView) getView()).getContext(), SelectionModel.class, this.b);
        }
    }
}
