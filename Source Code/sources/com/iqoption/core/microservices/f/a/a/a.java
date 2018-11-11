package com.iqoption.core.microservices.f.a.a;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;
import com.iqoption.core.data.model.InstrumentType;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 <2\u00020\u0001:\u0002<=Bi\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\t\u0010%\u001a\u00020\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010-\u001a\u00020\rHÆ\u0003Jq\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\t\u0010/\u001a\u00020\u0003HÖ\u0001J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u000103HÖ\u0003J\t\u00104\u001a\u00020\u0003HÖ\u0001J\t\u00105\u001a\u000206HÖ\u0001J\u0019\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R \u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R \u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u0014R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014R \u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0012\"\u0004\b\"\u0010\u0014R \u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0012\"\u0004\b$\u0010\u0014¨\u0006>"}, aXE = {"Lcom/iqoption/core/microservices/topassets/response/spread/SpreadData;", "Landroid/os/Parcelable;", "activeId", "", "spread", "Lcom/iqoption/core/microservices/topassets/response/spread/SpreadData$ValueIsValid;", "diff1h", "diffTradingDay", "curPrice", "volatility", "popularity", "volume", "instrumentType", "Lcom/iqoption/core/data/model/InstrumentType;", "(ILcom/iqoption/core/microservices/topassets/response/spread/SpreadData$ValueIsValid;Lcom/iqoption/core/microservices/topassets/response/spread/SpreadData$ValueIsValid;Lcom/iqoption/core/microservices/topassets/response/spread/SpreadData$ValueIsValid;Lcom/iqoption/core/microservices/topassets/response/spread/SpreadData$ValueIsValid;Lcom/iqoption/core/microservices/topassets/response/spread/SpreadData$ValueIsValid;Lcom/iqoption/core/microservices/topassets/response/spread/SpreadData$ValueIsValid;Lcom/iqoption/core/microservices/topassets/response/spread/SpreadData$ValueIsValid;Lcom/iqoption/core/data/model/InstrumentType;)V", "getActiveId", "()I", "getCurPrice", "()Lcom/iqoption/core/microservices/topassets/response/spread/SpreadData$ValueIsValid;", "setCurPrice", "(Lcom/iqoption/core/microservices/topassets/response/spread/SpreadData$ValueIsValid;)V", "getDiff1h", "setDiff1h", "getDiffTradingDay", "setDiffTradingDay", "getInstrumentType", "()Lcom/iqoption/core/data/model/InstrumentType;", "setInstrumentType", "(Lcom/iqoption/core/data/model/InstrumentType;)V", "getPopularity", "setPopularity", "getSpread", "setSpread", "getVolatility", "setVolatility", "getVolume", "setVolume", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "ValueIsValid", "core_release"})
/* compiled from: SpreadData.kt */
public final class a implements Parcelable {
    public static final Creator CREATOR = new b();
    public static final a aYn = new a();
    @SerializedName("spread")
    private c aYg;
    @SerializedName("diff_1h")
    private c aYh;
    @SerializedName("diff_trading_day")
    private c aYi;
    @SerializedName("cur_price")
    private c aYj;
    @SerializedName("volatility")
    private c aYk;
    @SerializedName("popularity")
    private c aYl;
    @SerializedName("volume")
    private c aYm;
    @SerializedName("active_id")
    private final int activeId;
    private InstrumentType instrumentType;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0002\u0010\u0007J\u0019\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0002\u0010\u0007J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0002\u0010\u0007J\u0019\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0002\u0010\rJ\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0002\u0010\u0007¨\u0006\u000f"}, aXE = {"Lcom/iqoption/core/microservices/topassets/response/spread/SpreadData$Companion;", "", "()V", "getCurPrice", "", "spread", "Lcom/iqoption/core/microservices/topassets/response/spread/SpreadData;", "(Lcom/iqoption/core/microservices/topassets/response/spread/SpreadData;)Ljava/lang/Double;", "getDiffTradingDay", "getSpread", "getValue", "valueIsValid", "Lcom/iqoption/core/microservices/topassets/response/spread/SpreadData$ValueIsValid;", "(Lcom/iqoption/core/microservices/topassets/response/spread/SpreadData$ValueIsValid;)Ljava/lang/Double;", "getVolume", "core_release"})
    /* compiled from: SpreadData.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final Double a(a aVar) {
            if (aVar != null) {
                c WW = aVar.WW();
                if (WW != null) {
                    return WW.getValue();
                }
            }
            return null;
        }

        public final Double b(a aVar) {
            if (aVar != null) {
                c WY = aVar.WY();
                if (WY != null) {
                    return WY.getValue();
                }
            }
            return null;
        }

        public final Double c(a aVar) {
            if (aVar != null) {
                c WZ = aVar.WZ();
                if (WZ != null) {
                    return WZ.getValue();
                }
            }
            return null;
        }

        public final Double d(a aVar) {
            if (aVar != null) {
                c Xc = aVar.Xc();
                if (Xc != null) {
                    return Xc.getValue();
                }
            }
            return null;
        }

        public final Double h(c cVar) {
            return cVar != null ? cVar.getValue() : null;
        }
    }

    @i(aXC = {1, 1, 11})
    public static class b implements Creator {
        public final Object createFromParcel(Parcel parcel) {
            h.e(parcel, "in");
            return new a(parcel.readInt(), parcel.readInt() != 0 ? (c) c.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (c) c.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (c) c.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (c) c.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (c) c.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (c) c.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (c) c.CREATOR.createFromParcel(parcel) : null, (InstrumentType) Enum.valueOf(InstrumentType.class, parcel.readString()));
        }

        public final Object[] newArray(int i) {
            return new a[i];
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\r\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0013J\t\u0010\u0014\u001a\u00020\u000eHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000eHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\t¨\u0006\u001c"}, aXE = {"Lcom/iqoption/core/microservices/topassets/response/spread/SpreadData$ValueIsValid;", "Landroid/os/Parcelable;", "_value", "", "isValid", "", "(DZ)V", "get_value", "()D", "()Z", "component1", "component2", "copy", "describeContents", "", "equals", "other", "", "getValue", "()Ljava/lang/Double;", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "core_release"})
    /* compiled from: SpreadData.kt */
    public static final class c implements Parcelable {
        public static final Creator CREATOR = new a();
        @SerializedName("value")
        private final double _value;
        @SerializedName("is_valid")
        private final boolean isValid;

