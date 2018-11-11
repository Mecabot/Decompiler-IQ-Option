package jumio.nv.mrz;

import android.content.Context;
import android.graphics.Rect;
import com.jumio.commons.camera.CameraUtils;
import com.jumio.commons.camera.PreviewProperties;
import com.jumio.commons.log.Log;
import com.jumio.core.data.document.DocumentFormat;
import com.jumio.core.data.document.DocumentScanMode;
import com.jumio.core.mvp.model.StaticModel;
import com.jumio.mrz.impl.smartEngines.swig.MrzDate;
import com.jumio.mrz.impl.smartEngines.swig.MrzEngine;
import com.jumio.mrz.impl.smartEngines.swig.MrzEngineInternalSettings;
import com.jumio.mrz.impl.smartEngines.swig.MrzEngineSessionHelpers;
import com.jumio.mrz.impl.smartEngines.swig.MrzEngineSessionSettings;
import com.jumio.mrz.impl.smartEngines.swig.MrzField;
import com.jumio.mrz.impl.smartEngines.swig.MrzRectMatrix;
import com.jumio.mrz.impl.smartEngines.swig.MrzRectVector;
import com.jumio.mrz.impl.smartEngines.swig.MrzResult;
import com.jumio.mrz.impl.smartEngines.swig.StreamReporterInterface;
import com.jumio.mrz.impl.smartEngines.swig.StringVector;
import com.jumio.nv.data.document.NVMRZFormat;
import com.jumio.nv.enums.NVErrorCase;
import com.jumio.nv.enums.NVGender;
import com.jumio.nv.extraction.JumioRect;
import com.jumio.nv.models.DocumentDataModel;
import com.jumio.nv.models.NVScanPartModel;
import com.jumio.nv.mrz.environment.MrzEnvironment;
import com.jumio.sdk.exception.JumioException;
import com.jumio.sdk.extraction.ExtractionClient;
import com.jumio.sdk.extraction.ExtractionClient.ExtractionUpdate;
import com.jumio.sdk.extraction.ExtractionUpdateState;
import java.security.InvalidParameterException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: MrzClient */
public class a extends ExtractionClient<ExtractionUpdate, DocumentDataModel> {
    private MrzEngine a;
    private MrzEngineSessionHelpers b;
    private MrzEngineSessionSettings c;
    private d d;
    private a e;
    private ExecutorService f;
    private DocumentScanMode g;
    private DocumentFormat h;
    private boolean i = false;
    private int j = 0;
    private int k = 0;
    private byte[] l;
    private float m = 0.0f;
    private byte[] n;
    private float o = 0.0f;

    /* compiled from: MrzClient */
    class b implements Runnable {
        private b() {
        }

        public void run() {
            a.this.e.a();
            if (a.this.a != null) {
                try {
                    a.this.a.InitializeSession(a.this.e, a.this.b, a.this.c);
                } catch (Throwable e) {
                    Log.e("MrzClient", "MrzInitTask", e);
                    a.this.b(new JumioException(NVErrorCase.OCR_LOADING_FAILED));
                    a.this.f.shutdownNow();
                }
            }
            d dVar = new d(a.this.mContext);
            dVar.calculate(a.this.g, a.this.h, a.this.extractionArea);
            Rect overlayBounds = dVar.getOverlayBounds();
            Rect a = dVar.a();
            a.this.j = overlayBounds.left;
            int k = (int) (((double) (a.this.getPreviewProperties().surface.width - (a.this.j * 2))) / a.this.b.get_optimal_aspect_ratio());
            a.this.k = a.top - ((k - (a.bottom - a.top)) / 2);
            if (a.this.k + k > a.this.getPreviewProperties().surface.height) {
                a.this.k = a.this.getPreviewProperties().surface.height - k;
            }
            synchronized (a.this) {
                a.this.i = false;
            }
        }
    }

    /* compiled from: MrzClient */
    class c implements Runnable {
        private c() {
        }

        public void run() {
            try {
                String mRZEngineSettingsPath = MrzEnvironment.getMRZEngineSettingsPath(a.this.mContext);
                if (mRZEngineSettingsPath == null) {
                    throw new Exception("Loading mrz settings failed!");
                }
                a.this.a = new MrzEngine(MrzEngineInternalSettings.createFromFilesystem(mRZEngineSettingsPath));
            } catch (Throwable e) {
                Log.e("MrzClient", "MrzLoadingTask", e);
                a.this.b(new JumioException(NVErrorCase.OCR_LOADING_FAILED));
                a.this.f.shutdownNow();
            }
        }
    }

    /* compiled from: MrzClient */
    class d extends Thread {
        private byte[] b;
        private PreviewProperties c;
        private boolean d;

        public d(byte[] bArr, boolean z) {
            this.b = Arrays.copyOf(bArr, bArr.length);
            this.d = z;
            this.c = a.this.getPreviewProperties().copy();
        }

