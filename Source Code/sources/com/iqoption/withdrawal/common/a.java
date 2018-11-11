package com.iqoption.withdrawal.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.measurement.AppMeasurement.Param;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0014HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006!"}, aXE = {"Lcom/iqoption/withdrawal/common/AmountLimit;", "Landroid/os/Parcelable;", "value", "", "type", "Lcom/iqoption/withdrawal/common/LimitType;", "direction", "Lcom/iqoption/withdrawal/common/LimitDirection;", "(DLcom/iqoption/withdrawal/common/LimitType;Lcom/iqoption/withdrawal/common/LimitDirection;)V", "getDirection", "()Lcom/iqoption/withdrawal/common/LimitDirection;", "getType", "()Lcom/iqoption/withdrawal/common/LimitType;", "getValue", "()D", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "IqOption-5.5.1_optionXRelease"})
/* compiled from: AmountLimits.kt */
public final class a implements Parcelable {
    public static final Creator CREATOR = new a();
    private final LimitType dPJ;
    private final LimitDirection dPK;
    private final double value;

    @i(aXC = {1, 1, 11})
    public static class a implements Creator {
        public final Object createFromParcel(Parcel parcel) {
            h.e(parcel, "in");
            return new a(parcel.readDouble(), (LimitType) Enum.valueOf(LimitType.class, parcel.readString()), (LimitDirection) Enum.valueOf(LimitDirection.class, parcel.readString()));
        }

        public final Object[] newArray(int i) {
            return new a[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    /* JADX WARNING: Missing block: B:8:0x0024, code:
            if (kotlin.jvm.internal.h.E(r4.dPK, r5.dPK) != false) goto L_0x0029;
     */
    public boolean equals(java.lang.Object r5) {
        /*
        r4 = this;
        if (r4 == r5) goto L_0x0029;
    L_0x0002:
        r0 = r5 instanceof com.iqoption.withdrawal.common.a;
        if (r0 == 0) goto L_0x0027;
    L_0x0006:
        r5 = (com.iqoption.withdrawal.common.a) r5;
        r0 = r4.value;
        r2 = r5.value;
        r0 = java.lang.Double.compare(r0, r2);
        if (r0 != 0) goto L_0x0027;
    L_0x0012:
        r0 = r4.dPJ;
        r1 = r5.dPJ;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x0027;
    L_0x001c:
        r0 = r4.dPK;
        r5 = r5.dPK;
        r5 = kotlin.jvm.internal.h.E(r0, r5);
        if (r5 == 0) goto L_0x0027;
    L_0x0026:
        goto L_0x0029;
    L_0x0027:
        r5 = 0;
        return r5;
    L_0x0029:
        r5 = 1;
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.withdrawal.common.a.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.value);
        int i = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) * 31;
        LimitType limitType = this.dPJ;
        int i2 = 0;
        i = (i + (limitType != null ? limitType.hashCode() : 0)) * 31;
        LimitDirection limitDirection = this.dPK;
        if (limitDirection != null) {
            i2 = limitDirection.hashCode();
        }
        return i + i2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AmountLimit(value=");
        stringBuilder.append(this.value);
        stringBuilder.append(", type=");
        stringBuilder.append(this.dPJ);
        stringBuilder.append(", direction=");
        stringBuilder.append(this.dPK);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        h.e(parcel, "parcel");
        parcel.writeDouble(this.value);
        parcel.writeString(this.dPJ.name());
        parcel.writeString(this.dPK.name());
    }

    public a(double d, LimitType limitType, LimitDirection limitDirection) {
        h.e(limitType, Param.TYPE);
        h.e(limitDirection, "direction");
        this.value = d;
        this.dPJ = limitType;
        this.dPK = limitDirection;
    }

    public final double getValue() {
        return this.value;
    }

    public final LimitType aMQ() {
        return this.dPJ;
    }

    public final LimitDirection aMR() {
        return this.dPK;
    }
}
