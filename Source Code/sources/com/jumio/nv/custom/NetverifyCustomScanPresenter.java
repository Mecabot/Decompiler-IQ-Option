package com.jumio.nv.custom;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.jumio.commons.utils.DeviceRotationManager;
import com.jumio.commons.utils.ScreenUtil;
import com.jumio.commons.view.CompatibilityLayer;
import com.jumio.commons.view.ScaleableImageView;
import com.jumio.core.data.Strings;
import com.jumio.core.data.document.DocumentScanMode;
import com.jumio.core.data.document.ScanSide;
import com.jumio.core.plugins.PluginRegistry.PluginMode;
import com.jumio.gui.DrawView;
import com.jumio.gui.Images;
import com.jumio.nv.data.NVStrings;
import com.jumio.nv.extraction.NfcController;
import com.jumio.nv.view.interactors.NVScanView;
import com.jumio.nv.view.interactors.NVScanView.GuiState;
import com.jumio.nv.view.interactors.NVScanView.HelpViewStyle;
import com.jumio.nv.view.interactors.NVScanView.NVHelpConfiguration;
import com.jumio.sdk.models.CredentialsModel;
import com.jumio.sdk.presentation.BaseScanPresenter.BaseScanControl;
import jumio.nv.core.x;

public final class NetverifyCustomScanPresenter {
    private Bitmap confirmationBitmap;
    private NetverifyCustomConfirmationView confirmationView = null;
    private a internalScanPresenter = null;
    private Bitmap jumioBitmap;
    private x nvScanPresenter;
    private ImageView poweredByJumioImageView = null;
    private DrawView scanOverlayView = null;
    private NetverifyCustomScanView scanView = null;
    private NetverifyCustomScanInterface scanViewInterface;
    private a sdkController;
    private TextureView textureView = null;

    class a implements OnGlobalLayoutListener, NVScanView {
        int a;
        int b;

        public int getHelpViewHeight(HelpViewStyle helpViewStyle) {
            return 0;
        }

        public void hideHelp() {
        }

        public void showLoading() {
        }

        public void showNFC(Bundle bundle) {
        }

        public void updateCameraControls(boolean z, boolean z2) {
        }

        public void updateUiAutomationScanId(PluginMode pluginMode) {
        }

        private a() {
            this.a = 0;
            this.b = 0;
        }

        public Context getContext() {
            return NetverifyCustomScanPresenter.this.sdkController.getContext();
        }

        public void onError(Throwable th) {
            NetverifyCustomScanPresenter.this.sdkController.onError(th);
        }

        public TextureView getTextureView() {
            return NetverifyCustomScanPresenter.this.textureView;
        }

        public DeviceRotationManager getRotationManager() {
            return NetverifyCustomScanPresenter.this.sdkController.d();
        }

        public void invalidateDrawView(final boolean z) {
            NetverifyCustomScanPresenter.this.scanOverlayView.post(new Runnable() {
                public void run() {
                    if (NetverifyCustomScanPresenter.this.scanOverlayView != null) {
                        if (z) {
                            NetverifyCustomScanPresenter.this.scanOverlayView.requestLayout();
                        }
                        NetverifyCustomScanPresenter.this.scanOverlayView.invalidate();
                    }
                }
            });
        }

        public void updateBranding(final boolean z) {
            NetverifyCustomScanPresenter.this.poweredByJumioImageView.post(new Runnable() {
                public void run() {
                    if (!z) {
                        CompatibilityLayer.setImageViewAlpha(NetverifyCustomScanPresenter.this.poweredByJumioImageView, 0);
                    } else if (CompatibilityLayer.getImageViewAlpha(NetverifyCustomScanPresenter.this.poweredByJumioImageView) == 0.0f) {
                        ObjectAnimator ofInt = ObjectAnimator.ofInt(NetverifyCustomScanPresenter.this.poweredByJumioImageView, "alpha", new int[]{0, 255});
                        ofInt.setDuration(200);
                        ofInt.start();
                    }
                }
            });
        }

        public void resetCameraControls(boolean z, boolean z2) {
            NetverifyCustomScanPresenter.this.scanViewInterface.onNetverifyCameraAvailable();
        }

        public CredentialsModel getCredentialsModel() {
            return NetverifyCustomScanPresenter.this.sdkController.getCredentialsModel();
        }

        public NfcController getNfcController() {
            return NetverifyCustomScanPresenter.this.sdkController.getNfcController();
        }

