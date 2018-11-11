package com.iqoption.dto.entity.iqbus;

import android.support.annotation.Nullable;
import com.google.common.base.d;
import com.google.common.base.f;
import com.google.common.base.j;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Longs;
import com.google.gson.annotations.SerializedName;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.core.i;
import com.iqoption.core.microservices.tradingengine.response.active.a;
import com.iqoption.fragment.b.b;
import com.iqoption.system.a.c;
import com.iqoption.util.ah;

@Deprecated
public class SignalLegacy {
    public static final int MAX_TURBO_DURATION_SEC = 600;
    public static final Ordering<SignalLegacy> ORDERING_BY_TIME_CREATED = new Ordering<SignalLegacy>() {
        public int compare(SignalLegacy signalLegacy, SignalLegacy signalLegacy2) {
            return Longs.compare(signalLegacy.created.longValue(), signalLegacy2.created.longValue());
        }
    };
    private static final String TAG = "com.iqoption.dto.entity.iqbus.SignalLegacy";
    public static final d<SignalLegacy, Long> getId = new d<SignalLegacy, Long>() {
        public Long apply(SignalLegacy signalLegacy) {
            return signalLegacy.id;
        }
    };
    public static final j<SignalLegacy> isAvailable = new j<SignalLegacy>() {
        public boolean apply(SignalLegacy signalLegacy) {
            return signalLegacy.isActiveAvailable();
        }
    };
    public static final j<SignalLegacy> isFound = new j<SignalLegacy>() {
        public boolean apply(SignalLegacy signalLegacy) {
            return signalLegacy.isActiveFound();
        }
    };
    public static final j<SignalLegacy> isMaxMin = new j<SignalLegacy>() {
        public boolean apply(SignalLegacy signalLegacy) {
            return signalLegacy.isMaxMin();
        }
    };
    @SerializedName("active_id")
    public Integer active_id;
    @SerializedName("created")
    public Long created;
    @SerializedName("finish_time")
    public Long finish_time;
    @SerializedName("finish_value")
    public Long finish_value;
    @SerializedName("id")
    public Long id;
    @SerializedName("level")
    public Integer level;
    @Nullable
    @SerializedName("option_type_id")
    public Integer option_type_id;
    @SerializedName("start_time")
    public Long start_time;
    @SerializedName("start_value")
    public Long start_value;
    @SerializedName("subtype")
    public Integer subType;
    @SerializedName("type")
    public Integer type;

    public static class SignalCreatedEvent extends c<SignalLegacy> {
    }

    public static class SignalsEvent extends c<SignalLegacy[]> {
    }

    @Nullable
    public static SignalLegacy fromJson(String str) {
        try {
            return (SignalLegacy) ah.aGg().fromJson(str, SignalLegacy.class);
        } catch (Throwable e) {
            String str2 = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("unable to create signal from json string ");
            stringBuilder.append(str);
            i.e(str2, stringBuilder.toString(), e);
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SignalLegacy)) {
            return false;
        }
        return f.equal(this.id, ((SignalLegacy) obj).id);
    }

    public int hashCode() {
        return f.hashCode(this.id);
    }

    @Nullable
    public InstrumentType getOptionType() {
        Object obj;
        Object obj2 = null;
        if (this.option_type_id != null) {
            a a = com.iqoption.app.helpers.a.FI().a(this.active_id, a.dP(this.option_type_id.intValue()));
            Object obj3 = this.option_type_id.intValue() == 3 ? 1 : null;
            if (this.option_type_id.intValue() == 1) {
                obj2 = 1;
            }
            if (a != null) {
                return a.dP(this.option_type_id.intValue());
            }
            obj = obj2;
            obj2 = obj3;
        } else {
            obj = null;
        }
        InstrumentType instrumentType = this.finish_time.longValue() - this.start_time.longValue() <= 600 ? InstrumentType.TURBO_INSTRUMENT : InstrumentType.BINARY_INSTRUMENT;
        if (((obj2 == null && InstrumentType.TURBO_INSTRUMENT == instrumentType) || (obj == null && InstrumentType.BINARY_INSTRUMENT == instrumentType)) && com.iqoption.app.helpers.a.FI().a(this.active_id, instrumentType) != null) {
            return instrumentType;
        }
        if (obj2 == null && com.iqoption.app.helpers.a.FI().a(this.active_id, InstrumentType.TURBO_INSTRUMENT) != null) {
            return InstrumentType.TURBO_INSTRUMENT;
        }
        if (obj == null && com.iqoption.app.helpers.a.FI().a(this.active_id, InstrumentType.BINARY_INSTRUMENT) != null) {
            return InstrumentType.BINARY_INSTRUMENT;
        }
        if (com.iqoption.app.helpers.a.FI().a(this.active_id, InstrumentType.DIGITAL_INSTRUMENT) != null) {
            return InstrumentType.DIGITAL_INSTRUMENT;
        }
        if (com.iqoption.app.helpers.a.FI().a(this.active_id, InstrumentType.CFD_INSTRUMENT) != null) {
            return InstrumentType.CFD_INSTRUMENT;
        }
        if (com.iqoption.app.helpers.a.FI().a(this.active_id, InstrumentType.FOREX_INSTRUMENT) != null) {
            return InstrumentType.FOREX_INSTRUMENT;
        }
        return com.iqoption.app.helpers.a.FI().a(this.active_id, InstrumentType.CRYPTO_INSTRUMENT) != null ? InstrumentType.CRYPTO_INSTRUMENT : null;
    }

    public boolean isActiveAvailable() {
        a a = com.iqoption.app.helpers.a.FI().a(this.active_id, getOptionType());
        return a != null && com.iqoption.util.e.a.G(a);
    }

    public boolean isMaxMin() {
        return this.type != null && b.cHQ.contains(this.type);
    }

    private boolean isActiveFound() {
        return com.iqoption.app.helpers.a.FI().a(this.active_id, getOptionType()) != null;
    }
}
