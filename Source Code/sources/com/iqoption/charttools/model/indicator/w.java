package com.iqoption.charttools.model.indicator;

import com.iqoption.charttools.o;
import com.iqoption.charttools.o.e;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, aXE = {"Lcom/iqoption/charttools/model/indicator/MACD;", "Lcom/iqoption/charttools/model/indicator/LocalIndicator;", "()V", "keys", "", "", "getKeys", "()[Ljava/lang/String;", "[Ljava/lang/String;", "titleKeysIndices", "", "getTitleKeysIndices", "()[I", "techtools_release"})
/* compiled from: MetaIndicator.kt */
public final class w extends v {
    private static final String[] axV = new String[]{"macd_fast_period", "macd_slow_period", "macd_sig_period", "macd_color", "macd_width", "macd_base_color", "macd_base_width", "macd_sig_color", "macd_sig_width"};
    private static final int[] axW = new int[]{0, 1, 2};
    public static final w ayD = new w();

    private w() {
        super("MACD", "MACD", o.i.iq4_indicators_title_macd, o.i.iq4_indicators_hint_macd, e.ic_icon_instrument_macd, null);
    }

    protected String[] getKeys() {
        return axV;
    }

    public int[] LX() {
        return axW;
    }
}
