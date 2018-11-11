package com.iqoption.dto.entity.strike;

import com.google.common.base.f;
import com.iqoption.core.data.model.InstrumentType;

public class GroupStrikeKey {
    public final Long expiration;
    public final InstrumentType instrumentType;
    public final boolean isSpot;
    public final Long period;
    public final String underlying;

    public GroupStrikeKey(InstrumentType instrumentType, String str, Long l, Long l2, boolean z) {
        this.instrumentType = instrumentType;
        this.underlying = str;
        this.expiration = l;
        this.period = l2;
        this.isSpot = z;
    }

    /* JADX WARNING: Missing block: B:12:0x0034, code:
            if (com.google.common.base.f.equal(r2.underlying, r3.underlying) != false) goto L_0x0039;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r3 == r2) goto L_0x0039;
    L_0x0002:
        r0 = r3 instanceof com.iqoption.dto.entity.strike.GroupStrikeKey;
        if (r0 == 0) goto L_0x0037;
    L_0x0006:
        r0 = r2.isSpot;
        r3 = (com.iqoption.dto.entity.strike.GroupStrikeKey) r3;
        r1 = r3.isSpot;
        if (r0 != r1) goto L_0x0037;
    L_0x000e:
        r0 = r2.period;
        r1 = r3.period;
        r0 = com.google.common.base.f.equal(r0, r1);
        if (r0 == 0) goto L_0x0037;
    L_0x0018:
        r0 = r2.instrumentType;
        r1 = r3.instrumentType;
        r0 = com.google.common.base.f.equal(r0, r1);
        if (r0 == 0) goto L_0x0037;
    L_0x0022:
        r0 = r2.expiration;
        r1 = r3.expiration;
        r0 = com.google.common.base.f.equal(r0, r1);
        if (r0 == 0) goto L_0x0037;
    L_0x002c:
        r0 = r2.underlying;
        r3 = r3.underlying;
        r3 = com.google.common.base.f.equal(r0, r3);
        if (r3 == 0) goto L_0x0037;
    L_0x0036:
        goto L_0x0039;
    L_0x0037:
        r3 = 0;
        goto L_0x003a;
    L_0x0039:
        r3 = 1;
    L_0x003a:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.dto.entity.strike.GroupStrikeKey.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        return f.hashCode(this.instrumentType, this.underlying, this.expiration, this.period);
    }
}
