package com.iqoption.analytics;

import com.iqoption.core.util.i;
import com.iqoption.dto.Event;

/* compiled from: TokenBalanceFragmentEventHelper */
public class n {
    public static void aA(boolean z) {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "otn_pay-commissions-balance-container").setValue(Double.valueOf(z ? 1.0d : 0.0d)).build());
    }

    public static void BL() {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "otn_expected-turnover-info").build());
    }

    public static void a(double d, String str) {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "otn_withdraw-crypto-balance-container").setValue(Double.valueOf(d)).setParameters(i.ZZ().l("crypto_name", str).aab()).build());
    }
}