        public void showHelp(NVHelpConfiguration nVHelpConfiguration, boolean z) {
            if (!z) {
                if ((nVHelpConfiguration.isUSDLFallback || nVHelpConfiguration.isIdBackFaceDetected) && NetverifyCustomScanPresenter.this.nvScanPresenter != null) {
                    NetverifyCustomScanPresenter.this.nvScanPresenter.l();
                }
                if (nVHelpConfiguration.showFullscreen && NetverifyCustomScanPresenter.this.nvScanPresenter != null) {
                    NetverifyCustomScanPresenter.this.nvScanPresenter.a(false);
                }
            }
        }

        public void showConfirmation(String str, boolean z) {
            NetverifyCustomScanPresenter.this.confirmationView.removeAllViews();
            View scaleableImageView = new ScaleableImageView(getContext());
            scaleableImageView.setLayoutParams(new LayoutParams(-1, -1));
            if (NetverifyCustomScanPresenter.this.confirmationBitmap != null) {
                NetverifyCustomScanPresenter.this.confirmationBitmap.recycle();
                NetverifyCustomScanPresenter.this.confirmationBitmap = null;
                System.gc();
            }
            NetverifyCustomScanPresenter.this.confirmationBitmap = BitmapFactory.decodeFile(str);
            scaleableImageView.setImageBitmap(NetverifyCustomScanPresenter.this.confirmationBitmap);
            NetverifyCustomScanPresenter.this.confirmationView.addView(scaleableImageView);
            NetverifyCustomScanPresenter.this.scanViewInterface.onNetverifyPresentConfirmationView();
        }

        public void extractionStarted() {
            NetverifyCustomScanPresenter.this.scanViewInterface.onNetverifyExtractionStarted();
        }

        public void scansComplete() {
            NetverifyCustomScanPresenter.this.scanViewInterface.onNetverifyScanForPartFinished(NetverifyCustomScanPresenter.this.nvScanPresenter.d(), true);
        }

        public void partComplete() {
            NetverifyCustomScanPresenter.this.scanViewInterface.onNetverifyScanForPartFinished(NetverifyCustomScanPresenter.this.nvScanPresenter.d(), false);
        }

        public void noUsAddressFound() {
            NetverifyCustomScanPresenter.this.scanViewInterface.onNetverifyNoUSAddressFound();
        }

        public void faceOnBackside() {
            NetverifyCustomScanPresenter.this.scanViewInterface.onNetverifyFaceOnBackside();
        }

        public void showLegalHint(String str) {
            NetverifyCustomScanPresenter.this.scanViewInterface.onNetverifyShowLegalAdvice(str);
        }

        public boolean displayOverlay(boolean z) {
            if (NetverifyCustomScanPresenter.this.nvScanPresenter == null) {
                return true;
            }
            if (!ScanSide.FACE.equals(NetverifyCustomScanPresenter.this.nvScanPresenter.d())) {
                z = NetverifyCustomScanPresenter.this.nvScanPresenter.e() != DocumentScanMode.MANUAL;
            } else if (!z) {
                NetverifyCustomScanPresenter.this.scanViewInterface.onNetverifyFaceInLandscape();
            }
            return z;
        }

        public void onGlobalLayout() {
            if (NetverifyCustomScanPresenter.this.textureView != null) {
                if (!(NetverifyCustomScanPresenter.this.textureView.getHeight() == this.b || NetverifyCustomScanPresenter.this.textureView.getWidth() == this.a)) {
                    if (NetverifyCustomScanPresenter.this.scanOverlayView != null) {
                        NetverifyCustomScanPresenter.this.scanOverlayView.requestLayout();
                    }
                    boolean z = getRotationManager().isScreenPortrait() || getRotationManager().isTablet();
                    if (NetverifyCustomScanPresenter.this.nvScanPresenter != null) {
                        NetverifyCustomScanPresenter.this.nvScanPresenter.a(jumio.nv.core.x.a.OVERLAY, z);
                        NetverifyCustomScanPresenter.this.nvScanPresenter.a(jumio.nv.core.x.a.BRANDING, z);
                    }
                }
                this.a = NetverifyCustomScanPresenter.this.textureView.getWidth();
                this.b = NetverifyCustomScanPresenter.this.textureView.getHeight();
            }
        }
    }

