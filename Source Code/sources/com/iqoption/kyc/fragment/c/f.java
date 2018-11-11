package com.iqoption.kyc.fragment.c;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager.OnBackStackChangedListener;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.iqoption.d.od;
import com.iqoption.kyc.a.b;
import com.iqoption.kyc.a.d;
import com.iqoption.kyc.c;
import com.iqoption.kyc.e;
import com.iqoption.kyc.i;
import com.iqoption.util.ac;
import com.iqoption.util.am;
import com.iqoption.x.R;

/* compiled from: KycSexFragment */
public class f extends Fragment implements b {
    public static final String TAG = "com.iqoption.kyc.fragment.c.f";
    private am adG;
    private com.iqoption.util.am.a cKG = new com.iqoption.util.am.a() {
        public void cp(boolean z) {
            if (z && f.this.isAdded() && ac.c(f.this.getFragmentManager(), f.TAG)) {
                am.n(f.this.zzakw());
            }
        }
    };
    private OnBackStackChangedListener cKO;
    @Nullable
    private e cKi;
    private a cMA;
    private od cMB;

    /* compiled from: KycSexFragment */
    public interface a {
        void dM(boolean z);
    }

    @NonNull
    public String apR() {
        return "PersonalData";
    }

    @NonNull
    public String apS() {
        return "ChooseSex";
    }

    public boolean apT() {
        return true;
    }

    public static f k(e eVar) {
        f fVar = new f();
        Bundle bundle = new Bundle();
        bundle.putParcelable("ARG_KYC_PROFILE", eVar);
        fVar.setArguments(bundle);
        return fVar;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.cKi = (e) getArguments().getParcelable("ARG_KYC_PROFILE");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.cMB = (od) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_kyc_sex, viewGroup, false);
        final boolean Dh = new c(getContext()).Dh();
        this.cMB.byK.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                com.iqoption.kyc.a.a.b(f.this.getContext(), true, f.this.apR(), f.this.apR(), Dh);
                f.this.cMA.dM(true);
            }
        });
        this.cMB.byJ.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                com.iqoption.kyc.a.a.b(f.this.getContext(), false, f.this.apR(), f.this.apR(), Dh);
                f.this.cMA.dM(false);
            }
        });
        apX();
        this.cKO = new d(this, getContext(), com.iqoption.kyc.a.a.apP(), getFragmentManager(), Dh, apR(), apS(), TAG) {
            final /* synthetic */ f cMC;

            protected void apV() {
                super.apV();
                this.cMC.apX();
            }
        };
        getFragmentManager().addOnBackStackChangedListener(this.cKO);
        this.adG = new am(zzakw());
        return this.cMB.getRoot();
    }

    private void apX() {
        i.a((AppCompatActivity) zzakw(), this.cMB.bxz.toolbar);
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
        if (context instanceof a) {
            this.cMA = (a) context;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.toString());
        stringBuilder.append(" must implement OnFragmentInteractionListener");
        throw new RuntimeException(stringBuilder.toString());
    }

    public void onDetach() {
        super.onDetach();
        this.cMA = null;
    }

    public void onDestroyView() {
        com.iqoption.core.i.d(TAG, "onDestroyView");
        getFragmentManager().removeOnBackStackChangedListener(this.cKO);
        super.onDestroyView();
    }
}
