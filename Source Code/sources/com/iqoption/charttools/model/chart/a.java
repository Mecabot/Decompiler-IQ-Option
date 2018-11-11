package com.iqoption.charttools.model.chart;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.gson.JsonObject;
import com.iqoption.core.ext.d;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 22\u00020\u0001:\u00012B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004BU\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010 \u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010!\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010\"\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0017Jn\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010$J\t\u0010%\u001a\u00020\nHÖ\u0001J\u0013\u0010&\u001a\u00020\f2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020\nHÖ\u0001J\u0006\u0010*\u001a\u00020\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\u0019\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\nHÖ\u0001R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u000b\u0010\u0017R\u0015\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\r\u0010\u0017R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u000f\u0010\u0017R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u000e\u0010\u0017R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0010\u0010\u0017R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u00063"}, aXE = {"Lcom/iqoption/charttools/model/chart/ChartConfig;", "Landroid/os/Parcelable;", "json", "Lcom/google/gson/JsonObject;", "(Lcom/google/gson/JsonObject;)V", "type", "Lcom/iqoption/charttools/model/chart/ChartType;", "color", "Lcom/iqoption/charttools/model/chart/ChartColor;", "candleSize", "", "isAutoScaleEnabled", "", "isHeikenAshiEnabled", "isTradersMoodEnabled", "isLiveDealsEnabled", "isVolumeEnabled", "(Lcom/iqoption/charttools/model/chart/ChartType;Lcom/iqoption/charttools/model/chart/ChartColor;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getCandleSize", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getColor", "()Lcom/iqoption/charttools/model/chart/ChartColor;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getType", "()Lcom/iqoption/charttools/model/chart/ChartType;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Lcom/iqoption/charttools/model/chart/ChartType;Lcom/iqoption/charttools/model/chart/ChartColor;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/iqoption/charttools/model/chart/ChartConfig;", "describeContents", "equals", "other", "", "hashCode", "toJsonObject", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "techtools_release"})
/* compiled from: ChartConfig.kt */
public final class a implements Parcelable {
    public static final Creator CREATOR = new b();
    public static final a axU = new a();
    private final ChartType axM;
    private final ChartColor axN;
    private final Integer axO;
    private final Boolean axP;
    private final Boolean axQ;
    private final Boolean axR;
    private final Boolean axS;
    private final Boolean axT;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, aXE = {"Lcom/iqoption/charttools/model/chart/ChartConfig$Companion;", "", "()V", "AUTO_SCALE", "", "CANDLE_SIZE", "COLOR", "HEIKIN_ASHI", "LIVE_DEALS", "TRADERS_MOOD", "TYPE", "VOLUME", "techtools_release"})
    /* compiled from: ChartConfig.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    @i(aXC = {1, 1, 11})
    public static class b implements Creator {
        public final Object createFromParcel(Parcel parcel) {
            Boolean valueOf;
            Boolean valueOf2;
            Boolean valueOf3;
            Boolean valueOf4;
            Boolean valueOf5;
            h.e(parcel, "in");
            ChartType chartType = parcel.readInt() != 0 ? (ChartType) Enum.valueOf(ChartType.class, parcel.readString()) : null;
            ChartColor chartColor = parcel.readInt() != 0 ? (ChartColor) Enum.valueOf(ChartColor.class, parcel.readString()) : null;
            Integer valueOf6 = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            boolean z = false;
            if (parcel.readInt() != 0) {
                valueOf = Boolean.valueOf(parcel.readInt() != 0);
            } else {
                valueOf = null;
            }
            if (parcel.readInt() != 0) {
                valueOf2 = Boolean.valueOf(parcel.readInt() != 0);
            } else {
                valueOf2 = null;
            }
            if (parcel.readInt() != 0) {
                valueOf3 = Boolean.valueOf(parcel.readInt() != 0);
            } else {
                valueOf3 = null;
            }
            if (parcel.readInt() != 0) {
                valueOf4 = Boolean.valueOf(parcel.readInt() != 0);
            } else {
                valueOf4 = null;
            }
            if (parcel.readInt() != 0) {
                if (parcel.readInt() != 0) {
                    z = true;
                }
                valueOf5 = Boolean.valueOf(z);
            } else {
                valueOf5 = null;
            }
            return new a(chartType, chartColor, valueOf6, valueOf, valueOf2, valueOf3, valueOf4, valueOf5);
        }

        public final Object[] newArray(int i) {
            return new a[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    /* JADX WARNING: Missing block: B:18:0x0056, code:
            if (kotlin.jvm.internal.h.E(r2.axT, r3.axT) != false) goto L_0x005b;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x005b;
    L_0x0002:
        r0 = r3 instanceof com.iqoption.charttools.model.chart.a;
        if (r0 == 0) goto L_0x0059;
    L_0x0006:
        r3 = (com.iqoption.charttools.model.chart.a) r3;
        r0 = r2.axM;
        r1 = r3.axM;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x0059;
    L_0x0012:
        r0 = r2.axN;
        r1 = r3.axN;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x0059;
    L_0x001c:
        r0 = r2.axO;
        r1 = r3.axO;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x0059;
    L_0x0026:
        r0 = r2.axP;
        r1 = r3.axP;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x0059;
    L_0x0030:
        r0 = r2.axQ;
        r1 = r3.axQ;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x0059;
    L_0x003a:
        r0 = r2.axR;
        r1 = r3.axR;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x0059;
    L_0x0044:
        r0 = r2.axS;
        r1 = r3.axS;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x0059;
    L_0x004e:
        r0 = r2.axT;
        r3 = r3.axT;
        r3 = kotlin.jvm.internal.h.E(r0, r3);
        if (r3 == 0) goto L_0x0059;
    L_0x0058:
        goto L_0x005b;
    L_0x0059:
        r3 = 0;
        return r3;
    L_0x005b:
        r3 = 1;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.charttools.model.chart.a.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        ChartType chartType = this.axM;
        int i = 0;
        int hashCode = (chartType != null ? chartType.hashCode() : 0) * 31;
        ChartColor chartColor = this.axN;
        hashCode = (hashCode + (chartColor != null ? chartColor.hashCode() : 0)) * 31;
        Integer num = this.axO;
        hashCode = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        Boolean bool = this.axP;
        hashCode = (hashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        bool = this.axQ;
        hashCode = (hashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        bool = this.axR;
        hashCode = (hashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        bool = this.axS;
        hashCode = (hashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        bool = this.axT;
        if (bool != null) {
            i = bool.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ChartConfig(type=");
        stringBuilder.append(this.axM);
        stringBuilder.append(", color=");
        stringBuilder.append(this.axN);
        stringBuilder.append(", candleSize=");
        stringBuilder.append(this.axO);
        stringBuilder.append(", isAutoScaleEnabled=");
        stringBuilder.append(this.axP);
        stringBuilder.append(", isHeikenAshiEnabled=");
        stringBuilder.append(this.axQ);
        stringBuilder.append(", isTradersMoodEnabled=");
        stringBuilder.append(this.axR);
        stringBuilder.append(", isLiveDealsEnabled=");
        stringBuilder.append(this.axS);
        stringBuilder.append(", isVolumeEnabled=");
        stringBuilder.append(this.axT);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        h.e(parcel, "parcel");
        Enum enumR = this.axM;
        if (enumR != null) {
            parcel.writeInt(1);
            parcel.writeString(enumR.name());
        } else {
            parcel.writeInt(0);
        }
        enumR = this.axN;
        if (enumR != null) {
            parcel.writeInt(1);
            parcel.writeString(enumR.name());
        } else {
            parcel.writeInt(0);
        }
        Integer num = this.axO;
        if (num != null) {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        } else {
            parcel.writeInt(0);
        }
        Boolean bool = this.axP;
        if (bool != null) {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue());
        } else {
            parcel.writeInt(0);
        }
        bool = this.axQ;
        if (bool != null) {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue());
        } else {
            parcel.writeInt(0);
        }
        bool = this.axR;
        if (bool != null) {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue());
        } else {
            parcel.writeInt(0);
        }
        bool = this.axS;
        if (bool != null) {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue());
        } else {
            parcel.writeInt(0);
        }
        bool = this.axT;
        if (bool != null) {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue());
            return;
        }
        parcel.writeInt(0);
    }

    public a(ChartType chartType, ChartColor chartColor, Integer num, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5) {
        this.axM = chartType;
        this.axN = chartColor;
        this.axO = num;
        this.axP = bool;
        this.axQ = bool2;
        this.axR = bool3;
        this.axS = bool4;
        this.axT = bool5;
    }

    public final ChartType LP() {
        return this.axM;
    }

    public final ChartColor LQ() {
        return this.axN;
    }

    public final Integer LR() {
        return this.axO;
    }

    public final Boolean LS() {
        return this.axP;
    }

    public final Boolean LT() {
        return this.axQ;
    }

    public final Boolean LU() {
        return this.axR;
    }

    public final Boolean LV() {
        return this.axS;
    }

    public final Boolean LW() {
        return this.axT;
    }

    public a(JsonObject jsonObject) {
        ChartType chartType;
        ChartColor chartColor;
        JsonObject jsonObject2 = jsonObject;
        h.e(jsonObject2, "json");
        String a = d.a(jsonObject2, Param.TYPE, null, 2, null);
        if (a != null) {
            for (ChartType chartType2 : ChartType.values()) {
                if (h.E(chartType2.name(), a)) {
                    break;
                }
            }
            ChartType chartType22 = null;
            chartType = chartType22;
        } else {
            chartType = null;
        }
        Boolean a2 = d.a(jsonObject2, "color", null, 2, null);
        if (a2 != null) {
            chartColor = a2.booleanValue() ? ChartColor.redGreen : ChartColor.mono;
        } else {
            chartColor = null;
        }
        this(chartType, chartColor, d.a(jsonObject2, "candle_size", null, 2, null), d.a(jsonObject2, "auto_scale", null, 2, null), d.a(jsonObject2, "heikin_ashi", null, 2, null), d.a(jsonObject2, "traders_mood", null, 2, null), d.a(jsonObject2, "live_deals", null, 2, null), d.a(jsonObject2, "volume", null, 2, null));
    }

    public final JsonObject LO() {
        JsonObject jsonObject = new JsonObject();
        if (this.axM != null) {
            jsonObject.addProperty(Param.TYPE, this.axM.name());
        }
        if (this.axN != null) {
            jsonObject.addProperty("color", Boolean.valueOf(this.axN == ChartColor.redGreen));
        }
        if (this.axO != null) {
            jsonObject.addProperty("candle_size", (Number) this.axO);
        }
        if (this.axP != null) {
            jsonObject.addProperty("auto_scale", this.axP);
        }
        if (this.axQ != null) {
            jsonObject.addProperty("heikin_ashi", this.axQ);
        }
        if (this.axR != null) {
            jsonObject.addProperty("traders_mood", this.axR);
        }
        if (this.axS != null) {
            jsonObject.addProperty("live_deals", this.axS);
        }
        if (this.axT != null) {
            jsonObject.addProperty("volume", this.axT);
        }
        return jsonObject;
    }
}
