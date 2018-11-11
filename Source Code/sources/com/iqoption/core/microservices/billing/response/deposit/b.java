package com.iqoption.core.microservices.billing.response.deposit;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u001e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u001c\b\u0002\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0003\u0018\u00010\u000b\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000f0\u000b\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0002\u0010\u0015J\u0011\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\u0011\u0010)\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\bHÆ\u0003J\u001d\u0010+\u001a\u0016\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0003\u0018\u00010\u000bHÆ\u0003J\u0015\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000f0\u000bHÆ\u0003J\u0011\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0013HÆ\u0003J\t\u0010/\u001a\u00020\u0013HÆ\u0003J£\u0001\u00100\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\u001c\b\u0002\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0003\u0018\u00010\u000b2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000f0\u000b2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0013HÆ\u0001J\t\u00101\u001a\u000202HÖ\u0001J\u0013\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u000106HÖ\u0003J\t\u00107\u001a\u000202HÖ\u0001J\t\u00108\u001a\u00020\fHÖ\u0001J\u0019\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u000202HÖ\u0001R \u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R&\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000f0\u000b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR*\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0003\u0018\u00010\u000b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0016\u0010\u0012\u001a\u00020\u00138\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001bR\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001bR\u0016\u0010\u0014\u001a\u00020\u00138\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\"R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001b¨\u0006>"}, aXE = {"Lcom/iqoption/core/microservices/billing/response/deposit/CashboxCounting;", "Landroid/os/Parcelable;", "userCards", "Ljava/util/ArrayList;", "Lcom/iqoption/core/microservices/billing/response/deposit/UserCard;", "paymentMethods", "Lcom/iqoption/core/microservices/billing/response/deposit/PaymentMethod;", "currencies", "Lcom/iqoption/core/microservices/billing/response/deposit/CurrencyBilling;", "activeCurrency", "deposits", "Ljava/util/HashMap;", "", "Lcom/iqoption/core/microservices/billing/response/deposit/Deposit;", "defaultBonuses", "Lcom/iqoption/core/microservices/billing/response/deposit/Bonus;", "lastPayments", "Lcom/iqoption/core/microservices/billing/response/deposit/Payment;", "kycLimit", "", "successSum", "(Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Lcom/iqoption/core/microservices/billing/response/deposit/CurrencyBilling;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/ArrayList;DD)V", "getActiveCurrency", "()Lcom/iqoption/core/microservices/billing/response/deposit/CurrencyBilling;", "setActiveCurrency", "(Lcom/iqoption/core/microservices/billing/response/deposit/CurrencyBilling;)V", "getCurrencies", "()Ljava/util/ArrayList;", "setCurrencies", "(Ljava/util/ArrayList;)V", "getDefaultBonuses", "()Ljava/util/HashMap;", "getDeposits", "getKycLimit", "()D", "getLastPayments", "getPaymentMethods", "getSuccessSum", "getUserCards", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "core_release"})
/* compiled from: CashboxCounting.kt */
public final class b implements Parcelable {
    public static final Creator CREATOR = new a();
    @SerializedName("currencies")
    private ArrayList<c> aPF;
    @SerializedName("payment_methods")
    private final ArrayList<g> aTr;
    @SerializedName("active_currency")
    private c aTs;
    @SerializedName("deposits")
    private final HashMap<String, ArrayList<d>> aTt;
    @SerializedName("default_bonuses")
    private final HashMap<String, a> aTu;
    @SerializedName("last_payments")
    private final ArrayList<f> aTv;
    @SerializedName("kyc_limit")
    private final double aTw;
    @SerializedName("success_sum")
    private final double aTx;
    @SerializedName("user_cards")
    private final ArrayList<h> userCards;

