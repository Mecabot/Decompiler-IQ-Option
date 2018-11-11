package com.iqoption.dto;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.common.base.d;
import com.google.common.base.e;
import com.google.common.base.j;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.google.gson.annotations.SerializedName;
import com.iqoption.util.l;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 )2\u00020\u0001:\u0001)B3\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0017J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JF\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010\u001bJ\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u001d\u001a\u00020\u000f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\u0006\u0010 \u001a\u00020\u0007J\u0006\u0010!\u001a\u00020\tJ\t\u0010\"\u001a\u00020\u0005HÖ\u0001J\t\u0010#\u001a\u00020\tHÖ\u0001J\u0019\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u0004\n\u0002\u0010\fR\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u0004\n\u0002\u0010\rR\u0012\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0004\n\u0002\u0010\u0011¨\u0006*"}, aXE = {"Lcom/iqoption/dto/Balance;", "Landroid/os/Parcelable;", "id", "", "type", "", "amount", "", "currency", "", "index", "(Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/String;J)V", "Ljava/lang/Double;", "Ljava/lang/Long;", "isLoadingChange", "", "tournamentName", "Ljava/lang/Integer;", "component1", "()Ljava/lang/Long;", "component2", "()Ljava/lang/Integer;", "component3", "()Ljava/lang/Double;", "component4", "component5", "copy", "(Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/String;J)Lcom/iqoption/dto/Balance;", "describeContents", "equals", "other", "", "getAmountRequired", "getBalanceText", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: Balance.kt */
public final class Balance implements Parcelable {
    public static final android.os.Parcelable.Creator CREATOR = new Creator();
    public static final Companion Companion = new Companion();
    public static final d<Balance, Boolean> filteredCryptoType = Balance$Companion$filteredCryptoType$1.INSTANCE;
    public static final d<Balance, Integer> getBalanceType = Balance$Companion$getBalanceType$1.INSTANCE;
    public static final d<Balance, Double> getBalanceValue = Balance$Companion$getBalanceValue$1.INSTANCE;
    public static final j<Balance> getOtnBalance = Balance$Companion$getOtnBalance$1.INSTANCE;
    @SerializedName("amount")
    public Double amount;
    @SerializedName("currency")
    public String currency;
    @SerializedName("id")
    public Long id;
    @SerializedName("index")
    public long index;
    public boolean isLoadingChange;
    @SerializedName("tournament_name")
    public String tournamentName;
    @SerializedName("type")
    public Integer type;

    @i(aXC = {1, 1, 11}, aXD = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0007J\u0012\u0010\t\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0007J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0007R\u001e\u0010\u0003\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\b0\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\n0\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\f8\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, aXE = {"Lcom/iqoption/dto/Balance$Companion;", "", "()V", "filteredCryptoType", "Lcom/google/common/base/Function;", "Lcom/iqoption/dto/Balance;", "", "getBalanceType", "", "getBalanceValue", "", "getOtnBalance", "Lcom/google/common/base/Predicate;", "balance", "getCurrency", "", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: Balance.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final double getBalanceValue(Balance balance) {
            if (balance == null) {
                return 0.0d;
            }
            Object h = e.h(balance.amount, Double.valueOf(0.0d));
            h.d(h, "MoreObjects.firstNonNull(balance.amount, 0.0)");
            return ((Number) h).doubleValue();
        }

        public final int getBalanceType(Balance balance) {
            if (balance == null) {
                return -1;
            }
            Object h = e.h(balance.type, Integer.valueOf(-1));
            h.d(h, "MoreObjects.firstNonNull(balance.type, -1)");
            return ((Number) h).intValue();
        }

        public final String getCurrency(Balance balance) {
            if (balance == null) {
                return "";
            }
            Object h = e.h(balance.currency, "");
            h.d(h, "MoreObjects.firstNonNull(balance.currency, \"\")");
            return (String) h;
        }
    }

    @i(aXC = {1, 1, 11})
    public static class Creator implements android.os.Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            h.e(parcel, "in");
            return new Balance(parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null, parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null, parcel.readInt() != 0 ? Double.valueOf(parcel.readDouble()) : null, parcel.readString(), parcel.readLong());
        }

        public final Object[] newArray(int i) {
            return new Balance[i];
        }
    }

    public static /* synthetic */ Balance copy$default(Balance balance, Long l, Integer num, Double d, String str, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            l = balance.id;
        }
        if ((i & 2) != 0) {
            num = balance.type;
        }
        Integer num2 = num;
        if ((i & 4) != 0) {
            d = balance.amount;
        }
        Double d2 = d;
        if ((i & 8) != 0) {
            str = balance.currency;
        }
        String str2 = str;
        if ((i & 16) != 0) {
            j = balance.index;
        }
        return balance.copy(l, num2, d2, str2, j);
    }

    public static final int getBalanceType(Balance balance) {
        return Companion.getBalanceType(balance);
    }

    public static final double getBalanceValue(Balance balance) {
        return Companion.getBalanceValue(balance);
    }

    public static final String getCurrency(Balance balance) {
        return Companion.getCurrency(balance);
    }

    public final Long component1() {
        return this.id;
    }

    public final Integer component2() {
        return this.type;
    }

    public final Double component3() {
        return this.amount;
    }

    public final String component4() {
        return this.currency;
    }

    public final long component5() {
        return this.index;
    }

    public final Balance copy(Long l, Integer num, Double d, String str, long j) {
        h.e(str, b.CURRENCY);
        return new Balance(l, num, d, str, j);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Balance) {
            Balance balance = (Balance) obj;
            if (h.E(this.id, balance.id) && h.E(this.type, balance.type) && h.E(this.amount, balance.amount) && h.E(this.currency, balance.currency)) {
                if ((this.index == balance.index ? 1 : null) != null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        Long l = this.id;
        int i = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 31;
        Integer num = this.type;
        hashCode = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        Double d = this.amount;
        hashCode = (hashCode + (d != null ? d.hashCode() : 0)) * 31;
        String str = this.currency;
        if (str != null) {
            i = str.hashCode();
        }
        hashCode = (hashCode + i) * 31;
        long j = this.index;
        return hashCode + ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Balance(id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", type=");
        stringBuilder.append(this.type);
        stringBuilder.append(", amount=");
        stringBuilder.append(this.amount);
        stringBuilder.append(", currency=");
        stringBuilder.append(this.currency);
        stringBuilder.append(", index=");
        stringBuilder.append(this.index);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        h.e(parcel, "parcel");
        Long l = this.id;
        if (l != null) {
            parcel.writeInt(1);
            parcel.writeLong(l.longValue());
        } else {
            parcel.writeInt(0);
        }
        Integer num = this.type;
        if (num != null) {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        } else {
            parcel.writeInt(0);
        }
        Double d = this.amount;
        if (d != null) {
            parcel.writeInt(1);
            parcel.writeDouble(d.doubleValue());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.currency);
        parcel.writeLong(this.index);
    }

    public Balance(Long l, Integer num, Double d, String str, long j) {
        h.e(str, b.CURRENCY);
        this.id = l;
        this.type = num;
        this.amount = d;
        this.currency = str;
        this.index = j;
    }

    public final double getAmountRequired() {
        return Companion.getBalanceValue(this);
    }

    public final String getBalanceText() {
        String t = l.t(Double.valueOf(Companion.getBalanceValue(this)));
        h.d(t, "CurrencyUtils.formatedAm…nt(getBalanceValue(this))");
        return t;
    }
}
