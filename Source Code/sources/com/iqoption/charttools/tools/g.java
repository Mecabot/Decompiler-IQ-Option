package com.iqoption.charttools.tools;

import com.iqoption.charttools.model.chart.ChartColor;
import com.iqoption.charttools.tools.data.SettingType;
import kotlin.i;

@i(aXC = {1, 1, 11})
public final /* synthetic */ class g {
    public static final /* synthetic */ int[] aoS = new int[SettingType.values().length];
    public static final /* synthetic */ int[] auV = new int[ChartColor.values().length];
    public static final /* synthetic */ int[] auk = new int[ToolsScreen.values().length];

    static {
        aoS[SettingType.TRADERS_MOOD.ordinal()] = 1;
        aoS[SettingType.LIVE_DEALS.ordinal()] = 2;
        aoS[SettingType.APPLY_TO_ALL_ASSETS.ordinal()] = 3;
        aoS[SettingType.VOLUME.ordinal()] = 4;
        auk[ToolsScreen.ACTIVE_TOOLS.ordinal()] = 1;
        auk[ToolsScreen.INDICATORS.ordinal()] = 2;
        auk[ToolsScreen.TEMPLATES.ordinal()] = 3;
        auV[ChartColor.mono.ordinal()] = 1;
        auV[ChartColor.redGreen.ordinal()] = 2;
    }
}
