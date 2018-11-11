package com.iqoption.withdrawal.crypto.fragment.a;

import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.content.res.ResourcesCompat;
import android.widget.EditText;
import android.widget.ImageView;
import com.google.common.util.concurrent.g;
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.s;
import com.iqoption.core.i;
import com.iqoption.d.vc;
import com.iqoption.dto.Currencies;
import com.iqoption.dto.Event;
import com.iqoption.dto.entity.result.KycState;
import com.iqoption.mobbtech.connect.response.e;
import com.iqoption.util.ag;
import com.iqoption.util.bg;
import com.iqoption.view.text.x;
import com.iqoption.withdrawal.crypto.kyc.KycWithdrawalStatus;
import com.iqoption.x.R;
import java.lang.ref.WeakReference;
import java.text.DecimalFormat;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: WithdrawalCryptoWalletChangedAmountDelegate */
public class a extends b {
    private static final String TAG = "com.iqoption.withdrawal.crypto.fragment.a.a";
    private final String assetName;
    private KycState cJn;
    private final double cnW;
    private com.iqoption.microservice.a.b.a dSR;
    final x dTA;
    private final vc dTs;
    private final com.iqoption.withdrawal.crypto.fragment.d dTu;
    private final boolean dTv;
    private e dTw;
    private e dTx;
    private a dTy;
    final x dTz;
    private final DecimalFormat duM;
    private final com.google.common.util.concurrent.x dwP;
    final ExecutorService executor;

    /* compiled from: WithdrawalCryptoWalletChangedAmountDelegate */
    public static final class b {
        private String assetName;
        private KycState cJn;
        private double cnW;
        private e dSM;
        private com.iqoption.microservice.a.b.a dSR;
        private com.iqoption.withdrawal.crypto.fragment.d.a dTr;
        private final vc dTs;
        private final com.iqoption.withdrawal.crypto.fragment.d dTu;
        private boolean dTv;

        public b(com.iqoption.withdrawal.crypto.fragment.d dVar, vc vcVar) {
            this.dTu = dVar;
            this.dTs = vcVar;
        }

        public b fG(boolean z) {
            this.dTv = z;
            return this;
        }

        public b d(e eVar) {
            this.dSM = eVar;
            return this;
        }

        public b V(double d) {
            this.cnW = d;
            return this;
        }

        public b kz(String str) {
            this.assetName = str;
            return this;
        }

        public b a(com.iqoption.withdrawal.crypto.fragment.d.a aVar) {
            this.dTr = aVar;
            return this;
        }

        public b i(KycState kycState) {
            this.cJn = kycState;
            return this;
        }

        public b c(com.iqoption.microservice.a.b.a aVar) {
            this.dSR = aVar;
            return this;
        }

        public a aOt() {
            a aVar = new a(this.dTu, this.dTs, this.assetName, this.cnW, this.dSM, this.dTv, this.cJn, this.dSR, null);
            aVar.b(this.dTr);
            return aVar;
        }
    }

    /* compiled from: WithdrawalCryptoWalletChangedAmountDelegate */
    private class c implements Runnable {
        WeakReference<a> aSh;
        private final double cnV;

        public c(double d) {
            i.v(a.TAG, "FeeAcquireRunnable");
            this.cnV = d;
            this.aSh = new WeakReference(a.this);
        }

        public void run() {
            i.v(a.TAG, "FeeAcquireRunnable - run");
            a.this.dwP.vY();
            i.v(a.TAG, "FeeAcquireRunnable - run acquired");
            com.iqoption.mobbtech.connect.response.a.a.ava().onStart();
            ag.b(o.a(com.iqoption.mobbtech.connect.response.a.a.ava().iM("PortfolioFragment"), new g<com.iqoption.core.microservices.billing.response.b.a, e>() {
                /* renamed from: d */
                public s<e> aP(com.iqoption.core.microservices.billing.response.b.a aVar) {
                    double aOs = a.this.aOs();
                    if (aOs <= 0.0d) {
                        aOs = a.this.cnW;
                    }
                    return com.iqoption.mobbtech.connect.request.api.b.a(aVar.getHost(), aVar.Uy(), c.this.cnV, aOs, a.this.assetName);
                }
            }), new d(this.aSh));
        }
    }

