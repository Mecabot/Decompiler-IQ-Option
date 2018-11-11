package jumio.nv.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.v4.content.LocalBroadcastManager;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.FaceDetector;
import com.google.android.gms.vision.face.FaceDetector.Builder;
import com.iqoption.dto.entity.position.PendingOrderWrapper;
import com.jumio.analytics.JumioAnalytics;
import com.jumio.analytics.MetaInfo;
import com.jumio.analytics.MobileEvents;
import com.jumio.analytics.Screen;
import com.jumio.analytics.UserAction;
import com.jumio.commons.camera.CameraUtils;
import com.jumio.commons.camera.ImageData;
import com.jumio.commons.camera.PreviewProperties;
import com.jumio.commons.enums.ScreenAngle;
import com.jumio.commons.log.Log;
import com.jumio.commons.log.Log.LogLevel;
import com.jumio.core.data.Strings;
import com.jumio.core.data.document.DocumentScanMode;
import com.jumio.core.data.document.ScanSide;
import com.jumio.core.environment.Environment;
import com.jumio.core.mvp.model.InvokeOnUiThread;
import com.jumio.core.mvp.model.Subscriber;
import com.jumio.core.plugins.PluginRegistry;
import com.jumio.core.plugins.PluginRegistry.PluginMode;
import com.jumio.nv.api.calls.NVBackend;
import com.jumio.nv.api.helpers.UploadManager;
import com.jumio.nv.data.NVStrings;
import com.jumio.nv.data.document.DocumentType;
import com.jumio.nv.data.document.NVDocumentMaskingType;
import com.jumio.nv.data.document.NVDocumentVariant;
import com.jumio.nv.enums.NVErrorCase;
import com.jumio.nv.enums.NVExtractionMethod;
import com.jumio.nv.extraction.NVExtractionUpdateState;
import com.jumio.nv.extraction.NfcController;
import com.jumio.nv.liveness.extraction.LivenessDataModel;
import com.jumio.nv.models.DocumentDataModel;
import com.jumio.nv.models.InitiateModel;
import com.jumio.nv.models.MerchantSettingsModel;
import com.jumio.nv.models.NVScanPartModel;
import com.jumio.nv.models.SelectionModel;
import com.jumio.nv.models.ServerSettingsModel;
import com.jumio.nv.models.TemplateModel;
import com.jumio.nv.utils.NetverifyLogUtils;
import com.jumio.nv.view.interactors.NVScanView;
import com.jumio.nv.view.interactors.NVScanView.GuiState;
import com.jumio.nv.view.interactors.NVScanView.HelpViewStyle;
import com.jumio.nv.view.interactors.NVScanView.NVHelpConfiguration;
import com.jumio.persistence.DataAccess;
import com.jumio.sdk.exception.JumioException;
import com.jumio.sdk.extraction.ExtractionClient.ExtractionUpdate;
import com.jumio.sdk.extraction.ExtractionUpdateState;
import com.jumio.sdk.models.BaseScanPartModel;
import com.jumio.sdk.presentation.BaseScanPresenter;
import com.jumio.sdk.presentation.BaseScanPresenter.BaseScanControl;
import java.io.File;
import java.io.Serializable;

/* compiled from: NVScanPresenter */
public class x extends BaseScanPresenter<NVScanView, ExtractionUpdate, DocumentDataModel> {
    private NVScanPartModel a;
    private NVScanPartModel b;
    private NVHelpConfiguration c;
    private ViewGroup d;
    private boolean e;
    private GuiState f = GuiState.SCAN;
    private FaceDetector g = null;
    private SelectionModel h;
    private boolean i = false;
    private boolean j = false;
    private Handler k = new Handler(Looper.getMainLooper());
    private UploadManager l;
    private MerchantSettingsModel m;
    private ServerSettingsModel n;

    /* compiled from: NVScanPresenter */
    public enum a {
        TITLE,
        OVERLAY,
        HELP,
        CONFIRMATION,
        BRANDING
    }

    /* compiled from: NVScanPresenter */
    class b implements OnClickListener {
        private b() {
        }

        /* synthetic */ b(x xVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        public void onClick(View view) {
            x.this.o();
        }
    }

    protected boolean enableFlashOnStart() {
        return false;
    }

    protected BaseScanPartModel getScanPartModel() {
        if (this.a == null) {
            this.a = (NVScanPartModel) DataAccess.load(((NVScanView) getView()).getContext(), NVScanPartModel.class);
            if (this.h == null) {
                this.h = (SelectionModel) DataAccess.load(((NVScanView) getView()).getContext(), SelectionModel.class);
            }
            if (!(this.h == null || this.a == null || this.h.getSelectedDoctype() == null || !this.h.getSelectedDoctype().getDocumentScanMode().equals(this.a.getScanMode()) || this.h.getSelectedDoctype().getThirdPartyOcr() == null || !NVDocumentVariant.PLASTIC.equals(this.h.getSelectedVariant()) || !PluginRegistry.hasPlugin(PluginMode.TEMPLATE_MATCHER))) {
                try {
                    if (new TemplateModel(((NVScanView) getView()).getContext()).getTemplate(this.h.getSelectedCountry(), this.h.getSelectedDoctype().getId(), this.h.getSelectedDoctype().getDocumentScanSide()) != null) {
                        this.h.getSelectedDoctype().setDocumentScanMode(DocumentScanMode.TEMPLATEMATCHER);
                        ScanSide sideToScan = this.a.getSideToScan();
                        this.a = new NVScanPartModel(sideToScan, DocumentScanMode.TEMPLATEMATCHER, this.a.getPartIndex());
                        this.h.getUploadModel().replace(sideToScan, this.a);
                        DataAccess.update(((NVScanView) getView()).getContext(), SelectionModel.class, this.h);
                    }
                } catch (Exception unused) {
                    return this.a;
                }
            }
        }
    }

