package com.iqoption.charttools.model.indicator.constructor.a;

import com.iqoption.charttools.model.indicator.aa;
import com.iqoption.charttools.model.indicator.ab;
import com.iqoption.charttools.model.indicator.constructor.d;
import com.iqoption.charttools.model.indicator.constructor.f;
import com.iqoption.charttools.model.indicator.constructor.g;
import com.iqoption.charttools.model.indicator.constructor.h;
import com.iqoption.charttools.o;
import java.util.List;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\u001a\u0010\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u001a\u0010\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u001a\u0010\u0010\u0005\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u001a\u0010\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u001a\u0010\u0010\u0007\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u001a\u0010\u0010\b\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u001a\u0010\u0010\t\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u001a\u0010\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u001a\u0010\u0010\u000b\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u001a\u0010\u0010\f\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u001a\u0010\u0010\r\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u001a\u0010\u0010\u000e\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u001a\u0010\u0010\u000f\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u001a\u0010\u0010\u0010\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u001a\u0010\u0010\u0011\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u001a\u0010\u0010\u0012\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u001a\u0010\u0010\u0013\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u001a\u0010\u0010\u0014\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¨\u0006\u0015"}, aXE = {"buildADXInputs", "Lcom/iqoption/charttools/model/indicator/constructor/Inputs;", "values", "Lcom/iqoption/charttools/model/indicator/constructor/ValuesIterator;", "buildATRInputs", "buildAlligatorInputs", "buildAwesomeOscillatorInputs", "buildBelkhayateTimingInputs", "buildBollingerBandsInputs", "buildCCIInputs", "buildDPOInputs", "buildFractalInputs", "buildIchimokuInputs", "buildKDJInputs", "buildMACDInputs", "buildMomentumInputs", "buildMovingAverageInputs", "buildParabolicSARInputs", "buildRSIInputs", "buildStochasticOscillator", "buildWilliamsPercentRangeInputs", "techtools_release"})
/* compiled from: LocalInputs.kt */
public final class b {
    public static final f h(h hVar) {
        h hVar2 = hVar;
        kotlin.jvm.internal.h.e(hVar2, "values");
        g gVar = new g();
        int i = o.i.main;
        int i2 = o.i.williams_percent_range_value_desc;
        String str = null;
        String str2 = null;
        String string = i != 0 ? com.iqoption.core.f.getString(i) : "";
        String string2 = i2 != 0 ? com.iqoption.core.f.getString(i2) : null;
        List MG = gVar.MG();
        d dVar = new d();
        dVar.setName(string);
        dVar.setDescription(string2);
        dVar.fD(str2);
        d dVar2 = dVar;
        d.a(dVar, o.i.period, hVar2.nextInt(14), Integer.valueOf(2), Integer.valueOf(100), null, false, 48, null);
        d dVar3 = dVar2;
        d.a(dVar3, o.i.color, hVar2.nextInt(com.iqoption.charttools.model.indicator.i.ayg[3]), false, 4, null);
        d.b(dVar3, o.i.width, hVar2.nextInt(com.iqoption.charttools.model.indicator.i.ayh[0]), false, 4, null);
        MG.add(dVar2);
        i = o.i.overbought;
        i2 = o.i.williams_percent_range_overbought_desc;
        string = i != 0 ? com.iqoption.core.f.getString(i) : "";
        string2 = i2 != 0 ? com.iqoption.core.f.getString(i2) : null;
        MG = gVar.MG();
        d dVar4 = new d();
        dVar4.setName(string);
        dVar4.setDescription(string2);
        dVar4.fD(str2);
        d.a(dVar4, o.i.period, hVar2.nextInt(-20), Integer.valueOf(-100), Integer.valueOf(-1), null, false, 48, null);
        dVar = dVar4;
        d.a(dVar4, o.i.color, hVar2.nextInt(com.iqoption.charttools.model.indicator.i.ayg[4]), false, 4, null);
        d.b(dVar, o.i.width, hVar2.nextInt(com.iqoption.charttools.model.indicator.i.ayh[0]), false, 4, null);
        MG.add(dVar);
        int i3 = o.i.oversold;
        int i4 = o.i.williams_percent_range_oversold_desc;
        String string3 = i3 != 0 ? com.iqoption.core.f.getString(i3) : "";
        if (i4 != 0) {
            str = com.iqoption.core.f.getString(i4);
        }
        List MG2 = gVar.MG();
        d dVar5 = new d();
        dVar5.setName(string3);
        dVar5.setDescription(str);
        dVar5.fD(str2);
        d dVar6 = dVar5;
        d.a(dVar6, o.i.period, hVar2.nextInt(-80), Integer.valueOf(-100), Integer.valueOf(-1), null, false, 48, null);
        d.a(dVar6, o.i.color, hVar2.nextInt(com.iqoption.charttools.model.indicator.i.ayg[0]), false, 4, null);
        d.b(dVar6, o.i.width, hVar2.nextInt(com.iqoption.charttools.model.indicator.i.ayh[0]), false, 4, null);
        MG2.add(dVar5);
        return gVar.MH();
    }

