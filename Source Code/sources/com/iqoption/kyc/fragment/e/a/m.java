package com.iqoption.kyc.fragment.e.a;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager.OnBackStackChangedListener;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.s;
import com.iqoption.d.np;
import com.iqoption.kyc.a.d;
import com.iqoption.kyc.c;
import com.iqoption.kyc.i;
import com.iqoption.mobbtech.connect.response.l;
import com.iqoption.view.text.x;
import com.iqoption.x.R;

/* compiled from: KycWarningFragment2 */
public class m extends Fragment implements com.iqoption.kyc.a.b {
    public static final String TAG = "com.iqoption.kyc.fragment.e.a.m";
    private c cJI;
    private OnBackStackChangedListener cKO;
    private boolean cLf;
    private a cNs;
    private np cNt;
    private String cNu;
    private boolean cNv;

    /* compiled from: KycWarningFragment2 */
    public interface a {
        void apr();

        s<? extends l> ia(@Nullable String str);
    }

    /* compiled from: KycWarningFragment2 */
    private static class b extends com.iqoption.system.c.b<m, l> {
        b(m mVar) {
            super((Object) mVar);
        }

        /* renamed from: a */
        public void z(m mVar, l lVar) {
            super.z(mVar, lVar);
            mVar.dK(false);
        }

        /* renamed from: a */
        public void c(m mVar, Throwable th) {
            super.c(mVar, th);
            mVar.dK(false);
        }
    }

    @NonNull
    public String apR() {
        return "TradingExperience";
    }

    @NonNull
    public String apS() {
        return "Warning";
    }

    public static m b(String str, Boolean bool) {
        m mVar = new m();
        Bundle bundle = new Bundle();
        bundle.putString("ARG_WARNING", str);
        bundle.putBoolean("ARG_IS_SHOW_USER_SIGNATURE_FIELD", bool.booleanValue());
        mVar.setArguments(bundle);
        return mVar;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        bundle = getArguments();
        if (bundle != null) {
            this.cNu = bundle.getString("ARG_WARNING");
            this.cNv = bundle.getBoolean("ARG_IS_SHOW_USER_SIGNATURE_FIELD");
        }
        this.cJI = new c(getContext());
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.cNt = (np) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_kyc_question_warning2, viewGroup, false);
        if (!TextUtils.isEmpty(this.cNu)) {
            this.cNt.byB.setText(Html.fromHtml(this.cNu));
        }
        if (this.cNv) {
            this.cNt.byx.setVisibility(8);
            this.cNt.byA.setVisibility(0);
            this.cNt.byz.setVisibility(0);
            this.cNt.byy.setVisibility(0);
        } else {
            this.cNt.byx.setVisibility(0);
            this.cNt.byA.setVisibility(8);
            this.cNt.byz.setVisibility(8);
            this.cNt.byy.setVisibility(8);
        }
        this.cNt.bxH.setEnabled(this.cNv ^ 1);
        if (this.cNv) {
            this.cNt.byy.addTextChangedListener(new x() {
                public void afterTextChanged(Editable editable) {
                    m.this.cNt.bxH.setEnabled(m.this.cJI.hW(editable.toString()));
                }
            });
        }
        this.cNt.bxH.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                Object obj = m.this.cNv ? m.this.cNt.byy.getText().toString() : null;
                if (!TextUtils.isEmpty(obj) || !m.this.cNv) {
                    m.this.cLf = true;
                    m.this.dK(true);
                    o.a(m.this.cNs.ia(obj), new b(m.this), com.iqoption.core.d.a.aSe);
                }
            }
        });
        this.cNt.byw.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                m.this.cLf = false;
                com.iqoption.kyc.a.a.b(m.this.getContext(), m.this.apR(), m.this.apS(), m.this.cJI.Dh());
                m.this.cNs.apr();
            }
        });
        this.cNt.byB.setMovementMethod(new ScrollingMovementMethod());
        apX();
        this.cKO = new d(this, getContext(), com.iqoption.kyc.a.a.apP(), getFragmentManager(), this.cJI.Dh(), apR(), apS(), TAG) {
            final /* synthetic */ m cNw;

            protected void apV() {
                super.apV();
                this.cNw.apX();
            }
        };
        getFragmentManager().addOnBackStackChangedListener(this.cKO);
        return this.cNt.getRoot();
    }

    public boolean apT() {
        return this.cLf;
    }

    private void apX() {
        i.b((AppCompatActivity) zzakw(), this.cNt.bxz.toolbar);
        zzakw().invalidateOptionsMenu();
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof a) {
            this.cNs = (a) context;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.toString());
        stringBuilder.append(" must implement OnFragmentInteractionListener");
        throw new RuntimeException(stringBuilder.toString());
    }

    public void onDetach() {
        super.onDetach();
        this.cNs = null;
    }

    public void onDestroyView() {
        com.iqoption.core.i.d(TAG, "onDestroyView");
        getFragmentManager().removeOnBackStackChangedListener(this.cKO);
        super.onDestroyView();
    }

    private void dK(boolean z) {
        this.cNt.bxH.f(z, false);
        this.cNt.byw.setEnabled(z ^ 1);
    }
}
