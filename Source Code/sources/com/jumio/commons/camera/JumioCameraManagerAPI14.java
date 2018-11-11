package com.jumio.commons.camera;

import android.graphics.ImageFormat;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.view.TextureView;
import com.jumio.commons.log.Log;
import com.jumio.commons.utils.DeviceRotationManager;
import java.util.ArrayList;
import java.util.List;

public class JumioCameraManagerAPI14 extends JumioCameraManager implements PreviewCallback {
    private static final int CAMERA_OPEN_TIMEOUT = 2000;
    private AutoFocusCallback autoFocusCallback = new AutoFocusCallback() {
        public void onAutoFocus(boolean z, Camera camera) {
            JumioCameraManagerAPI14.this.focusing = false;
        }
    };
    private byte[] callbackBuffer;
    private Camera camera;
    private final Object cameraAccessLock = new Object();
    private int cameraId;
    private int orientation;

    private class InitCameraRunnable implements Runnable {
        int displayRotation;
        int height;
        boolean isPortrait;
        SurfaceTexture surface;
        int width;

        public InitCameraRunnable(SurfaceTexture surfaceTexture, int i, int i2, boolean z, int i3) {
            this.surface = surfaceTexture;
            this.width = i;
            this.height = i2;
            this.isPortrait = z;
            this.displayRotation = i3;
        }

        public void run() {
            synchronized (JumioCameraManagerAPI14.this.cameraAccessLock) {
                JumioCameraManagerAPI14.this.initCamera();
                JumioCameraManagerAPI14.this.initPreview(this.surface, this.width, this.height, this.isPortrait, this.displayRotation);
                if (!JumioCameraManagerAPI14.this.pausePreview) {
                    JumioCameraManagerAPI14.this.startPreview();
                }
            }
        }
    }

    public class ReleaseCameraRunnable implements Runnable {
        public void run() {
            synchronized (JumioCameraManagerAPI14.this.cameraAccessLock) {
                if (JumioCameraManagerAPI14.this.camera != null) {
                    JumioCameraManagerAPI14.this.camera.release();
                    JumioCameraManagerAPI14.this.camera = null;
                }
                if (JumioCameraManagerAPI14.this.callbackBuffer != null) {
                    JumioCameraManagerAPI14.this.callbackBuffer = null;
                }
            }
        }
    }

    public class StopCameraPreviewRunnable implements Runnable {
        public void run() {
            JumioCameraManagerAPI14.this.setFlash(false);
            synchronized (JumioCameraManagerAPI14.this.cameraAccessLock) {
                if (JumioCameraManagerAPI14.this.inPreview && JumioCameraManagerAPI14.this.camera != null) {
                    JumioCameraManagerAPI14.this.camera.stopPreview();
                }
            }
            JumioCameraManagerAPI14.this.inPreview = false;
        }
    }

    public class SurfaceChangedRunnable implements Runnable {
        int displayRotation;
        int height;
        boolean isPortrait;
        SurfaceTexture surface;
        int width;

        public SurfaceChangedRunnable(SurfaceTexture surfaceTexture, int i, int i2, boolean z, int i3) {
            this.surface = surfaceTexture;
            this.width = i;
            this.height = i2;
            this.isPortrait = z;
            this.displayRotation = i3;
        }

        public void run() {
            synchronized (JumioCameraManagerAPI14.this.cameraAccessLock) {
                if (JumioCameraManagerAPI14.this.camera != null) {
                    if (JumioCameraManagerAPI14.this.cameraCallback != null) {
                        JumioCameraManagerAPI14.this.cameraCallback.onStopPreview();
                    }
                    JumioCameraManagerAPI14.this.camera.stopPreview();
                    JumioCameraManagerAPI14.this.initPreview(this.surface, this.width, this.height, this.isPortrait, this.displayRotation);
                    if (!JumioCameraManagerAPI14.this.pausePreview) {
                        JumioCameraManagerAPI14.this.startPreview();
                    }
                }
            }
        }
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public static int getNumberOfCameras() {
        return Camera.getNumberOfCameras();
    }

