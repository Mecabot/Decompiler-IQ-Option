package com.iqoption.kyc.fragment.b;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager.OnBackStackChangedListener;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.s;
import com.iqoption.core.i;
import com.iqoption.d.nh;
import com.iqoption.dto.entity.result.KycState;
import com.iqoption.kyc.a.d;
import com.iqoption.mobbtech.connect.response.l;
import com.iqoption.util.ac;
import com.iqoption.util.am;
import com.iqoption.view.text.x;
import com.iqoption.x.R;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* compiled from: KycPhoneConfirmFragment */
public class a extends Fragment implements com.iqoption.kyc.a.b {
    public static final String TAG = "com.iqoption.kyc.fragment.b.a";
    @Nullable
    private com.iqoption.kyc.c cJI;
    private com.iqoption.util.am.a cKG = new com.iqoption.util.am.a() {
        public void cp(boolean z) {
            if (z && a.this.isVisible() && ac.c(a.this.getFragmentManager(), a.TAG)) {
                am.n(a.this.zzakw());
            }
        }
    };
    private OnBackStackChangedListener cKO;
    private b cLL;
    private nh cLM;
    private int cLN;
    private CountDownTimer cLO;
    @Nullable
    private s<? extends l> cLP;
    private TextWatcher cLQ = new x() {
        public void afterTextChanged(Editable editable) {
            a.this.aqn();
        }
    };
    private com.iqoption.kyc.a.c cLR;
    private boolean cLf;

    /* compiled from: KycPhoneConfirmFragment */
    public interface b {
        s<? extends l> apl();

        void apm();

        s<? extends l> hZ(String str);
    }

    /* compiled from: KycPhoneConfirmFragment */
    private static class a extends com.iqoption.system.c.b<a, l> {
        public a(a aVar) {
            super((Object) aVar);
        }

        /* renamed from: a */
        public void z(a aVar, l lVar) {
            super.z(aVar, lVar);
            if (aVar.isAdded()) {
                aVar.dK(false);
                aVar.zzakw().invalidateOptionsMenu();
            }
        }

        /* renamed from: a */
        public void c(a aVar, Throwable th) {
            super.c(aVar, th);
            if (aVar.isAdded()) {
                aVar.dK(false);
                aVar.cLP = null;
                aVar.zzakw().invalidateOptionsMenu();
            }
        }
    }

    /* compiled from: KycPhoneConfirmFragment */
    private static class c extends com.iqoption.system.c.b<a, l> {
        c(a aVar) {
            super((Object) aVar);
        }

        /* renamed from: a */
        public void z(a aVar, l lVar) {
            super.z(aVar, lVar);
            aVar.dK(false);
            aVar.aql();
        }

        /* renamed from: a */
        public void c(a aVar, Throwable th) {
            super.c(aVar, th);
            aVar.dK(false);
        }
    }

    @NonNull
    public String apR() {
        return "PersonalData";
    }

    @NonNull
    public String apS() {
        return "PhoneConfirmation";
    }