    public static final f i(h hVar) {
        kotlin.jvm.internal.h.e(hVar, "values");
        g gVar = new g();
        List MG = gVar.MG();
        d dVar = new d();
        d.a(dVar, o.i.type, hVar.nextInt(0), aa.ayG.Mm(), false, 8, null);
        d.a(dVar, o.i.period, hVar.nextInt(14), Integer.valueOf(2), Integer.valueOf(100), null, false, 48, null);
        d.a(dVar, o.i.color, hVar.nextInt(com.iqoption.charttools.model.indicator.i.ayg[0]), false, 4, null);
        d.b(dVar, o.i.width, hVar.nextInt(com.iqoption.charttools.model.indicator.i.ayh[0]), false, 4, null);
        MG.add(dVar);
        return gVar.MH();
    }

    public static final f j(h hVar) {
        h hVar2 = hVar;
        kotlin.jvm.internal.h.e(hVar2, "values");
        g gVar = new g();
        int i = o.i.tenkan_sen;
        int i2 = o.i.ichimoku_tenkan_sen_desc;
        String str = null;
        String str2 = null;
        String string = i != 0 ? com.iqoption.core.f.getString(i) : "";
        String string2 = i2 != 0 ? com.iqoption.core.f.getString(i2) : null;
        List MG = gVar.MG();
        d dVar = new d();
        dVar.setName(string);
        dVar.setDescription(string2);
        dVar.fD(str2);
        d dVar2 = dVar;
        d.a(dVar, o.i.period, hVar2.nextInt(9), Integer.valueOf(2), Integer.valueOf(100), null, false, 48, null);
        d.a(dVar2, o.i.color, hVar2.nextInt(com.iqoption.charttools.model.indicator.i.ayg[3]), false, 4, null);
        d dVar3 = dVar2;
        d.b(dVar3, o.i.width, hVar2.nextInt(com.iqoption.charttools.model.indicator.i.ayh[0]), false, 4, null);
        MG.add(dVar3);
        int i3 = o.i.kijun_sen;
        int i4 = o.i.ichimoku_kijun_sen_desc;
        String string3 = i3 != 0 ? com.iqoption.core.f.getString(i3) : "";
        String string4 = i4 != 0 ? com.iqoption.core.f.getString(i4) : null;
        List MG2 = gVar.MG();
        d dVar4 = new d();
        dVar4.setName(string3);
        dVar4.setDescription(string4);
        dVar4.fD(str2);
        d dVar5 = dVar4;
        d.a(dVar5, o.i.period, hVar2.nextInt(26), Integer.valueOf(2), Integer.valueOf(100), null, false, 48, null);
        d.a(dVar5, o.i.color, hVar2.nextInt(com.iqoption.charttools.model.indicator.i.ayg[0]), false, 4, null);
        d.b(dVar5, o.i.width, hVar2.nextInt(com.iqoption.charttools.model.indicator.i.ayh[0]), false, 4, null);
        MG2.add(dVar4);
        i4 = o.i.senkou_span_a;
        int i5 = o.i.ichimoku_senkou_span_a_desc;
        string4 = i4 != 0 ? com.iqoption.core.f.getString(i4) : "";
        String string5 = i5 != 0 ? com.iqoption.core.f.getString(i5) : null;
        List MG3 = gVar.MG();
        d dVar6 = new d();
        dVar6.setName(string4);
        dVar6.setDescription(string5);
        dVar6.fD(str2);
        dVar5 = dVar6;
        d.a(dVar5, o.i.color, hVar2.nextInt(com.iqoption.charttools.model.indicator.i.ayg[4]), false, 4, null);
        d.b(dVar5, o.i.width, hVar2.nextInt(com.iqoption.charttools.model.indicator.i.ayh[0]), false, 4, null);
        MG3.add(dVar6);
        i4 = o.i.senkou_span_b;
        int i6 = o.i.ichimoku_senkou_span_b_desc;
        string4 = i4 != 0 ? com.iqoption.core.f.getString(i4) : "";
        String string6 = i6 != 0 ? com.iqoption.core.f.getString(i6) : null;
        List MG4 = gVar.MG();
        d dVar7 = new d();
        dVar7.setName(string4);
        dVar7.setDescription(string6);
        dVar7.fD(str2);
        dVar5 = dVar7;
        d.a(dVar5, o.i.period, hVar2.nextInt(52), Integer.valueOf(2), Integer.valueOf(100), null, false, 48, null);
        d.a(dVar5, o.i.color, hVar2.nextInt(com.iqoption.charttools.model.indicator.i.ayg[0]), false, 4, null);
        d.b(dVar5, o.i.width, hVar2.nextInt(com.iqoption.charttools.model.indicator.i.ayh[0]), false, 4, null);
        MG4.add(dVar7);
        i4 = o.i.chikou_span;
        i6 = o.i.ichimoku_chikou_span_desc;
        string4 = i4 != 0 ? com.iqoption.core.f.getString(i4) : "";
        if (i6 != 0) {
            str = com.iqoption.core.f.getString(i6);
        }
        MG3 = gVar.MG();
        dVar6 = new d();
        dVar6.setName(string4);
        dVar6.setDescription(str);
        dVar6.fD(str2);
        dVar5 = dVar6;
        d.a(dVar5, o.i.offset, hVar2.nextInt(26), Integer.valueOf(2), Integer.valueOf(100), null, false, 48, null);
        d.a(dVar5, o.i.color, hVar2.nextInt(com.iqoption.charttools.model.indicator.i.ayg[4]), false, 4, null);
        d.b(dVar5, o.i.width, hVar2.nextInt(com.iqoption.charttools.model.indicator.i.ayh[0]), false, 4, null);
        MG3.add(dVar6);
        return gVar.MH();
    }

