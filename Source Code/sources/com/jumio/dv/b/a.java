package com.jumio.dv.b;

import android.os.Handler;
import android.support.v4.content.LocalBroadcastManager;
import com.jumio.commons.log.Log;
import com.jumio.core.mvp.model.Subscriber;
import com.jumio.core.mvp.presenter.Presenter;
import com.jumio.dv.api.calls.DvBackend;
import com.jumio.dv.models.DvScanPartModel;
import com.jumio.dv.view.interactors.CompleteView;
import com.jumio.persistence.DataAccess;
import com.jumio.sdk.exception.JumioException;

/* compiled from: CompletePresenter */
public class a extends Presenter<CompleteView> implements Subscriber<Object> {
    private a a;

    /* compiled from: CompletePresenter */
    private class a implements Subscriber<String> {
        private a() {
        }

        /* renamed from: a */
        public void onResult(final String str) {
            if (a.this.b()) {
                Log.d("CompletePresenter", "complete call finished");
                ((CompleteView) a.this.getView()).uploadComplete();
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        a.this.a(str);
                    }
                }, 2000);
            }
        }

        public void onError(Throwable th) {
            if (a.this.b()) {
                Log.d("CompletePresenter", "finalize call finished");
                a.this.onError(DvBackend.errorFromThrowable(((CompleteView) a.this.getView()).getContext(), th, com.jumio.dv.api.calls.a.class));
            }
        }
    }

    public void onResult(Object obj) {
    }

    protected void onStop() {
    }

    protected void onStart() {
        Log.i("CompletePresenter", "registering for updates");
        this.a = new a();
        DvBackend.complete(((CompleteView) getView()).getContext(), ((CompleteView) getView()).getCredentialsModel(), ((DvScanPartModel) DataAccess.load(((CompleteView) getView()).getContext(), DvScanPartModel.class)).getScannedImage(), this.a);
    }

    public void onError(Throwable th) {
        if (b()) {
            ((CompleteView) getView()).onError(th);
        }
    }

    protected void a(String str) {
        if (b()) {
            LocalBroadcastManager.getInstance(((CompleteView) getView()).getContext()).sendBroadcast(new com.jumio.dv.a(str));
        }
    }

    public void a(JumioException jumioException) {
        LocalBroadcastManager.getInstance(((CompleteView) getView()).getContext()).sendBroadcast(new com.jumio.dv.a(jumioException.getErrorCase().code(), jumioException.getDetailedErrorCase(), jumioException.getErrorCase().localizedMessage(((CompleteView) getView()).getContext())));
    }

    public void a() {
        DvBackend.complete(((CompleteView) getView()).getContext(), ((CompleteView) getView()).getCredentialsModel(), ((DvScanPartModel) DataAccess.load(((CompleteView) getView()).getContext(), DvScanPartModel.class)).getScannedImage(), this.a);
    }
}
