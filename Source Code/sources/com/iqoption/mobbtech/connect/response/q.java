package com.iqoption.mobbtech.connect.response;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.NotificationCompat;
import com.google.gson.annotations.SerializedName;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\nHÆ\u0003J=\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u001cHÖ\u0001J\t\u0010\"\u001a\u00020\u0005HÖ\u0001J\u0019\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001cHÖ\u0001R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006("}, aXE = {"Lcom/iqoption/mobbtech/connect/response/VerifyCard;", "Landroid/os/Parcelable;", "id", "", "number", "", "expireDate", "status", "Lcom/iqoption/mobbtech/connect/response/CardStatus;", "declineReason", "Lcom/iqoption/mobbtech/connect/response/DeclineReason;", "(JLjava/lang/String;Ljava/lang/String;Lcom/iqoption/mobbtech/connect/response/CardStatus;Lcom/iqoption/mobbtech/connect/response/DeclineReason;)V", "getDeclineReason", "()Lcom/iqoption/mobbtech/connect/response/DeclineReason;", "getExpireDate", "()Ljava/lang/String;", "getId", "()J", "getNumber", "getStatus", "()Lcom/iqoption/mobbtech/connect/response/CardStatus;", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "IqOption-5.5.1_optionXRelease"})
/* compiled from: VerifyCard.kt */
public final class q implements Parcelable {
    public static final Creator CREATOR = new a();
    @SerializedName("status")
    private final CardStatus cWa;
    @SerializedName("decline_reason")
    private final DeclineReason cWb;
    @SerializedName("expiry_date")
    private final String expireDate;
    @SerializedName("id")
    private final long id;
    @SerializedName("number")
    private final String number;

    @i(aXC = {1, 1, 11})
    public static class a implements Creator {
        public final Object createFromParcel(Parcel parcel) {
            DeclineReason declineReason;
            h.e(parcel, "in");
            long readLong = parcel.readLong();
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            CardStatus cardStatus = (CardStatus) Enum.valueOf(CardStatus.class, parcel.readString());
            if (parcel.readInt() != 0) {
                declineReason = (DeclineReason) Enum.valueOf(DeclineReason.class, parcel.readString());
            } else {
                declineReason = null;
            }
            return new q(readLong, readString, readString2, cardStatus, declineReason);
        }

        public final Object[] newArray(int i) {
            return new q[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof q) {
            q qVar = (q) obj;
            return ((this.id > qVar.id ? 1 : (this.id == qVar.id ? 0 : -1)) == 0 ? 1 : null) != null && h.E(this.number, qVar.number) && h.E(this.expireDate, qVar.expireDate) && h.E(this.cWa, qVar.cWa) && h.E(this.cWb, qVar.cWb);
        }
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.number;
        int i2 = 0;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.expireDate;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        CardStatus cardStatus = this.cWa;
        i = (i + (cardStatus != null ? cardStatus.hashCode() : 0)) * 31;
        DeclineReason declineReason = this.cWb;
        if (declineReason != null) {
            i2 = declineReason.hashCode();
        }
        return i + i2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("VerifyCard(id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", number=");
        stringBuilder.append(this.number);
        stringBuilder.append(", expireDate=");
        stringBuilder.append(this.expireDate);
        stringBuilder.append(", status=");
        stringBuilder.append(this.cWa);
        stringBuilder.append(", declineReason=");
        stringBuilder.append(this.cWb);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        h.e(parcel, "parcel");
        parcel.writeLong(this.id);
        parcel.writeString(this.number);
        parcel.writeString(this.expireDate);
        parcel.writeString(this.cWa.name());
        Enum enumR = this.cWb;
        if (enumR != null) {
            parcel.writeInt(1);
            parcel.writeString(enumR.name());
            return;
        }
        parcel.writeInt(0);
    }

    public q(long j, String str, String str2, CardStatus cardStatus, DeclineReason declineReason) {
        h.e(str, "number");
        h.e(str2, "expireDate");
        h.e(cardStatus, NotificationCompat.CATEGORY_STATUS);
        this.id = j;
        this.number = str;
        this.expireDate = str2;
        this.cWa = cardStatus;
        this.cWb = declineReason;
    }

    public final long getId() {
        return this.id;
    }

    public final String getNumber() {
        return this.number;
    }

    public final String auW() {
        return this.expireDate;
    }

    public final CardStatus auX() {
        return this.cWa;
    }

    public final DeclineReason auY() {
        return this.cWb;
    }
}
