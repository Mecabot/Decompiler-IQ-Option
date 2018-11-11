package com.jumio.nv.models;

import android.content.Context;
import com.jumio.commons.PersistWith;
import com.jumio.commons.log.Log;
import com.jumio.core.data.document.DocumentScanMode;
import com.jumio.core.data.document.ScanSide;
import com.jumio.core.mvp.model.StaticModel;
import com.jumio.nv.NetverifyDocumentData;
import com.jumio.nv.data.country.Country;
import com.jumio.nv.data.document.DocumentType;
import com.jumio.nv.data.document.NVDocumentType;
import com.jumio.nv.data.document.NVDocumentVariant;
import com.jumio.persistence.DataAccess;
import java.util.ArrayList;

@PersistWith("SelectionModel")
public class SelectionModel implements StaticModel {
    private Country a;
    private DocumentType b;
    private NVDocumentVariant c = NVDocumentVariant.PLASTIC;
    private boolean d = false;
    private UploadDataModel e;
    private boolean f;

    public Country getSelectedCountry() {
        return this.a;
    }

    public void setSelectedCountry(Country country) {
        this.a = country;
    }

    public void buildUploadModel(Context context) {
        if (getSelectedDoctype() != null && getSelectedCountry() != null) {
            Log.i("SelectionModel", "creating upload model");
            this.e = new UploadDataModel();
            int i = 0;
            if (isVerificationRequired()) {
                ScanSide[] a = a(context);
                int length = a.length;
                int i2 = 0;
                while (i < length) {
                    ScanSide scanSide = a[i];
                    int i3 = i2 + 1;
                    this.e.add(new NVScanPartModel(scanSide, a(scanSide), i2));
                    i++;
                    i2 = i3;
                }
                return;
            }
            ScanSide documentScanSide = getSelectedDoctype().getDocumentScanSide();
            this.e.add(new NVScanPartModel(documentScanSide, a(documentScanSide), 0));
        }
    }

    private ScanSide[] a(Context context) {
        int parts = getSelectedDoctype().getParts() + (getSelectedDoctype().getDocumentScanSide().getPartNumber() >= getSelectedDoctype().getParts() ? 1 : 0);
        ArrayList arrayList = new ArrayList();
        if (parts >= 1) {
            arrayList.add(ScanSide.FRONT);
        }
        if (parts >= 2) {
            arrayList.add(ScanSide.BACK);
        }
        MerchantSettingsModel merchantSettingsModel = (MerchantSettingsModel) DataAccess.load(context, MerchantSettingsModel.class);
        if (merchantSettingsModel != null && merchantSettingsModel.isFaceMatchEnabled()) {
            arrayList.add(ScanSide.FACE);
        }
        return (ScanSide[]) arrayList.toArray(new ScanSide[arrayList.size()]);
    }

    private DocumentScanMode a(ScanSide scanSide) {
        if (getSelectedDoctype().getDocumentScanSide() == scanSide) {
            return getSelectedDoctype().getDocumentScanMode();
        }
        if (ScanSide.FACE == scanSide) {
            return DocumentScanMode.FACE;
        }
        if (getSelectedDoctype().getDocumentVariant() != NVDocumentVariant.PAPER) {
            return DocumentScanMode.LINEFINDER;
        }
        if ("DEU".equals(getSelectedCountry().getIsoCode()) && getSelectedDoctype().getId() == NVDocumentType.IDENTITY_CARD) {
            return DocumentScanMode.LINEFINDER;
        }
        return DocumentScanMode.MANUAL;
    }

    public DocumentType getSelectedDoctype() {
        return this.b;
    }

    public void setSelectedDoctype(DocumentType documentType) {
        this.b = documentType;
    }

    public NVDocumentVariant getSelectedVariant() {
        return this.c;
    }

    public void setSelectedVariant(NVDocumentVariant nVDocumentVariant) {
        this.c = nVDocumentVariant;
        if (this.b != null) {
            this.b.setDocumentVariant(nVDocumentVariant);
        }
    }

    public boolean isVerificationRequired() {
        return this.d;
    }

    public void setVerificationRequired(boolean z) {
        this.d = z;
    }

    public UploadDataModel getUploadModel() {
        return this.e;
    }

    public void setUploadModel(UploadDataModel uploadDataModel) {
        this.e = uploadDataModel;
    }

    public void populateData(NetverifyDocumentData netverifyDocumentData) {
        netverifyDocumentData.setSelectedCountry(this.a.getIsoCode());
        netverifyDocumentData.setSelectedDocumentType(this.b.getId());
    }

    public boolean isAddressEnabled() {
        return this.f;
    }

    public void setAddressEnabled(boolean z) {
        this.f = z;
    }
}
