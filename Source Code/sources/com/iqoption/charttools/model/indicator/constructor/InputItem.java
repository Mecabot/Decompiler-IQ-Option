package com.iqoption.charttools.model.indicator.constructor;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.util.Arrays;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b(\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\b\u0018\u0000 F2\u00020\u0001:\u0003FGHB\u0007\b\u0016¢\u0006\u0002\u0010\u0002Bc\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\t\u00101\u001a\u00020\u0004HÆ\u0003J\t\u00102\u001a\u00020\u0006HÆ\u0003J\t\u00103\u001a\u00020\u0006HÆ\u0003J\u0010\u00104\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u00105\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u00106\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0016\u00107\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010)J\t\u00108\u001a\u00020\u000fHÆ\u0003Jl\u00109\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fHÆ\u0001¢\u0006\u0002\u0010:J\t\u0010;\u001a\u00020\u0015HÖ\u0001J\u0013\u0010<\u001a\u00020\u000f2\b\u0010=\u001a\u0004\u0018\u00010>H\u0002J\b\u0010?\u001a\u00020\u0015H\u0016J\t\u0010@\u001a\u00020\u0006HÖ\u0001J\u0019\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0011\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0011\u0010\u001c\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0017R\u001a\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010!\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b$\u0010\u001fR\u0011\u0010%\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b&\u0010#R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010#R \u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r8\u0006X\u0004¢\u0006\n\n\u0002\u0010*\u001a\u0004\b(\u0010)R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b+\u0010\u001fR\u0011\u0010,\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b-\u0010#R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010#¨\u0006I"}, aXE = {"Lcom/iqoption/charttools/model/indicator/constructor/InputItem;", "Landroid/os/Parcelable;", "()V", "type", "Lcom/iqoption/charttools/model/indicator/constructor/InputItem$Type;", "name", "", "value", "min", "", "max", "step", "options", "", "hidden", "", "(Lcom/iqoption/charttools/model/indicator/constructor/InputItem$Type;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;[Ljava/lang/String;Z)V", "booleanValue", "getBooleanValue", "()Z", "colorValue", "", "getColorValue", "()I", "doubleValue", "getDoubleValue", "()D", "getHidden", "intValue", "getIntValue", "getMax", "()Ljava/lang/Double;", "Ljava/lang/Double;", "maxString", "getMaxString", "()Ljava/lang/String;", "getMin", "minString", "getMinString", "getName", "getOptions", "()[Ljava/lang/String;", "[Ljava/lang/String;", "getStep", "stepString", "getStepString", "getType", "()Lcom/iqoption/charttools/model/indicator/constructor/InputItem$Type;", "getValue", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Lcom/iqoption/charttools/model/indicator/constructor/InputItem$Type;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;[Ljava/lang/String;Z)Lcom/iqoption/charttools/model/indicator/constructor/InputItem;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "Type", "TypeGsonAdapter", "techtools_release"})
/* compiled from: InputItem.kt */
public final class InputItem implements Parcelable {
    public static final Creator CREATOR = new b();
    public static final a azb = new a();
    @SerializedName("options")
    private final String[] auK;
    @SerializedName("type")
    private final Type ayW;
    @SerializedName("min")
    private final Double ayX;
    @SerializedName("max")
    private final Double ayY;
    @SerializedName("step")
    private final Double ayZ;
    private final boolean aza;
    @SerializedName("name")
    private final String name;
    @SerializedName("value")
    private final String value;

