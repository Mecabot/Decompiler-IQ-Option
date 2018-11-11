package com.iqoption.kyc.fragment.b;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager.OnBackStackChangedListener;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
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
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.s;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import com.iqoption.core.i;
import com.iqoption.d.nf;
import com.iqoption.dto.entity.iqbus.Country;
import com.iqoption.dto.entity.result.KycState;
import com.iqoption.kyc.a.d;
import com.iqoption.kyc.f;
import com.iqoption.mobbtech.connect.response.l;
import com.iqoption.util.ac;
import com.iqoption.util.am;
import com.iqoption.util.az;
import com.iqoption.view.ConfirmButtonView;
import com.iqoption.view.text.x;
import com.iqoption.x.R;
import java.util.Locale;

/* compiled from: KycPhoneFragment */
public class c extends Fragment implements com.iqoption.kyc.a.b {
    public static final String TAG = "com.iqoption.kyc.fragment.b.c";
    private final PhoneNumberUtil ZJ = PhoneNumberUtil.xo();
    @Nullable
    private com.iqoption.kyc.c cJI;
    private f cJJ;
    private com.iqoption.util.am.a cKG = new com.iqoption.util.am.a() {
        public void cp(boolean z) {
            if (z && c.this.isVisible() && ac.c(c.this.getFragmentManager(), c.TAG)) {
                am.n(c.this.zzakw());
            }
        }
    };
    private OnBackStackChangedListener cKO;
    private int cLN;
    private com.iqoption.kyc.a.c cLR;
    private b cLW;
    private nf cLX;
    private TextWatcher cuS = new x() {
        public void afterTextChanged(Editable editable) {
            c.this.aqn();
        }
    };

    /* compiled from: KycPhoneFragment */
    public interface b {
        void apm();

        s<? extends l> v(int i, long j);
    }

    /* compiled from: KycPhoneFragment */
    private static class a extends com.iqoption.system.c.b<c, l> {
        public a(c cVar) {
            super((Object) cVar);
        }

        /* renamed from: a */
        public void z(c cVar, l lVar) {
            super.z(cVar, lVar);
            cVar.dK(false);
        }

        /* renamed from: a */
        public void c(c cVar, Throwable th) {
            super.c(cVar, th);
            cVar.dK(false);
        }
    }

    @NonNull
    public String apR() {
        return "PersonalData";
    }

    @NonNull
    public String apS() {
        return "InputPhone";
    }

    public boolean apT() {
        return true;
    }

