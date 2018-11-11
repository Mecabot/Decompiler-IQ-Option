package jumio.nv.core;

import android.content.Context;
import android.os.Handler;
import android.support.v4.content.LocalBroadcastManager;
import com.jumio.commons.log.Log;
import com.jumio.core.data.document.ScanSide;
import com.jumio.core.mvp.model.InvokeOnUiThread;
import com.jumio.core.mvp.model.Subscriber;
import com.jumio.core.mvp.presenter.Presenter;
import com.jumio.nv.NetverifyDocumentData;
import com.jumio.nv.api.calls.NVBackend;
import com.jumio.nv.api.helpers.UploadManager;
import com.jumio.nv.models.InitiateModel;
import com.jumio.nv.models.OfflineDataModel;
import com.jumio.nv.models.SelectionModel;
import com.jumio.nv.models.UploadDataModel;
import com.jumio.nv.view.interactors.UploadView;
import com.jumio.persistence.DataAccess;
import com.jumio.sdk.exception.JumioException;
import com.jumio.sdk.models.CredentialsModel;

/* compiled from: UploadPresenter */
public class z extends Presenter<UploadView> {
    static final /* synthetic */ boolean a = true;
    private UploadManager b;
    private b c;
    private a d;

    /* compiled from: UploadPresenter */
    class a implements Subscriber<Void> {
        private a() {
        }

        /* synthetic */ a(z zVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        /* renamed from: a */
        public void onResult(Void voidR) {
            if (z.this.b()) {
                Log.d("UploadPresenter", "finalize call finished");
                ((UploadView) z.this.getView()).uploadComplete();
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        z.this.a();
                    }
                }, (long) ((UploadView) z.this.getView()).getCloseDelay());
            }
        }

        public void onError(Throwable th) {
            if (z.this.b()) {
                Log.d("UploadPresenter", "finalize call finished");
                z.this.b.onError(th, g.class);
            }
        }
    }

    /* compiled from: UploadPresenter */
    class b implements Subscriber<String> {
        private b() {
        }

        /* synthetic */ b(z zVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        @InvokeOnUiThread
        /* renamed from: a */
        public void onResult(String str) {
            if (!z.this.b()) {
            }
        }

        @InvokeOnUiThread
        public void onError(Throwable th) {
            if (z.this.b()) {
                z.this.b.onError(th, h.class);
            }
        }
    }

    protected void onStart() {
        Log.i("UploadPresenter", "registering for updates");
        SelectionModel selectionModel = (SelectionModel) DataAccess.load(((UploadView) getView()).getContext(), SelectionModel.class);
        if (selectionModel != null) {
            Context context = ((UploadView) getView()).getContext();
            ScanSide sideToScan = selectionModel.getUploadModel().getActivePart().getSideToScan();
            CredentialsModel credentialsModel = ((UploadView) getView()).getCredentialsModel();
            boolean z = (selectionModel == null || !selectionModel.isVerificationRequired()) ? false : a;
            this.b = new UploadManager(context, sideToScan, credentialsModel, z);
            this.b.add(new Subscriber<Boolean>() {
                /* renamed from: a */
                public void onResult(Boolean bool) {
                }

                public void onError(Throwable th) {
                    if (z.this.b()) {
                        ((UploadView) z.this.getView()).onError(th);
                    }
                }
            });
            this.b.addSubscribers();
            this.c = new b(this, null);
            NVBackend.registerForUpdates(((UploadView) getView()).getContext(), h.class, this.c);
            this.d = new a(this, null);
            NVBackend.registerForUpdates(((UploadView) getView()).getContext(), g.class, this.d);
            NVBackend.forceRetry();
        }
    }

    protected void onStop() {
        Log.i("UploadPresenter", "unregistering from updates");
        NVBackend.unregisterFromUpdates(g.class, this.d);
        NVBackend.unregisterFromUpdates(g.class, this.c);
    }

    protected void a() {
        if (b()) {
            SelectionModel selectionModel = (SelectionModel) DataAccess.load(((UploadView) getView()).getContext(), SelectionModel.class);
            NetverifyDocumentData netverifyDocumentData = new NetverifyDocumentData();
            if (a || selectionModel != null) {
                UploadDataModel uploadModel = selectionModel.getUploadModel();
                selectionModel.populateData(netverifyDocumentData);
                if (uploadModel.getDocumentData() != null) {
                    uploadModel.getDocumentData().populateData(netverifyDocumentData, selectionModel);
                }
                OfflineDataModel offlineDataModel = (OfflineDataModel) DataAccess.load(((UploadView) getView()).getContext(), OfflineDataModel.class);
                if (offlineDataModel != null) {
                    offlineDataModel.populateData(netverifyDocumentData);
                }
                netverifyDocumentData.setExtractionMethod(uploadModel.getExtractionMethod());
                InitiateModel initiateModel = (InitiateModel) DataAccess.load(((UploadView) getView()).getContext(), InitiateModel.class);
                LocalBroadcastManager.getInstance(((UploadView) getView()).getContext()).sendBroadcast(new a(netverifyDocumentData, initiateModel != null ? initiateModel.getJumioScanRef() : null));
                return;
            }
            throw new AssertionError();
        }
    }

    public void b() {
        NVBackend.forceRetry();
    }

    public void a(JumioException jumioException) {
        InitiateModel initiateModel = (InitiateModel) DataAccess.load(((UploadView) getView()).getContext(), InitiateModel.class);
        LocalBroadcastManager.getInstance(((UploadView) getView()).getContext()).sendBroadcast(new a(jumioException.getErrorCase().code(), jumioException.getDetailedErrorCase(), jumioException.getErrorCase().localizedMessage(((UploadView) getView()).getContext()), initiateModel != null ? initiateModel.getJumioScanRef() : null));
    }
}
