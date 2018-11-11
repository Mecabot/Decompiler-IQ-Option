package com.iqoption.kyc.fragment.c;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager.OnBackStackChangedListener;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.iqoption.d.lx;
import com.iqoption.dto.entity.result.KycState;
import com.iqoption.kyc.a.d;
import com.iqoption.kyc.c;
import com.iqoption.kyc.e;
import com.iqoption.kyc.i;
import com.iqoption.util.ac;
import com.iqoption.util.am;
import com.iqoption.util.bg;
import com.iqoption.view.text.x;
import com.iqoption.x.R;

/* compiled from: KycCityFragment */
public class b extends Fragment implements com.iqoption.kyc.a.b {
    public static final String TAG = "com.iqoption.kyc.fragment.c.b";
    @Nullable
    private c cJI;
    private OnBackStackChangedListener cKO;
    @Nullable
    private e cKi;
    private lx cMa;
    private TextWatcher cMb = new x() {
        public void afterTextChanged(Editable editable) {
            b.this.aqn();
        }
    };
    private boolean cMc;
    private a cMg;
    private com.iqoption.kyc.a.c cMh;
    private com.iqoption.kyc.a.c cMi;

    /* compiled from: KycCityFragment */
    public interface a {
        void aj(String str, String str2);
    }

    @NonNull
    public String apR() {
        return "PersonalData";
    }

    @NonNull
    public String apS() {
        return "InputAddress_CityPostalCode";
    }

    public boolean apT() {
        return true;
    }

    public static b b(KycState kycState, e eVar) {
        b bVar = new b();
        Bundle bundle = new Bundle();
        bundle.putParcelable("ARG_KYC_STATE", kycState);
        bundle.putParcelable("ARG_KYC_PROFILE", eVar);
        bVar.setArguments(bundle);
        return bVar;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        bundle = getArguments();
        if (bundle != null) {
            this.cJI = new c(getContext(), (KycState) bundle.getParcelable("ARG_KYC_STATE"));
            this.cKi = (e) bundle.getParcelable("ARG_KYC_PROFILE");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.cMa = (lx) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_kyc_address, viewGroup, false);
        this.cMa.bxE.bxH.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                b.this.cMg.aj(b.this.cMa.bxB.getText().toString(), b.this.cMa.bxC.getText().toString());
            }
        });
        this.cMa.bxB.setHint(R.string.city);
        this.cMa.bxC.setHint(R.string.kyc_info_postalcode);
        aqp();
        aqn();
        apX();
        this.cMh = new com.iqoption.kyc.a.c(this.cMa.bxB, apR(), apS(), "City", 6, this.cJI.Dh());
        this.cMi = new com.iqoption.kyc.a.c(this.cMa.bxC, apR(), apS(), "PostalCode", 7, this.cJI.Dh());
        this.cKO = new d(this, getContext(), com.iqoption.kyc.a.a.apP(), getFragmentManager(), this.cJI.Dh(), apR(), apS(), TAG) {
            final /* synthetic */ b cMj;

            protected void apV() {
                super.apV();
                this.cMj.apX();
            }
        };
        getFragmentManager().addOnBackStackChangedListener(this.cKO);
        this.cMa.bxB.addTextChangedListener(this.cMb);
        this.cMa.bxC.addTextChangedListener(this.cMb);
        return this.cMa.getRoot();
    }

    private void aqp() {
        CharSequence charSequence = null;
        CharSequence g = this.cJI != null ? this.cJI.g(this.cKi) : null;
        if (this.cJI != null) {
            charSequence = this.cJI.h(this.cKi);
        }
        this.cMa.bxB.setText(g);
        this.cMa.bxC.setText(charSequence);
    }

    private void apX() {
        i.a((AppCompatActivity) zzakw(), this.cMa.bxz.toolbar);
    }

    public void onStart() {
        super.onStart();
        com.iqoption.core.d.a.aSe.postDelayed(new Runnable() {
            public void run() {
                if (b.this.isVisible() && ac.c(b.this.getFragmentManager(), b.TAG)) {
                    View view = b.this.cMc ? b.this.cMa.bxC : b.this.cMa.bxB;
                    am.b(b.this.getContext(), view);
                    view.requestFocus();
                    bg.e(view);
                }
            }
        }, 400);
    }

    public void onStop() {
        com.iqoption.core.i.d(TAG, "onStop");
        this.cMc = this.cMa.bxC.hasFocus();
        super.onStop();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof a) {
            this.cMg = (a) context;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.toString());
        stringBuilder.append(" must implement OnFragmentInteractionListener");
        throw new RuntimeException(stringBuilder.toString());
    }

    public void onDetach() {
        super.onDetach();
        this.cMg = null;
    }

    public void onDestroyView() {
        com.iqoption.core.i.d(TAG, "onDestroyView");
        getFragmentManager().removeOnBackStackChangedListener(this.cKO);
        super.onDestroyView();
    }

    private void aqn() {
        boolean z = (TextUtils.isEmpty(this.cMa.bxB.getText().toString()) || TextUtils.isEmpty(this.cMa.bxC.getText().toString())) ? false : true;
        this.cMa.bxE.bxH.setEnabled(z);
    }
}
