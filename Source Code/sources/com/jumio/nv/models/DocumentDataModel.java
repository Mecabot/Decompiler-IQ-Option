package com.jumio.nv.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.jumio.commons.PersistWith;
import com.jumio.commons.log.Log;
import com.jumio.commons.utils.StringUtil;
import com.jumio.core.data.document.ScanSide;
import com.jumio.core.mvp.model.StaticModel;
import com.jumio.nv.NetverifyDocumentData;
import com.jumio.nv.enums.NVGender;
import java.text.SimpleDateFormat;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

@PersistWith("DocumentDataModel")
public class DocumentDataModel extends NetverifyDocumentData implements StaticModel {
    public static final Creator<DocumentDataModel> CREATOR = new Creator<DocumentDataModel>() {
        /* renamed from: a */
        public DocumentDataModel createFromParcel(Parcel parcel) {
            return new DocumentDataModel(parcel);
        }

        /* renamed from: a */
        public DocumentDataModel[] newArray(int i) {
            return new DocumentDataModel[i];
        }
    };
    private static final transient String TAG = "DocumentDataModel";

    public DocumentDataModel(Parcel parcel) {
        super(parcel);
    }

    public void parseJson(String str) {
        if (str != null && !str.isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                setIdNumber(checkJsonString(jSONObject.optString("idNumber")));
                setPersonalNumber(checkJsonString(jSONObject.optString("personalNumber")));
                setIssuingDate(parseDate(jSONObject.optString("issueDate"), simpleDateFormat, true));
                setExpiryDate(parseDate(jSONObject.optString("expiryDate"), simpleDateFormat, false));
                setIssuingCountry(checkJsonString(jSONObject.optString("country")));
                setLastName(checkJsonString(jSONObject.optString("lastName")));
                setFirstName(checkJsonString(jSONObject.optString("firstName")));
                setMiddleName(checkJsonString(jSONObject.optString("middleName")));
                setNameSuffix(checkJsonString(jSONObject.optString("nameSuffix")));
                setDob(parseDate(jSONObject.optString("dateOfBirth"), simpleDateFormat, true));
                str = checkJsonString(jSONObject.optString("gender"));
                if (NVGender.M.name().equals(str)) {
                    setGender(NVGender.M);
                } else if (NVGender.F.name().equals(str)) {
                    setGender(NVGender.F);
                }
                setAddressLine(checkJsonString(jSONObject.optString("address")));
                setCity(checkJsonString(jSONObject.optString("city")));
                setSubdivision(checkJsonString(jSONObject.optString("state")));
                setPostCode(checkJsonString(jSONObject.optString("zip")));
                setOriginatingCountry(jSONObject.optString("originatingCountry"));
                setOptionalData1(jSONObject.optString("optData1"));
                setOptionalData2(jSONObject.optString("optData2"));
            } catch (Throwable e) {
                Log.w(TAG, "json exception in parseResponse()", e);
            }
        }
    }

    private String checkJsonString(String str) {
        return (str == null || str.length() == 0 || JSONObject.NULL.toString().equals(str)) ? null : str;
    }

    /* JADX WARNING: Missing block: B:10:0x003a, code:
            if (r3.after(r4.parse(r4.format(new java.util.Date()))) != false) goto L_0x003c;
     */
    private java.util.Date parseDate(java.lang.String r3, java.text.SimpleDateFormat r4, boolean r5) {
        /*
        r2 = this;
        r3 = r2.checkJsonString(r3);
        r0 = 0;
        if (r3 == 0) goto L_0x003c;
    L_0x0007:
        r1 = "^[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$";
        r1 = java.util.regex.Pattern.compile(r1);	 Catch:{ ParseException -> 0x003c }
        r1 = r1.matcher(r3);	 Catch:{ ParseException -> 0x003c }
        r1 = r1.matches();	 Catch:{ ParseException -> 0x003c }
        if (r1 != 0) goto L_0x0018;
    L_0x0017:
        return r0;
    L_0x0018:
        r3 = r4.parse(r3);	 Catch:{ ParseException -> 0x003c }
        if (r5 == 0) goto L_0x003d;
    L_0x001e:
        r4 = new java.text.SimpleDateFormat;	 Catch:{ ParseException -> 0x003d }
        r5 = "dd/MM/yyyy";
        r1 = java.util.Locale.getDefault();	 Catch:{ ParseException -> 0x003d }
        r4.<init>(r5, r1);	 Catch:{ ParseException -> 0x003d }
        r5 = new java.util.Date;	 Catch:{ ParseException -> 0x003d }
        r5.<init>();	 Catch:{ ParseException -> 0x003d }
        r5 = r4.format(r5);	 Catch:{ ParseException -> 0x003d }
        r4 = r4.parse(r5);	 Catch:{ ParseException -> 0x003d }
        r4 = r3.after(r4);	 Catch:{ ParseException -> 0x003d }
        if (r4 == 0) goto L_0x003d;
    L_0x003c:
        r3 = r0;
    L_0x003d:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.nv.models.DocumentDataModel.parseDate(java.lang.String, java.text.SimpleDateFormat, boolean):java.util.Date");
    }

    public void populateData(NetverifyDocumentData netverifyDocumentData, SelectionModel selectionModel) {
        netverifyDocumentData.setIdNumber(getIdNumber());
        netverifyDocumentData.setPersonalNumber(getPersonalNumber());
        netverifyDocumentData.setIssuingDate(getIssuingDate());
        netverifyDocumentData.setExpiryDate(getExpiryDate());
        netverifyDocumentData.setIssuingCountry(getIssuingCountry());
        netverifyDocumentData.setLastName(getLastName());
        netverifyDocumentData.setFirstName(getFirstName());
        netverifyDocumentData.setMiddleName(getMiddleName());
        netverifyDocumentData.setNameSuffix(getNameSuffix());
        netverifyDocumentData.setDob(getDob());
        netverifyDocumentData.setGender(getGender());
        netverifyDocumentData.setOriginatingCountry(getOriginatingCountry());
        netverifyDocumentData.setOptionalData1(getOptionalData1());
        netverifyDocumentData.setOptionalData2(getOptionalData2());
        if (selectionModel.isAddressEnabled()) {
            netverifyDocumentData.setAddressLine(getAddressLine());
            netverifyDocumentData.setCity(getCity());
            netverifyDocumentData.setSubdivision(getSubdivision());
            netverifyDocumentData.setPostCode(getPostCode());
        }
    }

    public void fillRequest(JSONObject jSONObject, SimpleDateFormat simpleDateFormat, SelectionModel selectionModel, UploadDataModel uploadDataModel) {
        ScanSide documentScanSide = selectionModel.getSelectedDoctype().getDocumentScanSide();
        selectionModel.getSelectedCountry();
        String firstName = getFirstName();
        if (!(getMiddleName() == null || getMiddleName().length() == 0)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(firstName);
            stringBuilder.append(" ");
            stringBuilder.append(getMiddleName());
            firstName = stringBuilder.toString();
        }
        appendValue(jSONObject, "firstName", firstName);
        appendValue(jSONObject, "middleName", getMiddleName());
        appendValue(jSONObject, "lastName", getLastName());
        appendValue(jSONObject, "personalNumber", getPersonalNumber());
        appendValue(jSONObject, "number", getIdNumber());
        String str = null;
        appendValue(jSONObject, "issuingDate", getIssuingDate() == null ? null : simpleDateFormat.format(getIssuingDate()));
        appendValue(jSONObject, "dob", getDob() == null ? null : simpleDateFormat.format(getDob()));
        firstName = "expiry";
        if (getExpiryDate() != null) {
            str = simpleDateFormat.format(getExpiryDate());
        }
        appendValue(jSONObject, firstName, str);
        appendValue(jSONObject, "country", getOriginatingCountry());
        appendValue(jSONObject, "optionalData1", getOptionalData1());
        appendValue(jSONObject, "optionalData2", getOptionalData2());
        appendValue(jSONObject, "extractionSide", documentScanSide == ScanSide.FRONT ? "FRONT" : "BACK");
        JSONObject jSONObject2 = new JSONObject();
        appendValue(jSONObject2, "city", getCity());
        appendValue(jSONObject2, "subdivision", getSubdivision());
        appendValue(jSONObject2, "addressLine", StringUtil.trim(getAddressLine(), 100));
        appendValue(jSONObject2, "postCode", getPostCode());
        jSONObject.put("address", jSONObject2);
    }

    protected void appendValue(JSONObject jSONObject, String str, String str2) {
        if (str2 != null && str2.length() != 0) {
            jSONObject.put(str, str2);
        }
    }

    protected void appendValue(JSONObject jSONObject, String str, JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0) {
            jSONObject.put(str, jSONArray);
        }
    }

    void replaceFrom(MrtdDataModel mrtdDataModel) {
        setFirstName(mrtdDataModel.getMrzFirstName());
        setLastName(mrtdDataModel.getMrzLastName());
        setPersonalNumber(mrtdDataModel.getMrzPersonalNumber());
        setIdNumber(mrtdDataModel.getMrzIdNumber());
        setIssuingCountry(mrtdDataModel.getMrzIssuingCountry());
        setIssuingDate(mrtdDataModel.getIssuingDate());
        setOriginatingCountry(mrtdDataModel.getMrzOriginatingCountry());
    }
}
