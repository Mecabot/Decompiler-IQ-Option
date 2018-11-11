package com.iqoption.core.microservices.billing.response.deposit;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 '2\u00020\u0001:\u0001'B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J5\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\u0013\u0010\u001d\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u001cHÖ\u0001J\t\u0010!\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001cHÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000f\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006("}, aXE = {"Lcom/iqoption/core/microservices/billing/response/deposit/Deposit;", "Landroid/os/Parcelable;", "amount", "", "badge", "", "currentBonus", "isCheckedBonus", "", "(DLjava/lang/String;Ljava/lang/String;Z)V", "getAmount", "()D", "setAmount", "(D)V", "getBadge", "()Ljava/lang/String;", "getCurrentBonus", "setCurrentBonus", "(Ljava/lang/String;)V", "()Z", "setCheckedBonus", "(Z)V", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "core_release"})
/* compiled from: Deposit.kt */
public final class d implements Parcelable {
    public static final Creator CREATOR = new b();
    public static final a aTE = new a();
    @SerializedName("amount")
    private double aTA;
    @SerializedName("badge")
    private final String aTB;
    private String aTC;
    private boolean aTD;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, aXE = {"Lcom/iqoption/core/microservices/billing/response/deposit/Deposit$Companion;", "", "()V", "POPULATE_STATUS", "", "VIP_STATUS", "core_release"})
    /* compiled from: Deposit.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    @i(aXC = {1, 1, 11})
    public static class b implements Creator {
        public final Object createFromParcel(Parcel parcel) {
            h.e(parcel, "in");
            return new d(parcel.readDouble(), parcel.readString(), parcel.readString(), parcel.readInt() != 0);
        }

        public final Object[] newArray(int i) {
            return new d[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (Double.compare(this.aTA, dVar.aTA) == 0 && h.E(this.aTB, dVar.aTB) && h.E(this.aTC, dVar.aTC)) {
                if ((this.aTD == dVar.aTD ? 1 : null) != null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.aTA);
        int i = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) * 31;
        String str = this.aTB;
        int i2 = 0;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.aTC;
        if (str != null) {
            i2 = str.hashCode();
        }
        i = (i + i2) * 31;
        int i3 = this.aTD;
        if (i3 != 0) {
            i3 = 1;
        }
        return i + i3;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Deposit(amount=");
        stringBuilder.append(this.aTA);
        stringBuilder.append(", badge=");
        stringBuilder.append(this.aTB);
        stringBuilder.append(", currentBonus=");
        stringBuilder.append(this.aTC);
        stringBuilder.append(", isCheckedBonus=");
        stringBuilder.append(this.aTD);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        h.e(parcel, "parcel");
        parcel.writeDouble(this.aTA);
        parcel.writeString(this.aTB);
        parcel.writeString(this.aTC);
        parcel.writeInt(this.aTD);
    }

    public d(double d, String str, String str2, boolean z) {
        this.aTA = d;
        this.aTB = str;
        this.aTC = str2;
        this.aTD = z;
    }

    public final double UO() {
        return this.aTA;
    }

    public final String UP() {
        return this.aTB;
    }
}
