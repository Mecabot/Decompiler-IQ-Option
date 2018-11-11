package com.iqoption.kyc.fragment.f;

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
import com.iqoption.d.nx;
import com.iqoption.kyc.a.d;
import com.iqoption.kyc.c;
import com.iqoption.kyc.e;
import com.iqoption.kyc.i;
import com.iqoption.util.ac;
import com.iqoption.util.am;
import com.iqoption.x.R;

/* compiled from: KycReportableFragment */
public class b extends Fragment implements com.iqoption.kyc.a.b {
    public static final String TAG = "com.iqoption.kyc.fragment.f.b";
    private am adG;
    private com.iqoption.util.am.a cKG = new com.iqoption.util.am.a() {
        public void cp(boolean z) {
            if (z && b.this.isAdded() && ac.c(b.this.getFragmentManager(), b.TAG)) {
                am.n(b.this.zzakw());
            }
        }
    };
    private OnBackStackChangedListener cKO;
    @Nullable
    private e cKi;
    private a cNB;
    private nx cNC;

    /* compiled from: KycReportableFragment */
    public interface a {
        s<?> dN(boolean z);
    }

    /* compiled from: KycReportableFragment */
    private static class b extends com.iqoption.system.c.b<b, Object> {
        private boolean cNE;

        public b(b bVar, boolean z) {
            super(bVar, Object.class);
            this.cNE = z;
        }

        /* renamed from: a */
        public void z(b bVar, Object obj) {
            super.z(bVar, obj);
            if (bVar.isAdded()) {
                bVar.f(false, this.cNE);
            }
        }

        /* renamed from: a */
        public void c(b bVar, Throwable th) {
            super.c(bVar, th);
            if (bVar.isAdded()) {
                bVar.f(false, this.cNE);
            }
        }
    }

    @NonNull
    public String apR() {
        return "PersonalData";
    }

    @NonNull
    public String apS() {
        return "USPerson";
    }

    public boolean apT() {
        return true;
    }

    public static b l(e eVar) {
        b bVar = new b();
        Bundle bundle = new Bundle();
        bundle.putParcelable("ARG_KYC_PROFILE", eVar);
        bVar.setArguments(bundle);
        return bVar;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.cKi = (e) getArguments().getParcelable("ARG_KYC_PROFILE");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.cNC = (nx) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_kyc_reportable, viewGroup, false);
        final boolean Dh = new c(getContext()).Dh();
        this.cNC.byF.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                com.iqoption.kyc.a.a.c(b.this.getContext(), false, b.this.apR(), b.this.apS(), Dh);
                o.a(b.this.cNB.dN(false), new b(b.this, false), com.iqoption.core.d.a.aSe);
            }
        });
        this.cNC.byH.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                com.iqoption.kyc.a.a.c(b.this.getContext(), true, b.this.apR(), b.this.apS(), Dh);
                o.a(b.this.cNB.dN(true), new b(b.this, true), com.iqoption.core.d.a.aSe);
            }
        });
        apX();
        this.cKO = new d(this, getContext(), com.iqoption.kyc.a.a.apP(), getFragmentManager(), Dh, apR(), apS(), TAG) {
            final /* synthetic */ b cND;

            protected void apV() {
                super.apV();
                this.cND.apX();
            }
        };
        getFragmentManager().addOnBackStackChangedListener(this.cKO);
        this.adG = new am(zzakw());
        return this.cNC.getRoot();
    }

    private void apX() {
        i.a((AppCompatActivity) zzakw(), this.cNC.bxz.toolbar);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof a) {
            this.cNB = (a) context;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.toString());
        stringBuilder.append(" must implement OnFragmentInteractionListener");
        throw new RuntimeException(stringBuilder.toString());
    }

    public void onStart() {
        super.onStart();
        am.a(this.cKG);
    }

    public void onStop() {
        super.onStop();
        am.b(this.cKG);
    }

    public void onDetach() {
        super.onDetach();
        this.cNB = null;
    }

    public void onDestroyView() {
        com.iqoption.core.i.d(TAG, "onDestroyView");
        getFragmentManager().removeOnBackStackChangedListener(this.cKO);
        super.onDestroyView();
    }

    private void f(boolean z, boolean z2) {
        if (z) {
            if (z2) {
                this.cNC.byH.f(true, false);
                this.cNC.byF.setEnabled(false);
                return;
            }
            this.cNC.byF.f(true, false);
            this.cNC.byH.setEnabled(false);
        } else if (z2) {
            this.cNC.byH.f(false, false);
            this.cNC.byF.setEnabled(true);
        } else {
            this.cNC.byF.f(false, false);
            this.cNC.byH.setEnabled(true);
        }
    }
}
