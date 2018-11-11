package com.iqoption.withdrawal.crypto.fragment;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.iqoption.core.i;
import com.iqoption.d.uw;
import com.iqoption.dto.Event;
import com.iqoption.mobbtech.connect.response.e;
import com.iqoption.util.am;
import com.iqoption.util.l;
import com.iqoption.x.R;

/* compiled from: WithdrawalCrypto3dsFragment */
public class a extends Fragment {
    private static final String TAG = "com.iqoption.withdrawal.crypto.fragment.a";
    private String assetName;
    private e dSM;
    private a dSN;
    private uw dSO;
    private com.iqoption.withdrawal.crypto.a.a.a dSP;
    private boolean isVisible;

    /* compiled from: WithdrawalCrypto3dsFragment */
    public interface a {
        void aOk();
    }

    public static a a(e eVar, String str) {
        a aVar = new a();
        Bundle bundle = new Bundle();
        bundle.putParcelable("ARG_CRYPTO_PAYOUT_AVAILABLE", eVar);
        bundle.putString("ARG_ASSET_NAME", str);
        aVar.setArguments(bundle);
        return aVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bundle = getArguments();
        if (bundle != null) {
            this.dSM = (e) bundle.getParcelable("ARG_CRYPTO_PAYOUT_AVAILABLE");
            this.assetName = bundle.getString("ARG_ASSET_NAME");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.dSO = (uw) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_withdrawal_crypto_3ds, viewGroup, false);
        this.dSO.getRoot().setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                am.n(a.this.zzakw());
                a.this.zzakw().getSupportFragmentManager().popBackStackImmediate();
            }
        });
        c(this.dSM);
        this.dSO.bHy.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                a.this.dSN.aOk();
                com.iqoption.withdrawal.crypto.a.a.a aI = com.iqoption.withdrawal.crypto.a.a.a.aI(Event.CATEGORY_BUTTON_PRESSED, "crypto_withdraw-popup-deposit");
                if (!(a.this.dSM == null || a.this.dSM.cVK == null)) {
                    aI.P(a.this.dSM.cVK.doubleValue());
                }
                aI.send();
            }
        });
        this.dSP = aOj();
        return this.dSO.getRoot();
    }

    public void c(e eVar) {
        this.dSM = eVar;
        String r = l.r(Double.valueOf(com.iqoption.withdrawal.crypto.a.N(com.iqoption.withdrawal.crypto.a.b(eVar))));
        this.dSO.aip.setText(getString(R.string.need_to_make_3ds_payment, r));
        TextView textView = this.dSO.bHy;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getString(R.string.deposit));
        stringBuilder.append(' ');
        stringBuilder.append(r);
        textView.setText(stringBuilder.toString());
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (getParentFragment() instanceof a) {
            this.dSN = (a) getParentFragment();
        } else if (context instanceof a) {
            this.dSN = (a) context;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(context.toString());
            stringBuilder.append(" must implement OnFragmentInteractionListener");
            throw new RuntimeException(stringBuilder.toString());
        }
    }

    public void onDetach() {
        super.onDetach();
        this.dSN = null;
    }

    public void setMenuVisibility(boolean z) {
        super.setMenuVisibility(z);
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("setMenuVisibility ");
        stringBuilder.append(z);
        i.v(str, stringBuilder.toString());
        this.isVisible = z;
        if (z) {
            this.dSP = aOj();
        } else if (this.dSP != null) {
            this.dSP.send();
            this.dSP = null;
        }
    }

    protected com.iqoption.withdrawal.crypto.a.a.a aOj() {
        return (!this.isVisible || this.assetName == null) ? null : com.iqoption.withdrawal.crypto.a.a.a.aI(Event.CATEGORY_POPUP_SERVED, "crypto_withdraw-popup").fF(true).ku("insufficient turnover").O(this.dSM.cVI.doubleValue()).R(this.dSM.cVI.doubleValue()).S(this.dSM.getMinimum()).ks(this.assetName);
    }
}
