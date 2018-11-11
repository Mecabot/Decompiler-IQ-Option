package com.iqoption.analytics;

import com.iqoption.core.util.i.b;
import com.iqoption.dto.Event;
import com.iqoption.dto.Event.Builder;

/* compiled from: DialogCongratEmissionEventHelper */
public class c {
    public static void Bk() {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "otn_receive-tokens-info-calculated").build());
    }

    public static Builder Bl() {
        return Event.Builder(Event.CATEGORY_POPUP_SERVED, "otn_receive-tokens");
    }

    public static void a(Builder builder, double d, double d2) {
        if (builder != null) {
            builder.calcDuration();
            builder.setValue(Double.valueOf(d));
            builder.setParameters(b.aaa().l("turnover_value", Double.valueOf(d2)).aab());
            EventManager.Bm().a(builder.build());
        }
    }
}
