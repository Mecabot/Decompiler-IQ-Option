package com.iqoption.dto.entity.result;

import com.google.common.collect.Sets;
import com.google.gson.annotations.SerializedName;
import com.iqoption.app.managers.feature.b;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.core.util.i;
import com.iqoption.dto.entity.Feature;
import com.iqoption.dto.entity.expiration.Expiration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class ExpirationsResult {
    private static final long MAX_SHORT_EXPIRATION = 3600;
    @SerializedName("expiration")
    public ArrayList<DigitalExpiration> expirations;
    @SerializedName("type")
    public InstrumentType type;
    @SerializedName("underlying")
    public String underlying;

    public static class DigitalExpiration {
        @SerializedName("dead_time")
        public long deadTime;
        @SerializedName("period")
        public long period;
        @SerializedName("time")
        public long time;

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("DigitalExpiration{time=");
            stringBuilder.append(this.time);
            stringBuilder.append(", period=");
            stringBuilder.append(this.period);
            stringBuilder.append(", deadTime=");
            stringBuilder.append(this.deadTime);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ExpirationsResult{type=");
        stringBuilder.append(this.type);
        stringBuilder.append(", underlying='");
        stringBuilder.append(this.underlying);
        stringBuilder.append('\'');
        stringBuilder.append(", expirations=");
        stringBuilder.append(this.expirations);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public Set<Expiration> getExpirations() {
        Set<Expiration> uI = Sets.uI();
        if (this.expirations != null) {
            Feature fd = b.HT().fd("trim-option-expirations");
            if (fd == null || InstrumentType.FX_INSTRUMENT != this.type) {
                fd = Feature.createDisabledFeature();
            }
            Iterator it = this.expirations.iterator();
            while (it.hasNext()) {
                DigitalExpiration digitalExpiration = (DigitalExpiration) it.next();
                String str = fd.status;
                Object obj = -1;
                int hashCode = str.hashCode();
                if (hashCode != -530335417) {
                    if (hashCode == 745728785 && str.equals("trim-short")) {
                        obj = 1;
                    }
                } else if (str.equals("trim-long")) {
                    obj = null;
                }
                switch (obj) {
                    case null:
                        if (digitalExpiration.period >= i.a(fd.params, (long) MAX_SHORT_EXPIRATION)) {
                            break;
                        }
                        uI.add(new Expiration(digitalExpiration.time, digitalExpiration.period * 1000, digitalExpiration.deadTime * 1000));
                        break;
                    case 1:
                        if (digitalExpiration.period < i.a(fd.params, (long) MAX_SHORT_EXPIRATION)) {
                            break;
                        }
                        uI.add(new Expiration(digitalExpiration.time, digitalExpiration.period * 1000, digitalExpiration.deadTime * 1000));
                        break;
                    default:
                        uI.add(new Expiration(digitalExpiration.time, digitalExpiration.period * 1000, digitalExpiration.deadTime * 1000));
                        break;
                }
            }
        }
        return uI;
    }
}
