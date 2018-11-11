package com.iqoption.withdrawal.crypto.fragment.a;

import android.content.res.Resources;
import android.support.annotation.StringRes;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.content.res.ResourcesCompat;
import android.widget.ImageView;
import com.iqoption.d.vc;
import com.iqoption.dto.entity.result.KycState;
import com.iqoption.mobbtech.connect.response.e;
import com.iqoption.util.bg;
import com.iqoption.view.text.x;
import com.iqoption.withdrawal.crypto.fragment.d;
import com.iqoption.withdrawal.crypto.kyc.KycWithdrawalStatus;
import com.iqoption.x.R;
import java.text.DecimalFormat;
import java.util.Locale;

/* compiled from: WithdrawalCryptoWalletFixedAmountDelegate */
public class c extends b {
    private final String assetName;
    private KycState cJn;
    private final double cnW;
    private e dSM;
    private com.iqoption.microservice.a.b.a dSR;
    private final vc dTs;
    private final d dTu;
    private final boolean dTv;
    private final DecimalFormat duM;

    /* compiled from: WithdrawalCryptoWalletFixedAmountDelegate */
    public static final class a {
        private String assetName;
        private KycState cJn;
        private double cnW;
        private e dSM;
        private com.iqoption.microservice.a.b.a dSR;
        private com.iqoption.withdrawal.crypto.fragment.d.a dTr;
        private final vc dTs;
        private final d dTu;
        private boolean dTv;

        public a(d dVar, vc vcVar) {
            this.dTu = dVar;
            this.dTs = vcVar;
        }

        public a fI(boolean z) {
            this.dTv = z;
            return this;
        }

        public a e(e eVar) {
            this.dSM = eVar;
            return this;
        }

        public a W(double d) {
            this.cnW = d;
            return this;
        }

        public a kA(String str) {
            this.assetName = str;
            return this;
        }

        public a c(com.iqoption.withdrawal.crypto.fragment.d.a aVar) {
            this.dTr = aVar;
            return this;
        }

        public a j(KycState kycState) {
            this.cJn = kycState;
            return this;
        }

        public a d(com.iqoption.microservice.a.b.a aVar) {
            this.dSR = aVar;
            return this;
        }

        public c aOy() {
            c cVar = new c(this.dTu, this.dTs, this.assetName, this.cnW, this.dSM, this.dTv, this.cJn, this.dSR, null);
            cVar.b(this.dTr);
            return cVar;
        }
    }

    /* synthetic */ c(d dVar, vc vcVar, String str, double d, e eVar, boolean z, KycState kycState, com.iqoption.microservice.a.b.a aVar, AnonymousClass1 anonymousClass1) {
        this(dVar, vcVar, str, d, eVar, z, kycState, aVar);
    }

    private c(d dVar, vc vcVar, String str, double d, e eVar, boolean z, KycState kycState, com.iqoption.microservice.a.b.a aVar) {
        super(dVar, vcVar, str);
        this.dTu = dVar;
        this.dTs = vcVar;
        this.assetName = str;
        this.cnW = d;
        this.dSM = eVar;
        this.dTv = z;
        this.cJn = kycState;
        this.dSR = aVar;
        this.duM = com.iqoption.withdrawal.crypto.a.kr(str);
        e(d, str);
        aOx();
        axR();
        vcVar.bHE.addTextChangedListener(new x() {
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                super.onTextChanged(charSequence, i, i2, i3);
                c.this.axR();
            }
        });
    }

    private void e(double d, String str) {
        this.dTs.bHN.setText(String.format(Locale.US, "%s %s %s", new Object[]{this.dTu.getString(R.string.withdrawals), this.duM.format(d), str}));
    }

    private void aOx() {
        this.dTs.bHI.setVisibility(8);
        this.dTs.bHF.setVisibility(0);
        if (this.dTs.bHB != null) {
            Resources resources = this.dTu.getResources();
            int dimension = (int) resources.getDimension(R.dimen.withdrawal_crypto_height_fixed_amount);
            int dimension2 = (int) resources.getDimension(R.dimen.withdrawal_crypto_peek_height_fixed_amount);
            this.dTs.bHB.getLayoutParams().height = dimension;
            BottomSheetBehavior from = BottomSheetBehavior.from(this.dTs.bHB);
            from.setPeekHeight(dimension2);
            from.setState(4);
            this.dTs.bHB.requestLayout();
            this.dTs.bHB.invalidate();
        }
    }

    private void axR() {
        int i = 4;
        if (com.iqoption.withdrawal.crypto.a.a(this.cJn, this.dSR) == KycWithdrawalStatus.Done && this.dSM.A(this.cnW)) {
            String obj = this.dTs.bHE.getText().toString();
            boolean aF = com.iqoption.withdrawal.crypto.a.aF(obj, this.assetName);
            aOr();
            Object obj2 = this.cnW > this.dSM.auQ() ? 1 : null;
            if (!aF) {
                if (!obj.isEmpty()) {
                    hE(R.string.wrong_format);
                }
                fH(false);
            } else if (obj2 == null) {
                fH(false);
            } else {
                this.dTs.bHE.setEnabled(true);
                fH(true);
            }
            ImageView imageView = this.dTs.bHD;
            if (this.dTv) {
                i = 0;
            }
            imageView.setVisibility(i);
            return;
        }
        hE(R.string.you_are_not_able_to_withdraw_yet);
        this.dTs.bHD.setVisibility(4);
        this.dTs.bHE.setEnabled(false);
        fH(false);
    }

    private void aOr() {
        int color = ResourcesCompat.getColor(this.dTu.getResources(), R.color.grey_blur, this.dTu.getContext().getTheme());
        CharSequence format = String.format(Locale.US, "%s %s %s", new Object[]{this.dTu.getString(R.string.commission), this.duM.format(this.dSM.cVJ), this.assetName});
        bg.setDrawableRight(this.dTs.bHM, null);
        this.dTs.bHM.setText(format);
        this.dTs.bHM.setTextColor(color);
        this.dTs.bHM.setVisibility(0);
        this.dTs.bHG.setBackgroundColor(color);
        this.dTs.bHL.setVisibility(4);
    }

    private void hE(@StringRes int i) {
        int color = ResourcesCompat.getColor(this.dTu.getResources(), R.color.red, this.dTu.getContext().getTheme());
        this.dTs.bHM.setText(i);
        this.dTs.bHM.setVisibility(0);
        this.dTs.bHL.setVisibility(0);
        this.dTs.bHG.setBackgroundColor(color);
    }

    protected double aOs() {
        return this.cnW;
    }

    public void ky(String str) {
        this.dTs.bHE.setText(com.iqoption.withdrawal.crypto.a.aH(str, this.assetName));
        axR();
    }
}
