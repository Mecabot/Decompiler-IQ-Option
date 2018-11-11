package com.iqoption.charttools.templates;

import com.iqoption.charttools.model.chart.ChartColor;
import com.iqoption.charttools.model.chart.ChartType;
import kotlin.i;

@i(aXC = {1, 1, 11})
public final /* synthetic */ class j {
    public static final /* synthetic */ int[] aoS = new int[ChartColor.values().length];
    public static final /* synthetic */ int[] auk = new int[ChartType.values().length];

    static {
        aoS[ChartColor.mono.ordinal()] = 1;
        aoS[ChartColor.redGreen.ordinal()] = 2;
        auk[ChartType.zone.ordinal()] = 1;
        auk[ChartType.linear.ordinal()] = 2;
        auk[ChartType.candles.ordinal()] = 3;
        auk[ChartType.bar.ordinal()] = 4;
    }
}
