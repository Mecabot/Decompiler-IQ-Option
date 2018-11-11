package jumio.bam;

import android.content.Context;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.PointF;
import com.jumio.bam.enums.CreditCardType;
import com.jumio.bam.environment.BamEnvironment;
import com.jumio.commons.camera.CameraUtils;
import com.jumio.commons.camera.PreviewProperties;
import com.jumio.commons.camera.Size;
import com.jumio.commons.json.JumioJSONObject;
import com.jumio.commons.log.Log;
import com.jumio.commons.log.Log.LogLevel;
import com.jumio.commons.utils.ImageUtil;
import com.jumio.core.ImageQuality;
import com.jumio.core.environment.Environment;
import com.jumio.core.mvp.model.StaticModel;
import com.jumio.ocr.impl.smartEngines.swig.OcrCardType;
import com.jumio.ocr.impl.smartEngines.swig.OcrCharStringVector;
import com.jumio.ocr.impl.smartEngines.swig.OcrEngine;
import com.jumio.ocr.impl.smartEngines.swig.OcrEngineInternalSettings;
import com.jumio.ocr.impl.smartEngines.swig.OcrEngineSession;
import com.jumio.ocr.impl.smartEngines.swig.OcrEngineSettings;
import com.jumio.ocr.impl.smartEngines.swig.OcrPoint;
import com.jumio.ocr.impl.smartEngines.swig.OcrQuadrangle;
import com.jumio.ocr.impl.smartEngines.swig.OcrResult;
import com.jumio.ocr.impl.smartEngines.swig.ResultAcceptorInterface;
import com.jumio.persistence.DataAccess;
import com.jumio.sdk.exception.JumioException;
import com.jumio.sdk.extraction.ExtractionClient;
import com.jumio.sdk.extraction.ExtractionClient.ExtractionUpdate;
import com.jumio.sdk.extraction.ExtractionUpdateState;
import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: OcrClient */
public class k extends ExtractionClient<ExtractionUpdate, y> {
    private static int b = 320;
    private static int c = 240;
    protected long a = 0;
    private ExecutorService d;
    private OcrEngine e = null;
    private OcrEngineSession f = null;
    private OcrEngineSettings g = null;
    private final Object h = new Object();
    private a i = null;
    private boolean j = false;
    private Object k = new Object();
    private boolean l = false;
    private byte[] m = null;
    private Object n = new Object();
    private long o = 0;
    private byte[] p = null;
    private StringBuilder q = null;
    private y r;
    private x s;
    private w t;
    private boolean u = false;

    /* compiled from: OcrClient */
    class b extends Thread {
        protected PreviewProperties a;

        public b(byte[] bArr) {
            if (k.this.p == null || k.this.p.length != bArr.length) {
                k.this.p = new byte[bArr.length];
            }
            System.arraycopy(bArr, 0, k.this.p, 0, bArr.length);
            this.a = k.this.getPreviewProperties().copy();
        }

