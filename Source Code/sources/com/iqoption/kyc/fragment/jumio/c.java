package com.iqoption.kyc.fragment.jumio;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager.OnBackStackChangedListener;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.common.base.e;
import com.google.common.collect.ImmutableMap;
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.s;
import com.iqoption.d.ml;
import com.iqoption.d.nv;
import com.iqoption.kyc.a.d;
import com.iqoption.kyc.i;
import com.iqoption.util.ac;
import com.iqoption.util.am;
import com.iqoption.x.R;
import java.util.Iterator;

/* compiled from: KycDocumentAddressFragment */
public class c extends Fragment implements com.iqoption.kyc.a.b {
    public static final String TAG = "com.iqoption.kyc.fragment.jumio.c";
    private com.iqoption.util.am.a cKG = new com.iqoption.util.am.a() {
        public void cp(boolean z) {
            if (z && ac.c(c.this.getFragmentManager(), c.TAG)) {
                am.n(c.this.zzakw());
            }
        }
    };
    private OnBackStackChangedListener cKO;
    private a cLh;
    private ml cLi;
    private ImmutableMap<Integer, String> cLj = ImmutableMap.a(Integer.valueOf(R.string.web_kyc_docs_bank_statement), "BS", Integer.valueOf(R.string.web_kyc_docs_utility_bill), "UB", Integer.valueOf(R.string.web_kyc_docs_credit_card_statement), "CCS", Integer.valueOf(R.string.web_kyc_docs_phone_bill), "PB", Integer.valueOf(R.string.kyc_docs_type_custom), "CUSTOM");
    private boolean isInProgress;

    /* compiled from: KycDocumentAddressFragment */
    public interface a {
        s<?> ib(String str);
    }

    /* compiled from: KycDocumentAddressFragment */
    private static class b extends com.iqoption.system.c.b<c, Object> {
        public b(c cVar) {
            super(cVar, Object.class);
        }

        /* renamed from: a */
        public void z(c cVar, Object obj) {
            super.z(cVar, obj);
            cVar.dK(false);
        }

        /* renamed from: a */
        public void c(c cVar, Throwable th) {
            super.c(cVar, th);
            cVar.dK(false);
        }
    }

    public String apR() {
        return "IdentityProving";
    }

    public String apS() {
        return "AddressDocument";
    }

    public boolean apT() {
        return true;
    }

    public static c aqf() {
        return new c();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.cLi = (ml) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_kyc_document_address, viewGroup, false);
        Iterator sI = this.cLj.keySet().iterator();
        while (sI.hasNext()) {
            final Integer num = (Integer) sI.next();
            nv nvVar = (nv) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_kyc_radio_button, viewGroup, false);
            nvVar.getRoot().setId(num.intValue());
            nvVar.bxJ.setText(num.intValue());
            nvVar.bxK.setOnClickListener(new com.iqoption.view.d.b() {
                public void q(View view) {
                    c.this.fe(num.intValue());
                }
            });
            this.cLi.bxS.addView(nvVar.getRoot());
        }
        fe(((Integer) e.h(com.google.common.collect.s.a(this.cLj.keySet(), Integer.valueOf(0)), Integer.valueOf(0))).intValue());
        this.cLi.bxH.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                if (!c.this.isInProgress) {
                    c.this.dK(true);
                    o.a(c.this.cLh.ib(c.this.aqg()), new b(c.this), com.iqoption.core.d.a.aSe);
                }
            }
        });
        apX();
        this.cKO = new d(this, getContext(), com.iqoption.kyc.a.a.apP(), getFragmentManager(), new com.iqoption.kyc.c(getContext()).Dh(), apR(), apS(), TAG) {
            final /* synthetic */ c cLk;

            protected void apV() {
                super.apV();
                this.cLk.apX();
            }
        };
        getFragmentManager().addOnBackStackChangedListener(this.cKO);
        return this.cLi.getRoot();
    }

    private void apX() {
        i.a((AppCompatActivity) zzakw(), this.cLi.bxz.toolbar);
    }

    private String aqg() {
        int childCount = this.cLi.bxS.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cLi.bxS.getChildAt(i);
            int id = childAt.getId();
            if (childAt.findViewById(R.id.checkMark).getVisibility() == 0) {
                return (String) this.cLj.get(Integer.valueOf(id));
            }
        }
        return null;
    }

    private void fe(int i) {
        int childCount = this.cLi.bxS.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.cLi.bxS.getChildAt(i2);
            childAt.findViewById(R.id.checkMark).setVisibility(childAt.getId() == i ? 0 : 4);
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
            this.cLh = (a) context;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.toString());
        stringBuilder.append(" must implement OnFragmentInteractionListener");
        throw new RuntimeException(stringBuilder.toString());
    }

    public void onDetach() {
        super.onDetach();
        this.cLh = null;
    }

    public void onDestroyView() {
        com.iqoption.core.i.d(TAG, "onDestroyView");
        getFragmentManager().removeOnBackStackChangedListener(this.cKO);
        super.onDestroyView();
    }

    private void dK(boolean z) {
        this.isInProgress = z;
        this.cLi.bxH.f(z, false);
    }
}