    protected PluginMode getScanPluginMode() {
        return this.n.getScanPluginMode(this.a.getScanMode());
    }

    protected boolean startCameraFrontfacing() {
        return this.m.isCameraFrontfacing() || getScanPartModel().getScanMode() == DocumentScanMode.FACE;
    }

    protected boolean canSwitchCamera() {
        return (this.cameraManager == null || !this.cameraManager.hasMultipleCameras() || getScanPartModel().getScanMode() == DocumentScanMode.FACE) ? false : true;
    }

    public boolean control(int i) {
        boolean control = super.control(i);
        if (i == BaseScanControl.toggleFlash) {
            JumioAnalytics.add(MobileEvents.userAction(JumioAnalytics.getSessionId(), Screen.SCAN, UserAction.FLASH, this.cameraManager.isFlashOn() ? "ON" : "OFF"));
        } else if (i == BaseScanControl.toggleCamera) {
            JumioAnalytics.add(MobileEvents.userAction(JumioAnalytics.getSessionId(), Screen.SCAN, UserAction.CAMERA, this.cameraManager.isFrontFacing() ? "BACK" : "FRONT"));
        }
        return control;
    }

    public void onPreviewAvailable(PreviewProperties previewProperties) {
        super.onPreviewAvailable(previewProperties);
        boolean z = true;
        this.mExtractionClient.setDataExtractionActive(this.f == GuiState.SCAN);
        if (this.f == GuiState.SCAN) {
            if (this.n == null || !this.n.isBrandingEnabled()) {
                z = false;
            }
            ((NVScanView) getView()).updateBranding(z);
            return;
        }
        ((NVScanView) getView()).updateBranding(false);
    }

    public void onCameraError(Throwable th) {
        if (getView() != null) {
            ((NVScanView) getView()).onError(new JumioException(NVErrorCase.NO_CAMERA_CONNECTION, 0));
        }
    }

    public void onManualRefocus(int i, int i2) {
        super.onManualRefocus(i, i2);
        JumioAnalytics.add(MobileEvents.userAction(JumioAnalytics.getSessionId(), Screen.SCAN, UserAction.REFOCUS));
    }

    protected void onCreate() {
        if (this.m == null) {
            this.m = (MerchantSettingsModel) DataAccess.load(((NVScanView) getView()).getContext(), MerchantSettingsModel.class);
            if (this.m == null) {
                ((NVScanView) getView()).onError(new JumioException(NVErrorCase.OCR_LOADING_FAILED, 0));
                return;
            }
        }
        if (this.n == null) {
            this.n = (ServerSettingsModel) DataAccess.load(((NVScanView) getView()).getContext(), ServerSettingsModel.class);
            if (this.n == null) {
                ((NVScanView) getView()).onError(new JumioException(NVErrorCase.OCR_LOADING_FAILED, 0));
                return;
            }
        }
        super.onCreate();
    }

    protected void onStart() {
        boolean z = true;
        boolean z2 = this.h != null && this.h.isVerificationRequired();
        this.e = z2;
        if (this.a == null) {
            this.a = (NVScanPartModel) DataAccess.load(((NVScanView) getView()).getContext(), NVScanPartModel.class);
            if (this.a == null) {
                ((NVScanView) getView()).onError(new JumioException(NVErrorCase.OCR_LOADING_FAILED, 0));
                return;
            }
        }
        if (this.b == null) {
            this.b = (NVScanPartModel) DataAccess.load(((NVScanView) getView()).getContext(), "fallbackScanPartModel");
        }
        if (!(((NVScanView) getView()).getRotationManager().isScreenPortrait() || ((NVScanView) getView()).getRotationManager().isTablet())) {
            z = false;
        }
        if (this.mOverlay != null) {
            onUpdate(new ExtractionUpdate(ExtractionUpdateState.receiveClickListener, new b(this, null)));
            this.mOverlay.setVisible(((NVScanView) getView()).displayOverlay(z) ? 0 : 4);
        }
        if (this.h != null) {
            this.c = a(this.h, z);
            if (this.f == GuiState.SCAN) {
                ((NVScanView) getView()).showHelp(this.c, false);
            }
            if (!(!c() || this.c == null || this.c.scanMode == DocumentScanMode.FACE)) {
                r();
            }
            this.l = new UploadManager(((NVScanView) getView()).getContext(), this.h.getUploadModel().getActivePart().getSideToScan(), ((NVScanView) getView()).getCredentialsModel(), this.e);
            this.l.add(new Subscriber<Boolean>() {
                /* renamed from: a */
                public void onResult(Boolean bool) {
                }

                public void onError(Throwable th) {
                    if (x.this.e()) {
                        ((NVScanView) x.this.getView()).onError(th);
                    }
                }
            });
            this.l.addSubscribers();
            PluginMode scanPluginMode = getScanPluginMode();
            MetaInfo metaInfo = new MetaInfo();
            metaInfo.put(PendingOrderWrapper.SIDE, this.a.getSideToScan().toString());
            metaInfo.put(Param.TYPE, scanPluginMode.toString());
            JumioAnalytics.add(MobileEvents.pageView(JumioAnalytics.getSessionId(), Screen.SCAN, metaInfo));
            ((NVScanView) getView()).updateUiAutomationScanId(scanPluginMode);
        }
        super.onStart();
    }

    public void a() {
        if (this.cameraManager != null) {
            this.cameraManager.startPreview();
        }
    }

