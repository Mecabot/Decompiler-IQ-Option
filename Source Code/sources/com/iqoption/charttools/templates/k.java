package com.iqoption.charttools.templates;

import android.util.SparseArray;
import com.iqoption.charttools.model.chart.ChartColor;
import com.iqoption.charttools.model.chart.ChartType;
import com.iqoption.charttools.model.indicator.h;
import com.iqoption.charttools.model.indicator.x;
import com.iqoption.charttools.o;
import com.iqoption.core.f;
import com.iqoption.core.microservices.tradingengine.response.active.d;
import com.iqoption.core.util.s;
import java.util.ArrayList;
import java.util.List;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b*\b\b\u0018\u0000 C2\u00020\u0001:\u0001CBQ\b\u0016\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fB\u001d\b\u0016\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0010B\u0001\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0006\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u001c\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001a\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010 J\t\u00101\u001a\u00020\fHÆ\u0003J\t\u00102\u001a\u00020\u001aHÆ\u0003J\t\u00103\u001a\u00020\u001aHÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00120\u0006HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u0010\u00108\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0002\u0010\"J\t\u00109\u001a\u00020\u001aHÆ\u0003J\t\u0010:\u001a\u00020\u001aHÆ\u0003J\t\u0010;\u001a\u00020\u001aHÆ\u0003J\t\u0010<\u001a\u00020\u001aHÆ\u0003J\u0001\u0010=\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\f2\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00062\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u001a2\b\b\u0002\u0010\u001d\u001a\u00020\u001a2\b\b\u0002\u0010\u001e\u001a\u00020\u001a2\b\b\u0002\u0010\u001f\u001a\u00020\u001a2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010>J\u0013\u0010?\u001a\u00020\u001a2\b\u0010@\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010A\u001a\u00020\u0018HÖ\u0001J\t\u0010B\u001a\u00020\fHÖ\u0001R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0013\u0010(\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0006¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010\u001b\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010-R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010-R\u0011\u0010\u001c\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010-R\u0011\u0010\u001e\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010-R\u0011\u0010\u001d\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010-R\u0011\u0010\u001f\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010-R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b.\u0010*R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b/\u00100¨\u0006D"}, aXE = {"Lcom/iqoption/charttools/templates/TemplateInitialState;", "", "actives", "Landroid/util/SparseArray;", "Lcom/iqoption/core/microservices/tradingengine/response/active/Active;", "indicators", "", "Lcom/iqoption/charttools/model/indicator/ChartIndicator;", "figures", "config", "Lcom/iqoption/charttools/model/chart/ChartConfig;", "name", "", "template", "Lcom/iqoption/charttools/model/template/ChartTemplate;", "(Landroid/util/SparseArray;Ljava/util/List;Ljava/util/List;Lcom/iqoption/charttools/model/chart/ChartConfig;Ljava/lang/String;Lcom/iqoption/charttools/model/template/ChartTemplate;)V", "(Lcom/iqoption/charttools/model/template/ChartTemplate;Landroid/util/SparseArray;)V", "instruments", "Lcom/iqoption/charttools/templates/InstrumentAdapterItem;", "chartType", "Lcom/iqoption/charttools/model/chart/ChartType;", "chartColor", "Lcom/iqoption/charttools/model/chart/ChartColor;", "candleSize", "", "isChartSettingsEnabled", "", "isAutoScaleEnabled", "isHeikenAshiEnabled", "isTradersMoodEnabled", "isLiveDealsEnabled", "isVolumeEnabled", "(Ljava/lang/String;Ljava/util/List;Lcom/iqoption/charttools/model/chart/ChartType;Lcom/iqoption/charttools/model/chart/ChartColor;Ljava/lang/Integer;ZZZZZZLcom/iqoption/charttools/model/template/ChartTemplate;)V", "getCandleSize", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getChartColor", "()Lcom/iqoption/charttools/model/chart/ChartColor;", "getChartType", "()Lcom/iqoption/charttools/model/chart/ChartType;", "formattedCandleSize", "getFormattedCandleSize", "()Ljava/lang/String;", "getInstruments", "()Ljava/util/List;", "()Z", "getName", "getTemplate", "()Lcom/iqoption/charttools/model/template/ChartTemplate;", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/util/List;Lcom/iqoption/charttools/model/chart/ChartType;Lcom/iqoption/charttools/model/chart/ChartColor;Ljava/lang/Integer;ZZZZZZLcom/iqoption/charttools/model/template/ChartTemplate;)Lcom/iqoption/charttools/templates/TemplateInitialState;", "equals", "other", "hashCode", "toString", "Companion", "techtools_release"})
/* compiled from: TemplateInitialState.kt */
public final class k {
    @Deprecated
    public static final a azI = new a();
    private final com.iqoption.charttools.model.a.a atq;
    private final Integer axO;
    private final ChartType azA;
    private final ChartColor azB;
    private final boolean azC;
    private final boolean azD;
    private final boolean azE;
    private final boolean azF;
    private final boolean azG;
    private final boolean azH;
    private final String azy;
    private final List<d> azz;
    private final String name;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J6\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0004¨\u0006\f"}, aXE = {"Lcom/iqoption/charttools/templates/TemplateInitialState$Companion;", "", "()V", "map", "", "Lcom/iqoption/charttools/templates/InstrumentAdapterItem;", "actives", "Landroid/util/SparseArray;", "Lcom/iqoption/core/microservices/tradingengine/response/active/Active;", "indicators", "Lcom/iqoption/charttools/model/indicator/ChartIndicator;", "figures", "techtools_release"})
    /* compiled from: TemplateInitialState.kt */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final List<d> a(SparseArray<com.iqoption.core.microservices.tradingengine.response.active.a> sparseArray, List<h> list, List<h> list2) {
            kotlin.jvm.internal.h.e(sparseArray, "actives");
            kotlin.jvm.internal.h.e(list, "indicators");
            kotlin.jvm.internal.h.e(list2, "figures");
            if (list.size() + list2.size() == 0) {
                return m.emptyList();
            }
            List<d> arrayList = new ArrayList();
            if ((list.isEmpty() ^ 1) != 0) {
                arrayList.add(new o(f.getString(o.i.indicators), null, 2, null));
                for (h hVar : list) {
                    arrayList.add(new c(hVar.Ma(), hVar, null, 4, null));
                }
            }
            if ((list2.isEmpty() ^ 1) != 0) {
                arrayList.add(new o(f.getString(o.i.lines), null, 2, null));
                for (h hVar2 : list2) {
                    x KJ = hVar2.KJ();
                    if (!(KJ instanceof com.iqoption.charttools.model.indicator.k)) {
                        KJ = null;
                    }
                    com.iqoption.charttools.model.indicator.k kVar = (com.iqoption.charttools.model.indicator.k) KJ;
                    com.iqoption.core.microservices.tradingengine.response.active.a aVar = (com.iqoption.core.microservices.tradingengine.response.active.a) sparseArray.get(kVar != null ? kVar.b(hVar2.Mc()) : -1);
                    if (aVar != null) {
                        arrayList.add(new b(hVar2.KJ().Mi(), d.s(aVar), hVar2, null, 8, null));
                    }
                }
            }
            return arrayList;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof k) {
            k kVar = (k) obj;
            if (kotlin.jvm.internal.h.E(this.name, kVar.name) && kotlin.jvm.internal.h.E(this.azz, kVar.azz) && kotlin.jvm.internal.h.E(this.azA, kVar.azA) && kotlin.jvm.internal.h.E(this.azB, kVar.azB) && kotlin.jvm.internal.h.E(this.axO, kVar.axO)) {
                if ((this.azC == kVar.azC ? 1 : null) != null) {
                    if ((this.azD == kVar.azD ? 1 : null) != null) {
                        if ((this.azE == kVar.azE ? 1 : null) != null) {
                            if ((this.azF == kVar.azF ? 1 : null) != null) {
                                if ((this.azG == kVar.azG ? 1 : null) != null) {
                                    return (this.azH == kVar.azH ? 1 : null) != null && kotlin.jvm.internal.h.E(this.atq, kVar.atq);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public int hashCode() {
        String str = this.name;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List list = this.azz;
        hashCode = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        ChartType chartType = this.azA;
        hashCode = (hashCode + (chartType != null ? chartType.hashCode() : 0)) * 31;
        ChartColor chartColor = this.azB;
        hashCode = (hashCode + (chartColor != null ? chartColor.hashCode() : 0)) * 31;
        Integer num = this.axO;
        hashCode = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        int i2 = this.azC;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        i2 = this.azD;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        i2 = this.azE;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        i2 = this.azF;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        i2 = this.azG;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        i2 = this.azH;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        com.iqoption.charttools.model.a.a aVar = this.atq;
        if (aVar != null) {
            i = aVar.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TemplateInitialState(name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", instruments=");
        stringBuilder.append(this.azz);
        stringBuilder.append(", chartType=");
        stringBuilder.append(this.azA);
        stringBuilder.append(", chartColor=");
        stringBuilder.append(this.azB);
        stringBuilder.append(", candleSize=");
        stringBuilder.append(this.axO);
        stringBuilder.append(", isChartSettingsEnabled=");
        stringBuilder.append(this.azC);
        stringBuilder.append(", isAutoScaleEnabled=");
        stringBuilder.append(this.azD);
        stringBuilder.append(", isHeikenAshiEnabled=");
        stringBuilder.append(this.azE);
        stringBuilder.append(", isTradersMoodEnabled=");
        stringBuilder.append(this.azF);
        stringBuilder.append(", isLiveDealsEnabled=");
        stringBuilder.append(this.azG);
        stringBuilder.append(", isVolumeEnabled=");
        stringBuilder.append(this.azH);
        stringBuilder.append(", template=");
        stringBuilder.append(this.atq);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public k(String str, List<? extends d> list, ChartType chartType, ChartColor chartColor, Integer num, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, com.iqoption.charttools.model.a.a aVar) {
        kotlin.jvm.internal.h.e(str, "name");
        kotlin.jvm.internal.h.e(list, "instruments");
        this.name = str;
        this.azz = list;
        this.azA = chartType;
        this.azB = chartColor;
        this.axO = num;
        this.azC = z;
        this.azD = z2;
        this.azE = z3;
        this.azF = z4;
        this.azG = z5;
        this.azH = z6;
        this.atq = aVar;
        Integer num2 = this.axO;
        if (num2 != null) {
            str = s.bhj.ec(num2.intValue());
        } else {
            str = null;
        }
        this.azy = str;
    }

    public final String getName() {
        return this.name;
    }

    public final List<d> Ik() {
        return this.azz;
    }

    public final ChartType MP() {
        return this.azA;
    }

    public final ChartColor MQ() {
        return this.azB;
    }

    public final Integer LR() {
        return this.axO;
    }

    public final boolean MR() {
        return this.azC;
    }

    public final boolean MS() {
        return this.azD;
    }

    public final boolean MT() {
        return this.azE;
    }

    public final boolean MU() {
        return this.azF;
    }

    public final boolean MV() {
        return this.azG;
    }

    public final boolean Ka() {
        return this.azH;
    }

    public final String MO() {
        return this.azy;
    }

    public /* synthetic */ k(SparseArray sparseArray, List list, List list2, com.iqoption.charttools.model.chart.a aVar, String str, com.iqoption.charttools.model.a.a aVar2, int i, f fVar) {
        if ((i & 16) != 0) {
            str = "";
        }
        String str2 = str;
        if ((i & 32) != 0) {
            aVar2 = (com.iqoption.charttools.model.a.a) null;
        }
        this(sparseArray, list, list2, aVar, str2, aVar2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0081  */
    public k(android.util.SparseArray<com.iqoption.core.microservices.tradingengine.response.active.a> r18, java.util.List<com.iqoption.charttools.model.indicator.h> r19, java.util.List<com.iqoption.charttools.model.indicator.h> r20, com.iqoption.charttools.model.chart.a r21, java.lang.String r22, com.iqoption.charttools.model.a.a r23) {
        /*
        r17 = this;
        r0 = r18;
        r1 = r19;
        r2 = r20;
        r3 = "actives";
        kotlin.jvm.internal.h.e(r0, r3);
        r3 = "indicators";
        kotlin.jvm.internal.h.e(r1, r3);
        r3 = "figures";
        kotlin.jvm.internal.h.e(r2, r3);
        r3 = "name";
        r5 = r22;
        kotlin.jvm.internal.h.e(r5, r3);
        r3 = azI;
        r6 = r3.a(r0, r1, r2);
        r0 = 0;
        if (r21 == 0) goto L_0x002b;
    L_0x0025:
        r1 = r21.LP();
        r7 = r1;
        goto L_0x002c;
    L_0x002b:
        r7 = r0;
    L_0x002c:
        if (r21 == 0) goto L_0x0034;
    L_0x002e:
        r1 = r21.LQ();
        r8 = r1;
        goto L_0x0035;
    L_0x0034:
        r8 = r0;
    L_0x0035:
        if (r21 == 0) goto L_0x003b;
    L_0x0037:
        r0 = r21.LR();
    L_0x003b:
        r9 = r0;
        r0 = 0;
        if (r21 == 0) goto L_0x0042;
    L_0x003f:
        r1 = 1;
        r10 = 1;
        goto L_0x0043;
    L_0x0042:
        r10 = 0;
    L_0x0043:
        if (r21 == 0) goto L_0x0051;
    L_0x0045:
        r1 = r21.LS();
        if (r1 == 0) goto L_0x0051;
    L_0x004b:
        r1 = r1.booleanValue();
        r11 = r1;
        goto L_0x0052;
    L_0x0051:
        r11 = 0;
    L_0x0052:
        if (r21 == 0) goto L_0x0060;
    L_0x0054:
        r1 = r21.LT();
        if (r1 == 0) goto L_0x0060;
    L_0x005a:
        r1 = r1.booleanValue();
        r12 = r1;
        goto L_0x0061;
    L_0x0060:
        r12 = 0;
    L_0x0061:
        if (r21 == 0) goto L_0x006f;
    L_0x0063:
        r1 = r21.LU();
        if (r1 == 0) goto L_0x006f;
    L_0x0069:
        r1 = r1.booleanValue();
        r13 = r1;
        goto L_0x0070;
    L_0x006f:
        r13 = 0;
    L_0x0070:
        if (r21 == 0) goto L_0x007e;
    L_0x0072:
        r1 = r21.LV();
        if (r1 == 0) goto L_0x007e;
    L_0x0078:
        r1 = r1.booleanValue();
        r14 = r1;
        goto L_0x007f;
    L_0x007e:
        r14 = 0;
    L_0x007f:
        if (r21 == 0) goto L_0x008d;
    L_0x0081:
        r1 = r21.LW();
        if (r1 == 0) goto L_0x008d;
    L_0x0087:
        r0 = r1.booleanValue();
        r15 = r0;
        goto L_0x008e;
    L_0x008d:
        r15 = 0;
    L_0x008e:
        r4 = r17;
        r16 = r23;
        r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.charttools.templates.k.<init>(android.util.SparseArray, java.util.List, java.util.List, com.iqoption.charttools.model.chart.a, java.lang.String, com.iqoption.charttools.model.a.a):void");
    }

    public k(com.iqoption.charttools.model.a.a aVar, SparseArray<com.iqoption.core.microservices.tradingengine.response.active.a> sparseArray) {
        kotlin.jvm.internal.h.e(aVar, "template");
        kotlin.jvm.internal.h.e(sparseArray, "actives");
        this(sparseArray, aVar.JT(), aVar.Kr(), aVar.MK(), aVar.getName(), aVar);
    }
}
