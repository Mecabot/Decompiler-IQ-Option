package io.card.payment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.ImageFormat;
import android.graphics.Rect;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.WindowManager;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.List;

class CardScanner implements AutoFocusCallback, PreviewCallback, Callback {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "CardScanner";
    private static boolean ekc = false;
    private static boolean eks = false;
    final int dSH = 640;
    final int dSJ = 480;
    private Camera dSi;
    private int ejM = 1;
    private Bitmap ekb;
    protected WeakReference<CardIOActivity> ekd;
    private boolean eke = false;
    private boolean ekf;
    private int ekg = -1;
    private boolean ekh = true;
    private long eki;
    private long ekj;
    private long ekk;
    private byte[] ekl;
    protected boolean ekm = true;
    private boolean ekn;
    private int eko;
    private int ekp;
    private int ekq;
    private int ekr;

    private native void nCleanup();

    private native void nGetGuideFrame(int i, int i2, int i3, Rect rect);

    private native int nGetNumFramesScanned();

    private native void nResetAnalytics();

    private native void nScanFrame(byte[] bArr, int i, int i2, int i3, DetectionInfo detectionInfo, Bitmap bitmap, boolean z);

    private native void nSetup(boolean z, float f);

    private native void nSetup(boolean z, float f, int i);

    public static native boolean nUseNeon();

    public static native boolean nUseTegra();

    public static native boolean nUseX86();

