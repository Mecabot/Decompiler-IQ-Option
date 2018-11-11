package com.jumio.nv.view.interactors;

import com.jumio.nv.data.country.Country;
import com.jumio.nv.data.document.DocumentType;
import com.jumio.nv.data.document.NVDocumentVariant;
import com.jumio.nv.extraction.NfcController;
import com.jumio.sdk.models.CredentialsModel;
import com.jumio.sdk.view.InteractibleView;
import java.util.List;

public interface SelectionView extends InteractibleView {
    CredentialsModel getCredentialsModel();

    NfcController getNfcController();

    void hideLoading(boolean z, boolean z2);

    void jumpToScanFragment(boolean z);

    void onCountriesReceived(List<Country> list, Country country, boolean z);

    void onDocumentTypesReceived(List<DocumentType> list, NVDocumentVariant nVDocumentVariant);
}
