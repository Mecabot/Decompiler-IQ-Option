package com.jumio.dv.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Point;
import android.os.Handler;
import android.os.Looper;
import android.os.Vibrator;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.view.View.OnClickListener;
import com.jumio.commons.camera.CameraUtils;
import com.jumio.commons.camera.ImageData;
import com.jumio.commons.camera.PreviewProperties;
import com.jumio.commons.enums.ScreenAngle;
import com.jumio.commons.log.Log;
import com.jumio.commons.log.Log.LogLevel;
import com.jumio.core.data.document.DocumentScanMode;
import com.jumio.core.environment.Environment;
import com.jumio.core.mvp.model.StaticModel;
import com.jumio.core.plugins.PluginRegistry.PluginMode;
import com.jumio.dv.R;
import com.jumio.dv.models.DvScanPartModel;
import com.jumio.dv.models.DvSettingsModel;
import com.jumio.dv.view.interactors.DvScanView;
import com.jumio.dv.view.interactors.DvScanView.GuiState;
import com.jumio.dv.view.interactors.DvScanView.HelpViewStyle;
import com.jumio.persistence.DataAccess;
import com.jumio.sdk.exception.JumioException;
import com.jumio.sdk.extraction.ExtractionClient.ExtractionUpdate;
import com.jumio.sdk.extraction.ExtractionUpdateState;
import com.jumio.sdk.models.BaseScanPartModel;
import com.jumio.sdk.presentation.BaseScanPresenter;
import java.io.File;

/* compiled from: DvScanPresenter */
public class b extends BaseScanPresenter<DvScanView, ExtractionUpdate, StaticModel> {
    private DvScanPartModel a;
    private GuiState b = GuiState.SCAN;
    private Handler c = new Handler(Looper.getMainLooper());
    private DvSettingsModel d;

    /* compiled from: DvScanPresenter */
    public enum a {
        HELP,
        CONFIRMATION,
        BRANDING
    }

    /* compiled from: DvScanPresenter */
    private class b implements OnClickListener {
        private b() {
        }

        /* synthetic */ b(b bVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        public void onClick(View view) {
            if (b.this.mExtractionClient.takePictureManually()) {
                b.this.mExtractionClient.takePicture();
            }
        }
    }

    protected boolean enableFlashOnStart() {
        return false;
    }

    protected BaseScanPartModel getScanPartModel() {
        if (this.a == null) {
            this.a = (DvScanPartModel) DataAccess.load(((DvScanView) getView()).getContext(), DvScanPartModel.class);
            if (this.a == null) {
                this.a = new DvScanPartModel();
            }
        }
        return this.a;
    }

    protected PluginMode getScanPluginMode() {
        return PluginMode.MANUAL;
    }

    protected boolean startCameraFrontfacing() {
        return this.d.isCameraFrontfacing() || getScanPartModel().getScanMode() == DocumentScanMode.FACE;
    }

    protected boolean canSwitchCamera() {
        return (this.cameraManager == null || !this.cameraManager.hasMultipleCameras() || getScanPartModel().getScanMode() == DocumentScanMode.FACE) ? false : true;
    }

    public boolean control(int i) {
        return super.control(i);
    }

    public int a(HelpViewStyle helpViewStyle) {
        int i = 0;
        if (helpViewStyle == null) {
            return 0;
        }
        switch (helpViewStyle) {
            case MICRO:
                i = (int) ((DvScanView) getView()).getContext().getResources().getDimension(R.dimen.dv_helpview_small_landscape_height);
                break;
            case MINI:
                i = (int) ((DvScanView) getView()).getContext().getResources().getDimension(R.dimen.dv_helpview_small_portrait_manual_height);
                break;
            case SMALL:
                i = (int) ((DvScanView) getView()).getContext().getResources().getDimension(R.dimen.dv_helpview_small_portrait_height);
                break;
        }
        return i;
    }

    public void onPreviewAvailable(PreviewProperties previewProperties) {
        super.onPreviewAvailable(previewProperties);
        this.mExtractionClient.setDataExtractionActive(this.b == GuiState.SCAN);
    }

    public void onCameraError(Throwable th) {
        if (getView() != null) {
            ((DvScanView) getView()).onError(new JumioException(com.jumio.dv.a.a.NO_CAMERA_CONNECTION, 0));
        }
    }

    public void onManualRefocus(int i, int i2) {
        super.onManualRefocus(i, i2);
    }

    protected void onCreate() {
        if (this.d == null) {
            this.d = (DvSettingsModel) DataAccess.load(((DvScanView) getView()).getContext(), DvSettingsModel.class);
            if (this.d == null) {
                ((DvScanView) getView()).onError(new JumioException(com.jumio.dv.a.a.OCR_LOADING_FAILED, 0));
                return;
            }
        }
        super.onCreate();
    }

    protected void onStart() {
        if (this.a == null) {
            this.a = (DvScanPartModel) DataAccess.load(((DvScanView) getView()).getContext(), DvScanPartModel.class);
            if (this.a == null) {
                this.a = new DvScanPartModel();
            }
        } else if (this.a.getScannedImage().getImagePath() != null) {
            return;
        }
        if (this.mOverlay != null) {
            onUpdate(new ExtractionUpdate(ExtractionUpdateState.receiveClickListener, new b(this, null)));
        }
        if (this.b == GuiState.SCAN) {
            DvScanView dvScanView = (DvScanView) getView();
            String type = this.d.getType();
            HelpViewStyle helpViewStyle = (((DvScanView) getView()).getRotationManager().isScreenPortrait() || ((DvScanView) getView()).getRotationManager().isTablet()) ? HelpViewStyle.MINI : HelpViewStyle.NONE;
            dvScanView.showHelp(type, helpViewStyle, this.d.getDocumentName(), false);
        }
        ((DvScanView) getView()).updateUiAutomationScanId(getScanPluginMode());
        super.onStart();
    }