    public static final f k(h hVar) {
        h hVar2 = hVar;
        kotlin.jvm.internal.h.e(hVar2, "values");
        g gVar = new g();
        List MG = gVar.MG();
        d dVar = new d();
        d.a(dVar, o.i.smooth, hVar2.nextInt(3), Integer.valueOf(1), Integer.valueOf(100), null, false, 48, null);
        MG.add(dVar);
        String string = com.iqoption.core.f.getString(o.i.kdj_pj_desc);
        String str = null;
        String str2 = null;
        List MG2 = gVar.MG();
        d dVar2 = new d();
        dVar2.setName("%J");
        dVar2.setDescription(string);
        dVar2.fD(str2);
        d dVar3 = dVar2;
        d.a(dVar3, o.i.color, hVar2.nextInt(com.iqoption.charttools.model.indicator.i.ayg[4]), false, 4, null);
        d.b(dVar3, o.i.width, hVar2.nextInt(com.iqoption.charttools.model.indicator.i.ayh[0]), false, 4, null);
        MG2.add(dVar2);
        String string2 = com.iqoption.core.f.getString(o.i.kdj_pk_desc);
        List MG3 = gVar.MG();
        d dVar4 = new d();
        dVar4.setName("%K");
        dVar4.setDescription(string2);
        dVar4.fD(str2);
        d dVar5 = dVar4;
        d.a(dVar5, o.i.period, hVar2.nextInt(13), Integer.valueOf(2), Integer.valueOf(100), null, false, 48, null);
        d.a(dVar5, o.i.color, hVar2.nextInt(com.iqoption.charttools.model.indicator.i.ayg[3]), false, 4, null);
        d.b(dVar5, o.i.width, hVar2.nextInt(com.iqoption.charttools.model.indicator.i.ayh[0]), false, 4, null);
        MG3.add(dVar4);
        String string3 = com.iqoption.core.f.getString(o.i.kdj_pd_desc);
        List MG4 = gVar.MG();
        d dVar6 = new d();
        dVar6.setName("%D");
        dVar6.setDescription(string3);
        dVar6.fD(str2);
        dVar5 = dVar6;
        d.a(dVar5, o.i.period, hVar2.nextInt(3), Integer.valueOf(2), Integer.valueOf(100), null, false, 48, null);
        d.a(dVar5, o.i.color, hVar2.nextInt(com.iqoption.charttools.model.indicator.i.ayg[4]), false, 4, null);
        d.b(dVar5, o.i.width, hVar2.nextInt(com.iqoption.charttools.model.indicator.i.ayh[0]), false, 4, null);
        MG4.add(dVar6);
        int i = o.i.overbought;
        int i2 = o.i.kdj_overbought_desc;
        string = i != 0 ? com.iqoption.core.f.getString(i) : "";
        string2 = i2 != 0 ? com.iqoption.core.f.getString(i2) : null;
        MG3 = gVar.MG();
        dVar2 = new d();
        dVar2.setName(string);
        dVar2.setDescription(string2);
        dVar2.fD(str2);
        d.a(dVar2, o.i.period, hVar2.nextInt(80), Integer.valueOf(2), Integer.valueOf(100), null, false, 48, null);
        dVar4 = dVar2;
        d.a(dVar4, o.i.color, hVar2.nextInt(com.iqoption.charttools.model.indicator.i.ayg[9]), false, 4, null);
        d.b(dVar4, o.i.width, hVar2.nextInt(com.iqoption.charttools.model.indicator.i.ayh[0]), false, 4, null);
        MG3.add(dVar2);
        i = o.i.oversold;
        i2 = o.i.kdj_oversold_desc;
        string = i != 0 ? com.iqoption.core.f.getString(i) : "";
        if (i2 != 0) {
            str = com.iqoption.core.f.getString(i2);
        }
        MG2 = gVar.MG();
        d dVar7 = new d();
        dVar7.setName(string);
        dVar7.setDescription(str);
        dVar7.fD(str2);
        d.a(dVar7, o.i.period, hVar2.nextInt(20), Integer.valueOf(2), Integer.valueOf(100), null, false, 48, null);
        dVar3 = dVar7;
        d.a(dVar3, o.i.color, hVar2.nextInt(com.iqoption.charttools.model.indicator.i.ayg[14]), false, 4, null);
        d.b(dVar3, o.i.width, hVar2.nextInt(com.iqoption.charttools.model.indicator.i.ayh[0]), false, 4, null);
        MG2.add(dVar7);
        return gVar.MH();
    }

