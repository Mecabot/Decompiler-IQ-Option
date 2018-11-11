package jumio.nv.mrz;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.jumio.commons.PersistWith;
import com.jumio.core.data.document.DocumentScanMode;
import com.jumio.core.data.document.ScanSide;
import com.jumio.core.mvp.model.StaticModel;
import com.jumio.mrz.impl.smartEngines.swig.MrzField;
import com.jumio.mrz.impl.smartEngines.swig.MrzResult;
import com.jumio.mrz.impl.smartEngines.swig.StringVector;
import com.jumio.nv.NetverifyDocumentData;
import com.jumio.nv.NetverifyMrzData;
import com.jumio.nv.data.document.NVMRZFormat;
import com.jumio.nv.enums.EMRTDStatus;
import com.jumio.nv.extraction.JumioRect;
import com.jumio.nv.models.DocumentDataModel;
import com.jumio.nv.models.MrtdDataModel;
import com.jumio.nv.models.SelectionModel;
import com.jumio.nv.models.UploadDataModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONObject;

@PersistWith("MrzDataModel")
/* compiled from: MrzDataModel */
public class c extends DocumentDataModel implements StaticModel {
    public static final Creator<c> CREATOR = new Creator<c>() {
        /* renamed from: a */
        public c createFromParcel(Parcel parcel) {
            return new c(parcel);
        }

        /* renamed from: a */
        public c[] newArray(int i) {
            return new c[i];
        }
    };
    private ArrayList<ArrayList<JumioRect>> a;

    public c() {
        this.mrzData = new NetverifyMrzData();
    }

    public c(Parcel parcel) {
        super(parcel);
        int readInt = parcel.readInt();
        if (readInt != 0) {
            this.a = new ArrayList();
            for (int i = 0; i < readInt; i++) {
                List arrayList = new ArrayList();
                parcel.readList(arrayList, JumioRect.class.getClassLoader());
                this.a.add(arrayList);
            }
        }
    }

    public void a(MrzResult mrzResult, NVMRZFormat nVMRZFormat) {
        this.mrzData.setFormat(nVMRZFormat);
        MrzField birthdate = mrzResult.getBirthdate();
        this.mrzData.setDobValid(birthdate.hasChecksumOcrChar() ? birthdate.hasCorrectChecksum() : true);
        birthdate = mrzResult.getDocNum();
        this.mrzData.setIdNumberValid(birthdate.hasChecksumOcrChar() ? birthdate.hasCorrectChecksum() : true);
        if (nVMRZFormat != NVMRZFormat.CNIS) {
            birthdate = mrzResult.getExpidate();
            this.mrzData.setExpiryDateValid(birthdate.hasChecksumOcrChar() ? birthdate.hasCorrectChecksum() : true);
        } else {
            this.mrzData.setExpiryDateValid(true);
        }
        if (nVMRZFormat == NVMRZFormat.MRP) {
            birthdate = mrzResult.getOptData2();
            this.mrzData.setPersonalNumberValid(birthdate.hasChecksumOcrChar() ? birthdate.hasCorrectChecksum() : true);
        } else {
            this.mrzData.setPersonalNumberValid(true);
        }
        if (nVMRZFormat == NVMRZFormat.MRV_A || nVMRZFormat == NVMRZFormat.MRV_B) {
            this.mrzData.setCompositeValid(true);
        } else {
            this.mrzData.setCompositeValid(mrzResult.hasCorrectCompositeChecksum());
        }
    }

    public void a(StringVector stringVector) {
        if (stringVector.size() >= 1) {
            this.mrzData.setMrzLine1(stringVector.get(0));
        }
        if (stringVector.size() >= 2) {
            this.mrzData.setMrzLine2(stringVector.get(1));
        }
        if (stringVector.size() >= 3) {
            this.mrzData.setMrzLine3(stringVector.get(2));
        }
    }

    public void a(ArrayList<ArrayList<JumioRect>> arrayList) {
        this.a = arrayList;
    }

