package com.iqoption.core.data.model;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.h;

@JsonAdapter(a.class)
@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0001\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\u0016\u0017B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\b\u0010\t\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0018"}, aXE = {"Lcom/iqoption/core/data/model/ActiveType;", "", "serverValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getServerValue", "()Ljava/lang/String;", "toInstrumentType", "Lcom/iqoption/core/data/model/InstrumentType;", "toString", "TURBO_ACTIVE", "BINARY_ACTIVE", "DIGITAL_ACTIVE", "FX_ACTIVE", "FOREX_ACTIVE", "CRYPTO_ACTIVE", "STOCK_ACTIVE", "COMMODITY_ACTIVE", "ETF_ACTIVE", "INDEX_ACTIVE", "BOND_ACTIVE", "UNKNOWN", "Adapter", "Companion", "core_release"})
/* compiled from: ActiveType.kt */
public enum ActiveType {
    TURBO_ACTIVE("turbo"),
    BINARY_ACTIVE("binary"),
    DIGITAL_ACTIVE("digital-option"),
    FX_ACTIVE("fx-option"),
    FOREX_ACTIVE("Forex"),
    CRYPTO_ACTIVE("Crypto"),
    STOCK_ACTIVE("Stock"),
    COMMODITY_ACTIVE("Commodity"),
    ETF_ACTIVE("ETF"),
    INDEX_ACTIVE("Index"),
    BOND_ACTIVE("Bond"),
    UNKNOWN("_UNKNOWN");
    
    public static final b Companion = null;
    private final String serverValue;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007J%\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0002\u0010\nJ%\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00072\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0007¢\u0006\u0002\u0010\rJ\u0012\u0010\u000e\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007J\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\bH\u0007¨\u0006\u0012"}, aXE = {"Lcom/iqoption/core/data/model/ActiveType$Companion;", "", "()V", "convertToActiveName", "", "value", "convertToActiveTypeArray", "", "Lcom/iqoption/core/data/model/ActiveType;", "types", "([Ljava/lang/String;)[Lcom/iqoption/core/data/model/ActiveType;", "convertToStringArray", "activeTypes", "([Lcom/iqoption/core/data/model/ActiveType;)[Ljava/lang/String;", "fromServerValue", "fromServerValueNullable", "serverValue", "activeType", "core_release"})
    /* compiled from: ActiveType.kt */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(f fVar) {
            this();
        }

        public final ActiveType fromServerValue(String str) {
            for (ActiveType activeType : ActiveType.values()) {
                if (h.E(activeType.getServerValue(), str)) {
                    break;
                }
            }
            ActiveType activeType2 = null;
            return activeType2 != null ? activeType2 : ActiveType.UNKNOWN;
        }

        public final ActiveType fromServerValueNullable(String str) {
            return str != null ? fromServerValue(str) : null;
        }

        public final String serverValue(ActiveType activeType) {
            return activeType != null ? activeType.getServerValue() : null;
        }

        public final String convertToActiveName(String str) {
            InstrumentType fromServerValue = InstrumentType.Companion.fromServerValue(str);
            ActiveType toOptionActiveType = fromServerValue.toOptionActiveType();
            ActiveType fromServerValue2 = ActiveType.Companion.fromServerValue(str);
            if (toOptionActiveType != null) {
                return toOptionActiveType.getServerValue();
            }
            if (fromServerValue != InstrumentType.UNKNOWN) {
                return fromServerValue.getServerValue();
            }
            return fromServerValue2 != ActiveType.UNKNOWN ? fromServerValue2.getServerValue() : null;
        }

        public final String[] convertToStringArray(ActiveType[] activeTypeArr) {
            if (activeTypeArr == null) {
                return null;
            }
            Collection arrayList = new ArrayList(activeTypeArr.length);
            for (ActiveType serverValue : activeTypeArr) {
                arrayList.add(serverValue.getServerValue());
            }
            Object[] toArray = ((List) arrayList).toArray(new String[0]);
            if (toArray != null) {
                return (String[]) toArray;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }

        public final ActiveType[] convertToActiveTypeArray(String[] strArr) {
            if (strArr == null) {
                return null;
            }
            Collection arrayList = new ArrayList(strArr.length);
            for (String fromServerValue : strArr) {
                arrayList.add(ActiveType.Companion.fromServerValue(fromServerValue));
            }
            Object[] toArray = ((List) arrayList).toArray(new ActiveType[0]);
            if (toArray != null) {
                return (ActiveType[]) toArray;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\f"}, aXE = {"Lcom/iqoption/core/data/model/ActiveType$Adapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/iqoption/core/data/model/ActiveType;", "()V", "read", "reader", "Lcom/google/gson/stream/JsonReader;", "write", "", "out", "Lcom/google/gson/stream/JsonWriter;", "type", "core_release"})
    /* compiled from: ActiveType.kt */
    public static final class a extends TypeAdapter<ActiveType> {
        /* renamed from: a */
        public void write(JsonWriter jsonWriter, ActiveType activeType) {
            h.e(jsonWriter, "out");
            jsonWriter.value(activeType != null ? activeType.getServerValue() : null);
        }

        /* renamed from: d */
        public ActiveType read(JsonReader jsonReader) {
            String nextString;
            h.e(jsonReader, "reader");
            if (jsonReader.peek() != JsonToken.NULL) {
                nextString = jsonReader.nextString();
            } else {
                jsonReader.skipValue();
                nextString = null;
            }
            return ActiveType.Companion.fromServerValue(nextString);
        }
    }

    public static final String convertToActiveName(String str) {
        return Companion.convertToActiveName(str);
    }

    public static final ActiveType[] convertToActiveTypeArray(String[] strArr) {
        return Companion.convertToActiveTypeArray(strArr);
    }

    public static final String[] convertToStringArray(ActiveType[] activeTypeArr) {
        return Companion.convertToStringArray(activeTypeArr);
    }

    public static final ActiveType fromServerValue(String str) {
        return Companion.fromServerValue(str);
    }

    public static final ActiveType fromServerValueNullable(String str) {
        return Companion.fromServerValueNullable(str);
    }

    public static final String serverValue(ActiveType activeType) {
        return Companion.serverValue(activeType);
    }

    protected ActiveType(String str) {
        h.e(str, "serverValue");
        this.serverValue = str;
    }

    public final String getServerValue() {
        return this.serverValue;
    }

    static {
        Companion = new b();
    }

    public final InstrumentType toInstrumentType() {
        switch (a.aoS[ordinal()]) {
            case 1:
                return InstrumentType.TURBO_INSTRUMENT;
            case 2:
                return InstrumentType.BINARY_INSTRUMENT;
            case 3:
                return InstrumentType.DIGITAL_INSTRUMENT;
            case 4:
                return InstrumentType.FX_INSTRUMENT;
            case 5:
                return InstrumentType.FOREX_INSTRUMENT;
            case 6:
                return InstrumentType.CRYPTO_INSTRUMENT;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                return InstrumentType.CFD_INSTRUMENT;
            default:
                return null;
        }
    }

    public String toString() {
        return this.serverValue;
    }
}
