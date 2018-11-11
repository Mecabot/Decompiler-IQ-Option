package jumio.nv.barcode-vision;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.SparseArray;
import com.google.android.gms.vision.Frame.Builder;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;
import com.jumio.commons.camera.CameraUtils;
import com.jumio.commons.log.Log;
import com.jumio.commons.log.Log.LogLevel;
import com.jumio.commons.log.LogUtils;
import com.jumio.core.ImageQuality;
import com.jumio.core.data.document.DocumentScanMode;
import com.jumio.core.mvp.model.StaticModel;
import com.jumio.nv.barcode.decoder.PDF417Data;
import com.jumio.nv.barcode.decoder.PDF417DataDecoder;
import com.jumio.nv.enums.NVErrorCase;
import com.jumio.nv.models.DocumentDataModel;
import com.jumio.nv.models.NVScanPartModel;
import com.jumio.nv.models.SelectionModel;
import com.jumio.nv.utils.NetverifyLogUtils;
import com.jumio.persistence.DataAccess;
import com.jumio.sdk.exception.JumioException;
import com.jumio.sdk.extraction.ExtractionClient;
import com.jumio.sdk.extraction.ExtractionClient.ExtractionUpdate;
import com.jumio.sdk.extraction.ExtractionUpdateState;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.ByteBuffer;

/* compiled from: BarcodeVisionClient */
public class a extends ExtractionClient<ExtractionUpdate, DocumentDataModel> {
    private BarcodeDetector a;
    private a b;
    private long c;
    private DocumentScanMode d;

    /* compiled from: BarcodeVisionClient */
    class a extends Thread {
        private BarcodeDetector b;
        private final Object c = new Object();
        private int d = 0;
        private ByteBuffer e;
        private boolean f = false;

        a(BarcodeDetector barcodeDetector) {
            this.b = barcodeDetector;
        }

        void a(byte[] bArr) {
            if (!this.f) {
                synchronized (this.c) {
                    this.d++;
                    this.e = ByteBuffer.allocateDirect(bArr.length);
                    this.e.put(bArr);
                    this.c.notifyAll();
                }
                this.f = true;
            }
        }

        public void run() {
            int i;
            int i2;
            if (a.this.mIsPortrait) {
                i = a.this.getPreviewProperties().preview.height;
                i2 = a.this.getPreviewProperties().preview.width;
            } else {
                i = a.this.getPreviewProperties().preview.width;
                i2 = a.this.getPreviewProperties().preview.height;
            }
            while (!isInterrupted()) {
                synchronized (this.c) {
                    if (this.e == null) {
                        try {
                            this.c.wait();
                        } catch (Throwable e) {
                            Log.d("CameraSource", "Frame processing loop terminated.", e);
                            return;
                        }
                    }
                    float calculateFocus = ImageQuality.calculateFocus(this.e.array(), i, i2, false);
                    a.this.a(new ExtractionUpdate(ExtractionUpdateState.notifyFlash, Boolean.valueOf(ImageQuality.isFlashNeeded(this.e.array(), i, i2, false))));
                    try {
                        Builder timestampMillis = new Builder().setImageData(this.e, i, i2, 17).setTimestampMillis(System.currentTimeMillis());
                        int i3 = this.d;
                        this.d = i3 + 1;
                        SparseArray detect = this.b.detect(timestampMillis.setId(i3).build());
                        if (detect == null || detect.size() == 0) {
                            this.f = false;
                            this.e = null;
                        } else {
                            Bitmap bitmap;
                            Barcode barcode = (Barcode) detect.get(detect.keyAt(0));
                            if (barcode.getBoundingBox() != null) {
                                Bitmap a = a.this.a(this.e.array(), barcode.getBoundingBox(), 5);
                                i2 = a.this.mIsPortrait ? barcode.getBoundingBox().width() : barcode.getBoundingBox().height();
                                bitmap = a;
                                i = a.this.mIsPortrait ? barcode.getBoundingBox().height() : barcode.getBoundingBox().width();
                            } else {
                                bitmap = CameraUtils.yuv2bitmap(this.e.array(), a.this.mIsPortrait, a.this.getPreviewProperties(), a.this.extractionArea, -1);
                            }
                            this.f = a.this.a(barcode.rawValue, bitmap, i, i2, calculateFocus);
                            this.e = null;
                        }
                    } catch (Throwable e2) {
                        Log.printStackTrace(e2);
                        this.f = false;
                    }
                }
            }
        }
    }

    public a(Context context) {
        super(context);
    }