    public static c g(KycState kycState) {
        c cVar = new c();
        Bundle bundle = new Bundle();
        bundle.putParcelable("ARG_KYC_STATE", kycState);
        cVar.setArguments(bundle);
        return cVar;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        bundle = getArguments();
        if (bundle != null) {
            this.cJI = new com.iqoption.kyc.c(getContext(), (KycState) bundle.getParcelable("ARG_KYC_STATE"));
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.cLX = (nf) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_kyc_phone, viewGroup, false);
        this.cLX.bxH.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                PhoneNumber b = c.this.aqo();
                c.this.dK(true);
                o.a(c.this.cLW.v(b.xE(), b.ye()), new a(c.this), com.iqoption.core.d.a.aSe);
            }
        });
        ajy();
        PhoneNumber aoB = this.cJI.aoB();
        if (aoB.yd() || aoB.yc()) {
            this.cLX.bif.setText(az.w(aoB.xE(), aoB.ye()));
        }
        aqn();
        this.cLX.bif.addTextChangedListener(this.cuS);
        this.cLX.bxR.setKeyListener(new com.iqoption.widget.NumPad.c() {
            public void en(int i) {
                c.this.cLX.bif.dispatchKeyEvent(new KeyEvent(0, i));
                c.this.cLX.bif.dispatchKeyEvent(new KeyEvent(1, i));
            }
        });
        apX();
        this.cLR = new com.iqoption.kyc.a.c(this.cLX.bif, apR(), apS(), "Phone", 1, this.cJI.Dh());
        this.cKO = new d(this, getContext(), com.iqoption.kyc.a.a.apP(), getFragmentManager(), this.cJI.Dh(), apR(), apS(), TAG) {
            final /* synthetic */ c cLY;

            protected void apV() {
                super.apV();
                this.cLY.apX();
                if (this.cLY.cLX != null) {
                    this.cLY.cLX.bif.setHideKeyboard(true);
                }
                if (this.cLY.cJI != null && this.cLY.cJI.De()) {
                    String str = c.TAG;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("exit, phone is confirmed = ");
                    stringBuilder.append(this.cLY.cJI.De());
                    i.d(str, stringBuilder.toString());
                    this.cLY.getFragmentManager().popBackStack();
                }
            }

            protected void apW() {
                super.apW();
                if (this.cLY.cLX != null) {
                    this.cLY.cLX.bif.setHideKeyboard(false);
                }
            }
        };
        getFragmentManager().addOnBackStackChangedListener(this.cKO);
        return this.cLX.getRoot();
    }

    private void apX() {
        com.iqoption.kyc.i.a((AppCompatActivity) zzakw(), this.cLX.bxz.toolbar);
    }

    private void ajy() {
        o.a(this.cJJ.aoP(), new com.iqoption.system.c.b<c, Country>(this) {
            /* renamed from: a */
            public void z(c cVar, Country country) {
                super.z(cVar, country);
                if (cVar.isAdded() && c.this.cJI != null) {
                    CharSequence a = c.this.cJI.a(country);
                    String str = c.TAG;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("setPhoneNumberHint: ");
                    stringBuilder.append(a);
                    i.d(str, stringBuilder.toString());
                    c.this.cLX.bif.setHint(a);
                }
            }

            /* renamed from: a */
            public void c(c cVar, Throwable th) {
                super.c(cVar, th);
                if (cVar.isAdded() && c.this.cJI != null) {
                    CharSequence a = c.this.cJI.a(null);
                    String str = c.TAG;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("setPhoneNumberHint (no country from server): ");
                    stringBuilder.append(a);
                    i.d(str, stringBuilder.toString());
                    c.this.cLX.bif.setHint(a);
                }
            }
        }, com.iqoption.core.d.a.aSe);
    }

    private PhoneNumber aqo() {
        try {
            return this.ZJ.b(this.cLX.bif.getText().toString(), Locale.getDefault().getCountry());
        } catch (NumberParseException unused) {
            return new PhoneNumber();
        }
    }

    public void onDestroyView() {
        i.d(TAG, "onDestroyView");
        getFragmentManager().removeOnBackStackChangedListener(this.cKO);
        super.onDestroyView();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof b) {
            this.cLW = (b) context;
            this.cJJ = new f(context);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.toString());
        stringBuilder.append(" must implement OnFragmentInteractionListener");
        throw new RuntimeException(stringBuilder.toString());
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(R.menu.kyc_skip_phone_menu, menu);
    }

    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        MenuItem findItem = menu.findItem(R.id.action_skip_phone);
        if (findItem != null) {
            boolean z = ac.c(getFragmentManager(), TAG) && this.cJI != null && !this.cJI.De() && (this.cJI.aoF() || this.cJI.aoE());
            findItem.setVisible(z);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.action_skip_phone) {
            return super.onOptionsItemSelected(menuItem);
        }
        this.cLW.apm();
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

    public void onDetach() {
        super.onDetach();
        this.cLW = null;
    }

    private void dK(boolean z) {
        this.cLX.bxH.f(z, false);
        this.cLX.bxR.setEnabled(z ^ 1);
        this.cLX.bif.setEnabled(z ^ 1);
    }

    private void aqn() {
        try {
            PhoneNumber aqo = aqo();
            ConfirmButtonView confirmButtonView = this.cLX.bxH;
            boolean z = aqo.yc() && aqo.yd() && this.ZJ.b(aqo);
            confirmButtonView.setEnabled(z);
        } catch (Exception unused) {
            this.cLX.bxH.setEnabled(false);
        }
    }
}
