package com.jumio.nv.liveness.extraction;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.FaceDetector.Builder;
import com.jumio.analytics.JumioAnalytics;
import com.jumio.analytics.MobileEvents;
import com.jumio.commons.camera.CameraUtils;
import com.jumio.commons.camera.PreviewProperties;
import com.jumio.commons.camera.Size;
import com.jumio.commons.log.Log;
import com.jumio.core.data.document.DocumentFormat;
import com.jumio.core.data.document.DocumentScanMode;
import com.jumio.core.mvp.model.StaticModel;
import com.jumio.nv.enums.NVErrorCase;
import com.jumio.nv.enums.NVLivenessResult;
import com.jumio.nv.liveness.overlay.LivenessOverlay;
import com.jumio.nv.models.DocumentDataModel;
import com.jumio.nv.models.ServerSettingsModel;
import com.jumio.persistence.DataAccess;
import com.jumio.sdk.exception.JumioException;
import com.jumio.sdk.extraction.ExtractionClient;
import com.jumio.sdk.extraction.ExtractionClient.ExtractionUpdate;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.Arrays;
import jumio.nv.core.q;

public class LivenessClient extends ExtractionClient<ExtractionUpdate, DocumentDataModel> {
    private static final int FACE_ALIGNMENT_TIME = 2500;
    protected static final float INVALID_SCORE_EYES_CLOSED = -4.0f;
    protected static final float INVALID_SCORE_NOT_DETECTED = -1.0f;
    protected static final float INVALID_SCORE_NOT_ENABLED = -2.0f;
    protected static final float INVALID_SCORE_OUT_OF_BOUNDS = -3.0f;
    protected static final int MESSAGE_AUTOMATIC_START_TIMER = 101;
    protected static final int MESSAGE_FACE_INVALID = 103;
    protected static final int MESSAGE_FACE_NOT_FOUND = 104;
    protected static final int MESSAGE_FACE_VALID = 102;
    protected static final int MESSAGE_FINISH = 106;
    protected static final int MESSAGE_INVALID_TIMER = 100;
    protected static final int MESSAGE_SAVE_IMAGES = 105;
    private static final String TAG = "LivenessManager";
    private boolean canDetectFace;
    private q faceDetector;
    private a faceDetectorWorker;
    private Bitmap fallbackFrame;
    private int frameId = 0;
    private Bitmap frameWithOpenEyes;
    protected Handler handler = new LivenessHandler(this);
    protected LivenessDataModel livenessDataModel;
    private LivenessSavingTask livenessSavingTask;
    protected final Object processLock = new Object();
    protected int unsuccessfulAttempts = 0;
    private Rect validAlignmentFrame;

    public class LivenessHandler extends Handler {
        private WeakReference<LivenessClient> clientWeakReference;

        public LivenessHandler(LivenessClient livenessClient) {
            super(Looper.getMainLooper());
            this.clientWeakReference = new WeakReference(livenessClient);
        }

        public synchronized void handleMessage(Message message) {
            LivenessClient livenessClient = (LivenessClient) this.clientWeakReference.get();
            if (livenessClient != null) {
                livenessClient.handleMessage(message);
            }
        }
    }

    class a extends Thread {
        private Frame b;
        private final Object c;
        private PreviewProperties d;
        private boolean e;

        private a() {
            this.b = null;
            this.c = new Object();
            this.e = false;
        }

        /* synthetic */ a(LivenessClient livenessClient, AnonymousClass1 anonymousClass1) {
            this();
        }

        public void a(Frame frame) {
            synchronized (this.c) {
                if (this.b != null) {
                    return;
                }
                this.b = frame;
            }
        }

        public void a(PreviewProperties previewProperties) {
            this.d = previewProperties;
        }

        public void a() {
            this.e = false;
        }

