package jumio.nv.barcode;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import com.jumio.commons.camera.CameraUtils;
import com.jumio.commons.log.Log;
import com.jumio.commons.log.Log.LogLevel;
import com.jumio.commons.log.LogUtils;
import com.jumio.core.ImageQuality;
import com.jumio.core.data.document.DocumentScanMode;
import com.jumio.nv.barcode.decoder.PDF417Data;
import com.jumio.nv.barcode.decoder.PDF417DataDecoder;
import com.jumio.nv.models.DocumentDataModel;
import com.jumio.nv.models.SelectionModel;
import com.jumio.nv.utils.NetverifyLogUtils;
import com.jumio.persistence.DataAccess;
import com.jumio.sdk.extraction.ExtractionClient;
import com.jumio.sdk.extraction.ExtractionClient.ExtractionUpdate;
import com.jumio.sdk.extraction.ExtractionUpdateState;
import com.microblink.directApi.Recognizer;
import com.microblink.hardware.orientation.Orientation;
import com.microblink.image.Image;
import com.microblink.image.ImageBuilder;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.b;
import com.microblink.recognizers.blinkbarcode.pdf417.Pdf417ScanResult;
import com.microblink.results.barcode.BarcodeDetailedData;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Arrays;

/* compiled from: BarcodeClient */
public class a extends ExtractionClient<ExtractionUpdate, DocumentDataModel> implements com.microblink.directApi.a {
    private a a = null;
    private boolean b = false;
    private Recognizer c;
    private final Object d = new Object();
    private DocumentScanMode e;

    /* compiled from: BarcodeClient */
    class a extends Thread implements com.microblink.view.recognition.a {
        private byte[] b;
        private float c;
        private int d;
        private int e;
        private Image f;

        public a(byte[] bArr) {
            this.b = Arrays.copyOf(bArr, bArr.length);
        }

        public void run() {
            this.d = a.this.getPreviewProperties().camera.width;
            this.e = a.this.getPreviewProperties().camera.height;
            this.c = ImageQuality.calculateFocus(this.b, this.d, this.e, false);
            a.this.a(new ExtractionUpdate(ExtractionUpdateState.notifyFlash, Boolean.valueOf(ImageQuality.isFlashNeeded(this.b, this.d, this.e, false))));
            synchronized (a.this.d) {
                if (a.this.c == null) {
                } else {
                    this.f = ImageBuilder.a(this.b, this.d, this.e, Orientation.ORIENTATION_LANDSCAPE_LEFT, null);
                    a.this.c.a(this.f, (com.microblink.view.recognition.a) this);
                    try {
                    } catch (Exception unused) {
                    }
                }
            }
        }

        public void onScanningDone(@Nullable b bVar) {
            if (this.f != null) {
                try {
                    this.f.dispose();
                    this.f = null;
                } catch (Exception unused) {
                    if (bVar != null) {
                        BaseRecognitionResult[] aPf = bVar.aPf();
                        boolean z = false;
                        if (aPf != null && aPf.length == 1) {
                            boolean z2 = false;
                            for (BaseRecognitionResult baseRecognitionResult : aPf) {
                                boolean z3 = !baseRecognitionResult.isEmpty() && baseRecognitionResult.isValid();
                                BarcodeDetailedData aPh = baseRecognitionResult instanceof Pdf417ScanResult ? ((Pdf417ScanResult) baseRecognitionResult).aPh() : null;
                                if (aPh != null) {
                                    if (z3) {
                                        z2 = a.this.a(new String(aPh.aPl()), CameraUtils.yuv2bitmap(this.b, a.this.mIsPortrait, a.this.getPreviewProperties(), a.this.extractionArea, -1), this.d, this.e, this.c);
                                    } else {
                                        Log.d("Photopay", aPh.toString());
                                    }
                                }
                                z2 = z3;
                            }
                            z = z2;
                        }
                        synchronized (a.this) {
                            this.b = null;
                            a.this.b = z;
                        }
                    }
                } catch (Throwable th) {
                    Throwable th2 = th;
                }
            }
        }
    }

    public void onRecognizerError(Throwable th) {
    }

