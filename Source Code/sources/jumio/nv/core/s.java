package jumio.nv.core;

import android.content.Context;
import android.graphics.Bitmap;
import com.jumio.commons.camera.CameraUtils;
import com.jumio.commons.camera.PreviewProperties;
import com.jumio.commons.log.Log;
import com.jumio.commons.log.Log.LogLevel;
import com.jumio.core.data.document.DocumentFormat;
import com.jumio.core.environment.Environment;
import com.jumio.core.mvp.model.StaticModel;
import com.jumio.nv.enums.NVErrorCase;
import com.jumio.nv.environment.NVEnvironment;
import com.jumio.nv.models.NVScanPartModel;
import com.jumio.ocr.impl.smartEngines.swig.DetectionEngine;
import com.jumio.ocr.impl.smartEngines.swig.DetectionInternalSettingsFactory;
import com.jumio.ocr.impl.smartEngines.swig.DetectionResult;
import com.jumio.ocr.impl.smartEngines.swig.DetectionSettings;
import com.jumio.sdk.exception.JumioException;
import com.jumio.sdk.extraction.ExtractionClient;
import com.jumio.sdk.extraction.ExtractionClient.ExtractionUpdate;
import com.jumio.sdk.extraction.ExtractionUpdateState;
import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.Locale;

/* compiled from: LineFinderClient */
public class s extends ExtractionClient<ExtractionUpdate, Void> {
    public static int a = 800;
    public static int b = 600;
    private a c = null;
    private DetectionEngine d;
    private boolean e = false;
    private int f = 0;
    private DocumentFormat g;
    private byte[] h;
    private float i = 0.0f;

    /* compiled from: LineFinderClient */
    class a extends Thread {
        private byte[] b;
        private PreviewProperties c;

        public a(byte[] bArr) {
            this.b = Arrays.copyOf(bArr, bArr.length);
            this.c = s.this.getPreviewProperties().copy();
        }