    public JumioCameraManagerAPI14(TextureView textureView, ICameraCallback iCameraCallback, DeviceRotationManager deviceRotationManager, boolean z, boolean z2) {
        super(textureView, iCameraCallback, deviceRotationManager, z, z2);
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.executorService.submit(new InitCameraRunnable(surfaceTexture, i, i2, this.rotationManager.isScreenPortrait(), this.rotationManager.getDisplayRotation()));
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        this.executorService.submit(new SurfaceChangedRunnable(surfaceTexture, i, i2, this.rotationManager.isScreenPortrait(), this.rotationManager.getDisplayRotation()));
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        stopPreview(this.pausePreview);
        destroy();
        return true;
    }

    public boolean isFlashSupported() {
        synchronized (this.cameraAccessLock) {
            if (this.camera != null) {
                try {
                    List supportedFlashModes = this.camera.getParameters().getSupportedFlashModes();
                    if (supportedFlashModes != null && (supportedFlashModes.contains("torch") || supportedFlashModes.contains("on"))) {
                        return true;
                    }
                } catch (Throwable e) {
                    Log.printStackTrace(e);
                }
            }
        }
        return false;
    }

    public int getOrientation() {
        return this.orientation;
    }

    public boolean hasMultipleCameras() {
        return Camera.getNumberOfCameras() > 1;
    }

    public void setCameraFacing(boolean z) {
        this.cameraId = 0;
        CameraInfo cameraInfo = new CameraInfo();
        int numberOfCameras = Camera.getNumberOfCameras();
        int i = 0;
        while (i < numberOfCameras) {
            Camera.getCameraInfo(i, cameraInfo);
            this.frontFacing = cameraInfo.facing == 1;
            if (z && cameraInfo.facing == 1) {
                this.cameraId = i;
                return;
            } else if (z || cameraInfo.facing != 0) {
                i++;
            } else {
                this.cameraId = i;
                return;
            }
        }
    }