    public void b() {
        this.f = GuiState.SCAN;
        if (this.a.getScannedImage().getImagePath() != null) {
            this.a.getScannedImage().clear();
        }
        this.mExtractionClient.cancel();
        this.mExtractionClient.reinit();
        onStart();
    }

    protected void onStop() {
        super.onStop();
        if (this.l != null) {
            this.l.removeSubscribers();
        }
        if (this.a != null) {
            DataAccess.update(((NVScanView) getView()).getContext(), NVScanPartModel.class, this.a);
        }
        if (this.b != null) {
            DataAccess.update(((NVScanView) getView()).getContext(), "fallbackScanPartModel", this.b);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.mOrientationListener != null) {
            this.mOrientationListener.disable();
            this.mOrientationListener = null;
        }
        if (this.g != null) {
            this.g.release();
            this.g = null;
        }
    }

    /* renamed from: a */
    public void onUpdate(final ExtractionUpdate extractionUpdate) {
        if (e() && extractionUpdate != null) {
            int state = extractionUpdate.getState();
            Bitmap bitmap;
            File file;
            if (state == ExtractionUpdateState.shotTaken) {
                ((NVScanView) getView()).extractionStarted();
                ImageData scannedImage = this.a.getScannedImage();
                this.cameraManager.getImageData(scannedImage);
                this.cameraManager.stopPreview(false);
                scannedImage.setFocusConfidence(((Float) extractionUpdate.getData()).floatValue());
                try {
                    ((Vibrator) ((NVScanView) getView()).getContext().getSystemService("vibrator")).vibrate(100);
                } catch (Exception unused) {
                }
            } else if (state == ExtractionUpdateState.notifyFlash) {
                this.cameraManager.requestFlashHint(((Boolean) extractionUpdate.getData()).booleanValue());
            } else if (state == ExtractionUpdateState.notifyFocus) {
                Point point = (Point) extractionUpdate.getData();
                this.cameraManager.requestFocus(point.x, point.y);
            } else if (state == ExtractionUpdateState.saveImage) {
                bitmap = (Bitmap) extractionUpdate.getData();
                if (Log.isLogEnabledForLevel(LogLevel.DEBUG) && bitmap != null) {
                    NetverifyLogUtils.dumpImageInSubfolder(bitmap, this.mExtractionClient.getClass().getSimpleName(), CompressFormat.JPEG, 80, String.valueOf(this.a.getPartIndex()));
                }
                file = new File(Environment.getDataDirectory(((NVScanView) getView()).getContext()), String.format("tmp_%d", new Object[]{Long.valueOf(System.currentTimeMillis())}));
                if (bitmap != null) {
                    try {
                        if (!bitmap.isRecycled()) {
                            CameraUtils.saveBitmap(bitmap, file, CompressFormat.WEBP, 75);
                        }
                    } catch (Throwable e) {
                        Log.printStackTrace(e);
                    }
                }
                this.a.getScannedImage().setImagePath(file.getAbsolutePath());
            } else if (state == ExtractionUpdateState.saveExactImage) {
                bitmap = (Bitmap) extractionUpdate.getData();
                if (bitmap != null) {
                    file = new File(Environment.getDataDirectory(((NVScanView) getView()).getContext()), String.format("tmp_%d", new Object[]{Long.valueOf(System.currentTimeMillis())}));
                    try {
                        CameraUtils.saveBitmap(bitmap, file, CompressFormat.JPEG, 80);
                    } catch (Throwable e2) {
                        Log.printStackTrace(e2);
                    }
                    this.a.getScannedImage().setExactImagePath(file.getAbsolutePath());
                }
            } else if (state != NVExtractionUpdateState.showHelp) {
                this.k.post(new Runnable() {
                    public void run() {
                        if (x.this.mOverlay != null && x.this.e()) {
                            x.this.mOverlay.update(extractionUpdate);
                            ((NVScanView) x.this.getView()).invalidateDrawView(false);
                        }
                    }
                });
            } else if (this.f == GuiState.SCAN) {
                this.c.showFullscreen = true;
                ((NVScanView) getView()).showHelp(this.c, false);
            }
        }
    }

