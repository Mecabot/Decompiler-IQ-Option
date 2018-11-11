package com.iqoption.withdrawal.common.fields;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.iqoption.dto.Balance;
import com.iqoption.dto.Currencies.ConversionCurrency;
import com.iqoption.microservice.withdraw.response.WithdrawMethodType;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\u0019\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006&"}, aXE = {"Lcom/iqoption/withdrawal/common/fields/WithdrawFieldsData;", "Landroid/os/Parcelable;", "method", "Lcom/iqoption/microservice/withdraw/response/BaseWithdrawMethod;", "balance", "Lcom/iqoption/dto/Balance;", "conversion", "Lcom/iqoption/dto/Currencies$ConversionCurrency;", "availableType", "Lcom/iqoption/microservice/withdraw/response/WithdrawMethodType;", "(Lcom/iqoption/microservice/withdraw/response/BaseWithdrawMethod;Lcom/iqoption/dto/Balance;Lcom/iqoption/dto/Currencies$ConversionCurrency;Lcom/iqoption/microservice/withdraw/response/WithdrawMethodType;)V", "getAvailableType", "()Lcom/iqoption/microservice/withdraw/response/WithdrawMethodType;", "getBalance", "()Lcom/iqoption/dto/Balance;", "getConversion", "()Lcom/iqoption/dto/Currencies$ConversionCurrency;", "getMethod", "()Lcom/iqoption/microservice/withdraw/response/BaseWithdrawMethod;", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "IqOption-5.5.1_optionXRelease"})
/* compiled from: WithdrawFieldsViewModel.kt */
public final class c implements Parcelable {
    public static final Creator CREATOR = new a();
    private final com.iqoption.microservice.withdraw.response.a dQe;
    private final Balance dQf;
    private final ConversionCurrency dQg;
    private final WithdrawMethodType dQh;

    @i(aXC = {1, 1, 11})
    public static class a implements Creator {
        public final Object createFromParcel(Parcel parcel) {
            h.e(parcel, "in");
            return new c((com.iqoption.microservice.withdraw.response.a) parcel.readParcelable(c.class.getClassLoader()), (Balance) Balance.CREATOR.createFromParcel(parcel), (ConversionCurrency) parcel.readParcelable(c.class.getClassLoader()), (WithdrawMethodType) Enum.valueOf(WithdrawMethodType.class, parcel.readString()));
        }

        public final Object[] newArray(int i) {
            return new c[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    /* JADX WARNING: Missing block: B:10:0x002e, code:
            if (kotlin.jvm.internal.h.E(r2.dQh, r3.dQh) != false) goto L_0x0033;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x0033;
    L_0x0002:
        r0 = r3 instanceof com.iqoption.withdrawal.common.fields.c;
        if (r0 == 0) goto L_0x0031;
    L_0x0006:
        r3 = (com.iqoption.withdrawal.common.fields.c) r3;
        r0 = r2.dQe;
        r1 = r3.dQe;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x0031;
    L_0x0012:
        r0 = r2.dQf;
        r1 = r3.dQf;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x0031;
    L_0x001c:
        r0 = r2.dQg;
        r1 = r3.dQg;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x0031;
    L_0x0026:
        r0 = r2.dQh;
        r3 = r3.dQh;
        r3 = kotlin.jvm.internal.h.E(r0, r3);
        if (r3 == 0) goto L_0x0031;
    L_0x0030:
        goto L_0x0033;
    L_0x0031:
        r3 = 0;
        return r3;
    L_0x0033:
        r3 = 1;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.withdrawal.common.fields.c.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        com.iqoption.microservice.withdraw.response.a aVar = this.dQe;
        int i = 0;
        int hashCode = (aVar != null ? aVar.hashCode() : 0) * 31;
        Balance balance = this.dQf;
        hashCode = (hashCode + (balance != null ? balance.hashCode() : 0)) * 31;
        ConversionCurrency conversionCurrency = this.dQg;
        hashCode = (hashCode + (conversionCurrency != null ? conversionCurrency.hashCode() : 0)) * 31;
        WithdrawMethodType withdrawMethodType = this.dQh;
        if (withdrawMethodType != null) {
            i = withdrawMethodType.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("WithdrawFieldsData(method=");
        stringBuilder.append(this.dQe);
        stringBuilder.append(", balance=");
        stringBuilder.append(this.dQf);
        stringBuilder.append(", conversion=");
        stringBuilder.append(this.dQg);
        stringBuilder.append(", availableType=");
        stringBuilder.append(this.dQh);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        h.e(parcel, "parcel");
        parcel.writeParcelable(this.dQe, i);
        this.dQf.writeToParcel(parcel, 0);
        parcel.writeParcelable(this.dQg, i);
        parcel.writeString(this.dQh.name());
    }

    public c(com.iqoption.microservice.withdraw.response.a aVar, Balance balance, ConversionCurrency conversionCurrency, WithdrawMethodType withdrawMethodType) {
        h.e(aVar, b.METHOD);
        h.e(balance, "balance");
        h.e(conversionCurrency, "conversion");
        h.e(withdrawMethodType, "availableType");
        this.dQe = aVar;
        this.dQf = balance;
        this.dQg = conversionCurrency;
        this.dQh = withdrawMethodType;
    }

    public final com.iqoption.microservice.withdraw.response.a aNc() {
        return this.dQe;
    }

    public final Balance aNd() {
        return this.dQf;
    }

    public final ConversionCurrency aNe() {
        return this.dQg;
    }

    public final WithdrawMethodType aNf() {
        return this.dQh;
    }
}
