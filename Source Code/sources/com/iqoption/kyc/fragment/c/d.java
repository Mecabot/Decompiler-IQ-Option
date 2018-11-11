package com.iqoption.kyc.fragment.c;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager.OnBackStackChangedListener;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.iqoption.d.mj;
import com.iqoption.dto.entity.result.KycState;
import com.iqoption.kyc.a.b;
import com.iqoption.kyc.c;
import com.iqoption.kyc.e;
import com.iqoption.kyc.i;
import com.iqoption.util.am;
import com.iqoption.util.bg;
import com.iqoption.view.ConfirmButtonView;
import com.iqoption.view.text.w;
import com.iqoption.view.text.x;
import com.iqoption.view.text.z;
import com.iqoption.widget.NumPad;
import com.iqoption.widget.helper.ErrorBubbleHelper;
import com.iqoption.widget.helper.ErrorBubbleHelper.BubbleGravity;
import com.iqoption.x.R;
import java.util.Calendar;
import java.util.Date;

/* compiled from: KycDateOfBirthFragment */
public class d extends Fragment implements b {
    public static final String TAG = "com.iqoption.kyc.fragment.c.d";
    @Nullable
    private c cJI;
    private OnBackStackChangedListener cKO;
    @Nullable
    private e cKi;
    private com.iqoption.kyc.a.c cLR;
    private TextWatcher cMb = new x() {
        public void afterTextChanged(Editable editable) {
            d.this.aqn();
        }
    };
    private a cMq;
    private mj cMr;
    @Nullable
    private w cMs;
    private ErrorBubbleHelper cxj;

    /* compiled from: KycDateOfBirthFragment */
    public interface a {
        void b(Date date);
    }

    @NonNull
    public String apR() {
        return "PersonalData";
    }

    @NonNull
    public String apS() {
        return "InputBirthDate";
    }

    public boolean apT() {
        return true;
    }

