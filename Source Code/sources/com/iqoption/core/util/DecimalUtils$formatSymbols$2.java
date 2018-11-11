package com.iqoption.core.util;

import java.text.DecimalFormatSymbols;
import java.util.Locale;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "Ljava/text/DecimalFormatSymbols;", "invoke"})
/* compiled from: DecimalUtils.kt */
final class DecimalUtils$formatSymbols$2 extends Lambda implements a<DecimalFormatSymbols> {
    public static final DecimalUtils$formatSymbols$2 bgN = new DecimalUtils$formatSymbols$2();

    DecimalUtils$formatSymbols$2() {
        super(0);
    }

    /* renamed from: ZY */
    public final DecimalFormatSymbols invoke() {
        return new DecimalFormatSymbols(Locale.US);
    }
}
