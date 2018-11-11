package com.jumio.commons.camera;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.jumio.commons.camera.ImageData.CameraPosition;
import com.jumio.commons.utils.DeviceRotationManager;
import com.jumio.commons.view.ViewFader;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class JumioCameraManager implements SurfaceTextureListener, OnClickListener, OnTouchListener {
    static final String[] FALLBACK_AUTO_FOCUS_LIST = new String[]{"GT-I9100", "SPH-D710", "SGH-T989", "SCH-I605", "SAMSUNG-SGH-I727", "GT-I9100G", "SAMSUNG-SGH-I777", "SPH-D710BST", "GT-I9100P", "GT-I9100T", "SGH-S959G", "SGH-T989D", "SGH-I727R", "GT-I9100M", "SPH-D710VMUB", "SAMSUNG-SGH-T989", "SGH-I757M", "SGH-I777", "GT-I9210", "GT-I9105P", "GT-I9105", "GT-I9105I", "GT-I9105G", "SAMSUNG-SGH-I717", "SGH-T879", "SGH-I717M", "SGH-I717R", "GT-N7000", "GT-N7005", "DROIDX"};
    protected static final String TAG = "CameraManager";
    ICameraCallback cameraCallback;
    boolean enableFlashOnStartUp = false;
    ExecutorService executorService;
    private final Object flashCheckLock = new Object();
    private CameraFlashThread flashCheckThread;
    boolean flashOn = false;
    boolean focusing = false;
    boolean frontFacing = false;
    boolean inPreview = false;
    boolean manualFocusEnabled = false;
    boolean pausePreview = false;
    PreviewProperties previewProperties;
    Size previewSize;
    Size requestedSize = null;
    protected DeviceRotationManager rotationManager;
    protected TextureView textureView;

    public abstract void addCallbackBuffer();

    public abstract void changeCamera();

    public abstract void destroy();

    public abstract boolean hasMultipleCameras();

    public abstract boolean isFlashSupported();

    public abstract void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2);

    public abstract boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture);

    public abstract void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2);

    public abstract void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture);

    public abstract void reinitCamera();

    public abstract void requestFocus(int i, int i2);

    public abstract void setCameraFacing(boolean z);

    public abstract void setFlash(boolean z);

    public abstract void startPreview();

    public abstract void stopPreview(boolean z);

    public static JumioCameraManager create(TextureView textureView, ICameraCallback iCameraCallback, DeviceRotationManager deviceRotationManager, boolean z, boolean z2) {
        return new JumioCameraManagerAPI14(textureView, iCameraCallback, deviceRotationManager, z, z2);
    }

    public static boolean hasFrontFacingCamera(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.camera.front");
    }

    public static int getNumberOfCameras(Context context) {
        return JumioCameraManagerAPI14.getNumberOfCameras();
    }

    JumioCameraManager(TextureView textureView, ICameraCallback iCameraCallback, DeviceRotationManager deviceRotationManager, boolean z, boolean z2) {
        this.textureView = textureView;
        this.textureView.setSurfaceTextureListener(this);
        this.textureView.setOpaque(false);
        this.textureView.setOnClickListener(this);
        this.textureView.setOnTouchListener(this);
        setCameraFacing(z);
        this.cameraCallback = iCameraCallback;
        this.rotationManager = deviceRotationManager;
        this.enableFlashOnStartUp = z2;
        this.executorService = Executors.newSingleThreadExecutor();
    }

    public boolean isFrontFacing() {
        return this.frontFacing;
    }

    public boolean isFlashOn() {
        return this.flashOn;
    }

    public boolean isFocusing() {
        return this.manualFocusEnabled && this.focusing;
    }

    public String getPreviewSize() {
        return String.format(Locale.GERMAN, "%dx%d", new Object[]{Integer.valueOf(this.previewSize.width), Integer.valueOf(this.previewSize.height)});
    }

    public void toggleFlash() {
        setFlash(this.flashOn ^ 1);
    }

    public boolean isPreviewRunning() {
        return this.pausePreview ^ 1;
    }

    public void requestFlashHint(boolean z) {
        synchronized (this.flashCheckLock) {
            if (this.flashCheckThread != null) {
                CameraFlashThread cameraFlashThread = this.flashCheckThread;
                z = z && !isFlashOn();
                cameraFlashThread.pulsate(z);
            }
        }
    }

    public void setFlashHint(ViewFader viewFader) {
        synchronized (this.flashCheckLock) {
            if (this.flashCheckThread == null) {
                this.flashCheckThread = new CameraFlashThread(viewFader);
                this.flashCheckThread.start();
            }
        }
    }

    public void cancelFlashHint() {
        synchronized (this.flashCheckLock) {
            if (this.flashCheckThread != null) {
                this.flashCheckThread.interrupt();
                this.flashCheckThread = null;
            }
        }
    }

    public void setRequestedSize(Size size) {
        this.requestedSize = size;
    }

    public void getImageData(ImageData imageData) {
        imageData.setCameraPosition(isFrontFacing() ? CameraPosition.FRONT : CameraPosition.BACK);
        imageData.setOrientationMode(this.rotationManager.getScreenOrientation());
        imageData.setImageSize(this.previewProperties.preview);
        imageData.setFlashMode(isFlashOn());
    }

    public void requestFocus() {
        requestFocus(this.textureView.getWidth() / 2, this.textureView.getHeight() / 2);
    }

    public void onClick(View view) {
        requestFocus();
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.pausePreview) {
            return false;
        }
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            requestFocus(x, y);
            if (this.cameraCallback != null) {
                this.cameraCallback.onManualRefocus(x, y);
            }
        }
        return false;
    }
}
