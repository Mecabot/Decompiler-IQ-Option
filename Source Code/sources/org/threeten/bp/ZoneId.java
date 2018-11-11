package org.threeten.bp;

import java.io.DataOutput;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.threeten.bp.temporal.b;
import org.threeten.bp.temporal.f;
import org.threeten.bp.temporal.g;
import org.threeten.bp.zone.ZoneRules;
import org.threeten.bp.zone.ZoneRulesException;

public abstract class ZoneId implements Serializable {
    public static final g<ZoneId> FROM = new g<ZoneId>() {
        /* renamed from: w */
        public ZoneId b(b bVar) {
            return ZoneId.v(bVar);
        }
    };
    public static final Map<String, String> SHORT_IDS;
    private static final long serialVersionUID = 8352817235686L;

    public abstract ZoneRules bCz();

    public abstract String getId();

    abstract void write(DataOutput dataOutput);

    static {
        Map hashMap = new HashMap();
        hashMap.put("ACT", "Australia/Darwin");
        hashMap.put("AET", "Australia/Sydney");
        hashMap.put("AGT", "America/Argentina/Buenos_Aires");
        hashMap.put("ART", "Africa/Cairo");
        hashMap.put("AST", "America/Anchorage");
        hashMap.put("BET", "America/Sao_Paulo");
        hashMap.put("BST", "Asia/Dhaka");
        hashMap.put("CAT", "Africa/Harare");
        hashMap.put("CNT", "America/St_Johns");
        hashMap.put("CST", "America/Chicago");
        hashMap.put("CTT", "Asia/Shanghai");
        hashMap.put("EAT", "Africa/Addis_Ababa");
        hashMap.put("ECT", "Europe/Paris");
        hashMap.put("IET", "America/Indiana/Indianapolis");
        hashMap.put("IST", "Asia/Kolkata");
        hashMap.put("JST", "Asia/Tokyo");
        hashMap.put("MIT", "Pacific/Apia");
        hashMap.put("NET", "Asia/Yerevan");
        hashMap.put("NST", "Pacific/Auckland");
        hashMap.put("PLT", "Asia/Karachi");
        hashMap.put("PNT", "America/Phoenix");
        hashMap.put("PRT", "America/Puerto_Rico");
        hashMap.put("PST", "America/Los_Angeles");
        hashMap.put("SST", "Pacific/Guadalcanal");
        hashMap.put("VST", "Asia/Ho_Chi_Minh");
        hashMap.put("EST", "-05:00");
        hashMap.put("MST", "-07:00");
        hashMap.put("HST", "-10:00");
        SHORT_IDS = Collections.unmodifiableMap(hashMap);
    }

    public static ZoneId v(b bVar) {
        ZoneId zoneId = (ZoneId) bVar.query(f.bDt());
        if (zoneId != null) {
            return zoneId;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unable to obtain ZoneId from TemporalAccessor: ");
        stringBuilder.append(bVar);
        stringBuilder.append(", type ");
        stringBuilder.append(bVar.getClass().getName());
        throw new DateTimeException(stringBuilder.toString());
    }

    ZoneId() {
        if (getClass() != ZoneOffset.class && getClass() != ZoneRegion.class) {
            throw new AssertionError("Invalid subclass");
        }
    }

    public ZoneId bCA() {
        try {
            ZoneRules bCz = bCz();
            if (bCz.isFixedOffset()) {
                return bCz.d(Instant.fdB);
            }
        } catch (ZoneRulesException unused) {
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ZoneId)) {
            return false;
        }
        return getId().equals(((ZoneId) obj).getId());
    }

    public int hashCode() {
        return getId().hashCode();
    }

    public String toString() {
        return getId();
    }
}