        public void run() {
            try {
                float calculateFocus = ImageQuality.calculateFocus(k.this.p, this.a.preview.width, this.a.preview.height, false);
                if (calculateFocus <= 0.12f) {
                    k.this.g(new ExtractionUpdate(ExtractionUpdateState.notifyFocus, Float.valueOf(calculateFocus)));
                    Log.d("setInImageCheck(false) - focus check");
                    k.this.a(false);
                    return;
                }
                Size size = new Size(-1, -1);
                byte[] a = k.this.a(k.this.p, this.a, size);
                if (a != null) {
                    synchronized (k.this.h) {
                        if (k.this.g != null) {
                            try {
                                k.this.g(new ExtractionUpdate(ExtractionUpdateState.notifyFlash, Boolean.valueOf(ImageQuality.isFlashNeeded(a, size.width, size.height, true))));
                            } catch (Throwable e) {
                                Log.w("ImageCheck", "isFlashNeeded failed!", e);
                            }
                        }
                    }
                }
                if (k.this.f == null || a == null) {
                    Log.d("setInImageCheck(false) - (ocrEngineSession == null || croppedRGB == null");
                    k.this.a(false);
                } else {
                    if (k.this.t.c()) {
                        k.b = Math.min(size.width, 720);
                        k.c = Math.min(size.height, 540);
                    } else {
                        k.b = 320;
                        k.c = 240;
                    }
                    Size size2 = new Size(k.b, k.c);
                    if (k.this.t.b()) {
                        synchronized (k.this.n) {
                            k.this.m = k.this.a(k.this.p, this.a, size2);
                        }
                    }
                    try {
                        k.this.i.a(size.width);
                        k.this.i.b(size.height);
                        aa.b();
                        aa.d();
                        k.this.o = System.currentTimeMillis();
                        synchronized (k.this.h) {
                            if (k.this.g != null) {
                                k.this.g.setNumberRecognitionFlag(true);
                                k.this.g.setNumberContextCorrectionFlag(true);
                                k.this.g.setExpiryRecognitionFlag(k.this.s.a());
                                k.this.g.setExpiryContextCorrectionFlag(k.this.s.a());
                                k.this.g.setNameRecognitionFlag(k.this.s.d());
                                k.this.g.setNameContextCorrectionFlag(k.this.s.d());
                                k.this.g.setUkSortCodeAccountNumberRecognitionFlag(k.this.s.f());
                                k.this.g.setUkSortCodeAccountNumberContextCorrectionFlag(k.this.s.f());
                                k.this.g.setAmexCVVRecognitionFlag(true);
                                k.this.g.setNumberOfQuadranglesToProcess(1);
                                k.this.g.setRawSecondLineRecognitionFlag(false);
                                k.this.g.setCheckUmpFlag(true);
                                k.this.g.setCheckStarbucksFlag(false);
                                k.this.g.setSbcodeRecognitionFlag(true);
                                k.this.g.setLogoAnalysisFlag(false);
                                long currentTimeMillis = System.currentTimeMillis();
                                OcrResult processUncompressedImageData = k.this.f.processUncompressedImageData(a, size.width, size.height, size.width * 3, k.this.g);
                                k.this.r.d(processUncompressedImageData.getUmpCardFlag());
                                OcrCardType cardType = processUncompressedImageData.getCardType();
                                if (k.this.s.a()) {
                                    k.this.l = processUncompressedImageData.getCardExpiry().getToAcceptFlag() & k.this.l;
                                }
                                CreditCardType creditCardType = CreditCardType.UNKNOWN;
                                if (cardType == OcrCardType.OcrCardTypeVisa) {
                                    creditCardType = CreditCardType.VISA;
                                } else if (cardType == OcrCardType.OcrCardTypeMastercard) {
                                    creditCardType = CreditCardType.MASTER_CARD;
                                } else if (cardType == OcrCardType.OcrCardTypeAmericanExpress) {
                                    creditCardType = CreditCardType.AMERICAN_EXPRESS;
                                } else if (cardType == OcrCardType.OcrCardTypeChinaUnionPay) {
                                    creditCardType = CreditCardType.CHINA_UNIONPAY;
                                } else if (cardType == OcrCardType.OcrCardTypeJcb) {
                                    creditCardType = CreditCardType.JCB;
                                } else if (cardType == OcrCardType.OcrCardTypeDinersClubInternational) {
                                    creditCardType = CreditCardType.DINERS_CLUB;
                                } else if (cardType == OcrCardType.OcrCardTypeDiscover) {
                                    creditCardType = CreditCardType.DISCOVER;
                                }
                                k.this.r.a(creditCardType);
                                if (k.this.l && !k.this.s.m().contains(k.this.r.getCardType())) {
                                    k.this.l = false;
                                    k.this.d(new JumioException(i.CREDIT_CARD_NOT_SUPPORTED, 0));
                                }
                                if (k.this.s.a()) {
                                    Pattern compile = Pattern.compile(ab.a());
                                    CharSequence stringBuilder = new StringBuilder();
                                    stringBuilder.append(k.this.r.getCardExpiryDateMonth());
                                    stringBuilder.append("/");
                                    stringBuilder.append(k.this.r.getCardExpiryDateYear());
                                    Matcher matcher = compile.matcher(stringBuilder);
                                    if (k.this.l && !matcher.matches()) {
                                        k.this.l = false;
                                        k.this.d(new JumioException(i.CREDIT_CARD_EXPIRED, 0));
                                    }
                                }
                                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                                String str = "OcrTask";
                                StringBuilder stringBuilder2 = new StringBuilder();
                                stringBuilder2.append("processImageData ");
                                stringBuilder2.append(k.this.t.b() ? "with" : "without");
                                stringBuilder2.append(" logo detector took ");
                                stringBuilder2.append(currentTimeMillis2);
                                stringBuilder2.append(" ms");
                                Log.v(str, stringBuilder2.toString());
                                if (k.this.l) {
                                    k.this.g(new ExtractionUpdate(ExtractionUpdateState.shotTaken, null));
                                    k.this.g(new ExtractionUpdate(l.c, Boolean.valueOf(false)));
                                    synchronized (k.this.n) {
                                        if (k.this.t.b()) {
                                            if (Log.isLogEnabledForLevel(LogLevel.VERBOSE)) {
                                                aa.b(a, size.width, size.height);
                                            }
                                            if (Log.isLogEnabledForLevel(LogLevel.DEBUG)) {
                                                aa.a(k.this.m, k.b, k.c);
                                            }
                                            k.this.g(new ExtractionUpdate(l.b, ImageUtil.rgbToFormat(k.this.m, k.b, k.c, CompressFormat.WEBP, 80)));
                                        }
                                    }
                                    if (Log.isLogEnabledForLevel(LogLevel.INFO)) {
                                        aa.a(size.width, size.height, k.b, k.c);
                                    }
                                }
                            }
                        }
                        k.this.r.e(k.this.l);
                        k.this.f(k.this.r);
                    } catch (Throwable e2) {
                        Log.printStackTrace(e2);
                    }
                    k.this.f.resetSession();
                    Arrays.fill(k.this.p, (byte) 0);
                    k.this.p = null;
                    Log.d(String.format("setInImageCheck(ocrPassed) - %s", new Object[]{Boolean.valueOf(k.this.l)}));
                    k.this.a(k.this.l);
                }
            } catch (Throwable e22) {
                Log.w("ImageCheck", "computeFocusConfidence failed!", e22);
                k.this.a(false);
            }
        }
    }

