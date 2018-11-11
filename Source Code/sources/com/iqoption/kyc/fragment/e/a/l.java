package com.iqoption.kyc.fragment.e.a;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager.OnBackStackChangedListener;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.common.util.concurrent.o;
import com.iqoption.d.ob;
import com.iqoption.dto.entity.result.KycState;
import com.iqoption.kyc.a.b;
import com.iqoption.kyc.a.d;
import com.iqoption.kyc.c;
import com.iqoption.kyc.i;
import com.iqoption.mobbtech.connect.response.MobbErrorException;
import com.iqoption.util.ac;
import com.iqoption.util.am;
import com.iqoption.x.R;

/* compiled from: KycRisksFragment2 */
public class l extends Fragment implements b {
    public static final String TAG = "com.iqoption.kyc.fragment.e.a.l";
    private am adG;
    @Nullable
    private c cJI;
    private com.iqoption.util.am.a cKG = new com.iqoption.util.am.a() {
        public void cp(boolean z) {
            if (z && l.this.isAdded() && ac.c(l.this.getFragmentManager(), l.TAG)) {
                am.n(l.this.zzakw());
            }
        }
    };
    private OnBackStackChangedListener cKO;
    private ob cMV;
    @Nullable
    private String cMW;

    /* compiled from: KycRisksFragment2 */
    private class a extends com.iqoption.system.c.b<l, Pair<String, String>> {
        public a(l lVar) {
            super((Object) lVar);
        }

        /* renamed from: a */
        public void z(l lVar, Pair<String, String> pair) {
            super.z(lVar, pair);
            lVar.dK(false);
            lVar.cMW = (String) pair.first;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<font color='#ffffff'>");
            stringBuilder.append(lVar.cMW);
            stringBuilder.append("</font>");
            i.a((AppCompatActivity) lVar.zzakw(), Html.fromHtml(stringBuilder.toString()));
            stringBuilder = new StringBuilder();
            stringBuilder.append("<html><head><style type=\"text/css\">body{color: #fff; background-color: rgba(0,0,0,0);} ol li { list-style-type: none; }</style></head><body>");
            stringBuilder.append((String) pair.second);
            stringBuilder.append("</body></html>");
            lVar.cMV.EM.loadData(stringBuilder.toString(), "text/html; charset=utf-8", null);
        }

        /* renamed from: a */
        public void c(l lVar, Throwable th) {
            super.c(lVar, th);
            lVar.dK(false);
            MobbErrorException.D(th);
        }
    }

    @NonNull
    public String apR() {
        return "TradingExperience";
    }

    @NonNull
    public String apS() {
        return "RiskDisclosure";
    }

    public boolean apT() {
        return false;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        bundle = getArguments();
        if (bundle != null) {
            this.cJI = new c(getContext(), (KycState) bundle.getParcelable("ARG_KYC_STATE"));
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.cMV = (ob) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_kyc_risks, viewGroup, false);
        apX();
        this.cKO = new d(this, getContext(), com.iqoption.kyc.a.a.apP(), getFragmentManager(), this.cJI.Dh(), apR(), apS(), TAG) {
            private boolean cMY;
            final /* synthetic */ l cNr;

            protected void apV() {
                super.apV();
                this.cMY = true;
                this.cNr.apX();
            }

            protected void apW() {
                super.apW();
                if (this.cMY && this.cNr.cJI != null) {
                    com.iqoption.kyc.a.a.c(this.cNr.getContext(), this.cNr.apR(), this.cNr.apS(), this.cNr.cJI.Dh());
                }
                this.cMY = false;
            }
        };
        getFragmentManager().addOnBackStackChangedListener(this.cKO);
        this.adG = new am(zzakw());
        this.cMV.EM.setBackgroundColor(0);
        this.cMV.EM.setLayerType(1, null);
        this.cMV.EM.setWebViewClient(new WebViewClient() {
            public void onPageFinished(WebView webView, String str) {
                l.this.cMV.EM.setBackgroundColor(0);
                l.this.cMV.EM.setLayerType(1, null);
                l.this.cMV.EM.loadUrl("javascript:document.body.style.setProperty(\"color\", \"white\");");
            }
        });
        dK(true);
        o.a(this.cJI.aoG(), new a(this), com.iqoption.core.d.a.aSe);
        return this.cMV.getRoot();
    }

    private void apX() {
        CharSequence fromHtml;
        StringBuilder stringBuilder;
        if (TextUtils.isEmpty(this.cMW)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("<font color='#ffffff'>");
            stringBuilder.append(getString(R.string.kyc_risk_disclosure));
            stringBuilder.append("</font>");
            fromHtml = Html.fromHtml(stringBuilder.toString());
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append("<font color='#ffffff'>");
            stringBuilder.append(this.cMW);
            stringBuilder.append("</font>");
            fromHtml = Html.fromHtml(stringBuilder.toString());
        }
        i.b((AppCompatActivity) zzakw(), this.cMV.bxz.toolbar, fromHtml);
    }

    public void onStart() {
        super.onStart();
        am.a(this.cKG);
    }

    public void onStop() {
        super.onStop();
        am.b(this.cKG);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public void onDestroyView() {
        com.iqoption.core.i.d(TAG, "onDestroyView");
        getFragmentManager().removeOnBackStackChangedListener(this.cKO);
        super.onDestroyView();
    }

    private void dK(boolean z) {
        this.cMV.bnn.setVisibility(z ? 0 : 8);
    }
}
