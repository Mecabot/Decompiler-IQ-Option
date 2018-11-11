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
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.iqoption.core.util.LocalizationUtil;
import com.iqoption.d.nn;
import com.iqoption.d.nv;
import com.iqoption.kyc.a.b;
import com.iqoption.kyc.a.d;
import com.iqoption.kyc.c;
import com.iqoption.kyc.i;
import com.iqoption.util.ac;
import com.iqoption.util.am;
import com.iqoption.view.ConfirmButtonView;
import com.iqoption.x.R;

/* compiled from: KycQuestionSingleChoiceFragment2 */
public class e extends Fragment implements b {
    public static final String TAG = "com.iqoption.kyc.fragment.e.a.e";
    private com.iqoption.util.am.a cKG = new f(this);
    private OnBackStackChangedListener cKO;
    private nn cML;
    private int cNc;
    private com.iqoption.microservice.a.a.a.e cNd;
    private a cNj;

    /* compiled from: KycQuestionSingleChoiceFragment2 */
    public interface a {
        void b(int i, com.iqoption.microservice.a.a.a.e eVar, int i2, b bVar);
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

    final /* synthetic */ void dY(boolean z) {
        if (z && ac.c(getFragmentManager(), TAG)) {
            am.n(zzakw());
        }
    }

    public static e b(Integer num, com.iqoption.microservice.a.a.a.e eVar) {
        e eVar2 = new e();
        Bundle bundle = new Bundle();
        bundle.putInt("ARG_QUESTION_TYPE", num.intValue());
        bundle.putParcelable("ARG_QUESTION", eVar);
        eVar2.setArguments(bundle);
        return eVar2;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        bundle = getArguments();
        if (bundle != null) {
            this.cNc = bundle.getInt("ARG_QUESTION_TYPE");
            this.cNd = (com.iqoption.microservice.a.a.a.e) bundle.getParcelable("ARG_QUESTION");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.cML = (nn) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_kyc_question_single_choice, viewGroup, false);
        this.cML.bxT.setText(LocalizationUtil.gW(this.cNd.asy()));
        for (final com.iqoption.microservice.a.a.a.a aVar : this.cNd.asA()) {
            nv nvVar = (nv) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_kyc_radio_button, viewGroup, false);
            nvVar.getRoot().setTag(R.id.answer, aVar);
            nvVar.getRoot().setTag(R.id.answerId, aVar.ask());
            nvVar.bxJ.setText(LocalizationUtil.gW(aVar.asm()));
            nvVar.bxK.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    e.this.h(aVar.ask());
                    e.this.aqn();
                }
            });
            this.cML.bxS.addView(nvVar.getRoot());
        }
        h(Integer.valueOf(-1));
        aqn();
        this.cML.bxE.bxH.setOnClickListener(new g(this));
        apX();
        this.cKO = new d(this, getContext(), com.iqoption.kyc.a.a.apP(), getFragmentManager(), new c(getContext()).Dh(), apR(), apS(), TAG) {
            final /* synthetic */ e cNm;

            protected void apV() {
                super.apV();
                this.cNm.apX();
            }
        };
        getFragmentManager().addOnBackStackChangedListener(this.cKO);
        return this.cML.getRoot();
    }

    final /* synthetic */ void bq(View view) {
        int aqv = aqv();
        a aVar = this.cNj;
        int i = this.cNc;
        com.iqoption.microservice.a.a.a.e eVar = this.cNd;
        if (aqv == -1) {
            aqv = 0;
        }
        aVar.b(i, eVar, aqv, this);
    }

    private void apX() {
        i.b((AppCompatActivity) zzakw(), this.cML.bxz.toolbar);
    }

    private int aqv() {
        int childCount = this.cML.bxS.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cML.bxS.getChildAt(i);
            Integer num = (Integer) childAt.getTag(R.id.answerId);
            if (num != null && childAt.findViewById(R.id.checkMark).getVisibility() == 0) {
                return num.intValue();
            }
        }
        return -1;
    }

    private void h(Integer num) {
        int childCount = this.cML.bxS.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cML.bxS.getChildAt(i);
            childAt.findViewById(R.id.checkMark).setVisibility(((Integer) childAt.getTag(R.id.answerId)).equals(num) ? 0 : 4);
        }
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
            this.cNj = (a) context;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.toString());
        stringBuilder.append(" must implement OnFragmentInteractionListener");
        throw new RuntimeException(stringBuilder.toString());
    }

    public void onDetach() {
        super.onDetach();
        this.cNj = null;
    }

    public void onDestroyView() {
        com.iqoption.core.i.d(TAG, "onDestroyView");
        getFragmentManager().removeOnBackStackChangedListener(this.cKO);
        super.onDestroyView();
    }

    private void aqn() {
        ConfirmButtonView confirmButtonView = this.cML.bxE.bxH;
        boolean z = (this.cNd.asz().booleanValue() && aqv() == -1) ? false : true;
        confirmButtonView.setEnabled(z);
    }
}
