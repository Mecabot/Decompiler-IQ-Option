package com.iqoption.withdrawal.crypto.a;

import com.iqoption.analytics.EventManager;
import com.iqoption.core.util.i.b;
import com.iqoption.dto.Event;
import com.iqoption.dto.Event.Builder;
import com.iqoption.dto.entity.position.Position;
import com.iqoption.withdrawal.crypto.kyc.KycWithdrawalStatus;

/* compiled from: CryptoWithdrawalAnalyticsEventUtils */
public final class a {

    /* compiled from: CryptoWithdrawalAnalyticsEventUtils */
    public static final class a {
        private final Builder aFE;
        private final b ajF = b.aaa();
        private boolean dRZ;
        private Double value;

        public static a aI(String str, String str2) {
            return new a(str, str2);
        }

        private a(String str, String str2) {
            this.aFE = Event.Builder(str, str2);
        }

        public a O(double d) {
            this.value = Double.valueOf(d);
            return this;
        }

        public a fB(boolean z) {
            this.value = Double.valueOf(z ? 1.0d : 0.0d);
            return this;
        }

        public a fC(boolean z) {
            this.value = Double.valueOf(z ? 1.0d : 0.0d);
            return this;
        }

        public a P(double d) {
            this.value = Double.valueOf(d);
            return this;
        }

        public a ks(String str) {
            this.ajF.l("crypto_name", str);
            return this;
        }

        public a Q(double d) {
            this.ajF.l("commission", Double.valueOf(d));
            return this;
        }

        public a o(Position position) {
            if (position != null) {
                com.iqoption.portfolio.a aVar = new com.iqoption.portfolio.a();
                aVar.e(position.getInvestSum().doubleValue(), position.getSellPnl(), position.getExpPnl());
                this.ajF.l("price_percentage", Double.valueOf(aVar.avJ()));
            }
            return this;
        }

        public a fD(boolean z) {
            this.ajF.l("is_valid", Boolean.valueOf(z));
            return this;
        }

        public a R(double d) {
            this.ajF.l("max_amount", Double.valueOf(d));
            return this;
        }

        public a S(double d) {
            this.ajF.l("min_amount", Double.valueOf(d));
            return this;
        }

        public a T(double d) {
            this.ajF.l("amount_to_withdraw", Double.valueOf(d));
            return this;
        }

        public a kt(String str) {
            this.ajF.l("error_text", str);
            return this;
        }

        public a fE(boolean z) {
            this.ajF.l("is_success", Boolean.valueOf(z));
            return this;
        }

        public a a(KycWithdrawalStatus kycWithdrawalStatus) {
            this.ajF.l("kyc_status", kycWithdrawalStatus);
            return this;
        }

        public a ku(String str) {
            this.ajF.l("popup_type", str);
            return this;
        }

        public a fF(boolean z) {
            this.dRZ = z;
            return this;
        }

        public void send() {
            this.aFE.setParameters(this.ajF.aab());
            if (this.value != null) {
                this.aFE.setValue(this.value);
            }
            if (this.dRZ) {
                this.aFE.calcDuration();
            }
            EventManager.Bm().a(this.aFE.build());
        }
    }
}
