package com.iqoption.core.microservices.risks.response.overnightfee;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0014HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0014HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006 "}, aXE = {"Lcom/iqoption/core/microservices/risks/response/overnightfee/FeeData;", "Landroid/os/Parcelable;", "time", "", "long", "", "short", "(Ljava/lang/String;DD)V", "getLong", "()D", "getShort", "getTime", "()Ljava/lang/String;", "setTime", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "core_release"})
/* compiled from: FeeData.kt */
public final class b implements Parcelable {
    public static final Creator CREATOR = new a();
    @SerializedName("time")
    private String aXE;
    @SerializedName("long")
    private final double aXF;
    @SerializedName("short")
    private final double aXG;

    @i(aXC = {1, 1, 11})
    public static class a implements Creator {
        public final Object createFromParcel(Parcel parcel) {
            h.e(parcel, "in");
            return new b(parcel.readString(), parcel.readDouble(), parcel.readDouble());
        }

        public final Object[] newArray(int i) {
            return new b[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    /* JADX WARNING: Missing block: B:8:0x0024, code:
            if (java.lang.Double.compare(r4.aXG, r5.aXG) == 0) goto L_0x0029;
     */
    public boolean equals(java.lang.Object r5) {
        /*
        r4 = this;
        if (r4 == r5) goto L_0x0029;
    L_0x0002:
        r0 = r5 instanceof com.iqoption.core.microservices.risks.response.overnightfee.b;
        if (r0 == 0) goto L_0x0027;
    L_0x0006:
        r5 = (com.iqoption.core.microservices.risks.response.overnightfee.b) r5;
        r0 = r4.aXE;
        r1 = r5.aXE;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x0027;
    L_0x0012:
        r0 = r4.aXF;
        r2 = r5.aXF;
        r0 = java.lang.Double.compare(r0, r2);
        if (r0 != 0) goto L_0x0027;
    L_0x001c:
        r0 = r4.aXG;
        r2 = r5.aXG;
        r5 = java.lang.Double.compare(r0, r2);
        if (r5 != 0) goto L_0x0027;
    L_0x0026:
        goto L_0x0029;
    L_0x0027:
        r5 = 0;
        return r5;
    L_0x0029:
        r5 = 1;
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.core.microservices.risks.response.overnightfee.b.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.aXE;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        long doubleToLongBits = Double.doubleToLongBits(this.aXF);
        hashCode = (hashCode + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31;
        doubleToLongBits = Double.doubleToLongBits(this.aXG);
        return hashCode + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("FeeData(time=");
        stringBuilder.append(this.aXE);
        stringBuilder.append(", long=");
        stringBuilder.append(this.aXF);
        stringBuilder.append(", short=");
        stringBuilder.append(this.aXG);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        h.e(parcel, "parcel");
        parcel.writeString(this.aXE);
        parcel.writeDouble(this.aXF);
        parcel.writeDouble(this.aXG);
    }

    public b(String str, double d, double d2) {
        h.e(str, "time");
        this.aXE = str;
        this.aXF = d;
        this.aXG = d2;
    }

    public final String getTime() {
        return this.aXE;
    }

    public final void setTime(String str) {
        h.e(str, "<set-?>");
        this.aXE = str;
    }

    public final double WJ() {
        return this.aXF;
    }

    public final double WK() {
        return this.aXG;
    }
}
