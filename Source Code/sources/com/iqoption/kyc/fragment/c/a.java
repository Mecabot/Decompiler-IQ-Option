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
import com.google.common.base.Joiner;
import com.google.common.base.k;
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.s;
import com.iqoption.d.lx;
import com.iqoption.dto.entity.result.KycState;
import com.iqoption.kyc.a.d;
import com.iqoption.kyc.c;
import com.iqoption.kyc.e;
import com.iqoption.kyc.i;
import com.iqoption.util.ac;
import com.iqoption.util.am;
import com.iqoption.util.bg;
import com.iqoption.view.text.SoftKeyboardEditText;
import com.iqoption.view.text.x;
import com.iqoption.x.R;

/* compiled from: KycAddressFragment */
public class a extends Fragment implements com.iqoption.kyc.a.b {
    public static final String TAG = "com.iqoption.kyc.fragment.c.a";
    @Nullable
    private c cJI;
    private OnBackStackChangedListener cKO;
    @Nullable
    private e cKi;
    private a cLZ;
    private lx cMa;
    private TextWatcher cMb = new x() {
        public void afterTextChanged(Editable editable) {
            a.this.aqn();
        }
    };
    private boolean cMc;
    private com.iqoption.kyc.a.c cMd;
    private com.iqoption.kyc.a.c cMe;

    /* compiled from: KycAddressFragment */
    public interface a {
        s<?> ak(String str, String str2);
    }

    /* compiled from: KycAddressFragment */
    private static class b extends com.iqoption.system.c.b<a, Object> {
        public b(a aVar) {
            super(aVar, Object.class);
        }

        /* renamed from: a */
        public void z(a aVar, Object obj) {
            super.z(aVar, obj);
            if (aVar.isAdded()) {
                aVar.dK(false);
            }
        }

        /* renamed from: a */
        public void c(a aVar, Throwable th) {
            super.c(aVar, th);
            if (aVar.isAdded()) {
                aVar.dK(false);
            }
        }
    }

    @NonNull
    public String apR() {
        return "PersonalData";
    }

    @NonNull
    public String apS() {
        return "InputAddress_StreetAndHouseNumber";
    }

    public boolean apT() {
        return true;
    }

    public static a a(KycState kycState, e eVar) {
        a aVar = new a();
        Bundle bundle = new Bundle();
        bundle.putParcelable("ARG_KYC_STATE", kycState);
        bundle.putParcelable("ARG_KYC_PROFILE", eVar);
        aVar.setArguments(bundle);
        return aVar;
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
                String obj = a.this.cMa.bxB.getText().toString();
                String obj2 = a.this.cMa.bxC.getText().toString();
                a.this.dK(true);
                o.a(a.this.cLZ.ak(obj, obj2), new b(a.this), com.iqoption.core.d.a.aSe);
            }
        });
        aqp();
        aqn();
        apX();
        this.cMd = new com.iqoption.kyc.a.c(this.cMa.bxB, apR(), apS(), "AddressLine1", 8, this.cJI.Dh());
        this.cMe = new com.iqoption.kyc.a.c(this.cMa.bxC, apR(), apS(), "AddressLine2", 9, this.cJI.Dh());
        this.cKO = new d(this, getContext(), com.iqoption.kyc.a.a.apP(), getFragmentManager(), this.cJI.Dh(), apR(), apS(), TAG) {
            final /* synthetic */ a cMf;

            protected void apV() {
                super.apV();
                this.cMf.apX();
            }
        };
        getFragmentManager().addOnBackStackChangedListener(this.cKO);
        SoftKeyboardEditText softKeyboardEditText = this.cMa.bxB;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getString(R.string.kyc_address_line));
        stringBuilder.append(" 1");
        softKeyboardEditText.setHint(stringBuilder.toString());
        softKeyboardEditText = this.cMa.bxC;
        stringBuilder = new StringBuilder();
        stringBuilder.append(getString(R.string.kyc_address_line));
        stringBuilder.append(" 2");
        softKeyboardEditText.setHint(stringBuilder.toString());
        this.cMa.bxB.addTextChangedListener(this.cMb);
        this.cMa.bxC.addTextChangedListener(this.cMb);
        return this.cMa.getRoot();
    }

    private void aqp() {
        CharSequence f = this.cJI != null ? this.cJI.f(this.cKi) : null;
        if (!TextUtils.isEmpty(f)) {
            if (f.length() > 30) {
                Iterable b = k.f(',').pU().pT().b(f);
                int p = com.google.common.collect.s.p(b);
                if (p > 1) {
                    p /= 2;
                    f = Joiner.on(", ").join(com.google.common.collect.s.c(b, p));
                    CharSequence join = Joiner.on(", ").join(com.google.common.collect.s.b(b, p));
                    this.cMa.bxB.setText(f);
                    this.cMa.bxC.setText(join);
                    return;
                }
                this.cMa.bxB.setText(f);
                return;
            }
            this.cMa.bxB.setText(f);
        }
    }

    private void apX() {
        i.a((AppCompatActivity) zzakw(), this.cMa.bxz.toolbar);
    }

    public void onStart() {
        super.onStart();
        com.iqoption.core.d.a.aSe.postDelayed(new Runnable() {
            public void run() {
                if (a.this.isVisible() && ac.c(a.this.getFragmentManager(), a.TAG)) {
                    View view = a.this.cMc ? a.this.cMa.bxC : a.this.cMa.bxB;
                    am.b(a.this.getContext(), view);
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
            this.cLZ = (a) context;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.toString());
        stringBuilder.append(" must implement OnFragmentInteractionListener");
        throw new RuntimeException(stringBuilder.toString());
    }

    public void onDetach() {
        super.onDetach();
        this.cLZ = null;
    }

    public void onDestroyView() {
        com.iqoption.core.i.d(TAG, "onDestroyView");
        getFragmentManager().removeOnBackStackChangedListener(this.cKO);
        super.onDestroyView();
    }

    private void aqn() {
        boolean z = (TextUtils.isEmpty(this.cMa.bxB.getText().toString()) && TextUtils.isEmpty(this.cMa.bxC.getText().toString())) ? false : true;
        this.cMa.bxE.bxH.setEnabled(z);
    }

    private void dK(boolean z) {
        if (z) {
            this.cMa.bxE.bxH.f(true, false);
            this.cMa.bxB.setEnabled(false);
            this.cMa.bxC.setEnabled(false);
            return;
        }
        this.cMa.bxE.bxH.f(false, false);
        this.cMa.bxB.setEnabled(true);
        this.cMa.bxC.setEnabled(true);
    }
}
