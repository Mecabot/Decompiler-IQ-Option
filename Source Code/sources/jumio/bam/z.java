package jumio.bam;

import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.Looper;
import android.os.Vibrator;
import android.support.v4.content.LocalBroadcastManager;
import com.jumio.commons.camera.ImageData;
import com.jumio.commons.camera.PreviewProperties;
import com.jumio.commons.log.Log;
import com.jumio.core.data.document.DocumentScanMode;
import com.jumio.core.data.document.ScanSide;
import com.jumio.core.mvp.model.InvokeOnUiThread;
import com.jumio.core.mvp.model.Subscriber;
import com.jumio.core.plugins.PluginRegistry.PluginMode;
import com.jumio.persistence.DataAccess;
import com.jumio.sdk.exception.JumioException;
import com.jumio.sdk.extraction.ExtractionClient.ExtractionUpdate;
import com.jumio.sdk.extraction.ExtractionUpdateState;
import com.jumio.sdk.models.BaseScanPartModel;
import com.jumio.sdk.presentation.BaseScanPresenter;
import java.util.ArrayList;

/* compiled from: BamScanPresenter */
public class z extends BaseScanPresenter<ai, ExtractionUpdate, y> {
    protected j a;
    protected boolean b;
    protected JumioException c;
    protected ArrayList<String> d;
    private v e;
    private x f;
    private w g;
    private y h;
    private ConditionVariable i;

    /* compiled from: BamScanPresenter */
    class a implements Subscriber<String> {
        private a() {
        }

        /* synthetic */ a(z zVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        /* renamed from: a */
        public void onResult(String str) {
            if (!z.this.e()) {
            }
        }

        public void onError(Throwable th) {
            if (z.this.e()) {
                b.a(b.a(th) == null);
            }
        }
    }

    /* compiled from: BamScanPresenter */
    class b implements Subscriber<w> {
        private b() {
        }

        /* synthetic */ b(z zVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        /* renamed from: a */
        public void onResult(w wVar) {
            z.this.i.block();
            if (z.this.e()) {
                if (wVar != null) {
                    z.this.g = wVar;
                    z.this.d.add(wVar.a());
                } else {
                    z.this.g = new w();
                    z.this.d.add("");
                }
                b.a(z.this.g.b() ^ true);
                DataAccess.update(((ai) z.this.getView()).getContext(), w.class, z.this.g);
                z.this.mExtractionClient.setDataExtractionActive(true);
                z.this.a = j.SCAN;
                ((ai) z.this.getView()).updateBranding(z.this.g.d());
            }
        }

        public void onError(Throwable th) {
            z.this.i.block();
            if (z.this.e()) {
                th = b.a(th);
                b.a(th == null);
                z.this.g = new w();
                DataAccess.update(((ai) z.this.getView()).getContext(), w.class, z.this.g);
                if (th != null) {
                    z.this.onError(th);
                } else {
                    z.this.mExtractionClient.setDataExtractionActive(true);
                }
            }
        }
    }

    /* compiled from: BamScanPresenter */
    class c implements Subscriber<String> {
        private c() {
        }

        /* synthetic */ c(z zVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        /* renamed from: a */
        public void onResult(String str) {
            if (!z.this.e()) {
            }
        }

        public void onError(Throwable th) {
            if (z.this.e()) {
                b.a(b.a(th) == null);
            }
        }
    }

    public z() {
        this.a = j.STOP;
        this.b = false;
        this.c = null;
        this.d = null;
        this.d = new ArrayList();
        this.i = new ConditionVariable(false);
        this.e = new v(ScanSide.FRONT, DocumentScanMode.CREDIT);
    }

    protected void onStart() {
        super.onStart();
        this.i.open();
    }

    public void onPreviewAvailable(PreviewProperties previewProperties) {
        super.onPreviewAvailable(previewProperties);
        this.mExtractionClient.setDataExtractionActive(this.g != null);
    }

    protected BaseScanPartModel getScanPartModel() {
        return this.e;
    }

    protected PluginMode getScanPluginMode() {
        return PluginMode.CARD;
    }

    protected boolean startCameraFrontfacing() {
        return this.f.l();
    }

    protected boolean canSwitchCamera() {
        return this.cameraManager.hasMultipleCameras();
    }

    protected boolean enableFlashOnStart() {
        return this.f.i();
    }

    public y a() {
        if (this.h == null) {
            this.h = new y();
        }
        return this.h;
    }

    protected void onCreate() {
        DataAccess.delete(((ai) getView()).getContext(), w.class);
        if (this.f == null) {
            this.f = (x) DataAccess.load(((ai) getView()).getContext(), x.class);
            if (this.f == null) {
                ((ai) getView()).onError(new IllegalStateException("Settings model not present! Be sure to persist it before scanning!"));
                return;
            }
        }
        super.onCreate();
        this.d.clear();
        b.a(((ai) getView()).getContext(), ((ai) getView()).d(), this.f, new b(this, null));
    }

    protected void onStop() {
        super.onStop();
        DataAccess.update(((ai) getView()).getContext(), v.class, this.e);
        DataAccess.delete(((ai) getView()).getContext(), w.class);
    }

