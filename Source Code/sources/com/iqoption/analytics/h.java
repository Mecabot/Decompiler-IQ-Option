package com.iqoption.analytics;

import com.iqoption.core.util.i;
import com.iqoption.dto.Event;

/* compiled from: OtnEventHelper */
public final class h {
    public static void a(boolean z, String str) {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "otn_expected-otn-amount-info").setValue(Double.valueOf(z ? 1.0d : 0.0d)).setParameters(i.ZZ().l("field_name", str).aab()).build());
    }
}
