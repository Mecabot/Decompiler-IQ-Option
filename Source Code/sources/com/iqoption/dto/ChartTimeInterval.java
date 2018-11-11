package com.iqoption.dto;

import android.content.Context;
import com.iqoption.app.managers.tab.a;
import com.iqoption.app.managers.tab.a.g;
import com.iqoption.x.R;
import java.util.ArrayList;

public class ChartTimeInterval {
    public static final int CANDLE_1 = 1;
    public static final int CANDLE_10 = 10;
    public static final int CANDLE_10m = 600;
    public static final int CANDLE_12H = 43200;
    public static final int CANDLE_15 = 15;
    public static final int CANDLE_15m = 900;
    public static final int CANDLE_1D = 86400;
    public static final int CANDLE_1H = 3600;
    public static final int CANDLE_1M = 2592000;
    public static final int CANDLE_1W = 604800;
    public static final int CANDLE_1m = 60;
    public static final int CANDLE_2H = 7200;
    public static final int CANDLE_2m = 120;
    public static final int CANDLE_30 = 30;
    public static final int CANDLE_30m = 1800;
    public static final int CANDLE_4H = 14400;
    public static final int CANDLE_5 = 5;
    public static final int CANDLE_5m = 300;
    public static final int CANDLE_8H = 28800;
    public static final int CHART_TYPE_BARS = 3;
    public static final int CHART_TYPE_CANDLES = 1;
    public static final int CHART_TYPE_LINEAR = 2;
    public static final int CHART_TYPE_ZONE = 0;
    public boolean isActual = false;
    public boolean isSelected = false;
    public String name;
    public int value;

    public ChartTimeInterval(String str, int i, int i2) {
        boolean z = false;
        this.name = str;
        this.value = i;
        if (i == i2) {
            z = true;
        }
        this.isSelected = z;
    }

    public String toString() {
        return this.name;
    }

    public static ArrayList<ChartTimeInterval> getChartTimeIntervalTemplates(Context context) {
        g IC = a.Il().IC();
        int i = IC != null ? IC.IX().candleSize : 0;
        ArrayList<ChartTimeInterval> arrayList = new ArrayList();
        arrayList.add(new ChartTimeInterval("1 second", 1, i));
        arrayList.add(new ChartTimeInterval(context.getString(R.string.sec_5), 5, i));
        arrayList.add(new ChartTimeInterval(context.getString(R.string.sec_10), 10, i));
        arrayList.add(new ChartTimeInterval(context.getString(R.string.sec_15), 15, i));
        arrayList.add(new ChartTimeInterval(context.getString(R.string.sec_30), 30, i));
        arrayList.add(new ChartTimeInterval(context.getString(R.string.m_1), 60, i));
        arrayList.add(new ChartTimeInterval(context.getString(R.string.m_2), CANDLE_2m, i));
        arrayList.add(new ChartTimeInterval(context.getString(R.string.m_5), 300, i));
        arrayList.add(new ChartTimeInterval(context.getString(R.string.m_10), 600, i));
        arrayList.add(new ChartTimeInterval(context.getString(R.string.m_15), CANDLE_15m, i));
        arrayList.add(new ChartTimeInterval(context.getString(R.string.m_30), CANDLE_30m, i));
        arrayList.add(new ChartTimeInterval(context.getString(R.string.h_1), CANDLE_1H, i));
        arrayList.add(new ChartTimeInterval(context.getString(R.string.h_2), CANDLE_2H, i));
        arrayList.add(new ChartTimeInterval(context.getString(R.string.h_4), CANDLE_4H, i));
        arrayList.add(new ChartTimeInterval(context.getString(R.string.h_8), CANDLE_8H, i));
        arrayList.add(new ChartTimeInterval(context.getString(R.string.h_12), CANDLE_12H, i));
        arrayList.add(new ChartTimeInterval(context.getString(R.string.d_1), CANDLE_1D, i));
        arrayList.add(new ChartTimeInterval(context.getString(R.string.w_1), CANDLE_1W, i));
        arrayList.add(new ChartTimeInterval(context.getString(R.string.month_1), CANDLE_1M, i));
        return arrayList;
    }

    public static ArrayList<ChartTimeInterval> getShortChartTimeIntervalTemplates(Context context) {
        g IC = a.Il().IC();
        int i = IC != null ? IC.IX().candleSize : 0;
        ArrayList<ChartTimeInterval> arrayList = new ArrayList();
        arrayList.add(new ChartTimeInterval("1 second", 1, i));
        arrayList.add(new ChartTimeInterval(context.getString(R.string.sec_5), 5, i));
        arrayList.add(new ChartTimeInterval(context.getString(R.string.sec_10), 10, i));
        arrayList.add(new ChartTimeInterval(context.getString(R.string.sec_15), 15, i));
        arrayList.add(new ChartTimeInterval(context.getString(R.string.sec_30), 30, i));
        arrayList.add(new ChartTimeInterval(context.getString(R.string.m_1), 60, i));
        arrayList.add(new ChartTimeInterval(context.getString(R.string.m_2), CANDLE_2m, i));
        return arrayList;
    }
}
