package com.iqoption.kyc.fragment.jumio;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager.OnBackStackChangedListener;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.s;
import com.iqoption.d.lz;
import com.iqoption.dto.entity.result.ProofDocsResult;
import com.iqoption.kyc.a.d;
import com.iqoption.kyc.c;
import com.iqoption.kyc.i;
import com.iqoption.util.ac;
import com.iqoption.util.am;
import com.iqoption.x.R;

/* compiled from: KycAddressDeclinedFragment */
public class b extends Fragment implements com.iqoption.kyc.a.b {
    public static final String TAG = "com.iqoption.kyc.fragment.jumio.b";
    private com.iqoption.util.am.a cKG = new com.iqoption.util.am.a() {
        public void cp(boolean z) {
            if (z && ac.c(b.this.getFragmentManager(), b.TAG)) {
                am.n(b.this.zzakw());
            }
        }
    };
    private OnBackStackChangedListener cKO;
    private a cLc;
    private lz cLd;
    @Nullable
    private ProofDocsResult cLe;
    private boolean cLf;

    /* compiled from: KycAddressDeclinedFragment */
    public interface a {
        s<?> apE();
    }

    /* compiled from: KycAddressDeclinedFragment */
    private static class b extends com.iqoption.system.c.b<b, Object> {
        public b(b bVar) {
            super(bVar, Object.class);
        }

        /* renamed from: a */
        public void z(b bVar, Object obj) {
            super.z(bVar, obj);
            bVar.dK(false);
        }

        /* renamed from: a */
        public void c(b bVar, Throwable th) {
            super.c(bVar, th);
            bVar.dK(false);
        }
    }

    public String apR() {
        return "IdentityProving";
    }

    public String apS() {
        return "AddressDocument";
    }

    public static b a(ProofDocsResult proofDocsResult) {
        b bVar = new b();
        Bundle bundle = new Bundle();
        bundle.putParcelable("KEY_PROOF_DOCS", proofDocsResult);
        bVar.setArguments(bundle);
        return bVar;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        bundle = getArguments();
        if (bundle != null) {
            this.cLe = (ProofDocsResult) bundle.getParcelable("KEY_PROOF_DOCS");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.cLd = (lz) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_kyc_address_declined, viewGroup, false);
        this.cLd.bxH.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                b.this.cLf = true;
                o.a(b.this.cLc.apE(), new b(b.this), com.iqoption.core.d.a.aSe);
            }
        });
        CharSequence declinedComment = this.cLe.getDeclinedComment(2);
        if (!TextUtils.isEmpty(declinedComment)) {
            this.cLd.bxG.setText(declinedComment);
        }
        apX();
        this.cKO = new d(this, getContext(), com.iqoption.kyc.a.a.apP(), getFragmentManager(), new c(getContext()).Dh(), apR(), apS(), TAG) {
            final /* synthetic */ b cLg;

            protected void apV() {
                super.apV();
                this.cLg.apX();
                this.cLg.cLf = false;
            }
        };
        getFragmentManager().addOnBackStackChangedListener(this.cKO);
        return this.cLd.getRoot();
    }

    private void apX() {
        i.a((AppCompatActivity) zzakw(), this.cLd.bxz.toolbar);
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
            this.cLc = (a) context;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.toString());
        stringBuilder.append(" must implement OnFragmentInteractionListener");
        throw new RuntimeException(stringBuilder.toString());
    }

    public void onDetach() {
        super.onDetach();
        this.cLc = null;
    }

    public void onDestroyView() {
        com.iqoption.core.i.d(TAG, "onDestroyView");
        getFragmentManager().removeOnBackStackChangedListener(this.cKO);
        super.onDestroyView();
    }

    private void dK(boolean z) {
        this.cLd.bxH.f(z, false);
    }

    public boolean apT() {
        return this.cLf;
    }
}