    /* compiled from: OcrClient */
    class c extends Thread {
        private c() {
        }

        public void run() {
            try {
                String oCREngineSettingsPath = BamEnvironment.getOCREngineSettingsPath(k.this.mContext);
                if (oCREngineSettingsPath == null) {
                    throw new Exception("TEMPLATE_MATCHER loading failed!");
                }
                OcrEngineInternalSettings createFromFilesystem = OcrEngineInternalSettings.createFromFilesystem(oCREngineSettingsPath);
                k.this.i = new a();
                k.this.e = new OcrEngine(createFromFilesystem);
                synchronized (k.this.h) {
                    k.this.g = new OcrEngineSettings();
                    k.this.g.setIntensityThreshold(70);
                    k.this.g.setFocusThreshold(15);
                }
                k.this.f = k.this.e.createSession(k.this.i);
            } catch (Throwable e) {
                Log.printStackTrace(e);
                k.this.d(new JumioException(i.OCR_LOADING_FAILED, 0));
            }
        }
    }

    /* compiled from: OcrClient */
    class a extends ResultAcceptorInterface {
        private int b;
        private int c;

        private a() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:72:0x029c  */
        /* JADX WARNING: Removed duplicated region for block: B:74:0x02b2  */
        /* JADX WARNING: Removed duplicated region for block: B:86:? A:{SYNTHETIC, RETURN} */
        /* JADX WARNING: Removed duplicated region for block: B:81:0x02dd  */
        /* JADX WARNING: Removed duplicated region for block: B:72:0x029c  */
        /* JADX WARNING: Removed duplicated region for block: B:74:0x02b2  */
        /* JADX WARNING: Removed duplicated region for block: B:81:0x02dd  */
        /* JADX WARNING: Removed duplicated region for block: B:86:? A:{SYNTHETIC, RETURN} */
        /* JADX WARNING: Removed duplicated region for block: B:72:0x029c  */
        /* JADX WARNING: Removed duplicated region for block: B:74:0x02b2  */
        /* JADX WARNING: Removed duplicated region for block: B:86:? A:{SYNTHETIC, RETURN} */
        /* JADX WARNING: Removed duplicated region for block: B:81:0x02dd  */
        public void accept(com.jumio.ocr.impl.smartEngines.swig.ResultAcceptorInterfaceSettings.FieldName r22, com.jumio.ocr.impl.smartEngines.swig.OcrCharStringVector r23, int r24, int r25, com.jumio.ocr.impl.smartEngines.swig.ResultAcceptorInterfaceSettings r26, boolean r27) {
            /*
            r21 = this;
            r1 = r21;
            r2 = r22;
            r3 = r26;
            r4 = r27;
            r5 = new java.lang.StringBuilder;
            r5.<init>();
            r6 = "AcceptorInterface.accept(): ";
            r5.append(r6);
            r6 = r22.toString();
            r5.append(r6);
            r6 = " - ";
            r5.append(r6);
            r6 = r23.size();
            r5.append(r6);
            r5 = r5.toString();
            com.jumio.commons.log.Log.d(r5);
            r5 = new java.lang.StringBuilder;
            r5.<init>();
            r6 = 0;
            r7 = 0;
        L_0x0033:
            r8 = (long) r7;
            r10 = r23.size();
            r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
            if (r12 >= 0) goto L_0x0067;
        L_0x003c:
            r8 = r23;
            r9 = r8.get(r7);
            r10 = r9.get();
            r10 = r10.get(r6);
            r10 = r10.getCharacter();
            r5.append(r10);
            r10 = com.jumio.commons.log.Log.LogLevel.INFO;
            r10 = com.jumio.commons.log.Log.isLogEnabledForLevel(r10);
            if (r10 == 0) goto L_0x0064;
        L_0x0059:
            r10 = r22.toString();
            r9 = r9.getQuadrangle();
            jumio.bam.aa.a(r10, r9);
        L_0x0064:
            r7 = r7 + 1;
            goto L_0x0033;
        L_0x0067:
            r8 = r23;
            r9 = java.lang.System.currentTimeMillis();
            r7 = com.jumio.ocr.impl.smartEngines.swig.ResultAcceptorInterfaceSettings.FieldName.NUMBER;
            r7 = r2.equals(r7);
            r11 = 0;
            r12 = 1;
            if (r7 == 0) goto L_0x0126;
        L_0x0077:
            r7 = jumio.bam.k.this;
            r7 = r7.r;
            r7.clear();
            r7 = jumio.bam.k.this;
            r7.l = r4;
            if (r4 == 0) goto L_0x0121;
        L_0x0087:
            r7 = com.jumio.ocr.impl.smartEngines.swig.ResultAcceptorInterfaceSettings.FieldName.EXPIRY;
            r13 = jumio.bam.k.this;
            r13 = r13.s;
            r13 = r13.a();
            r3.setOcrEnabledFlag(r7, r13);
            r7 = com.jumio.ocr.impl.smartEngines.swig.ResultAcceptorInterfaceSettings.FieldName.UK_SORTCODE;
            r13 = jumio.bam.k.this;
            r13 = r13.s;
            r13 = r13.f();
            r3.setOcrEnabledFlag(r7, r13);
            r7 = com.jumio.ocr.impl.smartEngines.swig.ResultAcceptorInterfaceSettings.FieldName.UK_ACCOUNTNUM;
            r13 = jumio.bam.k.this;
            r13 = r13.s;
            r13 = r13.f();
            r3.setOcrEnabledFlag(r7, r13);
            r7 = com.jumio.ocr.impl.smartEngines.swig.ResultAcceptorInterfaceSettings.FieldName.NAME;
            r13 = jumio.bam.k.this;
            r13 = r13.s;
            r13 = r13.d();
            r3.setOcrEnabledFlag(r7, r13);
            r7 = com.jumio.ocr.impl.smartEngines.swig.ResultAcceptorInterfaceSettings.FieldName.NAME_2NDLINE;
            r3.setOcrEnabledFlag(r7, r6);
            r7 = com.jumio.ocr.impl.smartEngines.swig.ResultAcceptorInterfaceSettings.FieldName.AMEX_CVV;
            r3.setOcrEnabledFlag(r7, r12);
            r7 = jumio.bam.k.this;	 Catch:{ JSONException -> 0x00f3 }
            r7 = r7.r;	 Catch:{ JSONException -> 0x00f3 }
            r13 = jumio.bam.k.this;	 Catch:{ JSONException -> 0x00f3 }
            r15 = r1.b;	 Catch:{ JSONException -> 0x00f3 }
            r14 = r1.c;	 Catch:{ JSONException -> 0x00f3 }
            r17 = 6;
            r19 = r7;
            r6 = r23.size();	 Catch:{ JSONException -> 0x00f3 }
            r6 = (int) r6;	 Catch:{ JSONException -> 0x00f3 }
            r6 = r6 - r12;
            r18 = r6 + -4;
            r6 = r14;
            r14 = r8;
            r16 = r6;
            r6 = r13.a(r14, r15, r16, r17, r18);	 Catch:{ JSONException -> 0x00f3 }
            r7 = r19;
            r7.a(r6);	 Catch:{ JSONException -> 0x00f3 }
            goto L_0x00f8;
        L_0x00f3:
            r0 = move-exception;
            r6 = r0;
            com.jumio.commons.log.Log.printStackTrace(r6);
        L_0x00f8:
            r6 = jumio.bam.k.this;
            r7 = new com.jumio.sdk.extraction.ExtractionClient$ExtractionUpdate;
            r8 = jumio.bam.l.a;
            r7.<init>(r8, r11);
            r6.g(r7);
            r6 = jumio.bam.k.this;
            r6 = r6.r;
            r6.a(r5);
            r6 = jumio.bam.k.this;
            r6 = r6.r;
            r7 = "ocrCardNumber";
            r8 = jumio.bam.k.this;
            r13 = r8.o;
            r11 = r9 - r13;
            r6.a(r7, r11);
            goto L_0x0172;
        L_0x0121:
            r11 = jumio.bam.i.CARD_NOT_DETECTED;
            r12 = 1;
            goto L_0x0294;
        L_0x0126:
            r6 = com.jumio.ocr.impl.smartEngines.swig.ResultAcceptorInterfaceSettings.FieldName.EXPIRY;
            r6 = r2.equals(r6);
            if (r6 == 0) goto L_0x0175;
        L_0x012e:
            if (r4 == 0) goto L_0x015f;
        L_0x0130:
            r6 = jumio.bam.k.this;
            r6 = r6.r;
            r7 = new java.lang.StringBuilder;
            r8 = 2;
            r11 = 0;
            r12 = r5.subSequence(r11, r8);
            r7.<init>(r12);
            r6.e(r7);
            r6 = jumio.bam.k.this;
            r6 = r6.r;
            r7 = new java.lang.StringBuilder;
            r11 = r5.length();
            r11 = r11 - r8;
            r8 = r5.length();
            r8 = r5.subSequence(r11, r8);
            r7.<init>(r8);
            r6.f(r7);
        L_0x015f:
            r6 = jumio.bam.k.this;
            r6 = r6.r;
            r7 = "ocrExpiryDate";
            r8 = jumio.bam.k.this;
            r11 = r8.o;
            r13 = r9 - r11;
            r6.a(r7, r13);
        L_0x0172:
            r12 = 1;
            goto L_0x0293;
        L_0x0175:
            r6 = com.jumio.ocr.impl.smartEngines.swig.ResultAcceptorInterfaceSettings.FieldName.UK_SORTCODE;
            r6 = r2.equals(r6);
            if (r6 == 0) goto L_0x01c9;
        L_0x017d:
            r6 = jumio.bam.k.this;
            r6 = r6.r;
            r7 = jumio.bam.k.this;
            r7 = r7.s;
            r7 = r7.f();
            if (r7 == 0) goto L_0x0191;
        L_0x018f:
            r7 = r5;
            goto L_0x0198;
        L_0x0191:
            r7 = new java.lang.StringBuilder;
            r8 = "";
            r7.<init>(r8);
        L_0x0198:
            r6.c(r7);
            r6 = jumio.bam.k.this;
            r6 = r6.r;
            r7 = jumio.bam.k.this;
            r7 = r7.s;
            r7 = r7.f();
            if (r7 == 0) goto L_0x01b1;
        L_0x01ad:
            if (r4 == 0) goto L_0x01b1;
        L_0x01af:
            r7 = 1;
            goto L_0x01b2;
        L_0x01b1:
            r7 = 0;
        L_0x01b2:
            r6.b(r7);
            r6 = jumio.bam.k.this;
            r6 = r6.r;
            r7 = "ocrSortCode";
            r8 = jumio.bam.k.this;
            r11 = r8.o;
            r13 = r9 - r11;
            r6.a(r7, r13);
            goto L_0x0172;
        L_0x01c9:
            r6 = com.jumio.ocr.impl.smartEngines.swig.ResultAcceptorInterfaceSettings.FieldName.UK_ACCOUNTNUM;
            r6 = r2.equals(r6);
            if (r6 == 0) goto L_0x021e;
        L_0x01d1:
            r6 = jumio.bam.k.this;
            r6 = r6.r;
            r7 = jumio.bam.k.this;
            r7 = r7.s;
            r7 = r7.f();
            if (r7 == 0) goto L_0x01e5;
        L_0x01e3:
            r7 = r5;
            goto L_0x01ec;
        L_0x01e5:
            r7 = new java.lang.StringBuilder;
            r8 = "";
            r7.<init>(r8);
        L_0x01ec:
            r6.d(r7);
            r6 = jumio.bam.k.this;
            r6 = r6.r;
            r7 = jumio.bam.k.this;
            r7 = r7.s;
            r7 = r7.f();
            if (r7 == 0) goto L_0x0205;
        L_0x0201:
            if (r4 == 0) goto L_0x0205;
        L_0x0203:
            r7 = 1;
            goto L_0x0206;
        L_0x0205:
            r7 = 0;
        L_0x0206:
            r6.c(r7);
            r6 = jumio.bam.k.this;
            r6 = r6.r;
            r7 = "ocrAccountNumber";
            r8 = jumio.bam.k.this;
            r11 = r8.o;
            r13 = r9 - r11;
            r6.a(r7, r13);
            goto L_0x0172;
        L_0x021e:
            r6 = com.jumio.ocr.impl.smartEngines.swig.ResultAcceptorInterfaceSettings.FieldName.NAME;
            r6 = r2.equals(r6);
            if (r6 == 0) goto L_0x0244;
        L_0x0226:
            r6 = jumio.bam.k.this;
            r6 = r6.r;
            r6.b(r5);
            r6 = jumio.bam.k.this;
            r6 = r6.r;
            r7 = "ocrCardHolderName";
            r8 = jumio.bam.k.this;
            r11 = r8.o;
            r13 = r9 - r11;
            r6.a(r7, r13);
            goto L_0x0172;
        L_0x0244:
            r6 = com.jumio.ocr.impl.smartEngines.swig.ResultAcceptorInterfaceSettings.FieldName.AMEX_CVV;
            r6 = r2.equals(r6);
            if (r6 == 0) goto L_0x0172;
        L_0x024c:
            if (r4 == 0) goto L_0x0172;
        L_0x024e:
            r6 = r23.size();
            r11 = 3;
            r13 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1));
            if (r13 == 0) goto L_0x0262;
        L_0x0258:
            r6 = r23.size();
            r11 = 4;
            r13 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1));
            if (r13 != 0) goto L_0x0172;
        L_0x0262:
            r6 = jumio.bam.k.this;
            r6 = r6.a(r5);
            if (r6 == 0) goto L_0x0172;
        L_0x026a:
            r6 = jumio.bam.k.this;	 Catch:{ JSONException -> 0x028d }
            r6 = r6.r;	 Catch:{ JSONException -> 0x028d }
            r13 = jumio.bam.k.this;	 Catch:{ JSONException -> 0x028d }
            r15 = r1.b;	 Catch:{ JSONException -> 0x028d }
            r7 = r1.c;	 Catch:{ JSONException -> 0x028d }
            r17 = 0;
            r11 = r23.size();	 Catch:{ JSONException -> 0x028d }
            r11 = (int) r11;
            r12 = 1;
            r18 = r11 + -1;
            r14 = r8;
            r16 = r7;
            r7 = r13.a(r14, r15, r16, r17, r18);	 Catch:{ JSONException -> 0x028b }
            r6.b(r7);	 Catch:{ JSONException -> 0x028b }
            goto L_0x0293;
        L_0x028b:
            r0 = move-exception;
            goto L_0x028f;
        L_0x028d:
            r0 = move-exception;
            r12 = 1;
        L_0x028f:
            r6 = r0;
            com.jumio.commons.log.Log.printStackTrace(r6);
        L_0x0293:
            r11 = 0;
        L_0x0294:
            r6 = com.jumio.commons.log.Log.LogLevel.INFO;
            r6 = com.jumio.commons.log.Log.isLogEnabledForLevel(r6);
            if (r6 == 0) goto L_0x02af;
        L_0x029c:
            r2 = r22.toString();
            r5 = r5.toString();
            r6 = jumio.bam.k.this;
            r6 = r6.o;
            r13 = r9 - r6;
            jumio.bam.aa.a(r2, r5, r13, r4);
        L_0x02af:
            if (r11 != 0) goto L_0x02b2;
        L_0x02b1:
            goto L_0x02b3;
        L_0x02b2:
            r12 = 0;
        L_0x02b3:
            if (r12 != 0) goto L_0x02c4;
        L_0x02b5:
            r2 = jumio.bam.i.CARD_NOT_DETECTED;
            if (r11 == r2) goto L_0x02c4;
        L_0x02b9:
            r2 = jumio.bam.k.this;
            r4 = new com.jumio.sdk.exception.JumioException;
            r5 = 0;
            r4.<init>(r11, r5);
            r2.d(r4);
        L_0x02c4:
            r2 = jumio.bam.k.this;
            r4 = jumio.bam.k.this;
            r4 = r4.l;
            r4 = r4 & r12;
            r2.l = r4;
            r2 = jumio.bam.k.this;
            r2.o = r9;
            r2 = jumio.bam.k.this;
            r2 = r2.l;
            if (r2 != 0) goto L_0x02fc;
        L_0x02dd:
            r2 = com.jumio.ocr.impl.smartEngines.swig.ResultAcceptorInterfaceSettings.FieldName.EXPIRY;
            r4 = 0;
            r3.setOcrEnabledFlag(r2, r4);
            r2 = com.jumio.ocr.impl.smartEngines.swig.ResultAcceptorInterfaceSettings.FieldName.UK_SORTCODE;
            r3.setOcrEnabledFlag(r2, r4);
            r2 = com.jumio.ocr.impl.smartEngines.swig.ResultAcceptorInterfaceSettings.FieldName.UK_ACCOUNTNUM;
            r3.setOcrEnabledFlag(r2, r4);
            r2 = com.jumio.ocr.impl.smartEngines.swig.ResultAcceptorInterfaceSettings.FieldName.NAME;
            r3.setOcrEnabledFlag(r2, r4);
            r2 = com.jumio.ocr.impl.smartEngines.swig.ResultAcceptorInterfaceSettings.FieldName.NAME_2NDLINE;
            r3.setOcrEnabledFlag(r2, r4);
            r2 = com.jumio.ocr.impl.smartEngines.swig.ResultAcceptorInterfaceSettings.FieldName.AMEX_CVV;
            r3.setOcrEnabledFlag(r2, r4);
        L_0x02fc:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: jumio.bam.k.a.accept(com.jumio.ocr.impl.smartEngines.swig.ResultAcceptorInterfaceSettings$FieldName, com.jumio.ocr.impl.smartEngines.swig.OcrCharStringVector, int, int, com.jumio.ocr.impl.smartEngines.swig.ResultAcceptorInterfaceSettings, boolean):void");
        }

        public void a(int i) {
            this.b = i;
        }

        public void b(int i) {
            this.c = i;
        }
    }

    public k(Context context) {
        super(context);
        Environment.loadJniInterfaceLib();
        this.d = Executors.newSingleThreadExecutor();
        this.d.submit(new c());
    }

    public void configure(StaticModel staticModel) {
        if (staticModel instanceof v) {
            this.s = (x) DataAccess.load(this.mContext, x.class);
            this.r = new y();
            return;
        }
        throw new InvalidParameterException("Configuration model should be an instance of BamScanPartModel");
    }

    private void c() {
        this.t = (w) DataAccess.load(this.mContext, w.class);
        if (this.t == null) {
            this.u = true;
            this.t = new w();
            return;
        }
        this.u = false;
    }

    protected void init() {
        this.a = System.currentTimeMillis();
        c();
        g(new ExtractionUpdate(l.c, Boolean.valueOf(true)));
        Log.d("setInImageCheck(false) - init");
        a(false);
    }

    public void destroy() {
        cancel();
    }

    /* renamed from: a */
    public void feed(byte[] bArr) {
        if (!d()) {
            Log.d("setInImageCheck(true)");
            a(true);
            if (this.u) {
                c();
            }
            this.d.submit(new b(bArr));
        }
    }

    public void cancel() {
        super.cancel();
    }

    public void a(boolean z) {
        synchronized (this.k) {
            this.j = z;
        }
    }

    private boolean d() {
        boolean z;
        synchronized (this.k) {
            z = this.j;
        }
        return z;
    }

    private byte[] a(byte[] bArr, PreviewProperties previewProperties, Size size) {
        return CameraUtils.yuv2rgb(bArr, this.mIsPortrait, previewProperties, this.extractionArea, 0.75f, size);
    }

    protected JumioJSONObject a(OcrCharStringVector ocrCharStringVector, int i, int i2, int i3, int i4) {
        OcrQuadrangle quadrangle = ocrCharStringVector.get(i3).getQuadrangle();
        OcrQuadrangle quadrangle2 = ocrCharStringVector.get(i4).getQuadrangle();
        PointF a = a(quadrangle.getTopLeft(), i, i2);
        PointF a2 = a(quadrangle2.getTopRight(), i, i2);
        PointF a3 = a(quadrangle.getBottomLeft(), i, i2);
        PointF a4 = a(quadrangle2.getBottomRight(), i, i2);
        a(a, a2, a3, a4);
        JumioJSONObject jumioJSONObject = new JumioJSONObject();
        jumioJSONObject.put("topLeft", a(a));
        jumioJSONObject.put("bottomLeft", a(a3));
        jumioJSONObject.put("topRight", a(a2));
        jumioJSONObject.put("bottomRight", a(a4));
        if (Log.isLogEnabledForLevel(LogLevel.INFO)) {
            aa.a(quadrangle, quadrangle2, jumioJSONObject);
        }
        return jumioJSONObject;
    }

    private JumioJSONObject a(PointF pointF) {
        JumioJSONObject jumioJSONObject = new JumioJSONObject();
        jumioJSONObject.put("x", (double) pointF.x);
        jumioJSONObject.put("y", (double) pointF.y);
        return jumioJSONObject;
    }

    private void a(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        pointF.x = ((float) Math.floor((double) pointF.x)) - 1.0f;
        pointF.y = ((float) Math.floor((double) pointF.y)) - 1.0f;
        pointF2.x = ((float) Math.ceil((double) pointF2.x)) + 1.0f;
        pointF2.y = ((float) Math.floor((double) pointF2.y)) - 1.0f;
        pointF3.x = ((float) Math.floor((double) pointF3.x)) - 1.0f;
        pointF3.y = ((float) Math.ceil((double) pointF3.y)) + 1.0f;
        pointF4.x = ((float) Math.ceil((double) pointF4.x)) + 1.0f;
        pointF4.y = ((float) Math.ceil((double) pointF4.y)) + 1.0f;
    }

    private PointF a(OcrPoint ocrPoint, int i, int i2) {
        PointF pointF = new PointF();
        pointF.x = (((float) ocrPoint.getX()) * ((float) b)) / ((float) i);
        pointF.y = (((float) ocrPoint.getY()) * ((float) c)) / ((float) i2);
        return pointF;
    }

    private boolean a(StringBuilder stringBuilder) {
        int i = 0;
        if (stringBuilder == null || stringBuilder.length() == 0) {
            return false;
        }
        boolean z = false;
        while (i < stringBuilder.length()) {
            z = Character.isDigit(stringBuilder.charAt(i));
            if (!z) {
                break;
            }
            i++;
        }
        return z;
    }
}
