package com.iqoption.withdrawal.crypto.barcode.camera;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.ImageFormat;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.os.SystemClock;
import android.support.annotation.RequiresPermission;
import android.view.SurfaceHolder;
import android.view.WindowManager;
import com.google.android.gms.common.images.Size;
import com.google.android.gms.vision.Detector;
import com.iqoption.core.i;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: CameraSource */
public class a {
    private final Object dSh;
    private Camera dSi;
    private int dSj;
    private int dSk;
    private Size dSl;
    private float dSm;
    private int dSn;
    private int dSo;
    private String dSp;
    private String dSq;
    private Thread dSr;
    private c dSs;
    private Map<byte[], ByteBuffer> dSt;
    private Context mContext;

    /* compiled from: CameraSource */
    public static class a {
        private a dSa = new a();
        private final Detector<?> dSu;

        public a(Context context, Detector<?> detector) {
            if (context == null) {
                throw new IllegalArgumentException("No context supplied.");
            } else if (detector == null) {
                throw new IllegalArgumentException("No detector supplied.");
            } else {
                this.dSu = detector;
                this.dSa.mContext = context;
            }
        }

        public a P(float f) {
            if (f <= 0.0f) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Invalid fps: ");
                stringBuilder.append(f);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            this.dSa.dSm = f;
            return this;
        }

        public a kv(String str) {
            this.dSa.dSp = str;
            return this;
        }

        public a kw(String str) {
            this.dSa.dSq = str;
            return this;
        }

        public a aG(int i, int i2) {
            if (i <= 0 || i > 1000000 || i2 <= 0 || i2 > 1000000) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Invalid preview size: ");
                stringBuilder.append(i);
                stringBuilder.append("x");
                stringBuilder.append(i2);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            this.dSa.dSn = i;
            this.dSa.dSo = i2;
            return this;
        }

        public a hC(int i) {
            if (i == 0 || i == 1) {
                this.dSa.dSj = i;
                return this;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid camera: ");
            stringBuilder.append(i);
            throw new IllegalArgumentException(stringBuilder.toString());
        }

        public a aOe() {
            a aVar = this.dSa;
            a aVar2 = this.dSa;
            aVar2.getClass();
            aVar.dSs = new c(this.dSu);
            return this.dSa;
        }
    }

    /* compiled from: CameraSource */
    private class b implements PreviewCallback {
        private b() {
        }

        public void onPreviewFrame(byte[] bArr, Camera camera) {
            a.this.dSs.a(bArr, camera);
        }
    }

    /* compiled from: CameraSource */
    private class c implements Runnable {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private Detector<?> dSu;
        private long dSw = SystemClock.elapsedRealtime();
        private long dSx;
        private int dSy = 0;
        private ByteBuffer dSz;
        private boolean mActive = true;
        private final Object mLock = new Object();

        static {
            Class cls = a.class;
        }

        c(Detector<?> detector) {
            this.dSu = detector;
        }

        @SuppressLint({"Assert"})
        void release() {
            this.dSu.release();
            this.dSu = null;
        }

        void setActive(boolean z) {
            synchronized (this.mLock) {
                this.mActive = z;
                this.mLock.notifyAll();
            }
        }

        void a(byte[] bArr, Camera camera) {
            synchronized (this.mLock) {
                if (this.dSz != null) {
                    camera.addCallbackBuffer(this.dSz.array());
                    this.dSz = null;
                }
                if (a.this.dSt.containsKey(bArr)) {
                    this.dSx = SystemClock.elapsedRealtime() - this.dSw;
                    this.dSy++;
                    this.dSz = (ByteBuffer) a.this.dSt.get(bArr);
                    this.mLock.notifyAll();
                    return;
                }
                i.d("OpenCameraSource", "Skipping frame.  Could not find ByteBuffer associated with the image data from the camera.");
            }
        }

