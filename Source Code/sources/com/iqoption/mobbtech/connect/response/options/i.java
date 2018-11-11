package com.iqoption.mobbtech.connect.response.options;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.util.Pools.SynchronizedPool;
import com.google.common.base.f;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Longs;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.core.microservices.tradingengine.response.active.a;
import com.iqoption.mobbtech.connect.response.c;

/* compiled from: OptionKey */
public class i implements Parcelable {
    public static final Creator<i> CREATOR = new Creator<i>() {
        /* renamed from: V */
        public i createFromParcel(Parcel parcel) {
            return new i(parcel);
        }

        /* renamed from: fz */
        public i[] newArray(int i) {
            return new i[i];
        }
    };
    public static Ordering<i> cWM = new Ordering<i>() {
        /* renamed from: a */
        public int compare(i iVar, i iVar2) {
            return Longs.compare(iVar.cWR.longValue(), iVar2.cWR.longValue());
        }
    };
    public static Ordering<i> cWN = new Ordering<i>() {
        /* renamed from: a */
        public int compare(i iVar, i iVar2) {
            return Longs.compare((long) iVar.activeId.intValue(), (long) iVar2.activeId.intValue());
        }
    };
    public static Ordering<i> cWO = new Ordering<i>() {
        /* renamed from: a */
        public int compare(i iVar, i iVar2) {
            return String.CASE_INSENSITIVE_ORDER.compare(iVar.instrumentType.getServerValue(), iVar2.instrumentType.getServerValue());
        }
    };
    public static Ordering<i> cWP = cWM.compound(cWN).compound(cWO).compound(orderingById);
    public static Ordering<i> cWQ = cWM.reverse().compound(cWN.reverse()).compound(cWO).compound(orderingById);
    public static Ordering<i> orderingById = new Ordering<i>() {
        /* renamed from: a */
        public int compare(i iVar, i iVar2) {
            return Longs.compare(iVar.id, iVar2.id);
        }
    };
    private static final SynchronizedPool<i> sPool = new SynchronizedPool(50);
    private Integer activeId;
    private Long cWR;
    private long id;
    private InstrumentType instrumentType;

    public int describeContents() {
        return 0;
    }

    public Long avm() {
        return this.cWR;
    }

    public Integer getActiveId() {
        return this.activeId;
    }

    public InstrumentType getInstrumentType() {
        return this.instrumentType;
    }

    public i(Long l, Integer num, InstrumentType instrumentType) {
        this.cWR = l;
        this.activeId = num;
        this.instrumentType = instrumentType;
        this.id = (long) f.hashCode(l, num, instrumentType);
    }

    public i(Long l, Long l2, Integer num, InstrumentType instrumentType) {
        long hashCode;
        this.cWR = l2;
        this.activeId = num;
        this.instrumentType = instrumentType;
        if (l == null) {
            hashCode = (long) f.hashCode(l2, num, instrumentType);
        } else {
            hashCode = l.longValue();
        }
        this.id = hashCode;
    }

    private i c(Long l, Integer num, InstrumentType instrumentType) {
        this.cWR = l;
        this.activeId = num;
        this.instrumentType = instrumentType;
        this.id = (long) f.hashCode(l, num, instrumentType);
        return this;
    }

    public static i b(c cVar) {
        return a(cVar.activeId, a.dP(cVar.optionTypeId.intValue()), cVar.expTime);
    }

    public static i a(Integer num, InstrumentType instrumentType, Long l) {
        i iVar = (i) sPool.acquire();
        return iVar != null ? iVar.c(l, num, instrumentType) : new i(l, num, instrumentType);
    }

    public void recycle() {
        sPool.release(this);
    }

    /* JADX WARNING: Missing block: B:10:0x002c, code:
            if (com.google.common.base.f.equal(r5.instrumentType, r6.instrumentType) != false) goto L_0x0031;
     */
    public boolean equals(java.lang.Object r6) {
        /*
        r5 = this;
        if (r6 == r5) goto L_0x0031;
    L_0x0002:
        r0 = r6 instanceof com.iqoption.mobbtech.connect.response.options.i;
        if (r0 == 0) goto L_0x002f;
    L_0x0006:
        r0 = r5.id;
        r6 = (com.iqoption.mobbtech.connect.response.options.i) r6;
        r2 = r6.id;
        r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r4 != 0) goto L_0x002f;
    L_0x0010:
        r0 = r5.activeId;
        r1 = r6.activeId;
        r0 = com.google.common.base.f.equal(r0, r1);
        if (r0 == 0) goto L_0x002f;
    L_0x001a:
        r0 = r5.cWR;
        r1 = r6.cWR;
        r0 = com.google.common.base.f.equal(r0, r1);
        if (r0 == 0) goto L_0x002f;
    L_0x0024:
        r0 = r5.instrumentType;
        r6 = r6.instrumentType;
        r6 = com.google.common.base.f.equal(r0, r6);
        if (r6 == 0) goto L_0x002f;
    L_0x002e:
        goto L_0x0031;
    L_0x002f:
        r6 = 0;
        goto L_0x0032;
    L_0x0031:
        r6 = 1;
    L_0x0032:
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.mobbtech.connect.response.options.i.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        return f.hashCode(Long.valueOf(this.id), this.activeId, this.cWR, this.instrumentType);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.cWR);
        parcel.writeValue(this.activeId);
        parcel.writeString(InstrumentType.serverValue(this.instrumentType));
    }

    protected i(Parcel parcel) {
        this.cWR = (Long) parcel.readValue(Long.class.getClassLoader());
        this.activeId = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.instrumentType = InstrumentType.fromServerValueNullable(parcel.readString());
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("OptionKey{expiredTime=");
        stringBuilder.append(this.cWR);
        stringBuilder.append(", activeId=");
        stringBuilder.append(this.activeId);
        stringBuilder.append(", instrumentType='");
        stringBuilder.append(this.instrumentType);
        stringBuilder.append('\'');
        stringBuilder.append(", id=");
        stringBuilder.append(this.id);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
