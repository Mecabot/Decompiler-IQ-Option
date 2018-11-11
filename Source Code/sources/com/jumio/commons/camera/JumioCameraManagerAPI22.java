package com.jumio.commons.camera;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession.CaptureCallback;
import android.hardware.camera2.CameraCaptureSession.StateCallback;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureRequest.Builder;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.ImageReader;
import android.media.ImageReader.OnImageAvailableListener;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Size;
import android.view.TextureView;
import com.jumio.commons.log.Log;
import com.jumio.commons.utils.DeviceRotationManager;
import java.util.Arrays;
import java.util.Vector;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

@TargetApi(22)
public class JumioCameraManagerAPI22 extends JumioCameraManager implements OnImageAvailableListener {
    private static final String[] BLACKLIST = new String[]{"hammerhead", "Nexus 5", "angler", "Nexus 6P"};
    private Handler backgroundHandler;
    private HandlerThread backgroundThread;
    private CameraCaptureSession cameraCaptureSession;
    private CameraCharacteristics cameraCharacteristics;
    private CameraDevice cameraDevice;
    private String cameraId;
    private Semaphore cameraOpenCloseLock = new Semaphore(1);
    private final CaptureSessionCaptureCallback captureSessionCaptureCallback = new CaptureSessionCaptureCallback();
    private final CaptureSessionStateCallback captureSessionStateCallback = new CaptureSessionStateCallback();
    private Vector<Integer> focusModes;
    private ImageHandler imageHandler = null;
    private ImageReader imageReader;
    private int orientation;
    private Builder previewRequestBuilder;

    private class CaptureSessionCaptureCallback extends CaptureCallback {
        private CaptureSessionCaptureCallback() {
        }

