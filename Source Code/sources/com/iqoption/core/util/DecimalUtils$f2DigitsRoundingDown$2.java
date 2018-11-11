package com.iqoption.core.util;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "Ljava/text/DecimalFormat;", "invoke"})
/* compiled from: DecimalUtils.kt */
final class DecimalUtils$f2DigitsRoundingDown$2 extends Lambda implements a<DecimalFormat> {
    public static final DecimalUtils$f2DigitsRoundingDown$2 bgM = new DecimalUtils$f2DigitsRoundingDown$2();

    DecimalUtils$f2DigitsRoundingDown$2() {
        super(0);
    }

    /* renamed from: ZX */
    public final DecimalFormat invoke() {
        DecimalFormat I = d.I(d.bgL.ZV(), 2);
        I.setRoundingMode(RoundingMode.DOWN);
        return I;
    }
}