        @i(aXC = {1, 1, 11})
        public static class a implements Creator {
            public final Object createFromParcel(Parcel parcel) {
                h.e(parcel, "in");
                return new c(parcel.readDouble(), parcel.readInt() != 0);
            }

            public final Object[] newArray(int i) {
                return new c[i];
            }
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof c) {
                c cVar = (c) obj;
                if (Double.compare(this._value, cVar._value) == 0) {
                    if ((this.isValid == cVar.isValid ? 1 : null) != null) {
                        return true;
                    }
                }
            }
            return false;
        }

        public int hashCode() {
            long doubleToLongBits = Double.doubleToLongBits(this._value);
            int i = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) * 31;
            int i2 = this.isValid;
            if (i2 != 0) {
                i2 = 1;
            }
            return i + i2;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ValueIsValid(_value=");
            stringBuilder.append(this._value);
            stringBuilder.append(", isValid=");
            stringBuilder.append(this.isValid);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            h.e(parcel, "parcel");
            parcel.writeDouble(this._value);
            parcel.writeInt(this.isValid);
        }

        public c(double d, boolean z) {
            this._value = d;
            this.isValid = z;
        }

        public final boolean isValid() {
            return this.isValid;
        }

        public final Double getValue() {
            return this.isValid ? Double.valueOf(this._value) : null;
        }
    }

    public static final Double a(a aVar) {
        return aYn.a(aVar);
    }

    public static final Double b(a aVar) {
        return aYn.b(aVar);
    }

    public static final Double c(a aVar) {
        return aYn.c(aVar);
    }

    public static final Double d(a aVar) {
        return aYn.d(aVar);
    }

    public static final Double h(c cVar) {
        return aYn.h(cVar);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            return (this.activeId == aVar.activeId ? 1 : null) != null && h.E(this.aYg, aVar.aYg) && h.E(this.aYh, aVar.aYh) && h.E(this.aYi, aVar.aYi) && h.E(this.aYj, aVar.aYj) && h.E(this.aYk, aVar.aYk) && h.E(this.aYl, aVar.aYl) && h.E(this.aYm, aVar.aYm) && h.E(this.instrumentType, aVar.instrumentType);
        }
    }

    public int hashCode() {
        int i = this.activeId * 31;
        c cVar = this.aYg;
        int i2 = 0;
        i = (i + (cVar != null ? cVar.hashCode() : 0)) * 31;
        cVar = this.aYh;
        i = (i + (cVar != null ? cVar.hashCode() : 0)) * 31;
        cVar = this.aYi;
        i = (i + (cVar != null ? cVar.hashCode() : 0)) * 31;
        cVar = this.aYj;
        i = (i + (cVar != null ? cVar.hashCode() : 0)) * 31;
        cVar = this.aYk;
        i = (i + (cVar != null ? cVar.hashCode() : 0)) * 31;
        cVar = this.aYl;
        i = (i + (cVar != null ? cVar.hashCode() : 0)) * 31;
        cVar = this.aYm;
        i = (i + (cVar != null ? cVar.hashCode() : 0)) * 31;
        InstrumentType instrumentType = this.instrumentType;
        if (instrumentType != null) {
            i2 = instrumentType.hashCode();
        }
        return i + i2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SpreadData(activeId=");
        stringBuilder.append(this.activeId);
        stringBuilder.append(", spread=");
        stringBuilder.append(this.aYg);
        stringBuilder.append(", diff1h=");
        stringBuilder.append(this.aYh);
        stringBuilder.append(", diffTradingDay=");
        stringBuilder.append(this.aYi);
        stringBuilder.append(", curPrice=");
        stringBuilder.append(this.aYj);
        stringBuilder.append(", volatility=");
        stringBuilder.append(this.aYk);
        stringBuilder.append(", popularity=");
        stringBuilder.append(this.aYl);
        stringBuilder.append(", volume=");
        stringBuilder.append(this.aYm);
        stringBuilder.append(", instrumentType=");
        stringBuilder.append(this.instrumentType);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        h.e(parcel, "parcel");
        parcel.writeInt(this.activeId);
        Parcelable parcelable = this.aYg;
        if (parcelable != null) {
            parcel.writeInt(1);
            parcelable.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcelable = this.aYh;
        if (parcelable != null) {
            parcel.writeInt(1);
            parcelable.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcelable = this.aYi;
        if (parcelable != null) {
            parcel.writeInt(1);
            parcelable.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcelable = this.aYj;
        if (parcelable != null) {
            parcel.writeInt(1);
            parcelable.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcelable = this.aYk;
        if (parcelable != null) {
            parcel.writeInt(1);
            parcelable.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcelable = this.aYl;
        if (parcelable != null) {
            parcel.writeInt(1);
            parcelable.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcelable = this.aYm;
        if (parcelable != null) {
            parcel.writeInt(1);
            parcelable.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.instrumentType.name());
    }

    public a(int i, c cVar, c cVar2, c cVar3, c cVar4, c cVar5, c cVar6, c cVar7, InstrumentType instrumentType) {
        h.e(instrumentType, "instrumentType");
        this.activeId = i;
        this.aYg = cVar;
        this.aYh = cVar2;
        this.aYi = cVar3;
        this.aYj = cVar4;
        this.aYk = cVar5;
        this.aYl = cVar6;
        this.aYm = cVar7;
        this.instrumentType = instrumentType;
    }

    public final int getActiveId() {
        return this.activeId;
    }

    public final c WW() {
        return this.aYg;
    }

    public final void a(c cVar) {
        this.aYg = cVar;
    }

    public final c WX() {
        return this.aYh;
    }

    public final void b(c cVar) {
        this.aYh = cVar;
    }

    public final c WY() {
        return this.aYi;
    }

    public final void c(c cVar) {
        this.aYi = cVar;
    }

    public final c WZ() {
        return this.aYj;
    }

    public final void d(c cVar) {
        this.aYj = cVar;
    }

    public final c Xa() {
        return this.aYk;
    }

    public final void e(c cVar) {
        this.aYk = cVar;
    }

    public final c Xb() {
        return this.aYl;
    }

    public final void f(c cVar) {
        this.aYl = cVar;
    }

    public final c Xc() {
        return this.aYm;
    }

    public final void g(c cVar) {
        this.aYm = cVar;
    }

    public final void b(InstrumentType instrumentType) {
        h.e(instrumentType, "<set-?>");
        this.instrumentType = instrumentType;
    }

    public final InstrumentType getInstrumentType() {
        return this.instrumentType;
    }
}
