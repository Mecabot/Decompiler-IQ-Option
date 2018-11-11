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
import com.google.common.collect.Ordering;
import com.iqoption.d.nn;
import com.iqoption.d.nv;
import com.iqoption.dto.entity.result.KycQuestionsResult.Answer;
import com.iqoption.kyc.a.d;
import com.iqoption.kyc.c;
import com.iqoption.kyc.i;
import com.iqoption.util.ac;
import com.iqoption.util.am;
import com.iqoption.x.R;
import java.util.HashMap;

/* compiled from: KycQuestionSingleChoiceFragment */
public class b extends Fragment implements com.iqoption.kyc.a.b {
    public static final String TAG = "com.iqoption.kyc.fragment.d.b";
    private com.iqoption.util.am.a cKG = new com.iqoption.util.am.a() {
        public void cp(boolean z) {
            if (z && ac.c(b.this.getFragmentManager(), b.TAG)) {
                am.n(b.this.zzakw());
            }
        }
    };
    private OnBackStackChangedListener cKO;
    private int cME;
    private HashMap<Integer, Answer> cMF;
    private a cMK;
    private nn cML;
    private String question;

    /* compiled from: KycQuestionSingleChoiceFragment */
    public interface a {
        void b(int i, String str, int i2, String str2, com.iqoption.kyc.a.b bVar);
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

    public static b a(int i, String str, HashMap<Integer, Answer> hashMap) {
        b bVar = new b();
        Bundle bundle = new Bundle();
        bundle.putInt("ARG_QUESTION_ID", i);
        bundle.putString("ARG_QUESTION", str);
        bundle.putSerializable("ARG_ANSWERS", hashMap);
        bVar.setArguments(bundle);
        return bVar;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        bundle = getArguments();
        if (bundle != null) {
            this.cME = bundle.getInt("ARG_QUESTION_ID");
            this.question = bundle.getString("ARG_QUESTION");
            this.cMF = (HashMap) bundle.getSerializable("ARG_ANSWERS");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.cML = (nn) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_kyc_question_single_choice, viewGroup, false);
        this.cML.bxT.setText(this.question);
        for (final Integer num : Ordering.natural().sortedCopy(this.cMF.keySet())) {
            Answer answer = (Answer) this.cMF.get(num);
            nv nvVar = (nv) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_kyc_radio_button, viewGroup, false);
            nvVar.getRoot().setTag(R.id.answer, answer);
            nvVar.getRoot().setTag(R.id.answerId, num);
            nvVar.bxJ.setText(answer.name);
            nvVar.bxK.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    b.this.fe(num.intValue());
                    b.this.aqn();
                }
            });
            this.cML.bxS.addView(nvVar.getRoot());
        }
        fe(-1);
        aqn();
        this.cML.bxE.bxH.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                int b = b.this.aqv();
                b.this.cMK.b(b.this.cME, b.this.question, b != -1 ? b : 0, ((Answer) b.this.cMF.get(Integer.valueOf(b))).name, b.this);
            }
        });
        apX();
        this.cKO = new d(this, getContext(), com.iqoption.kyc.a.a.apP(), getFragmentManager(), new c(getContext()).Dh(), apR(), apS(), TAG) {
            final /* synthetic */ b cMM;

            protected void apV() {
                super.apV();
                this.cMM.apX();
            }
        };
        getFragmentManager().addOnBackStackChangedListener(this.cKO);
        return this.cML.getRoot();
    }

    private void apX() {
        i.a((AppCompatActivity) zzakw(), this.cML.bxz.toolbar);
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

    private void fe(int i) {
        int childCount = this.cML.bxS.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.cML.bxS.getChildAt(i2);
            childAt.findViewById(R.id.checkMark).setVisibility(((Integer) childAt.getTag(R.id.answerId)).equals(Integer.valueOf(i)) ? 0 : 4);
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
            this.cMK = (a) context;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.toString());
        stringBuilder.append(" must implement OnFragmentInteractionListener");
        throw new RuntimeException(stringBuilder.toString());
    }

    public void onDetach() {
        super.onDetach();
        this.cMK = null;
    }

    public void onDestroyView() {
        com.iqoption.core.i.d(TAG, "onDestroyView");
        getFragmentManager().removeOnBackStackChangedListener(this.cKO);
        super.onDestroyView();
    }

    private void aqn() {
        this.cML.bxE.bxH.setEnabled(aqv() != -1);
    }
}
