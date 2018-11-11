package com.iqoption.withdrawal.crypto.fragment;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.common.util.concurrent.s;
import com.iqoption.core.i;
import com.iqoption.d.vc;
import com.iqoption.dto.Event;
import com.iqoption.dto.entity.position.Position;
import com.iqoption.dto.entity.result.KycState;
import com.iqoption.mobbtech.connect.response.e;
import com.iqoption.util.am;
import com.iqoption.util.be;
import com.iqoption.withdrawal.crypto.fragment.a.b;
import com.iqoption.x.R;

/* compiled from: WithdrawalCryptoWalletFragment */
public class d extends Fragment implements com.iqoption.withdrawal.crypto.barcode.a.a {
    private static final String TAG = "com.iqoption.withdrawal.crypto.fragment.d";
    private static boolean dTo;
    private String assetName;
    private KycState cJn;
    private double cnW;
    private boolean cnX;
    private e dSM;
    private com.iqoption.withdrawal.crypto.a.a.a dSP;
    private com.iqoption.microservice.a.b.a dSR;
    private boolean dTp;
    private b dTq;
    private a dTr;
    private vc dTs;
    private boolean isVisible;

    /* compiled from: WithdrawalCryptoWalletFragment */
    public interface a {
        s<?> g(String str, double d);
    }

    public static d a(String str, double d, e eVar, boolean z, KycState kycState, com.iqoption.microservice.a.b.a aVar) {
        d dVar = new d();
        Bundle bundle = new Bundle();
        bundle.putString("ARG_ASSET_NAME", str);
        bundle.putDouble("ARG_ASSET_AMOUNT", d);
        bundle.putParcelable("ARG_CRYPTO_PAYOUT_AVAILABLE", eVar);
        bundle.putBoolean("ARG_IS_AMOUNT_CHANGE_ALLOWED", z);
        bundle.putParcelable("ARG_KYC_STATE", kycState);
        bundle.putParcelable("ARG_KYC_DOCUMENTS_STATUS", aVar);
        dVar.setArguments(bundle);
        return dVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bundle = getArguments();
        if (bundle != null) {
            this.assetName = bundle.getString("ARG_ASSET_NAME");
            this.cnW = bundle.getDouble("ARG_ASSET_AMOUNT");
            this.dSM = (e) bundle.getParcelable("ARG_CRYPTO_PAYOUT_AVAILABLE");
            this.cnX = bundle.getBoolean("ARG_IS_AMOUNT_CHANGE_ALLOWED");
            this.cJn = (KycState) bundle.getParcelable("ARG_KYC_STATE");
            this.dSR = (com.iqoption.microservice.a.b.a) bundle.getParcelable("ARG_KYC_DOCUMENTS_STATUS");
        }
        if (!dTo) {
            dTo = be.bT(getContext());
        }
        this.dTp = be.aGC();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.dTs = (vc) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_withdrawal_crypto_wallet, viewGroup, false);
        OnClickListener anonymousClass1 = new OnClickListener() {
            public void onClick(View view) {
                am.n(d.this.zzakw());
                d.this.zzakw().getSupportFragmentManager().popBackStackImmediate();
            }
        };
        this.dTs.getRoot().setOnClickListener(anonymousClass1);
        if (this.dTs.bHC != null) {
            this.dTs.bHC.setOnClickListener(anonymousClass1);
        }
        boolean z = true;
        if (this.cnX) {
            com.iqoption.withdrawal.crypto.fragment.a.a.b d = new com.iqoption.withdrawal.crypto.fragment.a.a.b(this, this.dTs).V(this.cnW).kz(this.assetName).d(this.dSM);
            if (!(dTo && this.dTp)) {
                z = false;
            }
            this.dTq = d.fG(z).a(this.dTr).i(this.cJn).c(this.dSR).aOt();
        } else {
            com.iqoption.withdrawal.crypto.fragment.a.c.a e = new com.iqoption.withdrawal.crypto.fragment.a.c.a(this, this.dTs).W(this.cnW).kA(this.assetName).e(this.dSM);
            if (!(dTo && this.dTp)) {
                z = false;
            }
            this.dTq = e.fI(z).c(this.dTr).j(this.cJn).d(this.dSR).aOy();
        }
        this.dSP = aOj();
        return this.dTs.getRoot();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        this.dTq.onActivityResult(i, i2, intent);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (!this.dTq.a(i, strArr, iArr)) {
            super.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (getParentFragment() instanceof a) {
            this.dTr = (a) getParentFragment();
        } else if (context instanceof a) {
            this.dTr = (a) context;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(context.toString());
            stringBuilder.append(" must implement OnFragmentInteractionListener");
            throw new RuntimeException(stringBuilder.toString());
        }
    }

    public void onDetach() {
        super.onDetach();
        this.dTr = null;
        if (this.dTq != null) {
            this.dTq.b(null);
        }
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
            if (this.dTs != null && this.dTs.bHL.getVisibility() == 0) {
                this.dSP.kt(this.dTs.bHM.getText().toString());
            }
            this.dSP.send();
            this.dSP = null;
        }
    }

    protected com.iqoption.withdrawal.crypto.a.a.a aOj() {
        return (!this.isVisible || this.dSM == null) ? null : com.iqoption.withdrawal.crypto.a.a.a.aI(Event.CATEGORY_POPUP_SERVED, "crypto_withdraw-popup").fF(true).ku(Position.CLOSE_REASON_WITHDRAW).O(this.dSM.cVI.doubleValue()).R(this.dSM.cVI.doubleValue()).S(this.dSM.getMinimum()).ks(this.assetName);
    }

    public void a(Barcode barcode) {
        if (this.dTq != null) {
            this.dTq.a(barcode);
        }
    }
}
