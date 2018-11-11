package com.iqoption.kyc.fragment.d;

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
import com.iqoption.kyc.c;
import com.iqoption.kyc.i;
import com.iqoption.mobbtech.connect.response.MobbErrorException;
import com.iqoption.util.ac;
import com.iqoption.util.am;
import com.iqoption.x.R;

/* compiled from: KycRisksFragment */
public class d extends Fragment implements b {
    public static final String TAG = "com.iqoption.kyc.fragment.d.d";
    private am adG;
    @Nullable
    private c cJI;
    private com.iqoption.util.am.a cKG = new com.iqoption.util.am.a() {
        public void cp(boolean z) {
            if (z && d.this.isAdded() && ac.c(d.this.getFragmentManager(), d.TAG)) {
                am.n(d.this.zzakw());
            }
        }
    };
    private OnBackStackChangedListener cKO;
    private ob cMV;
    @Nullable
    private String cMW;

    /* compiled from: KycRisksFragment */
    private class a extends com.iqoption.system.c.b<d, Pair<String, String>> {
        public a(d dVar) {
            super((Object) dVar);
        }

        /* renamed from: a */
        public void z(d dVar, Pair<String, String> pair) {
            super.z(dVar, pair);
            dVar.dK(false);
            dVar.cMW = (String) pair.first;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<font color='#ffffff'>");
            stringBuilder.append(dVar.cMW);
            stringBuilder.append("</font>");
            i.a((AppCompatActivity) dVar.zzakw(), Html.fromHtml(stringBuilder.toString()));
            stringBuilder = new StringBuilder();
            stringBuilder.append("<html><head><style type=\"text/css\">body{color: #fff; background-color: rgba(0,0,0,0);} ol li { list-style-type: none; }</style></head><body>");
            stringBuilder.append((String) pair.second);
            stringBuilder.append("</body></html>");
            dVar.cMV.EM.loadData(stringBuilder.toString(), "text/html; charset=utf-8", null);
        }

        /* renamed from: a */
        public void c(d dVar, Throwable th) {
            super.c(dVar, th);
            dVar.dK(false);
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

    public static d h(KycState kycState) {
        d dVar = new d();
        Bundle bundle = new Bundle();
        bundle.putParcelable("ARG_KYC_STATE", kycState);
        dVar.setArguments(bundle);
        return dVar;
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
        this.cKO = new com.iqoption.kyc.a.d(this, getContext(), com.iqoption.kyc.a.a.apP(), getFragmentManager(), this.cJI.Dh(), apR(), apS(), TAG) {
            final /* synthetic */ d cMX;
            private boolean cMY;

            protected void apV() {
                super.apV();
                this.cMY = true;
                this.cMX.apX();
            }

            protected void apW() {
                super.apW();
                if (this.cMY && this.cMX.cJI != null) {
                    com.iqoption.kyc.a.a.c(this.cMX.getContext(), this.cMX.apR(), this.cMX.apS(), this.cMX.cJI.Dh());
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
                d.this.cMV.EM.setBackgroundColor(0);
                d.this.cMV.EM.setLayerType(1, null);
                d.this.cMV.EM.loadUrl("javascript:document.body.style.setProperty(\"color\", \"white\");");
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
        i.a((AppCompatActivity) zzakw(), this.cMV.bxz.toolbar, fromHtml);
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
