package com.iqoption.mobbtech.connect.request.api.a;

import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.google.common.base.j;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.n;
import com.google.common.util.concurrent.s;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.iqoption.app.IQApp;
import com.iqoption.app.managers.ae;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.core.i;
import com.iqoption.core.util.l;
import com.iqoption.dto.entity.position.Position;
import com.iqoption.dto.entity.result.BuybackResult;
import com.iqoption.mobbtech.connect.request.a.a.b;
import com.iqoption.mobbtech.connect.request.api.f;
import com.iqoption.mobbtech.connect.response.ArrayBuybackResponse;
import com.iqoption.mobbtech.connect.response.ArrayBuybackResponse.Map;
import com.iqoption.util.ag;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: OptionRequests */
public class a {
    private static final String TAG = "com.iqoption.mobbtech.connect.request.api.a.a";
    protected static final Set<Long> cUS = Sets.uJ();
    public static final j<Long> cUT = b.$instance;

    protected a() {
    }

    public static boolean x(Long l) {
        return cUS.contains(l);
    }

    public static s<?> c(Context context, long j) {
        return a(context, ImmutableList.af(Long.valueOf(j)));
    }

    public static s<?> a(Context context, final ImmutableList<Long> immutableList) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("sell optionIds=");
        stringBuilder.append(immutableList);
        i.d(str, stringBuilder.toString());
        cUS.addAll(immutableList);
        ae.g(context, 2);
        s Sa = b.A(Map.class).ga("sell-options").gb("2.0").c("options_ids", immutableList).Sa();
        ag.a(Sa, new n<Map>() {
            /* renamed from: b */
            public void onSuccess(Map map) {
                ArrayBuybackResponse auO = ArrayBuybackResponse.auO();
                Iterator it = map.entrySet().iterator();
                String str = null;
                while (it.hasNext()) {
                    Entry entry = (Entry) it.next();
                    if (!TextUtils.isEmpty(((BuybackResult) entry.getValue()).error)) {
                        str = ((BuybackResult) entry.getValue()).error;
                        auO.cVu.add(entry.getKey());
                        a.cUS.remove(entry.getKey());
                        it.remove();
                    }
                }
                if (str != null) {
                    IQApp.Dn().aE(auO);
                    com.iqoption.app.a.b.eO(str);
                }
                if (!l.x(map)) {
                    a.cUS.removeAll(map.keySet());
                    IQApp.Dn().aE(map);
                }
            }

            public void l(Throwable th) {
                ArrayBuybackResponse auO = ArrayBuybackResponse.auO();
                auO.cVu.addAll(immutableList);
                a.cUS.removeAll(immutableList);
                IQApp.Dn().aE(auO);
                com.iqoption.app.a.b.aT(IQApp.Dk());
                i.e(a.TAG, "sell error=", th);
            }
        });
        return Sa;
    }

    public static boolean a(String str, int i, InstrumentType instrumentType, long j, double d, long j2, int i2, boolean z) {
        return f.iy("sendMessage").iz("open-option").m("user_balance_id", Long.valueOf(j2)).m("active_id", Integer.valueOf(i)).m("option_type_id", Integer.valueOf(com.iqoption.core.microservices.tradingengine.response.active.a.C(instrumentType))).m("direction", z ? NotificationCompat.CATEGORY_CALL : "put").m(Position.CLOSE_REASON_EXPIRED, Long.valueOf(j)).m("refund_value", Integer.valueOf(0)).m("price", Double.valueOf(d)).m(FirebaseAnalytics.b.VALUE, Double.valueOf(com.iqoption.gl.b.aow().glchTabGetActualValue(str))).m("platform_id", Integer.valueOf(17)).m("profit_percent", Integer.valueOf(i2)).exec();
    }
}
