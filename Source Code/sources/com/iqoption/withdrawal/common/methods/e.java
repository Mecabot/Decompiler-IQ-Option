package com.iqoption.withdrawal.common.methods;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.iqoption.dto.Balance;
import com.iqoption.dto.Currencies.ConversionCurrency;
import com.iqoption.microservice.withdraw.response.WithdrawMethodType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BG\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\bHÆ\u0003J\t\u0010 \u001a\u00020\nHÆ\u0003J\u0015\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r0\fHÆ\u0003J\t\u0010\"\u001a\u00020\u000fHÆ\u0003JW\u0010#\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r0\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000fHÆ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020%HÖ\u0001J\t\u0010+\u001a\u00020\rHÖ\u0001J\u0019\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020%HÖ\u0001R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u00061"}, aXE = {"Lcom/iqoption/withdrawal/common/methods/WithdrawMethodsData;", "Landroid/os/Parcelable;", "methods", "", "Lcom/iqoption/microservice/withdraw/response/BaseWithdrawMethod;", "balance", "Lcom/iqoption/dto/Balance;", "conversion", "Lcom/iqoption/dto/Currencies$ConversionCurrency;", "availableType", "Lcom/iqoption/microservice/withdraw/response/WithdrawMethodType;", "methodWarnings", "", "", "fullRefundAmount", "", "(Ljava/util/List;Lcom/iqoption/dto/Balance;Lcom/iqoption/dto/Currencies$ConversionCurrency;Lcom/iqoption/microservice/withdraw/response/WithdrawMethodType;Ljava/util/Map;D)V", "getAvailableType", "()Lcom/iqoption/microservice/withdraw/response/WithdrawMethodType;", "getBalance", "()Lcom/iqoption/dto/Balance;", "getConversion", "()Lcom/iqoption/dto/Currencies$ConversionCurrency;", "getFullRefundAmount", "()D", "getMethodWarnings", "()Ljava/util/Map;", "getMethods", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "IqOption-5.5.1_optionXRelease"})
/* compiled from: WithdrawMethodsViewModel.kt */
public final class e implements Parcelable {
    public static final Creator CREATOR = new a();
    private final Balance dQf;
    private final ConversionCurrency dQg;
    private final WithdrawMethodType dQh;
    private final Map<com.iqoption.microservice.withdraw.response.a, String> dRA;
    private final double dRB;
    private final List<com.iqoption.microservice.withdraw.response.a> methods;

    @i(aXC = {1, 1, 11})
    public static class a implements Creator {
        public final Object createFromParcel(Parcel parcel) {
            h.e(parcel, "in");
            int readInt = parcel.readInt();
            List arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add((com.iqoption.microservice.withdraw.response.a) parcel.readParcelable(e.class.getClassLoader()));
                readInt--;
            }
            Balance balance = (Balance) Balance.CREATOR.createFromParcel(parcel);
            ConversionCurrency conversionCurrency = (ConversionCurrency) parcel.readParcelable(e.class.getClassLoader());
            WithdrawMethodType withdrawMethodType = (WithdrawMethodType) Enum.valueOf(WithdrawMethodType.class, parcel.readString());
            readInt = parcel.readInt();
            Map linkedHashMap = new LinkedHashMap(readInt);
            while (readInt != 0) {
                linkedHashMap.put((com.iqoption.microservice.withdraw.response.a) parcel.readParcelable(e.class.getClassLoader()), parcel.readString());
                readInt--;
            }
            return new e(arrayList, balance, conversionCurrency, withdrawMethodType, linkedHashMap, parcel.readDouble());
        }

