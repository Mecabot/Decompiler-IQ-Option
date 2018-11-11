package com.iqoption.kyc.fragment.d;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager.OnBackStackChangedListener;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.google.common.collect.Ordering;
import com.iqoption.d.md;
import com.iqoption.d.nl;
import com.iqoption.dto.entity.result.KycQuestionsResult.Answer;
import com.iqoption.dto.entity.result.KycState;
import com.iqoption.kyc.a.b;
import com.iqoption.kyc.a.d;
import com.iqoption.kyc.c;
import com.iqoption.kyc.i;
import com.iqoption.util.ac;
import com.iqoption.util.am;
import com.iqoption.x.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: KycQuestionMultiChoiceFragment */
public class a extends Fragment implements b {
    public static final String TAG = "com.iqoption.kyc.fragment.d.a";
    @Nullable
    private c cJI;
    private com.iqoption.util.am.a cKG = new com.iqoption.util.am.a() {
        public void cp(boolean z) {
            if (z && ac.c(a.this.getFragmentManager(), a.TAG)) {
                am.n(a.this.zzakw());
            }
        }
    };
    private OnBackStackChangedListener cKO;
    private int cME;
    private HashMap<Integer, Answer> cMF;
    private a cMG;
    private nl cMH;
    private String question;

    /* compiled from: KycQuestionMultiChoiceFragment */
    public interface a {
        void a(int i, String str, Collection<Integer> collection, HashMap<Integer, Answer> hashMap, b bVar);
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

    public static a a(KycState kycState, int i, String str, HashMap<Integer, Answer> hashMap) {
        a aVar = new a();
        Bundle bundle = new Bundle();
        bundle.putParcelable("ARG_KYC_STATE", kycState);
        bundle.putInt("ARG_QUESTION_ID", i);
        bundle.putString("ARG_QUESTION", str);
        bundle.putSerializable("ARG_ANSWERS", hashMap);
        aVar.setArguments(bundle);
        return aVar;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        bundle = getArguments();
        if (bundle != null) {
            this.cJI = new c(getContext(), (KycState) bundle.getParcelable("ARG_KYC_STATE"));
            this.cME = bundle.getInt("ARG_QUESTION_ID");
            this.question = bundle.getString("ARG_QUESTION");
            this.cMF = (HashMap) bundle.getSerializable("ARG_ANSWERS");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.cMH = (nl) DataBindingUtil.inflate(layoutInflater.cloneInContext(new ContextThemeWrapper(getContext(), (int) R.style.KycCountryTheme)), R.layout.fragment_kyc_question_multi_choice, viewGroup, false);
        this.cMH.bxT.setText(this.question);
        for (Integer num : Ordering.natural().sortedCopy(this.cMF.keySet())) {
            final md mdVar = (md) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_kyc_check_box, viewGroup, false);
            Answer answer = (Answer) this.cMF.get(num);
            mdVar.getRoot().setTag(R.id.answer, answer);
            mdVar.getRoot().setTag(R.id.answerId, num);
            mdVar.bxJ.setText(answer.name);
            mdVar.bxL.setOnCheckedChangeListener(new OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    Integer num = (Integer) mdVar.getRoot().getTag(R.id.answerId);
                    if (z && a.this.cJI != null) {
                        if (!a.this.cJI.eZ(num.intValue())) {
                            Iterator it = a.this.aqu().iterator();
                            while (it.hasNext()) {
                                Integer num2 = (Integer) it.next();
                                if (a.this.cJI.eZ(num2.intValue())) {
                                    a.this.fh(num2.intValue());
                                    break;
                                }
                            }
                        }
                        a.this.fg(num.intValue());
                    }
                    a.this.aqn();
                }
            });
            mdVar.bxK.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    mdVar.bxL.toggle();
                }
            });
            this.cMH.bxS.addView(mdVar.getRoot());
        }
        this.cMH.bxE.bxH.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                a.this.cMG.a(a.this.cME, a.this.question, a.this.aqu(), a.this.cMF, a.this);
            }
        });
        apX();
        this.cKO = new d(this, getContext(), com.iqoption.kyc.a.a.apP(), getFragmentManager(), new c(getContext()).Dh(), apR(), apS(), TAG) {
            final /* synthetic */ a cMI;

            protected void apV() {
                super.apV();
                this.cMI.apX();
            }
        };
        getFragmentManager().addOnBackStackChangedListener(this.cKO);
        aqn();
        return this.cMH.getRoot();
    }

    private ArrayList<Integer> aqu() {
        ArrayList<Integer> arrayList = new ArrayList();
        if (this.cMH == null) {
            return arrayList;
        }
        int childCount = this.cMH.bxS.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cMH.bxS.getChildAt(i);
            Integer num = (Integer) childAt.getTag(R.id.answerId);
            if (num != null && ((CheckBox) childAt.findViewById(R.id.checkBox)).isChecked()) {
                arrayList.add(num);
            }
        }
        return arrayList;
    }

    private void fg(int i) {
        int childCount = this.cMH.bxS.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.cMH.bxS.getChildAt(i2);
            Integer num = (Integer) childAt.getTag(R.id.answerId);
            if (!(num == null || num.equals(Integer.valueOf(i)))) {
                ((CheckBox) childAt.findViewById(R.id.checkBox)).setChecked(false);
            }
        }
    }

    private void fh(int i) {
        int childCount = this.cMH.bxS.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = this.cMH.bxS.getChildAt(i2);
            Integer num = (Integer) childAt.getTag(R.id.answerId);
            if (num == null || !num.equals(Integer.valueOf(i))) {
                i2++;
            } else {
                ((CheckBox) childAt.findViewById(R.id.checkBox)).setChecked(false);
                return;
            }
        }
    }

    private void apX() {
        i.a((AppCompatActivity) zzakw(), this.cMH.bxz.toolbar);
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
            this.cMG = (a) context;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.toString());
        stringBuilder.append(" must implement OnFragmentInteractionListener");
        throw new RuntimeException(stringBuilder.toString());
    }

    public void onDetach() {
        super.onDetach();
        this.cMG = null;
    }

    public void onDestroyView() {
        com.iqoption.core.i.d(TAG, "onDestroyView");
        getFragmentManager().removeOnBackStackChangedListener(this.cKO);
        super.onDestroyView();
    }

    private void aqn() {
        this.cMH.bxE.bxH.setEnabled(aqu().isEmpty() ^ 1);
    }
}
