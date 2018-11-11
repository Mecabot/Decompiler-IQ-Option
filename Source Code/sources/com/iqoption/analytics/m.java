package com.iqoption.analytics;

import com.iqoption.app.a;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.core.util.i.b;
import com.iqoption.dto.Event;
import com.iqoption.dto.Event.Builder;

/* compiled from: RightPanelEventHelper */
public final class m {
    public static void b(boolean z, String str) {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "crypto-confirmation_choose-commission-currency").setValue(Double.valueOf(z ? 1.0d : 0.0d)).setParameters(b.aaa().l("commission_currency", str).aab()).build());
    }

    public static void a(boolean z, InstrumentType instrumentType, int i) {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "traderoom_current-price").setValue(Double.valueOf(z ? 1.0d : 0.0d)).setParameters(b.aaa().l("instrument_type", instrumentType).l("balance_type_id", Integer.valueOf(i)).aab()).build());
    }

    public static void BF() {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "pending-order_submit").build());
    }

    public static void BG() {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "pending-order_roll-up-submittion").build());
    }

    public static void BH() {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "confirmation_show-commission").build());
    }

    public static void BI() {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "confirmation_show-limits").build());
    }

    public static void BJ() {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "confirmation_current-price").build());
    }

    public static Builder BK() {
        return Event.Builder(Event.CATEGORY_POPUP_SERVED, "confirmation_show");
    }

    public static void a(Builder builder, InstrumentType instrumentType, a aVar) {
        if (builder != null) {
            Integer valueOf = Integer.valueOf(aVar.CZ() ? 3 : aVar.Cy());
            builder.calcDuration();
            builder.setParameters(b.aaa().l("instrument_type", instrumentType).l("balance_type", valueOf).aab());
            EventManager.Bm().a(builder.build());
        }
    }

    public static void a(InstrumentType instrumentType, a aVar) {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "confirmation_confirm").setParameters(b.aaa().l("instrument_type", instrumentType).l("balance_type_id", Integer.valueOf(aVar.CZ() ? 3 : aVar.Cy())).aab()).build());
    }
}