    public a(Context context) {
        super(context);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0071 A:{Splitter: B:6:0x0021, ExcHandler: com.microblink.recognition.FeatureNotSupportedException (unused com.microblink.recognition.FeatureNotSupportedException)} */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0071 A:{Splitter: B:6:0x0021, ExcHandler: com.microblink.recognition.FeatureNotSupportedException (unused com.microblink.recognition.FeatureNotSupportedException)} */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0071 A:{Splitter: B:6:0x0021, ExcHandler: com.microblink.recognition.FeatureNotSupportedException (unused com.microblink.recognition.FeatureNotSupportedException)} */
    /* JADX WARNING: Missing block: B:16:?, code:
            r6.c = null;
            d(new com.jumio.sdk.exception.JumioException(com.jumio.nv.enums.NVErrorCase.OCR_LOADING_FAILED));
     */
    public void configure(com.jumio.core.mvp.model.StaticModel r7) {
        /*
        r6 = this;
        r0 = r7 instanceof com.jumio.nv.models.NVScanPartModel;
        if (r0 != 0) goto L_0x000c;
    L_0x0004:
        r7 = new java.lang.IllegalArgumentException;
        r0 = "Configuration model should be an instance of ScanPartModel";
        r7.<init>(r0);
        throw r7;
    L_0x000c:
        r0 = r6.mContext;
        r1 = com.jumio.nv.models.ServerSettingsModel.class;
        r0 = com.jumio.persistence.DataAccess.load(r0, r1);
        r0 = (com.jumio.nv.models.ServerSettingsModel) r0;
        r7 = (com.jumio.nv.models.NVScanPartModel) r7;
        r7 = r7.getScanMode();
        r6.e = r7;
        r7 = r6.d;
        monitor-enter(r7);
        r1 = com.microblink.directApi.Recognizer.aOD();	 Catch:{ FeatureNotSupportedException -> 0x0071, FeatureNotSupportedException -> 0x0071, FeatureNotSupportedException -> 0x0071, FeatureNotSupportedException -> 0x0071 }
        r6.c = r1;	 Catch:{ FeatureNotSupportedException -> 0x0071, FeatureNotSupportedException -> 0x0071, FeatureNotSupportedException -> 0x0071, FeatureNotSupportedException -> 0x0071 }
        r1 = r6.c;	 Catch:{ InvalidLicenceKeyException -> 0x0040 }
        r2 = r0.getBarcodeScannerKey();	 Catch:{ InvalidLicenceKeyException -> 0x0040 }
        r3 = 5;
        r3 = new byte[r3];	 Catch:{ InvalidLicenceKeyException -> 0x0040 }
        r3 = {49, 106, 69, 25, 49};	 Catch:{ InvalidLicenceKeyException -> 0x0040 }
        r4 = 2707057876264250875; // 0x259166cbbd276dfb float:-0.04087637 double:1.0041756561503918E-127;
        r3 = com.jumio.commons.obfuscate.StringObfuscater.format(r3, r4);	 Catch:{ InvalidLicenceKeyException -> 0x0040 }
        r1.aJ(r2, r3);	 Catch:{ InvalidLicenceKeyException -> 0x0040 }
        goto L_0x004b;
    L_0x0040:
        r1 = r6.c;	 Catch:{ FeatureNotSupportedException -> 0x0071, FeatureNotSupportedException -> 0x0071, FeatureNotSupportedException -> 0x0071, FeatureNotSupportedException -> 0x0071 }
        r2 = r6.mContext;	 Catch:{ FeatureNotSupportedException -> 0x0071, FeatureNotSupportedException -> 0x0071, FeatureNotSupportedException -> 0x0071, FeatureNotSupportedException -> 0x0071 }
        r0 = r0.getBarcodeScannerKey();	 Catch:{ FeatureNotSupportedException -> 0x0071, FeatureNotSupportedException -> 0x0071, FeatureNotSupportedException -> 0x0071, FeatureNotSupportedException -> 0x0071 }
        r1.G(r2, r0);	 Catch:{ FeatureNotSupportedException -> 0x0071, FeatureNotSupportedException -> 0x0071, FeatureNotSupportedException -> 0x0071, FeatureNotSupportedException -> 0x0071 }
    L_0x004b:
        r0 = new com.microblink.recognizers.blinkbarcode.pdf417.Pdf417RecognizerSettings;	 Catch:{ FeatureNotSupportedException -> 0x0071, FeatureNotSupportedException -> 0x0071, FeatureNotSupportedException -> 0x0071, FeatureNotSupportedException -> 0x0071 }
        r0.<init>();	 Catch:{ FeatureNotSupportedException -> 0x0071, FeatureNotSupportedException -> 0x0071, FeatureNotSupportedException -> 0x0071, FeatureNotSupportedException -> 0x0071 }
        r1 = 1;
        r0.fM(r1);	 Catch:{ FeatureNotSupportedException -> 0x0071, FeatureNotSupportedException -> 0x0071, FeatureNotSupportedException -> 0x0071, FeatureNotSupportedException -> 0x0071 }
        r0.fL(r1);	 Catch:{ FeatureNotSupportedException -> 0x0071, FeatureNotSupportedException -> 0x0071, FeatureNotSupportedException -> 0x0071, FeatureNotSupportedException -> 0x0071 }
        r2 = new com.microblink.recognizers.settings.RecognitionSettings;	 Catch:{ FeatureNotSupportedException -> 0x0071, FeatureNotSupportedException -> 0x0071, FeatureNotSupportedException -> 0x0071, FeatureNotSupportedException -> 0x0071 }
        r2.<init>();	 Catch:{ FeatureNotSupportedException -> 0x0071, FeatureNotSupportedException -> 0x0071, FeatureNotSupportedException -> 0x0071, FeatureNotSupportedException -> 0x0071 }
        r1 = new com.microblink.recognizers.settings.RecognizerSettings[r1];	 Catch:{ FeatureNotSupportedException -> 0x0071, FeatureNotSupportedException -> 0x0071, FeatureNotSupportedException -> 0x0071, FeatureNotSupportedException -> 0x0071 }
        r3 = 0;
        r1[r3] = r0;	 Catch:{ FeatureNotSupportedException -> 0x0071, FeatureNotSupportedException -> 0x0071, FeatureNotSupportedException -> 0x0071, FeatureNotSupportedException -> 0x0071 }
        r2.a(r1);	 Catch:{ FeatureNotSupportedException -> 0x0071, FeatureNotSupportedException -> 0x0071, FeatureNotSupportedException -> 0x0071, FeatureNotSupportedException -> 0x0071 }
        r2.fN(r3);	 Catch:{ FeatureNotSupportedException -> 0x0071, FeatureNotSupportedException -> 0x0071, FeatureNotSupportedException -> 0x0071, FeatureNotSupportedException -> 0x0071 }
        r0 = r6.c;	 Catch:{ FeatureNotSupportedException -> 0x0071, FeatureNotSupportedException -> 0x0071, FeatureNotSupportedException -> 0x0071, FeatureNotSupportedException -> 0x0071 }
        r1 = r6.mContext;	 Catch:{ FeatureNotSupportedException -> 0x0071, FeatureNotSupportedException -> 0x0071, FeatureNotSupportedException -> 0x0071, FeatureNotSupportedException -> 0x0071 }
        r0.a(r1, r2, r6);	 Catch:{ FeatureNotSupportedException -> 0x0071, FeatureNotSupportedException -> 0x0071, FeatureNotSupportedException -> 0x0071, FeatureNotSupportedException -> 0x0071 }
        goto L_0x007e;
    L_0x006f:
        r0 = move-exception;
        goto L_0x0080;
    L_0x0071:
        r0 = 0;
        r6.c = r0;	 Catch:{ all -> 0x006f }
        r0 = new com.jumio.sdk.exception.JumioException;	 Catch:{ all -> 0x006f }
        r1 = com.jumio.nv.enums.NVErrorCase.OCR_LOADING_FAILED;	 Catch:{ all -> 0x006f }
        r0.<init>(r1);	 Catch:{ all -> 0x006f }
        r6.d(r0);	 Catch:{ all -> 0x006f }
    L_0x007e:
        monitor-exit(r7);	 Catch:{ all -> 0x006f }
        return;
    L_0x0080:
        monitor-exit(r7);	 Catch:{ all -> 0x006f }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: jumio.nv.barcode.a.configure(com.jumio.core.mvp.model.StaticModel):void");
    }

    protected void init() {
        this.b = false;
    }

    public void destroy() {
        cancel();
        synchronized (this.d) {
            if (this.c != null) {
                this.c.terminate();
                this.c = null;
            }
        }
    }

    /* renamed from: a */
    public void feed(byte[] bArr) {
        synchronized (this) {
            if (!(this.b || this.c == null)) {
                this.b = true;
                this.a = new a(bArr);
                this.a.start();
            }
        }
    }

    public void cancel() {
        super.cancel();
        synchronized (this) {
            if (this.a != null) {
                this.a.interrupt();
            }
        }
    }

    public boolean a(String str, Bitmap bitmap, int i, int i2, float f) {
        String str2;
        DocumentDataModel documentDataModel = new DocumentDataModel();
        if (this.e == DocumentScanMode.PDF417) {
            PDF417DataDecoder pDF417DataDecoder = new PDF417DataDecoder();
            String simpleName = getClass().getSimpleName();
            StringBuilder stringBuilder;
            try {
                if (Log.isLogEnabledForLevel(LogLevel.INFO)) {
                    NetverifyLogUtils.logInfoInSubfolder(str, simpleName, "rawdata.text");
                }
                PDF417Data decode = pDF417DataDecoder.decode(str);
                documentDataModel.setIdNumber(decode.getIdNumber());
                documentDataModel.setIssuingDate(decode.getIssueDate());
                documentDataModel.setExpiryDate(decode.getExpiryDate());
                String issuingCountry = decode.getIssuingCountry();
                if (issuingCountry == null || issuingCountry.length() == 0) {
                    issuingCountry = documentDataModel.getSelectedCountry();
                }
                documentDataModel.setIssuingCountry(issuingCountry);
                documentDataModel.setLastName(decode.getLastName());
                documentDataModel.setFirstName(decode.getFirstName());
                documentDataModel.setMiddleName(decode.getMiddleName());
                documentDataModel.setNameSuffix(decode.getNameSuffix());
                documentDataModel.setDob(decode.getDateOfBirth());
                documentDataModel.setGender(decode.getGender());
                documentDataModel.setAddressLine(decode.getAddressStreet1());
                documentDataModel.setCity(decode.getAddressCity());
                documentDataModel.setSubdivision(decode.getAddressState());
                documentDataModel.setPostCode(decode.getAddressZip());
                if (Log.isLogEnabledForLevel(LogLevel.INFO)) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("Image dimensions:");
                    stringBuilder2.append("\r\n");
                    StringBuilder stringBuilder3 = new StringBuilder();
                    stringBuilder3.append("width: ");
                    stringBuilder3.append(i);
                    stringBuilder2.append(stringBuilder3.toString());
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("height: ");
                    stringBuilder.append(i2);
                    stringBuilder2.append(stringBuilder.toString());
                    stringBuilder2.append("\r\n");
                    stringBuilder2.append("\r\n");
                    stringBuilder2.append("Raw Data:");
                    stringBuilder2.append("\r\n");
                    str2 = "";
                    stringBuilder2.append(str.replaceAll(String.format("[^\\x20-\\x7E%s]+", new Object[]{str2}), "<Binary Data>"));
                    stringBuilder2.append("\r\n");
                    stringBuilder2.append("\r\n");
                    stringBuilder2.append("Result:");
                    stringBuilder2.append("\r\n");
                    LogUtils.appendParameter(stringBuilder2, "getIdNumber() ", decode.getIdNumber());
                    LogUtils.appendParameter(stringBuilder2, "getIssueDate() ", decode.getIssueDate());
                    LogUtils.appendParameter(stringBuilder2, "getExpiryDate() ", decode.getExpiryDate());
                    LogUtils.appendParameter(stringBuilder2, "getIssuingCountry() ", decode.getIssuingCountry());
                    LogUtils.appendParameter(stringBuilder2, "getLastName() ", decode.getLastName());
                    LogUtils.appendParameter(stringBuilder2, "getFirstName() ", decode.getFirstName());
                    LogUtils.appendParameter(stringBuilder2, "getMiddleName() ", decode.getMiddleName());
                    LogUtils.appendParameter(stringBuilder2, "getNameSuffix() ", decode.getNameSuffix());
                    LogUtils.appendParameter(stringBuilder2, "getDateOfBirth() ", decode.getDateOfBirth());
                    if (decode.getGender() != null) {
                        LogUtils.appendParameter(stringBuilder2, "getGender() ", decode.getGender().name());
                    }
                    LogUtils.appendParameter(stringBuilder2, "getAddressStreet1() ", decode.getAddressStreet1());
                    LogUtils.appendParameter(stringBuilder2, "getAddressCity() ", decode.getAddressCity());
                    LogUtils.appendParameter(stringBuilder2, "getAddressState() ", decode.getAddressState());
                    LogUtils.appendParameter(stringBuilder2, "getAddressZip() ", decode.getAddressZip());
                    stringBuilder2.append("\r\n");
                    stringBuilder2.append("\r\n");
                    stringBuilder2.append("Unused:");
                    stringBuilder2.append("\r\n");
                    LogUtils.appendParameter(stringBuilder2, "getAddressStreet2() ", decode.getAddressStreet2());
                    LogUtils.appendParameter(stringBuilder2, "getEndorsementCodes() ", decode.getEndorsementCodes());
                    if (decode.getEyeColor() != null) {
                        LogUtils.appendParameter(stringBuilder2, "getEyeColor() ", decode.getEyeColor().name());
                    }
                    LogUtils.appendParameter(stringBuilder2, "getHeight() ", decode.getHeight());
                    LogUtils.appendParameter(stringBuilder2, "getRestrictionCodes() ", decode.getRestrictionCodes());
                    LogUtils.appendParameter(stringBuilder2, "getVehicleClass() ", decode.getVehicleClass());
                    stringBuilder2.append("\r\n");
                    stringBuilder2.append("\r\n");
                    stringBuilder2.append("Unparsed:");
                    stringBuilder2.append("\r\n");
                    stringBuilder2.append(decode.getUnparsedData().toString().replaceAll(String.format("[^\\x20-\\x7E%s]+", new Object[]{str2}), "<Binary Data>"));
                    NetverifyLogUtils.logInfoInSubfolder(stringBuilder2.toString(), simpleName, null);
                }
            } catch (Exception e) {
                if (Log.isLogEnabledForLevel(LogLevel.INFO)) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Raw Data:");
                    stringBuilder.append("\r\n");
                    stringBuilder.append(str);
                    stringBuilder.append("\r\n");
                    stringBuilder.append("\r\n");
                    stringBuilder.append("Result:");
                    stringBuilder.append("\r\n");
                    Writer stringWriter = new StringWriter();
                    e.printStackTrace(new PrintWriter(stringWriter));
                    stringBuilder.append(stringWriter.toString());
                    NetverifyLogUtils.logInfoInSubfolder(stringBuilder.toString(), simpleName, null);
                }
                return false;
            }
        }
        System.gc();
        SelectionModel selectionModel = (SelectionModel) DataAccess.load(this.mContext, SelectionModel.class);
        str2 = documentDataModel.getAddressLine();
        String city = documentDataModel.getCity();
        if (!(selectionModel != null && !selectionModel.isVerificationRequired() && "USA".equals(selectionModel.getSelectedCountry().getIsoCode()) && this.e == DocumentScanMode.PDF417 && (str2 == null || str2.length() == 0 || city == null || city.length() == 0))) {
            a(new ExtractionUpdate(ExtractionUpdateState.shotTaken, Float.valueOf(f)));
        }
        a(new ExtractionUpdate(ExtractionUpdateState.saveImage, bitmap));
        a(new ExtractionUpdate(ExtractionUpdateState.saveExactImage, bitmap));
        f(documentDataModel);
        return true;
    }
}
