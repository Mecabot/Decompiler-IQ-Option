package com.iqoption.microservice.withdraw.response;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import io.card.payment.CardType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0007\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\u000f\u0010)\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\t\u0010*\u001a\u00020\nHÆ\u0003J\t\u0010+\u001a\u00020\u0005HÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001dJ\t\u0010-\u001a\u00020\u000eHÆ\u0003J\u0011\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0007HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0012HÆ\u0003Jz\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÆ\u0001¢\u0006\u0002\u00101J\t\u00102\u001a\u000203HÖ\u0001J\u0013\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u000107HÖ\u0003J\t\u00108\u001a\u000203HÖ\u0001J\b\u00109\u001a\u00020\u0003H\u0016J\t\u0010:\u001a\u00020\u0003HÖ\u0001J\b\u0010;\u001a\u00020<H\u0016J\u0019\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u000203HÖ\u0001R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0015\u0010\f\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001bR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0019¨\u0006B"}, aXE = {"Lcom/iqoption/microservice/withdraw/response/CardWithdrawMethod;", "Lcom/iqoption/microservice/withdraw/response/BaseWithdrawMethod;", "name", "", "commission", "", "fields", "", "Lcom/iqoption/microservice/withdraw/response/PayoutField;", "cardId", "", "refundAmount", "iqOptionPaymentMethodId", "cardType", "Lio/card/payment/CardType;", "limits", "Lcom/iqoption/microservice/withdraw/response/WithdrawLimit;", "maxLimit", "Lcom/iqoption/withdrawal/common/AmountLimit;", "(Ljava/lang/String;DLjava/util/List;JDLjava/lang/Long;Lio/card/payment/CardType;Ljava/util/List;Lcom/iqoption/withdrawal/common/AmountLimit;)V", "getCardId", "()J", "getCardType", "()Lio/card/payment/CardType;", "getCommission", "()D", "getFields", "()Ljava/util/List;", "getIqOptionPaymentMethodId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getLimits", "getMaxLimit", "()Lcom/iqoption/withdrawal/common/AmountLimit;", "setMaxLimit", "(Lcom/iqoption/withdrawal/common/AmountLimit;)V", "getName", "()Ljava/lang/String;", "getRefundAmount", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;DLjava/util/List;JDLjava/lang/Long;Lio/card/payment/CardType;Ljava/util/List;Lcom/iqoption/withdrawal/common/AmountLimit;)Lcom/iqoption/microservice/withdraw/response/CardWithdrawMethod;", "describeContents", "", "equals", "", "other", "", "hashCode", "methodId", "toString", "type", "Lcom/iqoption/microservice/withdraw/response/WithdrawMethodType;", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "IqOption-5.5.1_optionXRelease"})
/* compiled from: WithdrawMethod.kt */
public final class c implements a {
    public static final Creator CREATOR = new a();
    private final long aTU;
    private final CardType bVS;
    private final double cTp;
    private final Long cTq;
    private final double cTr;
    private final List<g> cTs;
    private com.iqoption.withdrawal.common.a cTt;
    private final List<f> fields;
    private final String name;

    @i(aXC = {1, 1, 11})
    public static class a implements Creator {
        public final Object createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Parcel parcel2 = parcel;
            h.e(parcel2, "in");
            String readString = parcel.readString();
            double readDouble = parcel.readDouble();
            int readInt = parcel.readInt();
            List arrayList2 = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList2.add((f) f.CREATOR.createFromParcel(parcel2));
                readInt--;
            }
            long readLong = parcel.readLong();
            double readDouble2 = parcel.readDouble();
            Long valueOf = parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null;
            CardType cardType = (CardType) Enum.valueOf(CardType.class, parcel.readString());
            if (parcel.readInt() != 0) {
                readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add((g) g.CREATOR.createFromParcel(parcel2));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            return new c(readString, readDouble, arrayList2, readLong, readDouble2, valueOf, cardType, arrayList, parcel.readInt() != 0 ? (com.iqoption.withdrawal.common.a) com.iqoption.withdrawal.common.a.CREATOR.createFromParcel(parcel2) : null);
        }