    NetverifyCustomScanPresenter(a aVar, NetverifyCustomScanView netverifyCustomScanView, NetverifyCustomConfirmationView netverifyCustomConfirmationView, NetverifyCustomScanInterface netverifyCustomScanInterface) {
        this.sdkController = aVar;
        this.scanViewInterface = netverifyCustomScanInterface;
        this.scanView = netverifyCustomScanView;
        this.confirmationView = netverifyCustomConfirmationView;
        this.nvScanPresenter = new x();
        this.internalScanPresenter = new a();
        Context context = aVar.getContext();
        int dipToPx = (int) ScreenUtil.dipToPx(context, 10.0f);
        int dipToPx2 = (int) ScreenUtil.dipToPx(context, 20.0f);
        int dipToPx3 = (int) ScreenUtil.dipToPx(context, 17.0f);
        netverifyCustomScanView.removeAllViews();
        this.textureView = new TextureView(context);
        this.textureView.setLayoutParams(new LayoutParams(-1, -1));
        netverifyCustomScanView.addView(this.textureView);
        this.textureView.getViewTreeObserver().addOnGlobalLayoutListener(this.internalScanPresenter);
        this.scanOverlayView = new DrawView(context);
        this.scanOverlayView.setLayoutParams(new LayoutParams(-1, -1));
        netverifyCustomScanView.addView(this.scanOverlayView);
        this.jumioBitmap = Images.getImage(context.getResources());
        this.poweredByJumioImageView = new ImageView(context);
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.poweredByJumioImageView.setLayoutParams(layoutParams);
        this.poweredByJumioImageView.setAdjustViewBounds(true);
        this.poweredByJumioImageView.setPadding(dipToPx2, dipToPx, dipToPx2, dipToPx3);
        this.poweredByJumioImageView.setImageBitmap(this.jumioBitmap);
        CompatibilityLayer.setImageViewAlpha(this.poweredByJumioImageView, 0);
        netverifyCustomScanView.addView(this.poweredByJumioImageView);
        netverifyCustomScanView.invalidate();
        this.nvScanPresenter.attachView(this.internalScanPresenter);
        this.scanOverlayView.setDrawViewInterface(this.nvScanPresenter);
        this.nvScanPresenter.activate();
    }

    public void destroy() {
        if (this.nvScanPresenter != null) {
            this.nvScanPresenter.deactivate();
            this.nvScanPresenter.detachView();
            this.nvScanPresenter = null;
        }
        if (this.confirmationBitmap != null) {
            this.confirmationBitmap.recycle();
            this.confirmationBitmap = null;
            System.gc();
        }
        if (this.jumioBitmap != null) {
            this.jumioBitmap.recycle();
            this.jumioBitmap = null;
            System.gc();
        }
        this.textureView.getViewTreeObserver().removeOnGlobalLayoutListener(this.internalScanPresenter);
        this.scanView.removeAllViews();
        this.confirmationView.removeAllViews();
        this.textureView = null;
        this.scanOverlayView = null;
        this.sdkController.e();
    }

    public NetverifyScanMode getScanMode() {
        NetverifyScanMode netverifyScanMode = null;
        if (this.nvScanPresenter == null) {
            return null;
        }
        switch (this.nvScanPresenter.e()) {
            case MRP:
            case MRV:
            case TD1:
            case TD2:
            case CNIS:
                netverifyScanMode = NetverifyScanMode.MRZ;
                break;
            case PDF417:
                netverifyScanMode = NetverifyScanMode.BARCODE;
                break;
            case CSSN:
            case LINEFINDER:
                netverifyScanMode = NetverifyScanMode.OCR_CARD;
                break;
            case FACE:
                netverifyScanMode = NetverifyScanMode.FACE;
                break;
            case MANUAL:
                netverifyScanMode = NetverifyScanMode.MANUAL;
                break;
            case TEMPLATEMATCHER:
                netverifyScanMode = NetverifyScanMode.OCR_TEMPLATE;
                break;
            case NFC:
                netverifyScanMode = NetverifyScanMode.NFC;
                break;
        }
        return netverifyScanMode;
    }

