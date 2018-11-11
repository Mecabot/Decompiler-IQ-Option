package com.iqoption.core.data.model;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.iqoption.core.ext.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.h;

@JsonAdapter(a.class)
@i(aXC = {1, 1, 11}, aXD = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0001\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\u0016\u0017B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\u0003J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\tJ\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\b\u0010\r\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0018"}, aXE = {"Lcom/iqoption/core/data/model/InstrumentType;", "", "serverValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getServerValue", "()Ljava/lang/String;", "getOptionActiveOrInstrumentValue", "isForexOrCFD", "", "isOption", "toOptionActiveType", "Lcom/iqoption/core/data/model/ActiveType;", "toString", "TURBO_INSTRUMENT", "BINARY_INSTRUMENT", "DIGITAL_INSTRUMENT", "FX_INSTRUMENT", "FOREX_INSTRUMENT", "CFD_INSTRUMENT", "CRYPTO_INSTRUMENT", "UNKNOWN", "Adapter", "Companion", "core_release"})
/* compiled from: InstrumentType.kt */
public enum InstrumentType {
    TURBO_INSTRUMENT("turbo-option"),
    BINARY_INSTRUMENT("binary-option"),
    DIGITAL_INSTRUMENT("digital-option"),
    FX_INSTRUMENT("fx-option"),
    FOREX_INSTRUMENT("forex"),
    CFD_INSTRUMENT("cfd"),
    CRYPTO_INSTRUMENT("crypto"),
    UNKNOWN("_UNKNOWN");
    
    public static final b Companion = null;
    private final String serverValue;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004H\u0007¢\u0006\u0002\u0010\bJ%\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00042\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0007¢\u0006\u0002\u0010\u000bJ%\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00042\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\fH\u0007¢\u0006\u0002\u0010\rJ\u0012\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007H\u0007J\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007H\u0007J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\fH\u0007J\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005H\u0007¨\u0006\u0014"}, aXE = {"Lcom/iqoption/core/data/model/InstrumentType$Companion;", "", "()V", "convertToInstrumentTypeArray", "", "Lcom/iqoption/core/data/model/InstrumentType;", "types", "", "([Ljava/lang/String;)[Lcom/iqoption/core/data/model/InstrumentType;", "convertToStringArray", "instruments", "([Lcom/iqoption/core/data/model/InstrumentType;)[Ljava/lang/String;", "", "(Ljava/util/List;)[Ljava/lang/String;", "fromServerValue", "value", "fromServerValueNullable", "getKnownValues", "serverValue", "instrumentType", "core_release"})
    /* compiled from: InstrumentType.kt */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(f fVar) {
            this();
        }

        public final InstrumentType fromServerValue(String str) {
            InstrumentType instrumentType;
            InstrumentType instrumentType2;
            InstrumentType[] values = InstrumentType.values();
            int length = values.length;
            int i = 0;
            while (true) {
                instrumentType = null;
                if (i >= length) {
                    instrumentType2 = null;
                    break;
                }
                instrumentType2 = values[i];
                if (h.E(instrumentType2.getServerValue(), str)) {
                    break;
                }
                i++;
            }
            if (instrumentType2 != null) {
                instrumentType = instrumentType2;
            } else {
                for (ActiveType activeType : ActiveType.values()) {
                    if (h.E(activeType.getServerValue(), str)) {
                        break;
                    }
                }
                ActiveType activeType2 = null;
                if (activeType2 != null) {
                    instrumentType = activeType2.toInstrumentType();
                }
            }
            return instrumentType != null ? instrumentType : InstrumentType.UNKNOWN;
        }

        public final InstrumentType fromServerValueNullable(String str) {
            return str != null ? InstrumentType.Companion.fromServerValue(str) : null;
        }

        public final String serverValue(InstrumentType instrumentType) {
            return instrumentType != null ? instrumentType.getServerValue() : null;
        }

        public final String[] convertToStringArray(List<? extends InstrumentType> list) {
            if (list == null) {
                return null;
            }
            Iterable<InstrumentType> iterable = list;
            Collection arrayList = new ArrayList(n.e(iterable, 10));
            for (InstrumentType serverValue : iterable) {
                arrayList.add(serverValue.getServerValue());
            }
            Object[] toArray = ((List) arrayList).toArray(new String[0]);
            if (toArray != null) {
                return (String[]) toArray;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }

        public final List<InstrumentType> getKnownValues() {
            InstrumentType[] values = InstrumentType.values();
            Collection arrayList = new ArrayList();
            for (InstrumentType instrumentType : values) {
                if ((instrumentType != InstrumentType.UNKNOWN ? 1 : null) != null) {
                    arrayList.add(instrumentType);
                }
            }
            return (List) arrayList;
        }

        public final String[] convertToStringArray(InstrumentType[] instrumentTypeArr) {
            if (instrumentTypeArr == null) {
                return null;
            }
            Collection arrayList = new ArrayList(instrumentTypeArr.length);
            for (InstrumentType serverValue : instrumentTypeArr) {
                arrayList.add(serverValue.getServerValue());
            }
            Object[] toArray = ((List) arrayList).toArray(new String[0]);
            if (toArray != null) {
                return (String[]) toArray;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }

        public final InstrumentType[] convertToInstrumentTypeArray(String[] strArr) {
            if (strArr == null) {
                return null;
            }
            Collection arrayList = new ArrayList(strArr.length);
            for (String fromServerValue : strArr) {
                arrayList.add(InstrumentType.Companion.fromServerValue(fromServerValue));
            }
            Object[] toArray = ((List) arrayList).toArray(new InstrumentType[0]);
            if (toArray != null) {
                return (InstrumentType[]) toArray;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\f"}, aXE = {"Lcom/iqoption/core/data/model/InstrumentType$Adapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/iqoption/core/data/model/InstrumentType;", "()V", "read", "reader", "Lcom/google/gson/stream/JsonReader;", "write", "", "out", "Lcom/google/gson/stream/JsonWriter;", "type", "core_release"})
    /* compiled from: InstrumentType.kt */
    public static final class a extends TypeAdapter<InstrumentType> {
        /* renamed from: a */
        public void write(JsonWriter jsonWriter, InstrumentType instrumentType) {
            h.e(jsonWriter, "out");
            jsonWriter.value(instrumentType != null ? instrumentType.getServerValue() : null);
        }

        /* renamed from: e */
        public InstrumentType read(JsonReader jsonReader) {
            String nextString;
            h.e(jsonReader, "reader");
            if (jsonReader.peek() != JsonToken.NULL) {
                nextString = jsonReader.nextString();
            } else {
                jsonReader.skipValue();
                nextString = null;
            }
            return InstrumentType.Companion.fromServerValue(nextString);
        }
    }

    public static final InstrumentType[] convertToInstrumentTypeArray(String[] strArr) {
        return Companion.convertToInstrumentTypeArray(strArr);
    }

    public static final String[] convertToStringArray(List<? extends InstrumentType> list) {
        return Companion.convertToStringArray((List) list);
    }

    public static final String[] convertToStringArray(InstrumentType[] instrumentTypeArr) {
        return Companion.convertToStringArray(instrumentTypeArr);
    }

    public static final InstrumentType fromServerValue(String str) {
        return Companion.fromServerValue(str);
    }

    public static final InstrumentType fromServerValueNullable(String str) {
        return Companion.fromServerValueNullable(str);
    }

    public static final List<InstrumentType> getKnownValues() {
        return Companion.getKnownValues();
    }

    public static final String serverValue(InstrumentType instrumentType) {
        return Companion.serverValue(instrumentType);
    }

    protected InstrumentType(String str) {
        h.e(str, "serverValue");
        this.serverValue = str;
    }

    public final String getServerValue() {
        return this.serverValue;
    }

    static {
        Companion = new b();
    }

    public final boolean isOption() {
        return c.b((Object) this, TURBO_INSTRUMENT, BINARY_INSTRUMENT, DIGITAL_INSTRUMENT, FX_INSTRUMENT);
    }

    public final boolean isForexOrCFD() {
        return c.b((Object) this, FOREX_INSTRUMENT, CFD_INSTRUMENT);
    }

    public final ActiveType toOptionActiveType() {
        switch (b.aoS[ordinal()]) {
            case 1:
                return ActiveType.TURBO_ACTIVE;
            case 2:
                return ActiveType.BINARY_ACTIVE;
            case 3:
                return ActiveType.DIGITAL_ACTIVE;
            case 4:
                return ActiveType.FX_ACTIVE;
            default:
                return null;
        }
    }

    public final String getOptionActiveOrInstrumentValue() {
        ActiveType toOptionActiveType = toOptionActiveType();
        if (toOptionActiveType != null) {
            String serverValue = toOptionActiveType.getServerValue();
            if (serverValue != null) {
                return serverValue;
            }
        }
        return this.serverValue;
    }

    public String toString() {
        return this.serverValue;
    }
}
