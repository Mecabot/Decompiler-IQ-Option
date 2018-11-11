package com.iqoption.kyc.fragment.e.a;

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
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import com.google.common.collect.ImmutableSet;
import com.iqoption.core.util.LocalizationUtil;
import com.iqoption.d.md;
import com.iqoption.d.nl;
import com.iqoption.kyc.a.b;
import com.iqoption.kyc.a.d;
import com.iqoption.kyc.c;
import com.iqoption.kyc.i;
import com.iqoption.microservice.a.a.a.e;
import com.iqoption.util.ac;
import com.iqoption.util.am;
import com.iqoption.x.R;
import java.util.ArrayList;
import java.util.List;

/* compiled from: KycQuestionMultiChoiceFragment2 */
public class a extends Fragment implements b {
    public static final String TAG = "com.iqoption.kyc.fragment.e.a.a";
    private com.iqoption.util.am.a cKG = new com.iqoption.util.am.a() {
        public void cp(boolean z) {
            if (z && ac.c(a.this.getFragmentManager(), a.TAG)) {
                am.n(a.this.zzakw());
            }
        }
    };
    private OnBackStackChangedListener cKO;
    private nl cMH;
    private int cNc;
    private e cNd;
    private a cNe;

    /* compiled from: KycQuestionMultiChoiceFragment2 */
    public interface a {
        void a(int i, e eVar, List<Integer> list, b bVar);
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

    public static a a(Integer num, e eVar) {
        a aVar = new a();
        Bundle bundle = new Bundle();
        bundle.putInt("ARG_QUESTION_TYPE", num.intValue());
        bundle.putParcelable("ARG_QUESTION", eVar);
        aVar.setArguments(bundle);
        return aVar;
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
        this.cMH = (nl) DataBindingUtil.inflate(layoutInflater.cloneInContext(new ContextThemeWrapper(getContext(), (int) R.style.KycCountryTheme)), R.layout.fragment_kyc_question_multi_choice, viewGroup, false);
        this.cMH.bxT.setText(LocalizationUtil.gW(this.cNd.asy()));
        for (com.iqoption.microservice.a.a.a.a aVar : this.cNd.asA()) {
            md mdVar = (md) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_kyc_check_box, viewGroup, false);
            mdVar.getRoot().setTag(R.id.answer, aVar);
            mdVar.getRoot().setTag(R.id.answerId, aVar.ask());
            mdVar.bxJ.setText(LocalizationUtil.gW(aVar.asm()));
            mdVar.bxL.setOnCheckedChangeListener(new b(this, mdVar));
            mdVar.bxK.setOnClickListener(new c(mdVar));
            this.cMH.bxS.addView(mdVar.getRoot());
        }
        this.cMH.bxE.bxH.setOnClickListener(new d(this));
        apX();
        this.cKO = new d(this, getContext(), com.iqoption.kyc.a.a.apP(), getFragmentManager(), new c(getContext()).Dh(), apR(), apS(), TAG) {
            final /* synthetic */ a cNi;

            protected void apV() {
                super.apV();
                this.cNi.apX();
            }
        };
        getFragmentManager().addOnBackStackChangedListener(this.cKO);
        aqn();
        return this.cMH.getRoot();
    }

    final /* synthetic */ void a(md mdVar, CompoundButton compoundButton, boolean z) {
        com.iqoption.microservice.a.a.a.a aVar = (com.iqoption.microservice.a.a.a.a) mdVar.getRoot().getTag(R.id.answer);
        if (z) {
            a(aVar);
        }
        aqn();
    }

    final /* synthetic */ void bp(View view) {
        this.cNe.a(this.cNc, this.cNd, aqu(), this);
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

    private void a(com.iqoption.microservice.a.a.a.a aVar) {
        int childCount = this.cMH.bxS.getChildCount();
        ImmutableSet n = ImmutableSet.n(aVar.asl());
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cMH.bxS.getChildAt(i);
            Integer num = (Integer) childAt.getTag(R.id.answerId);
            if (!(num == null || num.equals(aVar.ask()) || !n.contains(num))) {
                ((CheckBox) childAt.findViewById(R.id.checkBox)).setChecked(false);
            }
        }
    }

    private void apX() {
        i.b((AppCompatActivity) zzakw(), this.cMH.bxz.toolbar);
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
            this.cNe = (a) context;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.toString());
        stringBuilder.append(" must implement OnFragmentInteractionListener");
        throw new RuntimeException(stringBuilder.toString());
    }

    public void onDetach() {
        super.onDetach();
        this.cNe = null;
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