    static {
        Log.i("card.io", "card.io 5.5.1 03/17/2017 14:23:12 -0400");
        StringBuilder stringBuilder;
        try {
            loadLibrary("cardioDecider");
            Log.d("card.io", "Loaded card.io decider library.");
            stringBuilder = new StringBuilder();
            stringBuilder.append("    nUseNeon(): ");
            stringBuilder.append(nUseNeon());
            Log.d("card.io", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append("    nUseTegra():");
            stringBuilder.append(nUseTegra());
            Log.d("card.io", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append("    nUseX86():  ");
            stringBuilder.append(nUseX86());
            Log.d("card.io", stringBuilder.toString());
            if (aTC()) {
                loadLibrary("opencv_core");
                Log.d("card.io", "Loaded opencv core library");
                loadLibrary("opencv_imgproc");
                Log.d("card.io", "Loaded opencv imgproc library");
            }
            if (nUseNeon()) {
                loadLibrary("cardioRecognizer");
                Log.i("card.io", "Loaded card.io NEON library");
            } else if (nUseX86()) {
                loadLibrary("cardioRecognizer");
                Log.i("card.io", "Loaded card.io x86 library");
            } else if (nUseTegra()) {
                loadLibrary("cardioRecognizer_tegra2");
                Log.i("card.io", "Loaded card.io Tegra2 library");
            } else {
                Log.w("card.io", "unsupported processor - card.io scanning requires ARMv7 or x86 architecture");
                ekc = true;
            }
        } catch (UnsatisfiedLinkError e) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to load native library: ");
            stringBuilder.append(e.getMessage());
            Log.e("card.io", stringBuilder.toString());
            ekc = true;
        }
    }

    private static void loadLibrary(String str) {
        try {
            System.loadLibrary(str);
        } catch (UnsatisfiedLinkError e) {
            String aTB = CardIONativeLibsConfig.aTB();
            if (aTB == null || aTB.length() == 0) {
                throw e;
            }
            StringBuilder stringBuilder;
            if (!File.separator.equals(Character.valueOf(aTB.charAt(aTB.length() - 1)))) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(aTB);
                stringBuilder.append(File.separator);
                aTB = stringBuilder.toString();
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(aTB);
            stringBuilder.append(Build.CPU_ABI);
            stringBuilder.append(File.separator);
            stringBuilder.append(System.mapLibraryName(str));
            String stringBuilder2 = stringBuilder.toString();
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("loadLibrary failed for library ");
            stringBuilder3.append(str);
            stringBuilder3.append(". Trying ");
            stringBuilder3.append(stringBuilder2);
            Log.d("card.io", stringBuilder3.toString());
            System.load(stringBuilder2);
        }
    }

    private static boolean aTC() {
        return nUseNeon() || nUseTegra() || nUseX86();
    }

    static boolean aTD() {
        return !ekc && aTC();
    }

    CardScanner(CardIOActivity cardIOActivity, int i) {
        boolean z = false;
        Intent intent = cardIOActivity.getIntent();
        if (intent != null) {
            this.eke = intent.getBooleanExtra(CardIOActivity.EXTRA_SUPPRESS_SCAN, false);
            if (intent.getBooleanExtra(CardIOActivity.EXTRA_REQUIRE_EXPIRY, false) && intent.getBooleanExtra(CardIOActivity.EXTRA_SCAN_EXPIRY, true)) {
                z = true;
            }
            this.ekf = z;
            this.ekg = intent.getIntExtra(CardIOActivity.EXTRA_UNBLUR_DIGITS, -1);
        }
        this.ekd = new WeakReference(cardIOActivity);
        this.ejM = i;
        nSetup(this.eke, 6.0f, this.ekg);
    }

    /* JADX WARNING: Missing block: B:4:0x000c, code:
            return android.hardware.Camera.open();
     */
    private android.hardware.Camera aS(int r8, int r9) {
        /*
        r7 = this;
        r0 = java.lang.System.currentTimeMillis();
        r2 = r7.ekm;
        if (r2 == 0) goto L_0x0036;
    L_0x0008:
        r2 = android.hardware.Camera.open();	 Catch:{ RuntimeException -> 0x0017, Exception -> 0x000d }
        return r2;
    L_0x000d:
        r9 = move-exception;
        r2 = "card.io";
        r3 = "Unexpected exception. Please report it as a GitHub issue";
        android.util.Log.e(r2, r3, r9);
        r9 = 0;
        goto L_0x002b;
    L_0x0017:
        r2 = "card.io";
        r3 = "Wasn't able to connect to camera service. Waiting and trying again...";
        android.util.Log.w(r2, r3);	 Catch:{ InterruptedException -> 0x0023 }
        r2 = (long) r8;	 Catch:{ InterruptedException -> 0x0023 }
        java.lang.Thread.sleep(r2);	 Catch:{ InterruptedException -> 0x0023 }
        goto L_0x002b;
    L_0x0023:
        r2 = move-exception;
        r3 = "card.io";
        r4 = "Interrupted while waiting for camera";
        android.util.Log.e(r3, r4, r2);
    L_0x002b:
        r2 = java.lang.System.currentTimeMillis();
        r4 = r2 - r0;
        r2 = (long) r9;
        r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1));
        if (r6 < 0) goto L_0x0008;
    L_0x0036:
        r8 = TAG;
        r9 = "camera connect timeout";
        android.util.Log.w(r8, r9);
        r8 = 0;
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.card.payment.CardScanner.aS(int, int):android.hardware.Camera");
    }

    void aTE() {
        this.ekh = true;
        this.ekj = 0;
        this.ekk = 0;
        this.eko = 0;
        this.ekp = 0;
        this.ekq = 0;
        this.ekr = 0;
        if (this.ekm && this.dSi == null) {
            this.dSi = aS(50, 5000);
            if (this.dSi == null) {
                Log.e("card.io", "prepare scanner couldn't connect to camera!");
                return;
            }
            b(this.dSi);
            Parameters parameters = this.dSi.getParameters();
            List<Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
            if (supportedPreviewSizes != null) {
                Size size = null;
                for (Size size2 : supportedPreviewSizes) {
                    if (size2.width == 640 && size2.height == 480) {
                        size = size2;
                        break;
                    }
                }
                if (size == null) {
                    Log.w("card.io", "Didn't find a supported 640x480 resolution, so forcing");
                    Size size3 = (Size) supportedPreviewSizes.get(0);
                    size3.width = 640;
                    size3.height = 480;
                }
            }
            parameters.setPreviewSize(640, 480);
            this.dSi.setParameters(parameters);
        } else if (!this.ekm) {
            Log.w(TAG, "useCamera is false!");
        } else if (this.dSi != null) {
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("we already have a camera instance: ");
            stringBuilder.append(this.dSi);
            Log.v(str, stringBuilder.toString());
        }
        if (this.ekb == null) {
            this.ekb = Bitmap.createBitmap(428, 270, Config.ARGB_8888);
        }
    }

    boolean b(SurfaceHolder surfaceHolder) {
        if (this.dSi == null) {
            aTE();
        }
        if (this.ekm && this.dSi == null) {
            Log.i(TAG, "null camera. failure");
            return false;
        }
        if (this.ekm && this.ekl == null) {
            this.ekl = new byte[(((ImageFormat.getBitsPerPixel(this.dSi.getParameters().getPreviewFormat()) / 8) * 307200) * 3)];
            this.dSi.addCallbackBuffer(this.ekl);
        }
        surfaceHolder.addCallback(this);
        surfaceHolder.setType(3);
        if (this.ekm) {
            this.dSi.setPreviewCallbackWithBuffer(this);
        }
        if (this.ekn) {
            c(surfaceHolder);
        }
        gl(false);
        this.eki = System.currentTimeMillis();
        nResetAnalytics();
        return true;
    }

    public void aTF() {
        gl(false);
        if (this.dSi != null) {
            try {
                this.dSi.stopPreview();
                this.dSi.setPreviewDisplay(null);
            } catch (Throwable e) {
                Log.w("card.io", "can't stop preview display", e);
            }
            this.dSi.setPreviewCallback(null);
            this.dSi.release();
            this.ekl = null;
            this.dSi = null;
        }
    }

    public void aTG() {
        if (this.dSi != null) {
            aTF();
        }
        nCleanup();
        this.ekl = null;
    }

    private boolean c(SurfaceHolder surfaceHolder) {
        this.ekh = true;
        if (this.ekm) {
            try {
                this.dSi.setPreviewDisplay(surfaceHolder);
                try {
                    this.dSi.startPreview();
                    this.dSi.autoFocus(this);
                } catch (Throwable e) {
                    Log.e("card.io", "startPreview failed on camera. Error: ", e);
                    return false;
                }
            } catch (Throwable e2) {
                Log.e("card.io", "can't set preview display", e2);
                return false;
            }
        }
        return true;
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (this.dSi == null && this.ekm) {
            Log.wtf("card.io", "CardScanner.surfaceCreated() - camera is null!");
            return;
        }
        this.ekn = true;
        c(surfaceHolder);
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        String str = TAG;
        String str2 = "Preview.surfaceChanged(holder?:%b, f:%d, w:%d, h:%d )";
        Object[] objArr = new Object[4];
        objArr[0] = Boolean.valueOf(surfaceHolder != null);
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = Integer.valueOf(i3);
        Log.d(str, String.format(str2, objArr));
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        if (this.dSi != null) {
            try {
                this.dSi.stopPreview();
            } catch (Throwable e) {
                Log.e("card.io", "error stopping camera", e);
            }
        }
        this.ekn = false;
    }

    public void onPreviewFrame(byte[] bArr, Camera camera) {
        if (bArr == null) {
            Log.w(TAG, "frame is null! skipping");
            return;
        }
        boolean z = true;
        if (eks) {
            Log.e(TAG, "processing in progress.... dropping frame");
            this.ekr++;
            if (camera != null) {
                camera.addCallbackBuffer(bArr);
            }
            return;
        }
        eks = true;
        if (this.ekh) {
            this.ekh = false;
            this.ejM = 1;
            ((CardIOActivity) this.ekd.get()).iM(1);
        }
        DetectionInfo detectionInfo = new DetectionInfo();
        nScanFrame(bArr, 640, 480, this.ejM, detectionInfo, this.ekb, this.ekf);
        if (detectionInfo.focusScore < 6.0f) {
            z = false;
        }
        if (!z) {
            gk(false);
        } else if (detectionInfo.aTN() || (this.eke && detectionInfo.aTM())) {
            ((CardIOActivity) this.ekd.get()).a(this.ekb, detectionInfo);
        }
        if (camera != null) {
            camera.addCallbackBuffer(bArr);
        }
        eks = false;
    }

    void onEdgeUpdate(DetectionInfo detectionInfo) {
        ((CardIOActivity) this.ekd.get()).onEdgeUpdate(detectionInfo);
    }

    Rect w(int i, int i2, int i3) {
        if (!aTD()) {
            return null;
        }
        Rect rect = new Rect();
        nGetGuideFrame(i, i2, i3, rect);
        return rect;
    }

    Rect aT(int i, int i2) {
        return w(this.ejM, i, i2);
    }

    void setDeviceOrientation(int i) {
        this.ejM = i;
    }

    public void onAutoFocus(boolean z, Camera camera) {
        this.ekk = System.currentTimeMillis();
    }

    boolean aTH() {
        return this.ekk < this.ekj;
    }

    void gk(boolean z) {
        if (this.ekm && !aTH()) {
            try {
                this.ekj = System.currentTimeMillis();
                this.dSi.autoFocus(this);
                if (z) {
                    this.eko++;
                } else {
                    this.ekp++;
                }
            } catch (RuntimeException e) {
                String str = TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("could not trigger auto focus: ");
                stringBuilder.append(e);
                Log.w(str, stringBuilder.toString());
            }
        }
    }

    public boolean isFlashOn() {
        if (this.ekm) {
            return this.dSi.getParameters().getFlashMode().equals("torch");
        }
        return false;
    }

    public boolean gl(boolean z) {
        if (this.dSi != null) {
            try {
                Parameters parameters = this.dSi.getParameters();
                parameters.setFlashMode(z ? "torch" : "off");
                this.dSi.setParameters(parameters);
                this.ekq++;
                return true;
            } catch (RuntimeException e) {
                String str = TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Could not set flash mode: ");
                stringBuilder.append(e);
                Log.w(str, stringBuilder.toString());
            }
        }
        return false;
    }

    private void b(Camera camera) {
        int aTI;
        if (VERSION.SDK_INT >= 21) {
            CameraInfo cameraInfo = new CameraInfo();
            Camera.getCameraInfo(0, cameraInfo);
            aTI = ((cameraInfo.orientation - aTI()) + 360) % 360;
        } else {
            aTI = 90;
        }
        camera.setDisplayOrientation(aTI);
    }

    int aTI() {
        int rotation = ((WindowManager) ((CardIOActivity) this.ekd.get()).getSystemService("window")).getDefaultDisplay().getRotation();
        if (rotation == 0) {
            return 0;
        }
        if (rotation == 1) {
            return 90;
        }
        if (rotation == 2) {
            return 180;
        }
        return rotation == 3 ? 270 : 0;
    }
}