        /* JADX WARNING: Removed duplicated region for block: B:56:0x0285 A:{SYNTHETIC, Splitter: B:56:0x0285} */
        public void run() {
            /*
            r18 = this;
            r1 = r18;
            r2 = 800; // 0x320 float:1.121E-42 double:3.953E-321;
            jumio.nv.core.s.a = r2;
            r2 = 600; // 0x258 float:8.41E-43 double:2.964E-321;
            jumio.nv.core.s.b = r2;
            r2 = jumio.nv.core.s.this;
            r2 = r2.getPreviewProperties();
            r3 = jumio.nv.core.s.this;
            r3 = r3.extractionArea;
            r2 = com.jumio.commons.camera.CameraUtils.surfaceToPreview(r2, r3);
            r3 = jumio.nv.core.s.this;
            r3 = r3.extractionArea;
            r3 = r3.height();
            r3 = (float) r3;
            r4 = jumio.nv.core.s.this;
            r4 = r4.extractionArea;
            r4 = r4.width();
            r4 = (float) r4;
            r3 = r3 / r4;
            r4 = jumio.nv.core.s.this;
            r4 = r4.isPortrait();
            r5 = 1142292480; // 0x44160000 float:600.0 double:5.64367472E-315;
            r6 = 1145569280; // 0x44480000 float:800.0 double:5.65986426E-315;
            r7 = 1061158912; // 0x3f400000 float:0.75 double:5.24282163E-315;
            if (r4 == 0) goto L_0x0072;
        L_0x003f:
            r4 = r2.width();
            r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
            if (r4 >= 0) goto L_0x005b;
        L_0x0047:
            r3 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1));
            if (r3 < 0) goto L_0x005b;
        L_0x004b:
            r2 = r2.width();
            r2 = (int) r2;
            jumio.nv.core.s.a = r2;
            r2 = jumio.nv.core.s.a;
            r2 = (float) r2;
            r2 = r2 * r7;
            r2 = (int) r2;
            jumio.nv.core.s.b = r2;
            goto L_0x00a4;
        L_0x005b:
            r3 = r2.height();
            r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
            if (r3 >= 0) goto L_0x00a4;
        L_0x0063:
            r2 = r2.height();
            r2 = (int) r2;
            jumio.nv.core.s.b = r2;
            r2 = jumio.nv.core.s.b;
            r2 = (float) r2;
            r2 = r2 / r7;
            r2 = (int) r2;
            jumio.nv.core.s.a = r2;
            goto L_0x00a4;
        L_0x0072:
            r4 = r2.height();
            r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1));
            if (r4 >= 0) goto L_0x008d;
        L_0x007a:
            r3 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1));
            if (r3 > 0) goto L_0x008d;
        L_0x007e:
            r2 = r2.height();
            r2 = (int) r2;
            jumio.nv.core.s.b = r2;
            r2 = jumio.nv.core.s.b;
            r2 = (float) r2;
            r2 = r2 / r7;
            r2 = (int) r2;
            jumio.nv.core.s.a = r2;
            goto L_0x00a4;
        L_0x008d:
            r3 = r2.width();
            r3 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1));
            if (r3 >= 0) goto L_0x00a4;
        L_0x0095:
            r2 = r2.width();
            r2 = (int) r2;
            jumio.nv.core.s.a = r2;
            r2 = jumio.nv.core.s.a;
            r2 = (float) r2;
            r2 = r2 * r7;
            r2 = (int) r2;
            jumio.nv.core.s.b = r2;
        L_0x00a4:
            r3 = r1.b;
            r2 = jumio.nv.core.s.this;
            r4 = r2.isPortrait();
            r2 = jumio.nv.core.s.this;
            r5 = r2.getPreviewProperties();
            r2 = jumio.nv.core.s.this;
            r6 = r2.extractionArea;
            r7 = 1061158912; // 0x3f400000 float:0.75 double:5.24282163E-315;
            r8 = new com.jumio.commons.camera.Size;
            r2 = jumio.nv.core.s.a;
            r9 = jumio.nv.core.s.b;
            r8.<init>(r2, r9);
            r2 = com.jumio.commons.camera.CameraUtils.yuv2rgb(r3, r4, r5, r6, r7, r8);
            r3 = 0;
            if (r2 == 0) goto L_0x027c;
        L_0x00ca:
            r4 = jumio.nv.core.s.a;
            r5 = jumio.nv.core.s.b;
            r6 = 1;
            r4 = com.jumio.core.ImageQuality.calculateFocus(r2, r4, r5, r6);
            r5 = 1039516303; // 0x3df5c28f float:0.12 double:5.135892936E-315;
            r5 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1));
            if (r5 < 0) goto L_0x00f3;
        L_0x00da:
            r5 = jumio.nv.core.s.this;
            r10 = r5.d;
            r12 = jumio.nv.core.s.a;
            r13 = jumio.nv.core.s.b;
            r5 = jumio.nv.core.s.a;
            r14 = r5 * 3;
            r7 = java.lang.System.currentTimeMillis();
            r15 = (int) r7;
            r11 = r2;
            r5 = r10.processRawImage(r11, r12, r13, r14, r15);
            goto L_0x00f4;
        L_0x00f3:
            r5 = r3;
        L_0x00f4:
            if (r5 == 0) goto L_0x027c;
        L_0x00f6:
            r7 = jumio.nv.core.s.this;
            r7.a(r5, r2, r4);
            r8 = jumio.nv.core.s.this;
            r9 = r5.hasTopOfCard();
            r10 = r5.hasBottomOfCard();
            r11 = r5.hasLeftOfCard();
            r12 = r5.hasRightOfCard();
            r13 = r5.getFlashTurnOn();
            r7 = r5.isCardImageOfGoodQuality();
            r14 = r7 ^ 1;
            r6 = r8.a(r9, r10, r11, r12, r13, r14);
            if (r6 == 0) goto L_0x027d;
        L_0x011d:
            r7 = r5.getCardQuadrangle();
            if (r7 == 0) goto L_0x01b1;
        L_0x0123:
            r8 = r7.getTopLeft();
            r9 = r7.getTopRight();
            r10 = r7.getBottomLeft();
            r7 = r7.getBottomRight();
            r11 = r8.getX();
            r12 = r10.getX();
            if (r11 >= r12) goto L_0x0142;
        L_0x013d:
            r11 = r8.getX();
            goto L_0x0146;
        L_0x0142:
            r11 = r10.getX();
        L_0x0146:
            r12 = r8.getY();
            r13 = r9.getY();
            if (r12 >= r13) goto L_0x0155;
        L_0x0150:
            r8 = r8.getY();
            goto L_0x0159;
        L_0x0155:
            r8 = r9.getY();
        L_0x0159:
            r12 = r7.getX();
            r13 = r9.getX();
            if (r12 <= r13) goto L_0x0168;
        L_0x0163:
            r9 = r7.getX();
            goto L_0x016c;
        L_0x0168:
            r9 = r9.getX();
        L_0x016c:
            r12 = r7.getY();
            r13 = r10.getY();
            if (r12 <= r13) goto L_0x017b;
        L_0x0176:
            r7 = r7.getY();
            goto L_0x017f;
        L_0x017b:
            r7 = r10.getY();
        L_0x017f:
            r15 = r9 - r11;
            r16 = r7 - r8;
            r7 = r15 * r16;
            r7 = r7 * 3;
            r14 = new byte[r7];
            r7 = r8;
        L_0x018a:
            r9 = r8 + r16;
            if (r7 >= r9) goto L_0x01a5;
        L_0x018e:
            r9 = jumio.nv.core.s.a;
            r9 = r9 * r7;
            r9 = r9 * 3;
            r10 = r11 * 3;
            r9 = r9 + r10;
            r10 = r7 - r8;
            r10 = r10 * r15;
            r10 = r10 * 3;
            r12 = r15 * 3;
            java.lang.System.arraycopy(r2, r9, r14, r10, r12);
            r7 = r7 + 1;
            goto L_0x018a;
        L_0x01a5:
            r10 = jumio.nv.core.s.this;
            r12 = jumio.nv.core.s.a;
            r13 = jumio.nv.core.s.b;
            r11 = r2;
            r17 = r4;
            r10.a(r11, r12, r13, r14, r15, r16, r17);
        L_0x01b1:
            r2 = com.jumio.commons.log.Log.LogLevel.INFO;
            r2 = com.jumio.commons.log.Log.isLogEnabledForLevel(r2);
            if (r2 == 0) goto L_0x027d;
        L_0x01b9:
            r2 = new java.lang.StringBuilder;
            r2.<init>();
            r4 = new java.lang.StringBuilder;
            r4.<init>();
            r7 = "hasTopOfCard(): ";
            r4.append(r7);
            r7 = r5.hasTopOfCard();
            r7 = java.lang.Boolean.toString(r7);
            r4.append(r7);
            r4 = r4.toString();
            r2.append(r4);
            r4 = new java.lang.StringBuilder;
            r4.<init>();
            r7 = "hasBottomOfCard(): ";
            r4.append(r7);
            r7 = r5.hasBottomOfCard();
            r7 = java.lang.Boolean.toString(r7);
            r4.append(r7);
            r4 = r4.toString();
            r2.append(r4);
            r4 = new java.lang.StringBuilder;
            r4.<init>();
            r7 = "hasLeftOfCard(): ";
            r4.append(r7);
            r7 = r5.hasLeftOfCard();
            r7 = java.lang.Boolean.toString(r7);
            r4.append(r7);
            r4 = r4.toString();
            r2.append(r4);
            r4 = new java.lang.StringBuilder;
            r4.<init>();
            r7 = "hasRightOfCard(): ";
            r4.append(r7);
            r7 = r5.hasRightOfCard();
            r7 = java.lang.Boolean.toString(r7);
            r4.append(r7);
            r4 = r4.toString();
            r2.append(r4);
            r4 = new java.lang.StringBuilder;
            r4.<init>();
            r7 = "getFlashTurnOn(): ";
            r4.append(r7);
            r7 = r5.getFlashTurnOn();
            r7 = java.lang.Boolean.toString(r7);
            r4.append(r7);
            r4 = r4.toString();
            r2.append(r4);
            r4 = new java.lang.StringBuilder;
            r4.<init>();
            r7 = "isCardImageOfGoodQuality(): ";
            r4.append(r7);
            r5 = r5.isCardImageOfGoodQuality();
            r5 = java.lang.Boolean.toString(r5);
            r4.append(r5);
            r4 = r4.toString();
            r2.append(r4);
            r4 = "\r\n";
            r2.append(r4);
            com.jumio.nv.utils.NetverifyLogUtils.a.a(r2);
            r2 = r2.toString();
            r4 = jumio.nv.core.s.class;
            r4 = r4.getSimpleName();
            com.jumio.nv.utils.NetverifyLogUtils.logInfoInSubfolder(r2, r4, r3);
            goto L_0x027d;
        L_0x027c:
            r6 = 0;
        L_0x027d:
            r1.b = r3;
            java.lang.System.gc();
            r2 = jumio.nv.core.s.this;
            monitor-enter(r2);
            r4 = jumio.nv.core.s.this;	 Catch:{ all -> 0x028e }
            r4.e = r6;	 Catch:{ all -> 0x028e }
            monitor-exit(r2);	 Catch:{ all -> 0x028e }
            r1.c = r3;
            return;
        L_0x028e:
            r0 = move-exception;
            r3 = r0;
            monitor-exit(r2);	 Catch:{ all -> 0x028e }
            throw r3;
            */
            throw new UnsupportedOperationException("Method not decompiled: jumio.nv.core.s.a.run():void");
        }
    }