    public static final f l(h hVar) {
        kotlin.jvm.internal.h.e(hVar, "values");
        g gVar = new g();
        List MG = gVar.MG();
        d dVar = new d();
        d.a(dVar, o.i.period, hVar.nextInt(14), Integer.valueOf(2), Integer.valueOf(100), null, false, 48, null);
        d.a(dVar, o.i.color, hVar.nextInt(com.iqoption.charttools.model.indicator.i.ayg[7]), false, 4, null);
        d.b(dVar, o.i.width, hVar.nextInt(com.iqoption.charttools.model.indicator.i.ayh[0]), false, 4, null);
        MG.add(dVar);
        return gVar.MH();
    }

    public static final f m(h hVar) {
        kotlin.jvm.internal.h.e(hVar, "values");
        g gVar = new g();
        List MG = gVar.MG();
        d dVar = new d();
        d.a(dVar, o.i.period, hVar.nextInt(34), Integer.valueOf(2), Integer.valueOf(100), null, false, 48, null);
        MG.add(dVar);
        return gVar.MH();
    }

    public static final f n(h hVar) {
        kotlin.jvm.internal.h.e(hVar, "values");
        g gVar = new g();
        List MG = gVar.MG();
        d dVar = new d();
        d.a(dVar, o.i.type, hVar.nextInt(0), ab.ayH.Mn(), false, 8, null);
        d.a(dVar, o.i.period, hVar.nextInt(14), Integer.valueOf(2), Integer.valueOf(200), null, false, 48, null);
        d.a(dVar, o.i.color, hVar.nextInt(com.iqoption.charttools.model.indicator.i.ayg[0]), false, 4, null);
        d.b(dVar, o.i.width, hVar.nextInt(com.iqoption.charttools.model.indicator.i.ayh[0]), false, 4, null);
        MG.add(dVar);
        return gVar.MH();
    }

    public static final f o(h hVar) {
        h hVar2 = hVar;
        kotlin.jvm.internal.h.e(hVar2, "values");
        g gVar = new g();
        int i = o.i.jaws;
        int i2 = o.i.alligator_jaws_desc;
        String str = (String) null;
        String string = i != 0 ? com.iqoption.core.f.getString(i) : "";
        String string2 = i2 != 0 ? com.iqoption.core.f.getString(i2) : null;
        List MG = gVar.MG();
        d dVar = new d();
        dVar.setName(string);
        dVar.setDescription(string2);
        dVar.fD(str);
        d dVar2 = dVar;
        d.a(dVar, o.i.period, hVar2.nextInt(13), Integer.valueOf(2), Integer.valueOf(100), null, false, 48, null);
        d.a(dVar2, o.i.shift, hVar2.nextInt(8), Integer.valueOf(-100), Integer.valueOf(100), null, false, 48, null);
        d.a(dVar2, o.i.color, hVar2.nextInt(com.iqoption.charttools.model.indicator.i.ayg[4]), false, 4, null);
        d dVar3 = dVar2;
        d.b(dVar3, o.i.width, hVar2.nextInt(com.iqoption.charttools.model.indicator.i.ayh[0]), false, 4, null);
        MG.add(dVar3);
        int i3 = o.i.teeth;
        int i4 = o.i.alligator_teeth_desc;
        String string3 = i3 != 0 ? com.iqoption.core.f.getString(i3) : "";
        String string4 = i4 != 0 ? com.iqoption.core.f.getString(i4) : null;
        List MG2 = gVar.MG();
        d dVar4 = new d();
        dVar4.setName(string3);
        dVar4.setDescription(string4);
        dVar4.fD(str);
        d dVar5 = dVar4;
        d.a(dVar5, o.i.period, hVar2.nextInt(8), Integer.valueOf(2), Integer.valueOf(100), null, false, 48, null);
        d.a(dVar5, o.i.shift, hVar2.nextInt(5), Integer.valueOf(-100), Integer.valueOf(100), null, false, 48, null);
        d.a(dVar5, o.i.color, hVar2.nextInt(com.iqoption.charttools.model.indicator.i.ayg[8]), false, 4, null);
        d.b(dVar5, o.i.width, hVar2.nextInt(com.iqoption.charttools.model.indicator.i.ayh[0]), false, 4, null);
        MG2.add(dVar4);
        int i5 = o.i.lips;
        i4 = o.i.alligator_lips_desc;
        String string5 = i5 != 0 ? com.iqoption.core.f.getString(i5) : "";
        string4 = i4 != 0 ? com.iqoption.core.f.getString(i4) : null;
        MG2 = gVar.MG();
        dVar4 = new d();
        dVar4.setName(string5);
        dVar4.setDescription(string4);
        dVar4.fD(str);
        dVar5 = dVar4;
        d.a(dVar5, o.i.period, hVar2.nextInt(5), Integer.valueOf(2), Integer.valueOf(100), null, false, 48, null);
        d.a(dVar5, o.i.shift, hVar2.nextInt(3), Integer.valueOf(-100), Integer.valueOf(100), null, false, 48, null);
        d dVar6 = dVar4;
        d.a(dVar6, o.i.color, hVar2.nextInt(com.iqoption.charttools.model.indicator.i.ayg[14]), false, 4, null);
        d.b(dVar6, o.i.width, hVar2.nextInt(com.iqoption.charttools.model.indicator.i.ayh[0]), false, 4, null);
        MG2.add(dVar4);
        return gVar.MH();
    }

