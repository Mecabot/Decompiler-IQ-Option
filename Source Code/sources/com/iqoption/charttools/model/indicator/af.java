package com.iqoption.charttools.model.indicator;

import com.iqoption.charttools.o;
import com.iqoption.charttools.o.e;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, aXE = {"Lcom/iqoption/charttools/model/indicator/StochasticOscillator;", "Lcom/iqoption/charttools/model/indicator/LocalIndicator;", "()V", "keys", "", "", "getKeys", "()[Ljava/lang/String;", "[Ljava/lang/String;", "titleKeysIndices", "", "getTitleKeysIndices", "()[I", "techtools_release"})
/* compiled from: MetaIndicator.kt */
public final class af extends v {
    private static final String[] axV = new String[]{"sto_smooth", "sto_period_dK", "sto_dK_color", "sto_dK_width", "sto_period_dD", "sto_dD_color", "sto_dD_width", "sto_overbought", "sto_overbought_color", "sto_overbought_width", "sto_oversold", "sto_oversold_color", "sto_oversold_width"};
    private static final int[] axW = new int[]{1, 0, 4};
    public static final af ayP = new af();

    private af() {
        super("Stochastic", "Stochastic", o.i.iq4_indicators_title_stochastic, o.i.iq4_indicators_hint_stochastic, e.ic_icon_instrument_stohastic, null);
    }

    protected String[] getKeys() {
        return axV;
    }

    public int[] LX() {
        return axW;
    }
}