        public final Object[] newArray(int i) {
            return new c[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (h.E(getName(), cVar.getName()) && Double.compare(atv(), cVar.atv()) == 0 && h.E(atw(), cVar.atw())) {
                return ((this.aTU > cVar.aTU ? 1 : (this.aTU == cVar.aTU ? 0 : -1)) == 0 ? 1 : null) != null && Double.compare(this.cTp, cVar.cTp) == 0 && h.E(this.cTq, cVar.cTq) && h.E(this.bVS, cVar.bVS) && h.E(atx(), cVar.atx()) && h.E(aty(), cVar.aty());
            }
        }
    }

    public int hashCode() {
        String name = getName();
        int i = 0;
        int hashCode = (name != null ? name.hashCode() : 0) * 31;
        long doubleToLongBits = Double.doubleToLongBits(atv());
        hashCode = (hashCode + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31;
        List atw = atw();
        hashCode = (hashCode + (atw != null ? atw.hashCode() : 0)) * 31;
        doubleToLongBits = this.aTU;
        hashCode = (hashCode + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31;
        doubleToLongBits = Double.doubleToLongBits(this.cTp);
        hashCode = (hashCode + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31;
        Long l = this.cTq;
        hashCode = (hashCode + (l != null ? l.hashCode() : 0)) * 31;
        CardType cardType = this.bVS;
        hashCode = (hashCode + (cardType != null ? cardType.hashCode() : 0)) * 31;
        atw = atx();
        hashCode = (hashCode + (atw != null ? atw.hashCode() : 0)) * 31;
        com.iqoption.withdrawal.common.a aty = aty();
        if (aty != null) {
            i = aty.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CardWithdrawMethod(name=");
        stringBuilder.append(getName());
        stringBuilder.append(", commission=");
        stringBuilder.append(atv());
        stringBuilder.append(", fields=");
        stringBuilder.append(atw());
        stringBuilder.append(", cardId=");
        stringBuilder.append(this.aTU);
        stringBuilder.append(", refundAmount=");
        stringBuilder.append(this.cTp);
        stringBuilder.append(", iqOptionPaymentMethodId=");
        stringBuilder.append(this.cTq);
        stringBuilder.append(", cardType=");
        stringBuilder.append(this.bVS);
        stringBuilder.append(", limits=");
        stringBuilder.append(atx());
        stringBuilder.append(", maxLimit=");
        stringBuilder.append(aty());
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        h.e(parcel, "parcel");
        parcel.writeString(this.name);
        parcel.writeDouble(this.cTr);
        Collection<f> collection = this.fields;
        parcel.writeInt(collection.size());
        for (f writeToParcel : collection) {
            writeToParcel.writeToParcel(parcel, 0);
        }
        parcel.writeLong(this.aTU);
        parcel.writeDouble(this.cTp);
        Long l = this.cTq;
        if (l != null) {
            parcel.writeInt(1);
            parcel.writeLong(l.longValue());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.bVS.name());
        Collection<g> collection2 = this.cTs;
        if (collection2 != null) {
            parcel.writeInt(1);
            parcel.writeInt(collection2.size());
            for (g writeToParcel2 : collection2) {
                writeToParcel2.writeToParcel(parcel, 0);
            }
        } else {
            parcel.writeInt(0);
        }
        Parcelable parcelable = this.cTt;
        if (parcelable != null) {
            parcel.writeInt(1);
            parcelable.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }

    public c(String str, double d, List<f> list, long j, double d2, Long l, CardType cardType, List<g> list2, com.iqoption.withdrawal.common.a aVar) {
        h.e(str, "name");
        h.e(list, "fields");
        h.e(cardType, "cardType");
        this.name = str;
        this.cTr = d;
        this.fields = list;
        this.aTU = j;
        this.cTp = d2;
        this.cTq = l;
        this.bVS = cardType;
        this.cTs = list2;
        this.cTt = aVar;
    }

    public String getName() {
        return this.name;
    }

    public double atv() {
        return this.cTr;
    }

    public List<f> atw() {
        return this.fields;
    }

    public final long Vf() {
        return this.aTU;
    }

    public final double atz() {
        return this.cTp;
    }

    public final Long atA() {
        return this.cTq;
    }

    public final CardType getCardType() {
        return this.bVS;
    }

    public List<g> atx() {
        return this.cTs;
    }

    public com.iqoption.withdrawal.common.a aty() {
        return this.cTt;
    }

    public WithdrawMethodType att() {
        return WithdrawMethodType.CARD;
    }

    public String atu() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getName());
        stringBuilder.append('-');
        stringBuilder.append(this.aTU);
        return stringBuilder.toString();
    }
}