    public String getHelpText() {
        String str = null;
        if (this.nvScanPresenter == null) {
            return null;
        }
        switch (this.nvScanPresenter.e()) {
            case MRP:
            case MRV:
            case TD1:
            case TD2:
            case CSSN:
            case LINEFINDER:
                str = Strings.getExternalString(this.sdkController.getContext(), NVStrings.HELPVIEW_SMALL_DESCRIPTION);
                break;
            case CNIS:
                str = Strings.getExternalString(this.sdkController.getContext(), NVStrings.HELPVIEW_SMALL_DESCRIPTION_CARD);
                break;
            case PDF417:
                str = Strings.getExternalString(this.sdkController.getContext(), NVStrings.HELPVIEW_SMALL_DESCRIPTION_BARCODE);
                break;
            case FACE:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(Strings.getExternalString(this.sdkController.getContext(), NVStrings.HELPVIEW_FULL_DESCRIPTION_LIVENESS_GLASSES));
                stringBuilder.append(" ");
                String stringBuilder2 = stringBuilder.toString();
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append(stringBuilder2);
                stringBuilder3.append(Strings.getExternalString(this.sdkController.getContext(), NVStrings.HELPVIEW_FULL_DESCRIPTION_LIVENESS_CAP));
                stringBuilder3.append(" ");
                stringBuilder2 = stringBuilder3.toString();
                stringBuilder3 = new StringBuilder();
                stringBuilder3.append(stringBuilder2);
                stringBuilder3.append(Strings.getExternalString(this.sdkController.getContext(), NVStrings.HELPVIEW_FULL_DESCRIPTION_LIVENESS_LIGHT));
                stringBuilder3.append(" ");
                str = stringBuilder3.toString();
                break;
            case MANUAL:
                str = "";
                break;
            case TEMPLATEMATCHER:
                str = Strings.getExternalString(this.sdkController.getContext(), NVStrings.HELPVIEW_SMALL_DESCRIPTION_TEMPLATE);
                break;
        }
        return str;
    }

    public void resume() {
        if (this.nvScanPresenter != null && this.nvScanPresenter.k() == GuiState.SCAN) {
            retryScan();
        }
    }

    public void pause() {
        if (this.nvScanPresenter != null && this.nvScanPresenter.k() == GuiState.SCAN) {
            stopScan();
        }
    }

    public void retryScan() {
        if (this.nvScanPresenter != null) {
            this.nvScanPresenter.activate();
            this.nvScanPresenter.b();
        }
    }

    public void confirmScan() {
        if (this.nvScanPresenter != null) {
            this.nvScanPresenter.f();
        }
    }

    public void stopScan() {
        if (this.nvScanPresenter != null) {
            this.nvScanPresenter.deactivate();
        }
    }

    public boolean hasFlash() {
        if (this.nvScanPresenter == null) {
            return false;
        }
        return this.nvScanPresenter.control(BaseScanControl.hasFlash);
    }

    public boolean isFlashOn() {
        if (this.nvScanPresenter == null) {
            return false;
        }
        return this.nvScanPresenter.control(BaseScanControl.isFlashOn);
    }

    public void toggleFlash() {
        if (this.nvScanPresenter != null) {
            this.nvScanPresenter.control(BaseScanControl.toggleFlash);
        }
    }

    public boolean hasMultipleCameras() {
        if (this.nvScanPresenter == null) {
            return false;
        }
        return this.nvScanPresenter.control(BaseScanControl.hasMultipleCameras);
    }

    public boolean isCameraFrontFacing() {
        if (this.nvScanPresenter == null) {
            return false;
        }
        return this.nvScanPresenter.control(BaseScanControl.isCameraFrontfacing);
    }

    public void switchCamera() {
        if (this.nvScanPresenter != null) {
            this.nvScanPresenter.control(BaseScanControl.toggleCamera);
        }
    }

    public boolean isFallbackAvailable() {
        if (this.nvScanPresenter == null) {
            return false;
        }
        return this.nvScanPresenter.n();
    }

    public void startFallback() {
        if (this.nvScanPresenter != null) {
            this.nvScanPresenter.p();
        }
    }

    public boolean showShutterButton() {
        boolean z = false;
        if (this.nvScanPresenter == null) {
            return false;
        }
        if (this.nvScanPresenter.e() == DocumentScanMode.MANUAL) {
            z = true;
        }
        return z;
    }

    public void takePicture() {
        if (this.nvScanPresenter != null) {
            this.nvScanPresenter.o();
        }
    }

    public void pauseExtraction() {
        if (this.nvScanPresenter != null) {
            this.nvScanPresenter.control(BaseScanControl.stopExtraction);
        }
    }

    public void resumeExtraction() {
        if (this.nvScanPresenter != null) {
            this.nvScanPresenter.control(BaseScanControl.startExtraction);
        }
    }
}
