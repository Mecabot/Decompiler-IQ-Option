package com.iqoption.kyc.fragment.c;

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
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.NumberPicker;
import android.widget.NumberPicker.Formatter;
import android.widget.NumberPicker.OnValueChangeListener;
import com.google.common.base.f;
import com.google.common.base.j;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.s;
import com.google.common.util.concurrent.o;
import com.iqoption.core.i;
import com.iqoption.d.mf;
import com.iqoption.dto.entity.iqbus.Country;
import com.iqoption.dto.entity.result.KycState;
import com.iqoption.kyc.e;
import com.iqoption.mobbtech.connect.request.api.d;
import com.iqoption.util.ac;
import com.iqoption.util.am;
import com.iqoption.util.k;
import com.iqoption.x.R;

/* compiled from: KycCountryFragment */
public class c extends Fragment implements com.iqoption.kyc.a.b {
    private static final String LOG_TAG = "com.iqoption.kyc.fragment.c.c";
    @Nullable
    private com.iqoption.kyc.c cJI;
    private com.iqoption.util.am.a cKG = new com.iqoption.util.am.a() {
        public void cp(boolean z) {
            if (z && ac.c(c.this.getFragmentManager(), c.LOG_TAG)) {
                am.n(c.this.zzakw());
            }
        }
    };
    private OnBackStackChangedListener cKO;
    @Nullable
    private e cKi;
    private b cMk;
    private mf cMl;
    private boolean cMm;
    @Nullable
    private Country cMn;

    /* compiled from: KycCountryFragment */
    public interface b {
        void a(Country country, boolean z);

        void b(Country country);
    }

    /* compiled from: KycCountryFragment */
    private static class a extends com.iqoption.system.c.b<c, ImmutableList<Country>> {
        public a(c cVar) {
            super((Object) cVar);
        }

        /* renamed from: b */
        public void z(c cVar, ImmutableList<Country> immutableList) {
            super.z(cVar, immutableList);
            if (immutableList.isEmpty()) {
                k.c(new RuntimeException("KYC. Empty countries list has been received from the server"));
            }
            if (cVar.isAdded()) {
                cVar.o(immutableList);
                cVar.cMl.bxE.bxH.f(false, false);
            }
        }

        /* renamed from: a */
        public void c(c cVar, Throwable th) {
            super.c(cVar, th);
            com.crashlytics.android.a.log("KYC. Unable to get countries list");
            k.c(th);
            if (cVar.isAdded()) {
                cVar.cMl.bxE.bxH.f(false, false);
            }
        }
    }

    @NonNull
    public String apR() {
        return "PersonalData";
    }

    public boolean apT() {
        return true;
    }

    public static c a(KycState kycState, e eVar, boolean z) {
        c cVar = new c();
        Bundle bundle = new Bundle();
        bundle.putParcelable("ARG_KYC_STATE", kycState);
        bundle.putParcelable("ARG_KYC_PROFILE", eVar);
        bundle.putBoolean("ARG_IS_CITIZEN_COUNTRY_FRAGMENT", z);
        cVar.setArguments(bundle);
        return cVar;
    }

