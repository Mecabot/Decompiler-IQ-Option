package com.iqoption.a;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* compiled from: StableIdStore */
public final class t {
    private final Map<String, Long> aih = Maps.us();
    private final Set<Long> aii = Sets.uI();

    public long dU(String str) {
        Long l = (Long) this.aih.get(str);
        if (l != null) {
            return l.longValue();
        }
        long AZ = AZ();
        this.aih.put(str, Long.valueOf(AZ));
        return AZ;
    }

    private long AZ() {
        long leastSignificantBits;
        UUID uuid = null;
        do {
            if (uuid == null) {
                uuid = UUID.randomUUID();
                leastSignificantBits = uuid.getLeastSignificantBits();
            } else {
                leastSignificantBits = uuid.getMostSignificantBits();
                uuid = null;
            }
        } while (!this.aii.add(Long.valueOf(leastSignificantBits)));
        return leastSignificantBits;
    }
}
