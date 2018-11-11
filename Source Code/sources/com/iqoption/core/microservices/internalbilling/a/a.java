package com.iqoption.core.microservices.internalbilling.a;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;
import java.math.BigDecimal;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 92\u00020\u0001:\u00019Bs\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\b\b\u0002\u0010\f\u001a\u00020\b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\t\u0010$\u001a\u00020\u0011HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\bHÆ\u0003J\t\u0010(\u001a\u00020\bHÆ\u0003J\t\u0010)\u001a\u00020\bHÆ\u0003J\t\u0010*\u001a\u00020\bHÆ\u0003J\t\u0010+\u001a\u00020\bHÆ\u0003J\t\u0010,\u001a\u00020\u000eHÆ\u0003Jy\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u0011HÆ\u0001J\t\u0010.\u001a\u00020\u0005HÖ\u0001J\u0013\u0010/\u001a\u00020\u00112\b\u00100\u001a\u0004\u0018\u000101HÖ\u0003J\t\u00102\u001a\u00020\u0005HÖ\u0001J\t\u00103\u001a\u00020\u000eHÖ\u0001J\u0019\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\r\u001a\u00020\u000e8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\t\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0016\u0010\n\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0016\u0010\u000b\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0010\u001a\u00020\u00118\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u001cR\u0016\u0010\f\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 ¨\u0006:"}, aXE = {"Lcom/iqoption/core/microservices/internalbilling/response/Balance;", "Landroid/os/Parcelable;", "id", "", "userId", "", "type", "amount", "Ljava/math/BigDecimal;", "enrolledAmount", "enrolledSumAmount", "holdAmount", "ordersAmount", "currency", "", "tournamentName", "isFiat", "", "(JIILjava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/lang/String;Ljava/lang/String;Z)V", "getAmount", "()Ljava/math/BigDecimal;", "getCurrency", "()Ljava/lang/String;", "getEnrolledAmount", "getEnrolledSumAmount", "getHoldAmount", "getId", "()J", "()Z", "getOrdersAmount", "getTournamentName", "getType", "()I", "getUserId", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "core_release"})
/* compiled from: Balance.kt */
public final class a implements Parcelable {
    public static final Creator CREATOR = new b();
    public static final a aWt = new a();
    @SerializedName("user_id")
    private final int aWm;
    @SerializedName("amount")
    private final BigDecimal aWn;
    @SerializedName("enrolled_amount")
    private final BigDecimal aWo;
    @SerializedName("enrolled_sum_amount")
    private final BigDecimal aWp;
    @SerializedName("hold_amount")
    private final BigDecimal aWq;
    @SerializedName("orders_amount")
    private final BigDecimal aWr;
    @SerializedName("is_fiat")
    private final boolean aWs;
    @SerializedName("currency")
    private final String currency;
    @SerializedName("id")
    private final long id;
    @SerializedName("tournament_name")
    private final String tournamentName;
    @SerializedName("type")
    private final int type;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, aXE = {"Lcom/iqoption/core/microservices/internalbilling/response/Balance$Companion;", "", "()V", "TYPE_CRYPTO", "", "TYPE_MAIN", "TYPE_PRACTICE", "TYPE_TOURNAMENT", "TYPE_UNKNOWN", "core_release"})
    /* compiled from: Balance.kt */
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
            return new a(parcel.readLong(), parcel.readInt(), parcel.readInt(), (BigDecimal) parcel.readSerializable(), (BigDecimal) parcel.readSerializable(), (BigDecimal) parcel.readSerializable(), (BigDecimal) parcel.readSerializable(), (BigDecimal) parcel.readSerializable(), parcel.readString(), parcel.readString(), parcel.readInt() != 0);
        }

        public final Object[] newArray(int i) {
            return new a[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            if ((this.id == aVar.id ? 1 : null) != null) {
                if ((this.aWm == aVar.aWm ? 1 : null) != null) {
                    if ((this.type == aVar.type ? 1 : null) != null && h.E(this.aWn, aVar.aWn) && h.E(this.aWo, aVar.aWo) && h.E(this.aWp, aVar.aWp) && h.E(this.aWq, aVar.aWq) && h.E(this.aWr, aVar.aWr) && h.E(this.currency, aVar.currency) && h.E(this.tournamentName, aVar.tournamentName)) {
                        if ((this.aWs == aVar.aWs ? 1 : null) != null) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        long j = this.id;
        int i = ((((((int) (j ^ (j >>> 32))) * 31) + this.aWm) * 31) + this.type) * 31;
        BigDecimal bigDecimal = this.aWn;
        int i2 = 0;
        i = (i + (bigDecimal != null ? bigDecimal.hashCode() : 0)) * 31;
        bigDecimal = this.aWo;
        i = (i + (bigDecimal != null ? bigDecimal.hashCode() : 0)) * 31;
        bigDecimal = this.aWp;
        i = (i + (bigDecimal != null ? bigDecimal.hashCode() : 0)) * 31;
        bigDecimal = this.aWq;
        i = (i + (bigDecimal != null ? bigDecimal.hashCode() : 0)) * 31;
        bigDecimal = this.aWr;
        i = (i + (bigDecimal != null ? bigDecimal.hashCode() : 0)) * 31;
        String str = this.currency;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.tournamentName;
        if (str != null) {
            i2 = str.hashCode();
        }
        i = (i + i2) * 31;
        int i3 = this.aWs;
        if (i3 != 0) {
            i3 = 1;
        }
        return i + i3;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Balance(id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", userId=");
        stringBuilder.append(this.aWm);
        stringBuilder.append(", type=");
        stringBuilder.append(this.type);
        stringBuilder.append(", amount=");
        stringBuilder.append(this.aWn);
        stringBuilder.append(", enrolledAmount=");
        stringBuilder.append(this.aWo);
        stringBuilder.append(", enrolledSumAmount=");
        stringBuilder.append(this.aWp);
        stringBuilder.append(", holdAmount=");
        stringBuilder.append(this.aWq);
        stringBuilder.append(", ordersAmount=");
        stringBuilder.append(this.aWr);
        stringBuilder.append(", currency=");
        stringBuilder.append(this.currency);
        stringBuilder.append(", tournamentName=");
        stringBuilder.append(this.tournamentName);
        stringBuilder.append(", isFiat=");
        stringBuilder.append(this.aWs);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        h.e(parcel, "parcel");
        parcel.writeLong(this.id);
        parcel.writeInt(this.aWm);
        parcel.writeInt(this.type);
        parcel.writeSerializable(this.aWn);
        parcel.writeSerializable(this.aWo);
        parcel.writeSerializable(this.aWp);
        parcel.writeSerializable(this.aWq);
        parcel.writeSerializable(this.aWr);
        parcel.writeString(this.currency);
        parcel.writeString(this.tournamentName);
        parcel.writeInt(this.aWs);
    }

    public a(long j, int i, int i2, BigDecimal bigDecimal, BigDecimal bigDecimal2, BigDecimal bigDecimal3, BigDecimal bigDecimal4, BigDecimal bigDecimal5, String str, String str2, boolean z) {
        h.e(bigDecimal, "amount");
        h.e(bigDecimal2, "enrolledAmount");
        h.e(bigDecimal3, "enrolledSumAmount");
        h.e(bigDecimal4, "holdAmount");
        h.e(bigDecimal5, "ordersAmount");
        h.e(str, com.google.firebase.analytics.FirebaseAnalytics.b.CURRENCY);
        this.id = j;
        this.aWm = i;
        this.type = i2;
        this.aWn = bigDecimal;
        this.aWo = bigDecimal2;
        this.aWp = bigDecimal3;
        this.aWq = bigDecimal4;
        this.aWr = bigDecimal5;
        this.currency = str;
        this.tournamentName = str2;
        this.aWs = z;
    }

    public final long getId() {
        return this.id;
    }

    public final int getType() {
        return this.type;
    }

    public final BigDecimal VZ() {
        return this.aWn;
    }

    public final String getCurrency() {
        return this.currency;
    }
}
