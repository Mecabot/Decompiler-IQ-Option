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
import com.iqoption.d.uy;
import com.iqoption.dto.Event;
import com.iqoption.dto.entity.result.KycState;
import com.iqoption.mobbtech.connect.response.e;
import com.iqoption.util.am;
import com.iqoption.withdrawal.crypto.kyc.KycWithdrawalStatus;
import com.iqoption.x.R;

/* compiled from: WithdrawalCryptoKycFragment */
public class b extends Fragment {
    private static final String TAG = "com.iqoption.withdrawal.crypto.fragment.b";
    private String assetName;
    private KycState cJn;
    private double cnW;
    private com.iqoption.withdrawal.crypto.a.a.a dSP;
    private com.iqoption.microservice.a.b.a dSR;
    private boolean dSS;
    private a dST;
    private uy dSU;
    private boolean isVisible;

    /* compiled from: WithdrawalCryptoKycFragment */
    /* renamed from: com.iqoption.withdrawal.crypto.fragment.b$3 */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] dSW = new int[KycWithdrawalStatus.values().length];

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing block: B:11:0x0040, code:
            return;
     */
        static {
            /*
            r0 = com.iqoption.withdrawal.crypto.kyc.KycWithdrawalStatus.values();
            r0 = r0.length;
            r0 = new int[r0];
            dSW = r0;
            r0 = dSW;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = com.iqoption.withdrawal.crypto.kyc.KycWithdrawalStatus.NotFilled;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1;
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            r0 = dSW;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = com.iqoption.withdrawal.crypto.kyc.KycWithdrawalStatus.DocumentsNotUploaded;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2;
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            r0 = dSW;	 Catch:{ NoSuchFieldError -> 0x002a }
            r1 = com.iqoption.withdrawal.crypto.kyc.KycWithdrawalStatus.UploadIsNotFinishingByUser;	 Catch:{ NoSuchFieldError -> 0x002a }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x002a }
            r2 = 3;
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            r0 = dSW;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r1 = com.iqoption.withdrawal.crypto.kyc.KycWithdrawalStatus.DocumentOnVerification;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0035 }
            r2 = 4;
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0035 }
        L_0x0035:
            r0 = dSW;	 Catch:{ NoSuchFieldError -> 0x0040 }
            r1 = com.iqoption.withdrawal.crypto.kyc.KycWithdrawalStatus.DocumentsIsDeclined;	 Catch:{ NoSuchFieldError -> 0x0040 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0040 }
            r2 = 5;
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0040 }
        L_0x0040:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iqoption.withdrawal.crypto.fragment.b.3.<clinit>():void");
        }
    }

    /* compiled from: WithdrawalCryptoKycFragment */
    public interface a {
        void b(KycWithdrawalStatus kycWithdrawalStatus);
    }

    public static b a(KycState kycState, com.iqoption.microservice.a.b.a aVar, boolean z, String str, double d) {
        b bVar = new b();
        Bundle bundle = new Bundle();
        bundle.putParcelable("ARG_KYC_STATE", kycState);
        bundle.putParcelable("ARG_KYC_DOCUMENTS_STATUS", aVar);
        bundle.putBoolean("ARG_3DS_DONE", z);
        bundle.putString("ARG_ASSET_NAME", str);
        bundle.putDouble("ARG_ASSET_AMOUNT", d);
        bVar.setArguments(bundle);
        return bVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bundle = getArguments();
        if (bundle != null) {
            this.cJn = (KycState) bundle.getParcelable("ARG_KYC_STATE");
            this.dSR = (com.iqoption.microservice.a.b.a) bundle.getParcelable("ARG_KYC_DOCUMENTS_STATUS");
            this.dSS = bundle.getBoolean("ARG_3DS_DONE");
            this.assetName = bundle.getString("ARG_ASSET_NAME");
            this.cnW = bundle.getDouble("ARG_ASSET_AMOUNT");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.dSU = (uy) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_withdrawal_crypto_kyc, viewGroup, false);
        this.dSU.getRoot().setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                am.n(b.this.zzakw());
                b.this.zzakw().getSupportFragmentManager().popBackStackImmediate();
            }
        });
        b(this.cJn, this.dSR);
        this.dSU.bHz.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                KycWithdrawalStatus a = com.iqoption.withdrawal.crypto.a.a(b.this.cJn, b.this.dSR);
                b.this.dST.b(a);
                com.iqoption.withdrawal.crypto.a.a.a.aI(Event.CATEGORY_BUTTON_PRESSED, "crypto_withdraw-popup-kyc").a(a).send();
            }
        });
        this.dSP = aOj();
        return this.dSU.getRoot();
    }

    public void b(KycState kycState, com.iqoption.microservice.a.b.a aVar) {
        this.cJn = kycState;
        this.dSR = aVar;
        int i = AnonymousClass3.dSW[com.iqoption.withdrawal.crypto.a.a(kycState, aVar).ordinal()];
        int i2 = R.string.withdrawal_kyc_not_filled_3ds_required;
        TextView textView;
        switch (i) {
            case 1:
                this.dSU.agA.setText(R.string.withdrawal_kyc_not_filled_title);
                textView = this.dSU.aip;
                if (this.dSS) {
                    i2 = R.string.withdrawal_kyc_not_filled;
                }
                textView.setText(i2);
                this.dSU.bHz.setText(R.string.specify);
                return;
            case 2:
            case 3:
                this.dSU.agA.setText(R.string.withdrawal_kyc_documents_not_uploaded_title);
                this.dSU.aip.setText(this.dSS ? R.string.withdrawal_kyc_documents_not_uploaded : R.string.withdrawal_kyc_documents_not_uploaded_3ds_required);
                this.dSU.bHz.setText(R.string.upload_documents);
                aOl();
                return;
            case 4:
                this.dSU.agA.setText(R.string.withdrawal_kyc_documents_on_verification_title);
                this.dSU.aip.setText(R.string.withdrawal_kyc_documents_on_verification);
                this.dSU.bHz.setText(R.string.got_it);
                return;
            case 5:
                this.dSU.agA.setText(R.string.withdrawal_kyc_documents_declined_title);
                textView = this.dSU.aip;
                if (this.dSS) {
                    i2 = R.string.withdrawal_kyc_not_filled;
                }
                textView.setText(i2);
                this.dSU.bHz.setText(R.string.upload_documents);
                aOl();
                return;
            default:
                this.dSU.bHz.setText(R.string.upload_documents);
                aOl();
                return;
        }
    }

    private void aOl() {
        e b = com.iqoption.mobbtech.connect.request.api.b.b(0.0d, this.cnW, this.assetName);
        if (b == null || this.cnW >= b.getMinimum()) {
            this.dSU.bHz.setEnabled(true);
        } else {
            this.dSU.bHz.setEnabled(false);
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (getParentFragment() instanceof a) {
            this.dST = (a) getParentFragment();
        } else if (context instanceof a) {
            this.dST = (a) context;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(context.toString());
            stringBuilder.append(" must implement OnFragmentInteractionListener");
            throw new RuntimeException(stringBuilder.toString());
        }
    }

    public void onDetach() {
        super.onDetach();
        this.dST = null;
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
        return (!this.isVisible || this.assetName == null) ? null : com.iqoption.withdrawal.crypto.a.a.a.aI(Event.CATEGORY_POPUP_SERVED, "crypto_withdraw-popup").fF(true).ku("kyc").ks(this.assetName);
    }
}