        /* JADX WARNING: Missing block: B:54:0x02b9, code:
            if ((r7.width() / ((float) com.jumio.nv.liveness.extraction.LivenessClient.access$3100(r15.a).width())) >= r9) goto L_0x02bd;
     */
        public void run() {
            /*
            r15 = this;
        L_0x0000:
            r0 = r15.isInterrupted();
            if (r0 != 0) goto L_0x0349;
        L_0x0006:
            r0 = r15.b;
            if (r0 == 0) goto L_0x0000;
        L_0x000a:
            r0 = 0;
            r1 = com.jumio.nv.liveness.extraction.LivenessClient.this;	 Catch:{ Exception -> 0x033a }
            r1 = r1.faceDetector;	 Catch:{ Exception -> 0x033a }
            r2 = r15.b;	 Catch:{ Exception -> 0x033a }
            r1 = r1.detect(r2);	 Catch:{ Exception -> 0x033a }
            r2 = com.jumio.nv.liveness.extraction.LivenessClient.this;	 Catch:{ Exception -> 0x033a }
            r2 = r2.processLock;	 Catch:{ Exception -> 0x033a }
            monitor-enter(r2);	 Catch:{ Exception -> 0x033a }
            r3 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
            r4 = 1;
            r5 = 0;
            if (r1 == 0) goto L_0x02e3;
        L_0x0022:
            r6 = r1.size();	 Catch:{ all -> 0x02e1 }
            if (r6 != r4) goto L_0x02e3;
        L_0x0028:
            r1 = r1.valueAt(r5);	 Catch:{ all -> 0x02e1 }
            r1 = (com.google.android.gms.vision.face.Face) r1;	 Catch:{ all -> 0x02e1 }
            r6 = com.jumio.nv.liveness.extraction.LivenessClient.this;	 Catch:{ all -> 0x02e1 }
            r6 = r6.handler;	 Catch:{ all -> 0x02e1 }
            r7 = 100;
            r6.removeMessages(r7);	 Catch:{ all -> 0x02e1 }
            r6 = r15.d;	 Catch:{ all -> 0x02e1 }
            r7 = com.jumio.nv.liveness.extraction.LivenessClient.this;	 Catch:{ all -> 0x02e1 }
            r7 = r7.validAlignmentFrame;	 Catch:{ all -> 0x02e1 }
            r6 = com.jumio.commons.camera.CameraUtils.surfaceToPreview(r6, r7);	 Catch:{ all -> 0x02e1 }
            r7 = r6.width();	 Catch:{ all -> 0x02e1 }
            r8 = 1077936128; // 0x40400000 float:3.0 double:5.325712093E-315;
            r7 = r7 / r8;
            r9 = r6.height();	 Catch:{ all -> 0x02e1 }
            r9 = r9 / r8;
            r6.inset(r7, r9);	 Catch:{ all -> 0x02e1 }
            r7 = new android.graphics.RectF;	 Catch:{ all -> 0x02e1 }
            r8 = r1.getPosition();	 Catch:{ all -> 0x02e1 }
            r8 = r8.x;	 Catch:{ all -> 0x02e1 }
            r9 = r1.getPosition();	 Catch:{ all -> 0x02e1 }
            r9 = r9.y;	 Catch:{ all -> 0x02e1 }
            r10 = r1.getPosition();	 Catch:{ all -> 0x02e1 }
            r10 = r10.x;	 Catch:{ all -> 0x02e1 }
            r11 = r1.getWidth();	 Catch:{ all -> 0x02e1 }
            r10 = r10 + r11;
            r11 = r1.getPosition();	 Catch:{ all -> 0x02e1 }
            r11 = r11.y;	 Catch:{ all -> 0x02e1 }
            r12 = r1.getHeight();	 Catch:{ all -> 0x02e1 }
            r11 = r11 + r12;
            r7.<init>(r8, r9, r10, r11);	 Catch:{ all -> 0x02e1 }
            r8 = com.jumio.nv.liveness.extraction.LivenessClient.this;	 Catch:{ all -> 0x02e1 }
            r8 = r8.validAlignmentFrame;	 Catch:{ all -> 0x02e1 }
            r8 = r8.width();	 Catch:{ all -> 0x02e1 }
            r8 = (float) r8;	 Catch:{ all -> 0x02e1 }
            r9 = com.jumio.nv.liveness.extraction.LivenessClient.this;	 Catch:{ all -> 0x02e1 }
            r9 = r9.extractionArea;	 Catch:{ all -> 0x02e1 }
            r9 = r9.width();	 Catch:{ all -> 0x02e1 }
            r9 = (float) r9;	 Catch:{ all -> 0x02e1 }
            r8 = r8 / r9;
            r9 = 1050253722; // 0x3e99999a float:0.3 double:5.188942835E-315;
            r8 = r8 - r9;
            r9 = com.jumio.nv.liveness.extraction.LivenessClient.this;	 Catch:{ all -> 0x02e1 }
            r9 = r9.validAlignmentFrame;	 Catch:{ all -> 0x02e1 }
            r9 = r9.width();	 Catch:{ all -> 0x02e1 }
            r9 = (float) r9;	 Catch:{ all -> 0x02e1 }
            r10 = com.jumio.nv.liveness.extraction.LivenessClient.this;	 Catch:{ all -> 0x02e1 }
            r10 = r10.extractionArea;	 Catch:{ all -> 0x02e1 }
            r10 = r10.width();	 Catch:{ all -> 0x02e1 }
            r10 = (float) r10;	 Catch:{ all -> 0x02e1 }
            r9 = r9 / r10;
            r10 = 1045220557; // 0x3e4ccccd float:0.2 double:5.164075695E-315;
            r9 = r9 + r10;
            r10 = com.jumio.commons.log.Log.LogLevel.DEBUG;	 Catch:{ all -> 0x02e1 }
            r10 = com.jumio.commons.log.Log.isLogEnabledForLevel(r10);	 Catch:{ all -> 0x02e1 }
            if (r10 == 0) goto L_0x0162;
        L_0x00b7:
            r10 = com.jumio.nv.liveness.extraction.LivenessClient.this;	 Catch:{ all -> 0x02e1 }
            r11 = new com.jumio.sdk.extraction.ExtractionClient$ExtractionUpdate;	 Catch:{ all -> 0x02e1 }
            r12 = com.jumio.nv.liveness.extraction.LivenessExtractionUpdateState.facePosition;	 Catch:{ all -> 0x02e1 }
            r13 = r15.d;	 Catch:{ all -> 0x02e1 }
            r13 = com.jumio.commons.camera.CameraUtils.previewToSurface(r13, r7);	 Catch:{ all -> 0x02e1 }
            r11.<init>(r12, r13);	 Catch:{ all -> 0x02e1 }
            r10.a(r11);	 Catch:{ all -> 0x02e1 }
            r10 = com.jumio.nv.liveness.extraction.LivenessClient.this;	 Catch:{ all -> 0x02e1 }
            r11 = new com.jumio.sdk.extraction.ExtractionClient$ExtractionUpdate;	 Catch:{ all -> 0x02e1 }
            r12 = com.jumio.nv.liveness.extraction.LivenessExtractionUpdateState.validAlignmentFrame;	 Catch:{ all -> 0x02e1 }
            r13 = r15.d;	 Catch:{ all -> 0x02e1 }
            r13 = com.jumio.commons.camera.CameraUtils.previewToSurface(r13, r6);	 Catch:{ all -> 0x02e1 }
            r11.<init>(r12, r13);	 Catch:{ all -> 0x02e1 }
            r10.a(r11);	 Catch:{ all -> 0x02e1 }
            r10 = new java.util.ArrayList;	 Catch:{ all -> 0x02e1 }
            r10.<init>();	 Catch:{ all -> 0x02e1 }
            r11 = "happiness: %.2f";
            r12 = new java.lang.Object[r4];	 Catch:{ all -> 0x02e1 }
            r13 = r1.getIsSmilingProbability();	 Catch:{ all -> 0x02e1 }
            r13 = java.lang.Float.valueOf(r13);	 Catch:{ all -> 0x02e1 }
            r12[r5] = r13;	 Catch:{ all -> 0x02e1 }
            r11 = java.lang.String.format(r11, r12);	 Catch:{ all -> 0x02e1 }
            r10.add(r11);	 Catch:{ all -> 0x02e1 }
            r11 = "right eye: %.2f";
            r12 = new java.lang.Object[r4];	 Catch:{ all -> 0x02e1 }
            r13 = r1.getIsRightEyeOpenProbability();	 Catch:{ all -> 0x02e1 }
            r13 = java.lang.Float.valueOf(r13);	 Catch:{ all -> 0x02e1 }
            r12[r5] = r13;	 Catch:{ all -> 0x02e1 }
            r11 = java.lang.String.format(r11, r12);	 Catch:{ all -> 0x02e1 }
            r10.add(r11);	 Catch:{ all -> 0x02e1 }
            r11 = "left eye: %.2f";
            r12 = new java.lang.Object[r4];	 Catch:{ all -> 0x02e1 }
            r13 = r1.getIsLeftEyeOpenProbability();	 Catch:{ all -> 0x02e1 }
            r13 = java.lang.Float.valueOf(r13);	 Catch:{ all -> 0x02e1 }
            r12[r5] = r13;	 Catch:{ all -> 0x02e1 }
            r11 = java.lang.String.format(r11, r12);	 Catch:{ all -> 0x02e1 }
            r10.add(r11);	 Catch:{ all -> 0x02e1 }
            r11 = "euler z: %.2f";
            r12 = new java.lang.Object[r4];	 Catch:{ all -> 0x02e1 }
            r13 = r1.getEulerZ();	 Catch:{ all -> 0x02e1 }
            r13 = java.lang.Float.valueOf(r13);	 Catch:{ all -> 0x02e1 }
            r12[r5] = r13;	 Catch:{ all -> 0x02e1 }
            r11 = java.lang.String.format(r11, r12);	 Catch:{ all -> 0x02e1 }
            r10.add(r11);	 Catch:{ all -> 0x02e1 }
            r11 = "width: %.2f";
            r12 = new java.lang.Object[r4];	 Catch:{ all -> 0x02e1 }
            r13 = r7.width();	 Catch:{ all -> 0x02e1 }
            r14 = com.jumio.nv.liveness.extraction.LivenessClient.this;	 Catch:{ all -> 0x02e1 }
            r14 = r14.extractionArea;	 Catch:{ all -> 0x02e1 }
            r14 = r14.width();	 Catch:{ all -> 0x02e1 }
            r14 = (float) r14;	 Catch:{ all -> 0x02e1 }
            r13 = r13 / r14;
            r13 = java.lang.Float.valueOf(r13);	 Catch:{ all -> 0x02e1 }
            r12[r5] = r13;	 Catch:{ all -> 0x02e1 }
            r11 = java.lang.String.format(r11, r12);	 Catch:{ all -> 0x02e1 }
            r10.add(r11);	 Catch:{ all -> 0x02e1 }
            r11 = com.jumio.nv.liveness.extraction.LivenessClient.this;	 Catch:{ all -> 0x02e1 }
            r12 = new com.jumio.sdk.extraction.ExtractionClient$ExtractionUpdate;	 Catch:{ all -> 0x02e1 }
            r13 = com.jumio.nv.liveness.extraction.LivenessExtractionUpdateState.faceDetails;	 Catch:{ all -> 0x02e1 }
            r12.<init>(r13, r10);	 Catch:{ all -> 0x02e1 }
            r11.a(r12);	 Catch:{ all -> 0x02e1 }
        L_0x0162:
            r10 = r1.getEulerZ();	 Catch:{ all -> 0x02e1 }
            r11 = -1032847360; // 0xffffffffc2700000 float:-60.0 double:NaN;
            r10 = (r10 > r11 ? 1 : (r10 == r11 ? 0 : -1));
            if (r10 < 0) goto L_0x0256;
        L_0x016c:
            r10 = r1.getEulerZ();	 Catch:{ all -> 0x02e1 }
            r11 = 1114636288; // 0x42700000 float:60.0 double:5.507034975E-315;
            r10 = (r10 > r11 ? 1 : (r10 == r11 ? 0 : -1));
            if (r10 > 0) goto L_0x0256;
        L_0x0176:
            r10 = r7.centerX();	 Catch:{ all -> 0x02e1 }
            r11 = r7.centerY();	 Catch:{ all -> 0x02e1 }
            r10 = r6.contains(r10, r11);	 Catch:{ all -> 0x02e1 }
            if (r10 == 0) goto L_0x0256;
        L_0x0184:
            r10 = r7.width();	 Catch:{ all -> 0x02e1 }
            r11 = com.jumio.nv.liveness.extraction.LivenessClient.this;	 Catch:{ all -> 0x02e1 }
            r11 = r11.extractionArea;	 Catch:{ all -> 0x02e1 }
            r11 = r11.width();	 Catch:{ all -> 0x02e1 }
            r11 = (float) r11;	 Catch:{ all -> 0x02e1 }
            r10 = r10 / r11;
            r10 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1));
            if (r10 <= 0) goto L_0x0256;
        L_0x0198:
            r10 = r7.width();	 Catch:{ all -> 0x02e1 }
            r11 = com.jumio.nv.liveness.extraction.LivenessClient.this;	 Catch:{ all -> 0x02e1 }
            r11 = r11.extractionArea;	 Catch:{ all -> 0x02e1 }
            r11 = r11.width();	 Catch:{ all -> 0x02e1 }
            r11 = (float) r11;	 Catch:{ all -> 0x02e1 }
            r10 = r10 / r11;
            r10 = (r10 > r9 ? 1 : (r10 == r9 ? 0 : -1));
            if (r10 >= 0) goto L_0x0256;
        L_0x01ac:
            r6 = com.jumio.nv.liveness.extraction.LivenessClient.this;	 Catch:{ all -> 0x02e1 }
            r6 = r6.handler;	 Catch:{ all -> 0x02e1 }
            r7 = 102; // 0x66 float:1.43E-43 double:5.04E-322;
            r6.sendEmptyMessage(r7);	 Catch:{ all -> 0x02e1 }
            r6 = r15.b;	 Catch:{ all -> 0x02e1 }
            r6 = r6.getGrayscaleImageData();	 Catch:{ all -> 0x02e1 }
            r6 = r6.array();	 Catch:{ all -> 0x02e1 }
            r7 = r15.d;	 Catch:{ all -> 0x02e1 }
            r7 = r7.camera;	 Catch:{ all -> 0x02e1 }
            r7 = r7.width;	 Catch:{ all -> 0x02e1 }
            r8 = r15.d;	 Catch:{ all -> 0x02e1 }
            r8 = r8.camera;	 Catch:{ all -> 0x02e1 }
            r8 = r8.height;	 Catch:{ all -> 0x02e1 }
            r5 = com.jumio.core.ImageQuality.calculateFocus(r6, r7, r8, r5);	 Catch:{ all -> 0x02e1 }
            r6 = com.jumio.nv.liveness.extraction.LivenessClient.this;	 Catch:{ all -> 0x02e1 }
            r6 = r6.frameWithOpenEyes;	 Catch:{ all -> 0x02e1 }
            r7 = 640; // 0x280 float:8.97E-43 double:3.16E-321;
            if (r6 != 0) goto L_0x0215;
        L_0x01d9:
            r6 = 1039516303; // 0x3df5c28f float:0.12 double:5.135892936E-315;
            r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1));
            if (r5 < 0) goto L_0x0215;
        L_0x01e0:
            r5 = r1.getIsLeftEyeOpenProbability();	 Catch:{ all -> 0x02e1 }
            r6 = 1061997773; // 0x3f4ccccd float:0.8 double:5.246966156E-315;
            r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1));
            if (r5 <= 0) goto L_0x0215;
        L_0x01eb:
            r1 = r1.getIsRightEyeOpenProbability();	 Catch:{ all -> 0x02e1 }
            r1 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1));
            if (r1 <= 0) goto L_0x0215;
        L_0x01f3:
            r1 = com.jumio.nv.liveness.extraction.LivenessClient.this;	 Catch:{ all -> 0x02e1 }
            r5 = r15.b;	 Catch:{ all -> 0x02e1 }
            r5 = r5.getGrayscaleImageData();	 Catch:{ all -> 0x02e1 }
            r5 = r5.array();	 Catch:{ all -> 0x02e1 }
            r6 = com.jumio.nv.liveness.extraction.LivenessClient.this;	 Catch:{ all -> 0x02e1 }
            r6 = r6.mIsPortrait;	 Catch:{ all -> 0x02e1 }
            r8 = r15.d;	 Catch:{ all -> 0x02e1 }
            r9 = com.jumio.nv.liveness.extraction.LivenessClient.this;	 Catch:{ all -> 0x02e1 }
            r9 = r9.extractionArea;	 Catch:{ all -> 0x02e1 }
            r5 = com.jumio.commons.camera.CameraUtils.yuv2bitmap(r5, r6, r8, r9, r7);	 Catch:{ all -> 0x02e1 }
            r1.frameWithOpenEyes = r5;	 Catch:{ all -> 0x02e1 }
            goto L_0x0245;
        L_0x0215:
            r1 = com.jumio.nv.liveness.extraction.LivenessClient.this;	 Catch:{ all -> 0x02e1 }
            r1 = r1.unsuccessfulAttempts;	 Catch:{ all -> 0x02e1 }
            r5 = 2;
            if (r1 < r5) goto L_0x0245;
        L_0x021c:
            r1 = com.jumio.nv.liveness.extraction.LivenessClient.this;	 Catch:{ all -> 0x02e1 }
            r1 = r1.fallbackFrame;	 Catch:{ all -> 0x02e1 }
            if (r1 != 0) goto L_0x0245;
        L_0x0224:
            r1 = com.jumio.nv.liveness.extraction.LivenessClient.this;	 Catch:{ all -> 0x02e1 }
            r5 = r15.b;	 Catch:{ all -> 0x02e1 }
            r5 = r5.getGrayscaleImageData();	 Catch:{ all -> 0x02e1 }
            r5 = r5.array();	 Catch:{ all -> 0x02e1 }
            r6 = com.jumio.nv.liveness.extraction.LivenessClient.this;	 Catch:{ all -> 0x02e1 }
            r6 = r6.mIsPortrait;	 Catch:{ all -> 0x02e1 }
            r8 = r15.d;	 Catch:{ all -> 0x02e1 }
            r9 = com.jumio.nv.liveness.extraction.LivenessClient.this;	 Catch:{ all -> 0x02e1 }
            r9 = r9.extractionArea;	 Catch:{ all -> 0x02e1 }
            r5 = com.jumio.commons.camera.CameraUtils.yuv2bitmap(r5, r6, r8, r9, r7);	 Catch:{ all -> 0x02e1 }
            r1.fallbackFrame = r5;	 Catch:{ all -> 0x02e1 }
        L_0x0245:
            r1 = r15.e;	 Catch:{ all -> 0x02e1 }
            if (r1 != 0) goto L_0x0336;
        L_0x0249:
            r15.e = r4;	 Catch:{ all -> 0x02e1 }
            r1 = com.jumio.nv.liveness.extraction.LivenessClient.this;	 Catch:{ all -> 0x02e1 }
            r1 = r1.handler;	 Catch:{ all -> 0x02e1 }
            r4 = 2500; // 0x9c4 float:3.503E-42 double:1.235E-320;
            r1.sendEmptyMessageDelayed(r3, r4);	 Catch:{ all -> 0x02e1 }
            goto L_0x0336;
        L_0x0256:
            r15.e = r5;	 Catch:{ all -> 0x02e1 }
            r1 = com.jumio.nv.liveness.extraction.LivenessClient.this;	 Catch:{ all -> 0x02e1 }
            r1 = r1.handler;	 Catch:{ all -> 0x02e1 }
            r1.removeMessages(r3);	 Catch:{ all -> 0x02e1 }
            r1 = com.jumio.nv.liveness.extraction.LivenessClient.this;	 Catch:{ all -> 0x02e1 }
            r1 = r1.frameWithOpenEyes;	 Catch:{ all -> 0x02e1 }
            if (r1 == 0) goto L_0x0282;
        L_0x0267:
            r1 = com.jumio.nv.liveness.extraction.LivenessClient.this;	 Catch:{ all -> 0x02e1 }
            r1 = r1.canDetectFace;	 Catch:{ all -> 0x02e1 }
            if (r1 == 0) goto L_0x0282;
        L_0x026f:
            r1 = "recycle frameWithOpenEyes - face invalid";
            com.jumio.commons.log.Log.w(r1);	 Catch:{ all -> 0x02e1 }
            r1 = com.jumio.nv.liveness.extraction.LivenessClient.this;	 Catch:{ all -> 0x02e1 }
            r1 = r1.frameWithOpenEyes;	 Catch:{ all -> 0x02e1 }
            r1.recycle();	 Catch:{ all -> 0x02e1 }
            r1 = com.jumio.nv.liveness.extraction.LivenessClient.this;	 Catch:{ all -> 0x02e1 }
            r1.frameWithOpenEyes = r0;	 Catch:{ all -> 0x02e1 }
        L_0x0282:
            r1 = r7.centerX();	 Catch:{ all -> 0x02e1 }
            r3 = r7.centerY();	 Catch:{ all -> 0x02e1 }
            r1 = r6.contains(r1, r3);	 Catch:{ all -> 0x02e1 }
            if (r1 == 0) goto L_0x02bc;
        L_0x0290:
            r1 = r7.width();	 Catch:{ all -> 0x02e1 }
            r3 = com.jumio.nv.liveness.extraction.LivenessClient.this;	 Catch:{ all -> 0x02e1 }
            r3 = r3.extractionArea;	 Catch:{ all -> 0x02e1 }
            r3 = r3.width();	 Catch:{ all -> 0x02e1 }
            r3 = (float) r3;	 Catch:{ all -> 0x02e1 }
            r1 = r1 / r3;
            r1 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1));
            if (r1 > 0) goto L_0x02a7;
        L_0x02a4:
            r4 = 0;
            r5 = 1;
            goto L_0x02bd;
        L_0x02a7:
            r1 = r7.width();	 Catch:{ all -> 0x02e1 }
            r3 = com.jumio.nv.liveness.extraction.LivenessClient.this;	 Catch:{ all -> 0x02e1 }
            r3 = r3.extractionArea;	 Catch:{ all -> 0x02e1 }
            r3 = r3.width();	 Catch:{ all -> 0x02e1 }
            r3 = (float) r3;	 Catch:{ all -> 0x02e1 }
            r1 = r1 / r3;
            r1 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1));
            if (r1 < 0) goto L_0x02bc;
        L_0x02bb:
            goto L_0x02bd;
        L_0x02bc:
            r4 = 0;
        L_0x02bd:
            r1 = new android.os.Bundle;	 Catch:{ all -> 0x02e1 }
            r1.<init>();	 Catch:{ all -> 0x02e1 }
            r3 = "small";
            r1.putBoolean(r3, r5);	 Catch:{ all -> 0x02e1 }
            r3 = "big";
            r1.putBoolean(r3, r4);	 Catch:{ all -> 0x02e1 }
            r3 = new android.os.Message;	 Catch:{ all -> 0x02e1 }
            r3.<init>();	 Catch:{ all -> 0x02e1 }
            r4 = 103; // 0x67 float:1.44E-43 double:5.1E-322;
            r3.what = r4;	 Catch:{ all -> 0x02e1 }
            r3.setData(r1);	 Catch:{ all -> 0x02e1 }
            r1 = com.jumio.nv.liveness.extraction.LivenessClient.this;	 Catch:{ all -> 0x02e1 }
            r1 = r1.handler;	 Catch:{ all -> 0x02e1 }
            r1.sendMessage(r3);	 Catch:{ all -> 0x02e1 }
            goto L_0x0336;
        L_0x02e1:
            r1 = move-exception;
            goto L_0x0338;
        L_0x02e3:
            r6 = com.jumio.nv.liveness.extraction.LivenessClient.this;	 Catch:{ all -> 0x02e1 }
            r6 = r6.frameWithOpenEyes;	 Catch:{ all -> 0x02e1 }
            if (r6 == 0) goto L_0x0324;
        L_0x02eb:
            r6 = com.jumio.nv.liveness.extraction.LivenessClient.this;	 Catch:{ all -> 0x02e1 }
            r6 = r6.canDetectFace;	 Catch:{ all -> 0x02e1 }
            if (r6 == 0) goto L_0x0324;
        L_0x02f3:
            if (r1 == 0) goto L_0x0311;
        L_0x02f5:
            r6 = r1.size();	 Catch:{ all -> 0x02e1 }
            if (r6 <= r4) goto L_0x0311;
        L_0x02fb:
            r6 = "recycle frameWithOpenEyes - %d faces found";
            r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x02e1 }
            r1 = r1.size();	 Catch:{ all -> 0x02e1 }
            r1 = java.lang.Integer.valueOf(r1);	 Catch:{ all -> 0x02e1 }
            r4[r5] = r1;	 Catch:{ all -> 0x02e1 }
            r1 = java.lang.String.format(r6, r4);	 Catch:{ all -> 0x02e1 }
            com.jumio.commons.log.Log.w(r1);	 Catch:{ all -> 0x02e1 }
            goto L_0x0316;
        L_0x0311:
            r1 = "recycle frameWithOpenEyes - no face found";
            com.jumio.commons.log.Log.w(r1);	 Catch:{ all -> 0x02e1 }
        L_0x0316:
            r1 = com.jumio.nv.liveness.extraction.LivenessClient.this;	 Catch:{ all -> 0x02e1 }
            r1 = r1.frameWithOpenEyes;	 Catch:{ all -> 0x02e1 }
            r1.recycle();	 Catch:{ all -> 0x02e1 }
            r1 = com.jumio.nv.liveness.extraction.LivenessClient.this;	 Catch:{ all -> 0x02e1 }
            r1.frameWithOpenEyes = r0;	 Catch:{ all -> 0x02e1 }
        L_0x0324:
            r15.e = r5;	 Catch:{ all -> 0x02e1 }
            r1 = com.jumio.nv.liveness.extraction.LivenessClient.this;	 Catch:{ all -> 0x02e1 }
            r1 = r1.handler;	 Catch:{ all -> 0x02e1 }
            r1.removeMessages(r3);	 Catch:{ all -> 0x02e1 }
            r1 = com.jumio.nv.liveness.extraction.LivenessClient.this;	 Catch:{ all -> 0x02e1 }
            r1 = r1.handler;	 Catch:{ all -> 0x02e1 }
            r3 = 104; // 0x68 float:1.46E-43 double:5.14E-322;
            r1.sendEmptyMessage(r3);	 Catch:{ all -> 0x02e1 }
        L_0x0336:
            monitor-exit(r2);	 Catch:{ all -> 0x02e1 }
            goto L_0x033e;
        L_0x0338:
            monitor-exit(r2);	 Catch:{ all -> 0x02e1 }
            throw r1;	 Catch:{ Exception -> 0x033a }
        L_0x033a:
            r1 = move-exception;
            com.jumio.commons.log.Log.printStackTrace(r1);
        L_0x033e:
            r1 = r15.c;
            monitor-enter(r1);
            r15.b = r0;	 Catch:{ all -> 0x0346 }
            monitor-exit(r1);	 Catch:{ all -> 0x0346 }
            goto L_0x0000;
        L_0x0346:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0346 }
            throw r0;
        L_0x0349:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jumio.nv.liveness.extraction.LivenessClient.a.run():void");
        }
    }

    public LivenessClient(Context context) {
        super(context);
    }

    public static String getVisionStatus(Context context) {
        try {
            if (GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context) != 0) {
                throw new Exception(String.format("Google Play Services not Available - Code: %d", new Object[]{Integer.valueOf(GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context))}));
            }
            q qVar = new q(new Builder(context).setLandmarkType(0).setMode(1).setProminentFaceOnly(false).setClassificationType(1).build());
            if (qVar.isOperational()) {
                qVar.release();
                return null;
            }
            throw new Exception("Facedetector not operational");
        } catch (Exception e) {
            return e.getMessage();
        } catch (NoClassDefFoundError e2) {
            return e2.getMessage();
        }
    }

    public Size getPrefferedPreviewSize() {
        return new Size(1280, 720);
    }

    public void configure(StaticModel staticModel) {
        this.livenessSavingTask = new LivenessSavingTask(this.mContext, ((ServerSettingsModel) DataAccess.load(this.mContext, ServerSettingsModel.class)).getMaxLivenessImages(), 60);
        this.livenessSavingTask.start();
        this.faceDetectorWorker = new a(this, null);
        this.faceDetectorWorker.start();
    }

    public void setDataExtractionActive(boolean z) {
        boolean z2 = (this.mIsPortrait || this.mIsTablet) && z;
        super.setDataExtractionActive(z2);
        if (z) {
            resetValuesAndArrays();
            resetFaceDetection();
        }
    }

    protected void init() {
        new Thread(new Runnable() {
            public void run() {
                try {
                    LivenessOverlay livenessOverlay = new LivenessOverlay(LivenessClient.this.mContext);
                    livenessOverlay.calculate(DocumentScanMode.FACE, DocumentFormat.NONE, LivenessClient.this.extractionArea);
                    LivenessClient.this.validAlignmentFrame = new Rect(livenessOverlay.getOverlayBounds());
                    LivenessClient.this.livenessSavingTask.init(LivenessClient.this.getPreviewProperties(), LivenessClient.this.extractionArea, LivenessClient.this.mIsPortrait);
                    LivenessClient.this.livenessSavingTask.setActive(LivenessClient.this.mIsPortrait);
                    LivenessClient.this.faceDetectorWorker.a(LivenessClient.this.getPreviewProperties());
                    LivenessClient.this.frameId = 0;
                    int isGooglePlayServicesAvailable = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(LivenessClient.this.mContext);
                    if (isGooglePlayServicesAvailable != 0) {
                        throw new JumioException(NVErrorCase.GOOGLE_VISION_LOADING_FAILED, isGooglePlayServicesAvailable);
                    }
                    if (LivenessClient.this.faceDetector != null) {
                        LivenessClient.this.faceDetector.release();
                        LivenessClient.this.faceDetector = null;
                    }
                    LivenessClient.this.faceDetector = new q(new Builder(LivenessClient.this.mContext).setLandmarkType(0).setMode(1).setProminentFaceOnly(false).setClassificationType(1).build());
                    if (LivenessClient.this.faceDetector.isOperational()) {
                        synchronized (LivenessClient.this.processLock) {
                            LivenessClient.this.canDetectFace = true;
                        }
                        return;
                    }
                    throw new Exception("FaceDetector not operational");
                } catch (Throwable e) {
                    if (e instanceof JumioException) {
                        LivenessClient.this.e(e);
                    } else {
                        LivenessClient.this.e(new JumioException(NVErrorCase.GOOGLE_VISION_LOADING_FAILED));
                    }
                }
            }
        }).start();
    }

    public void destroy() {
        if (this.faceDetector != null) {
            this.faceDetector.release();
            this.faceDetector = null;
        }
        if (this.faceDetectorWorker != null) {
            this.faceDetectorWorker.interrupt();
            this.faceDetectorWorker = null;
        }
        if (this.livenessSavingTask != null) {
            this.livenessSavingTask.interrupt();
            this.livenessSavingTask = null;
        }
        if (this.frameWithOpenEyes != null) {
            Log.w("recycle frameWithOpenEyes - destroy");
            this.frameWithOpenEyes.recycle();
            this.frameWithOpenEyes = null;
        }
    }

    public void cancel() {
        super.cancel();
    }

    public void feed(byte[] bArr) {
        PreviewProperties previewProperties = getPreviewProperties();
        if (previewProperties != null) {
            int i = this.frameId;
            this.frameId = i + 1;
            if (i >= 5) {
                synchronized (this.processLock) {
                    if (this.canDetectFace && this.faceDetectorWorker != null) {
                        Frame build = new Frame.Builder().setImageData(ByteBuffer.wrap(Arrays.copyOf(bArr, bArr.length)), previewProperties.camera.width, previewProperties.camera.height, 17).setRotation(CameraUtils.getImageRotation(previewProperties)).setTimestampMillis(System.currentTimeMillis()).setId(this.frameId).build();
                        if (this.livenessSavingTask != null) {
                            this.livenessSavingTask.add(build);
                        }
                        this.faceDetectorWorker.a(build);
                    }
                }
            }
        }
    }

    protected void resetFaceDetection() {
        this.faceDetectorWorker.a();
        this.canDetectFace = true;
    }

    /* JADX WARNING: Missing block: B:72:0x013d, code:
            return;
     */
    protected void handleMessage(android.os.Message r12) {
        /*
        r11 = this;
        if (r12 != 0) goto L_0x0003;
    L_0x0002:
        return;
    L_0x0003:
        r0 = r12.what;
        r1 = 2;
        r2 = 0;
        r3 = 1;
        r4 = 0;
        switch(r0) {
            case 100: goto L_0x014b;
            case 101: goto L_0x00d8;
            case 102: goto L_0x00c1;
            case 103: goto L_0x00a6;
            case 104: goto L_0x008f;
            case 105: goto L_0x002c;
            case 106: goto L_0x000e;
            default: goto L_0x000c;
        };
    L_0x000c:
        goto L_0x0156;
    L_0x000e:
        r12 = r11.processLock;
        monitor-enter(r12);
        r0 = new com.jumio.sdk.extraction.ExtractionClient$ExtractionUpdate;	 Catch:{ all -> 0x0029 }
        r1 = com.jumio.sdk.extraction.ExtractionUpdateState.shotTaken;	 Catch:{ all -> 0x0029 }
        r2 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r2 = java.lang.Float.valueOf(r2);	 Catch:{ all -> 0x0029 }
        r0.<init>(r1, r2);	 Catch:{ all -> 0x0029 }
        r11.a(r0);	 Catch:{ all -> 0x0029 }
        r0 = r11.livenessDataModel;	 Catch:{ all -> 0x0029 }
        r11.b(r0);	 Catch:{ all -> 0x0029 }
        monitor-exit(r12);	 Catch:{ all -> 0x0029 }
        goto L_0x0156;
    L_0x0029:
        r0 = move-exception;
        monitor-exit(r12);	 Catch:{ all -> 0x0029 }
        throw r0;
    L_0x002c:
        r12 = r11.processLock;
        monitor-enter(r12);
        r0 = new com.jumio.sdk.extraction.ExtractionClient$ExtractionUpdate;	 Catch:{ all -> 0x008c }
        r2 = com.jumio.sdk.extraction.ExtractionUpdateState.saveImage;	 Catch:{ all -> 0x008c }
        r5 = r11.frameWithOpenEyes;	 Catch:{ all -> 0x008c }
        r0.<init>(r2, r5);	 Catch:{ all -> 0x008c }
        r11.a(r0);	 Catch:{ all -> 0x008c }
        r0 = new com.jumio.sdk.extraction.ExtractionClient$ExtractionUpdate;	 Catch:{ all -> 0x008c }
        r2 = com.jumio.sdk.extraction.ExtractionUpdateState.saveExactImage;	 Catch:{ all -> 0x008c }
        r5 = r11.frameWithOpenEyes;	 Catch:{ all -> 0x008c }
        r0.<init>(r2, r5);	 Catch:{ all -> 0x008c }
        r11.a(r0);	 Catch:{ all -> 0x008c }
        r0 = r11.livenessSavingTask;	 Catch:{ all -> 0x008c }
        if (r0 == 0) goto L_0x0089;
    L_0x004b:
        r0 = r11.livenessSavingTask;	 Catch:{ all -> 0x008c }
        r0 = r0.finish();	 Catch:{ all -> 0x008c }
        r2 = r11.livenessDataModel;	 Catch:{ all -> 0x008c }
        r2.setFrames(r0);	 Catch:{ all -> 0x008c }
        r2 = com.jumio.commons.log.Log.isFileLoggingActivated();	 Catch:{ all -> 0x008c }
        if (r2 == 0) goto L_0x0089;
    L_0x005c:
        r2 = 0;
    L_0x005d:
        r5 = r0.length;	 Catch:{ all -> 0x008c }
        if (r2 >= r5) goto L_0x0089;
    L_0x0060:
        r5 = new java.io.File;	 Catch:{ all -> 0x008c }
        r6 = r0[r2];	 Catch:{ all -> 0x008c }
        r5.<init>(r6);	 Catch:{ all -> 0x008c }
        r5 = r5.getName();	 Catch:{ all -> 0x008c }
        r6 = r0[r2];	 Catch:{ all -> 0x008c }
        r7 = com.jumio.nv.liveness.extraction.LivenessClient.class;
        r7 = r7.getSimpleName();	 Catch:{ all -> 0x008c }
        r8 = "%02d_%s.jpg";
        r9 = new java.lang.Object[r1];	 Catch:{ all -> 0x008c }
        r10 = java.lang.Integer.valueOf(r2);	 Catch:{ all -> 0x008c }
        r9[r4] = r10;	 Catch:{ all -> 0x008c }
        r9[r3] = r5;	 Catch:{ all -> 0x008c }
        r5 = java.lang.String.format(r8, r9);	 Catch:{ all -> 0x008c }
        com.jumio.nv.utils.NetverifyLogUtils.copyFile(r6, r7, r5);	 Catch:{ all -> 0x008c }
        r2 = r2 + 1;
        goto L_0x005d;
    L_0x0089:
        monitor-exit(r12);	 Catch:{ all -> 0x008c }
        goto L_0x0156;
    L_0x008c:
        r0 = move-exception;
        monitor-exit(r12);	 Catch:{ all -> 0x008c }
        throw r0;
    L_0x008f:
        r0 = r11.processLock;
        monitor-enter(r0);
        r12 = r11.canDetectFace;	 Catch:{ all -> 0x00a3 }
        if (r12 == 0) goto L_0x00a0;
    L_0x0096:
        r12 = new com.jumio.sdk.extraction.ExtractionClient$ExtractionUpdate;	 Catch:{ all -> 0x00a3 }
        r1 = com.jumio.nv.liveness.extraction.LivenessExtractionUpdateState.faceAlignmentOutOfBounds;	 Catch:{ all -> 0x00a3 }
        r12.<init>(r1, r2);	 Catch:{ all -> 0x00a3 }
        r11.a(r12);	 Catch:{ all -> 0x00a3 }
    L_0x00a0:
        monitor-exit(r0);	 Catch:{ all -> 0x00a3 }
        goto L_0x0156;
    L_0x00a3:
        r12 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x00a3 }
        throw r12;
    L_0x00a6:
        r0 = r11.processLock;
        monitor-enter(r0);
        r1 = r11.canDetectFace;	 Catch:{ all -> 0x00be }
        if (r1 == 0) goto L_0x00bb;
    L_0x00ad:
        r12 = r12.getData();	 Catch:{ all -> 0x00be }
        r1 = new com.jumio.sdk.extraction.ExtractionClient$ExtractionUpdate;	 Catch:{ all -> 0x00be }
        r2 = com.jumio.nv.liveness.extraction.LivenessExtractionUpdateState.faceAlignmentInvalid;	 Catch:{ all -> 0x00be }
        r1.<init>(r2, r12);	 Catch:{ all -> 0x00be }
        r11.a(r1);	 Catch:{ all -> 0x00be }
    L_0x00bb:
        monitor-exit(r0);	 Catch:{ all -> 0x00be }
        goto L_0x0156;
    L_0x00be:
        r12 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x00be }
        throw r12;
    L_0x00c1:
        r12 = r11.processLock;
        monitor-enter(r12);
        r0 = r11.canDetectFace;	 Catch:{ all -> 0x00d5 }
        if (r0 == 0) goto L_0x00d2;
    L_0x00c8:
        r0 = new com.jumio.sdk.extraction.ExtractionClient$ExtractionUpdate;	 Catch:{ all -> 0x00d5 }
        r1 = com.jumio.nv.liveness.extraction.LivenessExtractionUpdateState.faceAlignmentValid;	 Catch:{ all -> 0x00d5 }
        r0.<init>(r1, r2);	 Catch:{ all -> 0x00d5 }
        r11.a(r0);	 Catch:{ all -> 0x00d5 }
    L_0x00d2:
        monitor-exit(r12);	 Catch:{ all -> 0x00d5 }
        goto L_0x0156;
    L_0x00d5:
        r0 = move-exception;
        monitor-exit(r12);	 Catch:{ all -> 0x00d5 }
        throw r0;
    L_0x00d8:
        r12 = r11.processLock;
        monitor-enter(r12);
        r0 = r11.frameWithOpenEyes;	 Catch:{ all -> 0x0148 }
        if (r0 != 0) goto L_0x013e;
    L_0x00df:
        r0 = r11.unsuccessfulAttempts;	 Catch:{ all -> 0x0148 }
        r0 = r0 + r3;
        r11.unsuccessfulAttempts = r0;	 Catch:{ all -> 0x0148 }
        r0 = r11.unsuccessfulAttempts;	 Catch:{ all -> 0x0148 }
        r3 = 4;
        if (r0 < r3) goto L_0x0122;
    L_0x00e9:
        r0 = new com.jumio.nv.liveness.extraction.LivenessDataModel;	 Catch:{ all -> 0x0148 }
        r0.<init>();	 Catch:{ all -> 0x0148 }
        r11.livenessDataModel = r0;	 Catch:{ all -> 0x0148 }
        r0 = r11.livenessDataModel;	 Catch:{ all -> 0x0148 }
        r1 = com.jumio.nv.enums.NVLivenessResult.BO;	 Catch:{ all -> 0x0148 }
        r0.setLivenessResult(r1);	 Catch:{ all -> 0x0148 }
        r0 = r11.livenessDataModel;	 Catch:{ all -> 0x0148 }
        r1 = -1065353216; // 0xffffffffc0800000 float:-4.0 double:NaN;
        r0.setLivenessValue(r1);	 Catch:{ all -> 0x0148 }
        r0 = com.jumio.analytics.JumioAnalytics.getSessionId();	 Catch:{ all -> 0x0148 }
        r1 = com.jumio.analytics.Screen.SCAN;	 Catch:{ all -> 0x0148 }
        r2 = com.jumio.analytics.UserAction.EYE_TRACKING_EYES_CLOSED;	 Catch:{ all -> 0x0148 }
        r0 = com.jumio.analytics.MobileEvents.userAction(r0, r1, r2);	 Catch:{ all -> 0x0148 }
        com.jumio.analytics.JumioAnalytics.add(r0);	 Catch:{ all -> 0x0148 }
        r0 = r11.fallbackFrame;	 Catch:{ all -> 0x0148 }
        r11.frameWithOpenEyes = r0;	 Catch:{ all -> 0x0148 }
        r0 = r11.handler;	 Catch:{ all -> 0x0148 }
        r1 = 105; // 0x69 float:1.47E-43 double:5.2E-322;
        r0.sendEmptyMessage(r1);	 Catch:{ all -> 0x0148 }
        r0 = r11.handler;	 Catch:{ all -> 0x0148 }
        r1 = 106; // 0x6a float:1.49E-43 double:5.24E-322;
        r0.sendEmptyMessage(r1);	 Catch:{ all -> 0x0148 }
        r11.canDetectFace = r4;	 Catch:{ all -> 0x0148 }
        goto L_0x013c;
    L_0x0122:
        r0 = r11.unsuccessfulAttempts;	 Catch:{ all -> 0x0148 }
        if (r0 != r1) goto L_0x0133;
    L_0x0126:
        r11.canDetectFace = r4;	 Catch:{ all -> 0x0148 }
        r0 = new com.jumio.sdk.extraction.ExtractionClient$ExtractionUpdate;	 Catch:{ all -> 0x0148 }
        r1 = com.jumio.nv.extraction.NVExtractionUpdateState.showHelp;	 Catch:{ all -> 0x0148 }
        r0.<init>(r1, r2);	 Catch:{ all -> 0x0148 }
        r11.a(r0);	 Catch:{ all -> 0x0148 }
        goto L_0x013c;
    L_0x0133:
        r0 = r11.faceDetectorWorker;	 Catch:{ all -> 0x0148 }
        if (r0 == 0) goto L_0x013c;
    L_0x0137:
        r0 = r11.faceDetectorWorker;	 Catch:{ all -> 0x0148 }
        r0.a();	 Catch:{ all -> 0x0148 }
    L_0x013c:
        monitor-exit(r12);	 Catch:{ all -> 0x0148 }
        return;
    L_0x013e:
        r11.canDetectFace = r4;	 Catch:{ all -> 0x0148 }
        r11.resetValuesAndArrays();	 Catch:{ all -> 0x0148 }
        r11.automaticStartAttempt();	 Catch:{ all -> 0x0148 }
        monitor-exit(r12);	 Catch:{ all -> 0x0148 }
        goto L_0x0156;
    L_0x0148:
        r0 = move-exception;
        monitor-exit(r12);	 Catch:{ all -> 0x0148 }
        throw r0;
    L_0x014b:
        r12 = r11.processLock;
        monitor-enter(r12);
        r11.faceNotInScreen();	 Catch:{ all -> 0x0153 }
        monitor-exit(r12);	 Catch:{ all -> 0x0153 }
        goto L_0x0156;
    L_0x0153:
        r0 = move-exception;
        monitor-exit(r12);	 Catch:{ all -> 0x0153 }
        throw r0;
    L_0x0156:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.nv.liveness.extraction.LivenessClient.handleMessage(android.os.Message):void");
    }

    protected void automaticStartAttempt() {
        this.livenessDataModel = new LivenessDataModel();
        this.livenessDataModel.setLivenessResult(NVLivenessResult.BO);
        this.livenessDataModel.setLivenessValue(INVALID_SCORE_NOT_ENABLED);
        this.handler.sendEmptyMessage(105);
        this.handler.sendEmptyMessage(106);
        JumioAnalytics.add(MobileEvents.customAlert(JumioAnalytics.getSessionId(), "EyeTrackingInitFailed", null));
    }

    protected void faceNotInScreen() {
        resetValuesAndArrays();
        a(new ExtractionUpdate(LivenessExtractionUpdateState.faceAlignmentOutOfBounds, null));
    }

    protected void resetValuesAndArrays() {
        this.handler.removeMessages(100);
        this.handler.removeMessages(101);
    }
}
