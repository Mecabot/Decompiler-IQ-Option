package com.iqoption.kyc.fragment.d;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager.OnBackStackChangedListener;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.s;
import com.iqoption.d.nr;
import com.iqoption.kyc.a.d;
import com.iqoption.kyc.c;
import com.iqoption.kyc.i;
import com.iqoption.mobbtech.connect.response.l;
import com.iqoption.util.ac;
import com.iqoption.util.am;
import com.iqoption.x.R;

/* compiled from: KycWarningFragment */
public class e extends Fragment implements com.iqoption.kyc.a.b {
    public static final String TAG = "com.iqoption.kyc.fragment.d.e";
    private am adG;
    private com.iqoption.util.am.a cKG = new com.iqoption.util.am.a() {
        public void cp(boolean z) {
            if (z && e.this.isAdded() && ac.c(e.this.getFragmentManager(), e.TAG)) {
                am.n(e.this.zzakw());
            }
        }
    };
    private OnBackStackChangedListener cKO;
    private boolean cLf;
    private a cMZ;
    private nr cNa;

    /* compiled from: KycWarningFragment */
    public interface a {
        s<? extends l> apq();

        void apr();
    }

    /* compiled from: KycWarningFragment */
    private static class b extends com.iqoption.system.c.b<e, l> {
        b(e eVar) {
            super((Object) eVar);
        }

        /* renamed from: a */
        public void z(e eVar, l lVar) {
            super.z(eVar, lVar);
            eVar.dK(false);
        }

        /* renamed from: a */
        public void c(e eVar, Throwable th) {
            super.c(eVar, th);
            eVar.dK(false);
        }
    }

    @NonNull
    public String apR() {
        return "TradingExperience";
    }

    @NonNull
    public String apS() {
        return "Warning";
    }

    public static e aqw() {
        return new e();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.cNa = (nr) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_kyc_question_warning, viewGroup, false);
        this.cNa.bxH.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                e.this.cLf = true;
                e.this.dK(true);
                o.a(e.this.cMZ.apq(), new b(e.this), com.iqoption.core.d.a.aSe);
            }
        });
        this.cNa.byw.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                e.this.cLf = false;
                com.iqoption.kyc.a.a.b(e.this.getContext(), e.this.apR(), e.this.apS(), new c(e.this.getContext()).Dh());
                e.this.cMZ.apr();
            }
        });
        this.cNa.byB.setMovementMethod(new ScrollingMovementMethod());
        apX();
        this.cKO = new d(this, getContext(), com.iqoption.kyc.a.a.apP(), getFragmentManager(), new c(getContext()).Dh(), apR(), apS(), TAG) {
            final /* synthetic */ e cNb;

            protected void apV() {
                super.apV();
                this.cNb.apX();
            }
        };
        getFragmentManager().addOnBackStackChangedListener(this.cKO);
        this.adG = new am(zzakw());
        return this.cNa.getRoot();
    }

    public boolean apT() {
        return this.cLf;
    }

    private void apX() {
        i.a((AppCompatActivity) zzakw(), this.cNa.bxz.toolbar);
        zzakw().invalidateOptionsMenu();
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
            this.cMZ = (a) context;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.toString());
        stringBuilder.append(" must implement OnFragmentInteractionListener");
        throw new RuntimeException(stringBuilder.toString());
    }

    public void onDetach() {
        super.onDetach();
        this.cMZ = null;
    }

    public void onDestroyView() {
        com.iqoption.core.i.d(TAG, "onDestroyView");
        getFragmentManager().removeOnBackStackChangedListener(this.cKO);
        super.onDestroyView();
    }

    private void dK(boolean z) {
        this.cNa.bxH.f(z, false);
        this.cNa.byw.setEnabled(z);
    }
}
