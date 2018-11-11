package com.iqoption.kyc.fragment.b;

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
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import com.iqoption.d.nj;
import com.iqoption.dto.entity.result.KycState;
import com.iqoption.kyc.a.d;
import com.iqoption.kyc.c;
import com.iqoption.kyc.i;
import com.iqoption.util.az;
import com.iqoption.x.R;

/* compiled from: KycPhoneConfirmedFragment */
public class b extends Fragment implements com.iqoption.kyc.a.b {
    public static final String TAG = "com.iqoption.kyc.fragment.b.b";
    @Nullable
    private c cJI;
    private OnBackStackChangedListener cKO;
    private a cLT;
    private nj cLU;

    /* compiled from: KycPhoneConfirmedFragment */
    public interface a {
        void apn();
    }

    @NonNull
    public String apR() {
        return "PersonalData";
    }

    @NonNull
    public String apS() {
        return "PhoneConfirmed";
    }

    public boolean apT() {
        return true;
    }

    public static b f(KycState kycState) {
        b bVar = new b();
        Bundle bundle = new Bundle();
        bundle.putParcelable("ARG_KYC_STATE", kycState);
        bVar.setArguments(bundle);
        return bVar;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        bundle = getArguments();
        if (bundle != null) {
            this.cJI = new c(getContext(), (KycState) bundle.getParcelable("ARG_KYC_STATE"));
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.cLU = (nj) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_kyc_phone_confirmed, viewGroup, false);
        this.cLU.bxE.bxH.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                b.this.cLT.apn();
            }
        });
        PhoneNumber aoC = this.cJI.aoC();
        if (aoC.yd() || aoC.yc()) {
            this.cLU.bxU.setText(az.w(aoC.xE(), aoC.ye()));
        }
        apX();
        this.cKO = new d(this, getContext(), com.iqoption.kyc.a.a.apP(), getFragmentManager(), new c(getContext()).Dh(), apR(), apS(), TAG) {
            final /* synthetic */ b cLV;

            protected void apV() {
                super.apV();
                this.cLV.apX();
            }
        };
        getFragmentManager().addOnBackStackChangedListener(this.cKO);
        return this.cLU.getRoot();
    }

    private void apX() {
        i.a((AppCompatActivity) zzakw(), this.cLU.bxz.toolbar);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof a) {
            this.cLT = (a) context;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.toString());
        stringBuilder.append(" must implement OnFragmentInteractionListener");
        throw new RuntimeException(stringBuilder.toString());
    }

    public void onDetach() {
        super.onDetach();
        this.cLT = null;
    }

    public void onDestroyView() {
        com.iqoption.core.i.d(TAG, "onDestroyView");
        getFragmentManager().removeOnBackStackChangedListener(this.cKO);
        super.onDestroyView();
    }
}
