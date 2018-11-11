package com.iqoption.kyc.fragment.jumio;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager.OnBackStackChangedListener;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.s;
import com.iqoption.d.nb;
import com.iqoption.dto.entity.result.ProofDocsResult;
import com.iqoption.kyc.a.d;
import com.iqoption.kyc.c;
import com.iqoption.kyc.i;
import com.iqoption.util.ac;
import com.iqoption.util.am;
import com.iqoption.x.R;

/* compiled from: KycIdDeclinedFragment */
public class f extends Fragment implements com.iqoption.kyc.a.b {
    public static final String TAG = "com.iqoption.kyc.fragment.jumio.f";
    private com.iqoption.util.am.a cKG = new com.iqoption.util.am.a() {
        public void cp(boolean z) {
            if (z && ac.c(f.this.getFragmentManager(), f.TAG)) {
                am.n(f.this.zzakw());
            }
        }
    };
    private OnBackStackChangedListener cKO;
    @Nullable
    private ProofDocsResult cLe;
    private a cLw;
    private nb cLx;
    private boolean isInProgress;

    /* compiled from: KycIdDeclinedFragment */
    public interface a {
        s<?> apD();
    }

    /* compiled from: KycIdDeclinedFragment */
    private static class b extends com.iqoption.system.c.b<f, Object> {
        public b(f fVar) {
            super(fVar, Object.class);
        }

        /* renamed from: a */
        public void z(f fVar, Object obj) {
            super.z(fVar, obj);
            fVar.dK(false);
        }

        /* renamed from: a */
        public void c(f fVar, Throwable th) {
            super.c(fVar, th);
            fVar.dK(false);
        }
    }

    @NonNull
    public String apR() {
        return "IdentityProving";
    }

    @NonNull
    public String apS() {
        return "ProofOfIdentity";
    }

    public boolean apT() {
        return true;
    }

    public static f c(ProofDocsResult proofDocsResult) {
        f fVar = new f();
        Bundle bundle = new Bundle();
        bundle.putParcelable("KEY_PROOF_DOCS", proofDocsResult);
        fVar.setArguments(bundle);
        return fVar;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        bundle = getArguments();
        if (bundle != null) {
            this.cLe = (ProofDocsResult) bundle.getParcelable("KEY_PROOF_DOCS");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.cLx = (nb) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_kyc_id_declined, viewGroup, false);
        this.cLx.bxH.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                if (!f.this.isInProgress) {
                    f.this.dK(true);
                    o.a(f.this.cLw.apD(), new b(f.this), com.iqoption.core.d.a.aSe);
                }
            }
        });
        CharSequence declinedComment = this.cLe.getDeclinedComment(1);
        if (!TextUtils.isEmpty(declinedComment)) {
            this.cLx.bxG.setText(declinedComment);
        }
        apX();
        this.cKO = new d(this, getContext(), com.iqoption.kyc.a.a.apP(), getFragmentManager(), new c(getContext()).Dh(), apR(), apS(), TAG) {
            final /* synthetic */ f cLy;

            protected void apV() {
                super.apV();
                this.cLy.apX();
            }
        };
        getFragmentManager().addOnBackStackChangedListener(this.cKO);
        return this.cLx.getRoot();
    }

    private void apX() {
        i.a((AppCompatActivity) zzakw(), this.cLx.bxz.toolbar);
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
            this.cLw = (a) context;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.toString());
        stringBuilder.append(" must implement OnFragmentInteractionListener");
        throw new RuntimeException(stringBuilder.toString());
    }

    public void onDetach() {
        super.onDetach();
        this.cLw = null;
    }

    public void onDestroyView() {
        com.iqoption.core.i.d(TAG, "onDestroyView");
        getFragmentManager().removeOnBackStackChangedListener(this.cKO);
        super.onDestroyView();
    }

    private void dK(boolean z) {
        this.isInProgress = z;
        this.cLx.bxH.f(z, false);
    }
}