        public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
            if (JumioCameraManagerAPI22.this.manualFocusEnabled && JumioCameraManagerAPI22.this.focusing) {
                Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
                if (num == null) {
                    return;
                }
                if (num.intValue() == 4 || num.intValue() == 5) {
                    JumioCameraManagerAPI22.this.previewRequestBuilder.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(2));
                    try {
                        JumioCameraManagerAPI22.this.setRepeatingRequest();
                    } catch (Throwable e) {
                        Log.printStackTrace(e);
                    }
                    JumioCameraManagerAPI22.this.previewRequestBuilder.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(0));
                    JumioCameraManagerAPI22.this.focusing = false;
                }
            }
        }
    }

    private class CaptureSessionStateCallback extends StateCallback {
        private CaptureSessionStateCallback() {
        }

        public void onConfigured(CameraCaptureSession cameraCaptureSession) {
            if (JumioCameraManagerAPI22.this.cameraDevice != null) {
                JumioCameraManagerAPI22.this.cameraCaptureSession = cameraCaptureSession;
                try {
                    if (JumioCameraManagerAPI22.this.focusModes.contains(Integer.valueOf(3))) {
                        JumioCameraManagerAPI22.this.previewRequestBuilder.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(3));
                        JumioCameraManagerAPI22.this.manualFocusEnabled = false;
                    } else if (JumioCameraManagerAPI22.this.focusModes.contains(Integer.valueOf(4))) {
                        JumioCameraManagerAPI22.this.previewRequestBuilder.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(4));
                        JumioCameraManagerAPI22.this.manualFocusEnabled = false;
                    } else if (JumioCameraManagerAPI22.this.focusModes.contains(Integer.valueOf(1))) {
                        JumioCameraManagerAPI22.this.previewRequestBuilder.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(1));
                        JumioCameraManagerAPI22.this.manualFocusEnabled = true;
                    } else if (JumioCameraManagerAPI22.this.focusModes.contains(Integer.valueOf(2))) {
                        JumioCameraManagerAPI22.this.previewRequestBuilder.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(2));
                        JumioCameraManagerAPI22.this.manualFocusEnabled = true;
                    } else if (JumioCameraManagerAPI22.this.focusModes.size() == 0) {
                        JumioCameraManagerAPI22.this.manualFocusEnabled = true;
                    }
                    JumioCameraManagerAPI22.this.previewRequestBuilder.set(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(1));
                    JumioCameraManagerAPI22.this.previewRequestBuilder.set(CaptureRequest.CONTROL_SCENE_MODE, Integer.valueOf(0));
                    JumioCameraManagerAPI22.this.previewRequestBuilder.set(CaptureRequest.CONTROL_AWB_MODE, Integer.valueOf(1));
                    JumioCameraManagerAPI22.this.previewRequestBuilder.set(CaptureRequest.CONTROL_MODE, Integer.valueOf(1));
                    JumioCameraManagerAPI22.this.setRepeatingRequest();
                } catch (Throwable e) {
                    Log.printStackTrace(e);
                }
            }
        }

        public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
            JumioCameraManagerAPI22.this.cameraCallback.onCameraError(null);
        }

        public void onClosed(CameraCaptureSession cameraCaptureSession) {
            JumioCameraManagerAPI22.this.cameraCaptureSession = null;
        }
    }

    private class DeviceStateCallback extends CameraDevice.StateCallback {
        private DeviceStateCallback() {
        }

        public void onOpened(CameraDevice cameraDevice) {
            JumioCameraManagerAPI22.this.cameraOpenCloseLock.release();
            JumioCameraManagerAPI22.this.cameraDevice = cameraDevice;
            JumioCameraManagerAPI22.this.createCameraPreviewSession();
            if (JumioCameraManagerAPI22.this.previewRequestBuilder != null) {
                if (JumioCameraManagerAPI22.this.isFlashSupported() && JumioCameraManagerAPI22.this.enableFlashOnStartUp) {
                    JumioCameraManagerAPI22.this.setFlash(true);
                }
                JumioCameraManagerAPI22.this.textureView.post(new Runnable() {
                    public void run() {
                        JumioCameraManagerAPI22.this.cameraCallback.onCameraAvailable(JumioCameraManagerAPI22.this.isFlashSupported());
                    }
                });
            }
        }

        public void onClosed(CameraDevice cameraDevice) {
            Log.d("onClosed");
            JumioCameraManagerAPI22.this.cameraOpenCloseLock.release();
            JumioCameraManagerAPI22.this.cameraDevice = null;
        }

        public void onDisconnected(CameraDevice cameraDevice) {
            Log.d("onDisconnect");
            JumioCameraManagerAPI22.this.cameraOpenCloseLock.release();
            try {
                cameraDevice.close();
            } catch (Exception unused) {
                JumioCameraManagerAPI22.this.cameraDevice = null;
            }
        }

        public void onError(CameraDevice cameraDevice, int i) {
            Log.d("onError");
            JumioCameraManagerAPI22.this.cameraOpenCloseLock.release();
            try {
                cameraDevice.close();
            } catch (Exception unused) {
                JumioCameraManagerAPI22.this.cameraDevice = null;
                JumioCameraManagerAPI22.this.cameraCallback.onCameraError(null);
            }
        }
    }

    private class ImageHandler implements Runnable {
        private ImageReader reader;

        public ImageHandler(ImageReader imageReader) {
            this.reader = imageReader;
        }

        /* JADX WARNING: Removed duplicated region for block: B:55:0x0105 A:{SYNTHETIC, Splitter: B:55:0x0105} */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x00ea A:{SYNTHETIC, Splitter: B:44:0x00ea} */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x00de A:{Splitter: B:1:0x0003, ExcHandler: all (r0_4 'th' java.lang.Throwable)} */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing block: B:33:0x00d2, code:
            r0 = move-exception;
     */
        /* JADX WARNING: Missing block: B:34:0x00d3, code:
            com.jumio.commons.log.Log.printStackTrace(r0);
     */
        /* JADX WARNING: Missing block: B:37:0x00de, code:
            r0 = move-exception;
     */
        /* JADX WARNING: Missing block: B:38:0x00df, code:
            r2 = r0;
            r3 = null;
     */
        /* JADX WARNING: Missing block: B:39:0x00e2, code:
            r0 = move-exception;
     */
        /* JADX WARNING: Missing block: B:40:0x00e3, code:
            r2 = r0;
            r3 = null;
     */
        /* JADX WARNING: Missing block: B:45:?, code:
            r3.close();
     */
        /* JADX WARNING: Missing block: B:46:0x00ee, code:
            r0 = move-exception;
     */
        /* JADX WARNING: Missing block: B:47:0x00ef, code:
            r2 = r0;
     */
        public void run() {
            /*
            r22 = this;
            r1 = r22;
            r2 = 0;
            r3 = r1.reader;	 Catch:{ Exception -> 0x00e2, all -> 0x00de }
            if (r3 != 0) goto L_0x0018;
        L_0x0007:
            r3 = "close Image";
            com.jumio.commons.log.Log.d(r3);	 Catch:{ Exception -> 0x000d }
            goto L_0x0012;
        L_0x000d:
            r0 = move-exception;
            r3 = r0;
            com.jumio.commons.log.Log.printStackTrace(r3);
        L_0x0012:
            r3 = com.jumio.commons.camera.JumioCameraManagerAPI22.this;
            r3.imageHandler = r2;
            return;
        L_0x0018:
            r3 = r1.reader;	 Catch:{ Exception -> 0x00cc, all -> 0x00de }
            r3 = r3.acquireLatestImage();	 Catch:{ Exception -> 0x00cc, all -> 0x00de }
            r4 = r3.getPlanes();	 Catch:{ Exception -> 0x00c9 }
            r5 = 0;
            r4 = r4[r5];	 Catch:{ Exception -> 0x00c9 }
            r4 = r4.getBuffer();	 Catch:{ Exception -> 0x00c9 }
            r6 = r3.getPlanes();	 Catch:{ Exception -> 0x00c9 }
            r7 = 1;
            r6 = r6[r7];	 Catch:{ Exception -> 0x00c9 }
            r6 = r6.getBuffer();	 Catch:{ Exception -> 0x00c9 }
            r8 = r3.getPlanes();	 Catch:{ Exception -> 0x00c9 }
            r9 = 2;
            r8 = r8[r9];	 Catch:{ Exception -> 0x00c9 }
            r8 = r8.getBuffer();	 Catch:{ Exception -> 0x00c9 }
            r10 = r3.getPlanes();	 Catch:{ Exception -> 0x00c9 }
            r10 = r10[r5];	 Catch:{ Exception -> 0x00c9 }
            r10 = r10.getRowStride();	 Catch:{ Exception -> 0x00c9 }
            r11 = r3.getPlanes();	 Catch:{ Exception -> 0x00c9 }
            r11 = r11[r7];	 Catch:{ Exception -> 0x00c9 }
            r11 = r11.getRowStride();	 Catch:{ Exception -> 0x00c9 }
            r12 = r3.getWidth();	 Catch:{ Exception -> 0x00c9 }
            r13 = r3.getHeight();	 Catch:{ Exception -> 0x00c9 }
            r14 = r3.getWidth();	 Catch:{ Exception -> 0x00c9 }
            r14 = r14 / r9;
            r15 = r3.getHeight();	 Catch:{ Exception -> 0x00c9 }
            r15 = r15 / r9;
            r16 = r12 * r13;
            r17 = r3.getPlanes();	 Catch:{ Exception -> 0x00c9 }
            r7 = r17[r7];	 Catch:{ Exception -> 0x00c9 }
            r7 = r7.getPixelStride();	 Catch:{ Exception -> 0x00c9 }
            r17 = r16 * 3;
            r9 = r17 / 2;
            r9 = new byte[r9];	 Catch:{ Exception -> 0x00c9 }
        L_0x0077:
            if (r5 >= r13) goto L_0x00b3;
        L_0x0079:
            r2 = r5 * r10;
            r4.position(r2);	 Catch:{ Exception -> 0x00c9 }
            r2 = r5 * r12;
            r4.get(r9, r2, r12);	 Catch:{ Exception -> 0x00c9 }
            if (r5 >= r15) goto L_0x00ab;
        L_0x0085:
            r17 = r5 * r11;
            r18 = r4;
            r4 = 0;
        L_0x008a:
            if (r4 >= r14) goto L_0x00ad;
        L_0x008c:
            r19 = r4 * 2;
            r20 = r16 + r2;
            r20 = r20 + r19;
            r19 = r4 * r7;
            r21 = r2;
            r2 = r17 + r19;
            r19 = r8.get(r2);	 Catch:{ Exception -> 0x00c9 }
            r9[r20] = r19;	 Catch:{ Exception -> 0x00c9 }
            r20 = r20 + 1;
            r2 = r6.get(r2);	 Catch:{ Exception -> 0x00c9 }
            r9[r20] = r2;	 Catch:{ Exception -> 0x00c9 }
            r4 = r4 + 1;
            r2 = r21;
            goto L_0x008a;
        L_0x00ab:
            r18 = r4;
        L_0x00ad:
            r5 = r5 + 1;
            r4 = r18;
            r2 = 0;
            goto L_0x0077;
        L_0x00b3:
            r2 = com.jumio.commons.camera.JumioCameraManagerAPI22.this;	 Catch:{ Exception -> 0x00c9 }
            r2 = r2.cameraCallback;	 Catch:{ Exception -> 0x00c9 }
            r2.onPreviewFrame(r9);	 Catch:{ Exception -> 0x00c9 }
            if (r3 == 0) goto L_0x00c3;
        L_0x00bc:
            r3.close();	 Catch:{ Exception -> 0x00c0 }
            goto L_0x00c3;
        L_0x00c0:
            r0 = move-exception;
            r2 = r0;
            goto L_0x00f7;
        L_0x00c3:
            r2 = "close Image";
            com.jumio.commons.log.Log.d(r2);	 Catch:{ Exception -> 0x00c0 }
            goto L_0x00fa;
        L_0x00c9:
            r0 = move-exception;
            r2 = r0;
            goto L_0x00e5;
        L_0x00cc:
            r2 = "close Image";
            com.jumio.commons.log.Log.d(r2);	 Catch:{ Exception -> 0x00d2 }
            goto L_0x00d7;
        L_0x00d2:
            r0 = move-exception;
            r2 = r0;
            com.jumio.commons.log.Log.printStackTrace(r2);
        L_0x00d7:
            r2 = com.jumio.commons.camera.JumioCameraManagerAPI22.this;
            r3 = 0;
            r2.imageHandler = r3;
            return;
        L_0x00de:
            r0 = move-exception;
            r2 = r0;
            r3 = 0;
            goto L_0x0103;
        L_0x00e2:
            r0 = move-exception;
            r2 = r0;
            r3 = 0;
        L_0x00e5:
            com.jumio.commons.log.Log.printStackTrace(r2);	 Catch:{ all -> 0x0101 }
            if (r3 == 0) goto L_0x00f1;
        L_0x00ea:
            r3.close();	 Catch:{ Exception -> 0x00ee }
            goto L_0x00f1;
        L_0x00ee:
            r0 = move-exception;
            r2 = r0;
            goto L_0x00f7;
        L_0x00f1:
            r2 = "close Image";
            com.jumio.commons.log.Log.d(r2);	 Catch:{ Exception -> 0x00ee }
            goto L_0x00fa;
        L_0x00f7:
            com.jumio.commons.log.Log.printStackTrace(r2);
        L_0x00fa:
            r2 = com.jumio.commons.camera.JumioCameraManagerAPI22.this;
            r3 = 0;
            r2.imageHandler = r3;
            return;
        L_0x0101:
            r0 = move-exception;
            r2 = r0;
        L_0x0103:
            if (r3 == 0) goto L_0x010c;
        L_0x0105:
            r3.close();	 Catch:{ Exception -> 0x0109 }
            goto L_0x010c;
        L_0x0109:
            r0 = move-exception;
            r3 = r0;
            goto L_0x0112;
        L_0x010c:
            r3 = "close Image";
            com.jumio.commons.log.Log.d(r3);	 Catch:{ Exception -> 0x0109 }
            goto L_0x0115;
        L_0x0112:
            com.jumio.commons.log.Log.printStackTrace(r3);
        L_0x0115:
            r3 = com.jumio.commons.camera.JumioCameraManagerAPI22.this;
            r4 = 0;
            r3.imageHandler = r4;
            throw r2;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jumio.commons.camera.JumioCameraManagerAPI22.ImageHandler.run():void");
        }
    }

    public void addCallbackBuffer() {
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    JumioCameraManagerAPI22(TextureView textureView, ICameraCallback iCameraCallback, DeviceRotationManager deviceRotationManager, boolean z, boolean z2) {
        super(textureView, iCameraCallback, deviceRotationManager, z, z2);
        startBackgroundThread();
    }

    public static boolean hasSupportedCamera(Context context) {
        boolean z = false;
        try {
            if (Arrays.asList(BLACKLIST).contains(Build.MODEL)) {
                return false;
            }
            CameraManager cameraManager = (CameraManager) context.getSystemService("camera");
            Size bestPreviewSize = getBestPreviewSize(((StreamConfigurationMap) cameraManager.getCameraCharacteristics(cameraManager.getCameraIdList()[0]).get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP)).getOutputSizes(SurfaceTexture.class));
            if (bestPreviewSize.width >= 1920 && bestPreviewSize.height >= 1080) {
                z = true;
            }
            return z;
        } catch (CameraAccessException unused) {
            return false;
        } catch (NullPointerException unused2) {
            return false;
        }
    }

    public static int getNumberOfCameras(Context context) {
        try {
            return ((CameraManager) context.getSystemService("camera")).getCameraIdList().length;
        } catch (CameraAccessException e) {
            Log.d(e.getMessage());
            return 0;
        }
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        openCamera(i, i2, this.rotationManager.isPortrait(), this.rotationManager.getDisplayRotation());
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        configureTransform(i, i2, this.rotationManager.isPortrait(), this.rotationManager.getDisplayRotation());
    }

    public boolean isFlashSupported() {
        return this.cameraCharacteristics != null ? ((Boolean) this.cameraCharacteristics.get(CameraCharacteristics.FLASH_INFO_AVAILABLE)).booleanValue() : false;
    }

    public int getOrientation() {
        return this.orientation;
    }

    public boolean hasMultipleCameras() {
        return getNumberOfCameras(this.textureView.getContext()) > 1;
    }

    public void setCameraFacing(boolean z) {
        this.cameraId = null;
        CameraManager cameraManager = (CameraManager) this.textureView.getContext().getSystemService("camera");
        int i = 0;
        while (i < cameraManager.getCameraIdList().length) {
            try {
                CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(cameraManager.getCameraIdList()[i]);
                this.frontFacing = ((Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING)).intValue() == 0;
                if (z && this.frontFacing) {
                    this.cameraId = cameraManager.getCameraIdList()[i];
                    return;
                } else if (z || ((Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING)).intValue() != 1) {
                    i++;
                } else {
                    this.cameraId = cameraManager.getCameraIdList()[i];
                    return;
                }
            } catch (Throwable e) {
                this.cameraId = null;
                Log.printStackTrace(e);
                return;
            }
        }
    }

    public void requestFocus(int i, int i2) {
        try {
            Rect rect = (Rect) this.cameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
            RectF rectF = new RectF(0.0f, 0.0f, (float) this.previewSize.width, (float) this.previewSize.height);
            Matrix matrix = new Matrix();
            matrix.setRectToRect(rectF, new RectF(rect), ScaleToFit.CENTER);
            matrix.postRotate((float) this.previewProperties.orientation, (float) rect.centerX(), (float) rect.centerY());
            RectF rectF2 = new RectF();
            Rect rect2 = new Rect();
            matrix.mapRect(rectF2, CameraUtils.surfaceToPreview(this.previewProperties, new Rect(i - 50, i2 - 50, i + 50, i2 + 50)));
            rectF2.roundOut(rect2);
            boolean z = true;
            if (this.manualFocusEnabled) {
                if (!this.focusing) {
                    this.focusing = true;
                    this.previewRequestBuilder.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(1));
                } else {
                    return;
                }
            }
            if (this.cameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF) == null || ((Integer) this.cameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF)).intValue() <= 0) {
                z = false;
            } else {
                this.previewRequestBuilder.set(CaptureRequest.CONTROL_AF_REGIONS, new MeteringRectangle[]{new MeteringRectangle(rect2, 1000)});
            }
            if (z) {
                setRepeatingRequest();
            }
        } catch (Throwable e) {
            Log.printStackTrace(e);
        }
    }

    public void setFlash(boolean z) {
        if (this.previewRequestBuilder != null && isFlashSupported()) {
            this.flashOn = z;
            this.previewRequestBuilder.set(CaptureRequest.FLASH_MODE, Integer.valueOf(z ? 2 : 0));
            try {
                setRepeatingRequest();
            } catch (Throwable e) {
                Log.printStackTrace(e);
            }
        }
    }

    public void startPreview() {
        if (this.cameraCaptureSession != null) {
            this.pausePreview = false;
            try {
                setRepeatingRequest();
            } catch (Throwable e) {
                Log.printStackTrace(e);
                reinitCamera();
            }
        }
    }

    public void reinitCamera() {
        openCamera(this.textureView.getWidth(), this.textureView.getHeight(), this.rotationManager.isPortrait(), this.rotationManager.getDisplayRotation());
    }

    public void stopPreview(boolean z) {
        Log.d("stopPreview");
        if (this.cameraCaptureSession != null) {
            try {
                this.pausePreview = z;
                this.cameraCaptureSession.stopRepeating();
                if (isFlashOn()) {
                    this.previewRequestBuilder.set(CaptureRequest.FLASH_MODE, Integer.valueOf(0));
                    this.cameraCaptureSession.capture(this.previewRequestBuilder.build(), this.captureSessionCaptureCallback, this.backgroundHandler);
                }
            } catch (Throwable e) {
                Log.printStackTrace(e);
            }
        }
    }

    public void destroy() {
        Log.d("destroy");
        closeCamera(true);
        stopBackgroundThread();
    }

    public void changeCamera() {
        int i = 0;
        closeCamera(false);
        CameraManager cameraManager = (CameraManager) this.textureView.getContext().getSystemService("camera");
        try {
            if (this.cameraId != null) {
                int indexOf = Arrays.asList(cameraManager.getCameraIdList()).indexOf(this.cameraId) + 1;
                if (indexOf != cameraManager.getCameraIdList().length) {
                    i = indexOf;
                }
            }
            this.cameraId = cameraManager.getCameraIdList()[i];
        } catch (Throwable e) {
            Log.printStackTrace(e);
        }
        reinitCamera();
    }

    public void onImageAvailable(ImageReader imageReader) {
        try {
            Log.d("onImageAvailable");
            if (!(imageReader == null || this.backgroundHandler == null || this.imageHandler != null || this.pausePreview)) {
                Log.d("onImageAvailable - post ImageHandler");
                this.imageHandler = new ImageHandler(imageReader);
                this.backgroundHandler.post(this.imageHandler);
            }
        } catch (Throwable e) {
            Log.printStackTrace(e);
        }
    }

    private static Size getBestPreviewSize(Size[] sizeArr) {
        Size size = sizeArr[sizeArr.length - 1];
        for (Size size2 : sizeArr) {
            if (size2.getWidth() >= size.getWidth() && size2.getHeight() >= size.getHeight()) {
                size = size2;
            }
        }
        return new Size(size.getWidth(), size.getHeight());
    }

    private Size getRequestedPreviewSize(Size[] sizeArr) {
        int i = 0;
        Size size = sizeArr[0];
        int length = sizeArr.length;
        while (i < length) {
            Size size2 = sizeArr[i];
            if ((size2.getWidth() >= this.requestedSize.width && size2.getHeight() >= this.requestedSize.height) || (size2.getWidth() >= size.getWidth() && size2.getHeight() >= size.getHeight())) {
                size = size2;
            }
            i++;
        }
        return new Size(size.getWidth(), size.getHeight());
    }

    private void setUpCameraOutputs() {
        CameraManager cameraManager = (CameraManager) this.textureView.getContext().getSystemService("camera");
        try {
            int i = 0;
            if (this.cameraId == null || Arrays.asList(cameraManager.getCameraIdList()).indexOf(this.cameraId) == -1) {
                this.cameraId = cameraManager.getCameraIdList()[0];
            }
            this.cameraCharacteristics = cameraManager.getCameraCharacteristics(this.cameraId);
            ((Integer) this.cameraCharacteristics.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL)).intValue();
            this.frontFacing = ((Integer) this.cameraCharacteristics.get(CameraCharacteristics.LENS_FACING)).intValue() == 0;
            this.orientation = ((Integer) this.cameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
            this.focusModes = new Vector();
            int[] iArr = (int[]) this.cameraCharacteristics.get(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES);
            int length = iArr.length;
            while (i < length) {
                this.focusModes.add(Integer.valueOf(iArr[i]));
                i++;
            }
            StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) this.cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
            if (this.requestedSize == null) {
                this.requestedSize = new Size(1920, 1080);
            }
            this.previewSize = getRequestedPreviewSize(streamConfigurationMap.getOutputSizes(SurfaceTexture.class));
            this.imageReader = ImageReader.newInstance(this.previewSize.width, this.previewSize.height, 35, 2);
            this.imageReader.setOnImageAvailableListener(this, this.backgroundHandler);
        } catch (Throwable e) {
            this.cameraId = null;
            Log.printStackTrace(e);
        } catch (NullPointerException unused) {
            this.cameraId = null;
        }
    }

    private void openCamera(int i, int i2, boolean z, int i3) {
        Throwable e;
        setUpCameraOutputs();
        configureTransform(i, i2, z, i3);
        CameraManager cameraManager = (CameraManager) this.textureView.getContext().getSystemService("camera");
        try {
            if (this.cameraOpenCloseLock.tryAcquire(2500, TimeUnit.MILLISECONDS)) {
                cameraManager.openCamera(this.cameraId, new DeviceStateCallback(), this.backgroundHandler);
                return;
            }
            throw new Exception("Time out waiting to lock camera opening.");
        } catch (Throwable e2) {
            Log.printStackTrace(e2);
        } catch (Exception e3) {
            e2 = e3;
            if (e2 instanceof InterruptedException) {
                e2 = new RuntimeException("Interrupted while trying to lock camera closing.", e2);
            }
            if (this.cameraCallback != null) {
                this.cameraCallback.onCameraError(e2);
            }
        }
    }

    private void closeCamera(boolean z) {
        Log.d("closeCamera");
        try {
            stopPreview(z);
            this.cameraOpenCloseLock.acquire();
            if (this.cameraCaptureSession != null) {
                Log.d("closeCamera - cameraCaptureSession");
                this.cameraCaptureSession.close();
            }
            if (this.cameraDevice != null) {
                Log.d("closeCamera - cameraDevice");
                this.cameraDevice.close();
            }
            if (this.imageReader != null) {
                Log.d("closeCamera - imageReader");
                this.imageReader.close();
                this.imageReader = null;
            }
        } catch (Exception e) {
            Throwable e2 = e;
            Log.d(" - exception:");
            Log.printStackTrace(e2);
            if (e2 instanceof InterruptedException) {
                e2 = new RuntimeException("Interrupted while trying to lock camera closing.", e2);
            }
            if (this.cameraCallback != null) {
                this.cameraCallback.onCameraError(e2);
            }
        }
    }

    private void startBackgroundThread() {
        if (this.backgroundThread == null) {
            Log.d("startBackgroundThread");
            this.backgroundThread = new HandlerThread("CameraBackground");
            this.backgroundThread.start();
            this.backgroundHandler = new Handler(this.backgroundThread.getLooper());
        }
    }

    private void stopBackgroundThread() {
        if (this.backgroundThread != null) {
            Log.d("stopBackgroundThread");
            try {
                Log.d("stopBackgroundThread - not null");
                this.backgroundThread.quitSafely();
                this.backgroundThread.join();
                this.backgroundThread = null;
                this.backgroundHandler = null;
            } catch (Throwable e) {
                Log.printStackTrace(e);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0076 A:{Splitter: B:11:0x0064, ExcHandler: android.hardware.camera2.CameraAccessException (r1_13 'e' java.lang.Throwable)} */
    /* JADX WARNING: Missing block: B:18:0x0076, code:
            r1 = move-exception;
     */
    /* JADX WARNING: Missing block: B:19:0x0077, code:
            r6.previewRequestBuilder = null;
            com.jumio.commons.log.Log.printStackTrace(r1);
            reinitCamera();
     */
    /* JADX WARNING: Missing block: B:20:?, code:
            return;
     */
    private void createCameraPreviewSession() {
        /*
        r6 = this;
        r0 = 0;
        r1 = r6.cameraOpenCloseLock;	 Catch:{ all -> 0x006a }
        r1.acquire();	 Catch:{ all -> 0x006a }
        r1 = r6.textureView;	 Catch:{ all -> 0x006a }
        r1 = r1.getSurfaceTexture();	 Catch:{ all -> 0x006a }
        if (r1 != 0) goto L_0x0016;
    L_0x000e:
        r1 = new java.lang.Exception;	 Catch:{ all -> 0x006a }
        r2 = "Texture is null";
        r1.<init>(r2);	 Catch:{ all -> 0x006a }
        throw r1;	 Catch:{ all -> 0x006a }
    L_0x0016:
        r2 = r6.previewSize;	 Catch:{ all -> 0x006a }
        r2 = r2.width;	 Catch:{ all -> 0x006a }
        r3 = r6.previewSize;	 Catch:{ all -> 0x006a }
        r3 = r3.height;	 Catch:{ all -> 0x006a }
        r1.setDefaultBufferSize(r2, r3);	 Catch:{ all -> 0x006a }
        r2 = new android.view.Surface;	 Catch:{ all -> 0x006a }
        r2.<init>(r1);	 Catch:{ all -> 0x006a }
        r1 = r6.cameraDevice;	 Catch:{ all -> 0x006a }
        if (r1 != 0) goto L_0x0032;
    L_0x002a:
        r1 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x006a }
        r2 = "Camera is null";
        r1.<init>(r2);	 Catch:{ all -> 0x006a }
        throw r1;	 Catch:{ all -> 0x006a }
    L_0x0032:
        r1 = r6.cameraDevice;	 Catch:{ all -> 0x006a }
        r3 = 1;
        r1 = r1.createCaptureRequest(r3);	 Catch:{ all -> 0x006a }
        r6.previewRequestBuilder = r1;	 Catch:{ all -> 0x006a }
        r1 = r6.previewRequestBuilder;	 Catch:{ all -> 0x006a }
        r1.addTarget(r2);	 Catch:{ all -> 0x006a }
        r1 = r6.previewRequestBuilder;	 Catch:{ all -> 0x006a }
        r4 = r6.imageReader;	 Catch:{ all -> 0x006a }
        r4 = r4.getSurface();	 Catch:{ all -> 0x006a }
        r1.addTarget(r4);	 Catch:{ all -> 0x006a }
        r1 = r6.cameraDevice;	 Catch:{ all -> 0x006a }
        r4 = 2;
        r4 = new android.view.Surface[r4];	 Catch:{ all -> 0x006a }
        r5 = 0;
        r4[r5] = r2;	 Catch:{ all -> 0x006a }
        r2 = r6.imageReader;	 Catch:{ all -> 0x006a }
        r2 = r2.getSurface();	 Catch:{ all -> 0x006a }
        r4[r3] = r2;	 Catch:{ all -> 0x006a }
        r2 = java.util.Arrays.asList(r4);	 Catch:{ all -> 0x006a }
        r3 = r6.captureSessionStateCallback;	 Catch:{ all -> 0x006a }
        r1.createCaptureSession(r2, r3, r0);	 Catch:{ all -> 0x006a }
        r1 = r6.cameraOpenCloseLock;	 Catch:{ CameraAccessException -> 0x0076, CameraAccessException -> 0x0076, Exception -> 0x0071 }
        r1.release();	 Catch:{ CameraAccessException -> 0x0076, CameraAccessException -> 0x0076, Exception -> 0x0071 }
        goto L_0x007f;
    L_0x006a:
        r1 = move-exception;
        r2 = r6.cameraOpenCloseLock;	 Catch:{ CameraAccessException -> 0x0076, CameraAccessException -> 0x0076, Exception -> 0x0071 }
        r2.release();	 Catch:{ CameraAccessException -> 0x0076, CameraAccessException -> 0x0076, Exception -> 0x0071 }
        throw r1;	 Catch:{ CameraAccessException -> 0x0076, CameraAccessException -> 0x0076, Exception -> 0x0071 }
    L_0x0071:
        r0 = move-exception;
        com.jumio.commons.log.Log.printStackTrace(r0);
        goto L_0x007f;
    L_0x0076:
        r1 = move-exception;
        r6.previewRequestBuilder = r0;
        com.jumio.commons.log.Log.printStackTrace(r1);
        r6.reinitCamera();
    L_0x007f:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.commons.camera.JumioCameraManagerAPI22.createCameraPreviewSession():void");
    }

    private void setRepeatingRequest() {
        if (this.cameraCaptureSession != null && !this.pausePreview) {
            Log.d("setRepeatingRequest");
            this.cameraCaptureSession.setRepeatingRequest(this.previewRequestBuilder.build(), this.captureSessionCaptureCallback, this.backgroundHandler);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x012b  */
    private void configureTransform(int r11, int r12, boolean r13, int r14) {
        /*
        r10 = this;
        r0 = r10.textureView;
        if (r0 == 0) goto L_0x017e;
    L_0x0004:
        r0 = r10.previewSize;
        if (r0 != 0) goto L_0x000a;
    L_0x0008:
        goto L_0x017e;
    L_0x000a:
        r0 = new com.jumio.commons.camera.PreviewProperties;
        r0.<init>();
        r10.previewProperties = r0;
        r0 = new android.graphics.Matrix;
        r0.<init>();
        r1 = new android.graphics.RectF;
        r2 = (float) r11;
        r3 = (float) r12;
        r4 = 0;
        r1.<init>(r4, r4, r2, r3);
        r5 = r1.centerX();
        r6 = r1.centerY();
        r7 = new android.graphics.RectF;
        r8 = r10.previewSize;
        r8 = r8.height;
        r8 = (float) r8;
        r9 = r10.previewSize;
        r9 = r9.width;
        r9 = (float) r9;
        r7.<init>(r4, r4, r8, r9);
        r4 = r7.centerX();
        r4 = r5 - r4;
        r8 = r7.centerY();
        r8 = r6 - r8;
        r7.offset(r4, r8);
        r4 = android.graphics.Matrix.ScaleToFit.FILL;
        r0.setRectToRect(r1, r7, r4);
        r1 = 1;
        r4 = 90;
        if (r1 == r14) goto L_0x0071;
    L_0x004e:
        r1 = 3;
        if (r1 != r14) goto L_0x0052;
    L_0x0051:
        goto L_0x0071;
    L_0x0052:
        r1 = r10.previewSize;
        r1 = r1.width;
        r1 = (float) r1;
        r1 = r3 / r1;
        r7 = r10.previewSize;
        r7 = r7.height;
        r7 = (float) r7;
        r7 = r2 / r7;
        r1 = java.lang.Math.max(r1, r7);
        r0.postScale(r1, r1, r5, r6);
        r1 = 2;
        if (r1 != r14) goto L_0x008e;
    L_0x006a:
        r1 = r14 * 90;
        r1 = (float) r1;
        r0.postRotate(r1, r5, r6);
        goto L_0x008e;
    L_0x0071:
        r1 = r10.previewSize;
        r1 = r1.height;
        r1 = (float) r1;
        r1 = r3 / r1;
        r7 = r10.previewSize;
        r7 = r7.width;
        r7 = (float) r7;
        r7 = r2 / r7;
        r1 = java.lang.Math.max(r1, r7);
        r0.postScale(r1, r1, r5, r6);
        r1 = r14 + -2;
        r1 = r1 * 90;
        r1 = (float) r1;
        r0.postRotate(r1, r5, r6);
    L_0x008e:
        r1 = r10.textureView;
        r1.setTransform(r0);
        if (r11 <= r12) goto L_0x0098;
    L_0x0095:
        r0 = r2 / r3;
        goto L_0x009a;
    L_0x0098:
        r0 = r3 / r2;
    L_0x009a:
        r1 = r10.previewSize;
        r5 = 0;
        if (r1 == 0) goto L_0x013d;
    L_0x009f:
        r1 = r10.previewSize;
        r1 = r1.width;
        r1 = (float) r1;
        r6 = r10.previewSize;
        r6 = r6.height;
        r6 = (float) r6;
        r1 = r1 / r6;
        if (r13 == 0) goto L_0x00e5;
    L_0x00ac:
        r6 = r10.previewProperties;
        r7 = new com.jumio.commons.camera.Size;
        r8 = r10.previewSize;
        r8 = r8.height;
        r9 = r10.previewSize;
        r9 = r9.width;
        r7.<init>(r8, r9);
        r6.preview = r7;
        r6 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1));
        if (r6 < 0) goto L_0x00d2;
    L_0x00c1:
        r0 = r10.previewSize;
        r0 = r0.width;
        r0 = (float) r0;
        r1 = r10.previewSize;
        r1 = r1.height;
        r1 = (float) r1;
        r0 = r0 / r1;
        r0 = r0 * r2;
        r0 = (int) r0;
    L_0x00cf:
        r1 = r0;
        r0 = r11;
        goto L_0x011d;
    L_0x00d2:
        r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1));
        if (r0 >= 0) goto L_0x011b;
    L_0x00d6:
        r0 = r10.previewSize;
        r0 = r0.width;
        r0 = (float) r0;
        r1 = r10.previewSize;
        r1 = r1.height;
        r1 = (float) r1;
        r0 = r0 / r1;
        r3 = r3 / r0;
        r0 = (int) r3;
    L_0x00e3:
        r1 = r12;
        goto L_0x011d;
    L_0x00e5:
        r6 = r10.previewProperties;
        r7 = new com.jumio.commons.camera.Size;
        r8 = r10.previewSize;
        r8 = r8.width;
        r9 = r10.previewSize;
        r9 = r9.height;
        r7.<init>(r8, r9);
        r6.preview = r7;
        r6 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1));
        if (r6 > 0) goto L_0x0108;
    L_0x00fa:
        r0 = r10.previewSize;
        r0 = r0.width;
        r0 = (float) r0;
        r1 = r10.previewSize;
        r1 = r1.height;
        r1 = (float) r1;
        r0 = r0 / r1;
        r2 = r2 / r0;
        r0 = (int) r2;
        goto L_0x00cf;
    L_0x0108:
        r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1));
        if (r0 <= 0) goto L_0x011b;
    L_0x010c:
        r0 = r10.previewSize;
        r0 = r0.width;
        r0 = (float) r0;
        r1 = r10.previewSize;
        r1 = r1.height;
        r1 = (float) r1;
        r0 = r0 / r1;
        r0 = r0 * r3;
        r0 = (int) r0;
        goto L_0x00e3;
    L_0x011b:
        r0 = 0;
        r1 = 0;
    L_0x011d:
        switch(r14) {
            case 0: goto L_0x0120;
            case 1: goto L_0x0125;
            case 2: goto L_0x0122;
            case 3: goto L_0x0127;
            default: goto L_0x0120;
        };
    L_0x0120:
        r4 = 0;
        goto L_0x0127;
    L_0x0122:
        r4 = 180; // 0xb4 float:2.52E-43 double:8.9E-322;
        goto L_0x0127;
    L_0x0125:
        r4 = 270; // 0x10e float:3.78E-43 double:1.334E-321;
    L_0x0127:
        r14 = r10.frontFacing;
        if (r14 == 0) goto L_0x012d;
    L_0x012b:
        r4 = r4 + 180;
    L_0x012d:
        r14 = r10.previewProperties;
        r2 = r10.orientation;
        r4 = r4 + r2;
        r4 = r4 % 360;
        r14.orientation = r4;
        r14 = r10.previewProperties;
        r2 = r10.orientation;
        r14.sensorRotation = r2;
        goto L_0x013f;
    L_0x013d:
        r0 = 0;
        r1 = 0;
    L_0x013f:
        r14 = r10.previewProperties;
        r2 = new com.jumio.commons.camera.Size;
        r2.<init>(r0, r1);
        r14.scaledPreview = r2;
        r14 = r10.previewProperties;
        r0 = new com.jumio.commons.camera.Size;
        r0.<init>(r11, r12);
        r14.surface = r0;
        r11 = r10.previewProperties;
        r12 = new com.jumio.commons.camera.Size;
        r14 = r10.previewSize;
        r14 = r14.width;
        r0 = r10.previewSize;
        r0 = r0.height;
        r12.<init>(r14, r0);
        r11.camera = r12;
        r11 = r10.previewProperties;
        r12 = r10.frontFacing;
        r11.frontFacing = r12;
        r11 = r10.previewProperties;
        r12 = 17;
        r11.previewFormat = r12;
        r11 = r10.previewProperties;
        r11.isPortrait = r13;
        r11 = r10.cameraCallback;
        if (r11 == 0) goto L_0x017d;
    L_0x0176:
        r11 = r10.cameraCallback;
        r12 = r10.previewProperties;
        r11.onPreviewAvailable(r12);
    L_0x017d:
        return;
    L_0x017e:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.commons.camera.JumioCameraManagerAPI22.configureTransform(int, int, boolean, int):void");
    }
}