    /* renamed from: a */
    public void onResult(DocumentDataModel documentDataModel) {
        if (e()) {
            boolean z;
            Log.d("ScanPresenter", "onResult");
            JumioAnalytics.add(MobileEvents.userAction(JumioAnalytics.getSessionId(), Screen.SCAN, UserAction.SCAN_TRIGGERED, this.cameraManager.isFrontFacing() ? "FRONT" : "BACK"));
            DocumentScanMode scanMode = this.a.getScanMode();
            boolean z2 = true;
            if (this.h != null) {
                if (documentDataModel == null && this.h.getUploadModel().getExtractionMethod() == NVExtractionMethod.NONE && this.a.getSideToScan() == ScanSide.FRONT) {
                    documentDataModel = new DocumentDataModel();
                }
                this.a.setDocumentInfo(documentDataModel);
                String str = null;
                SelectionModel selectionModel;
                switch (scanMode) {
                    case PDF417:
                        String city;
                        if (documentDataModel != null) {
                            str = documentDataModel.getAddressLine();
                            city = documentDataModel.getCity();
                        } else {
                            city = null;
                        }
                        if (!this.e && !this.m.isDataExtractionOnMobileOnly() && this.h.isAddressEnabled() && "USA".equals(this.h.getSelectedCountry().getIsoCode()) && (str == null || str.length() == 0 || city == null || city.length() == 0)) {
                            this.mExtractionClient.unsubscribe(this);
                            this.mExtractionClient.destroy();
                            if (!DocumentScanMode.CSSN.equals(this.a.getScanMode())) {
                                a(this.a, this.h);
                                this.b = this.a;
                                DataAccess.update(((NVScanView) getView()).getContext(), "fallbackScanPartModel", this.b);
                                DataAccess.update(((NVScanView) getView()).getContext(), NVScanPartModel.class, this.a);
                                this.a = new NVScanPartModel(ScanSide.FRONT, DocumentScanMode.CSSN, 0);
                                this.j = true;
                                selectionModel = this.h;
                                if (!(((NVScanView) getView()).getRotationManager().isScreenPortrait() || ((NVScanView) getView()).getRotationManager().isTablet())) {
                                    z2 = false;
                                }
                                this.c = a(selectionModel, z2);
                                this.plugin = PluginRegistry.getPlugin(getScanPluginMode());
                                ((NVScanView) getView()).showHelp(this.c, false);
                                this.mExtractionClient = this.plugin.getExtractionClient(((NVScanView) getView()).getContext());
                                this.mExtractionClient.configure(this.a);
                                this.mExtractionClient.subscribe(this);
                                this.mExtractionClient.setFlags(((NVScanView) getView()).getRotationManager().isScreenPortrait(), ((NVScanView) getView()).getRotationManager().isTablet(), ((NVScanView) getView()).getRotationManager().isInverted());
                                this.mExtractionClient.setPreviewProperties(this.mPreviewProperties);
                                this.mExtractionClient.setExtractionArea(getExtractionArea());
                                this.mExtractionClient.reinit();
                                this.h.getSelectedDoctype().setDocumentScanSide(ScanSide.FRONT);
                                DataAccess.update(((NVScanView) getView()).getContext(), SelectionModel.class, this.h);
                                ((NVScanView) getView()).noUsAddressFound();
                                return;
                            }
                            return;
                        }
                    case MRP:
                    case MRV:
                    case TD1:
                    case TD2:
                    case CNIS:
                        z = this.e;
                        if (!(!a(this.h, d()) || this.h.getSelectedCountry() == null || !this.h.getSelectedCountry().getIsoCode().equals("NLD") || documentDataModel == null || documentDataModel.getMrzData() == null)) {
                            String mrzLine2;
                            if (scanMode != DocumentScanMode.TD1) {
                                if (scanMode == DocumentScanMode.MRP) {
                                    mrzLine2 = documentDataModel.getMrzData().getMrzLine2();
                                    documentDataModel.getMrzData().setMrzLine2(mrzLine2.replace(mrzLine2.substring(28, 42), "XXXXXXXXXXXXXX"));
                                    documentDataModel.setPersonalNumber(null);
                                    break;
                                }
                            }
                            mrzLine2 = documentDataModel.getMrzData().getMrzLine1();
                            documentDataModel.getMrzData().setMrzLine1(mrzLine2.replace(mrzLine2.substring(15, 30), "XXXXXXXXXXXXXXX"));
                            documentDataModel.setPersonalNumber(null);
                            break;
                        }
                        break;
                    case CSSN:
                    case LINEFINDER:
                        if (this.a.getSideToScan() == ScanSide.BACK) {
                            try {
                                this.g = new Builder(((NVScanView) getView()).getContext()).setTrackingEnabled(false).setLandmarkType(0).setMode(0).build();
                                if (this.g.isOperational()) {
                                    SparseArray detect = new q(this.g).detect(new Frame.Builder().setBitmap(BitmapFactory.decodeFile(this.a.getScannedImage().getImagePath())).build());
                                    if (detect != null && detect.size() > 0) {
                                        this.i = true;
                                        selectionModel = this.h;
                                        boolean z3 = ((NVScanView) getView()).getRotationManager().isScreenPortrait() || ((NVScanView) getView()).getRotationManager().isTablet();
                                        this.c = a(selectionModel, z3);
                                        ((NVScanView) getView()).showHelp(this.c, false);
                                        return;
                                    }
                                }
                                throw new Exception("Detector dependencies are not yet available.");
                            } catch (Exception unused) {
                                z = true;
                                break;
                            }
                        }
                        break;
                    case TEMPLATEMATCHER:
                    case MANUAL:
                        break;
                    case FACE:
                        if (documentDataModel instanceof LivenessDataModel) {
                            Serializable serializable = (LivenessDataModel) documentDataModel;
                            DataAccess.update(((NVScanView) getView()).getContext(), LivenessDataModel.class, serializable);
                            if (!(serializable.getFrames() == null || serializable.getFrames().length == 0)) {
                                NVBackend.liveness(((NVScanView) getView()).getContext(), ((NVScanView) getView()).getCredentialsModel(), null, serializable.getFrames());
                                break;
                            }
                        }
                        break;
                }
            }
            z = false;
            this.cameraManager.stopPreview(true);
            this.mExtractionClient.cancel();
            if (z) {
                ((NVScanView) getView()).hideHelp();
                ((NVScanView) getView()).showConfirmation(this.a.getScannedImage().getExactImagePath(), false);
                this.f = GuiState.CONFIRMATION;
            } else if (this.e) {
                b(false);
            } else {
                q();
            }
        }
    }

    @InvokeOnUiThread
    public void onError(Throwable th) {
        super.onError(th);
    }

    protected void onScreenAngleChanged(ScreenAngle screenAngle) {
        String str;
        super.onScreenAngleChanged(screenAngle);
        switch (screenAngle) {
            case PORTRAIT:
                str = "P";
                break;
            case LANDSCAPE:
                str = "L";
                break;
            case INVERTED_LANDSCAPE:
                str = "IL";
                break;
            case INVERTED_PORTRAIT:
                str = "IP";
                break;
            default:
                str = "P";
                break;
        }
        JumioAnalytics.add(MobileEvents.userAction(JumioAnalytics.getSessionId(), null, UserAction.ORIENTATION_CHANGED, str));
    }