    @i(aXC = {1, 1, 11})
    public static class a implements Creator {
        public final Object createFromParcel(Parcel parcel) {
            int readInt;
            ArrayList arrayList;
            ArrayList arrayList2;
            Map hashMap;
            h.e(parcel, "in");
            ArrayList arrayList3 = null;
            if (parcel.readInt() != 0) {
                readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add((h) h.CREATOR.createFromParcel(parcel));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            readInt = parcel.readInt();
            ArrayList arrayList4 = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList4.add((g) g.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            if (parcel.readInt() != 0) {
                readInt = parcel.readInt();
                arrayList2 = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList2.add((c) c.CREATOR.createFromParcel(parcel));
                    readInt--;
                }
            } else {
                arrayList2 = null;
            }
            c cVar = parcel.readInt() != 0 ? (c) c.CREATOR.createFromParcel(parcel) : null;
            if (parcel.readInt() != 0) {
                readInt = parcel.readInt();
                hashMap = new HashMap(readInt);
                while (readInt != 0) {
                    String readString = parcel.readString();
                    int readInt2 = parcel.readInt();
                    ArrayList arrayList5 = new ArrayList(readInt2);
                    while (readInt2 != 0) {
                        arrayList5.add((d) d.CREATOR.createFromParcel(parcel));
                        readInt2--;
                    }
                    hashMap.put(readString, arrayList5);
                    readInt--;
                }
            } else {
                hashMap = null;
            }
            readInt = parcel.readInt();
            Map hashMap2 = new HashMap(readInt);
            while (readInt != 0) {
                hashMap2.put(parcel.readString(), (a) a.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            if (parcel.readInt() != 0) {
                readInt = parcel.readInt();
                arrayList3 = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList3.add((f) f.CREATOR.createFromParcel(parcel));
                    readInt--;
                }
            }
            return new b(arrayList, arrayList4, arrayList2, cVar, hashMap, hashMap2, arrayList3, parcel.readDouble(), parcel.readDouble());
        }

        public final Object[] newArray(int i) {
            return new b[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    /* JADX WARNING: Missing block: B:20:0x0060, code:
            if (java.lang.Double.compare(r4.aTx, r5.aTx) == 0) goto L_0x0065;
     */
    public boolean equals(java.lang.Object r5) {
        /*
        r4 = this;
        if (r4 == r5) goto L_0x0065;
    L_0x0002:
        r0 = r5 instanceof com.iqoption.core.microservices.billing.response.deposit.b;
        if (r0 == 0) goto L_0x0063;
    L_0x0006:
        r5 = (com.iqoption.core.microservices.billing.response.deposit.b) r5;
        r0 = r4.userCards;
        r1 = r5.userCards;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x0063;
    L_0x0012:
        r0 = r4.aTr;
        r1 = r5.aTr;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x0063;
    L_0x001c:
        r0 = r4.aPF;
        r1 = r5.aPF;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x0063;
    L_0x0026:
        r0 = r4.aTs;
        r1 = r5.aTs;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x0063;
    L_0x0030:
        r0 = r4.aTt;
        r1 = r5.aTt;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x0063;
    L_0x003a:
        r0 = r4.aTu;
        r1 = r5.aTu;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x0063;
    L_0x0044:
        r0 = r4.aTv;
        r1 = r5.aTv;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x0063;
    L_0x004e:
        r0 = r4.aTw;
        r2 = r5.aTw;
        r0 = java.lang.Double.compare(r0, r2);
        if (r0 != 0) goto L_0x0063;
    L_0x0058:
        r0 = r4.aTx;
        r2 = r5.aTx;
        r5 = java.lang.Double.compare(r0, r2);
        if (r5 != 0) goto L_0x0063;
    L_0x0062:
        goto L_0x0065;
    L_0x0063:
        r5 = 0;
        return r5;
    L_0x0065:
        r5 = 1;
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.core.microservices.billing.response.deposit.b.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        ArrayList arrayList = this.userCards;
        int i = 0;
        int hashCode = (arrayList != null ? arrayList.hashCode() : 0) * 31;
        ArrayList arrayList2 = this.aTr;
        hashCode = (hashCode + (arrayList2 != null ? arrayList2.hashCode() : 0)) * 31;
        arrayList2 = this.aPF;
        hashCode = (hashCode + (arrayList2 != null ? arrayList2.hashCode() : 0)) * 31;
        c cVar = this.aTs;
        hashCode = (hashCode + (cVar != null ? cVar.hashCode() : 0)) * 31;
        HashMap hashMap = this.aTt;
        hashCode = (hashCode + (hashMap != null ? hashMap.hashCode() : 0)) * 31;
        hashMap = this.aTu;
        hashCode = (hashCode + (hashMap != null ? hashMap.hashCode() : 0)) * 31;
        arrayList2 = this.aTv;
        if (arrayList2 != null) {
            i = arrayList2.hashCode();
        }
        hashCode = (hashCode + i) * 31;
        long doubleToLongBits = Double.doubleToLongBits(this.aTw);
        hashCode = (hashCode + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31;
        doubleToLongBits = Double.doubleToLongBits(this.aTx);
        return hashCode + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CashboxCounting(userCards=");
        stringBuilder.append(this.userCards);
        stringBuilder.append(", paymentMethods=");
        stringBuilder.append(this.aTr);
        stringBuilder.append(", currencies=");
        stringBuilder.append(this.aPF);
        stringBuilder.append(", activeCurrency=");
        stringBuilder.append(this.aTs);
        stringBuilder.append(", deposits=");
        stringBuilder.append(this.aTt);
        stringBuilder.append(", defaultBonuses=");
        stringBuilder.append(this.aTu);
        stringBuilder.append(", lastPayments=");
        stringBuilder.append(this.aTv);
        stringBuilder.append(", kycLimit=");
        stringBuilder.append(this.aTw);
        stringBuilder.append(", successSum=");
        stringBuilder.append(this.aTx);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        h.e(parcel, "parcel");
        Collection<h> collection = this.userCards;
        if (collection != null) {
            parcel.writeInt(1);
            parcel.writeInt(collection.size());
            for (h writeToParcel : collection) {
                writeToParcel.writeToParcel(parcel, 0);
            }
        } else {
            parcel.writeInt(0);
        }
        Collection<g> collection2 = this.aTr;
        parcel.writeInt(collection2.size());
        for (g writeToParcel2 : collection2) {
            writeToParcel2.writeToParcel(parcel, 0);
        }
        Collection<c> collection3 = this.aPF;
        if (collection3 != null) {
            parcel.writeInt(1);
            parcel.writeInt(collection3.size());
            for (c writeToParcel3 : collection3) {
                writeToParcel3.writeToParcel(parcel, 0);
            }
        } else {
            parcel.writeInt(0);
        }
        Parcelable parcelable = this.aTs;
        if (parcelable != null) {
            parcel.writeInt(1);
            parcelable.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        Map map = this.aTt;
        if (map != null) {
            parcel.writeInt(1);
            parcel.writeInt(map.size());
            for (Entry next : map.entrySet()) {
                parcel.writeString((String) next.getKey());
                ArrayList<d> arrayList = (ArrayList) next.getValue();
                parcel.writeInt(arrayList.size());
                for (d writeToParcel4 : arrayList) {
                    writeToParcel4.writeToParcel(parcel, 0);
                }
            }
        } else {
            parcel.writeInt(0);
        }
        map = this.aTu;
        parcel.writeInt(map.size());
        for (Entry next2 : map.entrySet()) {
            parcel.writeString((String) next2.getKey());
            ((a) next2.getValue()).writeToParcel(parcel, 0);
        }
        Collection<f> collection4 = this.aTv;
        if (collection4 != null) {
            parcel.writeInt(1);
            parcel.writeInt(collection4.size());
            for (f writeToParcel5 : collection4) {
                writeToParcel5.writeToParcel(parcel, 0);
            }
        } else {
            parcel.writeInt(0);
        }
        parcel.writeDouble(this.aTw);
        parcel.writeDouble(this.aTx);
    }

    public b(ArrayList<h> arrayList, ArrayList<g> arrayList2, ArrayList<c> arrayList3, c cVar, HashMap<String, ArrayList<d>> hashMap, HashMap<String, a> hashMap2, ArrayList<f> arrayList4, double d, double d2) {
        h.e(arrayList2, "paymentMethods");
        h.e(hashMap2, "defaultBonuses");
        this.userCards = arrayList;
        this.aTr = arrayList2;
        this.aPF = arrayList3;
        this.aTs = cVar;
        this.aTt = hashMap;
        this.aTu = hashMap2;
        this.aTv = arrayList4;
        this.aTw = d;
        this.aTx = d2;
    }

    public final ArrayList<h> UG() {
        return this.userCards;
    }

    public final ArrayList<g> UH() {
        return this.aTr;
    }

    public final ArrayList<c> Td() {
        return this.aPF;
    }

    public final void g(ArrayList<c> arrayList) {
        this.aPF = arrayList;
    }

    public final c UI() {
        return this.aTs;
    }

    public final HashMap<String, ArrayList<d>> UJ() {
        return this.aTt;
    }

    public final double UK() {
        return this.aTw;
    }

    public final double UL() {
        return this.aTx;
    }
}