    public static final f p(h hVar) {
        h hVar2 = hVar;
        kotlin.jvm.internal.h.e(hVar2, "values");
        g gVar = new g();
        int i = o.i.main_settings;
        int i2 = o.i.bollinger_bands_main_settings_desc;
        String str = null;
        String str2 = null;
        String string = i != 0 ? com.iqoption.core.f.getString(i) : "";
        String string2 = i2 != 0 ? com.iqoption.core.f.getString(i2) : null;
        List MG = gVar.MG();
        d dVar = new d();
        dVar.setName(string);
        dVar.setDescription(string2);
        dVar.fD(str2);
        d dVar2 = dVar;
        d.a(dVar, o.i.period, hVar2.nextInt(14), Integer.valueOf(2), Integer.valueOf(100), null, false, 48, null);
        d.a(dVar2, o.i.deviation, hVar2.nextDouble(2.0d), Double.valueOf(0.1d), Double.valueOf(10.0d), null, false, 48, null);
        MG.add(dVar2);
        i = o.i.top_line;
        i2 = o.i.bollinger_bands_upper_line_desc;
        string = i != 0 ? com.iqoption.core.f.getString(i) : "";
        string2 = i2 != 0 ? com.iqoption.core.f.getString(i2) : null;
        MG = gVar.MG();
        d dVar3 = new d();
        dVar3.setName(string);
        dVar3.setDescription(string2);
        dVar3.fD(str2);
        d dVar4 = dVar3;
        d.a(dVar4, o.i.color, hVar2.nextInt(com.iqoption.charttools.model.indicator.i.ayg[3]), false, 4, null);
        d.b(dVar4, o.i.width, hVar2.nextInt(com.iqoption.charttools.model.indicator.i.ayh[0]), false, 4, null);
        MG.add(dVar3);
        i = o.i.middle_line;
        int i3 = o.i.bollinger_bands_middle_line_desc;
        string = i != 0 ? com.iqoption.core.f.getString(i) : "";
        String string3 = i3 != 0 ? com.iqoption.core.f.getString(i3) : null;
        List MG2 = gVar.MG();
        d dVar5 = new d();
        dVar5.setName(string);
        dVar5.setDescription(string3);
        dVar5.fD(str2);
        d dVar6 = dVar5;
        d.a(dVar6, o.i.color, hVar2.nextInt(hVar2.nextInt(com.iqoption.charttools.model.indicator.i.ayg[4])), false, 4, null);
        d.b(dVar6, o.i.width, hVar2.nextInt(com.iqoption.charttools.model.indicator.i.ayh[0]), false, 4, null);
        MG2.add(dVar5);
        i = o.i.bottom_line;
        i3 = o.i.bollinger_bands_lower_line_desc;
        string = i != 0 ? com.iqoption.core.f.getString(i) : "";
        if (i3 != 0) {
            str = com.iqoption.core.f.getString(i3);
        }
        MG = gVar.MG();
        dVar3 = new d();
        dVar3.setName(string);
        dVar3.setDescription(str);
        dVar3.fD(str2);
        dVar4 = dVar3;
        d.a(dVar4, o.i.color, hVar2.nextInt(com.iqoption.charttools.model.indicator.i.ayg[13]), false, 4, null);
        d.b(dVar4, o.i.width, hVar2.nextInt(com.iqoption.charttools.model.indicator.i.ayh[0]), false, 4, null);
        MG.add(dVar3);
        return gVar.MH();
    }

