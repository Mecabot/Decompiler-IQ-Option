package com.iqoption.core.util;

import android.util.SparseArray;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import kotlin.i;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J\u0018\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J\u0018\u0010 \u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J\u0018\u0010!\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0018\u0010\"\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0018\u0010#\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J\u0010\u0010$\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001aH\u0007J\u0016\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020\u001dJ\u0010\u0010(\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J\u0010\u0010)\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001dH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\u00128FX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u0017X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u0017X\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, aXE = {"Lcom/iqoption/core/util/DecimalUtils;", "", "()V", "PREFIX_ARRAY", "", "SYMBOL_HARD", "", "getSYMBOL_HARD", "()Ljava/lang/String;", "SYMBOL_SOFT", "getSYMBOL_SOFT", "f2DigitsRoundingDown", "Ljava/text/DecimalFormat;", "getF2DigitsRoundingDown", "()Ljava/text/DecimalFormat;", "f2DigitsRoundingDown$delegate", "Lkotlin/Lazy;", "formatSymbols", "Ljava/text/DecimalFormatSymbols;", "getFormatSymbols", "()Ljava/text/DecimalFormatSymbols;", "formatSymbols$delegate", "hardDecimalFormats", "Landroid/util/SparseArray;", "softDecimalFormats", "ceil", "", "value", "precision", "", "createFormatter", "symbol", "createFormatterAmount", "createPattern", "createPatternAmount", "floor", "format2DigitsRoundingDown", "formatWithLetter", "n", "iteration", "getHardDecimalFormat", "getSoftDecimalFormat", "core_release"})
/* compiled from: DecimalUtils.kt */
public final class d {
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(d.class), "formatSymbols", "getFormatSymbols()Ljava/text/DecimalFormatSymbols;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(d.class), "f2DigitsRoundingDown", "getF2DigitsRoundingDown()Ljava/text/DecimalFormat;"))};
    private static final String bgE = "#";
    private static final String bgF = "0";
    private static final kotlin.d bgG = g.f(DecimalUtils$formatSymbols$2.bgN);
    private static final kotlin.d bgH = g.f(DecimalUtils$f2DigitsRoundingDown$2.bgM);
    private static final char[] bgI = new char[]{'k', 'm', 'b', 't'};
    private static final SparseArray<DecimalFormat> bgJ = new SparseArray();
    private static final SparseArray<DecimalFormat> bgK = new SparseArray();
    public static final d bgL = new d();

    public final DecimalFormatSymbols ZW() {
        kotlin.d dVar = bgG;
        j jVar = apP[0];
        return (DecimalFormatSymbols) dVar.getValue();
    }

    private d() {
    }

    public final String ZV() {
        return bgF;
    }

    public static final DecimalFormat I(String str, int i) {
        h.e(str, "symbol");
        return i == 0 ? new DecimalFormat(bgE, bgL.ZW()) : new DecimalFormat(bgL.J(str, i), bgL.ZW());
    }

    private final String J(String str, int i) {
        StringBuilder stringBuilder = new StringBuilder("0.");
        for (int i2 = 0; i2 < i; i2++) {
            stringBuilder.append(str);
        }
        str = stringBuilder.toString();
        h.d(str, "sb.toString()");
        return str;
    }

    public static final DecimalFormat dX(int i) {
        DecimalFormat decimalFormat = (DecimalFormat) bgJ.get(i);
        if (decimalFormat != null) {
            return decimalFormat;
        }
        decimalFormat = I(bgE, i);
        bgJ.put(i, decimalFormat);
        return decimalFormat;
    }

    public static final DecimalFormat dY(int i) {
        DecimalFormat decimalFormat = (DecimalFormat) bgK.get(i);
        if (decimalFormat != null) {
            return decimalFormat;
        }
        decimalFormat = I(bgF, i);
        bgK.put(i, decimalFormat);
        return decimalFormat;
    }
}
