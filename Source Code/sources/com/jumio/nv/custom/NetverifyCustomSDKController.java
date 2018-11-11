package com.jumio.nv.custom;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.jumio.core.data.document.ScanSide;
import com.jumio.nv.NetverifyDocumentData;
import com.jumio.nv.NetverifySDK;
import com.jumio.nv.api.calls.NVBackend;
import com.jumio.nv.data.country.Country;
import com.jumio.nv.data.document.DocumentType;
import com.jumio.nv.data.document.NVDocumentType;
import com.jumio.nv.data.document.NVDocumentVariant;
import com.jumio.nv.extraction.NfcController;
import com.jumio.nv.models.InitiateModel;
import com.jumio.nv.models.NVScanPartModel;
import com.jumio.nv.models.SelectionModel;
import com.jumio.nv.view.interactors.SelectionView;
import com.jumio.nv.view.interactors.UploadView;
import com.jumio.persistence.DataAccess;
import com.jumio.sdk.exception.JumioErrorCase;
import com.jumio.sdk.exception.JumioException;
import com.jumio.sdk.models.CredentialsModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jumio.nv.core.b;
import jumio.nv.core.y;
import jumio.nv.core.z;

public final class NetverifyCustomSDKController {
    private HashMap<String, NetverifyCountry> countryList;
    private a internalController;
    private boolean isValid;
    private NetverifyCustomScanPresenter netverifyCustomScanPresenter;
    private y selectionPresenter = new y();
    private z uploadPresenter;

    class a extends b implements SelectionView, UploadView, b.b {
        private CredentialsModel f;
        private Context g;
        private NetverifyCustomSDKInterface h;

        public int getCloseDelay() {
            return 0;
        }

        public void hideLoading(boolean z, boolean z2) {
        }

        public void onDocumentTypesReceived(List<DocumentType> list, NVDocumentVariant nVDocumentVariant) {
        }

        public void uploadComplete() {
        }

        public a(NetverifyCustomSDKInterface netverifyCustomSDKInterface) {
            this.h = netverifyCustomSDKInterface;
        }

        public void a(Activity activity, CredentialsModel credentialsModel, boolean z) {
            super.a(activity, credentialsModel, z);
            a((b.b) this);
            this.g = activity;
            this.f = credentialsModel;
        }

        public void c() {
            NetverifyCustomSDKController.this.isValid = false;
            NVBackend.cancelAllPending();
            super.c();
        }

        public Context getContext() {
            return this.g;
        }

        public void onError(Throwable th) {
            if (th instanceof JumioException) {
                JumioException jumioException = (JumioException) th;
                JumioErrorCase errorCase = jumioException.getErrorCase();
                InitiateModel initiateModel = (InitiateModel) DataAccess.load(this.g, InitiateModel.class);
                this.h.onNetverifyError(errorCase.code(), jumioException.getDetailedErrorCase(), errorCase.localizedMessage(this.g), errorCase.retry(), initiateModel != null ? initiateModel.getJumioScanRef() : null);
            }
        }

        public CredentialsModel getCredentialsModel() {
            return this.f;
        }

        public void jumpToScanFragment(boolean z) {
            this.h.onNetverifyResourcesLoaded();
        }

        public void onCountriesReceived(List<Country> list, Country country, boolean z) {
            NetverifyCustomSDKController.this.countryList = new HashMap();
            for (int i = 0; i < list.size(); i++) {
                Country country2 = (Country) list.get(i);
                List<DocumentType> a = NetverifyCustomSDKController.this.selectionPresenter.a(country2);
                Map hashMap = new HashMap();
                for (DocumentType documentType : a) {
                    hashMap.put(documentType.getId(), Boolean.valueOf(documentType.hasPaperVariant()));
                }
                NetverifyCustomSDKController.this.countryList.put(country2.getIsoCode(), new NetverifyCountry(country2.getIsoCode(), Collections.unmodifiableMap(hashMap)));
            }
            this.h.onNetverifyCountriesReceived(NetverifyCustomSDKController.this.countryList, country != null ? country.getIsoCode() : "");
        }

        public NfcController getNfcController() {
            return super.c(this.g);
        }

        public void finishSDK(Intent intent) {
            if (intent.getIntExtra("com.jumio.nv.RESULT", 1) == -1) {
                this.h.onNetverifyFinished((NetverifyDocumentData) intent.getSerializableExtra(NetverifySDK.EXTRA_SCAN_DATA), intent.getStringExtra(NetverifySDK.EXTRA_SCAN_REFERENCE));
            } else if (intent.getIntExtra("com.jumio.nv.RESULT", 1) == 0) {
                String stringExtra = intent.getStringExtra(NetverifySDK.EXTRA_SCAN_REFERENCE);
                this.h.onNetverifyError(intent.getIntExtra(NetverifySDK.EXTRA_ERROR_CODE, 0), intent.getIntExtra(NetverifySDK.EXTRA_DETAILED_ERROR_CODE, 0), intent.getStringExtra(NetverifySDK.EXTRA_ERROR_MESSAGE), false, stringExtra);
            }
            if (NetverifyCustomSDKController.this.uploadPresenter != null) {
                NetverifyCustomSDKController.this.uploadPresenter.deactivate();
                NetverifyCustomSDKController.this.uploadPresenter.detachView();
                NetverifyCustomSDKController.this.uploadPresenter = null;
            }
        }

