package com.iqoption.fragment.cashbox;

import android.content.Context;
import com.iqoption.analytics.EventManager;
import com.iqoption.core.util.i;
import com.iqoption.dto.Event;
import com.iqoption.dto.Event.Builder;
import java.util.HashMap;
import java.util.LinkedHashMap;

/* compiled from: BillingPaymentPageLoadedEventHelper */
public class a {
    private static final String TAG = "com.iqoption.fragment.cashbox.a";
    private HashMap<String, Builder> cwn = new LinkedHashMap();

    public void hI(String str) {
        Builder Builder = Event.Builder(Event.CATEGORY_SYSTEM, "billing_payment-page-loaded");
        Builder.setParameters(i.ZZ().l("url_redirect", str).l("is_native_deposit", "1").aab());
        this.cwn.put(str, Builder);
    }

    public void c(String str, Context context) {
        Builder builder = (Builder) this.cwn.get(str);
        if (builder != null) {
            this.cwn.remove(str);
            a(context, 1.0d);
            a(context, builder, 1.0d);
        }
    }

    public void d(String str, Context context) {
        Builder builder = (Builder) this.cwn.get(str);
        if (builder != null) {
            this.cwn.remove(str);
            a(context, builder, 2.0d);
        }
    }

    public void bo(Context context) {
        a(context, 0.0d);
    }

    private void a(Context context, Builder builder, double d) {
        builder.calcDuration();
        builder.setValue(Double.valueOf(d));
        Event build = builder.build();
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("send PageLoadedEvent ");
        stringBuilder.append(build);
        com.iqoption.core.i.v(str, stringBuilder.toString());
        EventManager.Bm().a(build);
    }

    private void a(Context context, double d) {
        for (Builder a : this.cwn.values()) {
            a(context, a, d);
        }
        this.cwn.clear();
    }
}
