package com.iqoption.core.microservices.tradingengine.response.active;

import android.os.Parcelable;
import com.iqoption.core.data.model.ActiveType;
import com.iqoption.core.data.model.InstrumentType;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u0000 &2\u00020\u0001:\u0001&B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\u0012H&J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u000f\u0010\u0015\u001a\u0004\u0018\u00010\u0012H&¢\u0006\u0002\u0010\u0016J\u000f\u0010\u0017\u001a\u0004\u0018\u00010\u0012H&¢\u0006\u0002\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H&J\b\u0010\u001b\u001a\u00020\u0012H&J\b\u0010\u001c\u001a\u00020\u0019H&J\n\u0010\u001d\u001a\u0004\u0018\u00010\u0004H&J\b\u0010\u001e\u001a\u00020\u001fH&J\u0010\u0010 \u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\u0019H&J\b\u0010!\u001a\u00020\u001fH&J\b\u0010\"\u001a\u00020\u001fH&J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0000H&R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0006¨\u0006'"}, aXE = {"Lcom/iqoption/core/microservices/tradingengine/response/active/Active;", "Landroid/os/Parcelable;", "()V", "image", "", "getImage", "()Ljava/lang/String;", "instrumentId", "getInstrumentId", "instrumentType", "Lcom/iqoption/core/data/model/InstrumentType;", "getInstrumentType", "()Lcom/iqoption/core/data/model/InstrumentType;", "setInstrumentType", "(Lcom/iqoption/core/data/model/InstrumentType;)V", "underlying", "getUnderlying", "getActiveId", "", "getActiveType", "Lcom/iqoption/core/data/model/ActiveType;", "getCommission", "()Ljava/lang/Integer;", "getGroupId", "getNextSchedule", "", "timeSync", "getPrecision", "getStartTime", "getTicker", "isBuybackEnabled", "", "isEnabled", "isExpired", "isTopTradersEnabled", "update", "", "value", "Companion", "core_release"})
/* compiled from: Active.kt */
public abstract class a implements Parcelable {
    private static final f aYq = new f();
    public static final a aYr = new a();
    public InstrumentType instrumentType;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u0004H\u0007J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001b\u001a\u00020\u0004H\u0007J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001aH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006 "}, aXE = {"Lcom/iqoption/core/microservices/tradingengine/response/active/Active$Companion;", "", "()V", "APPLE_ACTIVE_ID", "", "BASE_PRICE", "", "BINARY_ID", "BITCOIN_100X_ACTIVE_ID", "BITCOIN_ACTIVE_ID", "CFD_ID", "CRYPTO_ID", "DEFAULT_PRECISION", "DIGITAL_ID", "EMPTY", "Lcom/iqoption/core/microservices/tradingengine/response/active/EmptyActive;", "getEMPTY", "()Lcom/iqoption/core/microservices/tradingengine/response/active/EmptyActive;", "EURUSD_ACTIVE_ID", "FOREX_ID", "FX_ID", "OTN_ACTIVE_ID", "TIME_TO_OPEN_NEVER", "", "TURBO_ID", "convertIdToInstrumentType", "Lcom/iqoption/core/data/model/InstrumentType;", "optionTypeId", "convertIdToOptionActiveType", "Lcom/iqoption/core/data/model/ActiveType;", "convertOptionTypeToId", "instrumentType", "core_release"})
    /* compiled from: Active.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final int C(InstrumentType instrumentType) {
            h.e(instrumentType, "instrumentType");
            switch (b.aoS[instrumentType.ordinal()]) {
                case 1:
                    return 3;
                case 2:
                    return 1;
                case 3:
                    return 9;
                case 4:
                    return 11;
                default:
                    return -1;
            }
        }

        public final InstrumentType dP(int i) {
            switch (i) {
                case 1:
                    return InstrumentType.BINARY_INSTRUMENT;
                case 3:
                    return InstrumentType.TURBO_INSTRUMENT;
                case 6:
                    return InstrumentType.CFD_INSTRUMENT;
                case 7:
                    return InstrumentType.FOREX_INSTRUMENT;
                case 9:
                    return InstrumentType.DIGITAL_INSTRUMENT;
                case 10:
                    return InstrumentType.CRYPTO_INSTRUMENT;
                case 11:
                    return InstrumentType.FX_INSTRUMENT;
                default:
                    return null;
            }
        }

        public final ActiveType dQ(int i) {
            if (i == 1) {
                return ActiveType.BINARY_ACTIVE;
            }
            if (i == 3) {
                return ActiveType.TURBO_ACTIVE;
            }
            if (i != 9) {
                return i != 11 ? null : ActiveType.FX_ACTIVE;
            } else {
                return ActiveType.DIGITAL_ACTIVE;
            }
        }
    }

    public static final int C(InstrumentType instrumentType) {
        return aYr.C(instrumentType);
    }

    public static final InstrumentType dP(int i) {
        return aYr.dP(i);
    }

    public static final ActiveType dQ(int i) {
        return aYr.dQ(i);
    }

    public String Xf() {
        return "";
    }

    public abstract String Xg();

    public abstract boolean Xh();

    public abstract Integer Xi();

    public abstract boolean Xj();

    public abstract Integer Xk();

    public abstract boolean ba(long j);

    public abstract long bb(long j);

    public abstract int getActiveId();

    public abstract String getImage();

    public String getInstrumentId() {
        return "";
    }

    public abstract int getPrecision();

    public abstract long getStartTime();

    public abstract boolean isExpired();

    public abstract void r(a aVar);

    public final void b(InstrumentType instrumentType) {
        h.e(instrumentType, "<set-?>");
        this.instrumentType = instrumentType;
    }

    public final InstrumentType getInstrumentType() {
        InstrumentType instrumentType = this.instrumentType;
        if (instrumentType == null) {
            h.lS("instrumentType");
        }
        return instrumentType;
    }

    public ActiveType getActiveType() {
        InstrumentType instrumentType = this.instrumentType;
        if (instrumentType == null) {
            h.lS("instrumentType");
        }
        return instrumentType.toOptionActiveType();
    }
}
