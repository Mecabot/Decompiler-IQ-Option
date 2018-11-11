package com.iqoption.analytics;

import com.iqoption.core.util.i;
import com.iqoption.dto.Event;
import com.iqoption.dto.Event.Builder;

/* compiled from: WelcomeTrendingTodayEventHelper */
public final class s {
    public static Builder Cf() {
        return Event.Builder(Event.CATEGORY_POPUP_SERVED, "traderoom_trending-now-show");
    }

    public static void d(Builder builder) {
        if (builder != null) {
            EventManager.Bm().a(builder.calcDuration().build());
        }
    }

    public static void a(double d, int i) {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "trending-now_choose-asset").setValue(Double.valueOf(d)).setParameters(i.ZZ().l("asset_id", Integer.valueOf(i)).aab()).build());
    }

    public static void Cg() {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "trending-now_close").build());
    }

    public static void Ch() {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_SCROLL, "trending-now_scroll-aside").build());
    }
}
