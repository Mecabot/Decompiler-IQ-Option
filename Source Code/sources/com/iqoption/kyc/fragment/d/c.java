package com.iqoption.kyc.fragment.d;

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
import com.iqoption.d.nt;
import com.iqoption.kyc.a.b;
import com.iqoption.kyc.a.d;
import com.iqoption.kyc.i;
import com.iqoption.util.ac;
import com.iqoption.util.am;
import com.iqoption.x.R;

/* compiled from: KycQuestionYesNoFragment */
public class c extends Fragment implements b {
    public static final String TAG = "com.iqoption.kyc.fragment.d.c";
    private am adG;
    private com.iqoption.util.am.a cKG = new com.iqoption.util.am.a() {
        public void cp(boolean z) {
            if (z && c.this.isAdded() && ac.c(c.this.getFragmentManager(), c.TAG)) {
                am.n(c.this.zzakw());
            }
        }
    };
    private OnBackStackChangedListener cKO;
    private int cME;
    private int cMO;
    private int cMP;
    private String cMQ;
    private String cMR;
    private a cMS;
    private nt cMT;
    private String question;

    /* compiled from: KycQuestionYesNoFragment */
    public interface a {
        void a(int i, String str, int i2, String str2, b bVar);
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

    public static c a(int i, int i2, int i3, String str, String str2, String str3) {
        c cVar = new c();
        Bundle bundle = new Bundle();
        bundle.putInt("ARG_QUESTION_ID", i);
        bundle.putInt("ARG_YES_ANSWER_ID", i2);
        bundle.putInt("ARG_NO_ANSWER_ID", i3);
        bundle.putString("ARG_QUESTION", str);
        bundle.putString("ARG_YES_ANSWER", str2);
        bundle.putString("ARG_NO_ANSWER", str3);
        cVar.setArguments(bundle);
        return cVar;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        bundle = getArguments();
        if (bundle != null) {
            this.cME = bundle.getInt("ARG_QUESTION_ID");
            this.cMO = bundle.getInt("ARG_YES_ANSWER_ID");
            this.cMP = bundle.getInt("ARG_NO_ANSWER_ID");
            this.question = bundle.getString("ARG_QUESTION");
            this.cMQ = bundle.getString("ARG_YES_ANSWER");
            this.cMR = bundle.getString("ARG_NO_ANSWER");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.cMT = (nt) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_kyc_question_yes_no, viewGroup, false);
        this.cMT.bxT.setText(this.question);
        this.cMT.byD.setText(this.cMQ);
        this.cMT.byC.setText(this.cMR);
        this.cMT.byD.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                c.this.cMS.a(c.this.cME, c.this.question, c.this.cMO, c.this.cMQ, c.this);
            }
        });
        this.cMT.byC.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                c.this.cMS.a(c.this.cME, c.this.question, c.this.cMP, c.this.cMR, c.this);
            }
        });
        apX();
        this.cKO = new d(this, getContext(), com.iqoption.kyc.a.a.apP(), getFragmentManager(), new com.iqoption.kyc.c(getContext()).Dh(), apR(), apS(), TAG) {
            final /* synthetic */ c cMU;

            protected void apV() {
                super.apV();
                this.cMU.apX();
            }
        };
        getFragmentManager().addOnBackStackChangedListener(this.cKO);
        this.adG = new am(zzakw());
        return this.cMT.getRoot();
    }

    private void apX() {
        i.a((AppCompatActivity) zzakw(), this.cMT.bxz.toolbar);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof a) {
            this.cMS = (a) context;
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
        this.cMS = null;
    }

    public void onDestroyView() {
        com.iqoption.core.i.d(TAG, "onDestroyView");
        getFragmentManager().removeOnBackStackChangedListener(this.cKO);
        super.onDestroyView();
    }
}
