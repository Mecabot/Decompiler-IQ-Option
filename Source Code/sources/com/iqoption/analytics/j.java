package com.iqoption.analytics;

import com.iqoption.dto.Event;
import com.iqoption.dto.Event.Builder;

/* compiled from: PendingOrderChangedEventHelper */
public class j {
    public Builder adT;

    public void ax(boolean z) {
        this.adT = Event.Builder(Event.CATEGORY_POPUP_SERVED, z ? "traderoom_order-executed" : "traderoom_order-created");
    }

    public void onStop() {
        if (this.adT != null) {
            EventManager.Bm().a(this.adT.calcDuration().build());
        }
    }

    public void Bu() {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "traderoom_order-view").build());
    }
}