    public static a e(KycState kycState) {
        a aVar = new a();
        Bundle bundle = new Bundle();
        bundle.putParcelable("ARG_KYC_STATE", kycState);
        aVar.setArguments(bundle);
        return aVar;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        bundle = getArguments();
        if (bundle != null) {
            this.cJI = new com.iqoption.kyc.c(getContext(), (KycState) bundle.getParcelable("ARG_KYC_STATE"));
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        setHasOptionsMenu(true);
        this.cLM = (nh) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_kyc_phone_confirm, viewGroup, false);
        this.cLM.bxH.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                a.this.cLf = true;
                a.this.dK(true);
                a.this.cLP = a.this.cLL.hZ(a.this.cLM.byh.getText().toString().trim());
                o.a(a.this.cLP, new a(a.this), com.iqoption.core.d.a.aSe);
            }
        });
        aqn();
        this.cLM.byh.addTextChangedListener(this.cLQ);
        this.cLM.bxR.setKeyListener(new com.iqoption.widget.NumPad.c() {
            public void en(int i) {
                a.this.cLM.byh.dispatchKeyEvent(new KeyEvent(0, i));
                a.this.cLM.byh.dispatchKeyEvent(new KeyEvent(1, i));
            }
        });
        apX();
        this.cLM.byu.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                s apl = a.this.cLL.apl();
                a.this.dK(true);
                o.a(apl, new c(a.this), com.iqoption.core.d.a.aSe);
            }
        });
        aql();
        this.cLR = new com.iqoption.kyc.a.c(this.cLM.byh, apR(), apS(), "ConfirmCode", 2, this.cJI.Dh());
        this.cKO = new d(this, getContext(), com.iqoption.kyc.a.a.apP(), getFragmentManager(), this.cJI.Dh(), apR(), apS(), TAG) {
            final /* synthetic */ a cLS;

            protected void apV() {
                super.apV();
                this.cLS.apX();
                if (this.cLS.cLM != null) {
                    this.cLS.cLM.byh.setHideKeyboard(true);
                }
                if (this.cLS.cJI != null && this.cLS.cJI.De()) {
                    i.d(a.TAG, "exit, phone is confirmed");
                    this.cLS.getFragmentManager().popBackStack();
                }
            }

            protected void apW() {
                super.apW();
                if (this.cLS.cLM != null) {
                    this.cLS.cLM.byh.setHideKeyboard(false);
                }
            }
        };
        getFragmentManager().addOnBackStackChangedListener(this.cKO);
        return this.cLM.getRoot();
    }

    public boolean apT() {
        return this.cLf;
    }

    private void apX() {
        com.iqoption.kyc.i.a((AppCompatActivity) zzakw(), this.cLM.bxz.toolbar);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(R.menu.kyc_confirm_phone_skip_menu, menu);
    }

    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        MenuItem findItem = menu.findItem(R.id.action_confirm_phone_skip);
        if (findItem != null) {
            boolean z = false;
            Object obj = (this.cLP == null || this.cLP.isDone() || this.cLP.isCancelled()) ? null : 1;
            if (ac.c(getFragmentManager(), TAG) && obj == null && this.cJI != null && !this.cJI.De() && (this.cJI.aoF() || this.cJI.aoE())) {
                z = true;
            }
            findItem.setVisible(z);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.action_confirm_phone_skip) {
            return super.onOptionsItemSelected(menuItem);
        }
        this.cLf = false;
        this.cLL.apm();
        return true;
    }

    public void onStart() {
        super.onStart();
        Window window = zzakw().getWindow();
        this.cLN = window.getAttributes().softInputMode;
        window.setSoftInputMode(3);
        am.a(this.cKG);
    }

    public void onStop() {
        super.onStop();
        am.b(this.cKG);
        zzakw().getWindow().setSoftInputMode(this.cLN);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof b) {
            this.cLL = (b) context;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.toString());
        stringBuilder.append(" must implement OnFragmentInteractionListener");
        throw new RuntimeException(stringBuilder.toString());
    }

    public void onDetach() {
        super.onDetach();
        this.cLL = null;
    }

    public void onDestroy() {
        super.onDestroy();
        getFragmentManager().removeOnBackStackChangedListener(this.cKO);
    }

    private void aql() {
        if (this.cJI != null) {
            if (this.cJI.aoE()) {
                this.cLM.byv.setVisibility(8);
                this.cLM.byu.setVisibility(0);
            } else {
                this.cLO = bz(this.cJI.aoD());
                this.cLO.start();
            }
            zzakw().invalidateOptionsMenu();
        }
    }

    @NonNull
    private CountDownTimer bz(long j) {
        return new CountDownTimer(j, 1000) {
            public void onTick(long j) {
                if (a.this.isVisible()) {
                    if (a.this.cLM.byu.getVisibility() == 0) {
                        com.iqoption.util.b.h(a.this.cLM.byu, a.this.cLM.byv).start();
                    }
                    TextView textView = a.this.cLM.byv;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(a.this.getString(R.string.kyc_resend_in));
                    stringBuilder.append(" ");
                    stringBuilder.append(bA(j));
                    textView.setText(stringBuilder.toString());
                    a.this.zzakw().invalidateOptionsMenu();
                }
            }

            public void onFinish() {
                a.this.aqm();
            }

            private String bA(long j) {
                return String.format(Locale.US, " %02d:%02d", new Object[]{Long.valueOf(TimeUnit.MILLISECONDS.toMinutes(j)), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(j)))});
            }
        };
    }

    private void aqm() {
        if (this.cLO != null) {
            this.cLO.cancel();
            this.cLO = null;
        }
        com.iqoption.util.b.h(this.cLM.byv, this.cLM.byu).start();
    }

    private void aqn() {
        boolean z = this.cLM.byh.getText().length() >= 6 && TextUtils.isDigitsOnly(this.cLM.byh.getText());
        this.cLM.bxH.setEnabled(z);
    }

    private void dK(boolean z) {
        this.cLM.bxH.f(z, false);
        this.cLM.byu.setEnabled(z ^ 1);
        this.cLM.byh.setEnabled(z ^ 1);
        zzakw().invalidateOptionsMenu();
    }
}