    public static String dX(boolean z) {
        StringBuilder stringBuilder;
        String str;
        if (z) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(LOG_TAG);
            str = ".citizenship";
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(LOG_TAG);
            str = ".residential_country";
        }
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        bundle = getArguments();
        if (bundle != null) {
            this.cJI = new com.iqoption.kyc.c(getContext(), (KycState) bundle.getParcelable("ARG_KYC_STATE"));
            this.cKi = (e) bundle.getParcelable("ARG_KYC_PROFILE");
            this.cMm = bundle.getBoolean("ARG_IS_CITIZEN_COUNTRY_FRAGMENT");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.cMl = (mf) DataBindingUtil.inflate(layoutInflater.cloneInContext(new ContextThemeWrapper(getContext(), (int) R.style.KycCountryTheme)), R.layout.fragment_kyc_country, viewGroup, false);
        this.cMl.bxE.bxH.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (c.this.cMn == null) {
                    i.w(c.LOG_TAG, "country is not selected");
                    return;
                }
                if (c.this.cMm) {
                    c.this.cMk.b(c.this.cMn);
                } else {
                    if (!(c.this.cJI == null || c.this.cMn == null)) {
                        com.iqoption.kyc.a.a.a(c.this.getContext(), c.this.apR(), c.this.apS(), c.this.cJI.Dh(), c.this.cMn.nameShort);
                    }
                    c.this.cMk.a(c.this.cMn, c.this.cMl.bxM.isChecked());
                }
            }
        });
        this.cMl.bxN.setWrapSelectorWheel(false);
        if (this.cMm) {
            this.cMl.bxO.setText(R.string.kyc_enter_your_citizenship_country);
            this.cMl.bxM.setVisibility(8);
        } else {
            this.cMl.bxO.setText(R.string.kyc_enter_your_residental_country);
        }
        this.cMl.bxE.bxH.f(true, false);
        o.a(d.aus(), new a(this), com.iqoption.core.d.a.aSe);
        apX();
        this.cKO = new com.iqoption.kyc.a.d(this, getContext(), com.iqoption.kyc.a.a.apP(), getFragmentManager(), this.cJI.Dh(), apR(), apS(), dX(this.cMm)) {
            final /* synthetic */ c cMo;

            protected void apV() {
                super.apV();
                this.cMo.apX();
                this.cMo.cMl.bxN.requestFocus();
            }
        };
        this.cMl.bxM.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                com.iqoption.kyc.a.a.a(c.this.getContext(), z, c.this.apR(), c.this.apS(), "", c.this.cJI.Dh());
            }
        });
        getFragmentManager().addOnBackStackChangedListener(this.cKO);
        return this.cMl.getRoot();
    }

    @NonNull
    public String apS() {
        return this.cMm ? "InputCountry_Citizenship" : "InputCountry_Resident";
    }

    private void apX() {
        com.iqoption.kyc.i.a((AppCompatActivity) zzakw(), this.cMl.bxz.toolbar);
    }

    private void o(final ImmutableList<Country> immutableList) {
        int d;
        if (this.cJI != null) {
            long e;
            if (this.cMm) {
                e = this.cJI.e(this.cKi);
            } else {
                e = this.cJI.d(this.cKi);
            }
            d = s.d(immutableList, new j<Country>() {
                /* renamed from: c */
                public boolean apply(Country country) {
                    return f.equal(country.id, Long.valueOf(e));
                }
            });
        } else {
            d = -1;
        }
        this.cMl.bxN.setMinValue(0);
        this.cMl.bxN.setMaxValue(Math.max(0, immutableList.size() - 1));
        if (d != -1) {
            this.cMl.bxN.setValue(d);
            this.cMn = (Country) immutableList.get(d);
        }
        this.cMl.bxN.setOnValueChangedListener(new OnValueChangeListener() {
            public void onValueChange(NumberPicker numberPicker, int i, int i2) {
                c.this.cMn = (Country) immutableList.get(i2);
                String access$000 = c.LOG_TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("country picker, selected country: ");
                stringBuilder.append(c.this.cMn);
                i.v(access$000, stringBuilder.toString());
            }
        });
        this.cMl.bxN.setFormatter(new Formatter() {
            public String format(int i) {
                return i < immutableList.size() ? ((Country) immutableList.get(i)).name : "";
            }
        });
    }

    public void onStart() {
        super.onStart();
        am.a(this.cKG);
        if (ac.c(getFragmentManager(), dX(this.cMm))) {
            this.cMl.bxN.requestFocus();
        }
    }

    public void onStop() {
        super.onStop();
        am.b(this.cKG);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof b) {
            this.cMk = (b) context;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.toString());
        stringBuilder.append(" must implement OnFragmentInteractionListener");
        throw new RuntimeException(stringBuilder.toString());
    }

    public void onDetach() {
        super.onDetach();
        this.cMk = null;
    }

    public void onDestroyView() {
        i.d(dX(this.cMm), "onDestroyView");
        getFragmentManager().removeOnBackStackChangedListener(this.cKO);
        super.onDestroyView();
    }
}
