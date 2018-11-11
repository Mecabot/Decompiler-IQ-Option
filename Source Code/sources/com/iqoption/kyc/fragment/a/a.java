package com.iqoption.kyc.fragment.a;

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
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.s;
import com.iqoption.d.mx;
import com.iqoption.kyc.a.d;
import com.iqoption.kyc.i;
import com.iqoption.x.R;

/* compiled from: KycFinishFragment */
public class a extends Fragment implements com.iqoption.kyc.a.b {
    public static final String TAG = "com.iqoption.kyc.fragment.a.a";
    private boolean aMv;
    private a cKL;
    private mx cKM;
    private int cKN;
    private OnBackStackChangedListener cKO;

    /* compiled from: KycFinishFragment */
    public interface a {
        s<?> apt();
    }

    /* compiled from: KycFinishFragment */
    private static class b extends com.iqoption.system.c.b<a, Object> {
        public b(a aVar) {
            super(aVar, Object.class);
        }

        /* renamed from: a */
        public void z(a aVar, Object obj) {
            super.z(aVar, obj);
            aVar.dK(false);
        }

        /* renamed from: a */
        public void c(a aVar, Throwable th) {
            super.c(aVar, th);
            aVar.dK(false);
        }
    }

    @NonNull
    public String apS() {
        return "AccountVerified";
    }

    public boolean apT() {
        return false;
    }

    public static a l(int i, boolean z) {
        a aVar = new a();
        Bundle bundle = new Bundle();
        bundle.putInt("ARG_SCREEN_TYPE", i);
        bundle.putBoolean("ARG_IS_REGULATED", z);
        aVar.setArguments(bundle);
        return aVar;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        bundle = getArguments();
        if (bundle != null) {
            this.aMv = bundle.getBoolean("ARG_IS_REGULATED");
            this.cKN = bundle.getInt("ARG_SCREEN_TYPE");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.cKM = (mx) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_kyc_finish, viewGroup, false);
        this.cKM.bxH.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                o.a(a.this.cKL.apt(), new b(a.this));
            }
        });
        switch (this.cKN) {
            case 1:
                this.cKM.byl.setImageResource(R.drawable.ic_kyc_user);
                this.cKM.bym.setText(R.string.kyc_profile_almost_verified);
                this.cKM.byk.setText(R.string.kyc_documents_review_description);
                break;
            case 2:
                this.cKM.byl.setImageResource(R.drawable.ic_kyc_finish);
                this.cKM.bym.setText(R.string.kyc_thanks);
                this.cKM.byk.setText(getString(R.string.kyc_information_has_been_saved_attach_documents_days, "7"));
                break;
            default:
                this.cKM.byl.setImageResource(R.drawable.ic_kyc_finish);
                this.cKM.bym.setText(R.string.kyc_thanks);
                this.cKM.byk.setText(R.string.kyc_information_has_been_saved);
                break;
        }
        apX();
        this.cKO = new d(this, getContext(), com.iqoption.kyc.a.a.apP(), getFragmentManager(), this.aMv, apR(), apS(), TAG) {
            final /* synthetic */ a cKP;

            protected void apV() {
                super.apV();
                this.cKP.apX();
            }
        };
        getFragmentManager().addOnBackStackChangedListener(this.cKO);
        return this.cKM.getRoot();
    }

    @NonNull
    public String apR() {
        return this.aMv ? "IdentityProving" : "PersonalData";
    }

    private void apX() {
        i.b((AppCompatActivity) zzakw());
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof a) {
            this.cKL = (a) context;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.toString());
        stringBuilder.append(" must implement OnFragmentInteractionListener");
        throw new RuntimeException(stringBuilder.toString());
    }

    public void onDetach() {
        super.onDetach();
        this.cKL = null;
    }

    public void onDestroyView() {
        com.iqoption.core.i.d(TAG, "onDestroyView");
        getFragmentManager().removeOnBackStackChangedListener(this.cKO);
        super.onDestroyView();
    }

    private void dK(boolean z) {
        this.cKM.bxH.f(z, false);
    }
}