    public void populateData(NetverifyDocumentData netverifyDocumentData, SelectionModel selectionModel) {
        super.populateData(netverifyDocumentData, selectionModel);
        netverifyDocumentData.setMrzData(this.mrzData);
        netverifyDocumentData.setEMRTDStatus(getEMRTDStatus());
        netverifyDocumentData.setPlaceOfBirth(getPlaceOfBirth());
    }

    public void fillRequest(JSONObject jSONObject, SimpleDateFormat simpleDateFormat, SelectionModel selectionModel, UploadDataModel uploadDataModel) {
        ScanSide documentScanSide = selectionModel.getSelectedDoctype().getDocumentScanSide();
        appendValue(jSONObject, "firstName", getFirstName());
        appendValue(jSONObject, "lastName", getLastName());
        appendValue(jSONObject, "extractionSide", documentScanSide == ScanSide.FRONT ? "FRONT" : "BACK");
        appendValue(jSONObject, "issuingDate", getIssuingDate() == null ? null : simpleDateFormat.format(getIssuingDate()));
        List scanModes = uploadDataModel.getScanModes();
        if (scanModes.contains(DocumentScanMode.MRP) || scanModes.contains(DocumentScanMode.TD1) || scanModes.contains(DocumentScanMode.TD2) || scanModes.contains(DocumentScanMode.CNIS) || scanModes.contains(DocumentScanMode.MRV)) {
            NetverifyMrzData mrzData = getMrzData();
            appendValue(jSONObject, "mrzLine1", mrzData.getMrzLine1());
            appendValue(jSONObject, "mrzLine2", mrzData.getMrzLine2());
            appendValue(jSONObject, "mrzLine3", mrzData.getMrzLine3());
            appendValue(jSONObject, "mrzLinesCoordinates", a());
        }
        MrtdDataModel mrtdData = uploadDataModel.getMrtdData();
        if (mrtdData != null && getEMRTDStatus() != null) {
            if (getEMRTDStatus() == EMRTDStatus.VERIFIED || getEMRTDStatus() == EMRTDStatus.DENIED) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("BAC", mrtdData.getBacCheckResult());
                jSONObject2.put("AA", mrtdData.getActiveAuthResult());
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("DSC", mrtdData.getDscCheckResult());
                jSONObject3.put("CSCA", mrtdData.getRootCertCheck());
                JSONObject jSONObject4 = new JSONObject();
                Map htCheckResults = mrtdData.getHtCheckResults();
                if (htCheckResults != null) {
                    for (Entry entry : htCheckResults.entrySet()) {
                        jSONObject4.put((String) entry.getKey(), entry.getValue());
                    }
                    jSONObject3.put("HTC", jSONObject4);
                }
                jSONObject2.put("PA", jSONObject3);
                int[] encodedDataItems = mrtdData.getEncodedDataItems();
                jSONObject3 = new JSONObject();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("\"");
                stringBuilder.append(jSONObject2.toString());
                stringBuilder.append("\"");
                jSONObject3.put("authenticationSteps", stringBuilder.toString());
                jSONObject3.put("authenticationValid", getEMRTDStatus() == EMRTDStatus.VERIFIED);
                jSONObject3.put("additionalData", Arrays.toString(encodedDataItems));
                jSONObject.put("eMRTD", jSONObject3);
            }
        }
    }

    public JSONArray a() {
        if (this.a == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < this.a.size(); i++) {
            ArrayList arrayList = (ArrayList) this.a.get(i);
            JSONArray jSONArray2 = new JSONArray();
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("height", ((JumioRect) arrayList.get(i2)).height());
                jSONObject.put("width", ((JumioRect) arrayList.get(i2)).width());
                jSONObject.put("x", ((JumioRect) arrayList.get(i2)).left);
                jSONObject.put("y", ((JumioRect) arrayList.get(i2)).top);
                jSONArray2.put(jSONObject);
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("mrzLineCoordinates", jSONArray2);
            jSONArray.put(jSONObject2);
        }
        return jSONArray;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.a != null ? this.a.size() : 0);
        if (this.a != null) {
            for (int i2 = 0; i2 < this.a.size(); i2++) {
                parcel.writeList((List) this.a.get(i2));
            }
        }
    }
}