    public void addChildren(@NonNull ViewGroup viewGroup) {
        super.addChildren(viewGroup);
        this.d = viewGroup;
    }

    public boolean c() {
        return this.e;
    }

    public ScanSide d() {
        return this.a != null ? this.a.getSideToScan() : null;
    }

    public DocumentScanMode e() {
        return this.a != null ? this.a.getScanMode() : null;
    }

    public void f() {
        JumioAnalytics.add(MobileEvents.userAction(JumioAnalytics.getSessionId(), Screen.CONFIRMATION, UserAction.CONFIRM));
        if (this.e) {
            b(false);
        } else {
            q();
        }
    }

    public void g() {
        NVBackend.finalizeCall(((NVScanView) getView()).getContext(), ((NVScanView) getView()).getCredentialsModel(), null);
    }

    public void h() {
        JumioAnalytics.add(MobileEvents.userAction(JumioAnalytics.getSessionId(), Screen.CONFIRMATION, UserAction.RETRY));
        b();
    }

    private boolean a(SelectionModel selectionModel) {
        NfcController nfcController = ((NVScanView) getView()).getNfcController();
        DocumentDataModel documentInfo = this.a.getDocumentInfo();
        if (documentInfo == null || !nfcController.hasNfcFeature()) {
            return false;
        }
        String isoCode = selectionModel.getSelectedCountry().getIsoCode();
        if (!(documentInfo.getIssuingCountry() == null || documentInfo.getIssuingCountry().length() == 0)) {
            isoCode = documentInfo.getIssuingCountry();
        }
        String str = "";
        String substring;
        try {
            substring = documentInfo.getMrzData().getMrzLine1().substring(0, 2);
        } catch (Exception unused) {
            substring = str;
        }
        DocumentType documentTypeFor = this.n.getCountryModel().getDocumentTypeFor(isoCode, selectionModel.getSelectedDoctype().getId());
        if (documentTypeFor != null && documentTypeFor.hasEMRTD(substring) && this.a.getSideToScan() == documentTypeFor.getDocumentScanSide()) {
            return nfcController.hasRootCertificate(isoCode);
        }
        return false;
    }

    protected void a(NVScanPartModel nVScanPartModel, SelectionModel selectionModel) {
        Context context = ((NVScanView) getView()).getContext();
        DataAccess.delete(context, NVScanPartModel.class);
        if (selectionModel != null) {
            selectionModel.getUploadModel().replace(nVScanPartModel.getSideToScan(), nVScanPartModel);
            DataAccess.update(context, SelectionModel.class, (Serializable) selectionModel);
            return;
        }
        Log.w("ScanPresenter", "NVScanPresenter#storeScanPart(): Selection model was not found in persistence!!");
    }

    protected void i() {
        DocumentDataModel documentInfo = this.a.getDocumentInfo();
        if (documentInfo != null) {
            Bundle bundle = new Bundle();
            String issuingCountry = documentInfo.getIssuingCountry();
            if (issuingCountry == null && this.h != null) {
                issuingCountry = this.h.getSelectedCountry().getIsoCode();
            }
            if (issuingCountry != null) {
                issuingCountry = issuingCountry.toLowerCase();
            }
            InitiateModel initiateModel = (InitiateModel) DataAccess.load(((NVScanView) getView()).getContext(), InitiateModel.class);
            bundle.putString("country", issuingCountry);
            bundle.putString("idnumber", documentInfo.getIdNumber());
            long j = 0;
            bundle.putLong("dob", documentInfo.getDob() != null ? documentInfo.getDob().getTime() : 0);
            issuingCountry = "doe";
            if (documentInfo.getExpiryDate() != null) {
                j = documentInfo.getExpiryDate().getTime();
            }
            bundle.putLong(issuingCountry, j);
            bundle.putString("scanReference", initiateModel != null ? initiateModel.getJumioScanRef() : "");
            ((NVScanView) getView()).showNFC(bundle);
        }
    }

    private void q() {
        this.f = GuiState.LOADING;
        ((NVScanView) getView()).showLoading();
        if (this.h == null) {
            Log.w("ScanPresenter", "NVScanPresenter#extractDataAndClose(): data model cannot be null!");
            return;
        }
        if (this.h.getUploadModel().has(this.a.getSideToScan())) {
            this.h.getUploadModel().replace(this.a.getSideToScan(), this.a);
        } else {
            this.h.getUploadModel().add(this.a);
        }
        this.h.getUploadModel().setDocumentData(this.a.getSideToScan(), this.a.getDocumentInfo());
        DataAccess.update(((NVScanView) getView()).getContext(), SelectionModel.class, this.h);
        if (this.a.getScanMode() == DocumentScanMode.TEMPLATEMATCHER || this.a.getScanMode() == DocumentScanMode.CSSN) {
            this.l.startExtractData(this.h, this.a.getSideToScan());
        } else {
            this.l.startData();
        }
    }