    @JsonAdapter(c.class)
    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, aXE = {"Lcom/iqoption/charttools/model/indicator/constructor/InputItem$Type;", "", "serverName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getServerName", "()Ljava/lang/String;", "INT", "DOUBLE", "BOOL", "STRING", "ACTIVE", "CANDLE_DURATION", "INT_SELECTION", "DOUBLE_SELECTION", "STRING_SELECTION", "COLOR", "LINE_WIDTH", "PLOT_VISIBILITY", "HOST", "UNKNOWN", "techtools_release"})
    /* compiled from: InputItem.kt */
    public enum Type {
        INT("integer"),
        DOUBLE("double"),
        BOOL("boolean"),
        STRING("string"),
        ACTIVE("active"),
        CANDLE_DURATION("candle_duration"),
        INT_SELECTION("integer_selection"),
        DOUBLE_SELECTION("double_selection"),
        STRING_SELECTION("string_selection"),
        COLOR("color"),
        LINE_WIDTH("line_width"),
        PLOT_VISIBILITY("plot_visibility"),
        HOST("host"),
        UNKNOWN("unknown");
        
        private final String serverName;

        protected Type(String str) {
            h.e(str, "serverName");
            this.serverName = str;
        }

        public final String getServerName() {
            return this.serverName;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, aXE = {"Lcom/iqoption/charttools/model/indicator/constructor/InputItem$Companion;", "", "()V", "HOST_CHART", "", "LINE_WIDTH_1", "LINE_WIDTH_2", "LINE_WIDTH_3", "techtools_release"})
    /* compiled from: InputItem.kt */
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
            h.e(parcel, "in");
            return new InputItem((Type) Enum.valueOf(Type.class, parcel.readString()), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? Double.valueOf(parcel.readDouble()) : null, parcel.readInt() != 0 ? Double.valueOf(parcel.readDouble()) : null, parcel.readInt() != 0 ? Double.valueOf(parcel.readDouble()) : null, parcel.createStringArray(), parcel.readInt() != 0);
        }

        public final Object[] newArray(int i) {
            return new InputItem[i];
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\f"}, aXE = {"Lcom/iqoption/charttools/model/indicator/constructor/InputItem$TypeGsonAdapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/iqoption/charttools/model/indicator/constructor/InputItem$Type;", "()V", "read", "in", "Lcom/google/gson/stream/JsonReader;", "write", "", "out", "Lcom/google/gson/stream/JsonWriter;", "value", "techtools_release"})
    /* compiled from: InputItem.kt */
    public static final class c extends TypeAdapter<Type> {
        /* renamed from: a */
        public void write(JsonWriter jsonWriter, Type type) {
            if (jsonWriter != null) {
                jsonWriter.value(type != null ? type.getServerName() : null);
            }
        }

        /* renamed from: b */
        public Type read(JsonReader jsonReader) {
            Type type = null;
            Object nextString = jsonReader != null ? jsonReader.nextString() : null;
            Enum enumR = Type.UNKNOWN;
            for (Type type2 : Type.values()) {
                if (h.E(type2.getServerName(), nextString)) {
                    type = type2;
                    break;
                }
            }
            if (type == null) {
                type = enumR;
            }
            return type;
        }
    }

    public static /* bridge */ /* synthetic */ InputItem a(InputItem inputItem, Type type, String str, String str2, Double d, Double d2, Double d3, String[] strArr, boolean z, int i, Object obj) {
        InputItem inputItem2 = inputItem;
        int i2 = i;
        return inputItem2.a((i2 & 1) != 0 ? inputItem2.ayW : type, (i2 & 2) != 0 ? inputItem2.name : str, (i2 & 4) != 0 ? inputItem2.value : str2, (i2 & 8) != 0 ? inputItem2.ayX : d, (i2 & 16) != 0 ? inputItem2.ayY : d2, (i2 & 32) != 0 ? inputItem2.ayZ : d3, (i2 & 64) != 0 ? inputItem2.auK : strArr, (i2 & 128) != 0 ? inputItem2.aza : z);
    }

    public final InputItem a(Type type, String str, String str2, Double d, Double d2, Double d3, String[] strArr, boolean z) {
        Type type2 = type;
        h.e(type2, Param.TYPE);
        String str3 = str;
        h.e(str3, "name");
        String str4 = str2;
        h.e(str4, com.google.firebase.analytics.FirebaseAnalytics.b.VALUE);
        return new InputItem(type2, str3, str4, d, d2, d3, strArr, z);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("InputItem(type=");
        stringBuilder.append(this.ayW);
        stringBuilder.append(", name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", value=");
        stringBuilder.append(this.value);
        stringBuilder.append(", min=");
        stringBuilder.append(this.ayX);
        stringBuilder.append(", max=");
        stringBuilder.append(this.ayY);
        stringBuilder.append(", step=");
        stringBuilder.append(this.ayZ);
        stringBuilder.append(", options=");
        stringBuilder.append(Arrays.toString(this.auK));
        stringBuilder.append(", hidden=");
        stringBuilder.append(this.aza);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        h.e(parcel, "parcel");
        parcel.writeString(this.ayW.name());
        parcel.writeString(this.name);
        parcel.writeString(this.value);
        Double d = this.ayX;
        if (d != null) {
            parcel.writeInt(1);
            parcel.writeDouble(d.doubleValue());
        } else {
            parcel.writeInt(0);
        }
        d = this.ayY;
        if (d != null) {
            parcel.writeInt(1);
            parcel.writeDouble(d.doubleValue());
        } else {
            parcel.writeInt(0);
        }
        d = this.ayZ;
        if (d != null) {
            parcel.writeInt(1);
            parcel.writeDouble(d.doubleValue());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeStringArray(this.auK);
        parcel.writeInt(this.aza);
    }

    public InputItem(Type type, String str, String str2, Double d, Double d2, Double d3, String[] strArr, boolean z) {
        h.e(type, Param.TYPE);
        h.e(str, "name");
        h.e(str2, com.google.firebase.analytics.FirebaseAnalytics.b.VALUE);
        this.ayW = type;
        this.name = str;
        this.value = str2;
        this.ayX = d;
        this.ayY = d2;
        this.ayZ = d3;
        this.auK = strArr;
        this.aza = z;
    }

    public /* synthetic */ InputItem(Type type, String str, String str2, Double d, Double d2, Double d3, String[] strArr, boolean z, int i, f fVar) {
        int i2 = i;
        this((i2 & 1) != 0 ? Type.UNKNOWN : type, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? "" : str2, (i2 & 8) != 0 ? (Double) null : d, (i2 & 16) != 0 ? (Double) null : d2, (i2 & 32) != 0 ? (Double) null : d3, (i2 & 64) != 0 ? (String[]) null : strArr, (i2 & 128) != 0 ? false : z);
    }

    public final Type My() {
        return this.ayW;
    }

    public final String getName() {
        return this.name;
    }

    public final String getValue() {
        return this.value;
    }

    public final Double Mz() {
        return this.ayX;
    }

    public final Double MA() {
        return this.ayY;
    }

    public final Double MB() {
        return this.ayZ;
    }

    public final String[] getOptions() {
        return this.auK;
    }

    public final boolean MC() {
        return this.aza;
    }

    public final int getIntValue() {
        return (int) Double.parseDouble(this.value);
    }

    public final double Mu() {
        return Double.parseDouble(this.value);
    }

    public final boolean getBooleanValue() {
        return Boolean.parseBoolean(this.value);
    }

    public final int Mv() {
        return com.iqoption.core.ext.a.gp(this.value);
    }

    public final String Mw() {
        if (this.ayX == null) {
            return "";
        }
        String valueOf;
        switch (e.aoS[this.ayW.ordinal()]) {
            case 1:
                valueOf = String.valueOf((int) this.ayX.doubleValue());
                break;
            case 2:
                valueOf = String.valueOf(this.ayX.doubleValue());
                break;
            default:
                valueOf = "";
                break;
        }
        return valueOf;
    }

    public final String Mx() {
        if (this.ayY == null) {
            return "";
        }
        String valueOf;
        switch (e.auk[this.ayW.ordinal()]) {
            case 1:
                valueOf = String.valueOf((int) this.ayY.doubleValue());
                break;
            case 2:
                valueOf = String.valueOf(this.ayY.doubleValue());
                break;
            default:
                valueOf = "";
                break;
        }
        return valueOf;
    }

    public InputItem() {
        this(Type.UNKNOWN, null, null, null, null, null, null, false, 254, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((h.E(getClass(), obj != null ? obj.getClass() : null) ^ 1) != 0) {
            return false;
        }
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.iqoption.charttools.model.indicator.constructor.InputItem");
        }
        InputItem inputItem = (InputItem) obj;
        if (this.ayW == inputItem.ayW && (h.E(this.name, inputItem.name) ^ 1) == 0 && (h.E(this.value, inputItem.value) ^ 1) == 0 && (h.j(this.ayX, inputItem.ayX) ^ 1) == 0 && (h.j(this.ayY, inputItem.ayY) ^ 1) == 0 && (h.j(this.ayZ, inputItem.ayZ) ^ 1) == 0 && Arrays.equals(this.auK, inputItem.auK)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((this.ayW.hashCode() * 31) + this.name.hashCode()) * 31) + this.value.hashCode()) * 31;
        Double d = this.ayX;
        int i = 0;
        hashCode = (hashCode + (d != null ? d.hashCode() : 0)) * 31;
        d = this.ayY;
        hashCode = (hashCode + (d != null ? d.hashCode() : 0)) * 31;
        d = this.ayZ;
        hashCode = (hashCode + (d != null ? d.hashCode() : 0)) * 31;
        String[] strArr = this.auK;
        if (strArr != null) {
            i = Arrays.hashCode(strArr);
        }
        return hashCode + i;
    }
}