    public static final f q(h hVar) {
        kotlin.jvm.internal.h.e(hVar, "values");
        g gVar = new g();
        List MG = gVar.MG();
        d dVar = new d();
        d.a(dVar, o.i.period, hVar.nextInt(14), Integer.valueOf(2), Integer.valueOf(100), null, false, 48, null);
        d.a(dVar, o.i.color, hVar.nextInt(com.iqoption.charttools.model.indicator.i.ayg[9]), false, 4, null);
        d.b(dVar, o.i.width, hVar.nextInt(com.iqoption.charttools.model.indicator.i.ayh[0]), false, 4, null);
        d.a(dVar, o.i.overbought, hVar.nextInt(70), Integer.valueOf(1), Integer.valueOf(100), null, false, 48, null);
        d.a(dVar, o.i.color, hVar.nextInt(com.iqoption.charttools.model.indicator.i.ayg[4]), false, 4, null);
        d.b(dVar, o.i.width, hVar.nextInt(com.iqoption.charttools.model.indicator.i.ayh[0]), false, 4, null);
        d.a(dVar, o.i.oversold, hVar.nextInt(30), Integer.valueOf(1), Integer.valueOf(100), null, false, 48, null);
        d.a(dVar, o.i.color, hVar.nextInt(com.iqoption.charttools.model.indicator.i.ayg[0]), false, 4, null);
        d.b(dVar, o.i.width, hVar.nextInt(com.iqoption.charttools.model.indicator.i.ayh[0]), false, 4, null);
        MG.add(dVar);
        return gVar.MH();
    }

    public static final f r(h hVar) {
        kotlin.jvm.internal.h.e(hVar, "values");
        g gVar = new g();
        int i = o.i.main_settings;
        String str = null;
        String string = i != 0 ? com.iqoption.core.f.getString(i) : "";
        List MG = gVar.MG();
        d dVar = new d();
        dVar.setName(string);
        dVar.setDescription(null);
        dVar.fD(str);
        d dVar2 = dVar;
        d.a(dVar2, o.i.period, hVar.nextInt(14), Integer.valueOf(2), Integer.valueOf(100), null, false, 48, null);
        d.a(dVar2, o.i.color, hVar.nextInt(com.iqoption.charttools.model.indicator.i.ayg[7]), false, 4, null);
        d.b(dVar2, o.i.width, hVar.nextInt(com.iqoption.charttools.model.indicator.i.ayh[0]), false, 4, null);
        MG.add(dVar);
        MG = gVar.MG();
        d dVar3 = new d();
        dVar3.setName("+Di");
        dVar3.setDescription(str);
        dVar3.fD(str);
        dVar2 = dVar3;
        d.a(dVar2, o.i.color, hVar.nextInt(com.iqoption.charttools.model.indicator.i.ayg[4]), false, 4, null);
        d.b(dVar2, o.i.width, hVar.nextInt(com.iqoption.charttools.model.indicator.i.ayh[0]), false, 4, null);
        MG.add(dVar3);
        MG = gVar.MG();
        dVar3 = new d();
        dVar3.setName("-Di");
        dVar3.setDescription(str);
        dVar3.fD(str);
        dVar2 = dVar3;
        d.a(dVar2, o.i.color, hVar.nextInt(com.iqoption.charttools.model.indicator.i.ayg[9]), false, 4, null);
        d.b(dVar2, o.i.width, hVar.nextInt(com.iqoption.charttools.model.indicator.i.ayh[0]), false, 4, null);
        MG.add(dVar3);
        return gVar.MH();
    }

    public static final f s(h hVar) {
        kotlin.jvm.internal.h.e(hVar, "values");
        g gVar = new g();
        List MG = gVar.MG();
        d dVar = new d();
        d.a(dVar, o.i.period, hVar.nextInt(14), Integer.valueOf(2), Integer.valueOf(100), null, false, 48, null);
        d.a(dVar, o.i.color, hVar.nextInt(com.iqoption.charttools.model.indicator.i.ayg[7]), false, 4, null);
        d.b(dVar, o.i.width, hVar.nextInt(com.iqoption.charttools.model.indicator.i.ayh[0]), false, 4, null);
        MG.add(dVar);
        return gVar.MH();
    }

    public static final f t(h hVar) {
        kotlin.jvm.internal.h.e(hVar, "values");
        g gVar = new g();
        List MG = gVar.MG();
        d dVar = new d();
        d.a(dVar, o.i.slow_period, hVar.nextInt(34), Integer.valueOf(2), Integer.valueOf(100), null, false, 48, null);
        d.a(dVar, o.i.fast_period, hVar.nextInt(5), Integer.valueOf(2), Integer.valueOf(100), null, false, 48, null);
        MG.add(dVar);
        return gVar.MH();
    }

