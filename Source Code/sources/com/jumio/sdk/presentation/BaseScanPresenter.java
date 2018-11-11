package com.jumio.sdk.presentation;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.OrientationEventListener;
import android.view.TextureView;
import android.view.ViewGroup;
import com.jumio.commons.camera.ICameraCallback;
import com.jumio.commons.camera.JumioCameraManager;
import com.jumio.commons.camera.PreviewProperties;
import com.jumio.commons.enums.ScreenAngle;
import com.jumio.commons.utils.DeviceRotationManager;
import com.jumio.core.data.document.DocumentScanMode;
import com.jumio.core.data.document.ScanSide;
import com.jumio.core.exceptions.MissingPluginException;
import com.jumio.core.mvp.model.InvokeOnUiThread;
import com.jumio.core.mvp.model.SubscriberWithUpdate;
import com.jumio.core.mvp.presenter.Presenter;
import com.jumio.core.overlay.Overlay;
import com.jumio.core.plugins.Plugin;
import com.jumio.core.plugins.PluginRegistry;
import com.jumio.core.plugins.PluginRegistry.PluginMode;
import com.jumio.gui.DrawView.DrawViewInterface;
import com.jumio.persistence.DataAccess;
import com.jumio.sdk.extraction.ExtractionClient;
import com.jumio.sdk.models.BaseScanPartModel;
import com.jumio.sdk.view.interactors.BaseScanView;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class BaseScanPresenter<Interactor extends BaseScanView, Update, Result> extends Presenter<Interactor> implements ICameraCallback, SubscriberWithUpdate<Update, Result>, DrawViewInterface {
    private static final String TAG = "BaseScanPresenter";
    protected static final int WEBP_QUALITY = 75;
    protected JumioCameraManager cameraManager;
    protected ExtractionClient mExtractionClient;
    protected OrientationHandler mOrientationListener;
    @Nullable
    protected Overlay mOverlay;
    protected PreviewProperties mPreviewProperties;
    protected Plugin plugin;
    protected int viewHeight;
    protected int viewWidth;

    public static class BaseScanControl {
        public static int flashOnStartupEnabled = id.getAndIncrement();
        public static int hasFlash = id.getAndIncrement();
        public static int hasMultipleCameras = id.getAndIncrement();
        protected static AtomicInteger id = new AtomicInteger(0);
        public static int isCameraFrontfacing = id.getAndIncrement();
        public static int isFlashOn = id.getAndIncrement();
        public static int startCameraFrontfacing = id.getAndIncrement();
        public static int startExtraction = id.getAndIncrement();
        public static int stopExtraction = id.getAndIncrement();
        public static int toggleCamera = id.getAndIncrement();
        public static int toggleFlash = id.getAndIncrement();
    }

    protected class OrientationHandler extends OrientationEventListener {
        public OrientationHandler(Context context) {
            super(context);
        }

        public OrientationHandler(Context context, int i) {
            super(context, i);
        }

        public void onOrientationChanged(int i) {
            if (i != -1 && BaseScanPresenter.this.getView() != null) {
                DeviceRotationManager rotationManager = ((BaseScanView) BaseScanPresenter.this.getView()).getRotationManager();
                if (rotationManager != null) {
                    ScreenAngle angle = rotationManager.getAngle();
                    rotationManager.setAngleFromScreen();
                    ScreenAngle angle2 = rotationManager.getAngle();
                    if (!angle2.equals(angle)) {
                        BaseScanPresenter.this.onScreenAngleChanged(angle2);
                    }
                    if (BaseScanPresenter.this.cameraManager != null && BaseScanPresenter.this.cameraManager.isPreviewRunning() && ((angle == ScreenAngle.LANDSCAPE && angle2 == ScreenAngle.INVERTED_LANDSCAPE) || ((angle == ScreenAngle.INVERTED_LANDSCAPE && angle2 == ScreenAngle.LANDSCAPE) || ((rotationManager.isTablet() && angle == ScreenAngle.PORTRAIT && angle2 == ScreenAngle.INVERTED_PORTRAIT) || (rotationManager.isTablet() && angle == ScreenAngle.INVERTED_PORTRAIT && angle2 == ScreenAngle.PORTRAIT))))) {
                        BaseScanPresenter.this.cameraManager.onSurfaceTextureSizeChanged(((BaseScanView) BaseScanPresenter.this.getView()).getTextureView().getSurfaceTexture(), ((BaseScanView) BaseScanPresenter.this.getView()).getTextureView().getWidth(), ((BaseScanView) BaseScanPresenter.this.getView()).getTextureView().getHeight());
                    }
                }
            }
        }
    }

    protected abstract boolean canSwitchCamera();

    protected abstract boolean enableFlashOnStart();

    protected abstract BaseScanPartModel getScanPartModel();

    protected abstract PluginMode getScanPluginMode();

    public void onManualRefocus(int i, int i2) {
    }

    protected void onScreenAngleChanged(ScreenAngle screenAngle) {
    }

    protected abstract boolean startCameraFrontfacing();

    public void onCameraAvailable(boolean z) {
        if (b()) {
            ((BaseScanView) getView()).resetCameraControls(this.cameraManager.isFrontFacing(), this.cameraManager.isFlashOn());
        }
    }

    public void onPreviewAvailable(PreviewProperties previewProperties) {
        if (getView() != null) {
            this.mPreviewProperties = previewProperties;
            DataAccess.update(((BaseScanView) getView()).getContext(), PreviewProperties.class, this.mPreviewProperties);
            ((BaseScanView) getView()).getRotationManager().setAngleFromScreen();
            if (this.mOverlay != null) {
                ((BaseScanView) getView()).invalidateDrawView(true);
            }
            this.mExtractionClient.cancel();
            this.mExtractionClient.setPreviewProperties(previewProperties);
            this.mExtractionClient.setExtractionArea(getExtractionArea());
            this.mExtractionClient.setFlags(((BaseScanView) getView()).getRotationManager().isScreenPortrait(), ((BaseScanView) getView()).getRotationManager().isTablet(), ((BaseScanView) getView()).getRotationManager().isInverted());
            this.mExtractionClient.reinit();
            ((BaseScanView) getView()).updateCameraControls(canSwitchCamera(), this.cameraManager.isFlashSupported());
        }
    }

    public void onStopPreview() {
        this.mPreviewProperties = null;
        DataAccess.delete(((BaseScanView) getView()).getContext(), PreviewProperties.class);
    }

    public void onPreviewFrame(byte[] bArr) {
        if (!(this.cameraManager.isFocusing() || this.mExtractionClient == null)) {
            this.mExtractionClient.process(bArr);
        }
        this.cameraManager.addCallbackBuffer();
    }

    protected void onCreate() {
        TextureView textureView = ((BaseScanView) getView()).getTextureView();
        if (getScanPartModel() != null) {
            DocumentScanMode scanMode = getScanPartModel().getScanMode();
            this.plugin = PluginRegistry.getPlugin(getScanPluginMode());
            if (this.plugin == null) {
                onError(new MissingPluginException(scanMode));
                return;
            }
            if (this.mOverlay == null) {
                this.mOverlay = this.plugin.getOverlay(((BaseScanView) getView()).getContext(), null);
            }
            this.mExtractionClient = this.plugin.getExtractionClient(((BaseScanView) getView()).getContext());
            if (scanMode == DocumentScanMode.NFC) {
                if (this.cameraManager != null) {
                    this.cameraManager.stopPreview(true);
                }
                textureView.setVisibility(4);
            } else {
                textureView.setVisibility(0);
                if (this.cameraManager == null) {
                    this.cameraManager = JumioCameraManager.create(textureView, this, ((BaseScanView) getView()).getRotationManager(), startCameraFrontfacing(), enableFlashOnStart());
                    this.cameraManager.setRequestedSize(this.mExtractionClient.getPrefferedPreviewSize());
                } else {
                    this.cameraManager.reinitCamera();
                }
            }
            this.mOrientationListener = new OrientationHandler(((BaseScanView) getView()).getContext(), 1);
            this.mOrientationListener.enable();
            this.mExtractionClient.subscribe(this);
            this.mExtractionClient.configure(getScanPartModel());
        }
    }

    protected void onStart() {
        if (this.cameraManager != null) {
            this.cameraManager.startPreview();
        }
    }

    protected void onStop() {
        if (this.cameraManager != null) {
            this.cameraManager.stopPreview(true);
        }
    }

    protected void onDestroy() {
        if (this.mExtractionClient != null) {
            this.mExtractionClient.unsubscribe(this);
            this.mExtractionClient.destroy();
        }
        if (this.mOrientationListener != null) {
            this.mOrientationListener.disable();
            this.mOrientationListener = null;
        }
        if (this.cameraManager != null) {
            this.cameraManager.stopPreview(false);
            this.cameraManager.destroy();
        }
    }

    @InvokeOnUiThread
    public void onError(Throwable th) {
        if (b()) {
            if (this.mExtractionClient != null) {
                this.mExtractionClient.cancel();
            }
            ((BaseScanView) getView()).onError(th);
        }
    }

    public void draw(Canvas canvas) {
        if (this.mOverlay != null) {
            this.mOverlay.doDraw(canvas);
        }
    }

    public void addChildren(@NonNull ViewGroup viewGroup) {
        if (this.mOverlay != null) {
            this.mOverlay.addViews(viewGroup);
        }
    }

    public Rect getOverlayBounds() {
        return this.mOverlay != null ? this.mOverlay.getOverlayBounds() : null;
    }

    public Rect getExtractionArea() {
        if (this.mPreviewProperties == null || this.mPreviewProperties.surface == null) {
            return new Rect(0, 0, this.viewWidth, this.viewHeight);
        }
        return new Rect(0, 0, this.mPreviewProperties.surface.width, this.mPreviewProperties.surface.height);
    }

    public void measure(int i, int i2) {
        this.viewWidth = i;
        this.viewHeight = i2;
        if (this.mOverlay != null && getView() != null) {
            this.mOverlay.calculate(getScanPartModel().getScanMode(), getScanPartModel().getFormat(), getExtractionArea());
            Overlay overlay = this.mOverlay;
            ScanSide sideToScan = getScanPartModel().getSideToScan();
            boolean z = false;
            boolean z2 = this.cameraManager != null && this.cameraManager.isFrontFacing();
            if (((BaseScanView) getView()).getRotationManager().isScreenPortrait() || ((BaseScanView) getView()).getRotationManager().isTablet()) {
                z = true;
            }
            overlay.prepareDraw(sideToScan, z2, z);
        }
    }

    public boolean control(int i) {
        if (i == BaseScanControl.toggleCamera && this.cameraManager != null) {
            this.cameraManager.changeCamera();
            return true;
        } else if (i == BaseScanControl.toggleFlash && this.cameraManager != null) {
            this.cameraManager.toggleFlash();
            return true;
        } else if (i == BaseScanControl.hasMultipleCameras && this.cameraManager != null) {
            return canSwitchCamera();
        } else {
            if (i == BaseScanControl.hasFlash && this.cameraManager != null) {
                return this.cameraManager.isFlashSupported();
            }
            if (i == BaseScanControl.isCameraFrontfacing && this.cameraManager != null) {
                return this.cameraManager.isFrontFacing();
            }
            if (i == BaseScanControl.isFlashOn && this.cameraManager != null) {
                return this.cameraManager.isFlashOn();
            }
            if (i == BaseScanControl.flashOnStartupEnabled) {
                return enableFlashOnStart();
            }
            if (i == BaseScanControl.startCameraFrontfacing) {
                return startCameraFrontfacing();
            }
            if (i == BaseScanControl.startExtraction) {
                this.mExtractionClient.setDataExtractionActive(true);
                return true;
            } else if (i != BaseScanControl.stopExtraction) {
                return false;
            } else {
                this.mExtractionClient.setDataExtractionActive(false);
                return true;
            }
        }
    }
}