        public void e() {
            NetverifyCustomSDKController.this.netverifyCustomScanPresenter = null;
        }
    }

    public NetverifyCustomSDKController(Activity activity, CredentialsModel credentialsModel, NetverifyCustomSDKInterface netverifyCustomSDKInterface) {
        this.internalController = new a(netverifyCustomSDKInterface);
        this.internalController.a(activity, credentialsModel, true);
        this.selectionPresenter.attachView(this.internalController);
        this.selectionPresenter.activate();
        this.isValid = true;
    }

    public List<ScanSide> setDocumentConfiguration(NetverifyCountry netverifyCountry, NVDocumentType nVDocumentType, NVDocumentVariant nVDocumentVariant) {
        if (this.isValid) {
            this.selectionPresenter.activate();
            this.selectionPresenter.a(netverifyCountry.getIsoCode(), nVDocumentType, nVDocumentVariant);
            SelectionModel selectionModel = (SelectionModel) DataAccess.load(this.internalController.getContext(), SelectionModel.class);
            List arrayList = new ArrayList();
            for (NVScanPartModel sideToScan : selectionModel.getUploadModel().getScans()) {
                arrayList.add(sideToScan.getSideToScan());
            }
            return arrayList;
        }
        throw new SDKNotConfiguredException("Controller is already destroyed");
    }

    public NetverifyCustomScanPresenter startScanForPart(ScanSide scanSide, NetverifyCustomScanView netverifyCustomScanView, NetverifyCustomConfirmationView netverifyCustomConfirmationView, NetverifyCustomScanInterface netverifyCustomScanInterface) {
        if (!this.isValid) {
            throw new SDKNotConfiguredException("Controller is already destroyed");
        } else if (this.netverifyCustomScanPresenter != null) {
            throw new SDKNotConfiguredException("Another part is already in progress");
        } else {
            this.selectionPresenter.deactivate();
            Object obj = null;
            Serializable serializable = (SelectionModel) DataAccess.load(this.internalController.getContext(), SelectionModel.class);
            for (NVScanPartModel nVScanPartModel : serializable.getUploadModel().getScans()) {
                if (nVScanPartModel.getSideToScan() == scanSide) {
                    obj = nVScanPartModel;
                }
            }
            DataAccess.delete(this.internalController.getContext(), "fallbackScanPartModel");
            DataAccess.update(this.internalController.getContext(), NVScanPartModel.class, (Serializable) obj);
            serializable.getUploadModel().setActivePart(obj.getPartIndex());
            DataAccess.update(this.internalController.getContext(), SelectionModel.class, serializable);
            this.netverifyCustomScanPresenter = new NetverifyCustomScanPresenter(this.internalController, netverifyCustomScanView, netverifyCustomConfirmationView, netverifyCustomScanInterface);
            return this.netverifyCustomScanPresenter;
        }
    }

    public void retry() {
        if (this.isValid) {
            NVBackend.forceRetry();
            return;
        }
        throw new SDKNotConfiguredException("Controller is already destroyed");
    }

    public void finish() {
        if (this.isValid) {
            SelectionModel selectionModel = (SelectionModel) DataAccess.load(this.internalController.getContext(), SelectionModel.class);
            if (selectionModel.getUploadModel() == null || selectionModel.getUploadModel().allPartsScanned()) {
                NVBackend.finalizeCall(this.internalController.getContext(), this.internalController.getCredentialsModel(), null);
                if (this.uploadPresenter == null) {
                    this.uploadPresenter = new z();
                    this.uploadPresenter.attachView(this.internalController);
                    this.uploadPresenter.activate();
                    return;
                }
                return;
            }
            throw new SDKNotConfiguredException("Parts missing");
        }
        throw new SDKNotConfiguredException("Controller is already destroyed");
    }

    public void pause() {
        if (this.isValid) {
            this.internalController.b(this.internalController.getContext());
            this.internalController.b();
            return;
        }
        throw new SDKNotConfiguredException("Controller is already destroyed");
    }

    public void resume() {
        if (this.isValid) {
            this.internalController.a();
            this.internalController.a(this.internalController.getContext());
            return;
        }
        throw new SDKNotConfiguredException("Controller is already destroyed");
    }

    public void destroy() {
        if (this.isValid) {
            this.isValid = false;
            if (this.uploadPresenter != null) {
                this.uploadPresenter.deactivate();
                this.uploadPresenter.detachView();
            }
            if (this.selectionPresenter != null) {
                this.selectionPresenter.deactivate();
                this.selectionPresenter.detachView();
            }
            this.internalController.c();
            return;
        }
        throw new SDKNotConfiguredException("Controller is already destroyed");
    }
}