    private void b(boolean z) {
        a(this.a, this.h);
        MerchantSettingsModel merchantSettingsModel = (MerchantSettingsModel) DataAccess.load(((NVScanView) getView()).getContext(), MerchantSettingsModel.class);
        if (merchantSettingsModel == null || this.h == null || this.h.getUploadModel() == null) {
            onError(new JumioException(NVErrorCase.OCR_LOADING_FAILED));
            return;
        }
        Object obj = null;
        Object obj2 = (merchantSettingsModel == null || !merchantSettingsModel.isEnableEMRTD()) ? null : 1;
        if (obj2 != null && a(this.h)) {
            obj = 1;
        }
        if (z) {
            this.l.startExtractData(this.h, ScanSide.FRONT);
        } else {
            this.l.startAddPart(this.h);
        }
        if (obj != null) {
            i();
        } else if (this.h.getUploadModel() == null || this.h.getUploadModel().allPartsScanned()) {
            if (this.h.getUploadModel().getExtractionMethod() == NVExtractionMethod.OCR) {
                for (NVScanPartModel nVScanPartModel : this.h.getUploadModel().getScans()) {
                    if (nVScanPartModel.getScanMode() == DocumentScanMode.TEMPLATEMATCHER || nVScanPartModel.getScanMode() == DocumentScanMode.CSSN) {
                        this.l.startExtractData(this.h, nVScanPartModel.getSideToScan());
                    }
                }
            }
            this.l.startData();
            ((NVScanView) getView()).scansComplete();
        } else {
            ((NVScanView) getView()).partComplete();
        }
    }

    public void j() {
        if (this.h.getUploadModel().hasNext()) {
            this.a = this.h.getUploadModel().nextPart();
            DataAccess.update(((NVScanView) getView()).getContext(), SelectionModel.class, this.h);
            DataAccess.update(((NVScanView) getView()).getContext(), NVScanPartModel.class, this.a);
        }
    }

    private NVDocumentMaskingType b(SelectionModel selectionModel) {
        if (!(this.n == null || this.n.getCountryModel() == null || selectionModel.getSelectedCountry() == null || selectionModel.getSelectedDoctype() == null)) {
            DocumentType documentTypeFor = this.n.getCountryModel().getDocumentTypeFor(selectionModel.getSelectedCountry().getIsoCode(), selectionModel.getSelectedDoctype().getId());
            if (documentTypeFor != null) {
                return documentTypeFor.getMaskingType();
            }
        }
        return NVDocumentMaskingType.NONE;
    }

    private boolean a(SelectionModel selectionModel, ScanSide scanSide) {
        NVDocumentMaskingType b = b(selectionModel);
        return b.toString().equalsIgnoreCase(scanSide.toString()) || b == NVDocumentMaskingType.BOTH;
    }

    private void r() {
        if (a(this.h, d())) {
            String externalString = this.h.getSelectedCountry().getIsoCode().equals("NLD") ? Strings.getExternalString(((NVScanView) getView()).getContext(), NVStrings.SCANVIEW_LEGAL_HINT_NLD) : this.h.getSelectedCountry().getIsoCode().equals("KOR") ? Strings.getExternalString(((NVScanView) getView()).getContext(), NVStrings.SCANVIEW_LEGAL_HINT_KOR) : null;
            ((NVScanView) getView()).showLegalHint(externalString);
        }
    }

    public void a(a aVar, boolean z) {
        boolean z2 = true;
        switch (aVar) {
            case HELP:
                if (this.f != GuiState.LOADING && this.h != null) {
                    this.c = a(this.h, z);
                    this.c.showFullscreen = false;
                    ((NVScanView) getView()).showHelp(this.c, true);
                    return;
                }
                return;
            case OVERLAY:
                if (this.mOverlay != null) {
                    this.mOverlay.calculate(this.a.getScanMode(), this.a.getFormat(), getExtractionArea());
                    this.mOverlay.prepareDraw(this.a.getSideToScan(), this.cameraManager.isFrontFacing(), z);
                    if (getView() != null) {
                        this.mOverlay.setVisible(((NVScanView) getView()).displayOverlay(z) ? 0 : 4);
                        ((NVScanView) getView()).invalidateDrawView(false);
                        return;
                    }
                    return;
                }
                return;
            case CONFIRMATION:
                if (this.f == GuiState.CONFIRMATION) {
                    ((NVScanView) getView()).showConfirmation(this.a.getScannedImage().getExactImagePath(), true);
                    return;
                }
                return;
            case BRANDING:
                if (this.f == GuiState.SCAN) {
                    if (this.n == null || !this.n.isBrandingEnabled()) {
                        z2 = false;
                    }
                    ((NVScanView) getView()).updateBranding(z2);
                    return;
                }
                ((NVScanView) getView()).updateBranding(false);
                return;
            default:
                return;
        }
    }

    public GuiState k() {
        return this.f;
    }

    public void a(GuiState guiState) {
        this.f = guiState;
    }

    public void a(boolean z) {
        if (e()) {
            this.f = z ? GuiState.HELP : GuiState.SCAN;
            boolean z2 = true;
            this.mExtractionClient.setDataExtractionActive(this.f == GuiState.SCAN);
            if (this.f == GuiState.SCAN) {
                if (this.c != null) {
                    PluginMode scanPluginMode;
                    MetaInfo metaInfo;
                    if (this.c.isUSDLFallback) {
                        this.j = false;
                        this.c.isUSDLFallback = false;
                        this.c.showFullscreen = false;
                        this.c.showFallback = false;
                        JumioAnalytics.add(MobileEvents.userAction(JumioAnalytics.getSessionId(), Screen.HELP, UserAction.FALLBACK));
                        ((NVScanView) getView()).showHelp(this.c, true);
                        scanPluginMode = getScanPluginMode();
                        metaInfo = new MetaInfo();
                        metaInfo.put(PendingOrderWrapper.SIDE, this.a.getSideToScan().toString());
                        metaInfo.put(Param.TYPE, scanPluginMode.toString());
                        JumioAnalytics.add(MobileEvents.pageView(JumioAnalytics.getSessionId(), Screen.SCAN, metaInfo));
                    } else if (this.c.isIdBackFaceDetected) {
                        this.i = false;
                        ((NVScanView) getView()).faceOnBackside();
                        b();
                    } else {
                        scanPluginMode = getScanPluginMode();
                        metaInfo = new MetaInfo();
                        metaInfo.put(PendingOrderWrapper.SIDE, this.a.getSideToScan().toString());
                        metaInfo.put(Param.TYPE, scanPluginMode.toString());
                        JumioAnalytics.add(MobileEvents.pageView(JumioAnalytics.getSessionId(), Screen.SCAN, metaInfo));
                    }
                }
                if (this.n == null || !this.n.isBrandingEnabled()) {
                    z2 = false;
                }
                ((NVScanView) getView()).updateBranding(z2);
            } else {
                if (!(this.c.isUSDLFallback || this.c.isIdBackFaceDetected)) {
                    JumioAnalytics.add(MobileEvents.pageView(JumioAnalytics.getSessionId(), Screen.HELP, null));
                }
                ((NVScanView) getView()).updateBranding(false);
            }
        }
    }

