package com.iqoption.kyc.fragment.jumio;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager.OnBackStackChangedListener;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.iqoption.d.lv;
import com.iqoption.kyc.a.b;
import com.iqoption.kyc.a.d;
import com.iqoption.kyc.c;
import com.iqoption.kyc.i;
import com.iqoption.util.ac;
import com.iqoption.util.am;
import com.iqoption.x.R;

/* compiled from: KycAcceptableDocumentsFragment */
public class a extends Fragment implements b {
    public static final String TAG = "com.iqoption.kyc.fragment.jumio.a";
    private boolean aMv;
    private am adG;
    private com.iqoption.util.am.a cKG = new com.iqoption.util.am.a() {
        public void cp(boolean z) {
            if (z && a.this.isAdded() && ac.c(a.this.getFragmentManager(), a.TAG)) {
                am.n(a.this.zzakw());
            }
        }
    };
    private OnBackStackChangedListener cKO;
    private lv cLa;

    public String apR() {
        return "IdentityProving";
    }

    public String apS() {
        return "AcceptableDocuments";
    }

    public boolean apT() {
        return false;
    }

    public static a dW(boolean z) {
        a aVar = new a();
        Bundle bundle = new Bundle();
        bundle.putBoolean("KEY_IS_REGULATED", z);
        aVar.setArguments(bundle);
        return aVar;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.aMv = getArguments().getBoolean("KEY_IS_REGULATED", true);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i = 0;
        this.cLa = (lv) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_kyc_acceptable_documents, viewGroup, false);
        apX();
        LinearLayout linearLayout = this.cLa.bxy;
        if (!this.aMv) {
            i = 8;
        }
        linearLayout.setVisibility(i);
        this.cKO = new d(this, getContext(), com.iqoption.kyc.a.a.apP(), getFragmentManager(), new c(getContext()).Dh(), apR(), apS(), TAG) {
            final /* synthetic */ a cLb;

            protected void apV() {
                super.apV();
                this.cLb.apX();
            }
        };
        getFragmentManager().addOnBackStackChangedListener(this.cKO);
        this.adG = new am(zzakw());
        return this.cLa.getRoot();
    }

    private void apX() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<font color='#ffffff'>");
        stringBuilder.append(getString(R.string.kyc_acceptable_documents));
        stringBuilder.append("</font>");
        i.a((AppCompatActivity) zzakw(), this.cLa.bxz.toolbar, Html.fromHtml(stringBuilder.toString()));
    }

    public void onStart() {
        super.onStart();
        am.a(this.cKG);
    }

    public void onStop() {
        super.onStop();
        am.b(this.cKG);
    }

    public void onDestroyView() {
        com.iqoption.core.i.d(TAG, "onDestroyView");
        getFragmentManager().removeOnBackStackChangedListener(this.cKO);
        super.onDestroyView();
    }
}