    public void configure(StaticModel staticModel) {
        if (staticModel instanceof NVScanPartModel) {
            this.d = ((NVScanPartModel) staticModel).getScanMode();
            try {
                this.a = new BarcodeDetector.Builder(this.mContext).setBarcodeFormats(2048).build();
                if (this.a.isOperational()) {
                    this.c = System.currentTimeMillis();
                    return;
                }
                throw new Exception("Detector dependencies are not yet available.");
            } catch (Exception unused) {
                d(new JumioException(NVErrorCase.OCR_LOADING_FAILED));
                return;
            }
        }
        throw new IllegalArgumentException("Configuration model should be an instance of ScanPartModel");
    }

    protected void init() {
        this.b = new a(this.a);
        this.b.start();
    }

    public void destroy() {
        if (this.a != null) {
            this.a.release();
            this.a = null;
        }
        cancel();
    }

    /* renamed from: a */
    public void feed(byte[] bArr) {
        synchronized (this) {
            if (this.b != null) {
                this.b.a(bArr);
            }
        }
    }

    public void cancel() {
        super.cancel();
        synchronized (this) {
            if (this.b != null) {
                this.b.interrupt();
                this.b = null;
            }
        }
    }

    private boolean a(String str, Bitmap bitmap, int i, int i2, float f) {
        String str2;
        DocumentDataModel documentDataModel = new DocumentDataModel();
        if (this.d == DocumentScanMode.PDF417) {
            PDF417DataDecoder pDF417DataDecoder = new PDF417DataDecoder();
            String simpleName = getClass().getSimpleName();
            StringBuilder stringBuilder;
            try {
                if (Log.isLogEnabledForLevel(LogLevel.INFO)) {
                    NetverifyLogUtils.logInfoInSubfolder(str, simpleName, "rawdata.txt");
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
                    if (decode.getIdNumber() != null) {
                        decode.getIdNumber();
                    } else {
                        Long.toString(this.c);
                    }
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
        if (!(selectionModel != null && !selectionModel.isVerificationRequired() && "USA".equals(selectionModel.getSelectedCountry().getIsoCode()) && this.d == DocumentScanMode.PDF417 && (str2 == null || str2.length() == 0 || city == null || city.length() == 0))) {
            a(new ExtractionUpdate(ExtractionUpdateState.shotTaken, Float.valueOf(f)));
        }
        a(new ExtractionUpdate(ExtractionUpdateState.saveImage, bitmap));
        a(new ExtractionUpdate(ExtractionUpdateState.saveExactImage, bitmap));
        f(documentDataModel);
        return true;
    }

    private Bitmap a(byte[] bArr, Rect rect, int i) {
        int i2;
        int i3;
        int height;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        Rect rect2 = rect;
        int i9 = i;
        int i10;
        int i11;
        int width;
        if (this.mIsPortrait) {
            i2 = getPreviewProperties().preview.height;
            i3 = getPreviewProperties().preview.width;
            i10 = rect2.top;
            i11 = rect2.left;
            width = rect.width();
            height = rect.height();
            i4 = height;
            i5 = i10;
            i6 = i11;
            i7 = width;
            i8 = i7;
        } else {
            i2 = getPreviewProperties().preview.width;
            i3 = getPreviewProperties().preview.height;
            i10 = rect2.top;
            width = rect.height();
            i11 = rect.width();
            i6 = rect2.left;
            i5 = i10;
            i7 = i11;
            i4 = i7;
            height = width;
            i8 = height;
        }
        if (i9 > 0) {
            int i12;
            int i13;
            float f = ((float) i9) / 100.0f;
            int i14 = (int) (((float) i7) * f);
            i9 = (int) (((float) height) * f);
            int max = Math.max(0, i6 - i14);
            int max2 = Math.max(0, i5 - i9);
            i7 += i14 * 2;
            int i15 = i7 + max > i2 ? (i2 - max) - 1 : i7;
            height += i9 * 2;
            int i16 = height + max2 > i3 ? (i3 - max2) - 1 : height;
            if (this.mIsPortrait) {
                i12 = i15;
                i13 = i16;
            } else {
                i13 = i15;
                i12 = i16;
            }
            return CameraUtils.yuv2bitmap(bArr, this.mIsPortrait, getPreviewProperties(), i15, i16, max, max2, i13, i12);
        }
        return CameraUtils.yuv2bitmap(bArr, this.mIsPortrait, getPreviewProperties(), i7, height, i6, i5, i4, i8);
    }
}