        public void run() {
            try {
                a(this.b);
            } catch (Throwable e) {
                Log.printStackTrace(e);
            }
            synchronized (a.this) {
                a.this.i = a.this.e.a;
                this.b = null;
                this.c = null;
                System.gc();
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:84:0x060e  */
        /* JADX WARNING: Removed duplicated region for block: B:83:0x05ee  */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x0100  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x00f2  */
        private void a(byte[] r31) {
            /*
            r30 = this;
            r1 = r30;
            r2 = r1.c;
            r2 = r2.preview;
            r2 = r2.width;
            r3 = r1.c;
            r3 = r3.preview;
            r3 = r3.height;
            r4 = jumio.nv.mrz.a.this;
            r4 = r4.b;
            r4 = r4.get_optimal_aspect_ratio();
            r6 = jumio.nv.mrz.a.this;
            r6 = r6.j;
            r7 = r1.c;
            r7 = r7.scaledPreview;
            r7 = r7.width;
            r8 = r1.c;
            r8 = r8.surface;
            r8 = r8.width;
            r7 = r7 - r8;
            r7 = r7 / 2;
            r6 = r6 + r7;
            r6 = r6 * r2;
            r7 = r1.c;
            r7 = r7.scaledPreview;
            r7 = r7.width;
            r6 = r6 / r7;
            r7 = r6 * 2;
            r2 = r2 - r7;
            r7 = (double) r2;
            r4 = r7 / r4;
            r4 = (int) r4;
            r5 = jumio.nv.mrz.a.this;
            r5 = r5.k;
            r9 = r1.c;
            r9 = r9.scaledPreview;
            r9 = r9.height;
            r10 = r1.c;
            r10 = r10.surface;
            r10 = r10.height;
            r9 = r9 - r10;
            r9 = r9 / 2;
            r5 = r5 + r9;
            r5 = r5 * r3;
            r3 = r1.c;
            r3 = r3.scaledPreview;
            r3 = r3.height;
            r5 = r5 / r3;
            r15 = new com.jumio.mrz.impl.smartEngines.swig.MrzRect;
            r15.<init>(r6, r5, r2, r4);
            r3 = com.jumio.mrz.impl.smartEngines.swig.MrzEngine.ImageOrientation.Landscape;
            r9 = r1.c;
            r9 = r9.orientation;
            r10 = 90;
            if (r9 != r10) goto L_0x006f;
        L_0x006c:
            r3 = com.jumio.mrz.impl.smartEngines.swig.MrzEngine.ImageOrientation.Portrait;
            goto L_0x0084;
        L_0x006f:
            r9 = r1.c;
            r9 = r9.orientation;
            r10 = 180; // 0xb4 float:2.52E-43 double:8.9E-322;
            if (r9 != r10) goto L_0x007a;
        L_0x0077:
            r3 = com.jumio.mrz.impl.smartEngines.swig.MrzEngine.ImageOrientation.InvertedLandscape;
            goto L_0x0084;
        L_0x007a:
            r9 = r1.c;
            r9 = r9.orientation;
            r10 = 270; // 0x10e float:3.78E-43 double:1.334E-321;
            if (r9 != r10) goto L_0x0084;
        L_0x0082:
            r3 = com.jumio.mrz.impl.smartEngines.swig.MrzEngine.ImageOrientation.InvertedPortrait;
        L_0x0084:
            r9 = r1.c;
            r9 = r9.frontFacing;
            if (r9 == 0) goto L_0x0097;
        L_0x008a:
            r9 = com.jumio.mrz.impl.smartEngines.swig.MrzEngine.ImageOrientation.Portrait;
            if (r3 != r9) goto L_0x0091;
        L_0x008e:
            r3 = com.jumio.mrz.impl.smartEngines.swig.MrzEngine.ImageOrientation.InvertedPortrait;
            goto L_0x0097;
        L_0x0091:
            r9 = com.jumio.mrz.impl.smartEngines.swig.MrzEngine.ImageOrientation.InvertedPortrait;
            if (r3 != r9) goto L_0x0097;
        L_0x0095:
            r3 = com.jumio.mrz.impl.smartEngines.swig.MrzEngine.ImageOrientation.Portrait;
        L_0x0097:
            r9 = jumio.nv.mrz.a.this;
            r9 = r9.extractionArea;
            r9 = r9.height();
            r9 = (float) r9;
            r10 = jumio.nv.mrz.a.this;
            r10 = r10.extractionArea;
            r10 = r10.width();
            r10 = (float) r10;
            r9 = r9 / r10;
            r10 = r1.d;
            r11 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
            if (r10 == 0) goto L_0x00b7;
        L_0x00b4:
            r10 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
            goto L_0x00b9;
        L_0x00b7:
            r10 = 1061158912; // 0x3f400000 float:0.75 double:5.24282163E-315;
        L_0x00b9:
            r12 = r1.d;
            if (r12 == 0) goto L_0x00c4;
        L_0x00bd:
            r12 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1));
            if (r12 >= 0) goto L_0x00c4;
        L_0x00c1:
            r20 = r9;
            goto L_0x00d3;
        L_0x00c4:
            r12 = r1.d;
            if (r12 != 0) goto L_0x00d1;
        L_0x00c8:
            r12 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1));
            if (r12 <= 0) goto L_0x00d1;
        L_0x00cc:
            r9 = java.lang.Math.min(r11, r9);
            goto L_0x00c1;
        L_0x00d1:
            r20 = r10;
        L_0x00d3:
            r14 = new com.jumio.commons.camera.Size;
            r9 = -1;
            r14.<init>(r9, r9);
            r9 = r1.d;
            r10 = r1.c;
            r11 = jumio.nv.mrz.a.this;
            r19 = r11.extractionArea;
            r16 = r31;
            r17 = r9;
            r18 = r10;
            r21 = r14;
            r13 = com.jumio.commons.camera.CameraUtils.yuv2rgb(r16, r17, r18, r19, r20, r21);
            r12 = 0;
            if (r13 != 0) goto L_0x0100;
        L_0x00f2:
            r9 = jumio.nv.mrz.a.this;
            monitor-enter(r9);
            r2 = jumio.nv.mrz.a.this;	 Catch:{ all -> 0x00fc }
            r2.i = r12;	 Catch:{ all -> 0x00fc }
            monitor-exit(r9);	 Catch:{ all -> 0x00fc }
            return;
        L_0x00fc:
            r0 = move-exception;
            r2 = r0;
            monitor-exit(r9);	 Catch:{ all -> 0x00fc }
            throw r2;
        L_0x0100:
            r9 = r14.width;
            r10 = r14.height;
            r11 = 1;
            r10 = com.jumio.core.ImageQuality.calculateFocus(r13, r9, r10, r11);
            r9 = r14.width;
            r12 = r14.height;
            r9 = com.jumio.core.ImageQuality.isFlashNeeded(r13, r9, r12, r11);
            r12 = jumio.nv.mrz.a.this;
            r11 = new com.jumio.sdk.extraction.ExtractionClient$ExtractionUpdate;
            r28 = r14;
            r14 = com.jumio.sdk.extraction.ExtractionUpdateState.notifyFlash;
            r9 = java.lang.Boolean.valueOf(r9);
            r11.<init>(r14, r9);
            r12.b(r11);
            r9 = 1039516303; // 0x3df5c28f float:0.12 double:5.135892936E-315;
            r9 = (r10 > r9 ? 1 : (r10 == r9 ? 0 : -1));
            if (r9 > 0) goto L_0x012c;
        L_0x012a:
            r9 = 1;
            goto L_0x012d;
        L_0x012c:
            r9 = 0;
        L_0x012d:
            if (r9 == 0) goto L_0x0180;
        L_0x012f:
            r2 = jumio.nv.mrz.a.this;
            r2 = r2.getPreviewProperties();
            r2 = r2.surface;
            r2 = r2.width;
            r3 = jumio.nv.mrz.a.this;
            r3 = r3.j;
            r3 = r3 * 2;
            r2 = r2 - r3;
            r3 = jumio.nv.mrz.a.this;
            r3 = r3.b;
            r3 = r3.get_optimal_aspect_ratio();
            r7 = r7 / r3;
            r3 = (int) r7;
            r4 = jumio.nv.mrz.a.this;
            r4 = r4.j;
            r2 = r2 / 2;
            r4 = r4 + r2;
            r2 = jumio.nv.mrz.a.this;
            r2 = r2.k;
            r3 = r3 / 2;
            r2 = r2 + r3;
            r3 = jumio.nv.mrz.a.this;
            r5 = new com.jumio.sdk.extraction.ExtractionClient$ExtractionUpdate;
            r6 = com.jumio.sdk.extraction.ExtractionUpdateState.notifyFocus;
            r7 = new android.graphics.Point;
            r7.<init>(r4, r2);
            r5.<init>(r6, r7);
            r3.b(r5);
            r7 = jumio.nv.mrz.a.this;
            monitor-enter(r7);
            r2 = jumio.nv.mrz.a.this;	 Catch:{ all -> 0x017c }
            r8 = 0;
            r2.i = r8;	 Catch:{ all -> 0x017c }
            monitor-exit(r7);	 Catch:{ all -> 0x017c }
            return;
        L_0x017c:
            r0 = move-exception;
            r2 = r0;
            monitor-exit(r7);	 Catch:{ all -> 0x017c }
            throw r2;
        L_0x0180:
            r8 = 0;
            r7 = jumio.nv.mrz.a.this;
            r9 = r13.length;
            r9 = java.util.Arrays.copyOf(r13, r9);
            r7.l = r9;
            r7 = jumio.nv.mrz.a.this;
            r7.m = r10;
            r7 = jumio.nv.mrz.a.this;
            r9 = r7.a;
            r7 = r1.c;
            r7 = r7.camera;
            r11 = r7.width;
            r7 = r1.c;
            r7 = r7.camera;
            r12 = r7.height;
            r7 = r1.c;
            r7 = r7.camera;
            r7 = r7.width;
            r14 = 1;
            r17 = r10;
            r10 = r31;
            r8 = 1;
            r18 = 0;
            r29 = r13;
            r13 = r7;
            r7 = r28;
            r16 = r3;
            r9.FeedUncompressedImageData(r10, r11, r12, r13, r14, r15, r16);
            r9 = r1.c;
            r10 = jumio.nv.mrz.a.this;
            r10 = r10.extractionArea;
            r9 = com.jumio.commons.camera.CameraUtils.surfaceToPreview(r9, r10);
            r10 = (float) r6;
            r11 = r9.left;
            r10 = r10 - r11;
            r11 = r9.width();
            r12 = r7.width;
            r12 = (float) r12;
            r11 = r11 - r12;
            r12 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
            r11 = r11 / r12;
            r10 = r10 - r11;
            r10 = (int) r10;
            r11 = (float) r5;
            r13 = r9.top;
            r11 = r11 - r13;
            r9 = r9.height();
            r13 = r7.height;
            r13 = (float) r13;
            r9 = r9 - r13;
            r9 = r9 / r12;
            r11 = r11 - r9;
            r9 = (int) r11;
            r11 = jumio.nv.mrz.a.this;
            r11 = r11.e;
            r11 = r11.c;
            r9 = r1.a(r11, r10, r9);
            r10 = jumio.nv.mrz.a.this;
            r10 = r10.e;
            r10 = r10.a;
            if (r10 == 0) goto L_0x05e2;
        L_0x01fc:
            r10 = jumio.nv.mrz.a.class;
            r10 = r10.getSimpleName();
            r11 = com.jumio.commons.log.Log.LogLevel.INFO;
            r11 = com.jumio.commons.log.Log.isLogEnabledForLevel(r11);
            if (r11 == 0) goto L_0x05cc;
        L_0x020a:
            r11 = new java.lang.StringBuilder;
            r11.<init>();
            r12 = java.util.Calendar.getInstance();
            r13 = new java.lang.StringBuilder;
            r13.<init>();
            r14 = "width = ";
            r13.append(r14);
            r14 = r1.c;
            r14 = r14.camera;
            r14 = r14.width;
            r13.append(r14);
            r14 = "\r\n";
            r13.append(r14);
            r13 = r13.toString();
            r11.append(r13);
            r13 = new java.lang.StringBuilder;
            r13.<init>();
            r14 = "height = ";
            r13.append(r14);
            r14 = r1.c;
            r14 = r14.camera;
            r14 = r14.height;
            r13.append(r14);
            r14 = "\r\n";
            r13.append(r14);
            r13 = r13.toString();
            r11.append(r13);
            r13 = new java.lang.StringBuilder;
            r13.<init>();
            r14 = "stride = ";
            r13.append(r14);
            r14 = r1.c;
            r14 = r14.camera;
            r14 = r14.width;
            r13.append(r14);
            r14 = "\r\n";
            r13.append(r14);
            r13 = r13.toString();
            r11.append(r13);
            r13 = new java.lang.StringBuilder;
            r13.<init>();
            r14 = "roi_x = ";
            r13.append(r14);
            r13.append(r6);
            r6 = "\r\n";
            r13.append(r6);
            r6 = r13.toString();
            r11.append(r6);
            r6 = new java.lang.StringBuilder;
            r6.<init>();
            r13 = "roi_y = ";
            r6.append(r13);
            r6.append(r5);
            r5 = "\r\n";
            r6.append(r5);
            r5 = r6.toString();
            r11.append(r5);
            r5 = new java.lang.StringBuilder;
            r5.<init>();
            r6 = "roiWidth = ";
            r5.append(r6);
            r5.append(r2);
            r2 = "\r\n";
            r5.append(r2);
            r2 = r5.toString();
            r11.append(r2);
            r2 = new java.lang.StringBuilder;
            r2.<init>();
            r5 = "roiHeight = ";
            r2.append(r5);
            r2.append(r4);
            r4 = "\r\n";
            r2.append(r4);
            r2 = r2.toString();
            r11.append(r2);
            r2 = "roi = new MrzRect(roi_x, roi_y, roiWidth, roiHeight)\r\n";
            r11.append(r2);
            r2 = "Portrait";
            r4 = com.jumio.mrz.impl.smartEngines.swig.MrzEngine.ImageOrientation.InvertedPortrait;
            if (r3 != r4) goto L_0x02e2;
        L_0x02df:
            r2 = "InvertedPortrait";
            goto L_0x02ef;
        L_0x02e2:
            r4 = com.jumio.mrz.impl.smartEngines.swig.MrzEngine.ImageOrientation.Landscape;
            if (r3 != r4) goto L_0x02e9;
        L_0x02e6:
            r2 = "Landscape";
            goto L_0x02ef;
        L_0x02e9:
            r4 = com.jumio.mrz.impl.smartEngines.swig.MrzEngine.ImageOrientation.InvertedLandscape;
            if (r3 != r4) goto L_0x02ef;
        L_0x02ed:
            r2 = "InvertedLandscape";
        L_0x02ef:
            r3 = new java.lang.StringBuilder;
            r3.<init>();
            r4 = "orientation = ";
            r3.append(r4);
            r3.append(r2);
            r2 = r3.toString();
            r11.append(r2);
            r2 = "FeedUncompressedImageData(buffer, width, height, stride, 1, roi, orientation)";
            r11.append(r2);
            r2 = "\r\n";
            r11.append(r2);
            r2 = "\r\n";
            r11.append(r2);
            r2 = "Result:";
            r11.append(r2);
            r2 = "\r\n";
            r11.append(r2);
            r2 = jumio.nv.mrz.a.this;
            r2 = r2.e;
            r2 = r2.b;
            r2 = r2.getMrzLines();
            r3 = 0;
        L_0x0329:
            r4 = (long) r3;
            r13 = r2.size();
            r6 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1));
            if (r6 >= 0) goto L_0x0359;
        L_0x0332:
            r4 = new java.lang.StringBuilder;
            r4.<init>();
            r5 = "getMrzLines().get(%d) ";
            r6 = new java.lang.Object[r8];
            r13 = java.lang.Integer.valueOf(r3);
            r6[r18] = r13;
            r5 = java.lang.String.format(r5, r6);
            r4.append(r5);
            r5 = r2.get(r3);
            r4.append(r5);
            r4 = r4.toString();
            r11.append(r4);
            r3 = r3 + 1;
            goto L_0x0329;
        L_0x0359:
            r2 = new java.lang.StringBuilder;
            r2.<init>();
            r3 = "getDocType() ";
            r2.append(r3);
            r3 = jumio.nv.mrz.a.this;
            r3 = r3.e;
            r3 = r3.b;
            r3 = r3.getDocType();
            r3 = r3.getAsString();
            r2.append(r3);
            r3 = "\r\n";
            r2.append(r3);
            r2 = r2.toString();
            r11.append(r2);
            r2 = new java.lang.StringBuilder;
            r2.<init>();
            r3 = "getDocTypeCode() ";
            r2.append(r3);
            r3 = jumio.nv.mrz.a.this;
            r3 = r3.e;
            r3 = r3.b;
            r3 = r3.getDocTypeCode();
            r3 = r3.getAsString();
            r2.append(r3);
            r3 = "\r\n";
            r2.append(r3);
            r2 = r2.toString();
            r11.append(r2);
            r2 = new java.lang.StringBuilder;
            r2.<init>();
            r3 = "getDocNum() ";
            r2.append(r3);
            r3 = jumio.nv.mrz.a.this;
            r3 = r3.e;
            r3 = r3.b;
            r3 = r3.getDocNum();
            r3 = r3.getAsString();
            r2.append(r3);
            r3 = "\r\n";
            r2.append(r3);
            r2 = r2.toString();
            r11.append(r2);
            r2 = new java.lang.StringBuilder;
            r2.<init>();
            r3 = "getOptData1() ";
            r2.append(r3);
            r3 = jumio.nv.mrz.a.this;
            r3 = r3.e;
            r3 = r3.b;
            r3 = r3.getOptData1();
            r3 = r3.getAsString();
            r2.append(r3);
            r3 = "\r\n";
            r2.append(r3);
            r2 = r2.toString();
            r11.append(r2);
            r2 = new java.lang.StringBuilder;
            r2.<init>();
            r3 = "getOptData2() ";
            r2.append(r3);
            r3 = jumio.nv.mrz.a.this;
            r3 = r3.e;
            r3 = r3.b;
            r3 = r3.getOptData2();
            r3 = r3.getAsString();
            r2.append(r3);
            r3 = "\r\n";
            r2.append(r3);
            r2 = r2.toString();
            r11.append(r2);
            r2 = jumio.nv.mrz.a.this;
            r2 = r2.e;
            r2 = r2.b;
            r2 = r2.getExpidate();
            r2 = r2.getAsMrzDate();
            r2 = r2.getYear();
            r3 = jumio.nv.mrz.a.this;
            r3 = r3.e;
            r3 = r3.b;
            r3 = r3.getExpidate();
            r3 = r3.getAsMrzDate();
            r3 = r3.getMonth();
            r2 = r2 + r3;
            r20 = r2 + -1;
            r2 = jumio.nv.mrz.a.this;
            r2 = r2.e;
            r2 = r2.b;
            r2 = r2.getExpidate();
            r2 = r2.getAsMrzDate();
            r21 = r2.getDay();
            r22 = 0;
            r23 = 0;
            r24 = 0;
            r19 = r12;
            r19.set(r20, r21, r22, r23, r24);
            r2 = new java.lang.StringBuilder;
            r2.<init>();
            r3 = "getExpidate() ";
            r2.append(r3);
            r3 = r12.getTime();
            r3 = r3.toString();
            r2.append(r3);
            r3 = "\r\n";
            r2.append(r3);
            r2 = r2.toString();
            r11.append(r2);
            r2 = new java.lang.StringBuilder;
            r2.<init>();
            r3 = "getCountry() ";
            r2.append(r3);
            r3 = jumio.nv.mrz.a.this;
            r3 = r3.e;
            r3 = r3.b;
            r3 = r3.getCountry();
            r3 = r3.getAsString();
            r2.append(r3);
            r3 = "\r\n";
            r2.append(r3);
            r2 = r2.toString();
            r11.append(r2);
            r2 = new java.lang.StringBuilder;
            r2.<init>();
            r3 = "getSecondName() ";
            r2.append(r3);
            r3 = jumio.nv.mrz.a.this;
            r3 = r3.e;
            r3 = r3.b;
            r3 = r3.getSecondName();
            r3 = r3.getAsString();
            r2.append(r3);
            r3 = "\r\n";
            r2.append(r3);
            r2 = r2.toString();
            r11.append(r2);
            r2 = new java.lang.StringBuilder;
            r2.<init>();
            r3 = "getFirstName() ";
            r2.append(r3);
            r3 = jumio.nv.mrz.a.this;
            r3 = r3.e;
            r3 = r3.b;
            r3 = r3.getFirstName();
            r3 = r3.getAsString();
            r2.append(r3);
            r3 = "\r\n";
            r2.append(r3);
            r2 = r2.toString();
            r11.append(r2);
            r2 = jumio.nv.mrz.a.this;
            r2 = r2.e;
            r2 = r2.b;
            r2 = r2.getBirthdate();
            r2 = r2.getAsMrzDate();
            r2 = r2.getYear();
            r3 = jumio.nv.mrz.a.this;
            r3 = r3.e;
            r3 = r3.b;
            r3 = r3.getBirthdate();
            r3 = r3.getAsMrzDate();
            r3 = r3.getMonth();
            r2 = r2 + r3;
            r20 = r2 + -1;
            r2 = jumio.nv.mrz.a.this;
            r2 = r2.e;
            r2 = r2.b;
            r2 = r2.getBirthdate();
            r2 = r2.getAsMrzDate();
            r21 = r2.getDay();
            r19.set(r20, r21, r22, r23, r24);
            r2 = new java.lang.StringBuilder;
            r2.<init>();
            r3 = "getBirthdate() ";
            r2.append(r3);
            r3 = r12.getTime();
            r3 = r3.toString();
            r2.append(r3);
            r3 = "\r\n";
            r2.append(r3);
            r2 = r2.toString();
            r11.append(r2);
            r2 = new java.lang.StringBuilder;
            r2.<init>();
            r3 = "getSex() ";
            r2.append(r3);
            r3 = jumio.nv.mrz.a.this;
            r3 = r3.e;
            r3 = r3.b;
            r3 = r3.getSex();
            r3 = r3.getAsString();
            r2.append(r3);
            r3 = "\r\n";
            r2.append(r3);
            r2 = r2.toString();
            r11.append(r2);
            r2 = new java.lang.StringBuilder;
            r2.<init>();
            r3 = "getNationality() ";
            r2.append(r3);
            r3 = jumio.nv.mrz.a.this;
            r3 = r3.e;
            r3 = r3.b;
            r3 = r3.getNationality();
            r3 = r3.getAsString();
            r2.append(r3);
            r3 = "\r\n";
            r2.append(r3);
            r2 = r2.toString();
            r11.append(r2);
            com.jumio.nv.utils.NetverifyLogUtils.appendCoordinatesLog(r11, r9);
            r2 = r11.toString();
            r3 = 0;
            com.jumio.nv.utils.NetverifyLogUtils.logInfoInSubfolder(r2, r10, r3);
        L_0x05cc:
            r2 = com.jumio.commons.log.Log.LogLevel.VERBOSE;
            r2 = com.jumio.commons.log.Log.isLogEnabledForLevel(r2);
            if (r2 == 0) goto L_0x05e2;
        L_0x05d4:
            r2 = r7.width;
            r3 = r7.height;
            r4 = r29;
            r2 = com.jumio.commons.utils.ImageUtil.rgbToBitmap(r4, r2, r3);
            com.jumio.nv.utils.NetverifyLogUtils.dumpPictureWithCoordinates(r9, r2, r10);
            goto L_0x05e4;
        L_0x05e2:
            r4 = r29;
        L_0x05e4:
            r2 = jumio.nv.mrz.a.this;
            r2 = r2.e;
            r2 = r2.a;
            if (r2 == 0) goto L_0x060e;
        L_0x05ee:
            r2 = jumio.nv.mrz.a.this;
            r3 = jumio.nv.mrz.a.this;
            r3 = r3.e;
            r3 = r3.b;
            r5 = r7.width;
            r6 = r7.height;
            r21 = r2;
            r22 = r3;
            r23 = r9;
            r24 = r4;
            r25 = r5;
            r26 = r6;
            r27 = r17;
            r21.a(r22, r23, r24, r25, r26, r27);
            goto L_0x061b;
        L_0x060e:
            r2 = jumio.nv.mrz.a.this;
            r3 = jumio.nv.mrz.a.this;
            r3 = r3.e;
            r3 = r3.c;
            r2.a(r3);
        L_0x061b:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: jumio.nv.mrz.a.d.a(byte[]):void");
        }

        private ArrayList<ArrayList<JumioRect>> a(MrzRectVector[] mrzRectVectorArr, int i, int i2) {
            if (mrzRectVectorArr == null || mrzRectVectorArr.length == 0) {
                return null;
            }
            ArrayList<ArrayList<JumioRect>> arrayList = new ArrayList();
            for (MrzRectVector mrzRectVector : mrzRectVectorArr) {
                ArrayList arrayList2 = new ArrayList();
                for (int i3 = 0; ((long) i3) < mrzRectVector.size(); i3++) {
                    int x = mrzRectVector.get(i3).getX() + i;
                    int y = mrzRectVector.get(i3).getY() + i2;
                    arrayList2.add(new JumioRect(x, y, mrzRectVector.get(i3).getWidth() + x, mrzRectVector.get(i3).getHeight() + y));
                }
                arrayList.add(arrayList2);
            }
            return arrayList;
        }
    }

    /* compiled from: MrzClient */
    class a extends StreamReporterInterface {
        public boolean a;
        public MrzResult b;
        public MrzRectVector[] c;

        private a() {
            this.a = false;
        }

        public void a() {
            this.a = false;
            this.b = null;
            this.c = new MrzRectVector[0];
            a.this.b();
        }

        public void SnapshotProcessed(MrzResult mrzResult, boolean z) {
            this.a = z;
            if (z) {
                this.b = new MrzResult(mrzResult);
                a.this.a();
            }
        }

        public void SnapshotRejected() {
            this.c = new MrzRectVector[0];
        }

        public void SymbolRectsFound(MrzRectMatrix mrzRectMatrix) {
            this.c = new MrzRectVector[((int) mrzRectMatrix.size())];
            for (int i = 0; ((long) i) < mrzRectMatrix.size(); i++) {
                this.c[i] = new MrzRectVector(mrzRectMatrix.get(i).size());
                for (int i2 = 0; ((long) i2) < mrzRectMatrix.get(i).size(); i2++) {
                    this.c[i].set(i2, mrzRectMatrix.get(i).get(i2));
                }
            }
        }
    }

    public a(Context context) {
        super(context);
        MrzEnvironment.loadMRZJniInterfaceLib();
        this.f = Executors.newSingleThreadExecutor();
        this.f.submit(new c());
        this.c = new MrzEngineSessionSettings();
        this.c.set_should_postprocess(true);
        this.c.set_m3z_support_enabled(false);
        this.b = new MrzEngineSessionHelpers();
    }

    public void configure(StaticModel staticModel) {
        if (staticModel instanceof NVScanPartModel) {
            NVScanPartModel nVScanPartModel = (NVScanPartModel) staticModel;
            this.g = nVScanPartModel.getScanMode();
            this.h = nVScanPartModel.getFormat();
            boolean z = false;
            this.c.set_mrp_support_enabled(this.g == DocumentScanMode.MRP);
            this.c.set_td1_support_enabled(this.g == DocumentScanMode.TD1);
            MrzEngineSessionSettings mrzEngineSessionSettings = this.c;
            boolean z2 = this.g == DocumentScanMode.TD2 || this.g == DocumentScanMode.CNIS;
            mrzEngineSessionSettings.set_td2_support_enabled(z2);
            this.c.set_cnis_support_enabled(this.g == DocumentScanMode.CNIS);
            this.c.set_mrva_support_enabled(this.g == DocumentScanMode.MRV);
            mrzEngineSessionSettings = this.c;
            if (this.g == DocumentScanMode.MRV) {
                z = true;
            }
            mrzEngineSessionSettings.set_mrvb_support_enabled(z);
            this.e = new a();
            return;
        }
        throw new InvalidParameterException("Configuration model should be an instance of ScanPartModel");
    }

    protected void init() {
        this.f.submit(new b());
    }

    public void destroy() {
        cancel();
    }

    /* renamed from: a */
    public void feed(byte[] bArr) {
        if (!this.i && this.a != null) {
            this.i = true;
            this.d = new d(bArr, isPortrait());
            this.f.submit(this.d);
        }
    }

    protected void a() {
        if (this.m > this.o) {
            this.o = this.m;
            Log.i("MrzClient", String.format(Locale.getDefault(), "Previous image focus value %f was replaced with new image focus value %f", new Object[]{Float.valueOf(this.o), Float.valueOf(this.m)}));
            this.n = Arrays.copyOf(this.l, this.l.length);
        }
    }

    protected void b() {
        this.m = 0.0f;
        this.o = 0.0f;
        this.n = null;
        this.l = null;
    }

    protected void a(MrzResult mrzResult, ArrayList<ArrayList<JumioRect>> arrayList, byte[] bArr, int i, int i2, float f) {
        Object rgb2bitmap;
        String a;
        b(new ExtractionUpdate(ExtractionUpdateState.shotTaken, Float.valueOf(f)));
        DocumentDataModel cVar = new c();
        if (this.n != null) {
            rgb2bitmap = CameraUtils.rgb2bitmap(this.n, i, i2);
        } else {
            rgb2bitmap = CameraUtils.rgb2bitmap(bArr, i, i2);
        }
        b(new ExtractionUpdate(ExtractionUpdateState.saveImage, rgb2bitmap));
        b(new ExtractionUpdate(ExtractionUpdateState.saveExactImage, rgb2bitmap));
        StringVector mrzLines = mrzResult.getMrzLines();
        cVar.setIdNumber(a(mrzResult.getDocNum()));
        switch (this.g) {
            case MRV:
                a(mrzResult, cVar);
                break;
            case MRP:
                a = a(mrzResult.getOptData2());
                if (!(a == null || a.length() == 0)) {
                    a = a.replaceAll("\\s+", "");
                }
                cVar.setPersonalNumber(a);
                break;
            case TD1:
                a = a(mrzResult.getOptData1());
                if (!(a == null || a.length() == 0)) {
                    cVar.setOptionalData1(a);
                }
                a(mrzResult, cVar);
                break;
            case TD2:
            case CNIS:
                a(mrzResult, cVar);
                break;
        }
        cVar.setExpiryDate(a(mrzResult.getExpidate().getAsMrzDate(), false));
        a = a(mrzResult.getCountry());
        if (a != null) {
            a = a.trim();
        }
        if ("D".equals(a)) {
            a = "DEU";
        }
        cVar.setIssuingCountry(a);
        cVar.setLastName(a(mrzResult.getSecondName()));
        a = a(mrzResult.getFirstName());
        if (this.g != DocumentScanMode.CNIS || a == null) {
            cVar.setFirstName(a);
        } else {
            String[] split = a.split("\\s{2}", 2);
            if (split.length >= 1) {
                cVar.setFirstName(split[0]);
            }
            if (split.length >= 2) {
                cVar.setMiddleName(split[1].replaceAll("  ", " "));
            }
        }
        cVar.setDob(a(mrzResult.getBirthdate().getAsMrzDate(), true));
        if (NVGender.M.name().equals(a(mrzResult.getSex()))) {
            cVar.setGender(NVGender.M);
        } else if (NVGender.F.name().equals(a(mrzResult.getSex()))) {
            cVar.setGender(NVGender.F);
        }
        a = a(mrzResult.getNationality());
        if (a != null) {
            a = a.trim();
        }
        if ("D".equals(a)) {
            a = "DEU";
        }
        cVar.setOriginatingCountry(a);
        NVMRZFormat nVMRZFormat = null;
        int i3 = AnonymousClass1.a[this.g.ordinal()];
        if (i3 != 1) {
            switch (i3) {
                case 3:
                    nVMRZFormat = NVMRZFormat.TD1;
                    break;
                case 4:
                    nVMRZFormat = NVMRZFormat.TD2;
                    break;
                case 5:
                    nVMRZFormat = NVMRZFormat.CNIS;
                    break;
                default:
                    nVMRZFormat = NVMRZFormat.MRP;
                    break;
            }
        } else if (mrzLines.size() == 2 && mrzLines.get(0).length() == 36) {
            nVMRZFormat = NVMRZFormat.MRV_B;
        } else if (mrzLines.size() == 2 && mrzLines.get(0).length() == 44) {
            nVMRZFormat = NVMRZFormat.MRV_A;
        }
        cVar.a(mrzResult, nVMRZFormat);
        cVar.a(mrzLines);
        cVar.a((ArrayList) arrayList);
        f(cVar);
    }

    protected void a(MrzRectVector[] mrzRectVectorArr) {
        b(new ExtractionUpdate(b.a, mrzRectVectorArr));
    }

    public void cancel() {
        super.cancel();
    }

    private void a(MrzResult mrzResult, DocumentDataModel documentDataModel) {
        String a = a(mrzResult.getOptData2());
        if (a != null && a.length() != 0) {
            if (this.g == DocumentScanMode.CNIS) {
                documentDataModel.setPersonalNumber(a.replaceAll("\\s+", ""));
            } else {
                documentDataModel.setOptionalData2(a);
            }
        }
    }

    private Date a(MrzDate mrzDate, boolean z) {
        Calendar instance = Calendar.getInstance();
        if (mrzDate.getYear() == -1 || mrzDate.getMonth() < 1 || mrzDate.getMonth() > 12 || mrzDate.getDay() < 1 || mrzDate.getDay() > 31) {
            return null;
        }
        instance.set(mrzDate.getYear(), mrzDate.getMonth() - 1, mrzDate.getDay(), 0, 0, 0);
        Date time = instance.getTime();
        if (z) {
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                if (time.after(simpleDateFormat.parse(simpleDateFormat.format(new Date())))) {
                    return null;
                }
            } catch (ParseException unused) {
                return time;
            }
        }
    }

    private String a(MrzField mrzField) {
        return mrzField.getAsString();
    }
}
