package com.jumio.nv.models;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.jumio.commons.PersistWith;
import com.jumio.commons.camera.ImageData;
import com.jumio.commons.log.Log;
import com.jumio.core.data.document.DocumentScanMode;
import com.jumio.core.data.document.ScanSide;
import com.jumio.core.mvp.model.StaticModel;
import com.jumio.nv.enums.NVExtractionMethod;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@PersistWith("UploadDataModel")
public class UploadDataModel implements StaticModel {
    private List<NVScanPartModel> a = new ArrayList();
    private Comparator<? super NVScanPartModel> b = new a();
    private MrtdDataModel c;
    private int d;

    class a implements Serializable, Comparator<NVScanPartModel> {
        private a() {
        }

        /* renamed from: a */
        public int compare(NVScanPartModel nVScanPartModel, NVScanPartModel nVScanPartModel2) {
            if (nVScanPartModel.getSideToScan() == nVScanPartModel2.getSideToScan()) {
                return 0;
            }
            return nVScanPartModel.getSideToScan().getPartNumber() < nVScanPartModel2.getSideToScan().getPartNumber() ? -1 : 1;
        }
    }

    @Nullable
    public ImageData getImageDataForPart(ScanSide scanSide) {
        for (NVScanPartModel nVScanPartModel : this.a) {
            if (nVScanPartModel.getSideToScan().equals(scanSide)) {
                return nVScanPartModel.getScannedImage();
            }
        }
        Log.i("UploadDataModel", "getImageDataForPart(): no scan side yet has an ImageData");
        return null;
    }

    @NonNull
    public List<DocumentScanMode> getScanModes() {
        List<DocumentScanMode> arrayList = new ArrayList();
        for (NVScanPartModel scanMode : this.a) {
            arrayList.add(scanMode.getScanMode());
        }
        return arrayList;
    }

    @NonNull
    public NVExtractionMethod getExtractionMethod() {
        List arrayList = new ArrayList();
        for (NVScanPartModel scanMode : this.a) {
            switch (scanMode.getScanMode()) {
                case MRP:
                case MRV:
                case TD1:
                case TD2:
                case CNIS:
                    arrayList.add(NVExtractionMethod.MRZ);
                    break;
                case PDF417:
                    arrayList.add(NVExtractionMethod.BARCODE);
                    break;
                case CSSN:
                case TEMPLATEMATCHER:
                    arrayList.add(NVExtractionMethod.OCR);
                    break;
                default:
                    break;
            }
        }
        NVExtractionMethod nVExtractionMethod = NVExtractionMethod.NONE;
        if (arrayList.size() == 1) {
            return (NVExtractionMethod) arrayList.get(0);
        }
        if (arrayList.size() <= 1) {
            return nVExtractionMethod;
        }
        if (arrayList.contains(NVExtractionMethod.BARCODE) && arrayList.contains(NVExtractionMethod.OCR)) {
            return NVExtractionMethod.BARCODE_OCR;
        }
        return (NVExtractionMethod) arrayList.get(0);
    }

    @Nullable
    public DocumentDataModel getDocumentData() {
        for (NVScanPartModel nVScanPartModel : this.a) {
            if (nVScanPartModel.getDocumentInfo() != null) {
                return nVScanPartModel.getDocumentInfo();
            }
        }
        Log.i("UploadDataModel", "getDocumentData(): no scan side yet has a DocumentDataModel");
        return null;
    }

    public UploadDataModel setDocumentData(ScanSide scanSide, DocumentDataModel documentDataModel) {
        for (NVScanPartModel nVScanPartModel : this.a) {
            if (nVScanPartModel.getSideToScan() == scanSide) {
                nVScanPartModel.setDocumentInfo(documentDataModel);
                return this;
            }
        }
        return this;
    }

    public List<NVScanPartModel> getScans() {
        return this.a;
    }

    @Nullable
    public NVScanPartModel getScan(ScanSide scanSide) {
        for (NVScanPartModel nVScanPartModel : this.a) {
            if (nVScanPartModel.getSideToScan().equals(scanSide)) {
                return nVScanPartModel;
            }
        }
        Log.i("UploadDataModel", "getScan(): no scan yet");
        return null;
    }

    public UploadDataModel add(NVScanPartModel nVScanPartModel) {
        this.a.add(nVScanPartModel);
        Collections.sort(this.a, this.b);
        return this;
    }

    public void remove(ScanSide scanSide) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            NVScanPartModel nVScanPartModel = (NVScanPartModel) this.a.get(i);
            if (nVScanPartModel.getSideToScan() == scanSide) {
                this.a.remove(nVScanPartModel);
            }
        }
    }

    public boolean has(ScanSide scanSide) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            if (((NVScanPartModel) this.a.get(i)).getSideToScan() == scanSide) {
                return true;
            }
        }
        return false;
    }

    public UploadDataModel replace(ScanSide scanSide, NVScanPartModel nVScanPartModel) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            if (((NVScanPartModel) this.a.get(i)).getSideToScan() == scanSide) {
                this.a.set(i, nVScanPartModel);
            }
        }
        return this;
    }

    @Nullable
    public MrtdDataModel getMrtdData() {
        return this.c;
    }

    public void setMrtdData(MrtdDataModel mrtdDataModel, boolean z) {
        this.c = mrtdDataModel;
        if (z && getDocumentData() != null) {
            getDocumentData().replaceFrom(mrtdDataModel);
        }
    }

    public NVScanPartModel nextPart() {
        this.d++;
        return getActivePart();
    }

    public NVScanPartModel getActivePart() {
        return (NVScanPartModel) this.a.get(this.d);
    }

    public void setActivePart(int i) {
        this.d = i;
    }

    public boolean hasNext() {
        return this.a.size() > this.d + 1;
    }

    public boolean allPartsScanned() {
        for (NVScanPartModel nVScanPartModel : this.a) {
            if (nVScanPartModel == null || !nVScanPartModel.isSkipped()) {
                if (!(nVScanPartModel == null || nVScanPartModel.getScannedImage().hasImagePath())) {
                    return false;
                }
            }
        }
        return true;
    }
}
