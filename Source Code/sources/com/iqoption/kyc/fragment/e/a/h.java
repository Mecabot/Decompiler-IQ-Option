package com.iqoption.kyc.fragment.e.a;

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
import android.view.ViewGroup;
import com.iqoption.core.util.LocalizationUtil;
import com.iqoption.d.nt;
import com.iqoption.kyc.a.b;
import com.iqoption.kyc.a.d;
import com.iqoption.kyc.c;
import com.iqoption.kyc.i;
import com.iqoption.microservice.a.a.a.e;
import com.iqoption.util.ac;
import com.iqoption.util.am;
import com.iqoption.x.R;

/* compiled from: KycQuestionYesNoFragment2 */
public class h extends Fragment implements b {
    public static final String TAG = "com.iqoption.kyc.fragment.e.a.h";
    private am adG;
    private com.iqoption.util.am.a cKG = new i(this);
    private OnBackStackChangedListener cKO;
    private nt cMT;
    private int cNc;
    private e cNd;
    private a cNn;

    /* compiled from: KycQuestionYesNoFragment2 */
    public interface a {
        void a(int i, e eVar, int i2, b bVar);
    }

    @NonNull
    public String apR() {
        return "TradingExperience";
    }

    @NonNull
    public String apS() {
        return "Question";
    }

    public boolean apT() {
        return false;
    }

    final /* synthetic */ void dZ(boolean z) {
        if (z && isAdded() && ac.c(getFragmentManager(), TAG)) {
            am.n(zzakw());
        }
    }

    public static h c(Integer num, e eVar) {
        h hVar = new h();
        Bundle bundle = new Bundle();
        bundle.putInt("ARG_QUESTION_TYPE", num.intValue());
        bundle.putParcelable("ARG_QUESTION", eVar);
        hVar.setArguments(bundle);
        return hVar;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        bundle = getArguments();
        if (bundle != null) {
            this.cNc = bundle.getInt("ARG_QUESTION_TYPE");
            this.cNd = (e) bundle.getParcelable("ARG_QUESTION");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.cMT = (nt) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_kyc_question_yes_no, viewGroup, false);
        this.cMT.bxT.setText(LocalizationUtil.gW(this.cNd.asy()));
        com.iqoption.microservice.a.a.a.a aVar = (com.iqoption.microservice.a.a.a.a) this.cNd.asA().get(0);
        com.iqoption.microservice.a.a.a.a aVar2 = (com.iqoption.microservice.a.a.a.a) this.cNd.asA().get(1);
        this.cMT.byD.setText(LocalizationUtil.gW(aVar.asm()));
        this.cMT.byC.setText(LocalizationUtil.gW(aVar2.asm()));
        this.cMT.byD.setOnClickListener(new j(this, aVar));
        this.cMT.byC.setOnClickListener(new k(this, aVar2));
        apX();
        this.cKO = new d(this, getContext(), com.iqoption.kyc.a.a.apP(), getFragmentManager(), new c(getContext()).Dh(), apR(), apS(), TAG) {
            final /* synthetic */ h cNq;

            protected void apV() {
                super.apV();
                this.cNq.apX();
            }
        };
        getFragmentManager().addOnBackStackChangedListener(this.cKO);
        this.adG = new am(zzakw());
        return this.cMT.getRoot();
    }

    final /* synthetic */ void b(com.iqoption.microservice.a.a.a.a aVar, View view) {
        this.cNn.a(this.cNc, this.cNd, aVar.ask().intValue(), this);
    }

    final /* synthetic */ void a(com.iqoption.microservice.a.a.a.a aVar, View view) {
        this.cNn.a(this.cNc, this.cNd, aVar.ask().intValue(), this);
    }

    private void apX() {
        i.b((AppCompatActivity) zzakw(), this.cMT.bxz.toolbar);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof a) {
            this.cNn = (a) context;
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
        this.cNn = null;
    }

    public void onDestroyView() {
        com.iqoption.core.i.d(TAG, "onDestroyView");
        getFragmentManager().removeOnBackStackChangedListener(this.cKO);
        super.onDestroyView();
    }
}