    public void l() {
        if (this.c == null) {
            return;
        }
        if (this.c.isUSDLFallback || this.c.isIdBackFaceDetected) {
            this.mOverlay = this.plugin.getOverlay(((NVScanView) getView()).getContext(), null);
            this.mOverlay.calculate(this.a.getScanMode(), this.a.getFormat(), getExtractionArea());
            boolean z = ((NVScanView) getView()).getRotationManager().isScreenPortrait() || ((NVScanView) getView()).getRotationManager().isTablet();
            this.mOverlay.prepareDraw(this.a.getSideToScan(), this.cameraManager.isFrontFacing(), z);
            this.mOverlay.setVisible(((NVScanView) getView()).displayOverlay(z) ? 0 : 4);
            ((NVScanView) getView()).invalidateDrawView(false);
        }
    }

    public void m() {
        NVBackend.forceRetry();
    }

    public void a(JumioException jumioException) {
        if (getView() != null && ((NVScanView) getView()).getContext() != null) {
            InitiateModel initiateModel = (InitiateModel) DataAccess.load(((NVScanView) getView()).getContext(), InitiateModel.class);
            if (jumioException != null && jumioException.getErrorCase() != null) {
                LocalBroadcastManager.getInstance(((NVScanView) getView()).getContext()).sendBroadcast(new a(jumioException.getErrorCase().code(), jumioException.getDetailedErrorCase(), jumioException.getErrorCase().localizedMessage(((NVScanView) getView()).getContext()), initiateModel != null ? initiateModel.getJumioScanRef() : null));
            }
        }
    }

    public boolean n() {
        return this.h.getSelectedDoctype().getDocumentScanSide() == this.a.getSideToScan() && (this.h.getSelectedDoctype().hasFallbackScan() || (this.e && this.a.getScanMode() == DocumentScanMode.PDF417));
    }

    public void o() {
        if (this.mExtractionClient != null && this.mExtractionClient.takePictureManually()) {
            this.mExtractionClient.takePicture();
        }
    }

    public void p() {
        if (!DocumentScanMode.CSSN.equals(this.a.getScanMode()) && !DocumentScanMode.MANUAL.equals(this.a.getScanMode())) {
            ScanSide sideToScan = this.a.getSideToScan();
            DocumentScanMode scanMode = this.a.getScanMode();
            int partIndex = this.a.getPartIndex();
            if (n() && getView() != null) {
                DocumentScanMode documentScanMode = this.h.getSelectedDoctype().hasFallbackScan() ? DocumentScanMode.CSSN : DocumentScanMode.LINEFINDER;
                this.mExtractionClient.setDataExtractionActive(false);
                this.mExtractionClient.destroy();
                if (this.h != null) {
                    if (this.h.getSelectedDoctype() != null) {
                        this.h.getSelectedDoctype().setDocumentScanMode(documentScanMode);
                        this.h.getSelectedDoctype().setDocumentScanSide(ScanSide.FRONT);
                    }
                    if (this.h.getUploadModel() != null) {
                        if (!this.e) {
                            this.a = new NVScanPartModel(ScanSide.FRONT, documentScanMode, scanMode.getFormat(), partIndex);
                            this.h.getUploadModel().remove(sideToScan);
                            this.h.getUploadModel().add(this.a);
                        } else if (sideToScan == ScanSide.FRONT) {
                            this.a = new NVScanPartModel(ScanSide.FRONT, documentScanMode, scanMode.getFormat(), partIndex);
                            this.h.getUploadModel().replace(sideToScan, this.a);
                        } else {
                            this.a = new NVScanPartModel(ScanSide.BACK, DocumentScanMode.LINEFINDER, scanMode.getFormat(), partIndex);
                            this.h.getUploadModel().replace(sideToScan, this.a);
                            if (this.h.getUploadModel().getScan(ScanSide.FRONT) != null) {
                                this.h.getUploadModel().getScan(ScanSide.FRONT).setScanMode(documentScanMode);
                            }
                        }
                        if (documentScanMode == DocumentScanMode.LINEFINDER && this.h.getUploadModel().getDocumentData() == null) {
                            this.h.getUploadModel().getScan(ScanSide.FRONT).setDocumentInfo(new DocumentDataModel());
                        }
                    }
                    DataAccess.update(((NVScanView) getView()).getContext(), SelectionModel.class, this.h);
                }
                boolean z = true;
                if (this.e && scanMode == DocumentScanMode.PDF417 && sideToScan != ScanSide.FRONT && this.h.getSelectedDoctype().getParts() == 1) {
                    this.a.setSkipped(true);
                    b(true);
                    return;
                }
                this.plugin = PluginRegistry.getPlugin(getScanPluginMode());
                this.mExtractionClient = this.plugin.getExtractionClient(((NVScanView) getView()).getContext());
                this.mExtractionClient.configure(this.a);
                this.mExtractionClient.subscribe(this);
                this.mExtractionClient.setFlags(((NVScanView) getView()).getRotationManager().isScreenPortrait(), ((NVScanView) getView()).getRotationManager().isTablet(), ((NVScanView) getView()).getRotationManager().isInverted());
                this.mExtractionClient.setPreviewProperties(this.mPreviewProperties);
                this.mExtractionClient.setExtractionArea(getExtractionArea());
                this.mExtractionClient.reinit();
                if (this.mOverlay != null) {
                    this.mOverlay.setVisible(8);
                    this.mOverlay = this.plugin.getOverlay(((NVScanView) getView()).getContext(), null);
                    this.mOverlay.addViews(this.d);
                    this.mOverlay.calculate(this.a.getScanMode(), this.a.getFormat(), getExtractionArea());
                    boolean z2 = ((NVScanView) getView()).getRotationManager().isScreenPortrait() || ((NVScanView) getView()).getRotationManager().isTablet();
                    this.mOverlay.prepareDraw(this.a.getSideToScan(), this.cameraManager.isFrontFacing(), z2);
                    this.mOverlay.setVisible(((NVScanView) getView()).displayOverlay(z2) ? 0 : 4);
                    ((NVScanView) getView()).invalidateDrawView(false);
                }
                SelectionModel selectionModel = this.h;
                boolean z3 = ((NVScanView) getView()).getRotationManager().isScreenPortrait() || ((NVScanView) getView()).getRotationManager().isTablet();
                this.c = a(selectionModel, z3);
                if (scanMode == DocumentScanMode.CNIS) {
                    this.c.initialScanMode = DocumentScanMode.CNIS;
                }
                ((NVScanView) getView()).showHelp(this.c, true);
                NVScanView nVScanView = (NVScanView) getView();
                if (this.n == null || !this.n.isBrandingEnabled()) {
                    z = false;
                }
                nVScanView.updateBranding(z);
                onUpdate(new ExtractionUpdate(ExtractionUpdateState.receiveClickListener, new b(this, null)));
            }
        }
    }

