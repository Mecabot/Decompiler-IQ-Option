package com.iqoption.charttools.model.indicator;

import com.iqoption.charttools.o;
import com.iqoption.charttools.o.e;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, aXE = {"Lcom/iqoption/charttools/model/indicator/Alligator;", "Lcom/iqoption/charttools/model/indicator/LocalIndicator;", "()V", "canHostFigures", "", "getCanHostFigures", "()Z", "keys", "", "", "getKeys", "()[Ljava/lang/String;", "[Ljava/lang/String;", "titleKeysIndices", "", "getTitleKeysIndices", "()[I", "getMaxInstances", "", "techtools_release"})
/* compiled from: MetaIndicator.kt */
public final class c extends v {
    private static final String[] axV = new String[]{"count1", "offset1", "color1", "all_jaws_width", "count2", "offset2", "color2", "all_theeth_width", "count3", "offset3", "color3", "all_lips_width"};
    private static final int[] axW = new int[]{0, 4, 8};
    public static final c axZ = new c();

    public boolean LY() {
        return false;
    }

    public int LZ() {
        return 2;
    }

    private c() {
        super("Alligator", "Alligator", o.i.alligator, o.i.iq4_indicators_hint_alligator, e.ic_icon_instrument_alligator, null);
    }

    protected String[] getKeys() {
        return axV;
    }

    public int[] LX() {
        return axW;
    }
}
