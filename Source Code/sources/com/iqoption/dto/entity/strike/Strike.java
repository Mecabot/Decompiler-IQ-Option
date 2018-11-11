package com.iqoption.dto.entity.strike;

import com.google.common.base.f;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Longs;
import com.google.gson.annotations.SerializedName;
import com.iqoption.core.data.model.InstrumentType;

public class Strike {
    public static final Ordering<Strike> ORDERING = new Ordering<Strike>() {
        public int compare(Strike strike, Strike strike2) {
            return Longs.compare(strike.value, strike2.value);
        }
    };
    @SerializedName("call")
    public Value call;
    public transient long expiration;
    public transient boolean isSpot;
    private volatile transient double lastSpotValue;
    public transient InstrumentType optionType;
    public transient long period;
    @SerializedName("put")
    public Value put;
    private volatile transient String strikeKey = null;
    public transient String underlying;
    @SerializedName("value")
    private final long value = 0;

    public static class Value {
        @SerializedName("cfi")
        public String cfi;
        @SerializedName("currency")
        public String currency;
        @SerializedName("id")
        public String id;
        @SerializedName("is_enabled")
        public Boolean isEnabled;
        @SerializedName("min_count")
        public Double minCount;
        @SerializedName("multiplier")
        public Integer multiplier;
        @SerializedName("period")
        public Long period = Long.valueOf(0);

        public int hashCode() {
            return f.hashCode(this.id);
        }

        public boolean equals(Object obj) {
            return obj == this || ((obj instanceof Value) && f.equal(this.id, ((Value) obj).id));
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Value{id='");
            stringBuilder.append(this.id);
            stringBuilder.append('\'');
            stringBuilder.append(", multiplier=");
            stringBuilder.append(this.multiplier);
            stringBuilder.append(", minCount=");
            stringBuilder.append(this.minCount);
            stringBuilder.append(", currency='");
            stringBuilder.append(this.currency);
            stringBuilder.append('\'');
            stringBuilder.append(", cfi='");
            stringBuilder.append(this.cfi);
            stringBuilder.append('\'');
            stringBuilder.append(", isEnabled=");
            stringBuilder.append(this.isEnabled);
            stringBuilder.append(", period=");
            stringBuilder.append(this.period);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    private Strike() {
    }

    public String getStrikeKey() {
        if (this.strikeKey == null) {
            synchronized (this) {
                if (this.strikeKey == null) {
                    this.strikeKey = createStrikeKey(this.optionType, this.underlying, this.expiration, this.value, this.period, this.isSpot);
                }
            }
        }
        return this.strikeKey;
    }

    public static String createStrikeKey(InstrumentType instrumentType, String str, long j, long j2, long j3, boolean z) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(instrumentType.toString());
        stringBuilder.append(str);
        stringBuilder.append(j);
        stringBuilder.append("_");
        stringBuilder.append(j2);
        stringBuilder.append("_");
        stringBuilder.append(j3);
        stringBuilder.append(z ? "_SPT" : "");
        return stringBuilder.toString();
    }

    public int hashCode() {
        return f.hashCode(Long.valueOf(this.value), this.call, this.put);
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Strike strike = (Strike) obj;
        if (this.value != strike.value) {
            return false;
        }
        if (!this.call == null ? this.call.equals(strike.call) : strike.call == null) {
            return false;
        }
        if (this.put != null) {
            z = this.put.equals(strike.put);
        } else if (strike.put != null) {
            z = false;
        }
        return z;
    }

    public long getStableId() {
        return (long) Longs.hashCode(this.value);
    }

    public Double getValue() {
        return Double.valueOf(((double) this.value) / 1000000.0d);
    }

    public Double getLastSpotValue() {
        return Double.valueOf(this.lastSpotValue);
    }

    public void setLastSpotValue(double d) {
        this.lastSpotValue = d;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Strike{value=");
        stringBuilder.append(this.value);
        stringBuilder.append(", call=");
        stringBuilder.append(this.call);
        stringBuilder.append(", put=");
        stringBuilder.append(this.put);
        stringBuilder.append(", optionType=");
        stringBuilder.append(this.optionType);
        stringBuilder.append(", underlying='");
        stringBuilder.append(this.underlying);
        stringBuilder.append('\'');
        stringBuilder.append(", expiration=");
        stringBuilder.append(this.expiration);
        stringBuilder.append(", period=");
        stringBuilder.append(this.period);
        stringBuilder.append(", isSpot=");
        stringBuilder.append(this.isSpot);
        stringBuilder.append(", lastSpotValue=");
        stringBuilder.append(this.lastSpotValue);
        stringBuilder.append(", strikeKey='");
        stringBuilder.append(this.strikeKey);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