    /* compiled from: WithdrawalCryptoWalletChangedAmountDelegate */
    private class a extends com.iqoption.fragment.cashbox.o {
        public a(EditText editText) {
            super(editText, "crypto_withdraw-popup-change-amount");
        }

        protected void RW() {
            double aOs = a.this.aOs();
            com.iqoption.withdrawal.crypto.a.a.a.aI(Event.CATEGORY_TEXT_CHANGED, "crypto_withdraw-popup-change-amount").O(a.this.dTw.cVI.doubleValue()).T(aOs).ks(a.this.assetName).fD(a.this.dTw.A(aOs)).send();
        }
    }

    /* compiled from: WithdrawalCryptoWalletChangedAmountDelegate */
    private static class d extends com.iqoption.system.c.b<a, e> {
        public d(WeakReference<a> weakReference) {
            super((WeakReference) weakReference);
        }

        /* renamed from: a */
        public void z(@NonNull a aVar, e eVar) {
            String iK = a.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("FeeRequestCallback result: ");
            stringBuilder.append(eVar);
            i.v(iK, stringBuilder.toString());
            super.z(aVar, eVar);
            aVar.axR();
        }
    }

    /* synthetic */ a(com.iqoption.withdrawal.crypto.fragment.d dVar, vc vcVar, String str, double d, e eVar, boolean z, KycState kycState, com.iqoption.microservice.a.b.a aVar, AnonymousClass1 anonymousClass1) {
        this(dVar, vcVar, str, d, eVar, z, kycState, aVar);
    }