        /* JADX WARNING: Missing block: B:22:?, code:
            r6.dSu.receiveFrame(r1);
     */
        /* JADX WARNING: Missing block: B:25:0x0077, code:
            r0 = move-exception;
     */
        /* JADX WARNING: Missing block: B:27:?, code:
            com.iqoption.core.i.e("OpenCameraSource", "Exception thrown from receiver.", r0);
     */
        /* JADX WARNING: Missing block: B:28:0x0080, code:
            com.iqoption.withdrawal.crypto.barcode.camera.a.a(r6.dSv).addCallbackBuffer(r2.array());
     */
        public void run() {
            /*
            r6 = this;
        L_0x0000:
            r0 = r6.mLock;
            monitor-enter(r0);
        L_0x0003:
            r1 = r6.mActive;	 Catch:{ all -> 0x008e }
            if (r1 == 0) goto L_0x001b;
        L_0x0007:
            r1 = r6.dSz;	 Catch:{ all -> 0x008e }
            if (r1 != 0) goto L_0x001b;
        L_0x000b:
            r1 = r6.mLock;	 Catch:{ InterruptedException -> 0x0011 }
            r1.wait();	 Catch:{ InterruptedException -> 0x0011 }
            goto L_0x0003;
        L_0x0011:
            r1 = move-exception;
            r2 = "OpenCameraSource";
            r3 = "Frame processing loop terminated.";
            com.iqoption.core.i.d(r2, r3, r1);	 Catch:{ all -> 0x008e }
            monitor-exit(r0);	 Catch:{ all -> 0x008e }
            return;
        L_0x001b:
            r1 = r6.mActive;	 Catch:{ all -> 0x008e }
            if (r1 != 0) goto L_0x0021;
        L_0x001f:
            monitor-exit(r0);	 Catch:{ all -> 0x008e }
            return;
        L_0x0021:
            r1 = new com.google.android.gms.vision.Frame$Builder;	 Catch:{ all -> 0x008e }
            r1.<init>();	 Catch:{ all -> 0x008e }
            r2 = r6.dSz;	 Catch:{ all -> 0x008e }
            r3 = com.iqoption.withdrawal.crypto.barcode.camera.a.this;	 Catch:{ all -> 0x008e }
            r3 = r3.dSl;	 Catch:{ all -> 0x008e }
            r3 = r3.getWidth();	 Catch:{ all -> 0x008e }
            r4 = com.iqoption.withdrawal.crypto.barcode.camera.a.this;	 Catch:{ all -> 0x008e }
            r4 = r4.dSl;	 Catch:{ all -> 0x008e }
            r4 = r4.getHeight();	 Catch:{ all -> 0x008e }
            r5 = 17;
            r1 = r1.setImageData(r2, r3, r4, r5);	 Catch:{ all -> 0x008e }
            r2 = r6.dSy;	 Catch:{ all -> 0x008e }
            r1 = r1.setId(r2);	 Catch:{ all -> 0x008e }
            r2 = r6.dSx;	 Catch:{ all -> 0x008e }
            r1 = r1.setTimestampMillis(r2);	 Catch:{ all -> 0x008e }
            r2 = com.iqoption.withdrawal.crypto.barcode.camera.a.this;	 Catch:{ all -> 0x008e }
            r2 = r2.dSk;	 Catch:{ all -> 0x008e }
            r1 = r1.setRotation(r2);	 Catch:{ all -> 0x008e }
            r1 = r1.build();	 Catch:{ all -> 0x008e }
            r2 = r6.dSz;	 Catch:{ all -> 0x008e }
            r3 = 0;
            r6.dSz = r3;	 Catch:{ all -> 0x008e }
            monitor-exit(r0);	 Catch:{ all -> 0x008e }
            r0 = r6.dSu;	 Catch:{ Throwable -> 0x0077 }
            r0.receiveFrame(r1);	 Catch:{ Throwable -> 0x0077 }
        L_0x0067:
            r0 = com.iqoption.withdrawal.crypto.barcode.camera.a.this;
            r0 = r0.dSi;
            r1 = r2.array();
            r0.addCallbackBuffer(r1);
            goto L_0x0000;
        L_0x0075:
            r0 = move-exception;
            goto L_0x0080;
        L_0x0077:
            r0 = move-exception;
            r1 = "OpenCameraSource";
            r3 = "Exception thrown from receiver.";
            com.iqoption.core.i.e(r1, r3, r0);	 Catch:{ all -> 0x0075 }
            goto L_0x0067;
        L_0x0080:
            r1 = com.iqoption.withdrawal.crypto.barcode.camera.a.this;
            r1 = r1.dSi;
            r2 = r2.array();
            r1.addCallbackBuffer(r2);
            throw r0;
        L_0x008e:
            r1 = move-exception;
            monitor-exit(r0);	 Catch:{ all -> 0x008e }
            throw r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iqoption.withdrawal.crypto.barcode.camera.a.c.run():void");
        }
    }

    /* compiled from: CameraSource */
    private static class d {
        private Size dSA;
        private Size dSB;

        public d(Camera.Size size, Camera.Size size2) {
            this.dSA = new Size(size.width, size.height);
            if (size2 != null) {
                this.dSB = new Size(size2.width, size2.height);
            }
        }

        public Size aOf() {
            return this.dSA;
        }

        public Size aOg() {
            return this.dSB;
        }
    }

    public void release() {
        synchronized (this.dSh) {
            stop();
            this.dSs.release();
        }
    }

    @RequiresPermission("android.permission.CAMERA")
    public a a(SurfaceHolder surfaceHolder) {
        synchronized (this.dSh) {
            if (this.dSi != null) {
                return this;
            }
            this.dSi = aOd();
            this.dSi.setPreviewDisplay(surfaceHolder);
            this.dSi.startPreview();
            this.dSr = new Thread(this.dSs);
            this.dSs.setActive(true);
            this.dSr.start();
            return this;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0026 A:{Catch:{ InterruptedException -> 0x0014 }} */
    public void stop() {
        /*
        r6 = this;
        r0 = r6.dSh;
        monitor-enter(r0);
        r1 = r6.dSs;	 Catch:{ all -> 0x0062 }
        r2 = 0;
        r1.setActive(r2);	 Catch:{ all -> 0x0062 }
        r1 = r6.dSr;	 Catch:{ all -> 0x0062 }
        r2 = 0;
        if (r1 == 0) goto L_0x001d;
    L_0x000e:
        r1 = r6.dSr;	 Catch:{ InterruptedException -> 0x0014 }
        r1.join();	 Catch:{ InterruptedException -> 0x0014 }
        goto L_0x001b;
    L_0x0014:
        r1 = "OpenCameraSource";
        r3 = "Frame processing thread interrupted on release.";
        com.iqoption.core.i.d(r1, r3);	 Catch:{ all -> 0x0062 }
    L_0x001b:
        r6.dSr = r2;	 Catch:{ all -> 0x0062 }
    L_0x001d:
        r1 = r6.dSt;	 Catch:{ all -> 0x0062 }
        r1.clear();	 Catch:{ all -> 0x0062 }
        r1 = r6.dSi;	 Catch:{ all -> 0x0062 }
        if (r1 == 0) goto L_0x0060;
    L_0x0026:
        r1 = r6.dSi;	 Catch:{ all -> 0x0062 }
        r1.stopPreview();	 Catch:{ all -> 0x0062 }
        r1 = r6.dSi;	 Catch:{ all -> 0x0062 }
        r1.setPreviewCallbackWithBuffer(r2);	 Catch:{ all -> 0x0062 }
        r1 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Exception -> 0x0042 }
        r3 = 11;
        if (r1 < r3) goto L_0x003c;
    L_0x0036:
        r1 = r6.dSi;	 Catch:{ Exception -> 0x0042 }
        r1.setPreviewTexture(r2);	 Catch:{ Exception -> 0x0042 }
        goto L_0x0059;
    L_0x003c:
        r1 = r6.dSi;	 Catch:{ Exception -> 0x0042 }
        r1.setPreviewDisplay(r2);	 Catch:{ Exception -> 0x0042 }
        goto L_0x0059;
    L_0x0042:
        r1 = move-exception;
        r3 = "OpenCameraSource";
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0062 }
        r4.<init>();	 Catch:{ all -> 0x0062 }
        r5 = "Failed to clear camera preview: ";
        r4.append(r5);	 Catch:{ all -> 0x0062 }
        r4.append(r1);	 Catch:{ all -> 0x0062 }
        r1 = r4.toString();	 Catch:{ all -> 0x0062 }
        com.iqoption.core.i.e(r3, r1);	 Catch:{ all -> 0x0062 }
    L_0x0059:
        r1 = r6.dSi;	 Catch:{ all -> 0x0062 }
        r1.release();	 Catch:{ all -> 0x0062 }
        r6.dSi = r2;	 Catch:{ all -> 0x0062 }
    L_0x0060:
        monitor-exit(r0);	 Catch:{ all -> 0x0062 }
        return;
    L_0x0062:
        r1 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0062 }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.withdrawal.crypto.barcode.camera.a.stop():void");
    }

    public Size getPreviewSize() {
        return this.dSl;
    }

    public int getCameraFacing() {
        return this.dSj;
    }

    private a() {
        this.dSh = new Object();
        this.dSj = 0;
        this.dSm = 30.0f;
        this.dSn = 1024;
        this.dSo = 768;
        this.dSp = null;
        this.dSq = null;
        this.dSt = new HashMap();
    }

    @SuppressLint({"InlinedApi"})
    private Camera aOd() {
        int hB = hB(this.dSj);
        if (hB == -1) {
            throw new RuntimeException("Could not find requested camera.");
        }
        Camera open = Camera.open(hB);
        d a = a(open, this.dSn, this.dSo);
        if (a == null) {
            throw new RuntimeException("Could not find suitable preview size.");
        }
        Size aOg = a.aOg();
        this.dSl = a.aOf();
        int[] a2 = a(open, this.dSm);
        if (a2 == null) {
            throw new RuntimeException("Could not find suitable preview frames per second range.");
        }
        StringBuilder stringBuilder;
        Parameters parameters = open.getParameters();
        if (aOg != null) {
            parameters.setPictureSize(aOg.getWidth(), aOg.getHeight());
        }
        parameters.setPreviewSize(this.dSl.getWidth(), this.dSl.getHeight());
        parameters.setPreviewFpsRange(a2[0], a2[1]);
        parameters.setPreviewFormat(17);
        a(open, parameters, hB);
        if (this.dSp != null) {
            if (parameters.getSupportedFocusModes().contains(this.dSp)) {
                parameters.setFocusMode(this.dSp);
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Camera focus mode: ");
                stringBuilder.append(this.dSp);
                stringBuilder.append(" is not supported on this device.");
                i.i("OpenCameraSource", stringBuilder.toString());
            }
        }
        this.dSp = parameters.getFocusMode();
        if (!(this.dSq == null || parameters.getSupportedFlashModes() == null)) {
            if (parameters.getSupportedFlashModes().contains(this.dSq)) {
                parameters.setFlashMode(this.dSq);
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Camera flash mode: ");
                stringBuilder.append(this.dSq);
                stringBuilder.append(" is not supported on this device.");
                i.i("OpenCameraSource", stringBuilder.toString());
            }
        }
        this.dSq = parameters.getFlashMode();
        open.setParameters(parameters);
        open.setPreviewCallbackWithBuffer(new b());
        open.addCallbackBuffer(a(this.dSl));
        open.addCallbackBuffer(a(this.dSl));
        open.addCallbackBuffer(a(this.dSl));
        open.addCallbackBuffer(a(this.dSl));
        return open;
    }

    private static int hB(int i) {
        CameraInfo cameraInfo = new CameraInfo();
        for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
            Camera.getCameraInfo(i2, cameraInfo);
            if (cameraInfo.facing == i) {
                return i2;
            }
        }
        return -1;
    }

    private static d a(Camera camera, int i, int i2) {
        d dVar = null;
        int i3 = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        for (d dVar2 : a(camera)) {
            Size aOf = dVar2.aOf();
            int abs = Math.abs(aOf.getWidth() - i) + Math.abs(aOf.getHeight() - i2);
            if (abs < i3) {
                dVar = dVar2;
                i3 = abs;
            }
        }
        return dVar;
    }

    private static List<d> a(Camera camera) {
        Parameters parameters = camera.getParameters();
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        List<Camera.Size> supportedPictureSizes = parameters.getSupportedPictureSizes();
        List<d> arrayList = new ArrayList();
        for (Camera.Size size : supportedPreviewSizes) {
            float f = ((float) size.width) / ((float) size.height);
            for (Camera.Size size2 : supportedPictureSizes) {
                if (Math.abs(f - (((float) size2.width) / ((float) size2.height))) < 0.01f) {
                    arrayList.add(new d(size, size2));
                    break;
                }
            }
        }
        if (arrayList.size() == 0) {
            i.w("OpenCameraSource", "No preview sizes have a corresponding same-aspect-ratio picture size");
            for (Camera.Size dVar : supportedPreviewSizes) {
                arrayList.add(new d(dVar, null));
            }
        }
        return arrayList;
    }

    private int[] a(Camera camera, float f) {
        int i = (int) (f * 1000.0f);
        int[] iArr = null;
        int i2 = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        for (int[] iArr2 : camera.getParameters().getSupportedPreviewFpsRange()) {
            int abs = Math.abs(i - iArr2[0]) + Math.abs(i - iArr2[1]);
            if (abs < i2) {
                iArr = iArr2;
                i2 = abs;
            }
        }
        return iArr;
    }

    private void a(Camera camera, Parameters parameters, int i) {
        int rotation = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getRotation();
        int i2 = 0;
        switch (rotation) {
            case 0:
                break;
            case 1:
                i2 = 90;
                break;
            case 2:
                i2 = 180;
                break;
            case 3:
                i2 = 270;
                break;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Bad rotation value: ");
                stringBuilder.append(rotation);
                i.e("OpenCameraSource", stringBuilder.toString());
                break;
        }
        CameraInfo cameraInfo = new CameraInfo();
        Camera.getCameraInfo(i, cameraInfo);
        if (cameraInfo.facing == 1) {
            i = (cameraInfo.orientation + i2) % 360;
            rotation = (360 - i) % 360;
        } else {
            i = ((cameraInfo.orientation - i2) + 360) % 360;
            rotation = i;
        }
        this.dSk = i / 90;
        camera.setDisplayOrientation(rotation);
        parameters.setRotation(i);
    }

    private byte[] a(Size size) {
        Object obj = new byte[(((int) Math.ceil(((double) ((long) ((size.getHeight() * size.getWidth()) * ImageFormat.getBitsPerPixel(17)))) / 8.0d)) + 1)];
        ByteBuffer wrap = ByteBuffer.wrap(obj);
        if (wrap.hasArray() && wrap.array() == obj) {
            this.dSt.put(obj, wrap);
            return obj;
        }
        throw new IllegalStateException("Failed to create valid buffer for camera source.");
    }
}