    private int a(boolean z, boolean z2, boolean z3, boolean z4) {
        int i = z ? 1 : 0;
        if (z2) {
            i++;
        }
        if (z3) {
            i++;
        }
        return z4 ? i + 1 : i;
    }

    public void destroy() {
    }

    public s(Context context) {
        super(context);
    }

    public void configure(StaticModel staticModel) {
        if (staticModel instanceof NVScanPartModel) {
            this.g = ((NVScanPartModel) staticModel).getFormat();
            return;
        }
        throw new InvalidParameterException("Configuration model should be an instance of ScanPartModel");
    }

    protected void init() {
        this.e = false;
        Environment.loadJniInterfaceLib();
        DetectionSettings detectionSettings = new DetectionSettings();
        detectionSettings.setRoiLeftMargin(this.g.getOverlayLeft());
        detectionSettings.setRoiRightMargin(this.g.getOverlayRight());
        detectionSettings.setRoiTopMargin(this.g.getOverlayTop());
        detectionSettings.setRoiBottomMargin(this.g.getOverlayBottom());
        detectionSettings.setRoiVerticalDeviation(0.04d);
        detectionSettings.setRoiHorizontalDeviation(0.03d);
        try {
            String cardDetectionSettingsPath = NVEnvironment.getCardDetectionSettingsPath(this.mContext);
            if (cardDetectionSettingsPath == null) {
                throw new Exception("Loading detection settings failed!");
            }
            this.d = new DetectionEngine(detectionSettings, DetectionInternalSettingsFactory.createFromFileSystem(cardDetectionSettingsPath));
        } catch (Exception unused) {
            d(new JumioException(NVErrorCase.OCR_LOADING_FAILED));
        }
    }

