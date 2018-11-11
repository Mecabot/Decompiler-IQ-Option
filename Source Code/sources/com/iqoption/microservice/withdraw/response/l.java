package com.iqoption.microservice.withdraw.response;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.NotificationCompat;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.math.BigDecimal;
import java.util.Date;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0006HÆ\u0003J\t\u0010*\u001a\u00020\bHÆ\u0003J\t\u0010+\u001a\u00020\nHÆ\u0003J\t\u0010,\u001a\u00020\fHÆ\u0003J\t\u0010-\u001a\u00020\fHÆ\u0003J\t\u0010.\u001a\u00020\nHÆ\u0003J\t\u0010/\u001a\u00020\nHÆ\u0003J{\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\n2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÆ\u0001J\t\u00101\u001a\u000202HÖ\u0001J\u0013\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u000106HÖ\u0003J\t\u00107\u001a\u000202HÖ\u0001J\t\u00108\u001a\u00020\nHÖ\u0001J\u0019\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u000202HÖ\u0001R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u000f\u001a\u00020\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\t\u001a\u00020\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001eR\u0016\u0010\u000e\u001a\u00020\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001bR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0016\u0010\r\u001a\u00020\f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0019¨\u0006>"}, aXE = {"Lcom/iqoption/microservice/withdraw/response/WithdrawPayout;", "Landroid/os/Parcelable;", "id", "", "operationId", "status", "Lcom/iqoption/microservice/withdraw/response/Status;", "amount", "Ljava/math/BigDecimal;", "currency", "", "createdAt", "Ljava/util/Date;", "updatedAt", "paymentMethod", "cssName", "message", "card", "Lcom/iqoption/microservice/withdraw/response/PayoutCard;", "(JJLcom/iqoption/microservice/withdraw/response/Status;Ljava/math/BigDecimal;Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/iqoption/microservice/withdraw/response/PayoutCard;)V", "getAmount", "()Ljava/math/BigDecimal;", "getCard", "()Lcom/iqoption/microservice/withdraw/response/PayoutCard;", "getCreatedAt", "()Ljava/util/Date;", "getCssName", "()Ljava/lang/String;", "getCurrency", "getId", "()J", "getMessage", "getOperationId", "getPaymentMethod", "getStatus", "()Lcom/iqoption/microservice/withdraw/response/Status;", "getUpdatedAt", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "IqOption-5.5.1_optionXRelease"})
/* compiled from: WithdrawPayout.kt */
public final class l implements Parcelable {
    public static final Creator CREATOR = new a();
    @SerializedName("amount")
    private final BigDecimal aWn;
    @SerializedName("css_name")
    private final String cTB;
    @SerializedName("operation_id")
    private final long cTE;
    @SerializedName("status")
    private final Status cTF;
    @SerializedName("created_at")
    @JsonAdapter(DateDeserializer.class)
    private final Date cTG;
    @SerializedName("updated_at")
    @JsonAdapter(DateDeserializer.class)
    private final Date cTH;
    @SerializedName("card")
    private final e cTI;
    @SerializedName("currency")
    private final String currency;
    @SerializedName("id")
    private final long id;
    @SerializedName("message")
    private final String message;
    @SerializedName("payment_method")
    private final String paymentMethod;

    @i(aXC = {1, 1, 11})
    public static class a implements Creator {
        public final Object createFromParcel(Parcel parcel) {
            Parcel parcel2 = parcel;
            h.e(parcel2, "in");
            return new l(parcel.readLong(), parcel.readLong(), (Status) Enum.valueOf(Status.class, parcel.readString()), (BigDecimal) parcel.readSerializable(), parcel.readString(), (Date) parcel.readSerializable(), (Date) parcel.readSerializable(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (e) e.CREATOR.createFromParcel(parcel2) : null);
        }

        public final Object[] newArray(int i) {
            return new l[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof l) {
            l lVar = (l) obj;
            if ((this.id == lVar.id ? 1 : null) != null) {
                return ((this.cTE > lVar.cTE ? 1 : (this.cTE == lVar.cTE ? 0 : -1)) == 0 ? 1 : null) != null && h.E(this.cTF, lVar.cTF) && h.E(this.aWn, lVar.aWn) && h.E(this.currency, lVar.currency) && h.E(this.cTG, lVar.cTG) && h.E(this.cTH, lVar.cTH) && h.E(this.paymentMethod, lVar.paymentMethod) && h.E(this.cTB, lVar.cTB) && h.E(this.message, lVar.message) && h.E(this.cTI, lVar.cTI);
            }
        }
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        long j2 = this.cTE;
        i = (i + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        Status status = this.cTF;
        int i2 = 0;
        i = (i + (status != null ? status.hashCode() : 0)) * 31;
        BigDecimal bigDecimal = this.aWn;
        i = (i + (bigDecimal != null ? bigDecimal.hashCode() : 0)) * 31;
        String str = this.currency;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        Date date = this.cTG;
        i = (i + (date != null ? date.hashCode() : 0)) * 31;
        date = this.cTH;
        i = (i + (date != null ? date.hashCode() : 0)) * 31;
        str = this.paymentMethod;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.cTB;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.message;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        e eVar = this.cTI;
        if (eVar != null) {
            i2 = eVar.hashCode();
        }
        return i + i2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("WithdrawPayout(id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", operationId=");
        stringBuilder.append(this.cTE);
        stringBuilder.append(", status=");
        stringBuilder.append(this.cTF);
        stringBuilder.append(", amount=");
        stringBuilder.append(this.aWn);
        stringBuilder.append(", currency=");
        stringBuilder.append(this.currency);
        stringBuilder.append(", createdAt=");
        stringBuilder.append(this.cTG);
        stringBuilder.append(", updatedAt=");
        stringBuilder.append(this.cTH);
        stringBuilder.append(", paymentMethod=");
        stringBuilder.append(this.paymentMethod);
        stringBuilder.append(", cssName=");
        stringBuilder.append(this.cTB);
        stringBuilder.append(", message=");
        stringBuilder.append(this.message);
        stringBuilder.append(", card=");
        stringBuilder.append(this.cTI);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        h.e(parcel, "parcel");
        parcel.writeLong(this.id);
        parcel.writeLong(this.cTE);
        parcel.writeString(this.cTF.name());
        parcel.writeSerializable(this.aWn);
        parcel.writeString(this.currency);
        parcel.writeSerializable(this.cTG);
        parcel.writeSerializable(this.cTH);
        parcel.writeString(this.paymentMethod);
        parcel.writeString(this.cTB);
        parcel.writeString(this.message);
        Parcelable parcelable = this.cTI;
        if (parcelable != null) {
            parcel.writeInt(1);
            parcelable.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }

    public l(long j, long j2, Status status, BigDecimal bigDecimal, String str, Date date, Date date2, String str2, String str3, String str4, e eVar) {
        h.e(status, NotificationCompat.CATEGORY_STATUS);
        h.e(bigDecimal, "amount");
        h.e(str, b.CURRENCY);
        h.e(date, "createdAt");
        h.e(date2, "updatedAt");
        h.e(str2, "paymentMethod");
        h.e(str3, "cssName");
        this.id = j;
        this.cTE = j2;
        this.cTF = status;
        this.aWn = bigDecimal;
        this.currency = str;
        this.cTG = date;
        this.cTH = date2;
        this.paymentMethod = str2;
        this.cTB = str3;
        this.message = str4;
        this.cTI = eVar;
    }

    public final long getId() {
        return this.id;
    }

    public final Status atK() {
        return this.cTF;
    }

    public final BigDecimal VZ() {
        return this.aWn;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final Date atL() {
        return this.cTG;
    }

    public final String atM() {
        return this.paymentMethod;
    }

    public final String getMessage() {
        return this.message;
    }

    public final e atN() {
        return this.cTI;
    }
}
