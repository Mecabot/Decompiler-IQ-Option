package com.iqoption.analytics;

import com.iqoption.dto.Event;
import com.iqoption.dto.Event.Builder;

/* compiled from: PendingKeyboardEventHelper */
public class i {
    public Builder adT;

    public void onStart() {
        this.adT = Event.Builder(Event.CATEGORY_POPUP_SERVED, "traderoom_show-current-price-keyboard");
    }

    public void onStop() {
        if (this.adT != null) {
            EventManager.Bm().a(this.adT.calcDuration().build());
        }
    }

    public void i(double d) {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "traderoom_press-price-keyboard").setValue(Double.valueOf(d)).build());
    }
}
