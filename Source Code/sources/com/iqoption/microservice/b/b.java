package com.iqoption.microservice.b;

import android.support.v4.app.NotificationCompat;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.gson.annotations.SerializedName;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\"\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002Be\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u0004¢\u0006\u0002\u0010\u0013J\t\u0010$\u001a\u00020\u0004HÆ\u0003J\t\u0010%\u001a\u00020\u000fHÆ\u0003J\t\u0010&\u001a\u00020\tHÆ\u0003J\t\u0010'\u001a\u00020\u0004HÆ\u0003J\t\u0010(\u001a\u00020\u0006HÆ\u0003J\t\u0010)\u001a\u00020\u0006HÆ\u0003J\t\u0010*\u001a\u00020\tHÆ\u0003J\t\u0010+\u001a\u00020\tHÆ\u0003J\t\u0010,\u001a\u00020\u0006HÆ\u0003J\t\u0010-\u001a\u00020\tHÆ\u0003J\t\u0010.\u001a\u00020\u0006HÆ\u0003J\t\u0010/\u001a\u00020\u000fHÆ\u0003J\u0001\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\u0004HÆ\u0001J\u0013\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u00020\u000fHÖ\u0001J\t\u00105\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0011\u001a\u00020\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0016\u0010\n\u001a\u00020\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0016\u0010\f\u001a\u00020\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0016\u0010\r\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u0012\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u000b\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR\u0016\u0010\u0010\u001a\u00020\u000f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0016\u0010\u000e\u001a\u00020\u000f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001aR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001a¨\u00066"}, aXE = {"Lcom/iqoption/microservice/operation/Transaction;", "", "()V", "id", "", "type", "", "status", "amount", "", "commissionAmount", "currency", "convertedAmount", "convertedCurrency", "platformId", "", "paymentMethodId", "balanceAfter", "created", "(JLjava/lang/String;Ljava/lang/String;FFLjava/lang/String;FLjava/lang/String;IIFJ)V", "getAmount", "()F", "getBalanceAfter", "getCommissionAmount", "getConvertedAmount", "getConvertedCurrency", "()Ljava/lang/String;", "getCreated", "()J", "getCurrency", "getId", "getPaymentMethodId", "()I", "getPlatformId", "getStatus", "getType", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "IqOption-5.5.1_optionXRelease"})
/* compiled from: OperationResponse.kt */
public final class b {
    @SerializedName("platform_id")
    private final int aXo;
    @SerializedName("amount")
    private final float cRP;
    @SerializedName("commission_amount")
    private final float cRQ;
    @SerializedName("converted_amount")
    private final float cRR;
    @SerializedName("converted_currency")
    private final String cRS;
    @SerializedName("payment_method_id")
    private final int cRT;
    @SerializedName("balance_after")
    private final float cRU;
    @SerializedName("created")
    private final long created;
    @SerializedName("currency")
    private final String currency;
    @SerializedName("id")
    private final long id;
    @SerializedName("status")
    private final String status;
    @SerializedName("type")
    private final String type;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if ((this.id == bVar.id ? 1 : null) != null && h.E(this.type, bVar.type) && h.E(this.status, bVar.status) && Float.compare(this.cRP, bVar.cRP) == 0 && Float.compare(this.cRQ, bVar.cRQ) == 0 && h.E(this.currency, bVar.currency) && Float.compare(this.cRR, bVar.cRR) == 0 && h.E(this.cRS, bVar.cRS)) {
                if ((this.aXo == bVar.aXo ? 1 : null) != null) {
                    if ((this.cRT == bVar.cRT ? 1 : null) != null && Float.compare(this.cRU, bVar.cRU) == 0) {
                        if ((this.created == bVar.created ? 1 : null) != null) {
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
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.type;
        int i2 = 0;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.status;
        i = (((((i + (str != null ? str.hashCode() : 0)) * 31) + Float.floatToIntBits(this.cRP)) * 31) + Float.floatToIntBits(this.cRQ)) * 31;
        str = this.currency;
        i = (((i + (str != null ? str.hashCode() : 0)) * 31) + Float.floatToIntBits(this.cRR)) * 31;
        str = this.cRS;
        if (str != null) {
            i2 = str.hashCode();
        }
        i = (((((((i + i2) * 31) + this.aXo) * 31) + this.cRT) * 31) + Float.floatToIntBits(this.cRU)) * 31;
        long j2 = this.created;
        return i + ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Transaction(id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", type=");
        stringBuilder.append(this.type);
        stringBuilder.append(", status=");
        stringBuilder.append(this.status);
        stringBuilder.append(", amount=");
        stringBuilder.append(this.cRP);
        stringBuilder.append(", commissionAmount=");
        stringBuilder.append(this.cRQ);
        stringBuilder.append(", currency=");
        stringBuilder.append(this.currency);
        stringBuilder.append(", convertedAmount=");
        stringBuilder.append(this.cRR);
        stringBuilder.append(", convertedCurrency=");
        stringBuilder.append(this.cRS);
        stringBuilder.append(", platformId=");
        stringBuilder.append(this.aXo);
        stringBuilder.append(", paymentMethodId=");
        stringBuilder.append(this.cRT);
        stringBuilder.append(", balanceAfter=");
        stringBuilder.append(this.cRU);
        stringBuilder.append(", created=");
        stringBuilder.append(this.created);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public b(long j, String str, String str2, float f, float f2, String str3, float f3, String str4, int i, int i2, float f4, long j2) {
        h.e(str, Param.TYPE);
        h.e(str2, NotificationCompat.CATEGORY_STATUS);
        h.e(str3, com.google.firebase.analytics.FirebaseAnalytics.b.CURRENCY);
        h.e(str4, "convertedCurrency");
        this.id = j;
        this.type = str;
        this.status = str2;
        this.cRP = f;
        this.cRQ = f2;
        this.currency = str3;
        this.cRR = f3;
        this.cRS = str4;
        this.aXo = i;
        this.cRT = i2;
        this.cRU = f4;
        this.created = j2;
    }

    public final long getId() {
        return this.id;
    }

    public final String getType() {
        return this.type;
    }

    public final String getStatus() {
        return this.status;
    }

    public final float asE() {
        return this.cRP;
    }

    public final long Vs() {
        return this.created;
    }

    public b() {
        this(0, "", "", 0.0f, 0.0f, "", 0.0f, "", 0, 0, 0.0f, 0);
    }
}