    /* renamed from: a */
    public void onUpdate(final ExtractionUpdate extractionUpdate) {
        if (extractionUpdate != null && e()) {
            int state = extractionUpdate.getState();
            if (state == ExtractionUpdateState.shotTaken) {
                ((ai) getView()).c();
                this.cameraManager.stopPreview(true);
                this.mOrientationListener.disable();
                if (this.f.g()) {
                    try {
                        ((Vibrator) ((ai) getView()).getContext().getSystemService("vibrator")).vibrate(100);
                    } catch (Exception unused) {
                        if (this.f.j() != -1) {
                            try {
                                MediaPlayer create = MediaPlayer.create(((ai) getView()).getContext(), this.f.j());
                                create.setOnCompletionListener(new OnCompletionListener() {
                                    public void onCompletion(MediaPlayer mediaPlayer) {
                                        mediaPlayer.release();
                                    }
                                });
                                create.start();
                            } catch (Exception unused2) {
                            }
                        }
                    }
                }
            } else if (state == ExtractionUpdateState.notifyFlash) {
                this.cameraManager.requestFlashHint(((Boolean) extractionUpdate.getData()).booleanValue());
            } else if (state == ExtractionUpdateState.notifyFocus) {
                this.cameraManager.requestFocus();
            } else if (state == l.b) {
                byte[] bArr = (byte[]) extractionUpdate.getData();
                ImageData imageData = new ImageData();
                this.cameraManager.getImageData(imageData);
                b.a(((ai) getView()).getContext(), ((ai) getView()).d(), imageData, this.g.a(), new a(this, null), bArr);
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public void run() {
                        if (z.this.mOverlay != null) {
                            z.this.mOverlay.update(extractionUpdate);
                            ((ai) z.this.getView()).invalidateDrawView(false);
                        }
                    }
                });
            }
        }
    }

    /* renamed from: a */
    public void onResult(y yVar) {
        Log.d("BamScanPresenter", "onResult");
        if (this.a != j.ADDITIONAL_ENTRY && e()) {
            if (yVar.f() && this.c == null) {
                this.h = yVar;
                this.cameraManager.stopPreview(true);
                aa.c();
                b.a(((ai) getView()).getContext(), ((ai) getView()).d(), this.f, yVar, this.g.a(), new c(this, null));
                if (((ai) getView()).a(yVar, this.f)) {
                    ((ai) getView()).b(yVar, this.f);
                    this.a = j.ADDITIONAL_ENTRY;
                } else {
                    a(false, false);
                }
            } else if (this.c != null && (this.c.getErrorCase() == i.CREDIT_CARD_EXPIRED || this.c.getErrorCase() == i.CREDIT_CARD_NOT_SUPPORTED)) {
                b.a(((ai) getView()).getContext(), ((ai) getView()).d(), this.f, yVar, this.g.a(), new c(this, null));
            }
        }
    }

    public ArrayList<String> b() {
        return this.d;
    }

    public void c() {
        if (this.c == null || this.c.getErrorCase().retry()) {
            this.c = null;
            this.b = false;
            this.a = j.INIT;
            this.mOrientationListener.enable();
            this.mExtractionClient.setDataExtractionActive(false);
            onStart();
            ((ai) getView()).updateCameraControls(canSwitchCamera(), this.cameraManager.isFlashSupported());
            if (this.g != null) {
                ((ai) getView()).updateBranding(this.g.d());
            }
            DataAccess.delete(((ai) getView()).getContext(), w.class);
            b.a(((ai) getView()).getContext(), ((ai) getView()).d(), this.f, new b(this, null));
            this.mExtractionClient.reinit();
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Retry not possible after receiving error: ");
        stringBuilder.append(this.c.getErrorCase().code());
        throw new UnsupportedOperationException(stringBuilder.toString());
    }

    public void a(boolean z, boolean z2) {
        if (!this.b) {
            Intent aVar;
            this.b = true;
            if (z) {
                if (z2) {
                    this.c = new JumioException(i.CANCEL_TYPE_BACKGROUND, 0);
                } else if (this.c == null) {
                    this.c = new JumioException(i.CANCEL_TYPE_USER, 0);
                }
                aVar = new a(this.c.getErrorCase().code(), this.c.getDetailedErrorCase(), this.c.getErrorCase().localizedMessage(((ai) getView()).getContext()), new ArrayList(this.d));
            } else {
                if (this.h != null) {
                    b.a(((ai) getView()).getContext(), ((ai) getView()).d(), this.h, this.g.a());
                }
                aVar = new a(this.h != null ? this.h.a() : null, new ArrayList(this.d));
            }
            DataAccess.delete(((ai) getView()).getContext(), w.class);
            DataAccess.delete(((ai) getView()).getContext(), v.class);
            DataAccess.delete(((ai) getView()).getContext(), x.class);
            DataAccess.delete(((ai) getView()).getContext(), y.class);
            LocalBroadcastManager.getInstance(((ai) getView()).getContext()).sendBroadcast(aVar);
            this.d.clear();
            b.a();
        }
    }

    public void onCameraError(Throwable th) {
        onError(new JumioException(i.NO_CAMERA_CONNECTION, 0));
    }

    @InvokeOnUiThread
    public void onError(Throwable th) {
        if (e() && this.a != j.ADDITIONAL_ENTRY) {
            this.a = j.ERROR;
            th.printStackTrace();
            this.cameraManager.stopPreview(true);
            if (th instanceof JumioException) {
                this.c = (JumioException) th;
            }
            super.onError(th);
        }
    }
}
