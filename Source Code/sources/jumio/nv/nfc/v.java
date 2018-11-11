package jumio.nv.nfc;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.support.annotation.NonNull;
import com.jumio.analytics.JumioAnalytics;
import com.jumio.analytics.MobileEvents;
import com.jumio.analytics.Screen;
import com.jumio.analytics.UserAction;
import com.jumio.commons.log.Log;
import com.jumio.core.data.Strings;
import com.jumio.core.data.document.DocumentScanMode;
import com.jumio.core.mvp.model.InvokeOnUiThread;
import com.jumio.core.mvp.model.PublisherWithUpdate;
import com.jumio.core.mvp.model.SubscriberWithUpdate;
import com.jumio.core.mvp.presenter.Presenter;
import com.jumio.nv.NetverifyDocumentData;
import com.jumio.nv.NetverifyMrzData;
import com.jumio.nv.api.calls.NVBackend;
import com.jumio.nv.data.NVStrings;
import com.jumio.nv.enums.EMRTDStatus;
import com.jumio.nv.extraction.NfcController;
import com.jumio.nv.models.DocumentDataModel;
import com.jumio.nv.models.NVScanPartModel;
import com.jumio.nv.models.SelectionModel;
import com.jumio.nv.models.UploadDataModel;
import com.jumio.nv.nfc.core.communication.TagAccessSpec;
import com.jumio.persistence.DataAccess;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import org.jmrtd.lds.icao.MRZInfo;

/* compiled from: NfcPresenter */
public class v extends Presenter<u> {
    private TagAccessSpec a = new TagAccessSpec();
    private ArrayList<o> b;
    private String c;
    private n d;
    private Bitmap e;
    private NfcController f;
    private a g = new a(this, null);

    /* compiled from: NfcPresenter */
    class a implements SubscriberWithUpdate<o, o> {
        private boolean b;
        private String c;

        private a() {
            this.c = null;
        }