    public static final f u(h hVar) {
        h hVar2 = hVar;
        kotlin.jvm.internal.h.e(hVar2, "values");
        g gVar = new g();
        int i = o.i.main_settings;
        String str = null;
        String string = i != 0 ? com.iqoption.core.f.getString(i) : "";
        List MG = gVar.MG();
        d dVar = new d();
        dVar.setName(string);
        dVar.setDescription(null);
        dVar.fD(str);
        d dVar2 = dVar;
        d.a(dVar2, o.i.period, hVar2.nextInt(14), Integer.valueOf(2), Integer.valueOf(100), null, false, 48, null);
        d.a(dVar2, o.i.overbought, hVar2.nextInt(100), Integer.valueOf(2), Integer.valueOf(1000), null, false, 48, null);
        d.a(dVar2, o.i.color, hVar2.nextInt(com.iqoption.charttools.model.indicator.i.ayg[7]), false, 4, null);
        d.b(dVar2, o.i.width, hVar2.nextInt(com.iqoption.charttools.model.indicator.i.ayh[0]), false, 4, null);
        MG.add(dVar);
        i = o.i.overbought;
        string = i != 0 ? com.iqoption.core.f.getString(i) : "";
        MG = gVar.MG();
        d dVar3 = new d();
        dVar3.setName(string);
        dVar3.setDescription(null);
        dVar3.fD(str);
        dVar2 = dVar3;
        d.a(dVar2, o.i.color, hVar2.nextInt(com.iqoption.charttools.model.indicator.i.ayg[4]), false, 4, null);
        d.b(dVar2, o.i.width, hVar2.nextInt(com.iqoption.charttools.model.indicator.i.ayh[0]), false, 4, null);
        MG.add(dVar3);
        i = o.i.oversold;
        string = i != 0 ? com.iqoption.core.f.getString(i) : "";
        MG = gVar.MG();
        dVar3 = new d();
        dVar3.setName(string);
        dVar3.setDescription(null);
        dVar3.fD(str);
        dVar2 = dVar3;
        d.a(dVar2, o.i.color, hVar2.nextInt(com.iqoption.charttools.model.indicator.i.ayg[0]), false, 4, null);
        d.b(dVar2, o.i.width, hVar2.nextInt(com.iqoption.charttools.model.indicator.i.ayh[0]), false, 4, null);
        MG.add(dVar3);
        return gVar.MH();
    }

    public static final f v(h hVar) {
        kotlin.jvm.internal.h.e(hVar, "values");
        g gVar = new g();
        List MG = gVar.MG();
        d dVar = new d();
        d.a(dVar, o.i.period, hVar.nextInt(5), Integer.valueOf(3), Integer.valueOf(50), null, false, 48, null);
        d.a(dVar, o.i.color, hVar.nextInt(com.iqoption.charttools.model.indicator.i.ayg[4]), false, 4, null);
        d.a(dVar, o.i.color, hVar.nextInt(com.iqoption.charttools.model.indicator.i.ayg[7]), false, 4, null);
        MG.add(dVar);
        return gVar.MH();
    }

    public static final f w(h hVar) {
        h hVar2 = hVar;
        kotlin.jvm.internal.h.e(hVar2, "values");
        g gVar = new g();
        int i = o.i.macd_line;
        int i2 = o.i.macd_line_desc;
        String str = (String) null;
        String string = i != 0 ? com.iqoption.core.f.getString(i) : "";
        String string2 = i2 != 0 ? com.iqoption.core.f.getString(i2) : null;
        List MG = gVar.MG();
        d dVar = new d();
        dVar.setName(string);
        dVar.setDescription(string2);
        dVar.fD(str);
        d dVar2 = dVar;
        d.a(dVar, o.i.fast_period, hVar2.nextInt(12), Integer.valueOf(2), Integer.valueOf(100), null, false, 48, null);
        d dVar3 = dVar2;
        d.a(dVar3, o.i.slow_period, hVar2.nextInt(26), Integer.valueOf(2), Integer.valueOf(100), null, false, 48, null);
        d.a(dVar3, o.i.signal_period, hVar2.nextInt(9), Integer.valueOf(2), Integer.valueOf(100), null, false, 48, null);
        d.a(dVar3, o.i.color, hVar2.nextInt(com.iqoption.charttools.model.indicator.i.ayg[12]), false, 4, null);
        d.b(dVar3, o.i.width, hVar2.nextInt(com.iqoption.charttools.model.indicator.i.ayh[0]), false, 4, null);
        MG.add(dVar2);
        i = o.i.signal_line;
        int i3 = o.i.macd_signal_line_desc;
        string = i != 0 ? com.iqoption.core.f.getString(i) : "";
        String string3 = i3 != 0 ? com.iqoption.core.f.getString(i3) : null;
        List MG2 = gVar.MG();
        d dVar4 = new d();
        dVar4.setName(string);
        dVar4.setDescription(string3);
        dVar4.fD(str);
        d dVar5 = dVar4;
        d.a(dVar5, o.i.color, hVar2.nextInt(com.iqoption.charttools.model.indicator.i.ayg[9]), false, 4, null);
        d.b(dVar5, o.i.width, hVar2.nextInt(com.iqoption.charttools.model.indicator.i.ayh[0]), false, 4, null);
        MG2.add(dVar4);
        i = o.i.baseline;
        string = i != 0 ? com.iqoption.core.f.getString(i) : "";
        List MG3 = gVar.MG();
        d dVar6 = new d();
        dVar6.setName(string);
        dVar6.setDescription(null);
        dVar6.fD(str);
        d dVar7 = dVar6;
        d.a(dVar7, o.i.color, hVar2.nextInt(com.iqoption.charttools.model.indicator.i.ayg[1]), false, 4, null);
        d.b(dVar7, o.i.width, hVar2.nextInt(com.iqoption.charttools.model.indicator.i.ayh[0]), false, 4, null);
        MG3.add(dVar6);
        return gVar.MH();
    }