    public void cancel() {
        super.cancel();
        synchronized (this) {
            if (this.c != null) {
                this.c.interrupt();
            }
        }
    }

    /* renamed from: a */
    public void feed(byte[] bArr) {
        synchronized (this) {
            if (!(this.e || this.d == null)) {
                this.e = true;
                this.c = new a(bArr);
                this.c.start();
            }
        }
    }

    protected void a(DetectionResult detectionResult, byte[] bArr, float f) {
        if (a(detectionResult.hasTopOfCard(), detectionResult.hasBottomOfCard(), detectionResult.hasLeftOfCard(), detectionResult.hasRightOfCard()) >= 3 && f > this.i) {
            if (Log.isLogEnabledForLevel(LogLevel.INFO)) {
                Log.i("LineFinderClient", String.format(Locale.getDefault(), "Previous image focus value %f was replaced with new image focus value %f", new Object[]{Float.valueOf(this.i), Float.valueOf(f)}));
            }
            this.i = f;
            this.h = Arrays.copyOf(bArr, bArr.length);
        }
    }

    protected void a() {
        this.i = 0.0f;
        this.h = null;
    }

    public boolean a(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        a(new ExtractionUpdate(u.a, new t(z4, z3, z, z2, z5, z6)));
        int a = a(z, z2, z3, z4);
        if (a < 3 || z6) {
            this.f = 0;
            a();
            if (Log.isLogEnabledForLevel(LogLevel.INFO)) {
                com.jumio.nv.utils.NetverifyLogUtils.a.a();
            }
        } else {
            this.f++;
            if (Log.isLogEnabledForLevel(LogLevel.INFO)) {
                com.jumio.nv.utils.NetverifyLogUtils.a.a(a);
            }
        }
        if (this.f >= 5) {
            return true;
        }
        return false;
    }

    public void a(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, float f) {
        Object rgb2bitmap;
        a(new ExtractionUpdate(ExtractionUpdateState.shotTaken, Float.valueOf(f)));
        a(new ExtractionUpdate(u.a, new t(false, false, false, false, false, false)));
        if (this.h != null) {
            rgb2bitmap = CameraUtils.rgb2bitmap(this.h, i, i2);
        } else {
            rgb2bitmap = CameraUtils.rgb2bitmap(bArr, i, i2);
        }
        Bitmap rgb2bitmap2 = CameraUtils.rgb2bitmap(bArr2, i3, i4);
        a(new ExtractionUpdate(ExtractionUpdateState.saveImage, rgb2bitmap));
        a(new ExtractionUpdate(ExtractionUpdateState.saveExactImage, rgb2bitmap2));
        a();
        f(null);
        System.gc();
    }
}
