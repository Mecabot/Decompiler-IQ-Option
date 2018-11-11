package com.iqoption.charttools.model.indicator;

import com.iqoption.charttools.o;
import com.iqoption.charttools.o.e;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, aXE = {"Lcom/iqoption/charttools/model/indicator/Ichimoku;", "Lcom/iqoption/charttools/model/indicator/LocalIndicator;", "()V", "canHostFigures", "", "getCanHostFigures", "()Z", "keys", "", "", "getKeys", "()[Ljava/lang/String;", "[Ljava/lang/String;", "titleKeysIndices", "", "getTitleKeysIndices", "()[I", "techtools_release"})
/* compiled from: MetaIndicator.kt */
public final class t extends v {
    private static final String[] axV = new String[]{"ichimoku_tenkanSen_period", "ichimoku_tenkanSen_color", "ichimoku_tenkanSen_width", "ichimoku_kijunSen_period", "ichimoku_kijunSen_color", "ichimoku_kijunSen_width", "ichimoku_senkouSpanA_color", "ichimoku_senkouSpanA_width", "ichimoku_senkouSpanB_period", "ichimoku_senkouSpanB_color", "ichimoku_senkouSpanB_width", "ichimoku_chikou_offset", "ichimoku_chikouSpan_color", "ichimoku_chikouSpan_width"};
    private static final int[] axW = new int[]{0, 3, 8, 11};
    public static final t ayy = new t();

    public boolean LY() {
        return false;
    }

    private t() {
        super("Ichimoku", "Ichimoku", o.i.ichimoku, o.i.ichimoku_description, e.ic_icon_instrument_isimo, null);
    }

    protected String[] getKeys() {
        return axV;
    }

    public int[] LX() {
        return axW;
    }
}