    protected void onStop() {
        super.onStop();
        DataAccess.update(((DvScanView) getView()).getContext(), DvScanPartModel.class, this.a);
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.mOrientationListener != null) {
            this.mOrientationListener.disable();
            this.mOrientationListener = null;
        }
    }

    /* renamed from: a */
    public void onUpdate(final ExtractionUpdate extractionUpdate) {
        if (b() && extractionUpdate != null) {
            int state = extractionUpdate.getState();
            Bitmap bitmap;
            File file;
            if (state == ExtractionUpdateState.shotTaken) {
                ((DvScanView) getView()).extractionStarted();
                ImageData scannedImage = this.a.getScannedImage();
                this.cameraManager.getImageData(scannedImage);
                this.cameraManager.stopPreview(false);
                scannedImage.setFocusConfidence(((Float) extractionUpdate.getData()).floatValue());
                try {
                    ((Vibrator) ((DvScanView) getView()).getContext().getSystemService("vibrator")).vibrate(100);
                } catch (Exception unused) {
                }
            } else if (state == ExtractionUpdateState.notifyFlash) {
                this.cameraManager.requestFlashHint(((Boolean) extractionUpdate.getData()).booleanValue());
            } else if (state == ExtractionUpdateState.notifyFocus) {
                Point point = (Point) extractionUpdate.getData();
                this.cameraManager.requestFocus(point.x, point.y);
            } else if (state == ExtractionUpdateState.saveImage) {
                bitmap = (Bitmap) extractionUpdate.getData();
                if (Log.isLogEnabledForLevel(LogLevel.DEBUG)) {
                    com.jumio.dv.c.a.a(bitmap, "", CompressFormat.JPEG, 80, null);
                }
                file = new File(Environment.getDataDirectory(((DvScanView) getView()).getContext()), String.format("tmpm_%d", new Object[]{Long.valueOf(System.currentTimeMillis())}));
                try {
                    CameraUtils.saveBitmap(bitmap, file, CompressFormat.JPEG, 80);
                } catch (Throwable e) {
                    Log.printStackTrace(e);
                }
                this.a.getScannedImage().setImagePath(file.getAbsolutePath());
            } else if (state == ExtractionUpdateState.saveExactImage) {
                bitmap = (Bitmap) extractionUpdate.getData();
                file = new File(Environment.getDataDirectory(((DvScanView) getView()).getContext()), String.format("tmpm_%d", new Object[]{Long.valueOf(System.currentTimeMillis())}));
                try {
                    CameraUtils.saveBitmap(bitmap, file, CompressFormat.JPEG, 80);
                } catch (Throwable e2) {
                    Log.printStackTrace(e2);
                }
                this.a.getScannedImage().setExactImagePath(file.getAbsolutePath());
            } else {
                this.c.post(new Runnable() {
                    public void run() {
                        if (b.this.mOverlay != null && b.this.b()) {
                            b.this.mOverlay.update(extractionUpdate);
                            ((DvScanView) b.this.getView()).invalidateDrawView(false);
                        }
                    }
                });
            }
        }
    }

    /* renamed from: a */
    public void onResult(StaticModel staticModel) {
        if (b()) {
            Log.d("ScanPresenter", "onResult");
            this.cameraManager.stopPreview(true);
            this.mExtractionClient.cancel();
            ((DvScanView) getView()).hideHelp();
            ((DvScanView) getView()).showConfirmation(this.a.getScannedImage().getExactImagePath(), false);
            this.b = GuiState.CONFIRMATION;
        }
    }

    protected void onScreenAngleChanged(ScreenAngle screenAngle) {
        super.onScreenAngleChanged(screenAngle);
    }

    public void a() {
        DataAccess.update(((DvScanView) getView()).getContext(), DvScanPartModel.class, this.a);
        ((DvScanView) getView()).scansComplete();
    }

    public void b() {
        this.b = GuiState.SCAN;
        this.a.getScannedImage().clear();
        this.mExtractionClient.reinit();
        onStart();
    }

    public void a(a aVar, boolean z) {
        switch (aVar) {
            case HELP:
                DvScanView dvScanView = (DvScanView) getView();
                String type = this.d.getType();
                HelpViewStyle helpViewStyle = (z || ((DvScanView) getView()).getRotationManager().isTablet()) ? HelpViewStyle.MINI : HelpViewStyle.NONE;
                dvScanView.showHelp(type, helpViewStyle, this.d.getDocumentName(), true);
                return;
            case CONFIRMATION:
                if (this.b == GuiState.CONFIRMATION) {
                    ((DvScanView) getView()).showConfirmation(this.a.getScannedImage().getExactImagePath(), true);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void a(GuiState guiState) {
        this.b = guiState;
    }

    public void a(JumioException jumioException) {
        LocalBroadcastManager.getInstance(((DvScanView) getView()).getContext()).sendBroadcast(new com.jumio.dv.a(jumioException.getErrorCase().code(), jumioException.getDetailedErrorCase(), jumioException.getErrorCase().localizedMessage(((DvScanView) getView()).getContext())));
    }
}