    public static final f x(h hVar) {
        kotlin.jvm.internal.h.e(hVar, "values");
        g gVar = new g();
        List MG = gVar.MG();
        d dVar = new d();
        d dVar2 = dVar;
        d.a(dVar2, o.i.acceleration, hVar.nextDouble(0.02d), Double.valueOf(0.0d), null, null, false, 56, null);
        d.a(dVar2, o.i.acceleration_max, hVar.nextDouble(0.2d), Double.valueOf(0.0d), null, null, false, 56, null);
        d.a(dVar, o.i.color, hVar.nextInt(com.iqoption.charttools.model.indicator.i.ayg[7]), false, 4, null);
        MG.add(dVar);
        return gVar.MH();
    }

    public static final f y(h hVar) {
        h hVar2 = hVar;
        kotlin.jvm.internal.h.e(hVar2, "values");
        g gVar = new g();
        List MG = gVar.MG();
        d dVar = new d();
        d.a(dVar, o.i.smooth, hVar2.nextInt(3), Integer.valueOf(0), Integer.valueOf(100), null, false, 48, null);
        MG.add(dVar);
        String string = com.iqoption.core.f.getString(o.i.stochastic_pk_desc);
        String str = null;
        String str2 = null;
        List MG2 = gVar.MG();
        dVar = new d();
        dVar.setName("%K");
        dVar.setDescription(string);
        dVar.fD(str2);
        d.a(dVar, o.i.period, hVar2.nextInt(13), Integer.valueOf(2), Integer.valueOf(100), null, false, 48, null);
        d dVar2 = dVar;
        d.a(dVar, o.i.color, hVar2.nextInt(com.iqoption.charttools.model.indicator.i.ayg[7]), false, 4, null);
        d.b(dVar2, o.i.width, hVar2.nextInt(com.iqoption.charttools.model.indicator.i.ayh[0]), false, 4, null);
        MG2.add(dVar2);
        String string2 = com.iqoption.core.f.getString(o.i.stochastic_pd_desc);
        List MG3 = gVar.MG();
        d dVar3 = new d();
        dVar3.setName("%D");
        dVar3.setDescription(string2);
        dVar3.fD(str2);
        d dVar4 = dVar3;
        d.a(dVar4, o.i.period, hVar2.nextInt(3), Integer.valueOf(2), Integer.valueOf(100), null, false, 48, null);
        d.a(dVar4, o.i.color, hVar2.nextInt(com.iqoption.charttools.model.indicator.i.ayg[0]), false, 4, null);
        d.b(dVar4, o.i.width, hVar2.nextInt(com.iqoption.charttools.model.indicator.i.ayh[0]), false, 4, null);
        MG3.add(dVar3);
        int i = o.i.overbought;
        int i2 = o.i.stochastic_overbought_desc;
        String string3 = i != 0 ? com.iqoption.core.f.getString(i) : "";
        string = i2 != 0 ? com.iqoption.core.f.getString(i2) : null;
        MG2 = gVar.MG();
        d dVar5 = new d();
        dVar5.setName(string3);
        dVar5.setDescription(string);
        dVar5.fD(str2);
        d.a(dVar5, o.i.overbought, hVar2.nextInt(80), Integer.valueOf(1), Integer.valueOf(100), null, false, 48, null);
        d dVar6 = dVar5;
        d.a(dVar6, o.i.color, hVar2.nextInt(com.iqoption.charttools.model.indicator.i.ayg[4]), false, 4, null);
        d.b(dVar6, o.i.width, hVar2.nextInt(com.iqoption.charttools.model.indicator.i.ayh[0]), false, 4, null);
        MG2.add(dVar5);
        i2 = o.i.oversold;
        int i3 = o.i.stochastic_oversold_desc;
        string = i2 != 0 ? com.iqoption.core.f.getString(i2) : "";
        if (i3 != 0) {
            str = com.iqoption.core.f.getString(i3);
        }
        MG2 = gVar.MG();
        dVar5 = new d();
        dVar5.setName(string);
        dVar5.setDescription(str);
        dVar5.fD(str2);
        d.a(dVar5, o.i.oversold, hVar2.nextInt(20), Integer.valueOf(1), Integer.valueOf(100), null, false, 48, null);
        dVar6 = dVar5;
        d.a(dVar6, o.i.color, hVar2.nextInt(com.iqoption.charttools.model.indicator.i.ayg[7]), false, 4, null);
        d.b(dVar6, o.i.width, hVar2.nextInt(com.iqoption.charttools.model.indicator.i.ayh[0]), false, 4, null);
        MG2.add(dVar5);
        return gVar.MH();
    }
}