    private a(com.iqoption.withdrawal.crypto.fragment.d dVar, vc vcVar, String str, double d, e eVar, boolean z, KycState kycState, com.iqoption.microservice.a.b.a aVar) {
        super(dVar, vcVar, str);
        this.dwP = com.google.common.util.concurrent.x.d(5.0d);
        this.dTz = new x() {
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                super.onTextChanged(charSequence, i, i2, i3);
                a.this.axR();
            }
        };
        this.executor = Executors.newSingleThreadExecutor();
        this.dTA = new x() {
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                super.onTextChanged(charSequence, i, i2, i3);
                a.this.axR();
            }
        };
        this.dTu = dVar;
        this.dTs = vcVar;
        this.assetName = str;
        this.cnW = d;
        this.dTw = eVar;
        this.dTx = eVar;
        this.dTv = z;
        this.cJn = kycState;
        this.dSR = aVar;
        this.duM = com.iqoption.withdrawal.crypto.a.kr(str);
        this.dTy = new a(vcVar.bHH);
        kx(str);
        U(d);
        k(eVar.getMinimum(), ((Double) com.google.common.base.e.h(eVar.cVI, Double.valueOf(0.0d))).doubleValue());
        axR();
        vcVar.bHE.addTextChangedListener(this.dTz);
        vcVar.bHH.addTextChangedListener(this.dTA);
    }

    private void kx(String str) {
        this.dTs.bHN.setText(String.format(Locale.US, "%s %s", new Object[]{str, this.dTu.getString(R.string.withdrawal)}));
    }

    private void U(double d) {
        this.dTs.bHH.setText(this.duM.format(d));
        this.dTs.bHI.setVisibility(0);
        this.dTs.bHF.setVisibility(8);
        if (Currencies.OTN_CURRENCY.equals(this.assetName)) {
            this.dTs.bHE.setHint(String.format(Locale.US, "%s %s", new Object[]{this.dTu.getString(R.string.crypto_wallet_number), Currencies.ETH_CURRENCY}));
        }
        if (this.dTs.bHB != null) {
            Resources resources = this.dTu.getResources();
            int dimension = (int) resources.getDimension(R.dimen.withdrawal_crypto_height_changed_amount);
            int dimension2 = (int) resources.getDimension(R.dimen.withdrawal_crypto_peek_height_changed_amount);
            this.dTs.bHB.getLayoutParams().height = dimension;
            BottomSheetBehavior from = BottomSheetBehavior.from(this.dTs.bHB);
            from.setPeekHeight(dimension2);
            from.setState(4);
            this.dTs.bHB.requestLayout();
            this.dTs.bHB.invalidate();
        }
    }

    private void k(double d, double d2) {
        CharSequence format;
        if (d > 0.0d) {
            format = String.format(Locale.US, "%s %s %s %s", new Object[]{this.dTu.getString(R.string.min_abbr), this.duM.format(d), this.dTu.getString(R.string.max_abbr), this.duM.format(d2)});
        } else {
            format = String.format(Locale.US, "%s %s", new Object[]{this.dTu.getString(R.string.max_abbr), this.duM.format(d2)});
        }
        this.dTs.bHJ.setText(format);
    }

    void axR() {
        i.v(TAG, "updateState");
        double aOs = aOs();
        KycWithdrawalStatus a = com.iqoption.withdrawal.crypto.a.a(this.cJn, this.dSR);
        int i = 4;
        String obj;
        if (this.dTw.A(aOs) && a == KycWithdrawalStatus.Done) {
            obj = this.dTs.bHE.getText().toString();
            boolean aF = com.iqoption.withdrawal.crypto.a.aF(obj, this.assetName);
            this.dTs.bHE.setEnabled(true);
            ImageView imageView = this.dTs.bHD;
            if (this.dTv) {
                i = 0;
            }
            imageView.setVisibility(i);
            aOr();
            e b = com.iqoption.mobbtech.connect.request.api.b.b(0.0d, aOs, this.assetName);
            this.dTs.bHH.setTextColor(-1);
            if (b != null) {
                this.dTx = b;
                boolean z = aOs > this.dTx.auQ();
                String str = TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("updateState isValidAddress=");
                stringBuilder.append(aF);
                stringBuilder.append(", isAmountMoreThenFee=");
                stringBuilder.append(z);
                i.v(str, stringBuilder.toString());
                if (!aF) {
                    if (!obj.isEmpty()) {
                        hE(R.string.wrong_format);
                    }
                    fH(false);
                    return;
                } else if (z) {
                    fH(true);
                    return;
                } else {
                    this.dTs.bHH.setTextColor(ResourcesCompat.getColor(this.dTu.getResources(), R.color.red, this.dTu.getContext().getTheme()));
                    fH(false);
                    return;
                }
            }
            this.executor.execute(new c(0.0d));
            return;
        }
        obj = TAG;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("updateState amount is not withdrawalable, amount=");
        stringBuilder2.append(aOs);
        i.v(obj, stringBuilder2.toString());
        if (aOs == 0.0d) {
            aOr();
            return;
        }
        if (aOs < this.dTw.getMinimum() || aOs > ((Double) com.google.common.base.e.h(this.dTw.cVI, Double.valueOf(0.0d))).doubleValue()) {
            this.dTs.bHH.setTextColor(ResourcesCompat.getColor(this.dTu.getResources(), R.color.red, this.dTu.getContext().getTheme()));
        } else {
            hE(R.string.you_are_not_able_to_withdraw_yet);
            this.dTs.bHD.setVisibility(4);
            this.dTs.bHE.setEnabled(false);
        }
        fH(false);
    }

    private void hE(@StringRes int i) {
        hh(this.dTu.getString(i));
    }

    private void hh(String str) {
        int color = ResourcesCompat.getColor(this.dTu.getResources(), R.color.red, this.dTu.getContext().getTheme());
        this.dTs.bHM.setText(str);
        this.dTs.bHM.setVisibility(0);
        this.dTs.bHL.setVisibility(0);
        this.dTs.bHG.setBackgroundColor(color);
    }

    private void aOr() {
        CharSequence string;
        int color = ResourcesCompat.getColor(this.dTu.getResources(), R.color.grey_blur, this.dTu.getContext().getTheme());
        if (this.dTx.cVJ.doubleValue() == 0.0d) {
            string = this.dTu.getString(R.string.commission_free);
        } else {
            string = String.format(Locale.US, "%s %s %s", new Object[]{this.dTu.getString(R.string.commission), this.duM.format(this.dTx.cVJ), this.assetName});
        }
        bg.setDrawableRight(this.dTs.bHM, null);
        this.dTs.bHM.setText(string);
        this.dTs.bHM.setTextColor(color);
        this.dTs.bHM.setVisibility(0);
        this.dTs.bHG.setBackgroundColor(color);
        this.dTs.bHL.setVisibility(4);
    }

    protected double aOs() {
        try {
            return Double.valueOf(this.dTs.bHH.getText().toString()).doubleValue();
        } catch (Throwable e) {
            i.e(TAG, "error when getting amount", e);
            return -1.0d;
        }
    }

    protected void ky(String str) {
        this.dTs.bHE.setText(com.iqoption.withdrawal.crypto.a.aH(str, this.assetName));
        axR();
    }
}