        public final Object[] newArray(int i) {
            return new e[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    /* JADX WARNING: Missing block: B:14:0x0042, code:
            if (java.lang.Double.compare(r4.dRB, r5.dRB) == 0) goto L_0x0047;
     */
    public boolean equals(java.lang.Object r5) {
        /*
        r4 = this;
        if (r4 == r5) goto L_0x0047;
    L_0x0002:
        r0 = r5 instanceof com.iqoption.withdrawal.common.methods.e;
        if (r0 == 0) goto L_0x0045;
    L_0x0006:
        r5 = (com.iqoption.withdrawal.common.methods.e) r5;
        r0 = r4.methods;
        r1 = r5.methods;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x0045;
    L_0x0012:
        r0 = r4.dQf;
        r1 = r5.dQf;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x0045;
    L_0x001c:
        r0 = r4.dQg;
        r1 = r5.dQg;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x0045;
    L_0x0026:
        r0 = r4.dQh;
        r1 = r5.dQh;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x0045;
    L_0x0030:
        r0 = r4.dRA;
        r1 = r5.dRA;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x0045;
    L_0x003a:
        r0 = r4.dRB;
        r2 = r5.dRB;
        r5 = java.lang.Double.compare(r0, r2);
        if (r5 != 0) goto L_0x0045;
    L_0x0044:
        goto L_0x0047;
    L_0x0045:
        r5 = 0;
        return r5;
    L_0x0047:
        r5 = 1;
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.withdrawal.common.methods.e.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        List list = this.methods;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        Balance balance = this.dQf;
        hashCode = (hashCode + (balance != null ? balance.hashCode() : 0)) * 31;
        ConversionCurrency conversionCurrency = this.dQg;
        hashCode = (hashCode + (conversionCurrency != null ? conversionCurrency.hashCode() : 0)) * 31;
        WithdrawMethodType withdrawMethodType = this.dQh;
        hashCode = (hashCode + (withdrawMethodType != null ? withdrawMethodType.hashCode() : 0)) * 31;
        Map map = this.dRA;
        if (map != null) {
            i = map.hashCode();
        }
        hashCode = (hashCode + i) * 31;
        long doubleToLongBits = Double.doubleToLongBits(this.dRB);
        return hashCode + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("WithdrawMethodsData(methods=");
        stringBuilder.append(this.methods);
        stringBuilder.append(", balance=");
        stringBuilder.append(this.dQf);
        stringBuilder.append(", conversion=");
        stringBuilder.append(this.dQg);
        stringBuilder.append(", availableType=");
        stringBuilder.append(this.dQh);
        stringBuilder.append(", methodWarnings=");
        stringBuilder.append(this.dRA);
        stringBuilder.append(", fullRefundAmount=");
        stringBuilder.append(this.dRB);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        h.e(parcel, "parcel");
        Collection<com.iqoption.microservice.withdraw.response.a> collection = this.methods;
        parcel.writeInt(collection.size());
        for (com.iqoption.microservice.withdraw.response.a writeParcelable : collection) {
            parcel.writeParcelable(writeParcelable, i);
        }
        this.dQf.writeToParcel(parcel, 0);
        parcel.writeParcelable(this.dQg, i);
        parcel.writeString(this.dQh.name());
        Map map = this.dRA;
        parcel.writeInt(map.size());
        for (Entry next : map.entrySet()) {
            parcel.writeParcelable((com.iqoption.microservice.withdraw.response.a) next.getKey(), i);
            parcel.writeString((String) next.getValue());
        }
        parcel.writeDouble(this.dRB);
    }

    public e(List<? extends com.iqoption.microservice.withdraw.response.a> list, Balance balance, ConversionCurrency conversionCurrency, WithdrawMethodType withdrawMethodType, Map<com.iqoption.microservice.withdraw.response.a, String> map, double d) {
        h.e(list, "methods");
        h.e(balance, "balance");
        h.e(conversionCurrency, "conversion");
        h.e(withdrawMethodType, "availableType");
        h.e(map, "methodWarnings");
        this.methods = list;
        this.dQf = balance;
        this.dQg = conversionCurrency;
        this.dQh = withdrawMethodType;
        this.dRA = map;
        this.dRB = d;
    }

    public final List<com.iqoption.microservice.withdraw.response.a> atC() {
        return this.methods;
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

    public final Map<com.iqoption.microservice.withdraw.response.a, String> aNR() {
        return this.dRA;
    }
}
