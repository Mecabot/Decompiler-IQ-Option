package com.iqoption.dto;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J)\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0012HÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u001f"}, aXE = {"Lcom/iqoption/dto/BalanceChanged;", "Landroid/os/Parcelable;", "id", "", "userId", "currentBalance", "Lcom/iqoption/dto/Balance;", "(JJLcom/iqoption/dto/Balance;)V", "getCurrentBalance", "()Lcom/iqoption/dto/Balance;", "getId", "()J", "getUserId", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "IqOption-5.5.1_optionXRelease"})
/* compiled from: BalanceChanged.kt */
public final class BalanceChanged implements Parcelable {
    public static final android.os.Parcelable.Creator CREATOR = new Creator();
    @SerializedName("current_balance")
    private final Balance currentBalance;
    @SerializedName("id")
    private final long id;
    @SerializedName("user_id")
    private final long userId;

    @i(aXC = {1, 1, 11})
    public static class Creator implements android.os.Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            h.e(parcel, "in");
            return new BalanceChanged(parcel.readLong(), parcel.readLong(), parcel.readInt() != 0 ? (Balance) Balance.CREATOR.createFromParcel(parcel) : null);
        }

        public final Object[] newArray(int i) {
            return new BalanceChanged[i];
        }
    }

    public static /* synthetic */ BalanceChanged copy$default(BalanceChanged balanceChanged, long j, long j2, Balance balance, int i, Object obj) {
        if ((i & 1) != 0) {
            j = balanceChanged.id;
        }
        long j3 = j;
        if ((i & 2) != 0) {
            j2 = balanceChanged.userId;
        }
        long j4 = j2;
        if ((i & 4) != 0) {
            balance = balanceChanged.currentBalance;
        }
        return balanceChanged.copy(j3, j4, balance);
    }

    public final long component1() {
        return this.id;
    }

    public final long component2() {
        return this.userId;
    }

    public final Balance component3() {
        return this.currentBalance;
    }

    public final BalanceChanged copy(long j, long j2, Balance balance) {
        return new BalanceChanged(j, j2, balance);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BalanceChanged) {
            BalanceChanged balanceChanged = (BalanceChanged) obj;
            if ((this.id == balanceChanged.id ? 1 : null) != null) {
                return ((this.userId > balanceChanged.userId ? 1 : (this.userId == balanceChanged.userId ? 0 : -1)) == 0 ? 1 : null) != null && h.E(this.currentBalance, balanceChanged.currentBalance);
            }
        }
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        long j2 = this.userId;
        i = (i + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        Balance balance = this.currentBalance;
        return i + (balance != null ? balance.hashCode() : 0);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("BalanceChanged(id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", userId=");
        stringBuilder.append(this.userId);
        stringBuilder.append(", currentBalance=");
        stringBuilder.append(this.currentBalance);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        h.e(parcel, "parcel");
        parcel.writeLong(this.id);
        parcel.writeLong(this.userId);
        Parcelable parcelable = this.currentBalance;
        if (parcelable != null) {
            parcel.writeInt(1);
            parcelable.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }

    public BalanceChanged(long j, long j2, Balance balance) {
        this.id = j;
        this.userId = j2;
        this.currentBalance = balance;
    }

    public final long getId() {
        return this.id;
    }

    public /* synthetic */ BalanceChanged(long j, long j2, Balance balance, int i, f fVar) {
        this((i & 1) != 0 ? 0 : j, (i & 2) != 0 ? 0 : j2, balance);
    }

    public final long getUserId() {
        return this.userId;
    }

    public final Balance getCurrentBalance() {
        return this.currentBalance;
    }
}
