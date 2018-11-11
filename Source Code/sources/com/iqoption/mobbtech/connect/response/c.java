package com.iqoption.mobbtech.connect.response;

import android.support.v4.app.NotificationCompat;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.s;
import com.google.gson.annotations.Expose;
import com.iqoption.core.i;
import com.iqoption.core.microservices.tradingengine.response.active.a;
import com.iqoption.mobbtech.connect.response.options.e;

/* compiled from: BuyBackData */
public class c extends b {
    private static final String TAG = "com.iqoption.mobbtech.connect.response.c";
    public Integer activeId;
    @Expose(deserialize = false, serialize = false)
    public transient ImmutableSortedMap<Integer, Double> cVz;
    public Long expTime;
    public Integer optionTypeId;

    public static Double a(e eVar, Double d, c cVar, int i, int i2, int i3) {
        boolean equals = NotificationCompat.CATEGORY_CALL.equals(eVar.getDir());
        double doubleValue = (d.doubleValue() - eVar.getValue().doubleValue()) * 1000000.0d;
        int i4 = (int) (10000.0d * doubleValue);
        if ((i4 <= 0 || !equals) && (i4 >= 0 || equals)) {
            if (i4 > 0) {
                doubleValue = -doubleValue;
            }
        } else if (i4 < 0) {
            doubleValue = -doubleValue;
        }
        double d2 = (double) i;
        i4 = (int) (d2 * Math.floor(doubleValue / d2));
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("interval: ");
        stringBuilder.append(i4);
        stringBuilder.append(", minInterval:");
        stringBuilder.append(i2);
        stringBuilder.append(", maxInterval:");
        stringBuilder.append(i3);
        i.d(str, stringBuilder.toString());
        if (i4 < i2) {
            i4 = i2;
        }
        if (i4 > i3) {
            i4 = i3;
        }
        return (Double) cVar.cVz.get(Integer.valueOf(i4));
    }

    public Double a(e eVar, double d, double d2) {
        if (this.cVz.size() < 2) {
            return null;
        }
        Iterable tx = this.cVz.sX();
        return Double.valueOf((d2 * a(eVar, Double.valueOf(d), this, Math.abs(((Integer) this.cVz.firstKey()).intValue() - ((Integer) s.a(tx, 1)).intValue()), ((Integer) tx.first()).intValue(), ((Integer) tx.last()).intValue()).doubleValue()) / 100.0d);
    }

    public com.iqoption.mobbtech.connect.response.options.i getOptionKey() {
        return new com.iqoption.mobbtech.connect.response.options.i(this.expTime, this.activeId, a.dP(this.optionTypeId.intValue()));
    }
}