    public Rect getExtractionArea() {
        Rect extractionArea = super.getExtractionArea();
        if (getView() != null) {
            boolean z = ((NVScanView) getView()).getRotationManager().isScreenPortrait() || ((NVScanView) getView()).getRotationManager().isTablet();
            if (!(this.h == null || this.mPreviewProperties == null || (this.c != null && this.c.isPortrait == z))) {
                this.c = a(this.h, z);
            }
            extractionArea.bottom -= ((NVScanView) getView()).getHelpViewHeight(this.c != null ? this.c.helpViewStyle : HelpViewStyle.NONE);
        }
        return extractionArea;
    }

    private NVHelpConfiguration a(SelectionModel selectionModel, boolean z) {
        NVHelpConfiguration nVHelpConfiguration = new NVHelpConfiguration();
        if (selectionModel == null || selectionModel.getSelectedDoctype() == null) {
            return nVHelpConfiguration;
        }
        nVHelpConfiguration.documentType = selectionModel.getSelectedDoctype().getId();
        nVHelpConfiguration.documentVariant = selectionModel.getSelectedVariant();
        nVHelpConfiguration.scanMode = this.a.getScanMode();
        nVHelpConfiguration.side = this.a.getSideToScan();
        nVHelpConfiguration.part = this.a.getPartIndex() + 1;
        nVHelpConfiguration.totalParts = selectionModel.getUploadModel().getScans().size();
        nVHelpConfiguration.isUSDLFallback = this.j;
        nVHelpConfiguration.isIdBackFaceDetected = this.i;
        boolean z2 = false;
        boolean z3 = (!selectionModel.getSelectedDoctype().hasFallbackScan() || this.a.getScanMode() == DocumentScanMode.CSSN || this.a.getScanMode() == DocumentScanMode.LINEFINDER) ? false : true;
        nVHelpConfiguration.showFallback = z3;
        nVHelpConfiguration.isExpandable = true;
        nVHelpConfiguration.isPortrait = z;
        switch (this.a.getScanMode()) {
            case PDF417:
            case MRP:
            case MRV:
            case TD1:
            case TD2:
            case CNIS:
            case CSSN:
            case LINEFINDER:
            case TEMPLATEMATCHER:
                nVHelpConfiguration.isExpandable = true;
                z3 = nVHelpConfiguration.isUSDLFallback || nVHelpConfiguration.isIdBackFaceDetected;
                nVHelpConfiguration.showFullscreen = z3;
                if (nVHelpConfiguration.showFallback || nVHelpConfiguration.isUSDLFallback || nVHelpConfiguration.isIdBackFaceDetected || (this.e && this.a.getScanMode() == DocumentScanMode.PDF417)) {
                    z2 = true;
                }
                nVHelpConfiguration.showFallback = z2;
                nVHelpConfiguration.helpViewStyle = z ? HelpViewStyle.SMALL : HelpViewStyle.MICRO;
                break;
            case MANUAL:
                HelpViewStyle helpViewStyle;
                nVHelpConfiguration.isExpandable = false;
                if (z) {
                    helpViewStyle = HelpViewStyle.MINI;
                } else {
                    helpViewStyle = HelpViewStyle.NONE;
                }
                nVHelpConfiguration.helpViewStyle = helpViewStyle;
                break;
            case FACE:
                nVHelpConfiguration.showFullscreen = false;
                nVHelpConfiguration.showFallback = true;
                nVHelpConfiguration.isExpandable = false;
                nVHelpConfiguration.helpViewStyle = HelpViewStyle.NONE;
                break;
            default:
                nVHelpConfiguration.helpViewStyle = HelpViewStyle.NONE;
                break;
        }
        return nVHelpConfiguration;
    }
}