    public void requestFocus(int i, int i2) {
        float width = (float) this.textureView.getWidth();
        int i3 = (int) (((((float) (i - 50)) / width) * 2000.0f) - 1000.0f);
        i = (int) (((((float) (i + 50)) / width) * 2000.0f) - 1000.0f);
        float height = (float) this.textureView.getHeight();
        int i4 = (int) (((((float) (i2 - 50)) / height) * 2000.0f) - 1000.0f);
        i2 = (int) (((((float) (i2 + 50)) / height) * 2000.0f) - 1000.0f);
        synchronized (this.cameraAccessLock) {
            if (this.manualFocusEnabled && !this.focusing && this.camera != null) {
                this.focusing = true;
                this.camera.autoFocus(this.autoFocusCallback);
            } else if (!(this.manualFocusEnabled || this.focusing || this.camera == null)) {
                Rect rect = new Rect(i3, i4, i, i2);
                List arrayList = new ArrayList();
                arrayList.add(new Area(rect, 1));
                try {
                    if (this.camera.getParameters().getMaxNumFocusAreas() > 0) {
                        this.camera.getParameters().setFocusAreas(arrayList);
                    }
                    if (this.camera.getParameters().getMaxNumMeteringAreas() > 0) {
                        this.camera.getParameters().setMeteringAreas(arrayList);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void setFlash(boolean z) {
        synchronized (this.cameraAccessLock) {
            if (this.camera != null && isFlashSupported()) {
                this.flashOn = z;
                Parameters parameters = this.camera.getParameters();
                List supportedFlashModes = parameters.getSupportedFlashModes();
                if (supportedFlashModes != null && supportedFlashModes.contains("torch")) {
                    parameters.setFlashMode(z ? "torch" : "off");
                } else if (supportedFlashModes != null && supportedFlashModes.contains("on")) {
                    parameters.setFlashMode(z ? "on" : "off");
                }
                this.camera.setParameters(parameters);
            }
        }
    }

    public void startPreview() {
        synchronized (this.cameraAccessLock) {
            if (this.camera != null) {
                try {
                    this.camera.startPreview();
                } catch (Throwable e) {
                    Log.printStackTrace(e);
                    reinitCamera();
                }
                if (this.callbackBuffer == null) {
                    this.callbackBuffer = new byte[(((this.previewSize.width * this.previewSize.height) * ImageFormat.getBitsPerPixel(17)) / 8)];
                }
                this.camera.addCallbackBuffer(this.callbackBuffer);
                this.camera.setPreviewCallbackWithBuffer(this);
                this.inPreview = true;
            }
            this.pausePreview = false;
        }
    }

    public void reinitCamera() {
        this.executorService.submit(new InitCameraRunnable(this.textureView.getSurfaceTexture(), this.textureView.getWidth(), this.textureView.getHeight(), this.rotationManager.isScreenPortrait(), this.rotationManager.getDisplayRotation()));
    }

    public void onPreviewFrame(byte[] bArr, Camera camera) {
        this.cameraCallback.onPreviewFrame(bArr);
    }

    public void addCallbackBuffer() {
        synchronized (this.cameraAccessLock) {
            if (!(this.camera == null || this.callbackBuffer == null)) {
                this.camera.addCallbackBuffer(this.callbackBuffer);
            }
        }
    }

    public void stopPreview(boolean z) {
        this.executorService.submit(new StopCameraPreviewRunnable());
        this.pausePreview = z;
    }

    public void destroy() {
        this.executorService.submit(new ReleaseCameraRunnable());
        cancelFlashHint();
    }

    public void changeCamera() {
        try {
            int numberOfCameras = Camera.getNumberOfCameras();
            if (numberOfCameras > 0) {
                this.cameraId++;
                if (this.cameraId >= numberOfCameras) {
                    this.cameraId = 0;
                }
                stopPreview(false);
                destroy();
                reinitCamera();
            }
        } catch (Exception unused) {
        }
    }

    private Camera getCameraWithId(int i) {
        int numberOfCameras = Camera.getNumberOfCameras();
        boolean z = false;
        if (numberOfCameras <= 0) {
            i = 0;
        }
        if (i >= numberOfCameras) {
            i = 0;
        }
        this.cameraId = i;
        CameraInfo cameraInfo = new CameraInfo();
        Camera.getCameraInfo(i, cameraInfo);
        if (cameraInfo.facing == 1) {
            z = true;
        }
        this.frontFacing = z;
        this.orientation = cameraInfo.orientation;
        long currentTimeMillis = System.currentTimeMillis();
        Camera camera = null;
        Throwable th = camera;
        while (camera == null && System.currentTimeMillis() - currentTimeMillis <= 2000) {
            try {
                camera = Camera.open(i);
            } catch (Throwable th2) {
                th = th2;
                camera = null;
            }
        }
        if (camera == null && th != null) {
            this.cameraCallback.onCameraError(th);
        }
        return camera;
    }

    private Size getBestPreviewSize(Parameters parameters) {
        Size size = (Size) parameters.getSupportedPreviewSizes().get(0);
        for (Size size2 : parameters.getSupportedPreviewSizes()) {
            if (size2.width >= size.width && size2.height >= size.height) {
                size = size2;
            }
        }
        return new Size(size.width, size.height);
    }

    private Size getRequestedPreviewSize(Parameters parameters) {
        Size size = (Size) parameters.getSupportedPreviewSizes().get(0);
        for (Size size2 : parameters.getSupportedPreviewSizes()) {
            if ((size2.width >= this.requestedSize.width && size2.height >= this.requestedSize.height) || (size2.width >= size.width && size2.height >= size.height)) {
                size = size2;
            }
        }
        return new Size(size.width, size.height);
    }

    private void initCamera() {
        synchronized (this.cameraAccessLock) {
            this.camera = getCameraWithId(this.cameraId);
        }
        final boolean isFlashSupported = isFlashSupported();
        if (isFlashSupported && this.enableFlashOnStartUp) {
            setFlash(true);
        }
        if (this.cameraCallback != null && this.camera != null) {
            this.textureView.post(new Runnable() {
                public void run() {
                    JumioCameraManagerAPI14.this.cameraCallback.onCameraAvailable(isFlashSupported);
                }
            });
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:63:0x015f  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x015c  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0159  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x016f  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0165  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x015f  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x015c  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0159  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0165  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x016f  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x015f  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x015c  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0159  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x016f  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0165  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x015f  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x015c  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0159  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0165  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x016f  */
    private void initPreview(android.graphics.SurfaceTexture r10, int r11, int r12, boolean r13, int r14) {
        /*
        r9 = this;
        r0 = r9.cameraAccessLock;
        monitor-enter(r0);
        r1 = r9.camera;	 Catch:{ all -> 0x01e8 }
        if (r1 != 0) goto L_0x0009;
    L_0x0007:
        monitor-exit(r0);	 Catch:{ all -> 0x01e8 }
        return;
    L_0x0009:
        r1 = r9.camera;	 Catch:{ Throwable -> 0x000f }
        r1.setPreviewTexture(r10);	 Catch:{ Throwable -> 0x000f }
        goto L_0x0017;
    L_0x000f:
        r10 = move-exception;
        r1 = "CameraManager";
        r2 = "Exception in setPreviewTexture()";
        com.jumio.commons.log.Log.e(r1, r2, r10);	 Catch:{ all -> 0x01e8 }
    L_0x0017:
        monitor-exit(r0);	 Catch:{ all -> 0x01e8 }
        r10 = r9.camera;
        r10 = r10.getParameters();
        r0 = FALLBACK_AUTO_FOCUS_LIST;
        r0 = java.util.Arrays.asList(r0);
        r1 = android.os.Build.MODEL;
        r0 = r0.contains(r1);
        r1 = r10.getSupportedFocusModes();
        r2 = 1;
        r3 = 0;
        if (r1 == 0) goto L_0x0075;
    L_0x0032:
        if (r0 != 0) goto L_0x0044;
    L_0x0034:
        r4 = "continuous-picture";
        r4 = r1.contains(r4);
        if (r4 == 0) goto L_0x0044;
    L_0x003c:
        r0 = "continuous-picture";
        r10.setFocusMode(r0);
        r9.manualFocusEnabled = r3;
        goto L_0x0075;
    L_0x0044:
        if (r0 != 0) goto L_0x0056;
    L_0x0046:
        r0 = "continuous-video";
        r0 = r1.contains(r0);
        if (r0 == 0) goto L_0x0056;
    L_0x004e:
        r0 = "continuous-video";
        r10.setFocusMode(r0);
        r9.manualFocusEnabled = r3;
        goto L_0x0075;
    L_0x0056:
        r0 = "auto";
        r0 = r1.contains(r0);
        if (r0 == 0) goto L_0x0066;
    L_0x005e:
        r0 = "auto";
        r10.setFocusMode(r0);
        r9.manualFocusEnabled = r2;
        goto L_0x0075;
    L_0x0066:
        r0 = "macro";
        r0 = r1.contains(r0);
        if (r0 == 0) goto L_0x0075;
    L_0x006e:
        r0 = "macro";
        r10.setFocusMode(r0);
        r9.manualFocusEnabled = r2;
    L_0x0075:
        r0 = r9.requestedSize;
        if (r0 != 0) goto L_0x007e;
    L_0x0079:
        r0 = r9.getBestPreviewSize(r10);
        goto L_0x0082;
    L_0x007e:
        r0 = r9.getRequestedPreviewSize(r10);
    L_0x0082:
        r9.previewSize = r0;
        r0 = new com.jumio.commons.camera.PreviewProperties;
        r0.<init>();
        r9.previewProperties = r0;
        if (r11 <= r12) goto L_0x0091;
    L_0x008d:
        r0 = (float) r11;
        r1 = (float) r12;
    L_0x008f:
        r0 = r0 / r1;
        goto L_0x0094;
    L_0x0091:
        r0 = (float) r12;
        r1 = (float) r11;
        goto L_0x008f;
    L_0x0094:
        r1 = "metering";
        r4 = "center";
        r10.set(r1, r4);	 Catch:{ Exception -> 0x009b }
    L_0x009b:
        r1 = r9.previewSize;
        r4 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        if (r1 == 0) goto L_0x018b;
    L_0x00a1:
        r1 = r9.previewSize;
        r1 = r1.width;
        r1 = (float) r1;
        r5 = r9.previewSize;
        r5 = r5.height;
        r5 = (float) r5;
        r1 = r1 / r5;
        if (r13 == 0) goto L_0x00fe;
    L_0x00ae:
        r5 = r9.previewSize;
        r5 = r5.width;
        r6 = r9.previewSize;
        r6 = r6.height;
        r10.setPreviewSize(r5, r6);
        r5 = r9.previewProperties;
        r6 = new com.jumio.commons.camera.Size;
        r7 = r9.previewSize;
        r7 = r7.height;
        r8 = r9.previewSize;
        r8 = r8.width;
        r6.<init>(r7, r8);
        r5.preview = r6;
        r5 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1));
        if (r5 < 0) goto L_0x00e4;
    L_0x00ce:
        r0 = r9.previewSize;
        r0 = r0.width;
        r0 = (float) r0;
        r1 = r9.previewSize;
        r1 = r1.height;
        r1 = (float) r1;
        r0 = r0 / r1;
        r1 = (float) r11;
        r0 = r0 * r1;
        r0 = (int) r0;
        r1 = (float) r0;
        r5 = (float) r12;
        r1 = r1 / r5;
    L_0x00e0:
        r5 = r1;
        r1 = r0;
        r0 = r11;
        goto L_0x014b;
    L_0x00e4:
        r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1));
        if (r0 >= 0) goto L_0x0147;
    L_0x00e8:
        r0 = (float) r12;
        r1 = r9.previewSize;
        r1 = r1.width;
        r1 = (float) r1;
        r5 = r9.previewSize;
        r5 = r5.height;
        r5 = (float) r5;
        r1 = r1 / r5;
        r0 = r0 / r1;
        r0 = (int) r0;
        r1 = (float) r0;
        r5 = (float) r11;
        r1 = r1 / r5;
    L_0x00f9:
        r4 = r1;
        r5 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r1 = r12;
        goto L_0x014b;
    L_0x00fe:
        r5 = r9.previewSize;
        r5 = r5.width;
        r6 = r9.previewSize;
        r6 = r6.height;
        r10.setPreviewSize(r5, r6);
        r5 = r9.previewProperties;
        r6 = new com.jumio.commons.camera.Size;
        r7 = r9.previewSize;
        r7 = r7.width;
        r8 = r9.previewSize;
        r8 = r8.height;
        r6.<init>(r7, r8);
        r5.preview = r6;
        r5 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1));
        if (r5 > 0) goto L_0x0130;
    L_0x011e:
        r0 = (float) r11;
        r1 = r9.previewSize;
        r1 = r1.width;
        r1 = (float) r1;
        r5 = r9.previewSize;
        r5 = r5.height;
        r5 = (float) r5;
        r1 = r1 / r5;
        r0 = r0 / r1;
        r0 = (int) r0;
        r1 = (float) r0;
        r5 = (float) r12;
        r1 = r1 / r5;
        goto L_0x00e0;
    L_0x0130:
        r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1));
        if (r0 <= 0) goto L_0x0147;
    L_0x0134:
        r0 = r9.previewSize;
        r0 = r0.width;
        r0 = (float) r0;
        r1 = r9.previewSize;
        r1 = r1.height;
        r1 = (float) r1;
        r0 = r0 / r1;
        r1 = (float) r12;
        r0 = r0 * r1;
        r0 = (int) r0;
        r1 = (float) r0;
        r5 = (float) r11;
        r1 = r1 / r5;
        goto L_0x00f9;
    L_0x0147:
        r0 = 0;
        r1 = 0;
        r5 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
    L_0x014b:
        r6 = new android.hardware.Camera$CameraInfo;
        r6.<init>();
        r7 = r9.cameraId;
        android.hardware.Camera.getCameraInfo(r7, r6);
        switch(r14) {
            case 0: goto L_0x0161;
            case 1: goto L_0x015f;
            case 2: goto L_0x015c;
            case 3: goto L_0x0159;
            default: goto L_0x0158;
        };
    L_0x0158:
        goto L_0x0161;
    L_0x0159:
        r3 = 270; // 0x10e float:3.78E-43 double:1.334E-321;
        goto L_0x0161;
    L_0x015c:
        r3 = 180; // 0xb4 float:2.52E-43 double:8.9E-322;
        goto L_0x0161;
    L_0x015f:
        r3 = 90;
    L_0x0161:
        r14 = r6.facing;
        if (r14 != r2) goto L_0x016f;
    L_0x0165:
        r14 = r6.orientation;
        r14 = r14 + r3;
        r14 = r14 % 360;
        r14 = 360 - r14;
        r14 = r14 % 360;
        goto L_0x0176;
    L_0x016f:
        r14 = r6.orientation;
        r14 = r14 - r3;
        r14 = r14 + 360;
        r14 = r14 % 360;
    L_0x0176:
        r2 = r9.camera;
        r2.setDisplayOrientation(r14);
        r2 = r9.camera;
        r2.setParameters(r10);
        r2 = r9.previewProperties;
        r2.orientation = r14;
        r14 = r9.previewProperties;
        r2 = r6.orientation;
        r14.sensorRotation = r2;
        goto L_0x018f;
    L_0x018b:
        r0 = 0;
        r1 = 0;
        r5 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
    L_0x018f:
        r14 = r9.previewProperties;
        r2 = new com.jumio.commons.camera.Size;
        r2.<init>(r0, r1);
        r14.scaledPreview = r2;
        r14 = r9.previewProperties;
        r0 = new com.jumio.commons.camera.Size;
        r0.<init>(r11, r12);
        r14.surface = r0;
        r14 = r9.previewProperties;
        r0 = new com.jumio.commons.camera.Size;
        r1 = r9.previewSize;
        r1 = r1.width;
        r2 = r9.previewSize;
        r2 = r2.height;
        r0.<init>(r1, r2);
        r14.camera = r0;
        r14 = r9.previewProperties;
        r0 = r9.frontFacing;
        r14.frontFacing = r0;
        r14 = r9.previewProperties;
        r10 = r10.getPreviewFormat();
        r14.previewFormat = r10;
        r10 = r9.previewProperties;
        r10.isPortrait = r13;
        r10 = r9.cameraCallback;
        if (r10 == 0) goto L_0x01cf;
    L_0x01c8:
        r10 = r9.cameraCallback;
        r13 = r9.previewProperties;
        r10.onPreviewAvailable(r13);
    L_0x01cf:
        r10 = new android.graphics.Matrix;
        r10.<init>();
        r11 = (float) r11;
        r13 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r11 = r11 / r13;
        r12 = (float) r12;
        r12 = r12 / r13;
        r10.setScale(r4, r5, r11, r12);
        r11 = r9.textureView;
        r12 = new com.jumio.commons.camera.JumioCameraManagerAPI14$2;
        r12.<init>(r10);
        r11.post(r12);
        return;
    L_0x01e8:
        r10 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x01e8 }
        throw r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.commons.camera.JumioCameraManagerAPI14.initPreview(android.graphics.SurfaceTexture, int, int, boolean, int):void");
    }
}