    public static d c(KycState kycState, e eVar) {
        d dVar = new d();
        Bundle bundle = new Bundle();
        bundle.putParcelable("ARG_KYC_STATE", kycState);
        bundle.putParcelable("ARG_KYC_PROFILE", eVar);
        dVar.setArguments(bundle);
        return dVar;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        bundle = getArguments();
        if (bundle != null) {
            this.cJI = new c(getContext(), (KycState) bundle.getParcelable("ARG_KYC_STATE"));
            this.cKi = (e) bundle.getParcelable("ARG_KYC_PROFILE");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        LayoutInflater layoutInflater2 = layoutInflater;
        this.cMr = (mj) DataBindingUtil.inflate(layoutInflater2, R.layout.fragment_kyc_date_of_birth, viewGroup, false);
        this.cMr.bxH.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (d.this.cMs != null && d.this.cMs.isValid()) {
                    Calendar instance = Calendar.getInstance();
                    instance.set(d.this.cMs.getYear(), d.this.cMs.getMonth() - 1, d.this.cMs.getDay());
                    d.this.cMq.b(instance.getTime());
                }
            }
        });
        this.cxj = new ErrorBubbleHelper(getContext(), layoutInflater2);
        this.cxj.r(getContext(), R.dimen.sp15);
        this.cxj.p(getContext(), R.dimen.kyc_text_field_height);
        aqn();
        apX();
        this.cLR = new com.iqoption.kyc.a.c(this.cMr.bxP, apR(), apS(), "BirthDay", 5, this.cJI.Dh());
        this.cKO = new com.iqoption.kyc.a.d(this, getContext(), com.iqoption.kyc.a.a.apP(), getFragmentManager(), this.cJI.Dh(), apR(), apS(), TAG) {
            final /* synthetic */ d cMt;

            protected void apV() {
                super.apV();
                this.cMt.apX();
                if (this.cMt.cMr != null) {
                    this.cMt.cMr.bxP.setHideKeyboard(true);
                }
            }

            protected void apW() {
                super.apW();
                if (this.cMt.cMr != null) {
                    this.cMt.cMr.bxP.setHideKeyboard(false);
                }
                if (this.cMt.isAdded() && this.cMt.cxj != null) {
                    this.cMt.cxj.akr();
                }
            }
        };
        getFragmentManager().addOnBackStackChangedListener(this.cKO);
        this.cMr.bxR.setKeyListener(new NumPad.c() {
            public void en(int i) {
                d.this.cMr.bxP.dispatchKeyEvent(new KeyEvent(0, i));
                d.this.cMr.bxP.dispatchKeyEvent(new KeyEvent(1, i));
            }
        });
        this.cMs = this.cMr.bxP.getTextDateValidator();
        if (this.cMs != null) {
            this.cMs.setValidationListener(new z() {
                public void aqs() {
                    d.this.aqn();
                    zy();
                }

                private void zy() {
                    String string;
                    d.this.cxj.q(d.this.getContext(), R.dimen.kyc_error_bubble_width);
                    if (d.this.cMs.aJH() && !d.this.cMs.aJE()) {
                        string = d.this.getString(R.string.incorrect_day);
                        d.this.ff(R.string.incorrect_day);
                    } else if (d.this.cMs.aJI() && !d.this.cMs.aJF()) {
                        string = d.this.getString(R.string.incorrect_month);
                        d.this.ff(R.string.incorrect_month);
                    } else if (!d.this.cMs.aJJ() || d.this.cMs.aJG()) {
                        string = d.this.getString(R.string.incorrect_value);
                        d.this.ff(R.string.incorrect_value);
                    } else {
                        string = d.this.getString(R.string.incorrect_year);
                        d.this.ff(R.string.incorrect_year);
                    }
                    com.iqoption.kyc.a.a.c(d.this.getContext(), d.this.apR(), d.this.apS(), string, d.this.cJI.Dh());
                }

                public void aqt() {
                    d.this.aqn();
                    d.this.aqr();
                }

                public void p(int i, int i2, int i3) {
                    d.this.aqn();
                    if (!d.this.cMs.isValid()) {
                        zy();
                    } else if (!d.this.o(i, i2, i3)) {
                        d.this.cxj.q(d.this.getContext(), R.dimen.kyc_age_error_bubble_width);
                        d.this.ff(R.string.unconfirmed_age);
                    }
                }
            });
        }
        aqq();
        return this.cMr.getRoot();
    }

    private void aqq() {
        Date c = this.cJI != null ? this.cJI.c(this.cKi) : null;
        if (c != null) {
            Calendar instance = Calendar.getInstance();
            instance.setTime(c);
            StringBuilder stringBuilder = new StringBuilder();
            int i = instance.get(5);
            if (i < 10) {
                stringBuilder.append(0);
            }
            stringBuilder.append(i);
            i = instance.get(2) + 1;
            if (i < 10) {
                stringBuilder.append(0);
            }
            stringBuilder.append(i);
            stringBuilder.append(instance.get(1));
            this.cMr.bxP.setText(stringBuilder.toString());
        }
    }

    private void apX() {
        i.a((AppCompatActivity) zzakw(), this.cMr.bxz.toolbar);
    }

    public void onStart() {
        super.onStart();
        com.iqoption.core.d.a.aSe.postDelayed(new Runnable() {
            public void run() {
                am.b(d.this.getContext(), d.this.cMr.bxP);
                d.this.cMr.bxP.requestFocus();
                bg.e(d.this.cMr.bxP);
            }
        }, 400);
    }

    public void onStop() {
        com.iqoption.core.i.d(TAG, "onStop");
        super.onStop();
        if (this.cxj != null) {
            this.cxj.akr();
        }
    }

    public void onDestroyView() {
        com.iqoption.core.i.d(TAG, "onDestroyView");
        getFragmentManager().removeOnBackStackChangedListener(this.cKO);
        super.onDestroyView();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof a) {
            this.cMq = (a) context;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.toString());
        stringBuilder.append(" must implement OnFragmentInteractionListener");
        throw new RuntimeException(stringBuilder.toString());
    }

    public void onDetach() {
        super.onDetach();
        this.cMq = null;
    }

    private void aqn() {
        ConfirmButtonView confirmButtonView = this.cMr.bxH;
        boolean z = this.cMs != null && this.cMs.isValid() && o(this.cMs.getDay(), this.cMs.getMonth(), this.cMs.getYear());
        confirmButtonView.setEnabled(z);
    }

    private int n(int i, int i2, int i3) {
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        instance2.set(i3, i2 - 1, i);
        i = instance.get(1) - instance2.get(1);
        return instance.get(6) < instance2.get(6) ? i - 1 : i;
    }

    private boolean o(int i, int i2, int i3) {
        return n(i, i2, i3) >= 18;
    }

    private void ff(@StringRes int i) {
        this.cxj.a(this.cMr.bxP, this.cxj.e(getContext(), this.cMr.bxP) ? BubbleGravity.bottom : BubbleGravity.top, getString(i));
    }

    private void aqr() {
        this.cxj.akr();
    }
}
