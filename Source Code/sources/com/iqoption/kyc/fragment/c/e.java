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
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.iqoption.d.nd;
import com.iqoption.dto.entity.result.KycState;
import com.iqoption.kyc.a.b;
import com.iqoption.kyc.a.d;
import com.iqoption.kyc.c;
import com.iqoption.kyc.i;
import com.iqoption.util.ac;
import com.iqoption.util.am;
import com.iqoption.util.bg;
import com.iqoption.view.text.x;
import com.iqoption.x.R;

/* compiled from: KycLegalNameFragment */
public class e extends Fragment implements b {
    public static final String TAG = "com.iqoption.kyc.fragment.c.e";
    @Nullable
    private c cJI;
    private OnBackStackChangedListener cKO;
    @Nullable
    private com.iqoption.kyc.e cKi;
    private TextWatcher cMb = new x() {
        public void afterTextChanged(Editable editable) {
            e.this.aqn();
        }
    };
    private a cMu;
    private nd cMv;
    private boolean cMw;
    private com.iqoption.kyc.a.c cMx;
    private com.iqoption.kyc.a.c cMy;

    /* compiled from: KycLegalNameFragment */
    public interface a {
        void ai(String str, String str2);
    }

    @NonNull
    public String apR() {
        return "PersonalData";
    }

    @NonNull
    public String apS() {
        return "InputName";
    }

    public boolean apT() {
        return true;
    }

    public static e d(KycState kycState, com.iqoption.kyc.e eVar) {
        e eVar2 = new e();
        Bundle bundle = new Bundle();
        bundle.putParcelable("ARG_KYC_STATE", kycState);
        bundle.putParcelable("ARG_KYC_PROFILE", eVar);
        eVar2.setArguments(bundle);
        return eVar2;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        bundle = getArguments();
        if (bundle != null) {
            this.cJI = new c(getContext(), (KycState) bundle.getParcelable("ARG_KYC_STATE"));
            this.cKi = (com.iqoption.kyc.e) bundle.getParcelable("ARG_KYC_PROFILE");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.cMv = (nd) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_kyc_legal_name, viewGroup, false);
        this.cMv.bxE.bxH.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                e.this.cMu.ai(e.this.cMv.byr.getText().toString(), e.this.cMv.bys.getText().toString());
            }
        });
        CharSequence a = this.cJI.a(this.cKi);
        CharSequence b = this.cJI.b(this.cKi);
        this.cMv.byr.setText(a);
        this.cMv.bys.setText(b);
        aqn();
        this.cMv.byr.addTextChangedListener(this.cMb);
        this.cMv.bys.addTextChangedListener(this.cMb);
        apX();
        this.cMx = new com.iqoption.kyc.a.c(this.cMv.byr, apR(), apS(), "Name", 3, this.cJI.Dh());
        this.cMy = new com.iqoption.kyc.a.c(this.cMv.bys, apR(), apS(), "Surname", 4, this.cJI.Dh());
        this.cKO = new d(this, getContext(), com.iqoption.kyc.a.a.apP(), getFragmentManager(), this.cJI.Dh(), apR(), apS(), TAG) {
            final /* synthetic */ e cMz;

            protected void apV() {
                super.apV();
                this.cMz.apX();
            }
        };
        getFragmentManager().addOnBackStackChangedListener(this.cKO);
        return this.cMv.getRoot();
    }

    private void apX() {
        i.a((AppCompatActivity) zzakw(), this.cMv.bxz.toolbar);
    }

    public void onStart() {
        super.onStart();
        com.iqoption.core.d.a.aSe.postDelayed(new Runnable() {
            public void run() {
                if (e.this.isVisible() && ac.c(e.this.getFragmentManager(), e.TAG)) {
                    View view = e.this.cMw ? e.this.cMv.bys : e.this.cMv.byr;
                    am.b(e.this.getContext(), view);
                    view.requestFocus();
                    bg.e(view);
                }
            }
        }, 400);
    }

    public void onStop() {
        com.iqoption.core.i.d(TAG, "onStop");
        this.cMw = this.cMv.bys.hasFocus();
        super.onStop();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof a) {
            this.cMu = (a) context;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.toString());
        stringBuilder.append(" must implement OnFragmentInteractionListener");
        throw new RuntimeException(stringBuilder.toString());
    }

    public void onDetach() {
        super.onDetach();
        this.cMu = null;
    }

    public void onDestroyView() {
        com.iqoption.core.i.d(TAG, "onDestroyView");
        getFragmentManager().removeOnBackStackChangedListener(this.cKO);
        super.onDestroyView();
    }

    private void aqn() {
        boolean z = this.cJI != null && this.cJI.hW(this.cMv.byr.getText().toString()) && this.cJI.hW(this.cMv.bys.getText().toString());
        this.cMv.bxE.bxH.setEnabled(z);
    }
}
