package com.iqoption.analytics;

import com.iqoption.core.util.i;
import com.iqoption.dto.Event;
import com.iqoption.dto.Event.Builder;

/* compiled from: RateUsDialogEventHelper */
public class l {
    public Builder adT;

    public void onStart() {
        this.adT = Event.Builder(Event.CATEGORY_POPUP_SERVED, "rate-app_show-popup");
    }

    public void az(boolean z) {
        if (this.adT != null) {
            EventManager.Bm().a(this.adT.calcDuration().setParameters(i.ZZ().l("is_user_loyalty", Boolean.valueOf(z)).aab()).build());
        }
    }

    public void BD() {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "rate-app_cancel").build());
    }

    public void BE() {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "rate-app_rate").setValue(Double.valueOf(5.0d)).build());
    }

    public void j(double d) {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "rate-app_suggest").setValue(Double.valueOf(d)).build());
    }
}