        /* synthetic */ a(v vVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        @InvokeOnUiThread
        /* renamed from: a */
        public void onUpdate(o oVar) {
            if (v.this.e()) {
                if (oVar.a() == p.INIT) {
                    this.b = false;
                    f.a("NfcPresenter", "onStarted");
                    v.this.b = new ArrayList();
                    this.c = null;
                    ((u) v.this.getView()).c();
                    JumioAnalytics.add(MobileEvents.userAction(JumioAnalytics.getSessionId(), Screen.SCAN, UserAction.NFC_EXTRACTION_STARTED));
                } else {
                    int ordinal;
                    v.this.b.add(oVar);
                    switch (oVar.a()) {
                        case BAC_CHECK:
                        case READ_LDS:
                        case PASSIVE_AUTH_DSC_CHECK:
                        case PASSIVE_AUTH_ROOT_CERT_CHECK:
                        case PASSIVE_AUTH_HASH_CHECK:
                        case ACTIVE_AUTH_CHECK:
                        case ADDITIONAL_DATA:
                        case FACE_IMAGE:
                            ordinal = oVar.a().ordinal();
                            break;
                        default:
                            ordinal = p.values().length;
                            break;
                    }
                    ((u) v.this.getView()).a(ordinal);
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("onProgressUpdate: ");
                    stringBuilder.append(oVar.toString());
                    f.a("NfcPresenter", stringBuilder.toString());
                    if (oVar.a() == p.READ_LDS) {
                        v.this.c = (String) oVar.g();
                        if (v.this.c != null) {
                            ordinal = v.this.c.length() / 2;
                            String substring = v.this.c.substring(0, ordinal);
                            String substring2 = v.this.c.substring(ordinal);
                            StringBuilder stringBuilder2 = new StringBuilder();
                            stringBuilder2.append("MRZ line 1: ");
                            stringBuilder2.append(substring);
                            Log.i("NfcPresenter", stringBuilder2.toString());
                            StringBuilder stringBuilder3 = new StringBuilder();
                            stringBuilder3.append("MRZ line 2: ");
                            stringBuilder3.append(substring2);
                            Log.i("NfcPresenter", stringBuilder3.toString());
                        }
                    }
                    if (oVar.a() == p.FACE_IMAGE && oVar.b() == q.SUCCESSFUL) {
                        v.this.e = (Bitmap) oVar.g();
                    }
                    if (oVar.a() == p.ADDITIONAL_DATA) {
                        v.this.d = (n) oVar.g();
                    }
                }
            }
        }

        @InvokeOnUiThread
        /* renamed from: b */
        public void onResult(o oVar) {
            f.a("NfcPresenter", "onComplete");
            if (!this.b) {
                StringBuilder stringBuilder = new StringBuilder("NFC Scan results\n");
                Iterator it = v.this.b.iterator();
                while (it.hasNext()) {
                    stringBuilder.append(((o) it.next()).toString());
                    stringBuilder.append("\n");
                }
                if (v.this.d != null) {
                    stringBuilder.append("\n");
                    stringBuilder.append(v.this.d.toString());
                }
                if (v.this.c != null) {
                    stringBuilder.append("\n");
                    stringBuilder.append(v.this.c);
                }
                f.a("NfcPresenter", stringBuilder.toString());
                final t tVar = new t(v.this.b, v.this.d, v.this.c);
                v.this.a(tVar);
                if (v.this.e()) {
                    ((u) v.this.getView()).d();
                    Serializable serializable = (SelectionModel) DataAccess.load(((u) v.this.getView()).getContext(), SelectionModel.class);
                    NetverifyDocumentData netverifyDocumentData = null;
                    UploadDataModel uploadModel = serializable != null ? serializable.getUploadModel() : null;
                    if (uploadModel != null) {
                        netverifyDocumentData = uploadModel.getDocumentData();
                    }
                    if (!(netverifyDocumentData == null || tVar.b() == null)) {
                        n b = tVar.b();
                        MRZInfo c = b.c();
                        NetverifyMrzData mrzData = netverifyDocumentData.getMrzData();
                        mrzData.setMrzLine1(c.getMrzLine1());
                        mrzData.setMrzLine2(c.getMrzLine2());
                        mrzData.setMrzLine3(c.getMrzLine3());
                        if (!(b.a() == null || b.a().h == null)) {
                            netverifyDocumentData.setIssuingDate(b.a().h);
                        }
                        netverifyDocumentData.setEMRTDStatus(tVar.getVerificationStatus());
                        netverifyDocumentData.setPlaceOfBirth(tVar.getPlaceOfBirth());
                        uploadModel.setMrtdData(tVar, true);
                    }
                    DataAccess.update(((u) v.this.getView()).getContext(), SelectionModel.class, serializable);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            v.this.a(tVar.getVerificationStatus());
                        }
                    }, 2000);
                }
            }
        }

        @InvokeOnUiThread
        public void onError(Throwable th) {
            if (th instanceof o) {
                o oVar = (o) th;
                this.b = true;
                this.c = oVar.toString();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onError: ");
                stringBuilder.append(oVar.toString());
                f.a("NfcPresenter", stringBuilder.toString());
                Serializable serializable = (SelectionModel) DataAccess.load(((u) v.this.getView()).getContext(), SelectionModel.class);
                DocumentDataModel documentDataModel = null;
                UploadDataModel uploadModel = serializable != null ? serializable.getUploadModel() : null;
                if (uploadModel != null) {
                    documentDataModel = uploadModel.getDocumentData();
                }
                if (documentDataModel != null) {
                    uploadModel.setMrtdData(new t(v.this.b, v.this.d, v.this.c), false);
                }
                DataAccess.update(((u) v.this.getView()).getContext(), SelectionModel.class, serializable);
                ((u) v.this.getView()).a(oVar);
            }
        }
    }

    public void a(String str) {
    }

    protected void onStop() {
    }

    protected void onCreate() {
        this.f = ((u) getView()).b();
        this.f.setTagAccess(this.a);
        if (!this.f.isNfcEnabled()) {
            c();
        }
        if (this.f instanceof PublisherWithUpdate) {
            ((PublisherWithUpdate) this.f).subscribe(this.g);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onCreate() ");
        stringBuilder.append(hashCode());
        Log.d("NfcPresenter", stringBuilder.toString());
    }

    protected void onDestroy() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onDestroy() ");
        stringBuilder.append(hashCode());
        Log.d("NfcPresenter", stringBuilder.toString());
        if (this.f instanceof PublisherWithUpdate) {
            ((PublisherWithUpdate) this.f).unsubscribe(this.g);
        }
        if (this.e != null) {
            this.e.recycle();
            this.e = null;
        }
    }

    protected void onStart() {
        a(this.f.isNfcEnabled());
    }

    public TagAccessSpec a() {
        return this.a;
    }

    public void a(@NonNull TagAccessSpec tagAccessSpec) {
        this.a = tagAccessSpec;
    }

    public void a(boolean z) {
        this.f.setEnabled(z);
    }

    public void a(EMRTDStatus eMRTDStatus) {
        if (e()) {
            Serializable serializable = (SelectionModel) DataAccess.load(((u) getView()).getContext(), SelectionModel.class);
            serializable.getUploadModel().getDocumentData().setEMRTDStatus(eMRTDStatus);
            DataAccess.update(((u) getView()).getContext(), SelectionModel.class, serializable);
            if (serializable.getUploadModel().hasNext()) {
                DataAccess.update(((u) getView()).getContext(), NVScanPartModel.class, serializable.getUploadModel().nextPart());
                DataAccess.update(((u) getView()).getContext(), SelectionModel.class, serializable);
                ((u) getView()).a(false);
            } else {
                NVBackend.data(((u) getView()).getContext(), ((u) getView()).a(), null);
                NVBackend.finalizeCall(((u) getView()).getContext(), ((u) getView()).a(), null);
                ((u) getView()).a(true);
            }
        }
    }

    public DocumentScanMode b() {
        SelectionModel selectionModel = (SelectionModel) DataAccess.load(((u) getView()).getContext(), SelectionModel.class);
        return selectionModel != null ? selectionModel.getSelectedDoctype().getDocumentScanMode() : null;
    }

    private void a(t tVar) {
        String str = "NfcFragment";
        if (tVar == null) {
            f.c(str, "no MrtdScanResult present");
            return;
        }
        for (o oVar : tVar.a()) {
            if (oVar == null) {
                f.c(str, "result missing!");
            } else {
                f.a(str, oVar.h());
            }
        }
        if (tVar.b() != null) {
            f.a(str, tVar.b().toString());
        } else {
            f.c(str, "no additional data present!");
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MRZ: ");
        stringBuilder.append(tVar.getMrzString());
        f.a(str, stringBuilder.toString());
    }

    private void c() {
        if (this.f.hasNfcFeature() && !this.f.isNfcEnabled()) {
            final Context context = ((u) getView()).getContext();
            new Builder(context, 5).setTitle(Strings.getExternalString(context, NVStrings.NFC_ENABLE_DIALOG_TITLE)).setMessage(Strings.getExternalString(context, NVStrings.NFC_ENABLE_DIALOG_TEXT)).setPositiveButton(17039379, new OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    context.startActivity(new Intent("android.settings.NFC_SETTINGS"));
                }
            }).setNegativeButton(17039369, new OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    JumioAnalytics.add(MobileEvents.userAction(JumioAnalytics.getSessionId(), Screen.ERROR, UserAction.CANCEL));
                    v.this.a(EMRTDStatus.NOT_PERFORMED);
                }
            }).show();
        }
    }
}
